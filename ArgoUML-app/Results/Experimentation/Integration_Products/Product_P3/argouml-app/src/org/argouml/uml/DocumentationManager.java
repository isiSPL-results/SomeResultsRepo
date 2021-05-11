package org.argouml.uml;
import java.util.Collection;
import java.util.Iterator;
import org.argouml.application.api.Argo;
import org.argouml.model.Model;
import org.argouml.util.MyTokenizer;
public class DocumentationManager  { 
private static final String LINE_SEPARATOR =
        System.getProperty("line.separator");
public static String getDocs(Object o, String indent, String header,
                                 String prefix, String footer)
    { 
String sResult = defaultFor(o, indent);
if(Model.getFacade().isAModelElement(o))//1
{ 
Iterator iter = Model.getFacade().getTaggedValues(o);
if(iter != null)//1
{ 
while (iter.hasNext()) //1
{ 
Object tv = iter.next();
String tag = Model.getFacade().getTagOfTag(tv);
if(Argo.DOCUMENTATION_TAG.equals(tag)
                            || Argo.DOCUMENTATION_TAG_ALT.equals(tag))//1
{ 
sResult = Model.getFacade().getValueOfTag(tv);
if(Argo.DOCUMENTATION_TAG.equals(tag))//1
{ 
break;

} 
} 
} 
} 
} 
if(sResult == null)//1
{ 
return "(No comment)";
} 
StringBuffer result = new StringBuffer();
if(header != null)//1
{ 
result.append(header).append(LINE_SEPARATOR);
} 
if(indent != null)//1
{ 
if(prefix != null)//1
{ 
prefix = indent + prefix;
} 
if(footer != null)//1
{ 
footer = indent + footer;
} 
} 
appendComment(result, prefix, sResult, 0);
if(footer != null)//1
{ 
result.append(footer);
} 
return result.toString();
} 
public static void setDocs(Object o, String s)
    { 
Object taggedValue =
            Model.getFacade().getTaggedValue(o, Argo.DOCUMENTATION_TAG);
if(taggedValue == null)//1
{ 
taggedValue =
                Model.getExtensionMechanismsFactory().buildTaggedValue(
                    Argo.DOCUMENTATION_TAG, s);
Model.getExtensionMechanismsHelper().addTaggedValue(o, taggedValue);
} 
else
{ 
Model.getExtensionMechanismsHelper().setValueOfTag(taggedValue, s);
} 
} 
public static String getDocs(Object o, String indent)
    { 
return getDocs(o, indent, "/* ", " *  ", " */");
} 
public static boolean hasDocs(Object o)
    { 
if(Model.getFacade().isAModelElement(o))//1
{ 
Iterator i = Model.getFacade().getTaggedValues(o);
if(i != null)//1
{ 
while (i.hasNext()) //1
{ 
Object tv = i.next();
String tag = Model.getFacade().getTagOfTag(tv);
String value = Model.getFacade().getValueOfTag(tv);
if((Argo.DOCUMENTATION_TAG.equals(tag)
                            || Argo.DOCUMENTATION_TAG_ALT.equals(tag))
                            && value != null && value.trim().length() > 0)//1
{ 
return true;
} 
} 
} 
} 
return false;
} 
public static String getComments(Object o)
    { 
return getComments(o, "/*", " * ", " */");
} 
public static String getComments(Object o,
                                     String header, String prefix,
                                     String footer)
    { 
StringBuffer result = new StringBuffer();
if(header != null)//1
{ 
result.append(header).append(LINE_SEPARATOR);
} 
if(Model.getFacade().isAUMLElement(o))//1
{ 
Collection comments = Model.getFacade().getComments(o);
if(!comments.isEmpty())//1
{ 
int nlcount = 2;
for (Iterator iter = comments.iterator(); iter.hasNext();) //1
{ 
Object c = iter.next();
String s = Model.getFacade().getName(c);
nlcount = appendComment(result,
                                            prefix,
                                            s,
                                            nlcount > 1 ? 0 : 1);
} 
} 
else
{ 
return "";
} 
} 
else
{ 
return "";
} 
if(footer != null)//1
{ 
result.append(footer).append(LINE_SEPARATOR);
} 
return result.toString();
} 
private static int appendComment(StringBuffer sb, String prefix,
                                     String comment, int nlprefix)
    { 
int nlcount = 0;
for (; nlprefix > 0; nlprefix--) //1
{ 
if(prefix != null)//1
{ 
sb.append(prefix);
} 
sb.append(LINE_SEPARATOR);
nlcount++;
} 
if(comment == null)//1
{ 
return nlcount;
} 
MyTokenizer tokens = new MyTokenizer(comment,
                                             "",
                                             MyTokenizer.LINE_SEPARATOR);
while (tokens.hasMoreTokens()) //1
{ 
String s = tokens.nextToken();
if(!s.startsWith("\r") && !s.startsWith("\n"))//1
{ 
if(prefix != null)//1
{ 
sb.append(prefix);
} 
sb.append(s);
sb.append(LINE_SEPARATOR);
nlcount = 0;
} 
else
if(nlcount > 0)//1
{ 
if(prefix != null)//1
{ 
sb.append(prefix);
} 
sb.append(LINE_SEPARATOR);
nlcount++;
} 
else
{ 
nlcount++;
} 
} 
return nlcount;
} 
public static String defaultFor(Object o, String indent)
    { 
if(Model.getFacade().isAClass(o))//1
{ 
return " A class that represents ...\n\n"
                   + indent + " @see OtherClasses\n"
                   + indent + " @author your_name_here";
} 
if(Model.getFacade().isAAttribute(o))//1
{ 
return " An attribute that represents ...";
} 
if(Model.getFacade().isAOperation(o))//1
{ 
return " An operation that does...\n\n"
                   + indent + " @param firstParam a description of this parameter";
} 
if(Model.getFacade().isAInterface(o))//1
{ 
return " An interface defining operations expected of ...\n\n"
                   + indent + " @see OtherClasses\n"
                   + indent + " @author your_name_here";
} 
if(Model.getFacade().isAModelElement(o))//1
{ 
return "\n";
} 
return null;
} 

 } 
