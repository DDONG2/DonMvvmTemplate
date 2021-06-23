package com.example.donmvvmtemplate.model.vo

import java.io.Serializable

data class LocationResponseVO (var title : String? = null,
                               var location_type :String? = null,
                               var woeid: Int? = null,
                               var latt_long: String? = null) : Serializable

