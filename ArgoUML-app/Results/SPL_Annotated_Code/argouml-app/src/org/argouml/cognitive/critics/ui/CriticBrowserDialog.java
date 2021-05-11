// Compilation Unit of /CriticBrowserDialog.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.critics.ui;
//#endif 


//#if COGNITIVE 
import java.awt.BorderLayout;
//#endif 


//#if COGNITIVE 
import java.awt.Dimension;
//#endif 


//#if COGNITIVE 
import java.awt.FlowLayout;
//#endif 


//#if COGNITIVE 
import java.awt.GridBagConstraints;
//#endif 


//#if COGNITIVE 
import java.awt.GridBagLayout;
//#endif 


//#if COGNITIVE 
import java.awt.Insets;
//#endif 


//#if COGNITIVE 
import java.awt.event.ActionEvent;
//#endif 


//#if COGNITIVE 
import java.awt.event.ActionListener;
//#endif 


//#if COGNITIVE 
import java.awt.event.ItemEvent;
//#endif 


//#if COGNITIVE 
import java.awt.event.ItemListener;
//#endif 


//#if COGNITIVE 
import java.util.Observable;
//#endif 


//#if COGNITIVE 
import java.util.Observer;
//#endif 


//#if COGNITIVE 
import javax.swing.BorderFactory;
//#endif 


//#if COGNITIVE 
import javax.swing.JButton;
//#endif 


//#if COGNITIVE 
import javax.swing.JComboBox;
//#endif 


//#if COGNITIVE 
import javax.swing.JLabel;
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
import javax.swing.event.DocumentEvent;
//#endif 


//#if COGNITIVE 
import javax.swing.event.DocumentListener;
//#endif 


//#if COGNITIVE 
import javax.swing.event.ListSelectionEvent;
//#endif 


//#if COGNITIVE 
import javax.swing.event.ListSelectionListener;
//#endif 


//#if COGNITIVE 
import javax.swing.event.TableModelEvent;
//#endif 


//#if COGNITIVE 
import javax.swing.event.TableModelListener;
//#endif 


//#if COGNITIVE 
import javax.swing.text.Document;
//#endif 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Critic;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Translator;
//#endif 


//#if COGNITIVE 
import org.argouml.util.ArgoDialog;
//#endif 


//#if COGNITIVE 
import org.argouml.util.osdep.StartBrowser;
//#endif 


//#if COGNITIVE 
import org.tigris.swidgets.BorderSplitPane;
//#endif 


//#if COGNITIVE 
public class CriticBrowserDialog extends ArgoDialog
 implements ActionListener
, ListSelectionListener
, ItemListener
, DocumentListener
, TableModelListener
, Observer
  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG =
        Logger.getLogger(CriticBrowserDialog.class);
//#endif 

private static int numCriticBrowser = 0;
private static final int NUM_COLUMNS = 25;
private static final String HIGH =
        Translator.localize("misc.level.high");
private static final String MEDIUM =
        Translator.localize("misc.level.medium");
private static final String LOW =
        Translator.localize("misc.level.low");
private static final String[] PRIORITIES = {
        HIGH, MEDIUM, LOW,
    };
private static final String ALWAYS =
        Translator.localize("dialog.browse.use-clarifier.always");
private static final String IF_ONLY_ONE =
        Translator.localize("dialog.browse.use-clarifier.if-only-one");
private static final String NEVER =
        Translator.localize("dialog.browse.use-clarifier.never");
private static final String[] USE_CLAR = {
        ALWAYS, IF_ONLY_ONE, NEVER,
    };
private static final int INSET_PX = 3;
private JLabel criticsLabel   = new JLabel(
        Translator.localize("dialog.browse.label.critics"));
private JLabel clsNameLabel   = new JLabel(
        Translator.localize("dialog.browse.label.critic-class"));
private JLabel headlineLabel  = new JLabel(
        Translator.localize("dialog.browse.label.headline"));
private JLabel priorityLabel  = new JLabel(
        Translator.localize("dialog.browse.label.priority"));
private JLabel moreInfoLabel  = new JLabel(
        Translator.localize("dialog.browse.label.more-info"));
private JLabel descLabel      = new JLabel(
        Translator.localize("dialog.browse.label.description"));
private JLabel clarifierLabel = new JLabel(
        Translator.localize("dialog.browse.label.use-clarifier"));
private TableCritics table;
private JTextField className = new JTextField("", NUM_COLUMNS);
private JTextField headline = new JTextField("", NUM_COLUMNS);
private JComboBox priority  = new JComboBox(PRIORITIES);
private JTextField moreInfo = new JTextField("", NUM_COLUMNS - 4);
private JTextArea desc      = new JTextArea("", 6, NUM_COLUMNS);
private JComboBox useClar   = new JComboBox(USE_CLAR);
private JButton wakeButton    = new JButton(
        Translator.localize("dialog.browse.button.wake"));
private JButton configButton  = new JButton(
        Translator.localize("dialog.browse.button.configure"));
private JButton networkButton = new JButton(
        Translator.localize("dialog.browse.button.edit-network"));
private JButton goButton      = new JButton(
        Translator.localize("dialog.browse.button.go"));
private JButton advancedButton  = new JButton(
        Translator.localize("dialog.browse.button.advanced"));
private Critic target;
private void addListeners()
    { 
goButton.addActionListener(this);
networkButton.addActionListener(this);
wakeButton.addActionListener(this);
advancedButton.addActionListener(this);
configButton.addActionListener(this);
headline.getDocument().addDocumentListener(this);
moreInfo.getDocument().addDocumentListener(this);
desc.getDocument().addDocumentListener(this);
priority.addItemListener(this);
useClar.addItemListener(this);
} 

public void insertUpdate(DocumentEvent e)
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug(getClass().getName() + " insert");
//#endif 

Document hDoc = headline.getDocument();
Document miDoc = moreInfo.getDocument();
Document dDoc = desc.getDocument();
if(e.getDocument() == hDoc)//1
{ 
setTargetHeadline();
} 

if(e.getDocument() == miDoc)//1
{ 
setTargetMoreInfo();
} 

if(e.getDocument() == dDoc)//1
{ 
setTargetDesc();
} 

} 

public void removeUpdate(DocumentEvent e)
    { 
insertUpdate(e);
} 

public void update(Observable o, Object arg)
    { 
table.repaint();
} 

private void setTargetMoreInfo()
    { 
if(target == null)//1
{ 
return;
} 

String mi = moreInfo.getText();
target.setMoreInfoURL(mi);
} 

private void setTargetDesc()
    { 
if(target == null)//1
{ 
return;
} 

String d = desc.getText();
target.setDescription(d);
} 

private void setTargetHeadline()
    { 
if(target == null)//1
{ 
return;
} 

String h = headline.getText();
target.setHeadline(h);
} 

public void itemStateChanged(ItemEvent e)
    { 
Object src = e.getSource();
if(src == priority)//1
{ 
setTargetPriority();
} 
else

//#if COGNITIVE 
if(src == useClar)//1
{ 
setTargetUseClarifiers();
} 
else
{ 
LOG.debug("unknown itemStateChanged src: " + src);
} 

//#endif 


} 

private void enableFieldsAndButtons()
    { 
className.setEditable(false);
headline.setEditable(false);
priority.setEnabled(false);
desc.setEditable(false);
moreInfo.setEditable(false);
goButton.setEnabled(false);
wakeButton.setEnabled(false);
advancedButton.setEnabled(true);
networkButton.setEnabled(false);
configButton.setEnabled(false);
useClar.setSelectedItem(null);
useClar.repaint();
} 

public void valueChanged(ListSelectionEvent lse)
    { 
if(lse.getValueIsAdjusting())//1
{ 
return;
} 

Object src = lse.getSource();
if(src != table.getSelectionModel())//1
{ 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("src = " + src);
//#endif 

return;
} 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("got valueChanged from " + src);
//#endif 

int row = table.getSelectedRow();
if(this.target != null)//1
{ 
this.target.deleteObserver(this);
} 

setTarget((row == -1) ? null : table.getCriticAtRow(row));
if(this.target != null)//2
{ 
this.target.addObserver(this);
} 

} 

public void actionPerformed(ActionEvent e)
    { 
super.actionPerformed(e);
if(e.getSource() == goButton)//1
{ 
StartBrowser.openUrl(moreInfo.getText());
return;
} 

if(e.getSource() == networkButton)//1
{ 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("TODO: network!");
//#endif 

return;
} 

if(e.getSource() == configButton)//1
{ 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("TODO: config!");
//#endif 

return;
} 

if(e.getSource() == wakeButton)//1
{ 
target.unsnooze();
target.setEnabled(true);
table.repaint();
return;
} 

if(e.getSource() == advancedButton)//1
{ 
table.setAdvanced(true);
advancedButton.setEnabled(false);
} 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("unknown src in CriticBrowserDialog: " + e.getSource());
//#endif 

} 

public void tableChanged(TableModelEvent e)
    { 
updateButtonsEnabled();
table.repaint();
} 

private void setTargetUseClarifiers()
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("setting clarifier usage rule");
//#endif 

} 

private void setTargetPriority()
    { 
if(target == null)//1
{ 
return;
} 

String p = (String) priority.getSelectedItem();
if(p == null)//1
{ 
return;
} 

if(p.equals(PRIORITIES[0]))//1
{ 
target.setPriority(ToDoItem.HIGH_PRIORITY);
} 

if(p.equals(PRIORITIES[1]))//1
{ 
target.setPriority(ToDoItem.MED_PRIORITY);
} 

if(p.equals(PRIORITIES[2]))//1
{ 
target.setPriority(ToDoItem.LOW_PRIORITY);
} 

} 

private void setTarget(Critic cr)
    { 
if(cr == null)//1
{ 
enableFieldsAndButtons();
className.setText("");
headline.setText("");
priority.setSelectedItem(null);
priority.repaint();
moreInfo.setText("");
desc.setText("");
return;
} 

updateButtonsEnabled();
className.setText(cr.getClass().getName());
headline.setText(cr.getHeadline());
int p = cr.getPriority();
if(p == ToDoItem.HIGH_PRIORITY)//1
{ 
priority.setSelectedItem(HIGH);
} 
else

//#if COGNITIVE 
if(p == ToDoItem.MED_PRIORITY)//1
{ 
priority.setSelectedItem(MEDIUM);
} 
else
{ 
priority.setSelectedItem(LOW);
} 

//#endif 


priority.repaint();
moreInfo.setText(cr.getMoreInfoURL());
desc.setText(cr.getDescriptionTemplate());
desc.setCaretPosition(0);
useClar.setSelectedItem(ALWAYS);
useClar.repaint();
} 

public void changedUpdate(DocumentEvent e)
    { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug(getClass().getName() + " changed");
//#endif 

} 

public CriticBrowserDialog()
    { 
super(Translator.localize("dialog.browse.label.critics"), false);
JPanel mainContent = new JPanel();
mainContent.setLayout(new BorderLayout(10, 10));
BorderSplitPane bsp = new BorderSplitPane();
JPanel tablePanel = new JPanel(new BorderLayout(5, 5));
table = new TableCritics(new TableModelCritics(false), this, this);
criticsLabel.setText(criticsLabel.getText() + " ("
                             + table.getModel().getRowCount() + ")");
tablePanel.add(criticsLabel, BorderLayout.NORTH);
JScrollPane tableSP = new JScrollPane(table);
tablePanel.add(tableSP, BorderLayout.CENTER);
tableSP.setPreferredSize(table.getInitialSize());
bsp.add(tablePanel, BorderSplitPane.CENTER);
JPanel detailsPanel = new JPanel(new GridBagLayout());
detailsPanel.setBorder(BorderFactory.createTitledBorder(
                                   Translator.localize(
                                       "dialog.browse.titled-border.critic-details")));
GridBagConstraints labelConstraints = new GridBagConstraints();
labelConstraints.anchor = GridBagConstraints.EAST;
labelConstraints.fill = GridBagConstraints.BOTH;
labelConstraints.gridy = 0;
labelConstraints.gridx = 0;
labelConstraints.gridwidth = 1;
labelConstraints.gridheight = 1;
labelConstraints.insets = new Insets(0, 10, 5, 4);
GridBagConstraints fieldConstraints = new GridBagConstraints();
fieldConstraints.anchor = GridBagConstraints.WEST;
fieldConstraints.fill = GridBagConstraints.BOTH;
fieldConstraints.gridy = 0;
fieldConstraints.gridx = 1;
fieldConstraints.gridwidth = 3;
fieldConstraints.gridheight = 1;
fieldConstraints.weightx = 1.0;
fieldConstraints.insets = new Insets(0, 4, 5, 10);
className.setBorder(null);
labelConstraints.gridy = 0;
fieldConstraints.gridy = 0;
detailsPanel.add(clsNameLabel, labelConstraints);
detailsPanel.add(className, fieldConstraints);
labelConstraints.gridy = 1;
fieldConstraints.gridy = 1;
detailsPanel.add(headlineLabel, labelConstraints);
detailsPanel.add(headline, fieldConstraints);
labelConstraints.gridy = 2;
fieldConstraints.gridy = 2;
detailsPanel.add(priorityLabel, labelConstraints);
detailsPanel.add(priority, fieldConstraints);
labelConstraints.gridy = 3;
fieldConstraints.gridy = 3;
detailsPanel.add(moreInfoLabel, labelConstraints);
JPanel moreInfoPanel =
            new JPanel(new GridBagLayout());
GridBagConstraints gridConstraints = new GridBagConstraints();
gridConstraints.anchor = GridBagConstraints.WEST;
gridConstraints.gridx = 0;
gridConstraints.gridy = 0;
gridConstraints.weightx = 100;
gridConstraints.fill = GridBagConstraints.BOTH;
gridConstraints.insets = new Insets(0, 0, 5, 0);
moreInfoPanel.add(moreInfo, gridConstraints);
gridConstraints.anchor = GridBagConstraints.EAST;
gridConstraints.gridx = 1;
gridConstraints.fill = GridBagConstraints.NONE;
gridConstraints.insets = new Insets(0, 10, 5, 0);
gridConstraints.weightx = 0;
moreInfoPanel.add(goButton, gridConstraints);
moreInfoPanel.setMinimumSize(new Dimension(priority.getWidth(),
                                     priority.getHeight()));
detailsPanel.add(moreInfoPanel, fieldConstraints);
labelConstraints.gridy = 4;
fieldConstraints.gridy = 4;
fieldConstraints.weighty = 3.0;
labelConstraints.anchor = GridBagConstraints.NORTHEAST;
detailsPanel.add(descLabel, labelConstraints);
detailsPanel.add(new JScrollPane(desc), fieldConstraints);
desc.setLineWrap(true);
desc.setWrapStyleWord(true);
desc.setMargin(new Insets(INSET_PX, INSET_PX, INSET_PX, INSET_PX));
labelConstraints.anchor = GridBagConstraints.EAST;
labelConstraints.gridy = 5;
fieldConstraints.gridy = 5;
fieldConstraints.weighty = 0;
detailsPanel.add(clarifierLabel, labelConstraints);
detailsPanel.add(useClar, fieldConstraints);
labelConstraints.gridy = 6;
fieldConstraints.gridy = 6;
JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
buttonPanel.add(wakeButton);
buttonPanel.add(advancedButton);
detailsPanel.add(new JLabel(""), labelConstraints);
detailsPanel.add(buttonPanel, fieldConstraints);
bsp.add(detailsPanel, BorderSplitPane.EAST);
this.addListeners();
this.enableFieldsAndButtons();
mainContent.add(bsp);
setResizable(true);
setContent(mainContent);
numCriticBrowser++;
} 

protected void updateButtonsEnabled()
    { 
this.configButton.setEnabled(false);
this.goButton.setEnabled(this.target != null
                                 && this.target.getMoreInfoURL() != null
                                 && this.target.getMoreInfoURL().length() > 0);
this.networkButton.setEnabled(false);
this.wakeButton.setEnabled(this.target != null
                                   && (this.target.isSnoozed()
                                       || !this.target.isEnabled()));
} 

 } 

//#endif 


