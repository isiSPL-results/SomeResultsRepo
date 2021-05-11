package org.argouml.ui.explorer;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import org.argouml.application.helpers.ApplicationVersion;
import org.argouml.configuration.Configuration;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.model.UmlException;
import org.argouml.model.XmiWriter;
import org.argouml.persistence.PersistenceManager;
import org.argouml.persistence.ProjectFileView;
import org.argouml.persistence.UmlFilePersister;
import org.argouml.profile.Profile;
import org.argouml.profile.ProfileException;
import org.argouml.util.ArgoFrame;
public class ActionExportProfileXMI extends AbstractAction
  { 
private Profile selectedProfile;
private static boolean isXmiFile(File file)
    { 
return file.isFile()
               && (file.getName().toLowerCase().endsWith(".xml")
                   || file.getName().toLowerCase().endsWith(".xmi"));
} 
private void saveModel(File destiny, Object model) throws IOException,
                UmlException
    { 
OutputStream stream = new FileOutputStream(destiny);
XmiWriter xmiWriter =
            Model.getXmiWriter(model, stream,
                               ApplicationVersion.getVersion() + "("
                               + UmlFilePersister.PERSISTENCE_VERSION + ")");
xmiWriter.write();
} 
public void actionPerformed(ActionEvent arg0)
    { 
try//1
{ 
final Collection profilePackages =
                selectedProfile.getProfilePackages();
final Object model = profilePackages.iterator().next();
if(model != null)//1
{ 
File destiny = getTargetFile();
if(destiny != null)//1
{ 
saveModel(destiny, model);
} 
} 
} 
catch (ProfileException e) //1
{ 
} 
catch (IOException e) //1
{ 
} 
catch (UmlException e) //1
{ 
} 
} 
public ActionExportProfileXMI(Profile profile)
    { 
super(Translator.localize("action.export-profile-as-xmi"));
this.selectedProfile = profile;
} 
private File getTargetFile()
    { 
JFileChooser chooser = new JFileChooser();
chooser.setDialogTitle(Translator.localize(
                                   "action.export-profile-as-xmi"));
chooser.setFileView(ProjectFileView.getInstance());
chooser.setApproveButtonText(Translator.localize(
                                         "filechooser.export"));
chooser.setAcceptAllFileFilterUsed(true);
chooser.setFileFilter(new FileFilter() {

            public boolean accept(File file) {
                return file.isDirectory() || isXmiFile(file);
            }



            public String getDescription() {
                return "*.XMI";
            }

        });
String fn =
            Configuration.getString(
                PersistenceManager.KEY_PROJECT_NAME_PATH);
if(fn.length() > 0)//1
{ 
fn = PersistenceManager.getInstance().getBaseName(fn);
chooser.setSelectedFile(new File(fn));
} 
int result = chooser.showSaveDialog(ArgoFrame.getInstance());
if(result == JFileChooser.APPROVE_OPTION)//1
{ 
File theFile = chooser.getSelectedFile();
if(theFile != null)//1
{ 
if(!theFile.getName().toUpperCase().endsWith(".XMI"))//1
{ 
theFile = new File(theFile.getAbsolutePath() + ".XMI");
} 
return theFile;
} 
} 
return null;
} 

 } 
