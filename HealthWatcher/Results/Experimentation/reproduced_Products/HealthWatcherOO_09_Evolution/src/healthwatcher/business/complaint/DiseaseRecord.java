package healthwatcher.business.complaint;
import healthwatcher.data.IDiseaseRepository;
import healthwatcher.model.complaint.DiseaseType;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.util.IteratorDsk;
import lib.concurrency.ConcurrencyManager;
import lib.exceptions.ExceptionMessages;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotValidException;
public class DiseaseRecord
{
    private IDiseaseRepository diseaseRep;
    private ConcurrencyManager manager = new ConcurrencyManager();
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
    public void insert(DiseaseType diseaseType) throws RepositoryException, ObjectAlreadyInsertedException,
               ObjectNotValidException
    {
        try { //1
            manager.beginExecution("" + diseaseType.getCode());
            if(diseaseRep.exists(diseaseType.getCode())) { //1
                throw new ObjectAlreadyInsertedException(ExceptionMessages.EXC_JA_EXISTE);
            } else {
                this.diseaseRep.insert(diseaseType);
            }
        } finally {
            manager.endExecution("" + diseaseType.getCode());
        }
    }

}
