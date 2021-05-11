
//#if 1562530917 
// Compilation Unit of /DiagramNameDocument.java 
 

//#if 1217478908 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1570893072 
import java.beans.PropertyVetoException;
//#endif 


//#if -1704238562 
import javax.swing.JTextField;
//#endif 


//#if 1849037418 
import javax.swing.event.DocumentEvent;
//#endif 


//#if 468862942 
import javax.swing.event.DocumentListener;
//#endif 


//#if -1748683457 
import javax.swing.text.BadLocationException;
//#endif 


//#if 937543700 
import javax.swing.text.DefaultHighlighter;
//#endif 


//#if -638230253 
import org.apache.log4j.Logger;
//#endif 


//#if -1545465521 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -163208487 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if 711504668 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1827531451 
import org.argouml.uml.diagram.ArgoDiagram;
//#endif 


//#if 1087552270 
class DiagramNameDocument implements 
//#if 690232230 
DocumentListener
//#endif 

, 
//#if -79517732 
TargetListener
//#endif 

  { 

//#if 996871034 
private static final Logger LOG =
        Logger.getLogger(DiagramNameDocument.class);
//#endif 


//#if -1013827088 
private JTextField field;
//#endif 


//#if -218435138 
private boolean stopEvents = false;
//#endif 


//#if -460086296 
private Object highlightTag = null;
//#endif 


//#if 1420035040 
public void targetRemoved(TargetEvent e)
    { 

//#if 1205517809 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -789223676 
private void update(DocumentEvent e)
    { 

//#if 263376500 
if(!stopEvents)//1
{ 

//#if -1218756616 
Object target = TargetManager.getInstance().getTarget();
//#endif 


//#if 1581156694 
if(target instanceof ArgoDiagram)//1
{ 

//#if -2092232548 
ArgoDiagram d = (ArgoDiagram) target;
//#endif 


//#if -994677056 
try //1
{ 

//#if 682144718 
int documentLength = e.getDocument().getLength();
//#endif 


//#if 557008282 
String newName = e.getDocument().getText(0, documentLength);
//#endif 


//#if -1553704387 
String oldName = d.getName();
//#endif 


//#if 399250111 
if(!oldName.equals(newName))//1
{ 

//#if 13828775 
d.setName(newName);
//#endif 


//#if 76781579 
if(highlightTag != null)//1
{ 

//#if -1082789714 
field.getHighlighter()
                            .removeHighlight(highlightTag);
//#endif 


//#if 52516333 
highlightTag = null;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#if 445383774 
catch (PropertyVetoException pe) //1
{ 

//#if -747909462 
try //1
{ 

//#if -1368111815 
highlightTag  = field.getHighlighter().addHighlight(0,
                                        field.getText().length(),
                                        DefaultHighlighter.DefaultPainter);
//#endif 

} 

//#if -716188655 
catch (BadLocationException e1) //1
{ 

//#if 2109431116 
LOG.debug("Nested exception", e1);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 1243302495 
catch (BadLocationException ble) //1
{ 

//#if -1861359295 
LOG.debug(ble);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 540995945 
private void setTarget(Object t)
    { 

//#if 837342939 
if(t instanceof ArgoDiagram)//1
{ 

//#if -1347089332 
stopEvents = true;
//#endif 


//#if -1598892968 
field.setText(((ArgoDiagram) t).getName());
//#endif 


//#if 773142393 
stopEvents = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1094025892 
public void removeUpdate(DocumentEvent e)
    { 

//#if 511384822 
update(e);
//#endif 

} 

//#endif 


//#if 1346126306 
public void targetSet(TargetEvent e)
    { 

//#if -1911222850 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 794410816 
public void targetAdded(TargetEvent e)
    { 

//#if 65318604 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if -1788771887 
public void insertUpdate(DocumentEvent e)
    { 

//#if -628231450 
update(e);
//#endif 

} 

//#endif 


//#if -469374802 
public DiagramNameDocument(JTextField theField)
    { 

//#if -657001324 
field = theField;
//#endif 


//#if -912542652 
TargetManager tm = TargetManager.getInstance();
//#endif 


//#if -1370614004 
tm.addTargetListener(this);
//#endif 


//#if -747492939 
setTarget(tm.getTarget());
//#endif 

} 

//#endif 


//#if -239567004 
public void changedUpdate(DocumentEvent e)
    { 

//#if 1228534995 
update(e);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

