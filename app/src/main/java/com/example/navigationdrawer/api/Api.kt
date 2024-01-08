package com.example.navigationdrawer.api


import com.example.navigationdrawer.response.PostResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("posts")
    fun getPosts(): Call<ArrayList<PostResponse>>
}