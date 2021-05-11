
//#if -966625627 
// Compilation Unit of /ActionAddCreateActionInstantiation.java 
 

//#if 1418979238 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -767617609 
import java.util.ArrayList;
//#endif 


//#if -981711222 
import java.util.Collection;
//#endif 


//#if 1348938314 
import java.util.List;
//#endif 


//#if -256677407 
import org.argouml.i18n.Translator;
//#endif 


//#if 386368643 
import org.argouml.kernel.Project;
//#endif 


//#if -1597774586 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1410446041 
import org.argouml.model.Model;
//#endif 


//#if -2082011563 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if 721493457 
public class ActionAddCreateActionInstantiation extends 
//#if 131751316 
AbstractActionAddModelElement2
//#endif 

  { 

//#if -641456157 
private Object choiceClass = Model.getMetaTypes().getClassifier();
//#endif 


//#if -2113035158 
private static final long serialVersionUID = -7108663482184056359L;
//#endif 


//#if 772378850 
protected void doIt(Collection selected)
    { 

//#if -1817416824 
if(selected != null && selected.size() >= 1)//1
{ 

//#if -180884979 
Model.getCommonBehaviorHelper().setInstantiation(getTarget(),
                    selected.iterator().next());
//#endif 

} 
else
{ 

//#if -237323514 
Model.getCommonBehaviorHelper().setInstantiation(getTarget(),
                    null);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 521040107 
protected List getChoices()
    { 

//#if -881518941 
List ret = new ArrayList();
//#endif 


//#if -384254258 
if(getTarget() != null)//1
{ 

//#if 1420793502 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1791153595 
Object model = p.getRoot();
//#endif 


//#if 1973866715 
ret.addAll(Model.getModelManagementHelper()
                       .getAllModelElementsOfKindWithModel(model, choiceClass));
//#endif 

} 

//#endif 


//#if 1270155888 
return ret;
//#endif 

} 

//#endif 


//#if 1116249564 
protected String getDialogTitle()
    { 

//#if -556826859 
return Translator.localize("dialog.title.add-instantiation");
//#endif 

} 

//#endif 


//#if 1075503716 
protected List getSelected()
    { 

//#if 878296778 
List ret = new ArrayList();
//#endif 


//#if -2042676312 
Object instantiation =
            Model.getCommonBehaviorHelper().getInstantiation(getTarget());
//#endif 


//#if 1710818764 
if(instantiation != null)//1
{ 

//#if -1230658557 
ret.add(instantiation);
//#endif 

} 

//#endif 


//#if 624897769 
return ret;
//#endif 

} 

//#endif 


//#if -1554290088 
public ActionAddCreateActionInstantiation()
    { 

//#if -245124623 
super();
//#endif 


//#if 183316402 
setMultiSelect(false);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

