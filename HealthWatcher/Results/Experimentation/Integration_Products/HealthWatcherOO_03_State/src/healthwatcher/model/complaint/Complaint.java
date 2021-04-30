package healthwatcher.model.complaint;
import healthwatcher.model.address.Address;
import healthwatcher.model.employee.Employee;
import lib.util.Date;
import healthwatcher.model.complaint.state.ComplaintState;
import healthwatcher.model.complaint.state.ComplaintStateClosed;
import healthwatcher.model.complaint.state.ComplaintStateOpen;
public abstract class Complaint implements java.io.Serializable
  { 
public static final int QUEIXA_ALIMENTAR = 1;
public static final int QUEIXA_ANIMAL = 2;
public static final int QUEIXA_DIVERSA = 3;
private ComplaintState state;
public int getCodigo()
    { 
return state.getCode();
} 
public void setDataQueixa(Date dataQueixa)
    { 
state.setComplaintDate(dataQueixa);
} 
public void setTimestamp(long timestamp)
    { 
state.setTimestamp(timestamp);
} 
public void setSolicitante(String solicitante)
    { 
state.setComplainer(solicitante);
} 
public void setObservacao(String observacao)
    { 
state.setObservation(observacao);
} 
public String getEmail()
    { 
return state.getEmail();
} 
public Complaint(String solicitante, String descricao, String observacao, String email,
                     Employee atendente, int situacao, Date dataParecer, Date dataQueixa,
                     Address enderecoSolicitante, long timestamp)
    { 
if(situacao==Situation.QUEIXA_ABERTA)//1
state= new ComplaintStateOpen(0,solicitante, descricao,
                                          observacao, email, atendente,
                                          dataParecer, dataQueixa,
                                          enderecoSolicitante, timestamp);
else
if(situacao==Situation.QUEIXA_FECHADA)//1
state= new ComplaintStateClosed(0,solicitante, descricao,
                                            observacao, email, atendente,
                                            dataParecer, dataQueixa,
                                            enderecoSolicitante, timestamp);
} 
public int getSituacao()
    { 
return state.getStatus();
} 
public String getDescricao()
    { 
return state.getDescription();
} 
public Address getEnderecoSolicitante()
    { 
return state.getComplainerAddress();
} 
public String getObservacao()
    { 
return state.getObservation();
} 
public Employee getAtendente()
    { 
return state.getAttendant();
} 
public void incTimestamp()
    { 
state.incTimestamp();
} 
public void setEnderecoSolicitante(Address enderecoSolicitante)
    { 
state.setComplainerAddress(enderecoSolicitante);
} 
public Date getDataParecer()
    { 
return state.getMedicalOpinionDate();
} 
public String getSolicitante()
    { 
return state.getComplainer();
} 
public void setComplaintState(ComplaintState _state)
    { 
state= _state;
} 
public void setAtendente(Employee atendente)
    { 
state.setAttendant(atendente);
} 
public void setCodigo(int codigo)
    { 
state.setCode(codigo);
} 
public long getTimestamp()
    { 
return state.getTimestamp();
} 
public void setDataParecer(Date dataParecer)
    { 
state.setMedicalOpinionDate(dataParecer);
} 
public void setSituacao(int situacao)
    { 
state.setStatus(situacao, this);
} 
public void setDescricao(String descricao)
    { 
state.setDescription(descricao);
} 
public void setEmail(String email)
    { 
state.setEmail(email);
} 
public Date getDataQueixa()
    { 
return state.getComplaintDate();
} 
public Complaint()
    { 
state= new ComplaintStateOpen();
} 

 } 
