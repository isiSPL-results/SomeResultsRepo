// Compilation Unit of /AssociationEndNameNotationUml.java 
 
package org.argouml.notation.providers.uml;
import java.text.ParseException;
import java.util.Map;
import java.util.NoSuchElementException;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.AssociationEndNameNotation;
import org.argouml.uml.StereotypeUtility;
import org.argouml.util.MyTokenizer;
public class AssociationEndNameNotationUml extends AssociationEndNameNotation
  { 
@SuppressWarnings("deprecation")

    @Deprecated
    @Override
    public String toString(Object modelElement, Map args)
    { 
return toString(modelElement,
                        NotationUtilityUml.isValue("visibilityVisible", args),
                        NotationUtilityUml.isValue("useGuillemets", args));
} 

@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 
return toString(modelElement, settings.isShowVisibilities(),
                        settings.isUseGuillemets());
} 

public void parse(Object modelElement, String text)
    { 
try //1
{ 
parseAssociationEnd(modelElement, text);
} 
catch (ParseException pe) //1
{ 
String msg = "statusmsg.bar.error.parsing.association-end-name";
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
} 


} 

protected AssociationEndNameNotationUml()
    { 
super();
} 

private String toString(Object modelElement, boolean showVisibility,
                            boolean useGuillemets)
    { 
String name = Model.getFacade().getName(modelElement);
if(name == null)//1
{ 
name = "";
} 

String visibility = "";
if(showVisibility)//1
{ 
visibility = NotationUtilityUml.generateVisibility2(modelElement);
if(name.length() < 1)//1
{ 
visibility = "";
} 

} 

String stereoString =
            NotationUtilityUml.generateStereotype(modelElement, useGuillemets);
if(stereoString.length() > 0)//1
{ 
stereoString += " ";
} 

return stereoString + visibility + name;
} 

public String getParsingHelp()
    { 
return "parsing.help.fig-association-end-name";
} 

public static final AssociationEndNameNotationUml getInstance()
    { 
return new AssociationEndNameNotationUml();
} 

protected void parseAssociationEnd(Object role, String text)
    throws ParseException
    { 
MyTokenizer st;
String name = null;
StringBuilder stereotype = null;
String token;
try //1
{ 
st = new MyTokenizer(text, "<<,\u00AB,\u00BB,>>");
while (st.hasMoreTokens()) //1
{ 
token = st.nextToken();
if("<<".equals(token) || "\u00AB".equals(token))//1
{ 
if(stereotype != null)//1
{ 
String msg =
                            "parsing.error.association-name.twin-stereotypes";
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
} 

stereotype = new StringBuilder();
while (true) //1
{ 
token = st.nextToken();
if(">>".equals(token) || "\u00BB".equals(token))//1
{ 
break;

} 

stereotype.append(token);
} 

} 
else
{ 
if(name != null)//1
{ 
String msg =
                            "parsing.error.association-name.twin-names";
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
} 

name = token;
} 

} 

} 
catch (NoSuchElementException nsee) //1
{ 
String ms = "parsing.error.association-name.unexpected-end-element";
throw new ParseException(Translator.localize(ms),
                                     text.length());
} 

catch (ParseException pre) //1
{ 
throw pre;
} 


if(name != null)//1
{ 
name = name.trim();
} 

if(name != null && name.startsWith("+"))//1
{ 
name = name.substring(1).trim();
Model.getCoreHelper().setVisibility(role,
                                                Model.getVisibilityKind().getPublic());
} 

if(name != null && name.startsWith("-"))//1
{ 
name = name.substring(1).trim();
Model.getCoreHelper().setVisibility(role,
                                                Model.getVisibilityKind().getPrivate());
} 

if(name != null && name.startsWith("#"))//1
{ 
name = name.substring(1).trim();
Model.getCoreHelper().setVisibility(role,
                                                Model.getVisibilityKind().getProtected());
} 

if(name != null && name.startsWith("~"))//1
{ 
name = name.substring(1).trim();
Model.getCoreHelper().setVisibility(role,
                                                Model.getVisibilityKind().getPackage());
} 

if(name != null)//2
{ 
Model.getCoreHelper().setName(role, name);
} 

StereotypeUtility.dealWithStereotypes(role, stereotype, true);
} 

 } 


