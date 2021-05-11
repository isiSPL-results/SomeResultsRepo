// Compilation Unit of /UMLModelElementTaggedValueProxy.java 
 
package org.argouml.uml.ui;
import java.beans.PropertyChangeEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import org.argouml.model.AddAssociationEvent;
import org.argouml.model.Model;
import org.argouml.model.ModelEventPump;
import org.argouml.model.RemoveAssociationEvent;
import org.argouml.ui.targetmanager.TargetEvent;
import org.tigris.gef.presentation.Fig;
public class UMLModelElementTaggedValueProxy implements UMLDocument
  { 
private Object panelTarget = null;
private String tagName = null;
private static final String EVENT_NAME = "taggedValue";
private UMLModelElementTaggedValueDocument document;
public void propertyChange(PropertyChangeEvent evt)
    { 
if(evt instanceof AddAssociationEvent)//1
{ 
Object tv = evt.getNewValue();
Object td = Model.getFacade().getTagDefinition(tv);
String name = (String) Model.getFacade().getType(td);
if(tagName != null && tagName.equals(name))//1
{ 
document.setTarget(tv);
} 

} 
else
if(evt instanceof RemoveAssociationEvent)//1
{ 
Object tv = evt.getOldValue();
Object td = Model.getFacade().getTagDefinition(tv);
String name = (String) Model.getFacade().getType(td);
if(tagName != null && tagName.equals(name))//1
{ 
document.setTarget(null);
} 

} 
else
{ 
document.propertyChange(evt);
} 


} 

public Position createPosition(int offs) throws BadLocationException
    { 
return document.createPosition(offs);
} 

public void render(Runnable r)
    { 
document.render(r);
} 

public void addDocumentListener(DocumentListener listener)
    { 
document.addDocumentListener(listener);
} 

public Position getEndPosition()
    { 
return document.getEndPosition();
} 

public UMLModelElementTaggedValueProxy(String taggedValue)
    { 
tagName = taggedValue;
document = new UMLModelElementTaggedValueDocument("");
} 

protected String getProperty()
    { 
return document.getProperty();
} 

public void remove(int offs, int len) throws BadLocationException
    { 
document.remove(offs, len);
} 

public final void setTarget(Object target)
    { 
target = target instanceof Fig ? ((Fig) target).getOwner() : target;
if(Model.getFacade().isAModelElement(target))//1
{ 
if(target != panelTarget)//1
{ 
ModelEventPump eventPump = Model.getPump();
if(panelTarget != null)//1
{ 
eventPump.removeModelEventListener(this, panelTarget,
                                                       EVENT_NAME);
} 

panelTarget = target;
eventPump.addModelEventListener(this, panelTarget, EVENT_NAME);
document.setTarget(Model.getFacade().getTaggedValue(
                                       panelTarget, tagName));
} 

} 

} 

protected void setProperty(String text)
    { 
document.setProperty(text);
} 

public Object getProperty(Object key)
    { 
return document.getProperty(key);
} 

public Position getStartPosition()
    { 
return document.getStartPosition();
} 

public Element[] getRootElements()
    { 
return document.getRootElements();
} 

public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 

public void targetAdded(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 

public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 

public void insertString(int offset, String str, AttributeSet a)
    throws BadLocationException
    { 
document.insertString(offset, str, a);
} 

public String getText(int offset, int length) throws BadLocationException
    { 
return document.getText(offset, length);
} 

public Element getDefaultRootElement()
    { 
return document.getDefaultRootElement();
} 

public final Object getTarget()
    { 
return panelTarget;
} 

public int getLength()
    { 
return document.getLength();
} 

public void addUndoableEditListener(UndoableEditListener listener)
    { 
document.addUndoableEditListener(listener);
} 

public void getText(int offset, int length, Segment txt)
    throws BadLocationException
    { 
document.getText(offset, length, txt);
} 

public void removeUndoableEditListener(UndoableEditListener listener)
    { 
document.removeUndoableEditListener(listener);
} 

public void putProperty(Object key, Object value)
    { 
document.putProperty(key, value);
} 

public void removeDocumentListener(DocumentListener listener)
    { 
document.removeDocumentListener(listener);
} 

 } 


