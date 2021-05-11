
//#if -1293033890 
// Compilation Unit of /PopupMenuNewAction.java 
 

//#if 1268689773 
package org.argouml.uml.ui.behavior.common_behavior;
//#endif 


//#if 1483108625 
import javax.swing.Action;
//#endif 


//#if -1654917466 
import javax.swing.JMenu;
//#endif 


//#if 1025164230 
import javax.swing.JPopupMenu;
//#endif 


//#if -688823494 
import org.argouml.i18n.Translator;
//#endif 


//#if -2138809737 
import org.argouml.uml.ui.ActionRemoveModelElement;
//#endif 


//#if 1791836635 
import org.argouml.uml.ui.UMLMutableLinkedList;
//#endif 


//#if 866624275 
public class PopupMenuNewAction extends 
//#if 2056704145 
JPopupMenu
//#endif 

  { 

//#if -742886648 
public static void buildMenu(JPopupMenu pmenu,
                                 String role, Object target)
    { 

//#if 1727260750 
JMenu newMenu = new JMenu();
//#endif 


//#if -984739924 
newMenu.setText(Translator.localize("action.new"));
//#endif 


//#if 1842515092 
newMenu.add(ActionNewCallAction.getInstance());
//#endif 


//#if 2106178798 
ActionNewCallAction.getInstance().setTarget(target);
//#endif 


//#if 98483936 
ActionNewCallAction.getInstance().putValue(ActionNewAction.ROLE, role);
//#endif 


//#if 1177130162 
newMenu.add(ActionNewCreateAction.getInstance());
//#endif 


//#if 1090642448 
ActionNewCreateAction.getInstance().setTarget(target);
//#endif 


//#if -870801534 
ActionNewCreateAction.getInstance()
        .putValue(ActionNewAction.ROLE, role);
//#endif 


//#if 1882531728 
newMenu.add(ActionNewDestroyAction.getInstance());
//#endif 


//#if 1414474078 
ActionNewDestroyAction.getInstance().setTarget(target);
//#endif 


//#if 1898704720 
ActionNewDestroyAction.getInstance()
        .putValue(ActionNewAction.ROLE, role);
//#endif 


//#if -1937223194 
newMenu.add(ActionNewReturnAction.getInstance());
//#endif 


//#if 1677112156 
ActionNewReturnAction.getInstance().setTarget(target);
//#endif 


//#if -1032833586 
ActionNewReturnAction.getInstance()
        .putValue(ActionNewAction.ROLE, role);
//#endif 


//#if 1117734462 
newMenu.add(ActionNewSendAction.getInstance());
//#endif 


//#if 1334201476 
ActionNewSendAction.getInstance().setTarget(target);
//#endif 


//#if 2135610614 
ActionNewSendAction.getInstance().putValue(ActionNewAction.ROLE, role);
//#endif 


//#if 1279206071 
newMenu.add(ActionNewTerminateAction.getInstance());
//#endif 


//#if 1481466775 
ActionNewTerminateAction.getInstance().setTarget(target);
//#endif 


//#if 381644105 
ActionNewTerminateAction.getInstance()
        .putValue(ActionNewAction.ROLE, role);
//#endif 


//#if -1392738039 
newMenu.add(ActionNewUninterpretedAction.getInstance());
//#endif 


//#if -2086594427 
ActionNewUninterpretedAction.getInstance().setTarget(target);
//#endif 


//#if 880083639 
ActionNewUninterpretedAction.getInstance()
        .putValue(ActionNewAction.ROLE, role);
//#endif 


//#if 1818205303 
newMenu.add(ActionNewActionSequence.getInstance());
//#endif 


//#if 1594755691 
ActionNewActionSequence.getInstance().setTarget(target);
//#endif 


//#if -1174698211 
ActionNewActionSequence.getInstance()
        .putValue(ActionNewAction.ROLE, role);
//#endif 


//#if 1694951559 
pmenu.add(newMenu);
//#endif 


//#if 1224586771 
pmenu.addSeparator();
//#endif 


//#if -1302843866 
ActionRemoveModelElement.SINGLETON.setObjectToRemove(ActionNewAction
                .getAction(role, target));
//#endif 


//#if -1947821455 
ActionRemoveModelElement.SINGLETON.putValue(Action.NAME,
                Translator.localize("action.delete-from-model"));
//#endif 


//#if 815379302 
pmenu.add(ActionRemoveModelElement.SINGLETON);
//#endif 

} 

//#endif 


//#if 2115420833 
public PopupMenuNewAction(String role, UMLMutableLinkedList list)
    { 

//#if 1671552898 
super();
//#endif 


//#if 1282528816 
buildMenu(this, role, list.getTarget());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

