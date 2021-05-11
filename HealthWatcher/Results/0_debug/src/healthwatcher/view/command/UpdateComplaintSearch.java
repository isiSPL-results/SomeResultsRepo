
//#if -1112460437
// Compilation Unit of /UpdateComplaintSearch.java


//#if 1442044989
package healthwatcher.view.command;
//#endif


//#if -497277257
import healthwatcher.Constants;
//#endif


//#if 1617509503
import healthwatcher.model.complaint.AnimalComplaint;
//#endif


//#if 1145778083
import healthwatcher.model.complaint.Complaint;
//#endif


//#if 2051483937
import healthwatcher.model.complaint.FoodComplaint;
//#endif


//#if -583697232
import healthwatcher.model.complaint.Situation;
//#endif


//#if -1274811274
import healthwatcher.model.complaint.SpecialComplaint;
//#endif


//#if -4022826
import healthwatcher.view.IFacade;
//#endif


//#if 493720843
import java.io.IOException;
//#endif


//#if 1113941076
import java.io.PrintWriter;
//#endif


//#if -858304479
import java.rmi.RemoteException;
//#endif


//#if 571249269
import javax.servlet.http.HttpSession;
//#endif


//#if 800118910
import lib.exceptions.CommunicationException;
//#endif


//#if 683536655
import lib.exceptions.InvalidSessionException;
//#endif


//#if 1413910142
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 1968807930
import lib.exceptions.RepositoryException;
//#endif


//#if 1121900384
import lib.exceptions.SituationFacadeException;
//#endif


//#if 840503430
import lib.exceptions.TransactionException;
//#endif


//#if -268267683
import lib.util.HTMLCode;
//#endif


//#if -88640002
import lib.exceptions.FacadeUnavailableException;
//#endif


//#if 248034936
import lib.exceptions.ObjectNotValidException;
//#endif


//#if 2144343315
public class UpdateComplaintSearch extends
//#if -156342649
    Command
//#endif

{

//#if 1948655820
    public static final String QUEIXA = "queixa";
//#endif


//#if 971320757
    public void execute()
    {

//#if -1111968715
        PrintWriter out= null;
//#endif


//#if 1303214598
        try { //1

//#if -675001436
            out = response.getWriter();
//#endif


//#if -1128224234
            HttpSession session = request.getSession(false);
//#endif


//#if 1871546964
            response.setContentType("text/html");
//#endif


//#if 799558341
            if(session == null) { //1

//#if -1653737879
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if 864842160
            int numQueixa = (new Integer(request.getParameter("numQueixa"))).intValue();
//#endif


//#if -1151365170
            if(! request.isAuthorized()) { //1

//#if -176077706
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if 1241489007
            int numQueixa = (new Integer(request.getInput("numQueixa"))).intValue();
//#endif


//#if -91868996
            Complaint q = facade.searchComplaint(numQueixa);
//#endif


//#if 366374181
            q.addObserver(facade);
//#endif


//#if 1187383759
            session.putValue(UpdateComplaintSearch.QUEIXA, q);
//#endif


//#if -1624965105
            request.put(UpdateComplaintSearch.QUEIXA, q);
//#endif


//#if 418441988
            if(q.getSituacao() != Situation.QUEIXA_ABERTA) { //1

//#if 1246184402
                throw new SituationFacadeException("Complaint not open");
//#endif

            }

//#endif


//#if -811064155
            out.println(HTMLCode.open("Update complaint"));
//#endif


//#if -251381269
            out.println("<script language=\"javascript\">");
//#endif


//#if -1918487939
            out.println("function submeterDados(modulo)");
//#endif


//#if 1116154263
            out.println("{");
//#endif


//#if -1709681072
            String a1 = "\"";
//#endif


//#if -822177391
            String a2 = "\"";
//#endif


//#if 1146426378
            out.println("   var f = document.formAlterarQueixa2;");
//#endif


//#if -334323834
            out.println("   if(f.obsQueixa.value ==" + a1 + a2 + ")");
//#endif


//#if -285109925
            out.println("   {");
//#endif


//#if -48521394
            out.println("           alert(\"Digite o parecer da queixa!\");");
//#endif


//#if 859529433
            out.println("           f.obsQueixa.select();");
//#endif


//#if 2142824583
            out.println("           return;");
//#endif


//#if 1116213845
            out.println("   }");
//#endif


//#if -1795674248
            out.println("   f.submit();");
//#endif


//#if 1489897437
            out.println("}");
//#endif


//#if 1415491636
            out.println("//--></script>");
//#endif


//#if -1832450399
            out.println("<body><h1>Update Complaint:</h1>");
//#endif


//#if 2022828849
            out.println("<form method=\"POST\" name=\"formAlterarQueixa2\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateComplaintData\">");
//#endif


//#if -634469356
            out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateComplaintData\">");
//#endif


//#if 401246588
            out.println("<div align=\"center\"><center><h4>Complaint : " + numQueixa+ "</h4></center></div>");
//#endif


//#if -812441553
            String t = null;
//#endif


//#if 479791351
            if(q instanceof SpecialComplaint) { //1

//#if 413882969
                t = "Special complaint";
//#endif

            } else

//#if 988704717
                if(q instanceof FoodComplaint) { //1

//#if 1253845047
                    t = "Food complaint";
//#endif

                } else

//#if -1873387318
                    if(q instanceof AnimalComplaint) { //1

//#if 468457413
                        t = "Animal complaint";
//#endif

                    }

//#endif


//#endif


//#endif


//#if 20862658
            out.println("<div align=\"center\"><center><p><strong>Complaint kind: "+t+"</strong></p></center></div>");
//#endif


//#if 387314734
            out.println("<div align=\"center\"><center><p><strong>Description: "+ q.getDescricao() + "</strong></p></center></div>");
//#endif


//#if -1566264935
            out.println("<div align=\"center\"><center><p><strong>Observation (complaint's solution):</strong><br><textarea rows=\"5\" name=\"obsQueixa\" cols=\"22\"></textarea></p></center></div>");
//#endif


//#if 1945670385
            out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"UpdateComplaintData\" name=\"operation\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" name=\"bt2\"></h4></center></div></form>");
//#endif


//#if -943734118
            out.println(HTMLCode.closeAdministrator());
//#endif

        }

//#if 1926409685
        catch(RemoteException e) { //1

//#if -977635689
            out.println(HTMLCode.errorPage("Comunitation error, please try again later."));
//#endif

        }

//#endif


//#if -479528594
        catch (InvalidSessionException e) { //1

//#if 159872255
            out.println(HTMLCode.errorPageAdministrator("<p>Ivalid Session! <br>You must <a href=\""+Constants.SYSTEM_LOGIN+"\">login</a> again!"));
//#endif

        }

//#endif


//#if -1357260455
        catch (RepositoryException e) { //1

//#if -1800136679
            out.println(HTMLCode.errorPage(e.getMessage()));
//#endif


//#if -33760352
            e.printStackTrace();
//#endif

        }

//#endif


//#if -1250343075
        catch (ObjectNotFoundException e) { //1

//#if -1697462710
            out.println(HTMLCode.errorPageAdministrator("Complaint does not exist!"));
//#endif

        }

//#endif


//#if -839970461
        catch (CommunicationException e) { //1

//#if 329687230
            out.println(HTMLCode.errorPage(e.getMessage()));
//#endif


//#if 802840005
            e.printStackTrace();
//#endif

        }

//#endif


//#if 1535456811
        catch (TransactionException e) { //1

//#if 1580033386
            out.println(HTMLCode.errorPage(e.getMessage()));
//#endif


//#if 1448909937
            e.printStackTrace();
//#endif

        }

//#endif


//#if -1571893627
        catch (SituationFacadeException e) { //1

//#if -650210342
            out.println(HTMLCode.errorPageAdministrator("This complaint's status is closed!"));
//#endif

        }

//#endif


//#if 1013043989
        catch(IOException e) { //1

//#if -100244373
            out.println(HTMLCode.errorPage(e.getMessage()));
//#endif

        }

//#endif

        finally {

//#if 799857613
            out.close();
//#endif

        }

//#endif

    }

//#endif


//#if 143757869
    public void execute() throws Exception
    {

//#if 2093261098
        PrintWriter out = response.getWriter();
//#endif


//#if 154806769
        try { //1

//#if -380265898
            if(! request.isAuthorized()) { //1

//#if -1589331374
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if 564232951
            int numQueixa = (new Integer(request.getInput("numQueixa"))).intValue();
//#endif


//#if -369572556
            Complaint q = facade.searchComplaint(numQueixa);
//#endif


//#if -861700179
            q.addObserver(facade);
//#endif


//#if 1968307351
            request.put(UpdateComplaintSearch.QUEIXA, q);
//#endif


//#if -166706820
            if(q.getSituacao() != Situation.QUEIXA_ABERTA) { //1

//#if 516351580
                throw new ObjectNotValidException("Complaint not open");
//#endif

            }

//#endif


//#if -829939923
            out.println(HTMLCode.open("Update complaint"));
//#endif


//#if -836530077
            out.println("<script language=\"javascript\">");
//#endif


//#if 2098775797
            out.println("function submeterDados(modulo)");
//#endif


//#if -2081775089
            out.println("{");
//#endif


//#if -2059112232
            String a1 = "\"";
//#endif


//#if -1171608551
            String a2 = "\"";
//#endif


//#if 1459137666
            out.println("   var f = document.formAlterarQueixa2;");
//#endif


//#if -1294067698
            out.println("   if(f.obsQueixa.value ==" + a1 + a2 + ")");
//#endif


//#if 1166124515
            out.println("   {");
//#endif


//#if -180684346
            out.println("           alert(\"Digite o parecer da queixa!\");");
//#endif


//#if 2145774929
            out.println("           f.obsQueixa.select();");
//#endif


//#if -1567742209
            out.println("           return;");
//#endif


//#if -2081715507
            out.println("   }");
//#endif


//#if -1248235024
            out.println("   f.submit();");
//#endif


//#if -1353835419
            out.println("}");
//#endif


//#if -2108376388
            out.println("//--></script>");
//#endif


//#if 1877368089
            out.println("<body><h1>Update Complaint:</h1>");
//#endif


//#if -1664380999
            out.println("<form method=\"POST\" name=\"formAlterarQueixa2\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateComplaintData\">");
//#endif


//#if 1938915468
            out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateComplaintData\">");
//#endif


//#if -1698081276
            out.println("<div align=\"center\"><center><h4>Complaint : " + numQueixa+ "</h4></center></div>");
//#endif


//#if 146117799
            String t = null;
//#endif


//#if -201945217
            if(q instanceof SpecialComplaint) { //1

//#if -144138055
                t = "Special complaint";
//#endif

            } else

//#if 894946495
                if(q instanceof FoodComplaint) { //1

//#if 656280526
                    t = "Food complaint";
//#endif

                } else

//#if 1467901917
                    if(q instanceof AnimalComplaint) { //1

//#if -278846237
                        t = "Animal complaint";
//#endif

                    }

//#endif


//#endif


//#endif


//#if 1304945978
            out.println("<div align=\"center\"><center><p><strong>Complaint kind: "+t+"</strong></p></center></div>");
//#endif


//#if 385460406
            out.println("<div align=\"center\"><center><p><strong>Description: "+ q.getDescricao() + "</strong></p></center></div>");
//#endif


//#if 202886673
            out.println("<div align=\"center\"><center><p><strong>Observation (complaint's solution):</strong><br><textarea rows=\"5\" name=\"obsQueixa\" cols=\"22\"></textarea></p></center></div>");
//#endif


//#if -233811079
            out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"UpdateComplaintData\" name=\"operation\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" name=\"bt2\"></h4></center></div></form>");
//#endif


//#if 557651218
            out.println(HTMLCode.closeAdministrator());
//#endif

        }

//#if -1325086154
        catch (InvalidSessionException e) { //1

//#if 410470116
            out.println(HTMLCode.errorPageAdministrator("<p>Ivalid Session! <br>You must <a href=\""+Constants.SYSTEM_LOGIN+"\">login</a> again!"));
//#endif

        }

//#endif


//#if -1349824991
        catch (RepositoryException e) { //1

//#if -1873827515
            out.println(HTMLCode.errorPage(e.getMessage()));
//#endif


//#if 917219020
            e.printStackTrace();
//#endif

        }

//#endif


//#if -2095900635
        catch (ObjectNotFoundException e) { //1

//#if 1266577427
            out.println(HTMLCode.errorPageAdministrator("Complaint does not exist!"));
//#endif

        }

//#endif


//#if 1626605467
        catch (CommunicationException e) { //1

//#if 1624218627
            throw new FacadeUnavailableException();
//#endif

        }

//#endif


//#if 1765956195
        catch (TransactionException e) { //1

//#if -851239241
            out.println(HTMLCode.errorPage(e.getMessage()));
//#endif


//#if -1830724802
            e.printStackTrace();
//#endif

        }

//#endif


//#if 1609347871
        catch (ObjectNotValidException e) { //1

//#if -2115814590
            out.println(HTMLCode.errorPageAdministrator("This complaint's status is closed!"));
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if 1227489083
    public UpdateComplaintSearch(IFacade f)
    {

//#if -1902906797
        super(f);
//#endif

    }

//#endif

}

//#endif


//#endif

