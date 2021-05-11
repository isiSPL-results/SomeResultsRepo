// Compilation Unit of /DefaultOclEvaluator.java 
 
package org.argouml.profile.internal.ocl;
import java.io.PushbackReader;
import java.io.StringReader;
import java.util.Map;
import tudresden.ocl.parser.OclParser;
import tudresden.ocl.parser.lexer.Lexer;
import tudresden.ocl.parser.node.Start;

//#if LOGGING 
import org.apache.log4j.Logger;
//#endif 

public class DefaultOclEvaluator implements OclExpressionEvaluator
  { 
private static OclExpressionEvaluator instance = null;

//#if LOGGING 
private static final Logger LOG = Logger
                                      .getLogger(DefaultOclEvaluator.class);
//#endif 

public Object evaluate(Map<String, Object> vt, ModelInterpreter mi,
                           String ocl) throws InvalidOclException
    { 

//#if LOGGING 
LOG.debug("OCL: " + ocl);
//#endif 

if(ocl.contains("ore"))//1
{ 
System.out.println("VOILA!");
} 

Lexer lexer = new Lexer(new PushbackReader(new StringReader(
                                    "context X inv: " + ocl), 2));
OclParser parser = new OclParser(lexer);
Start tree = null;
try //1
{ 
tree = parser.parse();
} 
catch (Exception e) //1
{ 
throw new InvalidOclException(ocl);
} 


EvaluateExpression ee = new EvaluateExpression(vt, mi);
tree.apply(ee);
return ee.getValue();
} 

public static OclExpressionEvaluator getInstance()
    { 
if(instance == null)//1
{ 
instance = new DefaultOclEvaluator();
} 

return instance;
} 

 } 


