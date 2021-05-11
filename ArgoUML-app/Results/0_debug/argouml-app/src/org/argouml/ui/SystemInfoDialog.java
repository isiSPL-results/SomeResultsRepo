
//#if -106924706 
// Compilation Unit of /SystemInfoDialog.java 
 

//#if 346860688 
package org.argouml.ui;
//#endif 


//#if -721349511 
import java.awt.Frame;
//#endif 


//#if 1677397338 
import java.awt.Insets;
//#endif 


//#if 626254579 
import java.awt.datatransfer.Clipboard;
//#endif 


//#if -1521196976 
import java.awt.datatransfer.ClipboardOwner;
//#endif 


//#if -752875986 
import java.awt.datatransfer.StringSelection;
//#endif 


//#if 1463744712 
import java.awt.datatransfer.Transferable;
//#endif 


//#if -1348535018 
import java.awt.event.ActionEvent;
//#endif 


//#if -331919950 
import java.awt.event.ActionListener;
//#endif 


//#if 89173371 
import java.awt.event.WindowAdapter;
//#endif 


//#if 323528528 
import java.awt.event.WindowEvent;
//#endif 


//#if -1614959464 
import javax.swing.JButton;
//#endif 


//#if -558491435 
import javax.swing.JScrollPane;
//#endif 


//#if 1725240752 
import javax.swing.JTextArea;
//#endif 


//#if 862046910 
import org.argouml.application.helpers.ApplicationVersion;
//#endif 


//#if 44076575 
import org.argouml.i18n.Translator;
//#endif 


//#if -1855143556 
import org.argouml.util.ArgoDialog;
//#endif 


//#if -1995973400 
public class SystemInfoDialog extends 
//#if 1738100753 
ArgoDialog
//#endif 

  { 

//#if -533826351 
private static final long serialVersionUID = 1595302214402366939L;
//#endif 


//#if -1005116063 
private static final int INSET_PX = 3;
//#endif 


//#if -158200552 
private JTextArea   info = new JTextArea();
//#endif 


//#if -1292669007 
private JButton     runGCButton = new JButton();
//#endif 


//#if 445714353 
private JButton     copyButton = new JButton();
//#endif 


//#if -178214927 
private static ClipboardOwner defaultClipboardOwner =
        new ClipboardObserver();
//#endif 


//#if -1425896006 
public SystemInfoDialog(boolean modal)
    { 

//#if -208232717 
super(Translator.localize("dialog.title.system-information"),
              ArgoDialog.CLOSE_OPTION, modal);
//#endif 


//#if -1669052145 
info.setEditable(false);
//#endif 


//#if -662677667 
info.setMargin(new Insets(INSET_PX, INSET_PX, INSET_PX, INSET_PX));
//#endif 


//#if -1979990000 
runGCButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runGCActionPerformed(e);
            }
        });
//#endif 


//#if -1480626896 
copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                copyActionPerformed(e);
            }
        });
//#endif 


//#if 480519944 
nameButton(copyButton, "button.copy-to-clipboard");
//#endif 


//#if 1730352538 
nameButton(runGCButton, "button.run-gc");
//#endif 


//#if -2079495474 
addButton(copyButton, 0);
//#endif 


//#if -1152288642 
addButton(runGCButton, 0);
//#endif 


//#if 945337 
setContent(new JScrollPane(info));
//#endif 


//#if 155588967 
updateInfo();
//#endif 


//#if 2071890568 
addWindowListener(new WindowAdapter() {
            public void windowActivated(WindowEvent e) {
                updateInfo();
            }
        });
//#endif 


//#if -887670747 
pack();
//#endif 

} 

//#endif 


//#if 1867393226 
private void runGCActionPerformed(ActionEvent e)
    { 

//#if -1696067080 
assert e.getSource() == runGCButton;
//#endif 


//#if 211993622 
Runtime.getRuntime().gc();
//#endif 


//#if -799541482 
updateInfo();
//#endif 

} 

//#endif 


//#if 1509466204 
void updateInfo()
    { 

//#if -585203962 
info.setText(getInfo());
//#endif 

} 

//#endif 


//#if 1049182893 
public static String getInfo()
    { 

//#if -2001291325 
StringBuffer s = new StringBuffer();
//#endif 


//#if 2095102500 
s.append(Translator.localize("dialog.systeminfo.argoumlversion"));
//#endif 


//#if -1134295978 
s.append(ApplicationVersion.getVersion() + "\n");
//#endif 


//#if 210071073 
s.append(Translator.localize("dialog.systeminfo.javaversion"));
//#endif 


//#if 662148658 
s.append(System.getProperty("java.version", "") + "\n");
//#endif 


//#if -1123747471 
s.append(Translator.localize("dialog.systeminfo.javavendor"));
//#endif 


//#if -1315939386 
s.append(System.getProperty("java.vendor", "") + "\n");
//#endif 


//#if -355836273 
s.append(Translator.localize("dialog.systeminfo.url-javavendor"));
//#endif 


//#if -899136569 
s.append(System.getProperty("java.vendor.url", "") + "\n");
//#endif 


//#if -2088226891 
s.append(Translator.localize("dialog.systeminfo.java-home-directory"));
//#endif 


//#if -1764178595 
s.append(System.getProperty("java.home", "") + "\n");
//#endif 


//#if 1672178745 
s.append(Translator.localize("dialog.systeminfo.java-classpath"));
//#endif 


//#if 1102899161 
s.append(System.getProperty("java.class.path", "") + "\n");
//#endif 


//#if -2132659006 
s.append(Translator.localize("dialog.systeminfo.operating-system"));
//#endif 


//#if 1018373558 
s.append(System.getProperty("os.name", ""));
//#endif 


//#if 631002984 
s.append(Translator.localize(
                     "dialog.systeminfo.operating-systemversion"));
//#endif 


//#if -1038593164 
s.append(System.getProperty("os.version", "") + "\n");
//#endif 


//#if -1213539110 
s.append(Translator.localize("dialog.systeminfo.architecture"));
//#endif 


//#if -713211822 
s.append(System.getProperty("os.arch", "") + "\n");
//#endif 


//#if 1890315768 
s.append(Translator.localize("dialog.systeminfo.user-name"));
//#endif 


//#if 798445184 
s.append(System.getProperty("user.name", "") + "\n");
//#endif 


//#if -1264069780 
s.append(Translator.localize("dialog.systeminfo.user-home-directory"));
//#endif 


//#if -802428204 
s.append(System.getProperty("user.home", "") + "\n");
//#endif 


//#if -1444857404 
s.append(Translator.localize("dialog.systeminfo.current-directory"));
//#endif 


//#if -685613808 
s.append(System.getProperty("user.dir", "") + "\n");
//#endif 


//#if 1046548573 
s.append(Translator.localize("dialog.systeminfo.jvm-total-memory"));
//#endif 


//#if -289122948 
s.append(String.valueOf(Runtime.getRuntime().totalMemory()) + "\n");
//#endif 


//#if 2111738113 
s.append(Translator.localize("dialog.systeminfo.jvm-free-memory"));
//#endif 


//#if 986663676 
s.append(String.valueOf(Runtime.getRuntime().freeMemory()) + "\n");
//#endif 


//#if 14073956 
return s.toString();
//#endif 

} 

//#endif 


//#if -414657266 
private void copyActionPerformed(ActionEvent e)
    { 

//#if 1218354440 
assert e.getSource() == copyButton;
//#endif 


//#if -1774484963 
String infoText = info.getText();
//#endif 


//#if -1347269381 
StringSelection contents = new StringSelection(infoText);
//#endif 


//#if -1568837334 
Clipboard clipboard = getToolkit().getSystemClipboard();
//#endif 


//#if 1994541209 
clipboard.setContents(contents, defaultClipboardOwner);
//#endif 

} 

//#endif 


//#if -818298798 
static class ClipboardObserver implements 
//#if -1229947052 
ClipboardOwner
//#endif 

  { 

//#if -1180931441 
public void lostOwnership(Clipboard clipboard, Transferable contents)
        { 
} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

