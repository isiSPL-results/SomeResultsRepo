
//#if -520610084 
// Compilation Unit of /AbstractActionAddModelElement2.java 
 

//#if -853592377 
package org.argouml.uml.ui;
//#endif 


//#if 1603771685 
import java.awt.event.ActionEvent;
//#endif 


//#if 453108571 
import java.util.Collection;
//#endif 


//#if -1370294309 
import java.util.List;
//#endif 


//#if 1857991766 
import java.util.Vector;
//#endif 


//#if 1132896155 
import javax.swing.Action;
//#endif 


//#if 1693476664 
import javax.swing.Icon;
//#endif 


//#if -1381289346 
import javax.swing.JOptionPane;
//#endif 


//#if 1371271152 
import org.argouml.i18n.Translator;
//#endif 


//#if 1210165632 
import org.argouml.kernel.UmlModelMutator;
//#endif 


//#if 187087316 
import org.argouml.util.ArgoFrame;
//#endif 


//#if 469429947 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -2067798746 

//#if 767879708 
@UmlModelMutator
//#endif 

public abstract class AbstractActionAddModelElement2 extends 
//#if -1608602685 
UndoableAction
//#endif 

  { 

//#if 854374455 
private Object target;
//#endif 


//#if 2072175569 
private boolean multiSelect = true;
//#endif 


//#if -686781670 
private boolean exclusive = true;
//#endif 


//#if 1711462428 
public boolean isMultiSelect()
    { 

//#if 4956926 
return multiSelect;
//#endif 

} 

//#endif 


//#if -45248250 
public void setMultiSelect(boolean theMultiSelect)
    { 

//#if -1213382903 
multiSelect = theMultiSelect;
//#endif 

} 

//#endif 


//#if -919757220 
protected abstract List getChoices();
//#endif 


//#if 1802646157 
protected abstract String getDialogTitle();
//#endif 


//#if 2147178294 
@Override
    public boolean isEnabled()
    { 

//#if 277295775 
return !getChoices().isEmpty();
//#endif 

} 

//#endif 


//#if -639540461 
protected abstract List getSelected();
//#endif 


//#if 1268305750 
protected AbstractActionAddModelElement2()
    { 

//#if 1974537090 
super(Translator.localize("menu.popup.add-modelelement"), null);
//#endif 


//#if 382342669 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("menu.popup.add-modelelement"));
//#endif 

} 

//#endif 


//#if 1516218195 
public AbstractActionAddModelElement2(String name)
    { 

//#if 1368215261 
super(name);
//#endif 

} 

//#endif 


//#if 424704807 
public void setTarget(Object theTarget)
    { 

//#if -596371988 
target = theTarget;
//#endif 

} 

//#endif 


//#if -655088204 
public void setExclusive(boolean theExclusive)
    { 

//#if 1424888104 
exclusive = theExclusive;
//#endif 

} 

//#endif 


//#if -1658123675 
public boolean isExclusive()
    { 

//#if -1905048420 
return exclusive;
//#endif 

} 

//#endif 


//#if -240968493 
protected abstract void doIt(Collection selected);
//#endif 


//#if 1605732906 
protected Object getTarget()
    { 

//#if 1147957336 
return target;
//#endif 

} 

//#endif 


//#if 1089361552 
@Override
    public void actionPerformed(ActionEvent e)
    { 

//#if 1415085968 
super.actionPerformed(e);
//#endif 


//#if -1030732862 
UMLAddDialog dialog =
            new UMLAddDialog(getChoices(), getSelected(), getDialogTitle(),
                             isMultiSelect(),
                             isExclusive());
//#endif 


//#if -765672896 
int result = dialog.showDialog(ArgoFrame.getInstance());
//#endif 


//#if 1971779047 
if(result == JOptionPane.OK_OPTION)//1
{ 

//#if -1942228323 
doIt(dialog.getSelected());
//#endif 

} 

//#endif 

} 

//#endif 


//#if -15772863 
public AbstractActionAddModelElement2(String name, Icon icon)
    { 

//#if 1225588196 
super(name, icon);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

