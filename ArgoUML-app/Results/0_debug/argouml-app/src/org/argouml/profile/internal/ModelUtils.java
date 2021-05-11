
//#if 1570194786 
// Compilation Unit of /ModelUtils.java 
 

//#if -915661220 
package org.argouml.profile.internal;
//#endif 


//#if 1915102258 
import java.util.Collection;
//#endif 


//#if -1217941889 
import org.argouml.model.Model;
//#endif 


//#if 886643633 
public class ModelUtils  { 

//#if 1511767949 
public static Object findTypeInModel(String s, Object model)
    { 

//#if -1836731265 
if(!Model.getFacade().isANamespace(model))//1
{ 

//#if 389461367 
throw new IllegalArgumentException(
                "Looking for the classifier " + s
                + " in a non-namespace object of " + model
                + ". A namespace was expected.");
//#endif 

} 

//#endif 


//#if -991199050 
Collection allClassifiers =
            Model.getModelManagementHelper()
            .getAllModelElementsOfKind(model,
                                       Model.getMetaTypes().getClassifier());
//#endif 


//#if -251448769 
for (Object classifier : allClassifiers) //1
{ 

//#if 799627308 
if(Model.getFacade().getName(classifier) != null
                    && Model.getFacade().getName(classifier).equals(s))//1
{ 

//#if -359151880 
return classifier;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -388689937 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

