package org.argouml.uml.diagram.ui;
import java.awt.Graphics;
import org.tigris.gef.base.SelectionMove;
import org.tigris.gef.presentation.Fig;
public class SelectionMoveClarifiers extends SelectionMove
  { 
public void paint(Graphics g)
    { 
((Clarifiable) getContent()).paintClarifiers(g);
super.paint(g);
} 
public SelectionMoveClarifiers(Fig f)
    { 
super(f);
} 

 } 
