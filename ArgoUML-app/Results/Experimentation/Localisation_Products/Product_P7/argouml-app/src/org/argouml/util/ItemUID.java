package org.argouml.util;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.argouml.model.Model;
public class ItemUID  { 
private static final Logger LOG = Logger.getLogger(ItemUID.class);
private static final Class MYCLASS = (new ItemUID()).getClass();
private String id;
public ItemUID(String param)
    { 
id = param;
} 
public ItemUID()
    { 
id = generateID();
} 
public String toString()
    { 
return id;
} 
protected static String readObjectID(Object obj)
    { 
if(Model.getFacade().isAUMLElement(obj))//1
{ 
return Model.getFacade().getUUID(obj);
} 
if(obj instanceof IItemUID)//1
{ 
final ItemUID itemUid = ((IItemUID) obj).getItemUID();
return (itemUid == null ? null : itemUid.toString());
} 
Object rv;
try//1
{ 
Method m = obj.getClass().getMethod("getItemUID", (Class[]) null);
rv = m.invoke(obj, (Object[]) null);
} 
catch (NoSuchMethodException nsme) //1
{ 
try//1
{ 
Method m = obj.getClass().getMethod("getUUID", (Class[]) null);
rv = m.invoke(obj, (Object[]) null);
return (String) rv;
} 
catch (NoSuchMethodException nsme2) //1
{ 
return null;
} 
catch (IllegalArgumentException iare) //1
{ 
LOG.error("getUUID for " + obj.getClass()
                          + " takes strange parameter: ",
                          iare);
return null;
} 
catch (IllegalAccessException iace) //1
{ 
return null;
} 
catch (InvocationTargetException tie) //1
{ 
LOG.error("getUUID for " + obj.getClass() + " threw: ",
                          tie);
return null;
} 
} 
catch (SecurityException se) //1
{ 
return null;
} 
catch (InvocationTargetException tie) //1
{ 
LOG.error("getItemUID for " + obj.getClass() + " threw: ",
                      tie);
return null;
} 
catch (IllegalAccessException iace) //1
{ 
return null;
} 
catch (IllegalArgumentException iare) //1
{ 
LOG.error("getItemUID for " + obj.getClass()
                      + " takes strange parameter: ",
                      iare);
return null;
} 
catch (ExceptionInInitializerError eiie) //1
{ 
LOG.error("getItemUID for " + obj.getClass()
                      + " exception: ",
                      eiie);
return null;
} 
if(rv == null)//1
{ 
return null;
} 
if(!(rv instanceof ItemUID))//1
{ 
LOG.error("getItemUID for " + obj.getClass()
                      + " returns strange value: " + rv.getClass());
return null;
} 
return rv.toString();
} 
public static String getIDOfObject(Object obj, boolean canCreate)
    { 
String s = readObjectID(obj);
if(s == null && canCreate)//1
{ 
s = createObjectID(obj);
} 
return s;
} 
protected static String createObjectID(Object obj)
    { 
if(Model.getFacade().isAUMLElement(obj))//1
{ 
return null;
} 
if(obj instanceof IItemUID)//1
{ 
ItemUID uid = new ItemUID();
((IItemUID) obj).setItemUID(uid);
return uid.toString();
} 
Class[] params = new Class[1];
Object[] mparam;
params[0] = MYCLASS;
try//1
{ 
Method m = obj.getClass().getMethod("setItemUID", params);
mparam = new Object[1];
mparam[0] = new ItemUID();
m.invoke(obj, mparam);
} 
catch (NoSuchMethodException nsme) //1
{ 
return null;
} 
catch (SecurityException se) //1
{ 
return null;
} 
catch (InvocationTargetException tie) //1
{ 
LOG.error("setItemUID for " + obj.getClass() + " threw",
                      tie);
return null;
} 
catch (IllegalAccessException iace) //1
{ 
return null;
} 
catch (IllegalArgumentException iare) //1
{ 
LOG.error("setItemUID for " + obj.getClass()
                      + " takes strange parameter",
                      iare);
return null;
} 
catch (ExceptionInInitializerError eiie) //1
{ 
LOG.error("setItemUID for " + obj.getClass() + " threw",
                      eiie);
return null;
} 
return mparam[0].toString();
} 
public static String generateID()
    { 
return (new java.rmi.server.UID()).toString();
} 

 } 
