
//#if 2009253523 
// Compilation Unit of /ActionNewPseudoState.java 
 

//#if 1397853295 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -419969451 
import java.awt.event.ActionEvent;
//#endif 


//#if 1736112331 
import javax.swing.Action;
//#endif 


//#if -1235161920 
import org.argouml.i18n.Translator;
//#endif 


//#if 1498814342 
import org.argouml.model.Model;
//#endif 


//#if -957528036 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -337526127 
import org.argouml.uml.ui.AbstractActionNewModelElement;
//#endif 


//#if -1204468533 
public class ActionNewPseudoState extends 
//#if -1575610614 
AbstractActionNewModelElement
//#endif 

  { 

//#if 1647249206 
private Object kind;
//#endif 


//#if 1430513841 
public ActionNewPseudoState(Object k, String n)
    { 

//#if 1533649297 
super();
//#endif 


//#if -1022855097 
kind = k;
//#endif 


//#if 660869845 
putValue(Action.NAME, Translator.localize(n));
//#endif 

} 

//#endif 


//#if -1270411196 
public ActionNewPseudoState()
    { 

//#if -1996913996 
super();
//#endif 


//#if -1852761792 
putValue(Action.NAME, Translator.localize("button.new-pseudostate"));
//#endif 

} 

//#endif 


//#if -1895836772 
public void actionPerformed(ActionEvent e)
    { 

//#if 1636640114 
super.actionPerformed(e);
//#endif 


//#if 663202729 
Object target = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -1444122736 
Object ps =
            Model.getStateMachinesFactory().buildPseudoState(target);
//#endif 


//#if -1201205802 
if(kind != null)//1
{ 

//#if -923383301 
Model.getCoreHelper().setKind(ps, kind);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

