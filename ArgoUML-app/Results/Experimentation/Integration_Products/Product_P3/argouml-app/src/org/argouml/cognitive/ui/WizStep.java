package org.argouml.cognitive.ui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.Translator;
import org.argouml.cognitive.critics.Wizard;
import org.argouml.swingext.SpacerPanel;
import org.argouml.ui.ProjectBrowser;
import org.argouml.ui.TabToDoTarget;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.util.osdep.StartBrowser;
public class WizStep extends JPanel
 implements TabToDoTarget
,ActionListener
,DocumentListener
  { 
private static final ImageIcon WIZ_ICON =
        ResourceLoaderWrapper
        .lookupIconResource("Wiz", "Wiz");
private JPanel  mainPanel = new JPanel();
private JButton backButton =
        new JButton(Translator.localize("button.back"));
private JButton nextButton =
        new JButton(Translator.localize("button.next"));
private JButton finishButton =
        new JButton(Translator.localize("button.finish"));
private JButton helpButton =
        new JButton(Translator.localize("button.help"));
private JPanel  buttonPanel = new JPanel();
private Object target;
private static final long serialVersionUID = 8845081753813440684L;
public void removeUpdate(DocumentEvent e)
    { 
insertUpdate(e);
} 
public void targetAdded(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
protected static final void setMnemonic(JButton b, String key)
    { 
String m = Translator.localize(key);
if(m == null)//1
{ 
return;
} 
if(m.length() == 1)//1
{ 
b.setMnemonic(m.charAt(0));
} 
} 
protected void updateTabToDo()
    { 
TabToDo ttd =
            (TabToDo) ProjectBrowser.getInstance().getTab(TabToDo.class);
JPanel ws = getWizard().getCurrentPanel();
if(ws instanceof WizStep)//1
{ 
((WizStep) ws).setTarget(target);
} 
ttd.showStep(ws);
} 
protected JPanel getMainPanel()
    { 
return mainPanel;
} 
protected static ImageIcon getWizardIcon()
    { 
return WIZ_ICON;
} 
public void doNext()
    { 
Wizard w = getWizard();
if(w != null)//1
{ 
w.next();
updateTabToDo();
} 
} 
public void doHelp()
    { 
if(!(target instanceof ToDoItem))//1
{ 
return;
} 
ToDoItem item = (ToDoItem) target;
String urlString = item.getMoreInfoURL();
StartBrowser.openUrl(urlString);
} 
public WizStep()
    { 
setMnemonic(backButton, "mnemonic.button.back");
setMnemonic(nextButton, "mnemonic.button.next");
setMnemonic(finishButton, "mnemonic.button.finish");
setMnemonic(helpButton, "mnemonic.button.help");
buttonPanel.setLayout(new GridLayout(1, 5));
buttonPanel.add(backButton);
buttonPanel.add(nextButton);
buttonPanel.add(new SpacerPanel());
buttonPanel.add(finishButton);
buttonPanel.add(new SpacerPanel());
buttonPanel.add(helpButton);
backButton.setMargin(new Insets(0, 0, 0, 0));
nextButton.setMargin(new Insets(0, 0, 0, 0));
finishButton.setMargin(new Insets(0, 0, 0, 0));
helpButton.setMargin(new Insets(0, 0, 0, 0));
JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
southPanel.add(buttonPanel);
setLayout(new BorderLayout());
add(mainPanel, BorderLayout.CENTER);
add(southPanel, BorderLayout.SOUTH);
backButton.addActionListener(this);
nextButton.addActionListener(this);
finishButton.addActionListener(this);
helpButton.addActionListener(this);
} 
public void enableButtons()
    { 
if(target == null)//1
{ 
backButton.setEnabled(false);
nextButton.setEnabled(false);
finishButton.setEnabled(false);
helpButton.setEnabled(false);
} 
else
if(target instanceof ToDoItem)//1
{ 
ToDoItem tdi = (ToDoItem) target;
Wizard w = getWizard();
backButton.setEnabled(w != null ? w.canGoBack() : false);
nextButton.setEnabled(w != null ? w.canGoNext() : false);
finishButton.setEnabled(w != null ? w.canFinish() : false);
if(tdi.getMoreInfoURL() == null
                    || "".equals(tdi.getMoreInfoURL()))//1
{ 
helpButton.setEnabled(false);
} 
else
{ 
helpButton.setEnabled(true);
} 
} 
else
{ 
return;
} 
} 
public void insertUpdate(DocumentEvent e)
    { 
enableButtons();
} 
public void refresh()
    { 
setTarget(target);
} 
public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public void doBack()
    { 
Wizard w = getWizard();
if(w != null)//1
{ 
w.back();
updateTabToDo();
} 
} 
public Wizard getWizard()
    { 
if(target instanceof ToDoItem)//1
{ 
return ((ToDoItem) target).getWizard();
} 
return null;
} 
public void changedUpdate(DocumentEvent e)
    { 
} 
public void doFinsh()
    { 
Wizard w = getWizard();
if(w != null)//1
{ 
w.finish();
updateTabToDo();
} 
} 
public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public void actionPerformed(ActionEvent ae)
    { 
Object src = ae.getSource();
if(src == backButton)//1
{ 
doBack();
} 
else
if(src == nextButton)//1
{ 
doNext();
} 
else
if(src == finishButton)//1
{ 
doFinsh();
} 
else
if(src == helpButton)//1
{ 
doHelp();
} 
} 
public void setTarget(Object item)
    { 
target = item;
enableButtons();
} 

 } 
