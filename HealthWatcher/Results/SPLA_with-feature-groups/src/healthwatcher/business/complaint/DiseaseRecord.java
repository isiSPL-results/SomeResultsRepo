// Compilation Unit of /DiseaseRecord.java 
 
package healthwatcher.business.complaint;
import healthwatcher.data.IDiseaseRepository;
import healthwatcher.model.complaint.DiseaseType;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.util.IteratorDsk;

//#if -1244817252 
import lib.concurrency.ConcurrencyManager;
//#endif 


//#if 1597337440 
import lib.exceptions.ExceptionMessages;
//#endif 


//#if -174934403 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 266494900 
import lib.exceptions.ObjectNotValidException;
//#endif 

public class DiseaseRecord  { 
private IDiseaseRepository diseaseRep;

//#if -303130765 
private ConcurrencyManager manager = new ConcurrencyManager();
//#endif 

public DiseaseType search(int codigo) throws RepositoryException, ObjectNotFoundException
    { 
return diseaseRep.search(codigo);
} 

public DiseaseRecord(IDiseaseRepository repTipoDoenca)
    { 
this.diseaseRep = repTipoDoenca;
} 

public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException
    { 
return diseaseRep.getDiseaseTypeList();
} 


//#if -1783298018 
public void insert(DiseaseType diseaseType) throws RepositoryException, ObjectAlreadyInsertedException,
               ObjectNotValidException
    { 
try //1
{ 
manager.beginExecution("" + diseaseType.getCode());
if(diseaseRep.exists(diseaseType.getCode()))//1
{ 
throw new ObjectAlreadyInsertedException(ExceptionMessages.EXC_JA_EXISTE);
} 
else
{ 
this.diseaseRep.insert(diseaseType);
} 

} 
finally { 
manager.endExecution("" + diseaseType.getCode());
} 

} 

//#endif 

 } 


