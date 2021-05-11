
//#if -1494733341 
// Compilation Unit of /ActionExit.java 
 

//#if 94103900 
package org.argouml.ui.cmd;
//#endif 


//#if 909681150 
import java.awt.event.ActionEvent;
//#endif 


//#if -1334899726 
import javax.swing.AbstractAction;
//#endif 


//#if 2082716745 
import org.argouml.application.api.CommandLineInterface;
//#endif 


//#if 797125174 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1329301047 
import org.argouml.i18n.Translator;
//#endif 


//#if -1255635944 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if 992958815 
public class ActionExit extends 
//#if -1510990998 
AbstractAction
//#endif 

 implements 
//#if -1908009204 
CommandLineInterface
//#endif 

  { 

//#if -516807026 
private static final long serialVersionUID = -6264722939329644183L;
//#endif 


//#if 1027827366 
public boolean doCommand(String argument)
    { 

//#if -774839925 
System.exit(0);
//#endif 


//#if -1855333967 
return true;
//#endif 

} 

//#endif 


//#if -604789040 
public ActionExit()
    { 

//#if -1579609980 
super(Translator.localize("action.exit"),
              ResourceLoaderWrapper.lookupIcon("action.exit"));
//#endif 

} 

//#endif 


//#if 149644654 
public void actionPerformed(ActionEvent ae)
    { 

//#if -316238868 
ProjectBrowser.getInstance().tryExit();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

