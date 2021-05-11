
//#if 362932098 
// Compilation Unit of /GoModelElementToBehavior.java 
 

//#if -57734474 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1945309810 
import java.util.Collection;
//#endif 


//#if 175063761 
import java.util.Collections;
//#endif 


//#if -621412014 
import java.util.HashSet;
//#endif 


//#if -1989656412 
import java.util.Set;
//#endif 


//#if -467474183 
import org.argouml.i18n.Translator;
//#endif 


//#if 1047074879 
import org.argouml.model.Model;
//#endif 


//#if 1106483217 
public class GoModelElementToBehavior extends 
//#if 985521383 
AbstractPerspectiveRule
//#endif 

  { 

//#if -995919881 
public Collection getChildren(Object parent)
    { 

//#if 1516437359 
if(Model.getFacade().isAModelElement(parent))//1
{ 

//#if -22889187 
return Model.getFacade().getBehaviors(parent);
//#endif 

} 

//#endif 


//#if -917500761 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 130945845 
public String getRuleName()
    { 

//#if 1319723304 
return Translator.localize("misc.model-element.behavior");
//#endif 

} 

//#endif 


//#if 800331213 
public Set getDependencies(Object parent)
    { 

//#if 1314717509 
if(Model.getFacade().isAModelElement(parent))//1
{ 

//#if -236419594 
Set set = new HashSet();
//#endif 


//#if 208810652 
set.add(parent);
//#endif 


//#if 2053973910 
return set;
//#endif 

} 

//#endif 


//#if 319542141 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

