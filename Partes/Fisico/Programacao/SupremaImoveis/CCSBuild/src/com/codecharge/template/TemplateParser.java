//TemplateParser class @0-7DFC8D76
/*
 * $Revision: 1.3 $
 * $Date: 2005/02/18 14:23:57 $
 */
package com.codecharge.template;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Locale;

import com.codecharge.template.structure.ITemplateItem;
import com.codecharge.template.structure.ITemplateNamedItem;
import com.codecharge.template.structure.ResourceVariable;
import com.codecharge.template.structure.TemplateBlock;
import com.codecharge.template.structure.TemplateText;
import com.codecharge.template.structure.TemplateVariable;
import com.codecharge.util.StringUtils;


public class TemplateParser implements ITemplateParser {
    
    Map templateModel = new HashMap();
    
    /**
     * maxDepth defines maximal level of nested blocks.
     */
    final private static int maxDepth = 100;

    /**
     * tree keeps all nodes of parsed template
     */
    private String[] tree = new String[maxDepth];
    /**
     * stack is needed for keeping information about nested blocks during parsing
     */
    private String[] stack = new String[maxDepth];
    /**
     * blocks keep children for each block
     */
    private ITemplateItem[] blocks = new ITemplateItem[maxDepth];
    
    /**
     * depth is current level of nesting blocks
     */
    private int depth = 0;
    /**
     * sequence number for template items
     */
    private int itemCounter = 0;
    /**
     * full path to block/variable
     */
    private String path;
    /**
     * brief path to block/variable. This path includes only one parent block
     */
    private String secondPath;
    /**
     * brief path to block/variable. This path includes only two parent blocks
     */
    private String thirdPath;
    /**
     * list of parsed template items
     */
    private ArrayList items = new ArrayList();
    /**
     * currentText services for keeping static text during parsing
     */
    private TemplateText currentText = new TemplateText();
    /**
     * currentVariable services for keeping variable during parsing
     */
    private TemplateVariable currentVariable = new TemplateVariable();
    /**
     * currentResVariable services for keeping resource variable text during parsing
     */
    private ResourceVariable currentResVariable = new ResourceVariable();
    /**
     * currentBlock services for keeping block during parsing
     */
    private TemplateBlock currentBlock;
    /**
     * root template node.
     * TODO: support several root nodes.
     */
    private TemplateBlock main = new TemplateBlock();

    /**
     * Locale for initializing resource variables
     */
    Locale locale = Locale.getDefault();
    
    private static String someVar = "111";

    private boolean debug = true;

    public void setLocale(Locale locale) {
        this.locale = locale;
        if (this.locale == null) {
            locale = Locale.getDefault();
        }
    }
    
    private void clearItems() {
    	for (int i = items.size()-1; i >=0 ;i--) {
    		items.remove(i);
    	}
    }

    public Map parse(Reader reader) {
        //this.templateModel = new HashMap();
        try {
            currentResVariable.setLocale(this.locale);
            currentText = new TemplateText();
            currentVariable = new TemplateVariable();
            main = new TemplateBlock();

            depth = 0;
            itemCounter = 0;
            main.setName( "main" );
            currentBlock = main;
            blocks[depth] = currentBlock;
            tree[depth] = "main";
            items.add(currentBlock);
            itemCounter++;
            depth++;
            getPath();
            putToModel(this.path + "/*", main);

            StreamTokenizer in = new StreamTokenizer( reader );
            in.resetSyntax();
            in.eolIsSignificant( true );
            in.ordinaryChar( ' ' ); //separator in blocks
            in.ordinaryChar( '{' ); //start variables
            in.ordinaryChar( '}' ); //end variables
            in.ordinaryChar( '<' ); //may be block begin
            in.ordinaryChar( '>' ); //may be block end
            in.ordinaryChar( '-' ); //symbol from html comment
            in.ordinaryChar( '"' ); //
            in.ordinaryChar( '!' ); //Second symbol of html comment
            in.ordinaryChar( '.' ); 
            in.wordChars( '#', ',' );
            in.wordChars( '[', '`' );
            in.wordChars( '.', '9' );
            in.wordChars( 'a', 'z' );
            in.wordChars( 'A', 'Z' );
            in.wordChars( '?', '@' );
            in.wordChars( ':', ';' );
            in.wordChars( '=', '=' );
            in.wordChars( '|', '|' );
            in.wordChars( '~', 255 );


            while( in.nextToken() != StreamTokenizer.TT_EOF ) {
                if ( in.ttype == '{' ) {
                    getVar( in );
                } else if ( in.ttype == '<' ) {
                    getBlock( in );
                } else {
                    if ( in.ttype == StreamTokenizer.TT_WORD ) {
                        currentText.addToBody( in.sval );
                    } else if ( in.ttype == StreamTokenizer.TT_NUMBER ) {
                        if ( ((int) in.nval) == in.nval ) {
                            currentText.addToBody( String.valueOf( (int) in.nval ) );
                        } else {
                            currentText.addToBody( String.valueOf( in.nval ) );
                        }
                    } else if ( in.ttype == ' ' ) {
                        currentText.addToBody( " " );
                    } else if ( in.ttype == '\"' ) {
                        currentText.addToBody( "\"" );
                    } else if ( in.ttype == '-' ) {
                        currentText.addToBody( "-" );
                    } else if ( in.ttype == '!' ) {
                        currentText.addToBody( "!" );
                    } else if ( in.ttype == '}' ) {
                        currentText.addToBody( "}" );
                    } else if ( in.ttype == '>' ) {
                        currentText.addToBody( ">" );
                    } else if ( in.ttype == '.' ) {
                        currentText.addToBody( "." );
                    } else if ( in.ttype == '=' ) {
                        currentText.addToBody( "=" );
                    } else if ( in.ttype == StreamTokenizer.TT_EOL ) {
                        currentText.addToBody( "\n" );
                    } else {
                        currentText.addToBody(in.sval);
                    }
                }
            }
            currentBlock.addItem(currentText);
            items.add( currentText );
            putToModel(this.path + "/@text", currentText);
            itemCounter++;
            reader.close();
        } catch ( Exception e ) {
            e.printStackTrace(System.out);
        }
        this.clearItems();
        return this.templateModel;
    }
    
    private void printModel() {
        if (this.templateModel == null) return;
        for (Iterator it = this.templateModel.keySet().iterator(); it.hasNext(); ) {
            String key = (String) it.next();
            List its = (List) this.templateModel.get(key);
            for (Iterator it1 = its.iterator(); it1.hasNext();) {
                ITemplateItem item = (ITemplateItem) it1.next();
                /*if (item instanceof ITemplateNamedItem) {
                    System.out.println("==================================================");
                    System.out.println("key: " + key);
                    System.out.println("path: " + item.getPath());
                    System.out.println("body: " + item.getBody());
                    System.out.println("==================================================");
                }*/
            }
        }
    }

    private void getVar( StreamTokenizer in ) throws IOException {
        StringBuffer name = new StringBuffer();
        while( in.nextToken() != StreamTokenizer.TT_EOF ) {
			if ( in.ttype == '<' ) {
				currentText.addToBody( "{" + name.toString() );
				getBlock( in );
				break;
			}
            if ( in.ttype == '}' ) {
                if ( checkVarName( getName( name.toString() ) ) ) {
                    currentBlock.addItem( currentText );
                    items.add( currentText );
                    putToModel(this.path + "/@text", currentText);
                    itemCounter++;
                    currentText = new TemplateText();
                    if ( name.toString().startsWith( "res:" ) ) {
                        currentResVariable.setBody(name.substring(4));
                        currentBlock.addItem( currentResVariable );
                        items.add( currentResVariable );
                        currentResVariable.setName(getName(name.toString()));
                        currentResVariable.setPath(this.path);
                        putToModel(this.path + "/@" + name + "/*", currentResVariable);
                        putToModel(this.secondPath + "/@" + name + "/*", currentResVariable);
                        putToModel(this.thirdPath + "/@" + name + "/*", currentResVariable);
                        putToModel("/@" + name + "/*", currentResVariable);
                        currentResVariable = new ResourceVariable();
                        currentResVariable.setLocale(this.locale);
                    } else {
                        currentBlock.addItem( currentVariable );
                        items.add( currentVariable );
                        currentVariable.setName(getName(name.toString()));
                        currentVariable.setPath(this.path);
                        putToModel(this.path + "/@" + name + "/*", currentVariable);
                        putToModel(this.secondPath + "/@" + name + "/*", currentVariable);
                        putToModel(this.thirdPath + "/@" + name + "/*", currentVariable);
                        putToModel("/@" + name + "/*", currentVariable);
                        currentVariable = new TemplateVariable();
                    }
                    itemCounter++;
                } else {
                    currentText.addToBody( "{" + name.toString() );
                    currentText.addToBody( "}" );
                    break;
                }
                break;
            } else {
                if ( in.ttype == StreamTokenizer.TT_WORD ) {
                    name.append(in.sval);
                } else if ( in.ttype == StreamTokenizer.TT_NUMBER ) {
                    name.append( String.valueOf( ((int) in.nval) == in.nval ? (int) in.nval : in.nval ) );
                } else if ( in.ttype == ' ' ) {
                    name.append( " " );
                } else if ( in.ttype == ':' ) {
                    name.append( ":" );
                } else if ( in.ttype == '.' ) {
                    name.append( "." );
                } else if ( in.ttype == '-' ) {
                    name.append( "-" );
                } else if ( in.ttype == '\"' ) {
                    name.append( "\"" );
                } else if ( in.ttype == '"' ) {
                    name.append( "\"" );
                } else if ( in.ttype == StreamTokenizer.TT_EOL ) {
                    currentText.addToBody( "{" + name.toString() + "\n" );
                    name = null;
                    break;
                }
            }
        }
    }

    private void getBlock( StreamTokenizer in ) throws IOException  {
        int blockInc = 0;
        boolean isBlock = false;
        boolean endBlock = false;
        boolean isStartTag = true;
        StringBuffer name = new StringBuffer();
        StringBuffer text = new StringBuffer( "<" );
        if ( in.nextToken() == '!' ) {
            text.append( "!" );
        } else {
            //If it is not HTML comment
            in.pushBack();
            currentText.addToBody("<");
            return;
        }
        while( in.nextToken() != StreamTokenizer.TT_EOF ) {
            if ( in.ttype == '"' ) {
                text.append( "\"" );
                if ( isBlock || endBlock ) {
                    name.append( "\"" );
                }
            } else if ( in.ttype == '=' ) {
                text.append( "=" );
                if ( isBlock || endBlock ) {
                    name.append( "=" );
                }
            } else if ( in.ttype == '-' ) {
                boolean isEndTag = false;
                text.append( "-" );
                if ( ! isStartTag ) {
                    if ( in.nextToken() != StreamTokenizer.TT_EOF ) {
                        if ( in.ttype == '-' ) {
                            text.append( "-" );
                            if ( in.nextToken() != StreamTokenizer.TT_EOF ) {
                                if ( in.ttype == '>' ) {
                                    text.append( ">" );
                                    isEndTag = true;
                                } else {
                                    in.pushBack();
                                }
                            }
                        } else {
                            in.pushBack();
                        }
                    }
                    if ( (isBlock || endBlock) && isEndTag ) {
                        String blockName = name.toString().trim();
                        if ( checkBlockName( getName( blockName ) ) ) {
                            if ( endBlock ) {
                                if ( ! ((TemplateBlock) blocks[depth-1]).getName().equals( blockName ) ) {
                                    System.err.println("ERROR: missing end of block '" + ((TemplateBlock) blocks[depth-1]).getName() + "'" );
                                    String rPath = this.path;
                                    depth--;
                                    removeFromModel();
                                    getPath();
                                    TemplateBlock tempBlock = currentBlock;
                                    items.remove( tempBlock.getPosition() );
                                    currentBlock = (TemplateBlock) blocks[depth-1];
                                    currentBlock.getChildren().removeLast();

                                    TemplateText txt = new TemplateText();
                                    txt.setBody( tempBlock.getStartTag() );
                                    currentBlock.addItem( txt );
                                    for ( int i = 0; i < tempBlock.getChildren().size(); i++ ) {
                                        currentBlock.addItem( tempBlock.getChildren().get(i) );
                                    }
                                    currentText.addToBody( text.toString() );
                                    currentBlock.addItem(currentText);
                                    items.add( currentText );
                                    putToModel(this.path + "/@text", currentText);
                                    itemCounter++;
                                    currentText = new TemplateText();
                                    endBlock = false;
                                    isBlock = false;
                                    isEndTag = false;
                                } else {
                                    currentBlock.addItem(currentText);
                                    items.add( currentText );
                                    putToModel(this.path + "/@text", currentText);
                                    itemCounter++;
                                    currentText = new TemplateText();
                                    depth--;
                                    getPath();
                                    currentBlock = (TemplateBlock) blocks[depth-1];
                                }
                                blockInc = 0;
                                endBlock = false;
                                isBlock = false;
                                break;
                            }
                            if ( isBlock ) {
                                currentBlock.addItem(currentText);
                                items.add( currentText );
                                putToModel(this.path + "/@text", currentText);
                                itemCounter++;
                                currentText = new TemplateText();
                                TemplateBlock block = new TemplateBlock();
                                currentBlock.addItem( block );
                                items.add( block );
                                block.setPosition( itemCounter );
                                itemCounter++;
                                currentBlock = block;
                                blocks[depth] = currentBlock;
                                tree[depth]=blockName;
                                stack[depth]=blockName;
                                depth++;
                                getPath();
                                putToModel(currentBlock);
                                currentBlock.setName(blockName);
                                currentBlock.setPath(this.path);
                                putToModel("/"+ currentBlock.getName() + "/*", currentBlock);
                                blockInc = 0;
                            }
                            if ( blockInc > 0 ) {
                            } else if ( blockInc < 0 ) {
                            }
                            break;
                        } else {
                            currentText.addToBody( text.toString() );
                            break;
                        }
                    } else { // end if ( (isBlock || endBlock) && isEndTag ) {
                        currentText.addToBody( text.toString() );
                        break;
                    }
                }
            } else if ( in.ttype == StreamTokenizer.TT_EOL ) {
                isStartTag = false;
                currentText.addToBody( text.toString() + "\n" );
                break;
            } else if ( in.ttype == ' ' ) {
                isStartTag = false;
                name.append( " " );
                text.append( " " );
            } else if ( in.ttype == '.' ) {
                isStartTag = false;
                name.append( "." );
                text.append( "." );
            } else if ( in.ttype == '=' ) {
                isStartTag = false;
                name.append( "=" );
                text.append( "=" );
            } else if ( in.ttype == StreamTokenizer.TT_WORD ) {
                isStartTag = false;
                text.append( in.sval );
                if ( isBlock || endBlock ) {
                    name.append( in.sval );
                } else if ( "BEGIN".equals( in.sval ) ) {
                    blockInc = 1;
                    isBlock = true;
                } else if ( "END".equals( in.sval ) ) {
                    blockInc = -1;
                    endBlock = true;
                }
            } else if ( in.ttype == StreamTokenizer.TT_NUMBER && (isBlock || endBlock) ) {
                isStartTag = false;
                if ( ((int) in.nval) == in.nval ) {
                    name.append( String.valueOf( (int) in.nval ) );
                    text.append( String.valueOf( (int) in.nval ) );
                } else {
                    name.append( String.valueOf( in.nval ) );
                    text.append( String.valueOf( in.nval ) );
                }
            }
        } // End of while
    }

    private void putToModel(ITemplateItem item) {
        putToModel(this.path + "/*", item);
        putToModel(this.secondPath + "/*", item);
        putToModel(this.thirdPath + "/*", item);
    }
    
    private void putToModel(String path, ITemplateItem item) {
        if (StringUtils.isEmpty(path) || item == null) {
            return;
        }
        ArrayList pathItems = (ArrayList) this.templateModel.get(path);
        if (pathItems == null) {
            pathItems = new ArrayList();
            this.templateModel.put(path, pathItems);
        }
        if (! pathItems.contains(item)) {
            pathItems.add(item);
        }
    }
    
    private void removeFromModel() {
        removeFromModel(this.path);
        removeFromModel(this.secondPath);
        removeFromModel(this.thirdPath);
    }
    
    private void removeFromModel(String path) {
        if (StringUtils.isEmpty(path)) {
            return;
        }
        ArrayList pathItems = (ArrayList) this.templateModel.get(path);
        if (pathItems != null) {
            pathItems.remove(pathItems.size() - 1);
        }
    }
    
    private StringBuffer sbPath = new StringBuffer();
    private void getPath() {
        sbPath.setLength( 0 );
        for ( int i = 0; i < depth; i++ ) {
            sbPath.append( "/" + tree[i] );
        }
        path = sbPath.toString();
        sbPath.setLength( 0 );
        for ( int i = depth - 1; i > -1 && i < depth; i++ ) {
            if ( i >= depth - 1 ) {
                sbPath.append( "/" );
            }
            sbPath.append( tree[i] );
        }
        secondPath = sbPath.toString();
        sbPath.setLength( 0 );
        for ( int i = depth - 2; i > -1 && i < depth; i++ ) {
            if ( i >= depth - 2 ) {
                sbPath.append( "/" );
            }
            sbPath.append( tree[i] );
        }
        thirdPath = sbPath.toString();
    }

    private boolean checkBlockName( String blockName ) {
        return true;
    }

    private boolean checkVarName( String blockName ) {
		if ("".equals(blockName)) return false;
        char[] charName = blockName.toCharArray();
        for (int i = 0; i < charName.length; i++) {
            if (charName[i] == ' '  ||
                charName[i] == '\n' ||
                charName[i] == '\"' ||
                charName[i] == '='  ||
                charName[i] == '{'  ||
                charName[i] == '('  ||
                charName[i] == ')'  ||
                charName[i] == ';'
                ) {
                    return false;
                }
        }
        return true;
    }

    private String getName( String nameString ) {
        String name = new String( nameString.trim() );
        int pos = name.indexOf( '=' );
        if ( pos > -1 ) {
            int npos = name.lastIndexOf( ' ', pos );
            if ( npos > -1 ) {
                name = name.substring( 0, npos );
            }
        }
        return name;
    }
}



//End TemplateParser class

