package com.example.assigntask.model

import com.google.firebase.database.IgnoreExtraProperties


@IgnoreExtraProperties
data class UserCredential(
    var username: String?=null,
    var password:String?=null
)
