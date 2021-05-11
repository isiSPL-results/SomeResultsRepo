// Compilation Unit of /ArgoFigLine.java 
 
package org.argouml.gefext;
import java.awt.Color;
import javax.management.ListenerNotFoundException;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.NotificationEmitter;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import org.tigris.gef.presentation.FigLine;
public class ArgoFigLine extends FigLine
 implements NotificationEmitter
  { 
private NotificationBroadcasterSupport notifier =
        new NotificationBroadcasterSupport();
public ArgoFigLine()
    { 
super();
} 

@Override
    public void deleteFromModel()
    { 
super.deleteFromModel();
firePropChange("remove", null, null);
notifier.sendNotification(new Notification("remove", this, 0));
} 

public MBeanNotificationInfo[] getNotificationInfo()
    { 
return notifier.getNotificationInfo();
} 

public ArgoFigLine(int x1, int y1, int x2, int y2)
    { 
super(x1, y1, x2, y2 );
} 

public void removeNotificationListener(NotificationListener listener)
    throws ListenerNotFoundException
    { 
notifier.removeNotificationListener(listener);
} 

public void removeNotificationListener(NotificationListener listener,
                                           NotificationFilter filter, Object handback)
    throws ListenerNotFoundException
    { 
notifier.removeNotificationListener(listener, filter, handback);
} 

public ArgoFigLine(int x1, int y1, int x2, int y2, Color lineColor)
    { 
super(x1, y1, x2, y2, lineColor);
} 

public void addNotificationListener(NotificationListener listener,
                                        NotificationFilter filter, Object handback)
    throws IllegalArgumentException
    { 
notifier.addNotificationListener(listener, filter, handback);
} 

 } 


