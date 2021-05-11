// Compilation Unit of /PropPanelPseudostate.java 
 
package org.argouml.uml.ui.behavior.state_machines;
import javax.swing.Icon;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetManager;
public class PropPanelPseudostate extends PropPanelStateVertex
  { 
private static final long serialVersionUID = 5822284822242536007L;
@Override
    public void targetAdded(TargetEvent e)
    { 
if(Model.getFacade().isAPseudostate(e.getNewTarget()))//1
{ 
refreshTarget();
super.targetAdded(e);
} 

} 

@Override
    public void targetSet(TargetEvent e)
    { 
if(Model.getFacade().isAPseudostate(e.getNewTarget()))//1
{ 
refreshTarget();
super.targetSet(e);
} 

} 

public void refreshTarget()
    { 
Object target = TargetManager.getInstance().getModelTarget();
if(Model.getFacade().isAPseudostate(target))//1
{ 
Object kind = Model.getFacade().getKind(target);
if(Model.getFacade().equalsPseudostateKind(kind,
                    Model.getPseudostateKind().getFork()))//1
{ 
getTitleLabel().setText(
                    Translator.localize("label.pseudostate.fork"));
} 

if(Model.getFacade().equalsPseudostateKind(kind,
                    Model.getPseudostateKind().getJoin()))//1
{ 
getTitleLabel().setText(
                    Translator.localize("label.pseudostate.join"));
} 

if(Model.getFacade().equalsPseudostateKind(kind,
                    Model.getPseudostateKind().getChoice()))//1
{ 
getTitleLabel().setText(
                    Translator.localize("label.pseudostate.choice"));
} 

if(Model.getFacade().equalsPseudostateKind(kind,
                    Model.getPseudostateKind().getDeepHistory()))//1
{ 
getTitleLabel().setText(
                    Translator.localize("label.pseudostate.deephistory"));
} 

if(Model.getFacade().equalsPseudostateKind(kind,
                    Model.getPseudostateKind().getShallowHistory()))//1
{ 
getTitleLabel().setText(
                    Translator.localize("label.pseudostate.shallowhistory"));
} 

if(Model.getFacade().equalsPseudostateKind(kind,
                    Model.getPseudostateKind().getInitial()))//1
{ 
getTitleLabel().setText(
                    Translator.localize("label.pseudostate.initial"));
} 

if(Model.getFacade().equalsPseudostateKind(kind,
                    Model.getPseudostateKind().getJunction()))//1
{ 
getTitleLabel().setText(
                    Translator.localize("label.pseudostate.junction"));
} 

Icon icon =
                ResourceLoaderWrapper.getInstance().lookupIcon(target);
if(icon != null)//1
{ 
getTitleLabel().setIcon(icon);
} 

} 

} 

@Override
    public void targetRemoved(TargetEvent e)
    { 
if(Model.getFacade().isAPseudostate(e.getNewTarget()))//1
{ 
refreshTarget();
super.targetRemoved(e);
} 

} 

public PropPanelPseudostate()
    { 
super("label.pseudostate", lookupIcon("State"));
addField("label.name", getNameTextField());
addField("label.container", getContainerScroll());
addSeparator();
addField("label.incoming", getIncomingScroll());
addField("label.outgoing", getOutgoingScroll());
TargetManager.getInstance().addTargetListener(this);
} 

 } 


