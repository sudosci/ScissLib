/*
 *  AncestorAdapter.java
 *  (ScissLib)
 *
 *  Copyright (c) 2004-2016 Hanns Holger Rutz. All rights reserved.
 *
 *	This library is free software; you can redistribute it and/or
 *	modify it under the terms of the GNU Lesser General Public
 *	License as published by the Free Software Foundation; either
 *	version 2.1 of the License, or (at your option) any later version.
 *
 *	This library is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *	Lesser General Public License for more details.
 *
 *	You should have received a copy of the GNU Lesser General Public
 *	License along with this library; if not, write to the Free Software
 *	Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *
 *	For further information, please contact Hanns Holger Rutz at
 *	contact@sciss.de
 */

package de.sciss.app;

import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

/**
 *  In analogy to <code>ComponentAdapter</code>
 *  provides a stub class that implements
 *  the <code>AncestorListener</code> interface,
 *  so subclasses need to override only those
 *  methods they're interested in.
 *
 *  @author		Hanns Holger Rutz
 *  @version	0.11, 25-Feb-08
 *
 *  @see	java.awt.event.ComponentAdapter
 */
public class AncestorAdapter
implements AncestorListener
{
    public void ancestorAdded( AncestorEvent e ) { /* empty */ }
    public void ancestorRemoved( AncestorEvent e ) { /* empty */ }
    public void ancestorMoved( AncestorEvent e ) { /* empty */ }
}