
//#if -1553940889 
// Compilation Unit of /OCLUtil.java 
 

//#if -773874253 
package org.argouml.ocl;
//#endif 


//#if 1017297509 
import java.util.Collection;
//#endif 


//#if -1688650603 
import java.util.Iterator;
//#endif 


//#if 1337100140 
import org.argouml.model.Model;
//#endif 


//#if -2063084132 
public final class OCLUtil  { 

//#if 296265886 
public static Object getInnerMostEnclosingNamespace (Object me)
    { 

//#if -455982393 
if(Model.getFacade().isAFeature(me))//1
{ 

//#if 1112914462 
me = Model.getFacade().getOwner(me);
//#endif 

} 

//#endif 


//#if 1174771011 
if(!Model.getFacade().isANamespace(me))//1
{ 

//#if 515538042 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if -1204643715 
return me;
//#endif 

} 

//#endif 


//#if 1016342982 
public static String getContextString (final Object me)
    { 

//#if 813102479 
if(me == null || !(Model.getFacade().isAModelElement(me)))//1
{ 

//#if -571902835 
return "";
//#endif 

} 

//#endif 


//#if 1704107905 
Object mnsContext =
            getInnerMostEnclosingNamespace (me);
//#endif 


//#if -918445538 
if(Model.getFacade().isABehavioralFeature(me))//1
{ 

//#if 81550772 
StringBuffer sbContext = new StringBuffer ("context ");
//#endif 


//#if 242820547 
sbContext.append (Model.getFacade().getName(mnsContext));
//#endif 


//#if 568241572 
sbContext.append ("::");
//#endif 


//#if 335335848 
sbContext.append (Model.getFacade().getName(me));
//#endif 


//#if -397870692 
sbContext.append (" (");
//#endif 


//#if 2034835531 
Collection lParams = Model.getFacade().getParameters(me);
//#endif 


//#if -54672587 
String sReturnType = null;
//#endif 


//#if 773725625 
boolean fFirstParam = true;
//#endif 


//#if -2049918885 
for (Iterator i = lParams.iterator(); i.hasNext();) //1
{ 

//#if 1959482737 
Object mp = i.next();
//#endif 


//#if -1607811549 
if(Model.getFacade().isReturn(mp))//1
{ 

//#if 930890511 
sReturnType = Model.getFacade().getName(
                                      Model.getFacade().getType(mp));
//#endif 

} 
else
{ 

//#if 50838807 
if(fFirstParam)//1
{ 

//#if 1328702344 
fFirstParam = false;
//#endif 

} 
else
{ 

//#if -2146748612 
sbContext.append ("; ");
//#endif 

} 

//#endif 


//#if 326145814 
sbContext.append(
                        Model.getFacade().getType(mp)).append(": ");
//#endif 


//#if -1366154751 
sbContext.append(Model.getFacade().getName(
                                         Model.getFacade().getType(mp)));
//#endif 

} 

//#endif 

} 

//#endif 


//#if -397840901 
sbContext.append (")");
//#endif 


//#if -1242903699 
if(sReturnType != null && !sReturnType.equalsIgnoreCase("void"))//1
{ 

//#if 1041105754 
sbContext.append (": ").append (sReturnType);
//#endif 

} 

//#endif 


//#if 271597282 
return sbContext.toString();
//#endif 

} 
else
{ 

//#if -1555795982 
return "context " + Model.getFacade().getName(mnsContext);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1072922044 
private OCLUtil () { 
} 

//#endif 

 } 

//#endif 


//#endif 

