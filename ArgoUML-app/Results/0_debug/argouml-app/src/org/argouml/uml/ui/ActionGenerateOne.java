
//#if -1329126300 
// Compilation Unit of /ActionGenerateOne.java 
 

//#if 833036446 
package org.argouml.uml.ui;
//#endif 


//#if 1428439918 
import java.awt.event.ActionEvent;
//#endif 


//#if -1667103587 
import java.util.ArrayList;
//#endif 


//#if 1198994532 
import java.util.Collection;
//#endif 


//#if -315096156 
import java.util.List;
//#endif 


//#if 771661540 
import javax.swing.Action;
//#endif 


//#if 230953671 
import org.argouml.i18n.Translator;
//#endif 


//#if -1680647923 
import org.argouml.model.Model;
//#endif 


//#if 790000437 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1981793198 
import org.argouml.uml.generator.ui.ClassGenerationDialog;
//#endif 


//#if 598881796 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1829059588 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -905695776 
public class ActionGenerateOne extends 
//#if 1113689513 
UndoableAction
//#endif 

  { 

//#if 994668432 
@Override
    public boolean isEnabled()
    { 

//#if 371856290 
return true;
//#endif 

} 

//#endif 


//#if -2068670413 
@Override
    public void actionPerformed(ActionEvent ae)
    { 

//#if -1675988898 
super.actionPerformed(ae);
//#endif 


//#if 870275424 
List classes = getCandidates();
//#endif 


//#if -332201178 
ClassGenerationDialog cgd = new ClassGenerationDialog(classes);
//#endif 


//#if -1069816269 
cgd.setVisible(true);
//#endif 

} 

//#endif 


//#if 430157275 
private List getCandidates()
    { 

//#if 1363341461 
List classes = new ArrayList();
//#endif 


//#if -148941752 
Collection targets = TargetManager.getInstance().getTargets();
//#endif 


//#if -201116296 
for (Object target : targets) //1
{ 

//#if -123727995 
if(target instanceof Fig)//1
{ 

//#if 1968895828 
target = ((Fig) target).getOwner();
//#endif 

} 

//#endif 


//#if -211417159 
if(Model.getFacade().isAClass(target)
                    || Model.getFacade().isAInterface(target))//1
{ 

//#if -653048843 
classes.add(target);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1842806530 
return classes;
//#endif 

} 

//#endif 


//#if -653664994 
public ActionGenerateOne()
    { 

//#if -1719192368 
super(Translator.localize("action.generate-selected-classes"), null);
//#endif 


//#if -899036849 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.generate-selected-classes"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

