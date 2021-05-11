package de.ovgu.featureide.examples.elevator.core.controller;
import java.util.ArrayList;
import java.util.List;
import de.ovgu.featureide.examples.elevator.core.model.Elevator;
import de.ovgu.featureide.examples.elevator.core.model.ElevatorState;
public class ControlUnit implements Runnable
{
    public static int TIME_DELAY = 700;
    public boolean run = true;
    private Elevator elevator;
    private List<ITickListener> tickListener = new ArrayList<>();
    public void addTickListener(ITickListener ticker)
    {
        this.tickListener.add(ticker);
    }
    public void setService(boolean modus)
    {
        elevator.setService(modus);
    }
    private ElevatorState calculateNextState()
    {
        final int currentFloor = elevator.getCurrentFloor();
        if(isInService()) { //1
            if(currentFloor != elevator.getMinFloor()) { //1
                return ElevatorState.MOVING_DOWN;
            } else {
                return ElevatorState.FLOORING;
            }
        }
        switch (elevator.getCurrentState()) { //1
        case FLOORING://1

            switch (elevator.getDirection()) { //1
            case MOVING_DOWN://1

                return (currentFloor <= elevator.getMinFloor()) ? ElevatorState.MOVING_UP : ElevatorState.MOVING_DOWN;

            case MOVING_UP://1

                return (currentFloor >= elevator.getMaxFloor()) ? ElevatorState.MOVING_DOWN : ElevatorState.MOVING_UP;

            default://1

                return ElevatorState.MOVING_UP;

            }

        default://1

            return ElevatorState.FLOORING;

        }
    }
    public ControlUnit(Elevator elevator)
    {
        this.elevator = elevator;
    }
    public boolean isInService()
    {
        return elevator.isInService();
    }
    private void triggerOnTick()
    {
        for (ITickListener listener : this.tickListener) { //1
            listener.onTick(elevator);
        }
    }
    public void run()
    {
        while (run) { //1
            final ElevatorState state;
            state = calculateNextState();
            elevator.setCurrentState(state);
            switch (state) { //1
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
            try { //1
                Thread.sleep(TIME_DELAY);
            } catch (InterruptedException e) { //1
            } switch (state) { //2
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

}
