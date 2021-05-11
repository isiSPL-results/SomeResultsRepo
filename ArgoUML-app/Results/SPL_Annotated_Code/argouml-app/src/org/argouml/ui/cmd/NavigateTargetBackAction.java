// Compilation Unit of /NavigateTargetBackAction.java 
 
package org.argouml.ui.cmd;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.ui.targetmanager.TargetManager;
class NavigateTargetBackAction extends AbstractAction
  { 
private static final long serialVersionUID = 33340548502483040L;
public NavigateTargetBackAction()
    { 
super(Translator.localize("action.navigate-back"),
              ResourceLoaderWrapper.lookupIcon("action.navigate-back"));
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.navigate-back"));
} 

public boolean isEnabled()
    { 
return TargetManager.getInstance().navigateBackPossible();
} 

public void actionPerformed(ActionEvent e)
    { 
TargetManager.getInstance().navigateBackward();
} 

 } 


