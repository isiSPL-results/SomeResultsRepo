// Compilation Unit of /ActionManageProfiles.java 
 
package org.argouml.ui.explorer;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.argouml.application.api.GUISettingsTabInterface;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.ui.GUI;
import org.argouml.ui.ProjectSettingsDialog;
import org.argouml.ui.ProjectSettingsTabProfile;
public class ActionManageProfiles extends AbstractAction
  { 
private ProjectSettingsDialog dialog;
private ProjectSettingsTabProfile profilesTab;
public void actionPerformed(ActionEvent e)
    { 
if(profilesTab == null)//1
{ 
Iterator iter = GUI.getInstance().getProjectSettingsTabs()
                            .iterator();
while (iter.hasNext()) //1
{ 
GUISettingsTabInterface stp = (GUISettingsTabInterface) iter
                                              .next();
if(stp instanceof ProjectSettingsTabProfile)//1
{ 
profilesTab = (ProjectSettingsTabProfile) stp;
} 

} 

} 

if(dialog == null)//1
{ 
dialog = new ProjectSettingsDialog();
} 

dialog.showDialog(profilesTab);
} 

public ActionManageProfiles()
    { 
super(Translator.localize("action.manage-profiles"),
              ResourceLoaderWrapper.lookupIcon("action.manage-profiles"));
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.manage-profiles"));
} 

 } 


