
//#if 1286728072 
// Compilation Unit of /UMLClassActiveCheckBox.java 
 

//#if 887858539 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 244096800 
import org.argouml.i18n.Translator;
//#endif 


//#if -990250522 
import org.argouml.model.Model;
//#endif 


//#if -469449937 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -599422641 
public class UMLClassActiveCheckBox extends 
//#if 1150980130 
UMLCheckBox2
//#endif 

  { 

//#if 2046182910 
public UMLClassActiveCheckBox()
    { 

//#if -1767129919 
super(Translator.localize("checkbox.active-lc"),
              ActionSetClassActive.getInstance(), "isActive");
//#endif 

} 

//#endif 


//#if -154802080 
public void buildModel()
    { 

//#if 1782778915 
if(getTarget() != null)//1
{ 

//#if 970073382 
setSelected(Model.getFacade().isActive(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

