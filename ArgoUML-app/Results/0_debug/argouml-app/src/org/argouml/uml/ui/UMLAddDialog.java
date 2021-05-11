
//#if -1067544672 
// Compilation Unit of /UMLAddDialog.java 
 

//#if -1016154829 
package org.argouml.uml.ui;
//#endif 


//#if -817297385 
import java.awt.BorderLayout;
//#endif 


//#if 335296652 
import java.awt.Component;
//#endif 


//#if 927988104 
import java.awt.Container;
//#endif 


//#if 1197077827 
import java.awt.Dimension;
//#endif 


//#if -58789547 
import java.awt.FlowLayout;
//#endif 


//#if 282345756 
import java.awt.Frame;
//#endif 


//#if 696077625 
import java.awt.event.ActionEvent;
//#endif 


//#if -502864209 
import java.awt.event.ActionListener;
//#endif 


//#if -2133098274 
import java.awt.event.WindowAdapter;
//#endif 


//#if -1926826125 
import java.awt.event.WindowEvent;
//#endif 


//#if 778672434 
import java.util.ArrayList;
//#endif 


//#if -1747900945 
import java.util.List;
//#endif 


//#if -244732566 
import java.util.Vector;
//#endif 


//#if -879447800 
import javax.swing.AbstractListModel;
//#endif 


//#if 185812627 
import javax.swing.BorderFactory;
//#endif 


//#if -1537418970 
import javax.swing.Box;
//#endif 


//#if -81007147 
import javax.swing.JButton;
//#endif 


//#if 1332664959 
import javax.swing.JDialog;
//#endif 


//#if 2065772475 
import javax.swing.JLabel;
//#endif 


//#if 205440233 
import javax.swing.JList;
//#endif 


//#if -637691158 
import javax.swing.JOptionPane;
//#endif 


//#if -2114320725 
import javax.swing.JPanel;
//#endif 


//#if 1786213266 
import javax.swing.JScrollPane;
//#endif 


//#if 2017004290 
import javax.swing.ListCellRenderer;
//#endif 


//#if 1284791622 
import javax.swing.ListModel;
//#endif 


//#if 407745098 
import javax.swing.ListSelectionModel;
//#endif 


//#if 1921839353 
import javax.swing.SwingUtilities;
//#endif 


//#if 794587442 
import javax.swing.WindowConstants;
//#endif 


//#if 1910002203 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -997440932 
import org.argouml.i18n.Translator;
//#endif 


//#if 603581812 
import org.argouml.uml.util.SortedListModel;
//#endif 


//#if 583091707 
public class UMLAddDialog extends 
//#if 378769792 
JPanel
//#endif 

 implements 
//#if 751677648 
ActionListener
//#endif 

  { 

//#if 937891324 
private JList choicesList = null;
//#endif 


//#if -1107594917 
private JList selectedList = null;
//#endif 


//#if -641862741 
private JButton addButton = null;
//#endif 


//#if 382994668 
private JButton removeButton = null;
//#endif 


//#if -399621692 
private JButton okButton = null;
//#endif 


//#if -2134639134 
private JButton cancelButton = null;
//#endif 


//#if -1437222860 
private JDialog dialog = null;
//#endif 


//#if -652897791 
private String title = null;
//#endif 


//#if -969137225 
private boolean multiSelectAllowed = false;
//#endif 


//#if 225238380 
private int returnValue;
//#endif 


//#if 1613995144 
private boolean exclusive;
//#endif 


//#if 1640753961 
public UMLAddDialog(final List theChoices, final List preselected,
                        final String theTitle, final boolean multiselectAllowed,
                        final boolean isExclusive)
    { 

//#if 1231220224 
this(theChoices, preselected, theTitle, new UMLListCellRenderer2(true),
             multiselectAllowed, isExclusive);
//#endif 

} 

//#endif 


//#if 615413676 
private void cancel()
    { 

//#if 430481955 
if(dialog != null)//1
{ 

//#if -559126579 
dialog.setVisible(false);
//#endif 


//#if -1634069190 
returnValue = JOptionPane.CANCEL_OPTION;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -856351771 
public int showDialog(Component parent)
    { 

//#if -1091098646 
Frame frame = parent instanceof Frame ? (Frame) parent
                      : (Frame) SwingUtilities
                      .getAncestorOfClass(Frame.class, parent);
//#endif 


//#if 690711084 
dialog = new JDialog(frame, title, true);
//#endif 


//#if 1426502414 
Container contentPane = dialog.getContentPane();
//#endif 


//#if -1600473912 
contentPane.setLayout(new BorderLayout());
//#endif 


//#if -177775171 
contentPane.add(this, BorderLayout.CENTER);
//#endif 


//#if -991274795 
dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//#endif 


//#if -1288895022 
dialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                cancel();
            }
        });
//#endif 


//#if -501598029 
dialog.pack();
//#endif 


//#if -1014700300 
dialog.setLocationRelativeTo(parent);
//#endif 


//#if 1010091338 
dialog.setVisible(true);
//#endif 


//#if -1007380446 
return returnValue;
//#endif 

} 

//#endif 


//#if 2061183547 
private void update()
    { 

//#if -1345264954 
if(choicesList.getModel().getSize() == 0)//1
{ 

//#if 2041652356 
addButton.setEnabled(false);
//#endif 

} 
else
{ 

//#if 2015832602 
addButton.setEnabled(true);
//#endif 

} 

//#endif 


//#if -2084952485 
if(selectedList.getModel().getSize() == 0)//1
{ 

//#if 930815874 
removeButton.setEnabled(false);
//#endif 

} 
else
{ 

//#if 1593489102 
removeButton.setEnabled(true);
//#endif 

} 

//#endif 


//#if -1614828180 
if(selectedList.getModel().getSize() > 1 && !multiSelectAllowed)//1
{ 

//#if -96615627 
addButton.setEnabled(false);
//#endif 


//#if -1689083074 
okButton.setEnabled(false);
//#endif 

} 
else
{ 

//#if -1127477935 
addButton.setEnabled(true);
//#endif 


//#if -970119514 
okButton.setEnabled(true);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1074851261 
private List getSelectedChoices()
    { 

//#if 122150154 
List result = new ArrayList();
//#endif 


//#if 1637188869 
for (int index : selectedList.getSelectedIndices()) //1
{ 

//#if -1597164555 
result.add(selectedList.getModel().getElementAt(index));
//#endif 

} 

//#endif 


//#if -1000927611 
return result;
//#endif 

} 

//#endif 


//#if 652292505 
public UMLAddDialog(final List theChoices, final List preselected,
                        final String theTitle, final ListCellRenderer renderer,
                        final boolean multiselectAllowed, final boolean isExclusive)
    { 

//#if 188219371 
multiSelectAllowed = multiselectAllowed;
//#endif 


//#if -1255171666 
if(theChoices == null)//1
{ 

//#if -1268285583 
throw new IllegalArgumentException(
                "There should always be choices in UMLAddDialog");
//#endif 

} 

//#endif 


//#if -1711775917 
exclusive = isExclusive;
//#endif 


//#if 595039950 
List choices = new ArrayList(theChoices);
//#endif 


//#if -1398676922 
if(isExclusive && preselected != null && !preselected.isEmpty())//1
{ 

//#if -924733223 
choices.removeAll(preselected);
//#endif 

} 

//#endif 


//#if 750034288 
if(theTitle != null)//1
{ 

//#if -696709750 
title = theTitle;
//#endif 

} 
else
{ 

//#if 1764613698 
title = "";
//#endif 

} 

//#endif 


//#if -409841856 
setLayout(new BorderLayout());
//#endif 


//#if -2016140012 
JPanel upperPanel = new JPanel();
//#endif 


//#if 1945100947 
JPanel panelChoices = new JPanel(new BorderLayout());
//#endif 


//#if 1108261206 
JPanel panelSelected = new JPanel(new BorderLayout());
//#endif 


//#if 1210771799 
choicesList = new JList(constructListModel(choices));
//#endif 


//#if -1404538950 
choicesList.setMinimumSize(new Dimension(150, 300));
//#endif 


//#if 850332364 
if(renderer != null)//1
{ 

//#if -1382522824 
choicesList.setCellRenderer(renderer);
//#endif 

} 

//#endif 


//#if 1424199545 
if(multiselectAllowed)//1
{ 

//#if 590230709 
choicesList.setSelectionMode(
                ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//#endif 

} 
else
{ 

//#if -1333887297 
choicesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//#endif 

} 

//#endif 


//#if -487807474 
choicesList.setVisibleRowCount(15);
//#endif 


//#if 576777321 
JScrollPane choicesScroll = new JScrollPane(choicesList);
//#endif 


//#if 5833442 
panelChoices.add(new JLabel(Translator.localize("label.choices")),
                         BorderLayout.NORTH);
//#endif 


//#if 1808518648 
panelChoices.add(choicesScroll, BorderLayout.CENTER);
//#endif 


//#if -293714719 
addButton = new JButton(ResourceLoaderWrapper
                                .lookupIconResource("NavigateForward"));
//#endif 


//#if -1627790027 
addButton.addActionListener(this);
//#endif 


//#if -228818694 
removeButton = new JButton(ResourceLoaderWrapper
                                   .lookupIconResource("NavigateBack"));
//#endif 


//#if -621505480 
removeButton.addActionListener(this);
//#endif 


//#if 1566496870 
Box buttonBox = Box.createVerticalBox();
//#endif 


//#if -290279044 
buttonBox.add(addButton);
//#endif 


//#if 1076281825 
buttonBox.add(Box.createRigidArea(new Dimension(0, 5)));
//#endif 


//#if 848592721 
buttonBox.add(removeButton);
//#endif 


//#if 1541810632 
selectedList = new JList(constructListModel(preselected));
//#endif 


//#if -1682404233 
selectedList.setMinimumSize(new Dimension(150, 300));
//#endif 


//#if 534420581 
if(renderer != null)//2
{ 

//#if 1676403492 
selectedList.setCellRenderer(renderer);
//#endif 

} 

//#endif 


//#if -1043295021 
selectedList
        .setSelectionMode(
            ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//#endif 


//#if -165656847 
selectedList.setVisibleRowCount(15);
//#endif 


//#if 1361056689 
JScrollPane selectedScroll = new JScrollPane(selectedList);
//#endif 


//#if -889679596 
panelSelected.add(new JLabel(Translator.localize("label.selected")),
                          BorderLayout.NORTH);
//#endif 


//#if -952999426 
panelSelected.add(selectedScroll, BorderLayout.CENTER);
//#endif 


//#if 957248870 
upperPanel.add(panelChoices);
//#endif 


//#if 304344830 
upperPanel.add(Box.createRigidArea(new Dimension(5, 0)));
//#endif 


//#if 833424005 
upperPanel.add(buttonBox);
//#endif 


//#if 60915348 
upperPanel.add(Box.createRigidArea(new Dimension(5, 0)));
//#endif 


//#if 1713072011 
upperPanel.add(panelSelected);
//#endif 


//#if 1495814325 
add(upperPanel, BorderLayout.NORTH);
//#endif 


//#if 958425505 
JPanel okCancelPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//#endif 


//#if -1324176060 
okButton = new JButton(Translator.localize("button.ok"));
//#endif 


//#if -28650144 
okButton.addActionListener(this);
//#endif 


//#if 227532672 
cancelButton = new JButton(Translator.localize("button.cancel"));
//#endif 


//#if -897835134 
cancelButton.addActionListener(this);
//#endif 


//#if -1605399788 
okCancelPanel.add(okButton);
//#endif 


//#if 1010070450 
okCancelPanel.add(cancelButton);
//#endif 


//#if 1230400214 
okCancelPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
//#endif 


//#if 242964793 
add(okCancelPanel, BorderLayout.SOUTH);
//#endif 


//#if 103344783 
setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
//#endif 


//#if 506018436 
update();
//#endif 

} 

//#endif 


//#if -1132656882 
private void ok()
    { 

//#if 1308224052 
if(dialog != null)//1
{ 

//#if -1197676607 
dialog.setVisible(false);
//#endif 


//#if 2046452136 
returnValue = JOptionPane.OK_OPTION;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 926041056 
public Vector getSelected()
    { 

//#if 1902062563 
Vector result = new Vector();
//#endif 


//#if 1172239639 
ListModel list = selectedList.getModel();
//#endif 


//#if 1789319503 
for (int i = 0; i < list.getSize(); i++) //1
{ 

//#if -724689693 
result.add(list.getElementAt(i));
//#endif 

} 

//#endif 


//#if 1662661629 
return result;
//#endif 

} 

//#endif 


//#if -160363398 
protected AbstractListModel constructListModel(List list)
    { 

//#if -757937861 
SortedListModel model = new SortedListModel();
//#endif 


//#if 252587555 
if(list != null)//1
{ 

//#if 414643303 
model.addAll(list);
//#endif 

} 

//#endif 


//#if -367981005 
return model;
//#endif 

} 

//#endif 


//#if 1040217880 
private List getChoices()
    { 

//#if -1392821774 
List result = new ArrayList();
//#endif 


//#if 196983460 
for (int index : choicesList.getSelectedIndices()) //1
{ 

//#if -1138314317 
result.add(choicesList.getModel().getElementAt(index));
//#endif 

} 

//#endif 


//#if -320415587 
return result;
//#endif 

} 

//#endif 


//#if -1360415528 
private void removeSelection()
    { 

//#if 926683660 
List theChoices = getSelectedChoices();
//#endif 


//#if 2062903200 
((SortedListModel) selectedList.getModel()).removeAll(theChoices);
//#endif 


//#if 1097504684 
if(exclusive)//1
{ 

//#if 840345449 
((SortedListModel) choicesList.getModel()).addAll(theChoices);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 694847367 
public void actionPerformed(ActionEvent e)
    { 

//#if -2113173304 
Object source = e.getSource();
//#endif 


//#if 1170579634 
if(source.equals(addButton))//1
{ 

//#if 928159907 
addSelection();
//#endif 


//#if -1444599803 
update();
//#endif 

} 

//#endif 


//#if 1972170439 
if(source.equals(removeButton))//1
{ 

//#if 636357233 
removeSelection();
//#endif 


//#if 849580434 
update();
//#endif 

} 

//#endif 


//#if 1404487791 
if(source.equals(okButton))//1
{ 

//#if -2007865462 
ok();
//#endif 

} 

//#endif 


//#if 1475314449 
if(source.equals(cancelButton))//1
{ 

//#if 484085915 
cancel();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -273029603 
private void addSelection()
    { 

//#if -326083838 
List theChoices = getChoices();
//#endif 


//#if -842493411 
if(exclusive)//1
{ 

//#if -598556735 
((SortedListModel) choicesList.getModel()).removeAll(theChoices);
//#endif 

} 

//#endif 


//#if 274887786 
((SortedListModel) selectedList.getModel()).addAll(theChoices);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

