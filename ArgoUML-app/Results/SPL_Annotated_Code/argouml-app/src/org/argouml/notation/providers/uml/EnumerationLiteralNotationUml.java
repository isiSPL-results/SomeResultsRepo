// Compilation Unit of /EnumerationLiteralNotationUml.java 
 
package org.argouml.notation.providers.uml;
import java.text.ParseException;
import java.util.Map;
import java.util.NoSuchElementException;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.i18n.Translator;
import org.argouml.kernel.Project;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.EnumerationLiteralNotation;
import org.argouml.uml.StereotypeUtility;
import org.argouml.util.MyTokenizer;
public class EnumerationLiteralNotationUml extends EnumerationLiteralNotation
  { 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 
return toString(modelElement, settings.isUseGuillemets());
} 

@Override
    public void parse(Object modelElement, String text)
    { 
try //1
{ 
parseEnumerationLiteralFig(
                Model.getFacade().getEnumeration(modelElement),
                modelElement, text);
} 
catch (ParseException pe) //1
{ 
String msg = "statusmsg.bar.error.parsing.enumeration-literal";
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
} 


} 

protected void parseEnumerationLiteral(String text, Object literal)
    throws ParseException
    { 
text = text.trim();
if(text.length() == 0)//1
{ 
return;
} 

if(text.charAt(text.length() - 1) == ';')//1
{ 
text = text.substring(0, text.length() - 2);
} 

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
                            "parsing.error.model-element-name.twin-stereotypes";
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
                            "parsing.error.model-element-name.twin-names";
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
} 

name = token;
} 

} 

} 
catch (NoSuchElementException nsee) //1
{ 
String msg =
                "parsing.error.model-element-name.unexpected-name-element";
throw new ParseException(Translator.localize(msg),
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

if(name != null)//2
{ 
Model.getCoreHelper().setName(literal, name);
} 

StereotypeUtility.dealWithStereotypes(literal, stereotype, false);
return;
} 

private String toString(Object modelElement, boolean useGuillemets)
    { 
String nameStr = "";
if(Model.getFacade().getName(modelElement) != null)//1
{ 
nameStr = NotationUtilityUml.generateStereotype(modelElement,
                      useGuillemets);
if(nameStr.length() > 0)//1
{ 
nameStr += " ";
} 

nameStr += Model.getFacade().getName(modelElement).trim();
} 

return nameStr;
} 

@SuppressWarnings("deprecation")

    @Deprecated
    @Override
    public String toString(Object modelElement, Map args)
    { 
return toString(modelElement,
                        NotationUtilityUml.isValue("useGuillemets", args));
} 

public EnumerationLiteralNotationUml(Object enumLiteral)
    { 
super(enumLiteral);
} 

@Override
    public String getParsingHelp()
    { 
return "parsing.help.fig-enumeration-literal";
} 

protected void  parseEnumerationLiteralFig(
        Object enumeration, Object literal, String text)
    throws ParseException
    { 
if(enumeration == null || literal == null)//1
{ 
return;
} 

Project project = ProjectManager.getManager().getCurrentProject();
ParseException pex = null;
int start = 0;
int end = NotationUtilityUml.indexOfNextCheckedSemicolon(text, start);
if(end == -1)//1
{ 
project.moveToTrash(literal);
return;
} 

String s = text.substring(start, end).trim();
if(s.length() == 0)//1
{ 
project.moveToTrash(literal);
return;
} 

parseEnumerationLiteral(s, literal);
int i = Model.getFacade().getEnumerationLiterals(enumeration)
                .indexOf(literal);
start = end + 1;
end = NotationUtilityUml.indexOfNextCheckedSemicolon(text, start);
while (end > start && end <= text.length()) //1
{ 
s = text.substring(start, end).trim();
if(s.length() > 0)//1
{ 
Object newLiteral =
                    Model.getCoreFactory().createEnumerationLiteral();
if(newLiteral != null)//1
{ 
try //1
{ 
if(i != -1)//1
{ 
Model.getCoreHelper().addLiteral(
                                enumeration, ++i, newLiteral);
} 
else
{ 
Model.getCoreHelper().addLiteral(
                                enumeration, 0, newLiteral);
} 

parseEnumerationLiteral(s, newLiteral);
} 
catch (ParseException ex) //1
{ 
if(pex == null)//1
{ 
pex = ex;
} 

} 


} 

} 

start = end + 1;
end = NotationUtilityUml.indexOfNextCheckedSemicolon(text, start);
} 

if(pex != null)//1
{ 
throw pex;
} 

} 

 } 


