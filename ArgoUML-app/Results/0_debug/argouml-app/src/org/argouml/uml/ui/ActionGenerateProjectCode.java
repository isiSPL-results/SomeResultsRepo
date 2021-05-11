
//#if 51492623 
// Compilation Unit of /ActionGenerateProjectCode.java 
 

//#if -96412912 
package org.argouml.uml.ui;
//#endif 


//#if 994788540 
import java.awt.event.ActionEvent;
//#endif 


//#if 1698414351 
import java.util.ArrayList;
//#endif 


//#if -1844131790 
import java.util.Collection;
//#endif 


//#if -1823733262 
import java.util.List;
//#endif 


//#if 48942642 
import javax.swing.Action;
//#endif 


//#if -327337159 
import org.argouml.i18n.Translator;
//#endif 


//#if -1287222657 
import org.argouml.model.Model;
//#endif 


//#if 933356990 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -458012672 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if -650616124 
import org.argouml.uml.generator.GeneratorManager;
//#endif 


//#if -1576291424 
import org.argouml.uml.generator.ui.ClassGenerationDialog;
//#endif 


//#if -1384837294 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 548696594 
public class ActionGenerateProjectCode extends 
//#if 1071768522 
UndoableAction
//#endif 

  { 

//#if -1233437539 
public ActionGenerateProjectCode()
    { 

//#if -413751869 
super(Translator.localize("action.generate-code-for-project"),
              null);
//#endif 


//#if -2019118468 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.generate-code-for-project"));
//#endif 

} 

//#endif 


//#if 726424886 
private boolean isCodeRelevantClassifier(Object cls)
    { 

//#if 1490916828 
if(cls == null)//1
{ 

//#if -898093464 
return false;
//#endif 

} 

//#endif 


//#if -1674478198 
if(!Model.getFacade().isAClass(cls)
                && !Model.getFacade().isAInterface(cls))//1
{ 

//#if -1378959971 
return false;
//#endif 

} 

//#endif 


//#if -1695242815 
String path = GeneratorManager.getCodePath(cls);
//#endif 


//#if -983346848 
String name = Model.getFacade().getName(cls);
//#endif 


//#if 1029374877 
if(name == null
                || name.length() == 0
                || Character.isDigit(name.charAt(0)))//1
{ 

//#if -261028886 
return false;
//#endif 

} 

//#endif 


//#if -183603187 
if(path != null)//1
{ 

//#if 639851331 
return (path.length() > 0);
//#endif 

} 

//#endif 


//#if -589977311 
Object parent = Model.getFacade().getNamespace(cls);
//#endif 


//#if 827933018 
while (parent != null) //1
{ 

//#if 1451144300 
path = GeneratorManager.getCodePath(parent);
//#endif 


//#if 1854175175 
if(path != null)//1
{ 

//#if 1169183917 
return (path.length() > 0);
//#endif 

} 

//#endif 


//#if 145555422 
parent = Model.getFacade().getNamespace(parent);
//#endif 

} 

//#endif 


//#if -1139934602 
return false;
//#endif 

} 

//#endif 


//#if -800536974 
@Override
    public void actionPerformed(ActionEvent ae)
    { 

//#if 1787555261 
super.actionPerformed(ae);
//#endif 


//#if -931772136 
List classes = new ArrayList();
//#endif 


//#if 1413090887 
ArgoDiagram activeDiagram = DiagramUtils.getActiveDiagram();
//#endif 


//#if -266224793 
if(activeDiagram == null)//1
{ 

//#if -392400743 
return;
//#endif 

} 

//#endif 


//#if 1982735473 
Object ns = activeDiagram.getNamespace();
//#endif 


//#if 1786917385 
if(ns == null)//1
{ 

//#if -274630696 
return;
//#endif 

} 

//#endif 


//#if -532270661 
while (Model.getFacade().getNamespace(ns) != null) //1
{ 

//#if -141264501 
ns = Model.getFacade().getNamespace(ns);
//#endif 

} 

//#endif 


//#if 901926344 
Collection elems =
            Model.getModelManagementHelper()
            .getAllModelElementsOfKind(
                ns,
                Model.getMetaTypes().getClassifier());
//#endif 


//#if 1039570760 
for (Object cls : elems) //1
{ 

//#if -223991321 
if(isCodeRelevantClassifier(cls))//1
{ 

//#if 854772997 
classes.add(cls);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1555392745 
ClassGenerationDialog cgd = new ClassGenerationDialog(classes, true);
//#endif 


//#if -1143256716 
cgd.setVisible(true);
//#endif 

} 

//#endif 


//#if -312135921 
public boolean isEnabled()
    { 

//#if 757407572 
return true;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

