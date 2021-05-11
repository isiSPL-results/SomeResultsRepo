package de.ovgu.featureide.examples.elevator.sim;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import de.ovgu.featureide.examples.elevator.core.controller.ControlUnit;
import de.ovgu.featureide.examples.elevator.core.controller.ITickListener;
import de.ovgu.featureide.examples.elevator.core.model.Elevator;
import de.ovgu.featureide.examples.elevator.ui.MainWindow;
public class SimulationUnit
{
    private static MainWindow simulationWindow;
    private ControlUnit controller;
    public void toggleService()
    {
        controller.setService(!controller.isInService());
    }
    public static void main(String[] args)
    {
        SimulationUnit sim = new SimulationUnit();
        simulationWindow = new MainWindow(sim);
        sim.start(5);
    }
    public List<Integer> getDisabledFloors()
    {
        return this.controller.getDisabledFloors();
    }
    public void setDisabledFloors(List<Integer> disabledFloors)
    {
        this.controller.setDisabledFloors(disabledFloors);
    }
    public boolean isInService()
    {
        return controller.isInService();
    }
    public boolean isDisabledFloor(int level)
    {
        return this.controller.isDisabledFloor(level);
    }
    public void start(int maxFloor)
    {
        Elevator elevator = new Elevator(maxFloor);
        controller = new ControlUnit(elevator);
        Thread controllerThread = new Thread(controller);
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
        controller.addTickListener(simulationWindow);
        simulationWindow.initialize(elevator.getMaxFloor());
        controllerThread.start();
    }

}
