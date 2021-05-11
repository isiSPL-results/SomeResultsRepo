
//#if -1317164625 
// Compilation Unit of /GoModelElementToComment.java 
 

//#if -668819555 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1711885337 
import java.util.Collection;
//#endif 


//#if 1528839690 
import java.util.Collections;
//#endif 


//#if 2018476299 
import java.util.HashSet;
//#endif 


//#if 559973597 
import java.util.Set;
//#endif 


//#if 1949226354 
import org.argouml.i18n.Translator;
//#endif 


//#if 650651960 
import org.argouml.model.Model;
//#endif 


//#if 1137295673 
public class GoModelElementToComment extends 
//#if -1149689810 
AbstractPerspectiveRule
//#endif 

  { 

//#if 1316296574 
public Collection getChildren(Object parent)
    { 

//#if 1235948874 
if(Model.getFacade().isAModelElement(parent))//1
{ 

//#if -1302351275 
return Model.getFacade().getComments(parent);
//#endif 

} 

//#endif 


//#if -2079629822 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1187356860 
public String getRuleName()
    { 

//#if 2133764246 
return Translator.localize("misc.model-element.comment");
//#endif 

} 

//#endif 


//#if 2115959718 
public Set getDependencies(Object parent)
    { 

//#if -1354927754 
if(Model.getFacade().isAModelElement(parent))//1
{ 

//#if -1691481872 
Set set = new HashSet();
//#endif 


//#if 898908822 
set.add(parent);
//#endif 


//#if 1785805584 
return set;
//#endif 

} 

//#endif 


//#if 1905035310 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

