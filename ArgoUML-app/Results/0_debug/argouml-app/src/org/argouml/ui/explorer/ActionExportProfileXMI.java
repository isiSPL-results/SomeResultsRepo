
//#if -1871625621 
// Compilation Unit of /ActionExportProfileXMI.java 
 

//#if -1789694789 
package org.argouml.ui.explorer;
//#endif 


//#if -1053062504 
import java.awt.event.ActionEvent;
//#endif 


//#if -473104876 
import java.io.File;
//#endif 


//#if 2064145587 
import java.io.FileOutputStream;
//#endif 


//#if -1471756803 
import java.io.IOException;
//#endif 


//#if 1427819343 
import java.io.OutputStream;
//#endif 


//#if 1270194958 
import java.util.Collection;
//#endif 


//#if 997323916 
import javax.swing.AbstractAction;
//#endif 


//#if 118065679 
import javax.swing.JFileChooser;
//#endif 


//#if 1438297281 
import javax.swing.filechooser.FileFilter;
//#endif 


//#if -336694720 
import org.argouml.application.helpers.ApplicationVersion;
//#endif 


//#if -1645176951 
import org.argouml.configuration.Configuration;
//#endif 


//#if 613789917 
import org.argouml.i18n.Translator;
//#endif 


//#if 2032366115 
import org.argouml.model.Model;
//#endif 


//#if 1490696367 
import org.argouml.model.UmlException;
//#endif 


//#if -26158363 
import org.argouml.model.XmiWriter;
//#endif 


//#if -223168750 
import org.argouml.persistence.PersistenceManager;
//#endif 


//#if 388326396 
import org.argouml.persistence.ProjectFileView;
//#endif 


//#if 483099087 
import org.argouml.persistence.UmlFilePersister;
//#endif 


//#if -1594732061 
import org.argouml.profile.Profile;
//#endif 


//#if 80159044 
import org.argouml.profile.ProfileException;
//#endif 


//#if 1825220423 
import org.argouml.util.ArgoFrame;
//#endif 


//#if 184829616 
import org.apache.log4j.Logger;
//#endif 


//#if 636160986 
public class ActionExportProfileXMI extends 
//#if 338410781 
AbstractAction
//#endif 

  { 

//#if 459705368 
private Profile selectedProfile;
//#endif 


//#if -928420098 
private static final Logger LOG = Logger
                                      .getLogger(ActionExportProfileXMI.class);
//#endif 


//#if 705827699 
private static boolean isXmiFile(File file)
    { 

//#if 92680562 
return file.isFile()
               && (file.getName().toLowerCase().endsWith(".xml")
                   || file.getName().toLowerCase().endsWith(".xmi"));
//#endif 

} 

//#endif 


//#if 1858597230 
private void saveModel(File destiny, Object model) throws IOException,
                UmlException
    { 

//#if -7087216 
OutputStream stream = new FileOutputStream(destiny);
//#endif 


//#if -29290417 
XmiWriter xmiWriter =
            Model.getXmiWriter(model, stream,
                               ApplicationVersion.getVersion() + "("
                               + UmlFilePersister.PERSISTENCE_VERSION + ")");
//#endif 


//#if -697579051 
xmiWriter.write();
//#endif 

} 

//#endif 


//#if -1258585941 
public void actionPerformed(ActionEvent arg0)
    { 

//#if -592978949 
try //1
{ 

//#if -270969261 
final Collection profilePackages =
                selectedProfile.getProfilePackages();
//#endif 


//#if 1994864853 
final Object model = profilePackages.iterator().next();
//#endif 


//#if 462639517 
if(model != null)//1
{ 

//#if 1105327441 
File destiny = getTargetFile();
//#endif 


//#if -759991675 
if(destiny != null)//1
{ 

//#if 158040086 
saveModel(destiny, model);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#if -901661387 
catch (ProfileException e) //1
{ 

//#if 2043871718 
LOG.error("Exception", e);
//#endif 

} 

//#endif 


//#if -2044563530 
catch (IOException e) //1
{ 

//#if -394874769 
LOG.error("Exception", e);
//#endif 

} 

//#endif 


//#if -1475274720 
catch (UmlException e) //1
{ 

//#if -1822964128 
LOG.error("Exception", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1666207516 
public ActionExportProfileXMI(Profile profile)
    { 

//#if 215612769 
super(Translator.localize("action.export-profile-as-xmi"));
//#endif 


//#if -1320104719 
this.selectedProfile = profile;
//#endif 

} 

//#endif 


//#if 1448950762 
private File getTargetFile()
    { 

//#if -1740476338 
JFileChooser chooser = new JFileChooser();
//#endif 


//#if 259934905 
chooser.setDialogTitle(Translator.localize(
                                   "action.export-profile-as-xmi"));
//#endif 


//#if -2047423360 
chooser.setFileView(ProjectFileView.getInstance());
//#endif 


//#if -412619430 
chooser.setApproveButtonText(Translator.localize(
                                         "filechooser.export"));
//#endif 


//#if -1459603685 
chooser.setAcceptAllFileFilterUsed(true);
//#endif 


//#if 1451577024 
chooser.setFileFilter(new FileFilter() {

            public boolean accept(File file) {
                return file.isDirectory() || isXmiFile(file);
            }



            public String getDescription() {
                return "*.XMI";
            }

        });
//#endif 


//#if 1167858416 
String fn =
            Configuration.getString(
                PersistenceManager.KEY_PROJECT_NAME_PATH);
//#endif 


//#if 1733032334 
if(fn.length() > 0)//1
{ 

//#if -1472929179 
fn = PersistenceManager.getInstance().getBaseName(fn);
//#endif 


//#if -587906275 
chooser.setSelectedFile(new File(fn));
//#endif 

} 

//#endif 


//#if 812514612 
int result = chooser.showSaveDialog(ArgoFrame.getInstance());
//#endif 


//#if 1454461906 
if(result == JFileChooser.APPROVE_OPTION)//1
{ 

//#if -100410642 
File theFile = chooser.getSelectedFile();
//#endif 


//#if -1678240849 
if(theFile != null)//1
{ 

//#if 1705331704 
if(!theFile.getName().toUpperCase().endsWith(".XMI"))//1
{ 

//#if 1408193614 
theFile = new File(theFile.getAbsolutePath() + ".XMI");
//#endif 

} 

//#endif 


//#if 1111630672 
return theFile;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1654147730 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

