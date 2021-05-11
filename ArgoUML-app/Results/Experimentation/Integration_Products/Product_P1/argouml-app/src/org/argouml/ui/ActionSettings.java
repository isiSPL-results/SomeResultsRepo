package org.argouml.ui;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.util.ArgoDialog;
public class ActionSettings extends AbstractAction
  { 
private ArgoDialog dialog;
private static final long serialVersionUID = -3646595772633674514L;
public ActionSettings()
    { 
super(Translator.localize("action.settings"),
              ResourceLoaderWrapper.lookupIcon("action.settings"));
} 
public void actionPerformed(ActionEvent event)
    { 
if(dialog == null)//1
{ 
dialog = new SettingsDialog();
} 
dialog.setVisible(true);
} 

 } 
