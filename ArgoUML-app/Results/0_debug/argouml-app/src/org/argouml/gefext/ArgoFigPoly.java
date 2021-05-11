
//#if 214237857 
// Compilation Unit of /ArgoFigPoly.java 
 

//#if 587610808 
package org.argouml.gefext;
//#endif 


//#if -321185276 
import javax.management.ListenerNotFoundException;
//#endif 


//#if 1966042106 
import javax.management.MBeanNotificationInfo;
//#endif 


//#if 1361971195 
import javax.management.Notification;
//#endif 


//#if 1370290490 
import javax.management.NotificationBroadcasterSupport;
//#endif 


//#if -273950995 
import javax.management.NotificationEmitter;
//#endif 


//#if 1598190435 
import javax.management.NotificationFilter;
//#endif 


//#if -2074592857 
import javax.management.NotificationListener;
//#endif 


//#if -1445442115 
import org.tigris.gef.presentation.FigPoly;
//#endif 


//#if 625592065 
public class ArgoFigPoly extends 
//#if -693577674 
FigPoly
//#endif 

 implements 
//#if 1432134985 
NotificationEmitter
//#endif 

  { 

//#if -1271611472 
private NotificationBroadcasterSupport notifier =
        new NotificationBroadcasterSupport();
//#endif 


//#if 1269218822 
@Override
    public void deleteFromModel()
    { 

//#if 427586936 
super.deleteFromModel();
//#endif 


//#if -1008949778 
firePropChange("remove", null, null);
//#endif 


//#if -1018666158 
notifier.sendNotification(new Notification("remove", this, 0));
//#endif 

} 

//#endif 


//#if -1943996361 
public void removeNotificationListener(NotificationListener listener)
    throws ListenerNotFoundException
    { 

//#if 1748055403 
notifier.removeNotificationListener(listener);
//#endif 

} 

//#endif 


//#if 1706408945 
public void removeNotificationListener(NotificationListener listener,
                                           NotificationFilter filter, Object handback)
    throws ListenerNotFoundException
    { 

//#if -1825258554 
notifier.removeNotificationListener(listener, filter, handback);
//#endif 

} 

//#endif 


//#if 1453315291 
public MBeanNotificationInfo[] getNotificationInfo()
    { 

//#if 1057465467 
return notifier.getNotificationInfo();
//#endif 

} 

//#endif 


//#if -1989711546 
public void addNotificationListener(NotificationListener listener,
                                        NotificationFilter filter, Object handback)
    throws IllegalArgumentException
    { 

//#if 1557062131 
notifier.addNotificationListener(listener, filter, handback);
//#endif 

} 

//#endif 


//#if 186237845 
public ArgoFigPoly ()
    { 
} 

//#endif 


//#if 2008624144 
public ArgoFigPoly(int x, int y)
    { 

//#if 1252539080 
super(x, y);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

