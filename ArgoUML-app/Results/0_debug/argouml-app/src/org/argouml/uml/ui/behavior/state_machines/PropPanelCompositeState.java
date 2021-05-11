
//#if 807734503 
// Compilation Unit of /PropPanelCompositeState.java 
 

//#if -756324959 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 1201896281 
import javax.swing.Action;
//#endif 


//#if -469881037 
import javax.swing.ImageIcon;
//#endif 


//#if 413421567 
import javax.swing.JList;
//#endif 


//#if 1695667752 
import javax.swing.JScrollPane;
//#endif 


//#if 1332177394 
import org.argouml.i18n.Translator;
//#endif 


//#if 444530104 
import org.argouml.model.Model;
//#endif 


//#if -1996848982 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 813696937 
import org.argouml.uml.diagram.ui.ActionAddConcurrentRegion;
//#endif 


//#if -1538438725 
public class PropPanelCompositeState extends 
//#if -1221727351 
AbstractPropPanelState
//#endif 

  { 

//#if 296134706 
private static final long serialVersionUID = 4758716706184949796L;
//#endif 


//#if 1856310546 
private JList subverticesList = null;
//#endif 


//#if 900860977 
private Action addConcurrentRegion;
//#endif 


//#if -1087397085 
@Override
    public void setTarget(final Object t)
    { 

//#if -93446197 
super.setTarget(t);
//#endif 


//#if 1842217869 
updateExtraButtons();
//#endif 


//#if -1535083752 
final Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1174841152 
if(Model.getFacade().isAConcurrentRegion(target))//1
{ 

//#if -860641465 
getTitleLabel().setText(
                Translator.localize("label.concurrent.region"));
//#endif 

} 
else

//#if 1886843984 
if(Model.getFacade().isConcurrent(target))//1
{ 

//#if -1351060390 
getTitleLabel().setText(
                Translator.localize("label.concurrent.composite.state"));
//#endif 

} 
else

//#if -352734490 
if(!Model.getFacade().isASubmachineState(target))//1
{ 

//#if -1566666754 
getTitleLabel().setText(
                Translator.localize("label.composite-state"));
//#endif 

} 

//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if 2098342092 
public PropPanelCompositeState()
    { 

//#if -1689149067 
super("label.composite-state", lookupIcon("CompositeState"));
//#endif 


//#if -1347956117 
initialize();
//#endif 


//#if -1237234912 
addField("label.name", getNameTextField());
//#endif 


//#if -14204566 
addField("label.container", getContainerScroll());
//#endif 


//#if -831806452 
addField("label.entry", getEntryScroll());
//#endif 


//#if 215548864 
addField("label.exit", getExitScroll());
//#endif 


//#if -1607122190 
addField("label.do-activity", getDoScroll());
//#endif 


//#if 1423785463 
addSeparator();
//#endif 


//#if 1009108416 
addField("label.incoming", getIncomingScroll());
//#endif 


//#if 677091200 
addField("label.outgoing", getOutgoingScroll());
//#endif 


//#if 1268062063 
addField("label.internal-transitions",
                 getInternalTransitionsScroll());
//#endif 


//#if -1104240389 
addSeparator();
//#endif 


//#if -585378741 
addField("label.subvertex",
                 new JScrollPane(subverticesList));
//#endif 

} 

//#endif 


//#if -1493449381 
public PropPanelCompositeState(final String name, final ImageIcon icon)
    { 

//#if -2055168611 
super(name, icon);
//#endif 


//#if -1406991640 
initialize();
//#endif 

} 

//#endif 


//#if 4234876 
protected void initialize()
    { 

//#if 356389857 
subverticesList =
            new UMLCompositeStateSubvertexList(
            new UMLCompositeStateSubvertexListModel());
//#endif 

} 

//#endif 


//#if -1287204570 
@Override
    protected void addExtraButtons()
    { 

//#if 1223241352 
super.addExtraButtons();
//#endif 


//#if -389402682 
addConcurrentRegion = new ActionAddConcurrentRegion();
//#endif 


//#if -1671702528 
addAction(addConcurrentRegion);
//#endif 

} 

//#endif 


//#if -1712402906 
protected void updateExtraButtons()
    { 

//#if -183300822 
addConcurrentRegion.setEnabled(addConcurrentRegion.isEnabled());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

