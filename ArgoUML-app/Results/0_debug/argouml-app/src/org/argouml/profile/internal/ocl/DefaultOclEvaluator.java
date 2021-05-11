
//#if -1789225404 
// Compilation Unit of /DefaultOclEvaluator.java 
 

//#if 1445468227 
package org.argouml.profile.internal.ocl;
//#endif 


//#if -96126817 
import java.io.PushbackReader;
//#endif 


//#if -291553393 
import java.io.StringReader;
//#endif 


//#if 235451131 
import java.util.Map;
//#endif 


//#if 512513571 
import tudresden.ocl.parser.OclParser;
//#endif 


//#if -385251728 
import tudresden.ocl.parser.lexer.Lexer;
//#endif 


//#if 1388239686 
import tudresden.ocl.parser.node.Start;
//#endif 


//#if -1572730979 
import org.apache.log4j.Logger;
//#endif 


//#if -1002326816 
public class DefaultOclEvaluator implements 
//#if 1975127091 
OclExpressionEvaluator
//#endif 

  { 

//#if -1726891704 
private static OclExpressionEvaluator instance = null;
//#endif 


//#if 968435030 
private static final Logger LOG = Logger
                                      .getLogger(DefaultOclEvaluator.class);
//#endif 


//#if -357200969 
public Object evaluate(Map<String, Object> vt, ModelInterpreter mi,
                           String ocl) throws InvalidOclException
    { 

//#if -114820880 
LOG.debug("OCL: " + ocl);
//#endif 


//#if -1498976501 
if(ocl.contains("ore"))//1
{ 

//#if 1836908357 
System.out.println("VOILA!");
//#endif 

} 

//#endif 


//#if -771041358 
Lexer lexer = new Lexer(new PushbackReader(new StringReader(
                                    "context X inv: " + ocl), 2));
//#endif 


//#if 1563199624 
OclParser parser = new OclParser(lexer);
//#endif 


//#if 1076125027 
Start tree = null;
//#endif 


//#if -1652157398 
try //1
{ 

//#if -1268553763 
tree = parser.parse();
//#endif 

} 

//#if 541054137 
catch (Exception e) //1
{ 

//#if -1271525311 
throw new InvalidOclException(ocl);
//#endif 

} 

//#endif 


//#endif 


//#if -1331065139 
EvaluateExpression ee = new EvaluateExpression(vt, mi);
//#endif 


//#if -1297315672 
tree.apply(ee);
//#endif 


//#if -2040503019 
return ee.getValue();
//#endif 

} 

//#endif 


//#if 1113751426 
public static OclExpressionEvaluator getInstance()
    { 

//#if 323596373 
if(instance == null)//1
{ 

//#if 1873713103 
instance = new DefaultOclEvaluator();
//#endif 

} 

//#endif 


//#if 783155324 
return instance;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

