import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WashingtonPost {
	public static void main(String[] args) {
		NewsData nd = new NewsData("https://www.washingtonpost.com/");
		
		try {
			Document frontpage = Jsoup.connect(nd.frontpageUrl()).get();
			Element headline = frontpage.getElementsByAttributeValue("data-pb-field", "web_headline").first();
			nd.setHeadline(headline.text());
			nd.setFirstArticleUrl(headline.attr("href"));
			Document firstArticle = Jsoup.connect(nd.firstArticleUrl()).get();
			Element title = firstArticle.getElementsByAttributeValue("data-pb-field", "customFields.web_headline").first();
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

