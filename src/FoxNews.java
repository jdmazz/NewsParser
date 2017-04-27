import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.IOException;

public class FoxNews {
	public static void main(String[] args) {
		NewsData nd = new NewsData("http://www.foxnews.com/");
		
		try {
			Document frontpage = Jsoup.connect(nd.frontpageUrl()).get();
			Elements headline = frontpage.getElementsByTag("h1");
			nd.setHeadline(headline.text());
			Element headlineUrl = headline.first().getElementsByTag("a").first();
			nd.setFirstArticleUrl(headlineUrl.attr("href"));
			Document firstArticle = Jsoup.connect(nd.firstArticleUrl()).get();
			Element title = firstArticle.getElementsByTag("h1").first();
			nd.setTitle(title.text());
			Element body = firstArticle.getElementsByTag("article").first();
	        	Elements paragraphs = body.getElementsByTag("p");
	        	nd.setContent(JSHelp.toStrArr(paragraphs));
	        	Elements links = body.getElementsByTag("a");
	        	nd.setLinks(JSHelp.toStrPairs(links));
			
			NewsWriter nw = NewsWriter.getInstance();
			try {
				nw.write(nd);
			} catch (IOException ex) {
				System.err.println("Sorry, we're unable to write the output file.");
			}
		} catch (IOException ex) {
			System.err.println("Sorry, we encountered an error reading this website.");
		}
	}
}
