
//#if 322144531 
// Compilation Unit of /SelectionMoveClarifiers.java 
 

//#if 869772868 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1734031182 
import java.awt.Graphics;
//#endif 


//#if -500081323 
import org.tigris.gef.base.SelectionMove;
//#endif 


//#if -1851299387 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -2009041161 
public class SelectionMoveClarifiers extends 
//#if -1425034774 
SelectionMove
//#endif 

  { 

//#if 1021288359 
public void paint(Graphics g)
    { 

//#if 1059955331 
((Clarifiable) getContent()).paintClarifiers(g);
//#endif 


//#if 176792866 
super.paint(g);
//#endif 

} 

//#endif 


//#if 981322132 
public SelectionMoveClarifiers(Fig f)
    { 

//#if -1762500168 
super(f);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

