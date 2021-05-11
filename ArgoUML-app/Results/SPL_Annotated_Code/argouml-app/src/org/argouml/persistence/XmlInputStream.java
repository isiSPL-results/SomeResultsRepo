// Compilation Unit of /XmlInputStream.java 
 
package org.argouml.persistence;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

class XmlInputStream extends BufferedInputStream
  { 
private boolean xmlStarted;
private boolean inTag;
private StringBuffer currentTag = new StringBuffer();
private boolean endStream;
private String tagName;
private String endTagName;
private Map attributes;
private boolean childOnly;
private int instanceCount;

//#if LOGGING 
private static final Logger LOG =
        Logger.getLogger(XmlInputStream.class);
//#endif 

public XmlInputStream(
        InputStream inStream,
        String theTag,
        long theLength,
        long theEventSpacing)
    { 
super(inStream);
tagName = theTag;
endTagName = '/' + theTag;
attributes = null;
childOnly = false;
} 

public synchronized int read(byte[] b, int off, int len)
    throws IOException
    { 
if(!xmlStarted)//1
{ 
skipToTag();
xmlStarted = true;
} 

if(endStream)//1
{ 
return -1;
} 

int cnt;
for (cnt = 0; cnt < len; ++cnt) //1
{ 
int read = read();
if(read == -1)//1
{ 
break;

} 

b[cnt + off] = (byte) read;
} 

if(cnt > 0)//1
{ 
return cnt;
} 

return -1;
} 

public synchronized void reopen(String theTag)
    { 
endStream = false;
xmlStarted = false;
inTag = false;
tagName = theTag;
endTagName = '/' + theTag;
attributes = null;
childOnly = false;
} 

public synchronized void reopen(
        String theTag,
        Map attribs,
        boolean child)
    { 
endStream = false;
xmlStarted = false;
inTag = false;
tagName = theTag;
endTagName = '/' + theTag;
attributes = attribs;
childOnly = child;
} 

private Map readAttributes() throws IOException
    { 
Map attributesFound = new HashMap();
int character;
while ((character = realRead()) != '>') //1
{ 
if(!Character.isWhitespace((char) character))//1
{ 
StringBuffer attributeName = new StringBuffer();
attributeName.append((char) character);
while ((character = realRead()) != '='
                        && !Character.isWhitespace((char) character)) //1
{ 
attributeName.append((char) character);
} 

while (Character.isWhitespace((char) character)) //1
{ 
character = realRead();
} 

if(character != '=')//1
{ 
throw new IOException(
                        "Expected = sign after attribute "
                        + attributeName);
} 

int quoteSymbol = realRead();
while (Character.isWhitespace((char) quoteSymbol)) //1
{ 
quoteSymbol = realRead();
} 

if(quoteSymbol != '"' && quoteSymbol != '\'')//1
{ 
throw new IOException(
                        "Expected \" or ' around attribute value after "
                        + "attribute " + attributeName);
} 

StringBuffer attributeValue = new StringBuffer();
while ((character = realRead()) != quoteSymbol) //1
{ 
attributeValue.append((char) character);
} 

attributesFound.put(
                    attributeName.toString(),
                    attributeValue.toString());
} 

} 

return attributesFound;
} 

public void realClose() throws IOException
    { 
super.close();
} 

public void close() throws IOException
    { 
} 

private boolean isNameTerminator(char ch)
    { 
return (ch == '>' || Character.isWhitespace(ch));
} 

private int realRead() throws IOException
    { 
int read = super.read();
if(read == -1)//1
{ 
throw new IOException("Tag " + tagName + " not found");
} 

return read;
} 

private void skipToTag() throws IOException
    { 
char[] searchChars = tagName.toCharArray();
int i;
boolean found;
while (true) //1
{ 
if(!childOnly)//1
{ 
mark(1000);
} 

while (realRead() != '<') //1
{ 
if(!childOnly)//1
{ 
mark(1000);
} 

} 

found = true;
for (i = 0; i < tagName.length(); ++i) //1
{ 
int c = realRead();
if(c != searchChars[i])//1
{ 
found = false;
break;

} 

} 

int terminator = realRead();
if(found && !isNameTerminator((char) terminator))//1
{ 
found = false;
} 

if(found)//1
{ 
if(attributes != null)//1
{ 
Map attributesFound = new HashMap();
if(terminator != '>')//1
{ 
attributesFound = readAttributes();
} 

Iterator it = attributes.entrySet().iterator();
while (found && it.hasNext()) //1
{ 
Map.Entry pair = (Map.Entry) it.next();
if(!pair.getValue().equals(
                                    attributesFound.get(pair.getKey())))//1
{ 
found = false;
} 

} 

} 

} 

if(found)//2
{ 
if(instanceCount < 0)//1
{ 
found = false;
++instanceCount;
} 

} 

if(found)//3
{ 
if(childOnly)//1
{ 
mark(1000);
while (realRead() != '<') //1
{ 
} 

tagName = "";
char ch = (char) realRead();
while (!isNameTerminator(ch)) //1
{ 
tagName += ch;
ch = (char) realRead();
} 

endTagName = "/" + tagName;

//#if LOGGING 
LOG.info("Start tag = " + tagName);
//#endif 


//#if LOGGING 
LOG.info("End tag = " + endTagName);
//#endif 

} 

reset();
return;
} 

} 

} 

public synchronized int read() throws IOException
    { 
if(!xmlStarted)//1
{ 
skipToTag();
xmlStarted = true;
} 

if(endStream)//1
{ 
return -1;
} 

int ch = super.read();
endStream = isLastTag(ch);
return ch;
} 

private boolean isLastTag(int ch)
    { 
if(ch == '<')//1
{ 
inTag = true;
currentTag.setLength(0);
} 
else
if(ch == '>')//1
{ 
inTag = false;
String tag = currentTag.toString();
if(tag.equals(endTagName)
                    // TODO: The below is not strictly correct, but should
                    // cover the case we deal with.  Using a real XML parser
                    // would be better.
                    // Look for XML document has just a single root element
                    || (currentTag.charAt(currentTag.length() - 1) == '/'
                        && tag.startsWith(tagName)
                        && tag.indexOf(' ') == tagName.indexOf(' ')))//1
{ 
return true;
} 

} 
else
if(inTag)//1
{ 
currentTag.append((char) ch);
} 



return false;
} 

 } 


