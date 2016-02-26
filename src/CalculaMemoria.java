import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CalculaMemoria {
	
	public static int doArquivo(String arquivo) throws IOException{
		
		int rtval = 0;
		
		BufferedReader in;
		String str;
		
		in = new BufferedReader( new FileReader(arquivo) );
		
		str = in.readLine();
		
		while( str != null )
		{
			if(str.length() > 0)
			{
				//IMPLEMENTAR PARSER
				
			}
			str = in.readLine();
		}
		in.close();
		return rtval;
	}

}
