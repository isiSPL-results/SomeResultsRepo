package org.argouml.profile.internal.ocl;
import tudresden.ocl.parser.analysis.DepthFirstAdapter;
import tudresden.ocl.parser.node.AConstraint;
import tudresden.ocl.parser.node.PConstraintBody;
public class EvaluateInvariant extends DepthFirstAdapter
  { 
private boolean ok = true;
private EvaluateExpression expEvaluator = null;
private Object modelElement;
private ModelInterpreter mi;
@Override
    public void caseAConstraint(AConstraint node)
    { 
inAConstraint(node);
if(node.getContextDeclaration() != null)//1
{ 
node.getContextDeclaration().apply(this);
} 
{ 
boolean localOk = true;
Object temp[] = node.getConstraintBody().toArray();
for (int i = 0; i < temp.length; i++) //1
{ 
expEvaluator.reset(modelElement, mi);
((PConstraintBody) temp[i]).apply(expEvaluator);
Object val = expEvaluator.getValue();
localOk &= val != null && (val instanceof Boolean)
                           && (Boolean) val;
} 
ok = localOk;
} 
outAConstraint(node);
} 
public EvaluateInvariant(Object element, ModelInterpreter interpreter)
    { 
this.modelElement = element;
this.mi = interpreter;
this.expEvaluator = new EvaluateExpression(element, interpreter);
} 
public boolean isOK()
    { 
return ok;
} 

 } 
