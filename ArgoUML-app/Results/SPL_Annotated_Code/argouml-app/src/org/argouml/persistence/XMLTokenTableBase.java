// Compilation Unit of /XMLTokenTableBase.java 
 
package org.argouml.persistence;
import java.util.Hashtable;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

abstract class XMLTokenTableBase  { 
private  Hashtable tokens       = null;
private  boolean   dbg          = false;
private  String[]  openTags   = new String[100];
private  int[]     openTokens = new int[100];
private  int       numOpen      = 0;

//#if LOGGING 
private static final Logger LOG = Logger.getLogger(XMLTokenTableBase.class);
//#endif 

public final int toToken(String s, boolean push)
    { 
if(push)//1
{ 
openTags[++numOpen] = s;
} 
else
if(s.equals(openTags[numOpen]))//1
{ 

//#if LOGGING 
LOG.debug("matched: " + s);
//#endif 

return openTokens[numOpen--];
} 


Integer i = (Integer) tokens.get(s);
if(i != null)//1
{ 
openTokens[numOpen] = i.intValue();
return openTokens[numOpen];
} 
else
{ 
return -1;
} 

} 

public void    setDbg(boolean d)
    { 
dbg = d;
} 

public boolean contains(String token)
    { 
return tokens.containsKey(token);
} 

public boolean getDbg()
    { 
return dbg;
} 

protected void addToken(String s, Integer i)
    { 
boolean error = false;
if(dbg)//1
{ 
if(tokens.contains(i) || tokens.containsKey(s))//1
{ 

//#if LOGGING 
LOG.error("ERROR: token table already contains " + s);
//#endif 

error = true;
} 

} 

tokens.put(s, i);
if(dbg && !error)//1
{ 

//#if LOGGING 
LOG.debug("NOTE: added '" + s + "' to token table");
//#endif 

} 

} 

public XMLTokenTableBase(int tableSize)
    { 
tokens = new Hashtable(tableSize);
setupTokens();
} 

protected abstract void setupTokens();
 } 


