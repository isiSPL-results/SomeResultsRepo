
//#if -2057137303 
// Compilation Unit of /ProgressEvent.java 
 

//#if 48250528 
package org.argouml.taskmgmt;
//#endif 


//#if 1350594517 
import java.util.EventObject;
//#endif 


//#if -1211448756 
public class ProgressEvent extends 
//#if 256272907 
EventObject
//#endif 

  { 

//#if -1113003324 
private long length;
//#endif 


//#if 1658905889 
private long position;
//#endif 


//#if 1594439055 
private static final long serialVersionUID = -440923505939663713L;
//#endif 


//#if -180502980 
public ProgressEvent(Object source, long thePosition, long theLength)
    { 

//#if 1061937826 
super(source);
//#endif 


//#if -1094933645 
this.length = theLength;
//#endif 


//#if 1258374829 
this.position = thePosition;
//#endif 

} 

//#endif 


//#if -1735384182 
public long getLength()
    { 

//#if -457357859 
return length;
//#endif 

} 

//#endif 


//#if -1035386803 
public long getPosition()
    { 

//#if -533034120 
return position;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

