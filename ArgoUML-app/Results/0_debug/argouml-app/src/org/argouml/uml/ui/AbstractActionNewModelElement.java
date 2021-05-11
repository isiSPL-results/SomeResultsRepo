
//#if 1219213695 
// Compilation Unit of /AbstractActionNewModelElement.java 
 

//#if -1672599695 
package org.argouml.uml.ui;
//#endif 


//#if 2076307889 
import javax.swing.Action;
//#endif 


//#if -1059474215 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1335060838 
import org.argouml.i18n.Translator;
//#endif 


//#if 34738070 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if -705997615 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1124332491 

//#if -393078186 
@UmlModelMutator
//#endif 

public abstract class AbstractActionNewModelElement extends 
//#if 1460576893 
UndoableAction
//#endif 

  { 

//#if 1725119345 
private Object target;
//#endif 


//#if -196261279 
public void setTarget(Object theTarget)
    { 

//#if -1417613551 
target = theTarget;
//#endif 

} 

//#endif 


//#if 360291223 
public Object getTarget()
    { 

//#if 1442059742 
return target;
//#endif 

} 

//#endif 


//#if -195838217 
protected AbstractActionNewModelElement()
    { 

//#if -401627637 
super(Translator.localize("action.new"), null);
//#endif 


//#if -909698636 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.new"));
//#endif 

} 

//#endif 


//#if 2138347195 
protected AbstractActionNewModelElement(String name)
    { 

//#if -716071065 
super(Translator.localize(name),
              ResourceLoaderWrapper.lookupIcon(name));
//#endif 


//#if -586902346 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(name));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

