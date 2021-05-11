
//#if -1902254320 
// Compilation Unit of /ActionImportXMI.java 
 

//#if -1766541029 
package org.argouml.ui;
//#endif 


//#if -1714668629 
import java.awt.event.ActionEvent;
//#endif 


//#if 1662958695 
import java.io.File;
//#endif 


//#if 335717791 
import javax.swing.AbstractAction;
//#endif 


//#if -1473682462 
import javax.swing.JFileChooser;
//#endif 


//#if -266429740 
import javax.swing.filechooser.FileFilter;
//#endif 


//#if 1262320982 
import org.argouml.configuration.Configuration;
//#endif 


//#if 1578836522 
import org.argouml.i18n.Translator;
//#endif 


//#if 722673434 
import org.argouml.kernel.Project;
//#endif 


//#if -1255636337 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -2094981376 
import org.argouml.persistence.AbstractFilePersister;
//#endif 


//#if 442294821 
import org.argouml.persistence.PersistenceManager;
//#endif 


//#if -999142967 
import org.argouml.persistence.ProjectFileView;
//#endif 


//#if 2101977473 
public class ActionImportXMI extends 
//#if -281773073 
AbstractAction
//#endif 

  { 

//#if 1632175010 
private static final long serialVersionUID = -8756142027376622496L;
//#endif 


//#if 1301043962 
public ActionImportXMI()
    { 

//#if -1540755351 
super(Translator.localize("action.import-xmi"));
//#endif 

} 

//#endif 


//#if -1150276234 
public void actionPerformed(ActionEvent e)
    { 

//#if -651035691 
ProjectBrowser pb = ProjectBrowser.getInstance();
//#endif 


//#if -1965560029 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 760507072 
PersistenceManager pm = PersistenceManager.getInstance();
//#endif 


//#if -2052029353 
if(!ProjectBrowser.getInstance().askConfirmationAndSave())//1
{ 

//#if 700626387 
return;
//#endif 

} 

//#endif 


//#if -217560070 
JFileChooser chooser = null;
//#endif 


//#if -1375546005 
if(p != null && p.getURI() != null)//1
{ 

//#if 1139242189 
File file = new File(p.getURI());
//#endif 


//#if 1214557974 
if(file.getParentFile() != null)//1
{ 

//#if -1313715853 
chooser = new JFileChooser(file.getParent());
//#endif 

} 

//#endif 

} 
else
{ 

//#if 2019582705 
chooser = new JFileChooser();
//#endif 

} 

//#endif 


//#if 1932705890 
if(chooser == null)//1
{ 

//#if -1325338047 
chooser = new JFileChooser();
//#endif 

} 

//#endif 


//#if 903188423 
chooser.setDialogTitle(
            Translator.localize("filechooser.import-xmi"));
//#endif 


//#if 1767830255 
chooser.setFileView(ProjectFileView.getInstance());
//#endif 


//#if 799132746 
chooser.setAcceptAllFileFilterUsed(true);
//#endif 


//#if -368228388 
pm.setXmiFileChooserFilter(chooser);
//#endif 


//#if -1137183114 
String fn =
            Configuration.getString(
                PersistenceManager.KEY_IMPORT_XMI_PATH);
//#endif 


//#if 35300607 
if(fn.length() > 0)//1
{ 

//#if -2098105549 
chooser.setSelectedFile(new File(fn));
//#endif 

} 

//#endif 


//#if -113826311 
int retval = chooser.showOpenDialog(pb);
//#endif 


//#if -673508832 
if(retval == JFileChooser.APPROVE_OPTION)//1
{ 

//#if 441355013 
File theFile = chooser.getSelectedFile();
//#endif 


//#if 1378511167 
if(!theFile.canRead())//1
{ 

//#if -1003081488 
FileFilter ffilter = chooser.getFileFilter();
//#endif 


//#if 17926002 
if(ffilter instanceof AbstractFilePersister)//1
{ 

//#if -989350095 
AbstractFilePersister afp =
                        (AbstractFilePersister) ffilter;
//#endif 


//#if -1482705609 
File m =
                        new File(theFile.getPath() + "."
                                 + afp.getExtension());
//#endif 


//#if -638302786 
if(m.canRead())//1
{ 

//#if 1742149758 
theFile = m;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -549086223 
Configuration.setString(
                PersistenceManager.KEY_IMPORT_XMI_PATH,
                theFile.getPath());
//#endif 


//#if -114533173 
ProjectBrowser.getInstance().loadProjectWithProgressMonitor(
                theFile, true);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

