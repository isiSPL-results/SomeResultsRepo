
//#if 1056858313 
// Compilation Unit of /ClassdiagramModelElementFactory.java 
 

//#if 1645622915 
package org.argouml.uml.diagram.static_structure.layout;
//#endif 


//#if -1493631296 
import org.apache.log4j.Logger;
//#endif 


//#if 1428417728 
import org.argouml.uml.diagram.layout.LayoutedObject;
//#endif 


//#if 815590081 
import org.argouml.uml.diagram.static_structure.ui.FigComment;
//#endif 


//#if 1217172071 
import org.argouml.uml.diagram.static_structure.ui.FigEdgeNote;
//#endif 


//#if -1196323888 
import org.argouml.uml.diagram.ui.FigAbstraction;
//#endif 


//#if 1143064405 
import org.argouml.uml.diagram.ui.FigAssociation;
//#endif 


//#if -846241820 
import org.argouml.uml.diagram.ui.FigGeneralization;
//#endif 


//#if 2096405899 
import org.argouml.uml.diagram.ui.FigNodeModelElement;
//#endif 


//#if 136680392 
import org.tigris.gef.presentation.FigNode;
//#endif 


//#if -1183135161 
public class ClassdiagramModelElementFactory  { 

//#if -1915281913 
private static final Logger LOG =
        Logger.getLogger(ClassdiagramModelElementFactory.class);
//#endif 


//#if -29051474 
public static final ClassdiagramModelElementFactory SINGLETON =
        new ClassdiagramModelElementFactory();
//#endif 


//#if 410266011 
private ClassdiagramModelElementFactory() { 
} 

//#endif 


//#if 787457041 
public LayoutedObject getInstance(Object f)
    { 

//#if -190586474 
if(f instanceof FigComment)//1
{ 

//#if 623958411 
return (new ClassdiagramNote((FigComment) f));
//#endif 

} 
else

//#if -1186705855 
if(f instanceof FigNodeModelElement)//1
{ 

//#if 1007787629 
return (new ClassdiagramNode((FigNode) f));
//#endif 

} 
else

//#if -212284902 
if(f instanceof FigGeneralization)//1
{ 

//#if 2146246037 
return new ClassdiagramGeneralizationEdge((FigGeneralization) f);
//#endif 

} 
else

//#if 1792633348 
if(f instanceof FigAbstraction)//1
{ 

//#if 211318760 
return (new ClassdiagramRealizationEdge((FigAbstraction) f));
//#endif 

} 
else

//#if -950400660 
if(f instanceof FigAssociation)//1
{ 

//#if -1364071535 
return (new ClassdiagramAssociationEdge((FigAssociation) f));
//#endif 

} 
else

//#if 1159224593 
if(f instanceof FigEdgeNote)//1
{ 

//#if 1101000564 
return (new ClassdiagramNoteEdge((FigEdgeNote) f));
//#endif 

} 

//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#endif 


//#if 310235955 
LOG.debug("Do not know how to deal with: " + f.getClass().getName()
                  + "\nUsing standard layout");
//#endif 


//#if -1582561928 
return null;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

