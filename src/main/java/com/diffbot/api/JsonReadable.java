package com.diffbot.api;

import javax.json.JsonObject;
import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * JSON readable.
 *
 * @author Giang Le (giang@thuangiang.com)
 * @version $Id$
 * @since 0.1
 */
public interface JsonReadable {
    /**
     * Describe it in a JSON object.
     * @return JSON object
     * @throws java.io.IOException If there is any I/O problem
     */
    @NotNull(message = "JSON is never NULL")
    JsonObject json() throws IOException;

}
