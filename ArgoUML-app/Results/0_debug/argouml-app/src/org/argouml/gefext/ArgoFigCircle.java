
//#if 1527886897 
// Compilation Unit of /ArgoFigCircle.java 
 

//#if -1433004376 
package org.argouml.gefext;
//#endif 


//#if -350564332 
import javax.management.ListenerNotFoundException;
//#endif 


//#if -413357558 
import javax.management.MBeanNotificationInfo;
//#endif 


//#if 760199147 
import javax.management.Notification;
//#endif 


//#if 270306602 
import javax.management.NotificationBroadcasterSupport;
//#endif 


//#if -1389274883 
import javax.management.NotificationEmitter;
//#endif 


//#if -654545069 
import javax.management.NotificationFilter;
//#endif 


//#if 2005072279 
import javax.management.NotificationListener;
//#endif 


//#if -830222935 
import org.tigris.gef.presentation.FigCircle;
//#endif 


//#if -1071052107 
public class ArgoFigCircle extends 
//#if 1781046915 
FigCircle
//#endif 

 implements 
//#if 1401377234 
NotificationEmitter
//#endif 

  { 

//#if 1766827527 
private NotificationBroadcasterSupport notifier =
        new NotificationBroadcasterSupport();
//#endif 


//#if 1609684786 
public MBeanNotificationInfo[] getNotificationInfo()
    { 

//#if 1949025120 
return notifier.getNotificationInfo();
//#endif 

} 

//#endif 


//#if -1856292465 
public void addNotificationListener(NotificationListener listener,
                                        NotificationFilter filter, Object handback)
    throws IllegalArgumentException
    { 

//#if 380210508 
notifier.addNotificationListener(listener, filter, handback);
//#endif 

} 

//#endif 


//#if 1555797149 
@Override
    public void deleteFromModel()
    { 

//#if -608744850 
super.deleteFromModel();
//#endif 


//#if -1156957384 
firePropChange("remove", null, null);
//#endif 


//#if 1324250440 
notifier.sendNotification(new Notification("remove", this, 0));
//#endif 

} 

//#endif 


//#if 1052455826 
public ArgoFigCircle(int x, int y, int w, int h)
    { 

//#if 679093822 
super(x, y, w, h);
//#endif 

} 

//#endif 


//#if 1974450432 
public void removeNotificationListener(NotificationListener listener)
    throws ListenerNotFoundException
    { 

//#if 938846720 
notifier.removeNotificationListener(listener);
//#endif 

} 

//#endif 


//#if -1287241798 
public void removeNotificationListener(NotificationListener listener,
                                           NotificationFilter filter, Object handback)
    throws ListenerNotFoundException
    { 

//#if -107303523 
notifier.removeNotificationListener(listener, filter, handback);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

