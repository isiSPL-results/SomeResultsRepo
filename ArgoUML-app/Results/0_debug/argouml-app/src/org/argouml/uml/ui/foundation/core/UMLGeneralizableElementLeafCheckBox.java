
//#if 158690571 
// Compilation Unit of /UMLGeneralizableElementLeafCheckBox.java 
 

//#if -1514956844 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -169997687 
import org.argouml.i18n.Translator;
//#endif 


//#if 630424015 
import org.argouml.model.Model;
//#endif 


//#if -1536142824 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if -1187557883 
public class UMLGeneralizableElementLeafCheckBox extends 
//#if -357837661 
UMLCheckBox2
//#endif 

  { 

//#if -1034928223 
public void buildModel()
    { 

//#if 820935339 
Object target = getTarget();
//#endif 


//#if -993728917 
if(target != null && Model.getFacade().isAUMLElement(target))//1
{ 

//#if 1770407075 
setSelected(Model.getFacade().isLeaf(target));
//#endif 

} 
else
{ 

//#if -407301579 
setSelected(false);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 792773838 
public UMLGeneralizableElementLeafCheckBox()
    { 

//#if -1253059659 
super(Translator.localize("checkbox.leaf-lc"),
              ActionSetGeneralizableElementLeaf.getInstance(), "isLeaf");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

