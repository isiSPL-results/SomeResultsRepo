
//#if 1954909646 
// Compilation Unit of /ObjectNotationUml.java 
 

//#if -1878148679 
package org.argouml.notation.providers.uml;
//#endif 


//#if -505376024 
import java.util.Collections;
//#endif 


//#if 2130169345 
import java.util.Map;
//#endif 


//#if 1777843095 
import java.util.StringTokenizer;
//#endif 


//#if -944990283 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -20529514 
import org.argouml.model.Model;
//#endif 


//#if -269702359 
import org.argouml.notation.NotationSettings;
//#endif 


//#if -2062566335 
import org.argouml.notation.providers.ObjectNotation;
//#endif 


//#if 1888490945 
public class ObjectNotationUml extends 
//#if -1281287561 
ObjectNotation
//#endif 

  { 

//#if -1159544109 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if -1474694028 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if 1645127897 
public void parse(Object modelElement, String text)
    { 

//#if 1674229488 
String s = text.trim();
//#endif 


//#if 1418165289 
if(s.length() == 0)//1
{ 

//#if 457432812 
return;
//#endif 

} 

//#endif 


//#if 170321263 
if(s.charAt(s.length() - 1) == ';')//1
{ 

//#if -1115605152 
s = s.substring(0, s.length() - 2);
//#endif 

} 

//#endif 


//#if 1661974136 
String name = "";
//#endif 


//#if 1276936305 
String bases = "";
//#endif 


//#if -569609462 
StringTokenizer baseTokens = null;
//#endif 


//#if -1202386392 
if(s.indexOf(":", 0) > -1)//1
{ 

//#if 85061359 
name = s.substring(0, s.indexOf(":", 0)).trim();
//#endif 


//#if -1451969542 
bases = s.substring(s.indexOf(":", 0) + 1).trim();
//#endif 


//#if -1624607809 
baseTokens = new StringTokenizer(bases, ",");
//#endif 

} 
else
{ 

//#if 1882135584 
name = s;
//#endif 

} 

//#endif 


//#if 1981679445 
Model.getCommonBehaviorHelper().setClassifiers(modelElement,
                Collections.emptyList());
//#endif 


//#if -1738016989 
if(baseTokens != null)//1
{ 

//#if -1462706578 
while (baseTokens.hasMoreElements()) //1
{ 

//#if -1856532405 
String typeString = baseTokens.nextToken();
//#endif 


//#if 860375664 
Object type =
                    ProjectManager.getManager()
                    .getCurrentProject().findType(typeString);
//#endif 


//#if 179890521 
Model.getCommonBehaviorHelper().addClassifier(modelElement,
                        type);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1791505586 
Model.getCoreHelper().setName(modelElement, name);
//#endif 

} 

//#endif 


//#if -217583028 
public ObjectNotationUml(Object theObject)
    { 

//#if -85568362 
super(theObject);
//#endif 

} 

//#endif 


//#if 1194593900 
public String getParsingHelp()
    { 

//#if -368227449 
return "parsing.help.fig-object";
//#endif 

} 

//#endif 


//#if -1456941319 
private String toString(Object modelElement)
    { 

//#if -709419759 
String nameStr = "";
//#endif 


//#if -1916578129 
if(Model.getFacade().getName(modelElement) != null)//1
{ 

//#if 60724881 
nameStr = Model.getFacade().getName(modelElement).trim();
//#endif 

} 

//#endif 


//#if 2099459379 
StringBuilder baseString = formatNameList(
                                       Model.getFacade().getClassifiers(modelElement));
//#endif 


//#if -1670323885 
if((nameStr.length() == 0) && (baseString.length() == 0))//1
{ 

//#if 1815667637 
return "";
//#endif 

} 

//#endif 


//#if -1828419030 
String base = baseString.toString().trim();
//#endif 


//#if 352111608 
if(base.length() < 1)//1
{ 

//#if -480716914 
return nameStr.trim();
//#endif 

} 

//#endif 


//#if -839924933 
return nameStr.trim() + " : " + base;
//#endif 

} 

//#endif 


//#if 719042341 

//#if -1762720810 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(Object modelElement, Map args)
    { 

//#if -283147320 
return toString(modelElement);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

