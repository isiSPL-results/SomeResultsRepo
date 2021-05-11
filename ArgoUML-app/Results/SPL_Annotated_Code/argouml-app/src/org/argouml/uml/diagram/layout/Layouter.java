// Compilation Unit of /Layouter.java 
 
package org.argouml.uml.diagram.layout;
import java.awt.*;
public interface Layouter  { 
Dimension getMinimumDiagramSize();
void layout();
void add(LayoutedObject obj);
LayoutedObject getObject(int index);
LayoutedObject [] getObjects();
void remove(LayoutedObject obj);
 } 


