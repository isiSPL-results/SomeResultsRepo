
//#if 1492884839
// Compilation Unit of /CycleWorkSpace.java


//#if -1131775176
package GPL;
//#endif


//#if -553885476
import java.lang.Integer;
//#endif


//#if -1275871976
public class CycleWorkSpace extends
//#if 1240346787
    WorkSpace
//#endif

{

//#if 287201487
    public boolean AnyCycles;
//#endif


//#if 31091443
    public int     counter;
//#endif


//#if 1707045852
    public boolean isDirected;
//#endif


//#if 1557314849
    public static final int WHITE = 0;
//#endif


//#if 122501858
    public static final int GRAY  = 1;
//#endif


//#if -1671470647
    public static final int BLACK = 2;
//#endif


//#if -353938132
    public void checkNeighborAction( Vertex vsource,
                                     Vertex vtarget )
    {

//#if -1517015232
        if(isDirected) { //1

//#if -328494403
            if(( vsource.VertexColor == GRAY ) && ( vtarget.VertexColor == GRAY )) { //1

//#if -935816868
                AnyCycles = true;
//#endif

            }

//#endif

        } else {

//#if 565976467
            if(( vsource.VertexColor == GRAY ) && ( vtarget.VertexColor == GRAY )
                    && vsource.VertexCycle != vtarget.VertexCycle+1) { //1

//#if -314139598
                AnyCycles = true;
//#endif

            }

//#endif

        }

//#endif

    }

//#endif


//#if -19456769
    public CycleWorkSpace( boolean UnDir )
    {

//#if 1770014198
        AnyCycles = false;
//#endif


//#if -1374669210
        counter   = 0;
//#endif


//#if 2109335608
        isDirected = UnDir;
//#endif

    }

//#endif


//#if -630819717
    public void init_vertex( Vertex v )
    {

//#if -1996078158
        v.VertexCycle = Integer.MAX_VALUE;
//#endif


//#if 1063755826
        v.VertexColor = WHITE;
//#endif

    }

//#endif


//#if -1581151598
    public void preVisitAction( Vertex v )
    {

//#if -115899540
        if(v.visited!=true) { //1

//#if -2068234223
            v.VertexCycle = counter++;
//#endif


//#if -70375677
            v.VertexColor = GRAY;
//#endif

        }

//#endif

    }

//#endif


//#if -1868052019
    public void postVisitAction( Vertex v )
    {

//#if 1701835672
        v.VertexColor = BLACK;
//#endif


//#if -683483163
        counter--;
//#endif

    }

//#endif

}

//#endif


//#endif

