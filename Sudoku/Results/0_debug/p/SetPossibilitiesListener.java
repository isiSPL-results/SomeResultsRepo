
//#if -1689348214 
// Compilation Unit of /SetPossibilitiesListener.java 
 

//#if 1773232096 
package p;
//#endif 


//#if 438586225 
import java.awt.event.ActionEvent;
//#endif 


//#if -617570953 
import java.awt.event.ActionListener;
//#endif 


//#if -2025191502 
import javax.swing.JOptionPane;
//#endif 


//#if 1461185665 

//#if 2137149259 
@p.R4Feature(p.R4Feature.EXTENDED)
//#endif 

public class SetPossibilitiesListener implements 
//#if 1777634767 
ActionListener
//#endif 

  { 

//#if 1743761513 
final static Object[] SELECTION_VALUES = { "4", "9", "16", "25", "36" };
//#endif 


//#if -1657866044 
protected BoardManager boardManager;
//#endif 


//#if -687212768 
public SetPossibilitiesListener(BoardManager bM)
    { 

//#if -1498905885 
this.boardManager = bM;
//#endif 

} 

//#endif 


//#if 452282699 
public void actionPerformed(ActionEvent arg0)
    { 

//#if 1947890279 
Object poss = JOptionPane.showInputDialog(null,
                      "Select number of possibilities", "",
                      JOptionPane.QUESTION_MESSAGE, null, SELECTION_VALUES,
                      String.valueOf(Field.POSSIBILITIES));
//#endif 


//#if -756729113 
if(null != poss)//1
{ 

//#if -1615353125 
boardManager.setPossibilities(Integer.valueOf((String) poss));
//#endif 

} 

//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

