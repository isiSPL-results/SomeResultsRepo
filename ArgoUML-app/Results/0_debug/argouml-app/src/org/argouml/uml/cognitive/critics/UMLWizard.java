
//#if 2007953810 
// Compilation Unit of /UMLWizard.java 
 

//#if -174754744 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if 1584999 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 232718482 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 381795494 
import org.argouml.cognitive.critics.Wizard;
//#endif 


//#if 308123262 
import org.argouml.model.Model;
//#endif 


//#if 1238994679 
public abstract class UMLWizard extends 
//#if 1535957461 
Wizard
//#endif 

  { 

//#if 853896333 
private String suggestion;
//#endif 


//#if 1175280621 
public UMLWizard()
    { 

//#if 1663496855 
super();
//#endif 

} 

//#endif 


//#if 556092216 
public Object getModelElement()
    { 

//#if 314337478 
if(getToDoItem() != null)//1
{ 

//#if 1012346584 
ToDoItem item = (ToDoItem) getToDoItem();
//#endif 


//#if 1623683420 
ListSet offs = item.getOffenders();
//#endif 


//#if -599176371 
if(offs.size() >= 1)//1
{ 

//#if -1177650907 
Object me = offs.get(0);
//#endif 


//#if -2086200660 
return me;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 745855598 
return null;
//#endif 

} 

//#endif 


//#if -478090659 
public String offerSuggestion()
    { 

//#if -1587620812 
if(suggestion != null)//1
{ 

//#if 197925845 
return suggestion;
//#endif 

} 

//#endif 


//#if -164511663 
Object me = getModelElement();
//#endif 


//#if -714939448 
if(me != null)//1
{ 

//#if -1784806211 
String n = Model.getFacade().getName(me);
//#endif 


//#if 243664743 
return n;
//#endif 

} 

//#endif 


//#if -15751547 
return "";
//#endif 

} 

//#endif 


//#if -846002916 
public int getNumSteps()
    { 

//#if -544321969 
return 1;
//#endif 

} 

//#endif 


//#if 1491795056 
public void setSuggestion(String s)
    { 

//#if 42425709 
suggestion = s;
//#endif 

} 

//#endif 


//#if -492503209 
public String getSuggestion()
    { 

//#if -1718589730 
return suggestion;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

