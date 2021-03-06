//    PredicateGefWrapper.java 41 2010-04-03 20:04:12Z marcusvnac $
// Copyright (c) 1996-2008 The Regents of the University of California. All
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

package org.argouml.util;

/*
 * A Predicate which wraps an old style GEF predicate for compatibility during
 * the transition period.  <em>Not to be used for new implementations</em>.
 *
 * @author Tom Morris <tfmorris@gmail.com>
 * @deprecated for 0.27.3 by tfmorris.  Will be removed when no longer required
 * by CheckItem.
 */
@Deprecated
public class PredicateGefWrapper implements Predicate
{

    private org.tigris.gef.util.Predicate predicate;

    /*
     * Construct a new Predicate which evaluates the given GEF predication.
     *
     * @param gefPredicate predicate to be evaluated
     */
    public PredicateGefWrapper(org.tigris.gef.util.Predicate gefPredicate)
    {
        predicate = gefPredicate;
    }

    public boolean evaluate(Object object)
    {
        return predicate.predicate(object);
    }

    /*
     * @return the original GEF Predicate
     */
    public org.tigris.gef.util.Predicate getGefPredicate()
    {
        return predicate;
    }
}
