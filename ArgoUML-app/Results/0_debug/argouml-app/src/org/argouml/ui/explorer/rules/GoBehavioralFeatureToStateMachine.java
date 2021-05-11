
//#if 589665948 
// Compilation Unit of /GoBehavioralFeatureToStateMachine.java 
 

//#if 680199230 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1799869946 
import java.util.Collection;
//#endif 


//#if -38604727 
import java.util.Collections;
//#endif 


//#if -1067767094 
import java.util.HashSet;
//#endif 


//#if -989010404 
import java.util.Set;
//#endif 


//#if 2065472625 
import org.argouml.i18n.Translator;
//#endif 


//#if 1870088119 
import org.argouml.model.Model;
//#endif 


//#if -1160043119 
public class GoBehavioralFeatureToStateMachine extends 
//#if 6430021 
AbstractPerspectiveRule
//#endif 

  { 

//#if -178015213 
public String getRuleName()
    { 

//#if -2054918954 
return Translator.localize("misc.behavioral-feature.statemachine");
//#endif 

} 

//#endif 


//#if 105356501 
public Collection getChildren(Object parent)
    { 

//#if -175429810 
if(Model.getFacade().isABehavioralFeature(parent))//1
{ 

//#if 616348781 
return Model.getFacade().getBehaviors(parent);
//#endif 

} 

//#endif 


//#if -1244279884 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 949439919 
public Set getDependencies(Object parent)
    { 

//#if 719275850 
if(Model.getFacade().isABehavioralFeature(parent))//1
{ 

//#if -1051158490 
Set set = new HashSet();
//#endif 


//#if -1784488756 
set.add(parent);
//#endif 


//#if 926234054 
return set;
//#endif 

} 

//#endif 


//#if 80480312 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

