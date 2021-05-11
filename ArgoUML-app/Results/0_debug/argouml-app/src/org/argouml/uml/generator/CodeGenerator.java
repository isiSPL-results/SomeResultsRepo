
//#if 461526039 
// Compilation Unit of /CodeGenerator.java 
 

//#if 1620031801 
package org.argouml.uml.generator;
//#endif 


//#if 2014848044 
import java.util.Collection;
//#endif 


//#if 85603266 
public interface CodeGenerator  { 

//#if 1763245639 
String FILE_SEPARATOR = System.getProperty("file.separator");
//#endif 


//#if -931566920 
Collection<SourceUnit> generate(Collection elements, boolean deps);
//#endif 


//#if -1917085625 
Collection<String> generateFiles(Collection elements, String path,
                                     boolean deps);
//#endif 


//#if 514894208 
Collection<String> generateFileList(Collection elements, boolean deps);
//#endif 

 } 

//#endif 


//#endif 

