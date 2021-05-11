
//#if 374988110 
// Compilation Unit of /UMLCheckItem.java 
 

//#if -623564193 
package org.argouml.uml.cognitive.checklist;
//#endif 


//#if 1593180909 
import org.apache.log4j.Logger;
//#endif 


//#if -153291195 
import org.argouml.cognitive.checklist.CheckItem;
//#endif 


//#if 1956972186 
import org.argouml.i18n.Translator;
//#endif 


//#if -1541039777 
import org.argouml.model.InvalidElementException;
//#endif 


//#if -2129253935 
import org.argouml.ocl.CriticOclEvaluator;
//#endif 


//#if -1156172123 
import org.argouml.ocl.OCLEvaluator;
//#endif 


//#if -73584095 
import org.tigris.gef.ocl.ExpansionException;
//#endif 


//#if 1587816303 
public class UMLCheckItem extends 
//#if 192685503 
CheckItem
//#endif 

  { 

//#if 1689889273 
private static final Logger LOG =
        Logger.getLogger(UMLCheckItem.class);
//#endif 


//#if 656249637 
public UMLCheckItem(String c, String d, String m,
                        org.tigris.gef.util.Predicate p)
    { 

//#if 2074722106 
super(c, d, m, p);
//#endif 

} 

//#endif 


//#if 1585098176 
public UMLCheckItem(String c, String d, String m,
                        org.argouml.util.Predicate p)
    { 

//#if 1214271255 
super(c, d, m, p);
//#endif 

} 

//#endif 


//#if -1294192052 
public UMLCheckItem(String c, String d)
    { 

//#if -1893132938 
super(c, d);
//#endif 

} 

//#endif 


//#if 1050683392 
@Override
    public String expand(String res, Object dm)
    { 

//#if -2134980175 
int searchPos = 0;
//#endif 


//#if 1497929468 
int matchPos = res.indexOf(OCLEvaluator.OCL_START, searchPos);
//#endif 


//#if 1911927240 
while (matchPos != -1) //1
{ 

//#if 1905571001 
int endExpr = res.indexOf(OCLEvaluator.OCL_END, matchPos + 1);
//#endif 


//#if 1405889595 
String expr = res.substring(matchPos
                                        + OCLEvaluator.OCL_START.length(), endExpr);
//#endif 


//#if 2130025167 
String evalStr = null;
//#endif 


//#if -1992601470 
try //1
{ 

//#if 588950945 
evalStr = CriticOclEvaluator.getInstance()
                          .evalToString(dm, expr);
//#endif 

} 

//#if 1350297004 
catch (ExpansionException e) //1
{ 

//#if -1465356974 
LOG.error("Failed to evaluate critic expression", e);
//#endif 

} 

//#endif 


//#if 620043188 
catch (InvalidElementException e) //1
{ 

//#if 322229650 
evalStr = Translator.localize("misc.name.deleted");
//#endif 

} 

//#endif 


//#endif 


//#if -1470955286 
LOG.debug("expr='" + expr + "' = '" + evalStr + "'");
//#endif 


//#if -1608771847 
res = res.substring(0, matchPos) + evalStr
                  + res.substring(endExpr + OCLEvaluator.OCL_END.length());
//#endif 


//#if -1663886878 
searchPos = endExpr + 1;
//#endif 


//#if -1848710267 
matchPos = res.indexOf(OCLEvaluator.OCL_START, searchPos);
//#endif 

} 

//#endif 


//#if -1918408507 
return res;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

