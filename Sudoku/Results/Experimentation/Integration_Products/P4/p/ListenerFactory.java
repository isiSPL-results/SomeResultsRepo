package p;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
public class ListenerFactory
{
    protected BoardManager bm;
    @p.R4Feature(p.R4Feature.EXTENDED)

    public ActionListener getSetPossibilitiesListener()
    {
        return new SetPossibilitiesListener(bm);
    }
    @p.R4Feature(p.R4Feature.STATES)

    public ActionListener getLoadStateListener()
    {
        return new LoadStateListener(bm);
    }
    public ActionListener getLoadFileListener()
    {
        return new LoadFileListener(bm);
    }
    @p.R4Feature(p.R4Feature.UNDO)

    public ActionListener getUndoListener()
    {
        return new UndoListener(bm);
    }
    public ListenerFactory(BoardManager bm)
    {
        this.bm = bm;
    }
    public MouseListener getPopupMenuListener(GuiField field)
    {
        return new GuiFieldPopupMenuListener(field, bm);
    }
    @p.R4Feature(p.R4Feature.STATES)

    public ActionListener getSaveStateListener()
    {
        return new SaveStateListener(bm);
    }

}
