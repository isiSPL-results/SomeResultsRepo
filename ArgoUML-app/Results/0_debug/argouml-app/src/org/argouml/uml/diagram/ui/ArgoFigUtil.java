
//#if 565291241 
// Compilation Unit of /ArgoFigUtil.java 
 

//#if 457346664 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1210189034 
import java.awt.Color;
//#endif 


//#if 443115992 
import org.argouml.kernel.Project;
//#endif 


//#if 690636305 
import org.argouml.kernel.ProjectManager;
//#endif 


//#if -589528008 
import org.argouml.uml.diagram.UMLMutableGraphSupport;
//#endif 


//#if 1503479475 
import org.tigris.gef.base.Editor;
//#endif 


//#if 1513669478 
import org.tigris.gef.base.Globals;
//#endif 


//#if 246595109 
import org.tigris.gef.base.Layer;
//#endif 


//#if -409752203 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if 1115985182 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if 178100201 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 875565689 
import org.tigris.gef.presentation.FigCircle;
//#endif 


//#if -779523412 
import org.tigris.gef.presentation.FigEdge;
//#endif 


//#if -767491227 
import org.tigris.gef.presentation.FigRect;
//#endif 


//#if 188167159 
public class ArgoFigUtil  { 

//#if 1320392153 
public static Project getProject(ArgoFig fig)
    { 

//#if -180047431 
if(fig instanceof Fig)//1
{ 

//#if 2146188982 
Fig f = (Fig) fig;
//#endif 


//#if 1005681853 
LayerPerspective layer = (LayerPerspective) f.getLayer();
//#endif 


//#if 1333149538 
if(layer == null)//1
{ 

//#if 158272824 
Editor editor = Globals.curEditor();
//#endif 


//#if 445601905 
if(editor == null)//1
{ 

//#if -494491845 
return ProjectManager.getManager().getCurrentProject();
//#endif 

} 

//#endif 


//#if 1766053917 
Layer lay = editor.getLayerManager().getActiveLayer();
//#endif 


//#if -256374098 
if(lay instanceof LayerPerspective)//1
{ 

//#if 1093256612 
layer = (LayerPerspective) lay;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 295376911 
if(layer == null)//2
{ 

//#if -1396791587 
return ProjectManager.getManager().getCurrentProject();
//#endif 

} 

//#endif 


//#if 1748574805 
GraphModel gm = layer.getGraphModel();
//#endif 


//#if 1348633931 
if(gm instanceof UMLMutableGraphSupport)//1
{ 

//#if 570475133 
Project project = ((UMLMutableGraphSupport) gm).getProject();
//#endif 


//#if 1154441551 
if(project != null)//1
{ 

//#if 1948066905 
return project;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1079821469 
return ProjectManager.getManager().getCurrentProject();
//#endif 

} 

//#endif 


//#if -2006755146 
return null;
//#endif 

} 

//#endif 


//#if -1213827896 
static void markPosition(FigEdge fe,
                             int pct, int delta, int angle, int offset,
                             Color color)
    { 

//#if 1570895571 
if(false)//1
{ 

//#if -1762004446 
Fig f;
//#endif 


//#if 1491005123 
f = new FigCircle(0, 0, 5, 5, color, Color.red);
//#endif 


//#if 455922632 
fe.addPathItem(f, new PathItemPlacement(fe, f, pct, delta, angle,
                                                    0));
//#endif 


//#if 1215782086 
f = new FigRect(0, 0, 100, 20, color, Color.red);
//#endif 


//#if 81279026 
f.setFilled(false);
//#endif 


//#if -1579717397 
fe.addPathItem(f, new PathItemPlacement(fe, f, pct, delta, angle,
                                                    offset));
//#endif 


//#if -1474519604 
f = new FigCircle(0, 0, 5, 5, color, Color.blue);
//#endif 


//#if -1404265081 
fe.addPathItem(f, new PathItemPlacement(fe, f, pct, delta, angle,
                                                    offset));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

