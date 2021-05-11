
//#if -1512808300 
// Compilation Unit of /CrUML.java 
 

//#if -1804169976 
package org.argouml.uml.cognitive.critics;
//#endif 


//#if -1357559221 
import org.apache.log4j.Logger;
//#endif 


//#if 976072940 
import org.argouml.cognitive.Critic;
//#endif 


//#if -1317221355 
import org.argouml.cognitive.Designer;
//#endif 


//#if -413044782 
import org.argouml.cognitive.ListSet;
//#endif 


//#if 1457760295 
import org.argouml.cognitive.ToDoItem;
//#endif 


//#if 222333318 
import org.argouml.cognitive.Translator;
//#endif 


//#if 489977278 
import org.argouml.model.Model;
//#endif 


//#if 1336884147 
import org.argouml.ocl.CriticOclEvaluator;
//#endif 


//#if 125767587 
import org.argouml.uml.cognitive.UMLToDoItem;
//#endif 


//#if 42286335 
import org.tigris.gef.ocl.ExpansionException;
//#endif 


//#if 1879808283 
public class CrUML extends 
//#if 836098826 
Critic
//#endif 

  { 

//#if 1267197061 
private static final Logger LOG = Logger.getLogger(CrUML.class);
//#endif 


//#if 1158768202 
private String localizationPrefix = "critics";
//#endif 


//#if -872048121 
private static final String OCL_START = "<ocl>";
//#endif 


//#if -1084150177 
private static final String OCL_END = "</ocl>";
//#endif 


//#if -414015183 
private static final long serialVersionUID = 1785043010468681602L;
//#endif 


//#if -291687174 
@Override
    public boolean predicate(Object dm, Designer dsgr)
    { 

//#if -1667324076 
if(Model.getFacade().isAModelElement(dm)
                && Model.getUmlFactory().isRemoved(dm))//1
{ 

//#if -1974565410 
return NO_PROBLEM;
//#endif 

} 
else
{ 

//#if 489587791 
return predicate2(dm, dsgr);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1545201721 
public CrUML()
    { 
} 

//#endif 


//#if 31658295 
public CrUML(String nonDefaultLocalizationPrefix)
    { 

//#if -527524151 
if(nonDefaultLocalizationPrefix != null)//1
{ 

//#if 1785464603 
this.localizationPrefix = nonDefaultLocalizationPrefix;
//#endif 


//#if -736913584 
setupHeadAndDesc();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1493923618 
protected String getLocalizedString(String suffix)
    { 

//#if -977315185 
return getLocalizedString(getClassSimpleName(), suffix);
//#endif 

} 

//#endif 


//#if -1163238759 
protected String getDefaultSuggestion()
    { 

//#if 1128561187 
return getLocalizedString("-sug");
//#endif 

} 

//#endif 


//#if -1610124868 
public String expand(String res, ListSet offs)
    { 

//#if -1558747860 
if(offs.size() == 0)//1
{ 

//#if 1100217881 
return res;
//#endif 

} 

//#endif 


//#if -220291625 
Object off1 = offs.get(0);
//#endif 


//#if -422137531 
StringBuffer beginning = new StringBuffer("");
//#endif 


//#if 505705814 
int matchPos = res.indexOf(OCL_START);
//#endif 


//#if -1352312903 
while (matchPos != -1) //1
{ 

//#if -404525883 
int endExpr = res.indexOf(OCL_END, matchPos + 1);
//#endif 


//#if 708462644 
if(endExpr == -1)//1
{ 

//#if 596771403 
break;

//#endif 

} 

//#endif 


//#if 1090324049 
if(matchPos > 0)//1
{ 

//#if -888769367 
beginning.append(res.substring(0, matchPos));
//#endif 

} 

//#endif 


//#if 1540136403 
String expr = res.substring(matchPos + OCL_START.length(), endExpr);
//#endif 


//#if 1693810040 
String evalStr = null;
//#endif 


//#if 1882410809 
try //1
{ 

//#if -1791788157 
evalStr =
                    CriticOclEvaluator.getInstance().evalToString(off1, expr);
//#endif 

} 

//#if 290075969 
catch (ExpansionException e) //1
{ 

//#if -1418322096 
LOG.error("Failed to evaluate critic expression", e);
//#endif 

} 

//#endif 


//#endif 


//#if 1651698513 
if(expr.endsWith("") && evalStr.equals(""))//1
{ 

//#if -1589320314 
evalStr = Translator.localize("misc.name.anon");
//#endif 

} 

//#endif 


//#if 709877069 
beginning.append(evalStr);
//#endif 


//#if -167403085 
res = res.substring(endExpr + OCL_END.length());
//#endif 


//#if -1909951179 
matchPos = res.indexOf(OCL_START);
//#endif 

} 

//#endif 


//#if 979419424 
if(beginning.length() == 0)//1
{ 

//#if 1873031065 
return res;
//#endif 

} 
else
{ 

//#if -1424816593 
return beginning.append(res).toString();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1833378349 
protected String getInstructions()
    { 

//#if 630680938 
return getLocalizedString("-ins");
//#endif 

} 

//#endif 


//#if 520675200 
protected String getLocalizedString(String key, String suffix)
    { 

//#if 1247935869 
return Translator.localize(localizationPrefix + "." + key + suffix);
//#endif 

} 

//#endif 


//#if -129632858 
public void setResource(String key)
    { 

//#if 681252599 
super.setHeadline(getLocalizedString(key, "-head"));
//#endif 


//#if -1753141056 
super.setDescription(getLocalizedString(key, "-desc"));
//#endif 

} 

//#endif 


//#if 1647597527 
@Override
    public ToDoItem toDoItem(Object dm, Designer dsgr)
    { 

//#if -1471009634 
return new UMLToDoItem(this, dm, dsgr);
//#endif 

} 

//#endif 


//#if -576544732 
public boolean predicate2(Object dm, Designer dsgr)
    { 

//#if 1626257556 
return super.predicate(dm, dsgr);
//#endif 

} 

//#endif 


//#if -8325574 
private final String getClassSimpleName()
    { 

//#if -335711084 
String className = getClass().getName();
//#endif 


//#if -92594984 
return className.substring(className.lastIndexOf('.') + 1);
//#endif 

} 

//#endif 


//#if 1123311575 
public final void setupHeadAndDesc()
    { 

//#if -1787435586 
setResource(getClassSimpleName());
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

