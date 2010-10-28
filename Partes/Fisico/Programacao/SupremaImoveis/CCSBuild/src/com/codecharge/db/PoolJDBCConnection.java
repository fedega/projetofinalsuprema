//PoolJDBCConnection class @ 0-257205AE
/*
 * $Revision: 1.5 $
 * $Date: 2004/08/18 08:36:01 $
 */
package com.codecharge.db;

public class PoolJDBCConnection extends JDBCConnection {

    public PoolJDBCConnection(String name) {
        this(name, true);
    }

    public PoolJDBCConnection(String name, boolean initConnection) {
        super(name, initConnection);
    }

    public void getConnection() {
        if (this.conn == null) {
            DBConnectionManager dbcm = DBConnectionManager.getInstance();
            this.conn = dbcm.getConnection(this.poolName);
            if (this.conn == null) {
                throw new RuntimeException("Unable to create connection '" + this.poolName
                        + "' to the database.");
            }
        }
    }

    public void closeConnection() {
        DBConnectionManager dbcm = DBConnectionManager.getInstance();
        dbcm.freeConnection(this.poolName, this.conn);
        this.conn = null;
    }
}

//End PoolJDBCConnection class

