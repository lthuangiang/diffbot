package com.diffbot.api;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.json.JsonObject;
import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * Article.
 *
 * @author Giang Le (giang@thuangiang.com)
 * @version $Id$
 * @since 0.1
 * @see <a href="http://www.diffbot.com/dev/docs/#tab_article-api-v2">Article API (v2)</a>
 */
public interface Article extends JsonReadable {
    /**
     * Diffbot we're in.
     * @return Diffbot
     */
    @NotNull(message = "Diffbot is never NULL")
    Diffbot diffbot();

    /**
     * Smart article with extra features.
     */
    @ToString
    @EqualsAndHashCode(of = "article")
    final class Smart implements Article {
        /**
         * Encapsulated article.
         */
        private final transient Article article;

        /**
         * Public ctor.
         * @param art Article
         */
        public Smart(Article art) {
            this.article = art;
        }

        @Override
        public Diffbot diffbot() {
            return this.article.diffbot();
        }

        /**
         * Response type
         * @return String
         * @throws IOException if any error inside
         */
        public String type() throws IOException {
            return new SmartJson(this).text("type");
        }

        /**
         * Response icon
         * @return  Icon
         * @throws IOException if any error inside
         */
        public String icon() throws IOException {
            return new SmartJson(this).text("icon");
        }

        /**
         * Article title
         * @return Article title
         * @throws IOException  if any error inside
         */
        public String title() throws IOException {
            return new SmartJson(this).text("title");
        }

        /**
         * Article content
         * @return Article content
         * @throws IOException  if any error inside
         */
        public String text() throws IOException {
            return new SmartJson(this).text("text");
        }

        /**
         * Article language
         * @return Article language
         * @throws IOException  if any error inside
         */
        public String language() throws IOException {
            return new SmartJson(this).text("humanLanguage");
        }

        @Override
        public JsonObject json() throws IOException {
            return this.article.json();
        }
    }
}
