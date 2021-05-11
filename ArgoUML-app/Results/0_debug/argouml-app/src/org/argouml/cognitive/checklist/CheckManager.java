
//#if -72528236 
// Compilation Unit of /CheckManager.java 
 

//#if -1885504726 
package org.argouml.cognitive.checklist;
//#endif 


//#if 2018292217 
import java.io.Serializable;
//#endif 


//#if 185604066 
import java.util.Hashtable;
//#endif 


//#if 967945275 
import java.util.Enumeration;
//#endif 


//#if -1602534190 
public class CheckManager implements 
//#if 351270821 
Serializable
//#endif 

  { 

//#if 354542749 
private static Hashtable lists = new Hashtable();
//#endif 


//#if 1981455538 
private static Hashtable statuses = new Hashtable();
//#endif 


//#if 2077240266 
public static void register(Object dm, Checklist cl)
    { 

//#if -1189429197 
lists.put(dm, cl);
//#endif 

} 

//#endif 


//#if 243483424 
private static Checklist lookupChecklist(Class cls)
    { 

//#if 1097850406 
if(lists.contains(cls))//1
{ 

//#if -1268678592 
return (Checklist) lists.get(cls);
//#endif 

} 

//#endif 


//#if -1136118838 
Enumeration enumeration = lists.keys();
//#endif 


//#if 1164738103 
while (enumeration.hasMoreElements()) //1
{ 

//#if -336117002 
Object clazz = enumeration.nextElement();
//#endif 


//#if -333933745 
Class[] intfs = cls.getInterfaces();
//#endif 


//#if -682033450 
for (int i = 0; i < intfs.length; i++) //1
{ 

//#if -1762790736 
if(intfs[i].equals(clazz))//1
{ 

//#if -446569910 
Checklist chlist = (Checklist) lists.get(clazz);
//#endif 


//#if 896396587 
lists.put(cls, chlist);
//#endif 


//#if 1075662694 
return chlist;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 751565706 
return null;
//#endif 

} 

//#endif 


//#if 1095579797 
public CheckManager() { 
} 

//#endif 


//#if -271815447 
public static Checklist getChecklistFor(Object dm)
    { 

//#if -1145161796 
Checklist cl;
//#endif 


//#if 546559258 
java.lang.Class cls = dm.getClass();
//#endif 


//#if -1041452370 
while (cls != null) //1
{ 

//#if -1032790117 
cl = lookupChecklist(cls);
//#endif 


//#if 2074099504 
if(cl != null)//1
{ 

//#if 1855056663 
return cl;
//#endif 

} 

//#endif 


//#if 1574884301 
cls = cls.getSuperclass();
//#endif 

} 

//#endif 


//#if -356447148 
return null;
//#endif 

} 

//#endif 


//#if -501640715 
public static ChecklistStatus getStatusFor(Object dm)
    { 

//#if 1172194246 
ChecklistStatus cls = (ChecklistStatus) statuses.get(dm);
//#endif 


//#if 886926677 
if(cls == null)//1
{ 

//#if 1697903096 
cls = new ChecklistStatus();
//#endif 


//#if 1157990921 
statuses.put(dm, cls);
//#endif 

} 

//#endif 


//#if -1822334712 
return cls;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

