
//#if 2136239589 
// Compilation Unit of /ArgoFigRRect.java 
 

//#if -1326162145 
package org.argouml.gefext;
//#endif 


//#if 803533245 
import javax.management.ListenerNotFoundException;
//#endif 


//#if 147064883 
import javax.management.MBeanNotificationInfo;
//#endif 


//#if -557639774 
import javax.management.Notification;
//#endif 


//#if -1444803295 
import javax.management.NotificationBroadcasterSupport;
//#endif 


//#if -704893594 
import javax.management.NotificationEmitter;
//#endif 


//#if -1463752246 
import javax.management.NotificationFilter;
//#endif 


//#if 1746055758 
import javax.management.NotificationListener;
//#endif 


//#if 2035240432 
import org.tigris.gef.presentation.FigRRect;
//#endif 


//#if -1396340262 
public class ArgoFigRRect extends 
//#if 1233749117 
FigRRect
//#endif 

 implements 
//#if -369517960 
NotificationEmitter
//#endif 

  { 

//#if 144498849 
private NotificationBroadcasterSupport notifier =
        new NotificationBroadcasterSupport();
//#endif 


//#if 105264596 
public ArgoFigRRect(int x, int y, int w, int h)
    { 

//#if 1120680995 
super(x, y, w, h);
//#endif 

} 

//#endif 


//#if 718118880 
public void removeNotificationListener(NotificationListener listener,
                                           NotificationFilter filter, Object handback)
    throws ListenerNotFoundException
    { 

//#if -679695414 
notifier.removeNotificationListener(listener, filter, handback);
//#endif 

} 

//#endif 


//#if -1472947019 
public void addNotificationListener(NotificationListener listener,
                                        NotificationFilter filter, Object handback)
    throws IllegalArgumentException
    { 

//#if -1765378682 
notifier.addNotificationListener(listener, filter, handback);
//#endif 

} 

//#endif 


//#if 1551890892 
public MBeanNotificationInfo[] getNotificationInfo()
    { 

//#if 1525265311 
return notifier.getNotificationInfo();
//#endif 

} 

//#endif 


//#if 1892071206 
public void removeNotificationListener(NotificationListener listener)
    throws ListenerNotFoundException
    { 

//#if 848482503 
notifier.removeNotificationListener(listener);
//#endif 

} 

//#endif 


//#if -1229263689 
@Override
    public void deleteFromModel()
    { 

//#if 94812023 
super.deleteFromModel();
//#endif 


//#if 1046707855 
firePropChange("remove", null, null);
//#endif 


//#if -1823354415 
notifier.sendNotification(new Notification("remove", this, 0));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

