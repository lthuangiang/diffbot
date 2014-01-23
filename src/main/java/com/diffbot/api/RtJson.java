package com.diffbot.api;

import com.rexsl.test.Request;
import com.rexsl.test.response.JsonResponse;
import com.rexsl.test.response.RestResponse;
import lombok.EqualsAndHashCode;
import javax.json.JsonObject;
import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Diffbot JSON item.
 *
 * @author Giang Le (giang@thuangiang.com)
 * @version $Id$
 * @since 0.1
 */
@EqualsAndHashCode(of = "request")
final class RtJson {

    /**
     * RESTful request.
     */
    private final transient Request request;

    /**
     * Public ctor.
     *
     * @param req Request
     */
    RtJson(final Request req) {
        this.request = req;
    }

    /**
     * Fetch JSON object.
     *
     * @return JSON object
     * @throws java.io.IOException If fails
     */
    public JsonObject fetch() throws IOException {
        return this.request.fetch()
                .as(RestResponse.class)
                .assertStatus(HttpURLConnection.HTTP_OK)
                .as(JsonResponse.class)
                .json().readObject();
    }

}

