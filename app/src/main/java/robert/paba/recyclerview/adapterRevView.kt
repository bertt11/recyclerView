package robert.paba.recyclerview

import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class adapterRevView (private val listWayang: ArrayList<wayang>) : RecyclerView.
    Adapter<adapterRevView.ListViewHolder> (){

        //10.03
    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data:wayang)

        fun delData(pos: Int)
    }

    fun setOnItemClickCallback (onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }




    //10.01

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            var _namaWayang = itemView.findViewById<TextView>(R.id.namaWayang)
            var _karakterWayang = itemView.findViewById<TextView>(R.id.karakterWayang)
            var _deskripsiWayang = itemView.findViewById<TextView>(R.id.deskripsiWayang)
            var _gambarWayang = itemView.findViewById<ImageView>(R.id.gambarWayang)

        //10.04
            var _btnHapus = itemView.findViewById<Button>(R.id.btnHapus)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler,parent , false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listWayang.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var wayang = listWayang[position]

        holder._namaWayang.setText(wayang.nama)
        holder._deskripsiWayang.setText(wayang.deskripsi)
        holder._karakterWayang.setText(wayang.karakter)
        Log.d("TEST", wayang.foto)
        Picasso.get()
            .load(wayang.foto)
            .into(holder._gambarWayang)

        //onclicklistener 10.02
        holder._gambarWayang.setOnClickListener {
//        Toast.makeText(holder.itemView.context,wayang.nama,Toast.LENGTH_LONG).show()
            //10.03
            onItemClickCallback.onItemClicked(listWayang[position])
        }

        //10.04
        holder._btnHapus.setOnClickListener{
            onItemClickCallback.delData(position)
        }
    }

}