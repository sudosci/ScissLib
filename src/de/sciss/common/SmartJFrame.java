/*
 *  SmartJFrame.java
 *  de.sciss.common package
 *
 *  Copyright (c) 2004-2009 Hanns Holger Rutz. All rights reserved.
 *
 *	This software is free software; you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License
 *	as published by the Free Software Foundation; either
 *	version 2, june 1991 of the License, or (at your option) any later version.
 *
 *	This software is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *	General Public License for more details.
 *
 *	You should have received a copy of the GNU General Public
 *	License (gpl.txt) along with this software; if not, write to the Free Software
 *	Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *
 *	For further information, please contact Hanns Holger Rutz at
 *	contact@sciss.de
 *
 *
 *  Changelog:
 *		29-Jan-09	created
 */
package de.sciss.common;

import java.awt.GraphicsConfiguration;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JRootPane;

/**
 *  @author		Hanns Holger Rutz
 *  @version	0.73, 29-Jan-09
 */
public class SmartJFrame
extends JFrame
{
	private final boolean		screenMenuBar;
	private ContainerListener	barListener	= null;
	private JMenuBar			savedBar	= null;
	
	public SmartJFrame( boolean screenMenuBar )
	{
		super();
		this.screenMenuBar = screenMenuBar;
	}
	
	public SmartJFrame( GraphicsConfiguration gc, boolean screenMenuBar )
	{
		super( gc );
		this.screenMenuBar = screenMenuBar;
	}
	
	public SmartJFrame( String title, boolean screenMenuBar )
	{
		super( title );
		this.screenMenuBar = screenMenuBar;
	}

	public SmartJFrame( String title, GraphicsConfiguration gc, boolean screenMenuBar )
	{
		super( title, gc );
		this.screenMenuBar = screenMenuBar;
	}

	public void setJMenuBar( JMenuBar m )
	{
		if( screenMenuBar ) {
			super.setJMenuBar( m );
			return;
		}
		
		if( barListener == null ) {
			barListener = new ContainerListener() {
				public void componentAdded( ContainerEvent e )
				{
					checkMenuBar( e );
				}
			
				public void componentRemoved( ContainerEvent e )
				{
					checkMenuBar( e );
				}
			};
		} else if( savedBar != null ) {
			savedBar.removeContainerListener( barListener );
		}
		savedBar = m;
		
		if( m.getMenuCount() > 0 ) super.setJMenuBar( m );
		m.addContainerListener( barListener );
	}

	protected void checkMenuBar( ContainerEvent e )
	{
		final JMenuBar mb = (JMenuBar) e.getContainer();
		if( mb.getMenuCount() == 0 ) {
			if( getJMenuBar() == mb ) {
				super.setJMenuBar( null );
			}
		} else {
			if( getJMenuBar() == null ) {
				super.setJMenuBar( mb );
			}
		}
		final JRootPane rp = getRootPane();
		rp.revalidate();
		rp.repaint();
	}
}
