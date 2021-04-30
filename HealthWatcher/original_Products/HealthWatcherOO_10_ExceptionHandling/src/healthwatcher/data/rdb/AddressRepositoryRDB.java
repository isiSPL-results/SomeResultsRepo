package healthwatcher.data.rdb;

import healthwatcher.data.IAddressRepository;
import healthwatcher.model.address.Address;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lib.exceptions.ExceptionMessages;
import lib.exceptions.ObjectAlreadyInsertedException;
import lib.exceptions.ObjectNotFoundException;
import lib.exceptions.ObjectNotValidException;
import lib.exceptions.PersistenceMechanismException;
import lib.exceptions.SQLPersistenceMechanismException;

import lib.exceptions.RepositoryException;
import lib.persistence.IPersistenceMechanism;




/*
 * Repositorio respons�vel por realizar a persit�ncia
 * de endere�os. Esse persist�ncia � realizada em banco
 * de dados relacional utilizando JDBC
 */
public class AddressRepositoryRDB implements IAddressRepository
{

    private IPersistenceMechanism mp;

    private ResultSet resultSet;

    public AddressRepositoryRDB(IPersistenceMechanism mp)
    {
        this.mp = mp;
    }

    /*
     * M�todo para atualiza��o de um endere�o.
     * Na vers�o atual do sistema disque sa�de
     * essa funcionalidade n�o est� implementada.
     */
    public void update(Address end) throws RepositoryException, ObjectNotFoundException
    {
    }

    /*
     * M�todo para verifica��o da exist�ncia de um
     * endere�o com c�digo espec�ficado como par�metro.
     * Na vers�o atual do sistema disque sa�de essa
     * funcionalidade n�o est� implementada.
     */
    public boolean exists(int codigo) throws RepositoryException
    {
        return false;
    }

    /*
     * M�todo para inser��o de endere�o no repositr�rio persistente.
     * Essa implementa��o faz a persist�ncia atrav�s de JDBC
     * conectando com um banco de dados relacional.
     */
    public int insert(Address end) throws ObjectAlreadyInsertedException, ObjectNotValidException,
               ObjectNotValidException, RepositoryException
    {

        // teste da validade do objeto a ser inserido
        if (end == null) {
            throw new ObjectNotValidException(ExceptionMessages.EXC_NULO);
        }

        Statement stmt;

        try {

            // Bloco para a recupera��o de um c�digo sequencial do
            // banco de dados para ser utilizado como identificador
            // e c�digo da tabela de endere�os.
            String consulta = null;
            try {

                //pega id e codigo e seta no objeto primeiro
                consulta = "select * from SCBS_endereco";

                stmt = (Statement) mp.getCommunicationChannel();
                resultSet = stmt.executeQuery(consulta);

                int count = 0;
                while (resultSet.next()) {
                    count++;
                }
                end.setCode(count + 1);

                count++;

                resultSet.close();
                stmt.close();

            } catch (SQLException e) {
                throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD, consulta);
            }

            // Consulta na tabela ao c�digo gerado pelo trecho anterior.
            // Caso o c�digo j� esteja em uso uma exce��o � levantada.
            String sql = null;
            try {
                stmt = (Statement) mp.getCommunicationChannel();
                sql = "SELECT * FROM SCBS_endereco WHERE codigo = '" + end.getCode() + "'";
                resultSet = stmt.executeQuery(sql);

                if (resultSet.next()) {
                    throw new ObjectAlreadyInsertedException(ExceptionMessages.EXC_JA_EXISTE);
                }
                resultSet.close();
                stmt.close();
            } catch (SQLException e) {
                throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD, sql);
            }

            // Essa �ltima etapa da inser��o insere de fato os valores
            // recebidos no objeto do par�metro com c�digo e
            // identificador devidamente alterados
            try {
                sql = "INSERT INTO SCBS_endereco VALUES(";

                //sql += end.getId() + ",";
                sql += "'" + end.getCode() + "',";
                sql += "'" + end.getStreet() + "',";
                sql += "'" + end.getComplement() + "',";
                sql += "'" + end.getZip() + "',";
                sql += "'" + end.getState() + "',";
                sql += "'" + end.getPhone() + "',";
                sql += "'" + end.getCity() + "',";
                sql += "'" + end.getNeighbourhood() + "')";

                stmt = (Statement) this.mp.getCommunicationChannel();
                stmt.executeUpdate(sql);
                stmt.close();

            } catch (SQLException e) {
                throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD, sql);
            }
        } catch (PersistenceMechanismException e) {
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_INCLUSAO);
        }

        // TODO THIS IS WRONG!!!
        return -1;
    }

    /*
     * M�todo para recupera��o de endere�o a partir do c�digo.
     *
     * @param codigo C�digo identificador do endere�o a
     *				 ser recuperado.
     * @return endere�o montado com os dados recuperados do bd
     * @exception RepositorioException caso ocorra algum problema
     *			  relacionado ao acesso aos dados persistentes.
     * @exception ObjetoInexistenteException caso o endere�o
     *			  n�o seja encontrada nos dados persistentes
     */
    public Address search(int code) throws RepositoryException, ObjectNotFoundException
    {
        Address end = null;
        String sql = null;
        try {
            sql = "select * from SCBS_endereco where " + " codigo = '" + code + "'";

            Statement stmt = (Statement) this.mp.getCommunicationChannel();

            //System.out.println(sql);
            resultSet = stmt.executeQuery(sql);

            if (resultSet.next()) {
                //long id = resultSet.getLong("ID");
                code = (new Integer(resultSet.getString("codigo"))).intValue();

                String rua = resultSet.getString("rua");
                String complemento = resultSet.getString("complemento");
                String cep = resultSet.getString("cep");
                String uf = resultSet.getString("uf");
                String fone = resultSet.getString("fone");
                String cidade = resultSet.getString("cidade");
                String bairro = resultSet.getString("bairro");
                end = new Address(rua, complemento, cep, uf, fone, cidade, bairro);
                end.setCode(code);

            } else {
                throw new ObjectNotFoundException(ExceptionMessages.EXC_FALHA_PROCURA);
            }
            resultSet.close();
            stmt.close();

        } catch (PersistenceMechanismException e) {
            throw new RepositoryException(ExceptionMessages.EXC_FALHA_BD);
        } catch (SQLException e) {
            throw new SQLPersistenceMechanismException(ExceptionMessages.EXC_FALHA_BD,sql);
        }

        return end;
    }

    public void remove(int code) throws ObjectNotFoundException, RepositoryException
    {
    }
}
