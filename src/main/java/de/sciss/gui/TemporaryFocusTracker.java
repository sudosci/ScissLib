/*
 *  TemporaryFocusTracker.java
 *  (de.sciss.gui package)
 *
 *  Copyright (c) 2004-2012 Hanns Holger Rutz. All rights reserved.
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
 *  Change log:
 *		24-Jan-10	extracted from AquaWindowBar
 */

package de.sciss.gui;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.text.JTextComponent;

import de.sciss.util.Disposable;

public class TemporaryFocusTracker
implements Disposable, ContainerListener, MouseListener, FocusListener, AncestorListener
{
	private static final boolean	DEBUG	= false;
	
	private final JFrame	jf;
	private Component		currentFocus	= null;
	
	public TemporaryFocusTracker( JFrame jf )
	{
		this.jf	= jf;
//		addContainer( jf.getContentPane() );
		jf.getRootPane().addAncestorListener( this );
	}
	
	public void dispose()
	{
		removeContainer( jf.getContentPane() );
		jf.getRootPane().removeAncestorListener( this );
	}
	
	private void addContainer( Container c )
	{
		for( int i = 0; i < c.getComponentCount(); i++ ) {
			addComponent( c.getComponent( i ));
		}
		c.addContainerListener( this );
		if( DEBUG ) System.err.println( "addContainerListener " + c.getClass().getName() + "(" + c.hashCode() + ")" );
	}

	private void removeContainer( Container c )
	{
		c.removeContainerListener( this );
		if( DEBUG ) System.err.println( "removeContainerListener " + c.getClass().getName() + "(" + c.hashCode() + ")" );
		for( int i = c.getComponentCount() - 1; i >= 0; i-- ) {
			removeComponent( c.getComponent( i ));
		}
	}
	
	private void addComponent( Component comp ) 
	{
		if( comp instanceof JTextComponent ) {
			addTextComponent( (JTextComponent) comp );
		} else if( (comp instanceof JPanel) || (comp instanceof Box) || (comp instanceof JTabbedPane) ) {
			addContainer( (Container) comp );
		} else if( comp instanceof JScrollPane ) {
			addScrollPane( (JScrollPane) comp );
		}
	}

	private void removeComponent( Component comp )
	{
		if( comp instanceof JTextComponent ) {
			removeTextComponent( (JTextComponent) comp );
		} else if( (comp instanceof JPanel) || (comp instanceof Box) || (comp instanceof JTabbedPane) ) {
			removeContainer( (Container) comp );
		} else if( comp instanceof JScrollPane ) {
			removeScrollPane( (JScrollPane) comp );
		}
	}
	
	private void addTextComponent( JTextComponent c )
	{
		c.addMouseListener( this );
		c.addFocusListener( this );
		if( DEBUG ) System.err.println( "addFocus/MouseListener " + c.getClass().getName() + "(" + c.hashCode() + ")" );
	}

	private void removeTextComponent( JTextComponent c )
	{
		c.removeMouseListener( this );
		c.removeFocusListener( this );
		if( DEBUG ) System.err.println( "removeFocus/MouseListener " + c.getClass().getName() + "(" + c.hashCode() + ")" );
	}

	private void addScrollPane( JScrollPane p )
	{
		final Component c = p.getViewport().getView();
		c.addMouseListener( this );
		c.addFocusListener( this );
		if( DEBUG ) System.err.println( "addFocus/MouseListener " + c.getClass().getName() + "(" + c.hashCode() + ")" );
	}

	private void removeScrollPane( JScrollPane p )
	{
		final Component c = p.getViewport().getView();
		c.removeMouseListener( this );
		c.removeFocusListener( this );
		if( DEBUG ) System.err.println( "removeFocus/MouseListener " + c.getClass().getName() + "(" + c.hashCode() + ")" );
	}

	public void componentAdded( ContainerEvent e )
	{
		if( DEBUG ) System.out.println( "componentAdded to " +e.getContainer().getClass().getName() + "(" + e.getContainer().hashCode() + ") : " + e.getChild().getClass().getName() + "(" + e.getChild().hashCode() + ") ");
		addComponent( e.getChild() );
	}

	public void componentRemoved( ContainerEvent e )
	{
		if( DEBUG ) System.out.println( "componentRemoved from " +e.getContainer().getClass().getName() + "(" + e.getContainer().hashCode() + ") : " + e.getChild().getClass().getName() + "(" + e.getChild().hashCode() + ") ");
		removeComponent( e.getChild() );
	}
	
	public void mousePressed( MouseEvent e )
	{
		final Component c = e.getComponent();
		
		jf.setFocusableWindowState( true );
		c.requestFocus();
		currentFocus = c;
	}
	
	public void mouseClicked( MouseEvent e ) { /* ignored */ }
	public void mouseEntered( MouseEvent e ) { /* ignored */ }
	public void mouseExited( MouseEvent e ) { /* ignored */ }
	public void mouseReleased( MouseEvent e ) { /* ignored */ }

	public void focusLost( FocusEvent e )
	{
		if( e.getComponent() == currentFocus ) {
			currentFocus = null;
			jf.setFocusableWindowState( false );
		}
	}

	public void focusGained( FocusEvent e )
	{
		currentFocus = e.getComponent();
	}
	
	public void ancestorAdded( AncestorEvent e )
	{
		if( DEBUG ) System.out.println( "ancestorAdded " + e.getAncestor().getClass().getName() + "(" + + e.getAncestor().hashCode() + ")" );
		addContainer( jf.getContentPane() );
	}
	
	public void ancestorRemoved( AncestorEvent e )
	{
		if( DEBUG ) System.out.println( "ancestorRemoved " + e.getAncestor().getClass().getName() + "(" + + e.getAncestor().hashCode() + ")" );
		removeContainer( jf.getContentPane() );
	}
	
	public void ancestorMoved( AncestorEvent e ) { /* ignored */ }
}
