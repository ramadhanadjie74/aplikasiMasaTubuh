package com.example.aplikasimasatubuh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mEtBerat;
    private EditText mEtTinggi;
    private Button mBtnHitung;
    private TextView mTvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtBerat = findViewById(R.id.etBerat);
        mEtTinggi = findViewById(R.id.etTinggi);
        mBtnHitung = findViewById(R.id.btnHitung);
        mTvHasil = findViewById(R.id.tvHasil);

        mBtnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungIMT();
            }
        });
    }

    private void hitungIMT() {
        double berat = Double.parseDouble(mEtBerat.getText().toString());
        double tinggi = Double.parseDouble(mEtTinggi.getText().toString());
        double tingiDalamMeter = tinggi / 100.0;

        double imt = berat / (tingiDalamMeter * tingiDalamMeter);
        imt = Math.round(imt);

        String keterangan = "";
        if (imt <= 18.5) {
            keterangan = "Berat Badan Kurang";
        } else if (imt >= 18.5 && imt <= 22.9) {
            keterangan = "Berat Badan Normal";
        } else if (imt >= 23 && imt <= 29.9) {
            keterangan = "Berat Badan Berlebih (Kecenderungan Obesitas)";
        } else {
            keterangan = "Obesitas";
        }

        String hasil = "Nilai IMT adalah " + imt + " Yaitu " + keterangan;
        mTvHasil.setText(hasil);
    }
}



