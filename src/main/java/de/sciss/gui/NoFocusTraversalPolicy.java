/*
 *  NoFocusTraversalPolicy.java
 *  (ScissLib)
 *
 *  Copyright (c) 2004-2013 Hanns Holger Rutz. All rights reserved.
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

package de.sciss.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.Window;

/**
 *  This is 'no' focus policy because
 *  all requests for focus are
 *  blocked; this can be used
 *  as a Frame's or Dialog's
 *  policy during processing
 *  when the user shouldn't be
 *  able to cycle through virtually
 *  inactive gadgets.
 *
 *  @author		Hanns Holger Rutz
 *  @version	0.10, 20-May-05
 */
public class NoFocusTraversalPolicy
extends FocusTraversalPolicy
{
	/**
	 *  @return <code>null</code>, in order to block traversal
	 */
	public Component getComponentAfter( Container focusCycleRoot, Component aComponent )
	{
		return null;
	}

	/**
	 *  @return <code>null</code>, in order to block traversal
	 */
	public Component getComponentBefore( Container focusCycleRoot, Component aComponent )
	{
		return null;
	}

	/**
	 *  @return <code>null</code>, in order to block traversal
	 */
	public Component getFirstComponent( Container focusCycleRoot )
	{
		return null;
	}

	/**
	 *  @return <code>null</code>, in order to block traversal
	 */
	public Component getLastComponent( Container focusCycleRoot )
	{
		return null;
	}

	/**
	 *  @return <code>null</code>, in order to block traversal
	 */
	public Component getDefaultComponent( Container focusCycleRoot )
	{
		return null;
	}

	/**
	 *  @return <code>null</code>, in order to block traversal
	 */
	public Component getInitialComponent( Window window )
	{
		return null;
	}
}