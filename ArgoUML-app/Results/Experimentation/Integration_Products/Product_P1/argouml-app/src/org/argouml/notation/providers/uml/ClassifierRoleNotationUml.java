package org.argouml.notation.providers.uml;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.ClassifierRoleNotation;
import org.argouml.util.MyTokenizer;
public class ClassifierRoleNotationUml extends ClassifierRoleNotation
  { 
@SuppressWarnings("deprecation")

    @Deprecated
    public String toString(Object modelElement, Map args)
    { 
return toString(modelElement);
} 
protected Object parseClassifierRole(Object cls, String s)
    throws ParseException
    { 
String name = null;
String token;
String role = null;
String base = null;
List<String> bases = null;
boolean hasColon = false;
boolean hasSlash = false;
try//1
{ 
MyTokenizer st = new MyTokenizer(s, " ,\t,/,:,\\,");
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
if(base != null)//1
{ 
if(bases == null)//1
{ 
bases = new ArrayList<String>();
} 
bases.add(base);
} 
base = null;
} 
else
if(":".equals(token))//1
{ 
hasColon = true;
hasSlash = false;
if(bases == null)//1
{ 
bases = new ArrayList<String>();
} 
if(base != null)//1
{ 
bases.add(base);
} 
base = null;
} 
else
if(",".equals(token))//1
{ 
if(base != null)//1
{ 
if(bases == null)//1
{ 
bases = new ArrayList<String>();
} 
bases.add(base);
} 
base = null;
} 
else
if(hasColon)//1
{ 
if(base != null)//1
{ 
String msg = "parsing.error.classifier.extra-test";
throw new ParseException(
                            Translator.localize(msg),
                            st.getTokenIndex());
} 
base = token;
} 
else
if(hasSlash)//1
{ 
if(role != null)//1
{ 
String msg = "parsing.error.classifier.extra-test";
throw new ParseException(
                            Translator.localize(msg),
                            st.getTokenIndex());
} 
role = token;
} 
else
{ 
if(name != null)//1
{ 
String msg = "parsing.error.classifier.extra-test";
throw new ParseException(
                            Translator.localize(msg),
                            st.getTokenIndex());
} 
name = token;
} 
} 
} 
catch (NoSuchElementException nsee) //1
{ 
String msg = "parsing.error.classifier.unexpected-end-attribute";
throw new ParseException(Translator.localize(msg), s.length());
} 
if(base != null)//1
{ 
if(bases == null)//1
{ 
bases = new ArrayList<String>();
} 
bases.add(base);
} 
if(role != null)//1
{ 
Model.getCoreHelper().setName(cls, role.trim());
} 
if(bases != null)//1
{ 
Collection b = new ArrayList(Model.getFacade().getBases(cls));
Iterator it = b.iterator();
Object c;
Object ns = Model.getFacade().getNamespace(cls);
if(ns != null && Model.getFacade().getNamespace(ns) != null)//1
{ 
ns = Model.getFacade().getNamespace(ns);
} 
else
{ 
ns = Model.getFacade().getModel(cls);
} 
it = bases.iterator();
addBases://1
while (it.hasNext()) //1
{ 
String d = ((String) it.next()).trim();
Iterator it2 = b.iterator();
while (it2.hasNext()) //1
{ 
c = it2.next();
if(d.equals(Model.getFacade().getName(c)))//1
{ 
continue addBases;
} 
} 
c = NotationUtilityUml.getType(d, ns);
if(Model.getFacade().isACollaboration(
                            Model.getFacade().getNamespace(c)))//1
{ 
Model.getCoreHelper().setNamespace(c, ns);
} 
} 
} 
return cls;
} 
public String getParsingHelp()
    { 
return "parsing.help.fig-classifierrole";
} 
public ClassifierRoleNotationUml(Object classifierRole)
    { 
super(classifierRole);
} 
private String toString(Object modelElement)
    { 
String nameString = Model.getFacade().getName(modelElement);
if(nameString == null)//1
{ 
nameString = "";
} 
nameString = nameString.trim();
StringBuilder baseString =
            formatNameList(Model.getFacade().getBases(modelElement));
baseString = new StringBuilder(baseString.toString().trim());
if(nameString.length() != 0)//1
{ 
nameString = "/" + nameString;
} 
if(baseString.length() != 0)//1
{ 
baseString = baseString.insert(0, ":");
} 
return nameString + baseString.toString();
} 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 
return toString(modelElement);
} 
public void parse(Object modelElement, String text)
    { 
try//1
{ 
parseClassifierRole(modelElement, text);
} 
catch (ParseException pe) //1
{ 
String msg = "statusmsg.bar.error.parsing.classifierrole";
Object[] args = {pe.getLocalizedMessage(),
                             Integer.valueOf(pe.getErrorOffset()),
                            };
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
} 
} 

 } 
