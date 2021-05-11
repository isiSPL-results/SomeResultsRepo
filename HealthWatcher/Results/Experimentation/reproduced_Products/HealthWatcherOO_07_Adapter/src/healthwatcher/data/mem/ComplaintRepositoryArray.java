package healthwatcher.data.mem;
import healthwatcher.data.IComplaintRepository;
import healthwatcher.model.complaint.Complaint;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.util.IteratorDsk;
public class ComplaintRepositoryArray implements IComplaintRepository
{
    private Complaint[] vetor;
    private int indice;
    private int ponteiro;
    public boolean exists(int codigo) throws RepositoryException
    {
        synchronized (this) { //1
            int i = getIndex(codigo);
            return (i != indice);
        }
    }
    public Object next()
    {
        synchronized (this) { //1
            if(ponteiro >= indice) { //1
                return null;
            } else {
                return vetor[ponteiro++];
            }
        }
    }
    public ComplaintRepositoryArray()
    {
        vetor = new Complaint[5000];
        indice = 0;
    }
    public boolean hasNext()
    {
        synchronized (this) { //1
            return ponteiro < indice;
        }
    }
    private int getIndex(int code)
    {
        synchronized (this) { //1
            int temp;
            boolean flag = false;
            int i = 0;
            while ((!flag) && (i < indice)) { //1
                temp = vetor[i].getCodigo();
                if(temp == code) { //1
                    flag = true;
                } else {
                    i = i + 1;
                }
            }
            return i;
        }
    }
    public int insert(Complaint q) throws RepositoryException, ObjectAlreadyInsertedException
    {
        synchronized (this) { //1
            if(q == null) { //1
                throw new IllegalArgumentException();
            }
            this.vetor[indice] = q;
            indice++;
            return vetor[indice - 1].getCodigo();
        }
    }
    public void remove(int codigo) throws RepositoryException, ObjectNotFoundException
    {
        synchronized (this) { //1
            int i = getIndex(codigo);
            if(i == indice) { //1
                throw new ObjectNotFoundException("Complaint not found");
            } else {
                vetor[i] = vetor[indice - 1];
                indice = indice - 1;
            }
        }
    }
    public void update(Complaint q) throws RepositoryException, ObjectNotFoundException
    {
        synchronized (this) { //1
            int i = getIndex(q.getCodigo());
            if(i == indice) { //1
                throw new ObjectNotFoundException("Complaint not found");
            } else {
                vetor[i] = q;
            }
        }
    }
    public Complaint search(int codigo) throws RepositoryException, ObjectNotFoundException
    {
        synchronized (this) { //1
            Complaint response = null;
            int i = getIndex(codigo);
            if(i == indice) { //1
                throw new ObjectNotFoundException("Complaint not found");
            } else {
                response = vetor[i];
            }
            return response;
        }
    }
    public void reset()
    {
        synchronized (this) { //1
            this.ponteiro = 0;
        }
    }
    public IteratorDsk getComplaintList()
    {
        synchronized (this) { //1
            return null;
        }
    }

}
