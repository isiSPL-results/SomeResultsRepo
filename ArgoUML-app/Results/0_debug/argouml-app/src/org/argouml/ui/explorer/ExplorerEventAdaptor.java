
//#if -1723943705 
// Compilation Unit of /ExplorerEventAdaptor.java 
 

//#if -875849683 
package org.argouml.ui.explorer;
//#endif 


//#if 1602745600 
import java.beans.PropertyChangeEvent;
//#endif 


//#if -1006545528 
import java.beans.PropertyChangeListener;
//#endif 


//#if -2090449590 
import javax.swing.SwingUtilities;
//#endif 


//#if 736720399 
import org.argouml.application.events.ArgoEventPump;
//#endif 


//#if 1481787174 
import org.argouml.application.events.ArgoEventTypes;
//#endif 


//#if -804018572 
import org.argouml.application.events.ArgoProfileEvent;
//#endif 


//#if -1625796832 
import org.argouml.application.events.ArgoProfileEventListener;
//#endif 


//#if -1682843177 
import org.argouml.configuration.Configuration;
//#endif 


//#if -1724345392 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1799212576 
import org.argouml.model.AddAssociationEvent;
//#endif 


//#if -1954577074 
import org.argouml.model.AttributeChangeEvent;
//#endif 


//#if 2142090336 
import org.argouml.model.DeleteInstanceEvent;
//#endif 


//#if 2072738096 
import org.argouml.model.InvalidElementException;
//#endif 


//#if 1646202993 
import org.argouml.model.Model;
//#endif 


//#if -919002049 
import org.argouml.model.RemoveAssociationEvent;
//#endif 


//#if 1098172486 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if -1952029273 
import org.argouml.notation.Notation;
//#endif 


//#if -201333506 
import org.apache.log4j.Logger;
//#endif 


//#if 1260214925 
public final class ExplorerEventAdaptor implements 
//#if -1442301189 
PropertyChangeListener
//#endif 

  { 

//#if 1401505549 
private static ExplorerEventAdaptor instance;
//#endif 


//#if -758451692 
private TreeModelUMLEventListener treeModel;
//#endif 


//#if -1410102378 
private static final Logger LOG =
        Logger.getLogger(ExplorerEventAdaptor.class);
//#endif 


//#if -1437563283 
private void modelChanged(UmlChangeEvent event)
    { 

//#if -340430218 
if(event instanceof AttributeChangeEvent)//1
{ 

//#if 209139080 
treeModel.modelElementChanged(event.getSource());
//#endif 

} 
else

//#if 1024150698 
if(event instanceof RemoveAssociationEvent)//1
{ 

//#if 797173585 
if(!("namespace".equals(event.getPropertyName())))//1
{ 

//#if 1469355552 
treeModel.modelElementChanged(((RemoveAssociationEvent) event)
                                              .getChangedValue());
//#endif 

} 

//#endif 

} 
else

//#if -783176259 
if(event instanceof AddAssociationEvent)//1
{ 

//#if -1024769160 
if(!("namespace".equals(event.getPropertyName())))//1
{ 

//#if -243110396 
treeModel.modelElementAdded(
                    ((AddAssociationEvent) event).getSource());
//#endif 

} 

//#endif 

} 
else

//#if -445338532 
if(event instanceof DeleteInstanceEvent)//1
{ 

//#if 390402959 
treeModel.modelElementRemoved(((DeleteInstanceEvent) event)
                                          .getSource());
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if -2005368084 
private ExplorerEventAdaptor()
    { 

//#if 2116117996 
Configuration.addListener(Notation.KEY_USE_GUILLEMOTS, this);
//#endif 


//#if 1485143248 
Configuration.addListener(Notation.KEY_SHOW_STEREOTYPES, this);
//#endif 


//#if -1054456018 
ProjectManager.getManager().addPropertyChangeListener(this);
//#endif 


//#if -166411319 
Model.getPump().addClassModelEventListener(this,
                Model.getMetaTypes().getModelElement(), (String[]) null);
//#endif 


//#if 1302088741 
ArgoEventPump.addListener(
            ArgoEventTypes.ANY_PROFILE_EVENT, new ProfileChangeListener());
//#endif 

} 

//#endif 


//#if 1921773424 
@Deprecated
    public void structureChanged()
    { 

//#if -712759641 
if(treeModel == null)//1
{ 

//#if -239355906 
return;
//#endif 

} 

//#endif 


//#if -1283497186 
treeModel.structureChanged();
//#endif 

} 

//#endif 


//#if -1297070766 
public void modelElementChanged(Object element)
    { 

//#if -1951383120 
if(treeModel == null)//1
{ 

//#if 487026935 
return;
//#endif 

} 

//#endif 


//#if -2100048029 
treeModel.modelElementChanged(element);
//#endif 

} 

//#endif 


//#if 1925687145 
public static ExplorerEventAdaptor getInstance()
    { 

//#if -1107641737 
if(instance == null)//1
{ 

//#if -1245156408 
instance = new ExplorerEventAdaptor();
//#endif 

} 

//#endif 


//#if -856568802 
return instance;
//#endif 

} 

//#endif 


//#if 66490886 
public void modelElementAdded(Object element)
    { 

//#if 1414634315 
if(treeModel == null)//1
{ 

//#if 1671216942 
return;
//#endif 

} 

//#endif 


//#if -2074242572 
treeModel.modelElementAdded(element);
//#endif 

} 

//#endif 


//#if -639934502 
public void propertyChange(final PropertyChangeEvent pce)
    { 

//#if -517168879 
if(treeModel == null)//1
{ 

//#if -144305244 
return;
//#endif 

} 

//#endif 


//#if 142383347 
if(pce instanceof UmlChangeEvent)//1
{ 

//#if -825676904 
Runnable doWorkRunnable = new Runnable() {
                public void run() {
                    try {
                        modelChanged((UmlChangeEvent) pce);
                    } catch (InvalidElementException e) {








                    }
                }
            };
//#endif 


//#if -1852676074 
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


//#if 1022564946 
SwingUtilities.invokeLater(doWorkRunnable);
//#endif 

} 
else

//#if -993529168 
if(pce.getPropertyName().equals(
                       // TODO: No one should be sending the deprecated event
                       // from outside ArgoUML, but keep responding to it for now
                       // just in case
                       ProjectManager.CURRENT_PROJECT_PROPERTY_NAME)
                   || pce.getPropertyName().equals(
                       ProjectManager.OPEN_PROJECTS_PROPERTY))//1
{ 

//#if -827248480 
if(pce.getNewValue() != null)//1
{ 

//#if -1359005626 
treeModel.structureChanged();
//#endif 

} 

//#endif 


//#if -204851593 
return;
//#endif 

} 
else

//#if -512176840 
if(Notation.KEY_USE_GUILLEMOTS.isChangedProperty(pce)
                   || Notation.KEY_SHOW_STEREOTYPES.isChangedProperty(pce))//1
{ 

//#if 4027235 
treeModel.structureChanged();
//#endif 

} 
else

//#if 1032432768 
if(pce.getSource() instanceof ProjectManager)//1
{ 

//#if -99554504 
if("remove".equals(pce.getPropertyName()))//1
{ 

//#if -1912586181 
treeModel.modelElementRemoved(pce.getOldValue());
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if -622690849 
public void setTreeModelUMLEventListener(
        TreeModelUMLEventListener newTreeModel)
    { 

//#if -1567184980 
treeModel = newTreeModel;
//#endif 

} 

//#endif 


//#if -1349887977 
class ProfileChangeListener implements 
//#if 839484916 
ArgoProfileEventListener
//#endif 

  { 

//#if 530843020 
public void profileRemoved(ArgoProfileEvent e)
        { 

//#if -1215780204 
structureChanged();
//#endif 

} 

//#endif 


//#if 1625044588 
public void profileAdded(ArgoProfileEvent e)
        { 

//#if -3712901 
structureChanged();
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

