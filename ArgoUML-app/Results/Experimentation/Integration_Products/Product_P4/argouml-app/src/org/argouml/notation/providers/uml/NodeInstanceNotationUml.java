package org.argouml.notation.providers.uml;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.NodeInstanceNotation;
public class NodeInstanceNotationUml extends NodeInstanceNotation
  { 
public String getParsingHelp()
    { 
return "parsing.help.fig-nodeinstance";
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public String toString(Object modelElement, Map args)
    { 
return toString(modelElement);
} 
private String toString(Object modelElement)
    { 
String nameStr = "";
if(Model.getFacade().getName(modelElement) != null)//1
{ 
nameStr = Model.getFacade().getName(modelElement).trim();
} 
StringBuilder baseStr =
            formatNameList(Model.getFacade().getClassifiers(modelElement));
if((nameStr.length() == 0) && (baseStr.length() == 0))//1
{ 
return "";
} 
String base = baseStr.toString().trim();
if(base.length() < 1)//1
{ 
return nameStr.trim();
} 
return nameStr.trim() + " : " + base;
} 
public void parse(Object modelElement, String text)
    { 
String s = text.trim();
if(s.length() == 0)//1
{ 
return;
} 
if(s.charAt(s.length() - 1) == ';')//1
{ 
s = s.substring(0, s.length() - 2);
} 
String name = "";
String bases = "";
StringTokenizer tokenizer = null;
if(s.indexOf(":", 0) > -1)//1
{ 
name = s.substring(0, s.indexOf(":")).trim();
bases = s.substring(s.indexOf(":") + 1).trim();
} 
else
{ 
name = s;
} 
tokenizer = new StringTokenizer(bases, ",");
List<Object> classifiers = new ArrayList<Object>();
Object ns = Model.getFacade().getNamespace(modelElement);
if(ns != null)//1
{ 
while (tokenizer.hasMoreElements()) //1
{ 
String newBase = tokenizer.nextToken();
Object cls = Model.getFacade().lookupIn(ns, newBase.trim());
if(cls != null)//1
{ 
classifiers.add(cls);
} 
} 
} 
Model.getCommonBehaviorHelper().setClassifiers(modelElement,
                classifiers);
Model.getCoreHelper().setName(modelElement, name);
} 
public NodeInstanceNotationUml(Object nodeInstance)
    { 
super(nodeInstance);
} 
@Override
    public String toString(Object modelElement, NotationSettings settings)
    { 
return toString(modelElement);
} 

 } 
