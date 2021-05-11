// Compilation Unit of /ActionNavigateUpNextDown.java 
 
package org.argouml.uml.ui;
import java.util.Iterator;
import java.util.List;
import javax.swing.Action;
import org.argouml.application.helpers.ResourceLoaderWrapper;
public abstract class ActionNavigateUpNextDown extends AbstractActionNavigate
  { 
public abstract Object getParent(Object child);
public abstract List getFamily(Object parent);
protected Object navigateTo(Object source)
    { 
Object up = getParent(source);
List family = getFamily(up);
assert family.contains(source);
Iterator it = family.iterator();
while (it.hasNext()) //1
{ 
Object child = it.next();
if(child == source)//1
{ 
if(it.hasNext())//1
{ 
return it.next();
} 
else
{ 
return null;
} 

} 

} 

return null;
} 

public ActionNavigateUpNextDown()
    { 
super("button.go-up-next-down", true);
putValue(Action.SMALL_ICON,
                 ResourceLoaderWrapper.lookupIconResource("NavigateUpNext"));
} 

 } 


