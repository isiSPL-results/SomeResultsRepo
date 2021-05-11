
//#if -74465249 
// Compilation Unit of /StylePanelFigUseCase.java 
 

//#if 2000931339 
package org.argouml.uml.diagram.use_case.ui;
//#endif 


//#if 1234025873 
import java.awt.event.ItemEvent;
//#endif 


//#if 402237865 
import javax.swing.JCheckBox;
//#endif 


//#if 1530916447 
import org.argouml.ui.StylePanelFigNodeModelElement;
//#endif 


//#if -1181667391 
import org.argouml.i18n.Translator;
//#endif 


//#if -1703211577 
public class StylePanelFigUseCase extends 
//#if 405468397 
StylePanelFigNodeModelElement
//#endif 

  { 

//#if -1369742323 
private JCheckBox epCheckBox =
        new JCheckBox(Translator.localize("checkbox.extension-points"));
//#endif 


//#if -635500236 
private boolean refreshTransaction = false;
//#endif 


//#if -2056515313 
public void itemStateChanged(ItemEvent e)
    { 

//#if -1996361856 
if(!refreshTransaction)//1
{ 

//#if -981511581 
if(e.getSource() == epCheckBox)//1
{ 

//#if 827297528 
FigUseCase target = (FigUseCase) getTarget();
//#endif 


//#if 1121047850 
target.setExtensionPointVisible(epCheckBox.isSelected());
//#endif 

} 
else
{ 

//#if 220850795 
super.itemStateChanged(e);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -726900663 
public StylePanelFigUseCase()
    { 

//#if -1803527444 
super();
//#endif 


//#if -894306163 
addToDisplayPane(epCheckBox);
//#endif 


//#if -239285961 
epCheckBox.setSelected(false);
//#endif 


//#if -775321213 
epCheckBox.addItemListener(this);
//#endif 

} 

//#endif 


//#if 660937478 
public void refresh()
    { 

//#if -1232345000 
refreshTransaction = true;
//#endif 


//#if 1695492919 
super.refresh();
//#endif 


//#if -172088843 
FigUseCase target = (FigUseCase) getTarget();
//#endif 


//#if -1076873997 
epCheckBox.setSelected(target.isExtensionPointVisible());
//#endif 


//#if 35249389 
refreshTransaction = false;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

