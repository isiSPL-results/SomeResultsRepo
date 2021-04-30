
//#if -1708765029 
// Compilation Unit of /DiseaseRecord.java 
 

//#if -767825178 
package healthwatcher.business.complaint;
//#endif 


//#if 117064905 
import healthwatcher.data.IDiseaseRepository;
//#endif 


//#if -2019151012 
import healthwatcher.model.complaint.DiseaseType;
//#endif 


//#if 1432370106 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if -34387146 
import lib.exceptions.RepositoryException;
//#endif 


//#if 1756687695 
import lib.util.IteratorDsk;
//#endif 


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


//#if 418953754 
public class DiseaseRecord  { 

//#if 764757172 
private IDiseaseRepository diseaseRep;
//#endif 


//#if -303130765 
private ConcurrencyManager manager = new ConcurrencyManager();
//#endif 


//#if -525616225 
public DiseaseType search(int codigo) throws RepositoryException, ObjectNotFoundException
    { 

//#if -1225729496 
return diseaseRep.search(codigo);
//#endif 

} 

//#endif 


//#if 151972001 
public DiseaseRecord(IDiseaseRepository repTipoDoenca)
    { 

//#if -790379981 
this.diseaseRep = repTipoDoenca;
//#endif 

} 

//#endif 


//#if 1062846851 
public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException
    { 

//#if -1104642507 
return diseaseRep.getDiseaseTypeList();
//#endif 

} 

//#endif 


//#if -1783298018 
public void insert(DiseaseType diseaseType) throws RepositoryException, ObjectAlreadyInsertedException,
               ObjectNotValidException
    { 

//#if 711409985 
try //1
{ 

//#if 1662088290 
manager.beginExecution("" + diseaseType.getCode());
//#endif 


//#if -1813242938 
if(diseaseRep.exists(diseaseType.getCode()))//1
{ 

//#if -884388061 
throw new ObjectAlreadyInsertedException(ExceptionMessages.EXC_JA_EXISTE);
//#endif 

} 
else
{ 

//#if -572048926 
this.diseaseRep.insert(diseaseType);
//#endif 

} 

//#endif 

} 
finally { 

//#if 786628884 
manager.endExecution("" + diseaseType.getCode());
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

