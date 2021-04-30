
//#if -1370900335 
// Compilation Unit of /ComplaintState.java 
 
package healthwatcher.model.complaint.state;

//#if -533710563 
import healthwatcher.model.address.Address;
//#endif 


//#if 2124274095 
import healthwatcher.model.complaint.Complaint;
//#endif 


//#if 394798780 
import healthwatcher.model.complaint.Situation;
//#endif 


//#if 591282793 
import healthwatcher.model.employee.Employee;
//#endif 


//#if -440315369 
import java.io.Serializable;
//#endif 


//#if -1030369133 
import lib.util.Date;
//#endif 

public abstract class ComplaintState implements Serializable
  { 
protected int             code;
protected String          complainer;
protected String          description;
protected String          observation;
protected String          email;
protected Employee		  attendant;
protected Date            medicalOpinionDate;
protected Date            complaintDate;
protected Address         complainerAddress;
protected long timestamp;
public abstract int getStatus();

//#if 500023622 
public abstract void setObservation(String obs, Complaint complaint);
//#endif 


//#if -174426420 
public abstract void setAttendant(Employee atendente, Complaint complaint);
//#endif 

public abstract void setComplainerAddress(Address end);
public abstract void setCode(int cod);
public String getEmail()
    { 
return this.email;
} 

public void setStatus(int sit,Complaint complaint)
    { 
if(sit!=getStatus())//1
{ 
if(sit==Situation.QUEIXA_ABERTA)//1
{ 
complaint.setComplaintState(new ComplaintStateOpen(code,complainer, description,
                                            observation, email, attendant,
                                            medicalOpinionDate, complaintDate,
                                            complainerAddress, timestamp));
} 
else

//#if 595928172 
if(sit==Situation.QUEIXA_FECHADA)//1
{ 
complaint.setComplaintState(new ComplaintStateClosed(code,complainer, description,
                                            observation, email, attendant,
                                            medicalOpinionDate, complaintDate,
                                            complainerAddress, timestamp));
} 
else

//#if 148196779 
if(sit==Situation.QUEIXA_SUSPENSA)//1
{
}
//#endif 


//#endif 


} 

} 

public abstract void setComplaintDate(Date data);
public abstract void setTimestamp(long newTimestamp);
public int getCode()
    { 
return this.code;
} 

public long getTimestamp()
    { 
return timestamp;
} 

public String getComplainer()
    { 
return this.complainer;
} 

public String getObservation()
    { 
return this.observation;
} 

public abstract void setMedicalOpinionDate(Date data);
public Address getComplainerAddress()
    { 
return this.complainerAddress;
} 

public ComplaintState()
    {
}
public void incTimestamp()
    { 
this.timestamp = timestamp + 1;
} 

public Date getMedicalOpinionDate()
    { 
return this.medicalOpinionDate;
} 

public abstract void setDescription(String desc);
public String getDescription()
    { 
return this.description;
} 

public Employee getAttendant()
    { 
return this.attendant;
} 

public abstract void setComplainer(String solicitante);

//#if -1677921862 
public abstract void setAttendant(Employee atendente);
//#endif 

public ComplaintState(int codigo,String solicitante, String descricao,
                          String observacao, String email, Employee atendente,
                          Date dataParecer, Date dataQueixa,
                          Address enderecoSolicitante, long timestamp)
    { 
this.code              = codigo;
this.complainer         = solicitante;
this.description           = descricao;
this.observation          = observacao;
this.email               = email;
this.attendant           = atendente;
this.medicalOpinionDate  = dataParecer;
this.complaintDate          = dataQueixa;
this.complainerAddress = enderecoSolicitante;
this.timestamp = timestamp;
} 

public Date getComplaintDate()
    { 
return this.complaintDate;
} 

public abstract void setEmail(String email);

//#if -921397888 
public abstract void setObservation(String obs);
//#endif 

 } 


//#endif 

