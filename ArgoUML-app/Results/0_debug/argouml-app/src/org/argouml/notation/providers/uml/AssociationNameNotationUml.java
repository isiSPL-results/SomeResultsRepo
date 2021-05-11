
//#if 833017240 
// Compilation Unit of /AssociationNameNotationUml.java 
 

//#if -745545428 
package org.argouml.notation.providers.uml;
//#endif 


//#if 2076298645 
import java.text.ParseException;
//#endif 


//#if 550833588 
import java.util.Map;
//#endif 


//#if -1614411017 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 1611157310 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if -1763170784 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if -994716093 
import org.argouml.i18n.Translator;
//#endif 


//#if 340408969 
import org.argouml.model.Model;
//#endif 


//#if 1535295964 
import org.argouml.notation.NotationSettings;
//#endif 


//#if -2031508365 
import org.argouml.notation.providers.AssociationNameNotation;
//#endif 


//#if 30335621 
public class AssociationNameNotationUml extends 
//#if 131613297 
AssociationNameNotation
//#endif 

  { 

//#if 1509861278 

//#if 268561442 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(Object modelElement, Map args)
    { 

//#if -2110993613 
return toString(modelElement, (Boolean) args.get("showAssociationName"),
                        isValue("fullyHandleStereotypes", args),
                        isValue("pathVisible", args),
                        isValue("visibilityVisible", args),
                        isValue("useGuillemets", args));
//#endif 

} 

//#endif 


//#if 1897629971 
public String getParsingHelp()
    { 

//#if 1902700273 
return "parsing.help.fig-association-name";
//#endif 

} 

//#endif 


//#if -880584564 
public String toString(Object modelElement, NotationSettings settings)
    { 

//#if 1380550820 
return toString(modelElement, settings.isShowAssociationNames(),
                        settings.isFullyHandleStereotypes(),
                        settings.isShowPaths(),
                        settings.isShowVisibilities(),
                        settings.isUseGuillemets());
//#endif 

} 

//#endif 


//#if -588159040 
public void parse(Object modelElement, String text)
    { 

//#if -1984478053 
try //1
{ 

//#if -547647709 
NotationUtilityUml.parseModelElement(modelElement, text);
//#endif 

} 

//#if -878922896 
catch (ParseException pe) //1
{ 

//#if -1787428624 
String msg = "statusmsg.bar.error.parsing.association-name";
//#endif 


//#if 1088153437 
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
//#endif 


//#if 1268315030 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -731152573 
public AssociationNameNotationUml(Object association)
    { 

//#if 206453051 
super(association);
//#endif 

} 

//#endif 


//#if 1804263981 
private String toString(Object modelElement, Boolean showAssociationName,
                            boolean fullyHandleStereotypes, boolean showPath,
                            boolean showVisibility, boolean useGuillemets)
    { 

//#if -847405347 
if(showAssociationName == Boolean.FALSE)//1
{ 

//#if -42278661 
return "";
//#endif 

} 

//#endif 


//#if 955231563 
String name = Model.getFacade().getName(modelElement);
//#endif 


//#if 1290466658 
StringBuffer sb = new StringBuffer("");
//#endif 


//#if 2136615998 
if(fullyHandleStereotypes)//1
{ 

//#if 686062566 
sb.append(NotationUtilityUml.generateStereotype(modelElement,
                      useGuillemets));
//#endif 

} 

//#endif 


//#if 596585374 
if(showVisibility)//1
{ 

//#if 1284743761 
sb.append(NotationUtilityUml.generateVisibility2(modelElement));
//#endif 


//#if 1608220284 
sb.append(" ");
//#endif 

} 

//#endif 


//#if 1622654513 
if(showPath)//1
{ 

//#if 568005313 
sb.append(NotationUtilityUml.generatePath(modelElement));
//#endif 

} 

//#endif 


//#if -1638195267 
if(name != null)//1
{ 

//#if -2094592938 
sb.append(name);
//#endif 

} 

//#endif 


//#if -1008473021 
return sb.toString();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

