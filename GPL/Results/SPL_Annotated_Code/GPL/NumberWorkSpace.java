
//#if  Number
// Compilation Unit of /NumberWorkSpace.java

package GPL;
public class NumberWorkSpace extends WorkSpace
{
    int vertexCounter;
    public NumberWorkSpace( )
    {
        vertexCounter = 0;
    }

    public void preVisitAction( Vertex v )
    {
        if(v.visited != true) { //1
            v.VertexNumber = vertexCounter++;
        }

    }

}


//#endif

