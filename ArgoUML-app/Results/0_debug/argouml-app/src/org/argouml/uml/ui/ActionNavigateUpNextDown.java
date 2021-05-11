
//#if -720029426 
// Compilation Unit of /ActionNavigateUpNextDown.java 
 

//#if -140144845 
package org.argouml.uml.ui;
//#endif 


//#if -1903094497 
import java.util.Iterator;
//#endif 


//#if 1060768751 
import java.util.List;
//#endif 


//#if 601721263 
import javax.swing.Action;
//#endif 


//#if -1411863525 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -228042661 
public abstract class ActionNavigateUpNextDown extends 
//#if 596241047 
AbstractActionNavigate
//#endif 

  { 

//#if -1965756084 
public abstract Object getParent(Object child);
//#endif 


//#if -857500517 
public abstract List getFamily(Object parent);
//#endif 


//#if -311351758 
protected Object navigateTo(Object source)
    { 

//#if -1715738142 
Object up = getParent(source);
//#endif 


//#if 1077810560 
List family = getFamily(up);
//#endif 


//#if 116898856 
assert family.contains(source);
//#endif 


//#if -820970864 
Iterator it = family.iterator();
//#endif 


//#if -1512235008 
while (it.hasNext()) //1
{ 

//#if 1686591613 
Object child = it.next();
//#endif 


//#if -329512499 
if(child == source)//1
{ 

//#if 643605932 
if(it.hasNext())//1
{ 

//#if 2106460764 
return it.next();
//#endif 

} 
else
{ 

//#if 251735651 
return null;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -60244818 
return null;
//#endif 

} 

//#endif 


//#if 1262208527 
public ActionNavigateUpNextDown()
    { 

//#if 515288171 
super("button.go-up-next-down", true);
//#endif 


//#if -1179028783 
putValue(Action.SMALL_ICON,
                 ResourceLoaderWrapper.lookupIconResource("NavigateUpNext"));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

