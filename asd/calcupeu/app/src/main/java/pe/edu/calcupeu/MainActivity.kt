package pe.edu.calcupeu

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.GridView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow


class MainActivity : AppCompatActivity() {

    lateinit var txtVal1:EditText  //se pone lateinit para asignar un valor que después se va a definir su valor
    lateinit var txtVal2:EditText
    lateinit var lblResult: TextView
    var resultado:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.calc)

        txtVal1=findViewById(R.id.txtNum1)
        txtVal2=findViewById(R.id.txtNum2)
        lblResult=findViewById(R.id.lblResult)

        var buttons= arrayOf(R.id.btnSum,R.id.btnSub,R.id.btnMul,R.id.btnDiv,
            R.id.btnPote,R.id.btnRoot,R.id.btnDiv1,R.id.btnPi)

        for (b in buttons){
            var button=findViewById<Button>(b)
            button.setOnClickListener{operation(button)}
        }

        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
    }
    fun operation(view: View){
        var val1=txtVal1.text.toString()
        var val2=txtVal2.text.toString()
        when(view.id){
            R.id.btnSum->{
                resultado=(val1.toInt()+val2.toInt()).toString()
                lblResult.text=resultado
            }
            R.id.btnSub->{
                resultado=(val1.toInt()-val2.toInt()).toString()
                lblResult.text=resultado
            }
            R.id.btnMul->{
                resultado=(val1.toInt()*val2.toInt()).toString()
                lblResult.text=resultado
            }
            R.id.btnDiv->{
                resultado=(val1.toDouble()/val2.toDouble()).toString()
                lblResult.text=resultado
            }
            R.id.btnPote->{
                resultado=(Math.pow(val1.toDouble(),val2.toDouble())).toString()
                lblResult.text=resultado
            }
            R.id.btnRoot->{
                resultado=(Math.sqrt(val1.toDouble())).toString()
                lblResult.text=resultado
            }
            R.id.btnDiv1->{
                resultado=(1.0/val1.toDouble()).toString()
                lblResult.text=resultado
            }
            R.id.btnPi->{
                resultado=(Math.PI).toString()
                lblResult.text=resultado
            }
        }
    }
}