
//#if 797412322 
// Compilation Unit of /GoModelToNode.java 
 

//#if 910124969 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 1634890533 
import java.util.Collection;
//#endif 


//#if -857999234 
import java.util.Collections;
//#endif 


//#if -211291311 
import java.util.Set;
//#endif 


//#if -1391859482 
import org.argouml.i18n.Translator;
//#endif 


//#if 410982060 
import org.argouml.model.Model;
//#endif 


//#if 1635833410 
public class GoModelToNode extends 
//#if 848229556 
AbstractPerspectiveRule
//#endif 

  { 

//#if 947964512 
public Set getDependencies(Object parent)
    { 

//#if -1593682564 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -898820476 
public Collection getChildren(Object parent)
    { 

//#if -1028533141 
if(Model.getFacade().isAModel(parent))//1
{ 

//#if 1575132095 
return
                Model.getModelManagementHelper().getAllModelElementsOfKind(
                    parent,
                    Model.getMetaTypes().getNode());
//#endif 

} 

//#endif 


//#if 1700524903 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if 1337486274 
public String getRuleName()
    { 

//#if 1240237824 
return Translator.localize("misc.model.node");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

