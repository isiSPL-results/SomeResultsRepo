// Compilation Unit of /DiseaseTypeRepositoryRDB.java

package healthwatcher.data.rdb;
import healthwatcher.data.IDiseaseRepository;
import healthwatcher.model.complaint.DiseaseType;
import healthwatcher.model.complaint.Symptom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import lib.exceptions.ExceptionMessages;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.PersistenceMechanismException;

//#if 775862238
import lib.exceptions.PersistenceSoftException;
//#endif

import lib.exceptions.RepositoryException;
import lib.persistence.IPersistenceMechanism;
import lib.util.ConcreteIterator;
import lib.util.IteratorDsk;

//#if 832300829
import lib.exceptions.SQLPersistenceMechanismException;
//#endif

public class DiseaseTypeRepositoryRDB implements IDiseaseRepository
{
    private IPersistenceMechanism mp;
    private ResultSet resultSet;
    public void update(DiseaseType td) throws RepositoryException, ObjectNotFoundException,
               ObjectNotValidException
    {
    }
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
            sql = "select * from SCBS_tipodoenca where "
                  + "codigo = '" + code+"'";
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
            resultSet  = stmt.executeQuery(sql);
            response = resultSet.next();
            resultSet.close();
            stmt.close();
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

    public DiseaseType search(int code) throws RepositoryException, ObjectNotFoundException
    {
        DiseaseType td = null;
        String nome, descricao, manifestacao, duracao;
        List sintomas;
        String sql = null;
        try { //1
            sql = "select * from SCBS_tipodoenca where " + "codigo = '" + code + "'";
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
            resultSet = stmt.executeQuery(sql);
            if(resultSet.next()) { //1
                code = (new Integer(resultSet.getString("codigo"))).intValue();
                nome = resultSet.getString("nome");
                descricao = resultSet.getString("descricao");
                manifestacao = resultSet.getString("manifestacao");
                duracao = resultSet.getString("duracao");
            } else {
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
            }

            resultSet.close();
            stmt.close();
            sql = "select * from SCBS_tipodoencasintoma where codigotipodoenca = '" + code + "'";
            stmt = (Statement) this.mp.getCommunicationChannel();
            resultSet = stmt.executeQuery(sql);
            sintomas = new ArrayList();
            while (resultSet.next()) { //1
                int codeSymptom = (new Integer(resultSet.getString("codigosintoma"))).intValue();
                sql = "select * from SCBS_sintoma where " + "codigo = '" + codeSymptom + "'";
                Statement stmt2 = (Statement) this.mp.getCommunicationChannel();
                ResultSet resultSet2 = stmt2.executeQuery(sql);
                Symptom sintoma;
                if(resultSet2.next()) { //1
                    sintoma = new Symptom(resultSet2.getString("descricao"));
                    sintoma.setCode((new Integer(resultSet2.getString("codigo"))).intValue());
                } else {
                    throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
                }

                resultSet2.close();
                stmt2.close();
                sintomas.add(sintoma);
            }

            resultSet.close();
            stmt.close();
            td = new DiseaseType(nome, descricao, manifestacao, duracao, sintomas);
            td.setCode(code);
        } catch (PersistenceMechanismException e) { //1
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
        }

        catch (SQLException e) { //1

//#if -572336772
            System.out.println(sql);
//#endif

            e.printStackTrace();

//#if -1048040324
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if -1544719264
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

        }


        return td;
    }

    public DiseaseTypeRepositoryRDB(IPersistenceMechanism mp)
    {
        this.mp = mp;
    }

    public void filter(int codigo) throws RepositoryException, ObjectNotFoundException
    {
    }
    public void insert(DiseaseType td) throws RepositoryException, ObjectAlreadyInsertedException,
        ObjectNotValidException
    {

//#if 1689359909
        if(td != null) { //1
            String sql=null;
            try { //1
                Statement stmt = (Statement) this.mp.getCommunicationChannel();
                sql = "insert into SCBS_tipodoenca (codigo, nome, DESCRICAO, manifestacao, duracao) values ('";
                sql += td.getCode() + "','";
                sql += td.getName() + "','";
                sql += td.getDescription() + "','";
                sql += td.getManifestation() + "','";
                sql += td.getDuration() + "')";
                stmt.executeUpdate(sql);
                stmt.close();
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
                try { //1
                    mp.releaseCommunicationChannel();
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


            }

        } else {
            throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
        }

//#endif

    }


//#if -493130946
    public DiseaseType partialSearch(int codigo) throws ObjectNotFoundException, RepositoryException
    {
        DiseaseType td = null;
        String nome, descricao, manifestacao, duracao;
        String sql = null;
        try { //1
            sql = "select * from SCBS_tipodoenca where " + "codigo = '" + codigo + "'";
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
            resultSet = stmt.executeQuery(sql);
            if(resultSet.next()) { //1
                codigo = (new Integer(resultSet.getString("codigo"))).intValue();
                nome = resultSet.getString("nome");
                descricao = resultSet.getString("descricao");
                manifestacao = resultSet.getString("manifestacao");
                duracao = resultSet.getString("duracao");
            } else {
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
            }

            resultSet.close();
            stmt.close();
            td = new DiseaseType();
            td.setName(nome);
            td.setDescription(descricao);
            td.setManifestation(manifestacao);
            td.setDuration(duracao);
            td.setCode(codigo);
        } catch (PersistenceMechanismException e) { //1
            throw new RepositoryException(e.getMessage());
        }

        catch (SQLException e) { //1
            throw new SQLPersistenceMechanismException(e.getMessage(),sql);
        }

        finally {
            try { //1
                mp.releaseCommunicationChannel();
            } catch (PersistenceMechanismException e) { //1
                throw new RepositoryException(e.getMessage());
            }

            catch (RepositoryException e) { //1
                throw e;
            }


        }

        return td;
    }

//#endif


//#if 1273710437
    public DiseaseType partialSearch(int codigo) throws ObjectNotFoundException
    {
        DiseaseType td = null;
        String nome, descricao, manifestacao, duracao;
        String sql = null;
        try { //1
            sql = "select * from SCBS_tipodoenca where " + "codigo = '" + codigo + "'";
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
            resultSet = stmt.executeQuery(sql);
            if(resultSet.next()) { //1
                codigo = (new Integer(resultSet.getString("codigo"))).intValue();
                nome = resultSet.getString("nome");
                descricao = resultSet.getString("descricao");
                manifestacao = resultSet.getString("manifestacao");
                duracao = resultSet.getString("duracao");
            } else {
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
            }

            resultSet.close();
            stmt.close();
            td = new DiseaseType();
            td.setName(nome);
            td.setDescription(descricao);
            td.setManifestation(manifestacao);
            td.setDuration(duracao);
            td.setCode(codigo);
        }

//#if 761418610
        catch (PersistenceMechanismException e) { //1
            throw new PersistenceSoftException(e);
        }

//#endif


//#if -211993134
        catch (SQLException e) { //1
            System.out.println(sql);
            throw new PersistenceSoftException(e);
        }

//#endif

        finally {
            try { //1
                mp.releaseCommunicationChannel();
            }

//#if 176440284
            catch (PersistenceMechanismException e) { //1
                throw new PersistenceSoftException(e);
            }

//#endif


        }

        return td;
    }

//#endif

    public IteratorDsk getDiseaseTypeList() throws RepositoryException, ObjectNotFoundException
    {
        List listatd = new ArrayList();
        String sql = "SELECT * FROM SCBS_tipodoenca";
        ResultSet rs = null;
        try { //1
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
            rs = stmt.executeQuery(sql);
            if(!rs.next()) { //1
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
            }

            do {
                DiseaseType td = partialSearch((new Integer(rs.getString("codigo"))).intValue());
                listatd.add(td);
            } while (rs.next()); //1

            rs.close();
            stmt.close();
        } catch (PersistenceMechanismException e) { //1
            e.printStackTrace();
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
        }

        catch (SQLException e) { //1

//#if 673277049
            System.out.println(sql);
//#endif

            e.printStackTrace();

//#if -923549447
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if 1373096323
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

        }


        return new ConcreteIterator(listatd);
    }

}


