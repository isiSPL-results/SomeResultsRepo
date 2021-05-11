
//#if -830554108 
// Compilation Unit of /PropPanelSignal.java 
 

//#if 343180263 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 1061714837 
import java.awt.event.ActionEvent;
//#endif 


//#if -681386 
import java.util.ArrayList;
//#endif 


//#if 1318475211 
import java.util.Collection;
//#endif 


//#if 2097806923 
import java.util.List;
//#endif 


//#if -1508490570 
import javax.swing.JScrollPane;
//#endif 


//#if 1747378048 
import org.argouml.i18n.Translator;
//#endif 


//#if -1979029659 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1535339078 
import org.argouml.model.Model;
//#endif 


//#if 1391651508 
import org.argouml.uml.ui.AbstractActionAddModelElement2;
//#endif 


//#if 172514860 
import org.argouml.uml.ui.AbstractActionRemoveElement;
//#endif 


//#if 1294027160 
import org.argouml.uml.ui.ActionNavigateNamespace;
//#endif 


//#if 1700911518 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -2088991455 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if 507334974 
import org.argouml.uml.ui.foundation.core.PropPanelClassifier;
//#endif 


//#if 910764489 
import org.argouml.uml.ui.foundation.extension_mechanisms.ActionNewStereotype;
//#endif 


//#if -326545198 
class ActionRemoveContextSignal extends 
//#if -1217134500 
AbstractActionRemoveElement
//#endif 

  { 

//#if 688431332 
private static final long serialVersionUID = -3345844954130000669L;
//#endif 


//#if 392390225 
public ActionRemoveContextSignal()
    { 

//#if -309801749 
super(Translator.localize("menu.popup.remove"));
//#endif 

} 

//#endif 


//#if 1965087621 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if -1493981088 
super.actionPerformed(e);
//#endif 


//#if 1866033465 
Object context = getObjectToRemove();
//#endif 


//#if 1993120821 
if(context != null)//1
{ 

//#if 296401472 
Object signal = getTarget();
//#endif 


//#if 1405027036 
if(Model.getFacade().isASignal(signal))//1
{ 

//#if 1660519845 
Model.getCommonBehaviorHelper().removeContext(signal, context);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if -950458921 
class ActionAddReceptionSignal extends 
//#if -270748130 
AbstractActionAddModelElement2
//#endif 

  { 

//#if 181517543 
private static final long serialVersionUID = -2854099588590429237L;
//#endif 


//#if 1919229820 
@Override
    protected void doIt(Collection selected)
    { 

//#if 1361835717 
Model.getCommonBehaviorHelper().setReception(getTarget(), selected);
//#endif 

} 

//#endif 


//#if 2117264030 
public ActionAddReceptionSignal()
    { 

//#if -1967969594 
super();
//#endif 

} 

//#endif 


//#if 1738893857 
protected List getChoices()
    { 

//#if -1966170190 
List ret = new ArrayList();
//#endif 


//#if -361379702 
Object model =
            ProjectManager.getManager().getCurrentProject().getModel();
//#endif 


//#if 351295391 
if(getTarget() != null)//1
{ 

//#if 1390794864 
ret.addAll(Model.getModelManagementHelper()
                       .getAllModelElementsOfKind(model,
                                                  Model.getMetaTypes().getReception()));
//#endif 

} 

//#endif 


//#if 1827075329 
return ret;
//#endif 

} 

//#endif 


//#if 1523668626 
protected String getDialogTitle()
    { 

//#if -946278398 
return Translator.localize("dialog.title.add-receptions");
//#endif 

} 

//#endif 


//#if 174264302 
protected List getSelected()
    { 

//#if -1540587301 
List ret = new ArrayList();
//#endif 


//#if 441169040 
ret.addAll(Model.getFacade().getReceptions(getTarget()));
//#endif 


//#if -148544200 
return ret;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 639133490 
class ActionRemoveReceptionSignal extends 
//#if -1878618262 
AbstractActionRemoveElement
//#endif 

  { 

//#if 1856301403 
private static final long serialVersionUID = -2630315087703962883L;
//#endif 


//#if 442360119 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if 2016183193 
super.actionPerformed(e);
//#endif 


//#if 918803968 
Object reception = getObjectToRemove();
//#endif 


//#if 160809468 
if(reception != null)//1
{ 

//#if 329299135 
Object signal = getTarget();
//#endif 


//#if -711231939 
if(Model.getFacade().isASignal(signal))//1
{ 

//#if -871533925 
Model.getCommonBehaviorHelper().removeReception(signal,
                        reception);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1460452927 
public ActionRemoveReceptionSignal()
    { 

//#if -1127996344 
super(Translator.localize("menu.popup.remove"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1506094957 
class UMLSignalReceptionListModel extends 
//#if 449627732 
UMLModelElementListModel2
//#endif 

  { 

//#if -1219021686 
private static final long serialVersionUID = 3273212639257377015L;
//#endif 


//#if 1868170902 
public UMLSignalReceptionListModel()
    { 

//#if 787576932 
super("reception");
//#endif 

} 

//#endif 


//#if -807691530 
protected boolean isValidElement(Object element)
    { 

//#if -1700847932 
return Model.getFacade().isAReception(element)
               && Model.getFacade().getReceptions(getTarget()).contains(element);
//#endif 

} 

//#endif 


//#if -2057013566 
protected void buildModelList()
    { 

//#if 1917986613 
if(getTarget() != null)//1
{ 

//#if -984818975 
setAllElements(Model.getFacade().getReceptions(getTarget()));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if -2077573465 
public class PropPanelSignal extends 
//#if 614037141 
PropPanelClassifier
//#endif 

  { 

//#if -1111625312 
private static final long serialVersionUID = -4496838172438164508L;
//#endif 


//#if -7721030 
public PropPanelSignal(String title, String iconName)
    { 

//#if 962718677 
super(title, lookupIcon(iconName));
//#endif 


//#if 518071653 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if -692509611 
addField(Translator.localize("label.namespace"),
                 getNamespaceSelector());
//#endif 


//#if 21395256 
add(getModifiersPanel());
//#endif 


//#if -1014471608 
add(getVisibilityPanel());
//#endif 


//#if -534486844 
addSeparator();
//#endif 


//#if -1509981712 
addField(Translator.localize("label.generalizations"),
                 getGeneralizationScroll());
//#endif 


//#if 1033279824 
addField(Translator.localize("label.specializations"),
                 getSpecializationScroll());
//#endif 


//#if -1453756658 
addSeparator();
//#endif 


//#if -450338017 
AbstractActionAddModelElement2 actionAddContext =
            new ActionAddContextSignal();
//#endif 


//#if -1728155513 
AbstractActionRemoveElement actionRemoveContext =
            new ActionRemoveContextSignal();
//#endif 


//#if 369050936 
JScrollPane operationScroll = new JScrollPane(
            new UMLMutableLinkedList(
                new UMLSignalContextListModel(),
                actionAddContext, null,
                actionRemoveContext, true));
//#endif 


//#if -793987335 
addField(Translator.localize("label.contexts"),
                 operationScroll);
//#endif 


//#if -1837316833 
AbstractActionAddModelElement2 actionAddReception =
            new ActionAddReceptionSignal();
//#endif 


//#if 1801607 
AbstractActionRemoveElement actionRemoveReception =
            new ActionRemoveReceptionSignal();
//#endif 


//#if 815952256 
JScrollPane receptionScroll = new JScrollPane(
            new UMLMutableLinkedList(
                new UMLSignalReceptionListModel(),
                actionAddReception, null,
                actionRemoveReception, true));
//#endif 


//#if 496248385 
addField(Translator.localize("label.receptions"),
                 receptionScroll);
//#endif 


//#if 924807978 
addAction(new ActionNavigateNamespace());
//#endif 


//#if 173862568 
addAction(new ActionNewSignal());
//#endif 


//#if -1953511502 
addAction(new ActionNewStereotype());
//#endif 


//#if -566602009 
addAction(getDeleteAction());
//#endif 

} 

//#endif 


//#if 1595311508 
public PropPanelSignal()
    { 

//#if -203672274 
this("label.signal-title", "SignalSending");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

