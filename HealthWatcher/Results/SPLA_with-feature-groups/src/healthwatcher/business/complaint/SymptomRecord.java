
//#if -37544588 
// Compilation Unit of /SymptomRecord.java 
 
package healthwatcher.business.complaint;

//#if -602308655 
import healthwatcher.data.ISymptomRepository;
//#endif 


//#if 701116350 
import healthwatcher.model.complaint.Symptom;
//#endif 


//#if 998816487 
import lib.concurrency.ConcurrencyManager;
//#endif 


//#if -648370069 
import lib.exceptions.ExceptionMessages;
//#endif 


//#if -168179886 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 1759199365 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 593324159 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if -2085720703 
import lib.exceptions.RepositoryException;
//#endif 


//#if -529064230 
import lib.util.IteratorDsk;
//#endif 

public class SymptomRecord  { 
private ISymptomRepository rep;
private ConcurrencyManager manager = new ConcurrencyManager();
public Symptom search(int code) throws ObjectNotFoundException,	RepositoryException
    { 
return rep.search(code);
} 

public IteratorDsk getSymptomList() throws RepositoryException, ObjectNotFoundException
    { 
return rep.getSymptomList();
} 

public void update(Symptom symptom) throws RepositoryException, ObjectNotFoundException,
        ObjectNotValidException
    { 
rep.update(symptom);
} 

public SymptomRecord(ISymptomRepository rep)
    { 
this.rep = rep;
} 

public void insert(Symptom symptom) throws RepositoryException, ObjectAlreadyInsertedException,
               ObjectNotValidException
    { 
try //1
{ 
manager.beginExecution("" + symptom.getCode());
if(rep.exists(symptom.getCode()))//1
{ 
throw new ObjectAlreadyInsertedException(ExceptionMessages.EXC_JA_EXISTE);
} 
else
{ 
rep.insert(symptom);
} 

} 
finally { 
manager.endExecution("" + symptom.getCode());
} 

} 

 } 


//#endif 

