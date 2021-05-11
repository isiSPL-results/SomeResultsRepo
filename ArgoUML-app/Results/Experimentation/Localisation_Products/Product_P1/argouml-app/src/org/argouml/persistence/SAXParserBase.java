package org.argouml.persistence;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
abstract class SAXParserBase extends DefaultHandler
  { 
private   static  XMLElement[]  elements      = new XMLElement[100];
private   static  int           nElements     = 0;
private   static  XMLElement[]  freeElements  = new XMLElement[100];
private   static  int           nFreeElements = 0;
private   static  boolean       stats         = true;
private   static  long          parseTime     = 0;
public InputSource resolveEntity (String publicId, String systemId)
    throws SAXException
    { 
try//1
{ 
URL testIt = new URL(systemId);
InputSource s = new InputSource(testIt.openStream());
return s;
} 
catch (Exception e) //1
{ 
String dtdName = systemId.substring(systemId.lastIndexOf('/') + 1);
String dtdPath = "/org/argouml/persistence/" + dtdName;
InputStream is = SAXParserBase.class.getResourceAsStream(dtdPath);
if(is == null)//1
{ 
try//1
{ 
is = new FileInputStream(dtdPath.substring(1));
} 
catch (Exception ex) //1
{ 
throw new SAXException(e);
} 
} 
return new InputSource(is);
} 
} 
public void startElement(String uri,
                             String localname,
                             String name,
                             Attributes atts) throws SAXException
    { 
if(isElementOfInterest(name))//1
{ 
XMLElement element = createXmlElement(name, atts);
elements[nElements++] = element;
handleStartElement(element);
} 
} 
protected boolean isElementOfInterest(String name)
    { 
return true;
} 
public long getParseTime()
    { 
return parseTime;
} 
public boolean getStats()
    { 
return stats;
} 
private XMLElement createXmlElement(String name, Attributes atts)
    { 
if(nFreeElements == 0)//1
{ 
return new XMLElement(name, atts);
} 
XMLElement e = freeElements[--nFreeElements];
e.setName(name);
e.setAttributes(atts);
e.resetText();
return e;
} 
public void parse(InputSource input) throws SAXException
    { 
long start, end;
SAXParserFactory factory = SAXParserFactory.newInstance();
factory.setNamespaceAware(false);
factory.setValidating(false);
try//1
{ 
SAXParser parser = factory.newSAXParser();
if(input.getSystemId() == null)//1
{ 
input.setSystemId(getJarResource("org.argouml.kernel.Project"));
} 
start = System.currentTimeMillis();
parser.parse(input, this);
end = System.currentTimeMillis();
parseTime = end - start;
} 
catch (IOException e) //1
{ 
throw new SAXException(e);
} 
catch (ParserConfigurationException e) //1
{ 
throw new SAXException(e);
} 
} 
public void parse(Reader reader) throws SAXException
    { 
parse(new InputSource(reader));
} 
public void    setStats(boolean s)
    { 
stats = s;
} 
public void notImplemented(XMLElement e)
    { 
} 
protected abstract void handleStartElement(XMLElement e)
    throws SAXException;public void endElement(String uri, String localname, String name)
    throws SAXException
    { 
if(isElementOfInterest(name))//1
{ 
XMLElement e = elements[--nElements];
handleEndElement(e);
} 
} 
public SAXParserBase()
    { 
} 
public void ignoreElement(XMLElement e)
    { 
} 
public String getJarResource(String cls)
    { 
String jarFile = "";
String fileSep = System.getProperty("file.separator");
String classFile = cls.replace('.', fileSep.charAt(0)) + ".class";
ClassLoader thisClassLoader = this.getClass().getClassLoader();
URL url = thisClassLoader.getResource(classFile);
if(url != null)//1
{ 
String urlString = url.getFile();
int idBegin = urlString.indexOf("file:");
int idEnd = urlString.indexOf("!");
if(idBegin > -1 && idEnd > -1 && idEnd > idBegin)//1
{ 
jarFile = urlString.substring(idBegin + 5, idEnd);
} 
} 
return jarFile;
} 
public void characters(char[] ch, int start, int length)
    throws SAXException
    { 
elements[nElements - 1].addText(ch, start, length);
} 
protected abstract void handleEndElement(XMLElement e)
    throws SAXException;
 } 
