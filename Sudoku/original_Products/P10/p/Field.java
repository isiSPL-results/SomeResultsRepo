package p;

//#if STATES
import java.io.IOException;
//#endif
//#if STATES
import java.io.ObjectInputStream;
//#endif
//#if STATES
import java.io.ObjectOutputStream;
//#endif
//#if STATES
import java.io.Serializable;
//#endif
import java.util.LinkedList;
import java.util.List;

public class Field 
// #ifdef STATES
 implements
    Cloneable
    ,
    Serializable
// #endif
{
    
    public static int POSSIBILITIES = 9;
    protected boolean set;
    protected boolean initialSet;
    protected int value;

    public Field()
    {
        this.initialSet = false;
        this.set = false;
       // #if SOLVER
        if(p.R4Feature.SOLVER) {
            remainingPos = new LinkedList();
            // #endif
           // #if SOLVER
            for (int i = 1; i <= POSSIBILITIES; i++)
               // #if SOLVER
            {
                remainingPos.add((Object) i);
            }
            // #endif
        }
        // #endif
    }

    public Field(int value, boolean initialSet)
    {
        this.value = value;
        this.set = true;
        this.initialSet = initialSet;
       // #if SOLVER
        if(p.R4Feature.SOLVER) {
            remainingPos = new LinkedList();
        }
        // #endif
    }

    public Field(int value)
    {
        this.value = value;
        this.set = true;
        this.initialSet = false;
       // #if SOLVER
        if(p.R4Feature.SOLVER) {
            remainingPos = new LinkedList();
        }
        // #endif
    }

    
    public int getValue()
    {
        return value;
    }

    
    public boolean isInitialSet()
    {
        return initialSet;
    }

    
    public boolean isSet()
    {
        return set;
    }

   // #if STATES
    @p.R4Feature(p.R4Feature.STATES)
    public Object clone() throws CloneNotSupportedException
    {
        Field clone = new Field();
        clone.initialSet = initialSet;
        clone.set = set;
        clone.value = value;
       // #if SOLVER
        if(p.R4Feature.SOLVER) {
            LinkedList remainingPosClone = new LinkedList();
            // #endif
           // #if SOLVER
            for (int i = 0; i < remainingPos.size(); i++)
               // #if SOLVER
            {
                remainingPosClone.add(new Integer(((Integer) remainingPos.get(i))
                                                  .intValue()));
            }
            // #endif
            // #endif
           // #if SOLVER
            clone.remainingPos = remainingPosClone;
        }
        // #endif
        return clone;
    }

    // #endif
   // #if STATES
    @p.R4Feature(p.R4Feature.STATES)
    private void writeObject(ObjectOutputStream aOutputStream)
    throws IOException
    {
        aOutputStream.writeBoolean(set);
        aOutputStream.writeBoolean(initialSet);
        aOutputStream.writeInt(value);
        aOutputStream.defaultWriteObject();
    }

    // #endif
   // #if STATES
    @p.R4Feature(p.R4Feature.STATES)
    private void readObject(ObjectInputStream aInputStream)
    throws ClassNotFoundException, IOException
    {
        aInputStream.defaultReadObject();
        set = aInputStream.readBoolean();
        initialSet = aInputStream.readBoolean();
        value = aInputStream.readInt();
    }

    // #endif
   // #if SOLVER
    @p.R4Feature(p.R4Feature.SOLVER)
    protected List remainingPos;

    // #endif
   // #if SOLVER
    @p.R4Feature(p.R4Feature.SOLVER)
    public Field(List remainingPos)
    {
        this.remainingPos = remainingPos;
    }

    // #endif
   // #if SOLVER
    
    @p.R4Feature(p.R4Feature.SOLVER)
    public List getRemainingPos()
    {
        return remainingPos;
    }

    // #endif
   // #if SOLVER
    @p.R4Feature(p.R4Feature.SOLVER)
    public String toString()
    {
        String output = "";
        if (remainingPos.isEmpty()) {
            output = "[" + value + "]";
        } else {
            output = "{";
            for (int i = 0; i < remainingPos.size(); i++) {
                output += remainingPos.get(i).toString();
            }
            output += "}";
        }
        return output;
    }

    // #endif
   // #if GENERATOR
    @p.R4Feature(p.R4Feature.GENERATOR)
    public void setInitial(boolean flag)
    {
        initialSet = flag;
    }
    // #endif
}
