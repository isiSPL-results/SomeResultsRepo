
//#if 618108447 
// Compilation Unit of /ActionLayout.java 
 

//#if 1274226149 
package org.argouml.uml.ui;
//#endif 


//#if -2102652857 
import java.awt.event.ActionEvent;
//#endif 


//#if -183937859 
import javax.swing.Action;
//#endif 


//#if -1858739954 
import org.argouml.i18n.Translator;
//#endif 


//#if -1750095990 
import org.argouml.ui.UndoableAction;
//#endif 


//#if 730033678 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 483780243 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1509989941 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if -1049633641 
import org.argouml.uml.diagram.activity.layout.ActivityDiagramLayouter;
//#endif 


//#if -1461899202 
import org.argouml.uml.diagram.activity.ui.UMLActivityDiagram;
//#endif 


//#if -797000814 
import org.argouml.uml.diagram.layout.Layouter;
//#endif 


//#if 1496527583 
import org.argouml.uml.diagram.static_structure.layout.ClassdiagramLayouter;
//#endif 


//#if -1666816308 
import org.argouml.uml.diagram.static_structure.ui.UMLClassDiagram;
//#endif 


//#if 210080948 
public class ActionLayout extends 
//#if -732998886 
UndoableAction
//#endif 

  { 

//#if 2045678882 
@Override
    public void actionPerformed(ActionEvent ae)
    { 

//#if 312569710 
super.actionPerformed(ae);
//#endif 


//#if 1263707024 
ArgoDiagram diagram = DiagramUtils.getActiveDiagram();
//#endif 


//#if -1038438394 
Layouter layouter;
//#endif 


//#if -1053188420 
if(diagram instanceof UMLClassDiagram)//1
{ 

//#if -1908611830 
layouter = new ClassdiagramLayouter(diagram);
//#endif 

} 
else

//#if -1914184905 
if(diagram instanceof UMLActivityDiagram)//1
{ 

//#if 1036915887 
layouter =
                new ActivityDiagramLayouter(diagram);
//#endif 

} 
else
{ 

//#if 165647536 
return;
//#endif 

} 

//#endif 


//#endif 


//#if -1839739552 
layouter.layout();
//#endif 


//#if 325205001 
diagram.damage();
//#endif 

} 

//#endif 


//#if 1218652799 
@Override
    public boolean isEnabled()
    { 

//#if 840323778 
ArgoDiagram d;
//#endif 


//#if -274348507 
Object target = TargetManager.getInstance().getTarget();
//#endif 


//#if 1951055945 
if(target instanceof ArgoDiagram)//1
{ 

//#if -246543012 
d = (ArgoDiagram) target;
//#endif 

} 
else
{ 

//#if 706247206 
d = DiagramUtils.getActiveDiagram();
//#endif 

} 

//#endif 


//#if 107335533 
if(d instanceof UMLClassDiagram


                || d instanceof UMLActivityDiagram)//1
{ 

//#if -1252076451 
return true;
//#endif 

} 

//#endif 


//#if -1744757961 
return false;
//#endif 

} 

//#endif 


//#if 1683873584 
public ActionLayout()
    { 

//#if -109856495 
super(Translator.localize("action.layout"), null);
//#endif 


//#if -777781090 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.layout"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

