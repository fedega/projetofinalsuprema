//ItemList class @0-E14B00CE
/*
 * $Revision: 1.1 $
 * $Date: 2005/01/18 10:22:52 $
 */
package com.codecharge.template.structure;



import java.util.ArrayList;
import java.util.Iterator;


public class ItemList {

    private ArrayList list;

    public ItemList() {
        list = new ArrayList( 5 );
    }

    public void add( ITemplateItem item ) {
        list.add( item );
    }

    public ITemplateItem get( int i ) {
        return (ITemplateItem) list.get(i);
    }

    public ITemplateItem remove( int i ) {
        return (ITemplateItem) list.remove(i);
    }

    public ITemplateItem removeLast() {
        return (ITemplateItem) list.remove( size() - 1 );
    }

    public int size() {
        return list.size();
    }

    public Iterator iterator() {
        return list.iterator();
    }
}

//End ItemList class

