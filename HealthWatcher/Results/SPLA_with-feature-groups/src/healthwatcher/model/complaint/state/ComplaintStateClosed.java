
//#if -120619150 
// Compilation Unit of /ComplaintStateClosed.java 
 
package healthwatcher.model.complaint.state;

//#if 968130825 
import healthwatcher.model.address.Address;
//#endif 


//#if 76454056 
import healthwatcher.model.complaint.Situation;
//#endif 


//#if 751845205 
import healthwatcher.model.employee.Employee;
//#endif 


//#if -1600073345 
import lib.util.Date;
//#endif 


//#if 1805929371 
import healthwatcher.model.complaint.Complaint;
//#endif 

public class ComplaintStateClosed extends ComplaintState
  { 

//#if -1546674863 
public void setObservation(String obs, Complaint complaint)
    {
}
//#endif 


//#if 1038809449 
public void setAttendant(Employee atend)
    {
}
//#endif 

public void setEmail(String _email)
    {
}
public ComplaintStateClosed()
    {
}

//#if -982869315 
public void setAttendant(Employee atend, Complaint complaint)
    {
}
//#endif 

public int getStatus()
    { 
return Situation.QUEIXA_FECHADA;
} 

public void setSituacao(int sit)
    {
}
public void setComplainerAddress(Address end)
    {
}
public void setMedicalOpinionDate(Date data)
    {
}

//#if 1170503509 
public void setObservation(String obs)
    {
}
//#endif 

public void setComplainer(String _solicitante)
    {
}
public ComplaintStateClosed(int codigo,String solicitante, String descricao,
                                String observacao, String email, Employee atendente,
                                Date dataParecer, Date dataQueixa,
                                Address enderecoSolicitante, long timestamp)
    { 
super(codigo,solicitante, descricao,
              observacao, email, atendente,
              dataParecer, dataQueixa,
              enderecoSolicitante, timestamp);
} 

public void setDescription(String desc)
    {
}
public void setCode(int cod)
    {
}
public void setTimestamp(long newTimestamp)
    {
}
public void setComplaintDate(Date data)
    {
}
 } 


//#endif 

