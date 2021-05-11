
//#if -253255749 
// Compilation Unit of /XMLTokenTableBase.java 
 

//#if -550121870 
package org.argouml.persistence;
//#endif 


//#if -1887946355 
import java.util.Hashtable;
//#endif 


//#if 1041592787 
import org.apache.log4j.Logger;
//#endif 


//#if 1528710964 
abstract class XMLTokenTableBase  { 

//#if 1850111769 
private  Hashtable tokens       = null;
//#endif 


//#if 566498428 
private  boolean   dbg          = false;
//#endif 


//#if 637885846 
private  String[]  openTags   = new String[100];
//#endif 


//#if -1062151261 
private  int[]     openTokens = new int[100];
//#endif 


//#if 1460310895 
private  int       numOpen      = 0;
//#endif 


//#if 235276274 
private static final Logger LOG = Logger.getLogger(XMLTokenTableBase.class);
//#endif 


//#if -926325112 
public final int toToken(String s, boolean push)
    { 

//#if 618645856 
if(push)//1
{ 

//#if -1035571349 
openTags[++numOpen] = s;
//#endif 

} 
else

//#if 336061582 
if(s.equals(openTags[numOpen]))//1
{ 

//#if -2051612017 
LOG.debug("matched: " + s);
//#endif 


//#if 1877611475 
return openTokens[numOpen--];
//#endif 

} 

//#endif 


//#endif 


//#if -817082771 
Integer i = (Integer) tokens.get(s);
//#endif 


//#if 613596790 
if(i != null)//1
{ 

//#if 869024036 
openTokens[numOpen] = i.intValue();
//#endif 


//#if -567549123 
return openTokens[numOpen];
//#endif 

} 
else
{ 

//#if -81684007 
return -1;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 586132596 
public void    setDbg(boolean d)
    { 

//#if 1057156920 
dbg = d;
//#endif 

} 

//#endif 


//#if 282249846 
public boolean contains(String token)
    { 

//#if 154555573 
return tokens.containsKey(token);
//#endif 

} 

//#endif 


//#if 1041683432 
public boolean getDbg()
    { 

//#if 1113764257 
return dbg;
//#endif 

} 

//#endif 


//#if 640553339 
protected void addToken(String s, Integer i)
    { 

//#if -111004093 
boolean error = false;
//#endif 


//#if -452669256 
if(dbg)//1
{ 

//#if -899989594 
if(tokens.contains(i) || tokens.containsKey(s))//1
{ 

//#if -506106131 
LOG.error("ERROR: token table already contains " + s);
//#endif 


//#if 95249633 
error = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1502133127 
tokens.put(s, i);
//#endif 


//#if -810035073 
if(dbg && !error)//1
{ 

//#if -1378282720 
LOG.debug("NOTE: added '" + s + "' to token table");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -902076150 
public XMLTokenTableBase(int tableSize)
    { 

//#if 249202815 
tokens = new Hashtable(tableSize);
//#endif 


//#if -315837824 
setupTokens();
//#endif 

} 

//#endif 


//#if 99617375 
protected abstract void setupTokens();
//#endif 

 } 

//#endif 


//#endif 

