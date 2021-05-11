
//#if -1516979718 
// Compilation Unit of /TabText.java 
 

//#if 1625438621 
package org.argouml.ui;
//#endif 


//#if -1523650201 
import java.awt.BorderLayout;
//#endif 


//#if 585804974 
import java.awt.Font;
//#endif 


//#if -1148580924 
import java.util.Collections;
//#endif 


//#if 1585989858 
import javax.swing.JScrollPane;
//#endif 


//#if 1973282045 
import javax.swing.JTextArea;
//#endif 


//#if 499361764 
import javax.swing.JToolBar;
//#endif 


//#if 509724676 
import javax.swing.SwingConstants;
//#endif 


//#if -1214625194 
import javax.swing.event.DocumentEvent;
//#endif 


//#if -1048971150 
import javax.swing.event.DocumentListener;
//#endif 


//#if -1714388871 
import org.argouml.application.api.AbstractArgoJPanel;
//#endif 


//#if -1634711100 
import org.argouml.swingext.UpArrowIcon;
//#endif 


//#if -1509948701 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if 483430320 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 747095485 
import org.tigris.toolbar.ToolBarFactory;
//#endif 


//#if -1512684289 
import org.apache.log4j.Logger;
//#endif 


//#if 612925644 
public class TabText extends 
//#if -1178463066 
AbstractArgoJPanel
//#endif 

 implements 
//#if 1377781942 
TabModelTarget
//#endif 

, 
//#if 1735852064 
DocumentListener
//#endif 

  { 

//#if -1737147271 
private Object target;
//#endif 


//#if -1238378267 
private JTextArea textArea = new JTextArea();
//#endif 


//#if 694398966 
private boolean parseChanges = true;
//#endif 


//#if -1572101712 
private boolean enabled;
//#endif 


//#if -1965730781 
private JToolBar toolbar;
//#endif 


//#if 1601762797 
private static final long serialVersionUID = -1484647093166393888L;
//#endif 


//#if 1474222237 
private static final Logger LOG = Logger.getLogger(TabText.class);
//#endif 


//#if 633270336 
protected void parseText(String s)
    { 

//#if -986662602 
if(s == null)//1
{ 

//#if 1725988231 
s = "(null)";
//#endif 

} 

//#endif 


//#if -536328869 
LOG.debug("parsing text:" + s);
//#endif 

} 

//#endif 


//#if 857944490 
public void changedUpdate(DocumentEvent e)
    { 

//#if 1914107092 
if(parseChanges)//1
{ 

//#if -273635375 
parseText(textArea.getText());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -619470680 
public void targetSet(TargetEvent e)
    { 

//#if 79489238 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 2085182754 
public TabText(String title)
    { 

//#if -1839479478 
this(title, false);
//#endif 

} 

//#endif 


//#if 465398358 
public void removeUpdate(DocumentEvent e)
    { 

//#if 1553395884 
if(parseChanges)//1
{ 

//#if -605387547 
parseText(textArea.getText());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1287491216 
protected void setShouldBeEnabled(boolean s)
    { 

//#if 457263207 
this.enabled = s;
//#endif 

} 

//#endif 


//#if -457772940 
protected JToolBar getToolbar()
    { 

//#if -755474511 
return toolbar;
//#endif 

} 

//#endif 


//#if 221013143 
public void setTarget(Object t)
    { 

//#if -1813568986 
target = t;
//#endif 


//#if 1220103475 
if(isVisible())//1
{ 

//#if -133732533 
doGenerateText();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 537108333 
public void setEditable(boolean editable)
    { 

//#if 1449103449 
textArea.setEditable(editable);
//#endif 

} 

//#endif 


//#if -746418266 
public void targetRemoved(TargetEvent e)
    { 

//#if 449131668 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -749318258 
public void refresh()
    { 

//#if 450954317 
Object t = TargetManager.getInstance().getTarget();
//#endif 


//#if 164034867 
setTarget(t);
//#endif 

} 

//#endif 


//#if 1232490516 
private void doGenerateText()
    { 

//#if 111320529 
parseChanges = false;
//#endif 


//#if -1713200064 
if(getTarget() == null)//1
{ 

//#if -1036615761 
textArea.setEnabled(false);
//#endif 


//#if 2093236690 
textArea.setText("Nothing selected");
//#endif 


//#if -1668685691 
enabled = false;
//#endif 

} 
else
{ 

//#if -1750693600 
textArea.setEnabled(true);
//#endif 


//#if 1342453649 
if(isVisible())//1
{ 

//#if -2103642886 
String generatedText = genText(getTarget());
//#endif 


//#if -624873505 
if(generatedText != null)//1
{ 

//#if 1952219444 
textArea.setText(generatedText);
//#endif 


//#if -1399555330 
enabled = true;
//#endif 


//#if 1717773829 
textArea.setCaretPosition(0);
//#endif 

} 
else
{ 

//#if -2000381134 
textArea.setEnabled(false);
//#endif 


//#if 1131642295 
textArea.setText("N/A");
//#endif 


//#if 801524770 
enabled = false;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -952796428 
parseChanges = true;
//#endif 

} 

//#endif 


//#if 1534568831 
public boolean shouldBeEnabled(Object t)
    { 

//#if 914142242 
return (t != null);
//#endif 

} 

//#endif 


//#if -384852593 
public Object getTarget()
    { 

//#if -554701355 
return target;
//#endif 

} 

//#endif 


//#if 1950222381 
protected String genText(Object t)
    { 

//#if -1948608435 
return t == null ? "Nothing selected" : t.toString();
//#endif 

} 

//#endif 


//#if -743520031 
protected boolean shouldBeEnabled()
    { 

//#if -203271478 
return enabled;
//#endif 

} 

//#endif 


//#if 507563679 
@Override
    public void setVisible(boolean visible)
    { 

//#if -630137075 
super.setVisible(visible);
//#endif 


//#if -1722556099 
if(visible)//1
{ 

//#if -1975431019 
doGenerateText();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -229347637 
public void insertUpdate(DocumentEvent e)
    { 

//#if -1977810648 
if(parseChanges)//1
{ 

//#if -561486784 
parseText(textArea.getText());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1641317510 
public void targetAdded(TargetEvent e)
    { 

//#if -2026546819 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 1688453591 
public TabText(String title, boolean withToolbar)
    { 

//#if 1277293127 
super(title);
//#endif 


//#if 1060274589 
setIcon(new UpArrowIcon());
//#endif 


//#if -983235689 
setLayout(new BorderLayout());
//#endif 


//#if 671271096 
textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
//#endif 


//#if 1227354544 
textArea.setTabSize(4);
//#endif 


//#if 1932716022 
add(new JScrollPane(textArea), BorderLayout.CENTER);
//#endif 


//#if -986920094 
textArea.getDocument().addDocumentListener(this);
//#endif 


//#if 791446952 
if(withToolbar)//1
{ 

//#if -738656316 
toolbar = (new ToolBarFactory(Collections.EMPTY_LIST))
                      .createToolBar();
//#endif 


//#if 863453359 
toolbar.setOrientation(SwingConstants.HORIZONTAL);
//#endif 


//#if -545469417 
toolbar.setFloatable(false);
//#endif 


//#if -973271802 
toolbar.setName(getTitle());
//#endif 


//#if -422240166 
add(toolbar, BorderLayout.NORTH);
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

