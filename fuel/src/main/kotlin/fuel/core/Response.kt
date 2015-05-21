package fuel.core

import org.apache.commons.io.IOUtils
import java.io.InputStream
import kotlin.properties.Delegates

/**
 * Created by Kittinun Vantasin on 5/13/15.
 */

public class Response {

    var httpStatusCode: Int by Delegates.notNull()
    var httpResponseMessage: String by Delegates.notNull()
    var httpResponseHeaders: Map<String, List<String>> by Delegates.notNull()

    var dataStream: InputStream? = null
    val data: ByteArray by Delegates.lazy {
        if (dataStream != null) IOUtils.toByteArray(dataStream) else ByteArray(0)
    }

    override fun toString(): String {
        return "Response: { StatusCode: $httpStatusCode, ResponseMessage: $httpResponseMessage }"
    }
}
