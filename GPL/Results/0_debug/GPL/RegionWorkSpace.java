
//#if 181821168
// Compilation Unit of /RegionWorkSpace.java


//#if 1240149848
package GPL;
//#endif


//#if 336025080
public class RegionWorkSpace extends
//#if -1339807862
    WorkSpace
//#endif

{

//#if 2004399267
    int counter;
//#endif


//#if -1336381522
    public RegionWorkSpace( )
    {

//#if -1643367757
        counter = 0;
//#endif

    }

//#endif


//#if -1152277516
    public void init_vertex( Vertex v )
    {

//#if -1884547499
        v.componentNumber = -1;
//#endif

    }

//#endif


//#if -1593011002
    public void postVisitAction( Vertex v )
    {

//#if 1047047902
        v.componentNumber = counter;
//#endif

    }

//#endif


//#if -935474886
    public void nextRegionAction( Vertex v )
    {

//#if 1080966524
        counter ++;
//#endif

    }

//#endif

}

//#endif


//#endif

