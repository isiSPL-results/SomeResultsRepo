// Compilation Unit of /AbstractActionRadioMenuItem.java 
 
package org.argouml.uml.diagram.ui;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.Action;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.ui.targetmanager.TargetManager;
import org.tigris.gef.undo.UndoableAction;
abstract class AbstractActionRadioMenuItem extends UndoableAction
  { 
public AbstractActionRadioMenuItem(String key, boolean hasIcon)
    { 
super(Translator.localize(key),
              hasIcon ? ResourceLoaderWrapper.lookupIcon(key) : null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(key));
} 

public final void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Iterator i = TargetManager.getInstance().getTargets().iterator();
while (i.hasNext()) //1
{ 
Object t = i.next();
toggleValueOfTarget(t);
} 

} 

abstract void toggleValueOfTarget(Object t);
abstract Object valueOfTarget(Object t);
public boolean isEnabled()
    { 
boolean result = true;
Object commonValue = null;
boolean first = true;
Iterator i = TargetManager.getInstance().getTargets().iterator();
while (i.hasNext() && result) //1
{ 
Object t = i.next();
try //1
{ 
Object value = valueOfTarget(t);
if(first)//1
{ 
commonValue = value;
first = false;
} 

result &= commonValue.equals(value);
} 
catch (IllegalArgumentException e) //1
{ 
result = false;
} 


} 

return result;
} 

 } 


