
//#if -431318173 
// Compilation Unit of /ContextApplicable.java 
 

//#if 1134960452 
package org.argouml.profile.internal.ocl;
//#endif 


//#if 210425681 
import org.argouml.model.Model;
//#endif 


//#if 965804269 
import tudresden.ocl.parser.analysis.DepthFirstAdapter;
//#endif 


//#if 4821056 
import tudresden.ocl.parser.node.AClassifierContext;
//#endif 


//#if -1344445226 
import tudresden.ocl.parser.node.APostStereotype;
//#endif 


//#if -1865842503 
import tudresden.ocl.parser.node.APreStereotype;
//#endif 


//#if -1637110818 
import org.apache.log4j.Logger;
//#endif 


//#if -1374451913 
public class ContextApplicable extends 
//#if 1793274923 
DepthFirstAdapter
//#endif 

  { 

//#if -1276796629 
private boolean applicable = true;
//#endif 


//#if 945380957 
private Object modelElement;
//#endif 


//#if -1833819121 
private static final Logger LOG = Logger.getLogger(ContextApplicable.class);
//#endif 


//#if 1553559942 
public ContextApplicable(Object element)
    { 

//#if -2079738497 
this.modelElement = element;
//#endif 

} 

//#endif 


//#if -2097205800 
public void inAPreStereotype(APreStereotype node)
    { 

//#if 1989938743 
applicable = false;
//#endif 

} 

//#endif 


//#if -488279294 
public void inAPostStereotype(APostStereotype node)
    { 

//#if 674018251 
applicable = false;
//#endif 

} 

//#endif 


//#if -315183438 
public boolean isApplicable()
    { 

//#if 990407204 
return applicable;
//#endif 

} 

//#endif 


//#if -173887805 
public void caseAClassifierContext(AClassifierContext node)
    { 

//#if 1023332868 
String metaclass = ("" + node.getPathTypeName()).trim();
//#endif 


//#if -2034015933 
applicable &= Model.getFacade().isA(metaclass, modelElement);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

