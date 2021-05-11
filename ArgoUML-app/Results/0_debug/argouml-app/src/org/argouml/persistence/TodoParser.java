
//#if -2075186195 
// Compilation Unit of /TodoParser.java 
 

//#if 657582872 
package org.argouml.persistence;
//#endif 


//#if 281487376 
import java.io.Reader;
//#endif 


//#if -681942800 
import java.util.ArrayList;
//#endif 


//#if 1523974001 
import java.util.List;
//#endif 


//#if 1634740333 
import org.apache.log4j.Logger;
//#endif 


//#if -1766579277 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1692542478 
import org.argouml.cognitive.ResolvedCritic;
//#endif 


//#if 1008402373 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1674466188 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 691583333 
import org.xml.sax.SAXException;
//#endif 


//#if 856554102 
class TodoParser extends 
//#if 1710342146 
SAXParserBase
//#endif 

  { 

//#if 356252699 
private static final Logger LOG = Logger.getLogger(TodoParser.class);
//#endif 


//#if -1295935364 
private TodoTokenTable tokens = new TodoTokenTable();
//#endif 


//#if -308696085 
private String headline;
//#endif 


//#if 1615821843 
private int    priority;
//#endif 


//#if 1448562475 
private String moreinfourl;
//#endif 


//#if -1146687941 
private String description;
//#endif 


//#if -451099061 
private String critic;
//#endif 


//#if -1360248022 
private List offenders;
//#endif 


//#if 2141616850 
protected void handlePoster(XMLElement e)
    { 

//#if -424891237 
critic = decode(e.getText()).trim();
//#endif 

} 

//#endif 


//#if -507390058 
protected void handleIssueStart(XMLElement e)
    { 

//#if 1150584288 
critic = null;
//#endif 


//#if 233299900 
offenders = null;
//#endif 

} 

//#endif 


//#if -1014421305 
public TodoParser()
    { 
} 

//#endif 


//#if -714570502 
public void handleStartElement(XMLElement e)
    { 

//#if 1746683353 
try //1
{ 

//#if -1236981177 
switch (tokens.toToken(e.getName(), true)) //1
{ 
case TodoTokenTable.TOKEN_HEADLINE://1

case TodoTokenTable.TOKEN_DESCRIPTION://1

case TodoTokenTable.TOKEN_PRIORITY://1

case TodoTokenTable.TOKEN_MOREINFOURL://1

case TodoTokenTable.TOKEN_POSTER://1

case TodoTokenTable.TOKEN_OFFENDER://1


//#if -229627612 
break;

//#endif 


case TodoTokenTable.TOKEN_TO_DO://1


//#if -1167465369 
handleTodo(e);
//#endif 


//#if 2007451334 
break;

//#endif 


case TodoTokenTable.TOKEN_TO_DO_LIST://1


//#if 732710568 
handleTodoList(e);
//#endif 


//#if -1531061303 
break;

//#endif 


case TodoTokenTable.TOKEN_TO_DO_ITEM://1


//#if 1634184438 
handleTodoItemStart(e);
//#endif 


//#if -1547657674 
break;

//#endif 


case TodoTokenTable.TOKEN_RESOLVEDCRITICS://1


//#if -1902041883 
handleResolvedCritics(e);
//#endif 


//#if 235162469 
break;

//#endif 


case TodoTokenTable.TOKEN_ISSUE://1


//#if 1572606939 
handleIssueStart(e);
//#endif 


//#if -1529199561 
break;

//#endif 


default://1


//#if -1036673549 
LOG.warn("WARNING: unknown tag:" + e.getName());
//#endif 


//#if 1131907247 
break;

//#endif 


} 

//#endif 

} 

//#if -533462443 
catch (Exception ex) //1
{ 

//#if -1373572704 
LOG.error("Exception in startelement", ex);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -888713859 
protected void handleIssueEnd(XMLElement e)
    { 

//#if -1144469108 
Designer dsgr;
//#endif 


//#if 1749442514 
ResolvedCritic item;
//#endif 


//#if -568786236 
if(critic == null)//1
{ 

//#if -867679729 
return;
//#endif 

} 

//#endif 


//#if -1102639568 
item = new ResolvedCritic(critic, offenders);
//#endif 


//#if -1400702776 
dsgr = Designer.theDesigner();
//#endif 


//#if -1496281059 
dsgr.getToDoList().addResolvedCritic(item);
//#endif 

} 

//#endif 


//#if 1691137893 
public void handleEndElement(XMLElement e) throws SAXException
    { 

//#if -1450299480 
try //1
{ 

//#if -1599752032 
switch (tokens.toToken(e.getName(), false)) //1
{ 
case TodoTokenTable.TOKEN_TO_DO://1

case TodoTokenTable.TOKEN_RESOLVEDCRITICS://1

case TodoTokenTable.TOKEN_TO_DO_LIST://1


//#if -1356313651 
break;

//#endif 


case TodoTokenTable.TOKEN_TO_DO_ITEM://1


//#if 812634100 
handleTodoItemEnd(e);
//#endif 


//#if 998801169 
break;

//#endif 


case TodoTokenTable.TOKEN_HEADLINE://1


//#if 867137957 
handleHeadline(e);
//#endif 


//#if 2053013110 
break;

//#endif 


case TodoTokenTable.TOKEN_DESCRIPTION://1


//#if -312837704 
handleDescription(e);
//#endif 


//#if 1376864231 
break;

//#endif 


case TodoTokenTable.TOKEN_PRIORITY://1


//#if 1722643743 
handlePriority(e);
//#endif 


//#if -1906399968 
break;

//#endif 


case TodoTokenTable.TOKEN_MOREINFOURL://1


//#if -1156353886 
handleMoreInfoURL(e);
//#endif 


//#if -1786735347 
break;

//#endif 


case TodoTokenTable.TOKEN_ISSUE://1


//#if 720098965 
handleIssueEnd(e);
//#endif 


//#if -247859720 
break;

//#endif 


case TodoTokenTable.TOKEN_POSTER://1


//#if 1664382291 
handlePoster(e);
//#endif 


//#if 1327299819 
break;

//#endif 


case TodoTokenTable.TOKEN_OFFENDER://1


//#if -1071275490 
handleOffender(e);
//#endif 


//#if -420773238 
break;

//#endif 


default://1


//#if 1532011888 
LOG.warn("WARNING: unknown end tag:"
                         + e.getName());
//#endif 


//#if 2141128565 
break;

//#endif 


} 

//#endif 

} 

//#if -808518952 
catch (Exception ex) //1
{ 

//#if -634568217 
throw new SAXException(ex);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1812710375 
protected void handleDescription(XMLElement e)
    { 

//#if -34183835 
description = decode(e.getText()).trim();
//#endif 

} 

//#endif 


//#if 1378490761 
public synchronized void readTodoList(
        Reader is) throws SAXException
    { 

//#if -1104171501 
LOG.info("=======================================");
//#endif 


//#if -1185818400 
LOG.info("== READING TO DO LIST");
//#endif 


//#if 486360507 
parse(is);
//#endif 

} 

//#endif 


//#if 208802075 
public static String encode(String str)
    { 

//#if 1745254641 
StringBuffer sb;
//#endif 


//#if 291142003 
int i1, i2;
//#endif 


//#if -454524232 
char c;
//#endif 


//#if -605303937 
if(str == null)//1
{ 

//#if 1851328331 
return null;
//#endif 

} 

//#endif 


//#if 1449858733 
sb = new StringBuffer();
//#endif 


//#if -839790292 
for (i1 = 0, i2 = 0; i2 < str.length(); i2++) //1
{ 

//#if -845556924 
c = str.charAt(i2);
//#endif 


//#if 177567834 
if(c == '%')//1
{ 

//#if 1573391800 
if(i2 > i1)//1
{ 

//#if 480923195 
sb.append(str.substring(i1, i2));
//#endif 

} 

//#endif 


//#if -1525509089 
sb.append("%proc;");
//#endif 


//#if -683573579 
i1 = i2 + 1;
//#endif 

} 
else

//#if 1048254503 
if(c < 0x28
                       ||  (c >= 0x3C && c <= 0x40 && c != 0x3D && c != 0x3F)
                       ||  (c >= 0x5E && c <= 0x60 && c != 0x5F)
                       ||   c >= 0x7B)//1
{ 

//#if 47725299 
if(i2 > i1)//1
{ 

//#if -634675092 
sb.append(str.substring(i1, i2));
//#endif 

} 

//#endif 


//#if 1462125902 
sb.append("%" + Integer.toString(c) + ";");
//#endif 


//#if 282558832 
i1 = i2 + 1;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1654901252 
if(i2 > i1)//1
{ 

//#if -1145913356 
sb.append(str.substring(i1, i2));
//#endif 

} 

//#endif 


//#if -143048535 
return sb.toString();
//#endif 

} 

//#endif 


//#if -119613439 
protected void handleTodoItemEnd(XMLElement e)
    { 

//#if 754147601 
ToDoItem item;
//#endif 


//#if -1927939016 
Designer dsgr;
//#endif 


//#if -2098423652 
dsgr = Designer.theDesigner();
//#endif 


//#if -38537970 
item =
            new ToDoItem(dsgr, headline, priority, description, moreinfourl,
                         new ListSet());
//#endif 


//#if 911848457 
dsgr.getToDoList().addElement(item);
//#endif 

} 

//#endif 


//#if -1398519460 
protected void handleResolvedCritics(XMLElement e)
    { 
} 

//#endif 


//#if -1637533417 
protected void handleMoreInfoURL(XMLElement e)
    { 

//#if 2090471528 
moreinfourl = decode(e.getText()).trim();
//#endif 

} 

//#endif 


//#if 1073397753 
protected void handleTodo(XMLElement e)
    { 
} 

//#endif 


//#if -844667325 
public static String decode(String str)
    { 

//#if -1077403899 
if(str == null)//1
{ 

//#if -1095570899 
return null;
//#endif 

} 

//#endif 


//#if -1456563029 
StringBuffer sb;
//#endif 


//#if -848400211 
int i1, i2;
//#endif 


//#if -1549244994 
char c;
//#endif 


//#if 49546983 
sb = new StringBuffer();
//#endif 


//#if 259267634 
for (i1 = 0, i2 = 0; i2 < str.length(); i2++) //1
{ 

//#if -2081067571 
c = str.charAt(i2);
//#endif 


//#if 1139654499 
if(c == '%')//1
{ 

//#if 1217410656 
if(i2 > i1)//1
{ 

//#if -300873295 
sb.append(str.substring(i1, i2));
//#endif 

} 

//#endif 


//#if -417601641 
for (i1 = ++i2; i2 < str.length(); i2++) //1
{ 

//#if -677322808 
if(str.charAt(i2) == ';')//1
{ 

//#if -1862135011 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -560710311 
if(i2 >= str.length())//1
{ 

//#if 415792133 
i1 = i2;
//#endif 


//#if 276602660 
break;

//#endif 

} 

//#endif 


//#if 1177081937 
if(i2 > i1)//2
{ 

//#if -638193887 
String ent = str.substring(i1, i2);
//#endif 


//#if 1609212975 
if("proc".equals(ent))//1
{ 

//#if -823357004 
sb.append('%');
//#endif 

} 
else
{ 

//#if -753841757 
try //1
{ 

//#if -1240913395 
sb.append((char) Integer.parseInt(ent));
//#endif 

} 

//#if -89791809 
catch (NumberFormatException nfe) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 1921530717 
i1 = i2 + 1;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 974311562 
if(i2 > i1)//1
{ 

//#if 36544394 
sb.append(str.substring(i1, i2));
//#endif 

} 

//#endif 


//#if 643064111 
return sb.toString();
//#endif 

} 

//#endif 


//#if -257095322 
protected void handleOffender(XMLElement e)
    { 

//#if -1029919130 
if(offenders == null)//1
{ 

//#if -920595478 
offenders = new ArrayList();
//#endif 

} 

//#endif 


//#if 1764661374 
offenders.add(decode(e.getText()).trim());
//#endif 

} 

//#endif 


//#if -977425413 
protected void handleTodoList(XMLElement e)
    { 
} 

//#endif 


//#if -136261350 
protected void handleTodoItemStart(XMLElement e)
    { 

//#if -1790955260 
headline = "";
//#endif 


//#if 259366120 
priority = ToDoItem.HIGH_PRIORITY;
//#endif 


//#if 2109623768 
moreinfourl = "";
//#endif 


//#if 710776008 
description = "";
//#endif 

} 

//#endif 


//#if 1592773163 
protected void handleHeadline(XMLElement e)
    { 

//#if -469649049 
headline = decode(e.getText()).trim();
//#endif 

} 

//#endif 


//#if 184193115 
protected void handlePriority(XMLElement e)
    { 

//#if 28077658 
String prio = decode(e.getText()).trim();
//#endif 


//#if -1084143274 
int np;
//#endif 


//#if -765442142 
try //1
{ 

//#if 2064236747 
np = Integer.parseInt(prio);
//#endif 

} 

//#if 867982041 
catch (NumberFormatException nfe) //1
{ 

//#if 1156123757 
np = ToDoItem.HIGH_PRIORITY;
//#endif 


//#if -1383307196 
if(TodoTokenTable.STRING_PRIO_HIGH.equalsIgnoreCase(prio))//1
{ 

//#if -1628730807 
np = ToDoItem.HIGH_PRIORITY;
//#endif 

} 
else

//#if -248412301 
if(TodoTokenTable.STRING_PRIO_MED.equalsIgnoreCase(prio))//1
{ 

//#if 951147842 
np = ToDoItem.MED_PRIORITY;
//#endif 

} 
else

//#if -815783947 
if(TodoTokenTable.STRING_PRIO_LOW.equalsIgnoreCase(prio))//1
{ 

//#if 734455276 
np = ToDoItem.LOW_PRIORITY;
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#endif 


//#if 457374956 
priority = np;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

