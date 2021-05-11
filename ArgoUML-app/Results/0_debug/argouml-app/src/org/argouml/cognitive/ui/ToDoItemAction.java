
//#if 1401665104 
// Compilation Unit of /ToDoItemAction.java 
 

//#if 39332340 
package org.argouml.cognitive.ui;
//#endif 


//#if 646050900 
import javax.swing.Action;
//#endif 


//#if -1597286570 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1437930648 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 995220311 
import org.argouml.i18n.Translator;
//#endif 


//#if 716583827 
import org.argouml.ui.UndoableAction;
//#endif 


//#if -2010096616 
public abstract class ToDoItemAction extends 
//#if -748472404 
UndoableAction
//#endif 

  { 

//#if 1042936062 
private Object rememberedTarget = null;
//#endif 


//#if -1796383551 
public boolean isEnabled(Object target)
    { 

//#if -1631772537 
return target instanceof ToDoItem;
//#endif 

} 

//#endif 


//#if 1013161823 
protected Object getRememberedTarget()
    { 

//#if 674966992 
return rememberedTarget;
//#endif 

} 

//#endif 


//#if -966115980 
public void updateEnabled(Object target)
    { 

//#if 490756612 
if(target == null)//1
{ 

//#if 415941699 
setEnabled(false);
//#endif 


//#if 1448165140 
return;
//#endif 

} 

//#endif 


//#if 528213841 
rememberedTarget = target;
//#endif 


//#if 353832215 
setEnabled(isEnabled(target));
//#endif 

} 

//#endif 


//#if -1961458490 
public ToDoItemAction(String name, boolean hasIcon)
    { 

//#if 2137874061 
super(Translator.localize(name),
              hasIcon ? ResourceLoaderWrapper.lookupIcon(name) : null);
//#endif 


//#if 1919579281 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(name));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

