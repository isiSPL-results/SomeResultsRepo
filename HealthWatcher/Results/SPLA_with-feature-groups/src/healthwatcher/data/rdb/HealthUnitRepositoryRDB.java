// Compilation Unit of /HealthUnitRepositoryRDB.java

package healthwatcher.data.rdb;
import healthwatcher.data.IHealthUnitRepository;
import healthwatcher.model.healthguide.HealthUnit;
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

//#if 1081879887
import lib.exceptions.PersistenceSoftException;
//#endif

import lib.exceptions.RepositoryException;
import lib.persistence.IPersistenceMechanism;
import lib.util.ConcreteIterator;
import lib.util.IteratorDsk;

//#if 1875467150
import lib.exceptions.SQLPersistenceMechanismException;
//#endif

public class HealthUnitRepositoryRDB implements IHealthUnitRepository
{
    private IPersistenceMechanism mp;
    private ResultSet resultSet;
    private SpecialityRepositoryRDB specialityRep;
    public void insert(HealthUnit hu) throws RepositoryException, ObjectAlreadyInsertedException,
               ObjectNotValidException
    {
        if(hu != null) { //1
            String sql = null;
            try { //1
                Statement stmt = (Statement) this.mp.getCommunicationChannel();
                sql = "insert into SCBS_unidadesaude (codigo,DESCRICAO) values (";
                sql += hu.getCode() + ",'";
                sql += hu.getDescription() + "')";
                stmt.executeUpdate(sql);
                stmt.close();
            } catch (SQLException e) { //1

//#if 1145819798
                System.out.println(sql);
//#endif


//#if -1719285443
                throw new PersistenceSoftException(e);
//#endif


//#if 244923560
                throw new SQLPersistenceMechanismException(e.getMessage(),sql);
//#endif

            }

            catch (PersistenceMechanismException e) { //1

//#if -371318556
                throw new PersistenceSoftException(e);
//#endif


//#if 1639527263
                throw new RepositoryException(e.getMessage());
//#endif

            }

            finally {
                try { //1
                    mp.releaseCommunicationChannel();
                } catch (PersistenceMechanismException e) { //1

//#if -97724612
                    throw new PersistenceSoftException(e);
//#endif


//#if -495447625
                    throw new RepositoryException(e.getMessage());
//#endif

                }


            }

        } else {
            throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
        }

    }

    public IteratorDsk getHealthUnitListBySpeciality(int code) throws RepositoryException,
        ObjectNotFoundException
    {
        List listaUS = new ArrayList();
        String sql = "select U.codigo from "
                     + "SCBS_unidadeespecialidade R, SCBS_especialidade E, SCBS_unidadesaude U where "
                     + "E.codigo=R.codigoespecialidade AND U.codigo=R.codigounidadesaude AND "
                     + "E.codigo = '" + code + "'";
        ResultSet rs = null;
        try { //1
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
            rs = stmt.executeQuery(sql);
            if(rs.next()) { //1
                HealthUnit us = new HealthUnit();
                us = partialSearch((new Integer(rs.getString("codigo"))).intValue());
                listaUS.add(us);
            } else {
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
            }

            while (rs.next()) { //1
                HealthUnit us = new HealthUnit();
                us = search((new Integer(rs.getString("codigo"))).intValue());
                listaUS.add(us);
            }

            rs.close();
            stmt.close();
        } catch (PersistenceMechanismException e) { //1
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
        }

        catch (SQLException e) { //1

//#if -848838745
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif


//#if -1351137399
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_PROCURA,sql);
//#endif

        }

        finally {
            try { //1
                mp.releaseCommunicationChannel();
            } catch (PersistenceMechanismException e) { //1

//#if -2141366575
                throw new PersistenceSoftException(e);
//#endif


//#if 2005806156
                throw new RepositoryException(e.getMessage());
//#endif

            }


        }

        return new ConcreteIterator(listaUS);
    }


//#if -1606442190
    public boolean exists(int code) throws RepositoryException
    {
        boolean response = false;
        String sql=null;
        try { //1
            sql = "select * from SCBS_unidadesaude where "
                  + "codigo = '" + code + "'";
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
            resultSet  = stmt.executeQuery(sql);
            response = resultSet.next();
            resultSet.close();
            stmt.close();
        }

//#if 737058645
        catch (PersistenceMechanismException e) { //1

//#if -1552790765
            throw new PersistenceSoftException(e);
//#endif


//#if -1173111154
            throw new RepositoryException(e.getMessage());
//#endif

        }

//#endif


//#if 632783759
        catch (SQLException e) { //1

//#if -798316548
            System.out.println(sql);
//#endif


//#if -180243037
            throw new PersistenceSoftException(e);
//#endif


//#if -529142014
            throw new SQLPersistenceMechanismException(e.getMessage(),sql);
//#endif

        }

//#endif


        return response;
    }

//#endif

    public void update(HealthUnit us) throws RepositoryException, ObjectNotFoundException,
        ObjectNotValidException
    {
        if(us != null) { //1
            String sql = null;
            try { //1
                Statement stmt = (Statement) this.mp.getCommunicationChannel();
                sql = "update SCBS_unidadesaude set " + "descricao='" + us.getDescription() + "'"
                      + " where codigo = '" + us.getCode() + "'";
                stmt.executeUpdate(sql);
                stmt.close();
            } catch (SQLException sqlException) { //1

//#if -1623559500
                System.out.println(sql);
//#endif


//#if 483102132
                throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if 497134120
                throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

            }

            catch (PersistenceMechanismException mpException) { //1
                throw new RepositoryException(ExceptionMessages.EXC_FALHA_ATUALIZACAO);
            }

            finally {
                try { //1
                    mp.releaseCommunicationChannel();
                } catch (PersistenceMechanismException e) { //1

//#if -412562448
                    throw new PersistenceSoftException(e);
//#endif


//#if -560065941
                    throw new RepositoryException(e.getMessage());
//#endif

                }


            }

        } else {
            throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
        }

    }

    public HealthUnitRepositoryRDB(IPersistenceMechanism mp)
    {
        this.mp = mp;
        specialityRep = new SpecialityRepositoryRDB(mp);
    }

    public HealthUnit search(int code) throws RepositoryException, ObjectNotFoundException
    {
        HealthUnit us = null;
        String sql = null;
        try { //1
            sql = "select * from SCBS_unidadeespecialidade where " + "codigounidadesaude = '"
                  + code + "'";
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
            resultSet = stmt.executeQuery(sql);
            List specialities = new ArrayList();
            while (resultSet.next()) { //1
                try { //1
                    MedicalSpeciality esp = specialityRep.search((new Integer(resultSet
                                            .getString("codigoespecialidade"))).intValue());
                    System.out.println("medicalspeciality: " + esp.getCodigo() + " "
                                       + esp.getDescricao());
                    specialities.add(esp);
                } catch (ObjectNotFoundException ex) { //1
                }

            }

            resultSet.close();
            stmt.close();
            sql = "select * from SCBS_unidadesaude where " + "codigo = '" + code + "'";
            stmt = (Statement) this.mp.getCommunicationChannel();
            resultSet = stmt.executeQuery(sql);
            if(resultSet.next()) { //1
                us = new HealthUnit(resultSet.getString("descricao"), specialities);
                us.setCode((new Integer(resultSet.getString("codigo"))).intValue());
            } else {
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
            }

            resultSet.close();
            stmt.close();
        } catch (PersistenceMechanismException e) { //1
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
        }

        catch (SQLException e) { //1

//#if -1368778798
            System.out.println(sql);
//#endif

            e.printStackTrace();

//#if -109610030
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
//#endif


//#if 1973943242
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
//#endif

        }

        finally {
            try { //1
                mp.releaseCommunicationChannel();
            } catch (PersistenceMechanismException e) { //1

//#if 936417219
                throw new PersistenceSoftException(e);
//#endif


//#if 1349671742
                throw new RepositoryException(e.getMessage());
//#endif

            }


        }

        return us;
    }


//#if -606155041
    public boolean exists(int num) throws RepositoryException
    {
        return false;
    }

//#endif

    public IteratorDsk getPartialHealthUnitList() throws RepositoryException,
        ObjectNotFoundException
    {
        List listaUs = new ArrayList();
        String sql = "SELECT codigo FROM SCBS_unidadesaude";
        ResultSet rs = null;
        try { //1
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
            rs = stmt.executeQuery(sql);
            if(rs.next()) { //1
                HealthUnit us = partialSearch((new Integer(rs.getString("codigo"))).intValue());
                listaUs.add(us);
            } else {
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
            }

            while (rs.next()) { //1
                HealthUnit us = new HealthUnit();
                us = search((new Integer(rs.getString("codigo"))).intValue());
                listaUs.add(us);
            }

            rs.close();
            stmt.close();
        } catch (PersistenceMechanismException e) { //1
            e.printStackTrace();
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
        }

        catch (SQLException e) { //1
            e.printStackTrace();

//#if -1240765400
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif


//#if -761000664
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_PROCURA,sql);
//#endif

        }


        return new ConcreteIterator(listaUs);
    }

    public void remove(int codigo) throws RepositoryException, ObjectNotFoundException
    {
    }
    public HealthUnit partialSearch(int codigo) throws RepositoryException, ObjectNotFoundException
    {
        HealthUnit hu = null;
        String sql = null;
        try { //1
            sql = "select * from SCBS_unidadesaude where " + "codigo = '" + codigo + "'";
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
            resultSet = stmt.executeQuery(sql);
            if(resultSet.next()) { //1
                hu = new HealthUnit();
                hu.setCode((new Integer(resultSet.getString("codigo"))).intValue());
                hu.setDescription(resultSet.getString("descricao"));
            } else {
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
            }

            resultSet.close();
            stmt.close();
        } catch (PersistenceMechanismException e) { //1
            throw new RepositoryException("PersistenceMechanismException: " + e.getMessage());
        }

        catch (SQLException e) { //1

//#if 63411553
            System.out.println(sql);
//#endif


//#if -1242929725
            throw new RepositoryException("SQLException: " + e.getMessage());
//#endif


//#if -1612685187
            throw new SQLPersistenceMechanismException("SQLException: " + e.getMessage(),sql);
//#endif

        }

        finally {
            try { //1
                mp.releaseCommunicationChannel();
            } catch (PersistenceMechanismException e) { //1
                throw new RepositoryException("PersistenceMechanismException: " + e.getMessage());
            }


        }

        return hu;
    }

    public IteratorDsk getHealthUnitList() throws RepositoryException, ObjectNotFoundException
    {
        List listaUs = new ArrayList();
        String sql = "SELECT codigo FROM SCBS_unidadesaude";
        ResultSet rs = null;
        try { //1
            Statement stmt = (Statement) this.mp.getCommunicationChannel();
            rs = stmt.executeQuery(sql);
            if(rs.next()) { //1
                HealthUnit us = search((new Integer(rs.getString("codigo"))).intValue());
                listaUs.add(us);
            } else {
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
            }

            while (rs.next()) { //1
                HealthUnit us = new HealthUnit();
                us = search((new Integer(rs.getString("codigo"))).intValue());
                listaUs.add(us);
            }

            rs.close();
            stmt.close();
        } catch (PersistenceMechanismException e) { //1
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
        }

        catch (SQLException e) { //1

//#if 969419924
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_PROCURA);
//#endif


//#if 361411132
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_PROCURA,sql);
//#endif

        }

        finally {
            try { //1
                mp.releaseCommunicationChannel();
            } catch (PersistenceMechanismException e) { //1

//#if -1239862446
                throw new PersistenceSoftException(e);
//#endif


//#if 1210709965
                throw new RepositoryException(e.getMessage());
//#endif

            }


        }

        return new ConcreteIterator(listaUs);
    }

}


