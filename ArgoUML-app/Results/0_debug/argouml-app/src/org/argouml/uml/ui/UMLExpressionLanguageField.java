
//#if -174464635 
// Compilation Unit of /UMLExpressionLanguageField.java 
 

//#if 850615121 
package org.argouml.uml.ui;
//#endif 


//#if -988787420 
import javax.swing.JTextField;
//#endif 


//#if 547499556 
import javax.swing.event.DocumentEvent;
//#endif 


//#if 1319164388 
import javax.swing.event.DocumentListener;
//#endif 


//#if 1875896954 
import org.argouml.i18n.Translator;
//#endif 


//#if 632178192 
import org.argouml.ui.LookAndFeelMgr;
//#endif 


//#if -1960278754 
public class UMLExpressionLanguageField extends 
//#if -1654460651 
JTextField
//#endif 

 implements 
//#if -1812213247 
DocumentListener
//#endif 

, 
//#if 304058897 
UMLUserInterfaceComponent
//#endif 

  { 

//#if 522651894 
private UMLExpressionModel2 model;
//#endif 


//#if -307246830 
private boolean notifyModel;
//#endif 


//#if 1818626543 
private void update()
    { 

//#if -1701936390 
String oldText = getText();
//#endif 


//#if -1861324741 
String newText = model.getLanguage();
//#endif 


//#if 1815644781 
if(oldText == null || newText == null || !oldText.equals(newText))//1
{ 

//#if 816204400 
if(oldText != newText)//1
{ 

//#if 1362107550 
setText(newText);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1663021285 
public void changedUpdate(final DocumentEvent p1)
    { 

//#if -983964370 
model.setLanguage(getText());
//#endif 

} 

//#endif 


//#if 412114321 
public UMLExpressionLanguageField(UMLExpressionModel2 expressionModel,
                                      boolean notify)
    { 

//#if -1216454611 
model = expressionModel;
//#endif 


//#if 1295640550 
notifyModel = notify;
//#endif 


//#if -1871174605 
getDocument().addDocumentListener(this);
//#endif 


//#if 532374124 
setToolTipText(Translator.localize("label.language.tooltip"));
//#endif 


//#if -1824702683 
setFont(LookAndFeelMgr.getInstance().getStandardFont());
//#endif 

} 

//#endif 


//#if 152439893 
public void targetChanged()
    { 

//#if -1509147719 
if(notifyModel)//1
{ 

//#if 1889015426 
model.targetChanged();
//#endif 

} 

//#endif 


//#if 74825621 
update();
//#endif 

} 

//#endif 


//#if -241988871 
public void targetReasserted()
    { 
} 

//#endif 


//#if 214585832 
public void insertUpdate(final DocumentEvent p1)
    { 

//#if -1848521565 
model.setLanguage(getText());
//#endif 

} 

//#endif 


//#if -45270733 
public void removeUpdate(final DocumentEvent p1)
    { 

//#if -591830875 
model.setLanguage(getText());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

