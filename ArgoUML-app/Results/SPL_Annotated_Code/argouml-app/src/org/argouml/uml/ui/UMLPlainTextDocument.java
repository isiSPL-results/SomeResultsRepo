// Compilation Unit of /UMLPlainTextDocument.java 
 
package org.argouml.uml.ui;
import java.beans.PropertyChangeEvent;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import org.apache.log4j.Logger;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.Model;
import org.argouml.model.ModelEventPump;
import org.argouml.ui.targetmanager.TargetEvent;
import org.tigris.gef.presentation.Fig;
public abstract class UMLPlainTextDocument extends PlainDocument
 implements UMLDocument
  { 
private static final Logger LOG =
        Logger.getLogger(UMLPlainTextDocument.class);
private boolean firing = true;
@Deprecated
    private boolean editing = false;
private Object panelTarget = null;
private String eventName = null;
public void insertString(int offset, String str, AttributeSet a)
    throws BadLocationException
    { 
super.insertString(offset, str, a);
setPropertyInternal(getText(0, getLength()));
} 

public final void setTarget(Object target)
    { 
target = target instanceof Fig ? ((Fig) target).getOwner() : target;
if(Model.getFacade().isAUMLElement(target))//1
{ 
if(target != panelTarget)//1
{ 
ModelEventPump eventPump = Model.getPump();
if(panelTarget != null)//1
{ 
eventPump.removeModelEventListener(this, panelTarget,
                                                       getEventName());
} 

panelTarget = target;
eventPump.addModelEventListener(this, panelTarget,
                                                getEventName());
} 

updateText(getProperty());
} 

} 

private final synchronized boolean isFiring()
    { 
return firing;
} 

private final void updateText(String textValue)
    { 
try //1
{ 
if(textValue == null)//1
{ 
textValue = "";
} 

String currentValue = getText(0, getLength());
if(isFiring() && !textValue.equals(currentValue))//1
{ 
setFiring(false);
super.remove(0, getLength());
super.insertString(0, textValue, null);
} 

} 
catch (BadLocationException b) //1
{ 
LOG.error(
                "A BadLocationException happened\n"
                + "The string to set was: "
                + getProperty(),
                b);
} 

finally { 
setFiring(true);
} 

} 

public UMLPlainTextDocument(String name)
    { 
super();
setEventName(name);
} 

public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 

public String getEventName()
    { 
return eventName;
} 

protected abstract void setProperty(String text);
protected void setEventName(String en)
    { 
eventName = en;
} 

public void propertyChange(PropertyChangeEvent evt)
    { 
if(evt instanceof AttributeChangeEvent
                && eventName.equals(evt.getPropertyName()))//1
{ 
updateText((String) evt.getNewValue());
} 

} 

private final synchronized void setFiring(boolean f)
    { 
ModelEventPump eventPump = Model.getPump();
if(f && panelTarget != null)//1
{ 
eventPump.addModelEventListener(this, panelTarget, eventName);
} 
else
{ 
eventPump.removeModelEventListener(this, panelTarget, eventName);
} 

firing = f;
} 

protected abstract String getProperty();
public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 

private void setPropertyInternal(String newValue)
    { 
if(isFiring() && !newValue.equals(getProperty()))//1
{ 
setFiring(false);
setProperty(newValue);
Model.getPump().flushModelEvents();
setFiring(true);
} 

} 

public void remove(int offs, int len) throws BadLocationException
    { 
super.remove(offs, len);
setPropertyInternal(getText(0, getLength()));
} 

public void targetAdded(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 

public final Object getTarget()
    { 
return panelTarget;
} 

 } 


