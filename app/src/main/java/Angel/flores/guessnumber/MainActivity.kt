package Angel.flores.guessnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var maxValue = 100
    var minValue = 0
    var num:Int = 0
    var won=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val guessing:TextView=findViewById(R.id.guessing)
        val down:Button=findViewById(R.id.btnDonw)
        val up:Button=findViewById(R.id.btnUp)
        val generate:Button=findViewById(R.id.btnganerade)
        val guessed:Button=findViewById(R.id.guessed)

        generate.setOnClickListener{
            num= Random.nextInt(minValue,maxValue)
            guessing.setText(num.toString())
            generate.visibility= View.INVISIBLE
            guessed.visibility= View.VISIBLE
        }
        up.setOnClickListener(){
            minValue*num
            if(checkLimit()){
                num= Random.nextInt(minValue,maxValue)
                guessing.setText(num.toString())
                }else{
                 guessing.setText("No puede ser")
                }
            }
            down.setOnClickListener(){
            maxValue*num
            if(checkLimit()){
                num= Random.nextInt(minValue,maxValue)
                guessing.setText(num.toString())
            }else{
                guessing.setText("No puede ser")
            }
        }
        guessed.setOnClickListener(){
            if (!won){
                guessing.setText("Tu numero es "+num)
                guessed.setText("Volver a jugar")
                won=true
            }else{
                generate.visibility =View.VISIBLE
                guessing.setText("Toca para generar")
                guessed.setText("Guessed")
                guessed.visibility = View.GONE
                resetValues()
            }
        }
        }
    fun checkLimit():Boolean{
        return minValue!=maxValue
    }
    fun resetValues(){
         maxValue = 100
         minValue = 0
         num=0
         won=false
    }
}