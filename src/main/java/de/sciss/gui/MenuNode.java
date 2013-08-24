/*
 *  MenuNode.java
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
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import de.sciss.app.AbstractWindow;

/**
 *  @author		Hanns Holger Rutz
 *  @version	0.70, 30-Aug-06
 */
public interface MenuNode
{
	public static final String	IDENTIFIER	= "de.sciss.gui.Identifier";	// Action key (expected value: a String)

	public JComponent create( AbstractWindow w );
	public void destroy( AbstractWindow w );
	public String getID();
	public void setEnabled( boolean b );
	public Action getAction();

	// ----------------- internal classes -----------------
	public static class DummyAction
	extends AbstractAction
	{
		protected DummyAction( String text )
		{
			super( text );
//			putValue( IDENTIFIER, id );
		}
		
		protected DummyAction( String text, KeyStroke stroke )
		{
			this( text );
			if( stroke != null ) putValue( ACCELERATOR_KEY, stroke );
		}
		
		public void actionPerformed( ActionEvent e ) { /* ignore */ }
	}
}