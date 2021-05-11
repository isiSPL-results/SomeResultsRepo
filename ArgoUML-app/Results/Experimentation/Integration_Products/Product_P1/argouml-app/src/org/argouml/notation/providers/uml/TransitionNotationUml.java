package org.argouml.notation.providers.uml;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.TransitionNotation;
public class TransitionNotationUml extends TransitionNotation
  { 
private String generateClassifierRef(Object cls)
    { 
if(cls == null)//1
{ 
return "";
} 
return Model.getFacade().getName(cls);
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public String toString(Object modelElement, Map args)
    { 
return toString(modelElement);
} 
private void addListenersForAction(PropertyChangeListener listener,
                                       Object action)
    { 
if(action != null)//1
{ 
addElementListener(listener, action,
                               new String[] {
                                   // TODO: Action isn't a valid property name
                                   // Or is it?  Double check validity checking code
                                   "script", "actualArgument", "action"
                               });
Collection args = Model.getFacade().getActualArguments(action);
Iterator i = args.iterator();
while (i.hasNext()) //1
{ 
Object argument = i.next();
addElementListener(listener, argument, "value");
} 
if(Model.getFacade().isAActionSequence(action))//1
{ 
Collection subactions = Model.getFacade().getActions(action);
i = subactions.iterator();
while (i.hasNext()) //1
{ 
Object a = i.next();
addListenersForAction(listener, a);
} 
} 
} 
} 
private String generateExpression(Object expr)
    { 
if(Model.getFacade().isAExpression(expr))//1
{ 
Object body = Model.getFacade().getBody(expr);
if(body != null)//1
{ 
return (String) body;
} 
} 
return "";
} 
protected Object parseTransition(Object trans, String s)
    throws ParseException
    { 
s = s.trim();
int a = s.indexOf("[");
int b = s.indexOf("]");
int c = s.indexOf("/");
if(((a < 0) && (b >= 0)) || ((b < 0) && (a >= 0)) || (b < a))//1
{ 
String msg = "parsing.error.transition.no-matching-square-brackets";
throw new ParseException(Translator.localize(msg),
                                     0);
} 
if((c >= 0) && (c < b))//1
{ 
String msg = "parsing.error.transition.found-bracket-instead-slash";
throw new ParseException(Translator.localize(msg),
                                     0);
} 
StringTokenizer tokenizer = new StringTokenizer(s, "[/");
String eventSignature = null;
String guardCondition = null;
String actionExpression = null;
while (tokenizer.hasMoreTokens()) //1
{ 
String nextToken = tokenizer.nextToken().trim();
if(nextToken.endsWith("]"))//1
{ 
guardCondition = nextToken.substring(0, nextToken.length() - 1);
} 
else
{ 
if(s.startsWith(nextToken))//1
{ 
eventSignature = nextToken;
} 
else
{ 
if(s.endsWith(nextToken))//1
{ 
actionExpression = nextToken;
} 
} 
} 
} 
if(eventSignature != null)//1
{ 
parseTrigger(trans, eventSignature);
} 
if(guardCondition != null)//1
{ 
parseGuard(trans,
                       guardCondition.substring(guardCondition.indexOf('[') + 1));
} 
if(actionExpression != null)//1
{ 
parseEffect(trans, actionExpression.trim());
} 
return trans;
} 
public String getParsingHelp()
    { 
return "parsing.help.fig-transition";
} 
private void delete(Object obj)
    { 
if(obj != null)//1
{ 
Model.getUmlFactory().delete(obj);
} 
} 
private void parseGuard(Object trans, String guard)
    { 
Object g = Model.getFacade().getGuard(trans);
if(guard.length() > 0)//1
{ 
if(g == null)//1
{ 
} 
else
{ 
Object expr = Model.getFacade().getExpression(g);
String language = "";
if(expr != null)//1
{ 
language = Model.getDataTypesHelper().getLanguage(expr);
} 
} 
} 
else
{ 
if(g == null)//1
{ 
} 
else
{ 
delete(g);
} 
} 
} 
public TransitionNotationUml(Object transition)
    { 
super(transition);
} 
private String generateKind(Object /*Parameter etc.*/ kind)
    { 
StringBuffer s = new StringBuffer();
if(kind == null /* "in" is the default */
                || kind == Model.getDirectionKind().getInParameter())//1
{ 
s.append(/*"in"*/ "");
} 
else
if(kind == Model.getDirectionKind().getInOutParameter())//1
{ 
s.append("inout");
} 
else
if(kind == Model.getDirectionKind().getReturnParameter())//1
{ 
} 
else
if(kind == Model.getDirectionKind().getOutParameter())//1
{ 
s.append("out");
} 
return s.toString();
} 
private void addListenersForEvent(PropertyChangeListener listener,
                                      Object event)
    { 
if(event != null)//1
{ 
if(Model.getFacade().isAEvent(event))//1
{ 
addElementListener(listener, event,
                                   new String[] {
                                       "parameter", "name"
                                   });
} 
if(Model.getFacade().isATimeEvent(event))//1
{ 
addElementListener(listener, event, new String[] {"when"});
} 
if(Model.getFacade().isAChangeEvent(event))//1
{ 
addElementListener(listener, event,
                                   new String[] {"changeExpression"});
} 
Collection prms = Model.getFacade().getParameters(event);
Iterator i = prms.iterator();
while (i.hasNext()) //1
{ 
Object parameter = i.next();
addElementListener(listener, parameter);
} 
} 
} 
public void initialiseListener(PropertyChangeListener listener,
                                   Object modelElement)
    { 
addListenersForTransition(listener, modelElement);
} 
private String generateGuard(Object m)
    { 
if(m != null)//1
{ 
if(Model.getFacade().getExpression(m) != null)//1
{ 
return generateExpression(Model.getFacade().getExpression(m));
} 
} 
return "";
} 
private void parseTrigger(Object trans, String trigger)
    throws ParseException
    { 
String s = "";
boolean timeEvent = false;
boolean changeEvent = false;
boolean callEvent = false;
boolean signalEvent = false;
trigger = trigger.trim();
StringTokenizer tokenizer = new StringTokenizer(trigger, "()");
String name = tokenizer.nextToken().trim();
if(name.equalsIgnoreCase("after"))//1
{ 
timeEvent = true;
} 
else
if(name.equalsIgnoreCase("when"))//1
{ 
changeEvent = true;
} 
else
{ 
if(tokenizer.hasMoreTokens()
                    || (trigger.indexOf("(") > 0)
                    || (trigger.indexOf(")") > 1))//1
{ 
callEvent = true;
if(!trigger.endsWith(")") || !(trigger.indexOf("(") > 0))//1
{ 
String msg =
                        "parsing.error.transition.no-matching-brackets";
throw new ParseException(
                        Translator.localize(msg), 0);
} 
} 
else
{ 
signalEvent = true;
} 
} 
if(timeEvent || changeEvent || callEvent)//1
{ 
if(tokenizer.hasMoreTokens())//1
{ 
s = tokenizer.nextToken().trim();
} 
} 
Object evt = Model.getFacade().getTrigger(trans);
if(evt == null)//1
{ 
} 
else
{ 
delete(evt);
} 
} 
private String toString(Object modelElement)
    { 
Object trigger = Model.getFacade().getTrigger(modelElement);
Object guard = Model.getFacade().getGuard(modelElement);
Object effect = Model.getFacade().getEffect(modelElement);
String t = generateEvent(trigger);
String g = generateGuard(guard);
String e = NotationUtilityUml.generateActionSequence(effect);
if(g.length() > 0)//1
{ 
t += " [" + g + "]";
} 
if(e.length() > 0)//1
{ 
t += " / " + e;
} 
return t;
} 
private void parseEffect(Object trans, String actions)
    { 
Object effect = Model.getFacade().getEffect(trans);
if(actions.length() > 0)//1
{ 
if(effect == null)//1
{ 
effect =
                    Model.getCommonBehaviorFactory()
                    .createCallAction();
Model.getCommonBehaviorHelper().setScript(effect,
                        Model.getDataTypesFactory()
                        .createActionExpression(""/*language*/,
                                                actions));
Model.getCoreHelper().setName(effect, "anon");
} 
else
{ 
Object script = Model.getFacade().getScript(effect);
String language = (script == null) ? null
                                  : Model.getDataTypesHelper().getLanguage(script);
Model.getCommonBehaviorHelper().setScript(effect,
                        Model.getDataTypesFactory()
                        .createActionExpression(language, actions));
} 
} 
else
{ 
if(effect == null)//1
{ 
} 
else
{ 
delete(effect);
} 
} 
} 
public void parse(Object modelElement, String text)
    { 
try//1
{ 
parseTransition(modelElement, text);
} 
catch (ParseException pe) //1
{ 
String msg = "statusmsg.bar.error.parsing.transition";
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
} 
} 
private String generateEvent(Object m)
    { 
if(m == null)//1
{ 
return "";
} 
StringBuffer event = new StringBuffer();
if(Model.getFacade().isAChangeEvent(m))//1
{ 
event.append("when(");
event.append(
                generateExpression(Model.getFacade().getExpression(m)));
event.append(")");
} 
else
if(Model.getFacade().isATimeEvent(m))//1
{ 
event.append("after(");
event.append(
                generateExpression(Model.getFacade().getExpression(m)));
event.append(")");
} 
else
if(Model.getFacade().isASignalEvent(m))//1
{ 
event.append(Model.getFacade().getName(m));
} 
else
if(Model.getFacade().isACallEvent(m))//1
{ 
event.append(Model.getFacade().getName(m));
event.append(generateParameterList(m));
} 
return event.toString();
} 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 
return toString(modelElement);
} 
public String generateParameter(Object parameter)
    { 
StringBuffer s = new StringBuffer();
s.append(generateKind(Model.getFacade().getKind(parameter)));
if(s.length() > 0)//1
{ 
s.append(" ");
} 
s.append(Model.getFacade().getName(parameter));
String classRef =
            generateClassifierRef(Model.getFacade().getType(parameter));
if(classRef.length() > 0)//1
{ 
s.append(" : ");
s.append(classRef);
} 
String defaultValue =
            generateExpression(Model.getFacade().getDefaultValue(parameter));
if(defaultValue.length() > 0)//1
{ 
s.append(" = ");
s.append(defaultValue);
} 
return s.toString();
} 
private String generateParameterList(Object parameterListOwner)
    { 
Iterator it =
            Model.getFacade().getParameters(parameterListOwner).iterator();
StringBuffer list = new StringBuffer();
list.append("(");
if(it.hasNext())//1
{ 
while (it.hasNext()) //1
{ 
Object param = it.next();
list.append(generateParameter(param));
if(it.hasNext())//1
{ 
list.append(", ");
} 
} 
} 
list.append(")");
return list.toString();
} 
private void addListenersForTransition(PropertyChangeListener listener,
                                           Object transition)
    { 
addElementListener(listener, transition,
                           new String[] {"guard", "trigger", "effect"});
Object guard = Model.getFacade().getGuard(transition);
if(guard != null)//1
{ 
addElementListener(listener, guard, "expression");
} 
Object trigger = Model.getFacade().getTrigger(transition);
addListenersForEvent(listener, trigger);
Object effect = Model.getFacade().getEffect(transition);
addListenersForAction(listener, effect);
} 

 } 
