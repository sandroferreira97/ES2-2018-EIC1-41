package generic;

import java.io.File;
import java.io.IOException;

public class Files {

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
