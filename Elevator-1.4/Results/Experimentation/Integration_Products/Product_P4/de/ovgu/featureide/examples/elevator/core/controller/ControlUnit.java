package de.ovgu.featureide.examples.elevator.core.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import de.ovgu.featureide.examples.elevator.core.controller.Request.RequestComparator;
import de.ovgu.featureide.examples.elevator.core.model.Elevator;
import de.ovgu.featureide.examples.elevator.core.model.ElevatorState;
public class ControlUnit implements Runnable
,ITriggerListener
  { 
public static int TIME_DELAY = 700;
public boolean run = true;
private Elevator elevator;
private static final Object calc = new Object();
private RequestComparator comparator = new Request.UpComparator(this);
private RequestComparator downComparator = new Request.DownComparator(this);
private PriorityBlockingQueue<Request> q = new PriorityBlockingQueue<>(1, comparator);
private List<ITickListener> tickListener = new ArrayList<>();
public void addTickListener(ITickListener ticker) { 
this.tickListener.add(ticker);
} 
private void sortQueue() { 
final ElevatorState direction = elevator.getCurrentState();
final PriorityBlockingQueue<Request> pQueue;
switch (direction) //1
{ 
case MOVING_DOWN://1

pQueue = new PriorityBlockingQueue<>(Math.max(1, q.size()), downComparator);
break;


case MOVING_UP://1

pQueue = new PriorityBlockingQueue<>(Math.max(1, q.size()), comparator);
break;


default://1

return;

} 
q.drainTo(pQueue);
q = pQueue;
} 
private ElevatorState calculateNextState() { 
final int currentFloor = elevator.getCurrentFloor();
return getElevatorState(currentFloor);
} 
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
if(floor > currentFloor)//1
{ 
return ElevatorState.MOVING_UP;
} 
else
{ 
return ElevatorState.MOVING_DOWN;
} 
} 
return ElevatorState.FLOORING;
} 
public int getCurrentFloor() { 
return elevator.getCurrentFloor();
} 
public ControlUnit(Elevator elevator) { 
this.elevator = elevator;
} 
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
synchronized (calc) //1
{ 
state = calculateNextState();
elevator.setCurrentState(state);
switch (state) //1
{ 
case MOVING_UP://1

elevator.setDirection(ElevatorState.MOVING_UP);
elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
break;


case MOVING_DOWN://1

elevator.setDirection(ElevatorState.MOVING_DOWN);
elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
break;


case FLOORING://1

this.triggerOnTick();
break;


} 
sortQueue();
} 
try//1
{ 
Thread.sleep(TIME_DELAY);
} 
catch (InterruptedException e)//1
{
}switch (state) //1
{ 
case MOVING_UP://1

this.triggerOnTick();
break;


case MOVING_DOWN://1

this.triggerOnTick();
break;


default://1

break;


} 
} 
} 
@Override
	public void trigger(Request req) { 
synchronized (calc) //1
{ 
q.offer(req);
} 
} 
private void triggerOnRequest(Request request) { 
for (ITickListener listener : this.tickListener) //1
{ 
listener.onRequestFinished(elevator, request);
} 
} 

 } 
