class LifeForm  { 
private final int type;
private final int[] neighbourhood;
private final int x;
private final int y;
public int getX()
    { 
return x;
} 
public int getType()
    { 
return type;
} 
public LifeForm(int x, int y, int type, int[] neighbourhood)
    { 
this.x = x;
this.y = y;
this.type = type;
this.neighbourhood = neighbourhood;
} 
public int getY()
    { 
return y;
} 
public int[] getNeighbourhood()
    { 
return neighbourhood;
} 

 } 
