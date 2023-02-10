package com.senko.mycomposelear1.ui.components

import android.content.Context
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.*
import androidx.compose.ui.viewinterop.AndroidView
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@Composable
fun MyWebView() {
    val myWebViewState = rememberMyWebViewState(url = "https://www.google.com")
    myWebViewState.content
    AndroidView(factory = { context: Context ->
        WebView(context).apply {
            webViewClient = WebViewClient()
        }
    }) { webView ->
        webView.apply {
            settings.javaScriptEnabled = true
//            loadUrl("https://www.google.com")
            loadDataWithBaseURL(
                "",
                "<h1>Hello, world!</h1>",
                "text/html",
                "UTF-8",
                ""
            )
        }
    }

}

sealed class MyWebViewContent {
    data class Url(val url: String) : MyWebViewContent()
    data class Html(val baseUrl: String, val html: String) : MyWebViewContent()
}

class MyWebViewState(myWebViewContent: MyWebViewContent) {
    // 内容
    var content by mutableStateOf(myWebViewContent)

    var pageTitle: String? by mutableStateOf(null)
}

@Composable
fun rememberMyWebViewState(url: String) = remember(key1 = url) {
    MyWebViewState(MyWebViewContent.Url(url))
}

@Composable
fun rememberMyWebViewState(html: String, baseUrl: String) = remember(key1 = baseUrl, key2 = html) {
    MyWebViewState(MyWebViewContent.Html(baseUrl, html))
}