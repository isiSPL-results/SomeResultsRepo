
//#if -1679049347 
// Compilation Unit of /GoTransitionToTarget.java 
 

//#if 1149828455 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -85066050 
import java.util.ArrayList;
//#endif 


//#if -1297449373 
import java.util.Collection;
//#endif 


//#if -1566223104 
import java.util.Collections;
//#endif 


//#if 229802753 
import java.util.HashSet;
//#endif 


//#if -565251629 
import java.util.Set;
//#endif 


//#if -498574360 
import org.argouml.i18n.Translator;
//#endif 


//#if -1587324242 
import org.argouml.model.Model;
//#endif 


//#if 1569107587 
public class GoTransitionToTarget extends 
//#if 1621360563 
AbstractPerspectiveRule
//#endif 

  { 

//#if -524123775 
public Set getDependencies(Object parent)
    { 

//#if 213859711 
if(Model.getFacade().isATransition(parent))//1
{ 

//#if -1348268609 
Set set = new HashSet();
//#endif 


//#if 305268453 
set.add(parent);
//#endif 


//#if -258988385 
return set;
//#endif 

} 

//#endif 


//#if -1207830475 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 30080963 
public Collection getChildren(Object parent)
    { 

//#if 2085736031 
if(Model.getFacade().isATransition(parent))//1
{ 

//#if -420493562 
Collection col = new ArrayList();
//#endif 


//#if -178521961 
col.add(Model.getFacade().getTarget(parent));
//#endif 


//#if -983132947 
return col;
//#endif 

} 

//#endif 


//#if 758186261 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1287041793 
public String getRuleName()
    { 

//#if -1502784654 
return Translator.localize("misc.transition.target-state");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

