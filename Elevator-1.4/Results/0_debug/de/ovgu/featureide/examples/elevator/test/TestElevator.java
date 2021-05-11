
//#if -617000980
// Compilation Unit of /TestElevator.java


//#if -1410839562
package de.ovgu.featureide.examples.elevator.test;
//#endif


//#if -743768549
import static org.junit.Assert.assertEquals;
//#endif


//#if -557632916
import java.util.Arrays;
//#endif


//#if -565146769
import java.util.LinkedList;
//#endif


//#if -111709249
import java.util.Queue;
//#endif


//#if -813503874
import org.junit.After;
//#endif


//#if 1397428189
import org.junit.Before;
//#endif


//#if -701462166
import org.junit.Test;
//#endif


//#if -1558160527
import de.ovgu.featureide.examples.elevator.core.controller.ControlUnit;
//#endif


//#if -2010316584
import de.ovgu.featureide.examples.elevator.core.controller.ITickListener;
//#endif


//#if 245713571
import de.ovgu.featureide.examples.elevator.core.controller.Request;
//#endif


//#if -863995955
import de.ovgu.featureide.examples.elevator.core.model.Elevator;
//#endif


//#if 1250549983
public class TestElevator
{

//#if -1766007167
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
//@			"1 MOVING_UP",
//@			"2 MOVING_UP",
//@			"3 MOVING_UP",
//@			"3 FLOORING",
//@			"2 MOVING_DOWN",
//@			"2 FLOORING",
//@			"2 FLOORING"
                //#else
                "1 MOVING_UP",
                "2 MOVING_UP",
                "2 FLOORING",
                "3 MOVING_UP",
                "3 FLOORING",
                "3 FLOORING"
                //#endif
            ));
//#endif


//#if 991482929
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
//#endif


//#if 2075290319
    private Queue<String> expectedResult = new LinkedList<>(Arrays.asList(
                //#if Sabbath
                "1 MOVING_UP",
                "1 FLOORING",
                "2 MOVING_UP",
                "2 FLOORING",
                "3 MOVING_UP",
                "3 FLOORING",
                "2 MOVING_DOWN",
                "2 FLOORING",
                "1 MOVING_DOWN",
                "1 FLOORING",
                "0 MOVING_DOWN",
                "0 FLOORING",
                "1 MOVING_UP",
                "1 FLOORING"
                //#elif FIFO
//@			"1 MOVING_UP",
//@			"2 MOVING_UP",
//@			"3 MOVING_UP",
//@			"3 FLOORING",
//@			"2 MOVING_DOWN",
//@			"2 FLOORING",
//@			"2 FLOORING"
                //#else
//@ 			"1 MOVING_UP",
//@ 			"2 MOVING_UP",
//@ 			"2 FLOORING",
//@ 			"3 MOVING_UP",
//@ 			"3 FLOORING",
//@ 			"3 FLOORING"
                //#endif
            ));
//#endif


//#if 96209546
    @Before
    public void setUp() throws Exception
    {

//#if 1270928685
        ControlUnit.TIME_DELAY = 0;
//#endif

    }

//#endif


//#if 370495470
    @After
    public void tearDown() throws Exception
    {
    }
//#endif


//#if 1438041292
    @Test
    public void test()
    {

//#if -90818140
        final ControlUnit controller = new ControlUnit(new Elevator(3));
//#endif


//#if 1643652558
        final TestListener listener = new TestListener(controller);
//#endif


//#if -613161635
        controller.addTickListener(listener);
//#endif


//#if 1566996656
        controller.trigger(new Request(3));
//#endif


//#if 1773121511
        try { //1

//#if 1422438133
            Thread.sleep(1);
//#endif

        }

//#if 1998982133
        catch (InterruptedException e1) { //1
        }
//#endif


//#endif


//#if 1566966865
        controller.trigger(new Request(2));
//#endif


//#if 1374346276
        Thread thread = new Thread(controller);
//#endif


//#if -1491574517
        thread.start();
//#endif


//#if -739762838
        try { //2

//#if -1805470631
            thread.join();
//#endif

        }

//#if -850125895
        catch (InterruptedException e) { //1
        }
//#endif


//#endif


//#if -867807958
        try { //1

//#if 326627256
            thread.join();
//#endif

        }

//#if 1376204106
        catch (InterruptedException e) { //1
        }
//#endif


//#endif


//#if -1675982105
        assertEquals(expectedResult.poll(), listener.wrongResult);
//#endif

    }

//#endif


//#if 42046101
    private final class TestListener implements
//#if -265909476
        ITickListener
//#endif

    {

//#if 919558447
        private final ControlUnit controller;
//#endif


//#if -1454059861
        private String wrongResult = null;
//#endif


//#if 1003959561
        private TestListener(ControlUnit controller)
        {

//#if 260866173
            this.controller = controller;
//#endif

        }

//#endif


//#if -33601380
        public void onTick(Elevator elevator)
        {

//#if -1672225144
            if(!expectedResult.isEmpty()) { //1

//#if 819125117
                final String result = elevator.getCurrentFloor() + " " + elevator.getCurrentState();
//#endif


//#if -508260941
                if(result.equals(expectedResult.peek())) { //1

//#if 1795308464
                    expectedResult.poll();
//#endif

                } else {

//#if 1252844266
                    wrongResult = result;
//#endif


//#if -29358405
                    controller.run = false;
//#endif

                }

//#endif

            } else {

//#if -491534865
                controller.run = false;
//#endif

            }

//#endif

        }

//#endif


//#if -252622198
        @Override
        public void onRequestFinished(Elevator elevator, Request request)
        {
        }
//#endif

    }

//#endif

}

//#endif


//#endif

