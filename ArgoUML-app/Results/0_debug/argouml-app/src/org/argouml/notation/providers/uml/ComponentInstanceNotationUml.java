
//#if 359940098 
// Compilation Unit of /ComponentInstanceNotationUml.java 
 

//#if 2081847501 
package org.argouml.notation.providers.uml;
//#endif 


//#if -861864518 
import java.util.ArrayList;
//#endif 


//#if 153029735 
import java.util.List;
//#endif 


//#if -1241967595 
import java.util.Map;
//#endif 


//#if -1652784213 
import java.util.StringTokenizer;
//#endif 


//#if 1397128106 
import org.argouml.model.Model;
//#endif 


//#if -54397635 
import org.argouml.notation.NotationSettings;
//#endif 


//#if 1063113388 
import org.argouml.notation.providers.ComponentInstanceNotation;
//#endif 


//#if 639694078 
public class ComponentInstanceNotationUml extends 
//#if 1204890232 
ComponentInstanceNotation
//#endif 

  { 

//#if 1438825503 

//#if 1435330138 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(Object modelElement, Map args)
    { 

//#if 993684508 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if 318838175 
public void parse(Object modelElement, String text)
    { 

//#if 1302549350 
String s = text.trim();
//#endif 


//#if 1046485151 
if(s.length() == 0)//1
{ 

//#if -566230294 
return;
//#endif 

} 

//#endif 


//#if -102663323 
if(s.charAt(s.length() - 1) == ';')//1
{ 

//#if 2061167070 
s = s.substring(0, s.length() - 2);
//#endif 

} 

//#endif 


//#if 1356620654 
String name = "";
//#endif 


//#if 400912955 
String bases = "";
//#endif 


//#if -1416262340 
StringTokenizer tokenizer = null;
//#endif 


//#if -1905789410 
if(s.indexOf(":", 0) > -1)//1
{ 

//#if -354977664 
name = s.substring(0, s.indexOf(":")).trim();
//#endif 


//#if -663505471 
bases = s.substring(s.indexOf(":") + 1).trim();
//#endif 

} 
else
{ 

//#if -509909840 
name = s;
//#endif 

} 

//#endif 


//#if 931034392 
tokenizer = new StringTokenizer(bases, ",");
//#endif 


//#if 1697418336 
List<Object> classifiers = new ArrayList<Object>();
//#endif 


//#if 593903873 
Object ns = Model.getFacade().getNamespace(modelElement);
//#endif 


//#if 360221543 
if(ns != null)//1
{ 

//#if 1595109373 
while (tokenizer.hasMoreElements()) //1
{ 

//#if -365080730 
String newBase = tokenizer.nextToken();
//#endif 


//#if -1682403966 
Object cls = Model.getFacade().lookupIn(ns, newBase.trim());
//#endif 


//#if -1228479352 
if(cls != null)//1
{ 

//#if 375597380 
classifiers.add(cls);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1777342590 
Model.getCommonBehaviorHelper().setClassifiers(modelElement,
                classifiers);
//#endif 


//#if -1567896936 
Model.getCoreHelper().setName(modelElement, name);
//#endif 

} 

//#endif 


//#if 1433077363 
private String toString(Object modelElement)
    { 

//#if -1819499708 
String nameStr = "";
//#endif 


//#if -672642148 
if(Model.getFacade().getName(modelElement) != null)//1
{ 

//#if -75995829 
nameStr = Model.getFacade().getName(modelElement).trim();
//#endif 

} 

//#endif 


//#if 652158702 
StringBuilder baseStr =
            formatNameList(Model.getFacade().getClassifiers(modelElement));
//#endif 


//#if -899760822 
if((nameStr.length() == 0) && (baseStr.length() == 0))//1
{ 

//#if -1977604896 
return "";
//#endif 

} 

//#endif 


//#if 32315702 
baseStr = new StringBuilder(baseStr.toString().trim());
//#endif 


//#if 1971214830 
if(baseStr.length() < 1)//1
{ 

//#if 1311096408 
return nameStr.trim();
//#endif 

} 

//#endif 


//#if -323796482 
return nameStr.trim() + " : " + baseStr.toString();
//#endif 

} 

//#endif 


//#if 352709273 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if 713755689 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if 1339519481 
public ComponentInstanceNotationUml(Object componentInstance)
    { 

//#if -59455630 
super(componentInstance);
//#endif 

} 

//#endif 


//#if -42450766 
public String getParsingHelp()
    { 

//#if 847755460 
return "parsing.help.fig-componentinstance";
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

