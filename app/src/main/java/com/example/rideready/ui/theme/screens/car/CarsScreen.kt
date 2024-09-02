package com.example.rideready.ui.theme.screens.car

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rideready.R

@Composable
fun CarScreen(navController: NavController){
    Column (modifier = Modifier
        .fillMaxSize()){
        Spacer(modifier = Modifier.height(50.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Hello, What type of car do you want?",
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold
            )

        }

        Spacer(modifier = Modifier.height(20.dp))


        //search bar
        var search by remember {
            mutableStateOf("") }
        OutlinedTextField(
            value = search,
            onValueChange = {search=it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            shape = CutCornerShape(5.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Search,
                contentDescription = "Search")
            },

        )
        //end of search bar
        Spacer(modifier = Modifier.height(20.dp))


        Row (
            modifier = Modifier .horizontalScroll(rememberScrollState())
                .padding(start = 20.dp, end = 20.dp)
        ) {
            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.size(width = 150.dp, height = 45.dp)
            ) {
                Text(text = "Mercedes", fontFamily = FontFamily.SansSerif)
            }
            Spacer(modifier = Modifier.width(40.dp))


            OutlinedButton(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.size(width = 150.dp, height = 45.dp)
            ) {
                Text(text = "Buggati", fontFamily = FontFamily.SansSerif)
            }

            Spacer(modifier = Modifier.width(40.dp))


            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(Color.DarkGray),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.size(width = 150.dp, height = 45.dp)

            ) {
                Text(text = "RollsRoyce", fontFamily = FontFamily.SansSerif)
            }

        }


        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .padding(start = 20.dp,)
                .horizontalScroll(rememberScrollState())
        ) {
            //CARD ONE

            Card(modifier = Modifier
                .height(180.dp)
                .width(200.dp)) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "home",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            //CARD END
            Spacer(modifier = Modifier.width(20.dp))

            //CARD TWO

            Card(modifier = Modifier
                .height(180.dp)
                .width(200.dp)) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "home",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            //CARD END TWO
            Spacer(modifier = Modifier.width(20.dp))

            //CARD THREE

            Card(modifier = Modifier
                .height(180.dp)
                .width(200.dp)) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "home",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            //CARD END THREE
            Spacer(modifier = Modifier.width(20.dp))

            //CARD FOUR

            Card(modifier = Modifier
                .height(180.dp)
                .width(200.dp)) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.img),
                        contentDescription = "home",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            //CARD END FOUR



        }





    }

}

@Composable
@Preview(showBackground = true)
fun CarScreenPreview(){
    CarScreen(rememberNavController())
}