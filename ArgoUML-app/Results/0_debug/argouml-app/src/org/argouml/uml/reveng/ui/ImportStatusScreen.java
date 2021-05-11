
//#if 384459450 
// Compilation Unit of /ImportStatusScreen.java 
 

//#if 1037447947 
package org.argouml.uml.reveng.ui;
//#endif 


//#if 873974196 
import java.awt.BorderLayout;
//#endif 


//#if -1785666293 
import java.awt.Container;
//#endif 


//#if -1516576570 
import java.awt.Dimension;
//#endif 


//#if 1711629855 
import java.awt.Frame;
//#endif 


//#if 214745782 
import java.awt.GridBagConstraints;
//#endif 


//#if 1969067456 
import java.awt.GridBagLayout;
//#endif 


//#if 565924654 
import java.awt.Toolkit;
//#endif 


//#if -123206212 
import java.awt.event.ActionEvent;
//#endif 


//#if 511490892 
import java.awt.event.ActionListener;
//#endif 


//#if 1548857334 
import java.awt.event.WindowEvent;
//#endif 


//#if -74109230 
import java.awt.event.WindowListener;
//#endif 


//#if 1695052466 
import javax.swing.JButton;
//#endif 


//#if -1186242724 
import javax.swing.JDialog;
//#endif 


//#if -647881922 
import javax.swing.JLabel;
//#endif 


//#if -533007826 
import javax.swing.JPanel;
//#endif 


//#if 1507615884 
import javax.swing.JProgressBar;
//#endif 


//#if -694402577 
import javax.swing.JScrollPane;
//#endif 


//#if 75939146 
import javax.swing.JTextArea;
//#endif 


//#if -1163585577 
import javax.swing.SwingConstants;
//#endif 


//#if 1102555516 
import javax.swing.SwingUtilities;
//#endif 


//#if -625436103 
import org.argouml.i18n.Translator;
//#endif 


//#if 498707182 
import org.argouml.taskmgmt.ProgressEvent;
//#endif 


//#if 1909352686 
import org.argouml.taskmgmt.ProgressMonitor;
//#endif 


//#if 1713522668 
public class ImportStatusScreen extends 
//#if 1531009767 
JDialog
//#endif 

 implements 
//#if 369474050 
ProgressMonitor
//#endif 

, 
//#if 1835813519 
WindowListener
//#endif 

  { 

//#if 616058635 
private JButton cancelButton;
//#endif 


//#if -129620522 
private JLabel progressLabel;
//#endif 


//#if -2034077702 
private JProgressBar progress;
//#endif 


//#if -1249281517 
private JTextArea messageArea;
//#endif 


//#if -524557281 
private boolean hasMessages = false;
//#endif 


//#if -878693812 
private boolean canceled = false;
//#endif 


//#if 553867122 
private static final long serialVersionUID = -1336242911879462274L;
//#endif 


//#if 938781187 
public void updateProgress(final int i)
    { 

//#if 252367337 
SwingUtilities.invokeLater(new Runnable () {
            public void run() {
                progress.setValue(i);
                if (isComplete()) {
                    if (hasMessages) {
                        cancelButton.setText(
                            Translator.localize("button.close"));
                    } else {
                        close();
                    }
                }
            }
        });
//#endif 

} 

//#endif 


//#if 971987281 
public void close()
    { 

//#if 1026393789 
SwingUtilities.invokeLater(new Runnable () {
            public void run() {
                setVisible(false);
                dispose();
            }
        });
//#endif 

} 

//#endif 


//#if -599548573 
public void windowClosing(WindowEvent e)
    { 

//#if -87951638 
canceled = true;
//#endif 


//#if 1629220323 
close();
//#endif 

} 

//#endif 


//#if -902581388 
public ImportStatusScreen(Frame frame, String title, String iconName)
    { 

//#if 1980665410 
super(frame, true);
//#endif 


//#if 757393262 
if(title != null)//1
{ 

//#if -94446294 
setTitle(title);
//#endif 

} 

//#endif 


//#if -1817814517 
Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
//#endif 


//#if -1609382503 
getContentPane().setLayout(new BorderLayout(4, 4));
//#endif 


//#if -1859325039 
Container panel = new JPanel(new GridBagLayout());
//#endif 


//#if -878688420 
progressLabel = new JLabel();
//#endif 


//#if -255219457 
progressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
//#endif 


//#if 1701147365 
GridBagConstraints gbc = new GridBagConstraints();
//#endif 


//#if -2113801212 
gbc.anchor = GridBagConstraints.NORTH;
//#endif 


//#if 2063841723 
gbc.fill = GridBagConstraints.HORIZONTAL;
//#endif 


//#if 565094519 
gbc.gridwidth = GridBagConstraints.REMAINDER;
//#endif 


//#if 1588944766 
gbc.gridheight = 1;
//#endif 


//#if 1379580402 
gbc.gridx = 0;
//#endif 


//#if 1379610193 
gbc.gridy = 0;
//#endif 


//#if -465138303 
gbc.weightx = 0.1;
//#endif 


//#if 1547317486 
panel.add(progressLabel, gbc);
//#endif 


//#if 1379592740 
gbc.gridy++;
//#endif 


//#if 757886808 
progress = new JProgressBar();
//#endif 


//#if 1729045560 
gbc.anchor = GridBagConstraints.CENTER;
//#endif 


//#if -1123107262 
panel.add(progress, gbc);
//#endif 


//#if 905308590 
gbc.gridy++;
//#endif 


//#if 1397831208 
panel.add(
            new JLabel(Translator.localize("label.import-messages")), gbc);
//#endif 


//#if 905308591 
gbc.gridy++;
//#endif 


//#if -1685898923 
messageArea = new JTextArea(10, 50);
//#endif 


//#if -436508935 
gbc.weighty = 0.8;
//#endif 


//#if 1809650942 
gbc.fill = GridBagConstraints.BOTH;
//#endif 


//#if 2139389189 
panel.add(new JScrollPane(messageArea), gbc);
//#endif 


//#if 905308592 
gbc.gridy++;
//#endif 


//#if 1847681673 
cancelButton = new JButton(Translator.localize("button.cancel"));
//#endif 


//#if 1820727335 
gbc.fill = GridBagConstraints.NONE;
//#endif 


//#if -1970566084 
gbc.anchor = GridBagConstraints.SOUTH;
//#endif 


//#if -436509152 
gbc.weighty = 0.1;
//#endif 


//#if -1026427620 
gbc.gridheight = GridBagConstraints.REMAINDER;
//#endif 


//#if -306537567 
panel.add(cancelButton, gbc);
//#endif 


//#if 905308593 
gbc.gridy++;
//#endif 


//#if 1516032988 
cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (isComplete()) {
                    close();
                }
                canceled = true;
            }

        });
//#endif 


//#if -1954811869 
getContentPane().add(panel);
//#endif 


//#if 1659037451 
pack();
//#endif 


//#if -632830441 
Dimension contentPaneSize = getContentPane().getPreferredSize();
//#endif 


//#if -295868965 
setLocation(scrSize.width / 2 - contentPaneSize.width / 2,
                    scrSize.height / 2 - contentPaneSize.height / 2);
//#endif 


//#if 724379209 
setResizable(true);
//#endif 


//#if 1624886540 
setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//#endif 


//#if 1072591849 
addWindowListener(this);
//#endif 

} 

//#endif 


//#if -982447377 
public void notifyNullAction()
    { 

//#if -1070601519 
String msg = Translator.localize("label.import.empty");
//#endif 


//#if -344899122 
notifyMessage(msg, msg, msg);
//#endif 

} 

//#endif 


//#if 2000523399 
public void windowOpened(WindowEvent e) { 
} 

//#endif 


//#if -1253556704 
public void updateSubTask(final String action)
    { 

//#if 1341178425 
SwingUtilities.invokeLater(new Runnable () {
            public void run() {
                progressLabel.setText(action);
            }
        });
//#endif 

} 

//#endif 


//#if -1790314530 
public void windowDeactivated(WindowEvent e) { 
} 

//#endif 


//#if 1403100344 
public boolean isCanceled()
    { 

//#if -1876601547 
return canceled;
//#endif 

} 

//#endif 


//#if -1800201931 
public void notifyMessage(final String title, final String introduction,
                              final String message)
    { 

//#if -1836181501 
hasMessages = true;
//#endif 


//#if 633357761 
messageArea.setText(messageArea.getText() + title + "\n" + introduction
                            + "\n" + message + "\n\n");
//#endif 


//#if -676105234 
messageArea.setCaretPosition(messageArea.getText().length());
//#endif 

} 

//#endif 


//#if 459615952 
public void updateMainTask(final String name)
    { 

//#if 788921640 
SwingUtilities.invokeLater(new Runnable () {
            public void run() {
                setTitle(name);
            }
        });
//#endif 

} 

//#endif 


//#if 2056935267 
public void progress(ProgressEvent event) throws InterruptedException
    { 
} 

//#endif 


//#if -150958176 
public void windowIconified(WindowEvent e) { 
} 

//#endif 


//#if 468258815 
public void windowDeiconified(WindowEvent e) { 
} 

//#endif 


//#if 434486606 
public void setMaximumProgress(final int i)
    { 

//#if -996991561 
SwingUtilities.invokeLater(new Runnable () {
            public void run() {
                progress.setMaximum(i);
                setVisible(true);
            }
        });
//#endif 

} 

//#endif 


//#if -1509808054 
public void windowClosed(WindowEvent e) { 
} 

//#endif 


//#if 1885435775 
public void windowActivated(WindowEvent e) { 
} 

//#endif 


//#if -532944972 
private boolean isComplete()
    { 

//#if -921774719 
return progress.getValue() == progress.getMaximum();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

