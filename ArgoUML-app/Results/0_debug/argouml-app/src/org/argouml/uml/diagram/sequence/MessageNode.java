
//#if 1305143538 
// Compilation Unit of /MessageNode.java 
 

//#if -1313316973 
package org.argouml.uml.diagram.sequence;
//#endif 


//#if 1757438119 
import java.util.List;
//#endif 


//#if 1557934274 
import org.argouml.uml.diagram.sequence.ui.FigMessagePort;
//#endif 


//#if 674955733 
import org.argouml.uml.diagram.sequence.ui.FigClassifierRole;
//#endif 


//#if 826495755 
public class MessageNode extends 
//#if 999015778 
Object
//#endif 

  { 

//#if -433078217 
public static final int INITIAL = 0;
//#endif 


//#if -550622609 
public static final int PRECREATED = 1;
//#endif 


//#if 1698905625 
public static final int DONE_SOMETHING_NO_CALL = 2;
//#endif 


//#if -1914363499 
public static final int CALLED = 3;
//#endif 


//#if -2072284402 
public static final int IMPLICIT_RETURNED = 4;
//#endif 


//#if 65521326 
public static final int CREATED = 5;
//#endif 


//#if 1039619872 
public static final int RETURNED = 6;
//#endif 


//#if -473487013 
public static final int DESTROYED = 7;
//#endif 


//#if -1281788577 
public static final int IMPLICIT_CREATED = 8;
//#endif 


//#if 678887219 
private FigMessagePort figMessagePort;
//#endif 


//#if -318949669 
private FigClassifierRole figClassifierRole;
//#endif 


//#if -1261854055 
private int state;
//#endif 


//#if 1505830289 
private List callers;
//#endif 


//#if 1701975741 
public List getCallers()
    { 

//#if -913484616 
return callers;
//#endif 

} 

//#endif 


//#if 1399749425 
public boolean canCreate()
    { 

//#if 349054953 
return canCall();
//#endif 

} 

//#endif 


//#if -84165230 
public void setState(int st)
    { 

//#if -836224352 
state = st;
//#endif 

} 

//#endif 


//#if 295309650 
public void setCallers(List theCallers)
    { 

//#if 1801907508 
this.callers = theCallers;
//#endif 

} 

//#endif 


//#if -2102196897 
public int getState()
    { 

//#if 1660704762 
return state;
//#endif 

} 

//#endif 


//#if -588651051 
public boolean canBeCalled()
    { 

//#if 269684331 
return figMessagePort == null
               && (state == INITIAL
                   || state == CREATED
                   || state == DONE_SOMETHING_NO_CALL
                   || state == CALLED
                   || state == RETURNED
                   || state == IMPLICIT_RETURNED
                   || state == IMPLICIT_CREATED);
//#endif 

} 

//#endif 


//#if -1391945661 
public Object getClassifierRole()
    { 

//#if -1218928851 
return figClassifierRole.getOwner();
//#endif 

} 

//#endif 


//#if -1319478795 
public boolean matchingCallerList(Object caller, int callerIndex)
    { 

//#if -1982065577 
if(callers != null && callers.lastIndexOf(caller) == callerIndex)//1
{ 

//#if -1972295990 
if(state == IMPLICIT_RETURNED)//1
{ 

//#if 1470382125 
state = CALLED;
//#endif 

} 

//#endif 


//#if -768553796 
return true;
//#endif 

} 

//#endif 


//#if 656455923 
return false;
//#endif 

} 

//#endif 


//#if 1831006407 
public boolean canDestroy()
    { 

//#if -1577741505 
return canCall();
//#endif 

} 

//#endif 


//#if 2083398139 
public boolean canReturn(Object caller)
    { 

//#if 826640281 
return figMessagePort == null
               && callers != null
               && callers.contains(caller);
//#endif 

} 

//#endif 


//#if 1894529251 
public boolean canBeDestroyed()
    { 

//#if 220940273 
boolean destroyableNode =
            (figMessagePort == null
             && (state == DONE_SOMETHING_NO_CALL
                 || state == CREATED
                 || state == CALLED || state == RETURNED
                 || state == IMPLICIT_RETURNED
                 || state == IMPLICIT_CREATED));
//#endif 


//#if 751066208 
if(destroyableNode)//1
{ 

//#if 257249316 
for (int i = figClassifierRole.getIndexOf(this) + 1;
                    destroyableNode && i < figClassifierRole.getNodeCount(); ++i) //1
{ 

//#if -2110247217 
MessageNode node = figClassifierRole.getNode(i);
//#endif 


//#if -222253426 
if(node.getFigMessagePort() != null)//1
{ 

//#if 581704687 
destroyableNode = false;
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1920975454 
return destroyableNode;
//#endif 

} 

//#endif 


//#if -1597919883 
public FigClassifierRole getFigClassifierRole()
    { 

//#if 239699784 
return figClassifierRole;
//#endif 

} 

//#endif 


//#if 398817771 
public FigMessagePort getFigMessagePort()
    { 

//#if -1219516817 
return figMessagePort;
//#endif 

} 

//#endif 


//#if 1997144339 
public boolean canCall()
    { 

//#if 2112314263 
return figMessagePort == null
               && (state == INITIAL
                   || state == CREATED
                   || state == CALLED
                   || state == DONE_SOMETHING_NO_CALL
                   || state == IMPLICIT_RETURNED
                   || state == IMPLICIT_CREATED);
//#endif 

} 

//#endif 


//#if 1237603394 
public boolean canBeReturnedTo()
    { 

//#if -215922889 
return figMessagePort == null
               && (state == DONE_SOMETHING_NO_CALL
                   || state == CALLED
                   || state == CREATED
                   || state == IMPLICIT_RETURNED
                   || state == IMPLICIT_CREATED);
//#endif 

} 

//#endif 


//#if 319748422 
public MessageNode(FigClassifierRole owner)
    { 

//#if 2119194370 
figClassifierRole = owner;
//#endif 


//#if -411419309 
figMessagePort = null;
//#endif 


//#if 82749883 
state = INITIAL;
//#endif 

} 

//#endif 


//#if 571119666 
public boolean canBeCreated()
    { 

//#if -1247503098 
return figMessagePort == null && state == INITIAL;
//#endif 

} 

//#endif 


//#if -797447610 
public void setFigMessagePort(FigMessagePort fmp)
    { 

//#if -1476919070 
figMessagePort = fmp;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

