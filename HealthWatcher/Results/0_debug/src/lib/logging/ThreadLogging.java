
//#if -1747378450
// Compilation Unit of /ThreadLogging.java


//#if -958976422
package lib.logging;
//#endif


//#if -519513903
import java.lang.Thread.UncaughtExceptionHandler;
//#endif


//#if 1848047772
import java.util.logging.Level;
//#endif


//#if -1618616873
public class ThreadLogging implements
//#if 1358873826
    UncaughtExceptionHandler
//#endif

{

//#if 388463557
    public void uncaughtException(Thread t, Throwable e)
    {

//#if 2006642638
        LogMechanism.createOccurrence();
//#endif


//#if -221201413
        LogMechanism.addLog(Level.WARNING, "Problem with Thread:" + t.getName() + ", Exception:"
                            + e.toString() + ", Line:" + e.getStackTrace()[0].getLineNumber() + ", Method:"
                            + e.getStackTrace()[0].getMethodName());
//#endif

    }

//#endif

}

//#endif


//#endif

