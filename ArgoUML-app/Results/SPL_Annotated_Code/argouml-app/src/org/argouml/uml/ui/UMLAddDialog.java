// Compilation Unit of /UMLAddDialog.java 
 
package org.argouml.uml.ui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
import org.argouml.uml.util.SortedListModel;
public class UMLAddDialog extends JPanel
 implements ActionListener
  { 
private JList choicesList = null;
private JList selectedList = null;
private JButton addButton = null;
private JButton removeButton = null;
private JButton okButton = null;
private JButton cancelButton = null;
private JDialog dialog = null;
private String title = null;
private boolean multiSelectAllowed = false;
private int returnValue;
private boolean exclusive;
public UMLAddDialog(final List theChoices, final List preselected,
                        final String theTitle, final boolean multiselectAllowed,
                        final boolean isExclusive)
    { 
this(theChoices, preselected, theTitle, new UMLListCellRenderer2(true),
             multiselectAllowed, isExclusive);
} 

private void cancel()
    { 
if(dialog != null)//1
{ 
dialog.setVisible(false);
returnValue = JOptionPane.CANCEL_OPTION;
} 

} 

public int showDialog(Component parent)
    { 
Frame frame = parent instanceof Frame ? (Frame) parent
                      : (Frame) SwingUtilities
                      .getAncestorOfClass(Frame.class, parent);
dialog = new JDialog(frame, title, true);
Container contentPane = dialog.getContentPane();
contentPane.setLayout(new BorderLayout());
contentPane.add(this, BorderLayout.CENTER);
dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                cancel();
            }
        });
dialog.pack();
dialog.setLocationRelativeTo(parent);
dialog.setVisible(true);
return returnValue;
} 

private void update()
    { 
if(choicesList.getModel().getSize() == 0)//1
{ 
addButton.setEnabled(false);
} 
else
{ 
addButton.setEnabled(true);
} 

if(selectedList.getModel().getSize() == 0)//1
{ 
removeButton.setEnabled(false);
} 
else
{ 
removeButton.setEnabled(true);
} 

if(selectedList.getModel().getSize() > 1 && !multiSelectAllowed)//1
{ 
addButton.setEnabled(false);
okButton.setEnabled(false);
} 
else
{ 
addButton.setEnabled(true);
okButton.setEnabled(true);
} 

} 

private List getSelectedChoices()
    { 
List result = new ArrayList();
for (int index : selectedList.getSelectedIndices()) //1
{ 
result.add(selectedList.getModel().getElementAt(index));
} 

return result;
} 

public UMLAddDialog(final List theChoices, final List preselected,
                        final String theTitle, final ListCellRenderer renderer,
                        final boolean multiselectAllowed, final boolean isExclusive)
    { 
multiSelectAllowed = multiselectAllowed;
if(theChoices == null)//1
{ 
throw new IllegalArgumentException(
                "There should always be choices in UMLAddDialog");
} 

exclusive = isExclusive;
List choices = new ArrayList(theChoices);
if(isExclusive && preselected != null && !preselected.isEmpty())//1
{ 
choices.removeAll(preselected);
} 

if(theTitle != null)//1
{ 
title = theTitle;
} 
else
{ 
title = "";
} 

setLayout(new BorderLayout());
JPanel upperPanel = new JPanel();
JPanel panelChoices = new JPanel(new BorderLayout());
JPanel panelSelected = new JPanel(new BorderLayout());
choicesList = new JList(constructListModel(choices));
choicesList.setMinimumSize(new Dimension(150, 300));
if(renderer != null)//1
{ 
choicesList.setCellRenderer(renderer);
} 

if(multiselectAllowed)//1
{ 
choicesList.setSelectionMode(
                ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
} 
else
{ 
choicesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
} 

choicesList.setVisibleRowCount(15);
JScrollPane choicesScroll = new JScrollPane(choicesList);
panelChoices.add(new JLabel(Translator.localize("label.choices")),
                         BorderLayout.NORTH);
panelChoices.add(choicesScroll, BorderLayout.CENTER);
addButton = new JButton(ResourceLoaderWrapper
                                .lookupIconResource("NavigateForward"));
addButton.addActionListener(this);
removeButton = new JButton(ResourceLoaderWrapper
                                   .lookupIconResource("NavigateBack"));
removeButton.addActionListener(this);
Box buttonBox = Box.createVerticalBox();
buttonBox.add(addButton);
buttonBox.add(Box.createRigidArea(new Dimension(0, 5)));
buttonBox.add(removeButton);
selectedList = new JList(constructListModel(preselected));
selectedList.setMinimumSize(new Dimension(150, 300));
if(renderer != null)//2
{ 
selectedList.setCellRenderer(renderer);
} 

selectedList
        .setSelectionMode(
            ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
selectedList.setVisibleRowCount(15);
JScrollPane selectedScroll = new JScrollPane(selectedList);
panelSelected.add(new JLabel(Translator.localize("label.selected")),
                          BorderLayout.NORTH);
panelSelected.add(selectedScroll, BorderLayout.CENTER);
upperPanel.add(panelChoices);
upperPanel.add(Box.createRigidArea(new Dimension(5, 0)));
upperPanel.add(buttonBox);
upperPanel.add(Box.createRigidArea(new Dimension(5, 0)));
upperPanel.add(panelSelected);
add(upperPanel, BorderLayout.NORTH);
JPanel okCancelPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
okButton = new JButton(Translator.localize("button.ok"));
okButton.addActionListener(this);
cancelButton = new JButton(Translator.localize("button.cancel"));
cancelButton.addActionListener(this);
okCancelPanel.add(okButton);
okCancelPanel.add(cancelButton);
okCancelPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
add(okCancelPanel, BorderLayout.SOUTH);
setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
update();
} 

private void ok()
    { 
if(dialog != null)//1
{ 
dialog.setVisible(false);
returnValue = JOptionPane.OK_OPTION;
} 

} 

public Vector getSelected()
    { 
Vector result = new Vector();
ListModel list = selectedList.getModel();
for (int i = 0; i < list.getSize(); i++) //1
{ 
result.add(list.getElementAt(i));
} 

return result;
} 

protected AbstractListModel constructListModel(List list)
    { 
SortedListModel model = new SortedListModel();
if(list != null)//1
{ 
model.addAll(list);
} 

return model;
} 

private List getChoices()
    { 
List result = new ArrayList();
for (int index : choicesList.getSelectedIndices()) //1
{ 
result.add(choicesList.getModel().getElementAt(index));
} 

return result;
} 

private void removeSelection()
    { 
List theChoices = getSelectedChoices();
((SortedListModel) selectedList.getModel()).removeAll(theChoices);
if(exclusive)//1
{ 
((SortedListModel) choicesList.getModel()).addAll(theChoices);
} 

} 

public void actionPerformed(ActionEvent e)
    { 
Object source = e.getSource();
if(source.equals(addButton))//1
{ 
addSelection();
update();
} 

if(source.equals(removeButton))//1
{ 
removeSelection();
update();
} 

if(source.equals(okButton))//1
{ 
ok();
} 

if(source.equals(cancelButton))//1
{ 
cancel();
} 

} 

private void addSelection()
    { 
List theChoices = getChoices();
if(exclusive)//1
{ 
((SortedListModel) choicesList.getModel()).removeAll(theChoices);
} 

((SortedListModel) selectedList.getModel()).addAll(theChoices);
} 

 } 


