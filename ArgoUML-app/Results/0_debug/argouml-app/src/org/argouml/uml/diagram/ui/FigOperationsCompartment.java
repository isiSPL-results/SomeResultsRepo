
//#if 1143241323 
// Compilation Unit of /FigOperationsCompartment.java 
 

//#if -1186444205 
package org.argouml.uml.diagram.ui;
//#endif 


//#if 1312881983 
import java.awt.Rectangle;
//#endif 


//#if -316320748 
import java.util.Collection;
//#endif 


//#if 1359921805 
import org.argouml.kernel.Project;
//#endif 


//#if -36906147 
import org.argouml.model.Model;
//#endif 


//#if -1977004126 
import org.argouml.notation.NotationProvider;
//#endif 


//#if 1061696794 
import org.argouml.notation.NotationProviderFactory2;
//#endif 


//#if 1106030309 
import org.argouml.ui.targetmanager.TargetManager;
//#endif 


//#if -1229376704 
import org.argouml.uml.diagram.DiagramSettings;
//#endif 


//#if 1129403279 
import org.argouml.uml.diagram.static_structure.ui.FigOperation;
//#endif 


//#if 146047469 
public class FigOperationsCompartment extends 
//#if -1288176607 
FigEditableCompartment
//#endif 

  { 

//#if 1943287109 
private static final long serialVersionUID = -2605582251722944961L;
//#endif 


//#if 1156553132 

//#if -1735615021 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    public FigOperationsCompartment(int x, int y, int w, int h)
    { 

//#if -716619704 
super(x, y, w, h);
//#endif 

} 

//#endif 


//#if 574295967 
@Override
    protected FigSingleLineTextWithNotation createFigText(Object owner,
            Rectangle bounds,
            DiagramSettings settings)
    { 

//#if -2051186949 
return new FigOperation(owner, bounds, settings);
//#endif 

} 

//#endif 


//#if -300089994 
public FigOperationsCompartment(Object owner, Rectangle bounds,
                                    DiagramSettings settings)
    { 

//#if 1216025664 
super(owner, bounds, settings);
//#endif 


//#if 1287394551 
super.populate();
//#endif 

} 

//#endif 


//#if -1180409477 
protected void createModelElement()
    { 

//#if -55585878 
Object classifier = getGroup().getOwner();
//#endif 


//#if -1809289754 
Project project = getProject();
//#endif 


//#if 907081000 
Object returnType = project.getDefaultReturnType();
//#endif 


//#if -1990970073 
Object oper = Model.getCoreFactory().buildOperation(classifier,
                      returnType);
//#endif 


//#if -1417871755 
TargetManager.getInstance().setTarget(oper);
//#endif 

} 

//#endif 


//#if -251734341 
protected int getNotationType()
    { 

//#if 887543609 
return NotationProviderFactory2.TYPE_OPERATION;
//#endif 

} 

//#endif 


//#if -1018677065 

//#if -1314653311 
@SuppressWarnings("deprecation")
//#endif 


    @Deprecated
    @Override
    protected FigSingleLineTextWithNotation createFigText(Object owner,
            Rectangle bounds,
            DiagramSettings settings, NotationProvider np)
    { 

//#if 1435722305 
return new FigOperation(owner, bounds, settings, np);
//#endif 

} 

//#endif 


//#if -84395374 
protected Collection getUmlCollection()
    { 

//#if -1805076271 
Object classifier = getOwner();
//#endif 


//#if 1911766815 
return Model.getFacade().getOperationsAndReceptions(classifier);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

