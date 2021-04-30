
//#if -1366754070
// Compilation Unit of /UndoListener.java


//#if 33873359
package p;
//#endif


//#if -1473729440
import java.awt.event.ActionEvent;
//#endif


//#if -1967332824
import java.awt.event.ActionListener;
//#endif


//#if 1406682309

//#if -737749104
@p.R4Feature(p.R4Feature.UNDO)
//#endif

public class UndoListener implements
//#if -431530273
    ActionListener
//#endif

{

//#if 1538002619
    private BoardManager bm;
//#endif


//#if -1404274600
    public void actionPerformed(ActionEvent e)
    {

//#if -215639930
        bm.undo();
//#endif

    }

//#endif


//#if -216761691
    public UndoListener(BoardManager bm)
    {

//#if 852820465
        this.bm = bm;
//#endif

    }

//#endif

}

//#endif


//#endif

