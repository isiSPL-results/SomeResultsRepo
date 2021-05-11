package org.argouml.uml.cognitive.checklist;
import org.argouml.cognitive.checklist.CheckItem;
import org.argouml.i18n.Translator;
import org.argouml.model.InvalidElementException;
import org.argouml.ocl.CriticOclEvaluator;
import org.argouml.ocl.OCLEvaluator;
import org.tigris.gef.ocl.ExpansionException;
public class UMLCheckItem extends CheckItem
  { 
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
try//1
{ 
evalStr = CriticOclEvaluator.getInstance()
                          .evalToString(dm, expr);
} 
catch (ExpansionException e) //1
{ 
} 
catch (InvalidElementException e) //1
{ 
evalStr = Translator.localize("misc.name.deleted");
} 
res = res.substring(0, matchPos) + evalStr
                  + res.substring(endExpr + OCLEvaluator.OCL_END.length());
searchPos = endExpr + 1;
matchPos = res.indexOf(OCLEvaluator.OCL_START, searchPos);
} 
return res;
} 

 } 
