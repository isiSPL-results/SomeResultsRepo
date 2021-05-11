
//#if -425024792 
// Compilation Unit of /ProjectFactory.java 
 

//#if 1126273923 
package org.argouml.kernel;
//#endif 


//#if 356587359 
import java.net.URI;
//#endif 


//#if -417234248 
public class ProjectFactory  { 

//#if 716095307 
private static final ProjectFactory INSTANCE = new ProjectFactory();
//#endif 


//#if -1110623611 
private ProjectFactory()
    { 

//#if 482366456 
super();
//#endif 

} 

//#endif 


//#if 460893534 
public Project createProject()
    { 

//#if 375310895 
return new ProjectImpl();
//#endif 

} 

//#endif 


//#if -193837548 
public static ProjectFactory getInstance()
    { 

//#if 1851834216 
return INSTANCE;
//#endif 

} 

//#endif 


//#if 1271389438 
public Project createProject(URI uri)
    { 

//#if 1382347474 
return new ProjectImpl(uri);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

