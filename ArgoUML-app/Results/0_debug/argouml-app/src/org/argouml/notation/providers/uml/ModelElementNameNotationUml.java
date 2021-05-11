
//#if 965901829 
// Compilation Unit of /ModelElementNameNotationUml.java 
 

//#if 1312554809 
package org.argouml.notation.providers.uml;
//#endif 


//#if 14415272 
import java.text.ParseException;
//#endif 


//#if 1428370305 
import java.util.Map;
//#endif 


//#if -1536754859 
import java.util.Stack;
//#endif 


//#if 1771465610 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -800849653 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 1622705843 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if 59986256 
import org.argouml.i18n.Translator;
//#endif 


//#if 135349270 
import org.argouml.model.Model;
//#endif 


//#if -610299735 
import org.argouml.notation.NotationSettings;
//#endif 


//#if 1486732898 
import org.argouml.notation.providers.ModelElementNameNotation;
//#endif 


//#if -1188514078 
public class ModelElementNameNotationUml extends 
//#if -343057146 
ModelElementNameNotation
//#endif 

  { 

//#if 1135756796 
public String getParsingHelp()
    { 

//#if 910712468 
return "parsing.help.fig-nodemodelelement";
//#endif 

} 

//#endif 


//#if -1027919588 
@Deprecated
    protected String generateStereotypes(Object modelElement, Map args)
    { 

//#if 1023543404 
return NotationUtilityUml.generateStereotype(modelElement, args);
//#endif 

} 

//#endif 


//#if -1445364548 
public ModelElementNameNotationUml(Object name)
    { 

//#if -472482495 
super(name);
//#endif 

} 

//#endif 


//#if -573686173 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if -45924873 
return toString(modelElement, settings.isFullyHandleStereotypes(),
                        settings.isUseGuillemets(), settings.isShowVisibilities(),
                        settings.isShowPaths());
//#endif 

} 

//#endif 


//#if -225598130 
public String toString(Object modelElement, Map args)
    { 

//#if 1413982500 
return toString(modelElement, isValue("fullyHandleStereotypes", args),
                        isValue("useGuillemets", args),
                        isValue("visibilityVisible", args),
                        isValue("pathVisible", args));
//#endif 

} 

//#endif 


//#if -451070127 
private String toString(Object modelElement, boolean handleStereotypes,
                            boolean useGuillemets, boolean showVisibility, boolean showPath)
    { 

//#if -1947402309 
String name = Model.getFacade().getName(modelElement);
//#endif 


//#if -935647278 
StringBuffer sb = new StringBuffer("");
//#endif 


//#if 1772437450 
if(handleStereotypes)//1
{ 

//#if 1807222781 
sb.append(NotationUtilityUml.generateStereotype(modelElement, useGuillemets));
//#endif 

} 

//#endif 


//#if -1133026802 
if(showVisibility)//1
{ 

//#if -818814030 
sb.append(generateVisibility(modelElement));
//#endif 

} 

//#endif 


//#if -1734495 
if(showPath)//1
{ 

//#if 1165892081 
sb.append(NotationUtilityUml.generatePath(modelElement));
//#endif 

} 

//#endif 


//#if 692063789 
if(name != null)//1
{ 

//#if 1053298606 
sb.append(name);
//#endif 

} 

//#endif 


//#if 182659027 
return sb.toString();
//#endif 

} 

//#endif 


//#if -909383762 
@Deprecated
    protected String generatePath(Object modelElement, Map args)
    { 

//#if -380409929 
StringBuilder s = new StringBuilder();
//#endif 


//#if 604283150 
if(isValue("pathVisible", args))//1
{ 

//#if 1051637990 
Object p = modelElement;
//#endif 


//#if 2072631243 
Stack stack = new Stack();
//#endif 


//#if 416602756 
Object ns = Model.getFacade().getNamespace(p);
//#endif 


//#if -682270748 
while (ns != null && !Model.getFacade().isAModel(ns)) //1
{ 

//#if -1359381142 
stack.push(Model.getFacade().getName(ns));
//#endif 


//#if 1784325445 
ns = Model.getFacade().getNamespace(ns);
//#endif 

} 

//#endif 


//#if 1077038962 
while (!stack.isEmpty()) //1
{ 

//#if 2090768194 
s.append((String) stack.pop() + "::");
//#endif 

} 

//#endif 


//#if 1067320780 
if(s.length() > 0 && !(s.lastIndexOf(":") == s.length() - 1))//1
{ 

//#if -24953233 
s.append("::");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1150002392 
return s.toString();
//#endif 

} 

//#endif 


//#if -974906263 
public void parse(Object modelElement, String text)
    { 

//#if 1610323961 
try //1
{ 

//#if 1681234936 
NotationUtilityUml.parseModelElement(modelElement, text);
//#endif 

} 

//#if 2100782282 
catch (ParseException pe) //1
{ 

//#if 2089152475 
String msg = "statusmsg.bar.error.parsing.node-modelelement";
//#endif 


//#if -1068304191 
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
//#endif 


//#if -747594062 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1890635739 
@Deprecated
    protected String generateVisibility(Object modelElement, Map args)
    { 

//#if -1861147824 
if(isValue("visibilityVisible", args))//1
{ 

//#if -428437894 
return generateVisibility(modelElement);
//#endif 

} 
else
{ 

//#if 795738889 
return "";
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1217056668 
private String generateVisibility(Object modelElement)
    { 

//#if 2109979384 
String s = NotationUtilityUml.generateVisibility2(modelElement);
//#endif 


//#if 439021652 
if(s.length() > 0)//1
{ 

//#if 527806152 
s = s + " ";
//#endif 

} 

//#endif 


//#if 305496587 
return s;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

