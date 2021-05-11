// Compilation Unit of /ProjectFactory.java 
 
package org.argouml.kernel;
import java.net.URI;
public class ProjectFactory  { 
private static final ProjectFactory INSTANCE = new ProjectFactory();
private ProjectFactory()
    { 
super();
} 

public Project createProject()
    { 
return new ProjectImpl();
} 

public static ProjectFactory getInstance()
    { 
return INSTANCE;
} 

public Project createProject(URI uri)
    { 
return new ProjectImpl(uri);
} 

 } 


