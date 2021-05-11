package de.ovgu.featureide.examples.elevator.core.model;
public class Elevator
{
    private final int maxFloor;
    private final int minFloor = 0;
    private ElevatorState direction = ElevatorState.MOVING_UP;
    private int currentFloor = 0;
    private ElevatorState currentState = ElevatorState.FLOORING;
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
    public void setCurrentFloor(int currentFloor)
    {
        this.currentFloor = currentFloor;
    }
    public ElevatorState getCurrentState()
    {
        return currentState;
    }
    public int getMinFloor()
    {
        return minFloor;
    }
    public void setDirection(ElevatorState direction)
    {
        this.direction = direction;
    }
    public int getCurrentFloor()
    {
        return currentFloor;
    }

}
