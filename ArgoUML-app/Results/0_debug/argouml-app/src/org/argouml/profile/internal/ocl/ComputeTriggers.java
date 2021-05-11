
//#if -189262941 
// Compilation Unit of /ComputeTriggers.java 
 

//#if -963841031 
package org.argouml.profile.internal.ocl;
//#endif 


//#if -976795050 
import java.util.ArrayList;
//#endif 


//#if 1726631499 
import java.util.List;
//#endif 


//#if -300485406 
import tudresden.ocl.parser.analysis.DepthFirstAdapter;
//#endif 


//#if 1596991595 
import tudresden.ocl.parser.node.AClassifierContext;
//#endif 


//#if 607234896 
public class ComputeTriggers extends 
//#if -777890493 
DepthFirstAdapter
//#endif 

  { 

//#if -315439504 
private List<String> triggs = new ArrayList<String>();
//#endif 


//#if -640242789 
public List<String> getTriggers()
    { 

//#if -956729774 
return triggs;
//#endif 

} 

//#endif 


//#if -1583740679 
@Override
    public void caseAClassifierContext(AClassifierContext node)
    { 

//#if -498237049 
String str = "" + node.getPathTypeName();
//#endif 


//#if -1748591367 
triggs.add(str.trim().toLowerCase());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

