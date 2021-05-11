// Compilation Unit of /UMLSynchStateBoundDocument.java 
 
package org.argouml.uml.ui.behavior.state_machines;
import org.argouml.model.Model;
import org.argouml.uml.ui.UMLPlainTextDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
public class UMLSynchStateBoundDocument extends UMLPlainTextDocument
  { 
private static final long serialVersionUID = -1391739151659430935L;
protected String getProperty()
    { 
int bound = Model.getFacade().getBound(getTarget());
if(bound <= 0)//1
{ 
return "*";
} 
else
{ 
return String.valueOf(bound);
} 

} 

public void insertString(int offset, String str, AttributeSet a)
    throws BadLocationException
    { 
try //1
{ 
Integer.parseInt(str);
super.insertString(offset, str, a);
} 
catch (NumberFormatException e) //1
{ 
} 


} 

protected void setProperty(String text)
    { 
if(text.equals(""))//1
{ 
Model.getStateMachinesHelper().setBound(getTarget(), 0);
} 
else
{ 
Model.getStateMachinesHelper()
            .setBound(getTarget(), Integer.valueOf(text).intValue());
} 

} 

public UMLSynchStateBoundDocument()
    { 
super("bound");
} 

 } 


