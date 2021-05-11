// Compilation Unit of /ActionProjectSettings.java 
 
package org.argouml.ui;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
public class ActionProjectSettings extends AbstractAction
  { 
private static ProjectSettingsDialog dialog;
public void actionPerformed(ActionEvent e)
    { 
if(dialog == null)//1
{ 
dialog = new ProjectSettingsDialog();
} 

dialog.showDialog();
} 

public ActionProjectSettings()
    { 
super(Translator.localize("action.properties"),
              ResourceLoaderWrapper.lookupIcon("action.properties"));
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.properties"));
} 

 } 


