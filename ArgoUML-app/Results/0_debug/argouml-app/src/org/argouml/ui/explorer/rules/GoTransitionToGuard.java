
//#if -397664736 
// Compilation Unit of /GoTransitionToGuard.java 
 

//#if -1436920590 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -769134573 
import java.util.ArrayList;
//#endif 


//#if -1028737106 
import java.util.Collection;
//#endif 


//#if -1826077419 
import java.util.Collections;
//#endif 


//#if 1945290134 
import java.util.HashSet;
//#endif 


//#if -556153112 
import java.util.Set;
//#endif 


//#if 398075965 
import org.argouml.i18n.Translator;
//#endif 


//#if 2095749507 
import org.argouml.model.Model;
//#endif 


//#if -1681081784 
public class GoTransitionToGuard extends 
//#if -522856415 
AbstractPerspectiveRule
//#endif 

  { 

//#if 1500305585 
public Collection getChildren(Object parent)
    { 

//#if -2022013385 
if(Model.getFacade().isATransition(parent))//1
{ 

//#if -1203516194 
Collection col = new ArrayList();
//#endif 


//#if 1090442681 
col.add(Model.getFacade().getGuard(parent));
//#endif 


//#if -862753259 
return col;
//#endif 

} 

//#endif 


//#if 597458669 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -2016139281 
public String getRuleName()
    { 

//#if 930359160 
return Translator.localize("misc.transition.guard");
//#endif 

} 

//#endif 


//#if -665649325 
public Set getDependencies(Object parent)
    { 

//#if 344691566 
if(Model.getFacade().isATransition(parent))//1
{ 

//#if -1684049456 
Set set = new HashSet();
//#endif 


//#if -1445127306 
set.add(parent);
//#endif 


//#if -1727644688 
return set;
//#endif 

} 

//#endif 


//#if -465552412 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

