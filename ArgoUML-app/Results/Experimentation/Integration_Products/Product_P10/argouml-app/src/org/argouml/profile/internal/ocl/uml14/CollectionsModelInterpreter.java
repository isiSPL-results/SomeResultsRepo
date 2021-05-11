package org.argouml.profile.internal.ocl.uml14;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.argouml.profile.internal.ocl.LambdaEvaluator;
import org.argouml.profile.internal.ocl.ModelInterpreter;
public class CollectionsModelInterpreter implements ModelInterpreter
  { 
@SuppressWarnings("unchecked")

    private Collection cloneCollection(Collection col)
    { 
if(col instanceof List)//1
{ 
return new ArrayList(col);
} 
else
if(col instanceof Bag)//1
{ 
return new HashBag(col);
} 
else
if(col instanceof Set)//1
{ 
return new HashSet(col);
} 
else
{ 
throw new IllegalArgumentException();
} 
} 
private boolean doForAll(Map<String, Object> vt, Collection collection,
                             List<String> vars, Object exp, LambdaEvaluator eval)
    { 
if(vars.isEmpty())//1
{ 
return (Boolean) eval.evaluate(vt, exp);
} 
else
{ 
String var = vars.get(0);
vars.remove(var);
Object oldval = vt.get(var);
for (Object element : collection) //1
{ 
vt.put(var, element);
boolean ret = doForAll(vt, collection, vars, exp, eval);
if(!ret)//1
{ 
return false;
} 
} 
vt.put(var, oldval);
} 
return true;
} 
@SuppressWarnings("unchecked")

    public Object invokeFeature(Map<String, Object> vt, Object subject,
                                String feature, String type, Object[] parameters)
    { 
if(subject == null)//1
{ 
return null;
} 
if(!(subject instanceof Collection))//1
{ 
if(type.equals("->"))//1
{ 
Set ns = new HashSet();
ns.add(subject);
subject = ns;
} 
} 
if(subject instanceof Collection)//1
{ 
if(type.equals("->"))//1
{ 
if(feature.toString().trim().equals("select"))//1
{ 
List<String> vars = (List<String>) parameters[0];
Object exp = parameters[1];
LambdaEvaluator eval = (LambdaEvaluator) parameters[2];
Collection col = cloneCollection((Collection) subject);
List remove = new ArrayList();
String varName = vars.get(0);
Object oldVal = vt.get(varName);
for (Object object : col) //1
{ 
vt.put(varName, object);
Object res = eval.evaluate(vt, exp);
if(res instanceof Boolean && (Boolean) res)//1
{ 
} 
else
{ 
remove.add(object);
} 
} 
col.removeAll(remove);
vt.put(varName, oldVal);
return col;
} 
else
if(feature.toString().trim().equals("reject"))//1
{ 
List<String> vars = (ArrayList<String>) parameters[0];
Object exp = parameters[1];
LambdaEvaluator eval = (LambdaEvaluator) parameters[2];
Collection col = cloneCollection((Collection) subject);
List remove = new ArrayList();
String varName = vars.get(0);
Object oldVal = vt.get(varName);
for (Object object : col) //1
{ 
vt.put(varName, object);
Object res = eval.evaluate(vt, exp);
if(res instanceof Boolean && (Boolean) res)//1
{ 
remove.add(object);
} 
} 
col.removeAll(remove);
vt.put(varName, oldVal);
return col;
} 
else
if(feature.toString().trim().equals("forAll"))//1
{ 
List<String> vars = (ArrayList<String>) parameters[0];
Object exp = parameters[1];
LambdaEvaluator eval = (LambdaEvaluator) parameters[2];
return doForAll(vt, (Collection) subject, vars, exp, eval);
} 
else
if(feature.toString().trim().equals("collect"))//1
{ 
List<String> vars = (ArrayList<String>) parameters[0];
Object exp = parameters[1];
LambdaEvaluator eval = (LambdaEvaluator) parameters[2];
Collection col = (Collection) subject;
Bag res = new HashBag();
String varName = vars.get(0);
Object oldVal = vt.get(varName);
for (Object object : col) //1
{ 
vt.put(varName, object);
Object val = eval.evaluate(vt, exp);
res.add(val);
} 
vt.put(varName, oldVal);
return res;
} 
else
if(feature.toString().trim().equals("exists"))//1
{ 
List<String> vars = (ArrayList<String>) parameters[0];
Object exp = parameters[1];
LambdaEvaluator eval = (LambdaEvaluator) parameters[2];
Collection col = (Collection) subject;
String varName = vars.get(0);
Object oldVal = vt.get(varName);
for (Object object : col) //1
{ 
vt.put(varName, object);
Object val = eval.evaluate(vt, exp);
if(val instanceof Boolean && (Boolean) val)//1
{ 
return true;
} 
} 
vt.put(varName, oldVal);
return false;
} 
else
if(feature.toString().trim().equals("isUnique"))//1
{ 
List<String> vars = (ArrayList<String>) parameters[0];
Object exp = parameters[1];
LambdaEvaluator eval = (LambdaEvaluator) parameters[2];
Collection col = (Collection) subject;
Bag<Object> res = new HashBag<Object>();
String varName = vars.get(0);
Object oldVal = vt.get(varName);
for (Object object : col) //1
{ 
vt.put(varName, object);
Object val = eval.evaluate(vt, exp);
res.add(val);
if(res.count(val) > 1)//1
{ 
return false;
} 
} 
vt.put(varName, oldVal);
return true;
} 
else
if(feature.toString().trim().equals("one"))//1
{ 
List<String> vars = (ArrayList<String>) parameters[0];
Object exp = parameters[1];
LambdaEvaluator eval = (LambdaEvaluator) parameters[2];
Collection col = (Collection) subject;
String varName = vars.get(0);
Object oldVal = vt.get(varName);
boolean found = false;
for (Object object : col) //1
{ 
vt.put(varName, object);
Object val = eval.evaluate(vt, exp);
if(val instanceof Boolean && (Boolean) val)//1
{ 
if(!found)//1
{ 
found = true;
} 
else
{ 
return false;
} 
} 
} 
vt.put(varName, oldVal);
return found;
} 
else
if(feature.toString().trim().equals("any"))//1
{ 
List<String> vars = (ArrayList<String>) parameters[0];
Object exp = parameters[1];
LambdaEvaluator eval = (LambdaEvaluator) parameters[2];
Collection col = (Collection) subject;
String varName = vars.get(0);
Object oldVal = vt.get(varName);
for (Object object : col) //1
{ 
vt.put(varName, object);
Object val = eval.evaluate(vt, exp);
if(val instanceof Boolean && (Boolean) val)//1
{ 
return object;
} 
} 
vt.put(varName, oldVal);
return null;
} 
} 
} 
if(subject instanceof Collection)//2
{ 
if(type.equals("->"))//1
{ 
if(feature.equals("size"))//1
{ 
return ((Collection) subject).size();
} 
if(feature.equals("includes"))//1
{ 
return ((Collection) subject).contains(parameters[0]);
} 
if(feature.equals("excludes"))//1
{ 
return !((Collection) subject).contains(parameters[0]);
} 
if(feature.equals("count"))//1
{ 
return (new HashBag<Object>((Collection) subject))
                           .count(parameters[0]);
} 
if(feature.equals("includesAll"))//1
{ 
Collection col = (Collection) parameters[0];
for (Object object : col) //1
{ 
if(!((Collection) subject).contains(object))//1
{ 
return false;
} 
} 
return true;
} 
if(feature.equals("excludesAll"))//1
{ 
Collection col = (Collection) parameters[0];
for (Object object : col) //1
{ 
if(((Collection) subject).contains(object))//1
{ 
return false;
} 
} 
return true;
} 
if(feature.equals("isEmpty"))//1
{ 
return ((Collection) subject).isEmpty();
} 
if(feature.equals("notEmpty"))//1
{ 
return !((Collection) subject).isEmpty();
} 
if(feature.equals("asSequence"))//1
{ 
return new ArrayList<Object>((Collection) subject);
} 
if(feature.equals("asBag"))//1
{ 
return new HashBag<Object>((Collection) subject);
} 
if(feature.equals("asSet"))//1
{ 
return new HashSet<Object>((Collection) subject);
} 
if(feature.equals("sum"))//1
{ 
Integer sum = 0;
Collection col = (Collection) subject;
for (Object object : col) //1
{ 
sum += (Integer) object;
} 
return sum;
} 
if(feature.equals("union"))//1
{ 
Collection copy = cloneCollection((Collection) subject);
copy.addAll((Collection) parameters[0]);
return copy;
} 
if(feature.equals("append"))//1
{ 
Collection copy = cloneCollection((Collection) subject);
copy.add(parameters[0]);
return copy;
} 
if(feature.equals("prepend"))//1
{ 
Collection copy = cloneCollection((Collection) subject);
if(copy instanceof List)//1
{ 
((List) copy).add(0, parameters[0]);
} 
else
{ 
copy.add(parameters[0]);
} 
return copy;
} 
} 
} 
if(subject instanceof List)//1
{ 
if(type.equals("->"))//1
{ 
if(feature.equals("at"))//1
{ 
return ((List) subject).get((Integer) parameters[0]);
} 
if(feature.equals("first"))//1
{ 
return ((List) subject).get(0);
} 
if(feature.equals("last"))//1
{ 
return ((List) subject).get(((List) subject).size());
} 
} 
} 
if(subject instanceof Set)//1
{ 
if(type.equals("->"))//1
{ 
if(feature.equals("intersection"))//1
{ 
Set c1 = (Set) subject;
Set c2 = (Set) parameters[0];
Set r = new HashSet<Object>();
for (Object o : c1) //1
{ 
if(c2.contains(o))//1
{ 
r.add(o);
} 
} 
for (Object o : c2) //1
{ 
if(c1.contains(o))//1
{ 
r.add(o);
} 
} 
return r;
} 
if(feature.equals("including"))//1
{ 
Set copy = (Set) cloneCollection((Set) subject);
copy.add(parameters[0]);
return copy;
} 
if(feature.equals("excluding"))//1
{ 
Set copy = (Set) cloneCollection((Set) subject);
copy.remove(parameters[0]);
return copy;
} 
if(feature.equals("symmetricDifference"))//1
{ 
Set c1 = (Set) subject;
Set c2 = (Set) parameters[0];
Set r = new HashSet<Object>();
for (Object o : c1) //1
{ 
if(!c2.contains(o))//1
{ 
r.add(o);
} 
} 
for (Object o : c2) //1
{ 
if(!c1.contains(o))//1
{ 
r.add(o);
} 
} 
return r;
} 
} 
} 
if(subject instanceof Bag)//1
{ 
if(type.equals("->"))//1
{ 
if(feature.equals("count"))//1
{ 
return ((Bag) subject).count(parameters[0]);
} 
} 
} 
return null;
} 
public Object getBuiltInSymbol(String sym)
    { 
return null;
} 

 } 
