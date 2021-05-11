
//#if -168543027 
// Compilation Unit of /UMLGeneralizableElementAbstractCheckBox.java 
 

//#if -646945403 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -499640006 
import org.argouml.i18n.Translator;
//#endif 


//#if 2002424064 
import org.argouml.model.Model;
//#endif 


//#if -1563320247 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -1689315974 
public class UMLGeneralizableElementAbstractCheckBox extends 
//#if -1668345139 
UMLCheckBox2
//#endif 

  { 

//#if 2125519912 
public UMLGeneralizableElementAbstractCheckBox()
    { 

//#if 865976827 
super(Translator.localize("checkbox.abstract-lc"),
              ActionSetGeneralizableElementAbstract.getInstance(),
              "isAbstract");
//#endif 

} 

//#endif 


//#if -2059185845 
public void buildModel()
    { 

//#if 448347809 
Object target = getTarget();
//#endif 


//#if -1821675851 
if(target != null && Model.getFacade().isAUMLElement(target))//1
{ 

//#if -430100536 
setSelected(Model.getFacade().isAbstract(target));
//#endif 

} 
else
{ 

//#if -632149641 
setSelected(false);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

