package org.argouml.uml.ui;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.apache.log4j.Logger;
import org.argouml.i18n.Translator;
import org.argouml.ui.LookAndFeelMgr;
import org.argouml.ui.targetmanager.TargetListener;
import org.argouml.ui.targetmanager.TargettableModelView;
public class UMLExpressionBodyField extends JTextArea
 implements DocumentListener
,UMLUserInterfaceComponent
,PropertyChangeListener
,TargettableModelView
  { 
private static final Logger LOG =
        Logger.getLogger(UMLExpressionBodyField.class);
private UMLExpressionModel2 model;
private boolean notifyModel;
public void insertUpdate(final DocumentEvent p1)
    { 
model.setBody(getText());
} 
public UMLExpressionBodyField(UMLExpressionModel2 expressionModel,
                                  boolean notify)
    { 
model = expressionModel;
notifyModel = notify;
getDocument().addDocumentListener(this);
setToolTipText(Translator.localize("label.body.tooltip"));
setFont(LookAndFeelMgr.getInstance().getStandardFont());
setRows(2);
} 
public void propertyChange(PropertyChangeEvent event)
    { 
LOG.debug("UMLExpressionBodyField: propertySet" + event);
update();
} 
public void removeUpdate(final DocumentEvent p1)
    { 
model.setBody(getText());
} 
public void targetReasserted()
    { 
} 
private void update()
    { 
String oldText = getText();
String newText = model.getBody();
if(oldText == null || newText == null || !oldText.equals(newText))//1
{ 
if(oldText != newText)//1
{ 
setText(newText);
} 
} 
} 
public TargetListener getTargettableModel()
    { 
return model;
} 
public void changedUpdate(final DocumentEvent p1)
    { 
model.setBody(getText());
} 
public void targetChanged()
    { 
LOG.debug("UMLExpressionBodyField: targetChanged");
if(notifyModel)//1
{ 
model.targetChanged();
} 
update();
} 

 } 
