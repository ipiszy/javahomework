import java.util.regex.*;
import java.io.*;
public class javahomework {
	public String readAll() throws Exception
	{
		FileReader r=new FileReader("bbsdoc[4].txt");
		BufferedReader reader=new BufferedReader(r);
		StringBuilder builder=new StringBuilder();
		String line;
		while((line=reader.readLine())!=null)
		{
			builder.append(line);
			builder.append("\n");
		}
		r.close();
		return builder.toString();
	}
	public static void main(String[] args)throws Exception
	{
		javahomework r=new javahomework();
		StringBuffer origin=new StringBuffer(r.readAll());
		origin.delete(0, origin.indexOf("<td>序号<td>状态<td>作者<td width=72>日期<td>标题")+"<td>序号<td>状态<td>作者<td width=72>日期<td>标题".length()+1);
		origin.delete(origin.indexOf("</table><hr>"),origin.length());
		//System.out.println(origin);
		
		String[] stringarray=origin.toString().split("<tr><td>");

		Pattern p1=Pattern.compile("(\\d+)<td>(.*)<td><.+>(.+)</a><td>(.+)<td><.+>(?:&nbsp;&nbsp;)*(.+) </a>.*");
		Pattern p2=Pattern.compile("<.+>\\[(.+)\\].+<td><td><.+>(.+)</a><td>(.+)<td><.+>(?:&nbsp;&nbsp;)*(.+) </a>.*");
		
		for (String temp: stringarray){
			System.out.println(temp);
			
			if (temp!=""){
				Matcher m1=p1.matcher(temp);
				if (m1.matches())
					for (int i=1;i<6;i++){
						System.out.print(m1.group(i));
						System.out.println();
					}
				else{
					Matcher m2=p2.matcher(temp);
					if (m2.matches())
						for (int i=1;i<5;i++){
							System.out.print(m2.group(i)+"   ");
							System.out.println();
						}
				}
			}
		}
		//System.out.println(r.readAll());
	}
}
