// Compilation Unit of /TodoParser.java 
 

//#if COGNITIVE 
package org.argouml.persistence;
//#endif 


//#if COGNITIVE 
import java.io.Reader;
//#endif 


//#if COGNITIVE 
import java.util.ArrayList;
//#endif 


//#if COGNITIVE 
import java.util.List;
//#endif 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Designer;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ResolvedCritic;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ListSet;
//#endif 


//#if COGNITIVE 
import org.xml.sax.SAXException;
//#endif 


//#if COGNITIVE 
class TodoParser extends SAXParserBase
  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG = Logger.getLogger(TodoParser.class);
//#endif 

private TodoTokenTable tokens = new TodoTokenTable();
private String headline;
private int    priority;
private String moreinfourl;
private String description;
private String critic;
private List offenders;
protected void handlePoster(XMLElement e)
    { 
critic = decode(e.getText()).trim();
} 

protected void handleIssueStart(XMLElement e)
    { 
critic = null;
offenders = null;
} 

public TodoParser()
    { 
} 

public void handleStartElement(XMLElement e)
    { 
try //1
{ 
switch (tokens.toToken(e.getName(), true)) //1
{ 
case TodoTokenTable.TOKEN_HEADLINE://1

case TodoTokenTable.TOKEN_DESCRIPTION://1

case TodoTokenTable.TOKEN_PRIORITY://1

case TodoTokenTable.TOKEN_MOREINFOURL://1

case TodoTokenTable.TOKEN_POSTER://1

case TodoTokenTable.TOKEN_OFFENDER://1


//#if COGNITIVE 
break;

//#endif 


case TodoTokenTable.TOKEN_TO_DO://1


//#if COGNITIVE 
handleTodo(e);
//#endif 


//#if COGNITIVE 
break;

//#endif 


case TodoTokenTable.TOKEN_TO_DO_LIST://1


//#if COGNITIVE 
handleTodoList(e);
//#endif 


//#if COGNITIVE 
break;

//#endif 


case TodoTokenTable.TOKEN_TO_DO_ITEM://1


//#if COGNITIVE 
handleTodoItemStart(e);
//#endif 


//#if COGNITIVE 
break;

//#endif 


case TodoTokenTable.TOKEN_RESOLVEDCRITICS://1


//#if COGNITIVE 
handleResolvedCritics(e);
//#endif 


//#if COGNITIVE 
break;

//#endif 


case TodoTokenTable.TOKEN_ISSUE://1


//#if COGNITIVE 
handleIssueStart(e);
//#endif 


//#if COGNITIVE 
break;

//#endif 


default://1


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.warn("WARNING: unknown tag:" + e.getName());
//#endif 


//#if COGNITIVE 
break;

//#endif 


} 

} 

//#if COGNITIVE 
catch (Exception ex) //1
{ 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.error("Exception in startelement", ex);
//#endif 

} 

//#endif 


} 

protected void handleIssueEnd(XMLElement e)
    { 
Designer dsgr;
ResolvedCritic item;
if(critic == null)//1
{ 
return;
} 

item = new ResolvedCritic(critic, offenders);
dsgr = Designer.theDesigner();
dsgr.getToDoList().addResolvedCritic(item);
} 

public void handleEndElement(XMLElement e) throws SAXException
    { 
try //1
{ 
switch (tokens.toToken(e.getName(), false)) //1
{ 
case TodoTokenTable.TOKEN_TO_DO://1

case TodoTokenTable.TOKEN_RESOLVEDCRITICS://1

case TodoTokenTable.TOKEN_TO_DO_LIST://1


//#if COGNITIVE 
break;

//#endif 


case TodoTokenTable.TOKEN_TO_DO_ITEM://1


//#if COGNITIVE 
handleTodoItemEnd(e);
//#endif 


//#if COGNITIVE 
break;

//#endif 


case TodoTokenTable.TOKEN_HEADLINE://1


//#if COGNITIVE 
handleHeadline(e);
//#endif 


//#if COGNITIVE 
break;

//#endif 


case TodoTokenTable.TOKEN_DESCRIPTION://1


//#if COGNITIVE 
handleDescription(e);
//#endif 


//#if COGNITIVE 
break;

//#endif 


case TodoTokenTable.TOKEN_PRIORITY://1


//#if COGNITIVE 
handlePriority(e);
//#endif 


//#if COGNITIVE 
break;

//#endif 


case TodoTokenTable.TOKEN_MOREINFOURL://1


//#if COGNITIVE 
handleMoreInfoURL(e);
//#endif 


//#if COGNITIVE 
break;

//#endif 


case TodoTokenTable.TOKEN_ISSUE://1


//#if COGNITIVE 
handleIssueEnd(e);
//#endif 


//#if COGNITIVE 
break;

//#endif 


case TodoTokenTable.TOKEN_POSTER://1


//#if COGNITIVE 
handlePoster(e);
//#endif 


//#if COGNITIVE 
break;

//#endif 


case TodoTokenTable.TOKEN_OFFENDER://1


//#if COGNITIVE 
handleOffender(e);
//#endif 


//#if COGNITIVE 
break;

//#endif 


default://1


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.warn("WARNING: unknown end tag:"
                         + e.getName());
//#endif 


//#if COGNITIVE 
break;

//#endif 


} 

} 

//#if COGNITIVE 
catch (Exception ex) //1
{ 
throw new SAXException(ex);
} 

//#endif 


} 

protected void handleDescription(XMLElement e)
    { 
description = decode(e.getText()).trim();
} 

public synchronized void readTodoList(
        Reader is) throws SAXException
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.info("=======================================");
//#endif 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.info("== READING TO DO LIST");
//#endif 

parse(is);
} 

public static String encode(String str)
    { 
StringBuffer sb;
int i1, i2;
char c;
if(str == null)//1
{ 
return null;
} 

sb = new StringBuffer();
for (i1 = 0, i2 = 0; i2 < str.length(); i2++) //1
{ 
c = str.charAt(i2);
if(c == '%')//1
{ 
if(i2 > i1)//1
{ 
sb.append(str.substring(i1, i2));
} 

sb.append("%proc;");
i1 = i2 + 1;
} 
else

//#if COGNITIVE 
if(c < 0x28
                       ||  (c >= 0x3C && c <= 0x40 && c != 0x3D && c != 0x3F)
                       ||  (c >= 0x5E && c <= 0x60 && c != 0x5F)
                       ||   c >= 0x7B)//1
{ 
if(i2 > i1)//1
{ 
sb.append(str.substring(i1, i2));
} 

sb.append("%" + Integer.toString(c) + ";");
i1 = i2 + 1;
} 

//#endif 


} 

if(i2 > i1)//1
{ 
sb.append(str.substring(i1, i2));
} 

return sb.toString();
} 

protected void handleTodoItemEnd(XMLElement e)
    { 
ToDoItem item;
Designer dsgr;
dsgr = Designer.theDesigner();
item =
            new ToDoItem(dsgr, headline, priority, description, moreinfourl,
                         new ListSet());
dsgr.getToDoList().addElement(item);
} 

protected void handleResolvedCritics(XMLElement e)
    { 
} 

protected void handleMoreInfoURL(XMLElement e)
    { 
moreinfourl = decode(e.getText()).trim();
} 

protected void handleTodo(XMLElement e)
    { 
} 

public static String decode(String str)
    { 
if(str == null)//1
{ 
return null;
} 

StringBuffer sb;
int i1, i2;
char c;
sb = new StringBuffer();
for (i1 = 0, i2 = 0; i2 < str.length(); i2++) //1
{ 
c = str.charAt(i2);
if(c == '%')//1
{ 
if(i2 > i1)//1
{ 
sb.append(str.substring(i1, i2));
} 

for (i1 = ++i2; i2 < str.length(); i2++) //1
{ 
if(str.charAt(i2) == ';')//1
{ 
break;

} 

} 

if(i2 >= str.length())//1
{ 
i1 = i2;
break;

} 

if(i2 > i1)//2
{ 
String ent = str.substring(i1, i2);
if("proc".equals(ent))//1
{ 
sb.append('%');
} 
else
{ 
try //1
{ 
sb.append((char) Integer.parseInt(ent));
} 

//#if COGNITIVE 
catch (NumberFormatException nfe) //1
{ 
} 

//#endif 


} 

} 

i1 = i2 + 1;
} 

} 

if(i2 > i1)//1
{ 
sb.append(str.substring(i1, i2));
} 

return sb.toString();
} 

protected void handleOffender(XMLElement e)
    { 
if(offenders == null)//1
{ 
offenders = new ArrayList();
} 

offenders.add(decode(e.getText()).trim());
} 

protected void handleTodoList(XMLElement e)
    { 
} 

protected void handleTodoItemStart(XMLElement e)
    { 
headline = "";
priority = ToDoItem.HIGH_PRIORITY;
moreinfourl = "";
description = "";
} 

protected void handleHeadline(XMLElement e)
    { 
headline = decode(e.getText()).trim();
} 

protected void handlePriority(XMLElement e)
    { 
String prio = decode(e.getText()).trim();
int np;
try //1
{ 
np = Integer.parseInt(prio);
} 

//#if COGNITIVE 
catch (NumberFormatException nfe) //1
{ 
np = ToDoItem.HIGH_PRIORITY;
if(TodoTokenTable.STRING_PRIO_HIGH.equalsIgnoreCase(prio))//1
{ 
np = ToDoItem.HIGH_PRIORITY;
} 
else

//#if COGNITIVE 
if(TodoTokenTable.STRING_PRIO_MED.equalsIgnoreCase(prio))//1
{ 
np = ToDoItem.MED_PRIORITY;
} 
else

//#if COGNITIVE 
if(TodoTokenTable.STRING_PRIO_LOW.equalsIgnoreCase(prio))//1
{ 
np = ToDoItem.LOW_PRIORITY;
} 

//#endif 


//#endif 


} 

//#endif 


priority = np;
} 

 } 

//#endif 


