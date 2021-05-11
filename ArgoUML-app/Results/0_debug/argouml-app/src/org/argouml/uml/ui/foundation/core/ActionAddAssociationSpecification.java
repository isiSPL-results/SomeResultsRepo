
//#if -598443821 
// Compilation Unit of /ActionAddAssociationSpecification.java 
 

//#if -129193847 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -54789868 
import java.util.ArrayList;
//#endif 


//#if -358887731 
import java.util.Collection;
//#endif 


//#if 81191117 
import java.util.List;
//#endif 


//#if 1786355774 
import org.argouml.i18n.Translator;
//#endif 


//#if -794653050 
import org.argouml.kernel.Project;
//#endif 


//#if -164814429 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1134544380 
import org.argouml.model.Model;
//#endif 


//#if 797272306 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if 50912169 
public class ActionAddAssociationSpecification extends 
//#if -221891317 
AbstractActionAddModelElement2
//#endif 

  { 

//#if -1133962296 
private static final ActionAddAssociationSpecification SINGLETON =
        new ActionAddAssociationSpecification();
//#endif 


//#if -212669931 
protected ActionAddAssociationSpecification()
    { 

//#if 1900128557 
super();
//#endif 

} 

//#endif 


//#if -1692813941 
protected void doIt(Collection selected)
    { 

//#if -1689959500 
Model.getCoreHelper().setSpecifications(getTarget(), selected);
//#endif 

} 

//#endif 


//#if -548234709 
public static ActionAddAssociationSpecification getInstance()
    { 

//#if -1317769853 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 1234373979 
protected List getSelected()
    { 

//#if -924254785 
List ret = new ArrayList();
//#endif 


//#if -104862680 
ret.addAll(Model.getFacade().getSpecifications(getTarget()));
//#endif 


//#if 1928054228 
return ret;
//#endif 

} 

//#endif 


//#if -1829139692 
protected List getChoices()
    { 

//#if 1182114846 
List ret = new ArrayList();
//#endif 


//#if -836116301 
if(getTarget() != null)//1
{ 

//#if 1275750829 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 604137676 
Object model = p.getRoot();
//#endif 


//#if -1331635161 
ret.addAll(Model.getModelManagementHelper()
                       .getAllModelElementsOfKindWithModel(model,
                               Model.getMetaTypes().getClassifier()));
//#endif 

} 

//#endif 


//#if -1131073259 
return ret;
//#endif 

} 

//#endif 


//#if -1256737467 
protected String getDialogTitle()
    { 

//#if 497912815 
return Translator.localize("dialog.title.add-specifications");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

