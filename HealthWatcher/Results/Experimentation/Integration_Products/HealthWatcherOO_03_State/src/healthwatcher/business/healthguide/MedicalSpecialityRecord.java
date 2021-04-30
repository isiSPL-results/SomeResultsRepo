package healthwatcher.business.healthguide;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.util.IteratorDsk;
import healthwatcher.data.ISpecialityRepository;
public class MedicalSpecialityRecord  { 
private ISpecialityRepository repEspecialidade;
public IteratorDsk getListaEspecialidade() throws RepositoryException, ObjectNotFoundException
    { 
return repEspecialidade.getSpecialityList();
} 
public MedicalSpecialityRecord(ISpecialityRepository repEspecialidade)
    { 
this.repEspecialidade = repEspecialidade;
} 

 } 
