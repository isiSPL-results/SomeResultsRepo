// Compilation Unit of /ActionNewTagDefinition.java 
 
package org.argouml.uml.ui.foundation.extension_mechanisms;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.kernel.UmlModelMutator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.tigris.gef.undo.UndoableAction;
@UmlModelMutator
public class ActionNewTagDefinition extends UndoableAction
  { 
public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Object t = TargetManager.getInstance().getModelTarget();
Object owner = null;
Object namespace = null;
if(Model.getFacade().isAStereotype(t))//1
{ 
owner = t;
} 
else
if(Model.getFacade().isAPackage(t))//1
{ 
namespace = t;
} 
else
{ 
namespace = Model.getFacade().getModel(t);
} 


Object newTagDefinition = Model.getExtensionMechanismsFactory()
                                  .buildTagDefinition(
                                      (String) null,
                                      owner,
                                      namespace
                                  );
TargetManager.getInstance().setTarget(newTagDefinition);
super.actionPerformed(e);
} 

public ActionNewTagDefinition()
    { 
super(Translator.localize("button.new-tagdefinition"),
              ResourceLoaderWrapper.lookupIcon("button.new-tagdefinition"));
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("button.new-tagdefinition"));
} 

 } 


