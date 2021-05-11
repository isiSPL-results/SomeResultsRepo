
//#if -1697857489 
// Compilation Unit of /ImporterManager.java 
 

//#if 664102286 
package org.argouml.uml.reveng;
//#endif 


//#if 2116215606 
import java.util.Collections;
//#endif 


//#if -1972659145 
import java.util.HashSet;
//#endif 


//#if 1707152905 
import java.util.Set;
//#endif 


//#if 630654961 
import org.apache.log4j.Logger;
//#endif 


//#if 2030414245 
public final class ImporterManager  { 

//#if -958404932 
private static final Logger LOG =
        Logger.getLogger(ImporterManager.class);
//#endif 


//#if 1503356182 
private static final ImporterManager INSTANCE =
        new ImporterManager();
//#endif 


//#if -1572536492 
private Set<ImportInterface> importers = new HashSet<ImportInterface>();
//#endif 


//#if 1115206253 
public boolean removeImporter(ImportInterface importer)
    { 

//#if -6716274 
boolean status = importers.remove(importer);
//#endif 


//#if 2003590982 
LOG.debug("Removed importer " + importer );
//#endif 


//#if 1468905039 
return status;
//#endif 

} 

//#endif 


//#if 1608870572 
public void addImporter(ImportInterface importer)
    { 

//#if -2101415063 
importers.add(importer);
//#endif 


//#if -553784659 
LOG.debug("Added importer " + importer );
//#endif 

} 

//#endif 


//#if 614243472 
private ImporterManager()
    { 
} 

//#endif 


//#if -92105473 
public static ImporterManager getInstance()
    { 

//#if -1801205740 
return INSTANCE;
//#endif 

} 

//#endif 


//#if 283241392 
public Set<ImportInterface> getImporters()
    { 

//#if 908570239 
return Collections.unmodifiableSet(importers);
//#endif 

} 

//#endif 


//#if -1209683952 
public boolean hasImporters()
    { 

//#if -50888865 
return !importers.isEmpty();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

