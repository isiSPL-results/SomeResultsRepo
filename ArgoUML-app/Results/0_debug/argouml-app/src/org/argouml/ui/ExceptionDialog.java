
//#if 1989390440 
// Compilation Unit of /ExceptionDialog.java 
 

//#if -381636077 
package org.argouml.ui;
//#endif 


//#if 1022540125 
import java.awt.BorderLayout;
//#endif 


//#if -1385088579 
import java.awt.Dimension;
//#endif 


//#if -52112746 
import java.awt.Frame;
//#endif 


//#if 2121367013 
import java.awt.Toolkit;
//#endif 


//#if 1588426675 
import java.awt.event.ActionEvent;
//#endif 


//#if 1915089397 
import java.awt.event.ActionListener;
//#endif 


//#if 715846872 
import java.awt.event.WindowAdapter;
//#endif 


//#if -1034477075 
import java.awt.event.WindowEvent;
//#endif 


//#if 932405387 
import java.io.PrintWriter;
//#endif 


//#if -1957209849 
import java.io.StringWriter;
//#endif 


//#if -2089985447 
import java.util.Date;
//#endif 


//#if 1045882073 
import javax.swing.BorderFactory;
//#endif 


//#if 1476212891 
import javax.swing.JButton;
//#endif 


//#if -1405082299 
import javax.swing.JDialog;
//#endif 


//#if 1580160184 
import javax.swing.JEditorPane;
//#endif 


//#if -516393931 
import javax.swing.JLabel;
//#endif 


//#if -401519835 
import javax.swing.JPanel;
//#endif 


//#if 343534424 
import javax.swing.JScrollPane;
//#endif 


//#if 1565091319 
import javax.swing.event.HyperlinkEvent;
//#endif 


//#if -1778766543 
import javax.swing.event.HyperlinkListener;
//#endif 


//#if 895575842 
import org.argouml.i18n.Translator;
//#endif 


//#if 100982839 
import org.argouml.util.osdep.StartBrowser;
//#endif 


//#if 857677911 
public class ExceptionDialog extends 
//#if -653969547 
JDialog
//#endif 

 implements 
//#if 2144849543 
ActionListener
//#endif 

  { 

//#if 864909255 
private JButton closeButton;
//#endif 


//#if -733603394 
private JButton copyButton;
//#endif 


//#if 1413128220 
private JLabel northLabel;
//#endif 


//#if 805809256 
private JEditorPane textArea;
//#endif 


//#if 794601480 
private static final long serialVersionUID = -2773182347529547418L;
//#endif 


//#if 1169916616 
public static String formatException(String message, Throwable e,
                                         boolean highlightCause)
    { 

//#if -1475341616 
StringWriter sw = new StringWriter();
//#endif 


//#if -1343941491 
PrintWriter pw = new PrintWriter(sw);
//#endif 


//#if -1660262931 
if(highlightCause && e.getCause() != null)//1
{ 

//#if -558728135 
pw.print(message );
//#endif 


//#if 2028993854 
pw.print("<hr>System Info:<p>" + SystemInfoDialog.getInfo());
//#endif 


//#if 2096924894 
pw.print("<p><hr>Error occurred at : " + new Date());
//#endif 


//#if -1639460805 
pw.print("<p>  Cause : ");
//#endif 


//#if -1414088890 
e.getCause().printStackTrace(pw);
//#endif 


//#if 1426307003 
pw.print("-------<p>Full exception : ");
//#endif 

} 

//#endif 


//#if 1402478011 
e.printStackTrace(pw);
//#endif 


//#if 2051264239 
return sw.toString();
//#endif 

} 

//#endif 


//#if 1503648494 
private void disposeDialog()
    { 

//#if 505493538 
setVisible(false);
//#endif 


//#if -1451381792 
dispose();
//#endif 

} 

//#endif 


//#if -374402360 
public ExceptionDialog(Frame f, Throwable e)
    { 

//#if -1429207004 
this(f, Translator.localize("dialog.exception.unknown.error"), e);
//#endif 

} 

//#endif 


//#if -2068079199 
public ExceptionDialog(Frame f, String message, Throwable e,
                           boolean highlightCause)
    { 

//#if -1553750197 
this(f, Translator.localize("dialog.exception.title"),
             Translator.localize("dialog.exception.message"),
             formatException(message, e, highlightCause));
//#endif 

} 

//#endif 


//#if 598434258 
public ExceptionDialog(Frame f, String message, Throwable e)
    { 

//#if -220681120 
this(f, message, e, false);
//#endif 

} 

//#endif 


//#if -1739300549 
private void copyActionPerformed(ActionEvent e)
    { 

//#if 1241183964 
assert e.getSource() == copyButton;
//#endif 


//#if 1971757161 
textArea.setSelectionStart(0);
//#endif 


//#if -530494345 
textArea.setSelectionEnd(textArea.getText().length());
//#endif 


//#if -1275196164 
textArea.copy();
//#endif 


//#if -1018867806 
textArea.setSelectionEnd(0);
//#endif 

} 

//#endif 


//#if 1717925296 
public void actionPerformed(ActionEvent e)
    { 

//#if 1324232240 
disposeDialog();
//#endif 

} 

//#endif 


//#if 75128165 
public ExceptionDialog(Frame f, String title, String intro,
                           String message)
    { 

//#if -1176611342 
super(f);
//#endif 


//#if 1969287462 
setResizable(true);
//#endif 


//#if 1968059889 
setModal(false);
//#endif 


//#if 2130252433 
setTitle(title);
//#endif 


//#if -117817176 
Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
//#endif 


//#if 53001150 
getContentPane().setLayout(new BorderLayout(0, 0));
//#endif 


//#if 1674489867 
northLabel =
            new JLabel(intro);
//#endif 


//#if 52255750 
northLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
//#endif 


//#if -1045473844 
getContentPane().add(northLabel, BorderLayout.NORTH);
//#endif 


//#if -1088263599 
textArea = new JEditorPane();
//#endif 


//#if -645924147 
textArea.setContentType("text/html");
//#endif 


//#if -1517617576 
textArea.setEditable(false);
//#endif 


//#if -1813554976 
textArea.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent hle) {
                linkEvent(hle);
            }
        });
//#endif 


//#if 1511078847 
textArea.setText(message.replaceAll("\n", "<p>"));
//#endif 


//#if -166693537 
textArea.setCaretPosition(0);
//#endif 


//#if 424367866 
JPanel centerPanel = new JPanel(new BorderLayout());
//#endif 


//#if 779538391 
centerPanel.add(new JScrollPane(textArea));
//#endif 


//#if 709985842 
centerPanel.setPreferredSize(new Dimension(500, 200));
//#endif 


//#if 974633937 
getContentPane().add(centerPanel);
//#endif 


//#if 315342017 
copyButton =
            new JButton(Translator.localize("button.copy-to-clipboard"));
//#endif 


//#if 1203445261 
copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });
//#endif 


//#if -1221602548 
closeButton = new JButton(Translator.localize("button.close"));
//#endif 


//#if 895057098 
closeButton.addActionListener(this);
//#endif 


//#if 1616088471 
JPanel bottomPanel = new JPanel();
//#endif 


//#if -200062482 
bottomPanel.add(copyButton);
//#endif 


//#if -246346457 
bottomPanel.add(closeButton);
//#endif 


//#if 946112458 
getContentPane().add(bottomPanel, BorderLayout.SOUTH);
//#endif 


//#if 1579637423 
addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                disposeDialog();
            }
        });
//#endif 


//#if -1187883672 
pack();
//#endif 


//#if 1913968509 
Dimension contentPaneSize = getContentPane().getSize();
//#endif 


//#if 237331768 
setLocation(scrSize.width / 2 - contentPaneSize.width / 2,
                    scrSize.height / 2 - contentPaneSize.height / 2);
//#endif 

} 

//#endif 


//#if 521135002 
private void linkEvent(HyperlinkEvent e)
    { 

//#if -1710724711 
if(e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED))//1
{ 

//#if 2083140604 
StartBrowser.openUrl(e.getURL());
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

