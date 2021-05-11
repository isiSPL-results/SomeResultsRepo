
//#if -760230440
// Compilation Unit of /MedicalSpecialityRecord.java


//#if 1435217370
package healthwatcher.business.healthguide;
//#endif


//#if -2103182383
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 642821837
import lib.exceptions.RepositoryException;
//#endif


//#if -431205082
import lib.util.IteratorDsk;
//#endif


//#if 1808814527
import healthwatcher.data.ISpecialityRepository;
//#endif


//#if 500301446
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if 1025909707
import lib.exceptions.ObjectNotValidException;
//#endif


//#if 83812128
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif


//#if -235740179
public class MedicalSpecialityRecord
{

//#if 2063337433
    private ISpecialityRepository repEspecialidade;
//#endif


//#if -827680956
    public IteratorDsk getListaEspecialidade() throws RepositoryException, ObjectNotFoundException
    {

//#if 1298643951
        return repEspecialidade.getSpecialityList();
//#endif

    }

//#endif


//#if -2118443870
    public MedicalSpeciality search(int codigo) throws ObjectNotFoundException, RepositoryException
    {

//#if -1115139183
        return repEspecialidade.search(codigo);
//#endif

    }

//#endif


//#if 317186828
    public MedicalSpecialityRecord(ISpecialityRepository repEspecialidade)
    {

//#if 410387047
        this.repEspecialidade = repEspecialidade;
//#endif

    }

//#endif


//#if -606278095
    public void update(MedicalSpeciality esp) throws ObjectNotValidException,
               ObjectNotFoundException, ObjectNotValidException, RepositoryException
    {

//#if -1707748373
        repEspecialidade.update(esp);
//#endif

    }

//#endif


//#if 1026807238
    public void insert(MedicalSpeciality esp) throws ObjectNotValidException,
        ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException
    {

//#if 200526448
        repEspecialidade.insert(esp);
//#endif

    }

//#endif

}

//#endif


//#endif

