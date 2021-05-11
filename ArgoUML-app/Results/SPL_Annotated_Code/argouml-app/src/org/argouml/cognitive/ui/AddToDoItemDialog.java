// Compilation Unit of /AddToDoItemDialog.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.awt.Insets;
//#endif 


//#if COGNITIVE 
import java.awt.event.ActionEvent;
//#endif 


//#if COGNITIVE 
import javax.swing.DefaultListModel;
//#endif 


//#if COGNITIVE 
import javax.swing.JComboBox;
//#endif 


//#if COGNITIVE 
import javax.swing.JLabel;
//#endif 


//#if COGNITIVE 
import javax.swing.JList;
//#endif 


//#if COGNITIVE 
import javax.swing.JPanel;
//#endif 


//#if COGNITIVE 
import javax.swing.JScrollPane;
//#endif 


//#if COGNITIVE 
import javax.swing.JTextArea;
//#endif 


//#if COGNITIVE 
import javax.swing.JTextField;
//#endif 


//#if COGNITIVE 
import javax.swing.ListCellRenderer;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Designer;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ListSet;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Translator;
//#endif 


//#if COGNITIVE 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.util.ArgoDialog;
//#endif 


//#if COGNITIVE 
import org.tigris.swidgets.Dialog;
//#endif 


//#if COGNITIVE 
import org.tigris.swidgets.LabelledLayout;
//#endif 


//#if COGNITIVE 
public class AddToDoItemDialog extends ArgoDialog
  { 
private static final String[] PRIORITIES = {
        Translator.localize("misc.level.high"),
        Translator.localize("misc.level.medium"),
        Translator.localize("misc.level.low"),
    };
private static final int TEXT_ROWS = 8;
private static final int TEXT_COLUMNS = 30;
private static final int INSET_PX = 3;
private JTextField headLineTextField;
private JComboBox  priorityComboBox;
private JTextField moreinfoTextField;
private JList offenderList;
private JTextArea  descriptionTextArea;
private void doAdd()
    { 
Designer designer = Designer.theDesigner();
String headline = headLineTextField.getText();
int priority = ToDoItem.HIGH_PRIORITY;
switch (priorityComboBox.getSelectedIndex()) //1
{ 
case 0://1


//#if COGNITIVE 
priority = ToDoItem.HIGH_PRIORITY;
//#endif 


//#if COGNITIVE 
break;

//#endif 


case 1://1


//#if COGNITIVE 
priority = ToDoItem.MED_PRIORITY;
//#endif 


//#if COGNITIVE 
break;

//#endif 


case 2://1


//#if COGNITIVE 
priority = ToDoItem.LOW_PRIORITY;
//#endif 


//#if COGNITIVE 
break;

//#endif 


} 

String desc = descriptionTextArea.getText();
String moreInfoURL = moreinfoTextField.getText();
ListSet newOffenders = new ListSet();
for (int i = 0; i < offenderList.getModel().getSize(); i++) //1
{ 
newOffenders.add(offenderList.getModel().getElementAt(i));
} 

ToDoItem item =
            new UMLToDoItem(designer, headline, priority, desc, moreInfoURL, newOffenders);
designer.getToDoList().addElement(item);
Designer.firePropertyChange(Designer.MODEL_TODOITEM_ADDED, null, item);
} 

@Override
    public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
if(e.getSource() == getOkButton())//1
{ 
doAdd();
} 

} 

public AddToDoItemDialog(ListCellRenderer renderer)
    { 
super(Translator.localize("dialog.title.add-todo-item"),
              Dialog.OK_CANCEL_OPTION, true);
headLineTextField = new JTextField(TEXT_COLUMNS);
priorityComboBox = new JComboBox(PRIORITIES);
moreinfoTextField = new JTextField(TEXT_COLUMNS);
descriptionTextArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
DefaultListModel dlm = new DefaultListModel();
Object[] offObj =
            TargetManager.getInstance().getModelTargets().toArray();
for (int i = 0; i < offObj.length; i++) //1
{ 
if(offObj[i] != null)//1
{ 
dlm.addElement(offObj[i]);
} 

} 

offenderList = new JList(dlm);
offenderList.setCellRenderer(renderer);
JScrollPane offenderScroll = new JScrollPane(offenderList);
offenderScroll.setOpaque(true);
JLabel headlineLabel =
            new JLabel(Translator.localize("label.headline"));
JLabel priorityLabel =
            new JLabel(Translator.localize("label.priority"));
JLabel moreInfoLabel =
            new JLabel(Translator.localize("label.more-info-url"));
JLabel offenderLabel =
            new JLabel(Translator.localize("label.offenders"));
priorityComboBox.setSelectedItem(PRIORITIES[0]);
JPanel panel = new JPanel(new LabelledLayout(getLabelGap(),
                                  getComponentGap()));
headlineLabel.setLabelFor(headLineTextField);
panel.add(headlineLabel);
panel.add(headLineTextField);
priorityLabel.setLabelFor(priorityComboBox);
panel.add(priorityLabel);
panel.add(priorityComboBox);
moreInfoLabel.setLabelFor(moreinfoTextField);
panel.add(moreInfoLabel);
panel.add(moreinfoTextField);
offenderLabel.setLabelFor(offenderScroll);
panel.add(offenderLabel);
panel.add(offenderScroll);
descriptionTextArea.setLineWrap(true);
descriptionTextArea.setWrapStyleWord(true);
descriptionTextArea.setText(Translator.localize("label.enter-todo-item")
                                    + "\n");
descriptionTextArea.setMargin(new Insets(INSET_PX, INSET_PX,
                                      INSET_PX, INSET_PX));
JScrollPane descriptionScroller = new JScrollPane(descriptionTextArea);
descriptionScroller.setPreferredSize(
            descriptionTextArea.getPreferredSize());
panel.add(descriptionScroller);
setContent(panel);
} 

 } 

//#endif 


