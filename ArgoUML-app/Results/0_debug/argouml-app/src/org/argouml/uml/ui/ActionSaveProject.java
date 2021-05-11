
//#if 1765495900 
// Compilation Unit of /ActionSaveProject.java 
 

//#if 2009791288 
package org.argouml.uml.ui;
//#endif 


//#if -1353963628 
import java.awt.event.ActionEvent;
//#endif 


//#if 696422792 
import javax.swing.AbstractAction;
//#endif 


//#if 1225263370 
import javax.swing.Action;
//#endif 


//#if 357261415 
import javax.swing.Icon;
//#endif 


//#if -1294652620 
import org.apache.log4j.Logger;
//#endif 


//#if 1440667360 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -124210335 
import org.argouml.i18n.Translator;
//#endif 


//#if -2098459002 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 2079264450 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if -126057435 
public class ActionSaveProject extends 
//#if -1130429820 
AbstractAction
//#endif 

  { 

//#if -1110751821 
private static final long serialVersionUID = -5579548202585774293L;
//#endif 


//#if -759855780 
private static final Logger LOG = Logger.getLogger(ActionSaveProject.class);
//#endif 


//#if 811776092 
@Override
    public synchronized void setEnabled(final boolean isEnabled)
    { 

//#if 1419554018 
if(isEnabled == this.enabled)//1
{ 

//#if 1467685017 
return;
//#endif 

} 

//#endif 


//#if -1818087367 
if(LOG.isDebugEnabled())//1
{ 

//#if 22373186 
if(!enabled && isEnabled)//1
{ 

//#if -1058612496 
Throwable throwable = new Throwable();
//#endif 


//#if -1520824556 
throwable.fillInStackTrace();
//#endif 


//#if -1804358733 
LOG.debug("Save action enabled by  ", throwable);
//#endif 

} 
else
{ 

//#if 554358729 
LOG.debug("Save state changed from " + enabled + " to "
                          + isEnabled);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2146826490 
internalSetEnabled(isEnabled);
//#endif 

} 

//#endif 


//#if 772403609 
private void internalSetEnabled(boolean isEnabled)
    { 

//#if 1757799255 
super.setEnabled(isEnabled);
//#endif 


//#if -1215148830 
ProjectBrowser.getInstance().showSaveIndicator();
//#endif 

} 

//#endif 


//#if 2098297067 
protected ActionSaveProject(String name, Icon icon)
    { 

//#if -1950827526 
super(name, icon);
//#endif 

} 

//#endif 


//#if -834287487 
public void actionPerformed(ActionEvent e)
    { 

//#if -486560292 
LOG.info("Performing save action");
//#endif 


//#if -953527778 
ProjectBrowser.getInstance().trySave(
            ProjectManager.getManager().getCurrentProject() != null
            && ProjectManager.getManager().getCurrentProject()
            .getURI() != null);
//#endif 

} 

//#endif 


//#if 2037255218 
public ActionSaveProject()
    { 

//#if 285566527 
super(Translator.localize("action.save-project"),
              ResourceLoaderWrapper.lookupIcon("action.save-project"));
//#endif 


//#if 1772938020 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.save-project"));
//#endif 


//#if 17948571 
super.setEnabled(false);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

