
//#if 106561621 
// Compilation Unit of /UMLMultiplicityPanel.java 
 

//#if -1015250842 
package org.argouml.uml.ui;
//#endif 


//#if 51434122 
import java.awt.BorderLayout;
//#endif 


//#if 1335654320 
import java.awt.Dimension;
//#endif 


//#if 422995331 
import java.awt.event.ItemEvent;
//#endif 


//#if -1229426139 
import java.awt.event.ItemListener;
//#endif 


//#if 779576421 
import java.util.ArrayList;
//#endif 


//#if 1013442268 
import java.util.List;
//#endif 


//#if -811981284 
import javax.swing.Action;
//#endif 


//#if 716789495 
import javax.swing.JCheckBox;
//#endif 


//#if -1483280259 
import javax.swing.JComboBox;
//#endif 


//#if -1975744232 
import javax.swing.JPanel;
//#endif 


//#if -2132568875 
import org.argouml.model.Model;
//#endif 


//#if 2064175328 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if 1524768639 
import org.argouml.uml.ui.behavior.collaborations.ActionSetClassifierRoleMultiplicity;
//#endif 


//#if 471377700 
public class UMLMultiplicityPanel extends 
//#if 848093996 
JPanel
//#endif 

 implements 
//#if -2078205223 
ItemListener
//#endif 

  { 

//#if 2141500169 
private JComboBox multiplicityComboBox;
//#endif 


//#if 452115388 
private JCheckBox checkBox;
//#endif 


//#if 506942314 
private MultiplicityComboBoxModel multiplicityComboBoxModel;
//#endif 


//#if -621405248 
private static List<String> multiplicityList = new ArrayList<String>();
//#endif 


//#if -1666321701 
static
    {
        multiplicityList.add("1");
        multiplicityList.add("0..1");
        multiplicityList.add("0..*");
        multiplicityList.add("1..*");
    }
//#endif 


//#if 2012081848 
private Object getTarget()
    { 

//#if 1876974125 
return multiplicityComboBoxModel.getTarget();
//#endif 

} 

//#endif 


//#if 1903824301 
public UMLMultiplicityPanel()
    { 

//#if 355320046 
super(new BorderLayout());
//#endif 


//#if -749127760 
multiplicityComboBoxModel =
            new MultiplicityComboBoxModel("multiplicity");
//#endif 


//#if 1103704324 
checkBox = new MultiplicityCheckBox();
//#endif 


//#if -144115884 
multiplicityComboBox =
            new MultiplicityComboBox(
            multiplicityComboBoxModel,
            ActionSetClassifierRoleMultiplicity.getInstance());
//#endif 


//#if 169063526 
multiplicityComboBox.setEditable(true);
//#endif 


//#if 2101285364 
multiplicityComboBox.addItemListener(this);
//#endif 


//#if -264936987 
add(checkBox, BorderLayout.WEST);
//#endif 


//#if -1771872732 
add(multiplicityComboBox, BorderLayout.CENTER);
//#endif 

} 

//#endif 


//#if 131238352 
@Override
    public Dimension getPreferredSize()
    { 

//#if 1522828911 
return new Dimension(
                   super.getPreferredSize().width,
                   getMinimumSize().height);
//#endif 

} 

//#endif 


//#if 198789875 
public void itemStateChanged(ItemEvent event)
    { 

//#if -1518037522 
if(event.getSource() == multiplicityComboBox && getTarget() != null)//1
{ 

//#if 1580737132 
Object item = multiplicityComboBox.getSelectedItem();
//#endif 


//#if 541533906 
Object target = multiplicityComboBoxModel.getTarget();
//#endif 


//#if -769905336 
Object multiplicity = Model.getFacade().getMultiplicity(target);
//#endif 


//#if 2137288590 
if(Model.getFacade().isAMultiplicity(item))//1
{ 

//#if 552673397 
if(!item.equals(multiplicity))//1
{ 

//#if -328443385 
Model.getCoreHelper().setMultiplicity(target, item);
//#endif 


//#if 757975890 
if(multiplicity != null)//1
{ 

//#if 1275069244 
Model.getUmlFactory().delete(multiplicity);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else

//#if -86482490 
if(item instanceof String)//1
{ 

//#if -1912448198 
if(!item.equals(Model.getFacade().toString(multiplicity)))//1
{ 

//#if 680751055 
Model.getCoreHelper().setMultiplicity(
                        target,
                        Model.getDataTypesFactory().createMultiplicity(
                            (String) item));
//#endif 


//#if 1440922579 
if(multiplicity != null)//1
{ 

//#if 102076679 
Model.getUmlFactory().delete(multiplicity);
//#endif 

} 

//#endif 

} 

//#endif 

} 
else
{ 

//#if -693697735 
if(multiplicity != null)//1
{ 

//#if -1548007724 
Model.getCoreHelper().setMultiplicity(target, null);
//#endif 


//#if 227085502 
Model.getUmlFactory().delete(multiplicity);
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


//#if -100371802 
private class MultiplicityComboBoxModel extends 
//#if -786580119 
UMLComboBoxModel2
//#endif 

  { 

//#if 1932969727 
protected boolean isValidElement(Object element)
        { 

//#if -1464401400 
return element instanceof String;
//#endif 

} 

//#endif 


//#if 1866650827 
protected void buildModelList()
        { 

//#if -1004187661 
setElements(multiplicityList);
//#endif 


//#if -352558384 
Object t = getTarget();
//#endif 


//#if 624793139 
if(Model.getFacade().isAModelElement(t))//1
{ 

//#if 1689931997 
addElement(Model.getFacade().getMultiplicity(t));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1620492233 
protected Object getSelectedModelElement()
        { 

//#if 161939365 
if(getTarget() != null)//1
{ 

//#if 1139801721 
return Model.getFacade().toString(
                           Model.getFacade().getMultiplicity(getTarget()));
//#endif 

} 

//#endif 


//#if -813612697 
return null;
//#endif 

} 

//#endif 


//#if -1792773362 
@Override
        public void addElement(Object o)
        { 

//#if 596192327 
if(o == null)//1
{ 

//#if 1268396789 
return;
//#endif 

} 

//#endif 


//#if -491360087 
String text;
//#endif 


//#if 374648909 
if(Model.getFacade().isAMultiplicity(o))//1
{ 

//#if -1860258398 
text = Model.getFacade().toString(o);
//#endif 


//#if 1565091123 
if("".equals(text))//1
{ 

//#if 1497911413 
text = "1";
//#endif 

} 

//#endif 

} 
else

//#if 1080573793 
if(o instanceof String)//1
{ 

//#if 1657011807 
text = (String) o;
//#endif 

} 
else
{ 

//#if -1376167686 
return;
//#endif 

} 

//#endif 


//#endif 


//#if 1350840832 
if(!multiplicityList.contains(text) && isValidElement(text))//1
{ 

//#if -453669859 
multiplicityList.add(text);
//#endif 

} 

//#endif 


//#if -1025960539 
super.addElement(text);
//#endif 

} 

//#endif 


//#if -1532291558 
@Override
        public void setSelectedItem(Object anItem)
        { 

//#if -1998378480 
addElement(anItem);
//#endif 


//#if -1605004087 
super.setSelectedItem((anItem == null) ? null
                                  : Model.getFacade().toString(anItem));
//#endif 

} 

//#endif 


//#if 1481245207 
public MultiplicityComboBoxModel(String propertySetName)
        { 

//#if 1083828094 
super(propertySetName, false);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 300386883 
private class MultiplicityComboBox extends 
//#if 1842466078 
UMLSearchableComboBox
//#endif 

  { 

//#if -1637050110 
@Override
        public void targetSet(TargetEvent e)
        { 

//#if 785186679 
super.targetSet(e);
//#endif 


//#if -1286846486 
Object target = getTarget();
//#endif 


//#if 801248984 
boolean exists = target != null
                             && Model.getFacade().getMultiplicity(target) != null;
//#endif 


//#if -24929925 
multiplicityComboBox.setEnabled(exists);
//#endif 


//#if 922445996 
multiplicityComboBox.setEditable(exists);
//#endif 


//#if 9521166 
checkBox.setSelected(exists);
//#endif 

} 

//#endif 


//#if 280773102 
@Override
        protected void doOnEdit(Object item)
        { 

//#if 958728720 
String text = (String) item;
//#endif 


//#if 453824685 
try //1
{ 

//#if 1155560750 
Object multi =
                    Model.getDataTypesFactory().createMultiplicity(text);
//#endif 


//#if 1988346035 
if(multi != null)//1
{ 

//#if 415288710 
setSelectedItem(text);
//#endif 


//#if 611813251 
Model.getUmlFactory().delete(multi);
//#endif 


//#if -872316708 
return;
//#endif 

} 

//#endif 

} 

//#if 1657368249 
catch (IllegalArgumentException e) //1
{ 

//#if 1709351203 
Object o = search(text);
//#endif 


//#if 1144367198 
if(o != null)//1
{ 

//#if 280529727 
setSelectedItem(o);
//#endif 


//#if 37011137 
return;
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#if 1778375235 
getEditor().setItem(getSelectedItem());
//#endif 

} 

//#endif 


//#if 620834715 
public MultiplicityComboBox(UMLComboBoxModel2 arg0,
                                    Action selectAction)
        { 

//#if -176235492 
super(arg0, selectAction);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1845400439 
private class MultiplicityCheckBox extends 
//#if 1453457330 
JCheckBox
//#endif 

 implements 
//#if 1613477186 
ItemListener
//#endif 

  { 

//#if 1478631857 
public void itemStateChanged(ItemEvent e)
        { 

//#if 1492758863 
Object target = getTarget();
//#endif 


//#if 1417212955 
Object oldValue = Model.getFacade().getMultiplicity(target);
//#endif 


//#if 290429945 
if(e.getStateChange() == ItemEvent.SELECTED)//1
{ 

//#if -326104313 
String comboText =
                    (String) multiplicityComboBox.getSelectedItem();
//#endif 


//#if 2142466041 
if(oldValue == null
                        || !comboText.equals(Model.getFacade().toString(
                                                 oldValue)))//1
{ 

//#if 1111137334 
Object multi = Model.getDataTypesFactory()
                                   .createMultiplicity(comboText);
//#endif 


//#if -310822225 
if(multi == null)//1
{ 

//#if -674430233 
Model.getCoreHelper().setMultiplicity(target, "1");
//#endif 

} 
else
{ 

//#if -1640585592 
Model.getCoreHelper().setMultiplicity(target, multi);
//#endif 

} 

//#endif 


//#if -363975698 
if(oldValue != null)//1
{ 

//#if 15704928 
Model.getUmlFactory().delete(oldValue);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1540202347 
multiplicityComboBox.setEnabled(true);
//#endif 


//#if 2098120374 
multiplicityComboBox.setEditable(true);
//#endif 

} 
else
{ 

//#if -378181468 
multiplicityComboBox.setEnabled(false);
//#endif 


//#if 1189716891 
multiplicityComboBox.setEditable(false);
//#endif 


//#if 2129155044 
Model.getCoreHelper().setMultiplicity(target, null);
//#endif 


//#if -433773114 
if(oldValue != null)//1
{ 

//#if 323516389 
Model.getUmlFactory().delete(oldValue);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -814739769 
public MultiplicityCheckBox()
        { 

//#if -804001782 
addItemListener(this);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

