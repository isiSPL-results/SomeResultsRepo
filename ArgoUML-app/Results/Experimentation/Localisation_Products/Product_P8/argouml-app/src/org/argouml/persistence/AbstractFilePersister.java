package org.argouml.persistence;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.event.EventListenerList;
import javax.swing.filechooser.FileFilter;
import org.argouml.kernel.ProfileConfiguration;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectMember;
import org.argouml.taskmgmt.ProgressEvent;
import org.argouml.taskmgmt.ProgressListener;
import org.argouml.uml.ProjectMemberModel;
import org.argouml.uml.diagram.ProjectMemberDiagram;
import org.argouml.util.ThreadUtils;
import org.apache.log4j.Logger;
import org.argouml.uml.cognitive.ProjectMemberTodoList;
public abstract class AbstractFilePersister extends FileFilter
 implements ProjectFilePersister
  { 
private static Map<Class, Class<? extends MemberFilePersister>>
    persistersByClass =
        new HashMap<Class, Class<? extends MemberFilePersister>>();
private static Map<String, Class<? extends MemberFilePersister>>
    persistersByTag =
        new HashMap<String, Class<? extends MemberFilePersister>>();
private EventListenerList listenerList = new EventListenerList();
private static final Logger LOG =
        Logger.getLogger(AbstractFilePersister.class);
static
    {
        registerPersister(ProjectMemberDiagram.class, "pgml",
                          DiagramMemberFilePersister.class);
        registerPersister(ProfileConfiguration.class, "profile",
                          ProfileConfigurationFilePersister.class);



        registerPersister(ProjectMemberTodoList.class, "todo",
                          TodoListMemberFilePersister.class);

        registerPersister(ProjectMemberModel.class, "xmi",
                          ModelMemberFilePersister.class);
    }
public final void save(Project project, File file) throws SaveException,
               InterruptedException
    { 
preSave(project, file);
doSave(project, file);
postSave(project, file);
} 
protected File copyFile(File src, File dest)
    throws FileNotFoundException, IOException
    { 
FileInputStream fis  = new FileInputStream(src);
FileOutputStream fos = new FileOutputStream(dest);
byte[] buf = new byte[1024];
int i = 0;
while ((i = fis.read(buf)) != -1) //1
{ 
fos.write(buf, 0, i);
} 
fis.close();
fos.close();
dest.setLastModified(src.lastModified());
return dest;
} 
public boolean isSaveEnabled()
    { 
return true;
} 
public abstract boolean hasAnIcon();private static String getExtension(String filename)
    { 
int i = filename.lastIndexOf('.');
if(i > 0 && i < filename.length() - 1)//1
{ 
return filename.substring(i + 1).toLowerCase();
} 
return null;
} 
public String getDescription()
    { 
return getDesc() + " (*." + getExtension() + ")";
} 
protected MemberFilePersister getMemberFilePersister(ProjectMember pm)
    { 
Class<? extends MemberFilePersister> persister = null;
if(persistersByClass.containsKey(pm))//1
{ 
persister = persistersByClass.get(pm);
} 
else
{ 
for (Class clazz : persistersByClass.keySet()) //1
{ 
if(clazz.isAssignableFrom(pm.getClass()))//1
{ 
persister = persistersByClass.get(clazz);
break;

} 
} 
} 
if(persister != null)//1
{ 
return newPersister(persister);
} 
return null;
} 
protected MemberFilePersister getMemberFilePersister(String tag)
    { 
Class<? extends MemberFilePersister> persister =
            persistersByTag.get(tag);
if(persister != null)//1
{ 
return newPersister(persister);
} 
return null;
} 
protected File createTempFile(File file)
    throws FileNotFoundException, IOException
    { 
File tempFile = new File(file.getAbsolutePath() + "#");
if(tempFile.exists())//1
{ 
tempFile.delete();
} 
if(file.exists())//1
{ 
copyFile(file, tempFile);
} 
return tempFile;
} 
private static boolean registerPersister(Class target, String tag,
            Class<? extends MemberFilePersister> persister)
    { 
persistersByClass.put(target, persister);
persistersByTag.put(tag, persister);
return true;
} 
public void removeProgressListener(ProgressListener listener)
    { 
listenerList.remove(ProgressListener.class, listener);
} 
public void addProgressListener(ProgressListener listener)
    { 
listenerList.add(ProgressListener.class, listener);
} 
private void postSave(Project project, File file) throws SaveException
    { 
if(project == null && file == null)//1
{ 
throw new SaveException("No project nor file given");
} 
} 
public boolean isLoadEnabled()
    { 
return true;
} 
public boolean isFileExtensionApplicable(String filename)
    { 
return filename.toLowerCase().endsWith("." + getExtension());
} 
protected abstract void doSave(Project project, File file)
    throws SaveException, InterruptedException;private static MemberFilePersister newPersister(
        Class<? extends MemberFilePersister> clazz)
    { 
try//1
{ 
return clazz.newInstance();
} 
catch (InstantiationException e) //1
{ 
LOG.error("Exception instantiating file persister " + clazz, e);
return null;
} 
catch (IllegalAccessException e) //1
{ 
LOG.error("Exception instantiating file persister " + clazz, e);
return null;
} 
} 
public boolean accept(File f)
    { 
if(f == null)//1
{ 
return false;
} 
if(f.isDirectory())//1
{ 
return true;
} 
String s = getExtension(f);
if(s != null)//1
{ 
if(s.equalsIgnoreCase(getExtension()))//1
{ 
return true;
} 
} 
return false;
} 
public abstract String getExtension();private static String getExtension(File f)
    { 
if(f == null)//1
{ 
return null;
} 
return getExtension(f.getName());
} 
public abstract Project doLoad(File file)
    throws OpenException, InterruptedException;protected abstract String getDesc();private void preSave(Project project, File file) throws SaveException
    { 
if(project == null && file == null)//1
{ 
throw new SaveException("No project nor file given");
} 
} 
class ProgressMgr implements ProgressListener
  { 
private int percentPhasesComplete;
private int phasesCompleted;
private int numberOfPhases;
public int getNumberOfPhases()
        { 
return this.numberOfPhases;
} 
protected void fireProgressEvent(long percent)
        throws InterruptedException
        { 
ProgressEvent event = null;
Object[] listeners = listenerList.getListenerList();
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 
if(listeners[i] == ProgressListener.class)//1
{ 
if(event == null)//1
{ 
event = new ProgressEvent(this, percent, 100);
} 
((ProgressListener) listeners[i + 1]).progress(event);
} 
} 
} 
public void setNumberOfPhases(int aNumberOfPhases)
        { 
this.numberOfPhases = aNumberOfPhases;
} 
protected void nextPhase() throws InterruptedException
        { 
ThreadUtils.checkIfInterrupted();
++phasesCompleted;
percentPhasesComplete =
                (phasesCompleted * 100) / numberOfPhases;
fireProgressEvent(percentPhasesComplete);
} 
public void setPercentPhasesComplete(int aPercentPhasesComplete)
        { 
this.percentPhasesComplete = aPercentPhasesComplete;
} 
public void progress(ProgressEvent event) throws InterruptedException
        { 
ThreadUtils.checkIfInterrupted();
int percentPhasesLeft = 100 - percentPhasesComplete;
long position = event.getPosition();
long length = event.getLength();
long proportion = (position * percentPhasesLeft) / length;
fireProgressEvent(percentPhasesComplete + proportion);
} 
public void setPhasesCompleted(int aPhasesCompleted)
        { 
this.phasesCompleted = aPhasesCompleted;
} 

 } 

 } 
