
//#if 1779273758 
// Compilation Unit of /GenAncestorClasses.java 
 

//#if 609638870 
package org.argouml.uml;
//#endif 


//#if 1057181508 
import java.util.Collection;
//#endif 


//#if -1587109825 
import java.util.Collections;
//#endif 


//#if 1080578509 
import java.util.Enumeration;
//#endif 


//#if -1155447360 
import java.util.HashSet;
//#endif 


//#if -1093473262 
import java.util.Set;
//#endif 


//#if -184626643 
import org.argouml.model.Model;
//#endif 


//#if -252058273 
import org.tigris.gef.util.ChildGenerator;
//#endif 


//#if -772990050 
public class GenAncestorClasses implements 
//#if 1860699959 
ChildGenerator
//#endif 

  { 

//#if 1233152660 
public Enumeration gen(Object cls)
    { 

//#if -1466711139 
Set res = new HashSet();
//#endif 


//#if -1029808602 
if(Model.getFacade().isAGeneralizableElement(cls))//1
{ 

//#if -981031932 
accumulateAncestors(cls, res);
//#endif 

} 

//#endif 


//#if 1566682514 
return Collections.enumeration(res);
//#endif 

} 

//#endif 


//#if 809404214 
public void accumulateAncestors(Object cls, Collection accum)
    { 

//#if -860443093 
Collection gens = Model.getFacade().getGeneralizations(cls);
//#endif 


//#if -1516220427 
if(gens == null)//1
{ 

//#if -1500211626 
return;
//#endif 

} 

//#endif 


//#if 1882110724 
for (Object g : gens) //1
{ 

//#if -1332466061 
Object ge = Model.getFacade().getGeneral(g);
//#endif 


//#if -1407890457 
if(!accum.contains(ge))//1
{ 

//#if 1599780569 
accum.add(ge);
//#endif 


//#if -1950206510 
accumulateAncestors(cls, accum);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

