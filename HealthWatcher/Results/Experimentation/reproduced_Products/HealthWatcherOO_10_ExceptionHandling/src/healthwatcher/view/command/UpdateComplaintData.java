package healthwatcher.view.command;
import healthwatcher.model.complaint.Complaint;
import healthwatcher.model.complaint.Situation;
import healthwatcher.model.employee.Employee;
import healthwatcher.view.IFacade;
import java.io.PrintWriter;
import java.util.Calendar;
import lib.exceptions.InvalidSessionException;
import lib.util.HTMLCode;
public class UpdateComplaintData extends Command
{
    public void execute() throws Exception
    {
        PrintWriter out = response.getWriter();
        String obsQueixa = request.getInput("obsQueixa");
        Complaint q = null;
        try { //1
            if(! request.isAuthorized()) { //1
                throw new InvalidSessionException();
            }
            q = (Complaint) request
                .get(UpdateComplaintSearch.QUEIXA);
            q.setObservacao(obsQueixa);
            Calendar agora = Calendar.getInstance();
            q.setDataParecer(new lib.util.Date(
                                 agora.get(Calendar.DAY_OF_MONTH),
                                 agora.get(Calendar.MONTH), agora.get(Calendar.YEAR)));
            Employee employee = (Employee) request
                                .get(Login.EMPLOYEE);
            q.setAtendente(employee);
            q.setSituacao(Situation.QUEIXA_FECHADA);
            out.println(HTMLCode.htmlPageAdministrator("Operation executed",
                        "Complaint updated" + "<P>" + obsQueixa + "</P>"));
        } catch (Exception e) { //1
            out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
            e.printStackTrace(out);
        }
    }
    public UpdateComplaintData(IFacade f)
    {
        super(f);
    }

}
