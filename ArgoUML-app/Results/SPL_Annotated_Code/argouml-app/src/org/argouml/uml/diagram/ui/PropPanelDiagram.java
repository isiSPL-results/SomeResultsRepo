// Compilation Unit of /PropPanelDiagram.java 
 
package org.argouml.uml.diagram.ui;
import static org.argouml.model.Model.getModelManagementFactory;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import org.argouml.i18n.Translator;
import org.argouml.ui.UndoableAction;
import org.argouml.ui.targetmanager.TargetManager;
import org.argouml.uml.diagram.ArgoDiagram;
import org.argouml.uml.diagram.Relocatable;
import org.argouml.uml.ui.AbstractActionNavigate;
import org.argouml.uml.ui.ActionDeleteModelElements;
import org.argouml.uml.ui.PropPanel;
import org.argouml.uml.ui.UMLComboBox2;
import org.argouml.uml.ui.UMLComboBoxModel2;
import org.argouml.uml.ui.UMLComboBoxNavigator;
import org.argouml.uml.ui.UMLSearchableComboBox;
import org.argouml.uml.util.PathComparator;
class UMLDiagramHomeModelComboBoxModel extends UMLComboBoxModel2
  { 
@Override
    protected Object getSelectedModelElement()
    { 
Object t = getTarget();
if(t instanceof ArgoDiagram)//1
{ 
return ((ArgoDiagram) t).getOwner();
} 

return null;
} 

@Override
    protected boolean isValidElement(Object element)
    { 
Object t = getTarget();
if(t instanceof Relocatable)//1
{ 
return ((Relocatable) t).isRelocationAllowed(element);
} 

return false;
} 

@Override
    protected void buildModelList()
    { 
Object target = getTarget();
List list = new ArrayList();
if(target instanceof Relocatable)//1
{ 
Relocatable diagram = (Relocatable) target;
for (Object obj : diagram.getRelocationCandidates(
                        getModelManagementFactory().getRootModel())) //1
{ 
if(diagram.isRelocationAllowed(obj))//1
{ 
list.add(obj);
} 

} 

} 

list.add(getSelectedModelElement());
Collections.sort(list, new PathComparator());
setElements(list);
} 

@Override
    protected void buildMinimalModelList()
    { 
Collection list = new ArrayList(1);
list.add(getSelectedModelElement());
setElements(list);
setModelInvalid();
} 

public UMLDiagramHomeModelComboBoxModel()
    { 
super(ArgoDiagram.NAMESPACE_KEY, false);
} 

@Override
    protected boolean isLazy()
    { 
return true;
} 

 } 

public class PropPanelDiagram extends PropPanel
  { 
private JComboBox homeModelSelector;
private UMLDiagramHomeModelComboBoxModel homeModelComboBoxModel =
        new UMLDiagramHomeModelComboBoxModel();
protected PropPanelDiagram(String diagramName, ImageIcon icon)
    { 
super(diagramName, icon);
JTextField field = new JTextField();
field.getDocument().addDocumentListener(new DiagramNameDocument(field));
addField("label.name", field);
addField("label.home-model", getHomeModelSelector());
addAction(new ActionNavigateUpFromDiagram());
addAction(ActionDeleteModelElements.getTargetFollower());
} 

protected JComponent getHomeModelSelector()
    { 
if(homeModelSelector == null)//1
{ 
homeModelSelector = new UMLSearchableComboBox(
                homeModelComboBoxModel,
                new ActionSetDiagramHomeModel(), true);
} 

return new UMLComboBoxNavigator(
                   Translator.localize("label.namespace.navigate.tooltip"),
                   homeModelSelector);
} 

public PropPanelDiagram()
    { 
this("Diagram", null);
} 

 } 

class ActionSetDiagramHomeModel extends UndoableAction
  { 
public void actionPerformed(ActionEvent e)
    { 
Object source = e.getSource();
if(source instanceof UMLComboBox2)//1
{ 
UMLComboBox2 box = (UMLComboBox2) source;
Object diagram = box.getTarget();
Object homeModel = box.getSelectedItem();
if(diagram instanceof Relocatable)//1
{ 
Relocatable d = (Relocatable) diagram;
if(d.isRelocationAllowed(homeModel))//1
{ 
d.relocate(homeModel);
} 

} 

} 

} 

protected ActionSetDiagramHomeModel()
    { 
super();
} 

 } 

class ActionNavigateUpFromDiagram extends AbstractActionNavigate
  { 
@Override
    public boolean isEnabled()
    { 
return true;
} 

@Override
    public void actionPerformed(ActionEvent e)
    { 
Object target = TargetManager.getInstance().getTarget();
Object destination = navigateTo(target);
if(destination != null)//1
{ 
TargetManager.getInstance().setTarget(destination);
} 

} 

public ActionNavigateUpFromDiagram()
    { 
super("button.go-up", true);
} 

protected Object navigateTo(Object source)
    { 
if(source instanceof ArgoDiagram)//1
{ 
return ((ArgoDiagram) source).getNamespace();
} 

return null;
} 

 } 


