
//#if -1442640581
// Compilation Unit of /LogMechanism.java


//#if -971548031
package lib.logging;
//#endif


//#if -1064687788
import java.io.File;
//#endif


//#if 1969534141
import java.io.IOException;
//#endif


//#if 128301611
import java.util.logging.FileHandler;
//#endif


//#if 459505173
import java.util.logging.Level;
//#endif


//#if 1632251789
import java.util.logging.Logger;
//#endif


//#if 458435425
import java.util.logging.SimpleFormatter;
//#endif


//#if -2000289542
public class LogMechanism
{

//#if -1666328853
    private static LogMechanism singleton;
//#endif


//#if 942981609
    private int IdLog;
//#endif


//#if 802770147
    private Logger logger;
//#endif


//#if 809613115
    private static String logFile = System.getProperty("java.io.tmpdir") + File.pathSeparator
                                    + "hw.log";
//#endif


//#if 923665277
    private static synchronized LogMechanism getInstance()
    {

//#if 1267911181
        if(singleton == null) { //1

//#if 1093796586
            singleton = new LogMechanism();
//#endif


//#if 1006738125
            singleton.logger = Logger.getLogger("healthwatcher");
//#endif


//#if -1194049163
            singleton.IdLog = 0;
//#endif


//#if -1827399735
            try { //1

//#if -455485820
                FileHandler fh = new FileHandler(logFile);
//#endif


//#if -1787773538
                fh.setFormatter(new SimpleFormatter());
//#endif


//#if -1778646345
                singleton.logger.addHandler(fh);
//#endif

            }

//#if 1892504528
            catch (IOException e) { //1
            }
//#endif


//#endif

        }

//#endif


//#if -1828579746
        return singleton;
//#endif

    }

//#endif


//#if -567162652
    public static void configure(String file)
    {

//#if 386917140
        logFile = file;
//#endif

    }

//#endif


//#if -1942747673
    public static synchronized int createOccurrence()
    {

//#if 2089894292
        getInstance().IdLog = getInstance().IdLog + 1;
//#endif


//#if 1604952308
        return getInstance().IdLog;
//#endif

    }

//#endif


//#if 1432935313
    public static int getLastOccurrence()
    {

//#if 2062634929
        return getInstance().IdLog;
//#endif

    }

//#endif


//#if 291797232
    public static void addLog(Level level, String message)
    {

//#if -1568715859
        if(level.getName().equals("SEVERE")) { //1

//#if 484048405
            getInstance().logger.severe("Log ID:" + getLastOccurrence() + ", Message:" + message);
//#endif

        } else

//#if -448122171
            if(level.getName().equals("WARNING")) { //1

//#if -1388822760
                getInstance().logger.warning("Log ID:" + getLastOccurrence() + ", Message:" + message);
//#endif

            } else

//#if -70075394
                if(level.getName().equals("FINE")) { //1

//#if -1588923656
                    getInstance().logger.fine("Log ID:" + getLastOccurrence() + ", Message:" + message);
//#endif

                } else

//#if -645248591
                    if(level.getName().equals("INFO")) { //1

//#if -1416567865
                        getInstance().logger.info("Log ID:" + getLastOccurrence() + ", Message:" + message);
//#endif

                    }

//#endif


//#endif


//#endif


//#endif

    }

//#endif


//#if -2016579626
    public static void addLogToThreads()
    {

//#if -1630266248
        Thread.setDefaultUncaughtExceptionHandler(new ThreadLogging());
//#endif

    }

//#endif


//#if -435531483
    public static void removeLogToThreads()
    {

//#if 1518409337
        Thread.setDefaultUncaughtExceptionHandler(null);
//#endif

    }

//#endif

}

//#endif


//#endif

