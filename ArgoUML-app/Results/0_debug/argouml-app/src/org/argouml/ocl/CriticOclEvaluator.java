
//#if 1952771672 
// Compilation Unit of /CriticOclEvaluator.java 
 

//#if -2137720159 
package org.argouml.ocl;
//#endif 


//#if -914134529 
import org.tigris.gef.ocl.ExpansionException;
//#endif 


//#if -435779563 

//#if -1522728047 
@Deprecated
//#endif 

public class CriticOclEvaluator  { 

//#if -805100123 
private static final CriticOclEvaluator INSTANCE =
        new CriticOclEvaluator();
//#endif 


//#if -911200113 
private static final OCLEvaluator EVALUATOR =
        new OCLEvaluator();
//#endif 


//#if -1175686547 
private CriticOclEvaluator()
    { 
} 

//#endif 


//#if -1569463282 
public synchronized String evalToString(
        Object self,
        String expr,
        String sep)
    throws ExpansionException
    { 

//#if -1368951060 
return EVALUATOR.evalToString(self, expr, sep);
//#endif 

} 

//#endif 


//#if 425812260 
public static final CriticOclEvaluator getInstance()
    { 

//#if -1028122585 
return INSTANCE;
//#endif 

} 

//#endif 


//#if 2118126607 
public synchronized String evalToString(Object self, String expr)
    throws ExpansionException
    { 

//#if 920780477 
return EVALUATOR.evalToString(self, expr);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

