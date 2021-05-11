
//#if -540650255 
// Compilation Unit of /ProjectFilePersister.java 
 

//#if 1869761306 
package org.argouml.persistence;
//#endif 


//#if -885283975 
import java.io.File;
//#endif 


//#if -2139275604 
import org.argouml.kernel.Project;
//#endif 


//#if -1073573703 
import org.argouml.taskmgmt.ProgressListener;
//#endif 


//#if -683656905 
public interface ProjectFilePersister  { 

//#if -260275034 
public void addProgressListener(ProgressListener listener);
//#endif 


//#if 928360777 
Project doLoad(File file) throws OpenException, InterruptedException;
//#endif 


//#if -2071437159 
public void removeProgressListener(ProgressListener listener);
//#endif 


//#if -2038940443 
void save(Project project, File file) throws SaveException,
             InterruptedException;
//#endif 

 } 

//#endif 


//#endif 

