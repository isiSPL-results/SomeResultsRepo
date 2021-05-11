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
    public ActionListener getLoadFileListener()
    {
        return new LoadFileListener(bm);
    }
    public ListenerFactory(BoardManager bm)
    {
        this.bm = bm;
    }
    public MouseListener getPopupMenuListener(GuiField field)
    {
        return new GuiFieldPopupMenuListener(field, bm);
    }

}
