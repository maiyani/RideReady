package com.example.rideready.ui.theme.screens.rollsroyce

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rideready.R
import com.example.rideready.navigation.ROUT_CAR

@Composable
fun RollsRoyceScreen(navController: NavController){
    Column (modifier = Modifier.fillMaxSize()
        .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally){


        Spacer(modifier = Modifier.height(100.dp))

        Image(
            painter = painterResource(id = R.drawable.rolls),
            contentDescription = "home",
            modifier = Modifier
                .size(300.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop
        )


        Text(
            text = "RollsRoyce",
            fontSize = 60.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Black
        )

        Text(
            text = "Coming soon.................",
            fontSize = 30.sp
        )








    }




}



@Composable
@Preview(showBackground = true)
fun RollsRoyceScreenPreview(){
    RollsRoyceScreen(rememberNavController())
}