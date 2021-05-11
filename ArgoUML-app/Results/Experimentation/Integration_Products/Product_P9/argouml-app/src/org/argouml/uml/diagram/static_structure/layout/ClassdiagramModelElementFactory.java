package org.argouml.uml.diagram.static_structure.layout;
import org.apache.log4j.Logger;
import org.argouml.uml.diagram.layout.LayoutedObject;
import org.argouml.uml.diagram.static_structure.ui.FigComment;
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
import org.argouml.uml.diagram.ui.FigAbstraction;
import org.argouml.uml.diagram.ui.FigAssociation;
import org.argouml.uml.diagram.ui.FigGeneralization;
import org.argouml.uml.diagram.ui.FigNodeModelElement;
import org.tigris.gef.presentation.FigNode;
public class ClassdiagramModelElementFactory  { 
private static final Logger LOG =
        Logger.getLogger(ClassdiagramModelElementFactory.class);
public static final ClassdiagramModelElementFactory SINGLETON =
        new ClassdiagramModelElementFactory();
private ClassdiagramModelElementFactory() { 
} 
public LayoutedObject getInstance(Object f)
    { 
if(f instanceof FigComment)//1
{ 
return (new ClassdiagramNote((FigComment) f));
} 
else
if(f instanceof FigNodeModelElement)//1
{ 
return (new ClassdiagramNode((FigNode) f));
} 
else
if(f instanceof FigGeneralization)//1
{ 
return new ClassdiagramGeneralizationEdge((FigGeneralization) f);
} 
else
if(f instanceof FigAbstraction)//1
{ 
return (new ClassdiagramRealizationEdge((FigAbstraction) f));
} 
else
if(f instanceof FigAssociation)//1
{ 
return (new ClassdiagramAssociationEdge((FigAssociation) f));
} 
else
if(f instanceof FigEdgeNote)//1
{ 
return (new ClassdiagramNoteEdge((FigEdgeNote) f));
} 
LOG.debug("Do not know how to deal with: " + f.getClass().getName()
                  + "\nUsing standard layout");
return null;
} 

 } 
