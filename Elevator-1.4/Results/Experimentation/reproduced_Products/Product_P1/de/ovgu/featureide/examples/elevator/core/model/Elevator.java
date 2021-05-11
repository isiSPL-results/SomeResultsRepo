package de.ovgu.featureide.examples.elevator.core.model;
import java.util.List;
public class Elevator
{
    private final int maxFloor;
    private final int minFloor = 0;
    private ElevatorState direction = ElevatorState.MOVING_UP;
    private int currentFloor = 0;
    private ElevatorState currentState = ElevatorState.FLOORING;
    private boolean inService = false;
    private List<Integer> disabledFloors;
    public void setCurrentState(ElevatorState state)
    {
        currentState = state;
    }
    public ElevatorState getDirection()
    {
        return direction;
    }
    public Elevator(int maxFloor)
    {
        this.maxFloor = maxFloor;
    }
    public int getMaxFloor()
    {
        return maxFloor;
    }
    public void setDisabledFloors(List<Integer> disabledFloors)
    {
        this.disabledFloors = disabledFloors;
    }
    public void setCurrentFloor(int currentFloor)
    {
        this.currentFloor = currentFloor;
    }
    public ElevatorState getCurrentState()
    {
        return currentState;
    }
    public void setService(boolean inService)
    {
        this.inService = inService;
    }
    public int getMinFloor()
    {
        return minFloor;
    }
    public boolean isInService()
    {
        return inService;
    }
    public void setDirection(ElevatorState direction)
    {
        this.direction = direction;
    }
    public int getCurrentFloor()
    {
        return currentFloor;
    }
    public List<Integer> getDisabledFloors()
    {
        return this.disabledFloors;
    }

}
