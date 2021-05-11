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
import lib.exceptions.PersistenceSoftException;
import lib.exceptions.RepositoryException;
import lib.persistence.IPersistenceMechanism;
import lib.util.ConcreteIterator;
import lib.util.IteratorDsk;
public class DiseaseTypeRepositoryRDB implements IDiseaseRepository
{
    private IPersistenceMechanism mp;
    private ResultSet resultSet;
    public void update(DiseaseType td) throws RepositoryException, ObjectNotFoundException,
               ObjectNotValidException
    {
    } public boolean exists(int code) throws RepositoryException
    {
        return false;
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
        } catch (SQLException e) { //1
            System.out.println(sql);
            e.printStackTrace();
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
        }
        return td;
    }
    public DiseaseTypeRepositoryRDB(IPersistenceMechanism mp)
    {
        this.mp = mp;
    }
    public void filter(int codigo) throws RepositoryException, ObjectNotFoundException
    {
    } public void insert(DiseaseType td) throws RepositoryException, ObjectAlreadyInsertedException,
        ObjectNotValidException
    {
    }
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
        } catch (PersistenceMechanismException e) { //1
            throw new PersistenceSoftException(e);
        } catch (SQLException e) { //1
            System.out.println(sql);
            throw new PersistenceSoftException(e);
        } finally {
            try { //1
                mp.releaseCommunicationChannel();
            } catch (PersistenceMechanismException e) { //1
                throw new PersistenceSoftException(e);
            }
        }
        return td;
    }
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
        } catch (SQLException e) { //1
            System.out.println(sql);
            e.printStackTrace();
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
        }
        return new ConcreteIterator(listatd);
    }

}
