package org.argouml.uml.diagram;
import org.argouml.kernel.Project;
import org.argouml.kernel.AbstractProjectMember;
import org.tigris.gef.util.Util;
public class ProjectMemberDiagram extends AbstractProjectMember
  { 
private static final String MEMBER_TYPE = "pgml";
private static final String FILE_EXT = ".pgml";
private ArgoDiagram diagram;
public String getType()
    { 
return MEMBER_TYPE;
} 
public ArgoDiagram getDiagram()
    { 
return diagram;
} 
public String repair()
    { 
return diagram.repair();
} 
protected void setDiagram(ArgoDiagram d)
    { 
diagram = d;
} 
@Override
    public String getZipFileExtension()
    { 
return FILE_EXT;
} 
public ProjectMemberDiagram(ArgoDiagram d, Project p)
    { 
super(Util.stripJunk(d.getName()), p);
setDiagram(d);
} 

 } 
