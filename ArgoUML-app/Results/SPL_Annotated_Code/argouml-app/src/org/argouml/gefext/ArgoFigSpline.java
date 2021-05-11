// Compilation Unit of /ArgoFigSpline.java 
 
package org.argouml.gefext;
import javax.management.ListenerNotFoundException;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.NotificationEmitter;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import org.tigris.gef.presentation.FigSpline;
public class ArgoFigSpline extends FigSpline
 implements NotificationEmitter
  { 
private NotificationBroadcasterSupport notifier =
        new NotificationBroadcasterSupport();
public void removeNotificationListener(NotificationListener listener)
    throws ListenerNotFoundException
    { 
notifier.removeNotificationListener(listener);
} 

@Override
    public void deleteFromModel()
    { 
super.deleteFromModel();
firePropChange("remove", null, null);
notifier.sendNotification(new Notification("remove", this, 0));
} 

public ArgoFigSpline(int x, int y)
    { 
super(x, y);
} 

public void removeNotificationListener(NotificationListener listener,
                                           NotificationFilter filter, Object handback)
    throws ListenerNotFoundException
    { 
notifier.removeNotificationListener(listener, filter, handback);
} 

public MBeanNotificationInfo[] getNotificationInfo()
    { 
return notifier.getNotificationInfo();
} 

public ArgoFigSpline()
    { 
} 

public void addNotificationListener(NotificationListener listener,
                                        NotificationFilter filter, Object handback)
    throws IllegalArgumentException
    { 
notifier.addNotificationListener(listener, filter, handback);
} 

 } 


