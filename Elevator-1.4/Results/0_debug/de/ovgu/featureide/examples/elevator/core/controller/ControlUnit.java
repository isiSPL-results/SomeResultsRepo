
//#if 835349020
// Compilation Unit of /ControlUnit.java


//#if -413260893
package de.ovgu.featureide.examples.elevator.core.controller;
//#endif


//#if -772860935
import java.util.ArrayList;
//#endif


//#if 148753096
import java.util.List;
//#endif


//#if 562100197
import java.util.concurrent.PriorityBlockingQueue;
//#endif


//#if 1976067532
import de.ovgu.featureide.examples.elevator.core.controller.Request.RequestComparator;
//#endif


//#if -1712960435
import de.ovgu.featureide.examples.elevator.core.model.Elevator;
//#endif


//#if 152250648
import de.ovgu.featureide.examples.elevator.core.model.ElevatorState;
//#endif


//#if 1654924002
public class ControlUnit implements
//#if -354221864
    Runnable
//#endif

    ,
//#if 290406814
    ITriggerListener
//#endif

{

//#if 2002798451
    public static int TIME_DELAY = 700;
//#endif


//#if -1956896713
    public boolean run = true;
//#endif


//#if 802307127
    private Elevator elevator;
//#endif


//#if 758093508
    private static final Object calc = new Object();
//#endif


//#if 639037234
    private RequestComparator comparator = new Request.UpComparator(this);
//#endif


//#if -227237431
    private RequestComparator downComparator = new Request.DownComparator(this);
//#endif


//#if 1128245354
    private PriorityBlockingQueue<Request> q = new PriorityBlockingQueue<>(1, comparator);
//#endif


//#if 884624783
    private List<ITickListener> tickListener = new ArrayList<>();
//#endif


//#if 1663715851
    private RequestComparator comparator = new RequestComparator();
//#endif


//#if 1412912297
    private RequestComparator comparator = new RequestComparator(this);
//#endif


//#if -149592253
    public void setDisabledFloors(List<Integer> disabledFloors)
    {

//#if 637682283
        elevator.setDisabledFloors(disabledFloors);
//#endif

    }

//#endif


//#if 1080580563
    public void addTickListener(ITickListener ticker)
    {

//#if -1443384024
        this.tickListener.add(ticker);
//#endif

    }

//#endif


//#if -1510039880
    private void sortQueue()
    {

//#if -816179463
        final ElevatorState direction = elevator.getCurrentState();
//#endif


//#if 1472691001
        final PriorityBlockingQueue<Request> pQueue;
//#endif


//#if 1858010404
        switch (direction) { //1
        case MOVING_DOWN://1


//#if -1461911936
            pQueue = new PriorityBlockingQueue<>(Math.max(1, q.size()), downComparator);
//#endif


//#if 104710203
            break;

//#endif


        case MOVING_UP://1


//#if -189356597
            pQueue = new PriorityBlockingQueue<>(Math.max(1, q.size()), comparator);
//#endif


//#if -404435186
            break;

//#endif


        default://1


//#if 589811479
            return;
//#endif


        }

//#endif


//#if 1241215789
        q.drainTo(pQueue);
//#endif


//#if -445109114
        q = pQueue;
//#endif

    }

//#endif


//#if 953265940
    public void setService(boolean modus)
    {

//#if 1221963619
        elevator.setService(modus);
//#endif

    }

//#endif


//#if 184886560
    public List<Integer> getDisabledFloors()
    {

//#if 830424408
        return elevator.getDisabledFloors();
//#endif

    }

//#endif


//#if 1413713076
    private ElevatorState calculateNextState()
    {

//#if -1531689959
        final int currentFloor = elevator.getCurrentFloor();
//#endif


//#if 1314092925
        if(isInService()) { //1

//#if 1203186181
            if(currentFloor != elevator.getMinFloor()) { //1

//#if 284399950
                return ElevatorState.MOVING_DOWN;
//#endif

            } else {

//#if 2067941728
                return ElevatorState.FLOORING;
//#endif

            }

//#endif

        }

//#endif


//#if -636695305
        return getElevatorState(currentFloor);
//#endif


//#if -1663565919
        switch (elevator.getCurrentState()) { //1
        case FLOORING://1


//#if 2033831249
            switch (elevator.getDirection()) { //1
            case MOVING_DOWN://1


//#if 1712144622
                return (currentFloor <= elevator.getMinFloor()) ? ElevatorState.MOVING_UP : ElevatorState.MOVING_DOWN;
//#endif


            case MOVING_UP://1


//#if -1104176124
                return (currentFloor >= elevator.getMaxFloor()) ? ElevatorState.MOVING_DOWN : ElevatorState.MOVING_UP;
//#endif


            default://1


//#if 794119674
                return ElevatorState.MOVING_UP;
//#endif


            }

//#endif


        default://1


//#if 1806761832
            return ElevatorState.FLOORING;
//#endif


        }

//#endif

    }

//#endif


//#if 1228716775
    private ElevatorState getElevatorState(int currentFloor)
    {

//#if -380988357
        if(!q.isEmpty()) { //1

//#if 1420377847
            Request poll = q.peek();
//#endif


//#if -520349767
            int floor = poll.getFloor();
//#endif


//#if -1556142984
            if(floor == currentFloor) { //1

//#if -1249216084
                do {

//#if 1602200466
                    triggerOnRequest(q.poll());
//#endif


//#if -1917943823
                    poll = q.peek();
//#endif

                } while (poll != null && poll.getFloor() == currentFloor); //1

//#endif


//#if 465248285
                return ElevatorState.FLOORING;
//#endif

            } else

//#if -108208352
                if(floor > currentFloor) { //1

//#if -1147750060
                    return ElevatorState.MOVING_UP;
//#endif

                } else {

//#if 93450387
                    return ElevatorState.MOVING_DOWN;
//#endif

                }

//#endif


//#endif

        }

//#endif


//#if 363595628
        return ElevatorState.FLOORING;
//#endif

    }

//#endif


//#if 2122721454
    public boolean isDisabledFloor(int level)
    {

//#if 1050564563
        return !elevator.getDisabledFloors().contains(level);
//#endif

    }

//#endif


//#if -1408494593
    public int getCurrentFloor()
    {

//#if -333851470
        return elevator.getCurrentFloor();
//#endif

    }

//#endif


//#if -1482712478
    public ControlUnit(Elevator elevator)
    {

//#if -72251158
        this.elevator = elevator;
//#endif

    }

//#endif


//#if 739921123
    public boolean isInService()
    {

//#if -1490383454
        return elevator.isInService();
//#endif

    }

//#endif


//#if 980661849
    private void triggerOnTick()
    {

//#if -841754971
        for (ITickListener listener : this.tickListener) { //1

//#if -739524558
            listener.onTick(elevator);
//#endif

        }

//#endif

    }

//#endif


//#if 1751189876
    public void run()
    {

//#if 275111709
        while (run) { //1

//#if -1688753345
            final ElevatorState state;
//#endif


//#if 662346537
            synchronized (calc) { //1

//#if 1517181970
                state = calculateNextState();
//#endif


//#if 2126962777
                elevator.setCurrentState(state);
//#endif


//#if -1456851270
                switch (state) { //1
                case MOVING_UP://1


//#if 306213523
                    elevator.setDirection(ElevatorState.MOVING_UP);
//#endif


//#if 649861376
                    elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
//#endif


//#if -2110815727
                    break;

//#endif


                case MOVING_DOWN://1


//#if 1690532481
                    elevator.setDirection(ElevatorState.MOVING_DOWN);
//#endif


//#if -70193755
                    elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
//#endif


//#if -261246134
                    break;

//#endif


                case FLOORING://1


//#if -610941101
                    this.triggerOnTick();
//#endif


//#if 696709535
                    break;

//#endif


                }

//#endif


//#if -1643561653
                sortQueue();
//#endif

            }

//#endif


//#if 375602558
            try { //1

//#if 1803195853
                Thread.sleep(TIME_DELAY);
//#endif

            }

//#if -828687998
            catch (InterruptedException e) { //1
            }
//#endif


//#endif


//#if 994225070
            state = calculateNextState();
//#endif


//#if -612371907
            elevator.setCurrentState(state);
//#endif


//#if 7663018
            switch (state) { //1
            case MOVING_UP://1


//#if 857794130
                this.triggerOnTick();
//#endif


//#if -1669945084
                elevator.setDirection(ElevatorState.MOVING_UP);
//#endif


//#if -57586063
                elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
//#endif


//#if 2140640384
                break;

//#endif


            case MOVING_DOWN://1


//#if -1292049276
                this.triggerOnTick();
//#endif


//#if 203608765
                elevator.setDirection(ElevatorState.MOVING_DOWN);
//#endif


//#if -364631839
                elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
//#endif


//#if 565786766
                break;

//#endif


            default://1


//#if -328391153
                break;

//#endif


            case FLOORING://1


//#if -2029621387
                this.triggerOnTick();
//#endif


//#if 1811106237
                break;

//#endif


            }

//#endif


//#if -1241222541
            try { //1

//#if -2060148641
                Thread.sleep(TIME_DELAY);
//#endif

            }

//#if 827861416
            catch (InterruptedException e) { //1
            }
//#endif


//#endif


//#if 1379406791
            switch (state) { //2
            case MOVING_UP://1


//#if -1945943837
                this.triggerOnTick();
//#endif


//#if -1599632881
                break;

//#endif


            case MOVING_DOWN://1


//#if 1540827357
                this.triggerOnTick();
//#endif


//#if 1141108053
                break;

//#endif


            default://1


//#if -36232502
                break;

//#endif


            }

//#endif

        }

//#endif

    }

//#endif


//#if 12950492
    @Override
    public void trigger(Request req)
    {

//#if 1283849457
        synchronized (calc) { //1

//#if 2041586654
            q.offer(req);
//#endif

        }

//#endif

    }

//#endif


//#if -1732424523
    private void triggerOnRequest(Request request)
    {

//#if 489555695
        for (ITickListener listener : this.tickListener) { //1

//#if 1243865541
            listener.onRequestFinished(elevator, request);
//#endif

        }

//#endif

    }

//#endif

}

//#endif


//#endif

