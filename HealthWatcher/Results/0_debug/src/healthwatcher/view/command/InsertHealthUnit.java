
//#if 1404691419
// Compilation Unit of /InsertHealthUnit.java


//#if 957713306
package healthwatcher.view.command;
//#endif


//#if -1960660256
import healthwatcher.model.healthguide.HealthUnit;
//#endif


//#if 1781468889
import healthwatcher.view.IFacade;
//#endif


//#if 2093937000
import java.io.IOException;
//#endif


//#if -1580810063
import java.io.PrintWriter;
//#endif


//#if -891766885
import lib.exceptions.CommunicationException;
//#endif


//#if -1014862978
import lib.exceptions.InsertEntryException;
//#endif


//#if -225315438
import lib.exceptions.InvalidSessionException;
//#endif


//#if 491516246
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if -660817157
import lib.exceptions.ObjectNotValidException;
//#endif


//#if -1517134339
import lib.exceptions.RepositoryException;
//#endif


//#if 150475491
import lib.exceptions.TransactionException;
//#endif


//#if 1775853306
import lib.util.HTMLCode;
//#endif


//#if -227508581
import lib.exceptions.FacadeUnavailableException;
//#endif


//#if 108417107
public class InsertHealthUnit extends
//#if -747212364
    Command
//#endif

{

//#if 1234814999
    public InsertHealthUnit(IFacade f)
    {

//#if 1109579593
        super(f);
//#endif

    }

//#endif


//#if -1191387806
    public void execute()
    {

//#if 435026368
        PrintWriter out=null;
//#endif


//#if 1727016575
        HealthUnit hu = null;
//#endif


//#if 1367113425
        try { //1

//#if 783707251
            try { //1

//#if -1378331267
                out = response.getWriter();
//#endif

            }

//#if -1856216434
            catch (IOException e1) { //1

//#if -944711039
                e1.printStackTrace();
//#endif

            }

//#endif


//#endif


//#if 1606849664
            if(! request.isAuthorized()) { //1

//#if 1485288461
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if -296250408
            String code = request.getInput("code");
//#endif


//#if 1022348308
            String description = request.getInput("description");
//#endif


//#if 1040711492
            hu = new HealthUnit(description, null);
//#endif


//#if 468257199
            hu.setCode(Integer.parseInt(code));
//#endif


//#if -694064393
            facade.insert(hu);
//#endif


//#if 1944877312
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "HealthUnit inserted"));
//#endif

        }

//#if -1965348261
        catch (ObjectAlreadyInsertedException e) { //1

//#if 267735293
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif


//#if -98877589
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if -1026186694
        catch (ObjectNotValidException e) { //1

//#if -2116203384
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif


//#if -206083274
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if 467979331
        catch(InsertEntryException e) { //1

//#if 1475696404
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif


//#if -600932670
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if 334346577
        catch (InvalidSessionException e) { //1

//#if -1192068217
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif


//#if -2099232395
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if -708953816
        catch(TransactionException e) { //1

//#if -1286927871
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif


//#if -713942161
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if -1645000416
        catch(CommunicationException e) { //1

//#if -2091325567
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif


//#if 1105860847
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if 510001852
        catch(RepositoryException e) { //1

//#if 735563574
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif


//#if -1181925276
            e.printStackTrace(out);
//#endif

        }

//#endif

        finally {

//#if -2225921
            out.close();
//#endif

        }

//#endif

    }

//#endif


//#if -1093078304
    public void execute() throws Exception
    {

//#if -927850954
        PrintWriter out = response.getWriter();
//#endif


//#if 46207403
        HealthUnit hu = null;
//#endif


//#if -695745539
        try { //1

//#if -1868903306
            if(! request.isAuthorized()) { //1

//#if -1485416992
                throw new InvalidSessionException();
//#endif

            }

//#endif


//#if 2082700110
            String code = request.getInput("code");
//#endif


//#if -1283560182
            String description = request.getInput("description");
//#endif


//#if -268021490
            hu = new HealthUnit(description, null);
//#endif


//#if -840475783
            hu.setCode(Integer.parseInt(code));
//#endif


//#if -1648270355
            facade.insert(hu);
//#endif


//#if 49305334
            out.println(HTMLCode.htmlPageAdministrator("Operation executed", "HealthUnit inserted"));
//#endif

        }

//#if -990187526
        catch (ObjectAlreadyInsertedException e) { //1

//#if -1936521604
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif


//#if 713915434
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if -1350737541
        catch (ObjectNotValidException e) { //1

//#if -1086572923
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif


//#if 1796147955
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if 53623970
        catch(InsertEntryException e) { //1

//#if 1182084775
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif


//#if 1487162517
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if 9795730
        catch (InvalidSessionException e) { //1

//#if -1795000212
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif


//#if -456596966
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if -1123309177
        catch(TransactionException e) { //1

//#if -685134253
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif


//#if 276475201
            e.printStackTrace(out);
//#endif

        }

//#endif


//#if -408543809
        catch(CommunicationException e) { //1

//#if -116359385
            throw new FacadeUnavailableException();
//#endif

        }

//#endif


//#if -611743107
        catch(RepositoryException e) { //1

//#if 802697871
            out.println(HTMLCode.errorPageAdministrator(e.getMessage()));
//#endif


//#if -2123104643
            e.printStackTrace(out);
//#endif

        }

//#endif


//#endif

    }

//#endif

}

//#endif


//#endif

