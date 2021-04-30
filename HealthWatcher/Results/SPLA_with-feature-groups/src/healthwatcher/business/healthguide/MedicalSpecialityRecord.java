// Compilation Unit of /MedicalSpecialityRecord.java 
 
package healthwatcher.business.healthguide;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.util.IteratorDsk;
import healthwatcher.data.ISpecialityRepository;

//#if 500301446 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if 1025909707 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if 83812128 
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif 

public class MedicalSpecialityRecord  { 
private ISpecialityRepository repEspecialidade;
public IteratorDsk getListaEspecialidade() throws RepositoryException, ObjectNotFoundException
    { 
return repEspecialidade.getSpecialityList();
} 


//#if -2118443870 
public MedicalSpeciality search(int codigo) throws ObjectNotFoundException, RepositoryException
    { 
return repEspecialidade.search(codigo);
} 

//#endif 

public MedicalSpecialityRecord(ISpecialityRepository repEspecialidade)
    { 
this.repEspecialidade = repEspecialidade;
} 


//#if -606278095 
public void update(MedicalSpeciality esp) throws ObjectNotValidException,
        ObjectNotFoundException, ObjectNotValidException, RepositoryException
    { 
repEspecialidade.update(esp);
} 

//#endif 


//#if 1026807238 
public void insert(MedicalSpeciality esp) throws ObjectNotValidException,
               ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException
    { 
repEspecialidade.insert(esp);
} 

//#endif 

 } 


