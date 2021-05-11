
//#if 214161793 
// Compilation Unit of /UMLStimulusActionTextField.java 
 

//#if 2091763300 
package org.argouml.uml.ui;
//#endif 


//#if 1566582622 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -301031830 
import java.beans.PropertyChangeListener;
//#endif 


//#if -1316838095 
import javax.swing.JTextField;
//#endif 


//#if -1156737865 
import javax.swing.event.DocumentEvent;
//#endif 


//#if 1190561393 
import javax.swing.event.DocumentListener;
//#endif 


//#if -4152834 
public class UMLStimulusActionTextField extends 
//#if -1648308267 
JTextField
//#endif 

 implements 
//#if 991830721 
DocumentListener
//#endif 

, 
//#if 2074876241 
UMLUserInterfaceComponent
//#endif 

, 
//#if 1088597003 
PropertyChangeListener
//#endif 

  { 

//#if -1160891627 
private UMLUserInterfaceContainer theContainer;
//#endif 


//#if -1211126454 
private UMLStimulusActionTextProperty theProperty;
//#endif 


//#if -1382813488 
public void propertyChange(PropertyChangeEvent event)
    { 

//#if -68784100 
if(theProperty.isAffected(event))//1
{ 

//#if 1531253704 
Object eventSource = event.getSource();
//#endif 


//#if -627343288 
Object target = theContainer.getTarget();
//#endif 


//#if 89126169 
if(eventSource == null || eventSource == target)//1
{ 

//#if 1313217633 
update();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 881312860 
public UMLStimulusActionTextField(UMLUserInterfaceContainer container,
                                      UMLStimulusActionTextProperty property)
    { 

//#if -1497932763 
theContainer = container;
//#endif 


//#if 1913532461 
theProperty = property;
//#endif 


//#if -708188858 
getDocument().addDocumentListener(this);
//#endif 


//#if -193330225 
update();
//#endif 

} 

//#endif 


//#if -2143288664 
public void insertUpdate(final DocumentEvent p1)
    { 

//#if -1051931543 
theProperty.setProperty(theContainer, getText());
//#endif 

} 

//#endif 


//#if -905790535 
public void targetReasserted()
    { 
} 

//#endif 


//#if 1583355941 
public void changedUpdate(final DocumentEvent p1)
    { 

//#if -375708345 
theProperty.setProperty(theContainer, getText());
//#endif 

} 

//#endif 


//#if 1923257237 
public void targetChanged()
    { 

//#if -1527554907 
theProperty.targetChanged();
//#endif 


//#if -1271493845 
update();
//#endif 

} 

//#endif 


//#if -21429969 
private void update()
    { 

//#if -2133998473 
String oldText = getText();
//#endif 


//#if -1096569394 
String newText = theProperty.getProperty(theContainer);
//#endif 


//#if 1349804816 
if(oldText == null || newText == null || !oldText.equals(newText))//1
{ 

//#if -926456168 
if(oldText != newText)//1
{ 

//#if -486472682 
setText(newText);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1891822067 
public void removeUpdate(final DocumentEvent p1)
    { 

//#if 1401777460 
theProperty.setProperty(theContainer, getText());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

