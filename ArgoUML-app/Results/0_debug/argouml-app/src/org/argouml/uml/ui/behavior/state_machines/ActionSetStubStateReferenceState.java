
//#if 1136198097 
// Compilation Unit of /ActionSetStubStateReferenceState.java 
 

//#if 1202088835 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if 1667134420 
import org.argouml.i18n.Translator;
//#endif 


//#if -1531295590 
import org.argouml.model.Model;
//#endif 


//#if 1015723293 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if 245039703 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1197673665 
import java.awt.event.ActionEvent;
//#endif 


//#if -1080464585 
import javax.swing.Action;
//#endif 


//#if 1655408939 
public class ActionSetStubStateReferenceState extends 
//#if 1619177372 
UndoableAction
//#endif 

  { 

//#if 1261956761 
private static final ActionSetStubStateReferenceState SINGLETON =
        new ActionSetStubStateReferenceState();
//#endif 


//#if -1762626043 
public void actionPerformed(ActionEvent e)
    { 

//#if -731970891 
super.actionPerformed(e);
//#endif 


//#if 668281444 
if(e.getSource() instanceof UMLComboBox2)//1
{ 

//#if -1628283999 
UMLComboBox2 box = (UMLComboBox2) e.getSource();
//#endif 


//#if 1208548802 
Object o = box.getSelectedItem();
//#endif 


//#if -1856138485 
if(o != null)//1
{ 

//#if -1364920749 
String name = Model.getStateMachinesHelper().getPath(o);
//#endif 


//#if 1819004306 
if(name != null)//1

//#if 1380146659 
Model.getStateMachinesHelper()
                    .setReferenceState(box.getTarget(), name);
//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1403827536 
public static ActionSetStubStateReferenceState getInstance()
    { 

//#if -1761224223 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 642153252 
protected ActionSetStubStateReferenceState()
    { 

//#if 771190378 
super(Translator.localize("action.set"), null);
//#endif 


//#if 198356341 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.set"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

