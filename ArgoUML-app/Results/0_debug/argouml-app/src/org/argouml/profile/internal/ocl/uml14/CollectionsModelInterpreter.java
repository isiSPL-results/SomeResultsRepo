
//#if -87502777 
// Compilation Unit of /CollectionsModelInterpreter.java 
 

//#if 922719887 
package org.argouml.profile.internal.ocl.uml14;
//#endif 


//#if -1301435819 
import java.util.ArrayList;
//#endif 


//#if -350206548 
import java.util.Collection;
//#endif 


//#if -343529384 
import java.util.HashSet;
//#endif 


//#if -2076595476 
import java.util.List;
//#endif 


//#if -344059664 
import java.util.Map;
//#endif 


//#if -343876950 
import java.util.Set;
//#endif 


//#if -21054969 
import org.argouml.profile.internal.ocl.LambdaEvaluator;
//#endif 


//#if 2083018838 
import org.argouml.profile.internal.ocl.ModelInterpreter;
//#endif 


//#if 344756227 
public class CollectionsModelInterpreter implements 
//#if 684939587 
ModelInterpreter
//#endif 

  { 

//#if 1335043139 

//#if -1748991813 
@SuppressWarnings("unchecked")
//#endif 


    private Collection cloneCollection(Collection col)
    { 

//#if 1036928632 
if(col instanceof List)//1
{ 

//#if -2070730499 
return new ArrayList(col);
//#endif 

} 
else

//#if -1432616521 
if(col instanceof Bag)//1
{ 

//#if 878897288 
return new HashBag(col);
//#endif 

} 
else

//#if -1331279327 
if(col instanceof Set)//1
{ 

//#if 1051477959 
return new HashSet(col);
//#endif 

} 
else
{ 

//#if 1398586203 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 1688750800 
private boolean doForAll(Map<String, Object> vt, Collection collection,
                             List<String> vars, Object exp, LambdaEvaluator eval)
    { 

//#if -245337448 
if(vars.isEmpty())//1
{ 

//#if 1339319904 
return (Boolean) eval.evaluate(vt, exp);
//#endif 

} 
else
{ 

//#if -1030479491 
String var = vars.get(0);
//#endif 


//#if -809434897 
vars.remove(var);
//#endif 


//#if 370873395 
Object oldval = vt.get(var);
//#endif 


//#if -1297658614 
for (Object element : collection) //1
{ 

//#if 1394042574 
vt.put(var, element);
//#endif 


//#if 2144434094 
boolean ret = doForAll(vt, collection, vars, exp, eval);
//#endif 


//#if -453069083 
if(!ret)//1
{ 

//#if 2083028063 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1394736978 
vt.put(var, oldval);
//#endif 

} 

//#endif 


//#if -50645024 
return true;
//#endif 

} 

//#endif 


//#if 398924073 

//#if 419978802 
@SuppressWarnings("unchecked")
//#endif 


    public Object invokeFeature(Map<String, Object> vt, Object subject,
                                String feature, String type, Object[] parameters)
    { 

//#if 1176757434 
if(subject == null)//1
{ 

//#if -1892130214 
return null;
//#endif 

} 

//#endif 


//#if -1527995005 
if(!(subject instanceof Collection))//1
{ 

//#if -1943107826 
if(type.equals("->"))//1
{ 

//#if -1905985028 
Set ns = new HashSet();
//#endif 


//#if 2087751938 
ns.add(subject);
//#endif 


//#if -1330185583 
subject = ns;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 580457405 
if(subject instanceof Collection)//1
{ 

//#if -222129194 
if(type.equals("->"))//1
{ 

//#if 831557270 
if(feature.toString().trim().equals("select"))//1
{ 

//#if -1449616449 
List<String> vars = (List<String>) parameters[0];
//#endif 


//#if -912333233 
Object exp = parameters[1];
//#endif 


//#if 2090629149 
LambdaEvaluator eval = (LambdaEvaluator) parameters[2];
//#endif 


//#if -889019519 
Collection col = cloneCollection((Collection) subject);
//#endif 


//#if -1790224294 
List remove = new ArrayList();
//#endif 


//#if 1273257084 
String varName = vars.get(0);
//#endif 


//#if 1630740148 
Object oldVal = vt.get(varName);
//#endif 


//#if -624748867 
for (Object object : col) //1
{ 

//#if -1835760542 
vt.put(varName, object);
//#endif 


//#if -200079028 
Object res = eval.evaluate(vt, exp);
//#endif 


//#if -1503574636 
if(res instanceof Boolean && (Boolean) res)//1
{ 
} 
else
{ 

//#if 1195755140 
remove.add(object);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2050446463 
col.removeAll(remove);
//#endif 


//#if 1096332125 
vt.put(varName, oldVal);
//#endif 


//#if -517663683 
return col;
//#endif 

} 
else

//#if -1723204214 
if(feature.toString().trim().equals("reject"))//1
{ 

//#if -253044004 
List<String> vars = (ArrayList<String>) parameters[0];
//#endif 


//#if -1350662699 
Object exp = parameters[1];
//#endif 


//#if -1000647465 
LambdaEvaluator eval = (LambdaEvaluator) parameters[2];
//#endif 


//#if 314671163 
Collection col = cloneCollection((Collection) subject);
//#endif 


//#if -2118046112 
List remove = new ArrayList();
//#endif 


//#if 945435266 
String varName = vars.get(0);
//#endif 


//#if -2048376082 
Object oldVal = vt.get(varName);
//#endif 


//#if -1063078333 
for (Object object : col) //1
{ 

//#if 813506524 
vt.put(varName, object);
//#endif 


//#if 1571338002 
Object res = eval.evaluate(vt, exp);
//#endif 


//#if -961825138 
if(res instanceof Boolean && (Boolean) res)//1
{ 

//#if -571002795 
remove.add(object);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1073116295 
col.removeAll(remove);
//#endif 


//#if -857470185 
vt.put(varName, oldVal);
//#endif 


//#if 656651843 
return col;
//#endif 

} 
else

//#if -220615142 
if(feature.toString().trim().equals("forAll"))//1
{ 

//#if 1388663833 
List<String> vars = (ArrayList<String>) parameters[0];
//#endif 


//#if -280260270 
Object exp = parameters[1];
//#endif 


//#if -1647312070 
LambdaEvaluator eval = (LambdaEvaluator) parameters[2];
//#endif 


//#if -1215741364 
return doForAll(vt, (Collection) subject, vars, exp, eval);
//#endif 

} 
else

//#if 1934232363 
if(feature.toString().trim().equals("collect"))//1
{ 

//#if 813039478 
List<String> vars = (ArrayList<String>) parameters[0];
//#endif 


//#if -2068236561 
Object exp = parameters[1];
//#endif 


//#if 1983169405 
LambdaEvaluator eval = (LambdaEvaluator) parameters[2];
//#endif 


//#if 2065290111 
Collection col = (Collection) subject;
//#endif 


//#if 766116301 
Bag res = new HashBag();
//#endif 


//#if -1448278756 
String varName = vars.get(0);
//#endif 


//#if 454177300 
Object oldVal = vt.get(varName);
//#endif 


//#if -1780652195 
for (Object object : col) //1
{ 

//#if -1350956349 
vt.put(varName, object);
//#endif 


//#if -1670295446 
Object val = eval.evaluate(vt, exp);
//#endif 


//#if -1050179187 
res.add(val);
//#endif 

} 

//#endif 


//#if 1197592253 
vt.put(varName, oldVal);
//#endif 


//#if 1570351549 
return res;
//#endif 

} 
else

//#if 722302889 
if(feature.toString().trim().equals("exists"))//1
{ 

//#if -1826522351 
List<String> vars = (ArrayList<String>) parameters[0];
//#endif 


//#if 607026762 
Object exp = parameters[1];
//#endif 


//#if 1761131330 
LambdaEvaluator eval = (LambdaEvaluator) parameters[2];
//#endif 


//#if 1731061018 
Collection col = (Collection) subject;
//#endif 


//#if 1089331639 
String varName = vars.get(0);
//#endif 


//#if -1608889447 
Object oldVal = vt.get(varName);
//#endif 


//#if 894611128 
for (Object object : col) //1
{ 

//#if -2140831164 
vt.put(varName, object);
//#endif 


//#if -528631287 
Object val = eval.evaluate(vt, exp);
//#endif 


//#if -2004169002 
if(val instanceof Boolean && (Boolean) val)//1
{ 

//#if 509440349 
return true;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1422438402 
vt.put(varName, oldVal);
//#endif 


//#if -1516597003 
return false;
//#endif 

} 
else

//#if 1157860981 
if(feature.toString().trim().equals("isUnique"))//1
{ 

//#if -86255131 
List<String> vars = (ArrayList<String>) parameters[0];
//#endif 


//#if -2031632866 
Object exp = parameters[1];
//#endif 


//#if -125159698 
LambdaEvaluator eval = (LambdaEvaluator) parameters[2];
//#endif 


//#if 201878510 
Collection col = (Collection) subject;
//#endif 


//#if 421396982 
Bag<Object> res = new HashBag<Object>();
//#endif 


//#if -631866229 
String varName = vars.get(0);
//#endif 


//#if -200028091 
Object oldVal = vt.get(varName);
//#endif 


//#if -1744048500 
for (Object object : col) //1
{ 

//#if 978286661 
vt.put(varName, object);
//#endif 


//#if -1011747544 
Object val = eval.evaluate(vt, exp);
//#endif 


//#if -1201827441 
res.add(val);
//#endif 


//#if -1816879450 
if(res.count(val) > 1)//1
{ 

//#if 1234136671 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1891509678 
vt.put(varName, oldVal);
//#endif 


//#if 859319036 
return true;
//#endif 

} 
else

//#if 1881140529 
if(feature.toString().trim().equals("one"))//1
{ 

//#if 704837617 
List<String> vars = (ArrayList<String>) parameters[0];
//#endif 


//#if 1677873962 
Object exp = parameters[1];
//#endif 


//#if -1371088286 
LambdaEvaluator eval = (LambdaEvaluator) parameters[2];
//#endif 


//#if -412802566 
Collection col = (Collection) subject;
//#endif 


//#if -618660201 
String varName = vars.get(0);
//#endif 


//#if -1916239175 
Object oldVal = vt.get(varName);
//#endif 


//#if -731472242 
boolean found = false;
//#endif 


//#if 1965458328 
for (Object object : col) //1
{ 

//#if -720980909 
vt.put(varName, object);
//#endif 


//#if -647862054 
Object val = eval.evaluate(vt, exp);
//#endif 


//#if -1426113755 
if(val instanceof Boolean && (Boolean) val)//1
{ 

//#if 2063316329 
if(!found)//1
{ 

//#if -1584285611 
found = true;
//#endif 

} 
else
{ 

//#if 1513887020 
return false;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -759775454 
vt.put(varName, oldVal);
//#endif 


//#if 212337494 
return found;
//#endif 

} 
else

//#if 562540164 
if(feature.toString().trim().equals("any"))//1
{ 

//#if 301725783 
List<String> vars = (ArrayList<String>) parameters[0];
//#endif 


//#if -860879088 
Object exp = parameters[1];
//#endif 


//#if -982653252 
LambdaEvaluator eval = (LambdaEvaluator) parameters[2];
//#endif 


//#if -901271968 
Collection col = (Collection) subject;
//#endif 


//#if -818917123 
String varName = vars.get(0);
//#endif 


//#if -2060628333 
Object oldVal = vt.get(varName);
//#endif 


//#if -573294722 
for (Object object : col) //1
{ 

//#if -1292089531 
vt.put(varName, object);
//#endif 


//#if -1359083992 
Object val = eval.evaluate(vt, exp);
//#endif 


//#if 1820636567 
if(val instanceof Boolean && (Boolean) val)//1
{ 

//#if 814058472 
return object;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 959444604 
vt.put(varName, oldVal);
//#endif 


//#if 895414257 
return null;
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 868295124 
if(subject instanceof Collection)//2
{ 

//#if 1810189594 
if(type.equals("->"))//1
{ 

//#if 774901036 
if(feature.equals("size"))//1
{ 

//#if 1147203519 
return ((Collection) subject).size();
//#endif 

} 

//#endif 


//#if 905248886 
if(feature.equals("includes"))//1
{ 

//#if -345274277 
return ((Collection) subject).contains(parameters[0]);
//#endif 

} 

//#endif 


//#if -6546684 
if(feature.equals("excludes"))//1
{ 

//#if 361907442 
return !((Collection) subject).contains(parameters[0]);
//#endif 

} 

//#endif 


//#if -1432498174 
if(feature.equals("count"))//1
{ 

//#if -589295632 
return (new HashBag<Object>((Collection) subject))
                           .count(parameters[0]);
//#endif 

} 

//#endif 


//#if -267134071 
if(feature.equals("includesAll"))//1
{ 

//#if -1670074595 
Collection col = (Collection) parameters[0];
//#endif 


//#if -2072687315 
for (Object object : col) //1
{ 

//#if -256046685 
if(!((Collection) subject).contains(object))//1
{ 

//#if 1373431709 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1328847547 
return true;
//#endif 

} 

//#endif 


//#if 2099187259 
if(feature.equals("excludesAll"))//1
{ 

//#if -1920151188 
Collection col = (Collection) parameters[0];
//#endif 


//#if -1100878468 
for (Object object : col) //1
{ 

//#if 386975216 
if(((Collection) subject).contains(object))//1
{ 

//#if 770684717 
return false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -933321204 
return true;
//#endif 

} 

//#endif 


//#if -1043361482 
if(feature.equals("isEmpty"))//1
{ 

//#if 2053482985 
return ((Collection) subject).isEmpty();
//#endif 

} 

//#endif 


//#if 105014949 
if(feature.equals("notEmpty"))//1
{ 

//#if 1622676766 
return !((Collection) subject).isEmpty();
//#endif 

} 

//#endif 


//#if 921389246 
if(feature.equals("asSequence"))//1
{ 

//#if -1908460403 
return new ArrayList<Object>((Collection) subject);
//#endif 

} 

//#endif 


//#if -768096215 
if(feature.equals("asBag"))//1
{ 

//#if -895021146 
return new HashBag<Object>((Collection) subject);
//#endif 

} 

//#endif 


//#if -101131005 
if(feature.equals("asSet"))//1
{ 

//#if 862450133 
return new HashSet<Object>((Collection) subject);
//#endif 

} 

//#endif 


//#if 2086144318 
if(feature.equals("sum"))//1
{ 

//#if 725458864 
Integer sum = 0;
//#endif 


//#if -1896369288 
Collection col = (Collection) subject;
//#endif 


//#if -205833578 
for (Object object : col) //1
{ 

//#if -155648557 
sum += (Integer) object;
//#endif 

} 

//#endif 


//#if -1018473365 
return sum;
//#endif 

} 

//#endif 


//#if 1706001858 
if(feature.equals("union"))//1
{ 

//#if 624135600 
Collection copy = cloneCollection((Collection) subject);
//#endif 


//#if 903692530 
copy.addAll((Collection) parameters[0]);
//#endif 


//#if -1254147830 
return copy;
//#endif 

} 

//#endif 


//#if 1525026437 
if(feature.equals("append"))//1
{ 

//#if -1034691765 
Collection copy = cloneCollection((Collection) subject);
//#endif 


//#if -1037644649 
copy.add(parameters[0]);
//#endif 


//#if -466848497 
return copy;
//#endif 

} 

//#endif 


//#if -1811212735 
if(feature.equals("prepend"))//1
{ 

//#if -824602532 
Collection copy = cloneCollection((Collection) subject);
//#endif 


//#if 563442618 
if(copy instanceof List)//1
{ 

//#if 387597732 
((List) copy).add(0, parameters[0]);
//#endif 

} 
else
{ 

//#if 515714251 
copy.add(parameters[0]);
//#endif 

} 

//#endif 


//#if -758410018 
return copy;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -825584899 
if(subject instanceof List)//1
{ 

//#if 1418119011 
if(type.equals("->"))//1
{ 

//#if 1138068740 
if(feature.equals("at"))//1
{ 

//#if 1197075295 
return ((List) subject).get((Integer) parameters[0]);
//#endif 

} 

//#endif 


//#if 517689597 
if(feature.equals("first"))//1
{ 

//#if -1950993991 
return ((List) subject).get(0);
//#endif 

} 

//#endif 


//#if 1948472487 
if(feature.equals("last"))//1
{ 

//#if -1497144467 
return ((List) subject).get(((List) subject).size());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1965672909 
if(subject instanceof Set)//1
{ 

//#if 447891055 
if(type.equals("->"))//1
{ 

//#if 679144481 
if(feature.equals("intersection"))//1
{ 

//#if -1178245668 
Set c1 = (Set) subject;
//#endif 


//#if 582285163 
Set c2 = (Set) parameters[0];
//#endif 


//#if 1842929931 
Set r = new HashSet<Object>();
//#endif 


//#if -1462043596 
for (Object o : c1) //1
{ 

//#if -1616644087 
if(c2.contains(o))//1
{ 

//#if 2054432344 
r.add(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1461120075 
for (Object o : c2) //1
{ 

//#if -300871265 
if(c1.contains(o))//1
{ 

//#if 574609773 
r.add(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1720391406 
return r;
//#endif 

} 

//#endif 


//#if -49634165 
if(feature.equals("including"))//1
{ 

//#if 671722052 
Set copy = (Set) cloneCollection((Set) subject);
//#endif 


//#if -778395727 
copy.add(parameters[0]);
//#endif 


//#if 826122165 
return copy;
//#endif 

} 

//#endif 


//#if 1749474237 
if(feature.equals("excluding"))//1
{ 

//#if 1342388101 
Set copy = (Set) cloneCollection((Set) subject);
//#endif 


//#if -63700475 
copy.remove(parameters[0]);
//#endif 


//#if -1661701898 
return copy;
//#endif 

} 

//#endif 


//#if -1760044806 
if(feature.equals("symmetricDifference"))//1
{ 

//#if -660971240 
Set c1 = (Set) subject;
//#endif 


//#if -191392345 
Set c2 = (Set) parameters[0];
//#endif 


//#if -666236337 
Set r = new HashSet<Object>();
//#endif 


//#if -1306809992 
for (Object o : c1) //1
{ 

//#if -1456758964 
if(!c2.contains(o))//1
{ 

//#if -1376262471 
r.add(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1305886471 
for (Object o : c2) //1
{ 

//#if 533662302 
if(!c1.contains(o))//1
{ 

//#if -1658390277 
r.add(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1736624434 
return r;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 111321 
if(subject instanceof Bag)//1
{ 

//#if 22547341 
if(type.equals("->"))//1
{ 

//#if 237298418 
if(feature.equals("count"))//1
{ 

//#if -1017455237 
return ((Bag) subject).count(parameters[0]);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -118034822 
return null;
//#endif 

} 

//#endif 


//#if 216815900 
public Object getBuiltInSymbol(String sym)
    { 

//#if -1449111025 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

