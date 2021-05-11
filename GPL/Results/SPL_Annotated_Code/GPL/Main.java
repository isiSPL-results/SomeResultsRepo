// Compilation Unit of /Main.java

package GPL;
class Main
{
    public static void main( String[] args )
    {
        Graph g = new  Graph();
        Vertex pre = null;
        for(int i = 0; i < 10; i++) { //1
            Vertex v = new Vertex();
            v.assignName("vertex " + i);
            g.addVertex(v);
            if(pre != null) { //1
                g.addEdge(pre, v);
            }

            pre = v;
        }

        g.run(g.getVertices().next());
        g.display();
    }

}


