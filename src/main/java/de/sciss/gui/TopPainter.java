/*
 *  TopPainter.java
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

package de.sciss.gui;

import java.awt.Graphics2D;

/**
 *  Simple as that: paint something
 *  arbitrary on top of a hosting component
 *  See the implementing classes for examples.
 *
 *  @author		Hanns Holger Rutz
 *  @version	0.67, 02-Sep-04
 */
public interface TopPainter
{
    /**
     *	Paints something on top of a component's
     *	graphics context. Components offering
     *	adding and removal of top painters should
     *	state which flags and transforms are initially
     *	set for the context, e.g. if coordinates are
     *	already normalized or not. The top painter
     *	should undo any temporary changes to the graphics
     *	context's affine transform, paint and stroke.
     *
     *	@param	g	the graphics context to paint onto.
     */
    public void paintOnTop( Graphics2D g );
}