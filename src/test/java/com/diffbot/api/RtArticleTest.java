package com.diffbot.api;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Integration case for {@link RtArticle}.
 * @author Giang Le (giang@thuangiang.com)
 * @version $Id$
 * @since 0.1
 */
public class RtArticleTest {
    /**
     * RtArticle can fetch article content
     * @throws Exception if any issue inside
     */
    @Test
    public void article() throws Exception {
        final Diffbot diffbot = new RtDiffbot("1dffb02a0bcc76058a7bde502c081d2a", "v2");
        final Article article = diffbot.article("http://blog.diffbot.com/diffbots-new-product-api-teaches-robots-to-shop-online/");
        // see json response here
        //System.out.println(article.json().toString());
        MatcherAssert.assertThat(
            new Article.Smart(article).title(),
            Matchers.equalTo("Diffbot’s New Product API Teaches Robots to Shop Online")
        );
    }
}
