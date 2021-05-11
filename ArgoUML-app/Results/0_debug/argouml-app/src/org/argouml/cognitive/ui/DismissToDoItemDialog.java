
//#if 191768756 
// Compilation Unit of /DismissToDoItemDialog.java 
 

//#if 1452869304 
package org.argouml.cognitive.ui;
//#endif 


//#if -1260208232 
import java.awt.GridBagConstraints;
//#endif 


//#if -99511394 
import java.awt.GridBagLayout;
//#endif 


//#if -1575899050 
import java.awt.Insets;
//#endif 


//#if -447880038 
import java.awt.event.ActionEvent;
//#endif 


//#if 419891118 
import java.awt.event.ActionListener;
//#endif 


//#if -13454589 
import javax.swing.ButtonGroup;
//#endif 


//#if 940292124 
import javax.swing.JLabel;
//#endif 


//#if 1475225385 
import javax.swing.JOptionPane;
//#endif 


//#if 1055166220 
import javax.swing.JPanel;
//#endif 


//#if -410130589 
import javax.swing.JRadioButton;
//#endif 


//#if -395837487 
import javax.swing.JScrollPane;
//#endif 


//#if 9210796 
import javax.swing.JTextArea;
//#endif 


//#if 800455662 
import org.apache.log4j.Logger;
//#endif 


//#if 289574162 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1230411484 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1227954951 
import org.argouml.cognitive.ToDoList;
//#endif 


//#if -1835401405 
import org.argouml.cognitive.Translator;
//#endif 


//#if -364812906 
import org.argouml.cognitive.UnresolvableException;
//#endif 


//#if 295357048 
import org.argouml.util.ArgoDialog;
//#endif 


//#if -326539122 
import org.tigris.swidgets.Dialog;
//#endif 


//#if 1007704196 
public class DismissToDoItemDialog extends 
//#if 1320654074 
ArgoDialog
//#endif 

  { 

//#if 829681390 
private static final Logger LOG =
        Logger.getLogger(DismissToDoItemDialog.class);
//#endif 


//#if 152534238 
private JRadioButton    badGoalButton;
//#endif 


//#if -1192110145 
private JRadioButton    badDecButton;
//#endif 


//#if 330934207 
private JRadioButton    explainButton;
//#endif 


//#if -945593291 
private ButtonGroup     actionGroup;
//#endif 


//#if 2077560956 
private JTextArea       explanation;
//#endif 


//#if -709171737 
private ToDoItem        target;
//#endif 


//#if -1252136417 
public void setTarget(Object t)
    { 

//#if -486462577 
target = (ToDoItem) t;
//#endif 

} 

//#endif 


//#if 2039742474 
public DismissToDoItemDialog()
    { 

//#if 1986445591 
super(
            Translator.localize("dialog.title.dismiss-todo-item"),
            Dialog.OK_CANCEL_OPTION,
            true);
//#endif 


//#if 340365317 
JLabel instrLabel =
            new JLabel(Translator.localize("label.remove-item"));
//#endif 


//#if -41701703 
badGoalButton = new JRadioButton(Translator.localize(
                                             "button.not-relevant-to-my-goals"));
//#endif 


//#if 794607866 
badDecButton = new JRadioButton(Translator.localize(
                                            "button.not-of-concern-at-moment"));
//#endif 


//#if -1382486153 
explainButton = new JRadioButton(Translator.localize(
                                             "button.reason-given-below"));
//#endif 


//#if 847143043 
badGoalButton.setMnemonic(
            Translator.localize(
                "button.not-relevant-to-my-goals.mnemonic")
            .charAt(0));
//#endif 


//#if 519884578 
badDecButton.setMnemonic(
            Translator.localize(
                "button.not-of-concern-at-moment.mnemonic")
            .charAt(0));
//#endif 


//#if 1037571717 
explainButton.setMnemonic(
            Translator.localize("button.reason-given-below.mnemonic").charAt(
                0));
//#endif 


//#if 1280280582 
JPanel content = new JPanel();
//#endif 


//#if -2040854832 
GridBagLayout gb = new GridBagLayout();
//#endif 


//#if -1604954852 
GridBagConstraints c = new GridBagConstraints();
//#endif 


//#if 413192615 
c.fill = GridBagConstraints.BOTH;
//#endif 


//#if -1452942856 
c.weightx = 1.0;
//#endif 


//#if -1301825191 
c.gridwidth = 2;
//#endif 


//#if 1398884230 
content.setLayout(gb);
//#endif 


//#if 1915751036 
explanation = new JTextArea(6, 40);
//#endif 


//#if -1927934171 
explanation.setLineWrap(true);
//#endif 


//#if 2084503580 
explanation.setWrapStyleWord(true);
//#endif 


//#if -1090746497 
JScrollPane explain = new JScrollPane(explanation);
//#endif 


//#if -217823831 
c.gridx = 0;
//#endif 


//#if -217794040 
c.gridy = 0;
//#endif 


//#if -1822502758 
gb.setConstraints(instrLabel, c);
//#endif 


//#if -857820354 
content.add(instrLabel);
//#endif 


//#if -217794009 
c.gridy = 1;
//#endif 


//#if -1482361683 
c.insets = new Insets(5, 0, 0, 0);
//#endif 


//#if 886136202 
gb.setConstraints(badGoalButton, c);
//#endif 


//#if -1122370152 
content.add(badGoalButton);
//#endif 


//#if -217793978 
c.gridy = 2;
//#endif 


//#if 541519553 
gb.setConstraints(badDecButton, c);
//#endif 


//#if -983301019 
content.add(badDecButton);
//#endif 


//#if -217793947 
c.gridy = 3;
//#endif 


//#if -1569899767 
gb.setConstraints(explainButton, c);
//#endif 


//#if 113061591 
content.add(explainButton);
//#endif 


//#if -217793916 
c.gridy = 4;
//#endif 


//#if -1424313705 
c.weighty = 1.0;
//#endif 


//#if 35939127 
gb.setConstraints(explain, c);
//#endif 


//#if -448200123 
content.add(explain);
//#endif 


//#if 1665393634 
setContent(content);
//#endif 


//#if -400041110 
getOkButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (badGoalButton.getModel().isSelected()) {
                    badGoal(e);
                } else if (badDecButton.getModel().isSelected()) {
                    badDec(e);
                } else if (explainButton.getModel().isSelected()) {
                    explain(e);
                }



                else {
                    LOG.warn("DissmissToDoItemDialog: Unknown action: " + e);
                }

            }
        });
//#endif 


//#if -2542635 
getOkButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (badGoalButton.getModel().isSelected()) {
                    badGoal(e);
                } else if (badDecButton.getModel().isSelected()) {
                    badDec(e);
                } else if (explainButton.getModel().isSelected()) {
                    explain(e);
                }







            }
        });
//#endif 


//#if -835054351 
actionGroup = new ButtonGroup();
//#endif 


//#if -1568358648 
actionGroup.add(badGoalButton);
//#endif 


//#if 803427573 
actionGroup.add(badDecButton);
//#endif 


//#if -332926905 
actionGroup.add(explainButton);
//#endif 


//#if 1791737435 
actionGroup.setSelected(explainButton.getModel(), true);
//#endif 


//#if 1772554575 
explanation.setText(
            Translator.localize("label.enter-rationale-here"));
//#endif 


//#if 99745722 
badGoalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                explanation.setEnabled(false);
            }
        });
//#endif 


//#if 1381711557 
badDecButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                explanation.setEnabled(false);
            }
        });
//#endif 


//#if -1210902644 
explainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                explanation.setEnabled(true);
                explanation.requestFocus();
                explanation.selectAll();
            }
        });
//#endif 

} 

//#endif 


//#if 1354010169 
private void explain(ActionEvent e)
    { 

//#if -622550608 
ToDoList list = Designer.theDesigner().getToDoList();
//#endif 


//#if -176061811 
try //1
{ 

//#if 1060373856 
list.explicitlyResolve(target, explanation.getText());
//#endif 


//#if -106762863 
Designer.firePropertyChange(
                Designer.MODEL_TODOITEM_DISMISSED, null, null);
//#endif 

} 

//#if -582037526 
catch (UnresolvableException ure) //1
{ 

//#if 1196605722 
LOG.error("Resolve failed (ure): ", ure);
//#endif 


//#if -1144991833 
JOptionPane.showMessageDialog(
                this,
                ure.getMessage(),
                Translator.localize("optionpane.dismiss-failed"),
                JOptionPane.ERROR_MESSAGE);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -145651654 
private void badGoal(ActionEvent e)
    { 

//#if -684414206 
GoalsDialog d = new GoalsDialog();
//#endif 


//#if 1833593341 
d.setVisible(true);
//#endif 

} 

//#endif 


//#if 35815053 
public void setVisible(boolean b)
    { 

//#if 1066645668 
super.setVisible(b);
//#endif 


//#if -863982380 
if(b)//1
{ 

//#if 492652004 
explanation.requestFocus();
//#endif 


//#if 1677845602 
explanation.selectAll();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1000779397 
private void badDec(ActionEvent e)
    { 

//#if 1389332597 
DesignIssuesDialog d = new DesignIssuesDialog();
//#endif 


//#if 283474700 
d.setVisible(true);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

