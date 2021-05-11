// Compilation Unit of /ImporterManager.java 
 
package org.argouml.uml.reveng;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
public final class ImporterManager  { 
private static final Logger LOG =
        Logger.getLogger(ImporterManager.class);
private static final ImporterManager INSTANCE =
        new ImporterManager();
private Set<ImportInterface> importers = new HashSet<ImportInterface>();
public boolean removeImporter(ImportInterface importer)
    { 
boolean status = importers.remove(importer);
LOG.debug("Removed importer " + importer );
return status;
} 

public void addImporter(ImportInterface importer)
    { 
importers.add(importer);
LOG.debug("Added importer " + importer );
} 

private ImporterManager()
    { 
} 

public static ImporterManager getInstance()
    { 
return INSTANCE;
} 

public Set<ImportInterface> getImporters()
    { 
return Collections.unmodifiableSet(importers);
} 

public boolean hasImporters()
    { 
return !importers.isEmpty();
} 

 } 


