
//#if 1289957071 
// Compilation Unit of /XmlInputStream.java 
 

//#if -1743246290 
package org.argouml.persistence;
//#endif 


//#if -1852257790 
import java.io.BufferedInputStream;
//#endif 


//#if -1955989660 
import java.io.IOException;
//#endif 


//#if 320687491 
import java.io.InputStream;
//#endif 


//#if 413019043 
import java.util.HashMap;
//#endif 


//#if 1925038391 
import java.util.Iterator;
//#endif 


//#if -2094389131 
import java.util.Map;
//#endif 


//#if 1557294231 
import org.apache.log4j.Logger;
//#endif 


//#if 787222362 
class XmlInputStream extends 
//#if 994300568 
BufferedInputStream
//#endif 

  { 

//#if 1730760217 
private boolean xmlStarted;
//#endif 


//#if 2070660254 
private boolean inTag;
//#endif 


//#if 866792420 
private StringBuffer currentTag = new StringBuffer();
//#endif 


//#if -2108194472 
private boolean endStream;
//#endif 


//#if -2096996105 
private String tagName;
//#endif 


//#if 120694928 
private String endTagName;
//#endif 


//#if -539691720 
private Map attributes;
//#endif 


//#if 886386763 
private boolean childOnly;
//#endif 


//#if -2030539904 
private int instanceCount;
//#endif 


//#if 240534670 
private static final Logger LOG =
        Logger.getLogger(XmlInputStream.class);
//#endif 


//#if 1520502520 
public XmlInputStream(
        InputStream inStream,
        String theTag,
        long theLength,
        long theEventSpacing)
    { 

//#if 1807146941 
super(inStream);
//#endif 


//#if 1961465665 
tagName = theTag;
//#endif 


//#if 2111001452 
endTagName = '/' + theTag;
//#endif 


//#if -61083513 
attributes = null;
//#endif 


//#if -196586234 
childOnly = false;
//#endif 

} 

//#endif 


//#if -1919984674 
public synchronized int read(byte[] b, int off, int len)
    throws IOException
    { 

//#if 2011189778 
if(!xmlStarted)//1
{ 

//#if 2027957016 
skipToTag();
//#endif 


//#if 1401312472 
xmlStarted = true;
//#endif 

} 

//#endif 


//#if -1800120638 
if(endStream)//1
{ 

//#if -605857516 
return -1;
//#endif 

} 

//#endif 


//#if -360566313 
int cnt;
//#endif 


//#if 1994741232 
for (cnt = 0; cnt < len; ++cnt) //1
{ 

//#if -450989830 
int read = read();
//#endif 


//#if -1320063141 
if(read == -1)//1
{ 

//#if 1317959718 
break;

//#endif 

} 

//#endif 


//#if 146190474 
b[cnt + off] = (byte) read;
//#endif 

} 

//#endif 


//#if 1039760610 
if(cnt > 0)//1
{ 

//#if -1717899994 
return cnt;
//#endif 

} 

//#endif 


//#if 19340253 
return -1;
//#endif 

} 

//#endif 


//#if 589454952 
public synchronized void reopen(String theTag)
    { 

//#if 1095720936 
endStream = false;
//#endif 


//#if -1057280643 
xmlStarted = false;
//#endif 


//#if -847490642 
inTag = false;
//#endif 


//#if -791848692 
tagName = theTag;
//#endif 


//#if -1359804607 
endTagName = '/' + theTag;
//#endif 


//#if 485517340 
attributes = null;
//#endif 


//#if 350014619 
childOnly = false;
//#endif 

} 

//#endif 


//#if -1183637279 
public synchronized void reopen(
        String theTag,
        Map attribs,
        boolean child)
    { 

//#if 2036334205 
endStream = false;
//#endif 


//#if -1963040376 
xmlStarted = false;
//#endif 


//#if -295337277 
inTag = false;
//#endif 


//#if -1315695657 
tagName = theTag;
//#endif 


//#if 2106958358 
endTagName = '/' + theTag;
//#endif 


//#if -1792678347 
attributes = attribs;
//#endif 


//#if 1211108951 
childOnly = child;
//#endif 

} 

//#endif 


//#if 491426370 
private Map readAttributes() throws IOException
    { 

//#if 2130048462 
Map attributesFound = new HashMap();
//#endif 


//#if -1169668911 
int character;
//#endif 


//#if -445222467 
while ((character = realRead()) != '>') //1
{ 

//#if -1265262836 
if(!Character.isWhitespace((char) character))//1
{ 

//#if 1239867110 
StringBuffer attributeName = new StringBuffer();
//#endif 


//#if 81007103 
attributeName.append((char) character);
//#endif 


//#if 1183601886 
while ((character = realRead()) != '='
                        && !Character.isWhitespace((char) character)) //1
{ 

//#if 1560413901 
attributeName.append((char) character);
//#endif 

} 

//#endif 


//#if -1366452670 
while (Character.isWhitespace((char) character)) //1
{ 

//#if 1248384662 
character = realRead();
//#endif 

} 

//#endif 


//#if -1485015447 
if(character != '=')//1
{ 

//#if -1982789146 
throw new IOException(
                        "Expected = sign after attribute "
                        + attributeName);
//#endif 

} 

//#endif 


//#if 87898756 
int quoteSymbol = realRead();
//#endif 


//#if 28544663 
while (Character.isWhitespace((char) quoteSymbol)) //1
{ 

//#if -1343997806 
quoteSymbol = realRead();
//#endif 

} 

//#endif 


//#if -166607204 
if(quoteSymbol != '"' && quoteSymbol != '\'')//1
{ 

//#if -394292053 
throw new IOException(
                        "Expected \" or ' around attribute value after "
                        + "attribute " + attributeName);
//#endif 

} 

//#endif 


//#if 948784010 
StringBuffer attributeValue = new StringBuffer();
//#endif 


//#if 714695355 
while ((character = realRead()) != quoteSymbol) //1
{ 

//#if 1520520015 
attributeValue.append((char) character);
//#endif 

} 

//#endif 


//#if -1677219502 
attributesFound.put(
                    attributeName.toString(),
                    attributeValue.toString());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 919792368 
return attributesFound;
//#endif 

} 

//#endif 


//#if 424722673 
public void realClose() throws IOException
    { 

//#if 1700248938 
super.close();
//#endif 

} 

//#endif 


//#if 2009601331 
public void close() throws IOException
    { 
} 

//#endif 


//#if 1413899322 
private boolean isNameTerminator(char ch)
    { 

//#if 1075555291 
return (ch == '>' || Character.isWhitespace(ch));
//#endif 

} 

//#endif 


//#if -12333432 
private int realRead() throws IOException
    { 

//#if -675133557 
int read = super.read();
//#endif 


//#if -317442849 
if(read == -1)//1
{ 

//#if 1547289967 
throw new IOException("Tag " + tagName + " not found");
//#endif 

} 

//#endif 


//#if 1238858119 
return read;
//#endif 

} 

//#endif 


//#if 361808735 
private void skipToTag() throws IOException
    { 

//#if 1579140073 
char[] searchChars = tagName.toCharArray();
//#endif 


//#if -987159885 
int i;
//#endif 


//#if -467856717 
boolean found;
//#endif 


//#if 1661489883 
while (true) //1
{ 

//#if -982806039 
if(!childOnly)//1
{ 

//#if -1849862684 
mark(1000);
//#endif 

} 

//#endif 


//#if -1980502271 
while (realRead() != '<') //1
{ 

//#if -857486351 
if(!childOnly)//1
{ 

//#if -1802814013 
mark(1000);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1074324513 
found = true;
//#endif 


//#if 2029404456 
for (i = 0; i < tagName.length(); ++i) //1
{ 

//#if -1618414571 
int c = realRead();
//#endif 


//#if -725333522 
if(c != searchChars[i])//1
{ 

//#if 1756767005 
found = false;
//#endif 


//#if -2043845242 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 216328014 
int terminator = realRead();
//#endif 


//#if -1152762964 
if(found && !isNameTerminator((char) terminator))//1
{ 

//#if -84205307 
found = false;
//#endif 

} 

//#endif 


//#if 2110257104 
if(found)//1
{ 

//#if -1923784594 
if(attributes != null)//1
{ 

//#if 2080418907 
Map attributesFound = new HashMap();
//#endif 


//#if 126053159 
if(terminator != '>')//1
{ 

//#if 316103746 
attributesFound = readAttributes();
//#endif 

} 

//#endif 


//#if -1842860353 
Iterator it = attributes.entrySet().iterator();
//#endif 


//#if -355824063 
while (found && it.hasNext()) //1
{ 

//#if 1402352664 
Map.Entry pair = (Map.Entry) it.next();
//#endif 


//#if 1669825174 
if(!pair.getValue().equals(
                                    attributesFound.get(pair.getKey())))//1
{ 

//#if 270055927 
found = false;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1233150177 
if(found)//2
{ 

//#if -92982032 
if(instanceCount < 0)//1
{ 

//#if 1598176006 
found = false;
//#endif 


//#if 752355508 
++instanceCount;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1233179969 
if(found)//3
{ 

//#if -1528060111 
if(childOnly)//1
{ 

//#if -837475112 
mark(1000);
//#endif 


//#if 10060990 
while (realRead() != '<') //1
{ 
} 

//#endif 


//#if -310790737 
tagName = "";
//#endif 


//#if 960735053 
char ch = (char) realRead();
//#endif 


//#if -1121843434 
while (!isNameTerminator(ch)) //1
{ 

//#if -743834560 
tagName += ch;
//#endif 


//#if -369788060 
ch = (char) realRead();
//#endif 

} 

//#endif 


//#if -1534427573 
endTagName = "/" + tagName;
//#endif 


//#if -1035832785 
LOG.info("Start tag = " + tagName);
//#endif 


//#if 1771452765 
LOG.info("End tag = " + endTagName);
//#endif 

} 

//#endif 


//#if 1978802999 
reset();
//#endif 


//#if -904598529 
return;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1994080378 
public synchronized int read() throws IOException
    { 

//#if 1231798132 
if(!xmlStarted)//1
{ 

//#if -2050808485 
skipToTag();
//#endif 


//#if -435391077 
xmlStarted = true;
//#endif 

} 

//#endif 


//#if 1939846308 
if(endStream)//1
{ 

//#if 1635120434 
return -1;
//#endif 

} 

//#endif 


//#if -2129084836 
int ch = super.read();
//#endif 


//#if -505064141 
endStream = isLastTag(ch);
//#endif 


//#if -974943846 
return ch;
//#endif 

} 

//#endif 


//#if -1001253285 
private boolean isLastTag(int ch)
    { 

//#if 1184724774 
if(ch == '<')//1
{ 

//#if 1322462606 
inTag = true;
//#endif 


//#if -1230284244 
currentTag.setLength(0);
//#endif 

} 
else

//#if -1770640513 
if(ch == '>')//1
{ 

//#if 168631794 
inTag = false;
//#endif 


//#if -1712944185 
String tag = currentTag.toString();
//#endif 


//#if -138092473 
if(tag.equals(endTagName)
                    // TODO: The below is not strictly correct, but should
                    // cover the case we deal with.  Using a real XML parser
                    // would be better.
                    // Look for XML document has just a single root element
                    || (currentTag.charAt(currentTag.length() - 1) == '/'
                        && tag.startsWith(tagName)
                        && tag.indexOf(' ') == tagName.indexOf(' ')))//1
{ 

//#if 877618731 
return true;
//#endif 

} 

//#endif 

} 
else

//#if 1905847875 
if(inTag)//1
{ 

//#if -1684814707 
currentTag.append((char) ch);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if -500922780 
return false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

