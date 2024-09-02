package com.example.rideready.data
import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.rideready.models.Car
import com.example.rideready.navigation.ADD_CAR_URL
import com.example.rideready.navigation.ROUT_LOGIN
import com.example.rideready.navigation.VIEW_CAR_URL
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage


class CarViewModel(var navController: NavController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress: ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(ROUT_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadCar(name:String, brand:String, price:String, phone: String,filePath: Uri){
        val productId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Cars/$productId")
        progress.show()
        storageRef.putFile(filePath).addOnCompleteListener{
            progress.dismiss()
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var car= Car(name,brand,price,phone,imageUrl,productId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Cars/$productId")
                    databaseRef.setValue(car).addOnCompleteListener {
                        if (it.isSuccessful){
                            navController.navigate(VIEW_CAR_URL)
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }



    fun allCars(
        product: MutableState<Car>,
        products: SnapshotStateList<Car>):SnapshotStateList<Car>{
        progress.show()
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Cars")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                products.clear()
                for (snap in snapshot.children){
                    var retrievedProduct = snap.getValue(Car::class.java)
                    product.value = retrievedProduct!!
                    products.add(retrievedProduct)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return products
    }



    fun updateCar(productId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Cars/$productId")
        ref.removeValue()
        navController.navigate(ADD_CAR_URL)
    }


    fun deleteCar(productId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Cars/$productId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}