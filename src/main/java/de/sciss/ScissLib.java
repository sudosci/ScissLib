/*
 *  ScissLib.java
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

package de.sciss;

//import de.sciss.util.DefaultUnitTranslator;
//import de.sciss.util.Param;
//import de.sciss.util.ParamSpace;

//import java.io.File;
//import java.io.IOException;
//import de.sciss.io.AudioFile;

public class ScissLib
{
	private static final double VERSION	= 1.0;
	
	public static void main( String[] args )
	{
		System.err.println( "\nScissUtil v" + VERSION + "\n" +
		    				"(C)opyright 2004-2012 by Hanns Holger Rutz. All rights reserved.\n" +
		    				"Published under the GNU General Public License.\n\n" +
		    				"This is a library which is not meant to be executed by itself.\n\n" );
		
//		testAIFF();
//		testParam();
		System.exit( 1 );
	}

	/**
	 *	Returns the library's version.
	 *
	 *	@return	the current version of ScissUtil
	 */
	public static double getVersion()
	{
		return VERSION;
	}
	
//	private static void testAIFF()
//	{
//		try {
//			AudioFile.openAsRead( new File( "/Users/rutz/Kontur/cache/32AF4200.cache" ));
//		}
//		catch( IOException e1 ) {
//			e1.printStackTrace();
//		}
//	}
	
//	private static void testParam()
//	{
//		final Param p1 = new Param( 441, ParamSpace.spcTimeSmpsD.unit );
//		final DefaultUnitTranslator dtu = new DefaultUnitTranslator();
//		dtu.setLengthAndRate( 1234, 44100 );
//		final Param p2 = dtu.translate( p1, ParamSpace.spcTimeMillisD );
//		System.out.println( p2 );
//	}
}
