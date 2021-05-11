
//#if 1497923776 
// Compilation Unit of /XmiInputStream.java 
 

//#if -1453408254 
package org.argouml.persistence;
//#endif 


//#if -171592274 
import java.io.BufferedInputStream;
//#endif 


//#if -1729933552 
import java.io.IOException;
//#endif 


//#if 546743599 
import java.io.InputStream;
//#endif 


//#if -295833929 
import java.util.StringTokenizer;
//#endif 


//#if 1294158281 
import org.argouml.persistence.AbstractFilePersister.ProgressMgr;
//#endif 


//#if 1785951522 
class InterruptedIOException extends 
//#if 962663430 
IOException
//#endif 

  { 

//#if -1743352025 
private static final long serialVersionUID = 5654808047803205851L;
//#endif 


//#if -1626273345 
private InterruptedException cause;
//#endif 


//#if -104065365 
public InterruptedException getInterruptedException()
    { 

//#if 1802349529 
return cause;
//#endif 

} 

//#endif 


//#if -1028769777 
public InterruptedIOException(InterruptedException theCause)
    { 

//#if 2122930608 
cause = theCause;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1176359185 
class XmiInputStream extends 
//#if -2045107595 
BufferedInputStream
//#endif 

  { 

//#if 1904487828 
private String tagName;
//#endif 


//#if 1511242451 
private String endTagName;
//#endif 


//#if -776240378 
private String attributes;
//#endif 


//#if 1894736573 
private boolean extensionFound;
//#endif 


//#if -954037735 
private boolean endFound;
//#endif 


//#if 400284177 
private boolean parsingExtension;
//#endif 


//#if 1222683999 
private boolean readingName;
//#endif 


//#if 1693999770 
private XmiExtensionParser xmiExtensionParser;
//#endif 


//#if -366681716 
private StringBuffer stringBuffer;
//#endif 


//#if 489812739 
private String type;
//#endif 


//#if -1522070999 
private long eventSpacing;
//#endif 


//#if -451758965 
private long readCount;
//#endif 


//#if 483217614 
private ProgressMgr progressMgr;
//#endif 


//#if 1129340470 
@Override
    public void close() throws IOException
    { 
} 

//#endif 


//#if -1432870412 
public void realClose() throws IOException
    { 

//#if -890514325 
super.close();
//#endif 

} 

//#endif 


//#if 916272565 
public XmiInputStream(
        InputStream inputStream,
        XmiExtensionParser extParser,
        long spacing,
        ProgressMgr prgrssMgr)
    { 

//#if 1581799507 
super(inputStream);
//#endif 


//#if -1421882096 
eventSpacing = spacing;
//#endif 


//#if 1932074354 
xmiExtensionParser  = extParser;
//#endif 


//#if 1365472158 
progressMgr  = prgrssMgr;
//#endif 

} 

//#endif 


//#if -1412517253 
@Override
    public synchronized int read(byte[] b, int off, int len)
    throws IOException
    { 

//#if -1623775082 
int cnt;
//#endif 


//#if 732067631 
for (cnt = 0; cnt < len; ++cnt) //1
{ 

//#if -810514428 
int read = read();
//#endif 


//#if -1679587739 
if(read == -1)//1
{ 

//#if -1306989499 
break;

//#endif 

} 

//#endif 


//#if -1078429120 
b[cnt + off] = (byte) read;
//#endif 

} 

//#endif 


//#if 1742464387 
if(cnt > 0)//1
{ 

//#if 1644177662 
return cnt;
//#endif 

} 

//#endif 


//#if 1551458012 
return -1;
//#endif 

} 

//#endif 


//#if -443693763 
private boolean isNameTerminator(char ch)
    { 

//#if -162552514 
return (ch == '>' || Character.isWhitespace(ch));
//#endif 

} 

//#endif 


//#if -2141986615 
@Override
    public synchronized int read() throws IOException
    { 

//#if -1218416942 
if(endFound)//1
{ 

//#if -1104348205 
extensionFound = false;
//#endif 


//#if 207412519 
parsingExtension = false;
//#endif 


//#if -264305873 
endFound = false;
//#endif 


//#if 639410365 
readingName = false;
//#endif 


//#if -423765571 
tagName = null;
//#endif 


//#if 1419275136 
endTagName = null;
//#endif 

} 

//#endif 


//#if -411637184 
int ch = super.read();
//#endif 


//#if 2137199578 
if(parsingExtension)//1
{ 

//#if -44669288 
stringBuffer.append((char) ch);
//#endif 

} 

//#endif 


//#if -236215446 
++readCount;
//#endif 


//#if -755404737 
if(progressMgr != null && readCount == eventSpacing)//1
{ 

//#if 152539727 
try //1
{ 

//#if 1612414904 
readCount = 0;
//#endif 


//#if 823523166 
progressMgr.nextPhase();
//#endif 

} 

//#if -68109404 
catch (InterruptedException e) //1
{ 

//#if 1059816338 
throw new InterruptedIOException(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -2060744392 
if(xmiExtensionParser != null)//1
{ 

//#if 712375904 
if(readingName)//1
{ 

//#if -499085085 
if(isNameTerminator((char) ch))//1
{ 

//#if 1086448700 
readingName = false;
//#endif 


//#if -1251926827 
if(parsingExtension && endTagName == null)//1
{ 

//#if 650906710 
endTagName = "/" + tagName;
//#endif 

} 
else

//#if 1387286097 
if(tagName.equals("XMI.extension"))//1
{ 

//#if -629249307 
extensionFound = true;
//#endif 

} 
else

//#if 125107635 
if(tagName.equals(endTagName))//1
{ 

//#if -573847521 
endFound = true;
//#endif 


//#if -45967141 
xmiExtensionParser.parse(type, stringBuffer.toString());
//#endif 


//#if -1299877006 
stringBuffer.delete(0, stringBuffer.length());
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 
else
{ 

//#if 289022304 
tagName += (char) ch;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1483892278 
if(extensionFound)//1
{ 

//#if -364029553 
if(ch == '>')//1
{ 

//#if -403853795 
extensionFound = false;
//#endif 


//#if 1899021743 
callExtensionParser();
//#endif 

} 
else
{ 

//#if 797335494 
attributes += (char) ch;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -928371306 
if(ch == '<')//1
{ 

//#if -385387296 
readingName = true;
//#endif 


//#if -866413380 
tagName = "";
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1483244158 
return ch;
//#endif 

} 

//#endif 


//#if -831378944 
private void callExtensionParser()
    { 

//#if 718752808 
String label = null;
//#endif 


//#if 687932833 
String extender = null;
//#endif 


//#if -1911060537 
for (StringTokenizer st = new StringTokenizer(attributes, " =");
                st.hasMoreTokens(); ) //1
{ 

//#if -1478884499 
String attributeType = st.nextToken();
//#endif 


//#if -1074845840 
if(attributeType.equals("xmi.extender"))//1
{ 

//#if 1674951135 
extender = st.nextToken();
//#endif 


//#if -222002515 
extender = extender.substring(1, extender.length() - 1);
//#endif 

} 

//#endif 


//#if 1751013225 
if(attributeType.equals("xmi.label"))//1
{ 

//#if -684983133 
label = st.nextToken();
//#endif 


//#if -1133584031 
label = label.substring(1, label.length() - 1);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1626462241 
if("ArgoUML".equals(extender))//1
{ 

//#if -566804835 
type = label;
//#endif 


//#if 423243080 
stringBuffer = new StringBuffer();
//#endif 


//#if 701333452 
parsingExtension = true;
//#endif 


//#if 279854318 
endTagName = null;
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

