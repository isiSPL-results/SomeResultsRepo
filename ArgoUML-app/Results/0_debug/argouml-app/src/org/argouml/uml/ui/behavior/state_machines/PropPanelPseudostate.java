
//#if -674960150 
// Compilation Unit of /PropPanelPseudostate.java 
 

//#if 630497857 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 228999638 
import javax.swing.Icon;
//#endif 


//#if 1010728657 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1671567726 
import org.argouml.i18n.Translator;
//#endif 


//#if -496186792 
import org.argouml.model.Model;
//#endif 


//#if 118944189 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -1813565430 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1464050466 
public class PropPanelPseudostate extends 
//#if 601402430 
PropPanelStateVertex
//#endif 

  { 

//#if -41123765 
private static final long serialVersionUID = 5822284822242536007L;
//#endif 


//#if -1186997963 
@Override
    public void targetAdded(TargetEvent e)
    { 

//#if -260624929 
if(Model.getFacade().isAPseudostate(e.getNewTarget()))//1
{ 

//#if -149841559 
refreshTarget();
//#endif 


//#if 420366384 
super.targetAdded(e);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1453697769 
@Override
    public void targetSet(TargetEvent e)
    { 

//#if 589320676 
if(Model.getFacade().isAPseudostate(e.getNewTarget()))//1
{ 

//#if 620046637 
refreshTarget();
//#endif 


//#if -1000286066 
super.targetSet(e);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -619267642 
public void refreshTarget()
    { 

//#if 801969016 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -979212642 
if(Model.getFacade().isAPseudostate(target))//1
{ 

//#if -330751989 
Object kind = Model.getFacade().getKind(target);
//#endif 


//#if -1352123838 
if(Model.getFacade().equalsPseudostateKind(kind,
                    Model.getPseudostateKind().getFork()))//1
{ 

//#if -1345331834 
getTitleLabel().setText(
                    Translator.localize("label.pseudostate.fork"));
//#endif 

} 

//#endif 


//#if 70690010 
if(Model.getFacade().equalsPseudostateKind(kind,
                    Model.getPseudostateKind().getJoin()))//1
{ 

//#if -979246955 
getTitleLabel().setText(
                    Translator.localize("label.pseudostate.join"));
//#endif 

} 

//#endif 


//#if 485208963 
if(Model.getFacade().equalsPseudostateKind(kind,
                    Model.getPseudostateKind().getChoice()))//1
{ 

//#if 905902241 
getTitleLabel().setText(
                    Translator.localize("label.pseudostate.choice"));
//#endif 

} 

//#endif 


//#if 1839102676 
if(Model.getFacade().equalsPseudostateKind(kind,
                    Model.getPseudostateKind().getDeepHistory()))//1
{ 

//#if -1728473103 
getTitleLabel().setText(
                    Translator.localize("label.pseudostate.deephistory"));
//#endif 

} 

//#endif 


//#if -1511183260 
if(Model.getFacade().equalsPseudostateKind(kind,
                    Model.getPseudostateKind().getShallowHistory()))//1
{ 

//#if -1861203011 
getTitleLabel().setText(
                    Translator.localize("label.pseudostate.shallowhistory"));
//#endif 

} 

//#endif 


//#if 1711754264 
if(Model.getFacade().equalsPseudostateKind(kind,
                    Model.getPseudostateKind().getInitial()))//1
{ 

//#if -1203357674 
getTitleLabel().setText(
                    Translator.localize("label.pseudostate.initial"));
//#endif 

} 

//#endif 


//#if -14213776 
if(Model.getFacade().equalsPseudostateKind(kind,
                    Model.getPseudostateKind().getJunction()))//1
{ 

//#if 1782480218 
getTitleLabel().setText(
                    Translator.localize("label.pseudostate.junction"));
//#endif 

} 

//#endif 


//#if 1139254993 
Icon icon =
                ResourceLoaderWrapper.getInstance().lookupIcon(target);
//#endif 


//#if 702838381 
if(icon != null)//1
{ 

//#if 1135389492 
getTitleLabel().setIcon(icon);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -43289451 
@Override
    public void targetRemoved(TargetEvent e)
    { 

//#if -1588997751 
if(Model.getFacade().isAPseudostate(e.getNewTarget()))//1
{ 

//#if 2098685335 
refreshTarget();
//#endif 


//#if 1480546 
super.targetRemoved(e);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -510177178 
public PropPanelPseudostate()
    { 

//#if -469544318 
super("label.pseudostate", lookupIcon("State"));
//#endif 


//#if -124091474 
addField("label.name", getNameTextField());
//#endif 


//#if -144315108 
addField("label.container", getContainerScroll());
//#endif 


//#if -90933719 
addSeparator();
//#endif 


//#if 186627570 
addField("label.incoming", getIncomingScroll());
//#endif 


//#if -145389646 
addField("label.outgoing", getOutgoingScroll());
//#endif 


//#if -1994503309 
TargetManager.getInstance().addTargetListener(this);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

