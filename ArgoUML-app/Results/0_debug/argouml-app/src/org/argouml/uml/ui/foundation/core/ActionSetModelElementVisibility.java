
//#if -1874271162 
// Compilation Unit of /ActionSetModelElementVisibility.java 
 

//#if -1667251920 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -841618800 
import java.awt.event.ActionEvent;
//#endif 


//#if -275609594 
import javax.swing.Action;
//#endif 


//#if 1126888153 
import javax.swing.JRadioButton;
//#endif 


//#if -1421389851 
import org.argouml.i18n.Translator;
//#endif 


//#if -1320299221 
import org.argouml.model.Model;
//#endif 


//#if -2107980068 
import org.argouml.uml.ui.UMLRadioButtonPanel;
//#endif 


//#if -97083098 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -2138980332 
public class ActionSetModelElementVisibility extends 
//#if -1262795322 
UndoableAction
//#endif 

  { 

//#if -709042467 
private static final ActionSetModelElementVisibility SINGLETON =
        new ActionSetModelElementVisibility();
//#endif 


//#if 1504855930 
public static final String PUBLIC_COMMAND = "public";
//#endif 


//#if 192254854 
public static final String PROTECTED_COMMAND = "protected";
//#endif 


//#if -1823250586 
public static final String PRIVATE_COMMAND = "private";
//#endif 


//#if -636858938 
public static final String PACKAGE_COMMAND = "package";
//#endif 


//#if -1130461770 
protected ActionSetModelElementVisibility()
    { 

//#if 830562777 
super(Translator.localize("Set"), null);
//#endif 


//#if 1603065046 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if -1777056997 
public void actionPerformed(ActionEvent e)
    { 

//#if -315736408 
super.actionPerformed(e);
//#endif 


//#if -1525765613 
if(e.getSource() instanceof JRadioButton)//1
{ 

//#if -242523001 
JRadioButton source = (JRadioButton) e.getSource();
//#endif 


//#if 1463406537 
String actionCommand = source.getActionCommand();
//#endif 


//#if -444081495 
Object target =
                ((UMLRadioButtonPanel) source.getParent()).getTarget();
//#endif 


//#if 2009442430 
if(Model.getFacade().isAModelElement(target)
                    || Model.getFacade().isAElementResidence(target)
                    || Model.getFacade().isAElementImport(target))//1
{ 

//#if -1661866572 
Object kind = null;
//#endif 


//#if 874537933 
if(actionCommand.equals(PUBLIC_COMMAND))//1
{ 

//#if -1965051070 
kind = Model.getVisibilityKind().getPublic();
//#endif 

} 
else

//#if 341013233 
if(actionCommand.equals(PROTECTED_COMMAND))//1
{ 

//#if 1830026921 
kind = Model.getVisibilityKind().getProtected();
//#endif 

} 
else

//#if -1728858604 
if(actionCommand.equals(PACKAGE_COMMAND))//1
{ 

//#if 1146893748 
kind = Model.getVisibilityKind().getPackage();
//#endif 

} 
else
{ 

//#if 1254440634 
kind = Model.getVisibilityKind().getPrivate();
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#if -723415180 
Model.getCoreHelper().setVisibility(target, kind);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 499249732 
public static ActionSetModelElementVisibility getInstance()
    { 

//#if -639407517 
return SINGLETON;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

