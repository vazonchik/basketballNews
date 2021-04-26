import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class Parser {
    private static Document getPage(String url){
        Document page = null;
        try {
            page = Jsoup.parse(new URL(url), 6000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return page;
    }

    public static void main(String[] args) {
        Document page = getPage("https://www.slamdunk.ru/news/nba/");
        Elements mainNewsBlock = page.select("a[class=invisionNews_grid_item__snippet_desc]");

        for (int i = 0; i < mainNewsBlock.size(); i++) {
            System.out.println(
                    getPage(mainNewsBlock.get(i).absUrl("href"))
                    .select("div[class=ipsType_break ipsContained]")
                    .get(0)
                    .text());
        }


    }
}
