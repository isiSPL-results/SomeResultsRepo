
//#if -2114899440 
// Compilation Unit of /ComplaintStateOpen.java 
 

//#if -496525089 
package healthwatcher.model.complaint.state;
//#endif 


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


//#if 743004696 
public class ComplaintStateOpen extends 
//#if 877178267 
ComplaintState
//#endif 

  { 

//#if -496272785 
public ComplaintStateOpen()
    { 

//#if -1073120067 
super();
//#endif 

} 

//#endif 


//#if 837656300 
public void setAttendant(Employee atend, Complaint complaint)
    { 

//#if 1652435383 
attendant = atend;
//#endif 


//#if 509782877 
complaint.notifyObservers();
//#endif 

} 

//#endif 


//#if 338462805 
public void setCode(int cod)
    { 

//#if 1290350185 
code = cod;
//#endif 

} 

//#endif 


//#if 452604565 
public void setTimestamp(long newTimestamp)
    { 

//#if 1788625510 
timestamp = newTimestamp;
//#endif 

} 

//#endif 


//#if 85879618 
public void setComplainer(String _solicitante)
    { 

//#if 85386413 
complainer = _solicitante;
//#endif 

} 

//#endif 


//#if 326743128 
public int getStatus()
    { 

//#if -425804310 
return Situation.QUEIXA_ABERTA;
//#endif 

} 

//#endif 


//#if 921939545 
public ComplaintStateOpen(int codigo,String solicitante, String descricao,
                              String observacao, String email, Employee atendente,
                              Date dataParecer, Date dataQueixa,
                              Address enderecoSolicitante, long timestamp)
    { 

//#if 346926649 
super(codigo,solicitante, descricao,
              observacao, email, atendente,
              dataParecer, dataQueixa,
              enderecoSolicitante, timestamp);
//#endif 

} 

//#endif 


//#if 1067317899 
public void setDescription(String desc)
    { 

//#if -1425537232 
description = desc;
//#endif 

} 

//#endif 


//#if -1949674554 
public void setObservation(String obs)
    { 

//#if -1294418428 
observation = obs;
//#endif 

} 

//#endif 


//#if -1697109294 
public void setComplaintDate(Date data)
    { 

//#if -1670827356 
complaintDate = data;
//#endif 

} 

//#endif 


//#if -1972781345 
public void setEmail(String _email)
    { 

//#if 745220242 
email = _email;
//#endif 

} 

//#endif 


//#if 434863514 
public void setAttendant(Employee atend)
    { 

//#if -575734466 
attendant = atend;
//#endif 

} 

//#endif 


//#if 296158632 
public void setComplainerAddress(Address end)
    { 

//#if -1005511247 
complainerAddress = end;
//#endif 

} 

//#endif 


//#if 542368064 
public void setObservation(String obs, Complaint complaint)
    { 

//#if 1294656589 
observation = obs;
//#endif 


//#if 300834922 
complaint.notifyObservers();
//#endif 

} 

//#endif 


//#if -1015805384 
public void setMedicalOpinionDate(Date data)
    { 

//#if -1408137747 
medicalOpinionDate = data;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

