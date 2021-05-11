// Compilation Unit of /UMLStimulusActionTextField.java 
 
package org.argouml.uml.ui;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class UMLStimulusActionTextField extends JTextField
 implements DocumentListener
, UMLUserInterfaceComponent
, PropertyChangeListener
  { 
private UMLUserInterfaceContainer theContainer;
private UMLStimulusActionTextProperty theProperty;
public void propertyChange(PropertyChangeEvent event)
    { 
if(theProperty.isAffected(event))//1
{ 
Object eventSource = event.getSource();
Object target = theContainer.getTarget();
if(eventSource == null || eventSource == target)//1
{ 
update();
} 

} 

} 

public UMLStimulusActionTextField(UMLUserInterfaceContainer container,
                                      UMLStimulusActionTextProperty property)
    { 
theContainer = container;
theProperty = property;
getDocument().addDocumentListener(this);
update();
} 

public void insertUpdate(final DocumentEvent p1)
    { 
theProperty.setProperty(theContainer, getText());
} 

public void targetReasserted()
    { 
} 

public void changedUpdate(final DocumentEvent p1)
    { 
theProperty.setProperty(theContainer, getText());
} 

public void targetChanged()
    { 
theProperty.targetChanged();
update();
} 

private void update()
    { 
String oldText = getText();
String newText = theProperty.getProperty(theContainer);
if(oldText == null || newText == null || !oldText.equals(newText))//1
{ 
if(oldText != newText)//1
{ 
setText(newText);
} 

} 

} 

public void removeUpdate(final DocumentEvent p1)
    { 
theProperty.setProperty(theContainer, getText());
} 

 } 


