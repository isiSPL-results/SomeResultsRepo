package org.argouml.uml.diagram.use_case.ui;
import java.awt.event.ItemEvent;
import javax.swing.JCheckBox;
import org.argouml.ui.StylePanelFigNodeModelElement;
import org.argouml.i18n.Translator;
public class StylePanelFigUseCase extends StylePanelFigNodeModelElement
  { 
private JCheckBox epCheckBox =
        new JCheckBox(Translator.localize("checkbox.extension-points"));
private boolean refreshTransaction = false;
public void itemStateChanged(ItemEvent e)
    { 
if(!refreshTransaction)//1
{ 
if(e.getSource() == epCheckBox)//1
{ 
FigUseCase target = (FigUseCase) getTarget();
target.setExtensionPointVisible(epCheckBox.isSelected());
} 
else
{ 
super.itemStateChanged(e);
} 
} 
} 
public StylePanelFigUseCase()
    { 
super();
addToDisplayPane(epCheckBox);
epCheckBox.setSelected(false);
epCheckBox.addItemListener(this);
} 
public void refresh()
    { 
refreshTransaction = true;
super.refresh();
FigUseCase target = (FigUseCase) getTarget();
epCheckBox.setSelected(target.isExtensionPointVisible());
refreshTransaction = false;
} 

 } 
