
//#if 835258313 
// Compilation Unit of /StylePanelFigClass.java 
 

//#if -327207687 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if 1889027973 
import java.awt.event.ItemEvent;
//#endif 


//#if -1072082786 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1099465781 
import javax.swing.JCheckBox;
//#endif 


//#if -50532019 
import org.argouml.i18n.Translator;
//#endif 


//#if 1987442259 
import org.argouml.ui.StylePanelFigNodeModelElement;
//#endif 


//#if -1188792572 
import org.argouml.uml.diagram.AttributesCompartmentContainer;
//#endif 


//#if 1135650703 
import org.argouml.uml.diagram.OperationsCompartmentContainer;
//#endif 


//#if 335147228 
public class StylePanelFigClass extends 
//#if 805878381 
StylePanelFigNodeModelElement
//#endif 

  { 

//#if -598318087 
private JCheckBox attrCheckBox =
        new JCheckBox(Translator.localize("checkbox.attributes"));
//#endif 


//#if 677544235 
private JCheckBox operCheckBox =
        new JCheckBox(Translator.localize("checkbox.operations"));
//#endif 


//#if 546701370 
private boolean refreshTransaction;
//#endif 


//#if -1153754995 
private static final long serialVersionUID = 4587367369055254943L;
//#endif 


//#if -1628144753 
public void itemStateChanged(ItemEvent e)
    { 

//#if -871581056 
if(!refreshTransaction)//1
{ 

//#if -1885763419 
Object src = e.getSource();
//#endif 


//#if -1532319408 
if(src == attrCheckBox)//1
{ 

//#if 764378015 
((AttributesCompartmentContainer) getPanelTarget())
                .setAttributesVisible(attrCheckBox.isSelected());
//#endif 

} 
else

//#if 1889761219 
if(src == operCheckBox)//1
{ 

//#if -1546185460 
((OperationsCompartmentContainer) getPanelTarget())
                .setOperationsVisible(operCheckBox.isSelected());
//#endif 

} 
else
{ 

//#if 2081843482 
super.itemStateChanged(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if 332025578 
public StylePanelFigClass()
    { 

//#if 293789101 
super();
//#endif 


//#if -144526542 
addToDisplayPane(attrCheckBox);
//#endif 


//#if 604958543 
addToDisplayPane(operCheckBox);
//#endif 


//#if 1501006334 
attrCheckBox.setSelected(false);
//#endif 


//#if 1851381979 
operCheckBox.setSelected(false);
//#endif 


//#if -277790884 
attrCheckBox.addItemListener(this);
//#endif 


//#if 992520031 
operCheckBox.addItemListener(this);
//#endif 

} 

//#endif 


//#if 1328791686 
public void refresh()
    { 

//#if 950776932 
refreshTransaction = true;
//#endif 


//#if 1947321155 
super.refresh();
//#endif 


//#if -293452804 
AttributesCompartmentContainer ac =
            (AttributesCompartmentContainer) getPanelTarget();
//#endif 


//#if 417568300 
attrCheckBox.setSelected(ac.isAttributesVisible());
//#endif 


//#if 141290904 
OperationsCompartmentContainer oc =
            (OperationsCompartmentContainer) getPanelTarget();
//#endif 


//#if 1131771436 
operCheckBox.setSelected(oc.isOperationsVisible());
//#endif 


//#if -1007447455 
refreshTransaction = false;
//#endif 

} 

//#endif 


//#if -1469533546 
public void refresh(PropertyChangeEvent e)
    { 

//#if -281923717 
String propertyName = e.getPropertyName();
//#endif 


//#if 1704843614 
if(propertyName.equals("bounds"))//1
{ 

//#if -607847135 
refresh();
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

