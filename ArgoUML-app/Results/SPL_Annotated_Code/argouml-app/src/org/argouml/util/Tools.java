// Compilation Unit of /Tools.java 
 
package org.argouml.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Locale;
import javax.xml.parsers.SAXParserFactory;
import org.apache.log4j.Logger;
import org.argouml.i18n.Translator;
public class Tools  { 
private static final Logger LOG = Logger.getLogger(Tools.class);
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
private static void getComponentVersionInfo(StringBuffer sb, String pn)
    { 
sb.append(Translator.localize("label.package")).append(": ");
sb.append(pn);
sb.append('\n');
Package pkg = Package.getPackage(pn);
if(pkg == null)//1
{ 
sb.append(Translator.localize("label.no-version"));
} 
else
{ 
String in = pkg.getImplementationTitle();
if(in != null)//1
{ 
sb.append(Translator.localize("label.component"));
sb.append(": ");
sb.append(in);
} 

in = pkg.getImplementationVendor();
if(in != null)//2
{ 
sb.append(Translator.localize("label.by"));
sb.append(": ");
sb.append(in);
} 

in = pkg.getImplementationVersion();
if(in != null)//3
{ 
sb.append(", ");
sb.append(Translator.localize("label.version"));
sb.append(" ");
sb.append(in);
sb.append('\n');
} 

} 

sb.append('\n');
} 

public static String getFileExtension(File file)
    { 
String ext = null;
String s = file.getName();
int i = s.lastIndexOf('.');
if(i > 0)//1
{ 
ext = s.substring(i).toLowerCase();
} 

return ext;
} 

public static String getVersionInfo()
    { 
try //1
{ 
Class cls = org.tigris.gef.base.Editor.class;
cls = org.xml.sax.AttributeList.class;
cls = org.apache.log4j.Logger.class;
try //1
{ 
cls = Class.forName("org.netbeans.api.mdr.MDRManager");
} 
catch (ClassNotFoundException e) //1
{ 
} 


StringBuffer sb = new StringBuffer();
String saxFactory =
                System.getProperty("javax.xml.parsers.SAXParserFactory");
if(saxFactory != null)//1
{ 
Object[] msgArgs = {
                    saxFactory,
                };
sb.append(Translator.messageFormat("label.sax-factory1",
                                                   msgArgs));
} 

Object saxObject = null;
try //2
{ 
saxObject = SAXParserFactory.newInstance();
Object[] msgArgs = {
                    saxObject.getClass().getName(),
                };
sb.append(Translator.messageFormat("label.sax-factory2",
                                                   msgArgs));
sb.append("\n");
} 
catch (Exception ex) //1
{ 
sb.append(Translator.localize("label.error-sax-factory"));
} 


for (int i = 0; i < PACKAGELIST.length; i++) //1
{ 
getComponentVersionInfo(sb, PACKAGELIST[i]);
} 

if(saxObject != null)//1
{ 
Package pckg = saxObject.getClass().getPackage();
if(pckg != null)//1
{ 
getComponentVersionInfo(sb, pckg.getName());
} 

} 

sb.append("\n");
sb.append(Translator.localize("label.os"));
sb.append(System.getProperty("os.name", "unknown"));
sb.append('\n');
sb.append(Translator.localize("label.os-version"));
sb.append(System.getProperty("os.version", "unknown"));
sb.append('\n');
sb.append(Translator.localize("label.language"));
sb.append(Locale.getDefault().getLanguage());
sb.append('\n');
sb.append(Translator.localize("label.country"));
sb.append(Locale.getDefault().getCountry());
sb.append('\n');
sb.append('\n');
return sb.toString();
} 
catch (Exception e) //1
{ 
return e.toString();
} 


} 

public static void logVersionInfo()
    { 
BufferedReader r =
            new BufferedReader(new StringReader(getVersionInfo()));
try //1
{ 
while (true) //1
{ 
String s = r.readLine();
if(s == null)//1
{ 
break;

} 

LOG.info(s);
} 

} 
catch (IOException ioe) //1
{ 
} 


} 

 } 


