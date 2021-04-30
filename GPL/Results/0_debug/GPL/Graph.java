
//#if -293859595 
// Compilation Unit of /Graph.java 
 

//#if 1857718506 
package GPL;
//#endif 


//#if 2116754443 
import java.util.LinkedList;
//#endif 


//#if -1880845676 
import java.util.Iterator;
//#endif 


//#if 979439327 
import java.util.Collections;
//#endif 


//#if -1267550868 
import java.util.Comparator;
//#endif 


//#if 1121532582 
import java.util.HashMap;
//#endif 


//#if -1041026824 
import java.util.Map;
//#endif 


//#if -1975540630 
import java.lang.Integer;
//#endif 


//#if -1040844110 
import java.util.Set;
//#endif 


//#if 1121715296 
import java.util.HashSet;
//#endif 


//#if 833733075 
public class Graph  { 

//#if 2057180439 
private LinkedList vertices;
//#endif 


//#if -735287536 
private LinkedList edges;
//#endif 


//#if 1342909739 
public static final boolean isDirected = false;
//#endif 


//#if 100274560 
private Map verticesMap;
//#endif 


//#if -1254852813 
public LinkedList vertices;
//#endif 


//#if 1099540481 
public static boolean isDirected = false;
//#endif 


//#if 187460292 
public static boolean isDirected = true;
//#endif 


//#if 939629335 
public Graph()
    { 

//#if 560533872 
vertices = new LinkedList();
//#endif 


//#if -537861887 
edges = new LinkedList();
//#endif 


//#if 703848283 
verticesMap = new HashMap( );
//#endif 

} 

//#endif 


//#if -720216687 
public  EdgeIfc findsEdge( Vertex theSource,
                               Vertex theTarget )
    { 

//#if 1834739173 
EdgeIfc theEdge;
//#endif 


//#if 242897593 
for( EdgeIter edgeiter = theSource.getEdges(); edgeiter.hasNext(); ) //1
{ 

//#if 61389635 
theEdge = edgeiter.next();
//#endif 


//#if -417978059 
if(( theEdge.getStart().getName().equals( theSource.getName() ) &&
                    theEdge.getEnd().getName().equals( theTarget.getName() ) ) ||
                    ( theEdge.getStart().getName().equals( theTarget.getName() ) &&
                      theEdge.getEnd().getName().equals( theSource.getName() ) ))//1
{ 

//#if 1757636898 
return theEdge;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1587856540 
Vertex v1 = theSource;
//#endif 


//#if 839518948 
for( EdgeIter edgeiter = v1.getEdges(); edgeiter.hasNext(); ) //1
{ 

//#if -1253337501 
EdgeIfc theEdge = edgeiter.next();
//#endif 


//#if -728698723 
Vertex v2 = theEdge.getOtherVertex( v1 );
//#endif 


//#if -1151992560 
if(( v1.getName().equals( theSource.getName() ) &&
                    v2.getName().equals( theTarget.getName() ) ) ||
                    ( v1.getName().equals( theTarget.getName() ) &&
                      v2.getName().equals( theSource.getName() ) ))//1
{ 

//#if 1361740751 
return theEdge;
//#endif 

} 

//#endif 

} 

//#endif 


//#if 1828957907 
return null;
//#endif 

} 

//#endif 


//#if 773529860 
public  Graph StrongComponents()
    { 

//#if 872957363 
FinishTimeWorkSpace FTWS = new FinishTimeWorkSpace();
//#endif 


//#if 1533779906 
GraphSearch( FTWS );
//#endif 


//#if 1194646537 
sortVertices(
        new Comparator() {
            public int compare( Object o1, Object o2 ) {
                Vertex v1 = ( Vertex )o1;
                Vertex v2 = ( Vertex )o2;

                if ( v1.finishTime > v2.finishTime ) {
                    return -1;
                }

                if ( v1.finishTime == v2.finishTime ) {
                    return 0;
                }
                return 1;
            }
        } );
//#endif 


//#if 1375714067 
Graph gaux = ComputeTranspose( ( Graph )this );
//#endif 


//#if -654998925 
WorkSpaceTranspose WST = new WorkSpaceTranspose();
//#endif 


//#if 873370683 
gaux.GraphSearch( WST );
//#endif 


//#if 389194298 
return gaux;
//#endif 

} 

//#endif 


//#if -1298691314 
public void addAnEdge( Vertex start,  Vertex end, int weight )
    { 

//#if 940436335 
addEdge( start, new  Neighbor( end, weight ) );
//#endif 


//#if -512549592 
addEdge( start,end, weight );
//#endif 

} 

//#endif 


//#if 422028764 
private void  run__wrappee__Connected  ( Vertex s )
    { 

//#if -738596791 
System.out.println("Connected");
//#endif 


//#if -1908743953 
ConnectedComponents( );
//#endif 


//#if -721300395 
run__wrappee__Number( s );
//#endif 

} 

//#endif 


//#if 80557044 
private void  run__wrappee__DFS  ( Vertex s )
    { 

//#if 1332079809 
System.out.println( "Cycle? " + CycleCheck() );
//#endif 


//#if 818784405 
run__wrappee__DirectedWithNeighbors( s );
//#endif 

} 

//#endif 


//#if -1346225509 
public EdgeIfc addEdge(Vertex start,  Vertex end)
    { 

//#if -1773012714 
Edge theEdge = new  Edge();
//#endif 


//#if -1528862869 
theEdge.EdgeConstructor( start, end );
//#endif 


//#if 842048756 
edges.add( theEdge );
//#endif 


//#if 1436562018 
start.addNeighbor( new  Neighbor( end, theEdge ) );
//#endif 


//#if -1531442590 
end.addNeighbor( new  Neighbor( start, theEdge ) );
//#endif 


//#if -2078737750 
return theEdge;
//#endif 


//#if -347992736 
Neighbor e = new Neighbor( end );
//#endif 


//#if -1193191178 
addEdge( start, e );
//#endif 


//#if -589123405 
return e;
//#endif 

} 

//#endif 


//#if 374473212 
public void addEdge( Vertex start,  Neighbor theNeighbor )
    { 

//#if -1634355612 
original( start,theNeighbor );
//#endif 


//#if -1352359938 
if(isDirected==false)//1
{ 

//#if -708737307 
Vertex end = theNeighbor.neighbor;
//#endif 


//#if 1558738491 
end.addWeight( end,theNeighbor.weight );
//#endif 

} 

//#endif 


//#if 1751964079 
start.addEdge( theNeighbor );
//#endif 


//#if -160572408 
Vertex end = theNeighbor.neighbor;
//#endif 


//#if -554603172 
end.addEdge( new  Neighbor( start ) );
//#endif 

} 

//#endif 


//#if -855616005 
public void addEdge( Vertex start,  Vertex end, int weight )
    { 

//#if -1599213653 
addEdge( start,end );
//#endif 


//#if -1218306701 
start.addWeight( weight );
//#endif 


//#if 1093881820 
if(isDirected==false)//1
{ 

//#if 1426957855 
end.addWeight( weight );
//#endif 

} 

//#endif 

} 

//#endif 


//#if -449724113 
public void NumberVertices( )
    { 

//#if 1173222445 
GraphSearch( new NumberWorkSpace( ) );
//#endif 

} 

//#endif 


//#if -983374546 
private void  display__wrappee__WeightedWithEdges  ()
    { 

//#if 1208670116 
System.out.println( "******************************************" );
//#endif 


//#if 1530897195 
System.out.println( "Vertices " );
//#endif 


//#if -816110404 
for ( VertexIter vxiter = getVertices(); vxiter.hasNext() ; ) //1
{ 

//#if 738880109 
vxiter.next().display();
//#endif 

} 

//#endif 


//#if -1514337234 
System.out.println( "******************************************" );
//#endif 


//#if 76219342 
System.out.println( "Edges " );
//#endif 


//#if 1496903874 
for ( EdgeIter edgeiter = getEdges(); edgeiter.hasNext(); ) //1
{ 

//#if 876855587 
edgeiter.next().display();
//#endif 

} 

//#endif 


//#if -1514337233 
System.out.println( "******************************************" );
//#endif 

} 

//#endif 


//#if -2052306802 
public EdgeIter getEdges()
    { 

//#if 2135463018 
return new EdgeIter() {
            private Iterator iter = edges.iterator();
            public EdgeIfc next() {
                return (EdgeIfc)iter.next();
            }
            public boolean hasNext() {
                return iter.hasNext();
            }
        };
//#endif 

} 

//#endif 


//#if -1043932941 
public boolean CycleCheck()
    { 

//#if -897834244 
CycleWorkSpace c = new CycleWorkSpace( isDirected );
//#endif 


//#if 2067860685 
GraphSearch( c );
//#endif 


//#if 594060755 
return c.AnyCycles;
//#endif 

} 

//#endif 


//#if -1620798313 
public void display()
    { 

//#if -1986841143 
display__wrappee__WeightedWithEdges();
//#endif 


//#if 63594086 
System.out.println( "******************************************" );
//#endif 


//#if 785611373 
System.out.println( "Vertices " );
//#endif 


//#if 369007546 
for ( VertexIter vxiter = getVertices(); vxiter.hasNext() ; ) //1
{ 

//#if -1720020179 
vxiter.next().display();
//#endif 

} 

//#endif 


//#if 450885164 
System.out.println( "******************************************" );
//#endif 


//#if 657343436 
System.out.println( "Edges " );
//#endif 


//#if 149660164 
for ( EdgeIter edgeiter = getEdges(); edgeiter.hasNext(); ) //1
{ 

//#if -1102117986 
edgeiter.next().display();
//#endif 

} 

//#endif 


//#if 450885165 
System.out.println( "******************************************" );
//#endif 

} 

//#endif 


//#if -2046704381 
public void run( Vertex s )
    { 

//#if 363950462 
System.out.println("MSTKruskal");
//#endif 


//#if 2020404068 
Graph gaux = Kruskal();
//#endif 


//#if -689529197 
System.out.println("MSTPrim");
//#endif 


//#if 887995710 
Graph gaux = Prim( s );
//#endif 


//#if 908546946 
System.out.println("StronglyConnected");
//#endif 


//#if -1939964302 
Graph gaux = StrongComponents();
//#endif 


//#if 968886336 
gaux.display();
//#endif 


//#if -1964095352 
run__wrappee__UndirectedWithEdges( s );
//#endif 


//#if 1927199903 
run__wrappee__Cycle( s );
//#endif 


//#if 416165642 
run__wrappee__Number( s );
//#endif 


//#if 1865334270 
System.out.println("Connected");
//#endif 


//#if -1554488092 
ConnectedComponents( );
//#endif 


//#if -1260047885 
run__wrappee__UndirectedWithNeighbors( s );
//#endif 


//#if 351180138 
run__wrappee__DFS( s );
//#endif 

} 

//#endif 


//#if -999482122 
private void  run__wrappee__Number  ( Vertex s )
    { 

//#if 257421497 
System.out.println("Number");
//#endif 


//#if -1211838352 
NumberVertices( );
//#endif 


//#if -1528857783 
run__wrappee__UndirectedWithEdges( s );
//#endif 

} 

//#endif 


//#if -598233740 
public void ConnectedComponents( )
    { 

//#if -103043352 
GraphSearch( new RegionWorkSpace( ) );
//#endif 

} 

//#endif 


//#if 2095048086 
private void  run__wrappee__UndirectedWithEdges  ( Vertex s ) {
}
//#endif 


//#if 214934989 
protected void addVertex( Vertex v )
    { 

//#if 1338986664 
vertices.add( v );
//#endif 


//#if 720498143 
verticesMap.put( v.name, v );
//#endif 

} 

//#endif 


//#if -575221877 
private void  run__wrappee__UndirectedWithNeighbors  ( Vertex s )
    {
}
//#endif 


//#if 2065238209 
public void sortVertices(Comparator c)
    { 

//#if 1425530599 
Collections.sort(vertices, c);
//#endif 

} 

//#endif 


//#if -1742457704 
public void sortEdges(Comparator c)
    { 

//#if 1566076429 
Collections.sort(edges, c);
//#endif 

} 

//#endif 


//#if 1278779935 
private void  run__wrappee__Cycle  ( Vertex s )
    { 

//#if 1138397292 
System.out.println( "Cycle? " + CycleCheck() );
//#endif 


//#if -645265504 
run__wrappee__Connected( s );
//#endif 

} 

//#endif 


//#if -252728569 
public  Graph Prim( Vertex r )
    { 

//#if -650993727 
Vertex root;
//#endif 


//#if -1971033008 
root = r;
//#endif 


//#if 1570421659 
Vertex x;
//#endif 


//#if -550210294 
for ( VertexIter vxiter = getVertices(); vxiter.hasNext(); ) //1
{ 

//#if -1879393080 
x = vxiter.next();
//#endif 


//#if 28298846 
x.pred = null;
//#endif 


//#if 1228920825 
x.key = Integer.MAX_VALUE;
//#endif 

} 

//#endif 


//#if 2079204929 
root.key = 0;
//#endif 


//#if 1201142992 
root.pred = null;
//#endif 


//#if -1181664102 
LinkedList Queue = new LinkedList();
//#endif 


//#if 656966640 
Set indx = new HashSet( );
//#endif 


//#if -180053716 
Queue.add( root );
//#endif 


//#if -865905712 
indx.add( root.getName( ) );
//#endif 


//#if -1719590553 
for ( VertexIter vxiter = getVertices(); vxiter.hasNext(); ) //2
{ 

//#if 2064846605 
x = vxiter.next();
//#endif 


//#if 1678028777 
if(x.key != 0)//1
{ 

//#if 813621372 
Queue.add( x );
//#endif 


//#if 2017906796 
indx.add( x.getName( ) );
//#endif 

} 

//#endif 

} 

//#endif 


//#if -690201217 
Vertex ucurrent;
//#endif 


//#if 1397574989 
int j,k,l;
//#endif 


//#if -1392714174 
int pos;
//#endif 


//#if 2023697476 
LinkedList Uneighbors;
//#endif 


//#if 1641593332 
Vertex u,v;
//#endif 


//#if -742609059 
EdgeIfc en;
//#endif 


//#if -354220381 
NeighborIfc vn;
//#endif 


//#if -1392499778 
int wuv;
//#endif 


//#if 132219001 
boolean isNeighborInQueue = false;
//#endif 


//#if 2131134386 
while ( Queue.size()!=0 ) //1
{ 

//#if 1644215249 
u = ( Vertex )Queue.removeFirst();
//#endif 


//#if 265058891 
indx.remove( u.getName( ) );
//#endif 


//#if -1360709609 
Uneighbors = u.getNeighborsObj( );
//#endif 


//#if 1265330238 
k = 0;
//#endif 


//#if -217128933 
for( EdgeIter edgeiter = u.getEdges(); edgeiter.hasNext(); k++ ) //1
{ 

//#if -2117365566 
vn = ( NeighborIfc )Uneighbors.get( k );
//#endif 


//#if -596625887 
en = edgeiter.next();
//#endif 


//#if -1631407590 
v = en.getOtherVertex(u);
//#endif 


//#if 1757227462 
isNeighborInQueue = false;
//#endif 


//#if 172695941 
if(indx.contains( v.getName( ) ))//1
{ 

//#if 733391213 
isNeighborInQueue = true;
//#endif 

} 

//#endif 


//#if -504665013 
wuv = en.getWeight();
//#endif 


//#if -1362293104 
if(isNeighborInQueue && ( wuv < v.key ))//1
{ 

//#if -895009887 
v.key = wuv;
//#endif 


//#if -1453668082 
v.pred = u.getName();
//#endif 


//#if -1236038485 
Uneighbors.set( k,vn );
//#endif 


//#if -949985472 
Object residue = ( Object ) v;
//#endif 


//#if 270565438 
Queue.remove( residue );
//#endif 


//#if -688036315 
indx.remove( v.getName( ) );
//#endif 


//#if 1516965842 
int position = Collections.binarySearch( Queue,v,
                    new Comparator() {
                        public int compare( Object o1, Object o2 ) {
                            Vertex v1 = ( Vertex )o1;
                            Vertex v2 = ( Vertex )o2;

                            if ( v1.key < v2.key ) {
                                return -1;
                            }
                            if ( v1.key == v2.key ) {
                                return 0;
                            }
                            return 1;
                        }
                    } );
//#endif 


//#if -794059960 
if(position < 0)//1
{ 

//#if 969289135 
Queue.add( - ( position+1 ),v );
//#endif 

} 
else
{ 

//#if -1473565664 
Queue.add( position,v );
//#endif 

} 

//#endif 


//#if -125918968 
indx.add( v.getName( ) );
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -2133302940 
String theName;
//#endif 


//#if -2034469929 
Graph newGraph = new  Graph();
//#endif 


//#if -1719560761 
for ( VertexIter vxiter = getVertices( ); vxiter.hasNext( ); ) //3
{ 

//#if -1464277812 
Vertex vtx = vxiter.next( );
//#endif 


//#if 1756892425 
theName = vtx.name;
//#endif 


//#if 168212403 
newGraph.addVertex( new  Vertex().assignName( theName ) );
//#endif 

} 

//#endif 


//#if -339841160 
Vertex theVertex, thePred;
//#endif 


//#if -1029627734 
Vertex theNewVertex, theNewPred;
//#endif 


//#if -1270881173 
EdgeIfc   e;
//#endif 


//#if -1719530969 
for ( VertexIter vxiter = getVertices( ); vxiter.hasNext( ); ) //4
{ 

//#if -966746957 
theVertex = vxiter.next( );
//#endif 


//#if 1988760089 
thePred = findsVertex( theVertex.pred );
//#endif 


//#if 646921838 
if(thePred==null)//1
{ 

//#if 458378360 
continue;
//#endif 

} 

//#endif 


//#if -390515666 
theNewVertex = newGraph.findsVertex( theVertex.name );
//#endif 


//#if 99671694 
theNewPred = newGraph.findsVertex( thePred.name );
//#endif 


//#if 819926455 
EdgeIfc theNewEdge = newGraph.addEdge( theNewPred, theNewVertex );
//#endif 


//#if -1678656084 
e = findsEdge( thePred,theVertex );
//#endif 


//#if 6324787 
theNewEdge.adjustAdorns( e );
//#endif 

} 

//#endif 


//#if 1990193321 
return newGraph;
//#endif 

} 

//#endif 


//#if -577654138 
public void addVertex( Vertex v )
    { 

//#if -127826638 
vertices.add( v );
//#endif 


//#if 2090565097 
verticesMap.put( v.name, v );
//#endif 

} 

//#endif 


//#if 2086530876 
public  Graph Kruskal()
    { 

//#if 1856116974 
LinkedList A = new LinkedList();
//#endif 


//#if 116941614 
for ( VertexIter vxiter = getVertices(); vxiter.hasNext(); ) //1
{ 

//#if -1234976777 
Vertex v = vxiter.next();
//#endif 


//#if -1301789068 
v.representative = v;
//#endif 


//#if -635834984 
v.members = new LinkedList();
//#endif 

} 

//#endif 


//#if 759761222 
LinkedList Vneighbors = new LinkedList();
//#endif 


//#if -1550639116 
sortEdges(
        new Comparator() {
            public int compare( Object o1, Object o2 ) {
                Edge e1 = ( Edge )o1;
                Edge e2 = ( Edge )o2;
                if ( e1.getWeight() < e2.getWeight() ) {
                    return -1;
                }
                if ( e1.getWeight() == e2.getWeight() ) {
                    return 0;
                }
                return 1;
            }
        } );
//#endif 


//#if -1593210254 
Vertex vaux, urep, vrep;
//#endif 


//#if -828302320 
for( EdgeIter edgeiter = getEdges(); edgeiter.hasNext(); ) //1
{ 

//#if 775239108 
EdgeIfc e1 = edgeiter.next();
//#endif 


//#if 943274950 
Vertex u = e1.getStart();
//#endif 


//#if 706964940 
Vertex v = e1.getEnd();
//#endif 


//#if 113754096 
if(! ( v.representative.getName() ).equals( u.representative.getName() ))//1
{ 

//#if -568323727 
A.add( e1 );
//#endif 


//#if 1116659535 
urep = u.representative;
//#endif 


//#if 431912943 
vrep = v.representative;
//#endif 


//#if 1961110017 
if(( urep.members ).size() > ( vrep.members ).size())//1
{ 

//#if -1410523926 
for( int j=0; j< ( vrep.members ).size(); j++ ) //1
{ 

//#if -622298935 
vaux = ( Vertex ) ( vrep.members ).get( j );
//#endif 


//#if -537170843 
vaux.representative = urep;
//#endif 


//#if -1488722823 
( urep.members ).add( vaux );
//#endif 

} 

//#endif 


//#if 1856635197 
v.representative = urep;
//#endif 


//#if -1620189944 
vrep.representative = urep;
//#endif 


//#if 662820659 
( urep.members ).add( v );
//#endif 


//#if 813366945 
if(!v.equals( vrep ))//1
{ 

//#if -854173756 
( urep.members ).add( vrep );
//#endif 

} 

//#endif 


//#if -888587590 
( vrep.members ).clear();
//#endif 

} 
else
{ 

//#if -1645734275 
for( int j=0; j< ( urep.members ).size(); j++ ) //1
{ 

//#if 1162674098 
vaux = ( Vertex ) ( urep.members ).get( j );
//#endif 


//#if -1992713008 
vaux.representative = vrep;
//#endif 


//#if 1282772034 
( vrep.members ).add( vaux );
//#endif 

} 

//#endif 


//#if 1340001297 
u.representative = vrep;
//#endif 


//#if -1239802794 
urep.representative = vrep;
//#endif 


//#if -1681443099 
( vrep.members ).add( u );
//#endif 


//#if 1062280051 
if(!u.equals( urep ))//1
{ 

//#if -1385303255 
( vrep.members ).add( urep );
//#endif 

} 

//#endif 


//#if -765144983 
( urep.members ).clear();
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if -1623556984 
String theName;
//#endif 


//#if -930694605 
Graph newGraph = new  Graph();
//#endif 


//#if 589222083 
for ( VertexIter vxiter = getVertices(); vxiter.hasNext(); ) //2
{ 

//#if 1518086488 
theName = vxiter.next().getName();
//#endif 


//#if 1234596217 
newGraph.addVertex( new  Vertex().assignName( theName ) );
//#endif 

} 

//#endif 


//#if 60397714 
Vertex theStart, theEnd;
//#endif 


//#if -1550762780 
Vertex theNewStart, theNewEnd;
//#endif 


//#if 853527998 
EdgeIfc   theEdge;
//#endif 


//#if 1456556815 
for( int i=0; i<A.size(); i++ ) //1
{ 

//#if -1400019458 
theEdge = ( Edge )A.get( i );
//#endif 


//#if 1917465677 
theStart = theEdge.getStart();
//#endif 


//#if 1959538989 
theEnd = theEdge.getEnd();
//#endif 


//#if -1731996628 
theNewStart = newGraph.findsVertex( theStart.getName() );
//#endif 


//#if 2037808414 
theNewEnd = newGraph.findsVertex( theEnd.getName() );
//#endif 


//#if 713021448 
Edge theNewEdge = ( Edge ) newGraph.addEdge( theNewStart, theNewEnd );
//#endif 


//#if 1763190629 
theNewEdge.adjustAdorns( ( Edge )  theEdge );
//#endif 

} 

//#endif 


//#if 612448773 
return newGraph;
//#endif 

} 

//#endif 


//#if 2050965916 
public VertexIter getVertices()
    { 

//#if -1215417680 
return new VertexIter() {
            private Iterator iter = vertices.iterator();
            public Vertex next() {
                return (Vertex)iter.next();
            }
            public boolean hasNext() {
                return iter.hasNext();
            }
        };
//#endif 

} 

//#endif 


//#if 333874249 
public void GraphSearch( WorkSpace w )
    { 

//#if -91626247 
VertexIter vxiter = getVertices( );
//#endif 


//#if 732722943 
if(vxiter.hasNext( ) == false)//1
{ 

//#if 1683331055 
return;
//#endif 

} 

//#endif 


//#if -870478190 
while( vxiter.hasNext( ) ) //1
{ 

//#if 52011000 
Vertex v = vxiter.next( );
//#endif 


//#if -1239004734 
v.init_vertex( w );
//#endif 

} 

//#endif 


//#if 1127803731 
for( vxiter = getVertices( ); vxiter.hasNext( ); ) //1
{ 

//#if -588848028 
Vertex v = vxiter.next( );
//#endif 


//#if -1214377602 
if(!v.visited)//1
{ 

//#if -82451754 
w.nextRegionAction( v );
//#endif 


//#if 1401993829 
v.nodeSearch( w );
//#endif 

} 

//#endif 

} 

//#endif 

} 

//#endif 


//#if 1960309732 
public  Vertex findsVertex( String theName )
    { 

//#if -604904671 
Vertex theVertex;
//#endif 


//#if -1866299823 
Vertex theVertex = null;
//#endif 


//#if -63026953 
if(theName==null)//1
{ 

//#if 65670973 
return null;
//#endif 

} 

//#endif 


//#if -372260787 
return ( Vertex ) verticesMap.get( theName );
//#endif 


//#if 150141677 
for(VertexIter vxiter = getVertices( ); vxiter.hasNext( ); ) //1
{ 

//#if 819783257 
theVertex = vxiter.next( );
//#endif 


//#if -609705422 
if(theName.equals( theVertex.getName( ) ))//1
{ 

//#if -1235421099 
return theVertex;
//#endif 

} 

//#endif 

} 

//#endif 


//#if -851760243 
return theVertex;
//#endif 

} 

//#endif 


//#if 279066407 
public  Graph ComputeTranspose( Graph the_graph )
    { 

//#if -2053483328 
int i;
//#endif 


//#if 688227217 
String theName;
//#endif 


//#if 1124242829 
Map newVertices = new HashMap( );
//#endif 


//#if -492821622 
Graph newGraph = new  Graph();
//#endif 


//#if -61370633 
for ( VertexIter vxiter = getVertices(); vxiter.hasNext(); ) //1
{ 

//#if -1041345949 
theName = vxiter.next().getName();
//#endif 


//#if 1076679959 
Vertex v = new  Vertex( ).assignName( theName );
//#endif 


//#if 420956200 
newGraph.addVertex( v );
//#endif 


//#if 1080012743 
newVertices.put( theName, v );
//#endif 

} 

//#endif 


//#if 364344179 
Vertex theVertex, newVertex;
//#endif 


//#if -2070170467 
Vertex theNeighbor;
//#endif 


//#if -594946 
Vertex newAdjacent;
//#endif 


//#if -214752250 
EdgeIfc newEdge;
//#endif 


//#if -1144686997 
VertexIter newvxiter = newGraph.getVertices( );
//#endif 


//#if 1363616858 
for ( VertexIter vxiter = getVertices(); vxiter.hasNext(); ) //2
{ 

//#if -1172031497 
theVertex = vxiter.next();
//#endif 


//#if -1930287268 
newAdjacent = newvxiter.next( );
//#endif 


//#if -38331131 
for( VertexIter neighbors = theVertex.getNeighbors(); neighbors.hasNext(); ) //1
{ 

//#if -1576469961 
theNeighbor = neighbors.next();
//#endif 


//#if 1955692131 
newVertex = ( Vertex ) newVertices.get( theNeighbor.getName( ) );
//#endif 


//#if 2116553771 
newEdge = newGraph.addEdge( newVertex, newAdjacent );
//#endif 

} 

//#endif 

} 

//#endif 


//#if -736685028 
return newGraph;
//#endif 

} 

//#endif 


//#if 468342642 
private void  run__wrappee__DirectedWithNeighbors  ( Vertex s )
    {
}
//#endif 

 } 

//#endif 


//#endif 

