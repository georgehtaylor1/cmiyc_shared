package util;

public class Debug {

	public static void say( String _message ) {
	
		Exception exception = new Exception();
		
		int line = exception.getStackTrace()[1].getLineNumber();
		String methodName = exception.getStackTrace()[1].getMethodName(); methodName = ( methodName.equals( "<init>" ) ) ? "Constructor" : methodName;
		String className = exception.getStackTrace()[1].getClassName();
		
		String spaces = "     ";
		
		int spacesCount = 0;
		int lineCount = line;
		
		while( lineCount > 0 ) {
			lineCount /= 10;
			spacesCount++;
		}

		spaces = spaces.substring( 0, ( spaces.length() - spacesCount ) );
		
		System.out.print( "\n" + line + spaces + "- " + className + ": " + _message + " [::" + methodName + "];" );
		
	}
	
}
