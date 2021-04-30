package p;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.border.Border;
import javax.swing.JOptionPane;
public class GuiFieldPopupMenuListener implements MouseListener
    ,ActionListener
{
    protected GuiField field;
    protected BoardManager boardManager;
    @p.R4Feature(p.R4Feature.COLOR)
    private static final int EMPH_BORDER_THICKNESS = 4;
    @p.R4Feature(p.R4Feature.COLOR)
    Border oldBorder;
    public GuiFieldPopupMenuListener(GuiField field, BoardManager bM)
    {
        this.field = field;
        this.boardManager = bM;
    }
    protected JPopupMenu createPopupMenu()
    {
        JPopupMenu m = new JPopupMenu();
        JMenuItem mi;
        boolean done = false;
        if(p.R4Feature.SOLVER) { //1
            done = true;
            for (int i = 0; i < boardManager
                    .getField(Structure.BOX, field.getBoxIndex(),
                              field.getFieldIndex()).getRemainingPos().size(); i++)
                // #if SOLVER
                //1
            {
                mi = new JMenuItem(String.valueOf(boardManager
                                                  .getField(Structure.BOX, field.getBoxIndex(),
                                                          field.getFieldIndex()).getRemainingPos().get(i)));
                mi.addActionListener(this);
                m.add(mi);
            }
        }
        if(!done) { //1
            for (int i = 0; i < Field.POSSIBILITIES; i++) { //1
                mi = new JMenuItem(String.valueOf(i + 1));
                mi.addActionListener(this);
                m.add(mi);
            }
        }
        return m;
    }
    public void actionPerformed(ActionEvent arg0)
    {
        boolean done = false;
        if(p.R4Feature.SOLVER) { //1
            done = true;
            if(!boardManager.trySetField(Structure.BOX, field.getBoxIndex(),
                                         field.getFieldIndex(),
                                         new Field(Integer.parseInt(arg0.getActionCommand())))) { //1
                JOptionPane.showMessageDialog(null,
                                              "Invalid state reached! Last action was undone.");
            }
        }
        if(!done) { //1
            boardManager.setField(Structure.BOX, field.getBoxIndex(),
                                  field.getFieldIndex(),
                                  new Field(Integer.parseInt(arg0.getActionCommand())));
        }
    }
    public void mouseReleased(MouseEvent arg0)
    {
    } public void mouseEntered(MouseEvent arg0)
    {
        if(p.R4Feature.COLOR) { //1
            if(!boardManager.getField(Structure.BOX, field.getBoxIndex(),
                                      field.getFieldIndex()).isInitialSet()) { //1
                oldBorder = field.getBorder();
                field.setBorder(BorderFactory.createLineBorder(Color.ORANGE,
                                EMPH_BORDER_THICKNESS));
            }
        }
    }
    public void mouseClicked(MouseEvent arg0)
    {
        if(!boardManager.getField(Structure.BOX, field.getBoxIndex(),
                                  field.getFieldIndex()).isInitialSet()) { //1
            createPopupMenu().show(arg0.getComponent(), arg0.getX(),
                                   arg0.getY());
        }
    }
    public void mouseExited(MouseEvent arg0)
    {
        if(p.R4Feature.COLOR) { //1
            if(!boardManager.getField(Structure.BOX, field.getBoxIndex(),
                                      field.getFieldIndex()).isInitialSet()) { //1
                field.setBorder(oldBorder);
            }
        }
    }
    public void mousePressed(MouseEvent arg0)
    {
    }
}
