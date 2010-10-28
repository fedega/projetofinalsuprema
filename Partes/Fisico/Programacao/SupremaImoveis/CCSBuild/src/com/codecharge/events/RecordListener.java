//RecordListener @0-DC836121
package com.codecharge.events;

public interface RecordListener extends ComponentListener {
    public void onValidate(Event e);
    public void beforeInsert(Event e);
    public void afterInsert(Event e);
    public void beforeUpdate(Event e);
    public void afterUpdate(Event e);
    public void beforeDelete(Event e);
    public void afterDelete(Event e);
}
//End RecordListener

