
//#if -360148478 
// Compilation Unit of /ActionSetStructuralFeatureTargetScope.java 
 

//#if 986158398 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if -1239241022 
import java.awt.event.ActionEvent;
//#endif 


//#if 905420344 
import javax.swing.Action;
//#endif 


//#if -862776845 
import org.argouml.i18n.Translator;
//#endif 


//#if -2114400711 
import org.argouml.model.Model;
//#endif 


//#if -2128636798 
import org.argouml.uml.ui.UMLCheckBox2;
//#endif 


//#if 819794776 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 534479239 

//#if 1551083003 
@Deprecated
//#endif 

public class ActionSetStructuralFeatureTargetScope extends 
//#if -269103284 
UndoableAction
//#endif 

  { 

//#if -277368743 
private static final ActionSetStructuralFeatureTargetScope SINGLETON =
        new ActionSetStructuralFeatureTargetScope();
//#endif 


//#if -2090337375 
protected ActionSetStructuralFeatureTargetScope()
    { 

//#if 1319331358 
super(Translator.localize("Set"), null);
//#endif 


//#if -1898851599 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("Set"));
//#endif 

} 

//#endif 


//#if 541903621 
public static ActionSetStructuralFeatureTargetScope getInstance()
    { 

//#if -1772299810 
return SINGLETON;
//#endif 

} 

//#endif 


//#if -2026154023 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if 632003627 
super.actionPerformed(e);
//#endif 


//#if -1448966872 
if(e.getSource() instanceof UMLCheckBox2)//1
{ 

//#if -1284874729 
UMLCheckBox2 source = (UMLCheckBox2) e.getSource();
//#endif 


//#if -413735807 
Object target = source.getTarget();
//#endif 


//#if 12256127 
if(Model.getFacade().isAStructuralFeature(target))//1
{ 

//#if -557051946 
Object m = target;
//#endif 


//#if 683235112 
Model.getCoreHelper().setTargetScope(
                    m,
                    source.isSelected()
                    ? Model.getScopeKind().getClassifier()
                    : Model.getScopeKind().getInstance());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

