package org.argouml.profile.internal.ocl;
import java.io.PushbackReader;
import java.io.StringReader;
import java.util.List;
import java.util.Set;
import tudresden.ocl.parser.OclParser;
import tudresden.ocl.parser.lexer.Lexer;
import tudresden.ocl.parser.node.Start;
public class OclInterpreter  { 
private Start tree = null;
private ModelInterpreter modelInterpreter;
public Set<Object> getCriticizedDesignMaterials()
    { 
ComputeDesignMaterials cdm = new ComputeDesignMaterials();
tree.apply(cdm);
return cdm.getCriticizedDesignMaterials();
} 
public boolean check(Object modelElement)
    { 
EvaluateInvariant ei = new EvaluateInvariant(modelElement,
                modelInterpreter);
tree.apply(ei);
return ei.isOK();
} 
public boolean applicable(Object modelElement)
    { 
ContextApplicable ca = new ContextApplicable(modelElement);
tree.apply(ca);
return ca.isApplicable();
} 
public OclInterpreter(String ocl, ModelInterpreter interpreter)
    throws InvalidOclException
    { 
this.modelInterpreter = interpreter;
Lexer lexer = new Lexer(new PushbackReader(new StringReader(ocl), 2));
OclParser parser = new OclParser(lexer);
try//1
{ 
tree = parser.parse();
} 
catch (Exception e) //1
{ 
e.printStackTrace();
throw new InvalidOclException(ocl);
} 
} 
public List<String> getTriggers()
    { 
ComputeTriggers ct = new ComputeTriggers();
tree.apply(ct);
return ct.getTriggers();
} 

 } 
