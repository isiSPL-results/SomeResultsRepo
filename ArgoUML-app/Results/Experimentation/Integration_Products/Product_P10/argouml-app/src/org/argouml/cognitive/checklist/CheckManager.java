package org.argouml.cognitive.checklist;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Enumeration;
public class CheckManager implements Serializable
  { 
private static Hashtable lists = new Hashtable();
private static Hashtable statuses = new Hashtable();
public static void register(Object dm, Checklist cl)
    { 
lists.put(dm, cl);
} 
private static Checklist lookupChecklist(Class cls)
    { 
if(lists.contains(cls))//1
{ 
return (Checklist) lists.get(cls);
} 
Enumeration enumeration = lists.keys();
while (enumeration.hasMoreElements()) //1
{ 
Object clazz = enumeration.nextElement();
Class[] intfs = cls.getInterfaces();
for (int i = 0; i < intfs.length; i++) //1
{ 
if(intfs[i].equals(clazz))//1
{ 
Checklist chlist = (Checklist) lists.get(clazz);
lists.put(cls, chlist);
return chlist;
} 
} 
} 
return null;
} 
public CheckManager() { 
} 
public static Checklist getChecklistFor(Object dm)
    { 
Checklist cl;
java.lang.Class cls = dm.getClass();
while (cls != null) //1
{ 
cl = lookupChecklist(cls);
if(cl != null)//1
{ 
return cl;
} 
cls = cls.getSuperclass();
} 
return null;
} 
public static ChecklistStatus getStatusFor(Object dm)
    { 
ChecklistStatus cls = (ChecklistStatus) statuses.get(dm);
if(cls == null)//1
{ 
cls = new ChecklistStatus();
statuses.put(dm, cls);
} 
return cls;
} 

 } 
