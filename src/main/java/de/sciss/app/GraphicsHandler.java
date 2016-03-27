/*
 *  GraphicsHandler.java
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

import java.awt.Font;

public interface GraphicsHandler
{
    public static final int FONT_SYSTEM			= 0x000;
    public static final int FONT_BOLDSYSTEM		= 0x001;
    public static final int FONT_USER			= 0x002;
    public static final int FONT_LABEL			= 0x003;

    public static final int FONT_TYPE_MASK		= 0x0FF;

    public static final int FONT_MEDIUM			= 0x000;
    public static final int FONT_SMALL			= 0x100;
    public static final int FONT_MINI			= 0x200;

    public static final int FONT_SIZE_MASK		= 0xF00;

    public Font getFont( int type );
}
