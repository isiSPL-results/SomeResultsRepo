
//#if 1549944420 
// Compilation Unit of /ArgoFigText.java 
 

//#if -17430127 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1091153129 
import java.awt.Font;
//#endif 


//#if 1836302913 
import java.awt.Rectangle;
//#endif 


//#if -1116628330 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1286817029 
import javax.management.ListenerNotFoundException;
//#endif 


//#if -1416748943 
import javax.management.MBeanNotificationInfo;
//#endif 


//#if 1299653028 
import javax.management.Notification;
//#endif 


//#if -1766040925 
import javax.management.NotificationBroadcasterSupport;
//#endif 


//#if -800375516 
import javax.management.NotificationEmitter;
//#endif 


//#if -1466832308 
import javax.management.NotificationFilter;
//#endif 


//#if -1213883824 
import javax.management.NotificationListener;
//#endif 


//#if 484030476 
import org.argouml.application.events.ArgoDiagramAppearanceEvent;
//#endif 


//#if -264936049 
import org.argouml.kernel.Project;
//#endif 


//#if -1141446757 
import org.argouml.model.Model;
//#endif 


//#if 1617888126 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if -212090011 
import org.tigris.gef.presentation.FigText;
//#endif 


//#if 53656011 
public class ArgoFigText extends 
//#if 707838362 
FigText
//#endif 

 implements 
//#if 284292300 
NotificationEmitter
//#endif 

, 
//#if 823723700 
ArgoFig
//#endif 

  { 

//#if 1976994765 
private NotificationBroadcasterSupport notifier =
        new NotificationBroadcasterSupport();
//#endif 


//#if 647888686 
private DiagramSettings settings;
//#endif 


//#if 1480975652 
protected void updateFont()
    { 

//#if -1683974988 
setFont(getSettings().getFont(getFigFontStyle()));
//#endif 

} 

//#endif 


//#if 4401886 

//#if -182239478 
@SuppressWarnings("deprecation")
//#endif 


    @Override
    @Deprecated
    public void setOwner(Object own)
    { 

//#if -1149093488 
super.setOwner(own);
//#endif 

} 

//#endif 


//#if 179542537 
public void addNotificationListener(NotificationListener listener,
                                        NotificationFilter filter, Object handback)
    throws IllegalArgumentException
    { 

//#if 394891733 
notifier.addNotificationListener(listener, filter, handback);
//#endif 

} 

//#endif 


//#if -53390088 
public MBeanNotificationInfo[] getNotificationInfo()
    { 

//#if -9973986 
return notifier.getNotificationInfo();
//#endif 

} 

//#endif 


//#if 609075624 
public ArgoFigText(Object owner, Rectangle bounds,
                       DiagramSettings renderSettings, boolean expandOnly)
    { 

//#if 938661359 
this(bounds.x, bounds.y, bounds.width, bounds.height, expandOnly);
//#endif 


//#if -666804579 
settings = renderSettings;
//#endif 


//#if 453886579 
super.setFontFamily(settings.getFontName());
//#endif 


//#if 504433836 
super.setFontSize(settings.getFontSize());
//#endif 


//#if -810813605 
super.setFillColor(FILL_COLOR);
//#endif 


//#if 1196202984 
super.setTextFillColor(FILL_COLOR);
//#endif 


//#if 1866102319 
super.setTextColor(TEXT_COLOR);
//#endif 


//#if -1263356088 
if(owner != null)//1
{ 

//#if 1508825901 
super.setOwner(owner);
//#endif 


//#if -1380757485 
Model.getPump().addModelEventListener(this, owner, "remove");
//#endif 

} 

//#endif 

} 

//#endif 


//#if -858484613 
@Override
    public void propertyChange(PropertyChangeEvent pce)
    { 

//#if -339212643 
super.propertyChange(pce);
//#endif 


//#if 315857758 
if("remove".equals(pce.getPropertyName())
                && (pce.getSource() == getOwner()))//1
{ 

//#if -1554677022 
deleteFromModel();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 673187043 
@Override
    public void deleteFromModel()
    { 

//#if 1661978420 
super.deleteFromModel();
//#endif 


//#if -1405999438 
firePropChange("remove", null, null);
//#endif 


//#if -2004449522 
notifier.sendNotification(new Notification("remove", this, 0));
//#endif 

} 

//#endif 


//#if -1194416360 

//#if -441451247 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public Project getProject()
    { 

//#if 957465538 
return ArgoFigUtil.getProject(this);
//#endif 

} 

//#endif 


//#if 270914356 
public void removeNotificationListener(NotificationListener listener,
                                           NotificationFilter filter, Object handback)
    throws ListenerNotFoundException
    { 

//#if 1535936330 
notifier.removeNotificationListener(listener, filter, handback);
//#endif 

} 

//#endif 


//#if 1810535494 
@Deprecated
    public void diagramFontChanged(
        @SuppressWarnings("unused") ArgoDiagramAppearanceEvent e)
    { 

//#if -1133970710 
renderingChanged();
//#endif 

} 

//#endif 


//#if -1093089647 

//#if 474592515 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public void setProject(Project project)
    { 

//#if 1915983332 
throw new UnsupportedOperationException();
//#endif 

} 

//#endif 


//#if 61589757 
public void renderingChanged()
    { 

//#if -242333321 
updateFont();
//#endif 


//#if 1492601858 
setBounds(getBounds());
//#endif 


//#if 340430304 
damage();
//#endif 

} 

//#endif 


//#if 2133874686 
@Deprecated
    public ArgoFigText(int x, int y, int w, int h, boolean expandOnly)
    { 

//#if 1512575761 
super(x, y, w, h, expandOnly);
//#endif 


//#if 1103518569 
setFontFamily("dialog");
//#endif 

} 

//#endif 


//#if 1774272772 
public DiagramSettings getSettings()
    { 

//#if -562916146 
if(settings == null)//1
{ 

//#if -491071364 
Project p = getProject();
//#endif 


//#if 889740123 
if(p != null)//1
{ 

//#if 488718202 
return p.getProjectSettings().getDefaultDiagramSettings();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1092809383 
return settings;
//#endif 

} 

//#endif 


//#if 1870424014 
@Deprecated
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 

//#if -1532754928 
if(oldOwner == newOwner)//1
{ 

//#if -1920643687 
return;
//#endif 

} 

//#endif 


//#if 1063613888 
if(oldOwner != null)//1
{ 

//#if -732833131 
Model.getPump().removeModelEventListener(this, oldOwner);
//#endif 

} 

//#endif 


//#if 67238183 
if(newOwner != null)//1
{ 

//#if -621800267 
Model.getPump().addModelEventListener(this, newOwner, "remove");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1091209312 
@Deprecated
    public ArgoFigText(int x, int y, int w, int h)
    { 

//#if 210785565 
super(x, y, w, h);
//#endif 


//#if 230824145 
setFontFamily("dialog");
//#endif 

} 

//#endif 


//#if -21770630 
public void removeNotificationListener(NotificationListener listener)
    throws ListenerNotFoundException
    { 

//#if -129777659 
notifier.removeNotificationListener(listener);
//#endif 

} 

//#endif 


//#if -1405326403 
protected int getFigFontStyle()
    { 

//#if -37316141 
return Font.PLAIN;
//#endif 

} 

//#endif 


//#if 2078737681 
public void setSettings(DiagramSettings renderSettings)
    { 

//#if 919855059 
settings = renderSettings;
//#endif 


//#if -1435936537 
renderingChanged();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

