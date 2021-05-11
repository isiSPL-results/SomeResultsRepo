
//#if -1432367884 
// Compilation Unit of /NotationProviderFactory2.java 
 

//#if -378938683 
package org.argouml.notation;
//#endif 


//#if 94750879 
import java.beans.PropertyChangeListener;
//#endif 


//#if -703636358 
import java.lang.reflect.Constructor;
//#endif 


//#if -1800097754 
import java.lang.reflect.InvocationTargetException;
//#endif 


//#if -1701044511 
import java.lang.reflect.Method;
//#endif 


//#if 1800355425 
import java.util.HashMap;
//#endif 


//#if -1268889037 
import java.util.Map;
//#endif 


//#if -1714554667 
import org.apache.log4j.Logger;
//#endif 


//#if -1875809451 
public final class NotationProviderFactory2  { 

//#if -597634421 
private static String currentLanguage;
//#endif 


//#if 2010293224 
public static final int TYPE_NAME = 1;
//#endif 


//#if 922075133 
public static final int TYPE_TRANSITION = 2;
//#endif 


//#if 1862202621 
public static final int TYPE_ACTIONSTATE = 4;
//#endif 


//#if -1096470533 
public static final int TYPE_ATTRIBUTE = 5;
//#endif 


//#if -354022033 
public static final int TYPE_OPERATION = 6;
//#endif 


//#if 730904686 
public static final int TYPE_OBJECT = 7;
//#endif 


//#if 175965858 
public static final int TYPE_COMPONENTINSTANCE = 8;
//#endif 


//#if 146855764 
public static final int TYPE_NODEINSTANCE = 9;
//#endif 


//#if -416096408 
public static final int TYPE_OBJECTFLOWSTATE_TYPE = 10;
//#endif 


//#if 1678780928 
public static final int TYPE_OBJECTFLOWSTATE_STATE = 11;
//#endif 


//#if -159504804 
public static final int TYPE_CALLSTATE = 12;
//#endif 


//#if 1175874791 
public static final int TYPE_CLASSIFIERROLE = 13;
//#endif 


//#if -1568178514 
public static final int TYPE_MESSAGE = 14;
//#endif 


//#if -305773642 
public static final int TYPE_EXTENSION_POINT = 15;
//#endif 


//#if 509892314 
public static final int TYPE_ASSOCIATION_END_NAME = 16;
//#endif 


//#if -1517112992 
public static final int TYPE_ASSOCIATION_ROLE = 17;
//#endif 


//#if 590059796 
public static final int TYPE_ASSOCIATION_NAME = 18;
//#endif 


//#if 1404974601 
public static final int TYPE_MULTIPLICITY = 19;
//#endif 


//#if 516269699 
public static final int TYPE_ENUMERATION_LITERAL = 20;
//#endif 


//#if 1578520396 
public static final int TYPE_SD_MESSAGE = 21;
//#endif 


//#if 25082993 
private NotationName defaultLanguage;
//#endif 


//#if -1433049356 
private Map<NotationName, Map<Integer, Class>> allLanguages;
//#endif 


//#if 1237359355 
private static NotationProviderFactory2 instance;
//#endif 


//#if -447605400 
private static final Logger LOG =
        Logger.getLogger(NotationProviderFactory2.class);
//#endif 


//#if -1516363450 
public static final int TYPE_STATEBODY = 3;
//#endif 


//#if -1622019458 
@Deprecated
    public NotationProvider getNotationProvider(int type,
            Object object, PropertyChangeListener listener)
    { 

//#if 1466515548 
NotationName name = Notation.findNotation(currentLanguage);
//#endif 


//#if 595410700 
return getNotationProvider(type, object, listener, name);
//#endif 

} 

//#endif 


//#if -893983879 
public static NotationProviderFactory2 getInstance()
    { 

//#if 936372260 
if(instance == null)//1
{ 

//#if 1347507878 
instance = new NotationProviderFactory2();
//#endif 

} 

//#endif 


//#if 1660026763 
return instance;
//#endif 

} 

//#endif 


//#if 128017180 
@Deprecated
    public static void setCurrentLanguage(String theCurrentLanguage)
    { 

//#if -1200184321 
NotationProviderFactory2.currentLanguage = theCurrentLanguage;
//#endif 

} 

//#endif 


//#if 472993195 
private Class getNotationProviderClass(int type, NotationName name)
    { 

//#if -1354045142 
if(allLanguages.containsKey(name))//1
{ 

//#if -644707727 
Map<Integer, Class> t = allLanguages.get(name);
//#endif 


//#if -1712310518 
if(t.containsKey(Integer.valueOf(type)))//1
{ 

//#if 162567515 
return t.get(Integer.valueOf(type));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 95893421 
Map<Integer, Class> t = allLanguages.get(defaultLanguage);
//#endif 


//#if -235238645 
if(t != null && t.containsKey(Integer.valueOf(type)))//1
{ 

//#if 87015425 
return t.get(Integer.valueOf(type));
//#endif 

} 

//#endif 


//#if -374071495 
return null;
//#endif 

} 

//#endif 


//#if -1768582046 
public NotationProvider getNotationProvider(int type,
            Object object, NotationName name)
    { 

//#if -1230241696 
Class clazz = getNotationProviderClass(type, name);
//#endif 


//#if -1681482805 
if(clazz != null)//1
{ 

//#if -1095578848 
try //1
{ 

//#if 625768008 
try //1
{ 

//#if 2138608482 
Class[] mp = {};
//#endif 


//#if 791683671 
Method m = clazz.getMethod("getInstance", mp);
//#endif 


//#if -1277489312 
return (NotationProvider) m.invoke(null, (Object[]) mp);
//#endif 

} 

//#if 499734339 
catch (Exception e) //1
{ 

//#if -991350624 
Class[] cp = {Object.class};
//#endif 


//#if 815076892 
Constructor constructor = clazz.getConstructor(cp);
//#endif 


//#if 844207098 
Object[] params = {
                        object,
                    };
//#endif 


//#if -826683735 
return (NotationProvider) constructor.newInstance(params);
//#endif 

} 

//#endif 


//#endif 

} 

//#if 181698649 
catch (SecurityException e) //1
{ 

//#if -1564240374 
LOG.error("Exception caught", e);
//#endif 

} 

//#endif 


//#if -245839230 
catch (NoSuchMethodException e) //1
{ 

//#if -827543323 
LOG.error("Exception caught", e);
//#endif 

} 

//#endif 


//#if 808301270 
catch (IllegalArgumentException e) //1
{ 

//#if 1829318018 
LOG.error("Exception caught", e);
//#endif 

} 

//#endif 


//#if 1727432592 
catch (InstantiationException e) //1
{ 

//#if -1781154043 
LOG.error("Exception caught", e);
//#endif 

} 

//#endif 


//#if -424268803 
catch (IllegalAccessException e) //1
{ 

//#if -1560362386 
LOG.error("Exception caught", e);
//#endif 

} 

//#endif 


//#if 328381082 
catch (InvocationTargetException e) //1
{ 

//#if -1700300453 
LOG.error("Exception caught", e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1665010193 
return null;
//#endif 

} 

//#endif 


//#if -1023174149 
@Deprecated
    public NotationProvider getNotationProvider(int type,
            Object object)
    { 

//#if -1524633373 
NotationName name = Notation.findNotation(currentLanguage);
//#endif 


//#if -923023347 
return getNotationProvider(type, object, name);
//#endif 

} 

//#endif 


//#if -2027968442 
public void setDefaultNotation(NotationName notationName)
    { 

//#if -1406291956 
if(allLanguages.containsKey(notationName))//1
{ 

//#if -1982122170 
defaultLanguage = notationName;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 48522689 
public NotationProvider getNotationProvider(int type,
            Object object, PropertyChangeListener listener,
            NotationName name)
    { 

//#if -804675208 
NotationProvider p = getNotationProvider(type, object, name);
//#endif 


//#if -2027348117 
p.initialiseListener(listener, object);
//#endif 


//#if -1048943588 
return p;
//#endif 

} 

//#endif 


//#if -419560834 
private NotationProviderFactory2()
    { 

//#if 1057836735 
super();
//#endif 


//#if 1110454468 
allLanguages = new HashMap<NotationName, Map<Integer, Class>>();
//#endif 

} 

//#endif 


//#if -1200832181 
public boolean removeNotation(NotationName notationName)
    { 

//#if 296982385 
if(defaultLanguage == notationName)//1
{ 

//#if 1506383224 
return false;
//#endif 

} 

//#endif 


//#if -217273979 
if(allLanguages.containsKey(notationName))//1
{ 

//#if 2050079476 
return allLanguages.remove(notationName) != null
                   && Notation.removeNotation(notationName);
//#endif 

} 

//#endif 


//#if -1424499050 
return false;
//#endif 

} 

//#endif 


//#if -1669806019 
public void addNotationProvider(int type,
                                    NotationName notationName, Class provider)
    { 

//#if 2059996251 
if(allLanguages.containsKey(notationName))//1
{ 

//#if -698280514 
Map<Integer, Class> t = allLanguages.get(notationName);
//#endif 


//#if 250161421 
t.put(Integer.valueOf(type), provider);
//#endif 

} 
else
{ 

//#if -784110339 
Map<Integer, Class> t = new HashMap<Integer, Class>();
//#endif 


//#if -2006577173 
t.put(Integer.valueOf(type), provider);
//#endif 


//#if -84509780 
allLanguages.put(notationName, t);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

