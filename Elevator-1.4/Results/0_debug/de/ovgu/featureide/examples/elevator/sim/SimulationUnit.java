
//#if 553049707 
// Compilation Unit of /SimulationUnit.java 
 

//#if 1283474563 
package de.ovgu.featureide.examples.elevator.sim;
//#endif 


//#if -446719762 
import java.text.SimpleDateFormat;
//#endif 


//#if -927087924 
import java.util.Date;
//#endif 


//#if -919461924 
import java.util.List;
//#endif 


//#if 79501317 
import de.ovgu.featureide.examples.elevator.core.controller.ControlUnit;
//#endif 


//#if -175314836 
import de.ovgu.featureide.examples.elevator.core.controller.ITickListener;
//#endif 


//#if -794461075 
import de.ovgu.featureide.examples.elevator.core.controller.ITriggerListener;
//#endif 


//#if 1570730295 
import de.ovgu.featureide.examples.elevator.core.controller.Request;
//#endif 


//#if 1411188833 
import de.ovgu.featureide.examples.elevator.core.model.Elevator;
//#endif 


//#if -1914237920 
import de.ovgu.featureide.examples.elevator.ui.MainWindow;
//#endif 


//#if -1049709250 
public class SimulationUnit  { 

//#if 290241623 
private ITriggerListener triggerListener;
//#endif 


//#if 444610440 
private static MainWindow simulationWindow;
//#endif 


//#if -1592122493 
private ControlUnit controller;
//#endif 


//#if -54132089 
public void toggleService() { 

//#if 721635046 
controller.setService(!controller.isInService());
//#endif 

} 

//#endif 


//#if -1807682093 
public static void main(String[] args) { 

//#if -100074775 
SimulationUnit sim = new SimulationUnit();
//#endif 


//#if -309460947 
simulationWindow = new MainWindow(sim);
//#endif 


//#if 1853724622 
simulationWindow = new MainWindow();
//#endif 


//#if -178448607 
sim.start(5);
//#endif 

} 

//#endif 


//#if -1871247901 
public List<Integer> getDisabledFloors() { 

//#if 691583950 
return this.controller.getDisabledFloors();
//#endif 

} 

//#endif 


//#if 1288618306 
public int getCurrentFloor() { 

//#if 2139522265 
return controller.getCurrentFloor();
//#endif 

} 

//#endif 


//#if 546815302 
public void setDisabledFloors(List<Integer> disabledFloors) { 

//#if -1822498278 
this.controller.setDisabledFloors(disabledFloors);
//#endif 

} 

//#endif 


//#if -857933274 
public boolean isInService() { 

//#if -357058960 
return controller.isInService();
//#endif 

} 

//#endif 


//#if 66586993 
public boolean isDisabledFloor(int level) { 

//#if -672361565 
return this.controller.isDisabledFloor(level);
//#endif 

} 

//#endif 


//#if -1604050701 
public void start(int maxFloor) { 

//#if -1006468279 
Elevator elevator = new Elevator(maxFloor);
//#endif 


//#if 1226793874 
controller = new ControlUnit(elevator);
//#endif 


//#if -1369454008 
this.setTriggerListener(controller);
//#endif 


//#if 1659448909 
Thread controllerThread = new Thread(controller);
//#endif 


//#if -1004026555 
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


//#if 499174013 
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


//#if 1989196901 
controller.addTickListener(simulationWindow);
//#endif 


//#if 1207064222 
simulationWindow.initialize(elevator.getMaxFloor());
//#endif 


//#if -1477664204 
controllerThread.start();
//#endif 

} 

//#endif 


//#if -252138598 
/**
	 * The simulation unit is a bridge between gui and control unit.
	 * So there is a need to delegate requests made by the gui to the control unit.
	 * Thats why the simulationunit is also capable of informing trigger listener.
	 * @param listener - The trigger listener.
	 */
	public void setTriggerListener(ITriggerListener listener) { 

//#if -1295399704 
this.triggerListener = listener;
//#endif 

} 

//#endif 


//#if 166334289 
/**
	 * Send a floor request to the trigger listener.
	 * @param floorRequest -  The floor request to send to the trigger listener.
	 */
	public void floorRequest(Request floorRequest) { 

//#if 283553125 
this.triggerListener.trigger(floorRequest);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

