
//#if 560128689
// Compilation Unit of /GetDataForSearchByDiseaseType.java


//#if -1801100108
package healthwatcher.view.command;
//#endif


//#if 538608302
import healthwatcher.Constants;
//#endif


//#if 117548623
import healthwatcher.model.complaint.DiseaseType;
//#endif


//#if 722643583
import healthwatcher.view.IFacade;
//#endif


//#if -860978046
import java.io.IOException;
//#endif


//#if -240757813
import java.io.PrintWriter;
//#endif


//#if 1189376778
import java.rmi.RemoteException;
//#endif


//#if 979859509
import lib.exceptions.CommunicationException;
//#endif


//#if -1604065881
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 1728770979
import lib.exceptions.RepositoryException;
//#endif


//#if 1989292541
import lib.exceptions.TransactionException;
//#endif


//#if 47640724
import lib.util.HTMLCode;
//#endif


//#if 1216227452
import lib.util.IteratorDsk;
//#endif


//#if -2061934027
import lib.exceptions.FacadeUnavailableException;
//#endif


//#if -2072497394
public class GetDataForSearchByDiseaseType extends
//#if -1888990423
    Command
//#endif

{

//#if 1393547339
    public void execute() throws Exception
    {

//#if 360822702
        PrintWriter out = response.getWriter();
//#endif


//#if -1822245003
        try { //1

//#if -123247243
            IteratorDsk repTP = facade.getDiseaseTypeList();
//#endif


//#if 648126924
            out.println(HTMLCode.open("Queries - Disease information"));
//#endif


//#if -1876827482
            out.println("<body><h1>Queries:<br>Querie about diseases</h1>");
//#endif


//#if 803276721
            out.println("<p>Choose a disease: </p>");
//#endif


//#if 298386137
            out
            .println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=SearchDiseaseData\">");
//#endif


//#if 495436734
            out
            .println("<div align=\"center\"><center><p><select name=\"codTipoDoenca\" size=\"1\">");
//#endif


//#if 89924794
            if(repTP == null || !repTP.hasNext()) { //1

//#if -1588511142
                out.println("</select></p></center></div>");
//#endif


//#if 7331826
                out
                .println("<p><font color=\"red\"><b> There isn't diseases registered.</b></font></p>");
//#endif

            } else {

//#if 1761124300
                DiseaseType tp;
//#endif


//#if -530991360
                do {

//#if -655425544
                    tp = (DiseaseType) repTP.next();
//#endif


//#if -650650086
                    out.println("<option value=\"" + tp.getCode() + "\"> "
                                + tp.getName() + " </OPTION>");
//#endif

                } while (repTP.hasNext()); //1

//#endif


//#if 807100890
                repTP.close();
//#endif


//#if -1894573016
                out.println("</select></p></center></div>");
//#endif


//#if -1262378939
                out
                .println("<div align=\"center\"><center><p><input type=\"submit\" value=\"SearchDiseaseData\" name=\"operation\"></p></center></div></form>");
//#endif

            }

//#endif


//#if -1008806695
            out.println(HTMLCode.closeQueries());
//#endif

        }

//#if 566659021
        catch (ObjectNotFoundException e) { //1

//#if 861574253
            out.println(HTMLCode
                        .errorPageQueries("There isn't registered diseases"));
//#endif

        }

//#endif


//#if -847719991
        catch (RepositoryException e) { //1

//#if 471032566
            out.println("</select></p></center></div>");
//#endif


//#if 968381702
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 151342011
        catch (TransactionException e) { //1

//#if -1355127878
            out.println("</select></p></center></div>");
//#endif


//#if -330650942
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 465568499
        catch (CommunicationException e) { //1

//#if -1452690192
            throw new FacadeUnavailableException();
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if 634597207
    public void execute()
    {

//#if 117412899
        PrintWriter out = null;
//#endif


//#if 12219201
        response.setContentType("text/html");
//#endif


//#if -1322339724
        try { //1

//#if -162925762
            out = response.getWriter();
//#endif

        }

//#if -673020319
        catch (IOException e1) { //1

//#if -1936979143
            e1.printStackTrace();
//#endif

        }

//#endif


//#endif


//#if 34765459
        out.println(HTMLCode.open("Queries - Disease information"));
//#endif


//#if 1158442559
        out.println("<body><h1>Queries:<br>Querie about diseases</h1>");
//#endif


//#if 1973390922
        out.println("<p>Choose a disease: </p>");
//#endif


//#if -881617056
        out
        .println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=SearchDiseaseData\">");
//#endif


//#if -382602307
        try { //2

//#if 901432637
            out
            .println("<div align=\"center\"><center><p><select name=\"codTipoDoenca\" size=\"1\">");
//#endif


//#if -1904860842
            IteratorDsk repTP = facade.getDiseaseTypeList();
//#endif


//#if 1877825465
            if(repTP == null || !repTP.hasNext()) { //1

//#if -1535333997
                out.println("</select></p></center></div>");
//#endif


//#if 1013033177
                out
                .println("<p><font color=\"red\"><b> There isn't diseases registered.</b></font></p>");
//#endif

            } else {

//#if -13466189
                DiseaseType tp;
//#endif


//#if 1444870759
                do {

//#if -1581312780
                    tp = (DiseaseType) repTP.next();
//#endif


//#if -448620010
                    out.println("<option value=\"" + tp.getCode() + "\"> "
                                + tp.getName() + " </OPTION>");
//#endif

                } while (repTP.hasNext()); //1

//#endif


//#if -967489599
                repTP.close();
//#endif


//#if 1421538255
                out.println("</select></p></center></div>");
//#endif


//#if -524070530
                out
                .println("<div align=\"center\"><center><p><input type=\"submit\" value=\"SearchDiseaseData\" name=\"operation\"></p></center></div></form>");
//#endif

            }

//#endif


//#if -1418460742
            out.println(HTMLCode.closeQueries());
//#endif

        }

//#if 338752819
        catch (RemoteException e) { //1

//#if 1644177560
            out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
//#endif


//#if -1376173234
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if -2067705669
        catch (ObjectNotFoundException e) { //1

//#if 889225676
            out.println(HTMLCode
                        .errorPageQueries("There isn't registered diseases"));
//#endif

        }

//#endif


//#if 1596539319
        catch (RepositoryException e) { //1

//#if 180360469
            out.println("</select></p></center></div>");
//#endif


//#if 199946055
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if -1386030707
        catch (TransactionException e) { //1

//#if -1244031978
            out.println("</select></p></center></div>");
//#endif


//#if 493139942
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 519136325
        catch (CommunicationException e) { //1

//#if 1986275091
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif

        finally {

//#if -676825498
            out.close();
//#endif

        }

//#endif

    }

//#endif


//#if 1905137185
    public GetDataForSearchByDiseaseType(IFacade f)
    {

//#if -344217191
        super(f);
//#endif

    }

//#endif

}

//#endif


//#endif

