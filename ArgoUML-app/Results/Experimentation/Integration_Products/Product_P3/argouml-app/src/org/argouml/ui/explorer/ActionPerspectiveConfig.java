package org.argouml.ui.explorer;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.argouml.application.helpers.ResourceLoaderWrapper;
import org.argouml.i18n.Translator;
public class ActionPerspectiveConfig extends AbstractAction
  { 
private static final long serialVersionUID = -708783262437452872L;
public void actionPerformed(ActionEvent ae)
    { 
PerspectiveConfigurator ncd = new PerspectiveConfigurator();
ncd.setVisible(true);
} 
public ActionPerspectiveConfig()
    { 
super(Translator.localize("action.configure-perspectives"),
              ResourceLoaderWrapper
              .lookupIcon("action.configure-perspectives"));
putValue(Action.SHORT_DESCRIPTION,
                 Translator.localize("action.configure-perspectives"));
} 

 } 
