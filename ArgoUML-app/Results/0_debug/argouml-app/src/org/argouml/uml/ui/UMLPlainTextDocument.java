
//#if 1818202100 
// Compilation Unit of /UMLPlainTextDocument.java 
 

//#if 225929589 
package org.argouml.uml.ui;
//#endif 


//#if 1141809069 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1719433772 
import javax.swing.text.AttributeSet;
//#endif 


//#if -271947107 
import javax.swing.text.BadLocationException;
//#endif 


//#if -229315233 
import javax.swing.text.PlainDocument;
//#endif 


//#if -1544146191 
import org.apache.log4j.Logger;
//#endif 


//#if 771437307 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if 303390308 
import org.argouml.model.Model;
//#endif 


//#if 1031972976 
import org.argouml.model.ModelEventPump;
//#endif 


//#if -1442875599 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -245304229 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1274540512 
public abstract class UMLPlainTextDocument extends 
//#if 2116974261 
PlainDocument
//#endif 

 implements 
//#if -674144321 
UMLDocument
//#endif 

  { 

//#if -1674383044 
private static final Logger LOG =
        Logger.getLogger(UMLPlainTextDocument.class);
//#endif 


//#if -427244680 
private boolean firing = true;
//#endif 


//#if 1479253829 
@Deprecated
    private boolean editing = false;
//#endif 


//#if -1921905606 
private Object panelTarget = null;
//#endif 


//#if -258756552 
private String eventName = null;
//#endif 


//#if -1815222953 
public void insertString(int offset, String str, AttributeSet a)
    throws BadLocationException
    { 

//#if -1192317219 
super.insertString(offset, str, a);
//#endif 


//#if 1038447040 
setPropertyInternal(getText(0, getLength()));
//#endif 

} 

//#endif 


//#if -1532803085 
public final void setTarget(Object target)
    { 

//#if 1431335128 
target = target instanceof Fig ? ((Fig) target).getOwner() : target;
//#endif 


//#if 646910591 
if(Model.getFacade().isAUMLElement(target))//1
{ 

//#if -986060822 
if(target != panelTarget)//1
{ 

//#if 497301671 
ModelEventPump eventPump = Model.getPump();
//#endif 


//#if -1295712985 
if(panelTarget != null)//1
{ 

//#if 327813507 
eventPump.removeModelEventListener(this, panelTarget,
                                                       getEventName());
//#endif 

} 

//#endif 


//#if -818237008 
panelTarget = target;
//#endif 


//#if -37727033 
eventPump.addModelEventListener(this, panelTarget,
                                                getEventName());
//#endif 

} 

//#endif 


//#if -768199535 
updateText(getProperty());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 949838191 
private final synchronized boolean isFiring()
    { 

//#if 853111207 
return firing;
//#endif 

} 

//#endif 


//#if -1996833743 
private final void updateText(String textValue)
    { 

//#if 767513814 
try //1
{ 

//#if 952376430 
if(textValue == null)//1
{ 

//#if 1488059839 
textValue = "";
//#endif 

} 

//#endif 


//#if -264715872 
String currentValue = getText(0, getLength());
//#endif 


//#if 1273927256 
if(isFiring() && !textValue.equals(currentValue))//1
{ 

//#if -647088137 
setFiring(false);
//#endif 


//#if -1322378931 
super.remove(0, getLength());
//#endif 


//#if -1664977859 
super.insertString(0, textValue, null);
//#endif 

} 

//#endif 

} 

//#if 2136411276 
catch (BadLocationException b) //1
{ 

//#if -163574354 
LOG.error(
                "A BadLocationException happened\n"
                + "The string to set was: "
                + getProperty(),
                b);
//#endif 

} 

//#endif 

finally { 

//#if -242671015 
setFiring(true);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1673257948 
public UMLPlainTextDocument(String name)
    { 

//#if 696880139 
super();
//#endif 


//#if 1108379190 
setEventName(name);
//#endif 

} 

//#endif 


//#if -31503897 
public void targetRemoved(TargetEvent e)
    { 

//#if -758764965 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -1003378342 
public String getEventName()
    { 

//#if -741016075 
return eventName;
//#endif 

} 

//#endif 


//#if -173740026 
protected abstract void setProperty(String text);
//#endif 


//#if 1875614844 
protected void setEventName(String en)
    { 

//#if -787283772 
eventName = en;
//#endif 

} 

//#endif 


//#if 967537509 
public void propertyChange(PropertyChangeEvent evt)
    { 

//#if 1923994667 
if(evt instanceof AttributeChangeEvent
                && eventName.equals(evt.getPropertyName()))//1
{ 

//#if 1905221715 
updateText((String) evt.getNewValue());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1224469715 
private final synchronized void setFiring(boolean f)
    { 

//#if 1705058771 
ModelEventPump eventPump = Model.getPump();
//#endif 


//#if -2018948761 
if(f && panelTarget != null)//1
{ 

//#if -344149612 
eventPump.addModelEventListener(this, panelTarget, eventName);
//#endif 

} 
else
{ 

//#if 1254045303 
eventPump.removeModelEventListener(this, panelTarget, eventName);
//#endif 

} 

//#endif 


//#if 1229148449 
firing = f;
//#endif 

} 

//#endif 


//#if 903469403 
protected abstract String getProperty();
//#endif 


//#if -169761943 
public void targetSet(TargetEvent e)
    { 

//#if -363695231 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -715885620 
private void setPropertyInternal(String newValue)
    { 

//#if -489487325 
if(isFiring() && !newValue.equals(getProperty()))//1
{ 

//#if 635809210 
setFiring(false);
//#endif 


//#if -739669188 
setProperty(newValue);
//#endif 


//#if -777533888 
Model.getPump().flushModelEvents();
//#endif 


//#if 852912763 
setFiring(true);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1728855083 
public void remove(int offs, int len) throws BadLocationException
    { 

//#if 1695481055 
super.remove(offs, len);
//#endif 


//#if -982687836 
setPropertyInternal(getText(0, getLength()));
//#endif 

} 

//#endif 


//#if 19716871 
public void targetAdded(TargetEvent e)
    { 

//#if 486559115 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -679399892 
public final Object getTarget()
    { 

//#if -1265357955 
return panelTarget;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

