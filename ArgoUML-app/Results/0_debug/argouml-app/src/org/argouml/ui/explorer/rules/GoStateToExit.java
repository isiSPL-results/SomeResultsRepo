
//#if 561840039 
// Compilation Unit of /GoStateToExit.java 
 

//#if 1623326218 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -185661957 
import java.util.ArrayList;
//#endif 


//#if -120955194 
import java.util.Collection;
//#endif 


//#if 545358077 
import java.util.Collections;
//#endif 


//#if -2116668034 
import java.util.HashSet;
//#endif 


//#if 310471376 
import java.util.Set;
//#endif 


//#if 2124469797 
import org.argouml.i18n.Translator;
//#endif 


//#if 417626987 
import org.argouml.model.Model;
//#endif 


//#if 165977285 
public class GoStateToExit extends 
//#if 160208400 
AbstractPerspectiveRule
//#endif 

  { 

//#if -857761568 
public Collection getChildren(Object parent)
    { 

//#if 902721852 
if(Model.getFacade().isAState(parent)
                && Model.getFacade().getExit(parent) != null)//1
{ 

//#if 78900239 
Collection children = new ArrayList();
//#endif 


//#if -1958087055 
children.add(Model.getFacade().getExit(parent));
//#endif 


//#if 1639672928 
return children;
//#endif 

} 

//#endif 


//#if -1298002790 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1260862076 
public Set getDependencies(Object parent)
    { 

//#if -889094213 
if(Model.getFacade().isAState(parent))//1
{ 

//#if -1128431968 
Set set = new HashSet();
//#endif 


//#if -1826484154 
set.add(parent);
//#endif 


//#if 1125584064 
return set;
//#endif 

} 

//#endif 


//#if -1141785473 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1574118942 
public String getRuleName()
    { 

//#if 1702267611 
return Translator.localize("misc.state.exit");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

