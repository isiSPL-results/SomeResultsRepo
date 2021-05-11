
//#if -1083076593 
// Compilation Unit of /AbstractPropPanelState.java 
 

//#if 2036741097 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 302672913 
import javax.swing.Action;
//#endif 


//#if -2016880338 
import javax.swing.Icon;
//#endif 


//#if -1522211973 
import javax.swing.ImageIcon;
//#endif 


//#if 1908435015 
import javax.swing.JList;
//#endif 


//#if -277047184 
import javax.swing.JScrollPane;
//#endif 


//#if -31187335 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1184352314 
import org.argouml.i18n.Translator;
//#endif 


//#if -649520903 
import org.argouml.uml.ui.ScrollList;
//#endif 


//#if 1124345563 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if -1789304296 
public abstract class AbstractPropPanelState extends 
//#if -1397120800 
PropPanelStateVertex
//#endif 

  { 

//#if -460022300 
private JScrollPane entryScroll;
//#endif 


//#if -1197523096 
private JScrollPane exitScroll;
//#endif 


//#if 1820761435 
private JScrollPane doScroll;
//#endif 


//#if -1989360971 
private JScrollPane internalTransitionsScroll;
//#endif 


//#if -9418023 
private ScrollList deferrableEventsScroll;
//#endif 


//#if 1037791766 
protected JScrollPane getInternalTransitionsScroll()
    { 

//#if -157083675 
return internalTransitionsScroll;
//#endif 

} 

//#endif 


//#if 586164146 
protected JScrollPane getDoScroll()
    { 

//#if 732579011 
return doScroll;
//#endif 

} 

//#endif 


//#if -1110459279 
@Override
    protected void addExtraButtons()
    { 

//#if -1641994058 
super.addExtraButtons();
//#endif 


//#if -949957586 
Action a = new ActionNewTransition();
//#endif 


//#if -685171489 
a.putValue(Action.SHORT_DESCRIPTION,
                   Translator.localize("button.new-internal-transition"));
//#endif 


//#if -1876610010 
Icon icon = ResourceLoaderWrapper.lookupIcon("Transition");
//#endif 


//#if -18885940 
a.putValue(Action.SMALL_ICON, icon);
//#endif 


//#if -856257561 
addAction(a);
//#endif 

} 

//#endif 


//#if 1775434763 
public AbstractPropPanelState(String name, ImageIcon icon)
    { 

//#if -172299010 
super(name, icon);
//#endif 


//#if -884117374 
deferrableEventsScroll =
            new ScrollList(new UMLStateDeferrableEventListModel());
//#endif 


//#if 724104136 
JList entryList = new UMLStateEntryList(new UMLStateEntryListModel());
//#endif 


//#if 1750808192 
entryList.setVisibleRowCount(2);
//#endif 


//#if 893631608 
entryScroll = new JScrollPane(entryList);
//#endif 


//#if -630711188 
JList exitList = new UMLStateExitList(new UMLStateExitListModel());
//#endif 


//#if 588863730 
exitList.setVisibleRowCount(2);
//#endif 


//#if 1028904966 
exitScroll = new JScrollPane(exitList);
//#endif 


//#if 1985774486 
JList internalTransitionList = new UMLMutableLinkedList(
            new UMLStateInternalTransition(), null,
            new ActionNewTransition());
//#endif 


//#if -215428261 
internalTransitionsScroll = new JScrollPane(internalTransitionList);
//#endif 


//#if -2046593817 
JList doList = new UMLStateDoActivityList(
            new UMLStateDoActivityListModel());
//#endif 


//#if -720696027 
doList.setVisibleRowCount(2);
//#endif 


//#if 275545760 
doScroll = new JScrollPane(doList);
//#endif 

} 

//#endif 


//#if 1033115397 
protected JScrollPane getExitScroll()
    { 

//#if 1646586526 
return exitScroll;
//#endif 

} 

//#endif 


//#if 354493191 
protected JScrollPane getEntryScroll()
    { 

//#if 1490574901 
return entryScroll;
//#endif 

} 

//#endif 


//#if 747666874 
protected JScrollPane getDeferrableEventsScroll()
    { 

//#if 885353771 
return deferrableEventsScroll;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

