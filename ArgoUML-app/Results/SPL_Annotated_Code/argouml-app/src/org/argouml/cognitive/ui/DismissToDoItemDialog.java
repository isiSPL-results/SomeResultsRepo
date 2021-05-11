// Compilation Unit of /DismissToDoItemDialog.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
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
import javax.swing.ButtonGroup;
//#endif 


//#if COGNITIVE 
import javax.swing.JLabel;
//#endif 


//#if COGNITIVE 
import javax.swing.JOptionPane;
//#endif 


//#if COGNITIVE 
import javax.swing.JPanel;
//#endif 


//#if COGNITIVE 
import javax.swing.JRadioButton;
//#endif 


//#if COGNITIVE 
import javax.swing.JScrollPane;
//#endif 


//#if COGNITIVE 
import javax.swing.JTextArea;
//#endif 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Designer;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoList;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Translator;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.UnresolvableException;
//#endif 


//#if COGNITIVE 
import org.argouml.util.ArgoDialog;
//#endif 


//#if COGNITIVE 
import org.tigris.swidgets.Dialog;
//#endif 


//#if COGNITIVE 
public class DismissToDoItemDialog extends ArgoDialog
  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG =
        Logger.getLogger(DismissToDoItemDialog.class);
//#endif 

private JRadioButton    badGoalButton;
private JRadioButton    badDecButton;
private JRadioButton    explainButton;
private ButtonGroup     actionGroup;
private JTextArea       explanation;
private ToDoItem        target;
public void setTarget(Object t)
    { 
target = (ToDoItem) t;
} 

public DismissToDoItemDialog()
    { 
super(
            Translator.localize("dialog.title.dismiss-todo-item"),
            Dialog.OK_CANCEL_OPTION,
            true);
JLabel instrLabel =
            new JLabel(Translator.localize("label.remove-item"));
badGoalButton = new JRadioButton(Translator.localize(
                                             "button.not-relevant-to-my-goals"));
badDecButton = new JRadioButton(Translator.localize(
                                            "button.not-of-concern-at-moment"));
explainButton = new JRadioButton(Translator.localize(
                                             "button.reason-given-below"));
badGoalButton.setMnemonic(
            Translator.localize(
                "button.not-relevant-to-my-goals.mnemonic")
            .charAt(0));
badDecButton.setMnemonic(
            Translator.localize(
                "button.not-of-concern-at-moment.mnemonic")
            .charAt(0));
explainButton.setMnemonic(
            Translator.localize("button.reason-given-below.mnemonic").charAt(
                0));
JPanel content = new JPanel();
GridBagLayout gb = new GridBagLayout();
GridBagConstraints c = new GridBagConstraints();
c.fill = GridBagConstraints.BOTH;
c.weightx = 1.0;
c.gridwidth = 2;
content.setLayout(gb);
explanation = new JTextArea(6, 40);
explanation.setLineWrap(true);
explanation.setWrapStyleWord(true);
JScrollPane explain = new JScrollPane(explanation);
c.gridx = 0;
c.gridy = 0;
gb.setConstraints(instrLabel, c);
content.add(instrLabel);
c.gridy = 1;
c.insets = new Insets(5, 0, 0, 0);
gb.setConstraints(badGoalButton, c);
content.add(badGoalButton);
c.gridy = 2;
gb.setConstraints(badDecButton, c);
content.add(badDecButton);
c.gridy = 3;
gb.setConstraints(explainButton, c);
content.add(explainButton);
c.gridy = 4;
c.weighty = 1.0;
gb.setConstraints(explain, c);
content.add(explain);
setContent(content);

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
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


//#if ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) && ! LOGGING  
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

actionGroup = new ButtonGroup();
actionGroup.add(badGoalButton);
actionGroup.add(badDecButton);
actionGroup.add(explainButton);
actionGroup.setSelected(explainButton.getModel(), true);
explanation.setText(
            Translator.localize("label.enter-rationale-here"));
badGoalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                explanation.setEnabled(false);
            }
        });
badDecButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                explanation.setEnabled(false);
            }
        });
explainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                explanation.setEnabled(true);
                explanation.requestFocus();
                explanation.selectAll();
            }
        });
} 

private void explain(ActionEvent e)
    { 
ToDoList list = Designer.theDesigner().getToDoList();
try //1
{ 
list.explicitlyResolve(target, explanation.getText());
Designer.firePropertyChange(
                Designer.MODEL_TODOITEM_DISMISSED, null, null);
} 

//#if COGNITIVE 
catch (UnresolvableException ure) //1
{ 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.error("Resolve failed (ure): ", ure);
//#endif 

JOptionPane.showMessageDialog(
                this,
                ure.getMessage(),
                Translator.localize("optionpane.dismiss-failed"),
                JOptionPane.ERROR_MESSAGE);
} 

//#endif 


} 

private void badGoal(ActionEvent e)
    { 
GoalsDialog d = new GoalsDialog();
d.setVisible(true);
} 

public void setVisible(boolean b)
    { 
super.setVisible(b);
if(b)//1
{ 
explanation.requestFocus();
explanation.selectAll();
} 

} 

private void badDec(ActionEvent e)
    { 
DesignIssuesDialog d = new DesignIssuesDialog();
d.setVisible(true);
} 

 } 

//#endif 


