package org.argouml.uml.ui;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.SwingUtilities;
import org.argouml.model.Model;
import org.argouml.ui.TabTarget;
import org.argouml.ui.targetmanager.TargetEvent;
import org.argouml.ui.targetmanager.TargetListener;
import org.tigris.gef.presentation.Fig;
public abstract class UMLExpressionModel2 implements TargetListener
,PropertyChangeListener
  { 
private UMLUserInterfaceContainer container;
private String propertyName;
private Object expression;
private boolean mustRefresh;
private static final String EMPTYSTRING = "";
private Object target = null;
public UMLExpressionModel2(UMLUserInterfaceContainer c, String name)
    { 
container = c;
propertyName = name;
mustRefresh = true;
} 
public abstract void setExpression(Object expr);private void setExpression(String lang, String body)
    { 
Object oldExpression = null;
if(mustRefresh || expression == null)//1
{ 
oldExpression = expression;
expression = newExpression();
} 
expression = Model.getDataTypesHelper().setLanguage(expression, lang);
expression = Model.getDataTypesHelper().setBody(expression, body);
setExpression(expression);
if(oldExpression != null)//1
{ 
Model.getUmlFactory().delete(oldExpression);
} 
} 
public void targetSet(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public abstract Object getExpression();public void propertyChange(PropertyChangeEvent e)
    { 
if(target != null && target == e.getSource())//1
{ 
mustRefresh = true;
expression = null;
if(container instanceof TabTarget)//1
{ 
SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        ((TabTarget) container).refresh();
                        /* TODO: The above statement also refreshes when
                         * we are not shown (to be verified) - hence
                         * not entirely correct. */
                    }
                });
} 
} 
} 
public void setTarget(Object theNewTarget)
    { 
theNewTarget = theNewTarget instanceof Fig
                       ? ((Fig) theNewTarget).getOwner() : theNewTarget;
if(Model.getFacade().isAUMLElement(target))//1
{ 
Model.getPump().removeModelEventListener(this, target,
                    propertyName);
} 
if(Model.getFacade().isAUMLElement(theNewTarget))//1
{ 
target = theNewTarget;
Model.getPump().addModelEventListener(this, target,
                                                  propertyName);
if(container instanceof TabTarget)//1
{ 
((TabTarget) container).refresh();
} 
} 
else
{ 
target = null;
} 
} 
public void setBody(String body)
    { 
boolean mustChange = true;
if(expression != null)//1
{ 
Object oldValue = Model.getDataTypesHelper().getBody(expression);
if(oldValue != null && oldValue.equals(body))//1
{ 
mustChange = false;
} 
} 
if(mustChange)//1
{ 
String lang = null;
if(expression != null)//1
{ 
lang = Model.getDataTypesHelper().getLanguage(expression);
} 
if(lang == null)//1
{ 
lang = EMPTYSTRING;
} 
setExpression(lang, body);
} 
} 
public void targetRemoved(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public String getBody()
    { 
if(mustRefresh)//1
{ 
expression = getExpression();
} 
if(expression == null)//1
{ 
return EMPTYSTRING;
} 
return Model.getDataTypesHelper().getBody(expression);
} 
public String getLanguage()
    { 
if(mustRefresh)//1
{ 
expression = getExpression();
} 
if(expression == null)//1
{ 
return EMPTYSTRING;
} 
return Model.getDataTypesHelper().getLanguage(expression);
} 
public void setLanguage(String lang)
    { 
boolean mustChange = true;
if(expression != null)//1
{ 
String oldValue =
                Model.getDataTypesHelper().getLanguage(expression);
if(oldValue != null && oldValue.equals(lang))//1
{ 
mustChange = false;
} 
} 
if(mustChange)//1
{ 
String body = EMPTYSTRING;
if(expression != null
                    && Model.getDataTypesHelper().getBody(expression) != null)//1
{ 
body = Model.getDataTypesHelper().getBody(expression);
} 
setExpression(lang, body);
} 
} 
public void targetAdded(TargetEvent e)
    { 
setTarget(e.getNewTarget());
} 
public void targetChanged()
    { 
mustRefresh = true;
expression = null;
} 
protected UMLUserInterfaceContainer getContainer()
    { 
return container;
} 
public abstract Object newExpression();
 } 
