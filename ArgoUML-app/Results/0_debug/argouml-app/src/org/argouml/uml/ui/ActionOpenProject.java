
//#if -1322541298 
// Compilation Unit of /ActionOpenProject.java 
 

//#if 545658456 
package org.argouml.uml.ui;
//#endif 


//#if -1978513292 
import java.awt.event.ActionEvent;
//#endif 


//#if -242422544 
import java.io.File;
//#endif 


//#if 485296618 
import javax.swing.Action;
//#endif 


//#if 921571051 
import javax.swing.JFileChooser;
//#endif 


//#if -648819043 
import javax.swing.filechooser.FileFilter;
//#endif 


//#if -747010497 
import org.argouml.application.api.CommandLineInterface;
//#endif 


//#if -953472512 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 961429293 
import org.argouml.configuration.Configuration;
//#endif 


//#if 1989586561 
import org.argouml.i18n.Translator;
//#endif 


//#if 458828771 
import org.argouml.kernel.Project;
//#endif 


//#if 671691174 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1522998377 
import org.argouml.persistence.AbstractFilePersister;
//#endif 


//#if 174734574 
import org.argouml.persistence.PersistenceManager;
//#endif 


//#if -1300034656 
import org.argouml.persistence.ProjectFileView;
//#endif 


//#if 1918550498 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if -1475156931 
import org.argouml.ui.UndoableAction;
//#endif 


//#if 899769635 
import org.argouml.util.ArgoFrame;
//#endif 


//#if 704078296 
public class ActionOpenProject extends 
//#if -913863987 
UndoableAction
//#endif 

 implements 
//#if -1303835117 
CommandLineInterface
//#endif 

  { 

//#if 683624941 
public boolean doCommand(String argument)
    { 

//#if 1237238839 
return ProjectBrowser.getInstance()
               .loadProject(new File(argument), false, null);
//#endif 

} 

//#endif 


//#if -678719816 
public ActionOpenProject()
    { 

//#if 1392757053 
super(Translator.localize("action.open-project"),
              ResourceLoaderWrapper.lookupIcon("action.open-project"));
//#endif 


//#if -1451674155 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.open-project"));
//#endif 

} 

//#endif 


//#if -551492620 
public void actionPerformed(ActionEvent e)
    { 

//#if 547505784 
super.actionPerformed(e);
//#endif 


//#if -1086322856 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -1293597013 
PersistenceManager pm = PersistenceManager.getInstance();
//#endif 


//#if -1690863092 
if(!ProjectBrowser.getInstance().askConfirmationAndSave())//1
{ 

//#if -1822212472 
return;
//#endif 

} 

//#endif 


//#if 1031174191 
JFileChooser chooser = null;
//#endif 


//#if -1591118954 
if(p != null && p.getURI() != null)//1
{ 

//#if -2022326442 
File file = new File(p.getURI());
//#endif 


//#if 793283871 
if(file.getParentFile() != null)//1
{ 

//#if 1775218230 
chooser = new JFileChooser(file.getParent());
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1498979154 
chooser = new JFileChooser();
//#endif 

} 

//#endif 


//#if -1207105779 
if(chooser == null)//1
{ 

//#if -1908262531 
chooser = new JFileChooser();
//#endif 

} 

//#endif 


//#if 1006013980 
chooser.setDialogTitle(
            Translator.localize("filechooser.open-project"));
//#endif 


//#if -1494635978 
chooser.setAcceptAllFileFilterUsed(false);
//#endif 


//#if 855021284 
chooser.setFileView(ProjectFileView.getInstance());
//#endif 


//#if -2029887885 
pm.setOpenFileChooserFilter(chooser);
//#endif 


//#if 2006353921 
String fn = Configuration.getString(
                        PersistenceManager.KEY_OPEN_PROJECT_PATH);
//#endif 


//#if 1190456234 
if(fn.length() > 0)//1
{ 

//#if -1324510802 
chooser.setSelectedFile(new File(fn));
//#endif 

} 

//#endif 


//#if -773308742 
int retval = chooser.showOpenDialog(ArgoFrame.getInstance());
//#endif 


//#if -1136773493 
if(retval == JFileChooser.APPROVE_OPTION)//1
{ 

//#if 856821674 
File theFile = chooser.getSelectedFile();
//#endif 


//#if -1850524550 
if(!theFile.canRead())//1
{ 

//#if -1094905705 
FileFilter ffilter = chooser.getFileFilter();
//#endif 


//#if 376844907 
if(ffilter instanceof AbstractFilePersister)//1
{ 

//#if 1480578503 
AbstractFilePersister afp =
                        (AbstractFilePersister) ffilter;
//#endif 


//#if 987222989 
File m =
                        new File(theFile.getPath() + "."
                                 + afp.getExtension());
//#endif 


//#if 514221268 
if(m.canRead())//1
{ 

//#if -1257334342 
theFile = m;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -175837225 
if(!theFile.canRead())//1
{ 

//#if 518743228 
File n =
                        new File(theFile.getPath() + "."
                                 + pm.getDefaultExtension());
//#endif 


//#if 1697797390 
if(n.canRead())//1
{ 

//#if 303738123 
theFile = n;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1740947605 
if(theFile != null)//1
{ 

//#if -850761419 
Configuration.setString(
                    PersistenceManager.KEY_OPEN_PROJECT_PATH,
                    theFile.getPath());
//#endif 


//#if 81412985 
ProjectBrowser.getInstance().loadProjectWithProgressMonitor(
                    theFile, true);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

