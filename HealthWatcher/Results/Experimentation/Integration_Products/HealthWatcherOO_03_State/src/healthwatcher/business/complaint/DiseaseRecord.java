package healthwatcher.business.complaint;
import healthwatcher.data.IDiseaseRepository;
import healthwatcher.model.complaint.DiseaseType;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.util.IteratorDsk;
public class DiseaseRecord  { 
private IDiseaseRepository diseaseRep;
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

 } 
