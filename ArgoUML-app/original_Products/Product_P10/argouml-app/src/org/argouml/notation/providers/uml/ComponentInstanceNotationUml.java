//    ComponentInstanceNotationUml.java 41 2010-04-03 20:04:12Z marcusvnac $
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.argouml.model.Model;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.providers.ComponentInstanceNotation;

/*
 * UML notation for a component instance.
 *
 * @author Michiel
 */
public class ComponentInstanceNotationUml extends ComponentInstanceNotation
{

    /*
     * The constructor.
     *
     * @param componentInstance the UML componentInstance
     */
    public ComponentInstanceNotationUml(Object componentInstance)
    {
        super(componentInstance);
    }

    /*
     * Parse a line of the form: "name : base-component".
     * <p>
     * The base-component part is a comma separated list of Components. <p>
     *
     * Note that stereotypes are not supported.
     *
     * {@inheritDoc}
     */
    public void parse(Object modelElement, String text)
    {
        // strip any trailing semi-colons
        String s = text.trim();
        if (s.length() == 0) {
            return;
        }
        if (s.charAt(s.length() - 1) == ';') {
            s = s.substring(0, s.length() - 2);
        }

        String name = "";
        String bases = "";
        StringTokenizer tokenizer = null;

        if (s.indexOf(":", 0) > -1) {
            name = s.substring(0, s.indexOf(":")).trim();
            bases = s.substring(s.indexOf(":") + 1).trim();
        } else {
            name = s;
        }

        tokenizer = new StringTokenizer(bases, ",");

        List<Object> classifiers = new ArrayList<Object>();
        Object ns = Model.getFacade().getNamespace(modelElement);
        if (ns != null) {
            while (tokenizer.hasMoreElements()) {
                String newBase = tokenizer.nextToken();
                Object cls = Model.getFacade().lookupIn(ns, newBase.trim());
                if (cls != null) {
                    classifiers.add(cls);
                }
            }
        }

        Model.getCommonBehaviorHelper().setClassifiers(modelElement,
                classifiers);
        Model.getCoreHelper().setName(modelElement, name);
    }

    /*
     * @see org.argouml.notation.providers.NotationProvider#getParsingHelp()
     */
    public String getParsingHelp()
    {
        return "parsing.help.fig-componentinstance";
    }

    /*
     * @see org.argouml.notation.providers.NotationProvider#toString(java.lang.Object, java.util.Map)
     */
    @SuppressWarnings("deprecation")
    @Deprecated
    public String toString(Object modelElement, Map args)
    {
        return toString(modelElement);
    }

    private String toString(Object modelElement)
    {
        String nameStr = "";
        if (Model.getFacade().getName(modelElement) != null) {
            nameStr = Model.getFacade().getName(modelElement).trim();
        }

        // construct bases string (comma separated)
        StringBuilder baseStr =
            formatNameList(Model.getFacade().getClassifiers(modelElement));
        if ((nameStr.length() == 0) && (baseStr.length() == 0)) {
            return "";
        }
        baseStr = new StringBuilder(baseStr.toString().trim());
        if (baseStr.length() < 1) {
            return nameStr.trim();
        }
        return nameStr.trim() + " : " + baseStr.toString();
    }

    @Override
    public String toString(Object modelElement, NotationSettings settings)
    {
        return toString(modelElement);
    }

}
