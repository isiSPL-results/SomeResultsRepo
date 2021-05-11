
//#if -1235635256 
// Compilation Unit of /PropPanelActionState.java 
 

//#if 296946202 
package org.argouml.uml.ui.behavior.activity_graphs;
//#endif 


//#if 2126249791 
import javax.swing.ImageIcon;
//#endif 


//#if -1286340354 
import org.argouml.i18n.Translator;
//#endif 


//#if -68450082 
import org.argouml.uml.ui.behavior.state_machines.AbstractPropPanelState;
//#endif 


//#if -1508827490 
public class PropPanelActionState extends 
//#if 566469913 
AbstractPropPanelState
//#endif 

  { 

//#if -64447622 
private static final long serialVersionUID = 4936258091606712050L;
//#endif 


//#if 1572989358 
public PropPanelActionState(String name, ImageIcon icon)
    { 

//#if 383231610 
super(name, icon);
//#endif 


//#if 1525577202 
addField(Translator.localize("label.name"), getNameTextField());
//#endif 


//#if -523175146 
addField(Translator.localize("label.container"), getContainerScroll());
//#endif 


//#if 829583478 
addField(Translator.localize("label.entry"), getEntryScroll());
//#endif 


//#if 1063245541 
addField(Translator.localize("label.deferrable"),
                 getDeferrableEventsScroll());
//#endif 


//#if 228319057 
addSeparator();
//#endif 


//#if -1122554812 
addField(Translator.localize("label.incoming"), getIncomingScroll());
//#endif 


//#if -489631408 
addField(Translator.localize("label.outgoing"), getOutgoingScroll());
//#endif 

} 

//#endif 


//#if -1967702165 
public PropPanelActionState()
    { 

//#if -1784150788 
this("label.action-state", lookupIcon("ActionState"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

