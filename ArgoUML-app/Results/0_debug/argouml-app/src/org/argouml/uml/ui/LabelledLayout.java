
//#if 1253957295 
// Compilation Unit of /LabelledLayout.java 
 

//#if 136760444 
package org.argouml.uml.ui;
//#endif 


//#if 95392803 
import java.awt.Component;
//#endif 


//#if 688084255 
import java.awt.Container;
//#endif 


//#if 957173978 
import java.awt.Dimension;
//#endif 


//#if -813786912 
import java.awt.Insets;
//#endif 


//#if 693396029 
import java.awt.LayoutManager;
//#endif 


//#if 1931587707 
import java.util.ArrayList;
//#endif 


//#if 1792970515 
import javax.swing.JComboBox;
//#endif 


//#if 1825868626 
import javax.swing.JLabel;
//#endif 


//#if 1940742722 
import javax.swing.JPanel;
//#endif 


//#if 817091233 
import javax.swing.UIManager;
//#endif 


//#if 1971586267 
class Seperator extends 
//#if -855868548 
JPanel
//#endif 

  { 

//#if 1065560944 
private static final long serialVersionUID = -4143634500959911688L;
//#endif 


//#if -1696837728 
Seperator()
    { 

//#if -1182102830 
super.setVisible(false);
//#endif 

} 

//#endif 

 } 

//#endif 


//#if 1629062503 
class LabelledLayout implements 
//#if 1602134859 
LayoutManager
//#endif 

, 
//#if -1677037101 
java.io.Serializable
//#endif 

  { 

//#if -2012860206 
private static final long serialVersionUID = -5596655602155151443L;
//#endif 


//#if 246687945 
private int hgap;
//#endif 


//#if 259617239 
private int vgap;
//#endif 


//#if 1907149982 
private boolean ignoreSplitters;
//#endif 


//#if 1402492067 
public LabelledLayout()
    { 

//#if -1916356846 
ignoreSplitters = false;
//#endif 


//#if -188536701 
hgap = 0;
//#endif 


//#if -648387055 
vgap = 0;
//#endif 

} 

//#endif 


//#if -1645524140 
private void layoutSection(
        final Container parent,
        final int sectionX,
        final int sectionWidth,
        final ArrayList components,
        final int sectionNo)
    { 

//#if 1063320270 
final ArrayList<Integer> rowHeights = new ArrayList<Integer>();
//#endif 


//#if -1136492470 
final int componentCount = components.size();
//#endif 


//#if -906593852 
if(componentCount == 0)//1
{ 

//#if -1810238390 
return;
//#endif 

} 

//#endif 


//#if -1018214448 
int labelWidth = 0;
//#endif 


//#if -584189948 
int unknownHeightCount = 0;
//#endif 


//#if -1702931549 
int totalHeight = 0;
//#endif 


//#if 6986977 
for (int i = 0; i < componentCount; ++i) //1
{ 

//#if 1826483043 
final Component childComp = (Component) components.get(i);
//#endif 


//#if -606446118 
final int childHeight;
//#endif 


//#if -1301300377 
if(childComp instanceof JLabel)//1
{ 

//#if -1199197407 
final JLabel jlabel = (JLabel) childComp;
//#endif 


//#if 2024121578 
final Component labelledComp = jlabel.getLabelFor();
//#endif 


//#if 140210736 
labelWidth = Math.max(labelWidth, getPreferredWidth(jlabel));
//#endif 


//#if -1344493451 
if(labelledComp != null)//1
{ 

//#if -1900308236 
++i;
//#endif 


//#if -1527332361 
childHeight = getChildHeight(labelledComp);
//#endif 


//#if 2141710046 
if(childHeight == 0)//1
{ 

//#if -347651780 
++unknownHeightCount;
//#endif 

} 

//#endif 

} 
else
{ 

//#if 1807121521 
childHeight = getPreferredHeight(jlabel);
//#endif 

} 

//#endif 

} 
else
{ 

//#if 1438268564 
childHeight = getChildHeight(childComp);
//#endif 


//#if -819056472 
if(childHeight == 0)//1
{ 

//#if -617234826 
++unknownHeightCount;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1573704551 
totalHeight += childHeight + this.vgap;
//#endif 


//#if 875467496 
rowHeights.add(new Integer(childHeight));
//#endif 

} 

//#endif 


//#if -1159676899 
totalHeight -= this.vgap;
//#endif 


//#if -775323346 
final Insets insets = parent.getInsets();
//#endif 


//#if -143788026 
final int parentHeight =
            parent.getHeight() - (insets.top + insets.bottom);
//#endif 


//#if -1951810220 
int y = insets.top;
//#endif 


//#if -1729347852 
int row = 0;
//#endif 


//#if 1990678064 
for (int i = 0; i < componentCount; ++i) //2
{ 

//#if -496315492 
Component childComp = (Component) components.get(i);
//#endif 


//#if -1329105303 
if(childComp.isVisible())//1
{ 

//#if 2122694697 
int rowHeight;
//#endif 


//#if 1356922389 
int componentWidth = sectionWidth;
//#endif 


//#if -459761963 
int componentX = sectionX;
//#endif 


//#if 2025149232 
if(childComp instanceof JLabel
                        && ((JLabel) childComp).getLabelFor() != null)//1
{ 

//#if -153898248 
i++;
//#endif 


//#if 1511381856 
final JLabel jlabel = (JLabel) childComp;
//#endif 


//#if -893271685 
childComp = jlabel.getLabelFor();
//#endif 


//#if -1274028872 
jlabel.setBounds(sectionX, y, labelWidth,
                                     getPreferredHeight(jlabel));
//#endif 


//#if 943600974 
componentWidth = sectionWidth - (labelWidth);
//#endif 


//#if -1061949811 
componentX = sectionX + labelWidth;
//#endif 

} 

//#endif 


//#if -468863861 
rowHeight = rowHeights.get(row).intValue();
//#endif 


//#if -1447814590 
if(rowHeight == 0)//1
{ 

//#if 1528124157 
try //1
{ 

//#if -1104786908 
rowHeight = calculateHeight(
                                        parentHeight,
                                        totalHeight,
                                        unknownHeightCount--,
                                        childComp);
//#endif 

} 

//#if 1876322207 
catch (ArithmeticException e) //1
{ 

//#if 126822986 
String lookAndFeel =
                            UIManager.getLookAndFeel().getClass().getName();
//#endif 


//#if -623416790 
throw new IllegalStateException(
                            "Division by zero laying out "
                            + childComp.getClass().getName()
                            + " on " + parent.getClass().getName()
                            + " in section " + sectionNo
                            + " using "
                            + lookAndFeel,
                            e);
//#endif 

} 

//#endif 


//#endif 


//#if -1359675568 
totalHeight += rowHeight;
//#endif 

} 

//#endif 


//#if 748338822 
if(childComp.getMaximumSize() != null
                        && getMaximumWidth(childComp) < componentWidth)//1
{ 

//#if -1040695375 
componentWidth = getMaximumWidth(childComp);
//#endif 

} 

//#endif 


//#if 1371072320 
childComp.setBounds(componentX, y, componentWidth, rowHeight);
//#endif 


//#if 1190306016 
y += rowHeight + this.vgap;
//#endif 


//#if 326492353 
++row;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1415794050 
private int getPreferredWidth(final Component comp)
    { 

//#if -468250242 
return (int) comp.getPreferredSize().getWidth();
//#endif 

} 

//#endif 


//#if 681382911 
public Dimension preferredLayoutSize(Container parent)
    { 

//#if 1762820997 
synchronized (parent.getTreeLock()) //1
{ 

//#if 1368261958 
final Insets insets = parent.getInsets();
//#endif 


//#if -2007157691 
int preferredWidth = 0;
//#endif 


//#if 640383006 
int preferredHeight = 0;
//#endif 


//#if 93080134 
int widestLabel = 0;
//#endif 


//#if -358240331 
final int componentCount = parent.getComponentCount();
//#endif 


//#if 389105401 
for (int i = 0; i < componentCount; ++i) //1
{ 

//#if 1423830406 
Component childComp = parent.getComponent(i);
//#endif 


//#if 129624814 
if(childComp.isVisible()
                        && !(childComp instanceof Seperator))//1
{ 

//#if 1381290568 
int childHeight = getPreferredHeight(childComp);
//#endif 


//#if 726753414 
if(childComp instanceof JLabel)//1
{ 

//#if 1140905495 
final JLabel jlabel = (JLabel) childComp;
//#endif 


//#if 770587080 
widestLabel =
                            Math.max(widestLabel, getPreferredWidth(jlabel));
//#endif 


//#if -216747932 
childComp = jlabel.getLabelFor();
//#endif 


//#if 1964217683 
final int childWidth = getPreferredWidth(childComp);
//#endif 


//#if -1708827052 
preferredWidth =
                            Math.max(preferredWidth, childWidth);
//#endif 


//#if 171385033 
childHeight =
                            Math.min(childHeight, getPreferredHeight(jlabel));
//#endif 

} 

//#endif 


//#if 331190885 
preferredHeight += childHeight + this.vgap;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 443610872 
preferredWidth += insets.left + widestLabel + insets.right;
//#endif 


//#if -746777443 
preferredHeight += insets.top + insets.bottom;
//#endif 


//#if 1544615456 
return new Dimension(
                       insets.left + widestLabel + preferredWidth + insets.right,
                       preferredHeight);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 2104189281 
private boolean isResizable(Component comp)
    { 

//#if -1332920971 
if(comp == null)//1
{ 

//#if 254944921 
return false;
//#endif 

} 

//#endif 


//#if -882745443 
if(comp instanceof JComboBox)//1
{ 

//#if 10457297 
return false;
//#endif 

} 

//#endif 


//#if -1699663740 
if(comp.getPreferredSize() == null)//1
{ 

//#if 12905976 
return false;
//#endif 

} 

//#endif 


//#if 1386638993 
if(comp.getMinimumSize() == null)//1
{ 

//#if 238138260 
return false;
//#endif 

} 

//#endif 


//#if 1859515965 
return (getMinimumHeight(comp) < getPreferredHeight(comp));
//#endif 

} 

//#endif 


//#if -236986164 
public void addLayoutComponent(String name, Component comp)
    { 
} 

//#endif 


//#if 514979673 
public void setHgap(int hgap)
    { 

//#if 1946148951 
this.hgap = hgap;
//#endif 

} 

//#endif 


//#if -1869423634 
private int getMinimumHeight(final Component comp)
    { 

//#if 1355106536 
return (int) comp.getMinimumSize().getHeight();
//#endif 

} 

//#endif 


//#if 2022233410 
public static Seperator getSeparator()
    { 

//#if 296650717 
return new Seperator();
//#endif 

} 

//#endif 


//#if -1731017807 
public LabelledLayout(boolean ignoreSplitters)
    { 

//#if 384719819 
this.ignoreSplitters = ignoreSplitters;
//#endif 


//#if -1927391117 
this.hgap = 0;
//#endif 


//#if 1907725825 
this.vgap = 0;
//#endif 

} 

//#endif 


//#if 715234165 
public void setVgap(int vgap)
    { 

//#if -1599724824 
this.vgap = vgap;
//#endif 

} 

//#endif 


//#if -444206070 
private int getSectionCount(Container parent)
    { 

//#if 768913655 
int sectionCount = 1;
//#endif 


//#if 239530317 
final int componentCount = parent.getComponentCount();
//#endif 


//#if 1537201507 
if(!ignoreSplitters)//1
{ 

//#if 1896824197 
for (int i = 0; i < componentCount; ++i) //1
{ 

//#if 1603153377 
if(parent.getComponent(i) instanceof Seperator)//1
{ 

//#if -1918338496 
++sectionCount;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -562773192 
return sectionCount;
//#endif 

} 

//#endif 


//#if 2132913554 
public Dimension minimumLayoutSize(Container parent)
    { 

//#if 422291364 
synchronized (parent.getTreeLock()) //1
{ 

//#if 1887522879 
final Insets insets = parent.getInsets();
//#endif 


//#if -214672729 
int minimumHeight = insets.top + insets.bottom;
//#endif 


//#if -1147944612 
final int componentCount = parent.getComponentCount();
//#endif 


//#if -901972942 
for (int i = 0; i < componentCount; ++i) //1
{ 

//#if 1444593030 
Component childComp = parent.getComponent(i);
//#endif 


//#if -1817751339 
if(childComp instanceof JLabel)//1
{ 

//#if 823362043 
final JLabel jlabel = (JLabel) childComp;
//#endif 


//#if 1148659200 
childComp = jlabel.getLabelFor();
//#endif 


//#if 1581405507 
final int childHeight = Math.max(
                                                getMinimumHeight(childComp),
                                                getMinimumHeight(jlabel));
//#endif 


//#if -145681511 
minimumHeight += childHeight + this.vgap;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -737105263 
return new Dimension(0, minimumHeight);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1505276309 
public void removeLayoutComponent(Component comp)
    { 
} 

//#endif 


//#if -964784593 
public LabelledLayout(int hgap, int vgap)
    { 

//#if 1043541569 
this.ignoreSplitters = false;
//#endif 


//#if 1064077508 
this.hgap = hgap;
//#endif 


//#if -1674182268 
this.vgap = vgap;
//#endif 

} 

//#endif 


//#if -1385131222 
private int getUsableWidth(Container parent)
    { 

//#if -1495129688 
final Insets insets = parent.getInsets();
//#endif 


//#if 1495937011 
return parent.getWidth() - (insets.left + insets.right);
//#endif 

} 

//#endif 


//#if 1314730785 
private int getPreferredHeight(final Component comp)
    { 

//#if -54097444 
return (int) comp.getPreferredSize().getHeight();
//#endif 

} 

//#endif 


//#if -620580956 
private int getChildHeight(Component childComp)
    { 

//#if -751557682 
if(isResizable(childComp))//1
{ 

//#if -504696613 
return 0;
//#endif 

} 
else
{ 

//#if 1717841899 
return getMinimumHeight(childComp);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 844683049 
public int getVgap()
    { 

//#if 1207371818 
return this.vgap;
//#endif 

} 

//#endif 


//#if 1360230930 
private final int calculateHeight(
        final int parentHeight,
        final int totalHeight,
        final int unknownHeightsLeft,
        final Component childComp)
    { 

//#if 394296606 
return Math.max(
                   (parentHeight - totalHeight) / unknownHeightsLeft,
                   getMinimumHeight(childComp));
//#endif 

} 

//#endif 


//#if 420956483 
private int getMaximumWidth(final Component comp)
    { 

//#if 160623547 
return (int) comp.getMaximumSize().getWidth();
//#endif 

} 

//#endif 


//#if -1254245372 
public void layoutContainer(Container parent)
    { 

//#if 1896938289 
synchronized (parent.getTreeLock()) //1
{ 

//#if -409173040 
int sectionX = parent.getInsets().left;
//#endif 


//#if -1380189787 
final ArrayList<Component> components = new ArrayList<Component>();
//#endif 


//#if -1648884968 
final int sectionCount = getSectionCount(parent);
//#endif 


//#if 166288336 
final int sectionWidth = getSectionWidth(parent, sectionCount);
//#endif 


//#if 769199019 
int sectionNo = 0;
//#endif 


//#if -1545275529 
for (int i = 0; i < parent.getComponentCount(); ++i) //1
{ 

//#if 1512201105 
final Component childComp = parent.getComponent(i);
//#endif 


//#if -704541879 
if(childComp instanceof Seperator)//1
{ 

//#if 945572134 
if(!this.ignoreSplitters)//1
{ 

//#if -1929272212 
layoutSection(
                            parent,
                            sectionX,
                            sectionWidth,
                            components,
                            sectionNo++);
//#endif 


//#if 795604005 
sectionX += sectionWidth + this.hgap;
//#endif 


//#if 1128256616 
components.clear();
//#endif 

} 

//#endif 

} 
else
{ 

//#if -992333004 
components.add(parent.getComponent(i));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1341694499 
layoutSection(
                parent,
                sectionX,
                sectionWidth,
                components,
                sectionNo);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 443874935 
public int getHgap()
    { 

//#if -1689330513 
return this.hgap;
//#endif 

} 

//#endif 


//#if 792121574 
private int getSectionWidth(Container parent, int sectionCount)
    { 

//#if -665875449 
return (getUsableWidth(parent) - (sectionCount - 1) * this.hgap)
               / sectionCount;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

