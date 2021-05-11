// Compilation Unit of /ExplorerEventAdaptor.java 
 
package org.argouml.ui.explorer;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.SwingUtilities;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoProfileEvent;
import org.argouml.application.events.ArgoProfileEventListener;
import org.argouml.configuration.Configuration;
import org.argouml.kernel.ProjectManager;
import org.argouml.model.AddAssociationEvent;
import org.argouml.model.AttributeChangeEvent;
import org.argouml.model.DeleteInstanceEvent;
import org.argouml.model.InvalidElementException;
import org.argouml.model.Model;
import org.argouml.model.RemoveAssociationEvent;
import org.argouml.model.UmlChangeEvent;
import org.argouml.notation.Notation;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public final class ExplorerEventAdaptor implements PropertyChangeListener
  { 
private static ExplorerEventAdaptor instance;
private TreeModelUMLEventListener treeModel;

//#if LOGGING 
private static final Logger LOG =
        Logger.getLogger(ExplorerEventAdaptor.class);
//#endif 

private void modelChanged(UmlChangeEvent event)
    { 
if(event instanceof AttributeChangeEvent)//1
{ 
treeModel.modelElementChanged(event.getSource());
} 
else
if(event instanceof RemoveAssociationEvent)//1
{ 
if(!("namespace".equals(event.getPropertyName())))//1
{ 
treeModel.modelElementChanged(((RemoveAssociationEvent) event)
                                              .getChangedValue());
} 

} 
else
if(event instanceof AddAssociationEvent)//1
{ 
if(!("namespace".equals(event.getPropertyName())))//1
{ 
treeModel.modelElementAdded(
                    ((AddAssociationEvent) event).getSource());
} 

} 
else
if(event instanceof DeleteInstanceEvent)//1
{ 
treeModel.modelElementRemoved(((DeleteInstanceEvent) event)
                                          .getSource());
} 




} 

private ExplorerEventAdaptor()
    { 
Configuration.addListener(Notation.KEY_USE_GUILLEMOTS, this);
Configuration.addListener(Notation.KEY_SHOW_STEREOTYPES, this);
ProjectManager.getManager().addPropertyChangeListener(this);
Model.getPump().addClassModelEventListener(this,
                Model.getMetaTypes().getModelElement(), (String[]) null);
ArgoEventPump.addListener(
            ArgoEventTypes.ANY_PROFILE_EVENT, new ProfileChangeListener());
} 

@Deprecated
    public void structureChanged()
    { 
if(treeModel == null)//1
{ 
return;
} 

treeModel.structureChanged();
} 

public void modelElementChanged(Object element)
    { 
if(treeModel == null)//1
{ 
return;
} 

treeModel.modelElementChanged(element);
} 

public static ExplorerEventAdaptor getInstance()
    { 
if(instance == null)//1
{ 
instance = new ExplorerEventAdaptor();
} 

return instance;
} 

public void modelElementAdded(Object element)
    { 
if(treeModel == null)//1
{ 
return;
} 

treeModel.modelElementAdded(element);
} 

public void propertyChange(final PropertyChangeEvent pce)
    { 
if(treeModel == null)//1
{ 
return;
} 

if(pce instanceof UmlChangeEvent)//1
{ 

//#if (CLASS || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) && ! LOGGING  
Runnable doWorkRunnable = new Runnable() {
                public void run() {
                    try {
                        modelChanged((UmlChangeEvent) pce);
                    } catch (InvalidElementException e) {








                    }
                }
            };
//#endif 


//#if LOGGING 
Runnable doWorkRunnable = new Runnable() {
                public void run() {
                    try {
                        modelChanged((UmlChangeEvent) pce);
                    } catch (InvalidElementException e) {



                        if (LOG.isDebugEnabled()) {
                            LOG.debug("updateLayout method accessed "
                                      + "deleted element", e);
                        }

                    }
                }
            };
//#endif 

SwingUtilities.invokeLater(doWorkRunnable);
} 
else
if(pce.getPropertyName().equals(
                       // TODO: No one should be sending the deprecated event
                       // from outside ArgoUML, but keep responding to it for now
                       // just in case
                       ProjectManager.CURRENT_PROJECT_PROPERTY_NAME)
                   || pce.getPropertyName().equals(
                       ProjectManager.OPEN_PROJECTS_PROPERTY))//1
{ 
if(pce.getNewValue() != null)//1
{ 
treeModel.structureChanged();
} 

return;
} 
else
if(Notation.KEY_USE_GUILLEMOTS.isChangedProperty(pce)
                   || Notation.KEY_SHOW_STEREOTYPES.isChangedProperty(pce))//1
{ 
treeModel.structureChanged();
} 
else
if(pce.getSource() instanceof ProjectManager)//1
{ 
if("remove".equals(pce.getPropertyName()))//1
{ 
treeModel.modelElementRemoved(pce.getOldValue());
} 

} 




} 

public void setTreeModelUMLEventListener(
        TreeModelUMLEventListener newTreeModel)
    { 
treeModel = newTreeModel;
} 

class ProfileChangeListener implements ArgoProfileEventListener
  { 
public void profileRemoved(ArgoProfileEvent e)
        { 
structureChanged();
} 

public void profileAdded(ArgoProfileEvent e)
        { 
structureChanged();
} 

 } 

 } 


