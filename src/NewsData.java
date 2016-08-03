public class NewsData {
	public NewsData(String frontpageUrl) {
		this.frontpageUrl = frontpageUrl;
	}
	
	public void setHeadline(String headline) { this.headline = headline.replaceAll("[^A-Za-z0-9. ]", ""); }
	public void setFirstArticleUrl(String firstArticleUrl) { this.firstArticleUrl = firstArticleUrl; }
	public void setTitle(String title) { this.title = title; }
	public void setContent(String[] content) { this.content = content; }
	public void setLinks(StrPair[] links) { this.links = links; }
	
	public String frontpageUrl() { return frontpageUrl; }
	public String headline() { return headline; }
	public String firstArticleUrl() { return firstArticleUrl; }
	public String title() { return title; }
	public String[] content() { return content; }
	public StrPair[] links() { return links; }
	
	private String frontpageUrl, headline, firstArticleUrl, title;
	private String[] content;
	private StrPair[] links;
}
