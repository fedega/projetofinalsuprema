//DbCache class @0-83967277
/*
 * $Revision$
 * $Date$
 */
package com.codecharge.util.cache;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.codecharge.db.DbRow;
import com.codecharge.db.JDBCConnection;
import com.codecharge.db.JDBCConnectionFactory;
import com.codecharge.util.CCLogger;
import com.codecharge.util.StringUtils;


public class DbCache extends CacheAdapter {

    private String connectionName;
    private String tableName;
    private String keyFieldName;
    private String dataFieldName;
    private String expiredFieldName;
    private String leftDelim;
    private String rightDelim;
    
    /*
     * ICache implemented methods
     */
    public void init() {
        if (this.leftDelim == null) { //check if instance has already initialized
            this.connectionName = StringUtils.getSiteProperty("dbcache.connectionName");
            this.tableName = StringUtils.getSiteProperty("dbcache.tableName");
            this.keyFieldName = StringUtils.getSiteProperty("dbcache.keyFieldName");
            this.dataFieldName = StringUtils.getSiteProperty("dbcache.dataFieldName");
            this.expiredFieldName = StringUtils.getSiteProperty("dbcache.expiredFieldName");
            
            boolean dbNameUppercase = new Boolean(StringUtils.getSiteProperty(
                    this.connectionName + ".dbNameUppercase", "")).booleanValue();
            String dbType = StringUtils.getSiteProperty(this.connectionName + ".dbType", "");
            if (dbNameUppercase && ("Oracle".equals(dbType) || "Interbase".equals(dbType))) {
                leftDelim = "";
                rightDelim = "";
            } else {
                leftDelim = StringUtils.getSiteProperty(this.connectionName
                        + ".fieldLeftDelim", "");
                rightDelim = StringUtils.getSiteProperty(this.connectionName
                        + ".fieldRightDelim", "");
            }
            logger.log("DbCache.init");
            logger.log("connectionName: "+connectionName);
            logger.log("tableName: "+tableName);
            logger.log("keyFieldName: "+keyFieldName);
            logger.log("dataFieldName: "+dataFieldName);
            logger.log("expiredFieldName: "+expiredFieldName);
            logger.log("leftDelim: "+leftDelim);
            logger.log("rightDelim: "+rightDelim);
        }
    }

    public void finalize() {
        //do nothing
    }
    
    /*
     * ICache implemented methods
     */
    public Object getObject(String key) {
        init();
        JDBCConnection conn = JDBCConnectionFactory.getJDBCConnection(this.connectionName);
        if (conn == null) {
            logger.debug("DbCache.get => unable to obtain connection. Cache is not used.");
            return null;
        }
        //key = handleKey(key);
        String sql = buildGetSql("LIKE "+conn.toSql(key, JDBCConnection.TEXT), conn);
        DbCache.logger.debug("DbCache.get => run sql:\n");
        DbRow data = getNonExpiredRow(sql, conn);
        conn.closeConnection();
        if (data != null) {
            return data.get(this.dataFieldName);
        }
        return null;
    }
    
    /*
     * ICache implemented methods
     */
    public void putObject(String key, Object value, int duration) {
        init();
        JDBCConnection conn = JDBCConnectionFactory.getJDBCConnection(this.connectionName);
        if (conn == null) {
            logger.debug("DbCache.put => unable to obtain connection. Cache is not used.");
            return;
        }
        String sql = null;
        //key = handleKey(key);
        if (isExists(key, conn, false)) {
            sql = buildUpdateSql(key, value.toString(), duration, conn);
        } else {
            sql = buildInsertSql(key, value.toString(), duration, conn);
        }
        logger.debug("DbCache.put => sql: "+sql);
        conn.executeUpdate(sql);
        conn.closeConnection();
    }
    
    public void removeObject(String key) {
        clearStartedWith(key);
    }
    
    /*
     * ICache implemented methods
     */
    public void clear() {
        init();
        JDBCConnection conn = JDBCConnectionFactory.getJDBCConnection(this.connectionName);
        if (conn == null) {
            logger.debug("DbCache.clear => unable to obtain connection. Cache is not used. There is nothing to delete.");
            return;
        }
        String sql = buildDeleteSql();
        logger.debug("DbCache.clear => sql: "+sql);
        PreparedStatement pstmt = conn.createPreparedStatementForUpdate(sql);
        try {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("DbCache.clear => unable to perform operation.", e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                }
            }
        }
        conn.closeConnection();
    }
    /*
     * ICache implemented methods
     */
    public void clearStartedWith(String keyPart) {
        init();
        JDBCConnection conn = JDBCConnectionFactory.getJDBCConnection(this.connectionName);
        if (conn == null) {
            logger.debug("DbCache.clearStartedWith => unable to obtain connection. Cache is not used. There is nothing to delete.");
            return;
        }
        //keyPart = handleKey(keyPart);
        String sql = buildDeleteStartedWithSql(keyPart, conn);
        logger.debug("DbCache.clearStartedWith => sql: "+sql);
        PreparedStatement pstmt = conn.createPreparedStatementForUpdate(sql);
        try {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("DbCache.clearStartedWith => unable to perform operation.", e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                }
            }
        }
        conn.closeConnection();
    }
    
    /*
     * ICache implemented methods
     */
    public void clearExpired() {
        init();
        JDBCConnection conn = JDBCConnectionFactory.getJDBCConnection(this.connectionName);
        if (conn == null) {
            logger.debug("DbCache.clearExpired => unable to obtain connection. Cache is not used. There is nothing to delete.");
            return;
        }
        String sql = buildDeleteExpiredSql(conn);
        logger.debug("DbCache.clearExpired => sql: "+sql);
        PreparedStatement pstmt = conn.createPreparedStatementForUpdate(sql);
        try {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("DbCache.clearExpired => unable to perform operation.", e);
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                }
            }
        }
        conn.closeConnection();
    }
    
    /*
     * End of ICache implemented methods
     */

    
    /*
     * DbCache specific
     */
    private boolean isExists(String key) {
        return isExists(key, false);
    }
    
    private boolean isExists(String key, boolean nonExpiredOnly) {
        init();
        JDBCConnection conn = JDBCConnectionFactory.getJDBCConnection(this.connectionName);
        if (conn == null) {
            logger.debug("DbCache.isExists => unable to obtain connection. Cache is not used.");
            return false;
        }
        //key = handleKey(key);
        boolean result = isExists(key, conn, nonExpiredOnly);
        conn.closeConnection();
        return result;
    }

    
    private DbRow getNonExpiredRow(String sql, JDBCConnection conn) {
        PreparedStatement ps = conn.createPreparedStatement(sql);
        ResultSet rs = null;
        DbRow data = null;
        try {
            //Date d = new Date(new java.util.Date().getTime());
            DbCache.logger.debug(sql);
            rs = ps.executeQuery();
            data = conn.getOneRow(rs);
        } catch (SQLException sqle) {
            CCLogger.getInstance().error("", sqle);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException sqle) {
                CCLogger.getInstance().error("", sqle);
            }
        }
        return data;
    }
    
    private boolean isExists(String key, JDBCConnection conn) {
        return isExists(key, conn, false);
    }
    
    private boolean isExists(String key, JDBCConnection conn, boolean nonExpiredOnly) {
        String sql = "SELECT COUNT(*) as cnt FROM " + this.leftDelim + this.tableName
                + this.rightDelim + " WHERE " + this.leftDelim + this.keyFieldName
                + this.rightDelim + " LIKE " + conn.toSql(key, JDBCConnection.TEXT);
        if (nonExpiredOnly) {
            sql += " AND " + this.leftDelim + this.expiredFieldName + this.rightDelim + ">= ?";
        }
                
        DbCache.logger.debug("DbCache.isExists => run sql:\n");
        DbRow data = null;
        if (nonExpiredOnly) {
            data = getNonExpiredRow(sql, conn);
        } else {
            data = conn.getOneRow(sql);
        }
        return (data != null && ((Number) data.get("cnt")).intValue() > 0);
    }
    
    public String getConnectionName() {
        return connectionName;
    }
    public void setConnectionName(String connectionName) {
        this.connectionName = connectionName;
    }
    public String getDataFieldName() {
        return dataFieldName;
    }
    public void setDataFieldName(String dataFieldName) {
        this.dataFieldName = dataFieldName;
    }
    public String getExpiredFieldName() {
        return expiredFieldName;
    }
    public void setExpiredFieldName(String expiredFieldName) {
        this.expiredFieldName = expiredFieldName;
    }
    public String getKeyFieldName() {
        return keyFieldName;
    }
    public void setKeyFieldName(String keyFieldName) {
        this.keyFieldName = keyFieldName;
    }
    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
    /*
     * End of DbCache specific
     */
    
    private String buildGetSql(String keyCondition, JDBCConnection conn) {
        CCLogger.getInstance().log("buildGetSql => keyCondition: "+keyCondition+" conn: "+conn);
        return "SELECT " + this.leftDelim + this.dataFieldName + this.rightDelim
                + " FROM " + this.leftDelim + this.tableName + this.rightDelim
                + " WHERE " + this.leftDelim + this.keyFieldName + this.rightDelim + " " 
                + keyCondition
                + " AND " + this.leftDelim + this.expiredFieldName + this.rightDelim
                + ">= " + (new java.util.Date()).getTime()/1000
                ;
    }
    
    private java.util.Date getExpireDate(int duration) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new java.util.Date());
        cal.add(Calendar.SECOND, duration);
        return cal.getTime();
    }
    
    private String buildInsertSql(String key, String value, int duration, JDBCConnection conn) {
        return "INSERT INTO " + this.leftDelim + this.tableName + this.rightDelim + "(" 
                + this.leftDelim + this.keyFieldName + this.rightDelim + ", "
                + this.leftDelim + this.expiredFieldName + this.rightDelim + ", "
                + this.leftDelim + this.dataFieldName + this.rightDelim 
                + ") VALUES ("
                + conn.toSql(key, JDBCConnection.TEXT) + ", "
                + getExpireDate(duration).getTime()/1000 + ", "
                + conn.toSql(value, JDBCConnection.TEXT) + ")";
    }

    private String buildUpdateSql(String key, String value, int duration, JDBCConnection conn) {
        return "UPDATE " + this.leftDelim + this.tableName + this.rightDelim + " SET " 
                + this.leftDelim + this.dataFieldName + this.rightDelim 
                + " = "
                + conn.toSql(value, JDBCConnection.TEXT) + ", " 
                + this.leftDelim + this.expiredFieldName + this.rightDelim + " = "
                + getExpireDate(duration).getTime()/1000
                + " WHERE "
                + this.leftDelim + this.keyFieldName + this.rightDelim + " LIKE "
                + conn.toSql(key, JDBCConnection.TEXT);
    }

    private String buildDeleteExpiredSql(JDBCConnection conn) {
        return "DELETE FROM " + this.leftDelim + this.tableName + this.rightDelim + " WHERE "
                + this.leftDelim + this.expiredFieldName + this.rightDelim + " < "
                + (new java.util.Date()).getTime()/1000;
    }

    private String buildDeleteStartedWithSql(String key, JDBCConnection conn) {
        return "DELETE FROM " + this.leftDelim + this.tableName + this.rightDelim + " WHERE "
                + this.leftDelim + this.keyFieldName + this.rightDelim + " LIKE "
                + conn.toSql(key + "%", JDBCConnection.TEXT);
    }

    private String buildDeleteSql() {
        return "DELETE FROM " + this.leftDelim + this.tableName + this.rightDelim;
    }
}


//End DbCache class

