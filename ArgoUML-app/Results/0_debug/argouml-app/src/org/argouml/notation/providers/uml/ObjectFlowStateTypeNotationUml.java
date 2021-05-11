
//#if -1422888092 
// Compilation Unit of /ObjectFlowStateTypeNotationUml.java 
 

//#if -1879443043 
package org.argouml.notation.providers.uml;
//#endif 


//#if 1771213252 
import java.text.ParseException;
//#endif 


//#if -319483675 
import java.util.Map;
//#endif 


//#if -241049178 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 1235701359 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if -389808945 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if -1642860620 
import org.argouml.i18n.Translator;
//#endif 


//#if 1716040826 
import org.argouml.model.Model;
//#endif 


//#if -1513586163 
import org.argouml.notation.NotationSettings;
//#endif 


//#if 1447481328 
import org.argouml.notation.providers.ObjectFlowStateTypeNotation;
//#endif 


//#if 1726851842 
public class ObjectFlowStateTypeNotationUml extends 
//#if 1906580628 
ObjectFlowStateTypeNotation
//#endif 

  { 

//#if -1596501054 
public String getParsingHelp()
    { 

//#if 853482703 
return "parsing.help.fig-objectflowstate1";
//#endif 

} 

//#endif 


//#if -1016971136 
protected Object parseObjectFlowState1(Object objectFlowState, String s)
    throws ParseException
    { 

//#if 576654580 
Object c =
            Model.getActivityGraphsHelper()
            .findClassifierByName(objectFlowState, s);
//#endif 


//#if 1573203027 
if(c != null)//1
{ 

//#if 649587206 
Model.getCoreHelper().setType(objectFlowState, c);
//#endif 


//#if -1477738189 
return objectFlowState;
//#endif 

} 

//#endif 


//#if -583968617 
if(s != null && s.length() > 0)//1
{ 

//#if 1063123367 
Object topState = Model.getFacade().getContainer(objectFlowState);
//#endif 


//#if -919629956 
if(topState != null)//1
{ 

//#if -1590229749 
Object machine = Model.getFacade().getStateMachine(topState);
//#endif 


//#if 2014402737 
if(machine != null)//1
{ 

//#if 2006250950 
Object ns = Model.getFacade().getNamespace(machine);
//#endif 


//#if 1144395312 
if(ns != null)//1
{ 

//#if 1435783319 
Object clazz = Model.getCoreFactory().buildClass(s, ns);
//#endif 


//#if -1019484017 
Model.getCoreHelper().setType(objectFlowState, clazz);
//#endif 


//#if -266863265 
return objectFlowState;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -690538673 
String msg = "parsing.error.object-flow-type.classifier-not-found";
//#endif 


//#if -517525403 
Object[] args = {s};
//#endif 


//#if 2041483466 
throw new ParseException(Translator.localize(msg, args), 0);
//#endif 

} 

//#endif 


//#if 507856655 

//#if -321823794 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(Object modelElement, Map args)
    { 

//#if -1896567005 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if 312353193 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if -261432013 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if 1608323843 
public ObjectFlowStateTypeNotationUml(Object objectflowstate)
    { 

//#if 809387929 
super(objectflowstate);
//#endif 

} 

//#endif 


//#if -130060957 
private String toString(Object modelElement)
    { 

//#if 1764052709 
Object classifier = Model.getFacade().getType(modelElement);
//#endif 


//#if -898482478 
if(Model.getFacade().isAClassifierInState(classifier))//1
{ 

//#if -764987949 
classifier = Model.getFacade().getType(classifier);
//#endif 

} 

//#endif 


//#if -574007196 
if(classifier == null)//1
{ 

//#if -443158434 
return "";
//#endif 

} 

//#endif 


//#if -663191034 
String name = Model.getFacade().getName(classifier);
//#endif 


//#if -39875762 
if(name == null)//1
{ 

//#if -1848604742 
name = "";
//#endif 

} 

//#endif 


//#if -1257127287 
return name;
//#endif 

} 

//#endif 


//#if -1131969361 
public void parse(Object modelElement, String text)
    { 

//#if -1489623414 
try //1
{ 

//#if -1815217366 
parseObjectFlowState1(modelElement, text);
//#endif 

} 

//#if -27696553 
catch (ParseException pe) //1
{ 

//#if 1253566197 
String msg = "statusmsg.bar.error.parsing.objectflowstate";
//#endif 


//#if -569613515 
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
//#endif 


//#if -361672002 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

