package com.diffbot.api;

import com.rexsl.test.Request;
import com.rexsl.test.request.ApacheRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

public final class RtDiffbot implements Diffbot {
    /**
     * Default request to start with.
     */
    private static final Request REQUEST =
            new ApacheRequest("http://api.diffbot.com")
                    .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);

    /**
     * REST request.
     */
    private final transient Request request;

    /**
     * diffbot token
     */
    private final transient String token;

    /**
     * API version
     */
    private final transient String version;

    /**
     * Public ctor
     * @param tok token
     * @param ver  version
     */
    public RtDiffbot(
        @NotNull(message = "token can't be NULL") final String tok,
        @NotNull(message = "version can't be NULL") final String ver) {
        this.request = RtDiffbot.REQUEST;
        this.token = tok;
        this.version = ver;
    }

    @Override
    public Request entry() {
        return this.request;
    }

    @Override
    public Article article(String url) {
        return new RtArticle(this, this.request.method (Request.GET).uri()
            .path("/v2/article")
            .queryParam("url", url)
            .queryParam("token", this.token)
            .back());
    }

    @Override
    public String token() {
        return this.token;
    }

    @Override
    public String version() {
        return this.version;
    }
}
