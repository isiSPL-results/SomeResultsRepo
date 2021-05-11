
//#if -1673439921 
// Compilation Unit of /StylePanelFigPackage.java 
 

//#if 154153127 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -586324429 
import java.awt.event.ItemEvent;
//#endif 


//#if 1170314311 
import javax.swing.JCheckBox;
//#endif 


//#if -1826164223 
import org.argouml.ui.StylePanelFigNodeModelElement;
//#endif 


//#if -1700316081 
import org.argouml.uml.diagram.StereotypeContainer;
//#endif 


//#if 1860688943 
import org.argouml.uml.diagram.VisibilityContainer;
//#endif 


//#if 112873816 
public class StylePanelFigPackage extends 
//#if -1809634453 
StylePanelFigNodeModelElement
//#endif 

  { 

//#if 652732254 
private JCheckBox stereoCheckBox = new JCheckBox("Stereotype");
//#endif 


//#if 1548820248 
private JCheckBox visibilityCheckBox = new JCheckBox("Visibility");
//#endif 


//#if 536068664 
private boolean refreshTransaction;
//#endif 


//#if -164775090 
private static final long serialVersionUID = -41790550511653720L;
//#endif 


//#if -1594294982 
public StylePanelFigPackage()
    { 

//#if -721106130 
super();
//#endif 


//#if -838596840 
addToDisplayPane(stereoCheckBox);
//#endif 


//#if 1913909830 
stereoCheckBox.setSelected(false);
//#endif 


//#if -256077292 
stereoCheckBox.addItemListener(this);
//#endif 


//#if -687551438 
addToDisplayPane(visibilityCheckBox);
//#endif 


//#if -574168262 
visibilityCheckBox.addItemListener(this);
//#endif 

} 

//#endif 


//#if -1166653359 
public void itemStateChanged(ItemEvent e)
    { 

//#if -772081477 
if(!refreshTransaction)//1
{ 

//#if -880854121 
Object src = e.getSource();
//#endif 


//#if 386096713 
if(src == stereoCheckBox)//1
{ 

//#if 1047169976 
((StereotypeContainer) getPanelTarget())
                .setStereotypeVisible(stereoCheckBox.isSelected());
//#endif 

} 
else

//#if 749330163 
if(src == visibilityCheckBox)//1
{ 

//#if 99106467 
((VisibilityContainer) getPanelTarget())
                .setVisibilityVisible(visibilityCheckBox.isSelected());
//#endif 

} 
else
{ 

//#if -28393451 
super.itemStateChanged(e);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 

} 

//#endif 


//#if -1455835388 
public void refresh()
    { 

//#if 785377247 
refreshTransaction = true;
//#endif 


//#if -720199234 
super.refresh();
//#endif 


//#if -1227430857 
StereotypeContainer stc = (StereotypeContainer) getPanelTarget();
//#endif 


//#if -363625205 
stereoCheckBox.setSelected(stc.isStereotypeVisible());
//#endif 


//#if 1431256678 
VisibilityContainer vc = (VisibilityContainer) getPanelTarget();
//#endif 


//#if -889163648 
visibilityCheckBox.setSelected(vc.isVisibilityVisible());
//#endif 


//#if -1839870394 
refreshTransaction = false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

