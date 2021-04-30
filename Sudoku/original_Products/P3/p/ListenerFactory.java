package p;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class ListenerFactory
{
    protected BoardManager bm;

    public ListenerFactory(BoardManager bm)
    {
        this.bm = bm;
    }

    public ActionListener getLoadFileListener()
    {
        return new LoadFileListener(bm);
    }

    public MouseListener getPopupMenuListener(GuiField field)
    {
        return new GuiFieldPopupMenuListener(field, bm);
    }

   // #if STATES
    @p.R4Feature(p.R4Feature.STATES)
    public ActionListener getSaveStateListener()
    {
        return new SaveStateListener(bm);
    }

    // #endif
   // #if STATES
    @p.R4Feature(p.R4Feature.STATES)
    public ActionListener getLoadStateListener()
    {
        return new LoadStateListener(bm);
    }

    // #endif
   // #if UNDO
    @p.R4Feature(p.R4Feature.UNDO)
    public ActionListener getUndoListener()
    {
        return new UndoListener(bm);
    }

    // #endif
   // #if SOLVER
//@    @p.R4Feature(p.R4Feature.SOLVER)
//@    public ActionListener getSolutionHintListener()
//@    {
//@        return new SolutionHintListener(bm);
//@    }
//@
    // #endif
   // #if GENERATOR
//@    @p.R4Feature(p.R4Feature.GENERATOR)
//@    public ActionListener getGenerateSudokuListener()
//@    {
//@        return new GenerateSudokuListener(bm);
//@    }
//@
    // #endif
   // #if EXTENDED
//@    @p.R4Feature(p.R4Feature.EXTENDED)
//@    public ActionListener getSetPossibilitiesListener()
//@    {
//@        return new SetPossibilitiesListener(bm);
//@    }
    // #endif
}
