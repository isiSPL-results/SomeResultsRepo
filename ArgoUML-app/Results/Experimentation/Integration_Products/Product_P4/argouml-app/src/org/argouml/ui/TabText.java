package org.argouml.ui;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Collections;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.argouml.application.api.AbstractArgoJPanel;
import org.argouml.swingext.UpArrowIcon;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetManager;
import org.tigris.toolbar.ToolBarFactory;
import org.apache.log4j.Logger;
public class TabText extends AbstractArgoJPanel
 implements TabModelTarget
,DocumentListener
  { 
private Object target;
private JTextArea textArea = new JTextArea();
private boolean parseChanges = true;
private boolean enabled;
private JToolBar toolbar;
private static final long serialVersionUID = -1484647093166393888L;
private static final Logger LOG = Logger.getLogger(TabText.class);
protected void parseText(String s)
    { 
if(s == null)//1
{ 
s = "(null)";
} 
LOG.debug("parsing text:" + s);
} 
public void changedUpdate(DocumentEvent e)
    { 
if(parseChanges)//1
{ 
parseText(textArea.getText());
} 
} 
public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public TabText(String title)
    { 
this(title, false);
} 
public void removeUpdate(DocumentEvent e)
    { 
if(parseChanges)//1
{ 
parseText(textArea.getText());
} 
} 
protected void setShouldBeEnabled(boolean s)
    { 
this.enabled = s;
} 
protected JToolBar getToolbar()
    { 
return toolbar;
} 
public void setTarget(Object t)
    { 
target = t;
if(isVisible())//1
{ 
doGenerateText();
} 
} 
public void setEditable(boolean editable)
    { 
textArea.setEditable(editable);
} 
public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public void refresh()
    { 
Object t = TargetManager.getInstance().getTarget();
setTarget(t);
} 
private void doGenerateText()
    { 
parseChanges = false;
if(getTarget() == null)//1
{ 
textArea.setEnabled(false);
textArea.setText("Nothing selected");
enabled = false;
} 
else
{ 
textArea.setEnabled(true);
if(isVisible())//1
{ 
String generatedText = genText(getTarget());
if(generatedText != null)//1
{ 
textArea.setText(generatedText);
enabled = true;
textArea.setCaretPosition(0);
} 
else
{ 
textArea.setEnabled(false);
textArea.setText("N/A");
enabled = false;
} 
} 
} 
parseChanges = true;
} 
public boolean shouldBeEnabled(Object t)
    { 
return (t != null);
} 
public Object getTarget()
    { 
return target;
} 
protected String genText(Object t)
    { 
return t == null ? "Nothing selected" : t.toString();
} 
protected boolean shouldBeEnabled()
    { 
return enabled;
} 
@Override
    public void setVisible(boolean visible)
    { 
super.setVisible(visible);
if(visible)//1
{ 
doGenerateText();
} 
} 
public void insertUpdate(DocumentEvent e)
    { 
if(parseChanges)//1
{ 
parseText(textArea.getText());
} 
} 
public void targetAdded(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public TabText(String title, boolean withToolbar)
    { 
super(title);
setIcon(new UpArrowIcon());
setLayout(new BorderLayout());
textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
textArea.setTabSize(4);
add(new JScrollPane(textArea), BorderLayout.CENTER);
textArea.getDocument().addDocumentListener(this);
if(withToolbar)//1
{ 
toolbar = (new ToolBarFactory(Collections.EMPTY_LIST))
                      .createToolBar();
toolbar.setOrientation(SwingConstants.HORIZONTAL);
toolbar.setFloatable(false);
toolbar.setName(getTitle());
add(toolbar, BorderLayout.NORTH);
} 
} 

 } 
