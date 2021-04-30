package p;

//#if COLOR
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
//#endif
import javax.swing.JMenuItem;
//#if SOLVER
import javax.swing.JOptionPane;
//#endif
import javax.swing.JPopupMenu;
//#if COLOR
import javax.swing.border.Border;
//#endif

public class GuiFieldPopupMenuListener implements MouseListener, ActionListener
{
    protected GuiField field;
    protected BoardManager boardManager;

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
        // #if SOLVER
        if(p.R4Feature.SOLVER) {
            done = true;
            // #endif
            // #if SOLVER
            for (int i = 0; i < boardManager
                    .getField(Structure.BOX, field.getBoxIndex(),
                              field.getFieldIndex()).getRemainingPos().size(); i++)
                // #if SOLVER
            {
                mi = new JMenuItem(String.valueOf(boardManager
                                                  .getField(Structure.BOX, field.getBoxIndex(),
                                                          field.getFieldIndex()).getRemainingPos().get(i)));
                mi.addActionListener(this);
                m.add(mi);
            }
            // #endif
        }
        // #endif
        if (!done) {
            for (int i = 0; i < Field.POSSIBILITIES; i++) {
                mi = new JMenuItem(String.valueOf(i + 1));
                mi.addActionListener(this);
                m.add(mi);
            }
        }
        return m;
    }

    public void mouseClicked(MouseEvent arg0)
    {
        if (!boardManager.getField(Structure.BOX, field.getBoxIndex(),
                                   field.getFieldIndex()).isInitialSet()) {
            createPopupMenu().show(arg0.getComponent(), arg0.getX(),
                                   arg0.getY());
        }
    }

    public void mouseEntered(MouseEvent arg0)
    {
        // #if COLOR
        if(p.R4Feature.COLOR) {
            if (!boardManager.getField(Structure.BOX, field.getBoxIndex(),
                                       field.getFieldIndex()).isInitialSet())
                // #if COLOR
            {
                oldBorder = field.getBorder();
                field.setBorder(BorderFactory.createLineBorder(Color.ORANGE,
                                EMPH_BORDER_THICKNESS));
            }
            // #endif
        }
        // #endif
    }

    public void mouseExited(MouseEvent arg0)
    {
        // #if COLOR
        if(p.R4Feature.COLOR) {
            if (!boardManager.getField(Structure.BOX, field.getBoxIndex(),
                                       field.getFieldIndex()).isInitialSet())
                // #if COLOR
            {
                field.setBorder(oldBorder);
            }
            // #endif
        }
        // #endif
    }

    public void mousePressed(MouseEvent arg0)
    {
    }

    public void mouseReleased(MouseEvent arg0)
    {
    }

    public void actionPerformed(ActionEvent arg0)
    {
        boolean done = false;
        // #if SOLVER
        if(p.R4Feature.SOLVER) {
            done = true;
            // #endif
            // #if SOLVER
            if (!boardManager.trySetField(Structure.BOX, field.getBoxIndex(),
                                          field.getFieldIndex(),
                                          new Field(Integer.parseInt(arg0.getActionCommand())))) {
                // #if SOLVER
                JOptionPane.showMessageDialog(null,
                                              "Invalid state reached! Last action was undone.");
                // #endif
            }
        }
        // #endif
        if (!done) {
            boardManager.setField(Structure.BOX, field.getBoxIndex(),
                                  field.getFieldIndex(),
                                  new Field(Integer.parseInt(arg0.getActionCommand())));
        }
    }

    // #if COLOR
    @p.R4Feature(p.R4Feature.COLOR)
    private static final int EMPH_BORDER_THICKNESS = 4;
    // #endif
    // #if COLOR
    @p.R4Feature(p.R4Feature.COLOR)
    Border oldBorder;
    // #endif
}
