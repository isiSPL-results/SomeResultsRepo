
//#if 671268904 
// Compilation Unit of /ActionReopenProject.java 
 

//#if -1362578749 
package org.argouml.uml.ui;
//#endif 


//#if 1879436713 
import java.awt.event.ActionEvent;
//#endif 


//#if -358309147 
import java.io.File;
//#endif 


//#if -365144163 
import javax.swing.AbstractAction;
//#endif 


//#if 782308493 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if 603291248 
public class ActionReopenProject extends 
//#if 1758254461 
AbstractAction
//#endif 

  { 

//#if 1103899013 
private String filename;
//#endif 


//#if 1427596114 
public ActionReopenProject(String theFilename)
    { 

//#if 535468577 
super("action.reopen-project");
//#endif 


//#if 181516338 
filename = theFilename;
//#endif 

} 

//#endif 


//#if -212083169 
public String getFilename()
    { 

//#if 1385793402 
return filename;
//#endif 

} 

//#endif 


//#if 1363808168 
public void actionPerformed(ActionEvent e)
    { 

//#if 1610809812 
if(!ProjectBrowser.getInstance().askConfirmationAndSave())//1
{ 

//#if 2132399016 
return;
//#endif 

} 

//#endif 


//#if 495201307 
File toOpen = new File(filename);
//#endif 


//#if 1816329806 
ProjectBrowser.getInstance().loadProjectWithProgressMonitor(
            toOpen, true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

