
//#if -996426620 
// Compilation Unit of /UMLComboBoxNavigator.java 
 

//#if 2109224111 
package org.argouml.uml.ui;
//#endif 


//#if 489724051 
import java.awt.BorderLayout;
//#endif 


//#if 1852085831 
import java.awt.Dimension;
//#endif 


//#if -1467729109 
import java.awt.event.ActionListener;
//#endif 


//#if 817690330 
import java.awt.event.ItemEvent;
//#endif 


//#if 1803799918 
import java.awt.event.ItemListener;
//#endif 


//#if 940027801 
import javax.swing.ImageIcon;
//#endif 


//#if -1250595503 
import javax.swing.JButton;
//#endif 


//#if -1044990330 
import javax.swing.JComboBox;
//#endif 


//#if -1459312721 
import javax.swing.JPanel;
//#endif 


//#if -1308691817 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -1154917372 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if 1729322544 
public class UMLComboBoxNavigator extends 
//#if 343665833 
JPanel
//#endif 

 implements 
//#if -719269127 
ActionListener
//#endif 

, 
//#if -481275242 
ItemListener
//#endif 

  { 

//#if 1104776502 
private static ImageIcon icon = ResourceLoaderWrapper
                                    .lookupIconResource("ComboNav");
//#endif 


//#if -1979048896 
private JComboBox theComboBox;
//#endif 


//#if -1138649440 
private JButton theButton;
//#endif 


//#if 1570986189 
@Override
    public Dimension getPreferredSize()
    { 

//#if 1796079788 
return new Dimension(
                   super.getPreferredSize().width,
                   getMinimumSize().height);
//#endif 

} 

//#endif 


//#if -1160398765 
public void setEnabled(boolean enabled)
    { 

//#if -912474828 
theComboBox.setEnabled(enabled);
//#endif 


//#if 1849973063 
theComboBox.setEditable(enabled);
//#endif 

} 

//#endif 


//#if 1074257764 
private void setButtonEnabled(Object item)
    { 

//#if -656908792 
if(item != null)//1
{ 

//#if -1480897877 
theButton.setEnabled(true);
//#endif 

} 
else
{ 

//#if -887497277 
theButton.setEnabled(false);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1638537712 
public void itemStateChanged(ItemEvent event)
    { 

//#if -511091043 
if(event.getSource() == theComboBox)//1
{ 

//#if -2065640874 
Object item = theComboBox.getSelectedItem();
//#endif 


//#if 999252693 
setButtonEnabled(item);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1056941135 
public void actionPerformed(final java.awt.event.ActionEvent event)
    { 

//#if -1233997488 
if(event.getSource() == theButton)//1
{ 

//#if -1317017852 
Object item = theComboBox.getSelectedItem();
//#endif 


//#if 1357751596 
if(item != null)//1
{ 

//#if 741741180 
TargetManager.getInstance().setTarget(item);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1208864645 
if(event.getSource() == theComboBox)//1
{ 

//#if -974051035 
Object item = theComboBox.getSelectedItem();
//#endif 


//#if -316006556 
setButtonEnabled(item);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -232276287 
public UMLComboBoxNavigator(String tooltip, JComboBox box)
    { 

//#if 115227291 
super(new BorderLayout());
//#endif 


//#if -1601478116 
theButton = new JButton(icon);
//#endif 


//#if 1201166816 
theComboBox = box;
//#endif 


//#if 98765172 
theButton.setPreferredSize(new Dimension(icon.getIconWidth() + 6, icon
                                   .getIconHeight() + 6));
//#endif 


//#if -1996973945 
theButton.setToolTipText(tooltip);
//#endif 


//#if -1074911527 
theButton.addActionListener(this);
//#endif 


//#if -1851598383 
box.addActionListener(this);
//#endif 


//#if -667913196 
box.addItemListener(this);
//#endif 


//#if 1451314617 
add(theComboBox, BorderLayout.CENTER);
//#endif 


//#if 801375094 
add(theButton, BorderLayout.EAST);
//#endif 


//#if 1131361280 
Object item = theComboBox.getSelectedItem();
//#endif 


//#if 1787804415 
setButtonEnabled(item);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

