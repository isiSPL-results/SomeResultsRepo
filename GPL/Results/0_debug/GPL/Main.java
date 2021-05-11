
//#if 1805950288
// Compilation Unit of /Main.java


//#if 133916692
package GPL;
//#endif


//#if 807151495
class Main
{

//#if -600213801
    public static void main( String[] args )
    {

//#if -1486543608
        Graph g = new  Graph();
//#endif


//#if -636303434
        Vertex pre = null;
//#endif


//#if 909336055
        for(int i = 0; i < 10; i++) { //1

//#if 2120167519
            Vertex v = new Vertex();
//#endif


//#if 111654244
            v.assignName("vertex " + i);
//#endif


//#if 316142080
            g.addVertex(v);
//#endif


//#if -189136639
            if(pre != null) { //1

//#if -173192083
                g.addEdge(pre, v);
//#endif

            }

//#endif


//#if -106962275
            pre = v;
//#endif

        }

//#endif


//#if 1027346255
        g.run(g.getVertices().next());
//#endif


//#if -68453345
        g.display();
//#endif

    }

//#endif

}

//#endif


//#endif

