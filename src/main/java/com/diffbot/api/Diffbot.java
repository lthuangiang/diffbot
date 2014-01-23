package com.diffbot.api;

import com.rexsl.test.Request;

import javax.validation.constraints.NotNull;

/**
 * Diffbot client, starting point to the entire library.
 *
 * <p>This is how you start communicating with Diffbot API:
 *
 * <pre> Diffbot diffbot = new RtDiffbot(token);
 * Article article = diffbot.article("http://blog.diffbot.com/diffbots-new-product-api-teaches-robots-to-shop-online/");
 *
 * <p>The interfaces in this packages are trying to cover as much
 * as possible of Diffbot API.
 *
 *  @author Giang Le (giang@thuangiang.com)
 * @version $Id$
 * @since 0.1
 */
public interface Diffbot {
    /**
     * RESTful request, an entry point to the Github API.
     * @return Request
     */
    @NotNull(message = "request is never NULL")
    Request entry();

    /**
     * Get a article by url.
     * @param url The article URL
     * @return The article
     * @see <a href="http://www.diffbot.com/dev/docs/#tab_article-api-v2">Article API</a>
     */
    Article article(@NotNull(message = "url can't be NULL") String url);
    /**
     * API token
     * @return API token
     */
    @NotNull(message = "token is never NULL")
    String token();

    /**
     * API version
     * @return API version
     */
    @NotNull(message = "version is never NULL")
    String version();
}
