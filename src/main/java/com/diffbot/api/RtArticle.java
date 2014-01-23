package com.diffbot.api;

import com.rexsl.test.Request;

import javax.json.JsonObject;
import java.io.IOException;

public final class RtArticle implements Article {
    /**
     * RESTful request.
     */
    private final transient Request request;

    private final transient Diffbot diffbot;

    public RtArticle (final Diffbot diff, final Request req) {
        this.request = req;
        this.diffbot = diff;
    }

    @Override
    public Diffbot diffbot() {
        return this.diffbot;
    }

    @Override
    public JsonObject json() throws IOException {
        return new RtJson(this.request).fetch();
    }
}
