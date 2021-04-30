// Compilation Unit of /ControlUnit.java 
 
package de.ovgu.featureide.examples.elevator.core.controller;
import java.util.ArrayList;
import java.util.List;

//#if  CallButtons  
import java.util.concurrent.PriorityBlockingQueue;
//#endif 


//#if  CallButtons  
import de.ovgu.featureide.examples.elevator.core.controller.Request.RequestComparator;
//#endif 

import de.ovgu.featureide.examples.elevator.core.model.Elevator;
import de.ovgu.featureide.examples.elevator.core.model.ElevatorState;
public class ControlUnit implements Runnable
, 
//#if  CallButtons  
ITriggerListener
//#endif 

  { 
public static int TIME_DELAY = 700;
public boolean run = true;
private Elevator elevator;

//#if  CallButtons  
private static final Object calc = new Object();
//#endif 


//#if  DirectedCall  
private RequestComparator comparator = new Request.UpComparator(this);
//#endif 


//#if  DirectedCall  
private RequestComparator downComparator = new Request.DownComparator(this);
//#endif 


//#if  CallButtons  
private PriorityBlockingQueue<Request> q = new PriorityBlockingQueue<>(1, comparator);
//#endif 

private List<ITickListener> tickListener = new ArrayList<>();

//#if  FIFO  
private RequestComparator comparator = new RequestComparator();
//#endif 


//#if  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) && ! DirectedCall  && ! FIFO  && ! Sabbath  
private RequestComparator comparator = new RequestComparator(this);
//#endif 


//#if  FloorPermission  
public void setDisabledFloors(List<Integer> disabledFloors) { 
elevator.setDisabledFloors(disabledFloors);
} 

//#endif 

public void addTickListener(ITickListener ticker) { 
this.tickListener.add(ticker);
} 


//#if  DirectedCall  
private void sortQueue() { 
final ElevatorState direction = elevator.getCurrentState();
final PriorityBlockingQueue<Request> pQueue;
switch (direction) //1
{ 
case MOVING_DOWN://1


//#if  DirectedCall  
pQueue = new PriorityBlockingQueue<>(Math.max(1, q.size()), downComparator);
//#endif 


//#if  DirectedCall  
break;

//#endif 


case MOVING_UP://1


//#if  DirectedCall  
pQueue = new PriorityBlockingQueue<>(Math.max(1, q.size()), comparator);
//#endif 


//#if  DirectedCall  
break;

//#endif 


default://1


//#if  DirectedCall  
return;
//#endif 


} 

q.drainTo(pQueue);
q = pQueue;
} 

//#endif 


//#if  Service  
public void setService(boolean modus) { 
elevator.setService(modus);
} 

//#endif 


//#if  FloorPermission  
public List<Integer> getDisabledFloors() { 
return elevator.getDisabledFloors();
} 

//#endif 

private ElevatorState calculateNextState() { 
final int currentFloor = elevator.getCurrentFloor();

//#if  Service  
if(isInService())//1
{ 
if(currentFloor != elevator.getMinFloor())//1
{ 
return ElevatorState.MOVING_DOWN;
} 
else
{ 
return ElevatorState.FLOORING;
} 

} 

//#endif 


//#if  CallButtons  
return getElevatorState(currentFloor);
//#endif 


//#if  Sabbath  
switch (elevator.getCurrentState()) //1
{ 
case FLOORING://1


//#if  Sabbath  
switch (elevator.getDirection()) //1
{ 
case MOVING_DOWN://1


//#if  Sabbath  
return (currentFloor <= elevator.getMinFloor()) ? ElevatorState.MOVING_UP : ElevatorState.MOVING_DOWN;
//#endif 


case MOVING_UP://1


//#if  Sabbath  
return (currentFloor >= elevator.getMaxFloor()) ? ElevatorState.MOVING_DOWN : ElevatorState.MOVING_UP;
//#endif 


default://1


//#if  Sabbath  
return ElevatorState.MOVING_UP;
//#endif 


} 

//#endif 


default://1


//#if  Sabbath  
return ElevatorState.FLOORING;
//#endif 


} 

//#endif 

} 


//#if  CallButtons  
private ElevatorState getElevatorState(int currentFloor) { 
if(!q.isEmpty())//1
{ 
Request poll = q.peek();
int floor = poll.getFloor();
if(floor == currentFloor)//1
{ 
do{ 
triggerOnRequest(q.poll());
poll = q.peek();
} 
 while (poll != null && poll.getFloor() == currentFloor);//1

return ElevatorState.FLOORING;
} 
else

//#if  CallButtons  
if(floor > currentFloor)//1
{ 
return ElevatorState.MOVING_UP;
} 
else
{ 
return ElevatorState.MOVING_DOWN;
} 

//#endif 


} 

return ElevatorState.FLOORING;
} 

//#endif 


//#if  FloorPermission  
public boolean isDisabledFloor(int level) { 
return !elevator.getDisabledFloors().contains(level);
} 

//#endif 


//#if  CallButtons  
public int getCurrentFloor() { 
return elevator.getCurrentFloor();
} 

//#endif 

public ControlUnit(Elevator elevator) { 
this.elevator = elevator;
} 


//#if  Service  
public boolean isInService() { 
return elevator.isInService();
} 

//#endif 

private void triggerOnTick() { 
for (ITickListener listener : this.tickListener) //1
{ 
listener.onTick(elevator);
} 

} 

public void run() { 
while (run) //1
{ 
final ElevatorState state;

//#if  CallButtons  
synchronized (calc) //1
{ 
state = calculateNextState();
elevator.setCurrentState(state);
switch (state) //1
{ 
case MOVING_UP://1


//#if  CallButtons  
elevator.setDirection(ElevatorState.MOVING_UP);
//#endif 


//#if  CallButtons  
elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
//#endif 


//#if  CallButtons  
break;

//#endif 


case MOVING_DOWN://1


//#if  CallButtons  
elevator.setDirection(ElevatorState.MOVING_DOWN);
//#endif 


//#if  CallButtons  
elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
//#endif 


//#if  CallButtons  
break;

//#endif 


case FLOORING://1


//#if  CallButtons  
this.triggerOnTick();
//#endif 


//#if  CallButtons  
break;

//#endif 


} 


//#if  DirectedCall  
sortQueue();
//#endif 

} 

//#endif 


//#if  CallButtons  
try //1
{ 
Thread.sleep(TIME_DELAY);
} 

//#if  CallButtons  
catch (InterruptedException e)//1
{
}
//#endif 


//#endif 


//#if  Sabbath  
state = calculateNextState();
//#endif 


//#if  Sabbath  
elevator.setCurrentState(state);
//#endif 

switch (state) //1
{ 
case MOVING_UP://1


//#if  CallButtons  
this.triggerOnTick();
//#endif 


//#if  Sabbath  
elevator.setDirection(ElevatorState.MOVING_UP);
//#endif 


//#if  Sabbath  
elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
//#endif 

break;


case MOVING_DOWN://1


//#if  CallButtons  
this.triggerOnTick();
//#endif 


//#if  Sabbath  
elevator.setDirection(ElevatorState.MOVING_DOWN);
//#endif 


//#if  Sabbath  
elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
//#endif 

break;


default://1


//#if  CallButtons  
break;

//#endif 


case FLOORING://1


//#if  Sabbath  
this.triggerOnTick();
//#endif 


//#if  Sabbath  
break;

//#endif 


} 


//#if  Sabbath  
try //1
{ 
Thread.sleep(TIME_DELAY);
} 

//#if  Sabbath  
catch (InterruptedException e)//1
{
}
//#endif 


//#endif 


//#if  Sabbath  
switch (state) //2
{ 
case MOVING_UP://1


//#if  Sabbath  
this.triggerOnTick();
//#endif 


//#if  Sabbath  
break;

//#endif 


case MOVING_DOWN://1


//#if  Sabbath  
this.triggerOnTick();
//#endif 


//#if  Sabbath  
break;

//#endif 


default://1


//#if  Sabbath  
break;

//#endif 


} 

//#endif 

} 

} 


//#if  CallButtons  
@Override
	public void trigger(Request req) { 
synchronized (calc) //1
{ 
q.offer(req);
} 

} 

//#endif 


//#if  CallButtons  
private void triggerOnRequest(Request request) { 
for (ITickListener listener : this.tickListener) //1
{ 
listener.onRequestFinished(elevator, request);
} 

} 

//#endif 

 } 


