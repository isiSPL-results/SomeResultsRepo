
//#if 1915142564 
// Compilation Unit of /ArgoFigSpline.java 
 

//#if 53237007 
package org.argouml.gefext;
//#endif 


//#if 251612621 
import javax.management.ListenerNotFoundException;
//#endif 


//#if -1894847421 
import javax.management.MBeanNotificationInfo;
//#endif 


//#if -1917558382 
import javax.management.Notification;
//#endif 


//#if 1143913233 
import javax.management.NotificationBroadcasterSupport;
//#endif 


//#if 1053873526 
import javax.management.NotificationEmitter;
//#endif 


//#if -575733830 
import javax.management.NotificationFilter;
//#endif 


//#if 433261630 
import javax.management.NotificationListener;
//#endif 


//#if -891832977 
import org.tigris.gef.presentation.FigSpline;
//#endif 


//#if 1978089949 
public class ArgoFigSpline extends 
//#if -2023562849 
FigSpline
//#endif 

 implements 
//#if -357768147 
NotificationEmitter
//#endif 

  { 

//#if -1036241844 
private NotificationBroadcasterSupport notifier =
        new NotificationBroadcasterSupport();
//#endif 


//#if 1554397211 
public void removeNotificationListener(NotificationListener listener)
    throws ListenerNotFoundException
    { 

//#if 2075240786 
notifier.removeNotificationListener(listener);
//#endif 

} 

//#endif 


//#if 1728553890 
@Override
    public void deleteFromModel()
    { 

//#if 2119748199 
super.deleteFromModel();
//#endif 


//#if 1990014367 
firePropChange("remove", null, null);
//#endif 


//#if 1429810369 
notifier.sendNotification(new Notification("remove", this, 0));
//#endif 

} 

//#endif 


//#if -183954553 
public ArgoFigSpline(int x, int y)
    { 

//#if -1866692397 
super(x, y);
//#endif 

} 

//#endif 


//#if 913721301 
public void removeNotificationListener(NotificationListener listener,
                                           NotificationFilter filter, Object handback)
    throws ListenerNotFoundException
    { 

//#if -1245327208 
notifier.removeNotificationListener(listener, filter, handback);
//#endif 

} 

//#endif 


//#if 297843063 
public MBeanNotificationInfo[] getNotificationInfo()
    { 

//#if 1228607450 
return notifier.getNotificationInfo();
//#endif 

} 

//#endif 


//#if -1715713474 
public ArgoFigSpline()
    { 
} 

//#endif 


//#if 166823722 
public void addNotificationListener(NotificationListener listener,
                                        NotificationFilter filter, Object handback)
    throws IllegalArgumentException
    { 

//#if 657919383 
notifier.addNotificationListener(listener, filter, handback);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

