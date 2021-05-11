
//#if -1984511081
// Compilation Unit of /UpdateMedicalSpecialityList.java


//#if 637018794
package healthwatcher.view.command;
//#endif


//#if -566842460
import healthwatcher.Constants;
//#endif


//#if 428070144
import healthwatcher.model.healthguide.MedicalSpeciality;
//#endif


//#if 2048218569
import healthwatcher.view.IFacade;
//#endif


//#if -754870152
import java.io.IOException;
//#endif


//#if -134649919
import java.io.PrintWriter;
//#endif


//#if -1191855445
import lib.exceptions.CommunicationException;
//#endif


//#if -938126206
import lib.exceptions.InvalidSessionException;
//#endif


//#if -207752719
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if 637187309
import lib.exceptions.RepositoryException;
//#endif


//#if -1785030157
import lib.exceptions.TransactionException;
//#endif


//#if -274036214
import lib.util.HTMLCode;
//#endif


//#if 210604870
import lib.util.IteratorDsk;
//#endif


//#if -1254786645
import lib.exceptions.FacadeUnavailableException;
//#endif


//#if -1760670895
public class UpdateMedicalSpecialityList extends
//#if 886489657
    Command
//#endif

{

//#if -428372377
    public void execute()
    {

//#if -608732398
        PrintWriter out = null;
//#endif


//#if -2092771421
        try { //1

//#if -1477244063
            try { //1

//#if -846574209
                out = response.getWriter();
//#endif

            }

//#if 2092447749
            catch (IOException e1) { //1

//#if 639665335
                e1.printStackTrace();
//#endif

            }

//#endif


//#endif


//#if -1720661650
            if(! request.isAuthorized()) { //1

//#if 426462524
                throw new InvalidSessionException("Invalid Session! <br><a href=\"" + Constants.SYSTEM_LOGIN + "\">Try again</a>");
//#endif

            }

//#endif


//#if 1520570249
            out.println("Queries - Medical Speciality information");
//#endif


//#if 446040019
            out.println("<body><h1>Queries:<br>Querie about medical specialities</h1>");
//#endif


//#if 1460274636
            out.println("<p>Choose a speciality: </p>");
//#endif


//#if 939688410
            out.println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateMedicalSpecialitySearch\">");
//#endif


//#if 2129903198
            out.println("<div align=\"center\"><center><p><select name=\"specialityCode\" size=\"1\">");
//#endif


//#if 794137822
            IteratorDsk repTP = facade.getSpecialityList();
//#endif


//#if -634832448
            if(repTP == null || !repTP.hasNext()) { //1

//#if -63074227
                out.println("</select></p></center></div>");
//#endif


//#if 1485196990
                out.println("<p><font color=\"red\"><b> There isn't any medical speciality.</b></font></p>");
//#endif

            } else {

//#if -1920274866
                MedicalSpeciality speciality;
//#endif


//#if -1705192149
                do {

//#if 1263824506
                    speciality = (MedicalSpeciality) repTP.next();
//#endif


//#if 288420455
                    out.println("<option value=\"" + speciality.getCodigo() + "\"> "
                                + speciality.getDescricao() + " </OPTION>");
//#endif

                } while (repTP.hasNext()); //1

//#endif


//#if 1116874885
                repTP.close();
//#endif


//#if 1902716307
                out.println("</select></p></center></div>");
//#endif


//#if -1823711871
                out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"UpdateMedicalSpecialitySearch\" name=\"operation\"></p></center></div></form>");
//#endif

            }

//#endif


//#if -1714344710
            out.println(HTMLCode.closeAdministrator());
//#endif

        }

//#if -517581345
        catch (ObjectNotFoundException e) { //1

//#if -254393939
            out.println("There isn't any medical speciality");
//#endif

        }

//#endif


//#if -385451813
        catch (RepositoryException e) { //1

//#if -2137732137
            e.printStackTrace();
//#endif

        }

//#endif


//#if 1596753641
        catch (TransactionException e) { //1

//#if -291090075
            e.printStackTrace();
//#endif

        }

//#endif


//#if -2063258975
        catch (CommunicationException e) { //1

//#if 1665652419
            e.printStackTrace();
//#endif

        }

//#endif


//#if 253233136
        catch (InvalidSessionException e) { //1

//#if -1552953152
            out.println(e.getMessage());
//#endif

        }

//#endif

        finally {

//#if -491307667
            out.close();
//#endif

        }

//#endif

    }

//#endif


//#if -995559554
    public UpdateMedicalSpecialityList(IFacade f)
    {

//#if 691388104
        super(f);
//#endif

    }

//#endif


//#if -262179013
    public void execute() throws Exception
    {

//#if 2058614418
        PrintWriter out = response.getWriter();
//#endif


//#if 212952409
        try { //1

//#if -1775050972
            if(! request.isAuthorized()) { //1

//#if 677390277
                throw new InvalidSessionException("Invalid Session! <br><a href=\"" + Constants.SYSTEM_LOGIN + "\">Try again</a>");
//#endif

            }

//#endif


//#if -1840483308
            IteratorDsk repTP = facade.getSpecialityList();
//#endif


//#if 1253660863
            out.println("Queries - Medical Speciality information");
//#endif


//#if 1900788829
            out.println("<body><h1>Queries:<br>Querie about medical specialities</h1>");
//#endif


//#if 937714262
            out.println("<p>Choose a speciality: </p>");
//#endif


//#if -207820316
            out.println("<form method=\"POST\" action=\""+Constants.SYSTEM_ACTION+"?operation=UpdateMedicalSpecialitySearch\">");
//#endif


//#if -1219289368
            out.println("<div align=\"center\"><center><p><select name=\"specialityCode\" size=\"1\">");
//#endif


//#if 1005956854
            if(repTP == null || !repTP.hasNext()) { //1

//#if 920955133
                out.println("</select></p></center></div>");
//#endif


//#if -941053938
                out.println("<p><font color=\"red\"><b> There isn't any medical speciality.</b></font></p>");
//#endif

            } else {

//#if 996982927
                MedicalSpeciality speciality;
//#endif


//#if 2069906348
                do {

//#if 1012971058
                    speciality = (MedicalSpeciality) repTP.next();
//#endif


//#if -760456273
                    out.println("<option value=\"" + speciality.getCodigo() + "\"> "
                                + speciality.getDescricao() + " </OPTION>");
//#endif

                } while (repTP.hasNext()); //1

//#endif


//#if -462516090
                repTP.close();
//#endif


//#if 277370324
                out.println("</select></p></center></div>");
//#endif


//#if 1708894944
                out.println("  <div align=\"center\"><center><p><input type=\"submit\" value=\"UpdateMedicalSpecialitySearch\" name=\"operation\"></p></center></div></form>");
//#endif

            }

//#endif


//#if -1383690492
            out.println(HTMLCode.closeAdministrator());
//#endif

        }

//#if -68885933
        catch (ObjectNotFoundException e) { //1

//#if -204474418
            out.println("There isn't any medical speciality");
//#endif

        }

//#endif


//#if -1555734705
        catch (RepositoryException e) { //1

//#if 941505647
            e.printStackTrace();
//#endif

        }

//#endif


//#if -322277643
        catch (TransactionException e) { //1

//#if -1668042645
            e.printStackTrace();
//#endif

        }

//#endif


//#if 583614381
        catch (CommunicationException e) { //1

//#if -704231980
            throw new FacadeUnavailableException();
//#endif

        }

//#endif


//#if 701928548
        catch (InvalidSessionException e) { //1

//#if 216620518
            out.println(e.getMessage());
//#endif

        }

//#endif


//#endif

    }

//#endif

}

//#endif


//#endif

