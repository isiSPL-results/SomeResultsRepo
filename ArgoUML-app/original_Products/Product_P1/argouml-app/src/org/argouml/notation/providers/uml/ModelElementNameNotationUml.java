//    ModelElementNameNotationUml.java 41 2010-04-03 20:04:12Z marcusvnac $
// Copyright (c) 2005-2008 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies.  This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason.  IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.

package org.argouml.notation.providers.uml;

import java.text.ParseException;
import java.util.Map;
import java.util.Stack;

import org.argouml.application.events.ArgoEventPump;
import org.argouml.application.events.ArgoEventTypes;
import org.argouml.application.events.ArgoHelpEvent;
import org.argouml.i18n.Translator;
import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.ModelElementNameNotation;

/*
 * Handles the notation of the name of a modelelement in UML,
 * ie a string on the format:<pre>
 *     [ &lt;&lt; stereotype &gt;&gt;] [+|-|#] [name]
 * </pre>
 *
 * @author mvw@tigris.org
 */
public class ModelElementNameNotationUml extends ModelElementNameNotation
{

    /*
     * The constructor.
     *
     * @param name the uml object
     */
    public ModelElementNameNotationUml(Object name)
    {
        super(name);
    }

    /*
     * @see org.argouml.notation.providers.NotationProvider#parse(java.lang.Object, java.lang.String)
     */
    public void parse(Object modelElement, String text)
    {
        try {
            NotationUtilityUml.parseModelElement(modelElement, text);
        } catch (ParseException pe) {
            String msg = "statusmsg.bar.error.parsing.node-modelelement";
            Object[] args = {
                pe.getLocalizedMessage(),
                Integer.valueOf(pe.getErrorOffset()),
            };
            ArgoEventPump.fireEvent(new ArgoHelpEvent(
                                        ArgoEventTypes.HELP_CHANGED, this,
                                        Translator.messageFormat(msg, args)));
        }
    }

    /*
     * @see org.argouml.notation.providers.NotationProvider#getParsingHelp()
     */
    public String getParsingHelp()
    {
        return "parsing.help.fig-nodemodelelement";
    }

    /*
     * @see org.argouml.notation.providers.NotationProvider#toString(java.lang.Object, java.util.Map)
     */
    public String toString(Object modelElement, Map args)
    {
        return toString(modelElement, isValue("fullyHandleStereotypes", args),
                        isValue("useGuillemets", args),
                        isValue("visibilityVisible", args),
                        isValue("pathVisible", args));
    }

    private String toString(Object modelElement, boolean handleStereotypes,
                            boolean useGuillemets, boolean showVisibility, boolean showPath)
    {
        String name = Model.getFacade().getName(modelElement);
        StringBuffer sb = new StringBuffer("");
        if (handleStereotypes) {
            sb.append(NotationUtilityUml.generateStereotype(modelElement, useGuillemets));
        }
        if (showVisibility) {
            sb.append(generateVisibility(modelElement));
        }
        if (showPath) {
            sb.append(NotationUtilityUml.generatePath(modelElement));
        }
        if (name != null) {
            sb.append(name);
        }
        return sb.toString();
    }

    /*
     * @param modelElement the UML element to generate for
     * @param args arguments that influence the generation
     * @return a string which represents the stereotypes
     * @deprecated for 0.27.3 by tfmorris.
     */
    @Deprecated
    protected String generateStereotypes(Object modelElement, Map args)
    {
        return NotationUtilityUml.generateStereotype(modelElement, args);
    }

    /*
     * @param modelElement the UML element to generate for
     * @param args arguments that influence the generation
     * @return a string which represents the path
     * @deprecated for 0.27.3 by tfmorris.
     */
    @Deprecated
    protected String generatePath(Object modelElement, Map args)
    {
        StringBuilder s = new StringBuilder();
        if (isValue("pathVisible", args)) {
            Object p = modelElement;
            Stack stack = new Stack();
            Object ns = Model.getFacade().getNamespace(p);
            while (ns != null && !Model.getFacade().isAModel(ns)) {
                stack.push(Model.getFacade().getName(ns));
                ns = Model.getFacade().getNamespace(ns);
            }
            while (!stack.isEmpty()) {
                s.append((String) stack.pop() + "::");
            }

            if (s.length() > 0 && !(s.lastIndexOf(":") == s.length() - 1)) {
                s.append("::");
            }
        }
        return s.toString();
    }

    /*
     * @param modelElement the UML element to generate for
     * @param args arguments that influence the generation
     * @return a string representing the visibility
     * @deprecated for 0.27.3 by tfmorris.
     */
    @Deprecated
    protected String generateVisibility(Object modelElement, Map args)
    {
        if (isValue("visibilityVisible", args)) {
            return generateVisibility(modelElement);
        } else {
            return "";
        }
    }

    private String generateVisibility(Object modelElement)
    {
        String s = NotationUtilityUml.generateVisibility2(modelElement);
        /* When nothing is generated: omit the space. */
        if (s.length() > 0) {
            s = s + " ";
        }
        return s;
    }

    @Override
    public String toString(Object modelElement, NotationSettings settings)
    {
        return toString(modelElement, settings.isFullyHandleStereotypes(),
                        settings.isUseGuillemets(), settings.isShowVisibilities(),
                        settings.isShowPaths());
    }

}
