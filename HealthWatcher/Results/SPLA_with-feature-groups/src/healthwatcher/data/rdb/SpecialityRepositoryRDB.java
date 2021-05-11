// Compilation Unit of /SpecialityRepositoryRDB.java

package healthwatcher.data.rdb;
import healthwatcher.data.ISpecialityRepository;
import healthwatcher.model.healthguide.MedicalSpeciality;
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

//#if 417086618
import lib.exceptions.PersistenceSoftException;
//#endif

import lib.exceptions.RepositoryException;
import lib.persistence.IPersistenceMechanism;
import lib.util.ConcreteIterator;
import lib.util.IteratorDsk;

//#if 1521938393
import lib.exceptions.SQLPersistenceMechanismException;
//#endif

public class SpecialityRepositoryRDB implements ISpecialityRepository
{
    private IPersistenceMechanism mp;
    protected ResultSet resultSet;
    public IteratorDsk getSpecialityList() throws RepositoryException, ObjectNotFoundException
    {
        List listaEsp = new ArrayList();
        String sql = "SELECT * FROM SCBS_especialidade";
        ResultSet rs = null;
        try { //1
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
            rs = stmt.executeQuery(sql);
            if(!rs.next()) { //1
                throw new ObjectNotFoundException("");
            }

            do {
                MedicalSpeciality esp = search((new Integer(rs.getString("codigo"))).intValue());
                listaEsp.add(esp);
            } while (rs.next()); //1

            rs.close();
            stmt.close();
        } catch (PersistenceMechanismException e) { //1
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
        }

        catch (SQLException e) { //1

//#if 1233984022
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif


//#if -424527622
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_PROCURA,sql);
//#endif

        }

        finally {
            try { //1
                mp.releaseCommunicationChannel();
            } catch (PersistenceMechanismException e) { //1

//#if 1596388036
                throw new PersistenceSoftException(e);
//#endif


//#if -1451088577
                throw new RepositoryException(e.getMessage());
//#endif

            }


        }

        return new ConcreteIterator(listaEsp);
    }


//#if -74191660
    public boolean exists(int code) throws RepositoryException
    {
        boolean response = false;
        String sql=null;
        try { //1
            sql = "select * from SCBS_especialidade where "
                  + "codigo = '" + code + "'";
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
            resultSet  = stmt.executeQuery(sql);
            response = resultSet.next();
            resultSet.close();
            stmt.close();
        }

//#if -1199835056
        catch (PersistenceMechanismException e) { //1

//#if 1929184739
            throw new PersistenceSoftException(e);
//#endif


//#if -1881233058
            throw new RepositoryException(e.getMessage());
//#endif

        }

//#endif


//#if -652506828
        catch (SQLException e) { //1

//#if -993264568
            System.out.println(sql);
//#endif


//#if 757790703
            throw new PersistenceSoftException(e);
//#endif


//#if -996173258
            throw new SQLPersistenceMechanismException(e.getMessage(),sql);
//#endif

        }

//#endif


        return response;
    }

//#endif

    public void insert(MedicalSpeciality spec) throws RepositoryException,
               ObjectAlreadyInsertedException, ObjectNotValidException
    {
        if(spec != null) { //1
            String sql = null;
            try { //1
                Statement stmt = (Statement) mp.getCommunicationChannel();
                sql = "insert into SCBS_especialidade (codigo,descricao) values (";
                sql += spec.getCodigo() + ",'";
                sql += spec.getDescricao() + "')";
                stmt.executeUpdate(sql);
                stmt.close();
            } catch (SQLException e) { //1

//#if -338307096
                System.out.println(sql);
//#endif


//#if 925393807
                throw new PersistenceSoftException(e);
//#endif


//#if -19627370
                throw new SQLPersistenceMechanismException(e.getMessage(),sql);
//#endif

            }

            catch (PersistenceMechanismException e) { //1

//#if 1595576228
                throw new PersistenceSoftException(e);
//#endif


//#if 1979376159
                throw new RepositoryException(e.getMessage());
//#endif

            }

            finally {
                try { //1
                    mp.releaseCommunicationChannel();
                } catch (PersistenceMechanismException e) { //1

//#if 322103777
                    throw new PersistenceSoftException(e);
//#endif


//#if -177754276
                    throw new RepositoryException(e.getMessage());
//#endif

                }


            }

        } else {
            throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
        }

    }

    public SpecialityRepositoryRDB(IPersistenceMechanism mp)
    {
        this.mp = mp;
    }

    public void remove(int code) throws RepositoryException, ObjectNotFoundException
    {
    }
    public void update(MedicalSpeciality esp) throws RepositoryException, ObjectNotFoundException,
        ObjectNotValidException
    {

//#if -775978946
        if(esp != null) { //1
            String sql=null;
            try { //1
                Statement stmt = (Statement) this.mp.getCommunicationChannel();
                sql = "update SCBS_especialidade set " +
                      "descricao='" + esp.getDescricao() + "'" +
                      " where codigo = '"+esp.getCodigo()+"'";
                stmt.executeUpdate(sql);
                stmt.close();
            }

//#if -339684470
            catch (SQLException sqlException) { //1

//#if 1980063746
                System.out.println(sql);
//#endif


//#if 847670274
                throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if 1504801178
                throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

            }

//#endif


//#if 898394911
            catch (PersistenceMechanismException mpException) { //1
                throw new RepositoryException(ExceptionMessages.EXC_FALHA_ATUALIZACAO);
            }

//#endif

            finally {
                try { //1
                    mp.releaseCommunicationChannel();
                }

//#if 70645752
                catch (PersistenceMechanismException e) { //1

//#if -1492156386
                    throw new PersistenceSoftException(e);
//#endif


//#if 1520220313
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

    public MedicalSpeciality search(int code) throws RepositoryException, ObjectNotFoundException
    {
        MedicalSpeciality esp = null;
        String sql = null;
        try { //1
            sql = "select * from SCBS_especialidade where " + "codigo = '" + code + "'";
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
            resultSet = stmt.executeQuery(sql);
            if(resultSet.next()) { //1
                esp = new MedicalSpeciality(resultSet.getString("descricao"));
                esp.setCodigo((new Integer(resultSet.getString("codigo"))).intValue());
            } else {
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
            }

            resultSet.close();
            stmt.close();
        } catch (PersistenceMechanismException e) { //1
            e.printStackTrace();
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
        }

        catch (java.sql.SQLException e) { //1

//#if -1645677065
            System.out.println(sql);
//#endif

            e.printStackTrace();

//#if -492770441
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if -693032251
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

        }

        finally {
            try { //1
                mp.releaseCommunicationChannel();
            } catch (PersistenceMechanismException e) { //1

//#if 1664741475
                throw new PersistenceSoftException(e);
//#endif


//#if 868815838
                throw new RepositoryException(e.getMessage());
//#endif

            }


        }

        return esp;
    }


//#if 1105840381
    public boolean exists(int num) throws RepositoryException
    {
        return false;
    }

//#endif

}


