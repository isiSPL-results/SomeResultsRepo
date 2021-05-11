
//#if -1472104323 
// Compilation Unit of /AbstractFilePersister.java 
 

//#if 1549750197 
package org.argouml.persistence;
//#endif 


//#if -2031191916 
import java.io.File;
//#endif 


//#if 1057211320 
import java.io.FileInputStream;
//#endif 


//#if 1659715714 
import java.io.FileNotFoundException;
//#endif 


//#if 658904883 
import java.io.FileOutputStream;
//#endif 


//#if -1375831171 
import java.io.IOException;
//#endif 


//#if 310829564 
import java.util.HashMap;
//#endif 


//#if -1072303282 
import java.util.Map;
//#endif 


//#if 1279712186 
import javax.swing.event.EventListenerList;
//#endif 


//#if 905004865 
import javax.swing.filechooser.FileFilter;
//#endif 


//#if -993997847 
import org.argouml.kernel.ProfileConfiguration;
//#endif 


//#if -432306041 
import org.argouml.kernel.Project;
//#endif 


//#if -1382645747 
import org.argouml.kernel.ProjectMember;
//#endif 


//#if 932130378 
import org.argouml.taskmgmt.ProgressEvent;
//#endif 


//#if 883236862 
import org.argouml.taskmgmt.ProgressListener;
//#endif 


//#if -1527888769 
import org.argouml.uml.ProjectMemberModel;
//#endif 


//#if 305058810 
import org.argouml.uml.diagram.ProjectMemberDiagram;
//#endif 


//#if 1617547124 
import org.argouml.util.ThreadUtils;
//#endif 


//#if 1524972592 
import org.apache.log4j.Logger;
//#endif 


//#if 1967320286 
import org.argouml.uml.cognitive.ProjectMemberTodoList;
//#endif 


//#if 1752206560 
public abstract class AbstractFilePersister extends 
//#if 1011038638 
FileFilter
//#endif 

 implements 
//#if 1633652198 
ProjectFilePersister
//#endif 

  { 

//#if -1796032577 
private static Map<Class, Class<? extends MemberFilePersister>>
    persistersByClass =
        new HashMap<Class, Class<? extends MemberFilePersister>>();
//#endif 


//#if 812715087 
private static Map<String, Class<? extends MemberFilePersister>>
    persistersByTag =
        new HashMap<String, Class<? extends MemberFilePersister>>();
//#endif 


//#if -1708922522 
private EventListenerList listenerList = new EventListenerList();
//#endif 


//#if -1170416377 
private static final Logger LOG =
        Logger.getLogger(AbstractFilePersister.class);
//#endif 


//#if -2093228118 
static
    {
        registerPersister(ProjectMemberDiagram.class, "pgml",
                          DiagramMemberFilePersister.class);
        registerPersister(ProfileConfiguration.class, "profile",
                          ProfileConfigurationFilePersister.class);






        registerPersister(ProjectMemberModel.class, "xmi",
                          ModelMemberFilePersister.class);
    }
//#endif 


//#if 1152291344 
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
//#endif 


//#if 375948829 
public final void save(Project project, File file) throws SaveException,
               InterruptedException
    { 

//#if -1192760729 
preSave(project, file);
//#endif 


//#if -1363416829 
doSave(project, file);
//#endif 


//#if 796148302 
postSave(project, file);
//#endif 

} 

//#endif 


//#if 983774804 
protected File copyFile(File src, File dest)
    throws FileNotFoundException, IOException
    { 

//#if -1076027327 
FileInputStream fis  = new FileInputStream(src);
//#endif 


//#if 590844229 
FileOutputStream fos = new FileOutputStream(dest);
//#endif 


//#if 371452220 
byte[] buf = new byte[1024];
//#endif 


//#if -1059641000 
int i = 0;
//#endif 


//#if 936413846 
while ((i = fis.read(buf)) != -1) //1
{ 

//#if -1202285426 
fos.write(buf, 0, i);
//#endif 

} 

//#endif 


//#if -882173482 
fis.close();
//#endif 


//#if 1221020252 
fos.close();
//#endif 


//#if -1926796615 
dest.setLastModified(src.lastModified());
//#endif 


//#if -1478603629 
return dest;
//#endif 

} 

//#endif 


//#if -1470057098 
public boolean isSaveEnabled()
    { 

//#if 836501417 
return true;
//#endif 

} 

//#endif 


//#if 1097602078 
public abstract boolean hasAnIcon();
//#endif 


//#if 1041152314 
private static String getExtension(String filename)
    { 

//#if 212931921 
int i = filename.lastIndexOf('.');
//#endif 


//#if -917878257 
if(i > 0 && i < filename.length() - 1)//1
{ 

//#if 1107255332 
return filename.substring(i + 1).toLowerCase();
//#endif 

} 

//#endif 


//#if 1728738236 
return null;
//#endif 

} 

//#endif 


//#if 780542235 
public String getDescription()
    { 

//#if -1739622904 
return getDesc() + " (*." + getExtension() + ")";
//#endif 

} 

//#endif 


//#if 1608117205 
protected MemberFilePersister getMemberFilePersister(ProjectMember pm)
    { 

//#if -403305355 
Class<? extends MemberFilePersister> persister = null;
//#endif 


//#if -2054875052 
if(persistersByClass.containsKey(pm))//1
{ 

//#if -1604028218 
persister = persistersByClass.get(pm);
//#endif 

} 
else
{ 

//#if -2024969917 
for (Class clazz : persistersByClass.keySet()) //1
{ 

//#if 1237608153 
if(clazz.isAssignableFrom(pm.getClass()))//1
{ 

//#if -388515881 
persister = persistersByClass.get(clazz);
//#endif 


//#if 1409173730 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1625034573 
if(persister != null)//1
{ 

//#if -294482604 
return newPersister(persister);
//#endif 

} 

//#endif 


//#if 842670706 
return null;
//#endif 

} 

//#endif 


//#if -1279651236 
protected MemberFilePersister getMemberFilePersister(String tag)
    { 

//#if 66892354 
Class<? extends MemberFilePersister> persister =
            persistersByTag.get(tag);
//#endif 


//#if 1307656559 
if(persister != null)//1
{ 

//#if 1750501799 
return newPersister(persister);
//#endif 

} 

//#endif 


//#if -1156059338 
return null;
//#endif 

} 

//#endif 


//#if -202369233 
protected File createTempFile(File file)
    throws FileNotFoundException, IOException
    { 

//#if 2058739187 
File tempFile = new File(file.getAbsolutePath() + "#");
//#endif 


//#if 1169358219 
if(tempFile.exists())//1
{ 

//#if 1220359412 
tempFile.delete();
//#endif 

} 

//#endif 


//#if 1982649087 
if(file.exists())//1
{ 

//#if -363431985 
copyFile(file, tempFile);
//#endif 

} 

//#endif 


//#if -1029278200 
return tempFile;
//#endif 

} 

//#endif 


//#if 1586009338 
private static boolean registerPersister(Class target, String tag,
            Class<? extends MemberFilePersister> persister)
    { 

//#if -1275396597 
persistersByClass.put(target, persister);
//#endif 


//#if 1755057456 
persistersByTag.put(tag, persister);
//#endif 


//#if -583814206 
return true;
//#endif 

} 

//#endif 


//#if 1897225000 
public void removeProgressListener(ProgressListener listener)
    { 

//#if -2051197830 
listenerList.remove(ProgressListener.class, listener);
//#endif 

} 

//#endif 


//#if -692507529 
public void addProgressListener(ProgressListener listener)
    { 

//#if -2071538885 
listenerList.add(ProgressListener.class, listener);
//#endif 

} 

//#endif 


//#if -1913232142 
private void postSave(Project project, File file) throws SaveException
    { 

//#if -1836214836 
if(project == null && file == null)//1
{ 

//#if -1643792511 
throw new SaveException("No project nor file given");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1668708397 
public boolean isLoadEnabled()
    { 

//#if -401049820 
return true;
//#endif 

} 

//#endif 


//#if -2082988516 
public boolean isFileExtensionApplicable(String filename)
    { 

//#if -236128718 
return filename.toLowerCase().endsWith("." + getExtension());
//#endif 

} 

//#endif 


//#if -444491377 
protected abstract void doSave(Project project, File file)
    throws SaveException, InterruptedException;
//#endif 


//#if -1363396651 
private static MemberFilePersister newPersister(
        Class<? extends MemberFilePersister> clazz)
    { 

//#if -2049233241 
try //1
{ 

//#if 1152458687 
return clazz.newInstance();
//#endif 

} 

//#if 1101052401 
catch (InstantiationException e) //1
{ 

//#if 1275568150 
LOG.error("Exception instantiating file persister " + clazz, e);
//#endif 


//#if -423177611 
return null;
//#endif 

} 

//#endif 


//#if -1050648994 
catch (IllegalAccessException e) //1
{ 

//#if 326076347 
LOG.error("Exception instantiating file persister " + clazz, e);
//#endif 


//#if 1634312922 
return null;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1790945926 
public boolean accept(File f)
    { 

//#if -1961029548 
if(f == null)//1
{ 

//#if 220892307 
return false;
//#endif 

} 

//#endif 


//#if -526478877 
if(f.isDirectory())//1
{ 

//#if 1621487785 
return true;
//#endif 

} 

//#endif 


//#if 337799006 
String s = getExtension(f);
//#endif 


//#if 1655817405 
if(s != null)//1
{ 

//#if 817695931 
if(s.equalsIgnoreCase(getExtension()))//1
{ 

//#if -957508022 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1484413682 
return false;
//#endif 

} 

//#endif 


//#if -459252672 
public abstract String getExtension();
//#endif 


//#if -539260490 
private static String getExtension(File f)
    { 

//#if 1440564432 
if(f == null)//1
{ 

//#if 179952448 
return null;
//#endif 

} 

//#endif 


//#if 1900682627 
return getExtension(f.getName());
//#endif 

} 

//#endif 


//#if -5935441 
public abstract Project doLoad(File file)
    throws OpenException, InterruptedException;
//#endif 


//#if 1393590113 
protected abstract String getDesc();
//#endif 


//#if -341235813 
private void preSave(Project project, File file) throws SaveException
    { 

//#if 1484784213 
if(project == null && file == null)//1
{ 

//#if -182326257 
throw new SaveException("No project nor file given");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 240696845 
class ProgressMgr implements 
//#if -774110251 
ProgressListener
//#endif 

  { 

//#if -1092744219 
private int percentPhasesComplete;
//#endif 


//#if 1242812424 
private int phasesCompleted;
//#endif 


//#if 554833283 
private int numberOfPhases;
//#endif 


//#if -793602819 
public int getNumberOfPhases()
        { 

//#if -1406576255 
return this.numberOfPhases;
//#endif 

} 

//#endif 


//#if 1623422105 
protected void fireProgressEvent(long percent)
        throws InterruptedException
        { 

//#if 257631959 
ProgressEvent event = null;
//#endif 


//#if -1375576164 
Object[] listeners = listenerList.getListenerList();
//#endif 


//#if 265081636 
for (int i = listeners.length - 2; i >= 0; i -= 2) //1
{ 

//#if 2135991049 
if(listeners[i] == ProgressListener.class)//1
{ 

//#if -1016659337 
if(event == null)//1
{ 

//#if -778613560 
event = new ProgressEvent(this, percent, 100);
//#endif 

} 

//#endif 


//#if 354310575 
((ProgressListener) listeners[i + 1]).progress(event);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 677392320 
public void setNumberOfPhases(int aNumberOfPhases)
        { 

//#if 1353181613 
this.numberOfPhases = aNumberOfPhases;
//#endif 

} 

//#endif 


//#if -1153153579 
protected void nextPhase() throws InterruptedException
        { 

//#if 557717001 
ThreadUtils.checkIfInterrupted();
//#endif 


//#if 1697701621 
++phasesCompleted;
//#endif 


//#if -989088265 
percentPhasesComplete =
                (phasesCompleted * 100) / numberOfPhases;
//#endif 


//#if -1162130870 
fireProgressEvent(percentPhasesComplete);
//#endif 

} 

//#endif 


//#if -959934904 
public void setPercentPhasesComplete(int aPercentPhasesComplete)
        { 

//#if 1171805254 
this.percentPhasesComplete = aPercentPhasesComplete;
//#endif 

} 

//#endif 


//#if -1563105236 
public void progress(ProgressEvent event) throws InterruptedException
        { 

//#if 1402882470 
ThreadUtils.checkIfInterrupted();
//#endif 


//#if -1352808071 
int percentPhasesLeft = 100 - percentPhasesComplete;
//#endif 


//#if 1671536023 
long position = event.getPosition();
//#endif 


//#if 1578405981 
long length = event.getLength();
//#endif 


//#if 1868014427 
long proportion = (position * percentPhasesLeft) / length;
//#endif 


//#if -1801067486 
fireProgressEvent(percentPhasesComplete + proportion);
//#endif 

} 

//#endif 


//#if 1834802062 
public void setPhasesCompleted(int aPhasesCompleted)
        { 

//#if -1669019673 
this.phasesCompleted = aPhasesCompleted;
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

