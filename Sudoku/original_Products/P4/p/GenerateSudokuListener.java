package p;

//#if GENERATOR
//@import java.awt.event.ActionEvent;
//@import java.awt.event.ActionListener;
//@
//@@p.R4Feature(p.R4Feature.GENERATOR)
//@public class GenerateSudokuListener implements ActionListener
//@{
//@    protected BoardManager bm;
//@    protected SudokuGenerator sGen;
//@
//@    public GenerateSudokuListener(BoardManager bm)
//@    {
//@        this.bm = bm;
//@        sGen = new SudokuGenerator();
//@    }
//@
//@
//@    public void actionPerformed(ActionEvent e)
//@    {
//@        Thread worker = new Thread() {
//@            public void run() {
//@                bm.setBusy(true);
//@                Board b = sGen.generate();
//@                bm.loadSudoku(b);
//@                bm.setBusy(false);
//@            }
//@        };
//@        worker.start();
//@    }
//@}
// #endif
