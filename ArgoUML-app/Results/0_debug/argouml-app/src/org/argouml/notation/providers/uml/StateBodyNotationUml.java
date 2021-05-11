
//#if -467207827 
// Compilation Unit of /StateBodyNotationUml.java 
 

//#if 74106952 
package org.argouml.notation.providers.uml;
//#endif 


//#if -1758445575 
import java.text.ParseException;
//#endif 


//#if 1463919413 
import java.util.ArrayList;
//#endif 


//#if -523540276 
import java.util.Collection;
//#endif 


//#if -646565424 
import java.util.Map;
//#endif 


//#if 2129387750 
import java.util.StringTokenizer;
//#endif 


//#if -1052286117 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 1857160026 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if -1201045884 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if -24667809 
import org.argouml.i18n.Translator;
//#endif 


//#if -1445860443 
import org.argouml.model.Model;
//#endif 


//#if -1052749320 
import org.argouml.notation.NotationSettings;
//#endif 


//#if -564325360 
import org.argouml.notation.providers.StateBodyNotation;
//#endif 


//#if 597080738 
public class StateBodyNotationUml extends 
//#if -1369579218 
StateBodyNotation
//#endif 

  { 

//#if -1719303787 
private static final String LANGUAGE = "Java";
//#endif 


//#if -28628092 
private void updateAction(Object old, String s)
    { 

//#if 249769408 
Object ae = Model.getFacade().getScript(old);
//#endif 


//#if -1048344391 
String language = LANGUAGE;
//#endif 


//#if -761697104 
if(ae != null)//1
{ 

//#if 1579659576 
language = Model.getDataTypesHelper().getLanguage(ae);
//#endif 


//#if -188469034 
String body = (String) Model.getFacade().getBody(ae);
//#endif 


//#if -162784774 
if(body.equals(s))//1
{ 

//#if 990005179 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1687570401 
ae = Model.getDataTypesFactory().createActionExpression(language, s);
//#endif 


//#if -1101494287 
Model.getCommonBehaviorHelper().setScript(old, ae);
//#endif 

} 

//#endif 


//#if 1080440922 
private void parseStateDoAction(Object st, String s)
    { 

//#if -1381352064 
if(s.indexOf("/") > -1)//1
{ 

//#if 899687808 
s = s.substring(s.indexOf("/") + 1).trim();
//#endif 

} 

//#endif 


//#if 242379494 
Object oldDo = Model.getFacade().getDoActivity(st);
//#endif 


//#if -404280955 
if(oldDo == null)//1
{ 

//#if -1383796911 
Model.getStateMachinesHelper().setDoActivity(st,
                    buildNewCallAction(s));
//#endif 

} 
else
{ 

//#if 1779977214 
updateAction(oldDo, s);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -939564536 
private String toString(Object modelElement)
    { 

//#if 1839225314 
StringBuffer s = new StringBuffer();
//#endif 


//#if -1968982147 
Object entryAction = Model.getFacade().getEntry(modelElement);
//#endif 


//#if -1414537913 
Object exitAction = Model.getFacade().getExit(modelElement);
//#endif 


//#if 1131727774 
Object doAction = Model.getFacade().getDoActivity(modelElement);
//#endif 


//#if 556690406 
if(entryAction != null)//1
{ 

//#if 620379235 
String entryStr =
                NotationUtilityUml.generateActionSequence(entryAction);
//#endif 


//#if -1014703566 
s.append("entry /").append(entryStr);
//#endif 

} 

//#endif 


//#if -19759815 
if(doAction != null)//1
{ 

//#if 447132246 
String doStr = NotationUtilityUml.generateActionSequence(doAction);
//#endif 


//#if -300361116 
if(s.length() > 0)//1
{ 

//#if -514517950 
s.append("\n");
//#endif 

} 

//#endif 


//#if 1575392991 
s.append("do /").append(doStr);
//#endif 

} 

//#endif 


//#if -1899244404 
if(exitAction != null)//1
{ 

//#if -124132247 
String exitStr =
                NotationUtilityUml.generateActionSequence(exitAction);
//#endif 


//#if -208353449 
if(s.length() > 0)//1
{ 

//#if 669350508 
s.append("\n");
//#endif 

} 

//#endif 


//#if 1347444652 
s.append("exit /").append(exitStr);
//#endif 

} 

//#endif 


//#if 1201440722 
Collection internaltrans =
            Model.getFacade().getInternalTransitions(modelElement);
//#endif 


//#if -1955614679 
if(internaltrans != null)//1
{ 

//#if -1213313372 
for (Object trans : internaltrans) //1
{ 

//#if -1569539446 
if(s.length() > 0)//1
{ 

//#if -1367517237 
s.append("\n");
//#endif 

} 

//#endif 


//#if 703622564 
s.append((new TransitionNotationUml(trans)).toString(trans,
                         NotationSettings.getDefaultSettings()));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1828001765 
return s.toString();
//#endif 

} 

//#endif 


//#if -197741970 
private Object buildNewCallAction(String s)
    { 

//#if -1175680293 
Object a =
            Model.getCommonBehaviorFactory().createCallAction();
//#endif 


//#if -1121104581 
Object ae =
            Model.getDataTypesFactory().createActionExpression(LANGUAGE, s);
//#endif 


//#if 531781492 
Model.getCommonBehaviorHelper().setScript(a, ae);
//#endif 


//#if 1053917186 
Model.getCoreHelper().setName(a, "anon");
//#endif 


//#if -1379618991 
return a;
//#endif 

} 

//#endif 


//#if 276191909 
private void parseStateEntryAction(Object st, String s)
    { 

//#if 983144644 
if(s.indexOf("/") > -1)//1
{ 

//#if -304124140 
s = s.substring(s.indexOf("/") + 1).trim();
//#endif 

} 

//#endif 


//#if 514135453 
Object oldEntry = Model.getFacade().getEntry(st);
//#endif 


//#if 1894696178 
if(oldEntry == null)//1
{ 

//#if 2017643375 
Model.getStateMachinesHelper().setEntry(st, buildNewCallAction(s));
//#endif 

} 
else
{ 

//#if -14421519 
updateAction(oldEntry, s);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -93775650 
private void delete(Object obj)
    { 

//#if -1031127389 
if(obj != null)//1
{ 

//#if 1760232217 
Model.getUmlFactory().delete(obj);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 589698468 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if 1345590899 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if -896460691 
private void parseStateExitAction(Object st, String s)
    { 

//#if -1259731659 
if(s.indexOf("/") > -1)//1
{ 

//#if 1444894907 
s = s.substring(s.indexOf("/") + 1).trim();
//#endif 

} 

//#endif 


//#if -818892988 
Object oldExit = Model.getFacade().getExit(st);
//#endif 


//#if -2034127411 
if(oldExit == null)//1
{ 

//#if 2085579430 
Model.getStateMachinesHelper().setExit(st, buildNewCallAction(s));
//#endif 

} 
else
{ 

//#if -828452400 
updateAction(oldExit, s);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1475196669 
public String getParsingHelp()
    { 

//#if 1272302258 
return "parsing.help.fig-statebody";
//#endif 

} 

//#endif 


//#if -942050576 
public StateBodyNotationUml(Object state)
    { 

//#if -234945007 
super(state);
//#endif 

} 

//#endif 


//#if 272710772 

//#if -1176407106 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(Object modelElement, Map args)
    { 

//#if 1028698597 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if 1680846634 
public void parse(Object modelElement, String text)
    { 

//#if 1955372585 
try //1
{ 

//#if -1614387408 
parseStateBody(modelElement, text);
//#endif 

} 

//#if -1526899214 
catch (ParseException pe) //1
{ 

//#if 1993014506 
String msg = "statusmsg.bar.error.parsing.statebody";
//#endif 


//#if 827607035 
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
//#endif 


//#if -314073416 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 597633551 
protected void parseStateBody(Object st, String s) throws ParseException
    { 

//#if 786789026 
boolean foundEntry = false;
//#endif 


//#if -865167912 
boolean foundExit = false;
//#endif 


//#if -952190453 
boolean foundDo = false;
//#endif 


//#if -1785664347 
ModelElementInfoList internalsInfo =
            new ModelElementInfoList(
            Model.getFacade().getInternalTransitions(st));
//#endif 


//#if -1622792794 
StringTokenizer lines = new StringTokenizer(s, "\n\r");
//#endif 


//#if 590882471 
while (lines.hasMoreTokens()) //1
{ 

//#if 595930131 
String line = lines.nextToken().trim();
//#endif 


//#if -2052963431 
if(!internalsInfo.checkRetain(line))//1
{ 

//#if -1782799766 
if(line.toLowerCase().startsWith("entry")
                        && line.substring(5).trim().startsWith("/"))//1
{ 

//#if 562761121 
parseStateEntryAction(st, line);
//#endif 


//#if 642268018 
foundEntry = true;
//#endif 

} 
else

//#if 1479171315 
if(line.toLowerCase().startsWith("exit")
                           && line.substring(4).trim().startsWith("/"))//1
{ 

//#if 1050318580 
parseStateExitAction(st, line);
//#endif 


//#if 559725975 
foundExit = true;
//#endif 

} 
else

//#if -1277780990 
if(line.toLowerCase().startsWith("do")
                           && line.substring(2).trim().startsWith("/"))//1
{ 

//#if -1647418429 
parseStateDoAction(st, line);
//#endif 


//#if 447711266 
foundDo = true;
//#endif 

} 
else
{ 

//#if 938871887 
Object t =
                        Model.getStateMachinesFactory()
                        .buildInternalTransition(st);
//#endif 


//#if 99280085 
if(t == null)//1
{ 

//#if -555496327 
continue;
//#endif 

} 

//#endif 


//#if -494523607 
new TransitionNotationUml(t).parseTransition(t, line);
//#endif 


//#if 968758502 
internalsInfo.add(t, true);
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 2139522963 
if(!foundEntry)//1
{ 

//#if -1919534756 
delete(Model.getFacade().getEntry(st));
//#endif 

} 

//#endif 


//#if 1978330605 
if(!foundExit)//1
{ 

//#if -178578521 
delete(Model.getFacade().getExit(st));
//#endif 

} 

//#endif 


//#if 146385050 
if(!foundDo)//1
{ 

//#if -606493556 
delete(Model.getFacade().getDoActivity(st));
//#endif 

} 

//#endif 


//#if -1196467210 
Model.getStateMachinesHelper().setInternalTransitions(st,
                internalsInfo.finalisedList());
//#endif 

} 

//#endif 


//#if 1698880016 
class ModelElementInfoList  { 

//#if 709176453 
private Collection<InfoItem> theList;
//#endif 


//#if 801312311 
Collection finalisedList()
        { 

//#if -696430078 
Collection<Object> newModelElementsList = new ArrayList<Object>();
//#endif 


//#if -1985551393 
for (InfoItem tInfo : theList) //1
{ 

//#if -524420994 
if(tInfo.isRetained())//1
{ 

//#if 217173436 
newModelElementsList.add(tInfo.getUmlObject());
//#endif 

} 
else
{ 

//#if 1964748987 
delete(tInfo.getUmlObject());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 633097324 
theList.clear();
//#endif 


//#if -263275923 
return newModelElementsList;
//#endif 

} 

//#endif 


//#if -1559272982 
boolean checkRetain(String line)
        { 

//#if -608115560 
for (InfoItem tInfo : theList) //1
{ 

//#if 210707416 
if(tInfo.getGenerated().equals(line))//1
{ 

//#if -1888800314 
tInfo.retain();
//#endif 


//#if -1512203014 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1615590673 
return false;
//#endif 

} 

//#endif 


//#if 1782009764 
ModelElementInfoList(Collection c)
        { 

//#if -968273018 
theList = new ArrayList<InfoItem>();
//#endif 


//#if 1699373148 
for (Object obj : c) //1
{ 

//#if 780523047 
theList.add(new InfoItem(obj));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -161225785 
void add(Object obj, boolean r)
        { 

//#if 928764083 
theList.add(new InfoItem(obj, r));
//#endif 

} 

//#endif 


//#if -1715170064 
class InfoItem  { 

//#if -8390339 
private TransitionNotationUml generator;
//#endif 


//#if -682393585 
private Object umlObject;
//#endif 


//#if 441626635 
private boolean retainIt;
//#endif 


//#if -1517805988 
boolean isRetained()
            { 

//#if 1143020847 
return retainIt;
//#endif 

} 

//#endif 


//#if 1576020216 
Object getUmlObject()
            { 

//#if -1310948422 
return umlObject;
//#endif 

} 

//#endif 


//#if -1103606539 
void retain()
            { 

//#if -2132039205 
retainIt = true;
//#endif 

} 

//#endif 


//#if -940547715 
InfoItem(Object obj)
            { 

//#if -514325501 
umlObject = obj;
//#endif 


//#if -1451334115 
generator = new TransitionNotationUml(obj);
//#endif 

} 

//#endif 


//#if -1722392929 
InfoItem(Object obj, boolean r)
            { 

//#if 393017946 
this(obj);
//#endif 


//#if 1275918939 
retainIt = r;
//#endif 

} 

//#endif 


//#if -1984259162 
String getGenerated()
            { 

//#if -850806592 
return generator.toString();
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

