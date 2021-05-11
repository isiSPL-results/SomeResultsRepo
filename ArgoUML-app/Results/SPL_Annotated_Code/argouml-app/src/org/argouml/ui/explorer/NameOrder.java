// Compilation Unit of /NameOrder.java 
 
package org.argouml.ui.explorer;
import java.text.Collator;
import java.util.Comparator;
import javax.swing.tree.DefaultMutableTreeNode;
import org.argouml.i18n.Translator;
import org.argouml.model.InvalidElementException;
import org.argouml.model.Model;
import org.argouml.profile.Profile;
import org.argouml.kernel.ProfileConfiguration;
import org.tigris.gef.base.Diagram;
public class NameOrder implements Comparator
  { 
private Collator collator = Collator.getInstance();
public NameOrder()
    { 
collator.setStrength(Collator.PRIMARY);
} 

@Override
    public String toString()
    { 
return Translator.localize("combobox.order-by-name");
} 

private String getName(Object obj)
    { 
String name;
if(obj instanceof Diagram)//1
{ 
name = ((Diagram) obj).getName();
} 
else
if(obj instanceof ProfileConfiguration)//1
{ 
name = "Profile Configuration";
} 
else
if(obj instanceof Profile)//1
{ 
name = ((Profile) obj).getDisplayName();
} 
else
if(Model.getFacade().isAModelElement(obj))//1
{ 
try //1
{ 
name = Model.getFacade().getName(obj);
} 
catch (InvalidElementException e) //1
{ 
name = Translator.localize("misc.name.deleted");
} 


} 
else
{ 
name = "??";
} 




if(name == null)//1
{ 
return "";
} 

return name;
} 

protected int compareUserObjects(Object obj, Object obj1)
    { 
return collator.compare(getName(obj), getName(obj1));
} 

public int compare(Object obj1, Object obj2)
    { 
if(obj1 instanceof DefaultMutableTreeNode)//1
{ 
DefaultMutableTreeNode node = (DefaultMutableTreeNode) obj1;
obj1 = node.getUserObject();
} 

if(obj2 instanceof DefaultMutableTreeNode)//1
{ 
DefaultMutableTreeNode node = (DefaultMutableTreeNode) obj2;
obj2 = node.getUserObject();
} 

return compareUserObjects(obj1, obj2);
} 

 } 


