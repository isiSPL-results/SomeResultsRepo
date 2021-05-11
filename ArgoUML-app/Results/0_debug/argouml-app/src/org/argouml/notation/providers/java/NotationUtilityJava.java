
//#if -2022377918 
// Compilation Unit of /NotationUtilityJava.java 
 

//#if -650065396 
package org.argouml.notation.providers.java;
//#endif 


//#if 1914175068 
import java.util.Map;
//#endif 


//#if 1465154416 
import java.util.Stack;
//#endif 


//#if 1488353585 
import org.argouml.model.Model;
//#endif 


//#if 321923702 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 1885258869 
public class NotationUtilityJava  { 

//#if -1179218619 
static String generatePath(Object modelElement,
                               Map args)
    { 

//#if -86225863 
if(NotationProvider.isValue("pathVisible", args))//1
{ 

//#if -1116758341 
return generatePath(modelElement);
//#endif 

} 
else
{ 

//#if -829674297 
return "";
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2129364605 
NotationUtilityJava()
    { 
} 

//#endif 


//#if -1359490101 
static String generateLeaf(Object modelElement)
    { 

//#if -545742888 
if(Model.getFacade().isLeaf(modelElement))//1
{ 

//#if 1440712626 
return "final ";
//#endif 

} 

//#endif 


//#if 1563566008 
return "";
//#endif 

} 

//#endif 


//#if 4166755 
static String generateExpression(Object expr)
    { 

//#if -1836733837 
if(Model.getFacade().isAExpression(expr))//1
{ 

//#if -993541784 
return generateUninterpreted(
                       (String) Model.getFacade().getBody(expr));
//#endif 

} 
else

//#if -1660112297 
if(Model.getFacade().isAConstraint(expr))//1
{ 

//#if 1377257233 
return generateExpression(Model.getFacade().getBody(expr));
//#endif 

} 

//#endif 


//#endif 


//#if 1935772462 
return "";
//#endif 

} 

//#endif 


//#if 1438743782 
@Deprecated
    static String generateLeaf(Object modelElement,
                               @SuppressWarnings("unused") Map args)
    { 

//#if 522004169 
return generateLeaf(modelElement);
//#endif 

} 

//#endif 


//#if -178087025 
static String generateAbstract(Object modelElement)
    { 

//#if 1756343123 
if(Model.getFacade().isAbstract(modelElement))//1
{ 

//#if -140202989 
return "abstract ";
//#endif 

} 

//#endif 


//#if -783959953 
return "";
//#endif 

} 

//#endif 


//#if 2038662690 
@Deprecated
    static String generateAbstract(Object modelElement,
                                   @SuppressWarnings("unused") Map args)
    { 

//#if 675807443 
return generateAbstract(modelElement);
//#endif 

} 

//#endif 


//#if 645989117 
static String generateChangeability(Object obj)
    { 

//#if 784214171 
if(Model.getFacade().isAAttribute(obj))//1
{ 

//#if -1148166885 
if(Model.getFacade().isReadOnly(obj))//1
{ 

//#if 628543009 
return "final ";
//#endif 

} 

//#endif 

} 
else
{ 

//#if -1384220841 
if(Model.getFacade().isAOperation(obj))//1
{ 

//#if -671267628 
if(Model.getFacade().isLeaf(obj))//1
{ 

//#if -2018897328 
return "final ";
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1777736992 
return "";
//#endif 

} 

//#endif 


//#if -1957269742 
static String generatePath(Object modelElement)
    { 

//#if -625918432 
StringBuilder s = new StringBuilder();
//#endif 


//#if -785167913 
Stack<String> stack = new Stack<String>();
//#endif 


//#if -2098923439 
Object ns = Model.getFacade().getNamespace(modelElement);
//#endif 


//#if -1597836234 
while (ns != null && !Model.getFacade().isAModel(ns)) //1
{ 

//#if -860191354 
stack.push(Model.getFacade().getName(ns));
//#endif 


//#if -532931743 
ns = Model.getFacade().getNamespace(ns);
//#endif 

} 

//#endif 


//#if 575656672 
while (!stack.isEmpty()) //1
{ 

//#if -1376512917 
s.append(stack.pop()).append(".");
//#endif 

} 

//#endif 


//#if 490050886 
if(s.length() > 0 && !(s.lastIndexOf(".") == s.length() - 1))//1
{ 

//#if -764553416 
s.append(".");
//#endif 

} 

//#endif 


//#if -76832801 
return s.toString();
//#endif 

} 

//#endif 


//#if 1681242481 
@Deprecated
    static String generateVisibility(Object modelElement,
                                     Map args)
    { 

//#if 1362016669 
String s = "";
//#endif 


//#if -1421461416 
if(NotationProvider.isValue("visibilityVisible", args))//1
{ 

//#if -1540154940 
s = NotationUtilityJava.generateVisibility(modelElement);
//#endif 

} 

//#endif 


//#if 2135435995 
return s;
//#endif 

} 

//#endif 


//#if -352531308 
static String generateScope(Object f)
    { 

//#if -1025965093 
if(Model.getFacade().isStatic(f))//1
{ 

//#if 1373108891 
return "static ";
//#endif 

} 

//#endif 


//#if -1773560194 
return "";
//#endif 

} 

//#endif 


//#if 1939239884 
static String generateUninterpreted(String un)
    { 

//#if 97889289 
if(un == null)//1
{ 

//#if -96361094 
return "";
//#endif 

} 

//#endif 


//#if -2145853080 
return un;
//#endif 

} 

//#endif 


//#if -1499408079 
static String generateVisibility(Object o)
    { 

//#if 1130059347 
if(Model.getFacade().isAFeature(o))//1
{ 

//#if 1742740807 
Object tv = Model.getFacade().getTaggedValue(o, "src_visibility");
//#endif 


//#if -381670226 
if(tv != null)//1
{ 

//#if -39559770 
Object tvValue = Model.getFacade().getValue(tv);
//#endif 


//#if -71809931 
if(tvValue instanceof String)//1
{ 

//#if -757692937 
String tagged = (String) tvValue;
//#endif 


//#if -483018595 
if(tagged != null)//1
{ 

//#if 962676089 
if(tagged.trim().equals("")
                                || tagged.trim().toLowerCase().equals("package")
                                || tagged.trim().toLowerCase().equals("default"))//1
{ 

//#if 1264910087 
return "";
//#endif 

} 

//#endif 


//#if -275755414 
return tagged + " ";
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 2035695352 
if(Model.getFacade().isAModelElement(o))//1
{ 

//#if -1314515396 
if(Model.getFacade().isPublic(o))//1
{ 

//#if -627490853 
return "public ";
//#endif 

} 

//#endif 


//#if -2133084084 
if(Model.getFacade().isPrivate(o))//1
{ 

//#if -212955600 
return "private ";
//#endif 

} 

//#endif 


//#if -759753087 
if(Model.getFacade().isProtected(o))//1
{ 

//#if -1021147543 
return "protected ";
//#endif 

} 

//#endif 


//#if -1900996567 
if(Model.getFacade().isPackage(o))//1
{ 

//#if 2049927714 
return "";
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1413209381 
if(Model.getFacade().isAVisibilityKind(o))//1
{ 

//#if -1373493929 
if(Model.getVisibilityKind().getPublic().equals(o))//1
{ 

//#if 163008774 
return "public ";
//#endif 

} 

//#endif 


//#if -1729991791 
if(Model.getVisibilityKind().getPrivate().equals(o))//1
{ 

//#if -1676447457 
return "private ";
//#endif 

} 

//#endif 


//#if 1433114556 
if(Model.getVisibilityKind().getProtected().equals(o))//1
{ 

//#if 881049393 
return "protected ";
//#endif 

} 

//#endif 


//#if 1863226452 
if(Model.getVisibilityKind().getPackage().equals(o))//1
{ 

//#if -903884477 
return "";
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1592136790 
return "";
//#endif 

} 

//#endif 


//#if 1779447538 
static String generateClassifierRef(Object cls)
    { 

//#if 678947003 
if(cls == null)//1
{ 

//#if 1629226315 
return "";
//#endif 

} 

//#endif 


//#if -2094935306 
return Model.getFacade().getName(cls);
//#endif 

} 

//#endif 


//#if 960028924 
static String generateParameter(Object parameter)
    { 

//#if -1865827311 
StringBuffer sb = new StringBuffer(20);
//#endif 


//#if 651104500 
sb.append(generateClassifierRef(Model.getFacade().getType(parameter)));
//#endif 


//#if 1744153396 
sb.append(' ');
//#endif 


//#if -717334083 
sb.append(Model.getFacade().getName(parameter));
//#endif 


//#if 2033050674 
return sb.toString();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

