// Compilation Unit of /OCLEvaluator.java 
 
package org.argouml.ocl;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.profile.internal.ocl.DefaultOclEvaluator;
import org.argouml.profile.internal.ocl.InvalidOclException;
import org.argouml.profile.internal.ocl.ModelInterpreter;
import org.argouml.profile.internal.ocl.OclExpressionEvaluator;
import org.argouml.profile.internal.ocl.uml14.Uml14ModelInterpreter;
import org.tigris.gef.ocl.ExpansionException;
@Deprecated
public class OCLEvaluator extends org.tigris.gef.ocl.OCLEvaluator
  { 
private OclExpressionEvaluator evaluator = new DefaultOclEvaluator();
private HashMap<String, Object> vt = new HashMap<String, Object>();
private ModelInterpreter modelInterpreter = new Uml14ModelInterpreter();
protected synchronized String evalToString(Object self, String expr)
    throws ExpansionException
    { 
if("self".equals(expr))//1
{ 
expr = "self.name";
} 

vt.clear();
vt.put("self", self);
try //1
{ 
return value2String(evaluator.evaluate(vt, modelInterpreter, expr));
} 
catch (InvalidOclException e) //1
{ 
return "<ocl>invalid expression</ocl>";
} 


} 

private String value2String(Object v)
    { 
if(Model.getFacade().isAExpression(v))//1
{ 
v = Model.getFacade().getBody(v);
if("".equals(v))//1
{ 
v = "(unspecified)";
} 

} 
else
if(Model.getFacade().isAUMLElement(v))//1
{ 
v = Model.getFacade().getName(v);
if("".equals(v))//1
{ 
v = Translator.localize("misc.name.anon");
} 

} 
else
if(v instanceof Collection)//1
{ 
String acc = "[";
Collection collection = (Collection) v;
for (Object object : collection) //1
{ 
acc += value2String(object) + ",";
} 

acc += "]";
v = acc;
} 



return "" + v;
} 

public OCLEvaluator()
    { 
} 

protected synchronized String evalToString(
        Object self,
        String expr,
        String sep)
    throws ExpansionException
    { 
_scratchBindings.put("self", self);
java.util.List values = eval(_scratchBindings, expr);
_strBuf.setLength(0);
Iterator iter = values.iterator();
while (iter.hasNext()) //1
{ 
Object v = value2String(iter.next());
if(!"".equals(v))//1
{ 
_strBuf.append(v);
if(iter.hasNext())//1
{ 
_strBuf.append(sep);
} 

} 

} 

return _strBuf.toString();
} 

 } 


