import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupRun {

	public static void main(String[] args) {      
		
		try {
			Document doc = Jsoup.connect("https://www.biblegateway.com/").get(); // connects
			
			// elements takes more than 1, element is only 1
			Elements texts = doc.select("div.votd-verse-component");
			
			for (Element text: texts) {
				String method = text.select("div.votd-box p").text(); 
				String title = texts.select("div.votd-box a[class]").text();
				System.out.println(method);
				System.out.println(title);
			}
			
		}catch (IOException e) { // catch IOException
			e.printStackTrace();
		}
		
	}

}
