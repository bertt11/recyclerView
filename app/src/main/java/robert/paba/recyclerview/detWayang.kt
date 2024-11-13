package robert.paba.recyclerview

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.squareup.picasso.Picasso

class detWayang : AppCompatActivity() {

    //10.03
    private lateinit var _ivFoto: ImageView
    private lateinit var _tvNama: TextView
    private lateinit var _tvDetail: TextView

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_det_wayang)

        //10.03
        _ivFoto = findViewById(R.id.ivFoto)
        _tvNama = findViewById(R.id.tvNama)
        _tvDetail = findViewById(R.id.tvDetail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //10.03
        val dataIntent = intent.getParcelableExtra<wayang>("kirimData", wayang::class.java)
        if (dataIntent != null) {
            Picasso.get()
                .load(dataIntent.foto)
                .into(_ivFoto)
            _tvNama.setText(dataIntent.nama)
            _tvDetail.setText(dataIntent.deskripsi)
        }
    }
}