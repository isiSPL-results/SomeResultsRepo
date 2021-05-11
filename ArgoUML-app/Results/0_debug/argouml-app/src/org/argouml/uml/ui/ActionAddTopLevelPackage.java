
//#if -370360046 
// Compilation Unit of /ActionAddTopLevelPackage.java 
 

//#if -1335510642 
package org.argouml.uml.ui;
//#endif 


//#if 2053422206 
import java.awt.event.ActionEvent;
//#endif 


//#if 563161076 
import javax.swing.Action;
//#endif 


//#if -1869431881 
import org.argouml.i18n.Translator;
//#endif 


//#if 195796973 
import org.argouml.kernel.Project;
//#endif 


//#if -1365770660 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -155452931 
import org.argouml.model.Model;
//#endif 


//#if -284973804 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1920176183 
public class ActionAddTopLevelPackage extends 
//#if -1819358026 
UndoableAction
//#endif 

  { 

//#if -2075405410 
public void actionPerformed(ActionEvent ae)
    { 

//#if 1980231577 
super.actionPerformed(ae);
//#endif 


//#if 1671660948 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -623998655 
int numPacks = p.getUserDefinedModelList().size();
//#endif 


//#if 538556106 
String nameStr = "package_" + (numPacks + 1);
//#endif 


//#if 338183152 
Object model = Model.getModelManagementFactory().createModel();
//#endif 


//#if -159213991 
Model.getCoreHelper().setName(model, nameStr);
//#endif 


//#if 1871618142 
p.addMember(model);
//#endif 


//#if 1703146521 
super.actionPerformed(ae);
//#endif 


//#if 1530777314 
new ActionClassDiagram().actionPerformed(ae);
//#endif 

} 

//#endif 


//#if -1916192936 
public ActionAddTopLevelPackage()
    { 

//#if -756863402 
super(Translator.localize("action.add-top-level-package"), null);
//#endif 


//#if -1644580215 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.add-top-level-package"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

