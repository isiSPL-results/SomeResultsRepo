
//#if -1067942207 
// Compilation Unit of /ClassifierRoleNotationUml.java 
 

//#if 644992683 
package org.argouml.notation.providers.uml;
//#endif 


//#if -1477617290 
import java.text.ParseException;
//#endif 


//#if 829411224 
import java.util.ArrayList;
//#endif 


//#if 1281542345 
import java.util.Collection;
//#endif 


//#if -405695495 
import java.util.Iterator;
//#endif 


//#if 502269897 
import java.util.List;
//#endif 


//#if 1263150195 
import java.util.Map;
//#endif 


//#if 1103416460 
import java.util.NoSuchElementException;
//#endif 


//#if 674094168 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if -459625987 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if 525334401 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if -465521982 
import org.argouml.i18n.Translator;
//#endif 


//#if 779955848 
import org.argouml.model.Model;
//#endif 


//#if 2107591579 
import org.argouml.notation.NotationSettings;
//#endif 


//#if 869295547 
import org.argouml.notation.providers.ClassifierRoleNotation;
//#endif 


//#if 1366277675 
import org.argouml.util.MyTokenizer;
//#endif 


//#if 602790971 
public class ClassifierRoleNotationUml extends 
//#if 1323858678 
ClassifierRoleNotation
//#endif 

  { 

//#if 1724535806 

//#if 504203876 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(Object modelElement, Map args)
    { 

//#if -869404705 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if 1271988863 
protected Object parseClassifierRole(Object cls, String s)
    throws ParseException
    { 

//#if 1434111363 
String name = null;
//#endif 


//#if -23352413 
String token;
//#endif 


//#if -629311698 
String role = null;
//#endif 


//#if 1364233545 
String base = null;
//#endif 


//#if 1743165018 
List<String> bases = null;
//#endif 


//#if -1991864552 
boolean hasColon = false;
//#endif 


//#if -1470783686 
boolean hasSlash = false;
//#endif 


//#if -25741946 
try //1
{ 

//#if -583273252 
MyTokenizer st = new MyTokenizer(s, " ,\t,/,:,\\,");
//#endif 


//#if -1257020068 
while (st.hasMoreTokens()) //1
{ 

//#if 1838791395 
token = st.nextToken();
//#endif 


//#if 379254391 
if(" ".equals(token) || "\t".equals(token))//1
{ 
} 
else

//#if -464373236 
if("/".equals(token))//1
{ 

//#if -1324000221 
hasSlash = true;
//#endif 


//#if 967823968 
hasColon = false;
//#endif 


//#if -1941023305 
if(base != null)//1
{ 

//#if -2007331071 
if(bases == null)//1
{ 

//#if -291948794 
bases = new ArrayList<String>();
//#endif 

} 

//#endif 


//#if -685735119 
bases.add(base);
//#endif 

} 

//#endif 


//#if 1614370968 
base = null;
//#endif 

} 
else

//#if -688167107 
if(":".equals(token))//1
{ 

//#if -1106284412 
hasColon = true;
//#endif 


//#if 169241187 
hasSlash = false;
//#endif 


//#if -816903179 
if(bases == null)//1
{ 

//#if -1779253291 
bases = new ArrayList<String>();
//#endif 

} 

//#endif 


//#if 1172531544 
if(base != null)//1
{ 

//#if 1325856685 
bases.add(base);
//#endif 

} 

//#endif 


//#if 370321431 
base = null;
//#endif 

} 
else

//#if 1774381935 
if(",".equals(token))//1
{ 

//#if -845251139 
if(base != null)//1
{ 

//#if 1269716793 
if(bases == null)//1
{ 

//#if -254859955 
bases = new ArrayList<String>();
//#endif 

} 

//#endif 


//#if 515438953 
bases.add(base);
//#endif 

} 

//#endif 


//#if 1602718546 
base = null;
//#endif 

} 
else

//#if 491181094 
if(hasColon)//1
{ 

//#if 1401989367 
if(base != null)//1
{ 

//#if 1079784600 
String msg = "parsing.error.classifier.extra-test";
//#endif 


//#if -1017884840 
throw new ParseException(
                            Translator.localize(msg),
                            st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 1613462558 
base = token;
//#endif 

} 
else

//#if -1440114647 
if(hasSlash)//1
{ 

//#if -2036799945 
if(role != null)//1
{ 

//#if -448476332 
String msg = "parsing.error.classifier.extra-test";
//#endif 


//#if -999673836 
throw new ParseException(
                            Translator.localize(msg),
                            st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -567091980 
role = token;
//#endif 

} 
else
{ 

//#if 1628154868 
if(name != null)//1
{ 

//#if 873039749 
String msg = "parsing.error.classifier.extra-test";
//#endif 


//#if -960501307 
throw new ParseException(
                            Translator.localize(msg),
                            st.getTokenIndex());
//#endif 

} 

//#endif 


//#if 129794343 
name = token;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 

} 

//#if 1534080140 
catch (NoSuchElementException nsee) //1
{ 

//#if 619193306 
String msg = "parsing.error.classifier.unexpected-end-attribute";
//#endif 


//#if -578780582 
throw new ParseException(Translator.localize(msg), s.length());
//#endif 

} 

//#endif 


//#endif 


//#if 632377335 
if(base != null)//1
{ 

//#if -1290950459 
if(bases == null)//1
{ 

//#if 2137992909 
bases = new ArrayList<String>();
//#endif 

} 

//#endif 


//#if -2070462987 
bases.add(base);
//#endif 

} 

//#endif 


//#if 417120092 
if(role != null)//1
{ 

//#if 1233830675 
Model.getCoreHelper().setName(cls, role.trim());
//#endif 

} 

//#endif 


//#if 825596370 
if(bases != null)//1
{ 

//#if 136985081 
Collection b = new ArrayList(Model.getFacade().getBases(cls));
//#endif 


//#if -828848542 
Iterator it = b.iterator();
//#endif 


//#if 1954220093 
Object c;
//#endif 


//#if -1425613362 
Object ns = Model.getFacade().getNamespace(cls);
//#endif 


//#if -813063205 
if(ns != null && Model.getFacade().getNamespace(ns) != null)//1
{ 

//#if -1014955033 
ns = Model.getFacade().getNamespace(ns);
//#endif 

} 
else
{ 

//#if 1893250118 
ns = Model.getFacade().getModel(cls);
//#endif 

} 

//#endif 


//#if -699744144 
while (it.hasNext()) //1
{ 

//#if -1875739000 
c = it.next();
//#endif 


//#if -1991034971 
if(!bases.contains(Model.getFacade().getName(c)))//1
{ 

//#if -987958843 
Model.getCollaborationsHelper().removeBase(cls, c);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1889860300 
it = bases.iterator();
//#endif 


//#if -365483938 
addBases://1

//#if 1931026046 
while (it.hasNext()) //1
{ 

//#if -687521859 
String d = ((String) it.next()).trim();
//#endif 


//#if -1744364529 
Iterator it2 = b.iterator();
//#endif 


//#if -1978729109 
while (it2.hasNext()) //1
{ 

//#if 944525183 
c = it2.next();
//#endif 


//#if -1872860185 
if(d.equals(Model.getFacade().getName(c)))//1
{ 

//#if -651444097 
continue addBases;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2112443860 
c = NotationUtilityUml.getType(d, ns);
//#endif 


//#if -1644575516 
if(Model.getFacade().isACollaboration(
                            Model.getFacade().getNamespace(c)))//1
{ 

//#if 1741101107 
Model.getCoreHelper().setNamespace(c, ns);
//#endif 

} 

//#endif 


//#if 1891764400 
Model.getCollaborationsHelper().addBase(cls, c);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1385545809 
return cls;
//#endif 

} 

//#endif 


//#if -2010388301 
public String getParsingHelp()
    { 

//#if 542880812 
return "parsing.help.fig-classifierrole";
//#endif 

} 

//#endif 


//#if -986464224 
public ClassifierRoleNotationUml(Object classifierRole)
    { 

//#if -284384967 
super(classifierRole);
//#endif 

} 

//#endif 


//#if 1942366226 
private String toString(Object modelElement)
    { 

//#if -732182396 
String nameString = Model.getFacade().getName(modelElement);
//#endif 


//#if -713542820 
if(nameString == null)//1
{ 

//#if 780250542 
nameString = "";
//#endif 

} 

//#endif 


//#if 1026278029 
nameString = nameString.trim();
//#endif 


//#if -1181908309 
StringBuilder baseString =
            formatNameList(Model.getFacade().getBases(modelElement));
//#endif 


//#if 355904839 
baseString = new StringBuilder(baseString.toString().trim());
//#endif 


//#if -882621644 
if(nameString.length() != 0)//1
{ 

//#if 1507919610 
nameString = "/" + nameString;
//#endif 

} 

//#endif 


//#if -1656899846 
if(baseString.length() != 0)//1
{ 

//#if -2059607858 
baseString = baseString.insert(0, ":");
//#endif 

} 

//#endif 


//#if 1757676039 
return nameString + baseString.toString();
//#endif 

} 

//#endif 


//#if 2098051290 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if -489950824 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if 348462944 
public void parse(Object modelElement, String text)
    { 

//#if 188266023 
try //1
{ 

//#if 1796617395 
parseClassifierRole(modelElement, text);
//#endif 

} 

//#if -561645514 
catch (ParseException pe) //1
{ 

//#if -1494746323 
String msg = "statusmsg.bar.error.parsing.classifierrole";
//#endif 


//#if 2058222144 
Object[] args = {pe.getLocalizedMessage(),
                             Integer.valueOf(pe.getErrorOffset()),
                            };
//#endif 


//#if -2097411821 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

