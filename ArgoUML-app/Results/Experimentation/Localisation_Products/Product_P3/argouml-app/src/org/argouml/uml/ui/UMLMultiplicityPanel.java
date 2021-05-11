package org.argouml.uml.ui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Action;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import org.argouml.model.Model;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.uml.ui.behavior.collaborations.ActionSetClassifierRoleMultiplicity;
public class UMLMultiplicityPanel extends JPanel
 implements ItemListener
  { 
private JComboBox multiplicityComboBox;
private JCheckBox checkBox;
private MultiplicityComboBoxModel multiplicityComboBoxModel;
private static List<String> multiplicityList = new ArrayList<String>();
static
    {
        multiplicityList.add("1");
        multiplicityList.add("0..1");
        multiplicityList.add("0..*");
        multiplicityList.add("1..*");
    }
private Object getTarget()
    { 
return multiplicityComboBoxModel.getTarget();
} 
public UMLMultiplicityPanel()
    { 
super(new BorderLayout());
multiplicityComboBoxModel =
            new MultiplicityComboBoxModel("multiplicity");
checkBox = new MultiplicityCheckBox();
multiplicityComboBox =
            new MultiplicityComboBox(
            multiplicityComboBoxModel,
            ActionSetClassifierRoleMultiplicity.getInstance());
multiplicityComboBox.setEditable(true);
multiplicityComboBox.addItemListener(this);
add(checkBox, BorderLayout.WEST);
add(multiplicityComboBox, BorderLayout.CENTER);
} 
@Override
    public Dimension getPreferredSize()
    { 
return new Dimension(
                   super.getPreferredSize().width,
                   getMinimumSize().height);
} 
public void itemStateChanged(ItemEvent event)
    { 
if(event.getSource() == multiplicityComboBox && getTarget() != null)//1
{ 
Object item = multiplicityComboBox.getSelectedItem();
Object target = multiplicityComboBoxModel.getTarget();
Object multiplicity = Model.getFacade().getMultiplicity(target);
if(Model.getFacade().isAMultiplicity(item))//1
{ 
if(!item.equals(multiplicity))//1
{ 
Model.getCoreHelper().setMultiplicity(target, item);
if(multiplicity != null)//1
{ 
Model.getUmlFactory().delete(multiplicity);
} 
} 
} 
else
if(item instanceof String)//1
{ 
if(!item.equals(Model.getFacade().toString(multiplicity)))//1
{ 
Model.getCoreHelper().setMultiplicity(
                        target,
                        Model.getDataTypesFactory().createMultiplicity(
                            (String) item));
if(multiplicity != null)//1
{ 
Model.getUmlFactory().delete(multiplicity);
} 
} 
} 
else
{ 
if(multiplicity != null)//1
{ 
Model.getCoreHelper().setMultiplicity(target, null);
Model.getUmlFactory().delete(multiplicity);
} 
} 
} 
} 
private class MultiplicityComboBoxModel extends UMLComboBoxModel2
  { 
protected boolean isValidElement(Object element)
        { 
return element instanceof String;
} 
protected void buildModelList()
        { 
setElements(multiplicityList);
Object t = getTarget();
if(Model.getFacade().isAModelElement(t))//1
{ 
addElement(Model.getFacade().getMultiplicity(t));
} 
} 
protected Object getSelectedModelElement()
        { 
if(getTarget() != null)//1
{ 
return Model.getFacade().toString(
                           Model.getFacade().getMultiplicity(getTarget()));
} 
return null;
} 
@Override
        public void addElement(Object o)
        { 
if(o == null)//1
{ 
return;
} 
String text;
if(Model.getFacade().isAMultiplicity(o))//1
{ 
text = Model.getFacade().toString(o);
if("".equals(text))//1
{ 
text = "1";
} 
} 
else
if(o instanceof String)//1
{ 
text = (String) o;
} 
else
{ 
return;
} 
if(!multiplicityList.contains(text) && isValidElement(text))//1
{ 
multiplicityList.add(text);
} 
super.addElement(text);
} 
@Override
        public void setSelectedItem(Object anItem)
        { 
addElement(anItem);
super.setSelectedItem((anItem == null) ? null
                                  : Model.getFacade().toString(anItem));
} 
public MultiplicityComboBoxModel(String propertySetName)
        { 
super(propertySetName, false);
} 

 } 
private class MultiplicityComboBox extends UMLSearchableComboBox
  { 
@Override
        public void targetSet(TargetEvent e)
        { 
super.targetSet(e);
Object target = getTarget();
boolean exists = target != null
                             && Model.getFacade().getMultiplicity(target) != null;
multiplicityComboBox.setEnabled(exists);
multiplicityComboBox.setEditable(exists);
checkBox.setSelected(exists);
} 
@Override
        protected void doOnEdit(Object item)
        { 
String text = (String) item;
try//1
{ 
Object multi =
                    Model.getDataTypesFactory().createMultiplicity(text);
if(multi != null)//1
{ 
setSelectedItem(text);
Model.getUmlFactory().delete(multi);
return;
} 
} 
catch (IllegalArgumentException e) //1
{ 
Object o = search(text);
if(o != null)//1
{ 
setSelectedItem(o);
return;
} 
} 
getEditor().setItem(getSelectedItem());
} 
public MultiplicityComboBox(UMLComboBoxModel2 arg0,
                                    Action selectAction)
        { 
super(arg0, selectAction);
} 

 } 
private class MultiplicityCheckBox extends JCheckBox
 implements ItemListener
  { 
public void itemStateChanged(ItemEvent e)
        { 
Object target = getTarget();
Object oldValue = Model.getFacade().getMultiplicity(target);
if(e.getStateChange() == ItemEvent.SELECTED)//1
{ 
String comboText =
                    (String) multiplicityComboBox.getSelectedItem();
if(oldValue == null
                        || !comboText.equals(Model.getFacade().toString(
                                                 oldValue)))//1
{ 
Object multi = Model.getDataTypesFactory()
                                   .createMultiplicity(comboText);
if(multi == null)//1
{ 
Model.getCoreHelper().setMultiplicity(target, "1");
} 
else
{ 
Model.getCoreHelper().setMultiplicity(target, multi);
} 
if(oldValue != null)//1
{ 
Model.getUmlFactory().delete(oldValue);
} 
} 
multiplicityComboBox.setEnabled(true);
multiplicityComboBox.setEditable(true);
} 
else
{ 
multiplicityComboBox.setEnabled(false);
multiplicityComboBox.setEditable(false);
Model.getCoreHelper().setMultiplicity(target, null);
if(oldValue != null)//1
{ 
Model.getUmlFactory().delete(oldValue);
} 
} 
} 
public MultiplicityCheckBox()
        { 
addItemListener(this);
} 

 } 

 } 
