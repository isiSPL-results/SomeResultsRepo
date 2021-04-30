
//#if -1478282674
// Compilation Unit of /GuiFieldPopupMenuListener.java


//#if -520209671
package p;
//#endif


//#if -2004809289
import java.awt.Color;
//#endif


//#if -1475892342
import java.awt.event.ActionEvent;
//#endif


//#if -1977836866
import java.awt.event.ActionListener;
//#endif


//#if 212726451
import java.awt.event.MouseEvent;
//#endif


//#if 1007654645
import java.awt.event.MouseListener;
//#endif


//#if -1685366238
import javax.swing.BorderFactory;
//#endif


//#if 787960836
import javax.swing.JMenuItem;
//#endif


//#if 1738909237
import javax.swing.JPopupMenu;
//#endif


//#if -962596110
import javax.swing.border.Border;
//#endif


//#if 1630750265
import javax.swing.JOptionPane;
//#endif


//#if 390971881
public class GuiFieldPopupMenuListener implements
//#if 1799053009
    MouseListener
//#endif

    ,
//#if -996840014
    ActionListener
//#endif

{

//#if 1578256262
    protected GuiField field;
//#endif


//#if -783546073
    protected BoardManager boardManager;
//#endif


//#if 337558726
    @p.R4Feature(p.R4Feature.COLOR)
    private static final int EMPH_BORDER_THICKNESS = 4;
//#endif


//#if -1268554980
    @p.R4Feature(p.R4Feature.COLOR)
    Border oldBorder;
//#endif


//#if 1889925101
    public GuiFieldPopupMenuListener(GuiField field, BoardManager bM)
    {

//#if -777489366
        this.field = field;
//#endif


//#if -1843546912
        this.boardManager = bM;
//#endif

    }

//#endif


//#if -1965680375
    protected JPopupMenu createPopupMenu()
    {

//#if -173651235
        JPopupMenu m = new JPopupMenu();
//#endif


//#if -525515594
        JMenuItem mi;
//#endif


//#if 1688565854
        boolean done = false;
//#endif


//#if 1164837451
        if(p.R4Feature.SOLVER) { //1

//#if 641869748
            done = true;
//#endif


//#if -706582759
            for (int i = 0; i < boardManager
                    .getField(Structure.BOX, field.getBoxIndex(),
                              field.getFieldIndex()).getRemainingPos().size(); i++)
                // #if SOLVER
                //1
            {

//#if 9532804
                mi = new JMenuItem(String.valueOf(boardManager
                                                  .getField(Structure.BOX, field.getBoxIndex(),
                                                          field.getFieldIndex()).getRemainingPos().get(i)));
//#endif


//#if 138780806
                mi.addActionListener(this);
//#endif


//#if -1072943857
                m.add(mi);
//#endif

            }

//#endif

        }

//#endif


//#if 1967934579
        if(!done) { //1

//#if 897058547
            for (int i = 0; i < Field.POSSIBILITIES; i++) { //1

//#if -633299240
                mi = new JMenuItem(String.valueOf(i + 1));
//#endif


//#if 2086758745
                mi.addActionListener(this);
//#endif


//#if -1375225892
                m.add(mi);
//#endif

            }

//#endif

        }

//#endif


//#if -1623205967
        return m;
//#endif

    }

//#endif


//#if 2138654382
    public void actionPerformed(ActionEvent arg0)
    {

//#if 500689518
        boolean done = false;
//#endif


//#if -200663493
        if(p.R4Feature.SOLVER) { //1

//#if 1006260940
            done = true;
//#endif


//#if 667193606
            if(!boardManager.trySetField(Structure.BOX, field.getBoxIndex(),
                                         field.getFieldIndex(),
                                         new Field(Integer.parseInt(arg0.getActionCommand())))) { //1

//#if 521715808
                JOptionPane.showMessageDialog(null,
                                              "Invalid state reached! Last action was undone.");
//#endif

            }

//#endif

        }

//#endif


//#if -645821821
        if(!done) { //1

//#if -864760548
            boardManager.setField(Structure.BOX, field.getBoxIndex(),
                                  field.getFieldIndex(),
                                  new Field(Integer.parseInt(arg0.getActionCommand())));
//#endif

        }

//#endif

    }

//#endif


//#if -1660686129
    public void mouseReleased(MouseEvent arg0)
    {
    }
//#endif


//#if 790324553
    public void mouseEntered(MouseEvent arg0)
    {

//#if 317169808
        if(p.R4Feature.COLOR) { //1

//#if -1189799500
            if(!boardManager.getField(Structure.BOX, field.getBoxIndex(),
                                      field.getFieldIndex()).isInitialSet()) { //1

//#if -675956236
                oldBorder = field.getBorder();
//#endif


//#if -96442818
                field.setBorder(BorderFactory.createLineBorder(Color.ORANGE,
                                EMPH_BORDER_THICKNESS));
//#endif

            }

//#endif

        }

//#endif

    }

//#endif


//#if -1808934919
    public void mouseClicked(MouseEvent arg0)
    {

//#if 516307709
        if(!boardManager.getField(Structure.BOX, field.getBoxIndex(),
                                  field.getFieldIndex()).isInitialSet()) { //1

//#if 1480795512
            createPopupMenu().show(arg0.getComponent(), arg0.getX(),
                                   arg0.getY());
//#endif

        }

//#endif

    }

//#endif


//#if -558725681
    public void mouseExited(MouseEvent arg0)
    {

//#if 2013527601
        if(p.R4Feature.COLOR) { //1

//#if 1095364879
            if(!boardManager.getField(Structure.BOX, field.getBoxIndex(),
                                      field.getFieldIndex()).isInitialSet()) { //1

//#if 550197228
                field.setBorder(oldBorder);
//#endif

            }

//#endif

        }

//#endif

    }

//#endif


//#if 887201268
    public void mousePressed(MouseEvent arg0)
    {
    }
//#endif

}

//#endif


//#endif

