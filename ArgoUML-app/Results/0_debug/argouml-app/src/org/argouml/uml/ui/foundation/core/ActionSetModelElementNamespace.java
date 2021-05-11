
//#if -1560010555 
// Compilation Unit of /ActionSetModelElementNamespace.java 
 

//#if 1268748239 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 41442577 
import java.awt.event.ActionEvent;
//#endif 


//#if -980460982 
import org.argouml.model.Model;
//#endif 


//#if 852170445 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -1664941401 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 384020890 
public class ActionSetModelElementNamespace extends 
//#if 1961015172 
UndoableAction
//#endif 

  { 

//#if -1422540810 
public ActionSetModelElementNamespace()
    { 

//#if -1114502381 
super();
//#endif 

} 

//#endif 


//#if -859200739 
public void actionPerformed(ActionEvent e)
    { 

//#if -435472625 
Object source = e.getSource();
//#endif 


//#if -92968496 
Object oldNamespace = null;
//#endif 


//#if -1089344201 
Object newNamespace = null;
//#endif 


//#if 1777626335 
Object m = null;
//#endif 


//#if -2125490475 
if(source instanceof UMLComboBox2)//1
{ 

//#if 1254671288 
UMLComboBox2 box = (UMLComboBox2) source;
//#endif 


//#if -1813540008 
Object o = box.getTarget();
//#endif 


//#if -688546632 
if(Model.getFacade().isAModelElement(o))//1
{ 

//#if 304783306 
m =  o;
//#endif 


//#if -1416637959 
oldNamespace = Model.getFacade().getNamespace(m);
//#endif 

} 

//#endif 


//#if 1530635676 
o = box.getSelectedItem();
//#endif 


//#if -844564786 
if(Model.getFacade().isANamespace(o))//1
{ 

//#if 2135948795 
newNamespace = o;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2068341594 
if(newNamespace != oldNamespace && m != null && newNamespace != null)//1
{ 

//#if 818388338 
super.actionPerformed(e);
//#endif 


//#if 15971896 
Model.getCoreHelper().setNamespace(m, newNamespace);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

