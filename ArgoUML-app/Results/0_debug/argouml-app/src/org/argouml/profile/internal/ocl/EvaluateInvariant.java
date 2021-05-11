
//#if -742683334 
// Compilation Unit of /EvaluateInvariant.java 
 

//#if -1018964745 
package org.argouml.profile.internal.ocl;
//#endif 


//#if -1728495264 
import tudresden.ocl.parser.analysis.DepthFirstAdapter;
//#endif 


//#if 717911806 
import tudresden.ocl.parser.node.AConstraint;
//#endif 


//#if 2059233293 
import tudresden.ocl.parser.node.PConstraintBody;
//#endif 


//#if -256783901 
public class EvaluateInvariant extends 
//#if 1395889844 
DepthFirstAdapter
//#endif 

  { 

//#if 1263059135 
private boolean ok = true;
//#endif 


//#if -377259025 
private EvaluateExpression expEvaluator = null;
//#endif 


//#if -2103130636 
private Object modelElement;
//#endif 


//#if -2091469639 
private ModelInterpreter mi;
//#endif 


//#if 193869918 
@Override
    public void caseAConstraint(AConstraint node)
    { 

//#if 327254568 
inAConstraint(node);
//#endif 


//#if 947379399 
if(node.getContextDeclaration() != null)//1
{ 

//#if -112113739 
node.getContextDeclaration().apply(this);
//#endif 

} 

//#endif 

{ 

//#if -1972710519 
boolean localOk = true;
//#endif 


//#if 746096882 
Object temp[] = node.getConstraintBody().toArray();
//#endif 


//#if 1389162670 
for (int i = 0; i < temp.length; i++) //1
{ 

//#if 1265986910 
expEvaluator.reset(modelElement, mi);
//#endif 


//#if -1103753160 
((PConstraintBody) temp[i]).apply(expEvaluator);
//#endif 


//#if -601479798 
Object val = expEvaluator.getValue();
//#endif 


//#if -1106023349 
localOk &= val != null && (val instanceof Boolean)
                           && (Boolean) val;
//#endif 

} 

//#endif 


//#if 1531130651 
ok = localOk;
//#endif 

} 

//#if -1490664345 
outAConstraint(node);
//#endif 

} 

//#endif 


//#if 1946701735 
public EvaluateInvariant(Object element, ModelInterpreter interpreter)
    { 

//#if 1582601445 
this.modelElement = element;
//#endif 


//#if 479080894 
this.mi = interpreter;
//#endif 


//#if 52551934 
this.expEvaluator = new EvaluateExpression(element, interpreter);
//#endif 

} 

//#endif 


//#if 608955352 
public boolean isOK()
    { 

//#if 1001040671 
return ok;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

