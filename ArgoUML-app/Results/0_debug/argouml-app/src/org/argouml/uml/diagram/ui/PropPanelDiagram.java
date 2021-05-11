
//#if -2067591287 
// Compilation Unit of /PropPanelDiagram.java 
 

//#if 974500479 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 905996369 
import static org.argouml.model.Model.getModelManagementFactory;
//#endif 


//#if -2116091022 
import java.awt.event.ActionEvent;
//#endif 


//#if 1934983449 
import java.util.ArrayList;
//#endif 


//#if 1194542952 
import java.util.Collection;
//#endif 


//#if -1623872357 
import java.util.Collections;
//#endif 


//#if 607103400 
import java.util.List;
//#endif 


//#if -1548637884 
import javax.swing.ImageIcon;
//#endif 


//#if 761311281 
import javax.swing.JComboBox;
//#endif 


//#if 1706292107 
import javax.swing.JComponent;
//#endif 


//#if -672085317 
import javax.swing.JTextField;
//#endif 


//#if 2019644227 
import org.argouml.i18n.Translator;
//#endif 


//#if 1640456319 
import org.argouml.ui.UndoableAction;
//#endif 


//#if 1358474041 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -728083512 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if -1705283832 
import org.argouml.uml.diagram.Relocatable;
//#endif 


//#if -1446662908 
import org.argouml.uml.ui.AbstractActionNavigate;
//#endif 


//#if 1852046186 
import org.argouml.uml.ui.ActionDeleteModelElements;
//#endif 


//#if 1819230344 
import org.argouml.uml.ui.PropPanel;
//#endif 


//#if 1294091532 
import org.argouml.uml.ui.UMLComboBox2;
//#endif 


//#if 1571812911 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if 1945946279 
import org.argouml.uml.ui.UMLComboBoxNavigator;
//#endif 


//#if -1908252746 
import org.argouml.uml.ui.UMLSearchableComboBox;
//#endif 


//#if 598760288 
import org.argouml.uml.util.PathComparator;
//#endif 


//#if 1122879113 
class UMLDiagramHomeModelComboBoxModel extends 
//#if -883635775 
UMLComboBoxModel2
//#endif 

  { 

//#if 1865528459 
@Override
    protected Object getSelectedModelElement()
    { 

//#if 2057748394 
Object t = getTarget();
//#endif 


//#if 1163083006 
if(t instanceof ArgoDiagram)//1
{ 

//#if -1102487658 
return ((ArgoDiagram) t).getOwner();
//#endif 

} 

//#endif 


//#if -425569483 
return null;
//#endif 

} 

//#endif 


//#if 509639549 
@Override
    protected boolean isValidElement(Object element)
    { 

//#if -1092460884 
Object t = getTarget();
//#endif 


//#if -61899524 
if(t instanceof Relocatable)//1
{ 

//#if 65447010 
return ((Relocatable) t).isRelocationAllowed(element);
//#endif 

} 

//#endif 


//#if 367745273 
return false;
//#endif 

} 

//#endif 


//#if -1313782455 
@Override
    protected void buildModelList()
    { 

//#if -1544707435 
Object target = getTarget();
//#endif 


//#if 620933357 
List list = new ArrayList();
//#endif 


//#if 811819845 
if(target instanceof Relocatable)//1
{ 

//#if 992442245 
Relocatable diagram = (Relocatable) target;
//#endif 


//#if -728830338 
for (Object obj : diagram.getRelocationCandidates(
                        getModelManagementFactory().getRootModel())) //1
{ 

//#if 135575509 
if(diagram.isRelocationAllowed(obj))//1
{ 

//#if 2021613945 
list.add(obj);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -223186517 
list.add(getSelectedModelElement());
//#endif 


//#if -1811259226 
Collections.sort(list, new PathComparator());
//#endif 


//#if -698168214 
setElements(list);
//#endif 

} 

//#endif 


//#if 1955726470 
@Override
    protected void buildMinimalModelList()
    { 

//#if 222854287 
Collection list = new ArrayList(1);
//#endif 


//#if -8318844 
list.add(getSelectedModelElement());
//#endif 


//#if -2093179005 
setElements(list);
//#endif 


//#if 344511982 
setModelInvalid();
//#endif 

} 

//#endif 


//#if 1715915204 
public UMLDiagramHomeModelComboBoxModel()
    { 

//#if -566438527 
super(ArgoDiagram.NAMESPACE_KEY, false);
//#endif 

} 

//#endif 


//#if -1196428244 
@Override
    protected boolean isLazy()
    { 

//#if -88110854 
return true;
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -537587119 
public class PropPanelDiagram extends 
//#if 1253945008 
PropPanel
//#endif 

  { 

//#if -1967699225 
private JComboBox homeModelSelector;
//#endif 


//#if -1269287007 
private UMLDiagramHomeModelComboBoxModel homeModelComboBoxModel =
        new UMLDiagramHomeModelComboBoxModel();
//#endif 


//#if -1265339916 
protected PropPanelDiagram(String diagramName, ImageIcon icon)
    { 

//#if 1418808262 
super(diagramName, icon);
//#endif 


//#if 1125708093 
JTextField field = new JTextField();
//#endif 


//#if -1908553080 
field.getDocument().addDocumentListener(new DiagramNameDocument(field));
//#endif 


//#if 1046602730 
addField("label.name", field);
//#endif 


//#if 1991925560 
addField("label.home-model", getHomeModelSelector());
//#endif 


//#if -529096437 
addAction(new ActionNavigateUpFromDiagram());
//#endif 


//#if -2095697256 
addAction(ActionDeleteModelElements.getTargetFollower());
//#endif 

} 

//#endif 


//#if -1538472764 
protected JComponent getHomeModelSelector()
    { 

//#if 216696733 
if(homeModelSelector == null)//1
{ 

//#if -1882951724 
homeModelSelector = new UMLSearchableComboBox(
                homeModelComboBoxModel,
                new ActionSetDiagramHomeModel(), true);
//#endif 

} 

//#endif 


//#if -381735234 
return new UMLComboBoxNavigator(
                   Translator.localize("label.namespace.navigate.tooltip"),
                   homeModelSelector);
//#endif 

} 

//#endif 


//#if -500402771 
public PropPanelDiagram()
    { 

//#if -1022079092 
this("Diagram", null);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -275656325 
class ActionSetDiagramHomeModel extends 
//#if 1916443318 
UndoableAction
//#endif 

  { 

//#if -1065788373 
public void actionPerformed(ActionEvent e)
    { 

//#if 1587814221 
Object source = e.getSource();
//#endif 


//#if -820813549 
if(source instanceof UMLComboBox2)//1
{ 

//#if 850924090 
UMLComboBox2 box = (UMLComboBox2) source;
//#endif 


//#if -2117791694 
Object diagram = box.getTarget();
//#endif 


//#if -854381954 
Object homeModel = box.getSelectedItem();
//#endif 


//#if 1061816827 
if(diagram instanceof Relocatable)//1
{ 

//#if 101675555 
Relocatable d = (Relocatable) diagram;
//#endif 


//#if -1725399913 
if(d.isRelocationAllowed(homeModel))//1
{ 

//#if 820843511 
d.relocate(homeModel);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -484700904 
protected ActionSetDiagramHomeModel()
    { 

//#if -1002287088 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 216959167 
class ActionNavigateUpFromDiagram extends 
//#if -980030667 
AbstractActionNavigate
//#endif 

  { 

//#if -538569959 
@Override
    public boolean isEnabled()
    { 

//#if -2065217747 
return true;
//#endif 

} 

//#endif 


//#if 1630402637 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if -1297640912 
Object target = TargetManager.getInstance().getTarget();
//#endif 


//#if -1642610387 
Object destination = navigateTo(target);
//#endif 


//#if -1188149070 
if(destination != null)//1
{ 

//#if 20197675 
TargetManager.getInstance().setTarget(destination);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2085640691 
public ActionNavigateUpFromDiagram()
    { 

//#if 1231608026 
super("button.go-up", true);
//#endif 

} 

//#endif 


//#if 1995355476 
protected Object navigateTo(Object source)
    { 

//#if -397896502 
if(source instanceof ArgoDiagram)//1
{ 

//#if -425542504 
return ((ArgoDiagram) source).getNamespace();
//#endif 

} 

//#endif 


//#if 1949422730 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

