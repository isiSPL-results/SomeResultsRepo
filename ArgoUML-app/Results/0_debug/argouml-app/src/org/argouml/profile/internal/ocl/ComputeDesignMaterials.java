
//#if 1597604711 
// Compilation Unit of /ComputeDesignMaterials.java 
 

//#if -982497493 
package org.argouml.profile.internal.ocl;
//#endif 


//#if 1206768945 
import java.lang.reflect.Method;
//#endif 


//#if -744633397 
import java.util.HashSet;
//#endif 


//#if -821940323 
import java.util.Set;
//#endif 


//#if 1528301581 
import org.argouml.model.MetaTypes;
//#endif 


//#if -1989975048 
import org.argouml.model.Model;
//#endif 


//#if 1409796244 
import tudresden.ocl.parser.analysis.DepthFirstAdapter;
//#endif 


//#if 1572684281 
import tudresden.ocl.parser.node.AClassifierContext;
//#endif 


//#if 457455749 
import org.apache.log4j.Logger;
//#endif 


//#if 434596327 
public class ComputeDesignMaterials extends 
//#if 606406119 
DepthFirstAdapter
//#endif 

  { 

//#if 1384341235 
private Set<Object> dms = new HashSet<Object>();
//#endif 


//#if 1670314954 
private static final Logger LOG =
        Logger.getLogger(ComputeDesignMaterials.class);
//#endif 


//#if 1417146198 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if -205526935 
return dms;
//#endif 

} 

//#endif 


//#if 1982030237 
@Override
    public void caseAClassifierContext(AClassifierContext node)
    { 

//#if 300784373 
String str = ("" + node.getPathTypeName()).trim();
//#endif 


//#if -1744723153 
if(str.equals("Class"))//1
{ 

//#if -318792281 
dms.add(Model.getMetaTypes().getUMLClass());
//#endif 

} 
else
{ 

//#if 934616514 
try //1
{ 

//#if 1706042670 
Method m = MetaTypes.class.getDeclaredMethod("get" + str,
                           new Class[0]);
//#endif 


//#if 1789669649 
if(m != null)//1
{ 

//#if -753477661 
dms.add(m.invoke(Model.getMetaTypes(), new Object[0]));
//#endif 

} 

//#endif 

} 

//#if -1987777438 
catch (Exception e) //1
{ 

//#if -1351389264 
LOG.error("Metaclass not found: " + str, e);
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


//#endif 

