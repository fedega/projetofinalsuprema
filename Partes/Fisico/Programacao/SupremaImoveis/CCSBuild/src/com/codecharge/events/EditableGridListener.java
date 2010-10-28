//EditableGridListener @0-1C9A7AE3
package com.codecharge.events;

public interface EditableGridListener extends ComponentListener {
    public void beforeShowRow(Event e);
    public void onValidate(Event e);
    public void onValidateRow(Event e);
    public void beforeSubmit(Event e);
    public void afterSubmit(Event e);
}
//End EditableGridListener

