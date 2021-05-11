// Compilation Unit of /ModelElementNameNotationUml.java 
 
package org.argouml.notation.providers.uml;
import java.text.ParseException;
import java.util.Map;
import java.util.Stack;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.ModelElementNameNotation;
public class ModelElementNameNotationUml extends ModelElementNameNotation
  { 
public String getParsingHelp()
    { 
return "parsing.help.fig-nodemodelelement";
} 

@Deprecated
    protected String generateStereotypes(Object modelElement, Map args)
    { 
return NotationUtilityUml.generateStereotype(modelElement, args);
} 

public ModelElementNameNotationUml(Object name)
    { 
super(name);
} 

@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 
return toString(modelElement, settings.isFullyHandleStereotypes(),
                        settings.isUseGuillemets(), settings.isShowVisibilities(),
                        settings.isShowPaths());
} 

public String toString(Object modelElement, Map args)
    { 
return toString(modelElement, isValue("fullyHandleStereotypes", args),
                        isValue("useGuillemets", args),
                        isValue("visibilityVisible", args),
                        isValue("pathVisible", args));
} 

private String toString(Object modelElement, boolean handleStereotypes,
                            boolean useGuillemets, boolean showVisibility, boolean showPath)
    { 
String name = Model.getFacade().getName(modelElement);
StringBuffer sb = new StringBuffer("");
if(handleStereotypes)//1
{ 
sb.append(NotationUtilityUml.generateStereotype(modelElement, useGuillemets));
} 

if(showVisibility)//1
{ 
sb.append(generateVisibility(modelElement));
} 

if(showPath)//1
{ 
sb.append(NotationUtilityUml.generatePath(modelElement));
} 

if(name != null)//1
{ 
sb.append(name);
} 

return sb.toString();
} 

@Deprecated
    protected String generatePath(Object modelElement, Map args)
    { 
StringBuilder s = new StringBuilder();
if(isValue("pathVisible", args))//1
{ 
Object p = modelElement;
Stack stack = new Stack();
Object ns = Model.getFacade().getNamespace(p);
while (ns != null && !Model.getFacade().isAModel(ns)) //1
{ 
stack.push(Model.getFacade().getName(ns));
ns = Model.getFacade().getNamespace(ns);
} 

while (!stack.isEmpty()) //1
{ 
s.append((String) stack.pop() + "::");
} 

if(s.length() > 0 && !(s.lastIndexOf(":") == s.length() - 1))//1
{ 
s.append("::");
} 

} 

return s.toString();
} 

public void parse(Object modelElement, String text)
    { 
try //1
{ 
NotationUtilityUml.parseModelElement(modelElement, text);
} 
catch (ParseException pe) //1
{ 
String msg = "statusmsg.bar.error.parsing.node-modelelement";
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
} 


} 

@Deprecated
    protected String generateVisibility(Object modelElement, Map args)
    { 
if(isValue("visibilityVisible", args))//1
{ 
return generateVisibility(modelElement);
} 
else
{ 
return "";
} 

} 

private String generateVisibility(Object modelElement)
    { 
String s = NotationUtilityUml.generateVisibility2(modelElement);
if(s.length() > 0)//1
{ 
s = s + " ";
} 

return s;
} 

 } 


