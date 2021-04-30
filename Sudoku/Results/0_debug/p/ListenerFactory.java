
//#if 301753005 
// Compilation Unit of /ListenerFactory.java 
 

//#if 1707883421 
package p;
//#endif 


//#if -1166584934 
import java.awt.event.ActionListener;
//#endif 


//#if -213101927 
import java.awt.event.MouseListener;
//#endif 


//#if -2143196293 
public class ListenerFactory  { 

//#if 1557173476 
protected BoardManager bm;
//#endif 


//#if -376591586 

//#if 819129457 
@p.R4Feature(p.R4Feature.EXTENDED)
//#endif 


    public ActionListener getSetPossibilitiesListener()
    { 

//#if -974566423 
return new SetPossibilitiesListener(bm);
//#endif 

} 

//#endif 


//#if -1380798597 

//#if 1175034172 
@p.R4Feature(p.R4Feature.GENERATOR)
//#endif 


    public ActionListener getGenerateSudokuListener()
    { 

//#if 925333438 
return new GenerateSudokuListener(bm);
//#endif 

} 

//#endif 


//#if 783418086 

//#if -812500766 
@p.R4Feature(p.R4Feature.STATES)
//#endif 


    public ActionListener getLoadStateListener()
    { 

//#if -372192315 
return new LoadStateListener(bm);
//#endif 

} 

//#endif 


//#if -1074005457 

//#if -2077039434 
@p.R4Feature(p.R4Feature.SOLVER)
//#endif 


    public ActionListener getSolutionHintListener()
    { 

//#if -1968926816 
return new SolutionHintListener(bm);
//#endif 

} 

//#endif 


//#if 1247020177 
public ActionListener getLoadFileListener()
    { 

//#if -396758490 
return new LoadFileListener(bm);
//#endif 

} 

//#endif 


//#if 55979123 

//#if 1594776498 
@p.R4Feature(p.R4Feature.UNDO)
//#endif 


    public ActionListener getUndoListener()
    { 

//#if 1505901112 
return new UndoListener(bm);
//#endif 

} 

//#endif 


//#if -1795750669 
public ListenerFactory(BoardManager bm)
    { 

//#if 1650119495 
this.bm = bm;
//#endif 

} 

//#endif 


//#if 913685926 
public MouseListener getPopupMenuListener(GuiField field)
    { 

//#if -1635362988 
return new GuiFieldPopupMenuListener(field, bm);
//#endif 

} 

//#endif 


//#if -1914608273 

//#if -857112571 
@p.R4Feature(p.R4Feature.STATES)
//#endif 


    public ActionListener getSaveStateListener()
    { 

//#if 665225650 
return new SaveStateListener(bm);
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

