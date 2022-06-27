package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log
var lastnum:Double=0.0
var saveop:Char=' '
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var res:Double?



    }

    fun btnaction(view: android.view.View) {
        var btnselect:Char=' '

        var textans=showans.text.toString()
        when(view.id){
            R.id.btn0->btnselect='0'
            R.id.btn1->btnselect='1'
            R.id.btn2->btnselect='2'
            R.id.btn3->btnselect='3'
            R.id.btn4->btnselect='4'
            R.id.btn5->btnselect='5'
            R.id.btn6->btnselect='6'
            R.id.btn7->btnselect='7'
            R.id.btn8->btnselect='8'
            R.id.btn9->btnselect='9'
            R.id.btnC->btnselect='C'
            R.id.btnDel->btnselect='x'
            R.id.btndiv->btnselect='/'
            R.id.btndot->btnselect='.'
            R.id.btnmul->btnselect='*'
            R.id.btnmod->btnselect='%'
            R.id.btnsum->btnselect='+'
            R.id.btnsub->btnselect='-'
            R.id.btneq->btnselect='='

        }
        if((btnselect >='0' && btnselect <='9')){
            showans.setText((showans.text.toString())+btnselect.toString())
        }
        else if(btnselect == 'C'){
            showans.setText("")
            lastnum=0.0
            saveop=' '
            showres.setText("")
        }
        else if(btnselect == 'x'){
            var cn=showans.text
            showans.setText("")
            for(n in 0..cn.length-2){
                showans.setText((showans.text.toString())+cn[n])
            }

        }
        else if(btnselect=='/'|| btnselect=='-'|| btnselect=='*'|| btnselect=='%'|| btnselect=='+'){
            if(saveop=='/'||saveop=='-'||saveop=='*'||saveop=='%'||saveop=='+'){
                if(saveop=='/'){
                    lastnum=lastnum/(showans.text.toString()).toDouble()
                    showres.setText(lastnum.toString())

                }else if(saveop=='+') {
                    lastnum = lastnum + (showans.text.toString()).toDouble()
                    showres.setText(lastnum.toString())
                }
                else if(saveop=='-') {
                    lastnum = lastnum - (showans.text.toString()).toDouble()
                    showres.setText(lastnum.toString())
                }
                else if(saveop=='%') {
                    lastnum = lastnum % (showans.text.toString()).toDouble()
                    showres.setText(lastnum.toString())
                }
                else if(saveop=='*') {
                    lastnum = lastnum * (showans.text.toString()).toDouble()
                    showres.setText(lastnum.toString())
                }
                saveop=btnselect
                showans.setText("")
            }else if(saveop==' '){
                lastnum=showans.text.toString().toDouble()
                saveop=btnselect
                showans.setText("")
                showres.setText(lastnum.toString())

            }

        }
        else if(btnselect == '.'){
            var checkdot=0
            var st=showans.text.toString()
            for(n in st){
                if(n=='.'){
                    checkdot++
                }
            }
            if(checkdot==0){
                showans.setText((showans.text.toString())+btnselect.toString())
            }
        }

        else if(btnselect == '='){
            if(saveop=='/'){
                lastnum=lastnum/(showans.text.toString()).toDouble()
                showres.setText(lastnum.toString())

            }else if(saveop=='+') {
                lastnum = lastnum + (showans.text.toString()).toDouble()
                showres.setText(lastnum.toString())
            }
            else if(saveop=='-') {
                lastnum = lastnum - (showans.text.toString()).toDouble()
                showres.setText(lastnum.toString())
            }
            else if(saveop=='%') {
                lastnum = lastnum % (showans.text.toString()).toDouble()
                showres.setText(lastnum.toString())
            }
            else if(saveop=='*') {
                lastnum = lastnum * (showans.text.toString()).toDouble()
                showres.setText(lastnum.toString())
            }
            saveop=' '
            showans.setText("")
        }


    }

}


