// Compilation Unit of /ToDoTreeRenderer.java 
 

//#if COGNITIVE 
package org.argouml.cognitive.ui;
//#endif 


//#if COGNITIVE 
import java.awt.Color;
//#endif 


//#if COGNITIVE 
import java.awt.Component;
//#endif 


//#if COGNITIVE 
import javax.swing.ImageIcon;
//#endif 


//#if COGNITIVE 
import javax.swing.JLabel;
//#endif 


//#if COGNITIVE 
import javax.swing.JTree;
//#endif 


//#if COGNITIVE 
import javax.swing.plaf.metal.MetalIconFactory;
//#endif 


//#if COGNITIVE 
import javax.swing.tree.DefaultTreeCellRenderer;
//#endif 


//#if COGNITIVE 
import org.argouml.application.helpers.ResourceLoaderWrapper;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Decision;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Designer;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Goal;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.Poster;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if COGNITIVE 
import org.argouml.model.Model;
//#endif 


//#if COGNITIVE 
import org.argouml.uml.ui.UMLTreeCellRenderer;
//#endif 


//#if COGNITIVE 
import org.tigris.gef.base.Diagram;
//#endif 


//#if COGNITIVE 
import org.tigris.gef.base.Globals;
//#endif 


//#if COGNITIVE 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if COGNITIVE 
public class ToDoTreeRenderer extends DefaultTreeCellRenderer
  { 
private final ImageIcon postIt0     = lookupIconResource("PostIt0");
private final ImageIcon postIt25    = lookupIconResource("PostIt25");
private final ImageIcon postIt50    = lookupIconResource("PostIt50");
private final ImageIcon postIt75    = lookupIconResource("PostIt75");
private final ImageIcon postIt99    = lookupIconResource("PostIt99");
private final ImageIcon postIt100   = lookupIconResource("PostIt100");
private final ImageIcon postItD0    = lookupIconResource("PostItD0");
private final ImageIcon postItD25   = lookupIconResource("PostItD25");
private final ImageIcon postItD50   = lookupIconResource("PostItD50");
private final ImageIcon postItD75   = lookupIconResource("PostItD75");
private final ImageIcon postItD99   = lookupIconResource("PostItD99");
private final ImageIcon postItD100  = lookupIconResource("PostItD100");
private UMLTreeCellRenderer treeCellRenderer = new UMLTreeCellRenderer();
public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean sel,
            boolean expanded,
            boolean leaf, int row,
            boolean hasTheFocus)
    { 
Component r = super.getTreeCellRendererComponent(tree, value, sel,
                      expanded, leaf,
                      row, hasTheFocus);
if(r instanceof JLabel)//1
{ 
JLabel lab = (JLabel) r;
if(value instanceof ToDoItem)//1
{ 
ToDoItem item = (ToDoItem) value;
Poster post = item.getPoster();
if(post instanceof Designer)//1
{ 
if(item.getProgress() == 0)//1
{ 
lab.setIcon(postItD0);
} 
else

//#if COGNITIVE 
if(item.getProgress() <= 25)//1
{ 
lab.setIcon(postItD25);
} 
else

//#if COGNITIVE 
if(item.getProgress() <= 50)//1
{ 
lab.setIcon(postItD50);
} 
else

//#if COGNITIVE 
if(item.getProgress() <= 75)//1
{ 
lab.setIcon(postItD75);
} 
else

//#if COGNITIVE 
if(item.getProgress() <= 100)//1
{ 
lab.setIcon(postItD99);
} 
else
{ 
lab.setIcon(postItD100);
} 

//#endif 


//#endif 


//#endif 


//#endif 


} 
else
{ 
if(item.getProgress() == 0)//1
{ 
lab.setIcon(postIt0);
} 
else

//#if COGNITIVE 
if(item.getProgress() <= 25)//1
{ 
lab.setIcon(postIt25);
} 
else

//#if COGNITIVE 
if(item.getProgress() <= 50)//1
{ 
lab.setIcon(postIt50);
} 
else

//#if COGNITIVE 
if(item.getProgress() <= 75)//1
{ 
lab.setIcon(postIt75);
} 
else

//#if COGNITIVE 
if(item.getProgress() <= 100)//1
{ 
lab.setIcon(postIt99);
} 
else
{ 
lab.setIcon(postIt100);
} 

//#endif 


//#endif 


//#endif 


//#endif 


} 

} 
else

//#if COGNITIVE 
if(value instanceof Decision)//1
{ 
lab.setIcon(MetalIconFactory.getTreeFolderIcon());
} 
else

//#if COGNITIVE 
if(value instanceof Goal)//1
{ 
lab.setIcon(MetalIconFactory.getTreeFolderIcon());
} 
else

//#if COGNITIVE 
if(value instanceof Poster)//1
{ 
lab.setIcon(MetalIconFactory.getTreeFolderIcon());
} 
else

//#if COGNITIVE 
if(value instanceof PriorityNode)//1
{ 
lab.setIcon(MetalIconFactory.getTreeFolderIcon());
} 
else

//#if COGNITIVE 
if(value instanceof KnowledgeTypeNode)//1
{ 
lab.setIcon(MetalIconFactory.getTreeFolderIcon());
} 
else

//#if COGNITIVE 
if(value instanceof Diagram)//1
{ 
return treeCellRenderer.getTreeCellRendererComponent(tree,
                        value,
                        sel,
                        expanded,
                        leaf,
                        row,
                        hasTheFocus);
} 
else
{ 
Object newValue = value;
if(newValue instanceof Fig)//1
{ 
newValue = ((Fig) value).getOwner();
} 

if(Model.getFacade().isAUMLElement(newValue))//1
{ 
return treeCellRenderer.getTreeCellRendererComponent(
                               tree, newValue, sel, expanded, leaf, row,
                               hasTheFocus);
} 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


String tip = lab.getText() + " ";
lab.setToolTipText(tip);
tree.setToolTipText(tip);
if(!sel)//1
{ 
lab.setBackground(getBackgroundNonSelectionColor());
} 
else
{ 
Color high = Globals.getPrefs().getHighlightColor();
high = high.brighter().brighter();
lab.setBackground(high);
} 

lab.setOpaque(sel);
} 

return r;
} 

private static ImageIcon lookupIconResource(String name)
    { 
return ResourceLoaderWrapper.lookupIconResource(name);
} 

 } 

//#endif 


