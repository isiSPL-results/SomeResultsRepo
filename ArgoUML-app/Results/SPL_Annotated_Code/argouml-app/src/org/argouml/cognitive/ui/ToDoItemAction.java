// Compilation Unit of /ToDoItemAction.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import javax.swing.Action;
//#endif 


//#if COGNITIVE 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.i18n.Translator;
//#endif 


//#if COGNITIVE 
import org.argouml.ui.UndoableAction;
//#endif 


//#if COGNITIVE 
public abstract class ToDoItemAction extends UndoableAction
  { 
private Object rememberedTarget = null;
public boolean isEnabled(Object target)
    { 
return target instanceof ToDoItem;
} 

protected Object getRememberedTarget()
    { 
return rememberedTarget;
} 

public void updateEnabled(Object target)
    { 
if(target == null)//1
{ 
setEnabled(false);
return;
} 

rememberedTarget = target;
setEnabled(isEnabled(target));
} 

public ToDoItemAction(String name, boolean hasIcon)
    { 
super(Translator.localize(name),
              hasIcon ? ResourceLoaderWrapper.lookupIcon(name) : null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(name));
} 

 } 

//#endif 


