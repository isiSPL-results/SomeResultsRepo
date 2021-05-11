
//#if -1410588140
// Compilation Unit of /Elevator.java


//#if -1483366761
package de.ovgu.featureide.examples.elevator.core.model;
//#endif


//#if 1992007537
import java.util.List;
//#endif


//#if 167108886
public class Elevator
{

//#if -1939567802
    private final int maxFloor;
//#endif


//#if -586280383
    private final int minFloor = 0;
//#endif


//#if -284656921
    private ElevatorState direction = ElevatorState.MOVING_UP;
//#endif


//#if 567026714
    private int currentFloor = 0;
//#endif


//#if 1824080036
    private ElevatorState currentState = ElevatorState.FLOORING;
//#endif


//#if 1299255033
    private boolean inService = false;
//#endif


//#if -1896070130
    private List<Integer> disabledFloors;
//#endif


//#if -825715839
    public void setCurrentState(ElevatorState state)
    {

//#if -1584065964
        currentState = state;
//#endif

    }

//#endif


//#if -151899531
    public ElevatorState getDirection()
    {

//#if -51222399
        return direction;
//#endif

    }

//#endif


//#if -1720813324
    public Elevator(int maxFloor)
    {

//#if -442045899
        this.maxFloor = maxFloor;
//#endif

    }

//#endif


//#if 1395946856
    public int getMaxFloor()
    {

//#if 863878346
        return maxFloor;
//#endif

    }

//#endif


//#if -52018057
    public void setDisabledFloors(List<Integer> disabledFloors)
    {

//#if -1289662018
        this.disabledFloors = disabledFloors;
//#endif

    }

//#endif


//#if -1599385434
    public void setCurrentFloor(int currentFloor)
    {

//#if -831647659
        this.currentFloor = currentFloor;
//#endif

    }

//#endif


//#if 1755051972
    public ElevatorState getCurrentState()
    {

//#if 676818711
        return currentState;
//#endif

    }

//#endif


//#if 541399320
    public void setService(boolean inService)
    {

//#if 1695336768
        this.inService = inService;
//#endif

    }

//#endif


//#if -427021126
    public int getMinFloor()
    {

//#if -372081302
        return minFloor;
//#endif

    }

//#endif


//#if -300516073
    public boolean isInService()
    {

//#if -108753408
        return inService;
//#endif

    }

//#endif


//#if -703723890
    public void setDirection(ElevatorState direction)
    {

//#if -1355072037
        this.direction = direction;
//#endif

    }

//#endif


//#if 1846035507
    public int getCurrentFloor()
    {

//#if 789555435
        return currentFloor;
//#endif

    }

//#endif


//#if -1227446444
    public List<Integer> getDisabledFloors()
    {

//#if 1615843390
        return this.disabledFloors;
//#endif

    }

//#endif

}

//#endif


//#endif

