
//#if -1698636324 
// Compilation Unit of /TabStereotype.java 
 

//#if 418929175 
package org.argouml.uml.ui;
//#endif 


//#if -386071557 
import java.awt.BorderLayout;
//#endif 


//#if 827728863 
import java.awt.Dimension;
//#endif 


//#if 576007163 
import java.awt.Insets;
//#endif 


//#if -48291883 
import java.awt.event.ActionEvent;
//#endif 


//#if -1098727789 
import java.awt.event.ActionListener;
//#endif 


//#if 1246571019 
import java.util.Collection;
//#endif 


//#if -253841289 
import javax.swing.BorderFactory;
//#endif 


//#if 606375946 
import javax.swing.Box;
//#endif 


//#if 992230080 
import javax.swing.BoxLayout;
//#endif 


//#if 64232193 
import javax.swing.ImageIcon;
//#endif 


//#if 1354076857 
import javax.swing.JButton;
//#endif 


//#if 1696423511 
import javax.swing.JLabel;
//#endif 


//#if -1191947571 
import javax.swing.JList;
//#endif 


//#if 1811297607 
import javax.swing.JPanel;
//#endif 


//#if -417593738 
import javax.swing.JScrollPane;
//#endif 


//#if 170352577 
import javax.swing.event.ListSelectionEvent;
//#endif 


//#if 1367959335 
import javax.swing.event.ListSelectionListener;
//#endif 


//#if -215995028 
import org.argouml.configuration.Configuration;
//#endif 


//#if 1696908096 
import org.argouml.i18n.Translator;
//#endif 


//#if -1668731386 
import org.argouml.model.Model;
//#endif 


//#if 1596744543 
import org.argouml.swingext.SpacerPanel;
//#endif 


//#if 2119602864 
import org.argouml.swingext.UpArrowIcon;
//#endif 


//#if 305242524 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 555413418 
import org.argouml.uml.StereotypeUtility;
//#endif 


//#if 597313892 
import org.argouml.uml.ui.foundation.core.UMLModelElementStereotypeListModel;
//#endif 


//#if -2115763715 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1344607597 
import org.tigris.swidgets.Horizontal;
//#endif 


//#if -1238965797 
import org.tigris.swidgets.Vertical;
//#endif 


//#if -1379356635 
public class TabStereotype extends 
//#if -322308116 
PropPanel
//#endif 

  { 

//#if -706482970 
private static final int INSET_PX = 3;
//#endif 


//#if 1796904594 
private static String orientation =
        Configuration.getString(Configuration
                                .makeKey("layout", "tabstereotype"));
//#endif 


//#if 1584698219 
private UMLModelElementListModel2 selectedListModel;
//#endif 


//#if 1865524761 
private UMLModelElementListModel2 availableListModel;
//#endif 


//#if 775207106 
private JScrollPane selectedScroll;
//#endif 


//#if -1664589546 
private JScrollPane availableScroll;
//#endif 


//#if -501514753 
private JPanel panel;
//#endif 


//#if 1001741685 
private JButton addStButton;
//#endif 


//#if -23945386 
private JButton removeStButton;
//#endif 


//#if -1832316067 
private JPanel xferButtons;
//#endif 


//#if -120899864 
private JList selectedList;
//#endif 


//#if 1120050542 
private JList availableList;
//#endif 


//#if -1842451689 
private static final long serialVersionUID = -4741653225927138553L;
//#endif 


//#if -630054550 
public TabStereotype()
    { 

//#if 745705785 
super(Translator.localize("tab.stereotype"), (ImageIcon) null);
//#endif 


//#if -1535494623 
setOrientation((orientation
                        .equals("West") || orientation.equals("East")) ? Vertical
                       .getInstance() : Horizontal.getInstance());
//#endif 


//#if 94734388 
setIcon(new UpArrowIcon());
//#endif 


//#if -1995382368 
setLayout(new BorderLayout());
//#endif 


//#if 805418350 
remove(getTitleLabel());
//#endif 


//#if 285560458 
panel = makePanel();
//#endif 


//#if 687665890 
add(panel);
//#endif 

} 

//#endif 


//#if -1928164185 
private void doAddStereotype()
    { 

//#if -224064731 
Object stereotype = availableList.getSelectedValue();
//#endif 


//#if 87318293 
Object modelElement = TargetManager.getInstance().getModelTarget();
//#endif 


//#if -96206961 
if(modelElement == null)//1
{ 

//#if 473483048 
return;
//#endif 

} 

//#endif 


//#if 529110747 
Model.getCoreHelper().addStereotype(modelElement, stereotype);
//#endif 

} 

//#endif 


//#if -1996352572 
private void doRemoveStereotype()
    { 

//#if -1721058223 
Object stereotype = selectedList.getSelectedValue();
//#endif 


//#if 1000357783 
Object modelElement = TargetManager.getInstance().getModelTarget();
//#endif 


//#if 1407010125 
if(modelElement == null)//1
{ 

//#if 370411841 
return;
//#endif 

} 

//#endif 


//#if 618725246 
if(Model.getFacade().getStereotypes(modelElement)
                .contains(stereotype))//1
{ 

//#if 1902877985 
Model.getCoreHelper().removeStereotype(modelElement, stereotype);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 974802415 
private JPanel makePanel()
    { 

//#if 1594685286 
selectedListModel = new UMLModelElementStereotypeListModel();
//#endif 


//#if -1326835816 
selectedList = new UMLLinkedList(selectedListModel);
//#endif 


//#if -1449678960 
selectedScroll = new JScrollPane(selectedList);
//#endif 


//#if -1834866535 
selectedScroll.setBorder(BorderFactory.createEmptyBorder(
                                     INSET_PX, INSET_PX, INSET_PX, INSET_PX));
//#endif 


//#if 2057995267 
selectedScroll.setColumnHeaderView(new JLabel(
                                               Translator.localize("label.applied-stereotypes")));
//#endif 


//#if 1095163948 
availableListModel = new UMLModelStereotypeListModel();
//#endif 


//#if -4815958 
availableList = new UMLLinkedList(availableListModel);
//#endif 


//#if 56954728 
availableScroll = new JScrollPane(availableList);
//#endif 


//#if -1382264147 
availableScroll.setBorder(BorderFactory.createEmptyBorder(
                                      INSET_PX, INSET_PX, INSET_PX, INSET_PX));
//#endif 


//#if 1947807907 
availableScroll.setColumnHeaderView(new JLabel(
                                                Translator.localize("label.available-stereotypes")));
//#endif 


//#if 1018684196 
addStButton = new JButton(">>");
//#endif 


//#if -1370566287 
addStButton.setToolTipText(Translator.localize("button.add-stereo"));
//#endif 


//#if -246223927 
removeStButton = new JButton("<<");
//#endif 


//#if 1365058945 
removeStButton.setToolTipText(Translator.localize(
                                          "button.remove-stereo"));
//#endif 


//#if -1301874793 
addStButton.setEnabled(false);
//#endif 


//#if -1800215598 
removeStButton.setEnabled(false);
//#endif 


//#if -869821500 
addStButton.setMargin(new Insets(2, 15, 2, 15));
//#endif 


//#if 1253571775 
removeStButton.setMargin(new Insets(2, 15, 2, 15));
//#endif 


//#if 2001343075 
addStButton.setPreferredSize(addStButton.getMinimumSize());
//#endif 


//#if -1569497919 
removeStButton.setPreferredSize(removeStButton.getMinimumSize());
//#endif 


//#if -1022530636 
BoxLayout box;
//#endif 


//#if 1869830696 
xferButtons = new JPanel();
//#endif 


//#if -1349212120 
box = new BoxLayout(xferButtons, BoxLayout.Y_AXIS);
//#endif 


//#if -182970712 
xferButtons.setLayout(box);
//#endif 


//#if -1998070005 
xferButtons.add(new SpacerPanel());
//#endif 


//#if 708884294 
xferButtons.add(addStButton);
//#endif 


//#if -551717017 
xferButtons.add(new SpacerPanel());
//#endif 


//#if 1468284585 
xferButtons.add(removeStButton);
//#endif 


//#if -98455760 
Dimension dmax = box.maximumLayoutSize(xferButtons);
//#endif 


//#if -1469136628 
Dimension dmin = box.minimumLayoutSize(xferButtons);
//#endif 


//#if 1924715194 
xferButtons.setMaximumSize(new Dimension(dmin.width, dmax.height));
//#endif 


//#if -1383094476 
addStButton.addActionListener(new AddRemoveListener());
//#endif 


//#if 486101615 
removeStButton.addActionListener(new AddRemoveListener());
//#endif 


//#if -86604579 
availableList.addListSelectionListener(
            new AvailableListSelectionListener());
//#endif 


//#if 1436560157 
selectedList.addListSelectionListener(
            new SelectedListSelectionListener());
//#endif 


//#if 1122867967 
JPanel thePanel = new JPanel();
//#endif 


//#if -1018012882 
thePanel.setLayout(new BoxLayout(thePanel, BoxLayout.X_AXIS));
//#endif 


//#if 1312365678 
thePanel.setBorder(BorderFactory.createEmptyBorder(
                               INSET_PX, INSET_PX, INSET_PX, INSET_PX));
//#endif 


//#if -125465481 
thePanel.add(availableScroll);
//#endif 


//#if -1844893721 
thePanel.add(xferButtons);
//#endif 


//#if 1745322986 
thePanel.add(Box.createRigidArea(new Dimension(5, 1)));
//#endif 


//#if -632031029 
thePanel.add(selectedScroll);
//#endif 


//#if -2026650297 
return thePanel;
//#endif 

} 

//#endif 


//#if 395083055 
@Override
    public void setTarget(Object theTarget)
    { 

//#if 1648202590 
super.setTarget(theTarget);
//#endif 


//#if 2062044436 
if(isVisible())//1
{ 

//#if 1857713734 
Object me = getModelElement();
//#endif 


//#if -360898243 
if(me != null)//1
{ 

//#if -1211066783 
selectedListModel.setTarget(me);
//#endif 


//#if 940032704 
validate();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1425114306 
public boolean shouldBeEnabled()
    { 

//#if -465770115 
Object target = getTarget();
//#endif 


//#if -783180205 
return shouldBeEnabled(target);
//#endif 

} 

//#endif 


//#if -365627148 
@Override
    public boolean shouldBeEnabled(Object target)
    { 

//#if 327328417 
if(target instanceof Fig)//1
{ 

//#if -1045740878 
target = ((Fig) target).getOwner();
//#endif 

} 

//#endif 


//#if 1181826736 
return Model.getFacade().isAModelElement(target);
//#endif 

} 

//#endif 


//#if 1051100931 
private class AvailableListSelectionListener implements 
//#if -1542569375 
ListSelectionListener
//#endif 

  { 

//#if 250044734 
public void valueChanged(ListSelectionEvent lse)
        { 

//#if -635078004 
if(lse.getValueIsAdjusting())//1
{ 

//#if -1768851525 
return;
//#endif 

} 

//#endif 


//#if -737058531 
Object selRule = availableList.getSelectedValue();
//#endif 


//#if 1936524876 
addStButton.setEnabled(selRule != null);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1821520687 
private class AddRemoveListener implements 
//#if -449954574 
ActionListener
//#endif 

  { 

//#if -1252227675 
public void actionPerformed(ActionEvent e)
        { 

//#if -411742385 
Object src = e.getSource();
//#endif 


//#if -307068738 
if(src == addStButton)//1
{ 

//#if 1618658962 
doAddStereotype();
//#endif 

} 
else

//#if 407962223 
if(src == removeStButton)//1
{ 

//#if 1107382324 
doRemoveStereotype();
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1901642648 
private static class UMLModelStereotypeListModel extends 
//#if -217957678 
UMLModelElementListModel2
//#endif 

  { 

//#if -404290133 
private static final long serialVersionUID = 7247425177890724453L;
//#endif 


//#if 1804465888 
public UMLModelStereotypeListModel()
        { 

//#if -246647347 
super("stereotype");
//#endif 

} 

//#endif 


//#if -31988620 
protected boolean isValidElement(Object element)
        { 

//#if 2027218163 
return Model.getFacade().isAStereotype(element);
//#endif 

} 

//#endif 


//#if -1532003264 
protected void buildModelList()
        { 

//#if -1114538001 
removeAllElements();
//#endif 


//#if 498346539 
if(Model.getFacade().isAModelElement(getTarget()))//1
{ 

//#if 1403506710 
Collection s;
//#endif 


//#if -805830286 
s = StereotypeUtility.getAvailableStereotypes(getTarget());
//#endif 


//#if -2116901256 
s.removeAll(Model.getFacade().getStereotypes(getTarget()));
//#endif 


//#if 221173677 
addAll(s);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#if -1940900003 
private class SelectedListSelectionListener implements 
//#if -1653882121 
ListSelectionListener
//#endif 

  { 

//#if -1676541996 
public void valueChanged(ListSelectionEvent lse)
        { 

//#if -829753792 
if(lse.getValueIsAdjusting())//1
{ 

//#if -1667689915 
return;
//#endif 

} 

//#endif 


//#if 1499810895 
Object selRule = selectedList.getSelectedValue();
//#endif 


//#if -115361099 
removeStButton.setEnabled(selRule != null);
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

