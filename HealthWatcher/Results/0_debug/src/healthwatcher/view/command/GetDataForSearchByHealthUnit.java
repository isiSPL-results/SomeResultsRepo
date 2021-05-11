
//#if -466001881
// Compilation Unit of /GetDataForSearchByHealthUnit.java


//#if -1663369492
package healthwatcher.view.command;
//#endif


//#if -2082080538
import healthwatcher.Constants;
//#endif


//#if 1277292878
import healthwatcher.model.healthguide.HealthUnit;
//#endif


//#if 1696917831
import healthwatcher.view.IFacade;
//#endif


//#if -1721903430
import java.io.IOException;
//#endif


//#if -1101683197
import java.io.PrintWriter;
//#endif


//#if 1552401362
import java.rmi.RemoteException;
//#endif


//#if 1777052781
import lib.exceptions.CommunicationException;
//#endif


//#if 1634089071
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if -680138133
import lib.exceptions.RepositoryException;
//#endif


//#if 327554101
import lib.exceptions.TransactionException;
//#endif


//#if 690319564
import lib.util.HTMLCode;
//#endif


//#if 297344324
import lib.util.IteratorDsk;
//#endif


//#if 846772845
import lib.exceptions.FacadeUnavailableException;
//#endif


//#if -185530480
public class GetDataForSearchByHealthUnit extends
//#if -1106154416
    Command
//#endif

{

//#if -460179772
    public void execute() throws Exception
    {

//#if 234503665
        PrintWriter out = response.getWriter();
//#endif


//#if -1595831048
        try { //1

//#if 2140106968
            IteratorDsk repUS = facade.getPartialHealthUnitList();
//#endif


//#if 789857122
            out.println(HTMLCode.open("Queries - Specialties"));
//#endif


//#if -461411749
            out
            .println("<body><h1>Queries:<br>Search Specialties of a Health unit</h1>");
//#endif


//#if -1870624627
            out.println("<p>Choose a health unit: </p>");
//#endif


//#if 1045885238
            out.println("<form method=\"POST\"action=\""+Constants.SYSTEM_ACTION+"?operation=SearchSpecialtiesByHealthUnit\">");
//#endif


//#if 1916067458
            out
            .println("<div align=\"center\"><center><p><select name=\"codUnidadeSaude\" size=\"1\">");
//#endif


//#if -1643095272
            if(!repUS.hasNext()) { //1

//#if 1794156839
                out.println("</select></p></center></div>");
//#endif


//#if -3124602
                out.println("<P> There isn't registered health units.</P>");
//#endif

            } else {

//#if 1868730610
                HealthUnit us;
//#endif


//#if -165590394
                do {

//#if 1526083292
                    us = (HealthUnit) repUS.next();
//#endif


//#if -1206706495
                    out.println("<option value=\"" + us.getCode() + "\"> "
                                + us.getDescription() + " </OPTION>");
//#endif

                } while (repUS.hasNext()); //1

//#endif


//#if -673112096
                repUS.close();
//#endif


//#if -1070395888
                out.println("</select></p></center></div>");
//#endif


//#if 1223355594
                out
                .println("<div align=\"center\"><center><p><input type=\"submit\" value=\"SearchSpecialtiesByHealthUnit\" name=\"operation\"></p></center></div></form>");
//#endif

            }

//#endif


//#if 1091882185
            out.println(HTMLCode.closeQueries());
//#endif

        }

//#if -616035292
        catch (ObjectNotFoundException e) { //1

//#if 854250420
            out.println("</select></p></center></div>");
//#endif


//#if 1303301384
            out.println("<P> " + e.getMessage() + " </P>");
//#endif


//#if -1267012788
            out.println("<P> Nenhuma unidade de saude foi cadastrada</P>");
//#endif

        }

//#endif


//#if 1042291104
        catch (RepositoryException e) { //1

//#if -1957983823
            out.println("</select></p></center></div>");
//#endif


//#if 316219435
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if -1387856188
        catch (TransactionException e) { //1

//#if -1931188121
            out.println("</select></p></center></div>");
//#endif


//#if 584953141
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if -1235150916
        catch (CommunicationException e) { //1

//#if 1632081979
            throw new FacadeUnavailableException();
//#endif

        }

//#endif


//#if 58532278
        catch (Exception e) { //1

//#if -772491781
            out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
//#endif


//#if -958202063
            e.printStackTrace(out);
//#endif

        }

//#endif


//#endif

    }

//#endif


//#if -657928706
    public void execute()
    {

//#if -1943691916
        PrintWriter out = null;
//#endif


//#if -9431536
        response.setContentType("text/html");
//#endif


//#if -1853493883
        try { //1

//#if -1113479770
            out = response.getWriter();
//#endif

        }

//#if 1434716313
        catch (IOException e1) { //1

//#if 941732722
            e1.printStackTrace();
//#endif

        }

//#endif


//#endif


//#if 377480188
        out.println(HTMLCode.open("Queries - Specialties"));
//#endif


//#if 1726987393
        out
        .println("<body><h1>Queries:<br>Search Specialties of a Health unit</h1>");
//#endif


//#if -653069645
        out.println("<p>Choose a health unit: </p>");
//#endif


//#if -1309199396
        out.println("<form method=\"POST\"action=\""+Constants.SYSTEM_ACTION+"?operation=SearchSpecialtiesByHealthUnit\">");
//#endif


//#if -1336634612
        try { //2

//#if -977811899
            out
            .println("<div align=\"center\"><center><p><select name=\"codUnidadeSaude\" size=\"1\">");
//#endif


//#if 1416897141
            IteratorDsk repUS = facade.getPartialHealthUnitList();
//#endif


//#if -1553683915
            if(!repUS.hasNext()) { //1

//#if -975632367
                out.println("</select></p></center></div>");
//#endif


//#if -2029888164
                out.println("<P> There isn't registered health units.</P>");
//#endif

            } else {

//#if -1734515206
                HealthUnit us;
//#endif


//#if -1294540162
                do {

//#if 946789757
                    us = (HealthUnit) repUS.next();
//#endif


//#if 461826722
                    out.println("<option value=\"" + us.getCode() + "\"> "
                                + us.getDescription() + " </OPTION>");
//#endif

                } while (repUS.hasNext()); //1

//#endif


//#if -704582696
                repUS.close();
//#endif


//#if 1449105416
                out.println("</select></p></center></div>");
//#endif


//#if -2146568750
                out
                .println("<div align=\"center\"><center><p><input type=\"submit\" value=\"SearchSpecialtiesByHealthUnit\" name=\"operation\"></p></center></div></form>");
//#endif

            }

//#endif


//#if 1192092966
            out.println(HTMLCode.closeQueries());
//#endif

        }

//#if -1381158685
        catch (RemoteException e) { //1

//#if 1116012223
            out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
//#endif


//#if 275867125
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if -1763779477
        catch (ObjectNotFoundException e) { //1

//#if -1286020688
            out.println("</select></p></center></div>");
//#endif


//#if -1736449908
            out.println("<P> " + e.getMessage() + " </P>");
//#endif


//#if 1885107920
            out.println("<P> Nenhuma unidade de saude foi cadastrada</P>");
//#endif

        }

//#endif


//#if 599795047
        catch (RepositoryException e) { //1

//#if 1392870691
            out.println("</select></p></center></div>");
//#endif


//#if -1649137159
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 2074635229
        catch (TransactionException e) { //1

//#if 1288051100
            out.println("</select></p></center></div>");
//#endif


//#if -66875360
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 1914413717
        catch (CommunicationException e) { //1

//#if -1640506334
            out.println("</select></p></center></div>");
//#endif


//#if 1332628314
            out.println("<P> " + e.getMessage() + " </P>");
//#endif

        }

//#endif


//#if 329050685
        catch (Exception e) { //1

//#if -476130752
            out.println(lib.util.HTMLCode
                        .errorPage("Comunitation error, please try again later."));
//#endif


//#if 1121720566
            e.printStackTrace(out);
//#endif

        }

//#endif

        finally {

//#if 1367961978
            out.close();
//#endif

        }

//#endif

    }

//#endif


//#if 560989834
    public GetDataForSearchByHealthUnit(IFacade f)
    {

//#if -638356559
        super(f);
//#endif

    }

//#endif

}

//#endif


//#endif

