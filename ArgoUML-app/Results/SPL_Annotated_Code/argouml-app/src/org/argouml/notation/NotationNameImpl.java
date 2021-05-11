// Compilation Unit of /NotationNameImpl.java 
 
package org.argouml.notation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import javax.swing.Icon;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoNotationEvent;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

class NotationNameImpl implements NotationName
  { 
private String name;
private String version;
private Icon icon;
private static ArrayList<NotationName> notations =
        new ArrayList<NotationName>();

//#if LOGGING 
private static final Logger LOG = Logger.getLogger(NotationNameImpl.class);
//#endif 

public String getName()
    { 
return name;
} 

static String getNotationNameString(String k1, String k2)
    { 
if(k2 == null)//1
{ 
return k1;
} 

if(k2.equals(""))//1
{ 
return k1;
} 

return k1 + " " + k2;
} 

static List<NotationName> getAvailableNotations()
    { 
return Collections.unmodifiableList(notations);
} 

public boolean sameNotationAs(NotationName nn)
    { 
return this.getConfigurationValue().equals(nn.getConfigurationValue());
} 

static NotationName getNotation(String k1, String k2)
    { 
return findNotation(getNotationNameString(k1, k2));
} 

protected NotationNameImpl(String myName, String myVersion, Icon myIcon)
    { 
name = myName;
version = myVersion;
icon = myIcon;
} 

public String getVersion()
    { 
return version;
} 

public String getTitle()
    { 
String myName = name;
if(myName.equalsIgnoreCase("uml"))//1
{ 
myName = myName.toUpperCase();
} 

if(version == null || version.equals(""))//1
{ 
return myName;
} 

return myName + " " + version;
} 

public Icon getIcon()
    { 
return icon;
} 

protected NotationNameImpl(String theName)
    { 
this(theName, null, null);
} 

public String getConfigurationValue()
    { 
return getNotationNameString(name, version);
} 

static NotationName findNotation(String s)
    { 
ListIterator iterator = notations.listIterator();
while (iterator.hasNext()) //1
{ 
try //1
{ 
NotationName nn = (NotationName) iterator.next();
if(s.equals(nn.getConfigurationValue()))//1
{ 
return nn;
} 

} 
catch (Exception e) //1
{ 

//#if LOGGING 
LOG.error("Unexpected exception", e);
//#endif 

} 


} 

return null;
} 

public String toString()
    { 
return getTitle();
} 

static boolean removeNotation(NotationName theNotation)
    { 
return notations.remove(theNotation);
} 

private static void fireEvent(int eventType, NotationName nn)
    { 
ArgoEventPump.fireEvent(new ArgoNotationEvent(eventType, nn));
} 

static NotationName makeNotation(String k1, String k2, Icon icon)
    { 
NotationName nn = null;
nn = findNotation(getNotationNameString(k1, k2));
if(nn == null)//1
{ 
nn = new NotationNameImpl(k1, k2, icon);
notations.add(nn);
fireEvent(ArgoEventTypes.NOTATION_ADDED, nn);
} 

return nn;
} 

protected NotationNameImpl(String theName, String theVersion)
    { 
this(theName, theVersion, null);
} 

protected NotationNameImpl(String theName, Icon theIcon)
    { 
this(theName, null, theIcon);
} 

static NotationName getNotation(String k1)
    { 
return findNotation(getNotationNameString(k1, null));
} 

 } 


