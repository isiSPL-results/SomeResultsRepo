// Compilation Unit of /ActionPageSetup.java 
 
package org.argouml.ui.cmd;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
class ActionPageSetup extends AbstractAction
  { 
public void actionPerformed(ActionEvent ae)
    { 
PrintManager.getInstance().showPageSetupDialog();
} 

public ActionPageSetup()
    { 
super(Translator.localize("action.page-setup"),
              ResourceLoaderWrapper.lookupIcon("action.page-setup"));
} 

 } 


