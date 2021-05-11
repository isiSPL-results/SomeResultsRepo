// Compilation Unit of /DiagramUtils.java 
 
package org.argouml.uml.diagram;
import org.apache.log4j.Logger;
import org.tigris.gef.base.Editor;
import org.tigris.gef.base.Globals;
import org.tigris.gef.base.Layer;
import org.tigris.gef.base.LayerManager;
import org.tigris.gef.base.LayerPerspective;
public class DiagramUtils  { 
private static final Logger LOG = Logger.getLogger(DiagramUtils.class);
private DiagramUtils()
    { 
} 

private static LayerPerspective getActiveLayer()
    { 
Editor editor = Globals.curEditor();
if(editor != null)//1
{ 
LayerManager manager = editor.getLayerManager();
if(manager != null)//1
{ 
Layer layer = manager.getActiveLayer();
if(layer instanceof LayerPerspective)//1
{ 
return (LayerPerspective) layer;
} 

} 

} 

return null;
} 

public static ArgoDiagram getActiveDiagram()
    { 
LayerPerspective layer = getActiveLayer();
if(layer != null)//1
{ 
return (ArgoDiagram) layer.getDiagram();
} 

LOG.debug("No active diagram");
return null;
} 

 } 


