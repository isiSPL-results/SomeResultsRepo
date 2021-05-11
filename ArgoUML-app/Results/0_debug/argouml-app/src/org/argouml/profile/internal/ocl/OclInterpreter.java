
//#if -1983014088 
// Compilation Unit of /OclInterpreter.java 
 

//#if -1668892263 
package org.argouml.profile.internal.ocl;
//#endif 


//#if 66982153 
import java.io.PushbackReader;
//#endif 


//#if -626578823 
import java.io.StringReader;
//#endif 


//#if -1838666581 
import java.util.List;
//#endif 


//#if -1028938485 
import java.util.Set;
//#endif 


//#if 306390157 
import tudresden.ocl.parser.OclParser;
//#endif 


//#if -901356966 
import tudresden.ocl.parser.lexer.Lexer;
//#endif 


//#if -706618852 
import tudresden.ocl.parser.node.Start;
//#endif 


//#if -1474544476 
public class OclInterpreter  { 

//#if -2006600993 
private Start tree = null;
//#endif 


//#if -1411690559 
private ModelInterpreter modelInterpreter;
//#endif 


//#if 973722854 
public Set<Object> getCriticizedDesignMaterials()
    { 

//#if 394087308 
ComputeDesignMaterials cdm = new ComputeDesignMaterials();
//#endif 


//#if -80559691 
tree.apply(cdm);
//#endif 


//#if -1581255565 
return cdm.getCriticizedDesignMaterials();
//#endif 

} 

//#endif 


//#if 1214675331 
public boolean check(Object modelElement)
    { 

//#if 2042885093 
EvaluateInvariant ei = new EvaluateInvariant(modelElement,
                modelInterpreter);
//#endif 


//#if -258676248 
tree.apply(ei);
//#endif 


//#if 142654642 
return ei.isOK();
//#endif 

} 

//#endif 


//#if -1347607870 
public boolean applicable(Object modelElement)
    { 

//#if 2895025 
ContextApplicable ca = new ContextApplicable(modelElement);
//#endif 


//#if -815013891 
tree.apply(ca);
//#endif 


//#if 1717831982 
return ca.isApplicable();
//#endif 

} 

//#endif 


//#if 785249130 
public OclInterpreter(String ocl, ModelInterpreter interpreter)
    throws InvalidOclException
    { 

//#if 186732472 
this.modelInterpreter = interpreter;
//#endif 


//#if 1851514322 
Lexer lexer = new Lexer(new PushbackReader(new StringReader(ocl), 2));
//#endif 


//#if 366101647 
OclParser parser = new OclParser(lexer);
//#endif 


//#if -2145401231 
try //1
{ 

//#if 1244481077 
tree = parser.parse();
//#endif 

} 

//#if -863132589 
catch (Exception e) //1
{ 

//#if 1959652653 
e.printStackTrace();
//#endif 


//#if -306615070 
throw new InvalidOclException(ocl);
//#endif 

} 

//#endif 


//#endif 

} 

//#endif 


//#if 2099540687 
public List<String> getTriggers()
    { 

//#if 932439839 
ComputeTriggers ct = new ComputeTriggers();
//#endif 


//#if 1016883710 
tree.apply(ct);
//#endif 


//#if 289438791 
return ct.getTriggers();
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

