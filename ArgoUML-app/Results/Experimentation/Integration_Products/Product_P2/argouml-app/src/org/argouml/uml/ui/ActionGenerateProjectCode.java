package org.argouml.uml.ui;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.Action;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramUtils;
import org.argouml.uml.generator.GeneratorManager;
import org.argouml.uml.generator.ui.ClassGenerationDialog;
import org.tigris.gef.undo.UndoableAction;
public class ActionGenerateProjectCode extends UndoableAction
  { 
public ActionGenerateProjectCode()
    { 
super(Translator.localize("action.generate-code-for-project"),
              null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.generate-code-for-project"));
} 
private boolean isCodeRelevantClassifier(Object cls)
    { 
if(cls == null)//1
{ 
return false;
} 
if(!Model.getFacade().isAClass(cls)
                && !Model.getFacade().isAInterface(cls))//1
{ 
return false;
} 
String path = GeneratorManager.getCodePath(cls);
String name = Model.getFacade().getName(cls);
if(name == null
                || name.length() == 0
                || Character.isDigit(name.charAt(0)))//1
{ 
return false;
} 
if(path != null)//1
{ 
return (path.length() > 0);
} 
Object parent = Model.getFacade().getNamespace(cls);
while (parent != null) //1
{ 
path = GeneratorManager.getCodePath(parent);
if(path != null)//1
{ 
return (path.length() > 0);
} 
parent = Model.getFacade().getNamespace(parent);
} 
return false;
} 
@Override
    public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
List classes = new ArrayList();
ArgoDiagram activeDiagram = DiagramUtils.getActiveDiagram();
if(activeDiagram == null)//1
{ 
return;
} 
Object ns = activeDiagram.getNamespace();
if(ns == null)//1
{ 
return;
} 
while (Model.getFacade().getNamespace(ns) != null) //1
{ 
ns = Model.getFacade().getNamespace(ns);
} 
Collection elems =
            Model.getModelManagementHelper()
            .getAllModelElementsOfKind(
                ns,
                Model.getMetaTypes().getClassifier());
for (Object cls : elems) //1
{ 
if(isCodeRelevantClassifier(cls))//1
{ 
classes.add(cls);
} 
} 
ClassGenerationDialog cgd = new ClassGenerationDialog(classes, true);
cgd.setVisible(true);
} 
public boolean isEnabled()
    { 
return true;
} 

 } 
