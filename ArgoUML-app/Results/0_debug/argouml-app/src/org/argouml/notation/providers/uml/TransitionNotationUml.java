
//#if 155212225 
// Compilation Unit of /TransitionNotationUml.java 
 

//#if -1512675377 
package org.argouml.notation.providers.uml;
//#endif 


//#if 765367555 
import java.beans.PropertyChangeListener;
//#endif 


//#if 1089277650 
import java.text.ParseException;
//#endif 


//#if 1751878693 
import java.util.Collection;
//#endif 


//#if 1386970709 
import java.util.Iterator;
//#endif 


//#if -1652150121 
import java.util.Map;
//#endif 


//#if 214494509 
import java.util.StringTokenizer;
//#endif 


//#if -130462796 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 368911905 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if -279222563 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if -1991069722 
import org.argouml.i18n.Translator;
//#endif 


//#if -1908187732 
import org.argouml.model.Model;
//#endif 


//#if -1237177409 
import org.argouml.notation.NotationSettings;
//#endif 


//#if 1599717121 
import org.argouml.notation.providers.TransitionNotation;
//#endif 


//#if 1848769940 
import org.argouml.model.StateMachinesFactory;
//#endif 


//#if -1519174527 
public class TransitionNotationUml extends 
//#if -417743044 
TransitionNotation
//#endif 

  { 

//#if 1355076760 
private String generateClassifierRef(Object cls)
    { 

//#if 1676994570 
if(cls == null)//1
{ 

//#if -201031176 
return "";
//#endif 

} 

//#endif 


//#if 1162791687 
return Model.getFacade().getName(cls);
//#endif 

} 

//#endif 


//#if -347595690 

//#if -1299987462 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(Object modelElement, Map args)
    { 

//#if -1867957642 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if -1571633394 
private void addListenersForAction(PropertyChangeListener listener,
                                       Object action)
    { 

//#if 1716048581 
if(action != null)//1
{ 

//#if 2095096531 
addElementListener(listener, action,
                               new String[] {
                                   // TODO: Action isn't a valid property name
                                   // Or is it?  Double check validity checking code
                                   "script", "actualArgument", "action"
                               });
//#endif 


//#if 1031295090 
Collection args = Model.getFacade().getActualArguments(action);
//#endif 


//#if 163368309 
Iterator i = args.iterator();
//#endif 


//#if 299845218 
while (i.hasNext()) //1
{ 

//#if 2045226665 
Object argument = i.next();
//#endif 


//#if -125604835 
addElementListener(listener, argument, "value");
//#endif 

} 

//#endif 


//#if 750970476 
if(Model.getFacade().isAActionSequence(action))//1
{ 

//#if 462660392 
Collection subactions = Model.getFacade().getActions(action);
//#endif 


//#if -1125669550 
i = subactions.iterator();
//#endif 


//#if 88272439 
while (i.hasNext()) //1
{ 

//#if 1638763065 
Object a = i.next();
//#endif 


//#if -1912169328 
addListenersForAction(listener, a);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -760519799 
private String generateExpression(Object expr)
    { 

//#if -1416562003 
if(Model.getFacade().isAExpression(expr))//1
{ 

//#if -917376307 
Object body = Model.getFacade().getBody(expr);
//#endif 


//#if 1833785424 
if(body != null)//1
{ 

//#if -25085418 
return (String) body;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -880128716 
return "";
//#endif 

} 

//#endif 


//#if -203300869 
protected Object parseTransition(Object trans, String s)
    throws ParseException
    { 

//#if -236016656 
s = s.trim();
//#endif 


//#if 406238105 
int a = s.indexOf("[");
//#endif 


//#if 1759607384 
int b = s.indexOf("]");
//#endif 


//#if -1183420601 
int c = s.indexOf("/");
//#endif 


//#if -413383000 
if(((a < 0) && (b >= 0)) || ((b < 0) && (a >= 0)) || (b < a))//1
{ 

//#if 1458854315 
String msg = "parsing.error.transition.no-matching-square-brackets";
//#endif 


//#if -1902956842 
throw new ParseException(Translator.localize(msg),
                                     0);
//#endif 

} 

//#endif 


//#if -1725237419 
if((c >= 0) && (c < b))//1
{ 

//#if -1569529217 
String msg = "parsing.error.transition.found-bracket-instead-slash";
//#endif 


//#if -1920704609 
throw new ParseException(Translator.localize(msg),
                                     0);
//#endif 

} 

//#endif 


//#if -1004548720 
StringTokenizer tokenizer = new StringTokenizer(s, "[/");
//#endif 


//#if -1752852247 
String eventSignature = null;
//#endif 


//#if -286870623 
String guardCondition = null;
//#endif 


//#if 1753081369 
String actionExpression = null;
//#endif 


//#if -816463839 
while (tokenizer.hasMoreTokens()) //1
{ 

//#if -376266630 
String nextToken = tokenizer.nextToken().trim();
//#endif 


//#if -1589807047 
if(nextToken.endsWith("]"))//1
{ 

//#if 78185758 
guardCondition = nextToken.substring(0, nextToken.length() - 1);
//#endif 

} 
else
{ 

//#if 1616207043 
if(s.startsWith(nextToken))//1
{ 

//#if -240553880 
eventSignature = nextToken;
//#endif 

} 
else
{ 

//#if -607055617 
if(s.endsWith(nextToken))//1
{ 

//#if -328480422 
actionExpression = nextToken;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1523566959 
if(eventSignature != null)//1
{ 

//#if -604503562 
parseTrigger(trans, eventSignature);
//#endif 

} 

//#endif 


//#if -594201271 
if(guardCondition != null)//1
{ 

//#if 1683692133 
parseGuard(trans,
                       guardCondition.substring(guardCondition.indexOf('[') + 1));
//#endif 

} 

//#endif 


//#if 44476097 
if(actionExpression != null)//1
{ 

//#if 1131461760 
parseEffect(trans, actionExpression.trim());
//#endif 

} 

//#endif 


//#if 184600070 
return trans;
//#endif 

} 

//#endif 


//#if 98290523 
public String getParsingHelp()
    { 

//#if -1765340476 
return "parsing.help.fig-transition";
//#endif 

} 

//#endif 


//#if -1470681796 
private void delete(Object obj)
    { 

//#if 1904115624 
if(obj != null)//1
{ 

//#if 595705230 
Model.getUmlFactory().delete(obj);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1532430180 
private void parseGuard(Object trans, String guard)
    { 

//#if 224910289 
Object g = Model.getFacade().getGuard(trans);
//#endif 


//#if 673123836 
if(guard.length() > 0)//1
{ 

//#if 2024693437 
if(g == null)//1
{ 

//#if -916152138 
g = Model.getStateMachinesFactory().createGuard();
//#endif 


//#if -785428345 
if(g != null)//1
{ 

//#if -149105371 
Model.getStateMachinesHelper().setExpression(g,
                            Model.getDataTypesFactory()
                            .createBooleanExpression("", guard));
//#endif 


//#if 1732815043 
Model.getCoreHelper().setName(g, "anon");
//#endif 


//#if 1012530725 
Model.getCommonBehaviorHelper().setTransition(g, trans);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -227872938 
Object expr = Model.getFacade().getExpression(g);
//#endif 


//#if 46278281 
String language = "";
//#endif 


//#if -1435489079 
if(expr != null)//1
{ 

//#if -1424057901 
language = Model.getDataTypesHelper().getLanguage(expr);
//#endif 

} 

//#endif 


//#if 1350903041 
Model.getStateMachinesHelper().setExpression(g,
                        Model.getDataTypesFactory()
                        .createBooleanExpression(language, guard));
//#endif 

} 

//#endif 

} 
else
{ 

//#if 513533430 
if(g == null)//1
{ 
} 
else
{ 

//#if -1296016486 
delete(g);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 2140485820 
public TransitionNotationUml(Object transition)
    { 

//#if 1893355174 
super(transition);
//#endif 

} 

//#endif 


//#if 740686135 
private String generateKind(Object /*Parameter etc.*/ kind)
    { 

//#if -1925923510 
StringBuffer s = new StringBuffer();
//#endif 


//#if -1564255751 
if(kind == null /* "in" is the default */
                || kind == Model.getDirectionKind().getInParameter())//1
{ 

//#if -1302634685 
s.append(/*"in"*/ "");
//#endif 

} 
else

//#if 1026214115 
if(kind == Model.getDirectionKind().getInOutParameter())//1
{ 

//#if 232612843 
s.append("inout");
//#endif 

} 
else

//#if 1858320059 
if(kind == Model.getDirectionKind().getReturnParameter())//1
{ 
} 
else

//#if -174249599 
if(kind == Model.getDirectionKind().getOutParameter())//1
{ 

//#if -1278886470 
s.append("out");
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if 1912294269 
return s.toString();
//#endif 

} 

//#endif 


//#if 185921958 
private void addListenersForEvent(PropertyChangeListener listener,
                                      Object event)
    { 

//#if 1361830768 
if(event != null)//1
{ 

//#if -1233155869 
if(Model.getFacade().isAEvent(event))//1
{ 

//#if -22557673 
addElementListener(listener, event,
                                   new String[] {
                                       "parameter", "name"
                                   });
//#endif 

} 

//#endif 


//#if -1302898992 
if(Model.getFacade().isATimeEvent(event))//1
{ 

//#if -1369608849 
addElementListener(listener, event, new String[] {"when"});
//#endif 

} 

//#endif 


//#if -1716192717 
if(Model.getFacade().isAChangeEvent(event))//1
{ 

//#if -153082312 
addElementListener(listener, event,
                                   new String[] {"changeExpression"});
//#endif 

} 

//#endif 


//#if -1797348961 
Collection prms = Model.getFacade().getParameters(event);
//#endif 


//#if -349055172 
Iterator i = prms.iterator();
//#endif 


//#if 1346234598 
while (i.hasNext()) //1
{ 

//#if 305939679 
Object parameter = i.next();
//#endif 


//#if -2130859252 
addElementListener(listener, parameter);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1347532493 
public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 

//#if 225959004 
addListenersForTransition(listener, modelElement);
//#endif 

} 

//#endif 


//#if -486601374 
private String generateGuard(Object m)
    { 

//#if 129051514 
if(m != null)//1
{ 

//#if 1088274749 
if(Model.getFacade().getExpression(m) != null)//1
{ 

//#if 253157098 
return generateExpression(Model.getFacade().getExpression(m));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 399024542 
return "";
//#endif 

} 

//#endif 


//#if -1888866753 
private void parseTrigger(Object trans, String trigger)
    throws ParseException
    { 

//#if 977612842 
String s = "";
//#endif 


//#if 1744582362 
boolean timeEvent = false;
//#endif 


//#if -1366839619 
boolean changeEvent = false;
//#endif 


//#if 1109953771 
boolean callEvent = false;
//#endif 


//#if -870492747 
boolean signalEvent = false;
//#endif 


//#if -2095524153 
trigger = trigger.trim();
//#endif 


//#if 753693329 
StringTokenizer tokenizer = new StringTokenizer(trigger, "()");
//#endif 


//#if -1301396433 
String name = tokenizer.nextToken().trim();
//#endif 


//#if 1588781506 
if(name.equalsIgnoreCase("after"))//1
{ 

//#if -694296748 
timeEvent = true;
//#endif 

} 
else

//#if -1923673941 
if(name.equalsIgnoreCase("when"))//1
{ 

//#if -490927678 
changeEvent = true;
//#endif 

} 
else
{ 

//#if -784456646 
if(tokenizer.hasMoreTokens()
                    || (trigger.indexOf("(") > 0)
                    || (trigger.indexOf(")") > 1))//1
{ 

//#if -371328284 
callEvent = true;
//#endif 


//#if 1439099698 
if(!trigger.endsWith(")") || !(trigger.indexOf("(") > 0))//1
{ 

//#if 1901043125 
String msg =
                        "parsing.error.transition.no-matching-brackets";
//#endif 


//#if 357210062 
throw new ParseException(
                        Translator.localize(msg), 0);
//#endif 

} 

//#endif 

} 
else
{ 

//#if 37153152 
signalEvent = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#if 366485234 
if(timeEvent || changeEvent || callEvent)//1
{ 

//#if -1608562574 
if(tokenizer.hasMoreTokens())//1
{ 

//#if 79541548 
s = tokenizer.nextToken().trim();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -360488475 
Object evt = Model.getFacade().getTrigger(trans);
//#endif 


//#if -1437409635 
if(evt == null)//1
{ 
} 
else
{ 

//#if -58004904 
delete(evt);
//#endif 

} 

//#endif 


//#if -1755898622 
Object ns =
            Model.getStateMachinesHelper()
            .findNamespaceForEvent(trans, null);
//#endif 


//#if -16199092 
StateMachinesFactory sMFactory =
            Model.getStateMachinesFactory();
//#endif 


//#if 1254977169 
boolean createdEvent = false;
//#endif 


//#if 2007819116 
if(trigger.length() > 0)//1
{ 

//#if -151045719 
if(evt == null)//1
{ 

//#if 1205154570 
if(timeEvent)//1
{ 

//#if 1723283145 
evt = sMFactory.buildTimeEvent(s, ns);
//#endif 

} 

//#endif 


//#if -1996191673 
if(changeEvent)//1
{ 

//#if -2123999949 
evt = sMFactory.buildChangeEvent(s, ns);
//#endif 

} 

//#endif 


//#if 1286733465 
if(callEvent)//1
{ 

//#if -1005719201 
String triggerName =
                        trigger.indexOf("(") > 0
                        ? trigger.substring(0, trigger.indexOf("(")).trim()
                        : trigger;
//#endif 


//#if -479322831 
evt = sMFactory.buildCallEvent(trans, triggerName, ns);
//#endif 


//#if -760028769 
NotationUtilityUml.parseParamList(evt, s, 0);
//#endif 

} 

//#endif 


//#if -799996849 
if(signalEvent)//1
{ 

//#if -852696351 
evt = sMFactory.buildSignalEvent(trigger, ns);
//#endif 

} 

//#endif 


//#if 1193493090 
createdEvent = true;
//#endif 

} 
else
{ 

//#if 333300443 
if(timeEvent)//1
{ 

//#if -1578096444 
if(Model.getFacade().isATimeEvent(evt))//1
{ 

//#if -1336874456 
Object timeExpr = Model.getFacade().getWhen(evt);
//#endif 


//#if -576240489 
Model.getDataTypesHelper().setBody(timeExpr, s);
//#endif 

} 
else
{ 

//#if -1251453400 
delete(evt);
//#endif 


//#if 1943147537 
evt = sMFactory.buildTimeEvent(s, ns);
//#endif 


//#if 463130354 
createdEvent = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1965582296 
if(changeEvent)//1
{ 

//#if 253496783 
if(Model.getFacade().isAChangeEvent(evt))//1
{ 

//#if 579420186 
Object changeExpr =
                            Model.getFacade().getChangeExpression(evt);
//#endif 


//#if 414951381 
if(changeExpr == null)//1
{ 

//#if -1219729044 
changeExpr = Model.getDataTypesFactory()
                                         .createBooleanExpression("", s);
//#endif 


//#if -598809097 
Model.getStateMachinesHelper().setExpression(evt,
                                    changeExpr);
//#endif 

} 
else
{ 

//#if -910443714 
Model.getDataTypesHelper().setBody(changeExpr, s);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -501606874 
delete(evt);
//#endif 


//#if 1935313078 
evt = sMFactory.buildChangeEvent(s, ns);
//#endif 


//#if -2110777232 
createdEvent = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 414879338 
if(callEvent)//1
{ 

//#if 1266089274 
if(Model.getFacade().isACallEvent(evt))//1
{ 

//#if -1385268468 
String triggerName =
                            trigger.indexOf("(") > 0
                            ? trigger.substring(0, trigger.indexOf("(")).trim()
                            : trigger;
//#endif 


//#if 2076322224 
if(!Model.getFacade().getName(evt)
                                .equals(triggerName))//1
{ 

//#if -750514696 
Model.getCoreHelper().setName(evt, triggerName);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1438679143 
delete(evt);
//#endif 


//#if -2077900176 
evt = sMFactory.buildCallEvent(trans, trigger, ns);
//#endif 


//#if -1092800365 
NotationUtilityUml.parseParamList(evt, s, 0);
//#endif 


//#if 206528419 
createdEvent = true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1133190176 
if(signalEvent)//1
{ 

//#if -791879836 
if(Model.getFacade().isASignalEvent(evt))//1
{ 

//#if -833070740 
if(!Model.getFacade().getName(evt).equals(trigger))//1
{ 

//#if -203841280 
Model.getCoreHelper().setName(evt, trigger);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1339378440 
delete(evt);
//#endif 


//#if -431348233 
evt = sMFactory.buildSignalEvent(trigger, ns);
//#endif 


//#if 28234178 
createdEvent = true;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1251900680 
if(createdEvent && (evt != null))//1
{ 

//#if -1885258446 
Model.getStateMachinesHelper().setEventAsTrigger(trans, evt);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -406076337 
if(evt == null)//1
{ 
} 
else
{ 

//#if 1377105236 
delete(evt);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -268315030 
private String toString(Object modelElement)
    { 

//#if -582603907 
Object trigger = Model.getFacade().getTrigger(modelElement);
//#endif 


//#if -34719779 
Object guard = Model.getFacade().getGuard(modelElement);
//#endif 


//#if 1611385165 
Object effect = Model.getFacade().getEffect(modelElement);
//#endif 


//#if -1129290267 
String t = generateEvent(trigger);
//#endif 


//#if 1774474000 
String g = generateGuard(guard);
//#endif 


//#if -637837236 
String e = NotationUtilityUml.generateActionSequence(effect);
//#endif 


//#if 1716959787 
if(g.length() > 0)//1
{ 

//#if 501959022 
t += " [" + g + "]";
//#endif 

} 

//#endif 


//#if -1556939155 
if(e.length() > 0)//1
{ 

//#if -1820078585 
t += " / " + e;
//#endif 

} 

//#endif 


//#if 1850643135 
return t;
//#endif 

} 

//#endif 


//#if -586517002 
private void parseEffect(Object trans, String actions)
    { 

//#if 2083233539 
Object effect = Model.getFacade().getEffect(trans);
//#endif 


//#if 1891616324 
if(actions.length() > 0)//1
{ 

//#if 924662360 
if(effect == null)//1
{ 

//#if -198577473 
effect =
                    Model.getCommonBehaviorFactory()
                    .createCallAction();
//#endif 


//#if -608675575 
Model.getStateMachinesHelper().setEffect(trans, effect);
//#endif 


//#if -12838338 
Model.getCommonBehaviorHelper().setScript(effect,
                        Model.getDataTypesFactory()
                        .createActionExpression(""/*language*/,
                                                actions));
//#endif 


//#if 426246833 
Model.getCoreHelper().setName(effect, "anon");
//#endif 

} 
else
{ 

//#if 1109263007 
Object script = Model.getFacade().getScript(effect);
//#endif 


//#if -2010271455 
String language = (script == null) ? null
                                  : Model.getDataTypesHelper().getLanguage(script);
//#endif 


//#if -2038970492 
Model.getCommonBehaviorHelper().setScript(effect,
                        Model.getDataTypesFactory()
                        .createActionExpression(language, actions));
//#endif 

} 

//#endif 

} 
else
{ 

//#if -473398849 
if(effect == null)//1
{ 
} 
else
{ 

//#if -1955569262 
delete(effect);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2033145848 
public void parse(Object modelElement, String text)
    { 

//#if -1896248387 
try //1
{ 

//#if -1040481397 
parseTransition(modelElement, text);
//#endif 

} 

//#if -2111873549 
catch (ParseException pe) //1
{ 

//#if -149813224 
String msg = "statusmsg.bar.error.parsing.transition";
//#endif 


//#if -1094032525 
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
//#endif 


//#if 1730466368 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 496065805 
private String generateEvent(Object m)
    { 

//#if 2065679164 
if(m == null)//1
{ 

//#if 1844915160 
return "";
//#endif 

} 

//#endif 


//#if 258077800 
StringBuffer event = new StringBuffer();
//#endif 


//#if 820006999 
if(Model.getFacade().isAChangeEvent(m))//1
{ 

//#if -1442039743 
event.append("when(");
//#endif 


//#if -170457841 
event.append(
                generateExpression(Model.getFacade().getExpression(m)));
//#endif 


//#if 118526950 
event.append(")");
//#endif 

} 
else

//#if -1836807262 
if(Model.getFacade().isATimeEvent(m))//1
{ 

//#if 367572923 
event.append("after(");
//#endif 


//#if 1280322493 
event.append(
                generateExpression(Model.getFacade().getExpression(m)));
//#endif 


//#if 973981688 
event.append(")");
//#endif 

} 
else

//#if -885158934 
if(Model.getFacade().isASignalEvent(m))//1
{ 

//#if 464405140 
event.append(Model.getFacade().getName(m));
//#endif 

} 
else

//#if -426133816 
if(Model.getFacade().isACallEvent(m))//1
{ 

//#if 1981039152 
event.append(Model.getFacade().getName(m));
//#endif 


//#if -1666647459 
event.append(generateParameterList(m));
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if -123631137 
return event.toString();
//#endif 

} 

//#endif 


//#if 1315648898 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if -2100603900 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if -1620952654 
public String generateParameter(Object parameter)
    { 

//#if -1011734846 
StringBuffer s = new StringBuffer();
//#endif 


//#if 10748849 
s.append(generateKind(Model.getFacade().getKind(parameter)));
//#endif 


//#if 182368937 
if(s.length() > 0)//1
{ 

//#if 124255823 
s.append(" ");
//#endif 

} 

//#endif 


//#if -42801296 
s.append(Model.getFacade().getName(parameter));
//#endif 


//#if 55370730 
String classRef =
            generateClassifierRef(Model.getFacade().getType(parameter));
//#endif 


//#if -628556633 
if(classRef.length() > 0)//1
{ 

//#if -1600367739 
s.append(" : ");
//#endif 


//#if 558957060 
s.append(classRef);
//#endif 

} 

//#endif 


//#if -1211828045 
String defaultValue =
            generateExpression(Model.getFacade().getDefaultValue(parameter));
//#endif 


//#if -1765588270 
if(defaultValue.length() > 0)//1
{ 

//#if -1642195753 
s.append(" = ");
//#endif 


//#if -812264348 
s.append(defaultValue);
//#endif 

} 

//#endif 


//#if -778576123 
return s.toString();
//#endif 

} 

//#endif 


//#if 616399385 
private String generateParameterList(Object parameterListOwner)
    { 

//#if -546523053 
Iterator it =
            Model.getFacade().getParameters(parameterListOwner).iterator();
//#endif 


//#if 353222033 
StringBuffer list = new StringBuffer();
//#endif 


//#if -1443974230 
list.append("(");
//#endif 


//#if 582590648 
if(it.hasNext())//1
{ 

//#if 531929802 
while (it.hasNext()) //1
{ 

//#if 1101536112 
Object param = it.next();
//#endif 


//#if 1844901597 
list.append(generateParameter(param));
//#endif 


//#if 828347457 
if(it.hasNext())//1
{ 

//#if -816737681 
list.append(", ");
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1443944439 
list.append(")");
//#endif 


//#if -2042789772 
return list.toString();
//#endif 

} 

//#endif 


//#if 1575365008 
private void addListenersForTransition(PropertyChangeListener listener,
                                           Object transition)
    { 

//#if -340403577 
addElementListener(listener, transition,
                           new String[] {"guard", "trigger", "effect"});
//#endif 


//#if -1672376877 
Object guard = Model.getFacade().getGuard(transition);
//#endif 


//#if 1933236793 
if(guard != null)//1
{ 

//#if -914477715 
addElementListener(listener, guard, "expression");
//#endif 

} 

//#endif 


//#if -2123927693 
Object trigger = Model.getFacade().getTrigger(transition);
//#endif 


//#if 421752855 
addListenersForEvent(listener, trigger);
//#endif 


//#if -51519933 
Object effect = Model.getFacade().getEffect(transition);
//#endif 


//#if 1397497568 
addListenersForAction(listener, effect);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

