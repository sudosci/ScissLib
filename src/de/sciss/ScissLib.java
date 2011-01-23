package de.sciss;

//import de.sciss.util.DefaultUnitTranslator;
//import de.sciss.util.Param;
//import de.sciss.util.ParamSpace;

//import java.io.File;
//import java.io.IOException;
//import de.sciss.io.AudioFile;

public class ScissLib
{
	private static final double VERSION	= 0.14;
	
	public static void main( String[] args )
	{
		System.err.println( "\nScissUtil v" + VERSION + "\n" +
		    				"(C)opyright 2004-2011 by Hanns Holger Rutz. All rights reserved.\n" +
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
	public static final double getVersion()
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
