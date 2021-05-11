package org.argouml.notation.providers.uml;
import java.text.ParseException;
import java.util.Map;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.ObjectFlowStateTypeNotation;
public class ObjectFlowStateTypeNotationUml extends ObjectFlowStateTypeNotation
  { 
public String getParsingHelp()
    { 
return "parsing.help.fig-objectflowstate1";
} 
protected Object parseObjectFlowState1(Object objectFlowState, String s)
    throws ParseException
    { 
if(s != null && s.length() > 0)//1
{ 
Object topState = Model.getFacade().getContainer(objectFlowState);
if(topState != null)//1
{ 
Object machine = Model.getFacade().getStateMachine(topState);
if(machine != null)//1
{ 
Object ns = Model.getFacade().getNamespace(machine);
if(ns != null)//1
{ 
Object clazz = Model.getCoreFactory().buildClass(s, ns);
Model.getCoreHelper().setType(objectFlowState, clazz);
return objectFlowState;
} 
} 
} 
} 
String msg = "parsing.error.object-flow-type.classifier-not-found";
Object[] args = {s};
throw new ParseException(Translator.localize(msg, args), 0);
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
public ObjectFlowStateTypeNotationUml(Object objectflowstate)
    { 
super(objectflowstate);
} 
private String toString(Object modelElement)
    { 
Object classifier = Model.getFacade().getType(modelElement);
if(Model.getFacade().isAClassifierInState(classifier))//1
{ 
classifier = Model.getFacade().getType(classifier);
} 
if(classifier == null)//1
{ 
return "";
} 
String name = Model.getFacade().getName(classifier);
if(name == null)//1
{ 
name = "";
} 
return name;
} 
public void parse(Object modelElement, String text)
    { 
try//1
{ 
parseObjectFlowState1(modelElement, text);
} 
catch (ParseException pe) //1
{ 
String msg = "statusmsg.bar.error.parsing.objectflowstate";
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
} 
} 

 } 
