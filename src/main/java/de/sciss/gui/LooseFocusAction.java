/*
 *  LooseFocusAction.java
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

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/**
 * 	@version	0.1, 03-Oct-07
 *	@author		Hanns Holger Rutz
 */
public class LooseFocusAction
extends AbstractAction
{
	private final JComponent c;
	
	public LooseFocusAction( JComponent c )
	{
		super();
		this.c	= c;
		c.getInputMap().put( KeyStroke.getKeyStroke( KeyEvent.VK_ESCAPE, 0 ), "lost" );
		c.getActionMap().put( "lost", this );
	}

	public void actionPerformed( ActionEvent e )
	{
		final JRootPane rp = SwingUtilities.getRootPane( c );
		if( rp != null ) rp.requestFocus();
	}
}