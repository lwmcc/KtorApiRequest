package com.mccarty.ktorapirequest.api

import com.mccarty.ktorapirequest.model.UrlParam
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol

interface ApiUrl {
    fun buildForecastUrl(protocol: URLProtocol, host: String, path: String, vararg params: UrlParam): URLBuilder
}