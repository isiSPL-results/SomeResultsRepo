
//#if 365518756 
// Compilation Unit of /StylePanelFigNodeModelElement.java 
 

//#if 529992882 
package org.argouml.ui;
//#endif 


//#if 1906978618 
import java.awt.FlowLayout;
//#endif 


//#if 901680588 
import java.awt.event.FocusListener;
//#endif 


//#if 107926033 
import java.awt.event.ItemEvent;
//#endif 


//#if 1339626199 
import java.awt.event.ItemListener;
//#endif 


//#if -1963370651 
import java.awt.event.KeyListener;
//#endif 


//#if 659079722 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 1099202590 
import java.beans.PropertyChangeListener;
//#endif 


//#if -834345687 
import javax.swing.JCheckBox;
//#endif 


//#if 743711030 
import javax.swing.JLabel;
//#endif 


//#if 858585126 
import javax.swing.JPanel;
//#endif 


//#if -832451775 
import org.argouml.i18n.Translator;
//#endif 


//#if 222717092 
import org.argouml.uml.diagram.PathContainer;
//#endif 


//#if 1969955198 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1905189058 
import org.tigris.gef.ui.ColorRenderer;
//#endif 


//#if 1526996933 
public class StylePanelFigNodeModelElement extends 
//#if 334486790 
StylePanelFig
//#endif 

 implements 
//#if 1317269874 
ItemListener
//#endif 

, 
//#if -930994559 
FocusListener
//#endif 

, 
//#if -491509176 
KeyListener
//#endif 

, 
//#if -1451230076 
PropertyChangeListener
//#endif 

  { 

//#if 1498795688 
private boolean refreshTransaction;
//#endif 


//#if 154674684 
private JLabel displayLabel = new JLabel(
        Translator.localize("label.stylepane.display"));
//#endif 


//#if 410798185 
private JCheckBox pathCheckBox = new JCheckBox(
        Translator.localize("label.stylepane.path"));
//#endif 


//#if 651157315 
private JPanel displayPane;
//#endif 


//#if 901515808 
public void propertyChange(PropertyChangeEvent evt)
    { 

//#if 1244490239 
if("pathVisible".equals(evt.getPropertyName()))//1
{ 

//#if 903312183 
refreshTransaction = true;
//#endif 


//#if -1189920141 
pathCheckBox.setSelected((Boolean) evt.getNewValue());
//#endif 


//#if 1816112622 
refreshTransaction = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 417178895 
public void addToDisplayPane(JCheckBox cb)
    { 

//#if 1955624426 
displayPane.add(cb);
//#endif 

} 

//#endif 


//#if -1019252441 
@Override
    public void setTarget(Object t)
    { 

//#if -1174844740 
Fig oldTarget = getPanelTarget();
//#endif 


//#if 183417218 
if(oldTarget != null)//1
{ 

//#if -1034574407 
oldTarget.removePropertyChangeListener(this);
//#endif 

} 

//#endif 


//#if -86968332 
super.setTarget(t);
//#endif 


//#if 1129098037 
Fig newTarget = getPanelTarget();
//#endif 


//#if -639458565 
if(newTarget != null)//1
{ 

//#if 857206530 
newTarget.addPropertyChangeListener(this);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1201308129 
public void itemStateChanged(ItemEvent e)
    { 

//#if -586750133 
if(!refreshTransaction)//1
{ 

//#if 735229479 
Object src = e.getSource();
//#endif 


//#if 2080944902 
if(src == pathCheckBox)//1
{ 

//#if 1095347448 
PathContainer pc = (PathContainer) getPanelTarget();
//#endif 


//#if 1491032600 
pc.setPathVisible(pathCheckBox.isSelected());
//#endif 

} 
else
{ 

//#if -1268720106 
super.itemStateChanged(e);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1971007789 
public StylePanelFigNodeModelElement()
    { 

//#if -1867659767 
super();
//#endif 


//#if -840912290 
getFillField().setRenderer(new ColorRenderer());
//#endif 


//#if -1781241905 
getLineField().setRenderer(new ColorRenderer());
//#endif 


//#if -695207587 
displayPane = new JPanel();
//#endif 


//#if 1088542328 
displayPane.setLayout(new FlowLayout(FlowLayout.LEFT));
//#endif 


//#if -1168606070 
addToDisplayPane(pathCheckBox);
//#endif 


//#if -1927824071 
displayLabel.setLabelFor(displayPane);
//#endif 


//#if -2121733329 
add(displayPane, 0);
//#endif 


//#if -415490375 
add(displayLabel, 0);
//#endif 


//#if 1799957708 
pathCheckBox.addItemListener(this);
//#endif 

} 

//#endif 


//#if -652654732 
public void refresh()
    { 

//#if 1928476486 
refreshTransaction = true;
//#endif 


//#if 548554789 
super.refresh();
//#endif 


//#if 1550616193 
Object target = getPanelTarget();
//#endif 


//#if 946025935 
if(target instanceof PathContainer)//1
{ 

//#if 792484129 
PathContainer pc = (PathContainer) getPanelTarget();
//#endif 


//#if 1839815455 
pathCheckBox.setSelected(pc.isPathVisible());
//#endif 

} 

//#endif 


//#if -763532353 
refreshTransaction = false;
//#endif 


//#if 1170579921 
setTargetBBox();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

