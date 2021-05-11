
//#if 632118412 
// Compilation Unit of /ProgressMonitor.java 
 

//#if -1349693980 
package org.argouml.taskmgmt;
//#endif 


//#if -852351633 
public interface ProgressMonitor extends 
//#if -2126669744 
ProgressListener
//#endif 

  { 

//#if -491167172 
void updateProgress(int progress);
//#endif 


//#if 624557327 
void updateMainTask(String name);
//#endif 


//#if 503350925 
public void close();
//#endif 


//#if -366179266 
void updateSubTask(String name);
//#endif 


//#if 1606944698 
void setMaximumProgress(int max);
//#endif 


//#if 1986765258 
void notifyNullAction();
//#endif 


//#if 2029185981 
boolean isCanceled();
//#endif 


//#if -624180670 
void notifyMessage(String title, String introduction, String message);
//#endif 

 } 

//#endif 


//#endif 

