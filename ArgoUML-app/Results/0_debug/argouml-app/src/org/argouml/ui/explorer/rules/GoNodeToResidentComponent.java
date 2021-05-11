
//#if 206689806 
// Compilation Unit of /GoNodeToResidentComponent.java 
 

//#if -505603491 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -52807975 
import java.util.Collection;
//#endif 


//#if -1637045430 
import java.util.Collections;
//#endif 


//#if -1852952035 
import java.util.Set;
//#endif 


//#if 1329877682 
import org.argouml.i18n.Translator;
//#endif 


//#if -928102792 
import org.argouml.model.Model;
//#endif 


//#if -1118184872 
public class GoNodeToResidentComponent extends 
//#if 86560636 
AbstractPerspectiveRule
//#endif 

  { 

//#if 1293995852 
public Collection getChildren(Object parent)
    { 

//#if -73824703 
if(Model.getFacade().isANode(parent))//1
{ 

//#if -464236212 
return Model.getFacade().getDeployedComponents(parent);
//#endif 

} 

//#endif 


//#if 2031881994 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -481905526 
public String getRuleName()
    { 

//#if -415697277 
return Translator.localize("misc.node.resident.component");
//#endif 

} 

//#endif 


//#if 833423000 
public Set getDependencies(Object parent)
    { 

//#if 1135675175 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

