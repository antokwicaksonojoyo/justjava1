package com.example.justjava1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    EditText namaEditText;
    String nama;
    EditText alamatEditText;
    String alamat;
    EditText noHpEditText;
    String nohp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void increment (View view) {
        quantity = quantity + 1;
        display(quantity);

    }

    public void decrement (View view) {
        if (quantity > 0){
            quantity = quantity - 1;
            display(quantity);
        }
    }

    public void submitOrder (View view) {
        CheckBox WarangkaCheckbox = (CheckBox) findViewById(R.id.warangka_checkbox);
        CheckBox minyakCendanaCheckbox = (CheckBox) findViewById(R.id.minyak_cendana_checkbox);
        CheckBox SingepCheckbox = (CheckBox) findViewById(R.id.singep_checkbox);
        namaEditText = (EditText) findViewById(R.id.name_field);
        alamatEditText = (EditText) findViewById(R.id.alamat_field);
        noHpEditText = (EditText) findViewById(R.id.hp_field);
        boolean hashWarangka = WarangkaCheckbox.isChecked();
        boolean hashMinyakCendana = minyakCendanaCheckbox.isChecked();
        boolean hashSingep = SingepCheckbox.isChecked();
        nama = namaEditText.getText().toString();
        alamat = alamatEditText.getText().toString();
        nohp = noHpEditText.getText().toString();
        int price = calculatePrice(hashWarangka, hashMinyakCendana, hashSingep);
        String priceMessage = "Jumlah yang dijamasi " + quantity + " bilah" +
                "\nWarangka : " + hashWarangka +
                "\nMinyak Cendana : " + hashMinyakCendana +
                "\nSingep : " + hashSingep +
                "\nTotal pembelian Rp " + price +
                "\nMatursalangkung, Kurir Kami Akan Mengambil Barang Sesuai Aplikasi  : \n"
                 + nama
                 + alamat
                 + nohp;
        displayMessage (priceMessage);
    }

    private int calculatePrice(boolean addhashWarangka, boolean addhashMinyakCendana, boolean addhashSingep) {
        int basePrice = 50000;
        int price = 0;
        if (addhashWarangka) {
            basePrice = basePrice + 250000;
        }
        if(addhashMinyakCendana){
            basePrice = basePrice + 75000;
        }
        if (addhashSingep){
            basePrice = basePrice + 15000;
        }
        return price = quantity * basePrice;
    }

    public void submitReset (View view) {
        if (quantity == quantity){
            quantity = 0;
        };
        display(quantity);
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private void display (int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText ("" + number);
    }
    private void displayPrice (int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format (number));
    }
}