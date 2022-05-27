package zoo.turquoise.zooappturquoise;

public class NewsArticle {
    private String title, url;

    public NewsArticle()
    {
        this.title = "Article introuvable";
        this.url = "https://www.cjoint.com/doc/20_12/JLFrj6Sanqu_image-not-found.png";
    }

    public NewsArticle(String title, String url)
    {
        this.title = title;
        this.url = url;
    }

    public  String getTitle(){ return title; }
    public  String getUrl(){ return url; }

    @Override
    public String toString()
    {
        return title;
    }
}