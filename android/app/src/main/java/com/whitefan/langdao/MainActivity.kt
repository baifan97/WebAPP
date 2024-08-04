package com.whitefan.langdao

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.KeyEvent
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var webView: WebView? = null

    var weburl = "https://www.720yun.com/vr/5a3jzOhOsy5"
    //填写你的网页链接

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 隐藏状态栏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun initWebView(){
        webView = findViewById(R.id.webview)
        webView?.loadUrl(weburl)

        val webClient = object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return false
            }
        }

        //下面这些直接复制就好
        webView?.webViewClient=webClient

        var webSettings = webView!!.settings
        webSettings.javaScriptEnabled = true  // 开启 JavaScript 交互
//        webSettings.setAppCacheEnabled(true) // 启用或禁用缓存
//        webSettings.cacheMode = WebSettings.LOAD_DEFAULT // 只要缓存可用就加载缓存, 哪怕已经过期失效 如果缓存不可用就从网络上加载数据
//        webSettings.setAppCachePath(cacheDir.path) // 设置应用缓存路径

        // 缩放操作
        webSettings.setSupportZoom(false) // 支持缩放 默认为true 是下面那个的前提
        webSettings.builtInZoomControls = false // 设置内置的缩放控件 若为false 则该WebView不可缩放
        webSettings.displayZoomControls = false // 隐藏原生的缩放控件

        webSettings.blockNetworkImage = false // 禁止或允许WebView从网络上加载图片
        webSettings.loadsImagesAutomatically = true // 支持自动加载图片

        val wetSettings = webView!!.settings //允许Https+Http混用
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            wetSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            webSettings.safeBrowsingEnabled = false // 是否开启安全模式
        }

        webSettings.javaScriptCanOpenWindowsAutomatically = true // 支持通过JS打开新窗口
        webSettings.domStorageEnabled = true // 启用或禁用DOM缓存
        webSettings.setSupportMultipleWindows(true) // 设置WebView是否支持多窗口

        // 设置自适应屏幕, 两者合用
        webSettings.useWideViewPort = false  // 将图片调整到适合webview的大小
        webSettings.loadWithOverviewMode = true  // 缩放至屏幕的大小
        webSettings.allowFileAccess = true // 设置可以访问文件

        webSettings.setGeolocationEnabled(true) // 是否使用地理位置

        webView?.fitsSystemWindows = true
        webView?.setLayerType(View.LAYER_TYPE_HARDWARE,null)
        webView?.loadUrl(weburl)
    }

    private var isExit: Boolean = false

    //设置返回键的监听
    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK)
            exitBy2Click() //调用双击退出函数
        return false
    }

    fun exitBy2Click() {
        val handler = Handler()
        if ((!isExit)) {
            isExit = true
            Toast.makeText(this, "再按一次退出APP\n(*>.<*)", Toast.LENGTH_LONG).show()
            handler.postDelayed({ isExit = false }, 1000 * 2) //x秒后没按就取消
        } else {
            finish()
            System.exit(0)
        }
    }
}