
//#if 1893574120 
// Compilation Unit of /ModeLabelDragFactory.java 
 

//#if 1267139885 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -1656986802 
import org.tigris.gef.base.Editor;
//#endif 


//#if 1988587252 
import org.tigris.gef.base.FigModifyingMode;
//#endif 


//#if 261173332 
import org.tigris.gef.base.ModeFactory;
//#endif 


//#if 1340363542 
public class ModeLabelDragFactory implements 
//#if 828320838 
ModeFactory
//#endif 

  { 

//#if -1102676431 
public FigModifyingMode createMode()
    { 

//#if 1601435713 
return new ModeLabelDrag();
//#endif 

} 

//#endif 


//#if -1614428105 
public FigModifyingMode createMode(Editor editor)
    { 

//#if 1696609736 
return new ModeLabelDrag(editor);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

