
//#if 1519259462 
// Compilation Unit of /ActionAddPackage.java 
 

//#if 1468103696 
package org.argouml.uml.ui;
//#endif 


//#if 323191740 
import java.awt.event.ActionEvent;
//#endif 


//#if 327998521 
import org.argouml.i18n.Translator;
//#endif 


//#if 1297001343 
import org.argouml.model.Model;
//#endif 


//#if -629713021 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -457290158 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 86884388 
public class ActionAddPackage extends 
//#if 1098890929 
UndoableAction
//#endif 

  { 

//#if -1841570302 
public ActionAddPackage()
    { 

//#if 1929631967 
super(Translator.localize("action.add-package"));
//#endif 

} 

//#endif 


//#if -1085925232 
public void actionPerformed(ActionEvent e)
    { 

//#if -1695562129 
super.actionPerformed(e);
//#endif 


//#if -2090374934 
Object namespace =
            TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1611582808 
Model.getCoreHelper().addOwnedElement(namespace,
                                              Model.getModelManagementFactory().createPackage());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

