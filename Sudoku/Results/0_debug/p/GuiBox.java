
//#if -802864762 
// Compilation Unit of /GuiBox.java 
 

//#if 1170362407 
package p;
//#endif 


//#if -2108110363 
import java.awt.Color;
//#endif 


//#if -2123616830 
import java.awt.Dimension;
//#endif 


//#if -65230977 
import java.awt.Font;
//#endif 


//#if 603992990 
import java.awt.GridLayout;
//#endif 


//#if -194385467 
import java.awt.event.MouseEvent;
//#endif 


//#if 1724149411 
import java.awt.event.MouseListener;
//#endif 


//#if -2092478156 
import javax.swing.BorderFactory;
//#endif 


//#if -1254922182 
import javax.swing.JLabel;
//#endif 


//#if -1140048086 
import javax.swing.JPanel;
//#endif 


//#if -835766859 
public class GuiBox extends 
//#if -2138155476 
JPanel
//#endif 

  { 

//#if 1668844336 
private static final int FONT_SIZE = 18;
//#endif 


//#if -209458192 
private GuiField[] fields;
//#endif 


//#if 2039137098 
private ListenerFactory listenerFactory;
//#endif 


//#if 237197319 
private int index;
//#endif 


//#if -179160899 
public GuiBox(int index, ListenerFactory listenerFactory)
    { 

//#if 362627146 
super();
//#endif 


//#if 1916084081 
this.listenerFactory = listenerFactory;
//#endif 


//#if 830979398 
fields = new GuiField[Field.POSSIBILITIES];
//#endif 


//#if -459842746 
this.setLayout(new GridLayout((int) Math.round(Math
                                      .sqrt(Field.POSSIBILITIES)), (int) Math.round(Math
                                              .sqrt(Field.POSSIBILITIES))));
//#endif 


//#if -478275452 
this.setBorder(BorderFactory.createLineBorder(Color.black));
//#endif 


//#if -1458698980 
for (int i = 0; i < Field.POSSIBILITIES; i++) //1
{ 

//#if 360910027 
fields[i] = new GuiField(index, i);
//#endif 


//#if -555274647 
fields[i].setText("");
//#endif 


//#if -1569191799 
fields[i].setBorder(BorderFactory.createLineBorder(Color.gray));
//#endif 


//#if -111536241 
fields[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//#endif 


//#if -865235174 
fields[i].addMouseListener(listenerFactory
                                       .getPopupMenuListener(fields[i]));
//#endif 


//#if 466073403 
add(fields[i]);
//#endif 


//#if -406389438 
fields[i].setFont(new Font(fields[i].getFont().getName(), fields[i]
                                       .getFont().getStyle(), FONT_SIZE));
//#endif 


//#if -716330829 
fields[i].setPreferredSize(new Dimension(FONT_SIZE
                                       + (int) (FONT_SIZE * 0.4 * Math.ceil(Math
                                                .log10((Field.POSSIBILITIES)))), FONT_SIZE
                                       + (int) (FONT_SIZE * 0.4 * Math.ceil(Math
                                                .log10((Field.POSSIBILITIES))))));
//#endif 


//#if 2103247288 
fields[i].addMouseListener(new MouseListener() {
                public void mouseReleased(MouseEvent arg0) {
                }

                public void mousePressed(MouseEvent arg0) {
                }

                public void mouseExited(MouseEvent arg0) {
                }

                public void mouseEntered(MouseEvent arg0) {
                }

                public void mouseClicked(MouseEvent arg0) {
                }
            });
//#endif 

} 

//#endif 

} 

//#endif 


//#if -109807241 
public JLabel getLabel(int element)
    { 

//#if -500031393 
return fields[element];
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

