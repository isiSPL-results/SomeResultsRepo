//    IteratorEnumeration.java 41 2010-04-03 20:04:12Z marcusvnac $
// Copyright (c) 2007 The Regents of the University of California. All
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

import java.util.Enumeration;
import java.util.Iterator;

/*
 * Adapter class to provide legacy Enumeration interface for more modern
 * Iterator. For use with GEF or other legacy API implementations.
 *
 * @param <T> type of object in Enumeration
 * @author Tom Morris <tfmorris@gmail.com>
 */
public class IteratorEnumeration<T> implements Enumeration<T>
{

    private Iterator<T> it;

    /*
     * Construct an Enumeration based on the given Iterator.
     *
     * @param iterator the iterator to be wrapped
     */
    public IteratorEnumeration(Iterator<T> iterator)
    {
        it = iterator;
    }

    public boolean hasMoreElements()
    {
        return it.hasNext();
    }

    public T nextElement()
    {
        return it.next();
    }


}
