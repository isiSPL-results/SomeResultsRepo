
//#if -1615437698 
// Compilation Unit of /OCLEvaluator.java 
 

//#if 1578705683 
package org.argouml.ocl;
//#endif 


//#if 1541050309 
import java.util.Collection;
//#endif 


//#if -1173490907 
import java.util.HashMap;
//#endif 


//#if -12129803 
import java.util.Iterator;
//#endif 


//#if 994465862 
import org.argouml.i18n.Translator;
//#endif 


//#if 840578572 
import org.argouml.model.Model;
//#endif 


//#if -1133921936 
import org.argouml.profile.internal.ocl.DefaultOclEvaluator;
//#endif 


//#if 731705690 
import org.argouml.profile.internal.ocl.InvalidOclException;
//#endif 


//#if -1205399331 
import org.argouml.profile.internal.ocl.ModelInterpreter;
//#endif 


//#if -1762125905 
import org.argouml.profile.internal.ocl.OclExpressionEvaluator;
//#endif 


//#if -280823945 
import org.argouml.profile.internal.ocl.uml14.Uml14ModelInterpreter;
//#endif 


//#if 322264269 
import org.tigris.gef.ocl.ExpansionException;
//#endif 


//#if -1304418957 

//#if -1973008448 
@Deprecated
//#endif 

public class OCLEvaluator extends 
//#if -1869538726 
org.tigris.gef.ocl.OCLEvaluator
//#endif 

  { 

//#if -135150427 
private OclExpressionEvaluator evaluator = new DefaultOclEvaluator();
//#endif 


//#if 1115039333 
private HashMap<String, Object> vt = new HashMap<String, Object>();
//#endif 


//#if -1731769849 
private ModelInterpreter modelInterpreter = new Uml14ModelInterpreter();
//#endif 


//#if -293248097 
protected synchronized String evalToString(Object self, String expr)
    throws ExpansionException
    { 

//#if 1759630491 
if("self".equals(expr))//1
{ 

//#if 1580472684 
expr = "self.name";
//#endif 

} 

//#endif 


//#if 358707716 
vt.clear();
//#endif 


//#if 234783270 
vt.put("self", self);
//#endif 


//#if -1212272785 
try //1
{ 

//#if -1124728127 
return value2String(evaluator.evaluate(vt, modelInterpreter, expr));
//#endif 

} 

//#if -897369054 
catch (InvalidOclException e) //1
{ 

//#if 2023312003 
return "<ocl>invalid expression</ocl>";
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1712611047 
private String value2String(Object v)
    { 

//#if -200060045 
if(Model.getFacade().isAExpression(v))//1
{ 

//#if 2001861682 
v = Model.getFacade().getBody(v);
//#endif 


//#if -60969468 
if("".equals(v))//1
{ 

//#if 518284979 
v = "(unspecified)";
//#endif 

} 

//#endif 

} 
else

//#if -1856857659 
if(Model.getFacade().isAUMLElement(v))//1
{ 

//#if 1784625134 
v = Model.getFacade().getName(v);
//#endif 


//#if 208955863 
if("".equals(v))//1
{ 

//#if -409519814 
v = Translator.localize("misc.name.anon");
//#endif 

} 

//#endif 

} 
else

//#if 387177810 
if(v instanceof Collection)//1
{ 

//#if -1496496876 
String acc = "[";
//#endif 


//#if -1996734060 
Collection collection = (Collection) v;
//#endif 


//#if -694274034 
for (Object object : collection) //1
{ 

//#if 742088134 
acc += value2String(object) + ",";
//#endif 

} 

//#endif 


//#if -626151502 
acc += "]";
//#endif 


//#if 1739780438 
v = acc;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if -2246126 
return "" + v;
//#endif 

} 

//#endif 


//#if -1779118860 
public OCLEvaluator()
    { 
} 

//#endif 


//#if -1176696930 
protected synchronized String evalToString(
        Object self,
        String expr,
        String sep)
    throws ExpansionException
    { 

//#if 1609916719 
_scratchBindings.put("self", self);
//#endif 


//#if -757972540 
java.util.List values = eval(_scratchBindings, expr);
//#endif 


//#if 232191774 
_strBuf.setLength(0);
//#endif 


//#if 1441555264 
Iterator iter = values.iterator();
//#endif 


//#if 59896526 
while (iter.hasNext()) //1
{ 

//#if -1090675501 
Object v = value2String(iter.next());
//#endif 


//#if 366312691 
if(!"".equals(v))//1
{ 

//#if 1868874836 
_strBuf.append(v);
//#endif 


//#if -1788328802 
if(iter.hasNext())//1
{ 

//#if -437975842 
_strBuf.append(sep);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1124746374 
return _strBuf.toString();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

