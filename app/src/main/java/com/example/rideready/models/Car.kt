package com.example.rideready.models

class Car {

    var name:String = ""
    var brand:String = ""
    var price:String = ""
    var phone:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, brand: String, price: String,phone: String, imageUrl: String, id: String) {
        this.name = name
        this.brand = brand
        this.price = price
        this.phone = phone
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}