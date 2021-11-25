package com.example.museo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.museo.databinding.ActivityListadoMuseoBinding

class ListadoMuseo : AppCompatActivity() {

    private val worker: GetPostWorkerList = GetPostWorkerList(this)

    private lateinit var newArrayList : ArrayList<ObjetoMuseo>
    private lateinit var newArrayList2 : ArrayList<ObjetoMuseo>
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var binding: ActivityListadoMuseoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_museo)
        binding = ActivityListadoMuseoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id:Int
        id = intent.getSerializableExtra("id") as Int
        val objeto = ObjetoMuseo("01","David", " Representa a la figura bíblica del David que acabó con el gigante Goliat con una honda", "https://m.media-amazon.com/images/I/61n6ifjM-oL._AC_UL400_.jpg")
        newArrayList = arrayListOf<ObjetoMuseo>()
        newArrayList.add(objeto)
        newRecyclerView = findViewById(R.id.rv)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        callservice(this, id)
  //      rv()
    }

 //   fun rv(){
 //       binding.rv.layoutManager = LinearLayoutManager(this)
 //       val adapter =MuseoAdapter(listadofav)
 //       binding.rv.adapter = adapter
 //   }
    private fun getdata(id: Int, ArrayList: ArrayList<ObjetoMuseo>){
     var adapter = MyAdapter(ArrayList)
     newRecyclerView.adapter = adapter

     adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
         override fun onItemClick(position: Int, codigo: String) {
             val intent = Intent(this@ListadoMuseo, ItemMuseo::class.java)
             intent.putExtra("id",id)
             intent.putExtra("codigo",codigo)
             startActivity(intent)
         }


     })
  }

    private fun callservice(context: Context, id: Int){
        worker.doWork(object : ActionListenerCallbackList {
            override fun onActionSuccess(successMessage: item_list) {
                Log.i("Success", successMessage.toString())
                newArrayList2 = arrayListOf<ObjetoMuseo>()
                var idd: String
                var title: String
                var des: String
                var url: String
                var om: ObjetoMuseo
                var contador: Int
                contador = 0
                for(i in successMessage.items_list){
                    idd = successMessage.items_list[contador].id
                    title = successMessage.items_list[contador].title
                    des = successMessage.items_list[contador].descripcion
                    url = successMessage.items_list[contador].url
                    om = ObjetoMuseo(idd, title, des, url)
                    newArrayList2.add(om)
                    contador = contador + 1
                }
                binding.progressBar.visibility = View.GONE
                getdata(id, newArrayList2)
            }

            override fun onActionFailure(throwableError: Throwable) {
                Log.i("Failure", throwableError.message.toString())
            }

        })
    }

}