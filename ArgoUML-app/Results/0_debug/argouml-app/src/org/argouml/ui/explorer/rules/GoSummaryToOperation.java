
//#if -1542213763 
// Compilation Unit of /GoSummaryToOperation.java 
 

//#if 947503693 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -709162295 
import java.util.Collection;
//#endif 


//#if -509192870 
import java.util.Collections;
//#endif 


//#if 497401947 
import java.util.HashSet;
//#endif 


//#if -472191955 
import java.util.Set;
//#endif 


//#if -1250283326 
import org.argouml.i18n.Translator;
//#endif 


//#if 606448776 
import org.argouml.model.Model;
//#endif 


//#if -1799789266 
public class GoSummaryToOperation extends 
//#if 1433396969 
AbstractPerspectiveRule
//#endif 

  { 

//#if 1042654391 
public String getRuleName()
    { 

//#if 17369529 
return Translator.localize("misc.summary.operation");
//#endif 

} 

//#endif 


//#if -1711553159 
public Collection getChildren(Object parent)
    { 

//#if -1131292434 
if(parent instanceof OperationsNode)//1
{ 

//#if -427697873 
return Model.getFacade().getOperations(
                       ((OperationsNode) parent).getParent());
//#endif 

} 

//#endif 


//#if 1879944957 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1869576309 
public Set getDependencies(Object parent)
    { 

//#if -130837207 
if(parent instanceof OperationsNode)//1
{ 

//#if -1869232886 
Set set = new HashSet();
//#endif 


//#if 322559517 
set.add(((OperationsNode) parent).getParent());
//#endif 


//#if 204894122 
return set;
//#endif 

} 

//#endif 


//#if 1640707170 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

