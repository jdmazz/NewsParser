import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewsWriter {
	public static NewsWriter getInstance(){
		return instance;
    }
	
	public void write(NewsData nd) throws IOException {
		try (FileWriter fw = new FileWriter(today + "-" + nd.headline() + ".txt")) {
			fw.write(nd.firstArticleUrl() + System.lineSeparator());
			fw.write(nd.title() + System.lineSeparator());
			for (String p : nd.content()) {
				fw.write(p + " ");
			}
	        fw.write(System.lineSeparator());
	        for (StrPair link : nd.links()) {
	        	if (!link.lh().equals("") && !link.rh().equals("")) {
	        		fw.write(link.lh() + "[" + link.rh() + "]" + System.lineSeparator());
	        	}
	        }
		}
	}
	
	private NewsWriter() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date dt = new Date();
		today = sdf.format(dt);
	}
	
	private static NewsWriter instance = new NewsWriter();
	private String today;
}
