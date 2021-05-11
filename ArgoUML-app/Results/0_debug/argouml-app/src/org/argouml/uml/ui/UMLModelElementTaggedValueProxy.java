
//#if 1210432466 
// Compilation Unit of /UMLModelElementTaggedValueProxy.java 
 

//#if 2105287083 
package org.argouml.uml.ui;
//#endif 


//#if -1210070601 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 968578122 
import javax.swing.event.DocumentListener;
//#endif 


//#if 937115037 
import javax.swing.event.UndoableEditListener;
//#endif 


//#if 1782114018 
import javax.swing.text.AttributeSet;
//#endif 


//#if -1090404013 
import javax.swing.text.BadLocationException;
//#endif 


//#if -103692654 
import javax.swing.text.Element;
//#endif 


//#if -1248837441 
import javax.swing.text.Position;
//#endif 


//#if 960515387 
import javax.swing.text.Segment;
//#endif 


//#if 237407625 
import org.argouml.model.AddAssociationEvent;
//#endif 


//#if 66522010 
import org.argouml.model.Model;
//#endif 


//#if 28407802 
import org.argouml.model.ModelEventPump;
//#endif 


//#if -1269579722 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if -1563222853 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -139129967 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 828191298 
public class UMLModelElementTaggedValueProxy implements 
//#if -1065535223 
UMLDocument
//#endif 

  { 

//#if -94008656 
private Object panelTarget = null;
//#endif 


//#if 253838766 
private String tagName = null;
//#endif 


//#if -435859091 
private static final String EVENT_NAME = "taggedValue";
//#endif 


//#if -1403420886 
private UMLModelElementTaggedValueDocument document;
//#endif 


//#if 411336795 
public void propertyChange(PropertyChangeEvent evt)
    { 

//#if -1421345625 
if(evt instanceof AddAssociationEvent)//1
{ 

//#if 176122381 
Object tv = evt.getNewValue();
//#endif 


//#if -1354968798 
Object td = Model.getFacade().getTagDefinition(tv);
//#endif 


//#if 402531232 
String name = (String) Model.getFacade().getType(td);
//#endif 


//#if 452255984 
if(tagName != null && tagName.equals(name))//1
{ 

//#if -1716854549 
document.setTarget(tv);
//#endif 

} 

//#endif 

} 
else

//#if 1819950973 
if(evt instanceof RemoveAssociationEvent)//1
{ 

//#if -1298695026 
Object tv = evt.getOldValue();
//#endif 


//#if -1461056408 
Object td = Model.getFacade().getTagDefinition(tv);
//#endif 


//#if 1408782618 
String name = (String) Model.getFacade().getType(td);
//#endif 


//#if 1089046710 
if(tagName != null && tagName.equals(name))//1
{ 

//#if 448551734 
document.setTarget(null);
//#endif 

} 

//#endif 

} 
else
{ 

//#if 256809600 
document.propertyChange(evt);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -896610909 
public Position createPosition(int offs) throws BadLocationException
    { 

//#if -802064088 
return document.createPosition(offs);
//#endif 

} 

//#endif 


//#if -1833289213 
public void render(Runnable r)
    { 

//#if -464560937 
document.render(r);
//#endif 

} 

//#endif 


//#if 1862269451 
public void addDocumentListener(DocumentListener listener)
    { 

//#if 1778923976 
document.addDocumentListener(listener);
//#endif 

} 

//#endif 


//#if -679064377 
public Position getEndPosition()
    { 

//#if 1379578011 
return document.getEndPosition();
//#endif 

} 

//#endif 


//#if 415173372 
public UMLModelElementTaggedValueProxy(String taggedValue)
    { 

//#if -1673647925 
tagName = taggedValue;
//#endif 


//#if -2106691962 
document = new UMLModelElementTaggedValueDocument("");
//#endif 

} 

//#endif 


//#if 238606003 
protected String getProperty()
    { 

//#if 91770346 
return document.getProperty();
//#endif 

} 

//#endif 


//#if 1219597643 
public void remove(int offs, int len) throws BadLocationException
    { 

//#if 1823736675 
document.remove(offs, len);
//#endif 

} 

//#endif 


//#if 1958998121 
public final void setTarget(Object target)
    { 

//#if -659518522 
target = target instanceof Fig ? ((Fig) target).getOwner() : target;
//#endif 


//#if 548091932 
if(Model.getFacade().isAModelElement(target))//1
{ 

//#if -1945736150 
if(target != panelTarget)//1
{ 

//#if 263262417 
ModelEventPump eventPump = Model.getPump();
//#endif 


//#if -1957992111 
if(panelTarget != null)//1
{ 

//#if -123085487 
eventPump.removeModelEventListener(this, panelTarget,
                                                       EVENT_NAME);
//#endif 

} 

//#endif 


//#if 750244678 
panelTarget = target;
//#endif 


//#if 899319741 
eventPump.addModelEventListener(this, panelTarget, EVENT_NAME);
//#endif 


//#if -168671976 
document.setTarget(Model.getFacade().getTaggedValue(
                                       panelTarget, tagName));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 691869022 
protected void setProperty(String text)
    { 

//#if -1757454942 
document.setProperty(text);
//#endif 

} 

//#endif 


//#if -1766594508 
public Object getProperty(Object key)
    { 

//#if 1341954531 
return document.getProperty(key);
//#endif 

} 

//#endif 


//#if 452012814 
public Position getStartPosition()
    { 

//#if -755904677 
return document.getStartPosition();
//#endif 

} 

//#endif 


//#if -1872315775 
public Element[] getRootElements()
    { 

//#if -784950659 
return document.getRootElements();
//#endif 

} 

//#endif 


//#if 1605155505 
public void targetRemoved(TargetEvent e)
    { 

//#if 819116870 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -2146175407 
public void targetAdded(TargetEvent e)
    { 

//#if 1595354322 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -1182070477 
public void targetSet(TargetEvent e)
    { 

//#if 639199401 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 1773765793 
public void insertString(int offset, String str, AttributeSet a)
    throws BadLocationException
    { 

//#if 1616531846 
document.insertString(offset, str, a);
//#endif 

} 

//#endif 


//#if -574103803 
public String getText(int offset, int length) throws BadLocationException
    { 

//#if 1433326425 
return document.getText(offset, length);
//#endif 

} 

//#endif 


//#if -1547296157 
public Element getDefaultRootElement()
    { 

//#if 724495933 
return document.getDefaultRootElement();
//#endif 

} 

//#endif 


//#if 1963840034 
public final Object getTarget()
    { 

//#if -709994202 
return panelTarget;
//#endif 

} 

//#endif 


//#if 1115766109 
public int getLength()
    { 

//#if 1994282018 
return document.getLength();
//#endif 

} 

//#endif 


//#if 2014098027 
public void addUndoableEditListener(UndoableEditListener listener)
    { 

//#if -779690197 
document.addUndoableEditListener(listener);
//#endif 

} 

//#endif 


//#if 1738398085 
public void getText(int offset, int length, Segment txt)
    throws BadLocationException
    { 

//#if -146369572 
document.getText(offset, length, txt);
//#endif 

} 

//#endif 


//#if -186844940 
public void removeUndoableEditListener(UndoableEditListener listener)
    { 

//#if 2075793084 
document.removeUndoableEditListener(listener);
//#endif 

} 

//#endif 


//#if 1434159242 
public void putProperty(Object key, Object value)
    { 

//#if 291750333 
document.putProperty(key, value);
//#endif 

} 

//#endif 


//#if -444606060 
public void removeDocumentListener(DocumentListener listener)
    { 

//#if 200586991 
document.removeDocumentListener(listener);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

