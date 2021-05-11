
//#if 916834492 
// Compilation Unit of /UMLSynchStateBoundDocument.java 
 

//#if 403190132 
package org.argouml.uml.ui.behavior.state_machines;
//#endif 


//#if -597970677 
import org.argouml.model.Model;
//#endif 


//#if -1268232623 
import org.argouml.uml.ui.UMLPlainTextDocument;
//#endif 


//#if 627962771 
import javax.swing.text.AttributeSet;
//#endif 


//#if 767266052 
import javax.swing.text.BadLocationException;
//#endif 


//#if -1304381730 
public class UMLSynchStateBoundDocument extends 
//#if 1277886585 
UMLPlainTextDocument
//#endif 

  { 

//#if 1648623953 
private static final long serialVersionUID = -1391739151659430935L;
//#endif 


//#if 880034312 
protected String getProperty()
    { 

//#if 2083976477 
int bound = Model.getFacade().getBound(getTarget());
//#endif 


//#if -1462166057 
if(bound <= 0)//1
{ 

//#if -1947096153 
return "*";
//#endif 

} 
else
{ 

//#if -734616647 
return String.valueOf(bound);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1194639956 
public void insertString(int offset, String str, AttributeSet a)
    throws BadLocationException
    { 

//#if 1577500386 
try //1
{ 

//#if -817988961 
Integer.parseInt(str);
//#endif 


//#if -935287694 
super.insertString(offset, str, a);
//#endif 

} 

//#if -762803637 
catch (NumberFormatException e) //1
{ 
} 

//#endif 


//#endif 

} 

//#endif 


//#if -1181328461 
protected void setProperty(String text)
    { 

//#if 1941613925 
if(text.equals(""))//1
{ 

//#if -989483265 
Model.getStateMachinesHelper().setBound(getTarget(), 0);
//#endif 

} 
else
{ 

//#if -957047525 
Model.getStateMachinesHelper()
            .setBound(getTarget(), Integer.valueOf(text).intValue());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 437763910 
public UMLSynchStateBoundDocument()
    { 

//#if 284631070 
super("bound");
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

