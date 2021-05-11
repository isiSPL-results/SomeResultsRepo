
//#if -1411578223 
// Compilation Unit of /GoClassToAssociatedClass.java 
 

//#if -1344383889 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1516732267 
import java.util.Collection;
//#endif 


//#if -225938184 
import java.util.Collections;
//#endif 


//#if 2052349689 
import java.util.HashSet;
//#endif 


//#if 745376203 
import java.util.Set;
//#endif 


//#if -1675517472 
import org.argouml.i18n.Translator;
//#endif 


//#if -2063704922 
import org.argouml.model.Model;
//#endif 


//#if 1906476969 
public class GoClassToAssociatedClass extends 
//#if -783815841 
AbstractPerspectiveRule
//#endif 

  { 

//#if 604922797 
public String getRuleName()
    { 

//#if -1976258077 
return Translator.localize("misc.class.associated-class");
//#endif 

} 

//#endif 


//#if 1172559983 
public Collection getChildren(Object parent)
    { 

//#if 1772095460 
if(Model.getFacade().isAClass(parent))//1
{ 

//#if 931455177 
return Model.getFacade().getAssociatedClasses(parent);
//#endif 

} 

//#endif 


//#if 1054524285 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 711739477 
public Set getDependencies(Object parent)
    { 

//#if -1768012964 
if(Model.getFacade().isAClass(parent))//1
{ 

//#if -52893961 
Set set = new HashSet();
//#endif 


//#if -1963639779 
set.add(parent);
//#endif 


//#if 877766103 
return set;
//#endif 

} 

//#endif 


//#if -855030523 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

