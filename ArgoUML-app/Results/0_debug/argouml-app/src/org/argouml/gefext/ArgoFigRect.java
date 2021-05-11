
//#if -1573234157 
// Compilation Unit of /ArgoFigRect.java 
 

//#if -639890388 
package org.argouml.gefext;
//#endif 


//#if -859904496 
import javax.management.ListenerNotFoundException;
//#endif 


//#if 1905466886 
import javax.management.MBeanNotificationInfo;
//#endif 


//#if 1867749487 
import javax.management.Notification;
//#endif 


//#if 415421614 
import javax.management.NotificationBroadcasterSupport;
//#endif 


//#if 1227660281 
import javax.management.NotificationEmitter;
//#endif 


//#if 122608855 
import javax.management.NotificationFilter;
//#endif 


//#if 1525683739 
import javax.management.NotificationListener;
//#endif 


//#if 1375483929 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if -871680883 
public class ArgoFigRect extends 
//#if -1181396514 
FigRect
//#endif 

 implements 
//#if 52528345 
NotificationEmitter
//#endif 

  { 

//#if -152949216 
private NotificationBroadcasterSupport notifier =
        new NotificationBroadcasterSupport();
//#endif 


//#if 2058536150 
public void addNotificationListener(NotificationListener listener,
                                        NotificationFilter filter, Object handback)
    throws IllegalArgumentException
    { 

//#if -1974902729 
notifier.addNotificationListener(listener, filter, handback);
//#endif 

} 

//#endif 


//#if -1826421941 
public MBeanNotificationInfo[] getNotificationInfo()
    { 

//#if 1170141169 
return notifier.getNotificationInfo();
//#endif 

} 

//#endif 


//#if -1370989481 
public ArgoFigRect(int x, int y, int w, int h)
    { 

//#if 742043168 
super(x, y, w, h);
//#endif 

} 

//#endif 


//#if 74117238 
@Override
    public void deleteFromModel()
    { 

//#if -1525006989 
super.deleteFromModel();
//#endif 


//#if 1725539091 
firePropChange("remove", null, null);
//#endif 


//#if 1062930893 
notifier.sendNotification(new Notification("remove", this, 0));
//#endif 

} 

//#endif 


//#if -1010249855 
public void removeNotificationListener(NotificationListener listener,
                                           NotificationFilter filter, Object handback)
    throws ListenerNotFoundException
    { 

//#if 410835589 
notifier.removeNotificationListener(listener, filter, handback);
//#endif 

} 

//#endif 


//#if 1459280839 
public void removeNotificationListener(NotificationListener listener)
    throws ListenerNotFoundException
    { 

//#if -178986035 
notifier.removeNotificationListener(listener);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

