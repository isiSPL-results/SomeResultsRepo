
//#if -125297780 
// Compilation Unit of /ShadowComboBox.java 
 

//#if 279263690 
package org.argouml.ui;
//#endif 


//#if -1511995921 
import java.awt.Component;
//#endif 


//#if -650214746 
import java.awt.Dimension;
//#endif 


//#if 39534047 
import java.awt.Graphics;
//#endif 


//#if 665876935 
import javax.swing.JComboBox;
//#endif 


//#if -1252172619 
import javax.swing.JComponent;
//#endif 


//#if 145850150 
import javax.swing.JList;
//#endif 


//#if -2013103963 
import javax.swing.ListCellRenderer;
//#endif 


//#if -19065767 
import org.argouml.i18n.Translator;
//#endif 


//#if -1891435873 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if -1451648266 
import org.argouml.uml.diagram.ui.FigStereotypesGroup;
//#endif 


//#if -737776218 
public class ShadowComboBox extends 
//#if 982690582 
JComboBox
//#endif 

  { 

//#if -1447241901 
private static final long serialVersionUID = 3440806802523267746L;
//#endif 


//#if -142200666 
private static ShadowFig[]  shadowFigs;
//#endif 


//#if 1840741880 
public ShadowComboBox()
    { 

//#if -60585649 
super();
//#endif 


//#if -3783965 
addItem(Translator.localize("label.stylepane.no-shadow"));
//#endif 


//#if 1968693761 
addItem("1");
//#endif 


//#if 1968723552 
addItem("2");
//#endif 


//#if 1968753343 
addItem("3");
//#endif 


//#if 1968783134 
addItem("4");
//#endif 


//#if 1968812925 
addItem("5");
//#endif 


//#if 1968842716 
addItem("6");
//#endif 


//#if 1968872507 
addItem("7");
//#endif 


//#if 1968902298 
addItem("8");
//#endif 


//#if -2071990973 
setRenderer(new ShadowRenderer());
//#endif 

} 

//#endif 


//#if 1310468041 
private class ShadowRenderer extends 
//#if -959973941 
JComponent
//#endif 

 implements 
//#if 184132635 
ListCellRenderer
//#endif 

  { 

//#if -505209262 
private static final long serialVersionUID = 5939340501470674464L;
//#endif 


//#if -445695049 
private ShadowFig  currentFig;
//#endif 


//#if -1294695263 
public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus)
        { 

//#if 1116828218 
if(shadowFigs == null)//1
{ 

//#if 148621372 
shadowFigs = new ShadowFig[ShadowComboBox.this.getItemCount()];
//#endif 


//#if 958755880 
for (int i = 0; i < shadowFigs.length; ++i) //1
{ 

//#if -1087973615 
shadowFigs[i] = new ShadowFig();
//#endif 


//#if -63479648 
shadowFigs[i].setShadowSize(i);
//#endif 


//#if -871545282 
shadowFigs[i].setName(
                        (String) ShadowComboBox.this.getItemAt(i));
//#endif 

} 

//#endif 

} 

//#endif 


//#if 492224905 
if(isSelected)//1
{ 

//#if 57172774 
setBackground(list.getSelectionBackground());
//#endif 

} 
else
{ 

//#if -746758089 
setBackground(list.getBackground());
//#endif 

} 

//#endif 


//#if -1162720680 
int figIndex = index;
//#endif 


//#if 642958406 
if(figIndex < 0)//1
{ 

//#if -1340874981 
for (int i = 0; i < shadowFigs.length; ++i) //1
{ 

//#if -221602931 
if(value == ShadowComboBox.this.getItemAt(i))//1
{ 

//#if -745397547 
figIndex = i;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 610346319 
if(figIndex >= 0)//1
{ 

//#if -44781013 
currentFig = shadowFigs[figIndex];
//#endif 


//#if 2046209077 
setPreferredSize(new Dimension(
                                     currentFig.getWidth() + figIndex + 4,
                                     currentFig.getHeight() + figIndex + 2));
//#endif 

} 
else
{ 

//#if -1532947830 
currentFig = null;
//#endif 

} 

//#endif 


//#if 1929590814 
return this;
//#endif 

} 

//#endif 


//#if -419362548 
protected void paintComponent(Graphics g)
        { 

//#if 455974919 
g.setColor(getBackground());
//#endif 


//#if -1545398761 
g.fillRect(0, 0, getWidth(), getHeight());
//#endif 


//#if 3736753 
if(currentFig != null)//1
{ 

//#if 1144725706 
currentFig.setLocation(2, 1);
//#endif 


//#if 1116617825 
currentFig.paint(g);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1029858501 
public ShadowRenderer()
        { 

//#if 782216356 
super();
//#endif 

} 

//#endif 

 } 

//#endif 


//#if -638502484 
private static class ShadowFig extends 
//#if 324909618 
FigNodeModelElement
//#endif 

  { 

//#if -336316158 
private static final long serialVersionUID = 4999132551417131227L;
//#endif 


//#if 1712738828 
public void setName(String text)
        { 

//#if 1455471653 
getNameFig().setText(text);
//#endif 

} 

//#endif 


//#if -740815275 
public ShadowFig()
        { 

//#if 1289224797 
super();
//#endif 


//#if -1940629915 
addFig(getBigPort());
//#endif 


//#if 1524771389 
addFig(getNameFig());
//#endif 

} 

//#endif 


//#if -1819078942 
public void setShadowSize(int size)
        { 

//#if -948862820 
super.setShadowSizeFriend(size);
//#endif 

} 

//#endif 


//#if 961712252 
protected FigStereotypesGroup createStereotypeFig()
        { 

//#if -1989762348 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 

 } 

//#endif 


//#endif 

