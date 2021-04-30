
//#if 1145399248 
// Compilation Unit of /ComplaintRecord.java 
 

//#if -1095959570 
package healthwatcher.business.complaint;
//#endif 


//#if -401966203 
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif 


//#if -1751609422 
import lib.exceptions.ObjectNotFoundException;
//#endif 


//#if 1377482668 
import lib.exceptions.ObjectNotValidException;
//#endif 


//#if -1616618706 
import lib.exceptions.RepositoryException;
//#endif 


//#if 436378170 
import lib.util.Functions;
//#endif 


//#if -810234041 
import lib.util.IteratorDsk;
//#endif 


//#if -480558014 
import healthwatcher.data.IComplaintRepository;
//#endif 


//#if 398538955 
import healthwatcher.model.complaint.AnimalComplaint;
//#endif 


//#if 1798919407 
import healthwatcher.model.complaint.Complaint;
//#endif 


//#if -2016819091 
import healthwatcher.model.complaint.FoodComplaint;
//#endif 


//#if 131976657 
public class ComplaintRecord  { 

//#if 700202793 
private IComplaintRepository complaintRep;
//#endif 


//#if -1618793700 
public ComplaintRecord(IComplaintRepository rep)
    { 

//#if 1930094455 
this.complaintRep = rep;
//#endif 

} 

//#endif 


//#if 1612818595 
public IteratorDsk getComplaintList() throws RepositoryException, ObjectNotFoundException
    { 

//#if 1375644035 
return complaintRep.getComplaintList();
//#endif 

} 

//#endif 


//#if 1662558968 
public void update(Complaint q) throws RepositoryException, ObjectNotFoundException,
        ObjectNotValidException
    { 

//#if 2022297193 
complaintRep.update(q);
//#endif 

} 

//#endif 


//#if 566941525 
public int insert(Complaint complaint) throws ObjectNotValidException,
               ObjectAlreadyInsertedException, ObjectNotValidException, RepositoryException
    { 

//#if -474572525 
this.validate(complaint);
//#endif 


//#if -1049414217 
if(complaintRep.exists(complaint.getCodigo()))//1
{ 

//#if -131801655 
throw new ObjectAlreadyInsertedException("Complaint code already registered");
//#endif 

} 

//#endif 


//#if 432326962 
return complaintRep.insert(complaint);
//#endif 

} 

//#endif 


//#if 56031203 
public void validate(Complaint complaint)
    { 

//#if -1175456893 
Functions f = new Functions();
//#endif 


//#if 1078321157 
if(complaint == null)//1
{ 

//#if -1737014275 
throw new IllegalArgumentException();
//#endif 

} 

//#endif 


//#if -1767434978 
f.campoPreenchido(complaint.getDescricao());
//#endif 


//#if 385659573 
if(complaint instanceof AnimalComplaint)//1
{ 

//#if 1805689261 
f.campoPreenchido(((AnimalComplaint) complaint).getOccurenceLocalAddress());
//#endif 


//#if -381972011 
f.campoPreenchido(((AnimalComplaint) complaint).getAnimal());
//#endif 

} 

//#endif 


//#if 538784531 
if(complaint instanceof FoodComplaint)//1
{ 

//#if -59108292 
f.campoPreenchido(((FoodComplaint) complaint).getQtdeComensais());
//#endif 


//#if 1559406664 
f.campoPreenchido(((FoodComplaint) complaint).getQtdeDoentes());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1967671443 
public Complaint search(int code) throws RepositoryException, ObjectNotFoundException
    { 

//#if -1409323988 
return complaintRep.search(code);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

