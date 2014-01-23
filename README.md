<img src="http://upload.wikimedia.org/wikipedia/en/thumb/4/4a/Diffbot_logo.jpg/240px-Diffbot_logo.jpg" />

More details are here: [diffbot.com](http://diffbot.com/products/)

Diffbot is a developer of machine learning and computer vision algorithms and public APIs for extracting data from web pages / web scraping

Set of classes in `com.diffbot.api` package is
an object oriented API of Diffbot:


```java
public class Main {
  public static void main(String[] args) {
    final GDiffbot diffbot = new RtDiffbot(".. your OAuth token ..", "..version..");
    final Article article = diffbot.article(".. url ..");
    System.out.println(new Article.Smart(article).title());
  }
}
```

