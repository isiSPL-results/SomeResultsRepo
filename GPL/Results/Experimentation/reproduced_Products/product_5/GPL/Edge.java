package GPL;
public class Edge
{
    private int weight;
    public void setWeight  (int weight)
    {
        this.weight = weight;
    }
    public void adjustAdorns( EdgeIfc the_edge )
    {
        setWeight(the_edge.getWeight());
        original( the_edge );
    }
    public void EdgeConstructor( Vertex the_start,  Vertex the_end,
                                 int the_weight )
    {
        EdgeConstructor( the_start,the_end );
        weight = the_weight;
    }
    public int getWeight  ()
    {
        return this.weight;
    }
    public void display()
    {
        System.out.print( " Weight=" + weight );
        original();
    }

}
