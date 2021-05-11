
//#if -369945906 
// Compilation Unit of /ActionAggregation.java 
 

//#if 2075901117 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -833635980 
import java.awt.event.ActionEvent;
//#endif 


//#if 199042794 
import java.util.Collection;
//#endif 


//#if -1260452262 
import java.util.Iterator;
//#endif 


//#if -1483746646 
import java.util.List;
//#endif 


//#if 1244363498 
import javax.swing.Action;
//#endif 


//#if -1173922431 
import org.argouml.i18n.Translator;
//#endif 


//#if -1349709625 
import org.argouml.model.Model;
//#endif 


//#if -1162743365 
import org.tigris.gef.base.Globals;
//#endif 


//#if -1502310177 
import org.tigris.gef.base.Selection;
//#endif 


//#if 326996926 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if -1879749622 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if -1884618165 
public class ActionAggregation extends 
//#if 222475447 
UndoableAction
//#endif 

  { 

//#if -1826387810 
private String str = "";
//#endif 


//#if -1986518311 
private Object agg = null;
//#endif 


//#if -1677856006 
private static UndoableAction srcAgg =
        new ActionAggregation(
        Model.getAggregationKind().getAggregate(), "src");
//#endif 


//#if 673464422 
private static UndoableAction destAgg =
        new ActionAggregation(
        Model.getAggregationKind().getAggregate(), "dest");
//#endif 


//#if 1833117529 
private static UndoableAction srcAggComposite =
        new ActionAggregation(
        Model.getAggregationKind().getComposite(), "src");
//#endif 


//#if 120813611 
private static UndoableAction destAggComposite =
        new ActionAggregation(
        Model.getAggregationKind().getComposite(), "dest");
//#endif 


//#if -670726813 
private static UndoableAction srcAggNone =
        new ActionAggregation(Model.getAggregationKind().getNone(), "src");
//#endif 


//#if -2116266527 
private static UndoableAction destAggNone =
        new ActionAggregation(
        Model.getAggregationKind().getNone(), "dest");
//#endif 


//#if -1490069864 
public static UndoableAction getDestAgg()
    { 

//#if 880703833 
return destAgg;
//#endif 

} 

//#endif 


//#if -144213058 
public static UndoableAction getSrcAggNone()
    { 

//#if 2053073990 
return srcAggNone;
//#endif 

} 

//#endif 


//#if -1471292136 
protected ActionAggregation(Object a, String s)
    { 

//#if -592038117 
super(Translator.localize(Model.getFacade().getName(a)),
              null);
//#endif 


//#if 578873124 
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize(Model.getFacade().getName(a)));
//#endif 


//#if 141239306 
str = s;
//#endif 


//#if -386419444 
agg = a;
//#endif 

} 

//#endif 


//#if 54339173 
@Override
    public void actionPerformed(ActionEvent ae)
    { 

//#if -1544737517 
super.actionPerformed(ae);
//#endif 


//#if 1801391685 
List sels = Globals.curEditor().getSelectionManager().selections();
//#endif 


//#if -1923660991 
if(sels.size() == 1)//1
{ 

//#if -693542009 
Selection sel = (Selection) sels.get(0);
//#endif 


//#if -518328546 
Fig f = sel.getContent();
//#endif 


//#if -1167985434 
Object owner = ((FigEdgeModelElement) f).getOwner();
//#endif 


//#if 1199392198 
Collection ascEnds = Model.getFacade().getConnections(owner);
//#endif 


//#if -1113568986 
Iterator iter = ascEnds.iterator();
//#endif 


//#if 1440381462 
Object ascEnd = null;
//#endif 


//#if 584001064 
if(str.equals("src"))//1
{ 

//#if -1852473496 
ascEnd = iter.next();
//#endif 

} 
else
{ 

//#if -1743857159 
while (iter.hasNext()) //1
{ 

//#if -106209875 
ascEnd = iter.next();
//#endif 

} 

//#endif 

} 

//#endif 


//#if -214162892 
Model.getCoreHelper().setAggregation(ascEnd, agg);
//#endif 

} 

//#endif 

} 

//#endif 


//#if -1388558106 
public static UndoableAction getSrcAgg()
    { 

//#if 395573996 
return srcAgg;
//#endif 

} 

//#endif 


//#if -313876030 
@Override
    public boolean isEnabled()
    { 

//#if -1272725099 
return true;
//#endif 

} 

//#endif 


//#if -2093604367 
public static UndoableAction getDestAggComposite()
    { 

//#if -1210136842 
return destAggComposite;
//#endif 

} 

//#endif 


//#if 1710876515 
public static UndoableAction getSrcAggComposite()
    { 

//#if -369880490 
return srcAggComposite;
//#endif 

} 

//#endif 


//#if -2133303184 
public static UndoableAction getDestAggNone()
    { 

//#if -1080262889 
return destAggNone;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

