package com.nurgle.android.githubviewer

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType.*
import org.jetbrains.anko.*
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jetbrains.anko.sdk25.coroutines.*
import com.google.gson.Gson
import android.support.v7.widget.RecyclerView
import android.view.View

data class GitHubRepositoryInfo(val name: String) {
    class List : ArrayList<GitHubRepositoryInfo>()
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            var email = editText(){
                hint = "Enter login"
                inputType = TYPE_CLASS_TEXT
                backgroundColor = Color.WHITE
            }
            button("Search") {
                onClick { findRepo(login = email.text.toString()) }
            }
        }
    }

    private fun findRepo(login: CharSequence)
    {
        Thread(Runnable {
            val url = "https://api.github.com/users/$login/repos"
            val client = OkHttpClient()
            val request = Request.Builder()
                    .url(url)
                    .build()
            val response = client.newCall(request).execute()
            val responseText = response.body()!!.string()
            val repos = Gson().fromJson(responseText, GitHubRepositoryInfo.List::class.java)
            if(repos != null) {

                android.util.Log.d("Repos", repos.joinToString { it.name })
            }
            else
            {
                toast("Not found")
            }

        }).start()

    }

}
