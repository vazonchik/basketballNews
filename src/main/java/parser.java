import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class parser {
    private static Document getPage(){
        Document page = null;
        try {
            page = Jsoup.parse(new URL("https://www.slamdunk.ru/"), 3000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return page;
    }

    public static void main(String[] args) {
        System.out.println(getPage());
    }
}
