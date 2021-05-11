
//#if -813006448 
// Compilation Unit of /ClassdiagramNoteEdge.java 
 

//#if -2085335122 
package org.argouml.uml.diagram.static_structure.layout;
//#endif 


//#if -2078148845 
import java.awt.Point;
//#endif 


//#if -416374625 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 2019240034 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if 2029731891 
import org.tigris.gef.presentation.FigPoly;
//#endif 


//#if 1425562794 
public class ClassdiagramNoteEdge extends 
//#if -1900274625 
ClassdiagramEdge
//#endif 

  { 

//#if -285245351 
public ClassdiagramNoteEdge(FigEdge edge)
    { 

//#if 1463762378 
super(edge);
//#endif 

} 

//#endif 


//#if -1029308746 
private void addPoints(Fig fs, Fig fd)
    { 

//#if 824674590 
FigPoly fig = getUnderlyingFig();
//#endif 


//#if -509363535 
Point p = fs.getLocation();
//#endif 


//#if -739713598 
p.translate(fs.getWidth(), fs.getHeight() / 2);
//#endif 


//#if 2045183185 
fig.addPoint(p);
//#endif 


//#if 656529876 
p = fd.getLocation();
//#endif 


//#if -3770219 
p.translate(0, fd.getHeight() / 2);
//#endif 


//#if -353750047 
fig.addPoint(p);
//#endif 

} 

//#endif 


//#if -1983617585 
public void layout()
    { 

//#if 902012232 
Fig fs = getSourceFigNode();
//#endif 


//#if 343523072 
Fig fd = getDestFigNode();
//#endif 


//#if 207502683 
if(fs.getLocation().x < fd.getLocation().x)//1
{ 

//#if -301010517 
addPoints(fs, fd);
//#endif 

} 
else
{ 

//#if -534235030 
addPoints(fd, fs);
//#endif 

} 

//#endif 


//#if 1712233009 
FigPoly fig = getUnderlyingFig();
//#endif 


//#if -398290698 
fig.setFilled(false);
//#endif 


//#if -1038526836 
getCurrentEdge().setFig(fig);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

