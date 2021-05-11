package org.argouml.notation.providers.uml;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.i18n.Translator;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.ObjectFlowStateStateNotation;
public class ObjectFlowStateStateNotationUml extends ObjectFlowStateStateNotation
  { 
public String getParsingHelp()
    { 
return "parsing.help.fig-objectflowstate2";
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public String toString(Object modelElement, Map args)
    { 
return toString(modelElement);
} 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 
return toString(modelElement);
} 
public void parse(Object modelElement, String text)
    { 
try//1
{ 
parseObjectFlowState2(modelElement, text);
} 
catch (ParseException pe) //1
{ 
String msg = "statusmsg.bar.error.parsing.objectflowstate";
Object[] args = {pe.getLocalizedMessage(),
                             Integer.valueOf(pe.getErrorOffset()),
                            };
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
} 
} 
private void delete(Object obj)
    { 
if(obj != null)//1
{ 
ProjectManager.getManager().getCurrentProject().moveToTrash(obj);
} 
} 
protected Object parseObjectFlowState2(Object objectFlowState, String s)
    throws ParseException
    { 
s = s.trim();
if(s.startsWith("["))//1
{ 
s = s.substring(1);
} 
if(s.endsWith("]"))//1
{ 
s = s.substring(0, s.length() - 1);
} 
s = s.trim();
Object c = Model.getFacade().getType(objectFlowState);
if(c != null)//1
{ 
if(Model.getFacade().isAClassifierInState(c))//1
{ 
Object classifier = Model.getFacade().getType(c);
if((s == null) || "".equals(s))//1
{ 
Model.getCoreHelper().setType(objectFlowState, classifier);
delete(c);
Model.getCoreHelper().setType(objectFlowState, classifier);
return objectFlowState;
} 
Collection states =
                    new ArrayList(Model.getFacade()
                                  .getInStates(c));
Collection statesToBeRemoved = new ArrayList(states);
Collection namesToBeAdded = new ArrayList();
StringTokenizer tokenizer = new StringTokenizer(s, ",");
while (tokenizer.hasMoreTokens()) //1
{ 
String nextToken = tokenizer.nextToken().trim();
boolean found = false;
Iterator i = states.iterator();
while (i.hasNext()) //1
{ 
Object state = i.next();
if(Model.getFacade().getName(state) == nextToken)//1
{ 
found = true;
statesToBeRemoved.remove(state);
} 
} 
if(!found)//1
{ 
namesToBeAdded.add(nextToken);
} 
} 
states.removeAll(statesToBeRemoved);
Iterator i = namesToBeAdded.iterator();
while (i.hasNext()) //1
{ 
String name = (String) i.next();
Object state =
                        Model.getActivityGraphsHelper()
                        .findStateByName(classifier, name);
if(state != null)//1
{ 
states.add(state);
} 
else
{ 
String msg =
                            "parsing.error.object-flow-state.state-not-found";
Object[] args = {s};
throw new ParseException(Translator.localize(msg, args),
                                                 0);
} 
} 
Model.getActivityGraphsHelper().setInStates(c, states);
} 
else
{ 
Collection statesToBeAdded = new ArrayList();
StringTokenizer tokenizer = new StringTokenizer(s, ",");
while (tokenizer.hasMoreTokens()) //1
{ 
String nextToken = tokenizer.nextToken().trim();
Object state =
                        Model.getActivityGraphsHelper()
                        .findStateByName(c, nextToken);
if(state != null)//1
{ 
statesToBeAdded.add(state);
} 
else
{ 
String msg =
                            "parsing.error.object-flow-state.state-not-found";
Object[] args = {s};
throw new ParseException(Translator.localize(msg, args),
                                                 0);
} 
} 
Object cis =
                    Model.getActivityGraphsFactory()
                    .buildClassifierInState(c, statesToBeAdded);
Model.getCoreHelper().setType(objectFlowState, cis);
} 
} 
else
{ 
String msg =
                "parsing.error.object-flow-state.classifier-not-found";
throw new ParseException(Translator.localize(msg),
                                     0);
} 
return objectFlowState;
} 
public ObjectFlowStateStateNotationUml(Object objectflowstate)
    { 
super(objectflowstate);
} 
private String toString(Object modelElement)
    { 
StringBuilder theNewText = new StringBuilder("");
Object cis = Model.getFacade().getType(modelElement);
if(Model.getFacade().isAClassifierInState(cis))//1
{ 
theNewText.append("[ ");
theNewText.append(formatNameList(
                                  Model.getFacade().getInStates(cis)));
theNewText.append(" ]");
} 
return theNewText.toString();
} 

 } 
