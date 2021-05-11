package org.argouml.kernel;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import org.argouml.application.events.ArgoDiagramAppearanceEvent;
import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoNotationEvent;
import org.argouml.configuration.Configuration;
import org.argouml.configuration.ConfigurationKey;
import org.argouml.notation.Notation;
import org.argouml.notation.NotationName;
import org.argouml.notation.NotationProviderFactory2;
import org.argouml.notation.NotationSettings;
import org.argouml.uml.diagram.DiagramAppearance;
import org.argouml.uml.diagram.DiagramSettings;
import org.tigris.gef.undo.Memento;
import org.tigris.gef.undo.UndoManager;
public class ProjectSettings  { 
private DiagramSettings diaDefault;
private NotationSettings npSettings;
private boolean showExplorerStereotypes;
private String headerComment =
        "Your copyright and other header comments";
@Deprecated
    public String getHideBidirectionalArrows()
    { 
return Boolean.toString(getHideBidirectionalArrowsValue());
} 
@Deprecated
    public boolean getShowBoldNamesValue()
    { 
return diaDefault.isShowBoldNames();
} 
@Deprecated
    public int getDefaultStereotypeViewValue()
    { 
return diaDefault.getDefaultStereotypeViewInt();
} 
public DiagramSettings getDefaultDiagramSettings()
    { 
return diaDefault;
} 
@Deprecated
    public void setShowVisibility(final boolean showem)
    { 
if(npSettings.isShowVisibilities() == showem)//1
{ 
return;
} 
Memento memento = new Memento() {
            private final ConfigurationKey key = Notation.KEY_SHOW_VISIBILITY;

            public void redo() {
                npSettings.setShowVisibilities(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                npSettings.setShowVisibilities(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
doUndoable(memento);
} 
public NotationName getNotationName()
    { 
return Notation.findNotation(getNotationLanguage());
} 
@Deprecated
    public String getShowTypes()
    { 
return Boolean.toString(getShowTypesValue());
} 
@Deprecated
    public int getDefaultShadowWidthValue()
    { 
return diaDefault.getDefaultShadowWidth();
} 
public boolean setNotationLanguage(final String newLanguage)
    { 
if(getNotationLanguage().equals(newLanguage))//1
{ 
return true;
} 
if(Notation.findNotation(newLanguage) == null)//1
{ 
return false;
} 
final String oldLanguage = getNotationLanguage();
Memento memento = new Memento() {
            private final ConfigurationKey key = Notation.KEY_DEFAULT_NOTATION;

            public void redo() {
                npSettings.setNotationLanguage(newLanguage);
                NotationProviderFactory2.setCurrentLanguage(newLanguage);
                fireNotationEvent(key, oldLanguage, newLanguage);
            }

            public void undo() {
                npSettings.setNotationLanguage(oldLanguage);
                NotationProviderFactory2.setCurrentLanguage(oldLanguage);
                fireNotationEvent(key, newLanguage, oldLanguage);
            }
        };
doUndoable(memento);
return true;
} 
private void fireDiagramAppearanceEvent(ConfigurationKey key, int oldValue,
                                            int newValue)
    { 
fireDiagramAppearanceEvent(key, Integer.toString(oldValue), Integer
                                   .toString(newValue));
} 
@Deprecated
    public void setShowBoldNames(String showbold)
    { 
setShowBoldNames(Boolean.valueOf(showbold).booleanValue());
} 
public String getShowStereotypes()
    { 
return Boolean.toString(getShowStereotypesValue());
} 
@Deprecated
    public void setShowAssociationNames(final boolean showem)
    { 
if(npSettings.isShowAssociationNames() == showem)//1
{ 
return;
} 
Memento memento = new Memento() {
            private final ConfigurationKey key =
                Notation.KEY_SHOW_ASSOCIATION_NAMES;

            public void redo() {
                npSettings.setShowAssociationNames(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                npSettings.setShowAssociationNames(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
doUndoable(memento);
} 
@Deprecated
    public String getRightGuillemot()
    { 
return getUseGuillemotsValue() ? "\u00bb" : ">>";
} 
@Deprecated
    public String getShowAssociationNames()
    { 
return Boolean.toString(getShowAssociationNamesValue());
} 
@Deprecated
    public void setFontName(String newFontName)
    { 
String old = diaDefault.getFontName();
diaDefault.setFontName(newFontName);
fireDiagramAppearanceEvent(DiagramAppearance.KEY_FONT_NAME, old,
                                   newFontName);
} 
public boolean getUseGuillemotsValue()
    { 
return npSettings.isUseGuillemets();
} 
@Deprecated
    public void setShowTypes(String showem)
    { 
setShowTypes(Boolean.valueOf(showem).booleanValue());
} 
@Deprecated
    public void setDefaultShadowWidth(String width)
    { 
setDefaultShadowWidth(Integer.parseInt(width));
} 
public String getShowBoldNames()
    { 
return Boolean.toString(getShowBoldNamesValue());
} 
@Deprecated
    public String getLeftGuillemot()
    { 
return getUseGuillemotsValue() ? "\u00ab" : "<<";
} 
@Deprecated
    public void setShowProperties(final boolean showem)
    { 
if(npSettings.isShowProperties() == showem)//1
{ 
return;
} 
Memento memento = new Memento() {
            private final ConfigurationKey key =
                Notation.KEY_SHOW_PROPERTIES;

            public void redo() {
                npSettings.setShowProperties(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                npSettings.setShowProperties(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
doUndoable(memento);
} 
@Deprecated
    public boolean getShowAssociationNamesValue()
    { 
return npSettings.isShowAssociationNames();
} 
@Deprecated
    public void setShowMultiplicity(final boolean showem)
    { 
if(npSettings.isShowMultiplicities() == showem)//1
{ 
return;
} 
Memento memento = new Memento() {
            private final ConfigurationKey key = Notation.KEY_SHOW_MULTIPLICITY;

            public void redo() {
                npSettings.setShowMultiplicities(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                npSettings.setShowMultiplicities(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
doUndoable(memento);
} 
@Deprecated
    public int getFontSize()
    { 
return diaDefault.getFontSize();
} 
@Deprecated
    public boolean getShowTypesValue()
    { 
return npSettings.isShowTypes();
} 
@Deprecated
    public Font getFontPlain()
    { 
return diaDefault.getFontPlain();
} 
public boolean getShowStereotypesValue()
    { 
return showExplorerStereotypes;
} 
private void fireNotationEvent(
        ConfigurationKey key, int oldValue, int newValue)
    { 
fireNotationEvent(key, Integer.toString(oldValue),
                          Integer.toString(newValue));
} 
@Deprecated
    public void setDefaultShadowWidth(final int newWidth)
    { 
final int oldValue = diaDefault.getDefaultShadowWidth();
if(oldValue == newWidth)//1
{ 
return;
} 
Memento memento = new Memento() {
            private final ConfigurationKey key =
                Notation.KEY_DEFAULT_SHADOW_WIDTH;

            public void redo() {
                diaDefault.setDefaultShadowWidth(newWidth);
                fireNotationEvent(key, oldValue, newWidth);
            }

            public void undo() {
                diaDefault.setDefaultShadowWidth(oldValue);
                fireNotationEvent(key, newWidth, oldValue);
            }
        };
doUndoable(memento);
} 
@Deprecated
    public void setShowSingularMultiplicities(String showem)
    { 
setShowSingularMultiplicities(Boolean.valueOf(showem).booleanValue());
} 
public void setUseGuillemots(String showem)
    { 
setUseGuillemots(Boolean.valueOf(showem).booleanValue());
} 
@Deprecated
    public boolean getShowSingularMultiplicitiesValue()
    { 
return npSettings.isShowSingularMultiplicities();
} 
@Deprecated
    public boolean getShowPropertiesValue()
    { 
return npSettings.isShowProperties();
} 
@Deprecated
    public String getDefaultShadowWidth()
    { 
return Integer.valueOf(getDefaultShadowWidthValue()).toString();
} 
private void init(boolean value, ConfigurationKey key)
    { 
fireNotationEvent(key, value, value);
} 
@Deprecated
    public void setHideBidirectionalArrows(String hideem)
    { 
setHideBidirectionalArrows(Boolean.valueOf(hideem).booleanValue());
} 
@Deprecated
    public void setShowProperties(String showem)
    { 
setShowProperties(Boolean.valueOf(showem).booleanValue());
} 
@Deprecated
    public void setShowVisibility(String showem)
    { 
setShowVisibility(Boolean.valueOf(showem).booleanValue());
} 
@Deprecated
    public boolean getHideBidirectionalArrowsValue()
    { 
return !diaDefault.isShowBidirectionalArrows();
} 
private void fireDiagramAppearanceEvent(ConfigurationKey key,
                                            String oldValue, String newValue)
    { 
ArgoEventPump.fireEvent(new ArgoDiagramAppearanceEvent(
                                    ArgoEventTypes.DIAGRAM_FONT_CHANGED, new PropertyChangeEvent(
                                        this, key.getKey(), oldValue, newValue)));
} 
@Deprecated
    public void setShowAssociationNames(String showem)
    { 
setShowAssociationNames(Boolean.valueOf(showem).booleanValue());
} 
@Deprecated
    public void init()
    { 
init(true, Configuration.makeKey("notation", "all"));
fireDiagramAppearanceEvent(
            Configuration.makeKey("diagramappearance", "all"),
            0, 0);
} 
@Deprecated
    public String getShowProperties()
    { 
return Boolean.toString(getShowPropertiesValue());
} 
@Deprecated
    public String getShowSingularMultiplicities()
    { 
return Boolean.toString(getShowSingularMultiplicitiesValue());
} 
@Deprecated
    public boolean getShowInitialValueValue()
    { 
return npSettings.isShowInitialValues();
} 
@Deprecated
    public String getShowInitialValue()
    { 
return Boolean.toString(getShowInitialValueValue());
} 
public void setHeaderComment(String c)
    { 
headerComment = c;
} 
public String getHeaderComment()
    { 
return headerComment;
} 
private void fireNotationEvent(ConfigurationKey key, String oldValue,
                                   String newValue)
    { 
ArgoEventPump.fireEvent(new ArgoNotationEvent(
                                    ArgoEventTypes.NOTATION_CHANGED, new PropertyChangeEvent(this,
                                            key.getKey(), oldValue, newValue)));
} 
ProjectSettings()
    { 
super();
diaDefault = new DiagramSettings();
npSettings = diaDefault.getNotationSettings();
String notationLanguage =
            Notation.getConfiguredNotation().getConfigurationValue();
NotationProviderFactory2.setCurrentLanguage(notationLanguage);
npSettings.setNotationLanguage(notationLanguage);
diaDefault.setShowBoldNames(Configuration.getBoolean(
                                        Notation.KEY_SHOW_BOLD_NAMES));
npSettings.setUseGuillemets(Configuration.getBoolean(
                                        Notation.KEY_USE_GUILLEMOTS, false));
npSettings.setShowAssociationNames(Configuration.getBoolean(
                                               Notation.KEY_SHOW_ASSOCIATION_NAMES, true));
npSettings.setShowVisibilities(Configuration.getBoolean(
                                           Notation.KEY_SHOW_VISIBILITY));
npSettings.setShowMultiplicities(Configuration.getBoolean(
                                             Notation.KEY_SHOW_MULTIPLICITY));
npSettings.setShowInitialValues(Configuration.getBoolean(
                                            Notation.KEY_SHOW_INITIAL_VALUE));
npSettings.setShowProperties(Configuration.getBoolean(
                                         Notation.KEY_SHOW_PROPERTIES));
npSettings.setShowTypes(Configuration.getBoolean(
                                    Notation.KEY_SHOW_TYPES, true));
diaDefault.setShowBidirectionalArrows(!Configuration.getBoolean(
                Notation.KEY_HIDE_BIDIRECTIONAL_ARROWS, true));
showExplorerStereotypes = Configuration.getBoolean(
                                      Notation.KEY_SHOW_STEREOTYPES);
npSettings.setShowSingularMultiplicities(Configuration.getBoolean(
                    Notation.KEY_SHOW_SINGULAR_MULTIPLICITIES, true));
diaDefault.setDefaultShadowWidth(Configuration.getInteger(
                                             Notation.KEY_DEFAULT_SHADOW_WIDTH, 1));
diaDefault.setDefaultStereotypeView(Configuration.getInteger(
                                                ProfileConfiguration.KEY_DEFAULT_STEREOTYPE_VIEW,
                                                DiagramAppearance.STEREOTYPE_VIEW_TEXTUAL));
diaDefault.setFontName(
            DiagramAppearance.getInstance().getConfiguredFontName());
diaDefault.setFontSize(
            Configuration.getInteger(DiagramAppearance.KEY_FONT_SIZE));
} 
@Deprecated
    public void setShowInitialValue(String showem)
    { 
setShowInitialValue(Boolean.valueOf(showem).booleanValue());
} 
@Deprecated
    public String getDefaultStereotypeView()
    { 
return Integer.valueOf(getDefaultStereotypeViewValue()).toString();
} 
@Deprecated
    public String getShowMultiplicity()
    { 
return Boolean.toString(getShowMultiplicityValue());
} 
@Deprecated
    public void setGenerationOutputDir(@SuppressWarnings("unused") String od)
    { 
} 
@Deprecated
    public void setShowTypes(final boolean showem)
    { 
if(npSettings.isShowTypes() == showem)//1
{ 
return;
} 
Memento memento = new Memento() {
            private final ConfigurationKey key = Notation.KEY_SHOW_TYPES;

            public void redo() {
                npSettings.setShowTypes(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                npSettings.setShowTypes(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
doUndoable(memento);
} 
@Deprecated
    public void setFontSize(int newFontSize)
    { 
int old = diaDefault.getFontSize();
diaDefault.setFontSize(newFontSize);
fireDiagramAppearanceEvent(DiagramAppearance.KEY_FONT_SIZE, old,
                                   newFontSize);
} 
@Deprecated
    public Font getFontBoldItalic()
    { 
return diaDefault.getFontBoldItalic();
} 
@Deprecated
    public String getFontName()
    { 
return diaDefault.getFontName();
} 
@Deprecated
    public void setHideBidirectionalArrows(final boolean hideem)
    { 
if(diaDefault.isShowBidirectionalArrows() == !hideem)//1
{ 
return;
} 
Memento memento = new Memento() {
            private final ConfigurationKey key =
                Notation.KEY_HIDE_BIDIRECTIONAL_ARROWS;

            public void redo() {
                diaDefault.setShowBidirectionalArrows(!hideem);
                fireNotationEvent(key, !hideem, hideem);
            }

            public void undo() {
                diaDefault.setShowBidirectionalArrows(hideem);
                fireNotationEvent(key, hideem, !hideem);
            }
        };
doUndoable(memento);
} 
public void setShowStereotypes(final boolean showem)
    { 
if(showExplorerStereotypes == showem)//1
{ 
return;
} 
Memento memento = new Memento() {
            private final ConfigurationKey key = Notation.KEY_SHOW_STEREOTYPES;

            public void redo() {
                showExplorerStereotypes = showem;
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                showExplorerStereotypes = !showem;
                fireNotationEvent(key, showem, !showem);
            }
        };
doUndoable(memento);
} 
public NotationSettings getNotationSettings()
    { 
return npSettings;
} 
@Deprecated
    public void setShowMultiplicity(String showem)
    { 
setShowMultiplicity(Boolean.valueOf(showem).booleanValue());
} 
@Deprecated
    public String getShowVisibility()
    { 
return Boolean.toString(getShowVisibilityValue());
} 
public String getUseGuillemots()
    { 
return Boolean.toString(getUseGuillemotsValue());
} 
@Deprecated
    public Font getFont(int fontStyle)
    { 
return diaDefault.getFont(fontStyle);
} 
@Deprecated
    public void setShowInitialValue(final boolean showem)
    { 
if(npSettings.isShowInitialValues() == showem)//1
{ 
return;
} 
Memento memento = new Memento() {
            private final ConfigurationKey key =
                Notation.KEY_SHOW_INITIAL_VALUE;

            public void redo() {
                npSettings.setShowInitialValues(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                npSettings.setShowInitialValues(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
doUndoable(memento);
} 
public void setNotationLanguage(NotationName nn)
    { 
setNotationLanguage(nn.getConfigurationValue());
} 
public void setShowStereotypes(String showem)
    { 
setShowStereotypes(Boolean.valueOf(showem).booleanValue());
} 
@Deprecated
    public boolean getShowVisibilityValue()
    { 
return npSettings.isShowVisibilities();
} 
private void fireNotationEvent(ConfigurationKey key, boolean oldValue,
                                   boolean newValue)
    { 
fireNotationEvent(key, Boolean.toString(oldValue),
                          Boolean.toString(newValue));
} 
@Deprecated
    public boolean getShowMultiplicityValue()
    { 
return npSettings.isShowMultiplicities();
} 
@Deprecated
    public void setShowSingularMultiplicities(final boolean showem)
    { 
if(npSettings.isShowSingularMultiplicities() == showem)//1
{ 
return;
} 
Memento memento = new Memento() {
            private final ConfigurationKey key =
                Notation.KEY_SHOW_SINGULAR_MULTIPLICITIES;

            public void redo() {
                npSettings.setShowSingularMultiplicities(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                npSettings.setShowSingularMultiplicities(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
doUndoable(memento);
} 
@Deprecated
    public Font getFontBold()
    { 
return diaDefault.getFontBold();
} 
private void doUndoable(Memento memento)
    { 
if(UndoManager.getInstance().isGenerateMementos())//1
{ 
UndoManager.getInstance().addMemento(memento);
} 
memento.redo();
ProjectManager.getManager().setSaveEnabled(true);
} 
public String getNotationLanguage()
    { 
return npSettings.getNotationLanguage();
} 
public void setUseGuillemots(final boolean showem)
    { 
if(getUseGuillemotsValue() == showem)//1
{ 
return;
} 
Memento memento = new Memento() {
            private final ConfigurationKey key = Notation.KEY_USE_GUILLEMOTS;

            public void redo() {
                npSettings.setUseGuillemets(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                npSettings.setUseGuillemets(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
doUndoable(memento);
} 
@Deprecated
    public void setShowBoldNames(final boolean showem)
    { 
if(diaDefault.isShowBoldNames() == showem)//1
{ 
return;
} 
Memento memento = new Memento() {
            private final ConfigurationKey key = Notation.KEY_SHOW_BOLD_NAMES;

            public void redo() {
                diaDefault.setShowBoldNames(showem);
                fireNotationEvent(key, !showem, showem);
            }

            public void undo() {
                diaDefault.setShowBoldNames(!showem);
                fireNotationEvent(key, showem, !showem);
            }
        };
doUndoable(memento);
} 
@Deprecated
    public String getGenerationOutputDir()
    { 
return "";
} 
@Deprecated
    public void setDefaultStereotypeView(final int newView)
    { 
final int oldValue = diaDefault.getDefaultStereotypeViewInt();
if(oldValue == newView)//1
{ 
return;
} 
Memento memento = new Memento() {
            private final ConfigurationKey key =
                ProfileConfiguration.KEY_DEFAULT_STEREOTYPE_VIEW;

            public void redo() {
                diaDefault.setDefaultStereotypeView(newView);
                fireNotationEvent(key, oldValue, newView);
            }

            public void undo() {
                diaDefault.setDefaultStereotypeView(oldValue);
                fireNotationEvent(key, newView, oldValue);
            }
        };
doUndoable(memento);
} 
@Deprecated
    public Font getFontItalic()
    { 
return diaDefault.getFontItalic();
} 

 } 
