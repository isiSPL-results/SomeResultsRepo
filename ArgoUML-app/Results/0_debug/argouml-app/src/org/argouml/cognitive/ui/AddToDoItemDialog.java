
//#if 624995288 
// Compilation Unit of /AddToDoItemDialog.java 
 

//#if 1620917669 
package org.argouml.cognitive.ui;
//#endif 


//#if -44811389 
import java.awt.Insets;
//#endif 


//#if 466651981 
import java.awt.event.ActionEvent;
//#endif 


//#if -1005488881 
import javax.swing.DefaultListModel;
//#endif 


//#if -2062914698 
import javax.swing.JComboBox;
//#endif 


//#if 1020117455 
import javax.swing.JLabel;
//#endif 


//#if -798121899 
import javax.swing.JList;
//#endif 


//#if 1134991551 
import javax.swing.JPanel;
//#endif 


//#if 435621374 
import javax.swing.JScrollPane;
//#endif 


//#if -1326235367 
import javax.swing.JTextArea;
//#endif 


//#if 1971222550 
import javax.swing.JTextField;
//#endif 


//#if 582292502 
import javax.swing.ListCellRenderer;
//#endif 


//#if 1675403845 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1147792478 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 155418199 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1492937802 
import org.argouml.cognitive.Translator;
//#endif 


//#if 2118982932 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1912267635 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if -1418921435 
import org.argouml.util.ArgoDialog;
//#endif 


//#if 587992897 
import org.tigris.swidgets.Dialog;
//#endif 


//#if -969957112 
import org.tigris.swidgets.LabelledLayout;
//#endif 


//#if 1571738696 
public class AddToDoItemDialog extends 
//#if 212205142 
ArgoDialog
//#endif 

  { 

//#if 1679892222 
private static final String[] PRIORITIES = {
        Translator.localize("misc.level.high"),
        Translator.localize("misc.level.medium"),
        Translator.localize("misc.level.low"),
    };
//#endif 


//#if 2064991370 
private static final int TEXT_ROWS = 8;
//#endif 


//#if -617344799 
private static final int TEXT_COLUMNS = 30;
//#endif 


//#if -1918131738 
private static final int INSET_PX = 3;
//#endif 


//#if 2130997491 
private JTextField headLineTextField;
//#endif 


//#if 1375347137 
private JComboBox  priorityComboBox;
//#endif 


//#if -1558415934 
private JTextField moreinfoTextField;
//#endif 


//#if -1977594742 
private JList offenderList;
//#endif 


//#if -1503525093 
private JTextArea  descriptionTextArea;
//#endif 


//#if -2000519211 
private void doAdd()
    { 

//#if -48424098 
Designer designer = Designer.theDesigner();
//#endif 


//#if 1297207904 
String headline = headLineTextField.getText();
//#endif 


//#if 2110798369 
int priority = ToDoItem.HIGH_PRIORITY;
//#endif 


//#if -1428672177 
switch (priorityComboBox.getSelectedIndex()) //1
{ 
case 0://1


//#if 188439248 
priority = ToDoItem.HIGH_PRIORITY;
//#endif 


//#if 455367446 
break;

//#endif 


case 1://1


//#if 1872548166 
priority = ToDoItem.MED_PRIORITY;
//#endif 


//#if -1372605890 
break;

//#endif 


case 2://1


//#if 920043418 
priority = ToDoItem.LOW_PRIORITY;
//#endif 


//#if -385693198 
break;

//#endif 


} 

//#endif 


//#if 1114770214 
String desc = descriptionTextArea.getText();
//#endif 


//#if -1800274431 
String moreInfoURL = moreinfoTextField.getText();
//#endif 


//#if -1884459053 
ListSet newOffenders = new ListSet();
//#endif 


//#if 135759149 
for (int i = 0; i < offenderList.getModel().getSize(); i++) //1
{ 

//#if 1565043974 
newOffenders.add(offenderList.getModel().getElementAt(i));
//#endif 

} 

//#endif 


//#if 2028927364 
ToDoItem item =
            new UMLToDoItem(designer, headline, priority, desc, moreInfoURL, newOffenders);
//#endif 


//#if -1164073792 
designer.getToDoList().addElement(item);
//#endif 


//#if 1695556675 
Designer.firePropertyChange(Designer.MODEL_TODOITEM_ADDED, null, item);
//#endif 

} 

//#endif 


//#if -1366181450 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if -386668659 
super.actionPerformed(e);
//#endif 


//#if -744655178 
if(e.getSource() == getOkButton())//1
{ 

//#if -1058723772 
doAdd();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -944698081 
public AddToDoItemDialog(ListCellRenderer renderer)
    { 

//#if -2009152981 
super(Translator.localize("dialog.title.add-todo-item"),
              Dialog.OK_CANCEL_OPTION, true);
//#endif 


//#if 817720313 
headLineTextField = new JTextField(TEXT_COLUMNS);
//#endif 


//#if 1841528140 
priorityComboBox = new JComboBox(PRIORITIES);
//#endif 


//#if 1744909384 
moreinfoTextField = new JTextField(TEXT_COLUMNS);
//#endif 


//#if -436440952 
descriptionTextArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
//#endif 


//#if -1065375067 
DefaultListModel dlm = new DefaultListModel();
//#endif 


//#if -123470993 
Object[] offObj =
            TargetManager.getInstance().getModelTargets().toArray();
//#endif 


//#if -1342733261 
for (int i = 0; i < offObj.length; i++) //1
{ 

//#if 1432458304 
if(offObj[i] != null)//1
{ 

//#if -1665721050 
dlm.addElement(offObj[i]);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1179613078 
offenderList = new JList(dlm);
//#endif 


//#if 135582138 
offenderList.setCellRenderer(renderer);
//#endif 


//#if -938979769 
JScrollPane offenderScroll = new JScrollPane(offenderList);
//#endif 


//#if -490377958 
offenderScroll.setOpaque(true);
//#endif 


//#if 2038267398 
JLabel headlineLabel =
            new JLabel(Translator.localize("label.headline"));
//#endif 


//#if 1509559302 
JLabel priorityLabel =
            new JLabel(Translator.localize("label.priority"));
//#endif 


//#if -401057929 
JLabel moreInfoLabel =
            new JLabel(Translator.localize("label.more-info-url"));
//#endif 


//#if 880006687 
JLabel offenderLabel =
            new JLabel(Translator.localize("label.offenders"));
//#endif 


//#if -1594041786 
priorityComboBox.setSelectedItem(PRIORITIES[0]);
//#endif 


//#if -1359019143 
JPanel panel = new JPanel(new LabelledLayout(getLabelGap(),
                                  getComponentGap()));
//#endif 


//#if 795970361 
headlineLabel.setLabelFor(headLineTextField);
//#endif 


//#if 398699822 
panel.add(headlineLabel);
//#endif 


//#if -1389727833 
panel.add(headLineTextField);
//#endif 


//#if 741836309 
priorityLabel.setLabelFor(priorityComboBox);
//#endif 


//#if 1009440606 
panel.add(priorityLabel);
//#endif 


//#if 557324311 
panel.add(priorityComboBox);
//#endif 


//#if 1884934619 
moreInfoLabel.setLabelFor(moreinfoTextField);
//#endif 


//#if 1626260095 
panel.add(moreInfoLabel);
//#endif 


//#if 202572984 
panel.add(moreinfoTextField);
//#endif 


//#if -1813774097 
offenderLabel.setLabelFor(offenderScroll);
//#endif 


//#if -1824279383 
panel.add(offenderLabel);
//#endif 


//#if 839057308 
panel.add(offenderScroll);
//#endif 


//#if -385076429 
descriptionTextArea.setLineWrap(true);
//#endif 


//#if -1335675698 
descriptionTextArea.setWrapStyleWord(true);
//#endif 


//#if -604023508 
descriptionTextArea.setText(Translator.localize("label.enter-todo-item")
                                    + "\n");
//#endif 


//#if 2059419716 
descriptionTextArea.setMargin(new Insets(INSET_PX, INSET_PX,
                                      INSET_PX, INSET_PX));
//#endif 


//#if -2140729742 
JScrollPane descriptionScroller = new JScrollPane(descriptionTextArea);
//#endif 


//#if 128561396 
descriptionScroller.setPreferredSize(
            descriptionTextArea.getPreferredSize());
//#endif 


//#if -2017550972 
panel.add(descriptionScroller);
//#endif 


//#if -1866056584 
setContent(panel);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

