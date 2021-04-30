package p;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
@p.R4Feature(p.R4Feature.SOLVER)
public class SolutionHintListener implements ActionListener
{
    protected BoardManager bm;
    public void actionPerformed(ActionEvent e)
    {
        Thread worker = new Thread() {
            public void run() {
                if (!bm.solutionHint()) {
                    JOptionPane.showMessageDialog(null, "Sudoku not solvable!");
                }
            }
        };
        worker.start();
    }
    public SolutionHintListener(BoardManager bm)
    {
        this.bm = bm;
    }

}
