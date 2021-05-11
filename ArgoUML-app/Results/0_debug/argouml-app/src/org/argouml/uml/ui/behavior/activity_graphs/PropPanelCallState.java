
//#if -1443358837 
// Compilation Unit of /PropPanelCallState.java 
 

//#if -766773008 
package org.argouml.uml.ui.behavior.activity_graphs;
//#endif 


//#if 555570467 
import javax.swing.Action;
//#endif 


//#if 1044831936 
import javax.swing.Icon;
//#endif 


//#if -823817943 
import javax.swing.ImageIcon;
//#endif 


//#if -1962732299 
import javax.swing.JList;
//#endif 


//#if 864717470 
import javax.swing.JScrollPane;
//#endif 


//#if 1016237095 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 283439976 
import org.argouml.i18n.Translator;
//#endif 


//#if -778216504 
import org.argouml.uml.ui.behavior.state_machines.AbstractPropPanelState;
//#endif 


//#if 347949924 
import org.argouml.uml.ui.behavior.state_machines.UMLStateEntryListModel;
//#endif 


//#if 1806990220 
public class PropPanelCallState extends 
//#if 2006834527 
AbstractPropPanelState
//#endif 

  { 

//#if 1711727225 
private JScrollPane callActionEntryScroll;
//#endif 


//#if 443925201 
private JList callActionEntryList;
//#endif 


//#if 1439608670 
private static final long serialVersionUID = -8830997687737785261L;
//#endif 


//#if 281403892 
protected JScrollPane getCallActionEntryScroll()
    { 

//#if -480944451 
return callActionEntryScroll;
//#endif 

} 

//#endif 


//#if -1175037044 
public PropPanelCallState(String name, ImageIcon icon)
    { 

//#if 1685568758 
super(name, icon);
//#endif 


//#if 927902204 
callActionEntryList =
            new UMLCallStateEntryList(
            new UMLStateEntryListModel());
//#endif 


//#if 778605212 
callActionEntryList.setVisibleRowCount(2);
//#endif 


//#if 1452037696 
callActionEntryScroll = new JScrollPane(callActionEntryList);
//#endif 


//#if 922915694 
addField(Translator.localize("label.name"),
                 getNameTextField());
//#endif 


//#if -647759334 
addField(Translator.localize("label.container"),
                 getContainerScroll());
//#endif 


//#if -158481242 
addField(Translator.localize("label.entry"),
                 getCallActionEntryScroll());
//#endif 


//#if 26579433 
addField(Translator.localize("label.deferrable"),
                 getDeferrableEventsScroll());
//#endif 


//#if 1208444109 
addSeparator();
//#endif 


//#if -1650058168 
addField(Translator.localize("label.incoming"),
                 getIncomingScroll());
//#endif 


//#if -1017134764 
addField(Translator.localize("label.outgoing"),
                 getOutgoingScroll());
//#endif 

} 

//#endif 


//#if -86449698 
protected void addExtraButtons()
    { 

//#if 768554414 
Action a = new ActionNewEntryCallAction();
//#endif 


//#if -879757841 
a.putValue(Action.SHORT_DESCRIPTION,
                   Translator.localize("button.new-callaction"));
//#endif 


//#if 1332068650 
Icon icon = ResourceLoaderWrapper.lookupIcon("CallAction");
//#endif 


//#if -934991703 
a.putValue(Action.SMALL_ICON, icon);
//#endif 


//#if -499538556 
addAction(a);
//#endif 

} 

//#endif 


//#if 127527753 
public PropPanelCallState()
    { 

//#if -432886389 
this("label.call-state", lookupIcon("CallState"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

