
//#if -811963663 
// Compilation Unit of /ActionNewTagDefinition.java 
 

//#if 1211451755 
package org.argouml.uml.ui.foundation.extension_mechanisms;
//#endif 


//#if 1803976794 
import java.awt.event.ActionEvent;
//#endif 


//#if -206403632 
import javax.swing.Action;
//#endif 


//#if -510053798 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1012305061 
import org.argouml.i18n.Translator;
//#endif 


//#if -425162827 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if -452451423 
import org.argouml.model.Model;
//#endif 


//#if 1847154721 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1165898512 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 187033578 

//#if 244562563 
@UmlModelMutator
//#endif 

public class ActionNewTagDefinition extends 
//#if 996436458 
UndoableAction
//#endif 

  { 

//#if -2117382281 
public void actionPerformed(ActionEvent e)
    { 

//#if 926935825 
super.actionPerformed(e);
//#endif 


//#if -929613851 
Object t = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -509424170 
Object owner = null;
//#endif 


//#if -1903444866 
Object namespace = null;
//#endif 


//#if -926629388 
if(Model.getFacade().isAStereotype(t))//1
{ 

//#if -573329585 
owner = t;
//#endif 

} 
else

//#if 1266842255 
if(Model.getFacade().isAPackage(t))//1
{ 

//#if 2007632174 
namespace = t;
//#endif 

} 
else
{ 

//#if -2036718141 
namespace = Model.getFacade().getModel(t);
//#endif 

} 

//#endif 


//#endif 


//#if -1158842751 
Object newTagDefinition = Model.getExtensionMechanismsFactory()
                                  .buildTagDefinition(
                                      (String) null,
                                      owner,
                                      namespace
                                  );
//#endif 


//#if -1914475715 
TargetManager.getInstance().setTarget(newTagDefinition);
//#endif 


//#if 2000463265 
super.actionPerformed(e);
//#endif 

} 

//#endif 


//#if 115629731 
public ActionNewTagDefinition()
    { 

//#if -858128444 
super(Translator.localize("button.new-tagdefinition"),
              ResourceLoaderWrapper.lookupIcon("button.new-tagdefinition"));
//#endif 


//#if -668303544 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("button.new-tagdefinition"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

