package generic;

import java.io.File;
import java.io.IOException;

/**
 * Files is the class that will allow to create the files .eps and .pdf.
 *
 * @author Nuno Fialho EIC1 72910
 * @author Sandro Ferreira EIC1 72911
 * @author Duarte Pinto EIC1 73117
 */

public class Files {
	
	/**
	 * Function that create a .eps file
	 * 
	 * @param name
	 */

	public static void loadR(String name) {

		String[] params = new String[2];

		params[0] = "C:\\Program Files\\R\\R-3.5.0\\bin\\x64\\Rscript.exe";

		params[1] = "C:\\Users\\"+System.getProperty("user.name")+"\\git\\ES2-2018-EIC1-41\\experimentBaseDirectory\\Experiments" + name + "\\R\\HV.Boxplot.R";

		String[] envp = new String[1];

		envp[0] = "Path=C:\\Program Files\\R\\R-3.5.0\\bin\\x64";

		try {
			Process p = Runtime.getRuntime().exec(params, envp,
					new File("C:\\Users\\"+System.getProperty("user.name")+"\\git\\ES2-2018-EIC1-41\\experimentBaseDirectory\\Experiments" + name + "\\R"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * Function that create a .pdf file
	 * 
	 * @param name
	 */
	
	public static void loadTex(String name) {
	
		String[] params = new String[2];

		params[0] = "C:\\Program Files\\MiKTeX 2.9\\miktex\\bin\\x64\\pdflatex.exe";

		params[1] = "C:\\Users\\"+System.getProperty("user.name")+"\\git\\ES2-2018-EIC1-41\\experimentBaseDirectory\\Experiments" + name + "\\latex\\Experiments" + name + ".tex";

		String[] envp = new String[1];

		envp[0] = "Path=C:\\Program Files\\MiKTeX 2.9\\miktex\\bin\\x64";

		try {
			Process p = Runtime.getRuntime().exec(params, envp,
					new File("C:\\Users\\"+System.getProperty("user.name")+"\\git\\ES2-2018-EIC1-41\\experimentBaseDirectory\\Experiments" + name + "\\latex"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
