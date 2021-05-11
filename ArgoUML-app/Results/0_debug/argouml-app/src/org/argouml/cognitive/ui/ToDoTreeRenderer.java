
//#if 723082945 
// Compilation Unit of /ToDoTreeRenderer.java 
 

//#if -1445565192 
package org.argouml.cognitive.ui;
//#endif 


//#if 1076649095 
import java.awt.Color;
//#endif 


//#if -55319891 
import java.awt.Component;
//#endif 


//#if 2136946012 
import javax.swing.ImageIcon;
//#endif 


//#if 1675155932 
import javax.swing.JLabel;
//#endif 


//#if 893218728 
import javax.swing.JTree;
//#endif 


//#if 1640258898 
import javax.swing.plaf.metal.MetalIconFactory;
//#endif 


//#if -591717198 
import javax.swing.tree.DefaultTreeCellRenderer;
//#endif 


//#if -849957798 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if 1777226753 
import org.argouml.cognitive.Decision;
//#endif 


//#if -1213526318 
import org.argouml.cognitive.Designer;
//#endif 


//#if -1145221974 
import org.argouml.cognitive.Goal;
//#endif 


//#if -1632185040 
import org.argouml.cognitive.Poster;
//#endif 


//#if 1561455332 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 1639390625 
import org.argouml.model.Model;
//#endif 


//#if -742143718 
import org.argouml.uml.ui.UMLTreeCellRenderer;
//#endif 


//#if 252311122 
import org.tigris.gef.base.Diagram;
//#endif 


//#if -50986603 
import org.tigris.gef.base.Globals;
//#endif 


//#if 1931617944 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 1940725774 
public class ToDoTreeRenderer extends 
//#if 404996998 
DefaultTreeCellRenderer
//#endif 

  { 

//#if -1314137595 
private final ImageIcon postIt0     = lookupIconResource("PostIt0");
//#endif 


//#if -1082250785 
private final ImageIcon postIt25    = lookupIconResource("PostIt25");
//#endif 


//#if 30329567 
private final ImageIcon postIt50    = lookupIconResource("PostIt50");
//#endif 


//#if -245140481 
private final ImageIcon postIt75    = lookupIconResource("PostIt75");
//#endif 


//#if 1663036607 
private final ImageIcon postIt99    = lookupIconResource("PostIt99");
//#endif 


//#if 969090883 
private final ImageIcon postIt100   = lookupIconResource("PostIt100");
//#endif 


//#if -1753306817 
private final ImageIcon postItD0    = lookupIconResource("PostItD0");
//#endif 


//#if -95472873 
private final ImageIcon postItD25   = lookupIconResource("PostItD25");
//#endif 


//#if -43868569 
private final ImageIcon postItD50   = lookupIconResource("PostItD50");
//#endif 


//#if -53385375 
private final ImageIcon postItD75   = lookupIconResource("PostItD75");
//#endif 


//#if -1088423971 
private final ImageIcon postItD99   = lookupIconResource("PostItD99");
//#endif 


//#if -2033000417 
private final ImageIcon postItD100  = lookupIconResource("PostItD100");
//#endif 


//#if 39929051 
private UMLTreeCellRenderer treeCellRenderer = new UMLTreeCellRenderer();
//#endif 


//#if 1351841004 
public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean sel,
            boolean expanded,
            boolean leaf, int row,
            boolean hasTheFocus)
    { 

//#if -1782164839 
Component r = super.getTreeCellRendererComponent(tree, value, sel,
                      expanded, leaf,
                      row, hasTheFocus);
//#endif 


//#if -1240769398 
if(r instanceof JLabel)//1
{ 

//#if 625096852 
JLabel lab = (JLabel) r;
//#endif 


//#if 1264743117 
if(value instanceof ToDoItem)//1
{ 

//#if 341493753 
ToDoItem item = (ToDoItem) value;
//#endif 


//#if -957176084 
Poster post = item.getPoster();
//#endif 


//#if -257295616 
if(post instanceof Designer)//1
{ 

//#if -2146389394 
if(item.getProgress() == 0)//1
{ 

//#if 1637778191 
lab.setIcon(postItD0);
//#endif 

} 
else

//#if 1721544824 
if(item.getProgress() <= 25)//1
{ 

//#if 1683642561 
lab.setIcon(postItD25);
//#endif 

} 
else

//#if -1474041394 
if(item.getProgress() <= 50)//1
{ 

//#if 284616274 
lab.setIcon(postItD50);
//#endif 

} 
else

//#if 80585773 
if(item.getProgress() <= 75)//1
{ 

//#if -1874743412 
lab.setIcon(postItD75);
//#endif 

} 
else

//#if -802461187 
if(item.getProgress() <= 100)//1
{ 

//#if 103016307 
lab.setIcon(postItD99);
//#endif 

} 
else
{ 

//#if -1714857497 
lab.setIcon(postItD100);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 
else
{ 

//#if -799970823 
if(item.getProgress() == 0)//1
{ 

//#if 35593760 
lab.setIcon(postIt0);
//#endif 

} 
else

//#if 93270959 
if(item.getProgress() <= 25)//1
{ 

//#if -1364746113 
lab.setIcon(postIt25);
//#endif 

} 
else

//#if 235551052 
if(item.getProgress() <= 50)//1
{ 

//#if 1523814605 
lab.setIcon(postIt50);
//#endif 

} 
else

//#if -266078805 
if(item.getProgress() <= 75)//1
{ 

//#if -1357357037 
lab.setIcon(postIt75);
//#endif 

} 
else

//#if 260753365 
if(item.getProgress() <= 100)//1
{ 

//#if -1819298475 
lab.setIcon(postIt99);
//#endif 

} 
else
{ 

//#if 529296980 
lab.setIcon(postIt100);
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 

} 

//#endif 

} 
else

//#if -1447833962 
if(value instanceof Decision)//1
{ 

//#if -827190113 
lab.setIcon(MetalIconFactory.getTreeFolderIcon());
//#endif 

} 
else

//#if 659609853 
if(value instanceof Goal)//1
{ 

//#if -38523395 
lab.setIcon(MetalIconFactory.getTreeFolderIcon());
//#endif 

} 
else

//#if 1350884184 
if(value instanceof Poster)//1
{ 

//#if -203217965 
lab.setIcon(MetalIconFactory.getTreeFolderIcon());
//#endif 

} 
else

//#if 885530102 
if(value instanceof PriorityNode)//1
{ 

//#if -816413236 
lab.setIcon(MetalIconFactory.getTreeFolderIcon());
//#endif 

} 
else

//#if 119289274 
if(value instanceof KnowledgeTypeNode)//1
{ 

//#if -1457261215 
lab.setIcon(MetalIconFactory.getTreeFolderIcon());
//#endif 

} 
else

//#if 9181172 
if(value instanceof Diagram)//1
{ 

//#if 1764278942 
return treeCellRenderer.getTreeCellRendererComponent(tree,
                        value,
                        sel,
                        expanded,
                        leaf,
                        row,
                        hasTheFocus);
//#endif 

} 
else
{ 

//#if -794124895 
Object newValue = value;
//#endif 


//#if 280016218 
if(newValue instanceof Fig)//1
{ 

//#if -1187064715 
newValue = ((Fig) value).getOwner();
//#endif 

} 

//#endif 


//#if 277995744 
if(Model.getFacade().isAUMLElement(newValue))//1
{ 

//#if 1742866832 
return treeCellRenderer.getTreeCellRendererComponent(
                               tree, newValue, sel, expanded, leaf, row,
                               hasTheFocus);
//#endif 

} 

//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if 752742502 
String tip = lab.getText() + " ";
//#endif 


//#if -549297842 
lab.setToolTipText(tip);
//#endif 


//#if 1250163369 
tree.setToolTipText(tip);
//#endif 


//#if -1024530734 
if(!sel)//1
{ 

//#if -1915453766 
lab.setBackground(getBackgroundNonSelectionColor());
//#endif 

} 
else
{ 

//#if 1224696246 
Color high = Globals.getPrefs().getHighlightColor();
//#endif 


//#if 1243945114 
high = high.brighter().brighter();
//#endif 


//#if -574564535 
lab.setBackground(high);
//#endif 

} 

//#endif 


//#if 794233324 
lab.setOpaque(sel);
//#endif 

} 

//#endif 


//#if 1289421982 
return r;
//#endif 

} 

//#endif 


//#if -1550835065 
private static ImageIcon lookupIconResource(String name)
    { 

//#if -350602422 
return ResourceLoaderWrapper.lookupIconResource(name);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

