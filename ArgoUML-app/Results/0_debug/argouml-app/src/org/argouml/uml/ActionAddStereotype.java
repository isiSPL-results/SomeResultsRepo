
//#if -1471843679 
// Compilation Unit of /ActionAddStereotype.java 
 

//#if 1827328351 
package org.argouml.uml;
//#endif 


//#if -1137174889 
import java.awt.event.ActionEvent;
//#endif 


//#if 719891213 
import javax.swing.Action;
//#endif 


//#if -1993694018 
import org.argouml.i18n.Translator;
//#endif 


//#if 1300167174 
import org.argouml.kernel.Project;
//#endif 


//#if -1742158301 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -469702877 
import org.argouml.kernel.ProjectSettings;
//#endif 


//#if 1672646898 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if -515408252 
import org.argouml.model.Model;
//#endif 


//#if -1190445908 
import org.argouml.notation.providers.uml.NotationUtilityUml;
//#endif 


//#if 931911213 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1649327513 

//#if -1723986794 
@UmlModelMutator
//#endif 

public class ActionAddStereotype extends 
//#if -627956547 
UndoableAction
//#endif 

  { 

//#if 1310501551 
private Object modelElement;
//#endif 


//#if 423722160 
private Object stereotype;
//#endif 


//#if -575469409 
@Override
    public void actionPerformed(ActionEvent ae)
    { 

//#if 1237163500 
super.actionPerformed(ae);
//#endif 


//#if -529485789 
if(Model.getFacade().getStereotypes(modelElement)
                .contains(stereotype))//1
{ 

//#if 891560733 
Model.getCoreHelper().removeStereotype(modelElement, stereotype);
//#endif 

} 
else
{ 

//#if -1093542534 
Model.getCoreHelper().addStereotype(modelElement, stereotype);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 911617393 
public ActionAddStereotype(Object me, Object st)
    { 

//#if 936043897 
super(Translator.localize(buildString(st)),
              null);
//#endif 


//#if -1321672266 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(buildString(st)));
//#endif 


//#if -917492413 
modelElement = me;
//#endif 


//#if 1390604345 
stereotype = st;
//#endif 

} 

//#endif 


//#if -972888121 
private static String buildString(Object st)
    { 

//#if -421027155 
Project p = ProjectManager.getManager().getCurrentProject();
//#endif 


//#if 1062879295 
ProjectSettings ps = p.getProjectSettings();
//#endif 


//#if -1730839623 
return NotationUtilityUml.generateStereotype(st,
                ps.getNotationSettings().isUseGuillemets());
//#endif 

} 

//#endif 


//#if 1148603005 
@Override
    public Object getValue(String key)
    { 

//#if -1377026178 
if("SELECTED".equals(key))//1
{ 

//#if -107091430 
if(Model.getFacade().getStereotypes(modelElement).contains(
                        stereotype))//1
{ 

//#if -455337183 
return Boolean.TRUE;
//#endif 

} 
else
{ 

//#if -1760221088 
return Boolean.FALSE;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1366187066 
return super.getValue(key);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

