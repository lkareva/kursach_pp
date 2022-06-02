package wrappers

import kotlinext.js.jso
import org.khronos.webgl.ArrayBuffer
import org.w3c.files.Blob
import org.w3c.files.File
import ru.altmanea.edu.server.model.Config
import kotlin.js.Promise

@JsModule("cross-fetch")
@JsNonModule
external fun fetch(
    url: String,
    options: FetchOptions = definedExternally
): Promise<HTTPResult>

interface HTTPResult {
    fun json(): Promise<dynamic>
    fun text(): Promise<String>
    fun blob(): Promise<File>
    fun arrayBuffer(): Promise<Array<dynamic>>
}

external interface FetchOptions {
    var method: String
    var headers: dynamic
    var body: dynamic
    var responseType: String
}

fun fetchText(
    url: String,
    options: FetchOptions = jso()
) =
    fetch(url, options)
        .then { it.text() }
        .then {it}


fun fetchBlob(
    url: String,
    options: FetchOptions = jso()
) =
    fetch(url, options)
        .then { it.blob() }
        .then {it}
