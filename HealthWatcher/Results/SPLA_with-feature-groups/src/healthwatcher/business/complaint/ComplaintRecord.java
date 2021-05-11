// Compilation Unit of /ComplaintRecord.java

package healthwatcher.business.complaint;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.RepositoryException;
import lib.util.Functions;
import lib.util.IteratorDsk;
import healthwatcher.data.IComplaintRepository;
import healthwatcher.model.complaint.AnimalComplaint;
import healthwatcher.model.complaint.Complaint;
import healthwatcher.model.complaint.FoodComplaint;
public class ComplaintRecord
{
    private IComplaintRepository complaintRep;
    public ComplaintRecord(IComplaintRepository rep)
    {
        this.complaintRep = rep;
    }

    public IteratorDsk getComplaintList() throws RepositoryException, ObjectNotFoundException
    {
        return complaintRep.getComplaintList();
    }

    public void update(Complaint q) throws RepositoryException, ObjectNotFoundException,
               ObjectNotValidException
    {
        complaintRep.update(q);
    }

    public int insert(Complaint complaint) throws ObjectNotValidException,
        ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException
    {
        this.validate(complaint);
        if(complaintRep.exists(complaint.getCodigo())) { //1
            throw new ObjectAlreadyInsertedException("Complaint code already registered");
        }

        return complaintRep.insert(complaint);
    }

    public void validate(Complaint complaint)
    {
        Functions f = new Functions();
        if(complaint == null) { //1
            throw new IllegalArgumentException();
        }

        f.campoPreenchido(complaint.getDescricao());
        if(complaint instanceof AnimalComplaint) { //1
            f.campoPreenchido(((AnimalComplaint) complaint).getOccurenceLocalAddress());
            f.campoPreenchido(((AnimalComplaint) complaint).getAnimal());
        }

        if(complaint instanceof FoodComplaint) { //1
            f.campoPreenchido(((FoodComplaint) complaint).getQtdeComensais());
            f.campoPreenchido(((FoodComplaint) complaint).getQtdeDoentes());
        }

    }

    public Complaint search(int code) throws RepositoryException, ObjectNotFoundException
    {
        return complaintRep.search(code);
    }

}


