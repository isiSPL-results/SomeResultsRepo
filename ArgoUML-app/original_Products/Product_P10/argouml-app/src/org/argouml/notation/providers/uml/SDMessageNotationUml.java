//    SDMessageNotationUml.java 41 2010-04-03 20:04:12Z marcusvnac $
// Copyright (c) 2006-2009 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies. This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason. IN NO EVENT SHALL THE
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

import java.util.Map;

import org.argouml.notation.NotationProvider;
import org.argouml.notation.NotationSettings;
import org.argouml.notation.SDNotationSettings;

/*
 * The UML notation for a message, as shown on a sequence diagram.
 *
 * @author michiel
 */
public class SDMessageNotationUml extends AbstractMessageNotationUml
{

    /*
     * The constructor.
     *
     * @param message the UML object
     */
    public SDMessageNotationUml(Object message)
    {
        super(message);
    }

    /*
     * Generate a textual description for a Message m.
     * {@inheritDoc}
     * @see org.argouml.notation.NotationProvider#toString(Object, NotationSettings)
     */
    public String toString(final Object modelElement,
                           NotationSettings settings)
    {
        if (settings instanceof SDNotationSettings) {
            return toString(modelElement,
                            ((SDNotationSettings) settings).isShowSequenceNumbers());
        } else {
            return toString(modelElement, true);
        }
    }

    /*
     * Generates a textual description for a Message m.
     *
     * @see org.argouml.notation.providers.NotationProvider#toString(java.lang.Object,
     * java.util.Map)
     */
    @SuppressWarnings("deprecation")
    public String toString(final Object modelElement, final Map args)
    {
        return toString(modelElement,
                        !NotationProvider.isValue("hideSequenceNrs", args));
    }

}
