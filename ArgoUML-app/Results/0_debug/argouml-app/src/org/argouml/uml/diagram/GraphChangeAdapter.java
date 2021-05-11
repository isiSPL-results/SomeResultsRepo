
//#if -1805792982 
// Compilation Unit of /GraphChangeAdapter.java 
 

//#if -627291095 
package org.argouml.uml.diagram;
//#endif 


//#if 995888976 
import org.argouml.model.DiDiagram;
//#endif 


//#if 1225926215 
import org.argouml.model.DiElement;
//#endif 


//#if 1793006997 
import org.argouml.model.Model;
//#endif 


//#if 196634224 
import org.tigris.gef.graph.GraphEvent;
//#endif 


//#if -1654510056 
import org.tigris.gef.graph.GraphListener;
//#endif 


//#if 419164097 
import org.tigris.gef.graph.GraphModel;
//#endif 


//#if -518720884 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -167955752 
public final class GraphChangeAdapter implements 
//#if 48038530 
GraphListener
//#endif 

  { 

//#if -233799013 
private static final GraphChangeAdapter INSTANCE =
        new GraphChangeAdapter();
//#endif 


//#if -1575334895 
public void removeDiagram(DiDiagram dd)
    { 

//#if 1579656785 
if(Model.getDiagramInterchangeModel() != null)//1
{ 

//#if -574579169 
Model.getDiagramInterchangeModel().deleteDiagram(dd);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1006519383 
public void removeElement(DiElement element)
    { 

//#if 322884320 
if(Model.getDiagramInterchangeModel() != null)//1
{ 

//#if 1187745543 
Model.getDiagramInterchangeModel().deleteElement(element);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1156113774 
public void edgeRemoved(GraphEvent e)
    { 

//#if -1064865680 
Object source = e.getSource();
//#endif 


//#if 1389353670 
Object arg = e.getArg();
//#endif 


//#if -173001025 
if(source instanceof Fig)//1
{ 

//#if 706998324 
source = ((Fig) source).getOwner();
//#endif 

} 

//#endif 


//#if 1564934832 
if(arg instanceof Fig)//1
{ 

//#if -188544472 
arg = ((Fig) arg).getOwner();
//#endif 

} 

//#endif 


//#if 288146533 
Model.getDiagramInterchangeModel().edgeRemoved(source, arg);
//#endif 

} 

//#endif 


//#if -1328808585 
public void nodeAdded(GraphEvent e)
    { 

//#if 1174543514 
Object source = e.getSource();
//#endif 


//#if -2078183824 
Object arg = e.getArg();
//#endif 


//#if -377856683 
if(source instanceof Fig)//1
{ 

//#if 1042796226 
source = ((Fig) source).getOwner();
//#endif 

} 

//#endif 


//#if -2138942502 
if(arg instanceof Fig)//1
{ 

//#if 1497040337 
arg = ((Fig) arg).getOwner();
//#endif 

} 

//#endif 


//#if 1906295028 
Model.getDiagramInterchangeModel().nodeAdded(source, arg);
//#endif 

} 

//#endif 


//#if -701538797 
public DiElement createElement(GraphModel gm, Object node)
    { 

//#if -1281637530 
if(Model.getDiagramInterchangeModel() != null)//1
{ 

//#if 1331299885 
return Model.getDiagramInterchangeModel().createElement(
                       ((UMLMutableGraphSupport) gm).getDiDiagram(), node);
//#endif 

} 

//#endif 


//#if 122804436 
return null;
//#endif 

} 

//#endif 


//#if 405841669 
public DiDiagram createDiagram(Class type, Object owner)
    { 

//#if 1287527464 
if(Model.getDiagramInterchangeModel() != null)//1
{ 

//#if -13265817 
return Model.getDiagramInterchangeModel()
                   .createDiagram(type, owner);
//#endif 

} 

//#endif 


//#if 544893590 
return null;
//#endif 

} 

//#endif 


//#if -1548491723 
private GraphChangeAdapter()
    { 
} 

//#endif 


//#if 577463410 
public void edgeAdded(GraphEvent e)
    { 

//#if 1174368020 
Object source = e.getSource();
//#endif 


//#if 1464116330 
Object arg = e.getArg();
//#endif 


//#if -1347693669 
if(source instanceof Fig)//1
{ 

//#if -1569829947 
source = ((Fig) source).getOwner();
//#endif 

} 

//#endif 


//#if 397407060 
if(arg instanceof Fig)//1
{ 

//#if 1750744524 
arg = ((Fig) arg).getOwner();
//#endif 

} 

//#endif 


//#if 294676713 
Model.getDiagramInterchangeModel().edgeAdded(source, arg);
//#endif 

} 

//#endif 


//#if -798628491 
public void graphChanged(GraphEvent e)
    { 

//#if -1617848741 
Object source = e.getSource();
//#endif 


//#if -1237611279 
Object arg = e.getArg();
//#endif 


//#if 86255476 
if(source instanceof Fig)//1
{ 

//#if -1858542327 
source = ((Fig) source).getOwner();
//#endif 

} 

//#endif 


//#if -1802578405 
if(arg instanceof Fig)//1
{ 

//#if -1417272495 
arg = ((Fig) arg).getOwner();
//#endif 

} 

//#endif 


//#if 1279237157 
Model.getDiagramInterchangeModel().graphChanged(source, arg);
//#endif 

} 

//#endif 


//#if 114236036 
public static GraphChangeAdapter getInstance()
    { 

//#if -1314057091 
return INSTANCE;
//#endif 

} 

//#endif 


//#if 867534423 
public void nodeRemoved(GraphEvent e)
    { 

//#if 1741048356 
Object source = e.getSource();
//#endif 


//#if -1580135558 
Object arg = e.getArg();
//#endif 


//#if -82487669 
if(source instanceof Fig)//1
{ 

//#if 771365935 
source = ((Fig) source).getOwner();
//#endif 

} 

//#endif 


//#if -255928732 
if(arg instanceof Fig)//1
{ 

//#if -352069792 
arg = ((Fig) arg).getOwner();
//#endif 

} 

//#endif 


//#if 320223710 
Model.getDiagramInterchangeModel().nodeRemoved(source, arg);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

