package org.argouml.notation.providers.uml;
import java.text.ParseException;
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
import org.argouml.notation.providers.CallStateNotation;
public class CallStateNotationUml extends CallStateNotation
  { 
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
protected Object parseCallState(Object callState, String s1)
    throws ParseException
    { 
String s = s1.trim();
int a = s.indexOf("(");
int b = s.indexOf(")");
if(((a < 0) && (b >= 0)) || ((b < 0) && (a >= 0)) || (b < a))//1
{ 
throw new ParseException("No matching brackets () found.", 0);
} 
String newClassName = null;
String newOperationName = null;
StringTokenizer tokenizer = new StringTokenizer(s, "(");
while (tokenizer.hasMoreTokens()) //1
{ 
String nextToken = tokenizer.nextToken().trim();
if(nextToken.endsWith(")"))//1
{ 
newClassName = nextToken.substring(0, nextToken.length() - 1);
} 
else
{ 
newOperationName = nextToken.trim();
} 
} 
String oldOperationName = null;
String oldClassName = null;
Object entry = Model.getFacade().getEntry(callState);
Object operation = null;
Object clazz = null;
if(Model.getFacade().isACallAction(entry))//1
{ 
operation = Model.getFacade().getOperation(entry);
if(Model.getFacade().isAOperation(operation))//1
{ 
oldOperationName = Model.getFacade().getName(operation);
clazz = Model.getFacade().getOwner(operation);
oldClassName = Model.getFacade().getName(clazz);
} 
} 
boolean found = false;
if((newClassName != null)
                && newClassName.equals(oldClassName)
                && (newOperationName != null)
                && !newOperationName.equals(oldOperationName))//1
{ 
for ( Object op : Model.getFacade().getOperations(clazz)) //1
{ 
if(newOperationName.equals(
                            Model.getFacade().getName(op)))//1
{ 
Model.getCommonBehaviorHelper().setOperation(entry, op);
found = true;
break;

} 
} 
if(!found)//1
{ 
throw new ParseException(
                    "Operation " + newOperationName
                    + " not found in " + newClassName + ".", 0);
} 
} 
else
if((newClassName != null)
                   && !newClassName.equals(oldClassName)
                   && (newOperationName != null))//1
{ 
Object model =
                ProjectManager.getManager().getCurrentProject().getRoot();
Collection c =
                Model.getModelManagementHelper().
                getAllModelElementsOfKind(model,
                                          Model.getMetaTypes().getClassifier());
Iterator i = c.iterator();
Object classifier = null;
while (i.hasNext()) //1
{ 
Object cl = i.next();
String cn = Model.getFacade().getName(cl);
if(cn.equals(newClassName))//1
{ 
classifier = cl;
break;

} 
} 
if(classifier == null)//1
{ 
throw new ParseException(
                    "Classifier " + newClassName + " not found.", 0);
} 
if(classifier != null)//1
{ 
Collection ops = Model.getFacade().getOperations(classifier);
Iterator io = ops.iterator();
while (io.hasNext()) //1
{ 
Object op = io.next();
if(newOperationName.equals(
                                Model.getFacade().getName(op)))//1
{ 
found = true;
if(!Model.getFacade().isACallAction(entry))//1
{ 
entry = Model.getCommonBehaviorFactory()
                                    .buildCallAction(op, "ca");
Model.getStateMachinesHelper().setEntry(
                                callState, entry);
} 
else
{ 
Model.getCommonBehaviorHelper().setOperation(
                                entry, op);
} 
break;

} 
} 
if(!found)//1
{ 
throw new ParseException(
                        "Operation " + newOperationName
                        + " not found in " + newClassName + ".", 0);
} 
} 
} 
if(!found)//1
{ 
throw new ParseException(
                "Incompatible input found.", 0);
} 
return callState;
} 
public void parse(Object modelElement, String text)
    { 
try//1
{ 
parseCallState(modelElement, text);
} 
catch (ParseException pe) //1
{ 
String msg = "statusmsg.bar.error.parsing.callstate";
Object[] args = {pe.getLocalizedMessage(),
                             Integer.valueOf(pe.getErrorOffset()),
                            };
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
} 
} 
public CallStateNotationUml(Object callState)
    { 
super(callState);
} 
public String getParsingHelp()
    { 
return "parsing.help.fig-callstate";
} 
private String toString(Object modelElement)
    { 
String ret = "";
Object action = Model.getFacade().getEntry(modelElement);
if(Model.getFacade().isACallAction(action))//1
{ 
Object operation = Model.getFacade().getOperation(action);
if(operation != null)//1
{ 
Object n = Model.getFacade().getName(operation);
if(n != null)//1
{ 
ret = (String) n;
} 
n =
                    Model.getFacade().getName(
                        Model.getFacade().getOwner(operation));
if(n != null && !n.equals(""))//1
{ 
ret += "\n(" + (String) n + ")";
} 
} 
} 
if(ret == null)//1
{ 
return "";
} 
return ret;
} 

 } 
