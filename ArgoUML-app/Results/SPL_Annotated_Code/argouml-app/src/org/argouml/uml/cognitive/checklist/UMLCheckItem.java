// Compilation Unit of /UMLCheckItem.java 
 

//#if COGNITIVE 
package org.argouml.uml.cognitive.checklist;
//#endif 


//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
import org.apache.log4j.Logger;
//#endif 


//#if COGNITIVE 
import org.argouml.cognitive.checklist.CheckItem;
//#endif 


//#if COGNITIVE 
import org.argouml.i18n.Translator;
//#endif 


//#if COGNITIVE 
import org.argouml.model.InvalidElementException;
//#endif 


//#if COGNITIVE 
import org.argouml.ocl.CriticOclEvaluator;
//#endif 


//#if COGNITIVE 
import org.argouml.ocl.OCLEvaluator;
//#endif 


//#if COGNITIVE 
import org.tigris.gef.ocl.ExpansionException;
//#endif 


//#if COGNITIVE 
public class UMLCheckItem extends CheckItem
  { 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
private static final Logger LOG =
        Logger.getLogger(UMLCheckItem.class);
//#endif 

public UMLCheckItem(String c, String d, String m,
                        org.tigris.gef.util.Predicate p)
    { 
super(c, d, m, p);
} 

public UMLCheckItem(String c, String d, String m,
                        org.argouml.util.Predicate p)
    { 
super(c, d, m, p);
} 

public UMLCheckItem(String c, String d)
    { 
super(c, d);
} 

@Override
    public String expand(String res, Object dm)
    { 
int searchPos = 0;
int matchPos = res.indexOf(OCLEvaluator.OCL_START, searchPos);
while (matchPos != -1) //1
{ 
int endExpr = res.indexOf(OCLEvaluator.OCL_END, matchPos + 1);
String expr = res.substring(matchPos
                                        + OCLEvaluator.OCL_START.length(), endExpr);
String evalStr = null;
try //1
{ 
evalStr = CriticOclEvaluator.getInstance()
                          .evalToString(dm, expr);
} 

//#if COGNITIVE 
catch (ExpansionException e) //1
{ 

//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.error("Failed to evaluate critic expression", e);
//#endif 

} 

//#endif 


//#if COGNITIVE 
catch (InvalidElementException e) //1
{ 
evalStr = Translator.localize("misc.name.deleted");
} 

//#endif 



//#if (( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE ) || ( DEPLOYMENT  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COGNITIVE  &&  ACTIVITY ) || ( DEPLOYMENT  &&  SEQUENCE  &&  USECASE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY ) || ( SEQUENCE  &&  USECASE  &&  STATE  &&  LOGGING  &&  COLLABORATION  &&  COGNITIVE  &&  ACTIVITY )) 
LOG.debug("expr='" + expr + "' = '" + evalStr + "'");
//#endif 

res = res.substring(0, matchPos) + evalStr
                  + res.substring(endExpr + OCLEvaluator.OCL_END.length());
searchPos = endExpr + 1;
matchPos = res.indexOf(OCLEvaluator.OCL_START, searchPos);
} 

return res;
} 

 } 

//#endif 


