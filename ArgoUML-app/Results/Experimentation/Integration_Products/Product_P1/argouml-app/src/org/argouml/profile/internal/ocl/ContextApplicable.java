package org.argouml.profile.internal.ocl;
import org.argouml.model.Model;
import tudresden.ocl.parser.analysis.DepthFirstAdapter;
import tudresden.ocl.parser.node.AClassifierContext;
import tudresden.ocl.parser.node.APostStereotype;
import tudresden.ocl.parser.node.APreStereotype;
public class ContextApplicable extends DepthFirstAdapter
  { 
private boolean applicable = true;
private Object modelElement;
public ContextApplicable(Object element)
    { 
this.modelElement = element;
} 
public void inAPreStereotype(APreStereotype node)
    { 
applicable = false;
} 
public void inAPostStereotype(APostStereotype node)
    { 
applicable = false;
} 
public boolean isApplicable()
    { 
return applicable;
} 
public void caseAClassifierContext(AClassifierContext node)
    { 
String metaclass = ("" + node.getPathTypeName()).trim();
applicable &= Model.getFacade().isA(metaclass, modelElement);
} 

 } 
