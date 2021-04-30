package de.ovgu.featureide.examples.elevator.sim;
import java.text.SimpleDateFormat;
import java.util.Date;
import de.ovgu.featureide.examples.elevator.core.controller.ControlUnit;
import de.ovgu.featureide.examples.elevator.core.controller.ITickListener;
import de.ovgu.featureide.examples.elevator.core.controller.ITriggerListener;
import de.ovgu.featureide.examples.elevator.core.controller.Request;
import de.ovgu.featureide.examples.elevator.core.model.Elevator;
import de.ovgu.featureide.examples.elevator.ui.MainWindow;
public class SimulationUnit  { 
private ITriggerListener triggerListener;
private static MainWindow simulationWindow;
private ControlUnit controller;
public static void main(String[] args) { 
SimulationUnit sim = new SimulationUnit();
simulationWindow = new MainWindow(sim);
sim.start(5);
} 
public int getCurrentFloor() { 
return controller.getCurrentFloor();
} 
public void start(int maxFloor) { 
Elevator elevator = new Elevator(maxFloor);
controller = new ControlUnit(elevator);
this.setTriggerListener(controller);
Thread controllerThread = new Thread(controller);
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
controller.addTickListener(simulationWindow);
simulationWindow.initialize(elevator.getMaxFloor());
controllerThread.start();
} 
/**
	 * The simulation unit is a bridge between gui and control unit.
	 * So there is a need to delegate requests made by the gui to the control unit.
	 * Thats why the simulationunit is also capable of informing trigger listener.
	 * @param listener - The trigger listener.
	 */
	public void setTriggerListener(ITriggerListener listener) { 
this.triggerListener = listener;
} 
/**
	 * Send a floor request to the trigger listener.
	 * @param floorRequest -  The floor request to send to the trigger listener.
	 */
	public void floorRequest(Request floorRequest) { 
this.triggerListener.trigger(floorRequest);
} 

 } 
