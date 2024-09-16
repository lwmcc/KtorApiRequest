package com.mccarty.ktorapirequest.api

import com.mccarty.ktorapirequest.model.UrlParam
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.path

class ApiUrlHelper private constructor() {

    companion object: ApiUrl {
        override fun buildForecastUrl(
            protocol: URLProtocol,
            host: String,
            path: String,
            vararg params: UrlParam,
        ): URLBuilder {
            return URLBuilder().apply {
                this.protocol = protocol
                this.host = host
                this.path(path)

                params.forEach {
                    parameters.append(it.name, it.value)
                }
            }
        }
    }
}