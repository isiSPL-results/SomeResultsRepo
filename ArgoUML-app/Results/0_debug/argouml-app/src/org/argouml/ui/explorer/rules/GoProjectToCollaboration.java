
//#if 845480714 
// Compilation Unit of /GoProjectToCollaboration.java 
 

//#if -715490987 
package org.argouml.ui.explorer.rules;
//#endif 


//#if -93148272 
import java.util.ArrayList;
//#endif 


//#if -1547998255 
import java.util.Collection;
//#endif 


//#if -743303854 
import java.util.Collections;
//#endif 


//#if -641713069 
import java.util.HashSet;
//#endif 


//#if 1455563813 
import java.util.Set;
//#endif 


//#if -1199302982 
import org.argouml.i18n.Translator;
//#endif 


//#if -59680630 
import org.argouml.kernel.Project;
//#endif 


//#if -1035907456 
import org.argouml.model.Model;
//#endif 


//#if 880594881 
public class GoProjectToCollaboration extends 
//#if -1798206139 
AbstractPerspectiveRule
//#endif 

  { 

//#if -2017784619 
public Collection getChildren(Object parent)
    { 

//#if -616840312 
Collection col = new ArrayList();
//#endif 


//#if 1577537312 
if(parent instanceof Project)//1
{ 

//#if 1644942582 
for (Object model : ((Project) parent).getUserDefinedModelList()) //1
{ 

//#if -913707386 
col.addAll(Model.getModelManagementHelper()
                           .getAllModelElementsOfKind(model,
                                                      Model.getMetaTypes().getCollaboration()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -353438805 
return col;
//#endif 

} 

//#endif 


//#if 733422611 
public String getRuleName()
    { 

//#if 374044665 
return Translator.localize("misc.project.collaboration");
//#endif 

} 

//#endif 


//#if 693755311 
public Set getDependencies(Object parent)
    { 

//#if 733843915 
if(parent instanceof Project)//1
{ 

//#if -134578901 
Set set = new HashSet();
//#endif 


//#if -2044588975 
set.add(parent);
//#endif 


//#if 77311243 
return set;
//#endif 

} 

//#endif 


//#if -1437087617 
return Collections.EMPTY_SET;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

