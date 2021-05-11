
//#if -1821391823 
// Compilation Unit of /GoInteractionToMessages.java 
 

//#if -1493740965 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 412922967 
import java.util.Collection;
//#endif 


//#if -84288116 
import java.util.Collections;
//#endif 


//#if 223949197 
import java.util.HashSet;
//#endif 


//#if -1605712289 
import java.util.Set;
//#endif 


//#if -385922188 
import org.argouml.i18n.Translator;
//#endif 


//#if 918024250 
import org.argouml.model.Model;
//#endif 


//#if 187599555 
public class GoInteractionToMessages extends 
//#if 1555508838 
AbstractPerspectiveRule
//#endif 

  { 

//#if -886327698 
public Set getDependencies(Object parent)
    { 

//#if -1647888005 
if(Model.getFacade().isAInteraction(parent))//1
{ 

//#if 292424424 
Set set = new HashSet();
//#endif 


//#if -1370226546 
set.add(parent);
//#endif 


//#if 1702155016 
return set;
//#endif 

} 

//#endif 


//#if -1153115936 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1866923788 
public String getRuleName()
    { 

//#if 169884488 
return Translator.localize("misc.interaction.messages");
//#endif 

} 

//#endif 


//#if -1429141578 
public Collection getChildren(Object parent)
    { 

//#if 1170593461 
if(Model.getFacade().isAInteraction(parent))//1
{ 

//#if -1352432914 
return Model.getFacade().getMessages(parent);
//#endif 

} 

//#endif 


//#if -1891458586 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

