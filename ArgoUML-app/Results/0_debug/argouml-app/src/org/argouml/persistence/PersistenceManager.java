
//#if 1481052913 
// Compilation Unit of /PersistenceManager.java 
 

//#if -871565451 
package org.argouml.persistence;
//#endif 


//#if 634607403 
import java.awt.Component;
//#endif 


//#if 30307412 
import java.io.ByteArrayOutputStream;
//#endif 


//#if -1911963564 
import java.io.File;
//#endif 


//#if 873955737 
import java.io.PrintStream;
//#endif 


//#if 246933929 
import java.io.UnsupportedEncodingException;
//#endif 


//#if -91694307 
import java.net.URI;
//#endif 


//#if -1747383539 
import java.net.URISyntaxException;
//#endif 


//#if 1467371123 
import java.util.ArrayList;
//#endif 


//#if -416537266 
import java.util.Collection;
//#endif 


//#if 1138904510 
import java.util.Iterator;
//#endif 


//#if -268014578 
import java.util.List;
//#endif 


//#if 586476623 
import javax.swing.JFileChooser;
//#endif 


//#if -1757689941 
import javax.swing.JOptionPane;
//#endif 


//#if -1920975103 
import javax.swing.filechooser.FileFilter;
//#endif 


//#if 1577161924 
import org.argouml.application.api.Argo;
//#endif 


//#if 168586569 
import org.argouml.configuration.Configuration;
//#endif 


//#if 1546285582 
import org.argouml.configuration.ConfigurationKey;
//#endif 


//#if 695477917 
import org.argouml.i18n.Translator;
//#endif 


//#if 555630663 
import org.argouml.kernel.Project;
//#endif 


//#if 1562801208 
import org.tigris.gef.util.UnexpectedException;
//#endif 


//#if 1880585049 
class MultitypeFileFilter extends 
//#if -870677162 
FileFilter
//#endif 

  { 

//#if -1010971804 
private ArrayList<FileFilter> filters;
//#endif 


//#if -294334496 
private ArrayList<String> extensions;
//#endif 


//#if -566190088 
private String desc;
//#endif 


//#if -576948605 
public Collection<FileFilter> getAll()
    { 

//#if 2145798728 
return filters;
//#endif 

} 

//#endif 


//#if 1237968363 
@Override
    public String getDescription()
    { 

//#if 2014256724 
Object[] s = {desc};
//#endif 


//#if 1629010524 
return Translator.messageFormat("filechooser.all-types-desc", s);
//#endif 

} 

//#endif 


//#if -2143119395 
public MultitypeFileFilter()
    { 

//#if 1566995301 
super();
//#endif 


//#if 418299917 
filters = new ArrayList<FileFilter>();
//#endif 


//#if 458389295 
extensions = new ArrayList<String>();
//#endif 

} 

//#endif 


//#if 1568256980 
public void add(AbstractFilePersister filter)
    { 

//#if 281208719 
filters.add(filter);
//#endif 


//#if -1652790091 
String extension = filter.getExtension();
//#endif 


//#if -651076510 
if(!extensions.contains(extension))//1
{ 

//#if 610961017 
extensions.add(filter.getExtension());
//#endif 


//#if -71836893 
desc =
                ((desc == null)
                 ? ""
                 : desc + ", ")
                + "*." + extension;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -693364824 
@Override
    public boolean accept(File arg0)
    { 

//#if 1298974647 
for (FileFilter ff : filters) //1
{ 

//#if 176491492 
if(ff.accept(arg0))//1
{ 

//#if 1073618363 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -187300509 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 923396963 
public final class PersistenceManager  { 

//#if -81588415 
private static final PersistenceManager INSTANCE =
        new PersistenceManager();
//#endif 


//#if -1612200325 
private AbstractFilePersister defaultPersister;
//#endif 


//#if -1813519733 
private List<AbstractFilePersister> otherPersisters =
        new ArrayList<AbstractFilePersister>();
//#endif 


//#if -1411018647 
private UmlFilePersister quickViewDump;
//#endif 


//#if -1955134438 
private XmiFilePersister xmiPersister;
//#endif 


//#if 1243946077 
private XmiFilePersister xmlPersister;
//#endif 


//#if -1365275238 
private UmlFilePersister umlPersister;
//#endif 


//#if 2089451444 
private ZipFilePersister zipPersister;
//#endif 


//#if -300965449 
private AbstractFilePersister savePersister;
//#endif 


//#if 1817756866 
public static final ConfigurationKey KEY_PROJECT_NAME_PATH =
        Configuration.makeKey("project", "name", "path");
//#endif 


//#if 1878980014 
public static final ConfigurationKey KEY_OPEN_PROJECT_PATH =
        Configuration.makeKey("project", "open", "path");
//#endif 


//#if -1970822120 
public static final ConfigurationKey KEY_IMPORT_XMI_PATH =
        Configuration.makeKey("xmi", "import", "path");
//#endif 


//#if 270903468 
private DiagramMemberFilePersister diagramMemberFilePersister
        = new DiagramMemberFilePersister();
//#endif 


//#if -1430485509 
public String getDefaultExtension()
    { 

//#if 2007596527 
return defaultPersister.getExtension();
//#endif 

} 

//#endif 


//#if 459884807 
public static PersistenceManager getInstance()
    { 

//#if 622290286 
return INSTANCE;
//#endif 

} 

//#endif 


//#if 580033155 
public void setOpenFileChooserFilter(JFileChooser chooser)
    { 

//#if 1221669507 
MultitypeFileFilter mf = new MultitypeFileFilter();
//#endif 


//#if -1675978309 
mf.add(defaultPersister);
//#endif 


//#if -1652160174 
chooser.addChoosableFileFilter(mf);
//#endif 


//#if 1124461049 
chooser.addChoosableFileFilter(defaultPersister);
//#endif 


//#if -1809693764 
Iterator iter = otherPersisters.iterator();
//#endif 


//#if -1442569750 
while (iter.hasNext()) //1
{ 

//#if 1003468774 
AbstractFilePersister ff = (AbstractFilePersister) iter.next();
//#endif 


//#if 1609170456 
if(ff.isLoadEnabled())//1
{ 

//#if -2128885722 
mf.add(ff);
//#endif 


//#if -44028956 
chooser.addChoosableFileFilter(ff);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2120461603 
chooser.setFileFilter(mf);
//#endif 

} 

//#endif 


//#if 1962404923 
public URI fixUriExtension(URI in)
    { 

//#if 327628887 
URI newUri;
//#endif 


//#if 1842602681 
String n = in.toString();
//#endif 


//#if -1775421371 
n = fixExtension(n);
//#endif 


//#if -294184502 
try //1
{ 

//#if 84323908 
newUri = new URI(n);
//#endif 

} 

//#if -1823911097 
catch (java.net.URISyntaxException e) //1
{ 

//#if -358443707 
throw new UnexpectedException(e);
//#endif 

} 

//#endif 


//#endif 


//#if -1042865845 
return newUri;
//#endif 

} 

//#endif 


//#if -1132931676 
public void register(AbstractFilePersister fp)
    { 

//#if 433270843 
otherPersisters.add(fp);
//#endif 

} 

//#endif 


//#if -998435395 
public void setProjectURI(URI theUri, Project p)
    { 

//#if 1942738152 
if(theUri != null)//1
{ 

//#if 1873661688 
theUri = fixUriExtension(theUri);
//#endif 

} 

//#endif 


//#if -722181468 
p.setUri(theUri);
//#endif 

} 

//#endif 


//#if -855121085 
public String getProjectBaseName(Project p)
    { 

//#if 953707970 
URI uri = p.getUri();
//#endif 


//#if 813152401 
String name = Translator.localize("label.projectbrowser-title");
//#endif 


//#if -7333947 
if(uri != null)//1
{ 

//#if 1646272242 
name = new File(uri).getName();
//#endif 

} 

//#endif 


//#if 252498684 
return getBaseName(name);
//#endif 

} 

//#endif 


//#if -12388759 
public AbstractFilePersister getSavePersister()
    { 

//#if -509642984 
return savePersister;
//#endif 

} 

//#endif 


//#if -761137605 
public AbstractFilePersister getPersisterFromFileName(String name)
    { 

//#if 309835856 
if(defaultPersister.isFileExtensionApplicable(name))//1
{ 

//#if 323448943 
return defaultPersister;
//#endif 

} 

//#endif 


//#if -1321470672 
for (AbstractFilePersister persister : otherPersisters) //1
{ 

//#if -330243680 
if(persister.isFileExtensionApplicable(name))//1
{ 

//#if -79050717 
return persister;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -513560127 
return null;
//#endif 

} 

//#endif 


//#if 108096962 
public void setSavePersister(AbstractFilePersister persister)
    { 

//#if 845588261 
savePersister = persister;
//#endif 

} 

//#endif 


//#if 1338031435 
public String getQuickViewDump(Project project)
    { 

//#if -1639675784 
ByteArrayOutputStream stream = new ByteArrayOutputStream();
//#endif 


//#if 1309265211 
try //1
{ 

//#if -1797068117 
quickViewDump.writeProject(project, stream, null);
//#endif 

} 

//#if -1946181161 
catch (Exception e) //1
{ 

//#if 1484598027 
e.printStackTrace(new PrintStream(stream));
//#endif 

} 

//#endif 


//#endif 


//#if 1721962390 
try //2
{ 

//#if 1481044093 
return stream.toString(Argo.getEncoding());
//#endif 

} 

//#if -1906355233 
catch (UnsupportedEncodingException e) //1
{ 

//#if 121303185 
return e.toString();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1422948061 
public void setProjectName(final String n, Project p)
    throws URISyntaxException
    { 

//#if -1263527643 
String s = "";
//#endif 


//#if -2117512240 
if(p.getURI() != null)//1
{ 

//#if 561809241 
s = p.getURI().toString();
//#endif 

} 

//#endif 


//#if 1077922732 
s = s.substring(0, s.lastIndexOf("/") + 1) + n;
//#endif 


//#if -1235494182 
setProjectURI(new URI(s), p);
//#endif 

} 

//#endif 


//#if -1880959325 
public void setXmiFileChooserFilter(JFileChooser chooser)
    { 

//#if -1910599187 
chooser.addChoosableFileFilter(xmiPersister);
//#endif 


//#if 1325341776 
chooser.setFileFilter(xmiPersister);
//#endif 

} 

//#endif 


//#if -1547937720 
public String getXmiExtension()
    { 

//#if 1731325937 
return xmiPersister.getExtension();
//#endif 

} 

//#endif 


//#if 1125588038 
public boolean confirmOverwrite(Component frame,
                                    boolean overwrite, File file)
    { 

//#if -1571440698 
if(file.exists() && !overwrite)//1
{ 

//#if 1213892790 
String sConfirm =
                Translator.messageFormat(
                    "optionpane.confirm-overwrite",
                    new Object[] {file});
//#endif 


//#if -801898201 
int nResult =
                JOptionPane.showConfirmDialog(
                    frame,
                    sConfirm,
                    Translator.localize(
                        "optionpane.confirm-overwrite-title"),
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
//#endif 


//#if -1336080881 
if(nResult != JOptionPane.YES_OPTION)//1
{ 

//#if -1708980539 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1147346701 
return true;
//#endif 

} 

//#endif 


//#if -1399051913 
DiagramMemberFilePersister getDiagramMemberFilePersister()
    { 

//#if 1925430424 
return diagramMemberFilePersister;
//#endif 

} 

//#endif 


//#if -713920405 
public void setDiagramMemberFilePersister(
        DiagramMemberFilePersister persister)
    { 

//#if 1254415046 
diagramMemberFilePersister = persister;
//#endif 

} 

//#endif 


//#if -1914978655 
public void setSaveFileChooserFilters(JFileChooser chooser,
                                          String fileName)
    { 

//#if -1192995558 
chooser.addChoosableFileFilter(defaultPersister);
//#endif 


//#if 711817698 
AbstractFilePersister defaultFileFilter = defaultPersister;
//#endif 


//#if -2031527860 
for (AbstractFilePersister fp : otherPersisters) //1
{ 

//#if -992074833 
if(fp.isSaveEnabled()
                    && !fp.equals(xmiPersister)
                    && !fp.equals(xmlPersister))//1
{ 

//#if 66459741 
chooser.addChoosableFileFilter(fp);
//#endif 


//#if -1552496238 
if(fileName != null
                        && fp.isFileExtensionApplicable(fileName))//1
{ 

//#if 1137315933 
defaultFileFilter = fp;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -200704592 
chooser.setFileFilter(defaultFileFilter);
//#endif 

} 

//#endif 


//#if 1782880028 
public String getBaseName(String n)
    { 

//#if -463410760 
AbstractFilePersister p = getPersisterFromFileName(n);
//#endif 


//#if 28701312 
if(p == null)//1
{ 

//#if 56298219 
return n;
//#endif 

} 

//#endif 


//#if -419051807 
int extLength = p.getExtension().length() + 1;
//#endif 


//#if -505943550 
return n.substring(0, n.length() - extLength);
//#endif 

} 

//#endif 


//#if 2107773711 
public String fixExtension(String in)
    { 

//#if 1484317807 
if(getPersisterFromFileName(in) == null)//1
{ 

//#if 2010320506 
in += "." + getDefaultExtension();
//#endif 

} 

//#endif 


//#if -1013814653 
return in;
//#endif 

} 

//#endif 


//#if 1520408274 
private PersistenceManager()
    { 

//#if -2142261190 
defaultPersister = new OldZargoFilePersister();
//#endif 


//#if 1219114422 
quickViewDump = new UmlFilePersister();
//#endif 


//#if 1127606627 
xmiPersister = new XmiFilePersister();
//#endif 


//#if -580149240 
otherPersisters.add(xmiPersister);
//#endif 


//#if -1363495063 
xmlPersister = new XmlFilePersister();
//#endif 


//#if -192901083 
otherPersisters.add(xmlPersister);
//#endif 


//#if 288445155 
umlPersister = new UmlFilePersister();
//#endif 


//#if 1323774792 
otherPersisters.add(umlPersister);
//#endif 


//#if 1258342781 
zipPersister = new ZipFilePersister();
//#endif 


//#if 485924571 
otherPersisters.add(zipPersister);
//#endif 

} 

//#endif 


//#if 1123992037 
public void addTranslation(
        final String originalClassName,
        final String newClassName)
    { 

//#if -1608505791 
getDiagramMemberFilePersister().addTranslation(
            originalClassName,
            newClassName);
//#endif 

} 

//#endif 


//#if -1561055631 
public String fixXmiExtension(String in)
    { 

//#if 1079900495 
if(getPersisterFromFileName(in) != xmiPersister)//1
{ 

//#if 610799654 
in += "." + getXmiExtension();
//#endif 

} 

//#endif 


//#if 1924727169 
return in;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

