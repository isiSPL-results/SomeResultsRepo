
//#if -1515080073 
// Compilation Unit of /ObjectFlowStateStateNotationUml.java 
 

//#if -1513136299 
package org.argouml.notation.providers.uml;
//#endif 


//#if -735867124 
import java.text.ParseException;
//#endif 


//#if -322440126 
import java.util.ArrayList;
//#endif 


//#if -66111137 
import java.util.Collection;
//#endif 


//#if -501378915 
import java.util.Map;
//#endif 


//#if 804073999 
import java.util.Iterator;
//#endif 


//#if -530418637 
import java.util.StringTokenizer;
//#endif 


//#if 701983470 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 404942375 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 553223703 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if -593064596 
import org.argouml.i18n.Translator;
//#endif 


//#if -1114442671 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -2105610702 
import org.argouml.model.Model;
//#endif 


//#if -1680123451 
import org.argouml.notation.NotationSettings;
//#endif 


//#if 28666159 
import org.argouml.notation.providers.ObjectFlowStateStateNotation;
//#endif 


//#if -392506897 
public class ObjectFlowStateStateNotationUml extends 
//#if 1451787817 
ObjectFlowStateStateNotation
//#endif 

  { 

//#if -1383123344 
public String getParsingHelp()
    { 

//#if 2127983195 
return "parsing.help.fig-objectflowstate2";
//#endif 

} 

//#endif 


//#if 1675398817 

//#if -654118908 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(Object modelElement, Map args)
    { 

//#if 1723961438 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if 635470807 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if 998406398 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if -577153059 
public void parse(Object modelElement, String text)
    { 

//#if -344709041 
try //1
{ 

//#if -1395336659 
parseObjectFlowState2(modelElement, text);
//#endif 

} 

//#if -872882727 
catch (ParseException pe) //1
{ 

//#if 1751850688 
String msg = "statusmsg.bar.error.parsing.objectflowstate";
//#endif 


//#if -524230464 
Object[] args = {pe.getLocalizedMessage(),
                             Integer.valueOf(pe.getErrorOffset()),
                            };
//#endif 


//#if -1052773741 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1342871633 
private void delete(Object obj)
    { 

//#if -1085174842 
if(obj != null)//1
{ 

//#if 815935893 
ProjectManager.getManager().getCurrentProject().moveToTrash(obj);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 910291825 
protected Object parseObjectFlowState2(Object objectFlowState, String s)
    throws ParseException
    { 

//#if -1097069748 
s = s.trim();
//#endif 


//#if 2024265082 
if(s.startsWith("["))//1
{ 

//#if -1825479124 
s = s.substring(1);
//#endif 

} 

//#endif 


//#if 2023873781 
if(s.endsWith("]"))//1
{ 

//#if 1740788512 
s = s.substring(0, s.length() - 1);
//#endif 

} 

//#endif 


//#if 1896306566 
s = s.trim();
//#endif 


//#if 2103955516 
Object c = Model.getFacade().getType(objectFlowState);
//#endif 


//#if -1544182390 
if(c != null)//1
{ 

//#if -1786029588 
if(Model.getFacade().isAClassifierInState(c))//1
{ 

//#if 1272130102 
Object classifier = Model.getFacade().getType(c);
//#endif 


//#if -1580048291 
if((s == null) || "".equals(s))//1
{ 

//#if -487855652 
Model.getCoreHelper().setType(objectFlowState, classifier);
//#endif 


//#if 1616825726 
delete(c);
//#endif 


//#if 461647606 
Model.getCoreHelper().setType(objectFlowState, classifier);
//#endif 


//#if -2072682739 
return objectFlowState;
//#endif 

} 

//#endif 


//#if 1165860593 
Collection states =
                    new ArrayList(Model.getFacade()
                                  .getInStates(c));
//#endif 


//#if -1114013102 
Collection statesToBeRemoved = new ArrayList(states);
//#endif 


//#if -1163891818 
Collection namesToBeAdded = new ArrayList();
//#endif 


//#if -805635997 
StringTokenizer tokenizer = new StringTokenizer(s, ",");
//#endif 


//#if 925255628 
while (tokenizer.hasMoreTokens()) //1
{ 

//#if -636996242 
String nextToken = tokenizer.nextToken().trim();
//#endif 


//#if 447643383 
boolean found = false;
//#endif 


//#if -1786014554 
Iterator i = states.iterator();
//#endif 


//#if 1593496534 
while (i.hasNext()) //1
{ 

//#if 1215206220 
Object state = i.next();
//#endif 


//#if 794068237 
if(Model.getFacade().getName(state) == nextToken)//1
{ 

//#if 1439244673 
found = true;
//#endif 


//#if -1802473538 
statesToBeRemoved.remove(state);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -318494320 
if(!found)//1
{ 

//#if -984780027 
namesToBeAdded.add(nextToken);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1697303277 
states.removeAll(statesToBeRemoved);
//#endif 


//#if -614569006 
Iterator i = namesToBeAdded.iterator();
//#endif 


//#if -1512044478 
while (i.hasNext()) //1
{ 

//#if 590461965 
String name = (String) i.next();
//#endif 


//#if -2014980262 
String msg =
                        "parsing.error.object-flow-state.state-not-found";
//#endif 


//#if 1753746425 
Object[] args = {s};
//#endif 


//#if 1621923510 
throw new ParseException(Translator.localize(msg, args),
                                             0);
//#endif 


//#if 669232089 
Object state =
                        Model.getActivityGraphsHelper()
                        .findStateByName(classifier, name);
//#endif 


//#if 595667821 
if(state != null)//1
{ 

//#if -753193978 
states.add(state);
//#endif 

} 
else
{ 

//#if 1383050301 
String msg =
                            "parsing.error.object-flow-state.state-not-found";
//#endif 


//#if -1577739530 
Object[] args = {s};
//#endif 


//#if 1255298329 
throw new ParseException(Translator.localize(msg, args),
                                                 0);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1347392526 
Model.getActivityGraphsHelper().setInStates(c, states);
//#endif 

} 
else
{ 

//#if -1320986443 
Collection statesToBeAdded = new ArrayList();
//#endif 


//#if 291264616 
StringTokenizer tokenizer = new StringTokenizer(s, ",");
//#endif 


//#if -1970646575 
while (tokenizer.hasMoreTokens()) //1
{ 

//#if 1166460405 
String nextToken = tokenizer.nextToken().trim();
//#endif 


//#if 520669563 
String msg =
                        "parsing.error.object-flow-state.state-not-found";
//#endif 


//#if -621748104 
Object[] args = {s};
//#endif 


//#if -1936211625 
throw new ParseException(Translator.localize(msg, args),
                                             0);
//#endif 


//#if -1675826273 
Object state =
                        Model.getActivityGraphsHelper()
                        .findStateByName(c, nextToken);
//#endif 


//#if -30218546 
if(state != null)//1
{ 

//#if -1467100924 
statesToBeAdded.add(state);
//#endif 

} 
else
{ 

//#if 287272459 
String msg =
                            "parsing.error.object-flow-state.state-not-found";
//#endif 


//#if -1832569368 
Object[] args = {s};
//#endif 


//#if 2086088167 
throw new ParseException(Translator.localize(msg, args),
                                                 0);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1768891164 
Object cis =
                    Model.getActivityGraphsFactory()
                    .buildClassifierInState(c, statesToBeAdded);
//#endif 


//#if -703437559 
Model.getCoreHelper().setType(objectFlowState, cis);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1613532560 
String msg =
                "parsing.error.object-flow-state.classifier-not-found";
//#endif 


//#if 342116207 
throw new ParseException(Translator.localize(msg),
                                     0);
//#endif 

} 

//#endif 


//#if -1824064498 
return objectFlowState;
//#endif 

} 

//#endif 


//#if -47948726 
public ObjectFlowStateStateNotationUml(Object objectflowstate)
    { 

//#if 203558804 
super(objectflowstate);
//#endif 

} 

//#endif 


//#if -576334475 
private String toString(Object modelElement)
    { 

//#if -654975344 
StringBuilder theNewText = new StringBuilder("");
//#endif 


//#if -110634281 
Object cis = Model.getFacade().getType(modelElement);
//#endif 


//#if 256333780 
if(Model.getFacade().isAClassifierInState(cis))//1
{ 

//#if -2132896889 
theNewText.append("[ ");
//#endif 


//#if 1614773278 
theNewText.append(formatNameList(
                                  Model.getFacade().getInStates(cis)));
//#endif 


//#if -2132837307 
theNewText.append(" ]");
//#endif 

} 

//#endif 


//#if -2103374059 
return theNewText.toString();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

