package com.example.fitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity(), View.OnClickListener, TextWatcher, View.OnLongClickListener {



    var contador = 0
    var limite = 20

    private var trofeo: ImageView? = null
    private var button: Button? = null
    private var button2: Button? = null
    private var laps: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        button2 = findViewById(R.id.Over) as Button
        button = findViewById(R.id.Go) as Button
        laps = findViewById(R.id.Laps)
        laps?.addTextChangedListener(this)
        trofeo = findViewById(R.id.trofeo) as ImageView
        button?.setOnLongClickListener(this)
        //
    }

    fun avanzar(v: View?){
        this.contador++
        if (contador == (limite-10)){
            laps?.text = contador.toString()
            Toast.makeText(this,"Faltan 10 vueltas",Toast.LENGTH_SHORT).show()
            trofeo?.setImageResource(R.drawable.celebracion)
            trofeo?.setVisibility(View.VISIBLE)

        }else if(contador == limite){
            laps?.text = contador.toString()
            Toast.makeText(this,"¡FELICIDADES!",Toast.LENGTH_SHORT).show()

            trofeo?.setImageResource(R.drawable.trofeo)
            trofeo?.setVisibility(View.VISIBLE)
            button?.setVisibility(View.INVISIBLE)
        }else{
            laps?.text = contador.toString()
            trofeo?.setVisibility(View.INVISIBLE)
        }
    }
    fun reinicio(v: View?){
        this.contador = 0
        laps?.text = this.contador.toString()
        button?.setVisibility(View.VISIBLE)
        trofeo?.setVisibility(View.INVISIBLE)
    }
    override fun onLongClick(v: View?): Boolean {
        val faltantes = (this.limite - contador).toString()
        Toast.makeText(this,faltantes,Toast.LENGTH_SHORT).show()
        return false
    }
    /*

    Esto lo puse y no iba a funcionar como queria y al borrarlo me daba un error
    y no sabia porque entonces mejor lo deje ahi jajaja el error dice esto:
    Class 'MainActivity'is not abstract and does not implement abstract member
    public abstract fun afterTextChanged(s: Editable?), Unit defined in android.text.TextWatcher

     */



    override fun afterTextChanged(s: Editable?) {


    }
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }
    override fun onClick(v: View?) {

    }


}


