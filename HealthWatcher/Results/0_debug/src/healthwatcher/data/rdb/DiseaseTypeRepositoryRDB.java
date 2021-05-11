
//#if 1164292343
// Compilation Unit of /DiseaseTypeRepositoryRDB.java


//#if 1180347616
package healthwatcher.data.rdb;
//#endif


//#if 1161031506
import healthwatcher.data.IDiseaseRepository;
//#endif


//#if 1686466917
import healthwatcher.model.complaint.DiseaseType;
//#endif


//#if -66575246
import healthwatcher.model.complaint.Symptom;
//#endif


//#if 1148495256
import java.sql.ResultSet;
//#endif


//#if -224049352
import java.sql.SQLException;
//#endif


//#if 1505293422
import java.sql.Statement;
//#endif


//#if 1623922382
import java.util.ArrayList;
//#endif


//#if -563702061
import java.util.List;
//#endif


//#if 490443575
import lib.exceptions.ExceptionMessages;
//#endif


//#if -1256077306
import lib.exceptions.ObjectAlreadyInsertedException;
//#endif


//#if -564403631
import lib.exceptions.ObjectNotFoundException;
//#endif


//#if -1730278837
import lib.exceptions.ObjectNotValidException;
//#endif


//#if -2013220675
import lib.exceptions.PersistenceMechanismException;
//#endif


//#if 775862238
import lib.exceptions.PersistenceSoftException;
//#endif


//#if 1392497997
import lib.exceptions.RepositoryException;
//#endif


//#if 1823256954
import lib.persistence.IPersistenceMechanism;
//#endif


//#if -720294897
import lib.util.ConcreteIterator;
//#endif


//#if -1666655322
import lib.util.IteratorDsk;
//#endif


//#if 832300829
import lib.exceptions.SQLPersistenceMechanismException;
//#endif


//#if -1050614374
public class DiseaseTypeRepositoryRDB implements
//#if -125351589
    IDiseaseRepository
//#endif

{

//#if 1289727802
    private IPersistenceMechanism mp;
//#endif


//#if -1164949802
    private ResultSet resultSet;
//#endif


//#if 1657410753
    public void update(DiseaseType td) throws RepositoryException, ObjectNotFoundException,
               ObjectNotValidException
    {
    }
//#endif


//#if -1856544960
    public boolean exists(int code) throws RepositoryException
    {

//#if -321027887
        return false;
//#endif


//#if -1411369387
        boolean response = false;
//#endif


//#if 236017387
        String sql=null;
//#endif


//#if -1499675233
        try { //1

//#if -1571297343
            sql = "select * from SCBS_tipodoenca where "
                  + "codigo = '" + code+"'";
//#endif


//#if 1971392908
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if 2017523799
            resultSet  = stmt.executeQuery(sql);
//#endif


//#if -587850268
            response = resultSet.next();
//#endif


//#if -77307379
            resultSet.close();
//#endif


//#if -642542170
            stmt.close();
//#endif

        }

//#if -1073959821
        catch (PersistenceMechanismException e) { //1

//#if 1240128812
            throw new PersistenceSoftException(e);
//#endif


//#if -360110169
            throw new RepositoryException(e.getMessage());
//#endif

        }

//#endif


//#if -1328881999
        catch (SQLException e) { //1

//#if 2082190288
            System.out.println(sql);
//#endif


//#if -985947273
            throw new PersistenceSoftException(e);
//#endif


//#if -2071365714
            throw new SQLPersistenceMechanismException(e.getMessage(),sql);
//#endif

        }

//#endif


//#endif


//#if 1159615521
        return response;
//#endif

    }

//#endif


//#if 1022547183
    public DiseaseType search(int code) throws RepositoryException, ObjectNotFoundException
    {

//#if -830543203
        DiseaseType td = null;
//#endif


//#if 2031373714
        String nome, descricao, manifestacao, duracao;
//#endif


//#if 1908566417
        List sintomas;
//#endif


//#if -571044428
        String sql = null;
//#endif


//#if -98690890
        try { //1

//#if -1647024631
            sql = "select * from SCBS_tipodoenca where " + "codigo = '" + code + "'";
//#endif


//#if -376153020
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if -1096795889
            resultSet = stmt.executeQuery(sql);
//#endif


//#if -1089128058
            if(resultSet.next()) { //1

//#if -1938278516
                code = (new Integer(resultSet.getString("codigo"))).intValue();
//#endif


//#if -598492661
                nome = resultSet.getString("nome");
//#endif


//#if -545787469
                descricao = resultSet.getString("descricao");
//#endif


//#if 1111883071
                manifestacao = resultSet.getString("manifestacao");
//#endif


//#if 1778694067
                duracao = resultSet.getString("duracao");
//#endif

            } else {

//#if 1966019267
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif

            }

//#endif


//#if 2125645909
            resultSet.close();
//#endif


//#if -1937743266
            stmt.close();
//#endif


//#if -1652929899
            sql = "select * from SCBS_tipodoencasintoma where codigotipodoenca = '" + code + "'";
//#endif


//#if 1330726857
            stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if 1464905443
            resultSet = stmt.executeQuery(sql);
//#endif


//#if -2090293732
            sintomas = new ArrayList();
//#endif


//#if -972489210
            while (resultSet.next()) { //1

//#if 1414853966
                int codeSymptom = (new Integer(resultSet.getString("codigosintoma"))).intValue();
//#endif


//#if 616802244
                sql = "select * from SCBS_sintoma where " + "codigo = '" + codeSymptom + "'";
//#endif


//#if 1573898941
                Statement stmt2 = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if -850121691
                ResultSet resultSet2 = stmt2.executeQuery(sql);
//#endif


//#if -1259987342
                Symptom sintoma;
//#endif


//#if -1312123683
                if(resultSet2.next()) { //1

//#if 378578663
                    sintoma = new Symptom(resultSet2.getString("descricao"));
//#endif


//#if 1579383923
                    sintoma.setCode((new Integer(resultSet2.getString("codigo"))).intValue());
//#endif

                } else {

//#if 1171029298
                    throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif

                }

//#endif


//#if -301190824
                resultSet2.close();
//#endif


//#if -987526831
                stmt2.close();
//#endif


//#if -1756871045
                sintomas.add(sintoma);
//#endif

            }

//#endif


//#if 119509469
            resultSet.close();
//#endif


//#if 1345834804
            stmt.close();
//#endif


//#if 1904093183
            td = new DiseaseType(nome, descricao, manifestacao, duracao, sintomas);
//#endif


//#if -1917902196
            td.setCode(code);
//#endif

        }

//#if 2038240691
        catch (PersistenceMechanismException e) { //1

//#if 552096730
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#if 355323249
        catch (SQLException e) { //1

//#if -572336772
            System.out.println(sql);
//#endif


//#if 854420237
            e.printStackTrace();
//#endif


//#if -1048040324
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if -1544719264
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

        }

//#endif


//#endif


//#if 2015834779
        return td;
//#endif

    }

//#endif


//#if -339784236
    public DiseaseTypeRepositoryRDB(IPersistenceMechanism mp)
    {

//#if 1766073190
        this.mp = mp;
//#endif

    }

//#endif


//#if -1967425545
    public void filter(int codigo) throws RepositoryException, ObjectNotFoundException
    {
    }
//#endif


//#if 739206404
    public void insert(DiseaseType td) throws RepositoryException, ObjectAlreadyInsertedException,
        ObjectNotValidException
    {

//#if 1689359909
        if(td != null) { //1

//#if 1762208426
            String sql=null;
//#endif


//#if 1607921408
            try { //1

//#if 2139879328
                Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if -943143430
                sql = "insert into SCBS_tipodoenca (codigo, nome, DESCRICAO, manifestacao, duracao) values ('";
//#endif


//#if -271526548
                sql += td.getCode() + "','";
//#endif


//#if -3843442
                sql += td.getName() + "','";
//#endif


//#if -2043591855
                sql += td.getDescription() + "','";
//#endif


//#if 831742439
                sql += td.getManifestation() + "','";
//#endif


//#if 1974835345
                sql += td.getDuration() + "')";
//#endif


//#if 2098943774
                stmt.executeUpdate(sql);
//#endif


//#if 1496530618
                stmt.close();
//#endif

            }

//#if -1966255441
            catch (SQLException e) { //1

//#if -254519576
                System.out.println(sql);
//#endif


//#if -1352637809
                throw new PersistenceSoftException(e);
//#endif


//#if -599170154
                throw new SQLPersistenceMechanismException(e.getMessage(),sql);
//#endif

            }

//#endif


//#if 2072835125
            catch (PersistenceMechanismException e) { //1

//#if 1070693081
                throw new PersistenceSoftException(e);
//#endif


//#if -993933228
                throw new RepositoryException(e.getMessage());
//#endif

            }

//#endif

            finally {

//#if 1567484420
                try { //1

//#if 150284962
                    mp.releaseCommunicationChannel();
//#endif

                }

//#if -910147924
                catch (PersistenceMechanismException e) { //1

//#if -1783598719
                    throw new PersistenceSoftException(e);
//#endif


//#if 1815320316
                    throw new RepositoryException(e.getMessage());
//#endif

                }

//#endif


//#endif

            }

//#endif

        } else {

//#if -712190859
            throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
//#endif

        }

//#endif

    }

//#endif


//#if -493130946
    public DiseaseType partialSearch(int codigo) throws ObjectNotFoundException, RepositoryException
    {

//#if -1810253145
        DiseaseType td = null;
//#endif


//#if 576655944
        String nome, descricao, manifestacao, duracao;
//#endif


//#if 935260862
        String sql = null;
//#endif


//#if 918552684
        try { //1

//#if -903114748
            sql = "select * from SCBS_tipodoenca where " + "codigo = '" + codigo + "'";
//#endif


//#if 978338045
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if -720366840
            resultSet = stmt.executeQuery(sql);
//#endif


//#if 349537983
            if(resultSet.next()) { //1

//#if -1084047255
                codigo = (new Integer(resultSet.getString("codigo"))).intValue();
//#endif


//#if -2046712518
                nome = resultSet.getString("nome");
//#endif


//#if 1526263330
                descricao = resultSet.getString("descricao");
//#endif


//#if -1343378834
                manifestacao = resultSet.getString("manifestacao");
//#endif


//#if 1822114722
                duracao = resultSet.getString("duracao");
//#endif

            } else {

//#if -1489047624
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif

            }

//#endif


//#if -1042064516
            resultSet.close();
//#endif


//#if 715928279
            stmt.close();
//#endif


//#if 1468920424
            td = new DiseaseType();
//#endif


//#if -350430637
            td.setName(nome);
//#endif


//#if 1275881626
            td.setDescription(descricao);
//#endif


//#if 423732104
            td.setManifestation(manifestacao);
//#endif


//#if 1589519940
            td.setDuration(duracao);
//#endif


//#if 27776689
            td.setCode(codigo);
//#endif

        }

//#if 1746015045
        catch (PersistenceMechanismException e) { //1

//#if -2085821891
            throw new RepositoryException(e.getMessage());
//#endif

        }

//#endif


//#if -1101270625
        catch (SQLException e) { //1

//#if 501962732
            throw new SQLPersistenceMechanismException(e.getMessage(),sql);
//#endif

        }

//#endif

        finally {

//#if -1578062713
            try { //1

//#if 2006775045
                mp.releaseCommunicationChannel();
//#endif

            }

//#if 96488356
            catch (PersistenceMechanismException e) { //1

//#if -21869499
                throw new RepositoryException(e.getMessage());
//#endif

            }

//#endif


//#if -169077132
            catch (RepositoryException e) { //1

//#if -764636980
                throw e;
//#endif

            }

//#endif


//#endif

        }

//#endif


//#if 1429907237
        return td;
//#endif

    }

//#endif


//#if 1273710437
    public DiseaseType partialSearch(int codigo) throws ObjectNotFoundException
    {

//#if 299688212
        DiseaseType td = null;
//#endif


//#if 1629159739
        String nome, descricao, manifestacao, duracao;
//#endif


//#if 1405638571
        String sql = null;
//#endif


//#if -727847713
        try { //1

//#if 1738614330
            sql = "select * from SCBS_tipodoenca where " + "codigo = '" + codigo + "'";
//#endif


//#if -44823545
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if -397502830
            resultSet = stmt.executeQuery(sql);
//#endif


//#if -2089873719
            if(resultSet.next()) { //1

//#if -1480552896
                codigo = (new Integer(resultSet.getString("codigo"))).intValue();
//#endif


//#if -1191454717
                nome = resultSet.getString("nome");
//#endif


//#if 804059563
                descricao = resultSet.getString("descricao");
//#endif


//#if 832777015
                manifestacao = resultSet.getString("manifestacao");
//#endif


//#if 2087484331
                duracao = resultSet.getString("duracao");
//#endif

            } else {

//#if -1554174262
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif

            }

//#endif


//#if 1728279858
            resultSet.close();
//#endif


//#if 1698979681
            stmt.close();
//#endif


//#if 890140318
            td = new DiseaseType();
//#endif


//#if -1923632675
            td.setName(nome);
//#endif


//#if 73285924
            td.setDescription(descricao);
//#endif


//#if 1842581822
            td.setManifestation(manifestacao);
//#endif


//#if -1017798790
            td.setDuration(duracao);
//#endif


//#if 9106363
            td.setCode(codigo);
//#endif

        }

//#if 761418610
        catch (PersistenceMechanismException e) { //1

//#if -530247783
            throw new PersistenceSoftException(e);
//#endif

        }

//#endif


//#if -211993134
        catch (SQLException e) { //1

//#if -1707068490
            System.out.println(sql);
//#endif


//#if 391215709
            throw new PersistenceSoftException(e);
//#endif

        }

//#endif

        finally {

//#if -1798232259
            try { //1

//#if -1589712581
                mp.releaseCommunicationChannel();
//#endif

            }

//#if 176440284
            catch (PersistenceMechanismException e) { //1

//#if 409785020
                throw new PersistenceSoftException(e);
//#endif

            }

//#endif


//#endif

        }

//#endif


//#if 2042200530
        return td;
//#endif

    }

//#endif


//#if 1314665607
    public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException
    {

//#if 212340553
        List listatd = new ArrayList();
//#endif


//#if 392146677
        String sql = "SELECT * FROM SCBS_tipodoenca";
//#endif


//#if 2007108523
        ResultSet rs = null;
//#endif


//#if 1452292264
        try { //1

//#if 435893749
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
//#endif


//#if 2113987086
            rs = stmt.executeQuery(sql);
//#endif


//#if -1636150790
            if(!rs.next()) { //1

//#if -879069165
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif

            }

//#endif


//#if -1445984786
            do {

//#if -1105248917
                DiseaseType td = partialSearch((new Integer(rs.getString("codigo"))).intValue());
//#endif


//#if 1911158192
                listatd.add(td);
//#endif

            } while (rs.next()); //1

//#endif


//#if -1848958666
            rs.close();
//#endif


//#if -87778865
            stmt.close();
//#endif

        }

//#if 1819589386
        catch (PersistenceMechanismException e) { //1

//#if -28373937
            e.printStackTrace();
//#endif


//#if -734010434
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif

        }

//#endif


//#if -1294249158
        catch (SQLException e) { //1

//#if 673277049
            System.out.println(sql);
//#endif


//#if 1914503306
            e.printStackTrace();
//#endif


//#if -923549447
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if 1373096323
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

        }

//#endif


//#endif


//#if -1621244242
        return new ConcreteIterator(listatd);
//#endif

    }

//#endif

}

//#endif


//#endif

