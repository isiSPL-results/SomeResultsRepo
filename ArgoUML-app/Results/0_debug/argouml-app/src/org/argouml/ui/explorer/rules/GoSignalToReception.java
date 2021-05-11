
//#if -1068858389 
// Compilation Unit of /GoSignalToReception.java 
 

//#if 430446133 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1042129073 
import java.util.Collection;
//#endif 


//#if -2053735310 
import java.util.Collections;
//#endif 


//#if -885705869 
import java.util.HashSet;
//#endif 


//#if -2037404859 
import java.util.Set;
//#endif 


//#if -1375296038 
import org.argouml.i18n.Translator;
//#endif 


//#if -1935118944 
import org.argouml.model.Model;
//#endif 


//#if -1897368740 
public class GoSignalToReception extends 
//#if 887671398 
AbstractPerspectiveRule
//#endif 

  { 

//#if 586390772 
public String getRuleName()
    { 

//#if -486083976 
return Translator.localize("Signal->Reception");
//#endif 

} 

//#endif 


//#if 206807990 
public Collection getChildren(Object parent)
    { 

//#if 2068575690 
if(Model.getFacade().isASignal(parent))//1
{ 

//#if -1656690754 
return Model.getFacade().getReceptions(parent);
//#endif 

} 

//#endif 


//#if -22960083 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1309579886 
public Set getDependencies(Object parent)
    { 

//#if 2095556405 
if(Model.getFacade().isASignal(parent))//1
{ 

//#if 408756839 
Set set = new HashSet();
//#endif 


//#if 1765846925 
set.add(parent);
//#endif 


//#if -1084986041 
return set;
//#endif 

} 

//#endif 


//#if -1995480872 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

