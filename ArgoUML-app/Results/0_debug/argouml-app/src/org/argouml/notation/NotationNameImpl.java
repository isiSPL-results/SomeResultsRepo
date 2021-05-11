
//#if -1411575429 
// Compilation Unit of /NotationNameImpl.java 
 

//#if -123093362 
package org.argouml.notation;
//#endif 


//#if 1862854497 
import java.util.ArrayList;
//#endif 


//#if 2074648803 
import java.util.Collections;
//#endif 


//#if -210274720 
import java.util.List;
//#endif 


//#if -2047039854 
import java.util.ListIterator;
//#endif 


//#if -219195267 
import javax.swing.Icon;
//#endif 


//#if 852420783 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 773531782 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 874258649 
import org.argouml.application.events.ArgoNotationEvent;
//#endif 


//#if -660337058 
import org.apache.log4j.Logger;
//#endif 


//#if 1884161549 
class NotationNameImpl implements 
//#if -1460210498 
NotationName
//#endif 

  { 

//#if -1878439347 
private String name;
//#endif 


//#if -987503098 
private String version;
//#endif 


//#if -586564041 
private Icon icon;
//#endif 


//#if -1569249386 
private static ArrayList<NotationName> notations =
        new ArrayList<NotationName>();
//#endif 


//#if 1561600810 
private static final Logger LOG = Logger.getLogger(NotationNameImpl.class);
//#endif 


//#if -1832506025 
public String getName()
    { 

//#if -1415364249 
return name;
//#endif 

} 

//#endif 


//#if 1450745440 
static String getNotationNameString(String k1, String k2)
    { 

//#if -764297227 
if(k2 == null)//1
{ 

//#if 1732515300 
return k1;
//#endif 

} 

//#endif 


//#if 1175315248 
if(k2.equals(""))//1
{ 

//#if -126191855 
return k1;
//#endif 

} 

//#endif 


//#if 1193013042 
return k1 + " " + k2;
//#endif 

} 

//#endif 


//#if -896245459 
static List<NotationName> getAvailableNotations()
    { 

//#if 1738044637 
return Collections.unmodifiableList(notations);
//#endif 

} 

//#endif 


//#if -457727620 
public boolean sameNotationAs(NotationName nn)
    { 

//#if -1302264552 
return this.getConfigurationValue().equals(nn.getConfigurationValue());
//#endif 

} 

//#endif 


//#if -1386185256 
static NotationName getNotation(String k1, String k2)
    { 

//#if -549280685 
return findNotation(getNotationNameString(k1, k2));
//#endif 

} 

//#endif 


//#if -548593228 
protected NotationNameImpl(String myName, String myVersion, Icon myIcon)
    { 

//#if 1778623316 
name = myName;
//#endif 


//#if -2035006282 
version = myVersion;
//#endif 


//#if -1945496812 
icon = myIcon;
//#endif 

} 

//#endif 


//#if -1445537938 
public String getVersion()
    { 

//#if 1595106054 
return version;
//#endif 

} 

//#endif 


//#if 292707886 
public String getTitle()
    { 

//#if -1823629919 
String myName = name;
//#endif 


//#if -1771721034 
if(myName.equalsIgnoreCase("uml"))//1
{ 

//#if 1037569598 
myName = myName.toUpperCase();
//#endif 

} 

//#endif 


//#if 700328824 
if(version == null || version.equals(""))//1
{ 

//#if 796716019 
return myName;
//#endif 

} 

//#endif 


//#if -250844240 
return myName + " " + version;
//#endif 

} 

//#endif 


//#if -704729635 
public Icon getIcon()
    { 

//#if -629403154 
return icon;
//#endif 

} 

//#endif 


//#if 284846908 
protected NotationNameImpl(String theName)
    { 

//#if 1556432646 
this(theName, null, null);
//#endif 

} 

//#endif 


//#if 663000487 
public String getConfigurationValue()
    { 

//#if -591909640 
return getNotationNameString(name, version);
//#endif 

} 

//#endif 


//#if 1106561480 
static NotationName findNotation(String s)
    { 

//#if -1277418485 
ListIterator iterator = notations.listIterator();
//#endif 


//#if 2014302602 
while (iterator.hasNext()) //1
{ 

//#if 1699200002 
try //1
{ 

//#if 1843838485 
NotationName nn = (NotationName) iterator.next();
//#endif 


//#if -1594010284 
if(s.equals(nn.getConfigurationValue()))//1
{ 

//#if -1442408796 
return nn;
//#endif 

} 

//#endif 

} 

//#if 1808728496 
catch (Exception e) //1
{ 

//#if -108996460 
LOG.error("Unexpected exception", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1433552007 
return null;
//#endif 

} 

//#endif 


//#if -1956930184 
public String toString()
    { 

//#if -1935600172 
return getTitle();
//#endif 

} 

//#endif 


//#if 769033788 
static boolean removeNotation(NotationName theNotation)
    { 

//#if -1315587534 
return notations.remove(theNotation);
//#endif 

} 

//#endif 


//#if -1888686131 
private static void fireEvent(int eventType, NotationName nn)
    { 

//#if -1024412414 
ArgoEventPump.fireEvent(new ArgoNotationEvent(eventType, nn));
//#endif 

} 

//#endif 


//#if -1137451700 
static NotationName makeNotation(String k1, String k2, Icon icon)
    { 

//#if -649221279 
NotationName nn = null;
//#endif 


//#if -1371303537 
nn = findNotation(getNotationNameString(k1, k2));
//#endif 


//#if -2114708067 
if(nn == null)//1
{ 

//#if 505202899 
nn = new NotationNameImpl(k1, k2, icon);
//#endif 


//#if 228206053 
notations.add(nn);
//#endif 


//#if -1303638888 
fireEvent(ArgoEventTypes.NOTATION_ADDED, nn);
//#endif 

} 

//#endif 


//#if 1441981454 
return nn;
//#endif 

} 

//#endif 


//#if 2001606578 
protected NotationNameImpl(String theName, String theVersion)
    { 

//#if 1276290665 
this(theName, theVersion, null);
//#endif 

} 

//#endif 


//#if -2023305929 
protected NotationNameImpl(String theName, Icon theIcon)
    { 

//#if 1938834878 
this(theName, null, theIcon);
//#endif 

} 

//#endif 


//#if -476649386 
static NotationName getNotation(String k1)
    { 

//#if 1462011254 
return findNotation(getNotationNameString(k1, null));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

