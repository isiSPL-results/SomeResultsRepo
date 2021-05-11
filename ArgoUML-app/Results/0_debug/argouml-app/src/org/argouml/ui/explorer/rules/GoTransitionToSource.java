
//#if -1332385864 
// Compilation Unit of /GoTransitionToSource.java 
 

//#if 362850984 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1321078813 
import java.util.ArrayList;
//#endif 


//#if -656631580 
import java.util.Collection;
//#endif 


//#if 1119259295 
import java.util.Collections;
//#endif 


//#if 1522884640 
import java.util.HashSet;
//#endif 


//#if -1906100622 
import java.util.Set;
//#endif 


//#if -153313721 
import org.argouml.i18n.Translator;
//#endif 


//#if -2114083699 
import org.argouml.model.Model;
//#endif 


//#if -1891133682 
public class GoTransitionToSource extends 
//#if -199258005 
AbstractPerspectiveRule
//#endif 

  { 

//#if -1249089079 
public Set getDependencies(Object parent)
    { 

//#if 1368282452 
if(Model.getFacade().isATransition(parent))//1
{ 

//#if 360600061 
Set set = new HashSet();
//#endif 


//#if -1167779293 
set.add(parent);
//#endif 


//#if 879362141 
return set;
//#endif 

} 

//#endif 


//#if 168151882 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -275712583 
public String getRuleName()
    { 

//#if 2050697742 
return Translator.localize("misc.transition.source-state");
//#endif 

} 

//#endif 


//#if 1979241083 
public Collection getChildren(Object parent)
    { 

//#if 1316596782 
if(Model.getFacade().isATransition(parent))//1
{ 

//#if -1951278052 
Collection col = new ArrayList();
//#endif 


//#if -657722441 
col.add(Model.getFacade().getSource(parent));
//#endif 


//#if 953359255 
return col;
//#endif 

} 

//#endif 


//#if -947452764 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

