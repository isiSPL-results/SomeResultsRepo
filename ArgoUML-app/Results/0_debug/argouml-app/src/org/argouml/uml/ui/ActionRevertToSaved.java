
//#if -407644410 
// Compilation Unit of /ActionRevertToSaved.java 
 

//#if -929155723 
package org.argouml.uml.ui;
//#endif 


//#if 535518903 
import java.awt.event.ActionEvent;
//#endif 


//#if -2091195277 
import java.io.File;
//#endif 


//#if 1587657090 
import java.text.MessageFormat;
//#endif 


//#if -1709061973 
import javax.swing.AbstractAction;
//#endif 


//#if -1089525204 
import javax.swing.JOptionPane;
//#endif 


//#if -1679794018 
import org.argouml.i18n.Translator;
//#endif 


//#if -1322106330 
import org.argouml.kernel.Project;
//#endif 


//#if -2049304061 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1811964095 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if -881165466 
import org.argouml.util.ArgoFrame;
//#endif 


//#if -741603058 
public class ActionRevertToSaved extends 
//#if 756374329 
AbstractAction
//#endif 

  { 

//#if -908102455 
public ActionRevertToSaved()
    { 

//#if 355850900 
super(Translator.localize("action.revert-to-saved"));
//#endif 

} 

//#endif 


//#if -1312148116 
public void actionPerformed(ActionEvent e)
    { 

//#if -1587140738 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 211689288 
if(p == null
                || !ProjectBrowser.getInstance().getSaveAction().isEnabled())//1
{ 

//#if -1865955013 
return;
//#endif 

} 

//#endif 


//#if 269848909 
String message =
            MessageFormat.format(
                Translator.localize(
                    "optionpane.revert-to-saved-confirm"),
                new Object[] {
                    p.getName(),
                });
//#endif 


//#if 1791596267 
int response =
            JOptionPane.showConfirmDialog(
                ArgoFrame.getInstance(),
                message,
                Translator.localize(
                    "optionpane.revert-to-saved-confirm-title"),
                JOptionPane.YES_NO_OPTION);
//#endif 


//#if 1511741472 
if(response == JOptionPane.YES_OPTION)//1
{ 

//#if -1523934619 
ProjectBrowser.getInstance().loadProjectWithProgressMonitor(
                new File(p.getURI()), true);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

