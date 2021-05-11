// Compilation Unit of /SnoozeOrder.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.critics;
//#endif 


//#if COGNITIVE 
import java.io.Serializable;
//#endif 


//#if COGNITIVE 
import java.util.Date;
//#endif 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
public class SnoozeOrder implements Serializable
  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG = Logger.getLogger(SnoozeOrder.class);
//#endif 

private static final long INITIAL_INTERVAL_MS = 1000 * 60 * 10;
private Date snoozeUntil;
private Date snoozeAgain;
private long interval;
private Date now = new Date();
private static final long serialVersionUID = -7133285313405407967L;
public void unsnooze()
    { 
snoozeUntil =  new Date(0);
} 

public boolean getSnoozed()
    { 
return snoozeUntil.after(getNow());
} 

private Date getNow()
    { 
now.setTime(System.currentTimeMillis());
return now;
} 

public SnoozeOrder()
    { 
snoozeUntil =  new Date(0);
snoozeAgain =  new Date(0);
} 

public void snooze()
    { 
if(snoozeAgain.after(getNow()))//1
{ 
interval = nextInterval(interval);
} 
else
{ 
interval = INITIAL_INTERVAL_MS;
} 

long n = (getNow()).getTime();
snoozeUntil.setTime(n + interval);
snoozeAgain.setTime(n + interval + INITIAL_INTERVAL_MS);

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.info("Setting snooze order to: " + snoozeUntil.toString());
//#endif 

} 

public void setSnoozed(boolean h)
    { 
if(h)//1
{ 
snooze();
} 
else
{ 
unsnooze();
} 

} 

protected long nextInterval(long last)
    { 
return last * 2;
} 

 } 

//#endif 


