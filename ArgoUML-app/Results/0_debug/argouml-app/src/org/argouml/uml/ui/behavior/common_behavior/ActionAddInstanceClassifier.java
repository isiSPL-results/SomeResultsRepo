
//#if -1828826258 
// Compilation Unit of /ActionAddInstanceClassifier.java 
 

//#if -371679 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 799378652 
import java.util.ArrayList;
//#endif 


//#if 350532613 
import java.util.Collection;
//#endif 


//#if 1008865285 
import java.util.List;
//#endif 


//#if -979964922 
import org.argouml.i18n.Translator;
//#endif 


//#if -1438078530 
import org.argouml.kernel.Project;
//#endif 


//#if -1899726997 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1967827404 
import org.argouml.model.Model;
//#endif 


//#if 629681850 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if 1314386757 
public class ActionAddInstanceClassifier extends 
//#if -1073413789 
AbstractActionAddModelElement2
//#endif 

  { 

//#if -2011967566 
private Object choiceClass = Model.getMetaTypes().getClassifier();
//#endif 


//#if 34981299 
protected List getSelected()
    { 

//#if -1499355429 
List ret = new ArrayList();
//#endif 


//#if 2028435664 
ret.addAll(Model.getFacade().getClassifiers(getTarget()));
//#endif 


//#if -1622507720 
return ret;
//#endif 

} 

//#endif 


//#if -1989326100 
public ActionAddInstanceClassifier(Object choice)
    { 

//#if -1801986097 
super();
//#endif 


//#if -1099887260 
choiceClass = choice;
//#endif 

} 

//#endif 


//#if 1952465089 
@Override
    protected void doIt(Collection selected)
    { 

//#if 1926381182 
Model.getCommonBehaviorHelper().setClassifiers(getTarget(), selected);
//#endif 

} 

//#endif 


//#if -1884130323 
protected String getDialogTitle()
    { 

//#if -1797336936 
return Translator.localize("dialog.title.add-specifications");
//#endif 

} 

//#endif 


//#if 764569532 
protected List getChoices()
    { 

//#if 80279093 
List ret = new ArrayList();
//#endif 


//#if -633286276 
if(getTarget() != null)//1
{ 

//#if -662122815 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1363820232 
Object model = p.getRoot();
//#endif 


//#if -1033097922 
ret.addAll(Model.getModelManagementHelper()
                       .getAllModelElementsOfKindWithModel(model, choiceClass));
//#endif 

} 

//#endif 


//#if 712197534 
return ret;
//#endif 

} 

//#endif 


//#if -1066391252 
public ActionAddInstanceClassifier()
    { 

//#if -173419622 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

