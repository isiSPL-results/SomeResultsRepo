// Compilation Unit of /OCLUtil.java 
 
package org.argouml.ocl;
import java.util.Collection;
import java.util.Iterator;
import org.argouml.model.Model;
public final class OCLUtil  { 
public static Object getInnerMostEnclosingNamespace (Object me)
    { 
if(Model.getFacade().isAFeature(me))//1
{ 
me = Model.getFacade().getOwner(me);
} 

if(!Model.getFacade().isANamespace(me))//1
{ 
throw new IllegalArgumentException();
} 

return me;
} 

public static String getContextString (final Object me)
    { 
if(me == null || !(Model.getFacade().isAModelElement(me)))//1
{ 
return "";
} 

Object mnsContext =
            getInnerMostEnclosingNamespace (me);
if(Model.getFacade().isABehavioralFeature(me))//1
{ 
StringBuffer sbContext = new StringBuffer ("context ");
sbContext.append (Model.getFacade().getName(mnsContext));
sbContext.append ("::");
sbContext.append (Model.getFacade().getName(me));
sbContext.append (" (");
Collection lParams = Model.getFacade().getParameters(me);
String sReturnType = null;
boolean fFirstParam = true;
for (Iterator i = lParams.iterator(); i.hasNext();) //1
{ 
Object mp = i.next();
if(Model.getFacade().isReturn(mp))//1
{ 
sReturnType = Model.getFacade().getName(
                                      Model.getFacade().getType(mp));
} 
else
{ 
if(fFirstParam)//1
{ 
fFirstParam = false;
} 
else
{ 
sbContext.append ("; ");
} 

sbContext.append(
                        Model.getFacade().getType(mp)).append(": ");
sbContext.append(Model.getFacade().getName(
                                         Model.getFacade().getType(mp)));
} 

} 

sbContext.append (")");
if(sReturnType != null && !sReturnType.equalsIgnoreCase("void"))//1
{ 
sbContext.append (": ").append (sReturnType);
} 

return sbContext.toString();
} 
else
{ 
return "context " + Model.getFacade().getName(mnsContext);
} 

} 

private OCLUtil () { 
} 

 } 


