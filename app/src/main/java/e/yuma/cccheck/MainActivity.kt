package e.yuma.cccheck

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.os.AsyncTask
import khttp.get

open class MyAsyncTask : AsyncTask<Void, Void, String>() {

    override fun doInBackground(vararg params: Void): String? {
        return null
    }

    override fun onPostExecute(text: String) {}
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        object : MyAsyncTask() {
            override fun doInBackground(vararg params: Void): String? {
                return getEthRate()
            }
            override fun onPostExecute(text: String) {
                val ethRate = findViewById<TextView>(R.id.ethRate)
                ethRate.setText(text)
            }
        }.execute()
    }
}

fun getEthRate(): String {
    var url : String = "https://lightning.bitflyer.jp/v1/getboard"
    return get(url).jsonObject.getString("mid_price")
}