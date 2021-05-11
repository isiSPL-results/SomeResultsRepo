package healthwatcher.model.complaint.state;
import healthwatcher.model.address.Address;
import healthwatcher.model.complaint.Situation;
import healthwatcher.model.employee.Employee;
import lib.util.Date;
import healthwatcher.model.complaint.Complaint;
public class ComplaintStateOpen extends ComplaintState
{
    public ComplaintStateOpen()
    {
        super();
    }
    public void setAttendant(Employee atend, Complaint complaint)
    {
        attendant = atend;
        complaint.notifyObservers();
    }
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
    public void setComplaintDate(Date data)
    {
        complaintDate = data;
    }
    public void setEmail(String _email)
    {
        email = _email;
    }
    public void setComplainerAddress(Address end)
    {
        complainerAddress = end;
    }
    public void setObservation(String obs, Complaint complaint)
    {
        observation = obs;
        complaint.notifyObservers();
    }
    public void setMedicalOpinionDate(Date data)
    {
        medicalOpinionDate = data;
    }

}
