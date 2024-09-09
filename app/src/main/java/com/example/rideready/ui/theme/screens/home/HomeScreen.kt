package com.example.rideready.ui.theme.screens.home


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rideready.R
import com.example.rideready.navigation.ROUT_BMW
import com.example.rideready.navigation.ROUT_CAR
import com.example.rideready.navigation.ROUT_MERCEDES
import com.example.rideready.navigation.ROUT_ROLLSROYCE
import kotlinx.coroutines.launch
import androidx.compose.material3.IconButton as IconButton1

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavController){


    //Navigation Drawer

    val drawerState = rememberDrawerState(DrawerValue.Closed)

    val scope = rememberCoroutineScope()

    val menuList = listOf(
        Icons.Filled.Home to "Home" ,
        Icons.Filled.Favorite to "Contacts" ,
        Icons.Filled.Info to "History",
        Icons.Filled.Settings to "Settings",
        Icons.Filled.AccountCircle to "Profile"
    )

    var selectedItem by remember { mutableStateOf(-1) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerHeader()
                menuList.forEachIndexed { index, pair ->
                    NavigationDrawerItem(
                        label = {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                Icon(imageVector = pair.first, contentDescription = pair.second)
                                Spacer(modifier = Modifier.width(15.dp))
                                Text(text = pair.second)
                            }
                        },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index })
                }
            }
        }) {
        Scaffold(
            topBar = {

                TopAppBar(title = { Text(text = "Homepage") },
                    navigationIcon = {
                        IconButton1(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Filled.Menu, contentDescription = "")
                        }


                        IconButton(onClick = {  }) {
                                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "menu", tint = Color.Black)
                            }





                    },





                )


            }
        ) {


            //Main Content of the screen

            Column (modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(top = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally){

                Text(text = "This is the home page", fontSize = 20.sp)

                Text(
                    text = "RideReady",
                    fontSize = 20.sp
                )




                Spacer(modifier = Modifier.height(10.dp))


                Card (modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .height(200.dp)
                    .clickable {
                        navController.navigate(ROUT_CAR)
                    },

                ){
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp),
                        contentAlignment = Alignment.Center){

                        Image(painter = painterResource(id = R.drawable.img),
                            contentDescription ="home",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = "Bugatti",
                            fontSize = 40.sp,
                            color = Color.White,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center

                        )
                    }

                }


                Spacer(modifier = Modifier.height(10.dp))


                Card (modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .height(200.dp)
                    .clickable {
                        navController.navigate(ROUT_MERCEDES)
                    },){
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp),
                        contentAlignment = Alignment.Center){

                        Image(painter = painterResource(id = R.drawable.mercedes),
                            contentDescription ="home",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = "Mercerdes",
                            fontSize = 40.sp,
                            color = Color.White,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center

                        )
                    }

                }


                Spacer(modifier = Modifier.height(10.dp))


                Card (modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .height(200.dp)
                    .clickable {
                        navController.navigate(ROUT_ROLLSROYCE)
                    },){
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp),
                        contentAlignment = Alignment.Center){

                        Image(painter = painterResource(id = R.drawable.royce),
                            contentDescription ="home",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = "Rolls Royce",
                            fontSize = 40.sp,
                            color = Color.White,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center

                        )
                    }

                }




                Spacer(modifier = Modifier.height(10.dp))


                Card (modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
                    .height(200.dp)
                    .clickable {
                        navController.navigate(ROUT_BMW)
                    },){
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp),
                        contentAlignment = Alignment.Center){

                        Image(painter = painterResource(id = R.drawable.bmw),
                            contentDescription ="home",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            text = "BMW",
                            fontSize = 40.sp,
                            color = Color.White,
                            fontWeight = FontWeight.ExtraBold,
                            textAlign = TextAlign.Center

                        )
                    }

                }






            }

            //End of main contents
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "ABOUT US",
                fontSize = 40.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center

            )

        }


    }


}





@Composable
private fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Other")
    }
}


@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){

    HomeScreen(navController = rememberNavController())

}