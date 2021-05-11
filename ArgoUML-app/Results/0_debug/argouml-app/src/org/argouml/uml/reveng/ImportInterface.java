
//#if -1316411010 
// Compilation Unit of /ImportInterface.java 
 

//#if 1717015730 
package org.argouml.uml.reveng;
//#endif 


//#if -1735763249 
import java.io.File;
//#endif 


//#if -648801079 
import java.util.Collection;
//#endif 


//#if 1556763593 
import java.util.List;
//#endif 


//#if -168466558 
import org.argouml.kernel.Project;
//#endif 


//#if 495612076 
import org.argouml.moduleloader.ModuleInterface;
//#endif 


//#if 940058245 
import org.argouml.taskmgmt.ProgressMonitor;
//#endif 


//#if -1098057929 
import org.argouml.util.SuffixFilter;
//#endif 


//#if 878507699 
public interface ImportInterface extends 
//#if -900356614 
ModuleInterface
//#endif 

  { 

//#if 535767941 
public static final String SOURCE_PATH_TAG = "src_path";
//#endif 


//#if -117573435 
public static final String SOURCE_MODIFIERS_TAG = "src_modifiers";
//#endif 


//#if -2146135275 
Collection parseFiles(Project p, final Collection<File> files,
                          ImportSettings settings, ProgressMonitor monitor)
    throws ImportException;
//#endif 


//#if -294770290 
List<SettingsTypes.Setting> getImportSettings();
//#endif 


//#if 2049564691 
SuffixFilter[] getSuffixFilters();
//#endif 


//#if -554045513 
boolean isParseable(File file);
//#endif 


//#if 991331694 
public class ImportException extends 
//#if -1455133538 
Exception
//#endif 

  { 

//#if 211295723 
public ImportException(String message)
        { 

//#if -485546334 
super(message);
//#endif 

} 

//#endif 


//#if 524698194 
public ImportException(String message, Throwable cause)
        { 

//#if -1210861759 
super("Import Exception : " + message, cause);
//#endif 

} 

//#endif 


//#if 1924554568 
public ImportException(Throwable cause)
        { 

//#if 1552645355 
super("Import Exception", cause);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

