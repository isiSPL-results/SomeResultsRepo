package org.argouml.persistence;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.ResolvedCritic;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.ListSet;
import org.xml.sax.SAXException;
class TodoParser extends SAXParserBase
  { 
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
try//1
{ 
switch (tokens.toToken(e.getName(), true)) //1
{ 
case TodoTokenTable.TOKEN_HEADLINE://1

case TodoTokenTable.TOKEN_DESCRIPTION://1

case TodoTokenTable.TOKEN_PRIORITY://1

case TodoTokenTable.TOKEN_MOREINFOURL://1

case TodoTokenTable.TOKEN_POSTER://1

case TodoTokenTable.TOKEN_OFFENDER://1

break;


case TodoTokenTable.TOKEN_TO_DO://1

handleTodo(e);
break;


case TodoTokenTable.TOKEN_TO_DO_LIST://1

handleTodoList(e);
break;


case TodoTokenTable.TOKEN_TO_DO_ITEM://1

handleTodoItemStart(e);
break;


case TodoTokenTable.TOKEN_RESOLVEDCRITICS://1

handleResolvedCritics(e);
break;


case TodoTokenTable.TOKEN_ISSUE://1

handleIssueStart(e);
break;


default://1

break;


} 
} 
catch (Exception ex) //1
{ 
} 
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
try//1
{ 
switch (tokens.toToken(e.getName(), false)) //1
{ 
case TodoTokenTable.TOKEN_TO_DO://1

case TodoTokenTable.TOKEN_RESOLVEDCRITICS://1

case TodoTokenTable.TOKEN_TO_DO_LIST://1

break;


case TodoTokenTable.TOKEN_TO_DO_ITEM://1

handleTodoItemEnd(e);
break;


case TodoTokenTable.TOKEN_HEADLINE://1

handleHeadline(e);
break;


case TodoTokenTable.TOKEN_DESCRIPTION://1

handleDescription(e);
break;


case TodoTokenTable.TOKEN_PRIORITY://1

handlePriority(e);
break;


case TodoTokenTable.TOKEN_MOREINFOURL://1

handleMoreInfoURL(e);
break;


case TodoTokenTable.TOKEN_ISSUE://1

handleIssueEnd(e);
break;


case TodoTokenTable.TOKEN_POSTER://1

handlePoster(e);
break;


case TodoTokenTable.TOKEN_OFFENDER://1

handleOffender(e);
break;


default://1

break;


} 
} 
catch (Exception ex) //1
{ 
throw new SAXException(ex);
} 
} 
protected void handleDescription(XMLElement e)
    { 
description = decode(e.getText()).trim();
} 
public synchronized void readTodoList(
        Reader is) throws SAXException
    { 
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
try//1
{ 
sb.append((char) Integer.parseInt(ent));
} 
catch (NumberFormatException nfe) //1
{ 
} 
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
try//1
{ 
np = Integer.parseInt(prio);
} 
catch (NumberFormatException nfe) //1
{ 
np = ToDoItem.HIGH_PRIORITY;
if(TodoTokenTable.STRING_PRIO_HIGH.equalsIgnoreCase(prio))//1
{ 
np = ToDoItem.HIGH_PRIORITY;
} 
else
if(TodoTokenTable.STRING_PRIO_MED.equalsIgnoreCase(prio))//1
{ 
np = ToDoItem.MED_PRIORITY;
} 
else
if(TodoTokenTable.STRING_PRIO_LOW.equalsIgnoreCase(prio))//1
{ 
np = ToDoItem.LOW_PRIORITY;
} 
} 
priority = np;
} 

 } 
