// Compilation Unit of /SimulationUnit.java

package de.ovgu.featureide.examples.elevator.sim;
import java.text.SimpleDateFormat;
import java.util.Date;

//#if  FloorPermission
import java.util.List;
//#endif

import de.ovgu.featureide.examples.elevator.core.controller.ControlUnit;
import de.ovgu.featureide.examples.elevator.core.controller.ITickListener;

//#if  CallButtons
import de.ovgu.featureide.examples.elevator.core.controller.ITriggerListener;
//#endif


//#if  CallButtons
import de.ovgu.featureide.examples.elevator.core.controller.Request;
//#endif

import de.ovgu.featureide.examples.elevator.core.model.Elevator;
import de.ovgu.featureide.examples.elevator.ui.MainWindow;
public class SimulationUnit
{

//#if  CallButtons
    private ITriggerListener triggerListener;
//#endif

    private static MainWindow simulationWindow;
    private ControlUnit controller;

//#if  Service
    public void toggleService()
    {
        controller.setService(!controller.isInService());
    }

//#endif

    public static void main(String[] args)
    {
        SimulationUnit sim = new SimulationUnit();

//#if (  ( ShortestPath  &&  CallButtons  &&  UndirectedCall  &&  FloorPermission  &&  Service ) ||  ( Service  &&  Sabbath ) ||  ( FIFO  &&  UndirectedCall  &&  CallButtons ) ||  ( DirectedCall  &&  ShortestPath  &&  CallButtons ) )
        simulationWindow = new MainWindow(sim);
//#endif


//#if  Sabbath && ! DirectedCall  && ! FIFO  && ! FloorPermission  && ! ShortestPath  && ! UndirectedCall  && ! CallButtons  && ! Service
        simulationWindow = new MainWindow();
//#endif

        sim.start(5);
    }


//#if  FloorPermission
    public List<Integer> getDisabledFloors()
    {
        return this.controller.getDisabledFloors();
    }

//#endif


//#if  CallButtons
    public int getCurrentFloor()
    {
        return controller.getCurrentFloor();
    }

//#endif


//#if  FloorPermission
    public void setDisabledFloors(List<Integer> disabledFloors)
    {
        this.controller.setDisabledFloors(disabledFloors);
    }

//#endif


//#if  Service
    public boolean isInService()
    {
        return controller.isInService();
    }

//#endif


//#if  FloorPermission
    public boolean isDisabledFloor(int level)
    {
        return this.controller.isDisabledFloor(level);
    }

//#endif

    public void start(int maxFloor)
    {
        Elevator elevator = new Elevator(maxFloor);
        controller = new ControlUnit(elevator);

//#if  CallButtons
        this.setTriggerListener(controller);
//#endif

        Thread controllerThread = new Thread(controller);

//#if  CallButtons
        controller.addTickListener(new ITickListener() {
            public void onTick(Elevator elevator) {
                System.out.printf(String.format("%s - %s -- Current Floor %d Next Floor %d \n", new SimpleDateFormat("HH:mm:ss").format(new Date()),
                                                elevator.getCurrentState(), elevator.getCurrentFloor(), Integer.MAX_VALUE));
            }
            //#if CallButtons
            @Override
            public void onRequestFinished(Elevator elevator, Request request) {
            }
            //#endif
        });
//#endif


//#if  Sabbath
        controller.addTickListener(new ITickListener() {
            public void onTick(Elevator elevator) {
                System.out.printf(String.format("%s - %s -- Current Floor %d Next Floor %d \n", new SimpleDateFormat("HH:mm:ss").format(new Date()),
                                                elevator.getCurrentState(), elevator.getCurrentFloor(), Integer.MAX_VALUE));
            }
            //#if CallButtons
//@			@Override
//@			public void onRequestFinished(Elevator elevator, Request request) {
//@			}
            //#endif
        });
//#endif

        controller.addTickListener(simulationWindow);
        simulationWindow.initialize(elevator.getMaxFloor());
        controllerThread.start();
    }


//#if  CallButtons
    /**
    	 * The simulation unit is a bridge between gui and control unit.
    	 * So there is a need to delegate requests made by the gui to the control unit.
    	 * Thats why the simulationunit is also capable of informing trigger listener.
    	 * @param listener - The trigger listener.
    	 */
    public void setTriggerListener(ITriggerListener listener)
    {
        this.triggerListener = listener;
    }

//#endif


//#if  CallButtons
    /**
    	 * Send a floor request to the trigger listener.
    	 * @param floorRequest -  The floor request to send to the trigger listener.
    	 */
    public void floorRequest(Request floorRequest)
    {
        this.triggerListener.trigger(floorRequest);
    }

//#endif

}


