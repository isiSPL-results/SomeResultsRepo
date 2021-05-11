
//#if -767085713 
// Compilation Unit of /ModelElementNameNotationJava.java 
 

//#if -1772397555 
package org.argouml.notation.providers.java;
//#endif 


//#if 1841966958 
import java.text.ParseException;
//#endif 


//#if 569581216 
import java.util.ArrayList;
//#endif 


//#if -1966509119 
import java.util.List;
//#endif 


//#if 2014796155 
import java.util.Map;
//#endif 


//#if -28824956 
import java.util.NoSuchElementException;
//#endif 


//#if -528742832 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 907132677 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if -677502599 
import org.argouml.application.events.ArgoHelpEvent;
//#endif 


//#if 1646819786 
import org.argouml.i18n.Translator;
//#endif 


//#if 159228463 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 2133965200 
import org.argouml.model.Model;
//#endif 


//#if 1960831139 
import org.argouml.notation.NotationSettings;
//#endif 


//#if -512111652 
import org.argouml.notation.providers.ModelElementNameNotation;
//#endif 


//#if -1870604253 
import org.argouml.util.MyTokenizer;
//#endif 


//#if -193196646 
public class ModelElementNameNotationJava extends 
//#if 1979794344 
ModelElementNameNotation
//#endif 

  { 

//#if 1821712609 
public String toString(Object modelElement, NotationSettings settings)
    { 

//#if -1459845973 
String name;
//#endif 


//#if -1649047220 
name = Model.getFacade().getName(modelElement);
//#endif 


//#if 546207121 
if(name == null)//1
{ 

//#if -1123392027 
return "";
//#endif 

} 

//#endif 


//#if 470825333 
String visibility = "";
//#endif 


//#if 424157524 
if(settings.isShowVisibilities())//1
{ 

//#if 25380979 
visibility = NotationUtilityJava.generateVisibility(modelElement);
//#endif 

} 

//#endif 


//#if -38620984 
String path = "";
//#endif 


//#if 325168316 
if(settings.isShowPaths())//1
{ 

//#if -316734055 
path = NotationUtilityJava.generatePath(modelElement);
//#endif 

} 

//#endif 


//#if -200542333 
return NotationUtilityJava.generateLeaf(modelElement)
               + NotationUtilityJava.generateAbstract(modelElement)
               + visibility
               + path
               + name;
//#endif 

} 

//#endif 


//#if 246287262 
public String getParsingHelp()
    { 

//#if 881606567 
return "parsing.help.java.fig-nodemodelelement";
//#endif 

} 

//#endif 


//#if -53570637 

//#if -491894324 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(Object modelElement, Map args)
    { 

//#if -1866237107 
String name;
//#endif 


//#if 1902663534 
name = Model.getFacade().getName(modelElement);
//#endif 


//#if 1383492275 
if(name == null)//1
{ 

//#if 1181612583 
return "";
//#endif 

} 

//#endif 


//#if -659573253 
return NotationUtilityJava.generateLeaf(modelElement, args)
               + NotationUtilityJava.generateAbstract(modelElement, args)
               + NotationUtilityJava.generateVisibility(modelElement, args)
               + NotationUtilityJava.generatePath(modelElement, args)
               + name;
//#endif 

} 

//#endif 


//#if 1582159914 
public ModelElementNameNotationJava(Object name)
    { 

//#if 1927281799 
super(name);
//#endif 

} 

//#endif 


//#if 724204939 
public void parse(Object modelElement, String text)
    { 

//#if -361901847 
try //1
{ 

//#if -1584254119 
parseModelElement(modelElement, text);
//#endif 

} 

//#if 2047991144 
catch (ParseException pe) //1
{ 

//#if -2105990411 
String msg = "statusmsg.bar.error.parsing.node-modelelement";
//#endif 


//#if 255302363 
Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
//#endif 


//#if 1080174552 
ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1481906157 
private static boolean isValidJavaClassName(String name)
    { 

//#if 300773312 
return true;
//#endif 

} 

//#endif 


//#if 1806005766 
static void parseModelElement(Object modelElement, String text)
    throws ParseException
    { 

//#if 1193594328 
MyTokenizer st;
//#endif 


//#if -753846590 
boolean abstrac = false;
//#endif 


//#if 897294400 
boolean fina = false;
//#endif 


//#if 383726298 
boolean publi = false;
//#endif 


//#if -1990625004 
boolean privat = false;
//#endif 


//#if 2134635493 
boolean protect = false;
//#endif 


//#if -898677380 
String token;
//#endif 


//#if -1545965132 
List<String> path = null;
//#endif 


//#if 2009846492 
String name = null;
//#endif 


//#if 806708767 
try //1
{ 

//#if 925087372 
st = new MyTokenizer(text,
                                 " ,.,abstract,final,public,private,protected");
//#endif 


//#if 807204584 
while (st.hasMoreTokens()) //1
{ 

//#if -184461918 
token = st.nextToken();
//#endif 


//#if 1790190051 
if(" ".equals(token))//1
{ 
} 
else

//#if 1289867163 
if("abstract".equals(token))//1
{ 

//#if -1259738833 
abstrac = true;
//#endif 

} 
else

//#if -137968723 
if("final".equals(token))//1
{ 

//#if -1058851499 
fina = true;
//#endif 

} 
else

//#if -1361446896 
if("public".equals(token))//1
{ 

//#if 1067538699 
publi = true;
//#endif 

} 
else

//#if -1299394702 
if("private".equals(token))//1
{ 

//#if -2007422136 
privat = true;
//#endif 

} 
else

//#if -1016169385 
if("protected".equals(token))//1
{ 

//#if 1154724621 
protect = true;
//#endif 

} 
else

//#if -971254485 
if(".".equals(token))//1
{ 

//#if -2001133652 
if(name != null)//1
{ 

//#if 1930337787 
name = name.trim();
//#endif 

} 

//#endif 


//#if 589005226 
if(path != null && (name == null || "".equals(name)))//1
{ 

//#if -854306446 
String msg =
                            "parsing.error.model-element-name.anon-qualifiers";
//#endif 


//#if 688345752 
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -117002198 
if(path == null)//1
{ 

//#if -1603566234 
path = new ArrayList<String>();
//#endif 

} 

//#endif 


//#if -1626481787 
if(name != null)//2
{ 

//#if -870228405 
path.add(name);
//#endif 

} 

//#endif 


//#if 971288183 
name = null;
//#endif 

} 
else
{ 

//#if -1853465285 
if(name != null)//1
{ 

//#if 797170873 
String msg =
                            "parsing.error.model-element-name.twin-names";
//#endif 


//#if -1729592348 
throw new ParseException(Translator.localize(msg),
                                                 st.getTokenIndex());
//#endif 

} 

//#endif 


//#if -1857326162 
name = token;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 

} 

//#if -748866452 
catch (NoSuchElementException nsee) //1
{ 

//#if -1210497837 
String msg =
                "parsing.error.model-element-name.unexpected-name-element";
//#endif 


//#if -1648557748 
throw new ParseException(Translator.localize(msg),
                                     text.length());
//#endif 

} 

//#endif 


//#if 1670052107 
catch (ParseException pre) //1
{ 

//#if -1817149637 
throw pre;
//#endif 

} 

//#endif 


//#endif 


//#if -1245935368 
if(name != null)//1
{ 

//#if 468494541 
name = name.trim();
//#endif 

} 

//#endif 


//#if 1312681694 
if(path != null && (name == null || "".equals(name)))//1
{ 

//#if 139767114 
String msg = "parsing.error.model-element-name.must-end-with-name";
//#endif 


//#if 1244333339 
throw new ParseException(Translator.localize(msg), 0);
//#endif 

} 

//#endif 


//#if -2029869012 
if(!isValidJavaClassName(name))//1
{ 

//#if 79099163 
throw new ParseException(
                "Invalid class name for Java: "
                + name, 0);
//#endif 

} 

//#endif 


//#if 1845606930 
if(path != null)//1
{ 

//#if -2131912520 
Object nspe =
                Model.getModelManagementHelper().getElement(
                    path,
                    Model.getFacade().getModel(modelElement));
//#endif 


//#if 1561294255 
if(nspe == null || !(Model.getFacade().isANamespace(nspe)))//1
{ 

//#if 765239279 
String msg =
                    "parsing.error.model-element-name.namespace-unresolved";
//#endif 


//#if 2104842365 
throw new ParseException(Translator.localize(msg),
                                         0);
//#endif 

} 

//#endif 


//#if 915543494 
Object model =
                ProjectManager.getManager().getCurrentProject().getRoot();
//#endif 


//#if 1420700020 
if(!Model.getCoreHelper().getAllPossibleNamespaces(
                        modelElement, model).contains(nspe))//1
{ 

//#if 696879817 
String msg =
                    "parsing.error.model-element-name.namespace-invalid";
//#endif 


//#if 774215643 
throw new ParseException(Translator.localize(msg),
                                         0);
//#endif 

} 

//#endif 


//#if -219358662 
Model.getCoreHelper().addOwnedElement(nspe, modelElement);
//#endif 

} 

//#endif 


//#if -1595483997 
Model.getCoreHelper().setName(modelElement, name);
//#endif 


//#if 1984158200 
if(abstrac)//1
{ 

//#if 137566778 
Model.getCoreHelper().setAbstract(modelElement, abstrac);
//#endif 

} 

//#endif 


//#if -798987744 
if(fina)//1
{ 

//#if -1888583524 
Model.getCoreHelper().setLeaf(modelElement, fina);
//#endif 

} 

//#endif 


//#if -2140866528 
if(publi)//1
{ 

//#if 39235297 
Model.getCoreHelper().setVisibility(modelElement,
                                                Model.getVisibilityKind().getPublic());
//#endif 

} 

//#endif 


//#if -1375032052 
if(privat)//1
{ 

//#if 218183847 
Model.getCoreHelper().setVisibility(modelElement,
                                                Model.getVisibilityKind().getPrivate());
//#endif 

} 

//#endif 


//#if 2010638261 
if(protect)//1
{ 

//#if -763235796 
Model.getCoreHelper().setVisibility(modelElement,
                                                Model.getVisibilityKind().getProtected());
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

