
//#if -324538583 
// Compilation Unit of /ActionNavigateUpPreviousDown.java 
 

//#if 856799912 
package org.argouml.uml.ui;
//#endif 


//#if 1038558986 
import java.util.Iterator;
//#endif 


//#if -1046230182 
import java.util.List;
//#endif 


//#if -751592550 
import javax.swing.Action;
//#endif 


//#if 1971960400 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1403544330 
public abstract class ActionNavigateUpPreviousDown extends 
//#if -1959507190 
AbstractActionNavigate
//#endif 

  { 

//#if 521175368 
public abstract List getFamily(Object parent);
//#endif 


//#if -1417655866 
public ActionNavigateUpPreviousDown()
    { 

//#if -1895617844 
super("button.go-up-previous-down", true);
//#endif 


//#if -7502470 
putValue(Action.SMALL_ICON,
                 ResourceLoaderWrapper.lookupIconResource("NavigateUpPrevious"));
//#endif 

} 

//#endif 


//#if 2118490687 
public abstract Object getParent(Object child);
//#endif 


//#if -1856284129 
protected Object navigateTo(Object source)
    { 

//#if 1589173528 
Object up = getParent(source);
//#endif 


//#if 254434870 
List family = getFamily(up);
//#endif 


//#if -1089833678 
assert family.contains(source);
//#endif 


//#if 1218312262 
Iterator it = family.iterator();
//#endif 


//#if 910142669 
Object previous = null;
//#endif 


//#if -1521057014 
while (it.hasNext()) //1
{ 

//#if 909348647 
Object child = it.next();
//#endif 


//#if 907666167 
if(child == source)//1
{ 

//#if 61314287 
return previous;
//#endif 

} 

//#endif 


//#if 1840874754 
previous = child;
//#endif 

} 

//#endif 


//#if 2007948260 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

