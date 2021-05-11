
//#if -338420561 
// Compilation Unit of /NodeInstanceNotationUml.java 
 

//#if 335005829 
package org.argouml.notation.providers.uml;
//#endif 


//#if -607601294 
import java.util.ArrayList;
//#endif 


//#if -1340319313 
import java.util.List;
//#endif 


//#if 788069837 
import java.util.Map;
//#endif 


//#if 1058249059 
import java.util.StringTokenizer;
//#endif 


//#if 77045602 
import org.argouml.model.Model;
//#endif 


//#if 562968309 
import org.argouml.notation.NotationSettings;
//#endif 


//#if 1268082517 
import org.argouml.notation.providers.NodeInstanceNotation;
//#endif 


//#if 1745039765 
public class NodeInstanceNotationUml extends 
//#if -1817209536 
NodeInstanceNotation
//#endif 

  { 

//#if -407787715 
public String getParsingHelp()
    { 

//#if -1681641890 
return "parsing.help.fig-nodeinstance";
//#endif 

} 

//#endif 


//#if -1878047692 

//#if 1163815270 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public String toString(Object modelElement, Map args)
    { 

//#if 1699640187 
return toString(modelElement);
//#endif 

} 

//#endif 


//#if -1852581432 
private String toString(Object modelElement)
    { 

//#if -625344114 
String nameStr = "";
//#endif 


//#if -359368430 
if(Model.getFacade().getName(modelElement) != null)//1
{ 

//#if 1947989483 
nameStr = Model.getFacade().getName(modelElement).trim();
//#endif 

} 

//#endif 


//#if 1997012068 
StringBuilder baseStr =
            formatNameList(Model.getFacade().getClassifiers(modelElement));
//#endif 


//#if 1465649428 
if((nameStr.length() == 0) && (baseStr.length() == 0))//1
{ 

//#if 1829443264 
return "";
//#endif 

} 

//#endif 


//#if 213697627 
String base = baseStr.toString().trim();
//#endif 


//#if -948556389 
if(base.length() < 1)//1
{ 

//#if -2021397880 
return nameStr.trim();
//#endif 

} 

//#endif 


//#if 1292554718 
return nameStr.trim() + " : " + base;
//#endif 

} 

//#endif 


//#if -814739606 
public void parse(Object modelElement, String text)
    { 

//#if 885405272 
String s = text.trim();
//#endif 


//#if 629341073 
if(s.length() == 0)//1
{ 

//#if 1034287901 
return;
//#endif 

} 

//#endif 


//#if 1656442583 
if(s.charAt(s.length() - 1) == ';')//1
{ 

//#if 1511809655 
s = s.substring(0, s.length() - 2);
//#endif 

} 

//#endif 


//#if 2027480032 
String name = "";
//#endif 


//#if -277282807 
String bases = "";
//#endif 


//#if 909568430 
StringTokenizer tokenizer = null;
//#endif 


//#if 1442667408 
if(s.indexOf(":", 0) > -1)//1
{ 

//#if -1327413597 
name = s.substring(0, s.indexOf(":")).trim();
//#endif 


//#if -744248322 
bases = s.substring(s.indexOf(":") + 1).trim();
//#endif 

} 
else
{ 

//#if -1650836595 
name = s;
//#endif 

} 

//#endif 


//#if 720661258 
tokenizer = new StringTokenizer(bases, ",");
//#endif 


//#if 1189437998 
List<Object> classifiers = new ArrayList<Object>();
//#endif 


//#if 1412818803 
Object ns = Model.getFacade().getNamespace(modelElement);
//#endif 


//#if -317974219 
if(ns != null)//1
{ 

//#if -217699197 
while (tokenizer.hasMoreElements()) //1
{ 

//#if 1704913506 
String newBase = tokenizer.nextToken();
//#endif 


//#if 115004030 
Object cls = Model.getFacade().lookupIn(ns, newBase.trim());
//#endif 


//#if -17902204 
if(cls != null)//1
{ 

//#if -142221149 
classifiers.add(cls);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1479268148 
Model.getCommonBehaviorHelper().setClassifiers(modelElement,
                classifiers);
//#endif 


//#if -110730010 
Model.getCoreHelper().setName(modelElement, name);
//#endif 

} 

//#endif 


//#if 694755542 
public NodeInstanceNotationUml(Object nodeInstance)
    { 

//#if -1900342029 
super(nodeInstance);
//#endif 

} 

//#endif 


//#if 2014287332 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 

//#if -1269619037 
return toString(modelElement);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

