
//#if -97281443 
// Compilation Unit of /ArgoStatusBar.java 
 

//#if 1098120887 
package org.argouml.ui;
//#endif 


//#if -443479382 
import java.text.MessageFormat;
//#endif 


//#if -326090673 
import javax.swing.SwingUtilities;
//#endif 


//#if 251566548 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -673080319 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 102806781 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if -1898527575 
import org.argouml.application.events.ArgoHelpEventListener;
//#endif 


//#if -2045822418 
import org.argouml.application.events.ArgoStatusEvent;
//#endif 


//#if 797542618 
import org.argouml.application.events.ArgoStatusEventListener;
//#endif 


//#if -1963795002 
import org.argouml.i18n.Translator;
//#endif 


//#if -712550639 
import org.tigris.gef.ui.IStatusBar;
//#endif 


//#if 894096236 
public class ArgoStatusBar extends 
//#if -397221306 
StatusBar
//#endif 

 implements 
//#if 1098236275 
IStatusBar
//#endif 

, 
//#if 1075996616 
ArgoStatusEventListener
//#endif 

, 
//#if 2011716569 
ArgoHelpEventListener
//#endif 

  { 

//#if 1634730627 
public void helpRemoved(ArgoHelpEvent e)
    { 

//#if 1488584535 
showStatusOnSwingThread("");
//#endif 

} 

//#endif 


//#if -158562835 
public void statusCleared(ArgoStatusEvent e)
    { 

//#if 530579885 
showStatusOnSwingThread("");
//#endif 

} 

//#endif 


//#if 845683313 
public void projectSaved(ArgoStatusEvent e)
    { 

//#if 1753809328 
String status = MessageFormat.format(
                            Translator.localize("statusmsg.bar.save-project-status-wrote"),
                            new Object[] {e.getText()});
//#endif 


//#if 176037841 
showStatusOnSwingThread(status);
//#endif 

} 

//#endif 


//#if 1667877402 
private void showStatusOnSwingThread(final String status)
    { 

//#if -351254472 
SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                showStatus(status);
            }
        });
//#endif 

} 

//#endif 


//#if -422668443 
public ArgoStatusBar()
    { 

//#if 200549154 
super();
//#endif 


//#if -455939950 
ArgoEventPump.addListener(ArgoEventTypes.ANY_HELP_EVENT, this);
//#endif 


//#if 1473902337 
ArgoEventPump.addListener(ArgoEventTypes.ANY_STATUS_EVENT, this);
//#endif 

} 

//#endif 


//#if 273687767 
public void helpChanged(ArgoHelpEvent e)
    { 

//#if -367186887 
showStatusOnSwingThread(e.getHelpText());
//#endif 

} 

//#endif 


//#if -525976047 
public void projectLoaded(ArgoStatusEvent e)
    { 

//#if 981142196 
String status = MessageFormat.format(
                            Translator.localize("statusmsg.bar.open-project-status-read"),
                            new Object[] {e.getText()});
//#endif 


//#if -1329156265 
showStatusOnSwingThread(status);
//#endif 

} 

//#endif 


//#if -1880540267 
public void projectModified(ArgoStatusEvent e)
    { 

//#if -508139909 
String status = MessageFormat.format(
                            Translator.localize("statusmsg.bar.project-modified"),
                            new Object[] {e.getText()});
//#endif 


//#if 2031276257 
showStatusOnSwingThread(status);
//#endif 

} 

//#endif 


//#if -2133587070 
public void statusText(ArgoStatusEvent e)
    { 

//#if 1021322504 
showStatusOnSwingThread(e.getText());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

