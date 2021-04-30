
//#if -1370900335 
// Compilation Unit of /ComplaintState.java 
 

//#if -803303998 
package healthwatcher.model.complaint.state;
//#endif 


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


//#if -1330250769 
public abstract class ComplaintState implements 
//#if -1338847208 
Serializable
//#endif 

  { 

//#if -465845324 
protected int             code;
//#endif 


//#if -2093101025 
protected String          complainer;
//#endif 


//#if 1883180677 
protected String          description;
//#endif 


//#if -992722859 
protected String          observation;
//#endif 


//#if -1284880539 
protected String          email;
//#endif 


//#if 403705393 
protected Employee		  attendant;
//#endif 


//#if -1049699431 
protected Date            medicalOpinionDate;
//#endif 


//#if 1151694789 
protected Date            complaintDate;
//#endif 


//#if 460830044 
protected Address         complainerAddress;
//#endif 


//#if 954642422 
protected long timestamp;
//#endif 


//#if 1076852190 
public abstract int getStatus();
//#endif 


//#if 500023622 
public abstract void setObservation(String obs, Complaint complaint);
//#endif 


//#if -174426420 
public abstract void setAttendant(Employee atendente, Complaint complaint);
//#endif 


//#if -753123666 
public abstract void setComplainerAddress(Address end);
//#endif 


//#if -862926193 
public abstract void setCode(int cod);
//#endif 


//#if -1048127366 
public String getEmail()
    { 

//#if -1478968442 
return this.email;
//#endif 

} 

//#endif 


//#if -882411146 
public void setStatus(int sit,Complaint complaint)
    { 

//#if 449430332 
if(sit!=getStatus())//1
{ 

//#if -1842761742 
if(sit==Situation.QUEIXA_ABERTA)//1
{ 

//#if -481859760 
complaint.setComplaintState(new ComplaintStateOpen(code,complainer, description,
                                            observation, email, attendant,
                                            medicalOpinionDate, complaintDate,
                                            complainerAddress, timestamp));
//#endif 

} 
else

//#if 595928172 
if(sit==Situation.QUEIXA_FECHADA)//1
{ 

//#if -344340705 
complaint.setComplaintState(new ComplaintStateClosed(code,complainer, description,
                                            observation, email, attendant,
                                            medicalOpinionDate, complaintDate,
                                            complainerAddress, timestamp));
//#endif 

} 
else

//#if 148196779 
if(sit==Situation.QUEIXA_SUSPENSA)//1
{
}
//#endif 


//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 114696280 
public abstract void setComplaintDate(Date data);
//#endif 


//#if -1000999653 
public abstract void setTimestamp(long newTimestamp);
//#endif 


//#if -10578761 
public int getCode()
    { 

//#if 1953440460 
return this.code;
//#endif 

} 

//#endif 


//#if -1914960769 
public long getTimestamp()
    { 

//#if -1132260326 
return timestamp;
//#endif 

} 

//#endif 


//#if 2140987930 
public String getComplainer()
    { 

//#if 638868054 
return this.complainer;
//#endif 

} 

//#endif 


//#if -1633081526 
public String getObservation()
    { 

//#if -1687134396 
return this.observation;
//#endif 

} 

//#endif 


//#if 1167104114 
public abstract void setMedicalOpinionDate(Date data);
//#endif 


//#if 157621755 
public Address getComplainerAddress()
    { 

//#if -118440369 
return this.complainerAddress;
//#endif 

} 

//#endif 


//#if -2044099991 
public ComplaintState()
    {
}
//#endif 


//#if 1773017103 
public void incTimestamp()
    { 

//#if -550189623 
this.timestamp = timestamp + 1;
//#endif 

} 

//#endif 


//#if 833906630 
public Date getMedicalOpinionDate()
    { 

//#if -2021677007 
return this.medicalOpinionDate;
//#endif 

} 

//#endif 


//#if -1415843823 
public abstract void setDescription(String desc);
//#endif 


//#if 1620582170 
public String getDescription()
    { 

//#if -809010201 
return this.description;
//#endif 

} 

//#endif 


//#if -705928568 
public Employee getAttendant()
    { 

//#if 366475768 
return this.attendant;
//#endif 

} 

//#endif 


//#if -767366481 
public abstract void setComplainer(String solicitante);
//#endif 


//#if -1677921862 
public abstract void setAttendant(Employee atendente);
//#endif 


//#if 260675539 
public ComplaintState(int codigo,String solicitante, String descricao,
                          String observacao, String email, Employee atendente,
                          Date dataParecer, Date dataQueixa,
                          Address enderecoSolicitante, long timestamp)
    { 

//#if -1636806106 
this.code              = codigo;
//#endif 


//#if 262969787 
this.complainer         = solicitante;
//#endif 


//#if 744318951 
this.description           = descricao;
//#endif 


//#if 2070241693 
this.observation          = observacao;
//#endif 


//#if 534041300 
this.email               = email;
//#endif 


//#if 228221949 
this.attendant           = atendente;
//#endif 


//#if -442555933 
this.medicalOpinionDate  = dataParecer;
//#endif 


//#if 1737884392 
this.complaintDate          = dataQueixa;
//#endif 


//#if 1534004196 
this.complainerAddress = enderecoSolicitante;
//#endif 


//#if 1080969824 
this.timestamp = timestamp;
//#endif 

} 

//#endif 


//#if 564820596 
public Date getComplaintDate()
    { 

//#if -2112959057 
return this.complaintDate;
//#endif 

} 

//#endif 


//#if 170212020 
public abstract void setEmail(String email);
//#endif 


//#if -921397888 
public abstract void setObservation(String obs);
//#endif 

 } 

//#endif 


//#endif 

