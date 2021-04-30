package p;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
public class ListenerFactory  { 
protected BoardManager bm;
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
