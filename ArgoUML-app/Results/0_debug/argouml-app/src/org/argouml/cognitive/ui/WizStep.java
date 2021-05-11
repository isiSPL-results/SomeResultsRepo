
//#if 648360586 
// Compilation Unit of /WizStep.java 
 

//#if -1550548080 
package org.argouml.cognitive.ui;
//#endif 


//#if -1085718290 
import java.awt.BorderLayout;
//#endif 


//#if 2014671852 
import java.awt.FlowLayout;
//#endif 


//#if -1755193644 
import java.awt.GridLayout;
//#endif 


//#if 1107483438 
import java.awt.Insets;
//#endif 


//#if 935461570 
import java.awt.event.ActionEvent;
//#endif 


//#if 1338529926 
import java.awt.event.ActionListener;
//#endif 


//#if -635414540 
import javax.swing.ImageIcon;
//#endif 


//#if 1992454252 
import javax.swing.JButton;
//#endif 


//#if -523414220 
import javax.swing.JPanel;
//#endif 


//#if -1862787811 
import javax.swing.event.DocumentEvent;
//#endif 


//#if -288531381 
import javax.swing.event.DocumentListener;
//#endif 


//#if 1126657778 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1477587788 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 2096684907 
import org.argouml.cognitive.Translator;
//#endif 


//#if 266371275 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if -775774068 
import org.argouml.swingext.SpacerPanel;
//#endif 


//#if -2030289708 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if -96210649 
import org.argouml.ui.TabToDoTarget;
//#endif 


//#if 690315260 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if 1412060680 
import org.argouml.util.osdep.StartBrowser;
//#endif 


//#if 1918609797 
public class WizStep extends 
//#if 1640039327 
JPanel
//#endif 

 implements 
//#if 688803719 
TabToDoTarget
//#endif 

, 
//#if 1756533743 
ActionListener
//#endif 

, 
//#if -1810887532 
DocumentListener
//#endif 

  { 

//#if -1642955882 
private static final ImageIcon WIZ_ICON =
        ResourceLoaderWrapper
        .lookupIconResource("Wiz", "Wiz");
//#endif 


//#if 125110314 
private JPanel  mainPanel = new JPanel();
//#endif 


//#if 479846219 
private JButton backButton =
        new JButton(Translator.localize("button.back"));
//#endif 


//#if -1309768605 
private JButton nextButton =
        new JButton(Translator.localize("button.next"));
//#endif 


//#if -906256797 
private JButton finishButton =
        new JButton(Translator.localize("button.finish"));
//#endif 


//#if 747188095 
private JButton helpButton =
        new JButton(Translator.localize("button.help"));
//#endif 


//#if 1543540579 
private JPanel  buttonPanel = new JPanel();
//#endif 


//#if -2146767123 
private Object target;
//#endif 


//#if 433942803 
private static final long serialVersionUID = 8845081753813440684L;
//#endif 


//#if -784406582 
public void removeUpdate(DocumentEvent e)
    { 

//#if -91927566 
insertUpdate(e);
//#endif 

} 

//#endif 


//#if 1610423186 
public void targetAdded(TargetEvent e)
    { 

//#if 981451376 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -40477622 
protected static final void setMnemonic(JButton b, String key)
    { 

//#if -684279118 
String m = Translator.localize(key);
//#endif 


//#if 1422308900 
if(m == null)//1
{ 

//#if 387730018 
return;
//#endif 

} 

//#endif 


//#if 526656153 
if(m.length() == 1)//1
{ 

//#if -1878899414 
b.setMnemonic(m.charAt(0));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 321634454 
protected void updateTabToDo()
    { 

//#if 55810662 
TabToDo ttd =
            (TabToDo) ProjectBrowser.getInstance().getTab(TabToDo.class);
//#endif 


//#if 1775708325 
JPanel ws = getWizard().getCurrentPanel();
//#endif 


//#if 19487216 
if(ws instanceof WizStep)//1
{ 

//#if 821514233 
((WizStep) ws).setTarget(target);
//#endif 

} 

//#endif 


//#if 1651641404 
ttd.showStep(ws);
//#endif 

} 

//#endif 


//#if -2049816967 
protected JPanel getMainPanel()
    { 

//#if -1628850948 
return mainPanel;
//#endif 

} 

//#endif 


//#if -487525218 
protected static ImageIcon getWizardIcon()
    { 

//#if 330881525 
return WIZ_ICON;
//#endif 

} 

//#endif 


//#if -466458015 
public void doNext()
    { 

//#if -1387351184 
Wizard w = getWizard();
//#endif 


//#if 944101533 
if(w != null)//1
{ 

//#if 1628416912 
w.next();
//#endif 


//#if 1443499784 
updateTabToDo();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -638594257 
public void doHelp()
    { 

//#if 841787003 
if(!(target instanceof ToDoItem))//1
{ 

//#if 2098692015 
return;
//#endif 

} 

//#endif 


//#if -830537053 
ToDoItem item = (ToDoItem) target;
//#endif 


//#if -1301138743 
String urlString = item.getMoreInfoURL();
//#endif 


//#if -881434535 
StartBrowser.openUrl(urlString);
//#endif 

} 

//#endif 


//#if -40441785 
public WizStep()
    { 

//#if -1103922576 
setMnemonic(backButton, "mnemonic.button.back");
//#endif 


//#if 604660056 
setMnemonic(nextButton, "mnemonic.button.next");
//#endif 


//#if 36166616 
setMnemonic(finishButton, "mnemonic.button.finish");
//#endif 


//#if 1980220476 
setMnemonic(helpButton, "mnemonic.button.help");
//#endif 


//#if 1723101707 
buttonPanel.setLayout(new GridLayout(1, 5));
//#endif 


//#if -882072 
buttonPanel.add(backButton);
//#endif 


//#if -263764876 
buttonPanel.add(nextButton);
//#endif 


//#if 838660136 
buttonPanel.add(new SpacerPanel());
//#endif 


//#if 576682708 
buttonPanel.add(finishButton);
//#endif 


//#if 699397418 
buttonPanel.add(new SpacerPanel());
//#endif 


//#if -40215870 
buttonPanel.add(helpButton);
//#endif 


//#if -188443132 
backButton.setMargin(new Insets(0, 0, 0, 0));
//#endif 


//#if -776329352 
nextButton.setMargin(new Insets(0, 0, 0, 0));
//#endif 


//#if 683173976 
finishButton.setMargin(new Insets(0, 0, 0, 0));
//#endif 


//#if -1801249814 
helpButton.setMargin(new Insets(0, 0, 0, 0));
//#endif 


//#if 1719216480 
JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//#endif 


//#if -1841751232 
southPanel.add(buttonPanel);
//#endif 


//#if 997648019 
setLayout(new BorderLayout());
//#endif 


//#if -1372877603 
add(mainPanel, BorderLayout.CENTER);
//#endif 


//#if -1317777925 
add(southPanel, BorderLayout.SOUTH);
//#endif 


//#if -1807765176 
backButton.addActionListener(this);
//#endif 


//#if 2001496508 
nextButton.addActionListener(this);
//#endif 


//#if 1992610460 
finishButton.addActionListener(this);
//#endif 


//#if 123345838 
helpButton.addActionListener(this);
//#endif 

} 

//#endif 


//#if 1819410685 
public void enableButtons()
    { 

//#if 79002347 
if(target == null)//1
{ 

//#if -1908898981 
backButton.setEnabled(false);
//#endif 


//#if 92644047 
nextButton.setEnabled(false);
//#endif 


//#if 2136671919 
finishButton.setEnabled(false);
//#endif 


//#if 1450455617 
helpButton.setEnabled(false);
//#endif 

} 
else

//#if -923650237 
if(target instanceof ToDoItem)//1
{ 

//#if 636724476 
ToDoItem tdi = (ToDoItem) target;
//#endif 


//#if 1114743507 
Wizard w = getWizard();
//#endif 


//#if 1288133538 
backButton.setEnabled(w != null ? w.canGoBack() : false);
//#endif 


//#if 1785402146 
nextButton.setEnabled(w != null ? w.canGoNext() : false);
//#endif 


//#if 1189083738 
finishButton.setEnabled(w != null ? w.canFinish() : false);
//#endif 


//#if 1239579541 
if(tdi.getMoreInfoURL() == null
                    || "".equals(tdi.getMoreInfoURL()))//1
{ 

//#if -1802521102 
helpButton.setEnabled(false);
//#endif 

} 
else
{ 

//#if -1327465112 
helpButton.setEnabled(true);
//#endif 

} 

//#endif 

} 
else
{ 

//#if 1262516191 
return;
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if -1479152577 
public void insertUpdate(DocumentEvent e)
    { 

//#if 1374801065 
enableButtons();
//#endif 

} 

//#endif 


//#if -1178173798 
public void refresh()
    { 

//#if 1230737381 
setTarget(target);
//#endif 

} 

//#endif 


//#if 1011780276 
public void targetSet(TargetEvent e)
    { 

//#if 575042920 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -814336171 
public void doBack()
    { 

//#if -1461832360 
Wizard w = getWizard();
//#endif 


//#if -294197115 
if(w != null)//1
{ 

//#if -844612406 
w.back();
//#endif 


//#if 1341058970 
updateTabToDo();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -540723639 
public Wizard getWizard()
    { 

//#if 1042635721 
if(target instanceof ToDoItem)//1
{ 

//#if 586948963 
return ((ToDoItem) target).getWizard();
//#endif 

} 

//#endif 


//#if -1645549500 
return null;
//#endif 

} 

//#endif 


//#if 768697014 
public void changedUpdate(DocumentEvent e)
    { 
} 

//#endif 


//#if 19921684 
public void doFinsh()
    { 

//#if -1734245098 
Wizard w = getWizard();
//#endif 


//#if -2014814525 
if(w != null)//1
{ 

//#if 739929075 
w.finish();
//#endif 


//#if -1188774747 
updateTabToDo();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -371092558 
public void targetRemoved(TargetEvent e)
    { 

//#if 265189869 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 1031179297 
public void actionPerformed(ActionEvent ae)
    { 

//#if 1505326482 
Object src = ae.getSource();
//#endif 


//#if -1357064893 
if(src == backButton)//1
{ 

//#if 764709885 
doBack();
//#endif 

} 
else

//#if 1006531355 
if(src == nextButton)//1
{ 

//#if -758334581 
doNext();
//#endif 

} 
else

//#if 1370276075 
if(src == finishButton)//1
{ 

//#if -56136395 
doFinsh();
//#endif 

} 
else

//#if -1683575828 
if(src == helpButton)//1
{ 

//#if 1417807617 
doHelp();
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 


//#if -77833504 
public void setTarget(Object item)
    { 

//#if 2016101221 
target = item;
//#endif 


//#if 632560325 
enableButtons();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

