
//#if 1473163041 
// Compilation Unit of /DocumentationManager.java 
 

//#if -127128148 
package org.argouml.uml;
//#endif 


//#if -1447081958 
import java.util.Collection;
//#endif 


//#if 1178055562 
import java.util.Iterator;
//#endif 


//#if 1398465936 
import org.argouml.application.api.Argo;
//#endif 


//#if -1115610729 
import org.argouml.model.Model;
//#endif 


//#if 1870945404 
import org.argouml.util.MyTokenizer;
//#endif 


//#if 277574884 
public class DocumentationManager  { 

//#if 491328458 
private static final String LINE_SEPARATOR =
        System.getProperty("line.separator");
//#endif 


//#if -1683139038 
public static String getDocs(Object o, String indent, String header,
                                 String prefix, String footer)
    { 

//#if -303487113 
String sResult = defaultFor(o, indent);
//#endif 


//#if 1389927943 
if(Model.getFacade().isAModelElement(o))//1
{ 

//#if -2008136142 
Iterator iter = Model.getFacade().getTaggedValues(o);
//#endif 


//#if -1555321472 
if(iter != null)//1
{ 

//#if -889241458 
while (iter.hasNext()) //1
{ 

//#if 1224291210 
Object tv = iter.next();
//#endif 


//#if 453860438 
String tag = Model.getFacade().getTagOfTag(tv);
//#endif 


//#if 2016841454 
if(Argo.DOCUMENTATION_TAG.equals(tag)
                            || Argo.DOCUMENTATION_TAG_ALT.equals(tag))//1
{ 

//#if -532957671 
sResult = Model.getFacade().getValueOfTag(tv);
//#endif 


//#if -1350761401 
if(Argo.DOCUMENTATION_TAG.equals(tag))//1
{ 

//#if 1512740164 
break;

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1233904710 
if(sResult == null)//1
{ 

//#if 1622815737 
return "(No comment)";
//#endif 

} 

//#endif 


//#if -416897870 
StringBuffer result = new StringBuffer();
//#endif 


//#if 511903901 
if(header != null)//1
{ 

//#if -1165016960 
result.append(header).append(LINE_SEPARATOR);
//#endif 

} 

//#endif 


//#if 737164284 
if(indent != null)//1
{ 

//#if -771045402 
if(prefix != null)//1
{ 

//#if 853106538 
prefix = indent + prefix;
//#endif 

} 

//#endif 


//#if 913789871 
if(footer != null)//1
{ 

//#if 673553405 
footer = indent + footer;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1983605074 
appendComment(result, prefix, sResult, 0);
//#endif 


//#if 541254187 
if(footer != null)//1
{ 

//#if -84780583 
result.append(footer);
//#endif 

} 

//#endif 


//#if -1488322381 
return result.toString();
//#endif 

} 

//#endif 


//#if -1231118931 
public static void setDocs(Object o, String s)
    { 

//#if 2029220189 
Object taggedValue =
            Model.getFacade().getTaggedValue(o, Argo.DOCUMENTATION_TAG);
//#endif 


//#if -737610117 
if(taggedValue == null)//1
{ 

//#if -1314142246 
taggedValue =
                Model.getExtensionMechanismsFactory().buildTaggedValue(
                    Argo.DOCUMENTATION_TAG, s);
//#endif 


//#if 585940160 
Model.getExtensionMechanismsHelper().addTaggedValue(o, taggedValue);
//#endif 

} 
else
{ 

//#if -1447307771 
Model.getExtensionMechanismsHelper().setValueOfTag(taggedValue, s);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1815651587 
public static String getDocs(Object o, String indent)
    { 

//#if 1062968758 
return getDocs(o, indent, "/* ", " *  ", " */");
//#endif 

} 

//#endif 


//#if -1569949303 
public static boolean hasDocs(Object o)
    { 

//#if -155596761 
if(Model.getFacade().isAModelElement(o))//1
{ 

//#if -813675471 
Iterator i = Model.getFacade().getTaggedValues(o);
//#endif 


//#if 982415505 
if(i != null)//1
{ 

//#if -1489219402 
while (i.hasNext()) //1
{ 

//#if -590186126 
Object tv = i.next();
//#endif 


//#if 1342941119 
String tag = Model.getFacade().getTagOfTag(tv);
//#endif 


//#if -1283302625 
String value = Model.getFacade().getValueOfTag(tv);
//#endif 


//#if 1736450109 
if((Argo.DOCUMENTATION_TAG.equals(tag)
                            || Argo.DOCUMENTATION_TAG_ALT.equals(tag))
                            && value != null && value.trim().length() > 0)//1
{ 

//#if -668292624 
return true;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -678004242 
return false;
//#endif 

} 

//#endif 


//#if 489993843 
public static String getComments(Object o)
    { 

//#if -266655070 
return getComments(o, "/*", " * ", " */");
//#endif 

} 

//#endif 


//#if 1309450732 
public static String getComments(Object o,
                                     String header, String prefix,
                                     String footer)
    { 

//#if 1921601751 
StringBuffer result = new StringBuffer();
//#endif 


//#if -225582078 
if(header != null)//1
{ 

//#if 1310033313 
result.append(header).append(LINE_SEPARATOR);
//#endif 

} 

//#endif 


//#if -1982457321 
if(Model.getFacade().isAUMLElement(o))//1
{ 

//#if -115564744 
Collection comments = Model.getFacade().getComments(o);
//#endif 


//#if 1199346602 
if(!comments.isEmpty())//1
{ 

//#if 697530843 
int nlcount = 2;
//#endif 


//#if 963193098 
for (Iterator iter = comments.iterator(); iter.hasNext();) //1
{ 

//#if -744857723 
Object c = iter.next();
//#endif 


//#if 497185558 
String s = Model.getFacade().getName(c);
//#endif 


//#if 2111714352 
nlcount = appendComment(result,
                                            prefix,
                                            s,
                                            nlcount > 1 ? 0 : 1);
//#endif 

} 

//#endif 

} 
else
{ 

//#if -154111436 
return "";
//#endif 

} 

//#endif 

} 
else
{ 

//#if 1263977255 
return "";
//#endif 

} 

//#endif 


//#if -196231792 
if(footer != null)//1
{ 

//#if -265250778 
result.append(footer).append(LINE_SEPARATOR);
//#endif 

} 

//#endif 


//#if 724139118 
return result.toString();
//#endif 

} 

//#endif 


//#if 1538273306 
private static int appendComment(StringBuffer sb, String prefix,
                                     String comment, int nlprefix)
    { 

//#if -1270594741 
int nlcount = 0;
//#endif 


//#if 1273995248 
for (; nlprefix > 0; nlprefix--) //1
{ 

//#if 935030656 
if(prefix != null)//1
{ 

//#if 1867972306 
sb.append(prefix);
//#endif 

} 

//#endif 


//#if -880827741 
sb.append(LINE_SEPARATOR);
//#endif 


//#if 1135698226 
nlcount++;
//#endif 

} 

//#endif 


//#if 1967054110 
if(comment == null)//1
{ 

//#if -657205649 
return nlcount;
//#endif 

} 

//#endif 


//#if 1408199748 
MyTokenizer tokens = new MyTokenizer(comment,
                                             "",
                                             MyTokenizer.LINE_SEPARATOR);
//#endif 


//#if -834176528 
while (tokens.hasMoreTokens()) //1
{ 

//#if 1179441924 
String s = tokens.nextToken();
//#endif 


//#if 962643206 
if(!s.startsWith("\r") && !s.startsWith("\n"))//1
{ 

//#if 1017006246 
if(prefix != null)//1
{ 

//#if -867520776 
sb.append(prefix);
//#endif 

} 

//#endif 


//#if -1423108748 
sb.append(s);
//#endif 


//#if 785601213 
sb.append(LINE_SEPARATOR);
//#endif 


//#if -1467168391 
nlcount = 0;
//#endif 

} 
else

//#if -686874088 
if(nlcount > 0)//1
{ 

//#if -963582182 
if(prefix != null)//1
{ 

//#if 994606054 
sb.append(prefix);
//#endif 

} 

//#endif 


//#if -61126199 
sb.append(LINE_SEPARATOR);
//#endif 


//#if -920906664 
nlcount++;
//#endif 

} 
else
{ 

//#if -406235087 
nlcount++;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 913616725 
return nlcount;
//#endif 

} 

//#endif 


//#if 633537740 
public static String defaultFor(Object o, String indent)
    { 

//#if 444113595 
if(Model.getFacade().isAClass(o))//1
{ 

//#if 155458554 
return " A class that represents ...\n\n"
                   + indent + " @see OtherClasses\n"
                   + indent + " @author your_name_here";
//#endif 

} 

//#endif 


//#if -532269929 
if(Model.getFacade().isAAttribute(o))//1
{ 

//#if -1531272474 
return " An attribute that represents ...";
//#endif 

} 

//#endif 


//#if 461266796 
if(Model.getFacade().isAOperation(o))//1
{ 

//#if -1339817748 
return " An operation that does...\n\n"
                   + indent + " @param firstParam a description of this parameter";
//#endif 

} 

//#endif 


//#if 1603450714 
if(Model.getFacade().isAInterface(o))//1
{ 

//#if -614724773 
return " An interface defining operations expected of ...\n\n"
                   + indent + " @see OtherClasses\n"
                   + indent + " @author your_name_here";
//#endif 

} 

//#endif 


//#if -390126002 
if(Model.getFacade().isAModelElement(o))//1
{ 

//#if -111090703 
return "\n";
//#endif 

} 

//#endif 


//#if -508325755 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

