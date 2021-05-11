// Compilation Unit of /AssociationNameNotationUml.java 
 
package org.argouml.notation.providers.uml;
import java.text.ParseException;
import java.util.Map;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.AssociationNameNotation;
public class AssociationNameNotationUml extends AssociationNameNotation
  { 
@SuppressWarnings("deprecation")

    @Deprecated
    public String toString(Object modelElement, Map args)
    { 
return toString(modelElement, (Boolean) args.get("showAssociationName"),
                        isValue("fullyHandleStereotypes", args),
                        isValue("pathVisible", args),
                        isValue("visibilityVisible", args),
                        isValue("useGuillemets", args));
} 

public String getParsingHelp()
    { 
return "parsing.help.fig-association-name";
} 

public String toString(Object modelElement, NotationSettings settings)
    { 
return toString(modelElement, settings.isShowAssociationNames(),
                        settings.isFullyHandleStereotypes(),
                        settings.isShowPaths(),
                        settings.isShowVisibilities(),
                        settings.isUseGuillemets());
} 

public void parse(Object modelElement, String text)
    { 
try //1
{ 
NotationUtilityUml.parseModelElement(modelElement, text);
} 
catch (ParseException pe) //1
{ 
String msg = "statusmsg.bar.error.parsing.association-name";
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
} 


} 

public AssociationNameNotationUml(Object association)
    { 
super(association);
} 

private String toString(Object modelElement, Boolean showAssociationName,
                            boolean fullyHandleStereotypes, boolean showPath,
                            boolean showVisibility, boolean useGuillemets)
    { 
if(showAssociationName == Boolean.FALSE)//1
{ 
return "";
} 

String name = Model.getFacade().getName(modelElement);
StringBuffer sb = new StringBuffer("");
if(fullyHandleStereotypes)//1
{ 
sb.append(NotationUtilityUml.generateStereotype(modelElement,
                      useGuillemets));
} 

if(showVisibility)//1
{ 
sb.append(NotationUtilityUml.generateVisibility2(modelElement));
sb.append(" ");
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

 } 


