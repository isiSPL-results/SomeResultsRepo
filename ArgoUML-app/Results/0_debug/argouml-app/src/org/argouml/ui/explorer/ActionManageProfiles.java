
//#if -561153096 
// Compilation Unit of /ActionManageProfiles.java 
 

//#if 529232676 
package org.argouml.ui.explorer;
//#endif 


//#if -1651795263 
import java.awt.event.ActionEvent;
//#endif 


//#if -2132573017 
import java.util.Iterator;
//#endif 


//#if 398591157 
import javax.swing.AbstractAction;
//#endif 


//#if 372242743 
import javax.swing.Action;
//#endif 


//#if -1591456146 
import org.argouml.application.api.GUISettingsTabInterface;
//#endif 


//#if -1286746221 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -767056428 
import org.argouml.i18n.Translator;
//#endif 


//#if -1349637673 
import org.argouml.ui.GUI;
//#endif 


//#if 1558618542 
import org.argouml.ui.ProjectSettingsDialog;
//#endif 


//#if -221377886 
import org.argouml.ui.ProjectSettingsTabProfile;
//#endif 


//#if -1930180365 
public class ActionManageProfiles extends 
//#if -1169222861 
AbstractAction
//#endif 

  { 

//#if 1085626519 
private ProjectSettingsDialog dialog;
//#endif 


//#if 30666552 
private ProjectSettingsTabProfile profilesTab;
//#endif 


//#if 1868008114 
public void actionPerformed(ActionEvent e)
    { 

//#if 343715871 
if(profilesTab == null)//1
{ 

//#if -1093754875 
Iterator iter = GUI.getInstance().getProjectSettingsTabs()
                            .iterator();
//#endif 


//#if -840902815 
while (iter.hasNext()) //1
{ 

//#if -1312293895 
GUISettingsTabInterface stp = (GUISettingsTabInterface) iter
                                              .next();
//#endif 


//#if -2061428577 
if(stp instanceof ProjectSettingsTabProfile)//1
{ 

//#if 292126436 
profilesTab = (ProjectSettingsTabProfile) stp;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 203397106 
if(dialog == null)//1
{ 

//#if 1782845252 
dialog = new ProjectSettingsDialog();
//#endif 

} 

//#endif 


//#if 69284656 
dialog.showDialog(profilesTab);
//#endif 

} 

//#endif 


//#if 360001706 
public ActionManageProfiles()
    { 

//#if 1367108102 
super(Translator.localize("action.manage-profiles"),
              ResourceLoaderWrapper.lookupIcon("action.manage-profiles"));
//#endif 


//#if -209690468 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.manage-profiles"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

