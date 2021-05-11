package org.argouml.uml.diagram.ui;
import java.awt.Font;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import javax.management.ListenerNotFoundException;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import javax.management.NotificationEmitter;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import org.argouml.application.events.ArgoDiagramAppearanceEvent;
import org.argouml.kernel.Project;
import org.argouml.model.Model;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.presentation.FigText;
public class ArgoFigText extends FigText
 implements NotificationEmitter
,ArgoFig
  { 
private NotificationBroadcasterSupport notifier =
        new NotificationBroadcasterSupport();
private DiagramSettings settings;
protected void updateFont()
    { 
setFont(getSettings().getFont(getFigFontStyle()));
} 
@SuppressWarnings("deprecation")

    @Override
    @Deprecated
    public void setOwner(Object own)
    { 
super.setOwner(own);
} 
public void addNotificationListener(NotificationListener listener,
                                        NotificationFilter filter, Object handback)
    throws IllegalArgumentException
    { 
notifier.addNotificationListener(listener, filter, handback);
} 
public MBeanNotificationInfo[] getNotificationInfo()
    { 
return notifier.getNotificationInfo();
} 
public ArgoFigText(Object owner, Rectangle bounds,
                       DiagramSettings renderSettings, boolean expandOnly)
    { 
this(bounds.x, bounds.y, bounds.width, bounds.height, expandOnly);
settings = renderSettings;
super.setFontFamily(settings.getFontName());
super.setFontSize(settings.getFontSize());
super.setFillColor(FILL_COLOR);
super.setTextFillColor(FILL_COLOR);
super.setTextColor(TEXT_COLOR);
if(owner != null)//1
{ 
super.setOwner(owner);
Model.getPump().addModelEventListener(this, owner, "remove");
} 
} 
@Override
    public void propertyChange(PropertyChangeEvent pce)
    { 
super.propertyChange(pce);
if("remove".equals(pce.getPropertyName())
                && (pce.getSource() == getOwner()))//1
{ 
deleteFromModel();
} 
} 
@Override
    public void deleteFromModel()
    { 
super.deleteFromModel();
firePropChange("remove", null, null);
notifier.sendNotification(new Notification("remove", this, 0));
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public Project getProject()
    { 
return ArgoFigUtil.getProject(this);
} 
public void removeNotificationListener(NotificationListener listener,
                                           NotificationFilter filter, Object handback)
    throws ListenerNotFoundException
    { 
notifier.removeNotificationListener(listener, filter, handback);
} 
@Deprecated
    public void diagramFontChanged(
        @SuppressWarnings("unused") ArgoDiagramAppearanceEvent e)
    { 
renderingChanged();
} 
@SuppressWarnings("deprecation")

    @Deprecated
    public void setProject(Project project)
    { 
throw new UnsupportedOperationException();
} 
public void renderingChanged()
    { 
updateFont();
setBounds(getBounds());
damage();
} 
@Deprecated
    public ArgoFigText(int x, int y, int w, int h, boolean expandOnly)
    { 
super(x, y, w, h, expandOnly);
setFontFamily("dialog");
} 
public DiagramSettings getSettings()
    { 
if(settings == null)//1
{ 
Project p = getProject();
if(p != null)//1
{ 
return p.getProjectSettings().getDefaultDiagramSettings();
} 
} 
return settings;
} 
@Deprecated
    protected void updateListeners(Object oldOwner, Object newOwner)
    { 
if(oldOwner == newOwner)//1
{ 
return;
} 
if(oldOwner != null)//1
{ 
Model.getPump().removeModelEventListener(this, oldOwner);
} 
if(newOwner != null)//1
{ 
Model.getPump().addModelEventListener(this, newOwner, "remove");
} 
} 
@Deprecated
    public ArgoFigText(int x, int y, int w, int h)
    { 
super(x, y, w, h);
setFontFamily("dialog");
} 
public void removeNotificationListener(NotificationListener listener)
    throws ListenerNotFoundException
    { 
notifier.removeNotificationListener(listener);
} 
protected int getFigFontStyle()
    { 
return Font.PLAIN;
} 
public void setSettings(DiagramSettings renderSettings)
    { 
settings = renderSettings;
renderingChanged();
} 

 } 
