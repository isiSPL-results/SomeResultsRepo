// Compilation Unit of /NotationUtilityJava.java 
 
package org.argouml.notation.providers.java;
import java.util.Map;
import java.util.Stack;
import org.argouml.model.Model;
import org.argouml.notation.NotationProvider;
public class NotationUtilityJava  { 
static String generatePath(Object modelElement,
                               Map args)
    { 
if(NotationProvider.isValue("pathVisible", args))//1
{ 
return generatePath(modelElement);
} 
else
{ 
return "";
} 

} 

NotationUtilityJava()
    { 
} 

static String generateLeaf(Object modelElement)
    { 
if(Model.getFacade().isLeaf(modelElement))//1
{ 
return "final ";
} 

return "";
} 

static String generateExpression(Object expr)
    { 
if(Model.getFacade().isAExpression(expr))//1
{ 
return generateUninterpreted(
                       (String) Model.getFacade().getBody(expr));
} 
else
if(Model.getFacade().isAConstraint(expr))//1
{ 
return generateExpression(Model.getFacade().getBody(expr));
} 


return "";
} 

@Deprecated
    static String generateLeaf(Object modelElement,
                               @SuppressWarnings("unused") Map args)
    { 
return generateLeaf(modelElement);
} 

static String generateAbstract(Object modelElement)
    { 
if(Model.getFacade().isAbstract(modelElement))//1
{ 
return "abstract ";
} 

return "";
} 

@Deprecated
    static String generateAbstract(Object modelElement,
                                   @SuppressWarnings("unused") Map args)
    { 
return generateAbstract(modelElement);
} 

static String generateChangeability(Object obj)
    { 
if(Model.getFacade().isAAttribute(obj))//1
{ 
if(Model.getFacade().isReadOnly(obj))//1
{ 
return "final ";
} 

} 
else
{ 
if(Model.getFacade().isAOperation(obj))//1
{ 
if(Model.getFacade().isLeaf(obj))//1
{ 
return "final ";
} 

} 

} 

return "";
} 

static String generatePath(Object modelElement)
    { 
StringBuilder s = new StringBuilder();
Stack<String> stack = new Stack<String>();
Object ns = Model.getFacade().getNamespace(modelElement);
while (ns != null && !Model.getFacade().isAModel(ns)) //1
{ 
stack.push(Model.getFacade().getName(ns));
ns = Model.getFacade().getNamespace(ns);
} 

while (!stack.isEmpty()) //1
{ 
s.append(stack.pop()).append(".");
} 

if(s.length() > 0 && !(s.lastIndexOf(".") == s.length() - 1))//1
{ 
s.append(".");
} 

return s.toString();
} 

@Deprecated
    static String generateVisibility(Object modelElement,
                                     Map args)
    { 
String s = "";
if(NotationProvider.isValue("visibilityVisible", args))//1
{ 
s = NotationUtilityJava.generateVisibility(modelElement);
} 

return s;
} 

static String generateScope(Object f)
    { 
if(Model.getFacade().isStatic(f))//1
{ 
return "static ";
} 

return "";
} 

static String generateUninterpreted(String un)
    { 
if(un == null)//1
{ 
return "";
} 

return un;
} 

static String generateVisibility(Object o)
    { 
if(Model.getFacade().isAFeature(o))//1
{ 
Object tv = Model.getFacade().getTaggedValue(o, "src_visibility");
if(tv != null)//1
{ 
Object tvValue = Model.getFacade().getValue(tv);
if(tvValue instanceof String)//1
{ 
String tagged = (String) tvValue;
if(tagged != null)//1
{ 
if(tagged.trim().equals("")
                                || tagged.trim().toLowerCase().equals("package")
                                || tagged.trim().toLowerCase().equals("default"))//1
{ 
return "";
} 

return tagged + " ";
} 

} 

} 

} 

if(Model.getFacade().isAModelElement(o))//1
{ 
if(Model.getFacade().isPublic(o))//1
{ 
return "public ";
} 

if(Model.getFacade().isPrivate(o))//1
{ 
return "private ";
} 

if(Model.getFacade().isProtected(o))//1
{ 
return "protected ";
} 

if(Model.getFacade().isPackage(o))//1
{ 
return "";
} 

} 

if(Model.getFacade().isAVisibilityKind(o))//1
{ 
if(Model.getVisibilityKind().getPublic().equals(o))//1
{ 
return "public ";
} 

if(Model.getVisibilityKind().getPrivate().equals(o))//1
{ 
return "private ";
} 

if(Model.getVisibilityKind().getProtected().equals(o))//1
{ 
return "protected ";
} 

if(Model.getVisibilityKind().getPackage().equals(o))//1
{ 
return "";
} 

} 

return "";
} 

static String generateClassifierRef(Object cls)
    { 
if(cls == null)//1
{ 
return "";
} 

return Model.getFacade().getName(cls);
} 

static String generateParameter(Object parameter)
    { 
StringBuffer sb = new StringBuffer(20);
sb.append(generateClassifierRef(Model.getFacade().getType(parameter)));
sb.append(' ');
sb.append(Model.getFacade().getName(parameter));
return sb.toString();
} 

 } 


