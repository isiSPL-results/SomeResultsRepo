// Compilation Unit of /WizStep.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.awt.BorderLayout;
//#endif 


//#if COGNITIVE 
import java.awt.FlowLayout;
//#endif 


//#if COGNITIVE 
import java.awt.GridLayout;
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
import javax.swing.ImageIcon;
//#endif 


//#if COGNITIVE 
import javax.swing.JButton;
//#endif 


//#if COGNITIVE 
import javax.swing.JPanel;
//#endif 


//#if COGNITIVE 
import javax.swing.event.DocumentEvent;
//#endif 


//#if COGNITIVE 
import javax.swing.event.DocumentListener;
//#endif 


//#if COGNITIVE 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Translator;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if COGNITIVE 
import org.argouml.swingext.SpacerPanel;
//#endif 


//#if COGNITIVE 
import org.argouml.ui.ProjectBrowser;
//#endif 


//#if COGNITIVE 
import org.argouml.ui.TabToDoTarget;
//#endif 


//#if COGNITIVE 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if COGNITIVE 
import org.argouml.util.osdep.StartBrowser;
//#endif 


//#if COGNITIVE 
public class WizStep extends JPanel
 implements TabToDoTarget
, ActionListener
, DocumentListener
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

//#if COGNITIVE 
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

//#endif 


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

//#if COGNITIVE 
if(src == nextButton)//1
{ 
doNext();
} 
else

//#if COGNITIVE 
if(src == finishButton)//1
{ 
doFinsh();
} 
else

//#if COGNITIVE 
if(src == helpButton)//1
{ 
doHelp();
} 

//#endif 


//#endif 


//#endif 


} 

public void setTarget(Object item)
    { 
target = item;
enableButtons();
} 

 } 

//#endif 


