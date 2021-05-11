package de.ovgu.featureide.examples.elevator.core.controller;
import de.ovgu.featureide.examples.elevator.core.controller.ControlUnit;
import java.util.Comparator;
import de.ovgu.featureide.examples.elevator.core.model.ElevatorState;
public class Request
{
    private int floor;
    private ElevatorState direction;
    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) { //1
            return true;
        }
        if(obj == null || getClass() != obj.getClass()) { //1
            return false;
        }
        Request other = (Request) obj;
        return floor == other.floor && direction == other.direction;
    }
    public Request(int floor, ElevatorState direction)
    {
        this.floor = floor;
        this.direction = direction;
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + floor;
        result = prime * result + direction.hashCode();
        return result;
    }
    @Override
    public String toString()
    {
        return "Request [floor=" + floor + ", direction=" + direction + "]";
    }
    public Request(int floor)
    {
        this.floor = floor;
    }
    public ElevatorState getDirection()
    {
        return direction;
    }
    public int getFloor()
    {
        return floor;
    }
    public static class RequestComparator implements Comparator<Request>
    {
        protected ControlUnit controller;
        @Override
        public int compare(Request o1, Request o2)
        {
            return compareDirectional(o1, o2);
        }
        protected int compareDirectional(Request o1, Request o2)
        {
            return 0;
        }
        public RequestComparator(ControlUnit controller)
        {
            this.controller = controller;
        }

    }
    public static class DownComparator extends RequestComparator
    {
        public DownComparator(ControlUnit controller)
        {
            super(controller);
        }
        @Override
        public int compareDirectional(Request o1, Request o2)
        {
            if(o1.getDirection() == ElevatorState.MOVING_UP   && o2.getDirection() != ElevatorState.MOVING_UP) { //1
                return  1;
            }
            if(o1.getDirection() == ElevatorState.MOVING_DOWN && o2.getDirection() == ElevatorState.MOVING_UP) { //1
                return -1;
            }
            if(o1.getDirection() == ElevatorState.FLOORING    && o2.getDirection() == ElevatorState.MOVING_UP
                    && o1.getFloor() + o2.getFloor() - 2*controller.getCurrentFloor() < 0) { //1
                return -1;
            }
            final int diffO1 = o1.getFloor() - controller.getCurrentFloor();
            final int diffO2 = o2.getFloor() - controller.getCurrentFloor();
            if(diffO1 <= 0 && diffO2 <= 0) { //1
                return o2.getFloor() - o1.getFloor();
            }
            if(diffO1 >  0 && diffO2 >  0) { //1
                return o1.getFloor() - o2.getFloor();
            }
            return (diffO1 <= 0) ? -1 : 1;
        }

    }
    public static class UpComparator extends RequestComparator
    {
        public UpComparator(ControlUnit controller)
        {
            super(controller);
        }
        @Override
        public int compareDirectional(Request o1, Request o2)
        {
            if(o1.getDirection() == ElevatorState.MOVING_DOWN && o2.getDirection() != ElevatorState.MOVING_DOWN) { //1
                return  1;
            }
            if(o1.getDirection() == ElevatorState.MOVING_UP   && o2.getDirection() == ElevatorState.MOVING_DOWN) { //1
                return -1;
            }
            if(o1.getDirection() == ElevatorState.FLOORING    && o2.getDirection() == ElevatorState.MOVING_DOWN
                    && o1.getFloor() + o2.getFloor() - 2*controller.getCurrentFloor() > 0) { //1
                return -1;
            }
            final int diffO1 = o1.getFloor() - controller.getCurrentFloor();
            final int diffO2 = o2.getFloor() - controller.getCurrentFloor();
            if(diffO1 >= 0 && diffO2 >= 0) { //1
                return o1.getFloor() - o2.getFloor();
            }
            if(diffO1 <  0 && diffO2 <  0) { //1
                return o2.getFloor() - o1.getFloor();
            }
            return (diffO1 >= 0) ? -1 : 1;
        }

    }

}
