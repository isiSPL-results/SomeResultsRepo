
//#if -323702198 
// Compilation Unit of /ItemUID.java 
 

//#if -183364556 
package org.argouml.util;
//#endif 


//#if 665418453 
import java.lang.reflect.InvocationTargetException;
//#endif 


//#if -500732782 
import java.lang.reflect.Method;
//#endif 


//#if 263827716 
import org.apache.log4j.Logger;
//#endif 


//#if 2111364215 
import org.argouml.model.Model;
//#endif 


//#if 1074722348 
public class ItemUID  { 

//#if 854823939 
private static final Logger LOG = Logger.getLogger(ItemUID.class);
//#endif 


//#if 399672693 
private static final Class MYCLASS = (new ItemUID()).getClass();
//#endif 


//#if -151356248 
private String id;
//#endif 


//#if -1721315619 
public ItemUID(String param)
    { 

//#if 628361302 
id = param;
//#endif 

} 

//#endif 


//#if 1802521593 
public ItemUID()
    { 

//#if -417021050 
id = generateID();
//#endif 

} 

//#endif 


//#if 1381087459 
public String toString()
    { 

//#if -334810041 
return id;
//#endif 

} 

//#endif 


//#if 1939080312 
protected static String readObjectID(Object obj)
    { 

//#if 1817810337 
if(Model.getFacade().isAUMLElement(obj))//1
{ 

//#if 293015622 
return Model.getFacade().getUUID(obj);
//#endif 

} 

//#endif 


//#if 1931950947 
if(obj instanceof IItemUID)//1
{ 

//#if -614983869 
final ItemUID itemUid = ((IItemUID) obj).getItemUID();
//#endif 


//#if -1873970702 
return (itemUid == null ? null : itemUid.toString());
//#endif 

} 

//#endif 


//#if 1406615433 
Object rv;
//#endif 


//#if 695184261 
try //1
{ 

//#if -1168486222 
Method m = obj.getClass().getMethod("getItemUID", (Class[]) null);
//#endif 


//#if 1259400483 
rv = m.invoke(obj, (Object[]) null);
//#endif 

} 

//#if 988836620 
catch (NoSuchMethodException nsme) //1
{ 

//#if -1585339392 
try //1
{ 

//#if -651035026 
Method m = obj.getClass().getMethod("getUUID", (Class[]) null);
//#endif 


//#if 1540883823 
rv = m.invoke(obj, (Object[]) null);
//#endif 


//#if -1150802356 
return (String) rv;
//#endif 

} 

//#if -263743259 
catch (NoSuchMethodException nsme2) //1
{ 

//#if 1836779254 
return null;
//#endif 

} 

//#endif 


//#if -99900387 
catch (IllegalArgumentException iare) //1
{ 

//#if 1266268540 
LOG.error("getUUID for " + obj.getClass()
                          + " takes strange parameter: ",
                          iare);
//#endif 


//#if 501777774 
return null;
//#endif 

} 

//#endif 


//#if -1831850747 
catch (IllegalAccessException iace) //1
{ 

//#if 140973217 
return null;
//#endif 

} 

//#endif 


//#if -1069860648 
catch (InvocationTargetException tie) //1
{ 

//#if -1074850491 
LOG.error("getUUID for " + obj.getClass() + " threw: ",
                          tie);
//#endif 


//#if 735099427 
return null;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -2017697398 
catch (SecurityException se) //1
{ 

//#if -99913273 
return null;
//#endif 

} 

//#endif 


//#if 1756182377 
catch (InvocationTargetException tie) //1
{ 

//#if 25593934 
LOG.error("getItemUID for " + obj.getClass() + " threw: ",
                      tie);
//#endif 


//#if 2011971240 
return null;
//#endif 

} 

//#endif 


//#if -970810410 
catch (IllegalAccessException iace) //1
{ 

//#if 1488582441 
return null;
//#endif 

} 

//#endif 


//#if -1568824658 
catch (IllegalArgumentException iare) //1
{ 

//#if -1178873794 
LOG.error("getItemUID for " + obj.getClass()
                      + " takes strange parameter: ",
                      iare);
//#endif 


//#if 1468931250 
return null;
//#endif 

} 

//#endif 


//#if 1762196995 
catch (ExceptionInInitializerError eiie) //1
{ 

//#if -1611869418 
LOG.error("getItemUID for " + obj.getClass()
                      + " exception: ",
                      eiie);
//#endif 


//#if -1114079015 
return null;
//#endif 

} 

//#endif 


//#endif 


//#if -1227422033 
if(rv == null)//1
{ 

//#if -43551083 
return null;
//#endif 

} 

//#endif 


//#if -1151211001 
if(!(rv instanceof ItemUID))//1
{ 

//#if -777528931 
LOG.error("getItemUID for " + obj.getClass()
                      + " returns strange value: " + rv.getClass());
//#endif 


//#if 945483377 
return null;
//#endif 

} 

//#endif 


//#if -637450109 
return rv.toString();
//#endif 

} 

//#endif 


//#if -882308052 
public static String getIDOfObject(Object obj, boolean canCreate)
    { 

//#if -832376960 
String s = readObjectID(obj);
//#endif 


//#if -689635727 
if(s == null && canCreate)//1
{ 

//#if 971218282 
s = createObjectID(obj);
//#endif 

} 

//#endif 


//#if 780156140 
return s;
//#endif 

} 

//#endif 


//#if 1518000018 
protected static String createObjectID(Object obj)
    { 

//#if -601433883 
if(Model.getFacade().isAUMLElement(obj))//1
{ 

//#if -1292207252 
return null;
//#endif 

} 

//#endif 


//#if 1091328159 
if(obj instanceof IItemUID)//1
{ 

//#if 1540996378 
ItemUID uid = new ItemUID();
//#endif 


//#if 1195654851 
((IItemUID) obj).setItemUID(uid);
//#endif 


//#if 1943140953 
return uid.toString();
//#endif 

} 

//#endif 


//#if 309435508 
Class[] params = new Class[1];
//#endif 


//#if -985073873 
Object[] mparam;
//#endif 


//#if 1577261589 
params[0] = MYCLASS;
//#endif 


//#if 1134976449 
try //1
{ 

//#if -1799125647 
Method m = obj.getClass().getMethod("setItemUID", params);
//#endif 


//#if -464443172 
mparam = new Object[1];
//#endif 


//#if -544879774 
mparam[0] = new ItemUID();
//#endif 


//#if 1651431408 
m.invoke(obj, mparam);
//#endif 

} 

//#if 2069789724 
catch (NoSuchMethodException nsme) //1
{ 

//#if 992748576 
return null;
//#endif 

} 

//#endif 


//#if 292189850 
catch (SecurityException se) //1
{ 

//#if -782111071 
return null;
//#endif 

} 

//#endif 


//#if 765318233 
catch (InvocationTargetException tie) //1
{ 

//#if 835613543 
LOG.error("setItemUID for " + obj.getClass() + " threw",
                      tie);
//#endif 


//#if -1057375787 
return null;
//#endif 

} 

//#endif 


//#if -1821002554 
catch (IllegalAccessException iace) //1
{ 

//#if -2008325043 
return null;
//#endif 

} 

//#endif 


//#if 1735278494 
catch (IllegalArgumentException iare) //1
{ 

//#if -1482020722 
LOG.error("setItemUID for " + obj.getClass()
                      + " takes strange parameter",
                      iare);
//#endif 


//#if 489767266 
return null;
//#endif 

} 

//#endif 


//#if -2056258797 
catch (ExceptionInInitializerError eiie) //1
{ 

//#if -1372637744 
LOG.error("setItemUID for " + obj.getClass() + " threw",
                      eiie);
//#endif 


//#if 1325875000 
return null;
//#endif 

} 

//#endif 


//#endif 


//#if -922178899 
return mparam[0].toString();
//#endif 

} 

//#endif 


//#if 180016245 
public static String generateID()
    { 

//#if -181321036 
return (new java.rmi.server.UID()).toString();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

