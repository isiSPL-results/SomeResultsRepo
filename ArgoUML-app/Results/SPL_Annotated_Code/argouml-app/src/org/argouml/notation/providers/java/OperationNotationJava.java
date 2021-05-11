// Compilation Unit of /OperationNotationJava.java 
 
package org.argouml.notation.providers.java;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.OperationNotation;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class OperationNotationJava extends OperationNotation
  { 

//#if LOGGING 
private static final Logger LOG =
        Logger.getLogger(OperationNotationJava.class);
//#endif 

@SuppressWarnings("deprecation")

    @Deprecated
    public String toString(Object modelElement, Map args)
    { 
return toString(modelElement);
} 

private static String generateAbstractness(Object op)
    { 
if(Model.getFacade().isAbstract(op))//1
{ 
return "abstract ";
} 

return "";
} 

public OperationNotationJava(Object operation)
    { 
super(operation);
} 

private static String generateConcurrency(Object op)
    { 
if(Model.getFacade().getConcurrency(op) != null
                && Model.getConcurrencyKind().getGuarded().equals(
                    Model.getFacade().getConcurrency(op)))//1
{ 
return "synchronized ";
} 

return "";
} 

public void parse(Object modelElement, String text)
    { 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                    ArgoEventTypes.HELP_CHANGED, this,
                                    "Parsing in Java not yet supported"));
} 

private String toString(Object modelElement)
    { 
StringBuffer sb = new StringBuffer(80);
String nameStr = null;
boolean constructor = false;
Iterator its =
            Model.getFacade().getStereotypes(modelElement).iterator();
String name = "";
while (its.hasNext()) //1
{ 
Object o = its.next();
name = Model.getFacade().getName(o);
if("create".equals(name))//1
{ 
break;

} 

} 

if("create".equals(name))//1
{ 
nameStr = Model.getFacade().getName(
                          Model.getFacade().getOwner(modelElement));
constructor = true;
} 
else
{ 
nameStr = Model.getFacade().getName(modelElement);
} 

sb.append(generateConcurrency(modelElement));
sb.append(generateAbstractness(modelElement));
sb.append(NotationUtilityJava.generateChangeability(modelElement));
sb.append(NotationUtilityJava.generateScope(modelElement));
sb.append(NotationUtilityJava.generateVisibility(modelElement));
Collection returnParams =
            Model.getCoreHelper().getReturnParameters(modelElement);
Object rp;
if(returnParams.size() == 0)//1
{ 
rp = null;
} 
else
{ 
rp = returnParams.iterator().next();
} 

if(returnParams.size() > 1)//1
{ 

//#if LOGGING 
LOG.warn("Java generator only handles one return parameter"
                     + " - Found " + returnParams.size()
                     + " for " + Model.getFacade().getName(modelElement));
//#endif 

} 

if(rp != null && !constructor)//1
{ 
Object returnType = Model.getFacade().getType(rp);
if(returnType == null)//1
{ 
sb.append("void ");
} 
else
{ 
sb.append(NotationUtilityJava.generateClassifierRef(returnType))
                .append(' ');
} 

} 

List params = new ArrayList(
            Model.getFacade().getParameters(modelElement));
params.remove(rp);
sb.append(nameStr).append('(');
if(params != null)//1
{ 
for (int i = 0; i < params.size(); i++) //1
{ 
if(i > 0)//1
{ 
sb.append(", ");
} 

sb.append(NotationUtilityJava.generateParameter(
                              params.get(i)));
} 

} 

sb.append(')');
Collection c = Model.getFacade().getRaisedSignals(modelElement);
if(!c.isEmpty())//1
{ 
Iterator it = c.iterator();
boolean first = true;
while (it.hasNext()) //1
{ 
Object signal = it.next();
if(!Model.getFacade().isAException(signal))//1
{ 
continue;
} 

if(first)//1
{ 
sb.append(" throws ");
} 
else
{ 
sb.append(", ");
} 

sb.append(Model.getFacade().getName(signal));
first = false;
} 

} 

return sb.toString();
} 

public String getParsingHelp()
    { 
return "Parsing in Java not yet supported";
} 

@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 
return toString(modelElement);
} 

 } 


