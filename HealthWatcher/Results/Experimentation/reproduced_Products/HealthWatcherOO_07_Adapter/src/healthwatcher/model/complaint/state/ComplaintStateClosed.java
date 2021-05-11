package healthwatcher.model.complaint.state;
import healthwatcher.model.address.Address;
import healthwatcher.model.complaint.Situation;
import healthwatcher.model.employee.Employee;
import lib.util.Date;
import healthwatcher.model.complaint.Complaint;
public class ComplaintStateClosed extends ComplaintState
{
    public void setObservation(String obs, Complaint complaint)
    {
    } public void setEmail(String _email)
    {
    } public ComplaintStateClosed()
    {
    } public void setAttendant(Employee atend, Complaint complaint)
    {
    } public int getStatus()
    {
        return Situation.QUEIXA_FECHADA;
    }
    public void setSituacao(int sit)
    {
    } public void setComplainerAddress(Address end)
    {
    } public void setMedicalOpinionDate(Date data)
    {
    } public void setComplainer(String _solicitante)
    {
    } public ComplaintStateClosed(int codigo,String solicitante, String descricao,
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
    } public void setCode(int cod)
    {
    } public void setTimestamp(long newTimestamp)
    {
    } public void setComplaintDate(Date data)
    {
    }
}
