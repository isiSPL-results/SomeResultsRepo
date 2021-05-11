
//#if 2001776593 
// Compilation Unit of /UMLExpressionModel2.java 
 

//#if -1552406046 
package org.argouml.uml.ui;
//#endif 


//#if 1891191072 
import java.beans.PropertyChangeEvent;
//#endif 


//#if 2137918824 
import java.beans.PropertyChangeListener;
//#endif 


//#if 833005930 
import javax.swing.SwingUtilities;
//#endif 


//#if 1068900433 
import org.argouml.model.Model;
//#endif 


//#if 1909998293 
import org.argouml.ui.TabTarget;
//#endif 


//#if 1726426340 
import org.argouml.ui.targetmanager.TargetEvent;
//#endif 


//#if -1515560156 
import org.argouml.ui.targetmanager.TargetListener;
//#endif 


//#if 1510701384 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -656185280 
public abstract class UMLExpressionModel2 implements 
//#if 570109579 
TargetListener
//#endif 

, 
//#if 1310461151 
PropertyChangeListener
//#endif 

  { 

//#if 229973764 
private UMLUserInterfaceContainer container;
//#endif 


//#if 1457467213 
private String propertyName;
//#endif 


//#if 1776040519 
private Object expression;
//#endif 


//#if -1636117580 
private boolean mustRefresh;
//#endif 


//#if 401370944 
private static final String EMPTYSTRING = "";
//#endif 


//#if 1194558756 
private Object target = null;
//#endif 


//#if 366561855 
public UMLExpressionModel2(UMLUserInterfaceContainer c, String name)
    { 

//#if 166329811 
container = c;
//#endif 


//#if 626014322 
propertyName = name;
//#endif 


//#if 802798595 
mustRefresh = true;
//#endif 

} 

//#endif 


//#if 180638018 
public abstract void setExpression(Object expr);
//#endif 


//#if -133606712 
private void setExpression(String lang, String body)
    { 

//#if 38241293 
Object oldExpression = null;
//#endif 


//#if 1533620184 
if(mustRefresh || expression == null)//1
{ 

//#if -1356549161 
oldExpression = expression;
//#endif 


//#if -197519335 
expression = newExpression();
//#endif 

} 

//#endif 


//#if -2003124448 
expression = Model.getDataTypesHelper().setLanguage(expression, lang);
//#endif 


//#if 1995108254 
expression = Model.getDataTypesHelper().setBody(expression, body);
//#endif 


//#if 461938402 
setExpression(expression);
//#endif 


//#if 923154793 
if(oldExpression != null)//1
{ 

//#if 760302632 
Model.getUmlFactory().delete(oldExpression);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1940158765 
public void targetSet(TargetEvent e)
    { 

//#if 101065978 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 672771295 
public abstract Object getExpression();
//#endif 


//#if -60331591 
public void propertyChange(PropertyChangeEvent e)
    { 

//#if -944357239 
if(target != null && target == e.getSource())//1
{ 

//#if -1445941117 
mustRefresh = true;
//#endif 


//#if 314245838 
expression = null;
//#endif 


//#if 1420049453 
if(container instanceof TabTarget)//1
{ 

//#if 809425184 
SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        ((TabTarget) container).refresh();
                        /* TODO: The above statement also refreshes when
                         * we are not shown (to be verified) - hence
                         * not entirely correct. */
                    }
                });
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 724283538 
public void setTarget(Object theNewTarget)
    { 

//#if -1534286142 
theNewTarget = theNewTarget instanceof Fig
                       ? ((Fig) theNewTarget).getOwner() : theNewTarget;
//#endif 


//#if -929952555 
if(Model.getFacade().isAUMLElement(target))//1
{ 

//#if 39227513 
Model.getPump().removeModelEventListener(this, target,
                    propertyName);
//#endif 

} 

//#endif 


//#if -2057423322 
if(Model.getFacade().isAUMLElement(theNewTarget))//1
{ 

//#if 1845682411 
target = theNewTarget;
//#endif 


//#if -684425007 
Model.getPump().addModelEventListener(this, target,
                                                  propertyName);
//#endif 


//#if 164788208 
if(container instanceof TabTarget)//1
{ 

//#if 1427226516 
((TabTarget) container).refresh();
//#endif 

} 

//#endif 

} 
else
{ 

//#if 1308993312 
target = null;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1620516559 
public void setBody(String body)
    { 

//#if 759629373 
boolean mustChange = true;
//#endif 


//#if -2103217414 
if(expression != null)//1
{ 

//#if -684455759 
Object oldValue = Model.getDataTypesHelper().getBody(expression);
//#endif 


//#if -727267108 
if(oldValue != null && oldValue.equals(body))//1
{ 

//#if 259649258 
mustChange = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1571339256 
if(mustChange)//1
{ 

//#if -1180378917 
String lang = null;
//#endif 


//#if -24170775 
if(expression != null)//1
{ 

//#if -638041259 
lang = Model.getDataTypesHelper().getLanguage(expression);
//#endif 

} 

//#endif 


//#if -1701923165 
if(lang == null)//1
{ 

//#if 1961503303 
lang = EMPTYSTRING;
//#endif 

} 

//#endif 


//#if 898620639 
setExpression(lang, body);
//#endif 

} 

//#endif 

} 

//#endif 


//#if 885352529 
public void targetRemoved(TargetEvent e)
    { 

//#if -1965668724 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 507866809 
public String getBody()
    { 

//#if -1486721870 
if(mustRefresh)//1
{ 

//#if 1559484783 
expression = getExpression();
//#endif 

} 

//#endif 


//#if 2129600303 
if(expression == null)//1
{ 

//#if -416904693 
return EMPTYSTRING;
//#endif 

} 

//#endif 


//#if 260233256 
return Model.getDataTypesHelper().getBody(expression);
//#endif 

} 

//#endif 


//#if -663488529 
public String getLanguage()
    { 

//#if 873106901 
if(mustRefresh)//1
{ 

//#if 294910080 
expression = getExpression();
//#endif 

} 

//#endif 


//#if 653081580 
if(expression == null)//1
{ 

//#if -163992584 
return EMPTYSTRING;
//#endif 

} 

//#endif 


//#if 354228143 
return Model.getDataTypesHelper().getLanguage(expression);
//#endif 

} 

//#endif 


//#if 1989812537 
public void setLanguage(String lang)
    { 

//#if -1892459743 
boolean mustChange = true;
//#endif 


//#if -460339234 
if(expression != null)//1
{ 

//#if 1240429525 
String oldValue =
                Model.getDataTypesHelper().getLanguage(expression);
//#endif 


//#if 1181656536 
if(oldValue != null && oldValue.equals(lang))//1
{ 

//#if 1953809730 
mustChange = false;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1763675100 
if(mustChange)//1
{ 

//#if -74284470 
String body = EMPTYSTRING;
//#endif 


//#if -1148609100 
if(expression != null
                    && Model.getDataTypesHelper().getBody(expression) != null)//1
{ 

//#if 2069585323 
body = Model.getDataTypesHelper().getBody(expression);
//#endif 

} 

//#endif 


//#if 1525264135 
setExpression(lang, body);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -524579855 
public void targetAdded(TargetEvent e)
    { 

//#if -625097467 
setTarget(e.getNewTarget());
//#endif 

} 

//#endif 


//#if 1523421761 
public void targetChanged()
    { 

//#if 1473723733 
mustRefresh = true;
//#endif 


//#if 1378259900 
expression = null;
//#endif 

} 

//#endif 


//#if 1315502123 
protected UMLUserInterfaceContainer getContainer()
    { 

//#if -1703262732 
return container;
//#endif 

} 

//#endif 


//#if 1755490345 
public abstract Object newExpression();
//#endif 

 } 

//#endif 


//#endif 

