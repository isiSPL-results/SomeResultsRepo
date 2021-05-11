package org.argouml.notation;
import org.tigris.gef.undo.Memento;
public class NotationSettings  { 
private static final NotationSettings DEFAULT_SETTINGS =
        initializeDefaultSettings();
private NotationSettings parent;
private String notationLanguage;
private boolean showAssociationNames;
private boolean showAssociationNamesSet = false;
private boolean showVisibilities;
private boolean showVisibilitiesSet = false;
private boolean showPaths;
private boolean showPathsSet = false;
private boolean fullyHandleStereotypes;
private boolean fullyHandleStereotypesSet = false;
private boolean useGuillemets;
private boolean useGuillemetsSet = false;
private boolean showMultiplicities;
private boolean showMultiplicitiesSet = false;
private boolean showSingularMultiplicities;
private boolean showSingularMultiplicitiesSet = false;
private boolean showTypes;
private boolean showTypesSet = false;
private boolean showProperties;
private boolean showPropertiesSet = false;
private boolean showInitialValues;
private boolean showInitialValuesSet = false;
public boolean isShowMultiplicities()
    { 
if(showMultiplicitiesSet)//1
{ 
return showMultiplicities;
} 
else
if(parent != null)//1
{ 
return parent.isShowMultiplicities();
} 
return getDefaultSettings().isShowMultiplicities();
} 
public void setShowProperties(final boolean showem)
    { 
if(showProperties == showem && showPropertiesSet)//1
{ 
return;
} 
final boolean oldValid = showPropertiesSet;
Memento memento = new Memento() {
            public void redo() {
                showProperties = showem;
                showPropertiesSet = true;
            }

            public void undo() {
                showProperties = !showem;
                showPropertiesSet = oldValid;
            }
        };
doUndoable(memento);
} 
public void setShowTypes(final boolean showem)
    { 
if(showTypes == showem && showTypesSet)//1
{ 
return;
} 
final boolean oldValid = showTypesSet;
Memento memento = new Memento() {
            public void redo() {
                showTypes = showem;
                showTypesSet = true;
            }

            public void undo() {
                showTypes = !showem;
                showTypesSet = oldValid;
            }
        };
doUndoable(memento);
} 
public String getNotationLanguage()
    { 
if(notationLanguage == null)//1
{ 
if(parent != null)//1
{ 
return parent.getNotationLanguage();
} 
else
{ 
return Notation.DEFAULT_NOTATION;
} 
} 
return notationLanguage;
} 
public void setShowInitialValues(final boolean showem)
    { 
if(showInitialValues == showem && showInitialValuesSet)//1
{ 
return;
} 
final boolean oldValid = showInitialValuesSet;
Memento memento = new Memento() {
            public void redo() {
                showInitialValues = showem;
                showInitialValuesSet = true;
            }

            public void undo() {
                showInitialValues = !showem;
                showInitialValuesSet = oldValid;
            }
        };
doUndoable(memento);
} 
public boolean isShowAssociationNames()
    { 
if(showAssociationNamesSet)//1
{ 
return showAssociationNames;
} 
else
if(parent != null)//1
{ 
return parent.isShowAssociationNames();
} 
return getDefaultSettings().isShowAssociationNames();
} 
public boolean isFullyHandleStereotypes()
    { 
if(fullyHandleStereotypesSet)//1
{ 
return fullyHandleStereotypes;
} 
else
{ 
if(parent != null)//1
{ 
return parent.fullyHandleStereotypes;
} 
else
{ 
return getDefaultSettings().isFullyHandleStereotypes();
} 
} 
} 
public static NotationSettings getDefaultSettings()
    { 
return DEFAULT_SETTINGS;
} 
public void setFullyHandleStereotypes(boolean newValue)
    { 
fullyHandleStereotypes = newValue;
fullyHandleStereotypesSet = true;
} 
private void doUndoable(Memento memento)
    { 
memento.redo();
} 
public NotationSettings()
    { 
super();
parent = getDefaultSettings();
} 
public boolean setNotationLanguage(final String newLanguage)
    { 
if(notationLanguage != null
                && notationLanguage.equals(newLanguage))//1
{ 
return true;
} 
if(Notation.findNotation(newLanguage) == null)//1
{ 
return false;
} 
final String oldLanguage = notationLanguage;
Memento memento = new Memento() {
            public void redo() {
                notationLanguage = newLanguage;
                // TODO: We can't have a global "current" language
                // NotationProviderFactory2.setCurrentLanguage(newLanguage);
            }

            public void undo() {
                notationLanguage = oldLanguage;
                // TODO: We can't have a global "current" language
                // NotationProviderFactory2.setCurrentLanguage(oldLanguage);
            }
        };
doUndoable(memento);
return true;
} 
private static NotationSettings initializeDefaultSettings()
    { 
NotationSettings settings = new NotationSettings();
settings.parent = null;
settings.setNotationLanguage(Notation.DEFAULT_NOTATION);
settings.setFullyHandleStereotypes(false);
settings.setShowAssociationNames(true);
settings.setShowInitialValues(false);
settings.setShowMultiplicities(false);
settings.setShowPaths(false);
settings.setShowProperties(false);
settings.setShowSingularMultiplicities(true);
settings.setShowTypes(true);
settings.setShowVisibilities(false);
settings.setUseGuillemets(false);
return settings;
} 
public void setUseGuillemets(final boolean showem)
    { 
if(useGuillemets == showem && useGuillemetsSet)//1
{ 
return;
} 
final boolean oldValid = useGuillemetsSet;
Memento memento = new Memento() {
            public void redo() {
                useGuillemets = showem;
                useGuillemetsSet = true;
            }

            public void undo() {
                useGuillemets = !showem;
                useGuillemetsSet = oldValid;
            }
        };
doUndoable(memento);
} 
public NotationSettings(NotationSettings parentSettings)
    { 
this();
parent = parentSettings;
} 
public boolean isShowInitialValues()
    { 
if(showInitialValuesSet)//1
{ 
return showInitialValues;
} 
else
if(parent != null)//1
{ 
return parent.isShowInitialValues();
} 
return getDefaultSettings().isShowInitialValues();
} 
public boolean isShowProperties()
    { 
if(showPropertiesSet)//1
{ 
return showProperties;
} 
else
if(parent != null)//1
{ 
return parent.isShowProperties();
} 
return getDefaultSettings().isShowProperties();
} 
public void setShowAssociationNames(final boolean showem)
    { 
if(showAssociationNames == showem && showAssociationNamesSet)//1
{ 
return;
} 
final boolean oldValid = showAssociationNamesSet;
Memento memento = new Memento() {

            public void redo() {
                showAssociationNames = showem;
                showAssociationNamesSet = true;
            }

            public void undo() {
                showAssociationNames = !showem;
                showAssociationNamesSet = oldValid;
            }
        };
doUndoable(memento);
} 
public void setShowPaths(boolean showPaths)
    { 
this.showPaths = showPaths;
showPathsSet = true;
} 
public boolean isShowPaths()
    { 
if(showPathsSet)//1
{ 
return showPaths;
} 
else
if(parent != null)//1
{ 
return parent.isShowPaths();
} 
return getDefaultSettings().isShowPaths();
} 
public boolean isShowVisibilities()
    { 
if(showVisibilitiesSet)//1
{ 
return showVisibilities;
} 
else
if(parent != null)//1
{ 
return parent.isShowVisibilities();
} 
return getDefaultSettings().isShowVisibilities();
} 
public boolean isShowTypes()
    { 
if(showTypesSet)//1
{ 
return showTypes;
} 
else
if(parent != null)//1
{ 
return parent.isShowTypes();
} 
return getDefaultSettings().isShowTypes();
} 
public void setShowVisibilities(final boolean showem)
    { 
if(showVisibilities == showem && showVisibilitiesSet)//1
{ 
return;
} 
final boolean oldValid = showVisibilitiesSet;
Memento memento = new Memento() {
            public void redo() {
                showVisibilities = showem;
                showVisibilitiesSet = true;
            }

            public void undo() {
                showVisibilities = !showem;
                showVisibilitiesSet = oldValid;
            }
        };
doUndoable(memento);
} 
public boolean isShowSingularMultiplicities()
    { 
if(showSingularMultiplicitiesSet)//1
{ 
return showSingularMultiplicities;
} 
else
if(parent != null)//1
{ 
return parent.isShowSingularMultiplicities();
} 
return getDefaultSettings().isShowSingularMultiplicities();
} 
public boolean isUseGuillemets()
    { 
if(useGuillemetsSet)//1
{ 
return useGuillemets;
} 
else
if(parent != null)//1
{ 
return parent.isUseGuillemets();
} 
return getDefaultSettings().isUseGuillemets();
} 
public void setShowSingularMultiplicities(final boolean showem)
    { 
if(showSingularMultiplicities == showem
                && showSingularMultiplicitiesSet)//1
{ 
return;
} 
final boolean oldValid = showSingularMultiplicitiesSet;
Memento memento = new Memento() {
            public void redo() {
                showSingularMultiplicities = showem;
                showSingularMultiplicitiesSet = true;
            }

            public void undo() {
                showSingularMultiplicities = !showem;
                showSingularMultiplicitiesSet = oldValid;
            }
        };
doUndoable(memento);
} 
public void setShowMultiplicities(final boolean showem)
    { 
if(showMultiplicities == showem && showMultiplicitiesSet)//1
{ 
return;
} 
final boolean oldValid = showMultiplicitiesSet;
Memento memento = new Memento() {
            public void redo() {
                showMultiplicities = showem;
                showMultiplicitiesSet = true;
            }

            public void undo() {
                showMultiplicities = !showem;
                showMultiplicitiesSet = oldValid;
            }
        };
doUndoable(memento);
} 

 } 
