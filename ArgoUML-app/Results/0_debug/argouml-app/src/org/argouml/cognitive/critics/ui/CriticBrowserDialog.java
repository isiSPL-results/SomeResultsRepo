
//#if 1763300312 
// Compilation Unit of /CriticBrowserDialog.java 
 

//#if 170283173 
package org.argouml.cognitive.critics.ui;
//#endif 


//#if -1825864462 
import java.awt.BorderLayout;
//#endif 


//#if 1732058696 
import java.awt.Dimension;
//#endif 


//#if -654251792 
import java.awt.FlowLayout;
//#endif 


//#if -1901422732 
import java.awt.GridBagConstraints;
//#endif 


//#if -121552318 
import java.awt.GridBagLayout;
//#endif 


//#if 769225266 
import java.awt.Insets;
//#endif 


//#if -1854037698 
import java.awt.event.ActionEvent;
//#endif 


//#if -1606920054 
import java.awt.event.ActionListener;
//#endif 


//#if -1409959397 
import java.awt.event.ItemEvent;
//#endif 


//#if -569526643 
import java.awt.event.ItemListener;
//#endif 


//#if 992066607 
import java.util.Observable;
//#endif 


//#if 1292655292 
import java.util.Observer;
//#endif 


//#if -312091154 
import javax.swing.BorderFactory;
//#endif 


//#if -676469392 
import javax.swing.JButton;
//#endif 


//#if 934388453 
import javax.swing.JComboBox;
//#endif 


//#if -1694213952 
import javax.swing.JLabel;
//#endif 


//#if -1579339856 
import javax.swing.JPanel;
//#endif 


//#if -1079106131 
import javax.swing.JScrollPane;
//#endif 


//#if 1671067784 
import javax.swing.JTextArea;
//#endif 


//#if 398339719 
import javax.swing.JTextField;
//#endif 


//#if -2056770527 
import javax.swing.event.DocumentEvent;
//#endif 


//#if 1798356679 
import javax.swing.event.DocumentListener;
//#endif 


//#if -1863978518 
import javax.swing.event.ListSelectionEvent;
//#endif 


//#if -1401145250 
import javax.swing.event.ListSelectionListener;
//#endif 


//#if -391236159 
import javax.swing.event.TableModelEvent;
//#endif 


//#if -24456921 
import javax.swing.event.TableModelListener;
//#endif 


//#if 1093102576 
import javax.swing.text.Document;
//#endif 


//#if 117187018 
import org.apache.log4j.Logger;
//#endif 


//#if -1666404147 
import org.argouml.cognitive.Critic;
//#endif 


//#if 362951624 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 378188007 
import org.argouml.cognitive.Translator;
//#endif 


//#if -345857452 
import org.argouml.util.ArgoDialog;
//#endif 


//#if 1681081100 
import org.argouml.util.osdep.StartBrowser;
//#endif 


//#if -1939446330 
import org.tigris.swidgets.BorderSplitPane;
//#endif 


//#if -843099471 
public class CriticBrowserDialog extends 
//#if 669007945 
ArgoDialog
//#endif 

 implements 
//#if 2147203538 
ActionListener
//#endif 

, 
//#if -941173862 
ListSelectionListener
//#endif 

, 
//#if 1698241455 
ItemListener
//#endif 

, 
//#if -39369289 
DocumentListener
//#endif 

, 
//#if -341376361 
TableModelListener
//#endif 

, 
//#if 1248539038 
Observer
//#endif 

  { 

//#if 821014734 
private static final Logger LOG =
        Logger.getLogger(CriticBrowserDialog.class);
//#endif 


//#if -1772697324 
private static int numCriticBrowser = 0;
//#endif 


//#if -1169855267 
private static final int NUM_COLUMNS = 25;
//#endif 


//#if 1489453184 
private static final String HIGH =
        Translator.localize("misc.level.high");
//#endif 


//#if -339518240 
private static final String MEDIUM =
        Translator.localize("misc.level.medium");
//#endif 


//#if 276576540 
private static final String LOW =
        Translator.localize("misc.level.low");
//#endif 


//#if 168641123 
private static final String[] PRIORITIES = {
        HIGH, MEDIUM, LOW,
    };
//#endif 


//#if -194754901 
private static final String ALWAYS =
        Translator.localize("dialog.browse.use-clarifier.always");
//#endif 


//#if 1232505219 
private static final String IF_ONLY_ONE =
        Translator.localize("dialog.browse.use-clarifier.if-only-one");
//#endif 


//#if -679579869 
private static final String NEVER =
        Translator.localize("dialog.browse.use-clarifier.never");
//#endif 


//#if -1381186334 
private static final String[] USE_CLAR = {
        ALWAYS, IF_ONLY_ONE, NEVER,
    };
//#endif 


//#if 644062105 
private static final int INSET_PX = 3;
//#endif 


//#if 1078270986 
private JLabel criticsLabel   = new JLabel(
        Translator.localize("dialog.browse.label.critics"));
//#endif 


//#if 796889456 
private JLabel clsNameLabel   = new JLabel(
        Translator.localize("dialog.browse.label.critic-class"));
//#endif 


//#if 917429532 
private JLabel headlineLabel  = new JLabel(
        Translator.localize("dialog.browse.label.headline"));
//#endif 


//#if 276158236 
private JLabel priorityLabel  = new JLabel(
        Translator.localize("dialog.browse.label.priority"));
//#endif 


//#if 615881151 
private JLabel moreInfoLabel  = new JLabel(
        Translator.localize("dialog.browse.label.more-info"));
//#endif 


//#if 371379203 
private JLabel descLabel      = new JLabel(
        Translator.localize("dialog.browse.label.description"));
//#endif 


//#if 956678660 
private JLabel clarifierLabel = new JLabel(
        Translator.localize("dialog.browse.label.use-clarifier"));
//#endif 


//#if -221225607 
private TableCritics table;
//#endif 


//#if -543331929 
private JTextField className = new JTextField("", NUM_COLUMNS);
//#endif 


//#if 22411418 
private JTextField headline = new JTextField("", NUM_COLUMNS);
//#endif 


//#if -1385444440 
private JComboBox priority  = new JComboBox(PRIORITIES);
//#endif 


//#if -1506994030 
private JTextField moreInfo = new JTextField("", NUM_COLUMNS - 4);
//#endif 


//#if -1235584075 
private JTextArea desc      = new JTextArea("", 6, NUM_COLUMNS);
//#endif 


//#if 280506205 
private JComboBox useClar   = new JComboBox(USE_CLAR);
//#endif 


//#if 1920285802 
private JButton wakeButton    = new JButton(
        Translator.localize("dialog.browse.button.wake"));
//#endif 


//#if 1486628628 
private JButton configButton  = new JButton(
        Translator.localize("dialog.browse.button.configure"));
//#endif 


//#if 305546713 
private JButton networkButton = new JButton(
        Translator.localize("dialog.browse.button.edit-network"));
//#endif 


//#if 485802866 
private JButton goButton      = new JButton(
        Translator.localize("dialog.browse.button.go"));
//#endif 


//#if -1370962586 
private JButton advancedButton  = new JButton(
        Translator.localize("dialog.browse.button.advanced"));
//#endif 


//#if 122713019 
private Critic target;
//#endif 


//#if 72189902 
private void addListeners()
    { 

//#if -508720805 
goButton.addActionListener(this);
//#endif 


//#if 912526177 
networkButton.addActionListener(this);
//#endif 


//#if -856437089 
wakeButton.addActionListener(this);
//#endif 


//#if -681030815 
advancedButton.addActionListener(this);
//#endif 


//#if 1117924033 
configButton.addActionListener(this);
//#endif 


//#if 750353880 
headline.getDocument().addDocumentListener(this);
//#endif 


//#if -1116471575 
moreInfo.getDocument().addDocumentListener(this);
//#endif 


//#if -2122685765 
desc.getDocument().addDocumentListener(this);
//#endif 


//#if 601497460 
priority.addItemListener(this);
//#endif 


//#if 125415299 
useClar.addItemListener(this);
//#endif 

} 

//#endif 


//#if -434874078 
public void insertUpdate(DocumentEvent e)
    { 

//#if 263522779 
LOG.debug(getClass().getName() + " insert");
//#endif 


//#if 869443524 
Document hDoc = headline.getDocument();
//#endif 


//#if -1587640507 
Document miDoc = moreInfo.getDocument();
//#endif 


//#if 630887019 
Document dDoc = desc.getDocument();
//#endif 


//#if 826256777 
if(e.getDocument() == hDoc)//1
{ 

//#if -1421127573 
setTargetHeadline();
//#endif 

} 

//#endif 


//#if 345274195 
if(e.getDocument() == miDoc)//1
{ 

//#if 131665351 
setTargetMoreInfo();
//#endif 

} 

//#endif 


//#if -1850017267 
if(e.getDocument() == dDoc)//1
{ 

//#if 1633860187 
setTargetDesc();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 259871917 
public void removeUpdate(DocumentEvent e)
    { 

//#if -252655006 
insertUpdate(e);
//#endif 

} 

//#endif 


//#if 1229486060 
public void update(Observable o, Object arg)
    { 

//#if 1836045015 
table.repaint();
//#endif 

} 

//#endif 


//#if 795784328 
private void setTargetMoreInfo()
    { 

//#if -773069304 
if(target == null)//1
{ 

//#if -994034313 
return;
//#endif 

} 

//#endif 


//#if 771476597 
String mi = moreInfo.getText();
//#endif 


//#if 175045330 
target.setMoreInfoURL(mi);
//#endif 

} 

//#endif 


//#if -1075658762 
private void setTargetDesc()
    { 

//#if -1552001706 
if(target == null)//1
{ 

//#if 813883705 
return;
//#endif 

} 

//#endif 


//#if -559280011 
String d = desc.getText();
//#endif 


//#if -1018170096 
target.setDescription(d);
//#endif 

} 

//#endif 


//#if -1074816903 
private void setTargetHeadline()
    { 

//#if 1901206565 
if(target == null)//1
{ 

//#if -504269353 
return;
//#endif 

} 

//#endif 


//#if -513290587 
String h = headline.getText();
//#endif 


//#if -1121796303 
target.setHeadline(h);
//#endif 

} 

//#endif 


//#if -1423955490 
public void itemStateChanged(ItemEvent e)
    { 

//#if -1686912306 
Object src = e.getSource();
//#endif 


//#if -1460262167 
if(src == priority)//1
{ 

//#if 2120904200 
setTargetPriority();
//#endif 

} 
else

//#if 479587490 
if(src == useClar)//1
{ 

//#if 1644172527 
setTargetUseClarifiers();
//#endif 

} 
else
{ 

//#if 1157264817 
LOG.debug("unknown itemStateChanged src: " + src);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -445226666 
private void enableFieldsAndButtons()
    { 

//#if -1737410851 
className.setEditable(false);
//#endif 


//#if -618716220 
headline.setEditable(false);
//#endif 


//#if -1653333621 
priority.setEnabled(false);
//#endif 


//#if -2062462591 
desc.setEditable(false);
//#endif 


//#if -1198851565 
moreInfo.setEditable(false);
//#endif 


//#if -2115148491 
goButton.setEnabled(false);
//#endif 


//#if -1257964871 
wakeButton.setEnabled(false);
//#endif 


//#if -306118502 
advancedButton.setEnabled(true);
//#endif 


//#if -511409755 
networkButton.setEnabled(false);
//#endif 


//#if 2081445275 
configButton.setEnabled(false);
//#endif 


//#if 393223209 
useClar.setSelectedItem(null);
//#endif 


//#if 1573303879 
useClar.repaint();
//#endif 

} 

//#endif 


//#if -182577289 
public void valueChanged(ListSelectionEvent lse)
    { 

//#if 46151002 
if(lse.getValueIsAdjusting())//1
{ 

//#if -1371899587 
return;
//#endif 

} 

//#endif 


//#if 592807343 
Object src = lse.getSource();
//#endif 


//#if 1818648457 
if(src != table.getSelectionModel())//1
{ 

//#if -1150081417 
LOG.debug("src = " + src);
//#endif 


//#if -696351707 
return;
//#endif 

} 

//#endif 


//#if -199939143 
LOG.debug("got valueChanged from " + src);
//#endif 


//#if 1752917853 
int row = table.getSelectedRow();
//#endif 


//#if -590226625 
if(this.target != null)//1
{ 

//#if 1710278293 
this.target.deleteObserver(this);
//#endif 

} 

//#endif 


//#if -1027197800 
setTarget((row == -1) ? null : table.getCriticAtRow(row));
//#endif 


//#if 154800914 
if(this.target != null)//2
{ 

//#if -1966365646 
this.target.addObserver(this);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -845462331 
public void actionPerformed(ActionEvent e)
    { 

//#if 555510391 
super.actionPerformed(e);
//#endif 


//#if 1344313967 
if(e.getSource() == goButton)//1
{ 

//#if 567172384 
StartBrowser.openUrl(moreInfo.getText());
//#endif 


//#if -722788491 
return;
//#endif 

} 

//#endif 


//#if -1359244037 
if(e.getSource() == networkButton)//1
{ 

//#if -715988011 
LOG.debug("TODO: network!");
//#endif 


//#if -825603440 
return;
//#endif 

} 

//#endif 


//#if 1827391945 
if(e.getSource() == configButton)//1
{ 

//#if 1567469707 
LOG.debug("TODO: config!");
//#endif 


//#if 807445382 
return;
//#endif 

} 

//#endif 


//#if 1742613739 
if(e.getSource() == wakeButton)//1
{ 

//#if -1674978702 
target.unsnooze();
//#endif 


//#if -685093888 
target.setEnabled(true);
//#endif 


//#if 1837092515 
table.repaint();
//#endif 


//#if 1981100919 
return;
//#endif 

} 

//#endif 


//#if -1560772759 
if(e.getSource() == advancedButton)//1
{ 

//#if -1636478877 
table.setAdvanced(true);
//#endif 


//#if -1842466041 
advancedButton.setEnabled(false);
//#endif 

} 

//#endif 


//#if -160172287 
LOG.debug("unknown src in CriticBrowserDialog: " + e.getSource());
//#endif 

} 

//#endif 


//#if -838231130 
public void tableChanged(TableModelEvent e)
    { 

//#if 1269654841 
updateButtonsEnabled();
//#endif 


//#if -1751198617 
table.repaint();
//#endif 

} 

//#endif 


//#if 1140667608 
private void setTargetUseClarifiers()
    { 

//#if -1170602333 
LOG.debug("setting clarifier usage rule");
//#endif 

} 

//#endif 


//#if 2028130377 
private void setTargetPriority()
    { 

//#if 1791473792 
if(target == null)//1
{ 

//#if -2002608446 
return;
//#endif 

} 

//#endif 


//#if 788263559 
String p = (String) priority.getSelectedItem();
//#endif 


//#if 481403551 
if(p == null)//1
{ 

//#if -1176505499 
return;
//#endif 

} 

//#endif 


//#if -989366090 
if(p.equals(PRIORITIES[0]))//1
{ 

//#if 1182722695 
target.setPriority(ToDoItem.HIGH_PRIORITY);
//#endif 

} 

//#endif 


//#if -101862409 
if(p.equals(PRIORITIES[1]))//1
{ 

//#if -791759569 
target.setPriority(ToDoItem.MED_PRIORITY);
//#endif 

} 

//#endif 


//#if 785641272 
if(p.equals(PRIORITIES[2]))//1
{ 

//#if -34460989 
target.setPriority(ToDoItem.LOW_PRIORITY);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -2118148126 
private void setTarget(Critic cr)
    { 

//#if 403956761 
if(cr == null)//1
{ 

//#if -809466095 
enableFieldsAndButtons();
//#endif 


//#if 870970617 
className.setText("");
//#endif 


//#if 549128450 
headline.setText("");
//#endif 


//#if 1700775800 
priority.setSelectedItem(null);
//#endif 


//#if 433692694 
priority.repaint();
//#endif 


//#if 1029381523 
moreInfo.setText("");
//#endif 


//#if -536581659 
desc.setText("");
//#endif 


//#if 392694952 
return;
//#endif 

} 

//#endif 


//#if -2138559967 
updateButtonsEnabled();
//#endif 


//#if 1192315508 
className.setText(cr.getClass().getName());
//#endif 


//#if 1205809985 
headline.setText(cr.getHeadline());
//#endif 


//#if 261429203 
int p = cr.getPriority();
//#endif 


//#if 1930772713 
if(p == ToDoItem.HIGH_PRIORITY)//1
{ 

//#if 140410874 
priority.setSelectedItem(HIGH);
//#endif 

} 
else

//#if -1812269757 
if(p == ToDoItem.MED_PRIORITY)//1
{ 

//#if -1584494153 
priority.setSelectedItem(MEDIUM);
//#endif 

} 
else
{ 

//#if -224375793 
priority.setSelectedItem(LOW);
//#endif 

} 

//#endif 


//#endif 


//#if -1717471991 
priority.repaint();
//#endif 


//#if 540564628 
moreInfo.setText(cr.getMoreInfoURL());
//#endif 


//#if -1110979380 
desc.setText(cr.getDescriptionTemplate());
//#endif 


//#if 123134993 
desc.setCaretPosition(0);
//#endif 


//#if 1101117846 
useClar.setSelectedItem(ALWAYS);
//#endif 


//#if 303261164 
useClar.repaint();
//#endif 

} 

//#endif 


//#if -1218407885 
public void changedUpdate(DocumentEvent e)
    { 

//#if 1884740680 
LOG.debug(getClass().getName() + " changed");
//#endif 

} 

//#endif 


//#if 452042220 
public CriticBrowserDialog()
    { 

//#if 91815834 
super(Translator.localize("dialog.browse.label.critics"), false);
//#endif 


//#if 66217700 
JPanel mainContent = new JPanel();
//#endif 


//#if 1917967960 
mainContent.setLayout(new BorderLayout(10, 10));
//#endif 


//#if -1734278563 
BorderSplitPane bsp = new BorderSplitPane();
//#endif 


//#if -74444739 
JPanel tablePanel = new JPanel(new BorderLayout(5, 5));
//#endif 


//#if -1224120887 
table = new TableCritics(new TableModelCritics(false), this, this);
//#endif 


//#if 418071742 
criticsLabel.setText(criticsLabel.getText() + " ("
                             + table.getModel().getRowCount() + ")");
//#endif 


//#if 1970000676 
tablePanel.add(criticsLabel, BorderLayout.NORTH);
//#endif 


//#if 497250587 
JScrollPane tableSP = new JScrollPane(table);
//#endif 


//#if -442177684 
tablePanel.add(tableSP, BorderLayout.CENTER);
//#endif 


//#if -1586528198 
tableSP.setPreferredSize(table.getInitialSize());
//#endif 


//#if 805244114 
bsp.add(tablePanel, BorderSplitPane.CENTER);
//#endif 


//#if 755828161 
JPanel detailsPanel = new JPanel(new GridBagLayout());
//#endif 


//#if -85724480 
detailsPanel.setBorder(BorderFactory.createTitledBorder(
                                   Translator.localize(
                                       "dialog.browse.titled-border.critic-details")));
//#endif 


//#if -182519200 
GridBagConstraints labelConstraints = new GridBagConstraints();
//#endif 


//#if -1127593907 
labelConstraints.anchor = GridBagConstraints.EAST;
//#endif 


//#if 1986463355 
labelConstraints.fill = GridBagConstraints.BOTH;
//#endif 


//#if 1081649332 
labelConstraints.gridy = 0;
//#endif 


//#if 1081619541 
labelConstraints.gridx = 0;
//#endif 


//#if 833384934 
labelConstraints.gridwidth = 1;
//#endif 


//#if -1497109765 
labelConstraints.gridheight = 1;
//#endif 


//#if -1302092296 
labelConstraints.insets = new Insets(0, 10, 5, 4);
//#endif 


//#if -917237402 
GridBagConstraints fieldConstraints = new GridBagConstraints();
//#endif 


//#if 1581504277 
fieldConstraints.anchor = GridBagConstraints.WEST;
//#endif 


//#if 1157980981 
fieldConstraints.fill = GridBagConstraints.BOTH;
//#endif 


//#if 785943482 
fieldConstraints.gridy = 0;
//#endif 


//#if 785913722 
fieldConstraints.gridx = 1;
//#endif 


//#if 1471636010 
fieldConstraints.gridwidth = 3;
//#endif 


//#if 1108802485 
fieldConstraints.gridheight = 1;
//#endif 


//#if 1320518314 
fieldConstraints.weightx = 1.0;
//#endif 


//#if -210795600 
fieldConstraints.insets = new Insets(0, 4, 5, 10);
//#endif 


//#if -1256355253 
className.setBorder(null);
//#endif 


//#if -1724325602 
labelConstraints.gridy = 0;
//#endif 


//#if -2119378856 
fieldConstraints.gridy = 0;
//#endif 


//#if -470271653 
detailsPanel.add(clsNameLabel, labelConstraints);
//#endif 


//#if -1471998691 
detailsPanel.add(className, fieldConstraints);
//#endif 


//#if 1081649363 
labelConstraints.gridy = 1;
//#endif 


//#if 785943513 
fieldConstraints.gridy = 1;
//#endif 


//#if -92294682 
detailsPanel.add(headlineLabel, labelConstraints);
//#endif 


//#if -1498148032 
detailsPanel.add(headline, fieldConstraints);
//#endif 


//#if 1081649394 
labelConstraints.gridy = 2;
//#endif 


//#if 785943544 
fieldConstraints.gridy = 2;
//#endif 


//#if 460074422 
detailsPanel.add(priorityLabel, labelConstraints);
//#endif 


//#if -1606584976 
detailsPanel.add(priority, fieldConstraints);
//#endif 


//#if 1081649425 
labelConstraints.gridy = 3;
//#endif 


//#if 785943575 
fieldConstraints.gridy = 3;
//#endif 


//#if -160839499 
detailsPanel.add(moreInfoLabel, labelConstraints);
//#endif 


//#if -452820848 
JPanel moreInfoPanel =
            new JPanel(new GridBagLayout());
//#endif 


//#if -2144440044 
GridBagConstraints gridConstraints = new GridBagConstraints();
//#endif 


//#if 919292879 
gridConstraints.anchor = GridBagConstraints.WEST;
//#endif 


//#if 607316961 
gridConstraints.gridx = 0;
//#endif 


//#if 607346752 
gridConstraints.gridy = 0;
//#endif 


//#if -1176065102 
gridConstraints.weightx = 100;
//#endif 


//#if 880197231 
gridConstraints.fill = GridBagConstraints.BOTH;
//#endif 


//#if -1125398683 
gridConstraints.insets = new Insets(0, 0, 5, 0);
//#endif 


//#if -1730949830 
moreInfoPanel.add(moreInfo, gridConstraints);
//#endif 


//#if 902550337 
gridConstraints.anchor = GridBagConstraints.EAST;
//#endif 


//#if 607316992 
gridConstraints.gridx = 1;
//#endif 


//#if 891273624 
gridConstraints.fill = GridBagConstraints.NONE;
//#endif 


//#if 220773352 
gridConstraints.insets = new Insets(0, 10, 5, 0);
//#endif 


//#if 651289427 
gridConstraints.weightx = 0;
//#endif 


//#if 731702801 
moreInfoPanel.add(goButton, gridConstraints);
//#endif 


//#if -398616779 
moreInfoPanel.setMinimumSize(new Dimension(priority.getWidth(),
                                     priority.getHeight()));
//#endif 


//#if 694131551 
detailsPanel.add(moreInfoPanel, fieldConstraints);
//#endif 


//#if 1081649456 
labelConstraints.gridy = 4;
//#endif 


//#if 785943606 
fieldConstraints.gridy = 4;
//#endif 


//#if 1349207047 
fieldConstraints.weighty = 3.0;
//#endif 


//#if 1985209098 
labelConstraints.anchor = GridBagConstraints.NORTHEAST;
//#endif 


//#if -2045682013 
detailsPanel.add(descLabel, labelConstraints);
//#endif 


//#if 1079874245 
detailsPanel.add(new JScrollPane(desc), fieldConstraints);
//#endif 


//#if -1012967816 
desc.setLineWrap(true);
//#endif 


//#if -1458809687 
desc.setWrapStyleWord(true);
//#endif 


//#if -748684663 
desc.setMargin(new Insets(INSET_PX, INSET_PX, INSET_PX, INSET_PX));
//#endif 


//#if -1210814747 
labelConstraints.anchor = GridBagConstraints.EAST;
//#endif 


//#if 1081649487 
labelConstraints.gridy = 5;
//#endif 


//#if 785943637 
fieldConstraints.gridy = 5;
//#endif 


//#if 484084908 
fieldConstraints.weighty = 0;
//#endif 


//#if 809975941 
detailsPanel.add(clarifierLabel, labelConstraints);
//#endif 


//#if -1107957377 
detailsPanel.add(useClar, fieldConstraints);
//#endif 


//#if 1081649518 
labelConstraints.gridy = 6;
//#endif 


//#if 785943668 
fieldConstraints.gridy = 6;
//#endif 


//#if -910322880 
JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//#endif 


//#if -1316738120 
buttonPanel.add(wakeButton);
//#endif 


//#if 1443175478 
buttonPanel.add(advancedButton);
//#endif 


//#if 2077629787 
detailsPanel.add(new JLabel(""), labelConstraints);
//#endif 


//#if -29366930 
detailsPanel.add(buttonPanel, fieldConstraints);
//#endif 


//#if -1829774738 
bsp.add(detailsPanel, BorderSplitPane.EAST);
//#endif 


//#if 961507865 
this.addListeners();
//#endif 


//#if -463220079 
this.enableFieldsAndButtons();
//#endif 


//#if 650037423 
mainContent.add(bsp);
//#endif 


//#if -358395438 
setResizable(true);
//#endif 


//#if 2124062446 
setContent(mainContent);
//#endif 


//#if -1221857568 
numCriticBrowser++;
//#endif 

} 

//#endif 


//#if -1870518908 
protected void updateButtonsEnabled()
    { 

//#if 542671572 
this.configButton.setEnabled(false);
//#endif 


//#if 1990357425 
this.goButton.setEnabled(this.target != null
                                 && this.target.getMoreInfoURL() != null
                                 && this.target.getMoreInfoURL().length() > 0);
//#endif 


//#if -968754292 
this.networkButton.setEnabled(false);
//#endif 


//#if -742184944 
this.wakeButton.setEnabled(this.target != null
                                   && (this.target.isSnoozed()
                                       || !this.target.isEnabled()));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

