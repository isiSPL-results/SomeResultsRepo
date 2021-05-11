
//#if -1657025901 
// Compilation Unit of /ActionAddAttribute.java 
 

//#if -1242339335 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 2095762855 
import java.awt.event.ActionEvent;
//#endif 


//#if -1223986659 
import javax.swing.Action;
//#endif 


//#if 1607204077 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -556871762 
import org.argouml.i18n.Translator;
//#endif 


//#if 238137622 
import org.argouml.kernel.Project;
//#endif 


//#if -2141389549 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -2113587198 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if 1242997108 
import org.argouml.model.Model;
//#endif 


//#if -882199007 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -1935018809 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if -1839502482 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1440644413 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -869028251 

//#if -297679469 
@UmlModelMutator
//#endif 

public class ActionAddAttribute extends 
//#if 2050619642 
UndoableAction
//#endif 

  { 

//#if -1211106832 
private static ActionAddAttribute targetFollower;
//#endif 


//#if -701866444 
private static final long serialVersionUID = -111785878370086329L;
//#endif 


//#if 1134588642 
public void actionPerformed(ActionEvent ae)
    { 

//#if 1647885120 
super.actionPerformed(ae);
//#endif 


//#if 1963621430 
Object target = TargetManager.getInstance().getSingleModelTarget();
//#endif 


//#if 1645215440 
Object classifier = null;
//#endif 


//#if -255200013 
if(Model.getFacade().isAClassifier(target)
                || Model.getFacade().isAAssociationEnd(target))//1
{ 

//#if 1247409762 
classifier = target;
//#endif 

} 
else

//#if -1497204705 
if(Model.getFacade().isAFeature(target))//1
{ 

//#if -41858783 
classifier = Model.getFacade().getOwner(target);
//#endif 

} 
else
{ 

//#if -322989493 
return;
//#endif 

} 

//#endif 


//#endif 


//#if -1854765692 
Project project = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -2108066530 
Object attrType = project.getDefaultAttributeType();
//#endif 


//#if 1149183141 
Object attr =
            Model.getCoreFactory().buildAttribute2(
                classifier,
                attrType);
//#endif 


//#if -599884859 
TargetManager.getInstance().setTarget(attr);
//#endif 

} 

//#endif 


//#if -749889736 
public static ActionAddAttribute getTargetFollower()
    { 

//#if -1577957584 
if(targetFollower == null)//1
{ 

//#if 85486842 
targetFollower  = new ActionAddAttribute();
//#endif 


//#if -940649971 
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


//#if -516242906 
targetFollower.setEnabled(targetFollower.shouldBeEnabled());
//#endif 

} 

//#endif 


//#if 359431075 
return targetFollower;
//#endif 

} 

//#endif 


//#if 2052749395 
public boolean shouldBeEnabled()
    { 

//#if -1732184322 
Object target = TargetManager.getInstance().getSingleModelTarget();
//#endif 


//#if 2121802858 
if(target == null)//1
{ 

//#if 467119918 
return false;
//#endif 

} 

//#endif 


//#if 940255586 
return Model.getFacade().isAClassifier(target)
               || Model.getFacade().isAFeature(target)
               || Model.getFacade().isAAssociationEnd(target);
//#endif 

} 

//#endif 


//#if 1320913121 
public ActionAddAttribute()
    { 

//#if -754127347 
super(Translator.localize("button.new-attribute"),
              ResourceLoaderWrapper.lookupIcon("button.new-attribute"));
//#endif 


//#if -937801490 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("button.new-attribute"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

