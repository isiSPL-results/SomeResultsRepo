// Compilation Unit of /Elevator.java 
 
package de.ovgu.featureide.examples.elevator.core.model;

//#if  FloorPermission  
import java.util.List;
//#endif 

public class Elevator  { 
private final int maxFloor;
private final int minFloor = 0;
private ElevatorState direction = ElevatorState.MOVING_UP;
private int currentFloor = 0;
private ElevatorState currentState = ElevatorState.FLOORING;

//#if  Service  
private boolean inService = false;
//#endif 


//#if  FloorPermission  
private List<Integer> disabledFloors;
//#endif 

public void setCurrentState(ElevatorState state) { 
currentState = state;
} 

public ElevatorState getDirection() { 
return direction;
} 

public Elevator(int maxFloor) { 
this.maxFloor = maxFloor;
} 

public int getMaxFloor() { 
return maxFloor;
} 


//#if  FloorPermission  
public void setDisabledFloors(List<Integer> disabledFloors) { 
this.disabledFloors = disabledFloors;
} 

//#endif 

public void setCurrentFloor(int currentFloor) { 
this.currentFloor = currentFloor;
} 

public ElevatorState getCurrentState() { 
return currentState;
} 


//#if  Service  
public void setService(boolean inService) { 
this.inService = inService;
} 

//#endif 

public int getMinFloor() { 
return minFloor;
} 


//#if  Service  
public boolean isInService() { 
return inService;
} 

//#endif 

public void setDirection(ElevatorState direction) { 
this.direction = direction;
} 

public int getCurrentFloor() { 
return currentFloor;
} 


//#if  FloorPermission  
public List<Integer> getDisabledFloors() { 
return this.disabledFloors;
} 

//#endif 

 } 


