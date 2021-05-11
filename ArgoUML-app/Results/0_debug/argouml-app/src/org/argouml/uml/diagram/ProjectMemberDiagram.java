
//#if 2002383386 
// Compilation Unit of /ProjectMemberDiagram.java 
 

//#if -1819843582 
package org.argouml.uml.diagram;
//#endif 


//#if 995834606 
import org.argouml.kernel.Project;
//#endif 


//#if -1965754890 
import org.argouml.kernel.AbstractProjectMember;
//#endif 


//#if 2033628933 
import org.tigris.gef.util.Util;
//#endif 


//#if 1696899884 
public class ProjectMemberDiagram extends 
//#if -587753133 
AbstractProjectMember
//#endif 

  { 

//#if -1908073857 
private static final String MEMBER_TYPE = "pgml";
//#endif 


//#if -715537786 
private static final String FILE_EXT = ".pgml";
//#endif 


//#if 1234902237 
private ArgoDiagram diagram;
//#endif 


//#if -597446279 
public String getType()
    { 

//#if -38942758 
return MEMBER_TYPE;
//#endif 

} 

//#endif 


//#if 1317105105 
public ArgoDiagram getDiagram()
    { 

//#if 925741712 
return diagram;
//#endif 

} 

//#endif 


//#if -347972730 
public String repair()
    { 

//#if -1795306581 
return diagram.repair();
//#endif 

} 

//#endif 


//#if 1957757996 
protected void setDiagram(ArgoDiagram d)
    { 

//#if -1844563762 
diagram = d;
//#endif 

} 

//#endif 


//#if -1471936879 
@Override
    public String getZipFileExtension()
    { 

//#if 1144759782 
return FILE_EXT;
//#endif 

} 

//#endif 


//#if -2119343247 
public ProjectMemberDiagram(ArgoDiagram d, Project p)
    { 

//#if 870251589 
super(Util.stripJunk(d.getName()), p);
//#endif 


//#if 196144328 
setDiagram(d);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

