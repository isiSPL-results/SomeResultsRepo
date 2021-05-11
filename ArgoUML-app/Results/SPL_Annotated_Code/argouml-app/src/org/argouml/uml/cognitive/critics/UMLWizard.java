// Compilation Unit of /UMLWizard.java 
 
package org.argouml.uml.cognitive.critics;
import org.argouml.cognitive.ToDoItem;
import org.argouml.cognitive.ListSet;
import org.argouml.cognitive.critics.Wizard;
import org.argouml.model.Model;
public abstract class UMLWizard extends Wizard
  { 
private String suggestion;
public UMLWizard()
    { 
super();
} 

public Object getModelElement()
    { 
if(getToDoItem() != null)//1
{ 
ToDoItem item = (ToDoItem) getToDoItem();
ListSet offs = item.getOffenders();
if(offs.size() >= 1)//1
{ 
Object me = offs.get(0);
return me;
} 

} 

return null;
} 

public String offerSuggestion()
    { 
if(suggestion != null)//1
{ 
return suggestion;
} 

Object me = getModelElement();
if(me != null)//1
{ 
String n = Model.getFacade().getName(me);
return n;
} 

return "";
} 

public int getNumSteps()
    { 
return 1;
} 

public void setSuggestion(String s)
    { 
suggestion = s;
} 

public String getSuggestion()
    { 
return suggestion;
} 

 } 


