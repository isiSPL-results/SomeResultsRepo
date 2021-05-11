
//#if -1160583074 
// Compilation Unit of /GoTransitiontoEffect.java 
 

//#if -1374749704 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -233475891 
import java.util.ArrayList;
//#endif 


//#if -1603187148 
import java.util.Collection;
//#endif 


//#if 1840807759 
import java.util.Collections;
//#endif 


//#if 618474704 
import java.util.HashSet;
//#endif 


//#if -599991518 
import java.util.Set;
//#endif 


//#if -337621257 
import org.argouml.i18n.Translator;
//#endif 


//#if -195744451 
import org.argouml.model.Model;
//#endif 


//#if 1268584884 
public class GoTransitiontoEffect extends 
//#if 1489140720 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1222175746 
public String getRuleName()
    { 

//#if -499001195 
return Translator.localize("misc.transition.effect");
//#endif 

} 

//#endif 


//#if -144980288 
public Collection getChildren(Object parent)
    { 

//#if -1637327162 
if(Model.getFacade().isATransition(parent))//1
{ 

//#if 350951576 
Object effect = Model.getFacade().getEffect(parent);
//#endif 


//#if 897695091 
if(effect != null)//1
{ 

//#if -1244992608 
Collection col = new ArrayList();
//#endif 


//#if 462724480 
col.add(effect);
//#endif 


//#if 1249989267 
return col;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 900050236 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1344168868 
public Set getDependencies(Object parent)
    { 

//#if 123409512 
if(Model.getFacade().isATransition(parent))//1
{ 

//#if 1949032486 
Set set = new HashSet();
//#endif 


//#if 89793740 
set.add(parent);
//#endif 


//#if 1946320326 
return set;
//#endif 

} 

//#endif 


//#if 651290462 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

