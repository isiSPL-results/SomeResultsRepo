
//#if 2060243943 
// Compilation Unit of /OperationNotationJava.java 
 

//#if -340339995 
package org.argouml.notation.providers.java;
//#endif 


//#if 114474184 
import java.util.ArrayList;
//#endif 


//#if 593330585 
import java.util.Collection;
//#endif 


//#if 818168009 
import java.util.Iterator;
//#endif 


//#if -1839620967 
import java.util.List;
//#endif 


//#if -336415325 
import java.util.Map;
//#endif 


//#if 1337926952 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -1355646163 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 1189167185 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if -1857682504 
import org.argouml.model.Model;
//#endif 


//#if -890024757 
import org.argouml.notation.NotationSettings;
//#endif 


//#if 1217976905 
import org.argouml.notation.providers.OperationNotation;
//#endif 


//#if 589748293 
import org.apache.log4j.Logger;
//#endif 


//#if 742138619 
public class OperationNotationJava extends 
//#if -984390644 
OperationNotation
//#endif 

  { 

//#if 541895986 
private static final Logger LOG =
        Logger.getLogger(OperationNotationJava.class);
//#endif 


//#if 1519960894 

//#if 1076385793 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(Object modelElement, Map args)
    { 

//#if 223717416 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if -329058092 
private static String generateAbstractness(Object op)
    { 

//#if -2063212119 
if(Model.getFacade().isAbstract(op))//1
{ 

//#if -466618617 
return "abstract ";
//#endif 

} 

//#endif 


//#if 395219219 
return "";
//#endif 

} 

//#endif 


//#if 23048132 
public OperationNotationJava(Object operation)
    { 

//#if -568545273 
super(operation);
//#endif 

} 

//#endif 


//#if 1685224698 
private static String generateConcurrency(Object op)
    { 

//#if -761258641 
if(Model.getFacade().getConcurrency(op) != null
                && Model.getConcurrencyKind().getGuarded().equals(
                    Model.getFacade().getConcurrency(op)))//1
{ 

//#if -1463042600 
return "synchronized ";
//#endif 

} 

//#endif 


//#if 1016171644 
return "";
//#endif 

} 

//#endif 


//#if -571283424 
public void parse(Object modelElement, String text)
    { 

//#if 78305048 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                    ArgoEventTypes.HELP_CHANGED, this,
                                    "Parsing in Java not yet supported"));
//#endif 

} 

//#endif 


//#if -1311905966 
private String toString(Object modelElement)
    { 

//#if 1366162994 
StringBuffer sb = new StringBuffer(80);
//#endif 


//#if -1089389344 
String nameStr = null;
//#endif 


//#if 1216546999 
boolean constructor = false;
//#endif 


//#if -1692161496 
Iterator its =
            Model.getFacade().getStereotypes(modelElement).iterator();
//#endif 


//#if -650784378 
String name = "";
//#endif 


//#if -1299394867 
while (its.hasNext()) //1
{ 

//#if 224067777 
Object o = its.next();
//#endif 


//#if 1490328601 
name = Model.getFacade().getName(o);
//#endif 


//#if 168409647 
if("create".equals(name))//1
{ 

//#if -366700036 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if -825579224 
if("create".equals(name))//1
{ 

//#if 195039079 
nameStr = Model.getFacade().getName(
                          Model.getFacade().getOwner(modelElement));
//#endif 


//#if 715277762 
constructor = true;
//#endif 

} 
else
{ 

//#if 2133297868 
nameStr = Model.getFacade().getName(modelElement);
//#endif 

} 

//#endif 


//#if 1623532067 
sb.append(generateConcurrency(modelElement));
//#endif 


//#if 1196618729 
sb.append(generateAbstractness(modelElement));
//#endif 


//#if 967009096 
sb.append(NotationUtilityJava.generateChangeability(modelElement));
//#endif 


//#if -1593196510 
sb.append(NotationUtilityJava.generateScope(modelElement));
//#endif 


//#if -1715554044 
sb.append(NotationUtilityJava.generateVisibility(modelElement));
//#endif 


//#if 368493641 
Collection returnParams =
            Model.getCoreHelper().getReturnParameters(modelElement);
//#endif 


//#if -1717357614 
Object rp;
//#endif 


//#if -744755011 
if(returnParams.size() == 0)//1
{ 

//#if 178598177 
rp = null;
//#endif 

} 
else
{ 

//#if 1721678229 
rp = returnParams.iterator().next();
//#endif 

} 

//#endif 


//#if 824603766 
if(returnParams.size() > 1)//1
{ 

//#if 347125110 
LOG.warn("Java generator only handles one return parameter"
                     + " - Found " + returnParams.size()
                     + " for " + Model.getFacade().getName(modelElement));
//#endif 

} 

//#endif 


//#if 890029825 
if(rp != null && !constructor)//1
{ 

//#if 270240288 
Object returnType = Model.getFacade().getType(rp);
//#endif 


//#if -2015941274 
if(returnType == null)//1
{ 

//#if -172260458 
sb.append("void ");
//#endif 

} 
else
{ 

//#if 9664122 
sb.append(NotationUtilityJava.generateClassifierRef(returnType))
                .append(' ');
//#endif 

} 

//#endif 

} 

//#endif 


//#if 561203226 
List params = new ArrayList(
            Model.getFacade().getParameters(modelElement));
//#endif 


//#if -1841361320 
params.remove(rp);
//#endif 


//#if 2066874586 
sb.append(nameStr).append('(');
//#endif 


//#if 1158035280 
if(params != null)//1
{ 

//#if 612458436 
for (int i = 0; i < params.size(); i++) //1
{ 

//#if -178466205 
if(i > 0)//1
{ 

//#if -1879429367 
sb.append(", ");
//#endif 

} 

//#endif 


//#if 1096690481 
sb.append(NotationUtilityJava.generateParameter(
                              params.get(i)));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1711154180 
sb.append(')');
//#endif 


//#if 1294896426 
Collection c = Model.getFacade().getRaisedSignals(modelElement);
//#endif 


//#if 428865279 
if(!c.isEmpty())//1
{ 

//#if 176954825 
Iterator it = c.iterator();
//#endif 


//#if 747522596 
boolean first = true;
//#endif 


//#if -179957034 
while (it.hasNext()) //1
{ 

//#if -1986687577 
Object signal = it.next();
//#endif 


//#if -1170993596 
if(!Model.getFacade().isAException(signal))//1
{ 

//#if -501901254 
continue;
//#endif 

} 

//#endif 


//#if 1551883008 
if(first)//1
{ 

//#if -1516220177 
sb.append(" throws ");
//#endif 

} 
else
{ 

//#if 130221169 
sb.append(", ");
//#endif 

} 

//#endif 


//#if 1253755144 
sb.append(Model.getFacade().getName(signal));
//#endif 


//#if -1800094120 
first = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -246387925 
return sb.toString();
//#endif 

} 

//#endif 


//#if 1413374323 
public String getParsingHelp()
    { 

//#if -19526609 
return "Parsing in Java not yet supported";
//#endif 

} 

//#endif 


//#if 1462428058 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if 544921423 
return toString(modelElement);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

