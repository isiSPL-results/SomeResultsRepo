
//#if -1303919115
// Compilation Unit of /GenerateSudokuListener.java


//#if -1645770453
package p;
//#endif


//#if 47580092
import java.awt.event.ActionEvent;
//#endif


//#if -1129972404
import java.awt.event.ActionListener;
//#endif


//#if -1598778007

//#if -1500634287
@p.R4Feature(p.R4Feature.GENERATOR)
//#endif

public class GenerateSudokuListener implements
//#if 1351241401
    ActionListener
//#endif

{

//#if 1226201930
    protected BoardManager bm;
//#endif


//#if 317231841
    protected SudokuGenerator sGen;
//#endif


//#if -191196921
    public GenerateSudokuListener(BoardManager bm)
    {

//#if 1632522569
        this.bm = bm;
//#endif


//#if -370948349
        sGen = new SudokuGenerator();
//#endif

    }

//#endif


//#if 1744122302
    public void actionPerformed(ActionEvent e)
    {

//#if 1418616426
        Thread worker = new Thread() {
            public void run() {
                bm.setBusy(true);
                Board b = sGen.generate();
                bm.loadSudoku(b);
                bm.setBusy(false);
            }
        };
//#endif


//#if 801970386
        worker.start();
//#endif

    }

//#endif

}

//#endif


//#endif

