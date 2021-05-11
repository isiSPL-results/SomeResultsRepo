
//#if -713831125 
// Compilation Unit of /ProjectMemberModel.java 
 

//#if -507361216 
package org.argouml.uml;
//#endif 


//#if 1448709871 
import org.argouml.kernel.AbstractProjectMember;
//#endif 


//#if 687606695 
import org.argouml.kernel.Project;
//#endif 


//#if -1272465277 
import org.argouml.model.Model;
//#endif 


//#if 1316820146 
import org.argouml.persistence.PersistenceManager;
//#endif 


//#if 1315964155 
public class ProjectMemberModel extends 
//#if 39520305 
AbstractProjectMember
//#endif 

  { 

//#if 543495039 
private static final String MEMBER_TYPE = "xmi";
//#endif 


//#if 1608152538 
private static final String FILE_EXT = "." + MEMBER_TYPE;
//#endif 


//#if 798401940 
private Object model;
//#endif 


//#if 1298422908 
public Object getModel()
    { 

//#if 1845429453 
return model;
//#endif 

} 

//#endif 


//#if -795099745 
public String getZipFileExtension()
    { 

//#if 2097242808 
return FILE_EXT;
//#endif 

} 

//#endif 


//#if -1501312806 
protected void setModel(Object m)
    { 

//#if 1574716076 
model = m;
//#endif 

} 

//#endif 


//#if 29827159 
public String getType()
    { 

//#if -1846537096 
return MEMBER_TYPE;
//#endif 

} 

//#endif 


//#if 1868921387 
public ProjectMemberModel(Object m, Project p)
    { 

//#if -710090100 
super(PersistenceManager.getInstance().getProjectBaseName(p)
              + FILE_EXT, p);
//#endif 


//#if 1220508892 
if(!Model.getFacade().isAModel(m))//1
{ 

//#if 1741065867 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if -1209792412 
setModel(m);
//#endif 

} 

//#endif 


//#if -1436116760 
public String repair()
    { 

//#if -2125476550 
return "";
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

