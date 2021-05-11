
//#if 242127046
// Compilation Unit of /SQLPersistenceMechanismException.java


//#if 1915463092
package lib.exceptions;
//#endif


//#if 276464922
import lib.logging.*;
//#endif


//#if -1878792457
import java.util.logging.Level;
//#endif


//#if -1421886166
public class SQLPersistenceMechanismException extends
//#if -778787253
    PersistenceMechanismException
//#endif

{

//#if 1127678673
    public String sql;
//#endif


//#if -2016071249
    public SQLPersistenceMechanismException(String erro, String sql)
    {

//#if -707832850
        super(erro);
//#endif


//#if 852261767
        this.sql = sql;
//#endif


//#if 1874017337
        LogMechanism.createOccurrence();
//#endif


//#if -826974858
        LogMechanism.addLog(Level.WARNING, "SQL Error in statement:"+sql);
//#endif

    }

//#endif

}

//#endif


//#endif

