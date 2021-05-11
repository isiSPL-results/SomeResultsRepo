
//#if 2097506995 
// Compilation Unit of /UMLExpressionBodyField.java 
 

//#if 835203328 
package org.argouml.uml.ui;
//#endif 


//#if -1832893630 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1230784518 
import java.beans.PropertyChangeListener;
//#endif 


//#if -576604102 
import javax.swing.JTextArea;
//#endif 


//#if 833680723 
import javax.swing.event.DocumentEvent;
//#endif 


//#if 1432227925 
import javax.swing.event.DocumentListener;
//#endif 


//#if 473054460 
import org.apache.log4j.Logger;
//#endif 


//#if 1711776041 
import org.argouml.i18n.Translator;
//#endif 


//#if 1825770751 
import org.argouml.ui.LookAndFeelMgr;
//#endif 


//#if 331247682 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if 461503766 
import org.argouml.ui.targetmanager.TargettableModelView;
//#endif 


//#if -460119419 
public class UMLExpressionBodyField extends 
//#if 90214336 
JTextArea
//#endif 

 implements 
//#if 301340051 
DocumentListener
//#endif 

, 
//#if 937636543 
UMLUserInterfaceComponent
//#endif 

, 
//#if 1666824541 
PropertyChangeListener
//#endif 

, 
//#if -286159435 
TargettableModelView
//#endif 

  { 

//#if -1118024362 
private static final Logger LOG =
        Logger.getLogger(UMLExpressionBodyField.class);
//#endif 


//#if -551819128 
private UMLExpressionModel2 model;
//#endif 


//#if -2141176284 
private boolean notifyModel;
//#endif 


//#if -1474140550 
public void insertUpdate(final DocumentEvent p1)
    { 

//#if 1617502756 
model.setBody(getText());
//#endif 

} 

//#endif 


//#if -166569063 
public UMLExpressionBodyField(UMLExpressionModel2 expressionModel,
                                  boolean notify)
    { 

//#if 1916635450 
model = expressionModel;
//#endif 


//#if 864100857 
notifyModel = notify;
//#endif 


//#if 1959134208 
getDocument().addDocumentListener(this);
//#endif 


//#if 781067075 
setToolTipText(Translator.localize("label.body.tooltip"));
//#endif 


//#if -839654158 
setFont(LookAndFeelMgr.getInstance().getStandardFont());
//#endif 


//#if 919471355 
setRows(2);
//#endif 

} 

//#endif 


//#if 1371320098 
public void propertyChange(PropertyChangeEvent event)
    { 

//#if 913990359 
LOG.debug("UMLExpressionBodyField: propertySet" + event);
//#endif 


//#if -923609541 
update();
//#endif 

} 

//#endif 


//#if -1733997115 
public void removeUpdate(final DocumentEvent p1)
    { 

//#if -1956488290 
model.setBody(getText());
//#endif 

} 

//#endif 


//#if -1711602805 
public void targetReasserted()
    { 
} 

//#endif 


//#if -1830599395 
private void update()
    { 

//#if 1426957968 
String oldText = getText();
//#endif 


//#if -581382841 
String newText = model.getBody();
//#endif 


//#if -152367977 
if(oldText == null || newText == null || !oldText.equals(newText))//1
{ 

//#if -414228099 
if(oldText != newText)//1
{ 

//#if -1741965298 
setText(newText);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1082256081 
public TargetListener getTargettableModel()
    { 

//#if 714172346 
return model;
//#endif 

} 

//#endif 


//#if 852110995 
public void changedUpdate(final DocumentEvent p1)
    { 

//#if -1518094662 
model.setBody(getText());
//#endif 

} 

//#endif 


//#if 786017539 
public void targetChanged()
    { 

//#if 726989163 
LOG.debug("UMLExpressionBodyField: targetChanged");
//#endif 


//#if 1045015820 
if(notifyModel)//1
{ 

//#if -553050769 
model.targetChanged();
//#endif 

} 

//#endif 


//#if 744158434 
update();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

