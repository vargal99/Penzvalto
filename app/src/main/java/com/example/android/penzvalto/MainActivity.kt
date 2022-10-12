package com.example.android.penzvalto

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android.penzvalto.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSzamol.setOnClickListener {
            atvaltasok()
        }


    }

    //számolás
     fun atvaltasok(){
        val stringInTextField = binding.edtBrutto.text.toString()
        val cost = stringInTextField.toDoubleOrNull()

        //mező ellenőrzés
        if(cost == null)
        {
            binding.tvResult.text = "Üres mező!"
            return
        }

        //rádigombok beállítása
        val selectedId = binding.radioGroup.checkedRadioButtonId
        val tipPecentage = when(selectedId){
            R.id.radiFel-> 0.735
            R.id.radiKozp -> 0.560
            else  -> 0.234
        }
        //számolás
        val tip = cost * tipPecentage

        //érték átadása a text mezőnek
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
         if(binding.radiFel.isChecked || binding.radiKozp.isChecked || binding.radioAlt.isChecked){

             if (R.id.radiFel == selectedId) {
                 binding.tvResult.text = formattedTip
             }
             if (R.id.radiKozp == selectedId) {
                 binding.tvResult.text = formattedTip
             }
             if (R.id.radioAlt == selectedId) {
                 binding.tvResult.text = formattedTip
             }


         }else {
             Toast.makeText(this, "Kérlek add meg a végzettséget.", Toast.LENGTH_SHORT).show()
         }

    }
}