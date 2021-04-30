
//#if -553695191 
// Compilation Unit of /SolutionHintListener.java 
 

//#if -376425612 
package p;
//#endif 


//#if -1687772411 
import java.awt.event.ActionEvent;
//#endif 


//#if -495047325 
import java.awt.event.ActionListener;
//#endif 


//#if 1011677342 
import javax.swing.JOptionPane;
//#endif 


//#if -604820890 

//#if 263283154 
@p.R4Feature(p.R4Feature.SOLVER)
//#endif 

public class SolutionHintListener implements 
//#if 1045393264 
ActionListener
//#endif 

  { 

//#if -1972419775 
protected BoardManager bm;
//#endif 


//#if -1903264537 
public void actionPerformed(ActionEvent e)
    { 

//#if 200181527 
Thread worker = new Thread() {
            public void run() {
                if (!bm.solutionHint()) {
                    JOptionPane.showMessageDialog(null, "Sudoku not solvable!");
                }
            }
        };
//#endif 


//#if -1188510405 
worker.start();
//#endif 

} 

//#endif 


//#if 350865522 
public SolutionHintListener(BoardManager bm)
    { 

//#if 545650611 
this.bm = bm;
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

