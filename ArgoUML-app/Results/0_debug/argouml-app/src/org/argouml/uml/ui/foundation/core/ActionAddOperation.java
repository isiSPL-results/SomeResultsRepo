
//#if -1084713124 
// Compilation Unit of /ActionAddOperation.java 
 

//#if 63508576 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -896678560 
import java.awt.event.ActionEvent;
//#endif 


//#if 1509569238 
import javax.swing.Action;
//#endif 


//#if 1377106324 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1166724885 
import org.argouml.i18n.Translator;
//#endif 


//#if 1540663503 
import org.argouml.kernel.Project;
//#endif 


//#if 1283429178 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 976578235 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if 705719387 
import org.argouml.model.Model;
//#endif 


//#if 950089242 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -975157714 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if -1947086553 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 235842550 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1178899817 

//#if 567624852 
@UmlModelMutator
//#endif 

public class ActionAddOperation extends 
//#if -151829445 
UndoableAction
//#endif 

  { 

//#if 1388480262 
private static ActionAddOperation targetFollower;
//#endif 


//#if -2095270167 
private static final long serialVersionUID = -1383845502957256177L;
//#endif 


//#if 681000675 
public void actionPerformed(ActionEvent ae)
    { 

//#if 1887418585 
super.actionPerformed(ae);
//#endif 


//#if -434814069 
Project project = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 86529511 
Object target =  TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1109373161 
Object classifier = null;
//#endif 


//#if -163647531 
if(Model.getFacade().isAClassifier(target))//1
{ 

//#if 25569267 
classifier = target;
//#endif 

} 
else

//#if 1132994793 
if(Model.getFacade().isAFeature(target))//1
{ 

//#if 1777528798 
classifier = Model.getFacade().getOwner(target);
//#endif 

} 
else
{ 

//#if -1727450269 
return;
//#endif 

} 

//#endif 


//#endif 


//#if -892079634 
Object returnType = project.getDefaultReturnType();
//#endif 


//#if 1094631405 
Object oper =
            Model.getCoreFactory().buildOperation(classifier, returnType);
//#endif 


//#if -1978053061 
TargetManager.getInstance().setTarget(oper);
//#endif 

} 

//#endif 


//#if -1227665492 
public static ActionAddOperation getTargetFollower()
    { 

//#if -1070411905 
if(targetFollower == null)//1
{ 

//#if 1344159875 
targetFollower  = new ActionAddOperation();
//#endif 


//#if -1129440167 
TargetManager.getInstance().addTargetListener(new TargetListener() {
                public void targetAdded(TargetEvent e) {
                    setTarget();
                }
                public void targetRemoved(TargetEvent e) {
                    setTarget();
                }

                public void targetSet(TargetEvent e) {
                    setTarget();
                }
                private void setTarget() {
                    targetFollower.setEnabled(targetFollower.shouldBeEnabled());
                }
            });
//#endif 


//#if 963998834 
targetFollower.setEnabled(targetFollower.shouldBeEnabled());
//#endif 

} 

//#endif 


//#if 1871784754 
return targetFollower;
//#endif 

} 

//#endif 


//#if -1974165843 
public ActionAddOperation()
    { 

//#if -11578362 
super(Translator.localize("button.new-operation"),
              ResourceLoaderWrapper.lookupIcon("button.new-operation"));
//#endif 


//#if 275718144 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("button.new-operation"));
//#endif 

} 

//#endif 


//#if -1539366508 
public boolean shouldBeEnabled()
    { 

//#if -757924341 
Object target = TargetManager.getInstance().getSingleModelTarget();
//#endif 


//#if -1870481347 
if(target == null)//1
{ 

//#if -2010377445 
return false;
//#endif 

} 

//#endif 


//#if 619116066 
return Model.getFacade().isAClassifier(target)
               || Model.getFacade().isAFeature(target);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

