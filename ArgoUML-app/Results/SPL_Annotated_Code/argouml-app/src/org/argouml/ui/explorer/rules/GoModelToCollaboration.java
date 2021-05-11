// Compilation Unit of /GoModelToCollaboration.java 
 

//#if COLLABORATION 
package org.argouml.ui.explorer.rules;
//#endif 


//#if COLLABORATION 
import java.util.ArrayList;
//#endif 


//#if COLLABORATION 
import java.util.Collection;
//#endif 


//#if COLLABORATION 
import java.util.Collections;
//#endif 


//#if COLLABORATION 
import java.util.Iterator;
//#endif 


//#if COLLABORATION 
import java.util.List;
//#endif 


//#if COLLABORATION 
import java.util.Set;
//#endif 


//#if COLLABORATION 
import org.argouml.i18n.Translator;
//#endif 


//#if COLLABORATION 
import org.argouml.model.Model;
//#endif 


//#if COLLABORATION 
public class GoModelToCollaboration extends AbstractPerspectiveRule
  { 
public Collection getChildren(Object parent)
    { 
if(Model.getFacade().isAModel(parent))//1
{ 
Collection col =
                Model.getModelManagementHelper().getAllModelElementsOfKind(
                    parent,
                    Model.getMetaTypes().getCollaboration());
List returnList = new ArrayList();
Iterator it = col.iterator();
while (it.hasNext()) //1
{ 
Object collab = it.next();
if(Model.getFacade().getRepresentedClassifier(collab) == null
                        && Model.getFacade().getRepresentedOperation(collab)
                        == null)//1
{ 
returnList.add(collab);
} 

} 

return returnList;
} 

return Collections.EMPTY_SET;
} 

public Set getDependencies(Object parent)
    { 
return Collections.EMPTY_SET;
} 

public String getRuleName()
    { 
return Translator.localize("misc.model.collaboration");
} 

 } 

//#endif 


