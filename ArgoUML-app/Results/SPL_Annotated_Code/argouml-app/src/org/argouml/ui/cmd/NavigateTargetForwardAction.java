// Compilation Unit of /NavigateTargetForwardAction.java 
 
package org.argouml.ui.cmd;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.ui.targetmanager.TargetManager;
class NavigateTargetForwardAction extends AbstractAction
  { 
private static final long serialVersionUID = -3426889296160732468L;
public boolean isEnabled()
    { 
return TargetManager.getInstance().navigateForwardPossible();
} 

public void actionPerformed(ActionEvent e)
    { 
TargetManager.getInstance().navigateForward();
} 

public NavigateTargetForwardAction()
    { 
super(Translator.localize("action.navigate-forward"),
              ResourceLoaderWrapper.lookupIcon("action.navigate-forward"));
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.navigate-forward"));
} 

 } 


