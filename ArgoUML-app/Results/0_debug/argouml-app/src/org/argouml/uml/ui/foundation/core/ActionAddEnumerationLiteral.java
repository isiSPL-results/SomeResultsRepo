
//#if 476071744 
// Compilation Unit of /ActionAddEnumerationLiteral.java 
 

//#if 1687753822 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 225422242 
import java.awt.event.ActionEvent;
//#endif 


//#if 756496914 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1592111379 
import org.argouml.i18n.Translator;
//#endif 


//#if -1049236739 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if 1941437785 
import org.argouml.model.Model;
//#endif 


//#if 1444082537 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1789972424 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1217350236 

//#if -170579896 
@UmlModelMutator
//#endif 

public class ActionAddEnumerationLiteral extends 
//#if 692094191 
UndoableAction
//#endif 

  { 

//#if 1949138208 
private static final long serialVersionUID = -1206083856173080229L;
//#endif 


//#if 1976845975 
public void actionPerformed(ActionEvent ae)
    { 

//#if -674323617 
super.actionPerformed(ae);
//#endif 


//#if -985946003 
Object target =  TargetManager.getInstance().getModelTarget();
//#endif 


//#if 533506539 
Object enumeration;
//#endif 


//#if 1597098877 
if(Model.getFacade().isAEnumeration(target))//1
{ 

//#if -304459062 
enumeration = target;
//#endif 

} 
else

//#if -2020717867 
if(Model.getFacade().isAEnumerationLiteral(target))//1
{ 

//#if -147927841 
enumeration = Model.getFacade().getEnumeration(target);
//#endif 

} 
else
{ 

//#if -644086953 
return;
//#endif 

} 

//#endif 


//#endif 


//#if -250890034 
Object oper =
            Model.getCoreFactory().buildEnumerationLiteral("anon",
                    enumeration);
//#endif 


//#if 1584456513 
TargetManager.getInstance().setTarget(oper);
//#endif 

} 

//#endif 


//#if 872765136 
public ActionAddEnumerationLiteral()
    { 

//#if 83442009 
super(Translator.localize("button.new-enumeration-literal"),
              ResourceLoaderWrapper
              .lookupIcon("button.new-enumeration-literal"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

