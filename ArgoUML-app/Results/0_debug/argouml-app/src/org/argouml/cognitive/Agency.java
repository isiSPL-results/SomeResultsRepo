
//#if -1758888885 
// Compilation Unit of /Agency.java 
 

//#if 461436689 
package org.argouml.cognitive;
//#endif 


//#if 492396828 
import java.util.ArrayList;
//#endif 


//#if -151649111 
import java.util.Arrays;
//#endif 


//#if -575969339 
import java.util.Collection;
//#endif 


//#if -979808941 
import java.util.Hashtable;
//#endif 


//#if -34958395 
import java.util.List;
//#endif 


//#if 1986917824 
import java.util.Observable;
//#endif 


//#if -359938931 
import java.util.Observer;
//#endif 


//#if -2079133007 
import java.util.Set;
//#endif 


//#if -1839517031 
import org.apache.log4j.Logger;
//#endif 


//#if -2006233983 
public class Agency extends 
//#if -1029092106 
Observable
//#endif 

  { 

//#if -1502830880 
private static final Logger LOG = Logger.getLogger(Agency.class);
//#endif 


//#if 925294629 
private static Hashtable<Class, List<Critic>> criticRegistry =
        new Hashtable<Class, List<Critic>>(100);
//#endif 


//#if -206561555 
private static List<Critic> critics = new ArrayList<Critic>();
//#endif 


//#if 829774731 
private ControlMech controlMech;
//#endif 


//#if -310422101 
private static Hashtable<String, Critic> singletonCritics =
        new Hashtable<String, Critic>(40);
//#endif 


//#if -1190442860 
private static Hashtable<Class, Collection<Critic>> cachedCritics =
        new Hashtable<Class, Collection<Critic>>();
//#endif 


//#if 1139618329 
public static void notifyStaticObservers(Object o)
    { 

//#if 590356425 
if(theAgency() != null)//1
{ 

//#if 1337798927 
theAgency().setChanged();
//#endif 


//#if 949629812 
theAgency().notifyObservers(o);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1022949179 
protected static List<Critic> criticListForSpecificClass(Class clazz)
    { 

//#if 1543818579 
List<Critic> theCritics = getCriticRegistry().get(clazz);
//#endif 


//#if 522425796 
if(theCritics == null)//1
{ 

//#if -594324857 
theCritics = new ArrayList<Critic>();
//#endif 


//#if 1217207945 
criticRegistry.put(clazz, theCritics);
//#endif 

} 

//#endif 


//#if 1013271321 
return theCritics;
//#endif 

} 

//#endif 


//#if 934088680 
public static void applyCritics(
        Object dm,
        Designer d,
        Collection<Critic> theCritics,
        long reasonCode)
    { 

//#if -1264964649 
for (Critic c : theCritics) //1
{ 

//#if 1854565968 
if(c.isActive() && c.matchReason(reasonCode))//1
{ 

//#if -441339121 
try //1
{ 

//#if 1412645349 
c.critique(dm, d);
//#endif 

} 

//#if 1455576834 
catch (Exception ex) //1
{ 

//#if -1597305247 
LOG.error("Disabling critique due to exception\n"
                              + c + "\n" + dm,
                              ex);
//#endif 


//#if -1572691829 
c.setEnabled(false);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 515720242 
public static void register(Critic cr, Object clazz)
    { 

//#if -574219116 
register(cr, (Class) clazz);
//#endif 

} 

//#endif 


//#if 434090151 
public static void register(Critic cr, Class clazz)
    { 

//#if 469835954 
List<Critic> theCritics = getCriticRegistry().get(clazz);
//#endif 


//#if -1922305467 
if(theCritics == null)//1
{ 

//#if -2104036052 
theCritics = new ArrayList<Critic>();
//#endif 


//#if -1986445884 
criticRegistry.put(clazz, theCritics);
//#endif 

} 

//#endif 


//#if -689101760 
if(!theCritics.contains(cr))//1
{ 

//#if -577553068 
theCritics.add(cr);
//#endif 


//#if 1261727511 
notifyStaticObservers(cr);
//#endif 


//#if -584663379 
LOG.debug("Registered: " + theCritics.toString());
//#endif 


//#if -1180377269 
cachedCritics.remove(clazz);
//#endif 


//#if -1460587256 
addCritic(cr);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 550667126 
protected static void addCritic(Critic cr)
    { 

//#if -495750456 
if(critics.contains(cr))//1
{ 

//#if 1014999073 
return;
//#endif 

} 

//#endif 


//#if -1982989424 
if(!(cr instanceof CompoundCritic))//1
{ 

//#if 1993711115 
critics.add(cr);
//#endif 

} 
else
{ 

//#if -739997334 
for (Critic c : ((CompoundCritic) cr).getCriticList()) //1
{ 

//#if 1327861334 
addCritic(c);
//#endif 

} 

//#endif 


//#if -1164052866 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1891397346 
public void determineActiveCritics(Designer d)
    { 

//#if -722614337 
for (Critic c : critics) //1
{ 

//#if -482165035 
if(controlMech.isRelevant(c, d))//1
{ 

//#if -1865673191 
c.beActive();
//#endif 

} 
else
{ 

//#if 1328277347 
c.beInactive();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -822997504 
public static void addStaticObserver(Observer obs)
    { 

//#if -1446293079 
Agency a = theAgency();
//#endif 


//#if -1725668791 
if(a == null)//1
{ 

//#if -373257120 
return;
//#endif 

} 

//#endif 


//#if -1352605936 
a.addObserver(obs);
//#endif 

} 

//#endif 


//#if 91532371 
public static List<Critic> getCriticList()
    { 

//#if -1678543554 
return critics;
//#endif 

} 

//#endif 


//#if -1352226241 
public static void register(Critic cr)
    { 

//#if -662933543 
Set<Object> metas = cr.getCriticizedDesignMaterials();
//#endif 


//#if 1533612929 
for (Object meta : metas) //1
{ 

//#if -1007943420 
register(cr, meta);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1289702242 
public Agency()
    { 

//#if -64096239 
controlMech = new StandardCM();
//#endif 

} 

//#endif 


//#if 48884260 
private static Hashtable<Class, List<Critic>> getCriticRegistry()
    { 

//#if -1945566471 
return criticRegistry;
//#endif 

} 

//#endif 


//#if -1491279751 
public static Collection<Critic> criticsForClass(Class clazz)
    { 

//#if 232562650 
Collection<Critic> col = cachedCritics.get(clazz);
//#endif 


//#if 602287112 
if(col == null)//1
{ 

//#if 2070449409 
col = new ArrayList<Critic>();
//#endif 


//#if -1736052327 
col.addAll(criticListForSpecificClass(clazz));
//#endif 


//#if 726326067 
Collection<Class> classes = new ArrayList<Class>();
//#endif 


//#if -382484939 
if(clazz.getSuperclass() != null)//1
{ 

//#if 1770626313 
classes.add(clazz.getSuperclass());
//#endif 

} 

//#endif 


//#if -2002651598 
if(clazz.getInterfaces() != null)//1
{ 

//#if 878859659 
classes.addAll(Arrays.asList(clazz.getInterfaces()));
//#endif 

} 

//#endif 


//#if 1541786997 
for (Class c : classes) //1
{ 

//#if -255372492 
col.addAll(criticsForClass(c));
//#endif 

} 

//#endif 


//#if -2108086787 
cachedCritics.put(clazz, col);
//#endif 

} 

//#endif 


//#if 671352591 
return col;
//#endif 

} 

//#endif 


//#if 250521471 
public static void applyAllCritics(
        Object dm,
        Designer d,
        long reasonCode)
    { 

//#if 2104270870 
Class dmClazz = dm.getClass();
//#endif 


//#if -787197186 
Collection<Critic> c = criticsForClass(dmClazz);
//#endif 


//#if -690306909 
applyCritics(dm, d, c, reasonCode);
//#endif 

} 

//#endif 


//#if -1090058288 
public static void register(String crClassName, String dmClassName)
    { 

//#if 1307520800 
Class dmClass;
//#endif 


//#if 683090970 
try //1
{ 

//#if -502698533 
dmClass = Class.forName(dmClassName);
//#endif 

} 

//#if 204323144 
catch (java.lang.ClassNotFoundException e) //1
{ 

//#if 331289298 
LOG.error("Error loading dm " + dmClassName, e);
//#endif 


//#if 877071488 
return;
//#endif 

} 

//#endif 


//#endif 


//#if -662575600 
Critic cr = singletonCritics.get(crClassName);
//#endif 


//#if -868619739 
if(cr == null)//1
{ 

//#if 448360963 
Class crClass;
//#endif 


//#if -949772483 
try //1
{ 

//#if -1904540185 
crClass = Class.forName(crClassName);
//#endif 

} 

//#if -1123507434 
catch (java.lang.ClassNotFoundException e) //1
{ 

//#if 97780636 
LOG.error("Error loading cr " + crClassName, e);
//#endif 


//#if 531036714 
return;
//#endif 

} 

//#endif 


//#endif 


//#if 572581460 
try //2
{ 

//#if 1442113505 
cr = (Critic) crClass.newInstance();
//#endif 

} 

//#if -745833465 
catch (java.lang.IllegalAccessException e) //1
{ 

//#if -1902485068 
LOG.error("Error instancating cr " + crClassName, e);
//#endif 


//#if -661556313 
return;
//#endif 

} 

//#endif 


//#if 1405867930 
catch (java.lang.InstantiationException e) //1
{ 

//#if 560933497 
LOG.error("Error instancating cr " + crClassName, e);
//#endif 


//#if 778708332 
return;
//#endif 

} 

//#endif 


//#endif 


//#if -1506531995 
singletonCritics.put(crClassName, cr);
//#endif 


//#if -1991782341 
addCritic(cr);
//#endif 

} 

//#endif 


//#if -670141595 
register(cr, dmClass);
//#endif 

} 

//#endif 


//#if 2092217960 
public static Agency theAgency()
    { 

//#if -705376617 
Designer dsgr = Designer.theDesigner();
//#endif 


//#if -993633274 
if(dsgr == null)//1
{ 

//#if 1192190622 
return null;
//#endif 

} 

//#endif 


//#if -1555744331 
return dsgr.getAgency();
//#endif 

} 

//#endif 


//#if 1951731418 
public static void applyAllCritics(Object dm, Designer d)
    { 

//#if -190235964 
Class dmClazz = dm.getClass();
//#endif 


//#if -1175658964 
Collection<Critic> c = criticsForClass(dmClazz);
//#endif 


//#if -1784829144 
applyCritics(dm, d, c, -1L);
//#endif 

} 

//#endif 


//#if -396184244 
public Agency(ControlMech cm)
    { 

//#if -1968061927 
controlMech = cm;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

