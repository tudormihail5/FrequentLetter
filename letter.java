import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Exercise 
{
	public static void findLetter(BufferedInputStream input)
	{
		try
		{
			BufferedReader read = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
			String line = "";
			int i,pos = 0,maxi = 0;
			int[] letters = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
			while(line != null)
			{
				line = read.readLine();
				if(line != null)
				{
					line = line.toLowerCase();
					if(line.length() > 0 && line.charAt(0) >= 'a' && line.charAt(0) <= 'z')
						++letters[(int)line.charAt(0) - 97];
					for(i=0; i<line.length() - 1; ++i)
						if((line.charAt(i) == ' ' || line.charAt(i) == '\'' || line.charAt(i) == '_' || line.charAt(i) == '[' || line.charAt(i) == '{' || line.charAt(i) == '<' || line.charAt(i) == '"' || line.charAt(i) == '(') && line.charAt(i + 1) >= 'a' && line.charAt(i + 1) <= 'z')
							++letters[(int)line.charAt(i + 1) - 97];
				}
			}
			for(i=0; i<26; ++i)
				if(letters[i] > maxi)
				{
					maxi = letters[i];
					pos = i;
				}
			System.out.println((char)(pos + 97));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String[] args)
	{
		try
		{
			BufferedInputStream input = new BufferedInputStream(new URL("https://www.gutenberg.org/cache/epub/29364/pg29364.txt").openStream());
			findLetter(input);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
