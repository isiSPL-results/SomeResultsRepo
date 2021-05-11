
//#if -784394920 
// Compilation Unit of /UMLEditableComboBox.java 
 

//#if -67434183 
package org.argouml.uml.ui;
//#endif 


//#if 370176669 
import java.awt.BorderLayout;
//#endif 


//#if -1573762106 
import java.awt.Component;
//#endif 


//#if -848198029 
import java.awt.event.ActionEvent;
//#endif 


//#if 1670802229 
import java.awt.event.ActionListener;
//#endif 


//#if 434207901 
import java.awt.event.FocusEvent;
//#endif 


//#if 2091764939 
import java.awt.event.FocusListener;
//#endif 


//#if 1435350761 
import javax.swing.Action;
//#endif 


//#if 1937112601 
import javax.swing.BorderFactory;
//#endif 


//#if 1710299765 
import javax.swing.ComboBoxEditor;
//#endif 


//#if -321848826 
import javax.swing.Icon;
//#endif 


//#if 156713717 
import javax.swing.JLabel;
//#endif 


//#if 271587813 
import javax.swing.JPanel;
//#endif 


//#if -243861956 
import javax.swing.JTextField;
//#endif 


//#if 1273372315 
import javax.swing.border.BevelBorder;
//#endif 


//#if -174150316 
import javax.swing.plaf.basic.BasicComboBoxEditor;
//#endif 


//#if 258221217 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if -377956841 
public abstract class UMLEditableComboBox extends 
//#if 1082334978 
UMLComboBox2
//#endif 

 implements 
//#if 1536515787 
FocusListener
//#endif 

  { 

//#if -884206746 
protected abstract void doOnEdit(Object item);
//#endif 


//#if 765225359 
public UMLEditableComboBox(UMLComboBoxModel2 model, Action selectAction,
                               boolean showIcon)
    { 

//#if 792696177 
super(model, selectAction, showIcon);
//#endif 


//#if -805885853 
setEditable(true);
//#endif 


//#if 1573146293 
setEditor(new UMLComboBoxEditor(showIcon));
//#endif 


//#if -1553247624 
getEditor().addActionListener(this);
//#endif 

} 

//#endif 


//#if 517471468 
public void actionPerformed(ActionEvent e)
    { 

//#if -1127486904 
super.actionPerformed(e);
//#endif 


//#if -581209421 
if(e.getSource() instanceof JTextField)//1
{ 

//#if 1870023321 
Object oldValue = getSelectedItem();
//#endif 


//#if 1492165388 
ComboBoxEditor editor = getEditor();
//#endif 


//#if 876606648 
Object item = editor.getItem();
//#endif 


//#if 776841224 
doOnEdit(item);
//#endif 


//#if -688728791 
if(oldValue == getSelectedItem())//1
{ 

//#if 450666915 
getEditor().setItem(getSelectedItem());
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -728288197 
public final void focusGained(FocusEvent arg0)
    { 
} 

//#endif 


//#if 202262785 
public final void focusLost(FocusEvent arg0)
    { 

//#if 666833423 
doOnEdit(getEditor().getItem());
//#endif 

} 

//#endif 


//#if -395172692 
public UMLEditableComboBox(UMLComboBoxModel2 arg0, Action selectAction)
    { 

//#if 10441950 
this(arg0, selectAction, true);
//#endif 

} 

//#endif 


//#if -892010189 
protected class UMLComboBoxEditor extends 
//#if 1522171953 
BasicComboBoxEditor
//#endif 

  { 

//#if -758860200 
private UMLImagePanel panel;
//#endif 


//#if 1818810560 
private boolean theShowIcon;
//#endif 


//#if -1644479995 
public UMLComboBoxEditor(boolean showIcon)
        { 

//#if -926901616 
super();
//#endif 


//#if -351056218 
panel = new UMLImagePanel(editor, showIcon);
//#endif 


//#if 692112169 
setShowIcon(showIcon);
//#endif 

} 

//#endif 


//#if -662873699 
public void removeActionListener(ActionListener l)
        { 

//#if 1835969205 
panel.removeActionListener(l);
//#endif 

} 

//#endif 


//#if 677938239 
public void setShowIcon(boolean showIcon)
        { 

//#if -423792388 
theShowIcon = showIcon;
//#endif 

} 

//#endif 


//#if 1771956840 
public void addActionListener(ActionListener l)
        { 

//#if -586726921 
panel.addActionListener(l);
//#endif 

} 

//#endif 


//#if -1220615609 
public void setItem(Object anObject)
        { 

//#if -140398549 
if(((UMLComboBoxModel2) getModel()).contains(anObject))//1
{ 

//#if 2120404488 
editor.setText(((UMLListCellRenderer2) getRenderer())
                               .makeText(anObject));
//#endif 


//#if 285471355 
if(theShowIcon && (anObject != null))//1

//#if -768283581 
panel.setIcon(ResourceLoaderWrapper.getInstance()
                                  .lookupIcon(anObject));
//#endif 


//#endif 

} 
else
{ 

//#if 416061038 
super.setItem(anObject);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -261233598 
public void selectAll()
        { 

//#if -1906027309 
super.selectAll();
//#endif 

} 

//#endif 


//#if 391347547 
public Object getItem()
        { 

//#if -1098615598 
return panel.getText();
//#endif 

} 

//#endif 


//#if -1984010680 
public Component getEditorComponent()
        { 

//#if -1492826876 
return panel;
//#endif 

} 

//#endif 


//#if 210503961 
public boolean isShowIcon()
        { 

//#if -951242729 
return theShowIcon;
//#endif 

} 

//#endif 


//#if 1945767457 
private class UMLImagePanel extends 
//#if 2079997985 
JPanel
//#endif 

  { 

//#if 270587111 
private JLabel imageIconLabel = new JLabel();
//#endif 


//#if 1150699008 
private JTextField theTextField;
//#endif 


//#if -1999770622 
public void selectAll()
            { 

//#if -887728505 
theTextField.selectAll();
//#endif 

} 

//#endif 


//#if 530800202 
public void setIcon(Icon i)
            { 

//#if 1342848152 
if(i != null)//1
{ 

//#if 405967151 
imageIconLabel.setIcon(i);
//#endif 


//#if 1738962639 
imageIconLabel.setBorder(BorderFactory
                                             .createEmptyBorder(0, 2, 0, 2));
//#endif 

} 
else
{ 

//#if 1966278506 
imageIconLabel.setIcon(null);
//#endif 


//#if 230170583 
imageIconLabel.setBorder(null);
//#endif 

} 

//#endif 


//#if 1691701920 
imageIconLabel.invalidate();
//#endif 


//#if -500037195 
validate();
//#endif 


//#if -2138621922 
repaint();
//#endif 

} 

//#endif 


//#if -316722851 
public void removeActionListener(ActionListener l)
            { 

//#if -1699396079 
theTextField.removeActionListener(l);
//#endif 

} 

//#endif 


//#if 956073294 
public void setText(String text)
            { 

//#if 1869334381 
theTextField.setText(text);
//#endif 

} 

//#endif 


//#if 789806920 
public UMLImagePanel(JTextField textField, boolean showIcon)
            { 

//#if -684954740 
setLayout(new BorderLayout());
//#endif 


//#if -94539058 
theTextField = textField;
//#endif 


//#if -1840792532 
setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
//#endif 


//#if -349675160 
if(showIcon)//1
{ 

//#if 85679592 
imageIconLabel.setOpaque(true);
//#endif 


//#if -174197376 
imageIconLabel.setBackground(theTextField.getBackground());
//#endif 


//#if 357323071 
add(imageIconLabel, BorderLayout.WEST);
//#endif 

} 

//#endif 


//#if -1004489545 
add(theTextField, BorderLayout.CENTER);
//#endif 


//#if -2089715947 
theTextField.addFocusListener(UMLEditableComboBox.this);
//#endif 

} 

//#endif 


//#if -1683242973 
public String getText()
            { 

//#if -494696182 
return theTextField.getText();
//#endif 

} 

//#endif 


//#if 1901144744 
public void addActionListener(ActionListener l)
            { 

//#if -184631469 
theTextField.addActionListener(l);
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

