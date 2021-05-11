
//#if -1661361819 
// Compilation Unit of /ProblemsDialog.java 
 

//#if -1320471726 
package org.argouml.uml.reveng.ui;
//#endif 


//#if 200767757 
import java.awt.BorderLayout;
//#endif 


//#if 2000427021 
import java.awt.Dimension;
//#endif 


//#if 1559976166 
import java.awt.Frame;
//#endif 


//#if 855617589 
import java.awt.Toolkit;
//#endif 


//#if 1813841411 
import java.awt.event.ActionEvent;
//#endif 


//#if -83361371 
import java.awt.event.ActionListener;
//#endif 


//#if -1703923928 
import java.awt.event.WindowAdapter;
//#endif 


//#if -809062339 
import java.awt.event.WindowEvent;
//#endif 


//#if -946985909 
import javax.swing.JButton;
//#endif 


//#if 466686197 
import javax.swing.JDialog;
//#endif 


//#if 2130897000 
import javax.swing.JEditorPane;
//#endif 


//#if -1425845627 
import javax.swing.JLabel;
//#endif 


//#if -1310971531 
import javax.swing.JPanel;
//#endif 


//#if 894271240 
import javax.swing.JScrollPane;
//#endif 


//#if -706501934 
import org.argouml.i18n.Translator;
//#endif 


//#if 1071065685 
class ProblemsDialog extends 
//#if -1384638283 
JDialog
//#endif 

 implements 
//#if 132187463 
ActionListener
//#endif 

  { 

//#if -494430145 
private Frame parentFrame;
//#endif 


//#if 492141135 
private JButton abortButton;
//#endif 


//#if 558779532 
private JButton continueButton;
//#endif 


//#if 238970588 
private JLabel northLabel;
//#endif 


//#if -428498648 
private boolean aborted = false;
//#endif 


//#if 2100420263 
private static final long serialVersionUID = -9221358976863603143L;
//#endif 


//#if 1292324836 
public boolean isAborted()
    { 

//#if -421126779 
return aborted;
//#endif 

} 

//#endif 


//#if -1336029616 
ProblemsDialog(Frame frame, String errors)
    { 

//#if -1321587584 
super(frame);
//#endif 


//#if 176107565 
setResizable(true);
//#endif 


//#if -1570940437 
setModal(true);
//#endif 


//#if -188475600 
setTitle(Translator.localize("dialog.title.import-problems"));
//#endif 


//#if -1482438929 
Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
//#endif 


//#if 728511621 
getContentPane().setLayout(new BorderLayout(0, 0));
//#endif 


//#if -662407554 
northLabel =
            new JLabel(Translator.localize("label.import-problems"));
//#endif 


//#if 1165185957 
getContentPane().add(northLabel, BorderLayout.NORTH);
//#endif 


//#if -1204579867 
JEditorPane textArea = new JEditorPane();
//#endif 


//#if -900747496 
textArea.setText(errors);
//#endif 


//#if -1076603519 
JPanel centerPanel = new JPanel(new BorderLayout());
//#endif 


//#if -36923152 
centerPanel.add(new JScrollPane(textArea));
//#endif 


//#if -1570835158 
centerPanel.setPreferredSize(new Dimension(600, 200));
//#endif 


//#if 365997546 
getContentPane().add(centerPanel);
//#endif 


//#if 1188144319 
continueButton = new JButton(Translator.localize("button.continue"));
//#endif 


//#if 418122981 
abortButton = new JButton(Translator.localize("button.abort"));
//#endif 


//#if -100436944 
JPanel bottomPanel = new JPanel();
//#endif 


//#if 1451644665 
bottomPanel.add(continueButton);
//#endif 


//#if 619707558 
bottomPanel.add(abortButton);
//#endif 


//#if 757089553 
getContentPane().add(bottomPanel, BorderLayout.SOUTH);
//#endif 


//#if -1333200839 
continueButton.requestFocusInWindow();
//#endif 


//#if -724793872 
continueButton.addActionListener(this);
//#endif 


//#if -1767612309 
abortButton.addActionListener(this);
//#endif 


//#if -124679818 
addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                disposeDialog();
            }
        });
//#endif 


//#if -1935038737 
pack();
//#endif 


//#if -170338986 
Dimension contentPaneSize = getContentPane().getSize();
//#endif 


//#if -854943297 
setLocation(scrSize.width / 2 - contentPaneSize.width / 2,
                    scrSize.height / 2 - contentPaneSize.height / 2);
//#endif 

} 

//#endif 


//#if 84104944 
public void actionPerformed(ActionEvent e)
    { 

//#if -590043694 
if(e.getSource().equals(abortButton))//1
{ 

//#if 614455435 
aborted = true;
//#endif 

} 

//#endif 


//#if 1128560189 
disposeDialog();
//#endif 

} 

//#endif 


//#if -1580404306 
private void disposeDialog()
    { 

//#if 2028225672 
setVisible(false);
//#endif 


//#if 1039040070 
dispose();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

