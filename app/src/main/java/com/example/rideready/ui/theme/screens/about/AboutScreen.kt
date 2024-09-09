package com.example.rideready.ui.theme.screens.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize().background(Color.LightGray)) {
        TopAppBar(
            title = { Text(text = "About", fontFamily = FontFamily.Cursive)},
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Gray),
            navigationIcon = {
                IconButton(onClick = {  }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "menu", tint = Color.Black)
                }
            },


        )

        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Welcome to [Rideready] " +
                "– your ultimate destination for buying and selling cars with ease and confidence! " +
                "Our app is designed to transform the car-selling experience by providing a seamless, " +
                "user-friendly platform that connects buyers and sellers in a dynamic and efficient way.",
            color = Color.White,
            fontSize = 20.sp
        )
    }

    

}

@Composable
@Preview(showBackground = true)
fun AboutScreenPreview(){
    AboutScreen(rememberNavController())
}