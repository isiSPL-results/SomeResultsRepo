
//#if -627299252 
// Compilation Unit of /NameOrder.java 
 

//#if 1248722682 
package org.argouml.ui.explorer;
//#endif 


//#if 575296788 
import java.text.Collator;
//#endif 


//#if 1576752533 
import java.util.Comparator;
//#endif 


//#if -1311281410 
import javax.swing.tree.DefaultMutableTreeNode;
//#endif 


//#if 1672905278 
import org.argouml.i18n.Translator;
//#endif 


//#if 1578362371 
import org.argouml.model.InvalidElementException;
//#endif 


//#if 190716932 
import org.argouml.model.Model;
//#endif 


//#if -535616700 
import org.argouml.profile.Profile;
//#endif 


//#if 898604618 
import org.argouml.kernel.ProfileConfiguration;
//#endif 


//#if 1987382069 
import org.tigris.gef.base.Diagram;
//#endif 


//#if 122387839 
public class NameOrder implements 
//#if -1032891629 
Comparator
//#endif 

  { 

//#if 1113905864 
private Collator collator = Collator.getInstance();
//#endif 


//#if -1142529826 
public NameOrder()
    { 

//#if -342437619 
collator.setStrength(Collator.PRIMARY);
//#endif 

} 

//#endif 


//#if -1454079754 
@Override
    public String toString()
    { 

//#if -621345021 
return Translator.localize("combobox.order-by-name");
//#endif 

} 

//#endif 


//#if -1832430865 
private String getName(Object obj)
    { 

//#if 1608130125 
String name;
//#endif 


//#if 1081996785 
if(obj instanceof Diagram)//1
{ 

//#if -1800529186 
name = ((Diagram) obj).getName();
//#endif 

} 
else

//#if 954397571 
if(obj instanceof ProfileConfiguration)//1
{ 

//#if 38855451 
name = "Profile Configuration";
//#endif 

} 
else

//#if 1179600131 
if(obj instanceof Profile)//1
{ 

//#if -1923884106 
name = ((Profile) obj).getDisplayName();
//#endif 

} 
else

//#if -1212487062 
if(Model.getFacade().isAModelElement(obj))//1
{ 

//#if -697838009 
try //1
{ 

//#if -1872192819 
name = Model.getFacade().getName(obj);
//#endif 

} 

//#if -836516525 
catch (InvalidElementException e) //1
{ 

//#if 1831405618 
name = Translator.localize("misc.name.deleted");
//#endif 

} 

//#endif 


//#endif 

} 
else
{ 

//#if -529071629 
name = "??";
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#if -1866019405 
if(name == null)//1
{ 

//#if -48914148 
return "";
//#endif 

} 

//#endif 


//#if -35654482 
return name;
//#endif 

} 

//#endif 


//#if 501409718 
protected int compareUserObjects(Object obj, Object obj1)
    { 

//#if -1649744080 
return collator.compare(getName(obj), getName(obj1));
//#endif 

} 

//#endif 


//#if 2111394632 
public int compare(Object obj1, Object obj2)
    { 

//#if -1452850798 
if(obj1 instanceof DefaultMutableTreeNode)//1
{ 

//#if 1407569868 
DefaultMutableTreeNode node = (DefaultMutableTreeNode) obj1;
//#endif 


//#if 1389552960 
obj1 = node.getUserObject();
//#endif 

} 

//#endif 


//#if -1123085037 
if(obj2 instanceof DefaultMutableTreeNode)//1
{ 

//#if 1216105093 
DefaultMutableTreeNode node = (DefaultMutableTreeNode) obj2;
//#endif 


//#if 193831579 
obj2 = node.getUserObject();
//#endif 

} 

//#endif 


//#if -1507608169 
return compareUserObjects(obj1, obj2);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

