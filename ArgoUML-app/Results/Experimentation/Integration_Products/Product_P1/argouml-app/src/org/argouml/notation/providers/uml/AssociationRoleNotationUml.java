package org.argouml.notation.providers.uml;
import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.AssociationRoleNotation;
import org.argouml.util.MyTokenizer;
public class AssociationRoleNotationUml extends AssociationRoleNotation
  { 
@Override
    public String toString(final Object modelElement,
                           final NotationSettings settings)
    { 
return toString(modelElement);
} 
private String toString(final Object modelElement)
    { 
String name = Model.getFacade().getName(modelElement);
if(name == null)//1
{ 
name = "";
} 
if(name.length() > 0)//1
{ 
name = "/" + name;
} 
Object assoc = Model.getFacade().getBase(modelElement);
if(assoc != null)//1
{ 
String baseName = Model.getFacade().getName(assoc);
if(baseName != null && baseName.length() > 0)//1
{ 
name = name + ":" + baseName;
} 
} 
return name;
} 
public AssociationRoleNotationUml(Object role)
    { 
super(role);
} 
protected void parseRole(Object role, String text)
    throws ParseException
    { 
String token;
boolean hasColon = false;
boolean hasSlash = false;
String rolestr = null;
String basestr = null;
MyTokenizer st = new MyTokenizer(text, " ,\t,/,:");
while (st.hasMoreTokens()) //1
{ 
token = st.nextToken();
if(" ".equals(token) || "\t".equals(token))//1
{ 
} 
else
if("/".equals(token))//1
{ 
hasSlash = true;
hasColon = false;
} 
else
if(":".equals(token))//1
{ 
hasColon = true;
hasSlash = false;
} 
else
if(hasColon)//1
{ 
if(basestr != null)//1
{ 
String msg =
                        "parsing.error.association-role.association-extra-text";
throw new ParseException(Translator.localize(msg), st
                                             .getTokenIndex());
} 
basestr = token;
} 
else
if(hasSlash)//1
{ 
if(rolestr != null)//1
{ 
String msg =
                        "parsing.error.association-role.association-extra-text";
throw new ParseException(Translator.localize(msg), st
                                             .getTokenIndex());
} 
rolestr = token;
} 
else
{ 
String msg =
                    "parsing.error.association-role.association-extra-text";
throw new ParseException(Translator.localize(msg),
                                         st.getTokenIndex());
} 
} 
if(basestr == null)//1
{ 
if(rolestr != null)//1
{ 
Model.getCoreHelper().setName(role, rolestr.trim());
} 
return;
} 
Object currentBase = Model.getFacade().getBase(role);
if(currentBase != null)//1
{ 
String currentBaseStr = Model.getFacade().getName(currentBase);
if(currentBaseStr == null)//1
{ 
currentBaseStr = "";
} 
if(currentBaseStr.equals(basestr))//1
{ 
if(rolestr != null)//1
{ 
Model.getCoreHelper().setName(role, rolestr.trim());
} 
return;
} 
} 
String msg = "parsing.error.association-role.base-not-found";
throw new ParseException(Translator.localize(msg), 0);
} 
public void parse(Object modelElement, String text)
    { 
try//1
{ 
parseRole(modelElement, text);
} 
catch (ParseException pe) //1
{ 
String msg = "statusmsg.bar.error.parsing.association-role";
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
} 
} 
public String getParsingHelp()
    { 
return "parsing.help.fig-association-role";
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public String toString(Object modelElement, Map args)
    { 
return toString(modelElement);
} 

 } 
