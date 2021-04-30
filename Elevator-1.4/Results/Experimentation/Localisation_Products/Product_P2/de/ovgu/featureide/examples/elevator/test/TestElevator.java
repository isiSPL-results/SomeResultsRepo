package de.ovgu.featureide.examples.elevator.test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import de.ovgu.featureide.examples.elevator.core.controller.ControlUnit;
import de.ovgu.featureide.examples.elevator.core.controller.ITickListener;
import de.ovgu.featureide.examples.elevator.core.controller.Request;
import de.ovgu.featureide.examples.elevator.core.model.Elevator;
public class TestElevator  { 
private Queue<String> expectedResult = new LinkedList<>(Arrays.asList(
			//#if Sabbath
//@ 			"1 MOVING_UP",
//@ 			"1 FLOORING",
//@ 			"2 MOVING_UP",
//@ 			"2 FLOORING",
//@ 			"3 MOVING_UP",
//@ 			"3 FLOORING",
//@ 			"2 MOVING_DOWN",
//@ 			"2 FLOORING",
//@ 			"1 MOVING_DOWN",
//@ 			"1 FLOORING",
//@ 			"0 MOVING_DOWN",
//@ 			"0 FLOORING",
//@ 			"1 MOVING_UP",
//@ 			"1 FLOORING"
			//#elif FIFO
			"1 MOVING_UP",
			"2 MOVING_UP",
			"3 MOVING_UP",
			"3 FLOORING",
			"2 MOVING_DOWN",
			"2 FLOORING",
			"2 FLOORING"
			//#else
//@ 			"1 MOVING_UP",
//@ 			"2 MOVING_UP",
//@ 			"2 FLOORING",
//@ 			"3 MOVING_UP",
//@ 			"3 FLOORING",
//@ 			"3 FLOORING"
			//#endif
	));
@Before
	public void setUp() throws Exception { 
ControlUnit.TIME_DELAY = 0;
} 
@After
	public void tearDown() throws Exception {
}@Test
	public void test() { 
final ControlUnit controller = new ControlUnit(new Elevator(3));
final TestListener listener = new TestListener(controller);
controller.addTickListener(listener);
controller.trigger(new Request(3));
try//1
{ 
Thread.sleep(1);
} 
catch (InterruptedException e1)//1
{
}controller.trigger(new Request(2));
Thread thread = new Thread(controller);
thread.start();
try//2
{ 
thread.join();
} 
catch (InterruptedException e)//1
{
}assertEquals(expectedResult.poll(), listener.wrongResult);
} 
private final class TestListener implements ITickListener
  { 
private final ControlUnit controller;
private String wrongResult = null;
private TestListener(ControlUnit controller) { 
this.controller = controller;
} 
public void onTick(Elevator elevator) { 
if(!expectedResult.isEmpty())//1
{ 
final String result = elevator.getCurrentFloor() + " " + elevator.getCurrentState();
if(result.equals(expectedResult.peek()))//1
{ 
expectedResult.poll();
} 
else
{ 
wrongResult = result;
controller.run = false;
} 
} 
else
{ 
controller.run = false;
} 
} 
@Override
		public void onRequestFinished(Elevator elevator, Request request) {
}
 } 

 } 
