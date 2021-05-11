package org.argouml.cognitive;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import org.apache.log4j.Logger;
public class Agency extends Observable
  { 
private static final Logger LOG = Logger.getLogger(Agency.class);
private static Hashtable<Class, List<Critic>> criticRegistry =
        new Hashtable<Class, List<Critic>>(100);
private static List<Critic> critics = new ArrayList<Critic>();
private ControlMech controlMech;
private static Hashtable<String, Critic> singletonCritics =
        new Hashtable<String, Critic>(40);
private static Hashtable<Class, Collection<Critic>> cachedCritics =
        new Hashtable<Class, Collection<Critic>>();
public static void notifyStaticObservers(Object o)
    { 
if(theAgency() != null)//1
{ 
theAgency().setChanged();
theAgency().notifyObservers(o);
} 
} 
protected static List<Critic> criticListForSpecificClass(Class clazz)
    { 
List<Critic> theCritics = getCriticRegistry().get(clazz);
if(theCritics == null)//1
{ 
theCritics = new ArrayList<Critic>();
criticRegistry.put(clazz, theCritics);
} 
return theCritics;
} 
public static void applyCritics(
        Object dm,
        Designer d,
        Collection<Critic> theCritics,
        long reasonCode)
    { 
for (Critic c : theCritics) //1
{ 
if(c.isActive() && c.matchReason(reasonCode))//1
{ 
try//1
{ 
c.critique(dm, d);
} 
catch (Exception ex) //1
{ 
LOG.error("Disabling critique due to exception\n"
                              + c + "\n" + dm,
                              ex);
c.setEnabled(false);
} 
} 
} 
} 
public static void register(Critic cr, Object clazz)
    { 
register(cr, (Class) clazz);
} 
public static void register(Critic cr, Class clazz)
    { 
List<Critic> theCritics = getCriticRegistry().get(clazz);
if(theCritics == null)//1
{ 
theCritics = new ArrayList<Critic>();
criticRegistry.put(clazz, theCritics);
} 
if(!theCritics.contains(cr))//1
{ 
theCritics.add(cr);
notifyStaticObservers(cr);
LOG.debug("Registered: " + theCritics.toString());
cachedCritics.remove(clazz);
addCritic(cr);
} 
} 
protected static void addCritic(Critic cr)
    { 
if(critics.contains(cr))//1
{ 
return;
} 
if(!(cr instanceof CompoundCritic))//1
{ 
critics.add(cr);
} 
else
{ 
for (Critic c : ((CompoundCritic) cr).getCriticList()) //1
{ 
addCritic(c);
} 
return;
} 
} 
public void determineActiveCritics(Designer d)
    { 
for (Critic c : critics) //1
{ 
if(controlMech.isRelevant(c, d))//1
{ 
c.beActive();
} 
else
{ 
c.beInactive();
} 
} 
} 
public static void addStaticObserver(Observer obs)
    { 
Agency a = theAgency();
if(a == null)//1
{ 
return;
} 
a.addObserver(obs);
} 
public static List<Critic> getCriticList()
    { 
return critics;
} 
public static void register(Critic cr)
    { 
Set<Object> metas = cr.getCriticizedDesignMaterials();
for (Object meta : metas) //1
{ 
register(cr, meta);
} 
} 
public Agency()
    { 
controlMech = new StandardCM();
} 
private static Hashtable<Class, List<Critic>> getCriticRegistry()
    { 
return criticRegistry;
} 
public static Collection<Critic> criticsForClass(Class clazz)
    { 
Collection<Critic> col = cachedCritics.get(clazz);
if(col == null)//1
{ 
col = new ArrayList<Critic>();
col.addAll(criticListForSpecificClass(clazz));
Collection<Class> classes = new ArrayList<Class>();
if(clazz.getSuperclass() != null)//1
{ 
classes.add(clazz.getSuperclass());
} 
if(clazz.getInterfaces() != null)//1
{ 
classes.addAll(Arrays.asList(clazz.getInterfaces()));
} 
for (Class c : classes) //1
{ 
col.addAll(criticsForClass(c));
} 
cachedCritics.put(clazz, col);
} 
return col;
} 
public static void applyAllCritics(
        Object dm,
        Designer d,
        long reasonCode)
    { 
Class dmClazz = dm.getClass();
Collection<Critic> c = criticsForClass(dmClazz);
applyCritics(dm, d, c, reasonCode);
} 
public static void register(String crClassName, String dmClassName)
    { 
Class dmClass;
try//1
{ 
dmClass = Class.forName(dmClassName);
} 
catch (java.lang.ClassNotFoundException e) //1
{ 
LOG.error("Error loading dm " + dmClassName, e);
return;
} 
Critic cr = singletonCritics.get(crClassName);
if(cr == null)//1
{ 
Class crClass;
try//1
{ 
crClass = Class.forName(crClassName);
} 
catch (java.lang.ClassNotFoundException e) //1
{ 
LOG.error("Error loading cr " + crClassName, e);
return;
} 
try//2
{ 
cr = (Critic) crClass.newInstance();
} 
catch (java.lang.IllegalAccessException e) //1
{ 
LOG.error("Error instancating cr " + crClassName, e);
return;
} 
catch (java.lang.InstantiationException e) //1
{ 
LOG.error("Error instancating cr " + crClassName, e);
return;
} 
singletonCritics.put(crClassName, cr);
addCritic(cr);
} 
register(cr, dmClass);
} 
public static Agency theAgency()
    { 
Designer dsgr = Designer.theDesigner();
if(dsgr == null)//1
{ 
return null;
} 
return dsgr.getAgency();
} 
public static void applyAllCritics(Object dm, Designer d)
    { 
Class dmClazz = dm.getClass();
Collection<Critic> c = criticsForClass(dmClazz);
applyCritics(dm, d, c, -1L);
} 
public Agency(ControlMech cm)
    { 
controlMech = cm;
} 

 } 
