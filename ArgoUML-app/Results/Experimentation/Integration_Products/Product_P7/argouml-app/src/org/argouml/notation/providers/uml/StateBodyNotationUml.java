package org.argouml.notation.providers.uml;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.StringTokenizer;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.StateBodyNotation;
public class StateBodyNotationUml extends StateBodyNotation
  { 
private static final String LANGUAGE = "Java";
private void updateAction(Object old, String s)
    { 
Object ae = Model.getFacade().getScript(old);
String language = LANGUAGE;
if(ae != null)//1
{ 
language = Model.getDataTypesHelper().getLanguage(ae);
String body = (String) Model.getFacade().getBody(ae);
if(body.equals(s))//1
{ 
return;
} 
} 
ae = Model.getDataTypesFactory().createActionExpression(language, s);
Model.getCommonBehaviorHelper().setScript(old, ae);
} 
private void parseStateDoAction(Object st, String s)
    { 
if(s.indexOf("/") > -1)//1
{ 
s = s.substring(s.indexOf("/") + 1).trim();
} 
Object oldDo = Model.getFacade().getDoActivity(st);
if(oldDo == null)//1
{ 
Model.getStateMachinesHelper().setDoActivity(st,
                    buildNewCallAction(s));
} 
else
{ 
updateAction(oldDo, s);
} 
} 
private String toString(Object modelElement)
    { 
StringBuffer s = new StringBuffer();
Object entryAction = Model.getFacade().getEntry(modelElement);
Object exitAction = Model.getFacade().getExit(modelElement);
Object doAction = Model.getFacade().getDoActivity(modelElement);
if(entryAction != null)//1
{ 
String entryStr =
                NotationUtilityUml.generateActionSequence(entryAction);
s.append("entry /").append(entryStr);
} 
if(doAction != null)//1
{ 
String doStr = NotationUtilityUml.generateActionSequence(doAction);
if(s.length() > 0)//1
{ 
s.append("\n");
} 
s.append("do /").append(doStr);
} 
if(exitAction != null)//1
{ 
String exitStr =
                NotationUtilityUml.generateActionSequence(exitAction);
if(s.length() > 0)//1
{ 
s.append("\n");
} 
s.append("exit /").append(exitStr);
} 
Collection internaltrans =
            Model.getFacade().getInternalTransitions(modelElement);
if(internaltrans != null)//1
{ 
for (Object trans : internaltrans) //1
{ 
if(s.length() > 0)//1
{ 
s.append("\n");
} 
s.append((new TransitionNotationUml(trans)).toString(trans,
                         NotationSettings.getDefaultSettings()));
} 
} 
return s.toString();
} 
private Object buildNewCallAction(String s)
    { 
Object a =
            Model.getCommonBehaviorFactory().createCallAction();
Object ae =
            Model.getDataTypesFactory().createActionExpression(LANGUAGE, s);
Model.getCommonBehaviorHelper().setScript(a, ae);
Model.getCoreHelper().setName(a, "anon");
return a;
} 
private void parseStateEntryAction(Object st, String s)
    { 
if(s.indexOf("/") > -1)//1
{ 
s = s.substring(s.indexOf("/") + 1).trim();
} 
Object oldEntry = Model.getFacade().getEntry(st);
if(oldEntry == null)//1
{ 
Model.getStateMachinesHelper().setEntry(st, buildNewCallAction(s));
} 
else
{ 
updateAction(oldEntry, s);
} 
} 
private void delete(Object obj)
    { 
if(obj != null)//1
{ 
Model.getUmlFactory().delete(obj);
} 
} 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 
return toString(modelElement);
} 
private void parseStateExitAction(Object st, String s)
    { 
if(s.indexOf("/") > -1)//1
{ 
s = s.substring(s.indexOf("/") + 1).trim();
} 
Object oldExit = Model.getFacade().getExit(st);
if(oldExit == null)//1
{ 
Model.getStateMachinesHelper().setExit(st, buildNewCallAction(s));
} 
else
{ 
updateAction(oldExit, s);
} 
} 
public String getParsingHelp()
    { 
return "parsing.help.fig-statebody";
} 
public StateBodyNotationUml(Object state)
    { 
super(state);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public String toString(Object modelElement, Map args)
    { 
return toString(modelElement);
} 
public void parse(Object modelElement, String text)
    { 
try//1
{ 
parseStateBody(modelElement, text);
} 
catch (ParseException pe) //1
{ 
String msg = "statusmsg.bar.error.parsing.statebody";
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
} 
} 
protected void parseStateBody(Object st, String s) throws ParseException
    { 
boolean foundEntry = false;
boolean foundExit = false;
boolean foundDo = false;
ModelElementInfoList internalsInfo =
            new ModelElementInfoList(
            Model.getFacade().getInternalTransitions(st));
StringTokenizer lines = new StringTokenizer(s, "\n\r");
while (lines.hasMoreTokens()) //1
{ 
String line = lines.nextToken().trim();
if(!internalsInfo.checkRetain(line))//1
{ 
if(line.toLowerCase().startsWith("entry")
                        && line.substring(5).trim().startsWith("/"))//1
{ 
parseStateEntryAction(st, line);
foundEntry = true;
} 
else
if(line.toLowerCase().startsWith("exit")
                           && line.substring(4).trim().startsWith("/"))//1
{ 
parseStateExitAction(st, line);
foundExit = true;
} 
else
if(line.toLowerCase().startsWith("do")
                           && line.substring(2).trim().startsWith("/"))//1
{ 
parseStateDoAction(st, line);
foundDo = true;
} 
else
{ 
Object t =
                        Model.getStateMachinesFactory()
                        .buildInternalTransition(st);
if(t == null)//1
{ 
continue;
} 
new TransitionNotationUml(t).parseTransition(t, line);
internalsInfo.add(t, true);
} 
} 
} 
if(!foundEntry)//1
{ 
delete(Model.getFacade().getEntry(st));
} 
if(!foundExit)//1
{ 
delete(Model.getFacade().getExit(st));
} 
if(!foundDo)//1
{ 
delete(Model.getFacade().getDoActivity(st));
} 
Model.getStateMachinesHelper().setInternalTransitions(st,
                internalsInfo.finalisedList());
} 
class ModelElementInfoList  { 
private Collection<InfoItem> theList;
Collection finalisedList()
        { 
Collection<Object> newModelElementsList = new ArrayList<Object>();
for (InfoItem tInfo : theList) //1
{ 
if(tInfo.isRetained())//1
{ 
newModelElementsList.add(tInfo.getUmlObject());
} 
else
{ 
delete(tInfo.getUmlObject());
} 
} 
theList.clear();
return newModelElementsList;
} 
boolean checkRetain(String line)
        { 
for (InfoItem tInfo : theList) //1
{ 
if(tInfo.getGenerated().equals(line))//1
{ 
tInfo.retain();
return true;
} 
} 
return false;
} 
ModelElementInfoList(Collection c)
        { 
theList = new ArrayList<InfoItem>();
for (Object obj : c) //1
{ 
theList.add(new InfoItem(obj));
} 
} 
void add(Object obj, boolean r)
        { 
theList.add(new InfoItem(obj, r));
} 
class InfoItem  { 
private TransitionNotationUml generator;
private Object umlObject;
private boolean retainIt;
boolean isRetained()
            { 
return retainIt;
} 
Object getUmlObject()
            { 
return umlObject;
} 
void retain()
            { 
retainIt = true;
} 
InfoItem(Object obj)
            { 
umlObject = obj;
generator = new TransitionNotationUml(obj);
} 
InfoItem(Object obj, boolean r)
            { 
this(obj);
retainIt = r;
} 
String getGenerated()
            { 
return generator.toString();
} 

 } 

 } 

 } 
