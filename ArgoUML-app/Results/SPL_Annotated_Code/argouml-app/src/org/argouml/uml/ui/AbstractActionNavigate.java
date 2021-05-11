// Compilation Unit of /AbstractActionNavigate.java 
 
package org.argouml.uml.ui;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.Icon;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetListener;
import org.argouml.ui.targetmanager.TargetManager;
import org.tigris.gef.undo.UndoableAction;
public abstract class AbstractActionNavigate extends UndoableAction
 implements TargetListener
  { 
public boolean isEnabled()
    { 
Object target = TargetManager.getInstance().getModelTarget();
return ((target != null) && (navigateTo(target) != null));
} 

public void targetAdded(TargetEvent e)
    { 
setEnabled(isEnabled());
} 

public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
Object target = TargetManager.getInstance().getModelTarget();
if(Model.getFacade().isAUMLElement(target))//1
{ 
Object elem = target;
Object nav = navigateTo(elem);
if(nav != null)//1
{ 
TargetManager.getInstance().setTarget(nav);
} 

} 

} 

public void targetRemoved(TargetEvent e)
    { 
setEnabled(isEnabled());
} 

public AbstractActionNavigate()
    { 
this("button.go-up", true);
} 

protected abstract Object navigateTo(Object source);
public void targetSet(TargetEvent e)
    { 
setEnabled(isEnabled());
} 

public AbstractActionNavigate(String key, boolean hasIcon)
    { 
super(Translator.localize(key),
              hasIcon ? ResourceLoaderWrapper.lookupIcon(key) : null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(key));
putValue(Action.SMALL_ICON,
                 ResourceLoaderWrapper.lookupIconResource("NavigateUp"));
} 

public AbstractActionNavigate setIcon(Icon newIcon)
    { 
putValue(Action.SMALL_ICON, newIcon);
return this;
} 

 } 


