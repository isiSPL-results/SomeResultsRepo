
//#if 1213518568 
// Compilation Unit of /ArgoFigInk.java 
 

//#if 48664125 
package org.argouml.gefext;
//#endif 


//#if -1625513761 
import javax.management.ListenerNotFoundException;
//#endif 


//#if -1729849259 
import javax.management.MBeanNotificationInfo;
//#endif 


//#if 1507031360 
import javax.management.Notification;
//#endif 


//#if -14384321 
import javax.management.NotificationBroadcasterSupport;
//#endif 


//#if 937844232 
import javax.management.NotificationEmitter;
//#endif 


//#if 2052922600 
import javax.management.NotificationFilter;
//#endif 


//#if 1131320812 
import javax.management.NotificationListener;
//#endif 


//#if 383474018 
import org.tigris.gef.presentation.FigInk;
//#endif 


//#if -947913876 
public class ArgoFigInk extends 
//#if 251384365 
FigInk
//#endif 

 implements 
//#if -2072075016 
NotificationEmitter
//#endif 

  { 

//#if 740328993 
private NotificationBroadcasterSupport notifier =
        new NotificationBroadcasterSupport();
//#endif 


//#if -2053191920 
public ArgoFigInk()
    { 
} 

//#endif 


//#if 1137926566 
public void removeNotificationListener(NotificationListener listener)
    throws ListenerNotFoundException
    { 

//#if -912916366 
notifier.removeNotificationListener(listener);
//#endif 

} 

//#endif 


//#if -1367487904 
public void removeNotificationListener(NotificationListener listener,
                                           NotificationFilter filter, Object handback)
    throws ListenerNotFoundException
    { 

//#if -1189526174 
notifier.removeNotificationListener(listener, filter, handback);
//#endif 

} 

//#endif 


//#if 1047585525 
public ArgoFigInk(int x, int y)
    { 

//#if 1802217656 
super(x, y);
//#endif 

} 

//#endif 


//#if 731776821 
public void addNotificationListener(NotificationListener listener,
                                        NotificationFilter filter, Object handback)
    throws IllegalArgumentException
    { 

//#if -1186258821 
notifier.addNotificationListener(listener, filter, handback);
//#endif 

} 

//#endif 


//#if -761515465 
@Override
    public void deleteFromModel()
    { 

//#if -1923026461 
super.deleteFromModel();
//#endif 


//#if -53294941 
firePropChange("remove", null, null);
//#endif 


//#if -1765521859 
notifier.sendNotification(new Notification("remove", this, 0));
//#endif 

} 

//#endif 


//#if -1409704116 
public MBeanNotificationInfo[] getNotificationInfo()
    { 

//#if -1260981738 
return notifier.getNotificationInfo();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

