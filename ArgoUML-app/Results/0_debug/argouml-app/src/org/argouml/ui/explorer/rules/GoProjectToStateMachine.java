
//#if -162489513 
// Compilation Unit of /GoProjectToStateMachine.java 
 

//#if 941465850 
package org.argouml.ui.explorer.rules;
//#endif 


//#if 343660811 
import java.util.ArrayList;
//#endif 


//#if -891818570 
import java.util.Collection;
//#endif 


//#if -1876570099 
import java.util.Collections;
//#endif 


//#if -995243552 
import java.util.Set;
//#endif 


//#if -34498251 
import org.argouml.i18n.Translator;
//#endif 


//#if -1269032273 
import org.argouml.kernel.Project;
//#endif 


//#if 816924283 
import org.argouml.model.Model;
//#endif 


//#if -2118447115 
public class GoProjectToStateMachine extends 
//#if -1248795003 
AbstractPerspectiveRule
//#endif 

  { 

//#if 436546899 
public String getRuleName()
    { 

//#if 551925521 
return Translator.localize("misc.project.state-machine");
//#endif 

} 

//#endif 


//#if 1028560405 
public Collection getChildren(Object parent)
    { 

//#if 1323166811 
Collection col = new ArrayList();
//#endif 


//#if 1588215981 
if(parent instanceof Project)//1
{ 

//#if -579044101 
for (Object model : ((Project) parent).getUserDefinedModelList()) //1
{ 

//#if -979003357 
col.addAll(Model.getModelManagementHelper()
                           .getAllModelElementsOfKind(model,
                                                      Model.getMetaTypes().getStateMachine()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -934384200 
return col;
//#endif 

} 

//#endif 


//#if -1386947473 
public Set getDependencies(Object parent)
    { 

//#if -1961233885 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

