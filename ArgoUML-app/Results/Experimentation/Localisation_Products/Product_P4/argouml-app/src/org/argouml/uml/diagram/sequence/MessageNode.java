package org.argouml.uml.diagram.sequence;
import java.util.List;
import org.argouml.uml.diagram.sequence.ui.FigMessagePort;
import org.argouml.uml.diagram.sequence.ui.FigClassifierRole;
public class MessageNode extends Object
  { 
public static final int INITIAL = 0;
public static final int PRECREATED = 1;
public static final int DONE_SOMETHING_NO_CALL = 2;
public static final int CALLED = 3;
public static final int IMPLICIT_RETURNED = 4;
public static final int CREATED = 5;
public static final int RETURNED = 6;
public static final int DESTROYED = 7;
public static final int IMPLICIT_CREATED = 8;
private FigMessagePort figMessagePort;
private FigClassifierRole figClassifierRole;
private int state;
private List callers;
public List getCallers()
    { 
return callers;
} 
public boolean canCreate()
    { 
return canCall();
} 
public void setState(int st)
    { 
state = st;
} 
public void setCallers(List theCallers)
    { 
this.callers = theCallers;
} 
public int getState()
    { 
return state;
} 
public boolean canBeCalled()
    { 
return figMessagePort == null
               && (state == INITIAL
                   || state == CREATED
                   || state == DONE_SOMETHING_NO_CALL
                   || state == CALLED
                   || state == RETURNED
                   || state == IMPLICIT_RETURNED
                   || state == IMPLICIT_CREATED);
} 
public Object getClassifierRole()
    { 
return figClassifierRole.getOwner();
} 
public boolean matchingCallerList(Object caller, int callerIndex)
    { 
if(callers != null && callers.lastIndexOf(caller) == callerIndex)//1
{ 
if(state == IMPLICIT_RETURNED)//1
{ 
state = CALLED;
} 
return true;
} 
return false;
} 
public boolean canDestroy()
    { 
return canCall();
} 
public boolean canReturn(Object caller)
    { 
return figMessagePort == null
               && callers != null
               && callers.contains(caller);
} 
public boolean canBeDestroyed()
    { 
boolean destroyableNode =
            (figMessagePort == null
             && (state == DONE_SOMETHING_NO_CALL
                 || state == CREATED
                 || state == CALLED || state == RETURNED
                 || state == IMPLICIT_RETURNED
                 || state == IMPLICIT_CREATED));
if(destroyableNode)//1
{ 
for (int i = figClassifierRole.getIndexOf(this) + 1;
                    destroyableNode && i < figClassifierRole.getNodeCount(); ++i) //1
{ 
MessageNode node = figClassifierRole.getNode(i);
if(node.getFigMessagePort() != null)//1
{ 
destroyableNode = false;
} 
} 
} 
return destroyableNode;
} 
public FigClassifierRole getFigClassifierRole()
    { 
return figClassifierRole;
} 
public FigMessagePort getFigMessagePort()
    { 
return figMessagePort;
} 
public boolean canCall()
    { 
return figMessagePort == null
               && (state == INITIAL
                   || state == CREATED
                   || state == CALLED
                   || state == DONE_SOMETHING_NO_CALL
                   || state == IMPLICIT_RETURNED
                   || state == IMPLICIT_CREATED);
} 
public boolean canBeReturnedTo()
    { 
return figMessagePort == null
               && (state == DONE_SOMETHING_NO_CALL
                   || state == CALLED
                   || state == CREATED
                   || state == IMPLICIT_RETURNED
                   || state == IMPLICIT_CREATED);
} 
public MessageNode(FigClassifierRole owner)
    { 
figClassifierRole = owner;
figMessagePort = null;
state = INITIAL;
} 
public boolean canBeCreated()
    { 
return figMessagePort == null && state == INITIAL;
} 
public void setFigMessagePort(FigMessagePort fmp)
    { 
figMessagePort = fmp;
} 

 } 
