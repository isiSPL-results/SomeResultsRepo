
//#if 170706818
// Compilation Unit of /UpdateComplaintData.java


//#if 1338882289
package healthwatcher.view.command;
//#endif


//#if -1906598313
import healthwatcher.model.complaint.Complaint;
//#endif


//#if 658893668
import healthwatcher.model.complaint.Situation;
//#endif


//#if -445312751
import healthwatcher.model.employee.Employee;
//#endif


//#if 1101028002
import healthwatcher.view.IFacade;
//#endif


//#if -134650433
import java.io.IOException;
//#endif


//#if 485569800
import java.io.PrintWriter;
//#endif


//#if 1361380012
import java.util.Calendar;
//#endif


//#if -1847129791
import javax.servlet.http.HttpSession;
//#endif


//#if -800400421
import lib.exceptions.InvalidSessionException;
//#endif


//#if 1156775185
import lib.util.HTMLCode;
//#endif


//#if -1107569527
public class UpdateComplaintData extends
//#if 674508565
    Command
//#endif

{

//#if -308223777
    public void execute() throws Exception
    {

//#if -1609752094
        PrintWriter out = response.getWriter();
//#endif


//#if 1117799008
        String obsQueixa = request.getInput("obsQueixa");
//#endif


//#if 94422128
        Complaint q = null;
//#endif


//#if 1847475369
        try { //1

//#if 941762832
            if(! request.isAuthorized()) { //1

//#if 1317095523
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if 880211301
            q = (Complaint) request
                .get(UpdateComplaintSearch.QUEIXA);
//#endif


//#if -180126356
            q.setObservacao(obsQueixa);
//#endif


//#if 1571915663
            Calendar agora = Calendar.getInstance();
//#endif


//#if 1421527343
            q.setDataParecer(new lib.util.Date(
                                 agora.get(Calendar.DAY_OF_MONTH),
                                 agora.get(Calendar.MONTH), agora.get(Calendar.YEAR)));
//#endif


//#if 531899389
            Employee employee = (Employee) request
                                .get(Login.EMPLOYEE);
//#endif


//#if 1554048574
            q.setAtendente(employee);
//#endif


//#if -839154985
            q.setSituacao(Situation.QUEIXA_FECHADA);
//#endif


//#if 1594039769
            out.println(HTMLCode.htmlPageAdministrator("Operation executed",
                        "Complaint updated" + "<P>" + obsQueixa + "</P>"));
//#endif

        }

//#if -2102791687
        catch (Exception e) { //1

//#if -1837105339
            out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
//#endif


//#if -1619183026
            e.printStackTrace(out);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if 1912971147
    public UpdateComplaintData(IFacade f)
    {

//#if 330062102
        super(f);
//#endif

    }

//#endif


//#if -173239997
    public void execute()
    {

//#if -1614344305
        PrintWriter out = null;
//#endif


//#if 749427424
        try { //1

//#if -878122329
            out = response.getWriter();
//#endif

        }

//#if 312349783
        catch (IOException e1) { //1

//#if 42077064
            e1.printStackTrace();
//#endif

        }

//#endif


//#endif


//#if -510112745
        HttpSession session = request.getSession(false);
//#endif


//#if 254267190
        String obsQueixa = request.getParameter("obsQueixa");
//#endif


//#if -1415537257
        String obsQueixa = request.getInput("obsQueixa");
//#endif


//#if -2113746457
        Complaint q = null;
//#endif


//#if 872660309
        response.setContentType("text/html");
//#endif


//#if 952460241
        try { //2

//#if 2095355077
            if(session == null) { //1

//#if -708898150
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if -756735859
            q = (Complaint) session
                .getValue(UpdateComplaintSearch.QUEIXA);
//#endif


//#if -918070834
            if(! request.isAuthorized()) { //1

//#if 615915124
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if -439126425
            q = (Complaint) request
                .get(UpdateComplaintSearch.QUEIXA);
//#endif


//#if -1480313490
            q.setObservacao(obsQueixa);
//#endif


//#if 1478581781
            q.setSituacao(Situation.QUEIXA_FECHADA);
//#endif


//#if 2054530321
            Calendar agora = Calendar.getInstance();
//#endif


//#if 1993701485
            q.setDataParecer(new lib.util.Date(
                                 agora.get(Calendar.DAY_OF_MONTH),
                                 agora.get(Calendar.MONTH), agora.get(Calendar.YEAR)));
//#endif


//#if 1438616305
            Employee employee = (Employee) session
                                .getValue(Login.EMPLOYEE);
//#endif


//#if -787438337
            Employee employee = (Employee) request
                                .get(Login.EMPLOYEE);
//#endif


//#if 1083422400
            q.setAtendente(employee);
//#endif


//#if -1408604996
            q.setSituacao(Situation.QUEIXA_FECHADA);
//#endif


//#if -813029548
            facade.updateComplaint(q);
//#endif


//#if 138838491
            out.println(HTMLCode.htmlPageAdministrator("Operation executed",
                        "Complaint updated" + "<P>" + obsQueixa + "</P>"));
//#endif

        }

//#if 820764354
        catch (Exception e) { //1

//#if 265122342
            out.println(lib.util.HTMLCode
                        .errorPageAdministrator(e.getMessage()));
//#endif


//#if -801948275
            e.printStackTrace(out);
//#endif

        }

//#endif

        finally {

//#if 986916301
            out.close();
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

