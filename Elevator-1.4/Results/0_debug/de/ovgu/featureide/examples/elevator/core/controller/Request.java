
//#if -691336843
// Compilation Unit of /Request.java


//#if 1798396661
package de.ovgu.featureide.examples.elevator.core.controller;
//#endif


//#if -1788538529
import de.ovgu.featureide.examples.elevator.core.controller.ControlUnit;
//#endif


//#if -1733097538
import java.util.Comparator;
//#endif


//#if 1001057898
import de.ovgu.featureide.examples.elevator.core.model.ElevatorState;
//#endif


//#if -1978249406
public class Request
{

//#if 1945419284
    private int floor;
//#endif


//#if 91154997
    private ElevatorState direction;
//#endif


//#if 1744400576
    private long timestamp = System.currentTimeMillis();
//#endif


//#if 1398734815
    public long getTimestamp()
    {

//#if 17849226
        return timestamp;
//#endif

    }

//#endif


//#if 104474734
    @Override
    public boolean equals(Object obj)
    {

//#if 1236097431
        if(this == obj)//1

//#if 1154123637
        {
            return true;
        }
//#endif


//#endif


//#if 1215869589
        if(obj == null || getClass() != obj.getClass())//1

//#if -876686328
        {
            return false;
        }
//#endif


//#endif


//#if -1529727317
        Request other = (Request) obj;
//#endif


//#if -699405274
        return floor == other.floor && direction == other.direction;
//#endif


//#if -945806449
        return (floor != other.floor);
//#endif

    }

//#endif


//#if -1015216423
    public Request(int floor, ElevatorState direction)
    {

//#if 822642976
        this.floor = floor;
//#endif


//#if 1142045242
        this.direction = direction;
//#endif

    }

//#endif


//#if 296617071
    @Override
    public int hashCode()
    {

//#if 405353314
        final int prime = 31;
//#endif


//#if 1646345887
        int result = 1;
//#endif


//#if 378562614
        result = prime * result + floor;
//#endif


//#if 1472455689
        result = prime * result + direction.hashCode();
//#endif


//#if -1313162934
        return result;
//#endif

    }

//#endif


//#if -1323245574
    @Override
    public String toString()
    {

//#if 198427743
        return "Request [floor=" + floor + ", direction=" + direction + "]";
//#endif


//#if -1462504734
        return "Request [floor=" + floor + "]";
//#endif

    }

//#endif


//#if -1054991471
    public Request(int floor)
    {

//#if -362945602
        this.floor = floor;
//#endif

    }

//#endif


//#if -1793126997
    public ElevatorState getDirection()
    {

//#if -2099113853
        return direction;
//#endif

    }

//#endif


//#if 692991684
    public int getFloor()
    {

//#if -2092397132
        return floor;
//#endif

    }

//#endif


//#if -168709475
    public static class RequestComparator implements
//#if -1706419139
        Comparator<Request>
//#endif

    {

//#if -1601739052
        protected ControlUnit controller;
//#endif


//#if -84299673
        @Override
        public int compare(Request o1, Request o2)
        {

//#if 1784226983
            return compareDirectional(o1, o2);
//#endif


//#if -794879940
            return (int) Math.signum(o1.timestamp - o2.timestamp);
//#endif


//#if 402744001
            int diff0 = Math.abs(o1.floor - controller.getCurrentFloor());
//#endif


//#if 1795007871
            int diff1 = Math.abs(o2.floor - controller.getCurrentFloor());
//#endif


//#if -448721764
            return diff0 - diff1;
//#endif

        }

//#endif


//#if -587253316
        protected int compareDirectional(Request o1, Request o2)
        {

//#if 76850104
            return 0;
//#endif

        }

//#endif


//#if -1760616240
        public RequestComparator(ControlUnit controller)
        {

//#if 186112081
            this.controller = controller;
//#endif

        }

//#endif

    }

//#endif


//#if -1690780608
    public static class DownComparator extends
//#if -1971226675
        RequestComparator
//#endif

    {

//#if -1571005093
        public DownComparator(ControlUnit controller)
        {

//#if 1784490952
            super(controller);
//#endif

        }

//#endif


//#if 1159885187
        @Override
        public int compareDirectional(Request o1, Request o2)
        {

//#if 1115218643
            if(o1.getDirection() == ElevatorState.MOVING_UP   && o2.getDirection() != ElevatorState.MOVING_UP)//1

//#if -913797798
            {
                return  1;
            }
//#endif


//#endif


//#if -881368842
            if(o1.getDirection() == ElevatorState.MOVING_DOWN && o2.getDirection() == ElevatorState.MOVING_UP)//1

//#if 495223874
            {
                return -1;
            }
//#endif


//#endif


//#if 1822680978
            if(o1.getDirection() == ElevatorState.FLOORING    && o2.getDirection() == ElevatorState.MOVING_UP
                    && o1.getFloor() + o2.getFloor() - 2*controller.getCurrentFloor() < 0)//1

//#if 789755764
            {
                return -1;
            }
//#endif


//#endif


//#if -1051602825
            final int diffO1 = o1.getFloor() - controller.getCurrentFloor();
//#endif


//#if 1666697239
            final int diffO2 = o2.getFloor() - controller.getCurrentFloor();
//#endif


//#if -695659401
            if(diffO1 <= 0 && diffO2 <= 0)//1

//#if -1856564557
            {
                return o2.getFloor() - o1.getFloor();
            }
//#endif


//#endif


//#if 1453625867
            if(diffO1 >  0 && diffO2 >  0)//1

//#if -507220876
            {
                return o1.getFloor() - o2.getFloor();
            }
//#endif


//#endif


//#if 1872456191
            return (diffO1 <= 0) ? -1 : 1;
//#endif

        }

//#endif

    }

//#endif


//#if 1071541497
    public static class UpComparator extends
//#if 596830124
        RequestComparator
//#endif

    {

//#if -436609759
        public UpComparator(ControlUnit controller)
        {

//#if 1392057992
            super(controller);
//#endif

        }

//#endif


//#if -1419880862
        @Override
        public int compareDirectional(Request o1, Request o2)
        {

//#if 1630190607
            if(o1.getDirection() == ElevatorState.MOVING_DOWN && o2.getDirection() != ElevatorState.MOVING_DOWN)//1

//#if 860734161
            {
                return  1;
            }
//#endif


//#endif


//#if -1079686044
            if(o1.getDirection() == ElevatorState.MOVING_UP   && o2.getDirection() == ElevatorState.MOVING_DOWN)//1

//#if 1111766589
            {
                return -1;
            }
//#endif


//#endif


//#if -482435607
            if(o1.getDirection() == ElevatorState.FLOORING    && o2.getDirection() == ElevatorState.MOVING_DOWN
                    && o1.getFloor() + o2.getFloor() - 2*controller.getCurrentFloor() > 0)//1

//#if 939586399
            {
                return -1;
            }
//#endif


//#endif


//#if 1810285513
            final int diffO1 = o1.getFloor() - controller.getCurrentFloor();
//#endif


//#if 233618281
            final int diffO2 = o2.getFloor() - controller.getCurrentFloor();
//#endif


//#if -1859518939
            if(diffO1 >= 0 && diffO2 >= 0)//1

//#if 2034364878
            {
                return o1.getFloor() - o2.getFloor();
            }
//#endif


//#endif


//#if 1013102461
            if(diffO1 <  0 && diffO2 <  0)//1

//#if 1488232944
            {
                return o2.getFloor() - o1.getFloor();
            }
//#endif


//#endif


//#if 829923883
            return (diffO1 >= 0) ? -1 : 1;
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

