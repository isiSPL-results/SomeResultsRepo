package p;

//#if UNDO
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@p.R4Feature(p.R4Feature.UNDO)
public class UndoListener implements ActionListener
{
    private BoardManager bm;

    public UndoListener(BoardManager bm)
    {
        this.bm = bm;
    }

    
    public void actionPerformed(ActionEvent e)
    {
        bm.undo();
    }
}
// #endif
