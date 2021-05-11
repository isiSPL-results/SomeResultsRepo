
//#if 2013352027 
// Compilation Unit of /ActionSetFlowSource.java 
 

//#if 227368931 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -847223171 
import java.awt.event.ActionEvent;
//#endif 


//#if 2063246446 
import java.util.ArrayList;
//#endif 


//#if 875728563 
import java.util.Collection;
//#endif 


//#if -216383245 
import javax.swing.Action;
//#endif 


//#if -1595125352 
import org.argouml.i18n.Translator;
//#endif 


//#if 1514514526 
import org.argouml.model.Model;
//#endif 


//#if 548147425 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if -728702957 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -449446485 
public class ActionSetFlowSource extends 
//#if -1567132133 
UndoableAction
//#endif 

  { 

//#if -77868374 
private static final ActionSetFlowSource SINGLETON =
        new ActionSetFlowSource();
//#endif 


//#if 343321702 
public void actionPerformed(ActionEvent e)
    { 

//#if -1997535545 
super.actionPerformed(e);
//#endif 


//#if 556698770 
if(e.getSource() instanceof UMLComboBox2)//1
{ 

//#if 722388756 
UMLComboBox2 source = (UMLComboBox2) e.getSource();
//#endif 


//#if 4853016 
Object target = source.getTarget();
//#endif 


//#if 792115087 
if(Model.getFacade().isAFlow(target))//1
{ 

//#if -1364227189 
Object flow = target;
//#endif 


//#if -227496466 
Object old = null;
//#endif 


//#if 110088348 
if(!Model.getFacade().getSources(flow).isEmpty())//1
{ 

//#if 958124124 
old = Model.getFacade().getSources(flow).toArray()[0];
//#endif 

} 

//#endif 


//#if -869739421 
if(old != source.getSelectedItem())//1
{ 

//#if -828742933 
if(source.getSelectedItem() != null)//1
{ 

//#if -1719144350 
Collection sources = new ArrayList();
//#endif 


//#if -86884449 
sources.add(source.getSelectedItem());
//#endif 


//#if -1969871599 
Model.getCoreHelper().setSources(flow, sources);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1076636149 
public static ActionSetFlowSource getInstance()
    { 

//#if -1187648947 
return SINGLETON;
//#endif 

} 

//#endif 


//#if 1285519087 
protected ActionSetFlowSource()
    { 

//#if -1462395581 
super(Translator.localize("Set"), null);
//#endif 


//#if -1639226836 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

