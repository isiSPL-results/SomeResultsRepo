package org.argouml.uml.diagram.ui;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.Action;
import org.argouml.i18n.Translator;
import org.argouml.ui.targetmanager.TargetManager;
import org.tigris.gef.undo.UndoableAction;
abstract class AbstractActionCheckBoxMenuItem extends UndoableAction
  { 
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
public AbstractActionCheckBoxMenuItem(String key)
    { 
super(Translator.localize(key), null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(key));
} 
public boolean isEnabled()
    { 
boolean result = true;
boolean commonValue = true;
boolean first = true;
Iterator i = TargetManager.getInstance().getTargets().iterator();
while (i.hasNext() && result) //1
{ 
Object t = i.next();
try//1
{ 
boolean value = valueOfTarget(t);
if(first)//1
{ 
commonValue = value;
first = false;
} 
result &= (commonValue == value);
} 
catch (IllegalArgumentException e) //1
{ 
result = false;
} 
} 
return result;
} 
abstract void toggleValueOfTarget(Object t);abstract boolean valueOfTarget(Object t);
 } 
