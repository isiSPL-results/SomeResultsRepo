package org.argouml.ui;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import org.argouml.i18n.Translator;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.argouml.uml.diagram.ui.FigStereotypesGroup;
public class ShadowComboBox extends JComboBox
  { 
private static final long serialVersionUID = 3440806802523267746L;
private static ShadowFig[]  shadowFigs;
public ShadowComboBox()
    { 
super();
addItem(Translator.localize("label.stylepane.no-shadow"));
addItem("1");
addItem("2");
addItem("3");
addItem("4");
addItem("5");
addItem("6");
addItem("7");
addItem("8");
setRenderer(new ShadowRenderer());
} 
private class ShadowRenderer extends JComponent
 implements ListCellRenderer
  { 
private static final long serialVersionUID = 5939340501470674464L;
private ShadowFig  currentFig;
public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus)
        { 
if(shadowFigs == null)//1
{ 
shadowFigs = new ShadowFig[ShadowComboBox.this.getItemCount()];
for (int i = 0; i < shadowFigs.length; ++i) //1
{ 
shadowFigs[i] = new ShadowFig();
shadowFigs[i].setShadowSize(i);
shadowFigs[i].setName(
                        (String) ShadowComboBox.this.getItemAt(i));
} 
} 
if(isSelected)//1
{ 
setBackground(list.getSelectionBackground());
} 
else
{ 
setBackground(list.getBackground());
} 
int figIndex = index;
if(figIndex < 0)//1
{ 
for (int i = 0; i < shadowFigs.length; ++i) //1
{ 
if(value == ShadowComboBox.this.getItemAt(i))//1
{ 
figIndex = i;
} 
} 
} 
if(figIndex >= 0)//1
{ 
currentFig = shadowFigs[figIndex];
setPreferredSize(new Dimension(
                                     currentFig.getWidth() + figIndex + 4,
                                     currentFig.getHeight() + figIndex + 2));
} 
else
{ 
currentFig = null;
} 
return this;
} 
protected void paintComponent(Graphics g)
        { 
g.setColor(getBackground());
g.fillRect(0, 0, getWidth(), getHeight());
if(currentFig != null)//1
{ 
currentFig.setLocation(2, 1);
currentFig.paint(g);
} 
} 
public ShadowRenderer()
        { 
super();
} 

 } 
private static class ShadowFig extends FigNodeModelElement
  { 
private static final long serialVersionUID = 4999132551417131227L;
public void setName(String text)
        { 
getNameFig().setText(text);
} 
public ShadowFig()
        { 
super();
addFig(getBigPort());
addFig(getNameFig());
} 
public void setShadowSize(int size)
        { 
super.setShadowSizeFriend(size);
} 
protected FigStereotypesGroup createStereotypeFig()
        { 
return null;
} 

 } 

 } 
