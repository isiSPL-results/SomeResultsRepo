
//#if 1950893877 
// Compilation Unit of /ActionExportXMI.java 
 

//#if 959305293 
package org.argouml.ui;
//#endif 


//#if -2111747271 
import java.awt.event.ActionEvent;
//#endif 


//#if 1403255925 
import java.io.File;
//#endif 


//#if -61360851 
import javax.swing.AbstractAction;
//#endif 


//#if -973537552 
import javax.swing.JFileChooser;
//#endif 


//#if -1663130488 
import org.argouml.configuration.Configuration;
//#endif 


//#if -2140666788 
import org.argouml.i18n.Translator;
//#endif 


//#if 1793922483 
import org.argouml.persistence.PersistenceManager;
//#endif 


//#if 370372859 
import org.argouml.persistence.ProjectFileView;
//#endif 


//#if 766535656 
import org.argouml.util.ArgoFrame;
//#endif 


//#if -1401035370 
public final class ActionExportXMI extends 
//#if -880062301 
AbstractAction
//#endif 

  { 

//#if 2054787719 
private static final long serialVersionUID = -3445739054369264482L;
//#endif 


//#if -1853994174 
public void actionPerformed(ActionEvent e)
    { 

//#if 63229873 
PersistenceManager pm = PersistenceManager.getInstance();
//#endif 


//#if -1893472144 
JFileChooser chooser = new JFileChooser();
//#endif 


//#if -328560149 
chooser.setDialogTitle(Translator.localize(
                                   "action.export-project-as-xmi"));
//#endif 


//#if 2058165150 
chooser.setFileView(ProjectFileView.getInstance());
//#endif 


//#if 682941692 
chooser.setApproveButtonText(Translator.localize(
                                         "filechooser.export"));
//#endif 


//#if 1897608121 
chooser.setAcceptAllFileFilterUsed(true);
//#endif 


//#if 1824438029 
pm.setXmiFileChooserFilter(chooser);
//#endif 


//#if 1572761614 
String fn =
            Configuration.getString(
                PersistenceManager.KEY_PROJECT_NAME_PATH);
//#endif 


//#if 1749718576 
if(fn.length() > 0)//1
{ 

//#if 1004816940 
fn = PersistenceManager.getInstance().getBaseName(fn);
//#endif 


//#if 1455564342 
chooser.setSelectedFile(new File(fn));
//#endif 

} 

//#endif 


//#if 1278480470 
int result = chooser.showSaveDialog(ArgoFrame.getInstance());
//#endif 


//#if -1846154508 
if(result == JFileChooser.APPROVE_OPTION)//1
{ 

//#if -1917893640 
File theFile = chooser.getSelectedFile();
//#endif 


//#if 1390054201 
if(theFile != null)//1
{ 

//#if -282940319 
String name = theFile.getName();
//#endif 


//#if 174786470 
Configuration.setString(
                    PersistenceManager.KEY_PROJECT_NAME_PATH,
                    PersistenceManager.getInstance().getBaseName(
                        theFile.getPath()));
//#endif 


//#if -521747586 
name = pm.fixXmiExtension(name);
//#endif 


//#if 675680383 
theFile = new File(theFile.getParent(), name);
//#endif 


//#if 857503428 
ProjectBrowser.getInstance().trySaveWithProgressMonitor(
                    false, theFile);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1294163433 
public ActionExportXMI()
    { 

//#if 152709188 
super(Translator.localize("action.export-project-as-xmi"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

