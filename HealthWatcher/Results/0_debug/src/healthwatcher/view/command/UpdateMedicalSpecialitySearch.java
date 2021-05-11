
//#if 585651626
// Compilation Unit of /UpdateMedicalSpecialitySearch.java


//#if -639539649
package healthwatcher.view.command;
//#endif


//#if -1559035463
import healthwatcher.Constants;
//#endif


//#if 849808085
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif


//#if 1591397268
import healthwatcher.view.IFacade;
//#endif


//#if 1312702733
import java.io.IOException;
//#endif


//#if 1932922966
import java.io.PrintWriter;
//#endif


//#if -511490048
import lib.exceptions.CommunicationException;
//#endif


//#if -1321635379
import lib.exceptions.InvalidSessionException;
//#endif


//#if -591261892
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 1321152440
import lib.exceptions.RepositoryException;
//#endif


//#if -2056947576
import lib.exceptions.TransactionException;
//#endif


//#if -843951137
import lib.util.HTMLCode;
//#endif


//#if -1763552128
import lib.exceptions.FacadeUnavailableException;
//#endif


//#if -2063229072
public class UpdateMedicalSpecialitySearch extends
//#if 1495986769
    Command
//#endif

{

//#if 2070051038
    public static final String SPECIALITY = "speciality";
//#endif


//#if 441211519
    public void execute()
    {

//#if 2061495053
        PrintWriter out=null;
//#endif


//#if -475067682
        try { //1

//#if 76304949
            try { //1

//#if 2077799914
                out = response.getWriter();
//#endif

            }

//#if 1404473290
            catch (IOException e1) { //1

//#if 1212525482
                e1.printStackTrace();
//#endif

            }

//#endif


//#endif


//#if -1474833342
            if(! request.isAuthorized()) { //1

//#if -634966397
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if -1030071935
            out.println("Update Medical Speciality");
//#endif


//#if -579408905
            out.println("<script language=\"javascript\">");
//#endif


//#if -1896482935
            out.println("function submeterDados(modulo)");
//#endif


//#if 1760868515
            out.println("{");
//#endif


//#if -424672572
            String a1 = "\"";
//#endif


//#if 462831109
            String a2 = "\"";
//#endif


//#if -1779729855
            out.println("   var f = document.formAlterarUnidade2;");
//#endif


//#if -566953086
            out.println("   if(f.descricao.value ==" + a1 + a2 + ")");
//#endif


//#if -696576305
            out.println("   {");
//#endif


//#if 63459171
            out.println("           alert(\"Digite a nova descri��o da especialidade!\");");
//#endif


//#if -1334917523
            out.println("           f.descricao.select();");
//#endif


//#if 1984560787
            out.println("           return;");
//#endif


//#if 1760928097
            out.println("   }");
//#endif


//#if -193051973
            out.println("   f.operation.value = \"UpdateMedicalSpecialityData\";");
//#endif


//#if 297230212
            out.println("   f.submit();");
//#endif


//#if 1078431057
            out.println("}");
//#endif


//#if 1092023464
            out.println("//--></script>");
//#endif


//#if 1763086578
            out.println("<body><h1>Update Medical Speciality:</h1>");
//#endif


//#if 32457229
            int specialityCode = (new Integer(request.getInput("specialityCode"))).intValue();
//#endif


//#if -203676310
            MedicalSpeciality speciality = facade.searchSpecialitiesByCode(specialityCode);
//#endif


//#if -1538674921
            speciality.addObserver(facade);
//#endif


//#if -1694121177
            request.put(SPECIALITY, speciality);
//#endif


//#if -390331448
            out.println("<form method=\"POST\" name=\"formAlterarUnidade2\" action=\"http://"+Constants.SERVLET_SERVER_PATH+"HWServlet\">");
//#endif


//#if -126758277
            out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateMedicalSpecialityData\">" );
//#endif


//#if -357237250
            out.println("<div align=\"center\"><center><h4>Medical Speciality: " + specialityCode + "</h4></center></div>");
//#endif


//#if -1081964802
            out.println("<div align=\"center\"><center><p><strong>Name:</strong><br><input type=\"text\" name=\"descricao\" value=\"" + speciality.getDescricao() + "\" size=\"60\"></p></center></div>");
//#endif


//#if 1813191232
            out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"UpdateMedicalSpecialityData\" name=\"operation\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" name=\"bt2\"></h4></center></div></form>");
//#endif


//#if -2011866458
            out.println(HTMLCode.closeAdministrator());
//#endif

        }

//#if 1965211517
        catch (ObjectNotFoundException e) { //1

//#if -1850521031
            out.println("Medical Speciality does not exist!");
//#endif

        }

//#endif


//#if -1558941298
        catch (InvalidSessionException e) { //1

//#if 1750714866
            out.println(e.getMessage());
//#endif

        }

//#endif


//#if 897868153
        catch (RepositoryException e) { //1

//#if -1276834932
            e.printStackTrace();
//#endif

        }

//#endif


//#if -1570000373
        catch (TransactionException e) { //1

//#if -408493916
            e.printStackTrace();
//#endif

        }

//#endif


//#if -182053565
        catch(CommunicationException e) { //1

//#if -2047600320
            out.println(e.getMessage());
//#endif

        }

//#endif

        finally {

//#if 1802310977
            out.close();
//#endif

        }

//#endif

    }

//#endif


//#if 254766496
    public UpdateMedicalSpecialitySearch(IFacade f)
    {

//#if -1048067281
        super(f);
//#endif

    }

//#endif


//#if 2089154595
    public void execute() throws Exception
    {

//#if -1358972713
        PrintWriter out = response.getWriter();
//#endif


//#if 2088959582
        try { //1

//#if 869734549
            if(! request.isAuthorized()) { //1

//#if -2086146119
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if -634162080
            int specialityCode = (new Integer(request.getInput("specialityCode"))).intValue();
//#endif


//#if 1377751165
            MedicalSpeciality speciality = facade.searchSpecialitiesByCode(specialityCode);
//#endif


//#if -1871514332
            speciality.addObserver(facade);
//#endif


//#if 634600116
            request.put(SPECIALITY, speciality);
//#endif


//#if -1281932658
            out.println("Update Medical Speciality");
//#endif


//#if -487294972
            out.println("<script language=\"javascript\">");
//#endif


//#if 244392662
            out.println("function submeterDados(modulo)");
//#endif


//#if 809363824
            out.println("{");
//#endif


//#if 825249047
            String a1 = "\"";
//#endif


//#if 1712752728
            String a2 = "\"";
//#endif


//#if -2097653996
            out.println("   var f = document.formAlterarUnidade2;");
//#endif


//#if -2006388459
            out.println("   if(f.descricao.value ==" + a1 + a2 + ")");
//#endif


//#if -188672286
            out.println("   {");
//#endif


//#if -889405706
            out.println("           alert(\"Digite a nova descri��o da especialidade!\");");
//#endif


//#if -1111716166
            out.println("           f.descricao.select();");
//#endif


//#if 1783407008
            out.println("           return;");
//#endif


//#if 809423406
            out.println("   }");
//#endif


//#if -1068164722
            out.println("   f.operation.value = \"UpdateMedicalSpecialityData\";");
//#endif


//#if 778548241
            out.println("   f.submit();");
//#endif


//#if 1586335076
            out.println("}");
//#endif


//#if -858375941
            out.println("//--></script>");
//#endif


//#if -1782464513
            out.println("<body><h1>Update Medical Speciality:</h1>");
//#endif


//#if 1615334677
            out.println("<form method=\"POST\" name=\"formAlterarUnidade2\" action=\"http://"+Constants.SERVLET_SERVER_PATH+"HWServlet\">");
//#endif


//#if -1353822264
            out.println("<input type=\"hidden\" name=\"operation\" value=\"UpdateMedicalSpecialityData\">" );
//#endif


//#if -282660917
            out.println("<div align=\"center\"><center><h4>Medical Speciality: " + specialityCode + "</h4></center></div>");
//#endif


//#if -1528412853
            out.println("<div align=\"center\"><center><p><strong>Name:</strong><br><input type=\"text\" name=\"descricao\" value=\"" + speciality.getDescricao() + "\" size=\"60\"></p></center></div>");
//#endif


//#if 1263419199
            out.println("<div align=\"center\"><center><h4><input type=\"button\" value=\"Update\" name=\"bt1\" onClick=\"javascript:submeterDados();\"><input type=\"reset\" value=\"Clear\" name=\"bt2\"></h4></center></div></form>");
//#endif


//#if 1865217331
            out.println(HTMLCode.closeAdministrator());
//#endif

        }

//#if 1376432073
        catch (ObjectNotFoundException e) { //1

//#if -394016315
            out.println("Medical Speciality does not exist!");
//#endif

        }

//#endif


//#if 2147246554
        catch (InvalidSessionException e) { //1

//#if -1447445526
            out.println(e.getMessage());
//#endif

        }

//#endif


//#if 220747717
        catch (RepositoryException e) { //1

//#if -2034992946
            e.printStackTrace();
//#endif

        }

//#endif


//#if -1085897409
        catch (TransactionException e) { //1

//#if -1019896402
            e.printStackTrace();
//#endif

        }

//#endif


//#if 1184426871
        catch(CommunicationException e) { //1

//#if -129330720
            throw new FacadeUnavailableException();
//#endif

        }

//#endif


//#endif

    }

//#endif

}

//#endif


//#endif

