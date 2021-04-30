// Compilation Unit of /Request.java 
 

//#if  CallButtons  
package de.ovgu.featureide.examples.elevator.core.controller;
//#endif 


//#if  ShortestPath  
import de.ovgu.featureide.examples.elevator.core.controller.ControlUnit;
//#endif 


//#if  CallButtons  
import java.util.Comparator;
//#endif 


//#if  DirectedCall  
import de.ovgu.featureide.examples.elevator.core.model.ElevatorState;
//#endif 


//#if  CallButtons  
public class Request  { 
private int floor;

//#if  DirectedCall  
private ElevatorState direction;
//#endif 


//#if  FIFO  
private long timestamp = System.currentTimeMillis();
//#endif 


//#if  FIFO  
public long getTimestamp() { 
return timestamp;
} 

//#endif 

@Override
	public boolean equals(Object obj) { 
if(this == obj)//1

//#if  CallButtons  
return true;
//#endif 


if(obj == null || getClass() != obj.getClass())//1

//#if  CallButtons  
return false;
//#endif 


Request other = (Request) obj;

//#if  DirectedCall  
return floor == other.floor && direction == other.direction;
//#endif 


//#if  UndirectedCall  
return (floor != other.floor);
//#endif 

} 


//#if  DirectedCall  
public Request(int floor, ElevatorState direction) { 
this.floor = floor;
this.direction = direction;
} 

//#endif 

@Override
	public int hashCode() { 
final int prime = 31;
int result = 1;
result = prime * result + floor;

//#if  DirectedCall  
result = prime * result + direction.hashCode();
//#endif 

return result;
} 

@Override
	public String toString() { 

//#if  DirectedCall  
return "Request [floor=" + floor + ", direction=" + direction + "]";
//#endif 


//#if  UndirectedCall  
return "Request [floor=" + floor + "]";
//#endif 

} 

public Request(int floor) { 
this.floor = floor;
} 


//#if  DirectedCall  
public ElevatorState getDirection() { 
return direction;
} 

//#endif 

public int getFloor() { 
return floor;
} 

public static class RequestComparator implements Comparator<Request>
  { 

//#if  ShortestPath  
protected ControlUnit controller;
//#endif 

@Override
		public int compare(Request o1, Request o2) { 

//#if  DirectedCall  
return compareDirectional(o1, o2);
//#endif 


//#if  FIFO  
return (int) Math.signum(o1.timestamp - o2.timestamp);
//#endif 


//#if  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) && ! DirectedCall  && ! FIFO  && ! Sabbath  
int diff0 = Math.abs(o1.floor - controller.getCurrentFloor());
//#endif 


//#if  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) && ! DirectedCall  && ! FIFO  && ! Sabbath  
int diff1 = Math.abs(o2.floor - controller.getCurrentFloor());
//#endif 


//#if  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) && ! DirectedCall  && ! FIFO  && ! Sabbath  
return diff0 - diff1;
//#endif 

} 

protected int compareDirectional(Request o1, Request o2) { 
return 0;
} 


//#if  ShortestPath  
public RequestComparator(ControlUnit controller) { 
this.controller = controller;
} 

//#endif 

 } 


//#if  DirectedCall  
public static class DownComparator extends RequestComparator
  { 
public DownComparator(ControlUnit controller) { 
super(controller);
} 

@Override
		public int compareDirectional(Request o1, Request o2) { 
if(o1.getDirection() == ElevatorState.MOVING_UP   && o2.getDirection() != ElevatorState.MOVING_UP)//1

//#if  DirectedCall  
return  1;
//#endif 


if(o1.getDirection() == ElevatorState.MOVING_DOWN && o2.getDirection() == ElevatorState.MOVING_UP)//1

//#if  DirectedCall  
return -1;
//#endif 


if(o1.getDirection() == ElevatorState.FLOORING    && o2.getDirection() == ElevatorState.MOVING_UP
					&& o1.getFloor() + o2.getFloor() - 2*controller.getCurrentFloor() < 0)//1

//#if  DirectedCall  
return -1;
//#endif 


final int diffO1 = o1.getFloor() - controller.getCurrentFloor();
final int diffO2 = o2.getFloor() - controller.getCurrentFloor();
if(diffO1 <= 0 && diffO2 <= 0)//1

//#if  DirectedCall  
return o2.getFloor() - o1.getFloor();
//#endif 


if(diffO1 >  0 && diffO2 >  0)//1

//#if  DirectedCall  
return o1.getFloor() - o2.getFloor();
//#endif 


return (diffO1 <= 0) ? -1 : 1;
} 

 } 

//#endif 


//#if  DirectedCall  
public static class UpComparator extends RequestComparator
  { 
public UpComparator(ControlUnit controller) { 
super(controller);
} 

@Override
		public int compareDirectional(Request o1, Request o2) { 
if(o1.getDirection() == ElevatorState.MOVING_DOWN && o2.getDirection() != ElevatorState.MOVING_DOWN)//1

//#if  DirectedCall  
return  1;
//#endif 


if(o1.getDirection() == ElevatorState.MOVING_UP   && o2.getDirection() == ElevatorState.MOVING_DOWN)//1

//#if  DirectedCall  
return -1;
//#endif 


if(o1.getDirection() == ElevatorState.FLOORING    && o2.getDirection() == ElevatorState.MOVING_DOWN
					&& o1.getFloor() + o2.getFloor() - 2*controller.getCurrentFloor() > 0)//1

//#if  DirectedCall  
return -1;
//#endif 


final int diffO1 = o1.getFloor() - controller.getCurrentFloor();
final int diffO2 = o2.getFloor() - controller.getCurrentFloor();
if(diffO1 >= 0 && diffO2 >= 0)//1

//#if  DirectedCall  
return o1.getFloor() - o2.getFloor();
//#endif 


if(diffO1 <  0 && diffO2 <  0)//1

//#if  DirectedCall  
return o2.getFloor() - o1.getFloor();
//#endif 


return (diffO1 >= 0) ? -1 : 1;
} 

 } 

//#endif 

 } 

//#endif 


