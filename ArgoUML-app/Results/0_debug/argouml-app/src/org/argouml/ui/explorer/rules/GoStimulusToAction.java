
//#if 547165537 
// Compilation Unit of /GoStimulusToAction.java 
 

//#if 924624475 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1032480330 
import java.util.ArrayList;
//#endif 


//#if -1013249961 
import java.util.Collection;
//#endif 


//#if -1345975924 
import java.util.Collections;
//#endif 


//#if 119233933 
import java.util.HashSet;
//#endif 


//#if -905776545 
import java.util.Set;
//#endif 


//#if 1727690612 
import org.argouml.i18n.Translator;
//#endif 


//#if -383181766 
import org.argouml.model.Model;
//#endif 


//#if 173688449 
public class GoStimulusToAction extends 
//#if -1371136154 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1169182220 
public String getRuleName()
    { 

//#if 388854950 
return Translator.localize("misc.stimulus.action");
//#endif 

} 

//#endif 


//#if 1525004470 
public Collection getChildren(Object parent)
    { 

//#if 2123286122 
if(!Model.getFacade().isAStimulus(parent))//1
{ 

//#if -485368332 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -2143700089 
Object ms = parent;
//#endif 


//#if 1432786934 
Object action = Model.getFacade().getDispatchAction(ms);
//#endif 


//#if 1974523119 
Collection result = new ArrayList();
//#endif 


//#if -140767054 
result.add(action);
//#endif 


//#if 328673792 
return result;
//#endif 

} 

//#endif 


//#if -1111710354 
public Set getDependencies(Object parent)
    { 

//#if -1153877846 
if(Model.getFacade().isAStimulus(parent))//1
{ 

//#if -334129150 
Set set = new HashSet();
//#endif 


//#if -1766708568 
set.add(parent);
//#endif 


//#if -774170462 
return set;
//#endif 

} 

//#endif 


//#if 1031775547 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

