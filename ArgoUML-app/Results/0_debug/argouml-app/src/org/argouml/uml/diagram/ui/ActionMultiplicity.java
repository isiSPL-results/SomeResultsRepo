
//#if 1334393390 
// Compilation Unit of /ActionMultiplicity.java 
 

//#if 150890863 
package org.argouml.uml.diagram.ui;
//#endif 


//#if -2004111742 
import java.awt.event.ActionEvent;
//#endif 


//#if 1262583416 
import java.util.Collection;
//#endif 


//#if -1259345560 
import java.util.Iterator;
//#endif 


//#if 12086456 
import java.util.List;
//#endif 


//#if 1245470200 
import javax.swing.Action;
//#endif 


//#if -1384782215 
import org.argouml.model.Model;
//#endif 


//#if 1207213677 
import org.tigris.gef.base.Globals;
//#endif 


//#if -306259695 
import org.tigris.gef.base.Selection;
//#endif 


//#if -1319725200 
import org.tigris.gef.presentation.Fig;
//#endif 


//#if 2032816920 
import org.tigris.gef.undo.UndoableAction;
//#endif 


//#if 1509151556 
public class ActionMultiplicity extends 
//#if 141787914 
UndoableAction
//#endif 

  { 

//#if -727249743 
private String str = "";
//#endif 


//#if 824366259 
private Object mult = null;
//#endif 


//#if 2837002 
private static UndoableAction srcMultOne =
        new ActionMultiplicity("1", "src");
//#endif 


//#if -886939820 
private static UndoableAction destMultOne =
        new ActionMultiplicity("1", "dest");
//#endif 


//#if -1681536873 
private static UndoableAction srcMultZeroToOne =
        new ActionMultiplicity("0..1", "src");
//#endif 


//#if 1683490927 
private static UndoableAction destMultZeroToOne =
        new ActionMultiplicity("0..1", "dest");
//#endif 


//#if -1870821547 
private static UndoableAction srcMultZeroToMany =
        new ActionMultiplicity("0..*", "src");
//#endif 


//#if 1540722793 
private static UndoableAction destMultZeroToMany =
        new ActionMultiplicity("0..*", "dest");
//#endif 


//#if 349732866 
private static UndoableAction srcMultOneToMany =
        new ActionMultiplicity("1..*", "src");
//#endif 


//#if 228343396 
private static UndoableAction destMultOneToMany =
        new ActionMultiplicity("1..*", "dest");
//#endif 


//#if -2090095854 
protected ActionMultiplicity(String m, String s)
    { 

//#if -1973437049 
super(m, null);
//#endif 


//#if 584169272 
putValue(Action.SHORT_DESCRIPTION, m);
//#endif 


//#if 871893174 
str = s;
//#endif 


//#if 253506073 
mult = m;
//#endif 

} 

//#endif 


//#if 1239998258 
@Override
    public void actionPerformed(ActionEvent ae)
    { 

//#if 297203621 
super.actionPerformed(ae);
//#endif 


//#if -1609671849 
List sels = Globals.curEditor().getSelectionManager().selections();
//#endif 


//#if -432429713 
if(sels.size() == 1)//1
{ 

//#if 1539725953 
Selection sel = (Selection) sels.get(0);
//#endif 


//#if 587875224 
Fig f = sel.getContent();
//#endif 


//#if 1236419808 
Object owner = ((FigEdgeModelElement) f).getOwner();
//#endif 


//#if -313694912 
Collection ascEnds = Model.getFacade().getConnections(owner);
//#endif 


//#if -1603023584 
Iterator iter = ascEnds.iterator();
//#endif 


//#if 1816861584 
Object ascEnd = null;
//#endif 


//#if -1506065374 
if(str.equals("src"))//1
{ 

//#if -1947305283 
ascEnd = iter.next();
//#endif 

} 
else
{ 

//#if -226906984 
while (iter.hasNext()) //1
{ 

//#if 2094821461 
ascEnd = iter.next();
//#endif 

} 

//#endif 

} 

//#endif 


//#if 497848553 
if(!mult.equals(Model.getFacade().toString(
                                 Model.getFacade().getMultiplicity(ascEnd))))//1
{ 

//#if -314614665 
Model.getCoreHelper().setMultiplicity(
                    ascEnd,
                    Model.getDataTypesFactory().createMultiplicity(
                        (String) mult));
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1998424061 
public static UndoableAction getDestMultZeroToOne()
    { 

//#if 778264787 
return destMultZeroToOne;
//#endif 

} 

//#endif 


//#if 1417137666 
public static UndoableAction getSrcMultZeroToMany()
    { 

//#if 470257636 
return srcMultZeroToMany;
//#endif 

} 

//#endif 


//#if 954777167 
public boolean isEnabled()
    { 

//#if 391382560 
return true;
//#endif 

} 

//#endif 


//#if -2031689190 
public static UndoableAction getDestMultOneToMany()
    { 

//#if 13977798 
return destMultOneToMany;
//#endif 

} 

//#endif 


//#if 1810451520 
public static UndoableAction getDestMultOne()
    { 

//#if 1190861010 
return destMultOne;
//#endif 

} 

//#endif 


//#if -1765418654 
public static UndoableAction getSrcMultOneToMany()
    { 

//#if 760683047 
return srcMultOneToMany;
//#endif 

} 

//#endif 


//#if -2030272699 
public static UndoableAction getSrcMultZeroToOne()
    { 

//#if -1136749602 
return srcMultZeroToOne;
//#endif 

} 

//#endif 


//#if 1752685642 
public static UndoableAction getDestMultZeroToMany()
    { 

//#if 1367920135 
return destMultZeroToMany;
//#endif 

} 

//#endif 


//#if -1358603896 
public static UndoableAction getSrcMultOne()
    { 

//#if -1100861656 
return srcMultOne;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

