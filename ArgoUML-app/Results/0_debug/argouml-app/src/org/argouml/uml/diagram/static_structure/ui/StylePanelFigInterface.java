
//#if 405825095 
// Compilation Unit of /StylePanelFigInterface.java 
 

//#if 2069570505 
package org.argouml.uml.diagram.static_structure.ui;
//#endif 


//#if -444350891 
import java.awt.event.ItemEvent;
//#endif 


//#if 203226981 
import javax.swing.JCheckBox;
//#endif 


//#if 89253155 
import org.argouml.ui.StylePanelFigNodeModelElement;
//#endif 


//#if -1204263571 
public class StylePanelFigInterface extends 
//#if -821074668 
StylePanelFigNodeModelElement
//#endif 

  { 

//#if 1001465265 
private JCheckBox operCheckBox = new JCheckBox("Operations");
//#endif 


//#if 828964705 
private boolean refreshTransaction;
//#endif 


//#if 2076037265 
private static final long serialVersionUID = -5908351031706234211L;
//#endif 


//#if -1451216860 
public StylePanelFigInterface()
    { 

//#if -869760770 
super();
//#endif 


//#if -96460578 
addToDisplayPane(operCheckBox);
//#endif 


//#if 1582225708 
operCheckBox.setSelected(false);
//#endif 


//#if 1261992302 
operCheckBox.addItemListener(this);
//#endif 

} 

//#endif 


//#if -2016854035 
public void refresh()
    { 

//#if -1797908227 
refreshTransaction = true;
//#endif 


//#if -357379876 
super.refresh();
//#endif 


//#if -1003851130 
FigInterface ti = (FigInterface) getPanelTarget();
//#endif 


//#if 1396336532 
operCheckBox.setSelected(ti.isOperationsVisible());
//#endif 


//#if -317341464 
refreshTransaction = false;
//#endif 

} 

//#endif 


//#if -1481253688 
public void itemStateChanged(ItemEvent e)
    { 

//#if -489478564 
if(!refreshTransaction)//1
{ 

//#if 1831394939 
Object src = e.getSource();
//#endif 


//#if 885499907 
if(src == operCheckBox)//1
{ 

//#if 1540957858 
((FigInterface) getPanelTarget())
                .setOperationsVisible(operCheckBox.isSelected());
//#endif 

} 
else
{ 

//#if 1754520655 
super.itemStateChanged(e);
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

