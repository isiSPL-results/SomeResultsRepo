
//#if -987524514 
// Compilation Unit of /ActionAddStereotype.java 
 

//#if -655325765 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -2030118730 
import java.awt.event.ActionEvent;
//#endif 


//#if -1740178388 
import javax.swing.Action;
//#endif 


//#if 389817983 
import org.argouml.i18n.Translator;
//#endif 


//#if 407223333 
import org.argouml.kernel.Project;
//#endif 


//#if 2062037796 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if 1496259138 
import org.argouml.kernel.ProjectSettings;
//#endif 


//#if -656358383 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if -1944450875 
import org.argouml.model.Model;
//#endif 


//#if -211083475 
import org.argouml.notation.providers.uml.NotationUtilityUml;
//#endif 


//#if -1397094068 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1519395185 

//#if -1271512856 
@Deprecated
//#endif 


//#if 1956348056 
@UmlModelMutator
//#endif 

class ActionAddStereotype extends 
//#if -1352617665 
UndoableAction
//#endif 

  { 

//#if 604144689 
private Object modelElement;
//#endif 


//#if 1920192178 
private Object stereotype;
//#endif 


//#if 442329715 
public ActionAddStereotype(Object me, Object st)
    { 

//#if 1222069473 
super(Translator.localize(buildString(st)),
              null);
//#endif 


//#if 868918606 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(buildString(st)));
//#endif 


//#if -348546853 
modelElement = me;
//#endif 


//#if 1994547665 
stereotype = st;
//#endif 

} 

//#endif 


//#if -2129421091 
@Override
    public void actionPerformed(ActionEvent ae)
    { 

//#if -373219203 
super.actionPerformed(ae);
//#endif 


//#if -342332236 
if(Model.getFacade().getStereotypes(modelElement)
                .contains(stereotype))//1
{ 

//#if 1669053648 
Model.getCoreHelper().removeStereotype(modelElement, stereotype);
//#endif 

} 
else
{ 

//#if 1513941479 
Model.getCoreHelper().addStereotype(modelElement, stereotype);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2052786743 
private static String buildString(Object st)
    { 

//#if -1630861232 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if -796177438 
ProjectSettings ps = p.getProjectSettings();
//#endif 


//#if -1751009124 
return NotationUtilityUml.generateStereotype(st,
                ps.getNotationSettings().isUseGuillemets());
//#endif 

} 

//#endif 


//#if 68704383 
@Override
    public Object getValue(String key)
    { 

//#if 985000705 
if("SELECTED".equals(key))//1
{ 

//#if 1755871368 
if(Model.getFacade().getStereotypes(modelElement).contains(
                        stereotype))//1
{ 

//#if 878266278 
return Boolean.TRUE;
//#endif 

} 
else
{ 

//#if 1556306715 
return Boolean.FALSE;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -877371613 
return super.getValue(key);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

