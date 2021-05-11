// Compilation Unit of /SpecialityRepositoryArray.java

package healthwatcher.data.mem;
import healthwatcher.data.ISpecialityRepository;
import healthwatcher.model.healthguide.MedicalSpeciality;
import java.util.Arrays;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.RepositoryException;
import lib.util.ConcreteIterator;
import lib.util.IteratorDsk;
public class SpecialityRepositoryArray implements ISpecialityRepository
{
    private MedicalSpeciality[] vetor;
    private int indice;
    private int ponteiro;
    public void update(MedicalSpeciality specialty) throws RepositoryException,
               ObjectNotFoundException
    {
        int i = getIndex(specialty.getCodigo());
        if(i == indice) { //1
            throw new ObjectNotFoundException("Specialty not found");
        } else {
            vetor[i] = specialty;
        }

    }

    public SpecialityRepositoryArray()
    {
        vetor = new MedicalSpeciality[100];
        indice = 0;
    }

    public void insert(MedicalSpeciality specialty) throws RepositoryException,
        ObjectAlreadyInsertedException
    {
        if(specialty == null) { //1
            throw new IllegalArgumentException();
        }

        this.vetor[indice] = specialty;
        indice++;
    }

    public boolean hasNext()
    {
        return ponteiro < indice;
    }

    public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException
    {
        if(indice == 0) { //1
            throw new ObjectNotFoundException("There isn't registered Health units");
        }

        return new ConcreteIterator(Arrays.asList(vetor));
    }

    public boolean exists(int code) throws RepositoryException
    {
        boolean flag = false;
        for (int i = 0; i < indice; i++) { //1
            if(this.vetor[i].getCodigo() == code) { //1
                flag = true;
                break;

            }

        }

        return flag;
    }

    public void remove(int code) throws RepositoryException, ObjectNotFoundException
    {
        int i = getIndex(code);
        if(i == indice) { //1
            throw new ObjectNotFoundException("Specialty not found");
        } else {
            vetor[i] = vetor[indice - 1];
            indice = indice - 1;
        }

    }

    public MedicalSpeciality search(int code) throws RepositoryException, ObjectNotFoundException
    {
        MedicalSpeciality response = null;
        int i = getIndex(code);
        if(i == indice) { //1
            throw new ObjectNotFoundException("Specialty not found");
        } else {
            response = vetor[i];
        }

        return response;
    }

    private int getIndex(int code)
    {
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

    public Object next()
    {
        if(ponteiro >= indice) { //1
            return null;
        } else {
            return vetor[ponteiro++];
        }

    }

    public void reset()
    {
        this.ponteiro = 0;
    }

}


