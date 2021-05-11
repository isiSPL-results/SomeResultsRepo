
//#if 1039845500 
// Compilation Unit of /ClClassName.java 
 

//#if -58356084 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1602032818 
import java.awt.Color;
//#endif 


//#if 503821812 
import java.awt.Component;
//#endif 


//#if 658749754 
import java.awt.Graphics;
//#endif 


//#if 1351824322 
import java.awt.Rectangle;
//#endif 


//#if 1050151851 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if -1813804109 
import org.argouml.ui.Clarifier;
//#endif 


//#if 763775305 
import org.argouml.uml.diagram.ui.FigEdgeModelElement;
//#endif 


//#if -1489936092 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if -1033888079 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1006387564 
public class ClClassName implements 
//#if -1903518087 
Clarifier
//#endif 

  { 

//#if 1664085914 
private static ClClassName theInstance = new ClClassName();
//#endif 


//#if -87417188 
private static final int WAVE_LENGTH = 4;
//#endif 


//#if -1600809859 
private static final int WAVE_HEIGHT = 2;
//#endif 


//#if -1466071074 
private Fig fig;
//#endif 


//#if -179768744 
public int getIconWidth()
    { 

//#if -348691954 
return 0;
//#endif 

} 

//#endif 


//#if -1926239964 
public void setFig(Fig f)
    { 

//#if 1015676 
fig = f;
//#endif 

} 

//#endif 


//#if -774049417 
public int getIconHeight()
    { 

//#if -1740372114 
return 0;
//#endif 

} 

//#endif 


//#if 464413614 
public static ClClassName getTheInstance()
    { 

//#if -2060912177 
return theInstance;
//#endif 

} 

//#endif 


//#if -1697045015 
public void setToDoItem(ToDoItem i) { 
} 

//#endif 


//#if -683641942 
public boolean hit(int x, int y)
    { 

//#if -1973059753 
Rectangle rect = null;
//#endif 


//#if -1497700695 
if(fig instanceof FigNodeModelElement)//1
{ 

//#if 1282419372 
FigNodeModelElement fnme = (FigNodeModelElement) fig;
//#endif 


//#if -242842440 
rect = fnme.getNameBounds();
//#endif 

} 
else

//#if -413540690 
if(fig instanceof FigEdgeModelElement)//1
{ 

//#if 710485335 
FigEdgeModelElement feme = (FigEdgeModelElement) fig;
//#endif 


//#if 1108746829 
rect = feme.getNameBounds();
//#endif 

} 

//#endif 


//#endif 


//#if -544663768 
fig = null;
//#endif 


//#if 107692091 
return (rect != null) && rect.contains(x, y);
//#endif 

} 

//#endif 


//#if 310941406 
public void paintIcon(Component c, Graphics g, int x, int y)
    { 

//#if -1849158991 
Rectangle rect = null;
//#endif 


//#if 1809598723 
if(fig instanceof FigNodeModelElement)//1
{ 

//#if -1616568474 
FigNodeModelElement fnme = (FigNodeModelElement) fig;
//#endif 


//#if -2124162754 
rect = fnme.getNameBounds();
//#endif 

} 
else

//#if -180895389 
if(fig instanceof FigEdgeModelElement)//1
{ 

//#if 1864552177 
FigEdgeModelElement feme = (FigEdgeModelElement) fig;
//#endif 


//#if -292504077 
rect = feme.getNameBounds();
//#endif 

} 

//#endif 


//#endif 


//#if -746118751 
if(rect != null)//1
{ 

//#if 525115765 
int left  = rect.x + 6;
//#endif 


//#if -1750543150 
int height = rect.y + rect.height - 4;
//#endif 


//#if 990626307 
int right = rect.x + rect.width - 6;
//#endif 


//#if 555322974 
g.setColor(Color.red);
//#endif 


//#if -409963145 
int i = left;
//#endif 


//#if -1571396397 
while (true) //1
{ 

//#if 1022203400 
g.drawLine(i, height, i + WAVE_LENGTH, height + WAVE_HEIGHT);
//#endif 


//#if -753339400 
i += WAVE_LENGTH;
//#endif 


//#if 838388981 
if(i >= right)//1
{ 

//#if 1824209934 
break;

//#endif 

} 

//#endif 


//#if 328298372 
g.drawLine(i, height + WAVE_HEIGHT, i + WAVE_LENGTH, height);
//#endif 


//#if -1529897126 
i += WAVE_LENGTH;
//#endif 


//#if 1211383196 
if(i >= right)//2
{ 

//#if 1581862880 
break;

//#endif 

} 

//#endif 


//#if -1209871957 
g.drawLine(i, height, i + WAVE_LENGTH,
                           height + WAVE_HEIGHT / 2);
//#endif 


//#if -1529897125 
i += WAVE_LENGTH;
//#endif 


//#if 1211412988 
if(i >= right)//3
{ 

//#if -174527787 
break;

//#endif 

} 

//#endif 


//#if -735205631 
g.drawLine(i, height + WAVE_HEIGHT / 2, i + WAVE_LENGTH,
                           height);
//#endif 


//#if -1529897124 
i += WAVE_LENGTH;
//#endif 


//#if 1211442780 
if(i >= right)//4
{ 

//#if -819996851 
break;

//#endif 

} 

//#endif 

} 

//#endif 


//#if 569063957 
fig = null;
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

