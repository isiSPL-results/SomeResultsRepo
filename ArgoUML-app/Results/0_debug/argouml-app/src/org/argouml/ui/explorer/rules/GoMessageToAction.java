
//#if -1199460128 
// Compilation Unit of /GoMessageToAction.java 
 

//#if -1380438810 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -1132361569 
import java.util.ArrayList;
//#endif 


//#if 596127906 
import java.util.Collection;
//#endif 


//#if 1300097697 
import java.util.Collections;
//#endif 


//#if -1800335070 
import java.util.HashSet;
//#endif 


//#if 2010285666 
import java.util.List;
//#endif 


//#if -1874610060 
import java.util.Set;
//#endif 


//#if 1349022921 
import org.argouml.i18n.Translator;
//#endif 


//#if -127071217 
import org.argouml.model.Model;
//#endif 


//#if -1530963849 
public class GoMessageToAction extends 
//#if -782497759 
AbstractPerspectiveRule
//#endif 

  { 

//#if 1688653651 
public Set getDependencies(Object parent)
    { 

//#if -1798689273 
if(Model.getFacade().isAMessage(parent))//1
{ 

//#if 587952020 
Set set = new HashSet();
//#endif 


//#if -1923704006 
set.add(parent);
//#endif 


//#if -159654220 
return set;
//#endif 

} 

//#endif 


//#if 918755497 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1724319921 
public Collection getChildren(Object parent)
    { 

//#if -2049125508 
if(Model.getFacade().isAMessage(parent))//1
{ 

//#if 429359947 
Object action = Model.getFacade().getAction(parent);
//#endif 


//#if 747448277 
if(action != null)//1
{ 

//#if -784128183 
List children = new ArrayList();
//#endif 


//#if -791911016 
children.add(action);
//#endif 


//#if -943362586 
return children;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 752539604 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1871599599 
public String getRuleName()
    { 

//#if -689204307 
return Translator.localize("misc.message.action");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

