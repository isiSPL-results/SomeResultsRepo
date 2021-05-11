package org.argouml.profile.internal.ocl;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import org.argouml.model.MetaTypes;
import org.argouml.model.Model;
import tudresden.ocl.parser.analysis.DepthFirstAdapter;
import tudresden.ocl.parser.node.AClassifierContext;
import org.apache.log4j.Logger;
public class ComputeDesignMaterials extends DepthFirstAdapter
  { 
private Set<Object> dms = new HashSet<Object>();
private static final Logger LOG =
        Logger.getLogger(ComputeDesignMaterials.class);
public Set<Object> getCriticizedDesignMaterials()
    { 
return dms;
} 
@Override
    public void caseAClassifierContext(AClassifierContext node)
    { 
String str = ("" + node.getPathTypeName()).trim();
if(str.equals("Class"))//1
{ 
dms.add(Model.getMetaTypes().getUMLClass());
} 
else
{ 
try//1
{ 
Method m = MetaTypes.class.getDeclaredMethod("get" + str,
                           new Class[0]);
if(m != null)//1
{ 
dms.add(m.invoke(Model.getMetaTypes(), new Object[0]));
} 
} 
catch (Exception e) //1
{ 
LOG.error("Metaclass not found: " + str, e);
} 
} 
} 

 } 
