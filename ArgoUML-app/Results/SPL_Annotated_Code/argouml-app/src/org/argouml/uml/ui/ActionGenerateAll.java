// Compilation Unit of /ActionGenerateAll.java 
 
package org.argouml.uml.ui;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.Action;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramUtils;
import org.argouml.uml.diagram.static_structure.ui.UMLClassDiagram;
import org.argouml.uml.generator.ui.ClassGenerationDialog;
import org.tigris.gef.undo.UndoableAction;
public class ActionGenerateAll extends UndoableAction
  { 
public ActionGenerateAll()
    { 
super(Translator.localize("action.generate-all-classes"), null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.generate-all-classes"));
} 

@Override
    public boolean isEnabled()
    { 
return true;
} 

@Override
    public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
ArgoDiagram activeDiagram = DiagramUtils.getActiveDiagram();
if(!(activeDiagram instanceof UMLClassDiagram))//1
{ 
return;
} 

UMLClassDiagram d = (UMLClassDiagram) activeDiagram;
List classes = new ArrayList();
List nodes = d.getNodes();
for (Object owner : nodes) //1
{ 
if(!Model.getFacade().isAClass(owner)
                    && !Model.getFacade().isAInterface(owner))//1
{ 
continue;
} 

String name = Model.getFacade().getName(owner);
if(name == null
                    || name.length() == 0
                    || Character.isDigit(name.charAt(0)))//1
{ 
continue;
} 

classes.add(owner);
} 

if(classes.size() == 0)//1
{ 
Collection selectedObjects =
                TargetManager.getInstance().getTargets();
for (Object selected : selectedObjects) //1
{ 
if(Model.getFacade().isAPackage(selected))//1
{ 
addCollection(Model.getModelManagementHelper()
                                  .getAllModelElementsOfKind(
                                      selected,
                                      Model.getMetaTypes().getUMLClass()),
                                  classes);
addCollection(Model.getModelManagementHelper()
                                  .getAllModelElementsOfKind(
                                      selected,
                                      Model.getMetaTypes().getInterface()),
                                  classes);
} 
else
if(Model.getFacade().isAClass(selected)
                           || Model.getFacade().isAInterface(selected))//1
{ 
if(!classes.contains(selected))//1
{ 
classes.add(selected);
} 

} 


} 

} 

ClassGenerationDialog cgd = new ClassGenerationDialog(classes);
cgd.setVisible(true);
} 

private void addCollection(Collection c, Collection v)
    { 
for (Object o : c) //1
{ 
if(!v.contains(o))//1
{ 
v.add(o);
} 

} 

} 

 } 


