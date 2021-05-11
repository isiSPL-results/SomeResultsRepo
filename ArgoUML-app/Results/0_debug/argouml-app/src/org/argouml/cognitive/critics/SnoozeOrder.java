
//#if 1399776078 
// Compilation Unit of /SnoozeOrder.java 
 

//#if 588927766 
package org.argouml.cognitive.critics;
//#endif 


//#if 1859046558 
import java.io.Serializable;
//#endif 


//#if -970913493 
import java.util.Date;
//#endif 


//#if -1047083805 
import org.apache.log4j.Logger;
//#endif 


//#if -682229162 
public class SnoozeOrder implements 
//#if 773214422 
Serializable
//#endif 

  { 

//#if 1366416617 
private static final Logger LOG = Logger.getLogger(SnoozeOrder.class);
//#endif 


//#if 1507394887 
private static final long INITIAL_INTERVAL_MS = 1000 * 60 * 10;
//#endif 


//#if 78836829 
private Date snoozeUntil;
//#endif 


//#if -500776805 
private Date snoozeAgain;
//#endif 


//#if 1722653998 
private long interval;
//#endif 


//#if -592177587 
private Date now = new Date();
//#endif 


//#if -211654925 
private static final long serialVersionUID = -7133285313405407967L;
//#endif 


//#if 1182221044 
public void unsnooze()
    { 

//#if 1061047417 
snoozeUntil =  new Date(0);
//#endif 

} 

//#endif 


//#if -2044160303 
public boolean getSnoozed()
    { 

//#if 1088661090 
return snoozeUntil.after(getNow());
//#endif 

} 

//#endif 


//#if 1431156699 
private Date getNow()
    { 

//#if 1557328738 
now.setTime(System.currentTimeMillis());
//#endif 


//#if 1964530886 
return now;
//#endif 

} 

//#endif 


//#if 380054665 
public SnoozeOrder()
    { 

//#if 249608400 
snoozeUntil =  new Date(0);
//#endif 


//#if -933529134 
snoozeAgain =  new Date(0);
//#endif 

} 

//#endif 


//#if 545344091 
public void snooze()
    { 

//#if 1861782244 
if(snoozeAgain.after(getNow()))//1
{ 

//#if 896049314 
interval = nextInterval(interval);
//#endif 

} 
else
{ 

//#if -652974173 
interval = INITIAL_INTERVAL_MS;
//#endif 

} 

//#endif 


//#if 956666171 
long n = (getNow()).getTime();
//#endif 


//#if 1196153314 
snoozeUntil.setTime(n + interval);
//#endif 


//#if -51386790 
snoozeAgain.setTime(n + interval + INITIAL_INTERVAL_MS);
//#endif 


//#if 1339917044 
LOG.info("Setting snooze order to: " + snoozeUntil.toString());
//#endif 

} 

//#endif 


//#if -1123560399 
public void setSnoozed(boolean h)
    { 

//#if -2075433532 
if(h)//1
{ 

//#if 482083783 
snooze();
//#endif 

} 
else
{ 

//#if 1860934893 
unsnooze();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1402012954 
protected long nextInterval(long last)
    { 

//#if 329025971 
return last * 2;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

