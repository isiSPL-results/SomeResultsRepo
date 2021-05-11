
//#if 1207268431 
// Compilation Unit of /UMLModelElementNamespaceComboBoxModel.java 
 

//#if -710183964 
package org.argouml.uml.ui.foundation.core;
//#endif 


//#if 1570429551 
import java.util.ArrayList;
//#endif 


//#if -1516693294 
import java.util.Collection;
//#endif 


//#if 200451652 
import java.util.Set;
//#endif 


//#if -362905214 
import java.util.TreeSet;
//#endif 


//#if 2009713260 
import org.apache.log4j.Logger;
//#endif 


//#if 1139607486 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -437717537 
import org.argouml.model.Model;
//#endif 


//#if -1718935912 
import org.argouml.model.UmlChangeEvent;
//#endif 


//#if 1722397593 
import org.argouml.uml.ui.UMLComboBoxModel2;
//#endif 


//#if 187975862 
import org.argouml.uml.util.PathComparator;
//#endif 


//#if -116036945 
public class UMLModelElementNamespaceComboBoxModel extends 
//#if -274105174 
UMLComboBoxModel2
//#endif 

  { 

//#if -513176878 
private static final Logger LOG =
        Logger.getLogger(UMLModelElementNamespaceComboBoxModel.class);
//#endif 


//#if -878159092 
private static final long serialVersionUID = -775116993155949065L;
//#endif 


//#if 1512464224 
@Override
    public void modelChanged(UmlChangeEvent evt)
    { 

//#if 1811769155 
Object t = getTarget();
//#endif 


//#if -1913397753 
if(t != null
                && evt.getSource() == t
                && evt.getNewValue() != null)//1
{ 

//#if 108214740 
buildMinimalModelList();
//#endif 


//#if 2117573585 
setSelectedItem(getSelectedModelElement());
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1006351637 
@Override
    protected boolean isLazy()
    { 

//#if -2104739588 
return true;
//#endif 

} 

//#endif 


//#if 966213344 
public UMLModelElementNamespaceComboBoxModel()
    { 

//#if 591639243 
super("namespace", true);
//#endif 


//#if -1699598296 
Model.getPump().addClassModelEventListener(this,
                Model.getMetaTypes().getNamespace(), "ownedElement");
//#endif 

} 

//#endif 


//#if 1718401676 
protected void buildModelList()
    { 

//#if -1066153887 
Set<Object> elements = new TreeSet<Object>(new PathComparator());
//#endif 


//#if 88330971 
Object model =
            ProjectManager.getManager().getCurrentProject().getRoot();
//#endif 


//#if -904021939 
Object target = getTarget();
//#endif 


//#if -1196645492 
elements.addAll(
            Model.getCoreHelper().getAllPossibleNamespaces(target, model));
//#endif 


//#if -1277149100 
if(target != null)//1
{ 

//#if 974258282 
Object namespace = Model.getFacade().getNamespace(target);
//#endif 


//#if -986082211 
if(namespace != null && !elements.contains(namespace))//1
{ 

//#if 2125570232 
elements.add(namespace);
//#endif 


//#if 96533205 
LOG.warn("The current namespace is not a valid one!");
//#endif 

} 

//#endif 

} 

//#endif 


//#if 581881433 
removeAllElements();
//#endif 


//#if -985156578 
addAll(elements);
//#endif 

} 

//#endif 


//#if -1992285715 
protected boolean isValidElement(Object o)
    { 

//#if 1859677651 
return Model.getFacade().isANamespace(o)
               && Model.getCoreHelper().isValidNamespace(getTarget(), o);
//#endif 

} 

//#endif 


//#if -1182879761 
@Override
    protected void buildMinimalModelList()
    { 

//#if -104766220 
Object target = getTarget();
//#endif 


//#if -112251434 
Collection c = new ArrayList(1);
//#endif 


//#if 542127675 
if(target != null)//1
{ 

//#if -2010944207 
Object namespace = Model.getFacade().getNamespace(target);
//#endif 


//#if -1126613544 
if(namespace != null && !c.contains(namespace))//1
{ 

//#if -154654864 
c.add(namespace);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1216042522 
setElements(c);
//#endif 


//#if 1829870934 
setModelInvalid();
//#endif 

} 

//#endif 


//#if 1000957800 
protected Object getSelectedModelElement()
    { 

//#if -248605780 
if(getTarget() != null)//1
{ 

//#if 1314944653 
return Model.getFacade().getNamespace(getTarget());
//#endif 

} 

//#endif 


//#if 1421258240 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

