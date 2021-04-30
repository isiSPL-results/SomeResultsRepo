
//#if -120619150 
// Compilation Unit of /ComplaintStateClosed.java 
 

//#if -1490861226 
package healthwatcher.model.complaint.state;
//#endif 


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


//#if 1604826801 
public class ComplaintStateClosed extends 
//#if 1817611948 
ComplaintState
//#endif 

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


//#if 561110448 
public void setEmail(String _email)
    {
}
//#endif 


//#if -1039840414 
public ComplaintStateClosed()
    {
}
//#endif 


//#if -982869315 
public void setAttendant(Employee atend, Complaint complaint)
    {
}
//#endif 


//#if 723829929 
public int getStatus()
    { 

//#if -2124480865 
return Situation.QUEIXA_FECHADA;
//#endif 

} 

//#endif 


//#if -1315067848 
public void setSituacao(int sit)
    {
}
//#endif 


//#if -631794887 
public void setComplainerAddress(Address end)
    {
}
//#endif 


//#if -1599928697 
public void setMedicalOpinionDate(Date data)
    {
}
//#endif 


//#if 1170503509 
public void setObservation(String obs)
    {
}
//#endif 


//#if 1384091601 
public void setComplainer(String _solicitante)
    {
}
//#endif 


//#if -106868084 
public ComplaintStateClosed(int codigo,String solicitante, String descricao,
                                String observacao, String email, Employee atendente,
                                Date dataParecer, Date dataQueixa,
                                Address enderecoSolicitante, long timestamp)
    { 

//#if 329811295 
super(codigo,solicitante, descricao,
              observacao, email, atendente,
              dataParecer, dataQueixa,
              enderecoSolicitante, timestamp);
//#endif 

} 

//#endif 


//#if -991409956 
public void setDescription(String desc)
    {
}
//#endif 


//#if -417070428 
public void setCode(int cod)
    {
}
//#endif 


//#if 987951206 
public void setTimestamp(long newTimestamp)
    {
}
//#endif 


//#if 539130147 
public void setComplaintDate(Date data)
    {
}
//#endif 

 } 

//#endif 


//#endif 

