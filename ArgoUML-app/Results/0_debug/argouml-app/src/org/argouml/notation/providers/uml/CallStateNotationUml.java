
//#if -1373986020 
// Compilation Unit of /CallStateNotationUml.java 
 

//#if -1406501890 
package org.argouml.notation.providers.uml;
//#endif 


//#if 628867587 
import java.text.ParseException;
//#endif 


//#if 1265467350 
import java.util.Collection;
//#endif 


//#if -200830458 
import java.util.Map;
//#endif 


//#if 675850822 
import java.util.Iterator;
//#endif 


//#if -1173315556 
import java.util.StringTokenizer;
//#endif 


//#if 1723300965 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 2001013648 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 1574541198 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if 58286869 
import org.argouml.i18n.Translator;
//#endif 


//#if 2049910586 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -1368850341 
import org.argouml.model.Model;
//#endif 


//#if 2011295790 
import org.argouml.notation.NotationSettings;
//#endif 


//#if -903113446 
import org.argouml.notation.providers.CallStateNotation;
//#endif 


//#if -2049115732 
public class CallStateNotationUml extends 
//#if 438685796 
CallStateNotation
//#endif 

  { 

//#if 601957674 

//#if -1788519292 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(Object modelElement, Map args)
    { 

//#if 2017804874 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if 208464430 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if 1702439937 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if 2108943167 
protected Object parseCallState(Object callState, String s1)
    throws ParseException
    { 

//#if -2117179493 
String s = s1.trim();
//#endif 


//#if -1878129023 
int a = s.indexOf("(");
//#endif 


//#if -524789535 
int b = s.indexOf(")");
//#endif 


//#if -1146193859 
if(((a < 0) && (b >= 0)) || ((b < 0) && (a >= 0)) || (b < a))//1
{ 

//#if 2072543643 
throw new ParseException("No matching brackets () found.", 0);
//#endif 

} 

//#endif 


//#if -1361483613 
String newClassName = null;
//#endif 


//#if 471853394 
String newOperationName = null;
//#endif 


//#if 1027987655 
StringTokenizer tokenizer = new StringTokenizer(s, "(");
//#endif 


//#if -321734228 
while (tokenizer.hasMoreTokens()) //1
{ 

//#if -820904911 
String nextToken = tokenizer.nextToken().trim();
//#endif 


//#if 879426606 
if(nextToken.endsWith(")"))//1
{ 

//#if 1419777383 
newClassName = nextToken.substring(0, nextToken.length() - 1);
//#endif 

} 
else
{ 

//#if 1844609756 
newOperationName = nextToken.trim();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -909020821 
String oldOperationName = null;
//#endif 


//#if -365107908 
String oldClassName = null;
//#endif 


//#if -67932643 
Object entry = Model.getFacade().getEntry(callState);
//#endif 


//#if 1946953287 
Object operation = null;
//#endif 


//#if 1679982328 
Object clazz = null;
//#endif 


//#if -1463582543 
if(Model.getFacade().isACallAction(entry))//1
{ 

//#if 1260484679 
operation = Model.getFacade().getOperation(entry);
//#endif 


//#if -1949325609 
if(Model.getFacade().isAOperation(operation))//1
{ 

//#if 707500305 
oldOperationName = Model.getFacade().getName(operation);
//#endif 


//#if 1708165608 
clazz = Model.getFacade().getOwner(operation);
//#endif 


//#if -1321646317 
oldClassName = Model.getFacade().getName(clazz);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -377876413 
boolean found = false;
//#endif 


//#if -39219675 
if((newClassName != null)
                && newClassName.equals(oldClassName)
                && (newOperationName != null)
                && !newOperationName.equals(oldOperationName))//1
{ 

//#if 1026245725 
for ( Object op : Model.getFacade().getOperations(clazz)) //1
{ 

//#if 268103628 
if(newOperationName.equals(
                            Model.getFacade().getName(op)))//1
{ 

//#if -1204228320 
Model.getCommonBehaviorHelper().setOperation(entry, op);
//#endif 


//#if -110562253 
found = true;
//#endif 


//#if -558861669 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2124891435 
if(!found)//1
{ 

//#if -995870594 
throw new ParseException(
                    "Operation " + newOperationName
                    + " not found in " + newClassName + ".", 0);
//#endif 

} 

//#endif 

} 
else

//#if 1123282843 
if((newClassName != null)
                   && !newClassName.equals(oldClassName)
                   && (newOperationName != null))//1
{ 

//#if -1185945142 
Object model =
                ProjectManager.getManager().getCurrentProject().getRoot();
//#endif 


//#if -700759179 
Collection c =
                Model.getModelManagementHelper().
                getAllModelElementsOfKind(model,
                                          Model.getMetaTypes().getClassifier());
//#endif 


//#if -1076382115 
Iterator i = c.iterator();
//#endif 


//#if -1406443911 
Object classifier = null;
//#endif 


//#if -290782792 
while (i.hasNext()) //1
{ 

//#if -1421454284 
Object cl = i.next();
//#endif 


//#if 1914446302 
String cn = Model.getFacade().getName(cl);
//#endif 


//#if 1991153252 
if(cn.equals(newClassName))//1
{ 

//#if 1624105386 
classifier = cl;
//#endif 


//#if 1428815760 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -262290119 
if(classifier == null)//1
{ 

//#if 512652570 
throw new ParseException(
                    "Classifier " + newClassName + " not found.", 0);
//#endif 

} 

//#endif 


//#if 945120725 
if(classifier != null)//1
{ 

//#if -1972493264 
Collection ops = Model.getFacade().getOperations(classifier);
//#endif 


//#if -818366253 
Iterator io = ops.iterator();
//#endif 


//#if 1679813329 
while (io.hasNext()) //1
{ 

//#if -802761522 
Object op = io.next();
//#endif 


//#if 280782972 
if(newOperationName.equals(
                                Model.getFacade().getName(op)))//1
{ 

//#if -1615163553 
found = true;
//#endif 


//#if 96823047 
if(!Model.getFacade().isACallAction(entry))//1
{ 

//#if 551628665 
entry = Model.getCommonBehaviorFactory()
                                    .buildCallAction(op, "ca");
//#endif 


//#if -1301096832 
Model.getStateMachinesHelper().setEntry(
                                callState, entry);
//#endif 

} 
else
{ 

//#if 789875545 
Model.getCommonBehaviorHelper().setOperation(
                                entry, op);
//#endif 

} 

//#endif 


//#if -654472209 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -990467864 
if(!found)//1
{ 

//#if 205513245 
throw new ParseException(
                        "Operation " + newOperationName
                        + " not found in " + newClassName + ".", 0);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#if 1526309852 
if(!found)//1
{ 

//#if 1941983503 
throw new ParseException(
                "Incompatible input found.", 0);
//#endif 

} 

//#endif 


//#if 828873744 
return callState;
//#endif 

} 

//#endif 


//#if 1368774324 
public void parse(Object modelElement, String text)
    { 

//#if 1988013872 
try //1
{ 

//#if 1154632388 
parseCallState(modelElement, text);
//#endif 

} 

//#if -1615426385 
catch (ParseException pe) //1
{ 

//#if 2001675431 
String msg = "statusmsg.bar.error.parsing.callstate";
//#endif 


//#if 1467615992 
Object[] args = {pe.getLocalizedMessage(),
                             Integer.valueOf(pe.getErrorOffset()),
                            };
//#endif 


//#if 1522986843 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 120108708 
public CallStateNotationUml(Object callState)
    { 

//#if -214720487 
super(callState);
//#endif 

} 

//#endif 


//#if 1387629831 
public String getParsingHelp()
    { 

//#if 2017769522 
return "parsing.help.fig-callstate";
//#endif 

} 

//#endif 


//#if 30223422 
private String toString(Object modelElement)
    { 

//#if 1829045736 
String ret = "";
//#endif 


//#if 1370012269 
Object action = Model.getFacade().getEntry(modelElement);
//#endif 


//#if 72778231 
if(Model.getFacade().isACallAction(action))//1
{ 

//#if -1959876720 
Object operation = Model.getFacade().getOperation(action);
//#endif 


//#if -632136545 
if(operation != null)//1
{ 

//#if 1177853108 
Object n = Model.getFacade().getName(operation);
//#endif 


//#if 67851708 
if(n != null)//1
{ 

//#if 552452156 
ret = (String) n;
//#endif 

} 

//#endif 


//#if -1554994697 
n =
                    Model.getFacade().getName(
                        Model.getFacade().getOwner(operation));
//#endif 


//#if -1087846219 
if(n != null && !n.equals(""))//1
{ 

//#if -954208934 
ret += "\n(" + (String) n + ")";
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 2121457419 
if(ret == null)//1
{ 

//#if 160919265 
return "";
//#endif 

} 

//#endif 


//#if 1106306736 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

