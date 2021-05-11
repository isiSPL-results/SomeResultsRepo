
//#if 723084428 
// Compilation Unit of /ArgoFigLine.java 
 

//#if -62009115 
package org.argouml.gefext;
//#endif 


//#if 1538468233 
import java.awt.Color;
//#endif 


//#if -911154889 
import javax.management.ListenerNotFoundException;
//#endif 


//#if -74005331 
import javax.management.MBeanNotificationInfo;
//#endif 


//#if -1431991832 
import javax.management.Notification;
//#endif 


//#if 493009383 
import javax.management.NotificationBroadcasterSupport;
//#endif 


//#if -177749920 
import javax.management.NotificationEmitter;
//#endif 


//#if -2139484272 
import javax.management.NotificationFilter;
//#endif 


//#if 907640468 
import javax.management.NotificationListener;
//#endif 


//#if -892021054 
import org.tigris.gef.presentation.FigLine;
//#endif 


//#if -503082026 
public class ArgoFigLine extends 
//#if 302865379 
FigLine
//#endif 

 implements 
//#if 1435300174 
NotificationEmitter
//#endif 

  { 

//#if -1290795253 
private NotificationBroadcasterSupport notifier =
        new NotificationBroadcasterSupport();
//#endif 


//#if 69385666 
public ArgoFigLine()
    { 

//#if 1618524667 
super();
//#endif 

} 

//#endif 


//#if -680436575 
@Override
    public void deleteFromModel()
    { 

//#if 1401115873 
super.deleteFromModel();
//#endif 


//#if 285293285 
firePropChange("remove", null, null);
//#endif 


//#if 862028347 
notifier.sendNotification(new Notification("remove", this, 0));
//#endif 

} 

//#endif 


//#if 1280788534 
public MBeanNotificationInfo[] getNotificationInfo()
    { 

//#if -1212504510 
return notifier.getNotificationInfo();
//#endif 

} 

//#endif 


//#if -1566709676 
public ArgoFigLine(int x1, int y1, int x2, int y2)
    { 

//#if -946107798 
super(x1, y1, x2, y2 );
//#endif 

} 

//#endif 


//#if 1061728124 
public void removeNotificationListener(NotificationListener listener)
    throws ListenerNotFoundException
    { 

//#if -531523151 
notifier.removeNotificationListener(listener);
//#endif 

} 

//#endif 


//#if 197528118 
public void removeNotificationListener(NotificationListener listener,
                                           NotificationFilter filter, Object handback)
    throws ListenerNotFoundException
    { 

//#if 751779297 
notifier.removeNotificationListener(listener, filter, handback);
//#endif 

} 

//#endif 


//#if -1721018234 
public ArgoFigLine(int x1, int y1, int x2, int y2, Color lineColor)
    { 

//#if -401224297 
super(x1, y1, x2, y2, lineColor);
//#endif 

} 

//#endif 


//#if 964403723 
public void addNotificationListener(NotificationListener listener,
                                        NotificationFilter filter, Object handback)
    throws IllegalArgumentException
    { 

//#if 1103270875 
notifier.addNotificationListener(listener, filter, handback);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

