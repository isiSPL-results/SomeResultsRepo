package p;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class GuiBox extends JPanel
  { 
private static final int FONT_SIZE = 18;
private GuiField[] fields;
private ListenerFactory listenerFactory;
private int index;
public GuiBox(int index, ListenerFactory listenerFactory)
    { 
super();
this.listenerFactory = listenerFactory;
fields = new GuiField[Field.POSSIBILITIES];
this.setLayout(new GridLayout((int) Math.round(Math
                                      .sqrt(Field.POSSIBILITIES)), (int) Math.round(Math
                                              .sqrt(Field.POSSIBILITIES))));
this.setBorder(BorderFactory.createLineBorder(Color.black));
for (int i = 0; i < Field.POSSIBILITIES; i++) //1
{ 
fields[i] = new GuiField(index, i);
fields[i].setText("");
fields[i].setBorder(BorderFactory.createLineBorder(Color.gray));
fields[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
fields[i].addMouseListener(listenerFactory
                                       .getPopupMenuListener(fields[i]));
add(fields[i]);
fields[i].setFont(new Font(fields[i].getFont().getName(), fields[i]
                                       .getFont().getStyle(), FONT_SIZE));
fields[i].setPreferredSize(new Dimension(FONT_SIZE
                                       + (int) (FONT_SIZE * 0.4 * Math.ceil(Math
                                                .log10((Field.POSSIBILITIES)))), FONT_SIZE
                                       + (int) (FONT_SIZE * 0.4 * Math.ceil(Math
                                                .log10((Field.POSSIBILITIES))))));
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
} 
} 
public JLabel getLabel(int element)
    { 
return fields[element];
} 

 } 
