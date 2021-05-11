
//#if 370558534 
// Compilation Unit of /FigEnumLiteralsCompartment.java 
 

//#if 517918297 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 2002582649 
import java.awt.Rectangle;
//#endif 


//#if 1061055694 
import java.util.Collection;
//#endif 


//#if -732868509 
import org.argouml.model.Model;
//#endif 


//#if 207716904 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 50364832 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if -1716707297 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1951474618 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 219260126 
import org.argouml.uml.diagram.static_structure.ui.FigEnumerationLiteral;
//#endif 


//#if -274246418 
public class FigEnumLiteralsCompartment extends 
//#if 294752371 
FigEditableCompartment
//#endif 

  { 

//#if -100717184 
private static final long serialVersionUID = 829674049363538379L;
//#endif 


//#if -511776755 
@Override
    protected FigSingleLineTextWithNotation createFigText(Object owner,
            Rectangle bounds, DiagramSettings settings)
    { 

//#if -148302538 
return new FigEnumerationLiteral(owner, bounds, settings);
//#endif 

} 

//#endif 


//#if 474373527 

//#if 678181841 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigEnumLiteralsCompartment(int x, int y, int w, int h)
    { 

//#if -1625316344 
super(x, y, w, h);
//#endif 

} 

//#endif 


//#if -526966231 
protected int getNotationType()
    { 

//#if -363268625 
return NotationProviderFactory2.TYPE_ENUMERATION_LITERAL;
//#endif 

} 

//#endif 


//#if 1793631165 
public FigEnumLiteralsCompartment(Object owner, Rectangle bounds,
                                      DiagramSettings settings)
    { 

//#if 176221389 
super(owner, bounds, settings);
//#endif 


//#if 1220581636 
super.populate();
//#endif 

} 

//#endif 


//#if -1803732992 
protected Collection getUmlCollection()
    { 

//#if 193075864 
return Model.getFacade().getEnumerationLiterals(getOwner());
//#endif 

} 

//#endif 


//#if 273161381 

//#if 895361603 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    protected FigSingleLineTextWithNotation createFigText(Object owner,
            Rectangle bounds, DiagramSettings settings, NotationProvider np)
    { 

//#if 1957679544 
return new FigEnumerationLiteral(owner, bounds, settings, np);
//#endif 

} 

//#endif 


//#if 1143817705 
protected void createModelElement()
    { 

//#if 426463642 
Object enumeration = getGroup().getOwner();
//#endif 


//#if 1363005494 
Object literal = Model.getCoreFactory().buildEnumerationLiteral(
                             "literal",  enumeration);
//#endif 


//#if -1162261972 
TargetManager.getInstance().setTarget(literal);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

