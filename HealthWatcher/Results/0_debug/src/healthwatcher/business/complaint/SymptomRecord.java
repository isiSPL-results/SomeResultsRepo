
//#if -37544588 
// Compilation Unit of /SymptomRecord.java 
 

//#if -1665281221 
package healthwatcher.business.complaint;
//#endif 


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


//#if -888360100 
public class SymptomRecord  { 

//#if 2123559068 
private ISymptomRepository rep;
//#endif 


//#if 1544819966 
private ConcurrencyManager manager = new ConcurrencyManager();
//#endif 


//#if -1980409647 
public Symptom search(int code) throws ObjectNotFoundException,	RepositoryException
    { 

//#if 838596046 
return rep.search(code);
//#endif 

} 

//#endif 


//#if -869749979 
public IteratorDsk getSymptomList() throws RepositoryException, ObjectNotFoundException
    { 

//#if 2104804332 
return rep.getSymptomList();
//#endif 

} 

//#endif 


//#if 771370482 
public void update(Symptom symptom) throws RepositoryException, ObjectNotFoundException,
        ObjectNotValidException
    { 

//#if -2092242776 
rep.update(symptom);
//#endif 

} 

//#endif 


//#if 1503457756 
public SymptomRecord(ISymptomRepository rep)
    { 

//#if 1727359785 
this.rep = rep;
//#endif 

} 

//#endif 


//#if -1473358701 
public void insert(Symptom symptom) throws RepositoryException, ObjectAlreadyInsertedException,
               ObjectNotValidException
    { 

//#if 1527749513 
try //1
{ 

//#if 261786304 
manager.beginExecution("" + symptom.getCode());
//#endif 


//#if -235856384 
if(rep.exists(symptom.getCode()))//1
{ 

//#if 1704500637 
throw new ObjectAlreadyInsertedException(ExceptionMessages.EXC_JA_EXISTE);
//#endif 

} 
else
{ 

//#if -929143509 
rep.insert(symptom);
//#endif 

} 

//#endif 

} 
finally { 

//#if -79222990 
manager.endExecution("" + symptom.getCode());
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

