
//#if -2114899440 
// Compilation Unit of /ComplaintStateOpen.java 
 
package healthwatcher.model.complaint.state;

//#if 723111520 
import healthwatcher.model.address.Address;
//#endif 


//#if -45129089 
import healthwatcher.model.complaint.Situation;
//#endif 


//#if 1511494380 
import healthwatcher.model.employee.Employee;
//#endif 


//#if -1029522922 
import lib.util.Date;
//#endif 


//#if 1684346226 
import healthwatcher.model.complaint.Complaint;
//#endif 

public class ComplaintStateOpen extends ComplaintState
  { 
public ComplaintStateOpen()
    { 
super();
} 


//#if 837656300 
public void setAttendant(Employee atend, Complaint complaint)
    { 
attendant = atend;
complaint.notifyObservers();
} 

//#endif 

public void setCode(int cod)
    { 
code = cod;
} 

public void setTimestamp(long newTimestamp)
    { 
timestamp = newTimestamp;
} 

public void setComplainer(String _solicitante)
    { 
complainer = _solicitante;
} 

public int getStatus()
    { 
return Situation.QUEIXA_ABERTA;
} 

public ComplaintStateOpen(int codigo,String solicitante, String descricao,
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
description = desc;
} 


//#if -1949674554 
public void setObservation(String obs)
    { 
observation = obs;
} 

//#endif 

public void setComplaintDate(Date data)
    { 
complaintDate = data;
} 

public void setEmail(String _email)
    { 
email = _email;
} 


//#if 434863514 
public void setAttendant(Employee atend)
    { 
attendant = atend;
} 

//#endif 

public void setComplainerAddress(Address end)
    { 
complainerAddress = end;
} 


//#if 542368064 
public void setObservation(String obs, Complaint complaint)
    { 
observation = obs;
complaint.notifyObservers();
} 

//#endif 

public void setMedicalOpinionDate(Date data)
    { 
medicalOpinionDate = data;
} 

 } 


//#endif 

