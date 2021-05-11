package org.argouml.uml.ui;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import org.apache.log4j.Logger;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.kernel.ProjectManager;
import org.argouml.ui.ProjectBrowser;
public class ActionSaveProject extends AbstractAction
  { 
private static final long serialVersionUID = -5579548202585774293L;
private static final Logger LOG = Logger.getLogger(ActionSaveProject.class);
@Override
    public synchronized void setEnabled(final boolean isEnabled)
    { 
if(isEnabled == this.enabled)//1
{ 
return;
} 
if(LOG.isDebugEnabled())//1
{ 
if(!enabled && isEnabled)//1
{ 
Throwable throwable = new Throwable();
throwable.fillInStackTrace();
LOG.debug("Save action enabled by  ", throwable);
} 
else
{ 
LOG.debug("Save state changed from " + enabled + " to "
                          + isEnabled);
} 
} 
internalSetEnabled(isEnabled);
} 
private void internalSetEnabled(boolean isEnabled)
    { 
super.setEnabled(isEnabled);
ProjectBrowser.getInstance().showSaveIndicator();
} 
protected ActionSaveProject(String name, Icon icon)
    { 
super(name, icon);
} 
public void actionPerformed(ActionEvent e)
    { 
LOG.info("Performing save action");
ProjectBrowser.getInstance().trySave(
            ProjectManager.getManager().getCurrentProject() != null
            && ProjectManager.getManager().getCurrentProject()
            .getURI() != null);
} 
public ActionSaveProject()
    { 
super(Translator.localize("action.save-project"),
              ResourceLoaderWrapper.lookupIcon("action.save-project"));
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.save-project"));
super.setEnabled(false);
} 

 } 
