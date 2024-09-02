package com.example.rideready.ui.theme.screens.checkout

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun CheckOutScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(400.dp)){
        Spacer(modifier = Modifier.height(40.dp))

        val mUrl = "https://maps.app.goo.gl/uPQMPHE3cq9XHP9cA"

        AndroidView(factory = {
            WebView(it).apply {
                settings.apply {
                    javaScriptEnabled=true
                }


                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                webViewClient = WebViewClient()
                loadUrl(mUrl)
            }

        }, update = { it.loadUrl(mUrl) })



    }



}


@Preview(showBackground = true)
@Composable
fun CheckOutScreenPreview() {
    CheckOutScreen(navController = rememberNavController())

}