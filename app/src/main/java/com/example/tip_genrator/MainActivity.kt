package com.example.tip_genrator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tip_genrator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.totalAmountPrint.visibility=View.INVISIBLE
        binding.tipAmountPrint.visibility=View.INVISIBLE
        binding.billAmountPrint.visibility=View.INVISIBLE
        binding.textView7.visibility=View.INVISIBLE
    }

    fun calculating_amount(view: View) {

         binding.totalAmountPrint.visibility=View.VISIBLE
         binding.tipAmountPrint.visibility=View.VISIBLE
         binding.billAmountPrint.visibility=View.VISIBLE
         binding.textView7.visibility=View.VISIBLE

         var s = binding.amountEntered.text.toString()
         var amount = s.toDouble()
         amount = String.format("%.3f", amount).toDouble()
         binding.billAmountPrint.text="Bill Amount :   ₹${amount}"

         var d = tip_amount()
         d = String.format("%.3f", d).toDouble()
        binding.tipAmountPrint.text="Tip Amount :    ₹${d}"


         var total = d+amount
        total = String.format("%.3f", total).toDouble()
         binding.totalAmountPrint.text= "Total Amount : ₹${total}"


    }
    fun tip_amount(): Double{
        val s = binding.amountEntered.text.toString()
        val amount = s.toDouble()
        val tipPer = when (binding.radioGroup.checkedRadioButtonId) {
            R.id.radioButton -> 0.20
            R.id.radioButton2 -> 0.15
            R.id.radioButton3-> 0.10
            else -> 0.05
        }

        var tip = amount*tipPer

        if (binding.switchTip.isChecked) {
            tip = kotlin.math.ceil(tip)
        }

        return tip
    }

    fun clear_all(view: View) {
        binding.totalAmountPrint.visibility=View.INVISIBLE
        binding.tipAmountPrint.visibility=View.INVISIBLE
        binding.billAmountPrint.visibility=View.INVISIBLE
        binding.textView7.visibility=View.INVISIBLE

        binding.amountEntered.text?.clear()
        binding.radioGroup.clearCheck()
        binding.switchTip.setChecked(false)

    }
}