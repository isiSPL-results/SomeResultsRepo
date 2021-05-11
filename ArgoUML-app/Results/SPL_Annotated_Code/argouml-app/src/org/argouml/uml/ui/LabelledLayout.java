// Compilation Unit of /LabelledLayout.java 
 
package org.argouml.uml.ui;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
class Seperator extends JPanel
  { 
private static final long serialVersionUID = -4143634500959911688L;
Seperator()
    { 
super.setVisible(false);
} 

 } 

class LabelledLayout implements LayoutManager
, java.io.Serializable
  { 
private static final long serialVersionUID = -5596655602155151443L;
private int hgap;
private int vgap;
private boolean ignoreSplitters;
public LabelledLayout()
    { 
ignoreSplitters = false;
hgap = 0;
vgap = 0;
} 

private void layoutSection(
        final Container parent,
        final int sectionX,
        final int sectionWidth,
        final ArrayList components,
        final int sectionNo)
    { 
final ArrayList<Integer> rowHeights = new ArrayList<Integer>();
final int componentCount = components.size();
if(componentCount == 0)//1
{ 
return;
} 

int labelWidth = 0;
int unknownHeightCount = 0;
int totalHeight = 0;
for (int i = 0; i < componentCount; ++i) //1
{ 
final Component childComp = (Component) components.get(i);
final int childHeight;
if(childComp instanceof JLabel)//1
{ 
final JLabel jlabel = (JLabel) childComp;
final Component labelledComp = jlabel.getLabelFor();
labelWidth = Math.max(labelWidth, getPreferredWidth(jlabel));
if(labelledComp != null)//1
{ 
++i;
childHeight = getChildHeight(labelledComp);
if(childHeight == 0)//1
{ 
++unknownHeightCount;
} 

} 
else
{ 
childHeight = getPreferredHeight(jlabel);
} 

} 
else
{ 
childHeight = getChildHeight(childComp);
if(childHeight == 0)//1
{ 
++unknownHeightCount;
} 

} 

totalHeight += childHeight + this.vgap;
rowHeights.add(new Integer(childHeight));
} 

totalHeight -= this.vgap;
final Insets insets = parent.getInsets();
final int parentHeight =
            parent.getHeight() - (insets.top + insets.bottom);
int y = insets.top;
int row = 0;
for (int i = 0; i < componentCount; ++i) //2
{ 
Component childComp = (Component) components.get(i);
if(childComp.isVisible())//1
{ 
int rowHeight;
int componentWidth = sectionWidth;
int componentX = sectionX;
if(childComp instanceof JLabel
                        && ((JLabel) childComp).getLabelFor() != null)//1
{ 
i++;
final JLabel jlabel = (JLabel) childComp;
childComp = jlabel.getLabelFor();
jlabel.setBounds(sectionX, y, labelWidth,
                                     getPreferredHeight(jlabel));
componentWidth = sectionWidth - (labelWidth);
componentX = sectionX + labelWidth;
} 

rowHeight = rowHeights.get(row).intValue();
if(rowHeight == 0)//1
{ 
try //1
{ 
rowHeight = calculateHeight(
                                        parentHeight,
                                        totalHeight,
                                        unknownHeightCount--,
                                        childComp);
} 
catch (ArithmeticException e) //1
{ 
String lookAndFeel =
                            UIManager.getLookAndFeel().getClass().getName();
throw new IllegalStateException(
                            "Division by zero laying out "
                            + childComp.getClass().getName()
                            + " on " + parent.getClass().getName()
                            + " in section " + sectionNo
                            + " using "
                            + lookAndFeel,
                            e);
} 


totalHeight += rowHeight;
} 

if(childComp.getMaximumSize() != null
                        && getMaximumWidth(childComp) < componentWidth)//1
{ 
componentWidth = getMaximumWidth(childComp);
} 

childComp.setBounds(componentX, y, componentWidth, rowHeight);
y += rowHeight + this.vgap;
++row;
} 

} 

} 

private int getPreferredWidth(final Component comp)
    { 
return (int) comp.getPreferredSize().getWidth();
} 

public Dimension preferredLayoutSize(Container parent)
    { 
synchronized (parent.getTreeLock()) //1
{ 
final Insets insets = parent.getInsets();
int preferredWidth = 0;
int preferredHeight = 0;
int widestLabel = 0;
final int componentCount = parent.getComponentCount();
for (int i = 0; i < componentCount; ++i) //1
{ 
Component childComp = parent.getComponent(i);
if(childComp.isVisible()
                        && !(childComp instanceof Seperator))//1
{ 
int childHeight = getPreferredHeight(childComp);
if(childComp instanceof JLabel)//1
{ 
final JLabel jlabel = (JLabel) childComp;
widestLabel =
                            Math.max(widestLabel, getPreferredWidth(jlabel));
childComp = jlabel.getLabelFor();
final int childWidth = getPreferredWidth(childComp);
preferredWidth =
                            Math.max(preferredWidth, childWidth);
childHeight =
                            Math.min(childHeight, getPreferredHeight(jlabel));
} 

preferredHeight += childHeight + this.vgap;
} 

} 

preferredWidth += insets.left + widestLabel + insets.right;
preferredHeight += insets.top + insets.bottom;
return new Dimension(
                       insets.left + widestLabel + preferredWidth + insets.right,
                       preferredHeight);
} 

} 

private boolean isResizable(Component comp)
    { 
if(comp == null)//1
{ 
return false;
} 

if(comp instanceof JComboBox)//1
{ 
return false;
} 

if(comp.getPreferredSize() == null)//1
{ 
return false;
} 

if(comp.getMinimumSize() == null)//1
{ 
return false;
} 

return (getMinimumHeight(comp) < getPreferredHeight(comp));
} 

public void addLayoutComponent(String name, Component comp)
    { 
} 

public void setHgap(int hgap)
    { 
this.hgap = hgap;
} 

private int getMinimumHeight(final Component comp)
    { 
return (int) comp.getMinimumSize().getHeight();
} 

public static Seperator getSeparator()
    { 
return new Seperator();
} 

public LabelledLayout(boolean ignoreSplitters)
    { 
this.ignoreSplitters = ignoreSplitters;
this.hgap = 0;
this.vgap = 0;
} 

public void setVgap(int vgap)
    { 
this.vgap = vgap;
} 

private int getSectionCount(Container parent)
    { 
int sectionCount = 1;
final int componentCount = parent.getComponentCount();
if(!ignoreSplitters)//1
{ 
for (int i = 0; i < componentCount; ++i) //1
{ 
if(parent.getComponent(i) instanceof Seperator)//1
{ 
++sectionCount;
} 

} 

} 

return sectionCount;
} 

public Dimension minimumLayoutSize(Container parent)
    { 
synchronized (parent.getTreeLock()) //1
{ 
final Insets insets = parent.getInsets();
int minimumHeight = insets.top + insets.bottom;
final int componentCount = parent.getComponentCount();
for (int i = 0; i < componentCount; ++i) //1
{ 
Component childComp = parent.getComponent(i);
if(childComp instanceof JLabel)//1
{ 
final JLabel jlabel = (JLabel) childComp;
childComp = jlabel.getLabelFor();
final int childHeight = Math.max(
                                                getMinimumHeight(childComp),
                                                getMinimumHeight(jlabel));
minimumHeight += childHeight + this.vgap;
} 

} 

return new Dimension(0, minimumHeight);
} 

} 

public void removeLayoutComponent(Component comp)
    { 
} 

public LabelledLayout(int hgap, int vgap)
    { 
this.ignoreSplitters = false;
this.hgap = hgap;
this.vgap = vgap;
} 

private int getUsableWidth(Container parent)
    { 
final Insets insets = parent.getInsets();
return parent.getWidth() - (insets.left + insets.right);
} 

private int getPreferredHeight(final Component comp)
    { 
return (int) comp.getPreferredSize().getHeight();
} 

private int getChildHeight(Component childComp)
    { 
if(isResizable(childComp))//1
{ 
return 0;
} 
else
{ 
return getMinimumHeight(childComp);
} 

} 

public int getVgap()
    { 
return this.vgap;
} 

private final int calculateHeight(
        final int parentHeight,
        final int totalHeight,
        final int unknownHeightsLeft,
        final Component childComp)
    { 
return Math.max(
                   (parentHeight - totalHeight) / unknownHeightsLeft,
                   getMinimumHeight(childComp));
} 

private int getMaximumWidth(final Component comp)
    { 
return (int) comp.getMaximumSize().getWidth();
} 

public void layoutContainer(Container parent)
    { 
synchronized (parent.getTreeLock()) //1
{ 
int sectionX = parent.getInsets().left;
final ArrayList<Component> components = new ArrayList<Component>();
final int sectionCount = getSectionCount(parent);
final int sectionWidth = getSectionWidth(parent, sectionCount);
int sectionNo = 0;
for (int i = 0; i < parent.getComponentCount(); ++i) //1
{ 
final Component childComp = parent.getComponent(i);
if(childComp instanceof Seperator)//1
{ 
if(!this.ignoreSplitters)//1
{ 
layoutSection(
                            parent,
                            sectionX,
                            sectionWidth,
                            components,
                            sectionNo++);
sectionX += sectionWidth + this.hgap;
components.clear();
} 

} 
else
{ 
components.add(parent.getComponent(i));
} 

} 

layoutSection(
                parent,
                sectionX,
                sectionWidth,
                components,
                sectionNo);
} 

} 

public int getHgap()
    { 
return this.hgap;
} 

private int getSectionWidth(Container parent, int sectionCount)
    { 
return (getUsableWidth(parent) - (sectionCount - 1) * this.hgap)
               / sectionCount;
} 

 } 


