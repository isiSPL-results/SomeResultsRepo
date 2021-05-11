
//#if 578792703 
// Compilation Unit of /UMLTextField2.java 
 

//#if 277139370 
package org.argouml.uml.ui;
//#endif 


//#if 646755928 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -966724304 
import java.beans.PropertyChangeListener;
//#endif 


//#if -24981973 
import javax.swing.JTextField;
//#endif 


//#if 381738793 
import org.argouml.ui.LookAndFeelMgr;
//#endif 


//#if 370421996 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if 392894016 
import org.argouml.ui.targetmanager.TargettableModelView;
//#endif 


//#if -1567745078 
public class UMLTextField2 extends 
//#if 762125326 
JTextField
//#endif 

 implements 
//#if -1347851580 
PropertyChangeListener
//#endif 

, 
//#if -226726692 
TargettableModelView
//#endif 

  { 

//#if -363894791 
private static final long serialVersionUID = -5740838103900828073L;
//#endif 


//#if -1810093984 
public void propertyChange(PropertyChangeEvent evt)
    { 

//#if 1378836921 
((UMLDocument) getDocument()).propertyChange(evt);
//#endif 

} 

//#endif 


//#if -1289233910 
public TargetListener getTargettableModel()
    { 

//#if 289888101 
return (UMLDocument) getDocument();
//#endif 

} 

//#endif 


//#if 660687421 
public UMLTextField2(UMLDocument doc)
    { 

//#if 729578900 
super(doc, null, 0);
//#endif 


//#if -150494548 
setFont(LookAndFeelMgr.getInstance().getStandardFont());
//#endif 


//#if -241713897 
addCaretListener(ActionCopy.getInstance());
//#endif 


//#if -1819083392 
addCaretListener(ActionCut.getInstance());
//#endif 


//#if 1983636561 
addCaretListener(ActionPaste.getInstance());
//#endif 


//#if 439552806 
addFocusListener(ActionPaste.getInstance());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

