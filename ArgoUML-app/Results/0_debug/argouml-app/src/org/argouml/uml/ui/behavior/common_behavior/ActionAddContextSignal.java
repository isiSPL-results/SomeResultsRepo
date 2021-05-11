
//#if 1101840400 
// Compilation Unit of /ActionAddContextSignal.java 
 

//#if -658619597 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if -103146102 
import java.util.ArrayList;
//#endif 


//#if -1857930985 
import java.util.Collection;
//#endif 


//#if -1710929257 
import java.util.List;
//#endif 


//#if 1623125684 
import org.argouml.i18n.Translator;
//#endif 


//#if -320913511 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -62180486 
import org.argouml.model.Model;
//#endif 


//#if 1134090984 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if 1495806138 
public class ActionAddContextSignal extends 
//#if -952980115 
AbstractActionAddModelElement2
//#endif 

  { 

//#if 1849313571 
protected String getDialogTitle()
    { 

//#if 1142131003 
return Translator.localize("dialog.title.add-contexts");
//#endif 

} 

//#endif 


//#if 642619981 
public ActionAddContextSignal()
    { 

//#if -554115265 
super();
//#endif 

} 

//#endif 


//#if 790093170 
protected List getChoices()
    { 

//#if -938197742 
List ret = new ArrayList();
//#endif 


//#if -523819542 
Object model =
            ProjectManager.getManager().getCurrentProject().getModel();
//#endif 


//#if -2141297089 
if(getTarget() != null)//1
{ 

//#if -1368272 
ret.addAll(Model.getModelManagementHelper()
                       .getAllBehavioralFeatures(model));
//#endif 

} 

//#endif 


//#if -538109023 
return ret;
//#endif 

} 

//#endif 


//#if 826214077 
protected List getSelected()
    { 

//#if -1645224252 
List ret = new ArrayList();
//#endif 


//#if -513755239 
ret.addAll(Model.getFacade().getContexts(getTarget()));
//#endif 


//#if 34775215 
return ret;
//#endif 

} 

//#endif 


//#if -2039911703 
protected void doIt(Collection selected)
    { 

//#if -41756098 
Model.getCommonBehaviorHelper().setContexts(getTarget(), selected);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

