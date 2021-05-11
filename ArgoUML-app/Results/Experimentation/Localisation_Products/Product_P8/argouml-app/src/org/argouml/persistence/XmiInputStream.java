package org.argouml.persistence;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
import org.argouml.persistence.AbstractFilePersister.ProgressMgr;
class InterruptedIOException extends IOException
  { 
private static final long serialVersionUID = 5654808047803205851L;
private InterruptedException cause;
public InterruptedException getInterruptedException()
    { 
return cause;
} 
public InterruptedIOException(InterruptedException theCause)
    { 
cause = theCause;
} 

 } 
class XmiInputStream extends BufferedInputStream
  { 
private String tagName;
private String endTagName;
private String attributes;
private boolean extensionFound;
private boolean endFound;
private boolean parsingExtension;
private boolean readingName;
private XmiExtensionParser xmiExtensionParser;
private StringBuffer stringBuffer;
private String type;
private long eventSpacing;
private long readCount;
private ProgressMgr progressMgr;
@Override
    public void close() throws IOException
    { 
} 
public void realClose() throws IOException
    { 
super.close();
} 
public XmiInputStream(
        InputStream inputStream,
        XmiExtensionParser extParser,
        long spacing,
        ProgressMgr prgrssMgr)
    { 
super(inputStream);
eventSpacing = spacing;
xmiExtensionParser  = extParser;
progressMgr  = prgrssMgr;
} 
@Override
    public synchronized int read(byte[] b, int off, int len)
    throws IOException
    { 
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
private boolean isNameTerminator(char ch)
    { 
return (ch == '>' || Character.isWhitespace(ch));
} 
@Override
    public synchronized int read() throws IOException
    { 
if(endFound)//1
{ 
extensionFound = false;
parsingExtension = false;
endFound = false;
readingName = false;
tagName = null;
endTagName = null;
} 
int ch = super.read();
if(parsingExtension)//1
{ 
stringBuffer.append((char) ch);
} 
++readCount;
if(progressMgr != null && readCount == eventSpacing)//1
{ 
try//1
{ 
readCount = 0;
progressMgr.nextPhase();
} 
catch (InterruptedException e) //1
{ 
throw new InterruptedIOException(e);
} 
} 
if(xmiExtensionParser != null)//1
{ 
if(readingName)//1
{ 
if(isNameTerminator((char) ch))//1
{ 
readingName = false;
if(parsingExtension && endTagName == null)//1
{ 
endTagName = "/" + tagName;
} 
else
if(tagName.equals("XMI.extension"))//1
{ 
extensionFound = true;
} 
else
if(tagName.equals(endTagName))//1
{ 
endFound = true;
xmiExtensionParser.parse(type, stringBuffer.toString());
stringBuffer.delete(0, stringBuffer.length());
} 
} 
else
{ 
tagName += (char) ch;
} 
} 
if(extensionFound)//1
{ 
if(ch == '>')//1
{ 
extensionFound = false;
callExtensionParser();
} 
else
{ 
attributes += (char) ch;
} 
} 
if(ch == '<')//1
{ 
readingName = true;
tagName = "";
} 
} 
return ch;
} 
private void callExtensionParser()
    { 
String label = null;
String extender = null;
for (StringTokenizer st = new StringTokenizer(attributes, " =");
                st.hasMoreTokens(); ) //1
{ 
String attributeType = st.nextToken();
if(attributeType.equals("xmi.extender"))//1
{ 
extender = st.nextToken();
extender = extender.substring(1, extender.length() - 1);
} 
if(attributeType.equals("xmi.label"))//1
{ 
label = st.nextToken();
label = label.substring(1, label.length() - 1);
} 
} 
if("ArgoUML".equals(extender))//1
{ 
type = label;
stringBuffer = new StringBuffer();
parsingExtension = true;
endTagName = null;
} 
} 

 } 
