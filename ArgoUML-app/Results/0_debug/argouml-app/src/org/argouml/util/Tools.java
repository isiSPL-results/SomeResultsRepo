
//#if -1495970323 
// Compilation Unit of /Tools.java 
 

//#if 1884014564 
package org.argouml.util;
//#endif 


//#if 2032611594 
import java.io.BufferedReader;
//#endif 


//#if -605847920 
import java.io.File;
//#endif 


//#if 1928462849 
import java.io.IOException;
//#endif 


//#if 380163544 
import java.io.StringReader;
//#endif 


//#if 1132961230 
import java.util.Locale;
//#endif 


//#if -949620322 
import javax.xml.parsers.SAXParserFactory;
//#endif 


//#if -706092876 
import org.apache.log4j.Logger;
//#endif 


//#if 1867950305 
import org.argouml.i18n.Translator;
//#endif 


//#if -936230086 
public class Tools  { 

//#if 761939475 
private static final Logger LOG = Logger.getLogger(Tools.class);
//#endif 


//#if 1742614749 
private static final String[] PACKAGELIST =
        new String[] {
        "org.argouml.application",
        // TODO: The following is MDR specific.  We need something generic
        // to all Model subsystems - tfm 20070716
        "org.netbeans.mdr",
        "org.tigris.gef.base",
        "org.xml.sax",
        "java.lang",
        "org.apache.log4j",
    };
//#endif 


//#if -1354547858 
private static void getComponentVersionInfo(StringBuffer sb, String pn)
    { 

//#if 723174042 
sb.append(Translator.localize("label.package")).append(": ");
//#endif 


//#if 1117847611 
sb.append(pn);
//#endif 


//#if -1594783541 
sb.append('\n');
//#endif 


//#if -536772763 
Package pkg = Package.getPackage(pn);
//#endif 


//#if 1721626252 
if(pkg == null)//1
{ 

//#if 1214860097 
sb.append(Translator.localize("label.no-version"));
//#endif 

} 
else
{ 

//#if 396172236 
String in = pkg.getImplementationTitle();
//#endif 


//#if 674007568 
if(in != null)//1
{ 

//#if 770399559 
sb.append(Translator.localize("label.component"));
//#endif 


//#if 1864118746 
sb.append(": ");
//#endif 


//#if 200845561 
sb.append(in);
//#endif 

} 

//#endif 


//#if -1340787111 
in = pkg.getImplementationVendor();
//#endif 


//#if 387425953 
if(in != null)//2
{ 

//#if -1024569398 
sb.append(Translator.localize("label.by"));
//#endif 


//#if -933341819 
sb.append(": ");
//#endif 


//#if 526246894 
sb.append(in);
//#endif 

} 

//#endif 


//#if 21771035 
in = pkg.getImplementationVersion();
//#endif 


//#if 387455745 
if(in != null)//3
{ 

//#if 531152641 
sb.append(", ");
//#endif 


//#if 2052656297 
sb.append(Translator.localize("label.version"));
//#endif 


//#if -259970085 
sb.append(" ");
//#endif 


//#if -257781888 
sb.append(in);
//#endif 


//#if -524400855 
sb.append('\n');
//#endif 

} 

//#endif 

} 

//#endif 


//#if 731805095 
sb.append('\n');
//#endif 

} 

//#endif 


//#if -1764895828 
public static String getFileExtension(File file)
    { 

//#if -477283634 
String ext = null;
//#endif 


//#if 767145719 
String s = file.getName();
//#endif 


//#if 750517976 
int i = s.lastIndexOf('.');
//#endif 


//#if 1227634545 
if(i > 0)//1
{ 

//#if 1992786042 
ext = s.substring(i).toLowerCase();
//#endif 

} 

//#endif 


//#if -110957053 
return ext;
//#endif 

} 

//#endif 


//#if 1828259719 
public static String getVersionInfo()
    { 

//#if -1896784602 
try //1
{ 

//#if -1907485541 
Class cls = org.tigris.gef.base.Editor.class;
//#endif 


//#if -647414066 
cls = org.xml.sax.AttributeList.class;
//#endif 


//#if -1742136183 
cls = org.apache.log4j.Logger.class;
//#endif 


//#if 565653557 
try //1
{ 

//#if 1792156177 
cls = Class.forName("org.netbeans.api.mdr.MDRManager");
//#endif 

} 

//#if -2033661503 
catch (ClassNotFoundException e) //1
{ 
} 

//#endif 


//#endif 


//#if -429561721 
StringBuffer sb = new StringBuffer();
//#endif 


//#if -1222019849 
String saxFactory =
                System.getProperty("javax.xml.parsers.SAXParserFactory");
//#endif 


//#if -1562995433 
if(saxFactory != null)//1
{ 

//#if 529510752 
Object[] msgArgs = {
                    saxFactory,
                };
//#endif 


//#if -957052721 
sb.append(Translator.messageFormat("label.sax-factory1",
                                                   msgArgs));
//#endif 

} 

//#endif 


//#if 1191510498 
Object saxObject = null;
//#endif 


//#if -2066476452 
try //2
{ 

//#if 1748046491 
saxObject = SAXParserFactory.newInstance();
//#endif 


//#if -1802203338 
Object[] msgArgs = {
                    saxObject.getClass().getName(),
                };
//#endif 


//#if 1281681602 
sb.append(Translator.messageFormat("label.sax-factory2",
                                                   msgArgs));
//#endif 


//#if -444063118 
sb.append("\n");
//#endif 

} 

//#if -1055890668 
catch (Exception ex) //1
{ 

//#if -926818805 
sb.append(Translator.localize("label.error-sax-factory"));
//#endif 

} 

//#endif 


//#endif 


//#if 1440712809 
for (int i = 0; i < PACKAGELIST.length; i++) //1
{ 

//#if 277492345 
getComponentVersionInfo(sb, PACKAGELIST[i]);
//#endif 

} 

//#endif 


//#if -1892831416 
if(saxObject != null)//1
{ 

//#if 957769434 
Package pckg = saxObject.getClass().getPackage();
//#endif 


//#if -2023269385 
if(pckg != null)//1
{ 

//#if -2076164824 
getComponentVersionInfo(sb, pckg.getName());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 237221966 
sb.append("\n");
//#endif 


//#if 497671776 
sb.append(Translator.localize("label.os"));
//#endif 


//#if -928088020 
sb.append(System.getProperty("os.name", "unknown"));
//#endif 


//#if 380372526 
sb.append('\n');
//#endif 


//#if -1341568533 
sb.append(Translator.localize("label.os-version"));
//#endif 


//#if 442855437 
sb.append(System.getProperty("os.version", "unknown"));
//#endif 


//#if 1554241892 
sb.append('\n');
//#endif 


//#if 1044458388 
sb.append(Translator.localize("label.language"));
//#endif 


//#if 571205797 
sb.append(Locale.getDefault().getLanguage());
//#endif 


//#if 1554241893 
sb.append('\n');
//#endif 


//#if -1515445396 
sb.append(Translator.localize("label.country"));
//#endif 


//#if -1946180625 
sb.append(Locale.getDefault().getCountry());
//#endif 


//#if 1554241894 
sb.append('\n');
//#endif 


//#if 1554241895 
sb.append('\n');
//#endif 


//#if 1934368958 
return sb.toString();
//#endif 

} 

//#if -1755863423 
catch (Exception e) //1
{ 

//#if 179153595 
return e.toString();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1309596412 
public static void logVersionInfo()
    { 

//#if -323426035 
BufferedReader r =
            new BufferedReader(new StringReader(getVersionInfo()));
//#endif 


//#if -150625844 
try //1
{ 

//#if 2011921974 
while (true) //1
{ 

//#if 37164004 
String s = r.readLine();
//#endif 


//#if -548315764 
if(s == null)//1
{ 

//#if -156762365 
break;

//#endif 

} 

//#endif 


//#if 1537811306 
LOG.info(s);
//#endif 

} 

//#endif 

} 

//#if 571153097 
catch (IOException ioe) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

