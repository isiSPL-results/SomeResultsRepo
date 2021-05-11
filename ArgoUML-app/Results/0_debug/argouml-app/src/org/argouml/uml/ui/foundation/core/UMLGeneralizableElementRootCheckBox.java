
//#if 1941961126 
// Compilation Unit of /UMLGeneralizableElementRootCheckBox.java 
 

//#if -509327548 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 158149113 
import org.argouml.i18n.Translator;
//#endif 


//#if 1560009023 
import org.argouml.model.Model;
//#endif 


//#if 327301512 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -1673665799 
public class UMLGeneralizableElementRootCheckBox extends 
//#if 2089405835 
UMLCheckBox2
//#endif 

  { 

//#if -530958711 
public void buildModel()
    { 

//#if -1237294718 
Object target = getTarget();
//#endif 


//#if 1670486068 
if(target != null && Model.getFacade().isAUMLElement(target))//1
{ 

//#if 1961041591 
setSelected(Model.getFacade().isRoot(target));
//#endif 

} 
else
{ 

//#if -1478558243 
setSelected(false);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -135824534 
public UMLGeneralizableElementRootCheckBox()
    { 

//#if -693080901 
super(Translator.localize("checkbox.root-lc"),
              ActionSetGeneralizableElementRoot.getInstance(), "isRoot");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

