
//#if -1461900172 
// Compilation Unit of /UMLCompositeStateSubvertexList.java 
 

//#if -804672640 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 30335485 
import javax.swing.JMenu;
//#endif 


//#if 1731745487 
import javax.swing.JPopupMenu;
//#endif 


//#if 1588809169 
import org.argouml.i18n.Translator;
//#endif 


//#if -1713526505 
import org.argouml.model.Model;
//#endif 


//#if 1063532302 
import org.argouml.uml.ui.ActionRemoveModelElement;
//#endif 


//#if -1180190867 
import org.argouml.uml.ui.UMLModelElementListModel2;
//#endif 


//#if -867630606 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -243508331 
public class UMLCompositeStateSubvertexList extends 
//#if -1468898463 
UMLMutableLinkedList
//#endif 

  { 

//#if -244370731 
public UMLCompositeStateSubvertexList(
        UMLModelElementListModel2 dataModel)
    { 

//#if -570593337 
super(dataModel);
//#endif 

} 

//#endif 


//#if 826562424 
public JPopupMenu getPopupMenu()
    { 

//#if 535711768 
return new PopupMenu();
//#endif 

} 

//#endif 


//#if -1219207874 
private class PopupMenu extends 
//#if -1100846477 
JPopupMenu
//#endif 

  { 

//#if -1617445743 
public PopupMenu()
        { 

//#if 1635319001 
super();
//#endif 


//#if -1656163756 
JMenu pMenu = new JMenu();
//#endif 


//#if -148258040 
pMenu.setText(Translator.localize("button.new-pseudostate"));
//#endif 


//#if -925752667 
pMenu.add(new ActionNewPseudoState(
                          Model.getPseudostateKind().getChoice(),
                          "label.pseudostate.choice"));
//#endif 


//#if -754080245 
pMenu.add(new ActionNewPseudoState(
                          Model.getPseudostateKind().getInitial(),
                          "label.pseudostate.initial"));
//#endif 


//#if -232980309 
pMenu.add(new ActionNewPseudoState(
                          Model.getPseudostateKind().getDeepHistory(),
                          "label.pseudostate.deephistory"));
//#endif 


//#if 572279179 
pMenu.add(new ActionNewPseudoState(
                          Model.getPseudostateKind().getJunction(),
                          "label.pseudostate.junction"));
//#endif 


//#if -617923645 
pMenu.add(new ActionNewPseudoState(
                          Model.getPseudostateKind().getShallowHistory(),
                          "label.pseudostate.shallowhistory"));
//#endif 


//#if -414050585 
pMenu.add(new ActionNewPseudoState(
                          Model.getPseudostateKind().getFork(),
                          "label.pseudostate.fork"));
//#endif 


//#if -517169737 
pMenu.add(new ActionNewPseudoState(
                          Model.getPseudostateKind().getJoin(),
                          "label.pseudostate.join"));
//#endif 


//#if -971828412 
JMenu newMenu = new JMenu();
//#endif 


//#if -1629373706 
newMenu.setText(Translator.localize("action.new"));
//#endif 


//#if -235761039 
newMenu.add(pMenu);
//#endif 


//#if 226637326 
newMenu.add(ActionNewSynchState.getInstance());
//#endif 


//#if 1864694889 
ActionNewSynchState.getInstance().setTarget(getTarget());
//#endif 


//#if -1724560967 
newMenu.add(ActionNewStubState.getInstance());
//#endif 


//#if 2111633512 
ActionNewStubState.getInstance().setTarget(getTarget());
//#endif 


//#if -1123337710 
newMenu.add(ActionNewCompositeState.getSingleton());
//#endif 


//#if -1737942911 
ActionNewCompositeState.getSingleton().setTarget(getTarget());
//#endif 


//#if 725808241 
newMenu.add(ActionNewSimpleState.getSingleton());
//#endif 


//#if -417300212 
ActionNewSimpleState.getSingleton().setTarget(getTarget());
//#endif 


//#if -142401855 
newMenu.add(ActionNewFinalState.getSingleton());
//#endif 


//#if 1375765744 
ActionNewFinalState.getSingleton().setTarget(getTarget());
//#endif 


//#if 1089552768 
newMenu.add(ActionNewSubmachineState.getInstance());
//#endif 


//#if -934299281 
ActionNewSubmachineState.getInstance().setTarget(getTarget());
//#endif 


//#if 2064358960 
add(newMenu);
//#endif 


//#if -257186436 
addSeparator();
//#endif 


//#if 674894258 
ActionRemoveModelElement.SINGLETON.setTarget(getSelectedValue());
//#endif 


//#if 1121048101 
ActionRemoveModelElement.SINGLETON.setObjectToRemove(
                getSelectedValue());
//#endif 


//#if 1011465245 
add(ActionRemoveModelElement.SINGLETON);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

