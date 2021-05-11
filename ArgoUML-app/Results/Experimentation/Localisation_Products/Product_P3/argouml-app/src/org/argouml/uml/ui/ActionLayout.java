package org.argouml.uml.ui;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import org.argouml.i18n.Translator;
import org.argouml.ui.UndoableAction;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.DiagramUtils;
import org.argouml.uml.diagram.activity.layout.ActivityDiagramLayouter;
import org.argouml.uml.diagram.activity.ui.UMLActivityDiagram;
import org.argouml.uml.diagram.layout.Layouter;
import org.argouml.uml.diagram.static_structure.layout.ClassdiagramLayouter;
import org.argouml.uml.diagram.static_structure.ui.UMLClassDiagram;
public class ActionLayout extends UndoableAction
  { 
@Override
    public void actionPerformed(ActionEvent ae)
    { 
super.actionPerformed(ae);
ArgoDiagram diagram = DiagramUtils.getActiveDiagram();
Layouter layouter;
if(diagram instanceof UMLClassDiagram)//1
{ 
layouter = new ClassdiagramLayouter(diagram);
} 
else
if(diagram instanceof UMLActivityDiagram)//1
{ 
layouter =
                new ActivityDiagramLayouter(diagram);
} 
else
{ 
return;
} 
layouter.layout();
diagram.damage();
} 
@Override
    public boolean isEnabled()
    { 
ArgoDiagram d;
Object target = TargetManager.getInstance().getTarget();
if(target instanceof ArgoDiagram)//1
{ 
d = (ArgoDiagram) target;
} 
else
{ 
d = DiagramUtils.getActiveDiagram();
} 
if(d instanceof UMLClassDiagram


                || d instanceof UMLActivityDiagram)//1
{ 
return true;
} 
return false;
} 
public ActionLayout()
    { 
super(Translator.localize("action.layout"), null);
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.layout"));
} 

 } 
