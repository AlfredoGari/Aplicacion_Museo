package com.example.museo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.museo.databinding.ActivityListadoMuseoBinding

class ListadoMuseo : AppCompatActivity() {

    val listadofav = arrayListOf<ObjetoMuseo>(
        ObjetoMuseo("01","David", "Representa a la figura bíblica del David que acabó con el gigante Goliat con una honda", "https://m.media-amazon.com/images/I/61n6ifjM-oL._AC_UL400_.jpg"),
        ObjetoMuseo("02","Las señoritas de Avignon", "Picasso nos muestra en esta obra a cinco prostitutas barcelonesas y lo hace de un modo inédito hasta entonces: lo hace al estilo cubista.", "https://barnebys.imgix.net/https%3A%2F%2Fsubastareal.es%2Fincludes%2Fresize.aspx%3Fimg%3D%2Ffotos%2Fpablo-picasso-las-senoritas-de-avignon-4500-11636-1.jpg%26w%3D560?auto=format%2Ccompress&crop=0&cs=tinysrgb&fit=crop&h=400&ixlib=php-2.3.0&trim=auto&w=400&s=6be742e4e93123acabc8c00cada58406"),
        ObjetoMuseo("03","La noche estrellada", " La noche estrellada es una de las pinturas más reconocidas en la historia de la cultura occidental.  La vista es de la ventana de su dormitorio", "https://i.pinimg.com/originals/a5/76/b4/a576b4cc1eadab3b93dd1d7e4038e567.jpg"),
        ObjetoMuseo("04","La Gioconda", "Es una obra pictórica del polímata renacentista italiano Leonardo da Vinci. Fue adquirida por el rey Francisco I de Francia", "https://marcianosmx.com/wp-content/uploads/2012/10/mona-lisa.jpg"),
        ObjetoMuseo("05","El Guernica", "Fue inspirada en un feroz bombardeo sufrido por la ciudad del País Vasco el 26 de abril de 1937", "https://i1.wp.com/www.cromacultura.com/wp-content/uploads/2012/03/picasso.jpg?fit=400%2C400&ssl=1"),
        ObjetoMuseo("06","La persistencia de la memoria", "Es un cuadro del pintor español Salvador Dalí pintado en 1931. Realizado mediante la técnica del óleo sobre lienzo, es de estilo surrealista", "https://www.picclickimg.com/d/l400/pict/142260745410_/Reloj-Repisa-Derretido-Salvador-Dal%C3%AD-Decoraci%C3%B3n-Casa-Analogico.jpg"),
        ObjetoMuseo("1234567890","FMA IA-58 Pucará", "La Fuerza Aérea Argentina presentó a principios de 1968 los requerimientos al Área Material Córdoba para la construcción del IA-58 Pucará." , "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Argentina_Air_Force_FMA_IA-58A_Pucara_Lofting-1.jpg/600px-Argentina_Air_Force_FMA_IA-58A_Pucara_Lofting-1.jpg")
    )

    private lateinit var newArrayList : ArrayList<ObjetoMuseo>
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
        getdata(id)
  //      rv()
    }

 //   fun rv(){
 //       binding.rv.layoutManager = LinearLayoutManager(this)
 //       val adapter =MuseoAdapter(listadofav)
 //       binding.rv.adapter = adapter
 //   }
    private fun getdata(id: Int){
     var adapter = MyAdapter(listadofav)
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
}