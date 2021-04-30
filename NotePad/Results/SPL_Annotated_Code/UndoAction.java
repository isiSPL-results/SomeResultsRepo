
//#if  Undo  
// Compilation Unit of /UndoAction.java 
 

//#if  Undo  
import java.awt.event.*;
//#endif 


//#if  Undo  
import javax.swing.*;
//#endif 


//#if  Undo  
import javax.swing.undo.*;
//#endif 

class UndoAction extends AbstractAction
  { 
private static final long serialVersionUID = 1;
Notepad notepad;
public UndoAction(Notepad notepad)
    { 
super( "Undo" );
putValue( Action.SMALL_ICON,
                  new ImageIcon( this.getClass().getResource( "images/undo.gif" ) ) );
setEnabled( false );
this.notepad = notepad;
} 

protected void update()
    { 
if(notepad.undo.canUndo())//1
{ 
setEnabled( true );
putValue( "Undo", notepad.undo.getUndoPresentationName() );
} 
else
{ 
setEnabled( false );
putValue( Action.NAME, "Undo" );
} 

} 

public void actionPerformed( ActionEvent e )
    { 
try //1
{ 
notepad.undo.undo();
} 

//#if  Undo  
catch ( CannotUndoException ex )//1
{ 
System.out.println( "Unable to undo: " + ex );
ex.printStackTrace();
} 

//#endif 


update();
notepad.redoAction.update();
} 

 } 


//#endif 

