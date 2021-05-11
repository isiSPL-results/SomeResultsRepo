
//#if  DirectedWithNeighbors  &&  StrongC  &&  Directed  &&  StronglyConnected  &&  Transpose  &&  WeightedOnlyVertices
// Compilation Unit of /WorkSpaceTranspose.java

package GPL;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;
public class WorkSpaceTranspose extends WorkSpace
{
    int SCCCounter;
    public WorkSpaceTranspose()
    {
        SCCCounter = 0;
    }

    public void preVisitAction( Vertex v )
    {
        if(v.visited!=true) { //1
            v.strongComponentNumber = SCCCounter;
        }

    }

    public void nextRegionAction( Vertex v )
    {
        SCCCounter++;
    }

}


//#endif

