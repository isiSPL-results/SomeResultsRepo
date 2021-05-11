package org.argouml.uml.diagram.layout;
import java.awt.*;
public interface LayoutedContainer  { 
void resize(Dimension newSize);void remove(LayoutedObject obj);void add(LayoutedObject obj);LayoutedObject [] getContent();
 } 
