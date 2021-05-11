
//#if -975960683 
// Compilation Unit of /GoModelElementToContents.java 
 

//#if 926940340 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1435290096 
import java.util.Collection;
//#endif 


//#if 1544321811 
import java.util.Collections;
//#endif 


//#if -1360156012 
import java.util.HashSet;
//#endif 


//#if -929375514 
import java.util.Set;
//#endif 


//#if -867080261 
import org.argouml.i18n.Translator;
//#endif 


//#if -1650898943 
import org.argouml.model.Model;
//#endif 


//#if -474637737 
public class GoModelElementToContents extends 
//#if 39972817 
AbstractPerspectiveRule
//#endif 

  { 

//#if 1991840671 
public String getRuleName()
    { 

//#if -2140307713 
return Translator.localize("misc.model-element.contents");
//#endif 

} 

//#endif 


//#if 1675912289 
public Collection getChildren(Object parent)
    { 

//#if 1238710621 
if(Model.getFacade().isAModelElement(parent))//1
{ 

//#if 882487929 
return Model.getFacade().getModelElementContents(parent);
//#endif 

} 

//#endif 


//#if -1201403499 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 478056867 
public Set getDependencies(Object parent)
    { 

//#if 79085557 
Set set = new HashSet();
//#endif 


//#if 1534748584 
if(Model.getFacade().isAModelElement(parent))//1
{ 

//#if -409745962 
set.add(parent);
//#endif 


//#if 385511413 
set.addAll(Model.getFacade().getModelElementContents(parent));
//#endif 

} 

//#endif 


//#if 62719061 
return set;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

