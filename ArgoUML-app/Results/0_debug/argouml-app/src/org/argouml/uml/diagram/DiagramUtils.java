
//#if -828391275 
// Compilation Unit of /DiagramUtils.java 
 

//#if -894589169 
package org.argouml.uml.diagram;
//#endif 


//#if 491037308 
import org.apache.log4j.Logger;
//#endif 


//#if -2127508586 
import org.tigris.gef.base.Editor;
//#endif 


//#if 622189283 
import org.tigris.gef.base.Globals;
//#endif 


//#if 268013794 
import org.tigris.gef.base.Layer;
//#endif 


//#if 775684039 
import org.tigris.gef.base.LayerManager;
//#endif 


//#if -430132584 
import org.tigris.gef.base.LayerPerspective;
//#endif 


//#if 610498711 
public class DiagramUtils  { 

//#if -1936573485 
private static final Logger LOG = Logger.getLogger(DiagramUtils.class);
//#endif 


//#if 1337996457 
private DiagramUtils()
    { 
} 

//#endif 


//#if 1942514329 
private static LayerPerspective getActiveLayer()
    { 

//#if 2040252831 
Editor editor = Globals.curEditor();
//#endif 


//#if -105036 
if(editor != null)//1
{ 

//#if 737557366 
LayerManager manager = editor.getLayerManager();
//#endif 


//#if 1892938004 
if(manager != null)//1
{ 

//#if 1380695429 
Layer layer = manager.getActiveLayer();
//#endif 


//#if -804479773 
if(layer instanceof LayerPerspective)//1
{ 

//#if -1428918703 
return (LayerPerspective) layer;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -284653195 
return null;
//#endif 

} 

//#endif 


//#if -479030142 
public static ArgoDiagram getActiveDiagram()
    { 

//#if 336744579 
LayerPerspective layer = getActiveLayer();
//#endif 


//#if -251190148 
if(layer != null)//1
{ 

//#if -1438067632 
return (ArgoDiagram) layer.getDiagram();
//#endif 

} 

//#endif 


//#if -617213440 
LOG.debug("No active diagram");
//#endif 


//#if 1421848601 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

