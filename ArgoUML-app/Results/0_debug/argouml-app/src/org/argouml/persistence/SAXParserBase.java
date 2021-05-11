
//#if 1940680421 
// Compilation Unit of /SAXParserBase.java 
 

//#if 991934582 
package org.argouml.persistence;
//#endif 


//#if 69385943 
import java.io.FileInputStream;
//#endif 


//#if -1931616740 
import java.io.IOException;
//#endif 


//#if 345060411 
import java.io.InputStream;
//#endif 


//#if -1183419666 
import java.io.Reader;
//#endif 


//#if -587442693 
import java.net.URL;
//#endif 


//#if -1115243860 
import javax.xml.parsers.ParserConfigurationException;
//#endif 


//#if 511039721 
import javax.xml.parsers.SAXParser;
//#endif 


//#if 1596521507 
import javax.xml.parsers.SAXParserFactory;
//#endif 


//#if -1039266191 
import org.xml.sax.Attributes;
//#endif 


//#if 2123525449 
import org.xml.sax.InputSource;
//#endif 


//#if 1025935043 
import org.xml.sax.SAXException;
//#endif 


//#if -477108394 
import org.xml.sax.helpers.DefaultHandler;
//#endif 


//#if 537147215 
import org.apache.log4j.Logger;
//#endif 


//#if -1666157683 
abstract class SAXParserBase extends 
//#if -188004359 
DefaultHandler
//#endif 

  { 

//#if 1448096763 
private   static  XMLElement[]  elements      = new XMLElement[100];
//#endif 


//#if -1551337711 
private   static  int           nElements     = 0;
//#endif 


//#if 1451155591 
private   static  XMLElement[]  freeElements  = new XMLElement[100];
//#endif 


//#if -1584341755 
private   static  int           nFreeElements = 0;
//#endif 


//#if -434874904 
private   static  boolean       stats         = true;
//#endif 


//#if 1329493765 
private   static  long          parseTime     = 0;
//#endif 


//#if 1602942292 
private static final Logger LOG = Logger.getLogger(SAXParserBase.class);
//#endif 


//#if -770765750 
protected static final boolean DBG = false;
//#endif 


//#if -633410386 
public InputSource resolveEntity (String publicId, String systemId)
    throws SAXException
    { 

//#if 939849746 
try //1
{ 

//#if 1596147718 
URL testIt = new URL(systemId);
//#endif 


//#if 1295599356 
InputSource s = new InputSource(testIt.openStream());
//#endif 


//#if -714528298 
return s;
//#endif 

} 

//#if 1837680486 
catch (Exception e) //1
{ 

//#if -1186546407 
LOG.info("NOTE: Could not open DTD " + systemId
                     + " due to exception");
//#endif 


//#if 554317726 
String dtdName = systemId.substring(systemId.lastIndexOf('/') + 1);
//#endif 


//#if -1148389659 
String dtdPath = "/org/argouml/persistence/" + dtdName;
//#endif 


//#if 1191001303 
InputStream is = SAXParserBase.class.getResourceAsStream(dtdPath);
//#endif 


//#if -1731475307 
if(is == null)//1
{ 

//#if -1700070472 
try //1
{ 

//#if -586201442 
is = new FileInputStream(dtdPath.substring(1));
//#endif 

} 

//#if -1441274268 
catch (Exception ex) //1
{ 

//#if 545336819 
throw new SAXException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1321760128 
return new InputSource(is);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -321109573 
public void startElement(String uri,
                             String localname,
                             String name,
                             Attributes atts) throws SAXException
    { 

//#if -2046119836 
if(isElementOfInterest(name))//1
{ 

//#if -122669619 
XMLElement element = createXmlElement(name, atts);
//#endif 


//#if 1166317517 
if(LOG.isDebugEnabled())//1
{ 

//#if -1698759062 
StringBuffer buf = new StringBuffer();
//#endif 


//#if 1762677007 
buf.append("START: ").append(name).append(' ').append(element);
//#endif 


//#if -637300749 
for (int i = 0; i < atts.getLength(); i++) //1
{ 

//#if -176037768 
buf.append("   ATT: ")
                    .append(atts.getLocalName(i))
                    .append(' ')
                    .append(atts.getValue(i));
//#endif 

} 

//#endif 


//#if -897533025 
LOG.debug(buf.toString());
//#endif 

} 

//#endif 


//#if 40893609 
elements[nElements++] = element;
//#endif 


//#if 405865233 
handleStartElement(element);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1604002322 
protected boolean isElementOfInterest(String name)
    { 

//#if -98304951 
return true;
//#endif 

} 

//#endif 


//#if -424049248 
public long getParseTime()
    { 

//#if -1476004984 
return parseTime;
//#endif 

} 

//#endif 


//#if 1211372665 
public boolean getStats()
    { 

//#if -108403395 
return stats;
//#endif 

} 

//#endif 


//#if -1173844289 
private XMLElement createXmlElement(String name, Attributes atts)
    { 

//#if -194916592 
if(nFreeElements == 0)//1
{ 

//#if 1300129857 
return new XMLElement(name, atts);
//#endif 

} 

//#endif 


//#if -1756914378 
XMLElement e = freeElements[--nFreeElements];
//#endif 


//#if 707959011 
e.setName(name);
//#endif 


//#if -1284625538 
e.setAttributes(atts);
//#endif 


//#if 1447325161 
e.resetText();
//#endif 


//#if -380965016 
return e;
//#endif 

} 

//#endif 


//#if -879096620 
public void parse(InputSource input) throws SAXException
    { 

//#if 2060910735 
long start, end;
//#endif 


//#if 1424405205 
SAXParserFactory factory = SAXParserFactory.newInstance();
//#endif 


//#if -471284635 
factory.setNamespaceAware(false);
//#endif 


//#if 1229916533 
factory.setValidating(false);
//#endif 


//#if -1738830081 
try //1
{ 

//#if 404994980 
SAXParser parser = factory.newSAXParser();
//#endif 


//#if -1926522635 
if(input.getSystemId() == null)//1
{ 

//#if 682051375 
input.setSystemId(getJarResource("org.argouml.kernel.Project"));
//#endif 

} 

//#endif 


//#if -708543490 
start = System.currentTimeMillis();
//#endif 


//#if 1151807394 
parser.parse(input, this);
//#endif 


//#if 1705278455 
end = System.currentTimeMillis();
//#endif 


//#if -2052847364 
parseTime = end - start;
//#endif 

} 

//#if -145016259 
catch (IOException e) //1
{ 

//#if -333402046 
throw new SAXException(e);
//#endif 

} 

//#endif 


//#if -607810180 
catch (ParserConfigurationException e) //1
{ 

//#if 103209508 
throw new SAXException(e);
//#endif 

} 

//#endif 


//#endif 


//#if -1233060949 
if(stats && LOG.isInfoEnabled())//1
{ 

//#if -1428798926 
LOG.info("Elapsed time: " + (end - start) + " ms");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -721974957 
public void parse(Reader reader) throws SAXException
    { 

//#if 1393800527 
parse(new InputSource(reader));
//#endif 

} 

//#endif 


//#if 980711040 
public void    setStats(boolean s)
    { 

//#if 932057233 
stats = s;
//#endif 

} 

//#endif 


//#if -1707142955 
public void notImplemented(XMLElement e)
    { 

//#if -986449754 
if(LOG.isDebugEnabled())//1
{ 

//#if -1992587879 
LOG.debug("NOTE: element not implemented: " + e.getName());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1771160301 
protected abstract void handleStartElement(XMLElement e)
    throws SAXException;
//#endif 


//#if -1817105907 
public void endElement(String uri, String localname, String name)
    throws SAXException
    { 

//#if -2071377242 
if(isElementOfInterest(name))//1
{ 

//#if -2069542600 
XMLElement e = elements[--nElements];
//#endif 


//#if -156530918 
if(LOG.isDebugEnabled())//1
{ 

//#if -589025474 
StringBuffer buf = new StringBuffer();
//#endif 


//#if -512553889 
buf.append("END: " + e.getName() + " ["
                           + e.getText() + "] " + e + "\n");
//#endif 


//#if 1163413999 
for (int i = 0; i < e.getNumAttributes(); i++) //1
{ 

//#if -1726127791 
buf.append("   ATT: " + e.getAttributeName(i) + " "
                               + e.getAttributeValue(i) + "\n");
//#endif 

} 

//#endif 


//#if -1937699316 
LOG.debug(buf);
//#endif 

} 

//#endif 


//#if 2067351540 
handleEndElement(e);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1854045214 
public SAXParserBase()
    { 
} 

//#endif 


//#if -1216952044 
public void ignoreElement(XMLElement e)
    { 

//#if 704956689 
if(LOG.isDebugEnabled())//1
{ 

//#if 493182884 
LOG.debug("NOTE: ignoring tag:" + e.getName());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1904407419 
public String getJarResource(String cls)
    { 

//#if 892060833 
String jarFile = "";
//#endif 


//#if -2099694196 
String fileSep = System.getProperty("file.separator");
//#endif 


//#if -1317738088 
String classFile = cls.replace('.', fileSep.charAt(0)) + ".class";
//#endif 


//#if 1027268370 
ClassLoader thisClassLoader = this.getClass().getClassLoader();
//#endif 


//#if -853851961 
URL url = thisClassLoader.getResource(classFile);
//#endif 


//#if -21442062 
if(url != null)//1
{ 

//#if -762802630 
String urlString = url.getFile();
//#endif 


//#if 2142940498 
int idBegin = urlString.indexOf("file:");
//#endif 


//#if 96502657 
int idEnd = urlString.indexOf("!");
//#endif 


//#if -1085950788 
if(idBegin > -1 && idEnd > -1 && idEnd > idBegin)//1
{ 

//#if -1812595301 
jarFile = urlString.substring(idBegin + 5, idEnd);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -84053225 
return jarFile;
//#endif 

} 

//#endif 


//#if 839240865 
public void characters(char[] ch, int start, int length)
    throws SAXException
    { 

//#if -77324534 
elements[nElements - 1].addText(ch, start, length);
//#endif 

} 

//#endif 


//#if -69988954 
protected abstract void handleEndElement(XMLElement e)
    throws SAXException;
//#endif 

 } 

//#endif 


//#endif 

