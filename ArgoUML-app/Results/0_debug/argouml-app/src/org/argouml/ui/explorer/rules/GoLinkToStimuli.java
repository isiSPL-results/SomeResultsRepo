
//#if -511604976 
// Compilation Unit of /GoLinkToStimuli.java 
 

//#if 1553556470 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 2065693618 
import java.util.Collection;
//#endif 


//#if -388005487 
import java.util.Collections;
//#endif 


//#if 852729874 
import java.util.HashSet;
//#endif 


//#if -396148892 
import java.util.Set;
//#endif 


//#if -1650911303 
import org.argouml.i18n.Translator;
//#endif 


//#if 1103406847 
import org.argouml.model.Model;
//#endif 


//#if 1270255335 
public class GoLinkToStimuli extends 
//#if -1325030759 
AbstractPerspectiveRule
//#endif 

  { 

//#if -186911447 
public Collection getChildren(Object parent)
    { 

//#if -1649723577 
if(!Model.getFacade().isALink(parent))//1
{ 

//#if -309910729 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 859757226 
return Model.getFacade().getStimuli(parent);
//#endif 

} 

//#endif 


//#if 188429415 
public String getRuleName()
    { 

//#if 1445246879 
return Translator.localize("misc.link.stimuli");
//#endif 

} 

//#endif 


//#if -1716128293 
public Set getDependencies(Object parent)
    { 

//#if 1632923839 
if(Model.getFacade().isALink(parent))//1
{ 

//#if -281348780 
Set set = new HashSet();
//#endif 


//#if -1414594310 
set.add(parent);
//#endif 


//#if 1099142260 
return set;
//#endif 

} 

//#endif 


//#if -671791984 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

