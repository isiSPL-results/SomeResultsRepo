
//#if 1275808506 
// Compilation Unit of /GoModelToCollaboration.java 
 

//#if -753497118 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 921218851 
import java.util.ArrayList;
//#endif 


//#if -167388514 
import java.util.Collection;
//#endif 


//#if -894074843 
import java.util.Collections;
//#endif 


//#if 290002702 
import java.util.Iterator;
//#endif 


//#if -1134142114 
import java.util.List;
//#endif 


//#if 379261432 
import java.util.Set;
//#endif 


//#if 261281613 
import org.argouml.i18n.Translator;
//#endif 


//#if 102060179 
import org.argouml.model.Model;
//#endif 


//#if -1433648450 
public class GoModelToCollaboration extends 
//#if -1393402543 
AbstractPerspectiveRule
//#endif 

  { 

//#if -347835935 
public Collection getChildren(Object parent)
    { 

//#if -948671033 
if(Model.getFacade().isAModel(parent))//1
{ 

//#if -979220510 
Collection col =
                Model.getModelManagementHelper().getAllModelElementsOfKind(
                    parent,
                    Model.getMetaTypes().getCollaboration());
//#endif 


//#if -280647125 
List returnList = new ArrayList();
//#endif 


//#if 2065754963 
Iterator it = col.iterator();
//#endif 


//#if -761255101 
while (it.hasNext()) //1
{ 

//#if 1744148864 
Object collab = it.next();
//#endif 


//#if 1835685074 
if(Model.getFacade().getRepresentedClassifier(collab) == null
                        && Model.getFacade().getRepresentedOperation(collab)
                        == null)//1
{ 

//#if 506430494 
returnList.add(collab);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1334067068 
return returnList;
//#endif 

} 

//#endif 


//#if 1745835147 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -464161757 
public Set getDependencies(Object parent)
    { 

//#if -823729663 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 


//#if -1092345569 
public String getRuleName()
    { 

//#if -1062060225 
return Translator.localize("misc.model.collaboration");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

