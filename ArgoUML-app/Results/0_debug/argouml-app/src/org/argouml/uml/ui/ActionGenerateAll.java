
//#if 96131997 
// Compilation Unit of /ActionGenerateAll.java 
 

//#if 1143971567 
package org.argouml.uml.ui;
//#endif 


//#if -1947125763 
import java.awt.event.ActionEvent;
//#endif 


//#if -1356168466 
import java.util.ArrayList;
//#endif 


//#if -2046918605 
import java.util.Collection;
//#endif 


//#if -958654797 
import java.util.List;
//#endif 


//#if -1573612941 
import javax.swing.Action;
//#endif 


//#if -1332367336 
import org.argouml.i18n.Translator;
//#endif 


//#if 509757150 
import org.argouml.model.Model;
//#endif 


//#if 1147038148 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1918694499 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 1322704385 
import org.argouml.uml.diagram.DiagramUtils;
//#endif 


//#if -612921898 
import org.argouml.uml.diagram.static_structure.ui.UMLClassDiagram;
//#endif 


//#if -49531935 
import org.argouml.uml.generator.ui.ClassGenerationDialog;
//#endif 


//#if 601371027 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1550198572 
public class ActionGenerateAll extends 
//#if 705449779 
UndoableAction
//#endif 

  { 

//#if 1976142287 
public ActionGenerateAll()
    { 

//#if 1284289805 
super(Translator.localize("action.generate-all-classes"), null);
//#endif 


//#if -619039966 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.generate-all-classes"));
//#endif 

} 

//#endif 


//#if 792370630 
@Override
    public boolean isEnabled()
    { 

//#if 1358838970 
return true;
//#endif 

} 

//#endif 


//#if 6068841 
@Override
    public void actionPerformed(ActionEvent ae)
    { 

//#if 1963846608 
super.actionPerformed(ae);
//#endif 


//#if 881659348 
ArgoDiagram activeDiagram = DiagramUtils.getActiveDiagram();
//#endif 


//#if -2147332238 
if(!(activeDiagram instanceof UMLClassDiagram))//1
{ 

//#if 2019738716 
return;
//#endif 

} 

//#endif 


//#if -913581103 
UMLClassDiagram d = (UMLClassDiagram) activeDiagram;
//#endif 


//#if 238292325 
List classes = new ArrayList();
//#endif 


//#if -1492816318 
List nodes = d.getNodes();
//#endif 


//#if 786608011 
for (Object owner : nodes) //1
{ 

//#if 1318772663 
if(!Model.getFacade().isAClass(owner)
                    && !Model.getFacade().isAInterface(owner))//1
{ 

//#if 141548766 
continue;
//#endif 

} 

//#endif 


//#if -1145108918 
String name = Model.getFacade().getName(owner);
//#endif 


//#if -1600594178 
if(name == null
                    || name.length() == 0
                    || Character.isDigit(name.charAt(0)))//1
{ 

//#if 542968243 
continue;
//#endif 

} 

//#endif 


//#if -1830596473 
classes.add(owner);
//#endif 

} 

//#endif 


//#if -14960020 
if(classes.size() == 0)//1
{ 

//#if -120950269 
Collection selectedObjects =
                TargetManager.getInstance().getTargets();
//#endif 


//#if -2073685451 
for (Object selected : selectedObjects) //1
{ 

//#if 1480545109 
if(Model.getFacade().isAPackage(selected))//1
{ 

//#if -319738266 
addCollection(Model.getModelManagementHelper()
                                  .getAllModelElementsOfKind(
                                      selected,
                                      Model.getMetaTypes().getUMLClass()),
                                  classes);
//#endif 


//#if 1795939877 
addCollection(Model.getModelManagementHelper()
                                  .getAllModelElementsOfKind(
                                      selected,
                                      Model.getMetaTypes().getInterface()),
                                  classes);
//#endif 

} 
else

//#if 721611655 
if(Model.getFacade().isAClass(selected)
                           || Model.getFacade().isAInterface(selected))//1
{ 

//#if 1866230138 
if(!classes.contains(selected))//1
{ 

//#if -1124414353 
classes.add(selected);
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -1191166476 
ClassGenerationDialog cgd = new ClassGenerationDialog(classes);
//#endif 


//#if 52530049 
cgd.setVisible(true);
//#endif 

} 

//#endif 


//#if 327017081 
private void addCollection(Collection c, Collection v)
    { 

//#if -1767658908 
for (Object o : c) //1
{ 

//#if -1452248868 
if(!v.contains(o))//1
{ 

//#if -635484903 
v.add(o);
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

