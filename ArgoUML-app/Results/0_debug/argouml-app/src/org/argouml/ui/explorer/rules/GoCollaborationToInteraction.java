
//#if -1619597198 
// Compilation Unit of /GoCollaborationToInteraction.java 
 

//#if -891233563 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -67927711 
import java.util.Collection;
//#endif 


//#if -2105757246 
import java.util.Collections;
//#endif 


//#if -408252221 
import java.util.HashSet;
//#endif 


//#if -127389547 
import java.util.Set;
//#endif 


//#if 413376298 
import org.argouml.i18n.Translator;
//#endif 


//#if -388591888 
import org.argouml.model.Model;
//#endif 


//#if 1607974002 
public class GoCollaborationToInteraction extends 
//#if -2021619154 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1458155098 
public Set getDependencies(Object parent)
    { 

//#if 1552180876 
if(Model.getFacade().isACollaboration(parent))//1
{ 

//#if -1806878491 
Set set = new HashSet();
//#endif 


//#if -1790200565 
set.add(parent);
//#endif 


//#if 2071521605 
return set;
//#endif 

} 

//#endif 


//#if 2006854210 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 781879996 
public String getRuleName()
    { 

//#if 1319453822 
return Translator.localize("misc.collaboration.interaction");
//#endif 

} 

//#endif 


//#if 1396048254 
public Collection getChildren(Object parent)
    { 

//#if 1176844884 
if(!Model.getFacade().isACollaboration(parent))//1
{ 

//#if 445709986 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -83193234 
return Model.getFacade().getInteractions(parent);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

