
//#if 2074175595 
// Compilation Unit of /StylePanelFigMessage.java 
 

//#if -441570868 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 189574434 
import java.awt.event.ItemEvent;
//#endif 


//#if 893642046 
import javax.swing.JComboBox;
//#endif 


//#if -1221337849 
import javax.swing.JLabel;
//#endif 


//#if 603572880 
import org.argouml.i18n.Translator;
//#endif 


//#if -1043043472 
import org.argouml.ui.StylePanelFigNodeModelElement;
//#endif 


//#if -1644207096 
public class StylePanelFigMessage extends 
//#if -1344722912 
StylePanelFigNodeModelElement
//#endif 

  { 

//#if 706746954 
private JLabel arrowLabel = new JLabel(Translator.localize("label.localize"));
//#endif 


//#if 1026039927 
private JComboBox arrowField = new JComboBox(FigMessage.getArrowDirections().toArray());
//#endif 


//#if -2046596836 
@Override
    public void itemStateChanged(ItemEvent e)
    { 

//#if 1255766927 
Object src = e.getSource();
//#endif 


//#if -246589705 
if(src == arrowField)//1
{ 

//#if -329959120 
setTargetArrow();
//#endif 

} 
else
{ 

//#if -946421667 
super.itemStateChanged(e);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 27784550 
public StylePanelFigMessage()
    { 

//#if 1397021433 
super();
//#endif 


//#if 1592372659 
arrowField.addItemListener(this);
//#endif 


//#if 984193053 
arrowLabel.setLabelFor(arrowField);
//#endif 


//#if 70300414 
add(arrowLabel);
//#endif 


//#if -727749756 
add(arrowField);
//#endif 


//#if 1658789010 
arrowField.setSelectedIndex(0);
//#endif 


//#if 1574577118 
remove(getFillField());
//#endif 


//#if -298355496 
remove(getFillLabel());
//#endif 

} 

//#endif 


//#if 1266849594 
public void setTargetArrow()
    { 

//#if 1960621177 
String ad = (String) arrowField.getSelectedItem();
//#endif 


//#if 482979142 
int arrowDirection = FigMessage.getArrowDirections().indexOf(ad);
//#endif 


//#if -2025110539 
if(getPanelTarget() == null || arrowDirection == -1)//1
{ 

//#if 1267801981 
return;
//#endif 

} 

//#endif 


//#if 901560925 
((FigMessage) getPanelTarget()).setArrow(arrowDirection);
//#endif 


//#if -1833944322 
getPanelTarget().endTrans();
//#endif 

} 

//#endif 


//#if -2034168807 
@Override
    public void refresh()
    { 

//#if 7972696 
super.refresh();
//#endif 


//#if 1179061571 
int direction = ((FigMessage) getPanelTarget()).getArrow();
//#endif 


//#if -511161320 
arrowField.setSelectedItem(FigMessage.getArrowDirections()
                                   .get(direction));
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

