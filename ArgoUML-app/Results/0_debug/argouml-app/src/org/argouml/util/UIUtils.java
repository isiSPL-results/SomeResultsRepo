
//#if 1982629734 
// Compilation Unit of /UIUtils.java 
 

//#if 479187571 
package org.argouml.util;
//#endif 


//#if 1239869541 
import java.awt.event.ActionEvent;
//#endif 


//#if 2035669298 
import java.awt.event.KeyEvent;
//#endif 


//#if -1004711335 
import javax.swing.AbstractAction;
//#endif 


//#if -2105390594 
import javax.swing.JComponent;
//#endif 


//#if -1207813933 
import javax.swing.JDialog;
//#endif 


//#if 1004776177 
import javax.swing.JRootPane;
//#endif 


//#if 2026115022 
import javax.swing.KeyStroke;
//#endif 


//#if -2590197 
public class UIUtils  { 

//#if -1819298527 
private static final String ACTION_KEY_ESCAPE = "escapeAction";
//#endif 


//#if -1249636706 
public static void loadCommonKeyMap(final JDialog dialog)
    { 

//#if -155153956 
JRootPane rootPane = dialog.getRootPane();
//#endif 


//#if 120670196 
rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
             ACTION_KEY_ESCAPE);
//#endif 


//#if -1253097529 
rootPane.getActionMap().put(ACTION_KEY_ESCAPE, new AbstractAction() {
            private static final long serialVersionUID = 0;

            public void actionPerformed(ActionEvent evt) {
                dialog.dispose();
            }
        });
//#endif 

} 

//#endif 

 } 

//#endif 


//#endif 

