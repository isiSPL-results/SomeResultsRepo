package org.argouml.ui;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import org.argouml.configuration.Configuration;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.persistence.AbstractFilePersister;
import org.argouml.persistence.PersistenceManager;
import org.argouml.persistence.ProjectFileView;
public class ActionImportXMI extends AbstractAction
  { 
private static final long serialVersionUID = -8756142027376622496L;
public ActionImportXMI()
    { 
super(Translator.localize("action.import-xmi"));
} 
public void actionPerformed(ActionEvent e)
    { 
ProjectBrowser pb = ProjectBrowser.getInstance();
Project p = ProjectManager.getManager().getCurrentProject();
PersistenceManager pm = PersistenceManager.getInstance();
if(!ProjectBrowser.getInstance().askConfirmationAndSave())//1
{ 
return;
} 
JFileChooser chooser = null;
if(p != null && p.getURI() != null)//1
{ 
File file = new File(p.getURI());
if(file.getParentFile() != null)//1
{ 
chooser = new JFileChooser(file.getParent());
} 
} 
else
{ 
chooser = new JFileChooser();
} 
if(chooser == null)//1
{ 
chooser = new JFileChooser();
} 
chooser.setDialogTitle(
            Translator.localize("filechooser.import-xmi"));
chooser.setFileView(ProjectFileView.getInstance());
chooser.setAcceptAllFileFilterUsed(true);
pm.setXmiFileChooserFilter(chooser);
String fn =
            Configuration.getString(
                PersistenceManager.KEY_IMPORT_XMI_PATH);
if(fn.length() > 0)//1
{ 
chooser.setSelectedFile(new File(fn));
} 
int retval = chooser.showOpenDialog(pb);
if(retval == JFileChooser.APPROVE_OPTION)//1
{ 
File theFile = chooser.getSelectedFile();
if(!theFile.canRead())//1
{ 
FileFilter ffilter = chooser.getFileFilter();
if(ffilter instanceof AbstractFilePersister)//1
{ 
AbstractFilePersister afp =
                        (AbstractFilePersister) ffilter;
File m =
                        new File(theFile.getPath() + "."
                                 + afp.getExtension());
if(m.canRead())//1
{ 
theFile = m;
} 
} 
} 
Configuration.setString(
                PersistenceManager.KEY_IMPORT_XMI_PATH,
                theFile.getPath());
ProjectBrowser.getInstance().loadProjectWithProgressMonitor(
                theFile, true);
} 
} 

 } 
