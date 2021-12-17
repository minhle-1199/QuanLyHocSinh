package com.example.quanlyhocsinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivityTHEM_MONHOC extends AppCompatActivity {

    EditText edt_ten;
    EditText edt_stc;

    Button btnSave;
    MonHocDAO monHocDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_them_monhoc);

        edt_ten = findViewById(R.id.edt_tenADD_mh);
        edt_stc = findViewById(R.id.edt_stcADD_mh);
        btnSave = findViewById(R.id.btnLUUADD_mh);

        monHocDAO = new MonHocDAO(MainActivityTHEM_MONHOC.this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonHoc monHoc = new MonHoc();
                String ten = edt_ten.getText().toString();
                int stc = Integer.parseInt(edt_stc.getText().toString());

                monHoc.setTen_mh(ten);
                monHoc.setSo_tinchi(stc);

                long kq = monHocDAO.addRow(monHoc);

                if(kq>0){
                    Toast.makeText(MainActivityTHEM_MONHOC.this, "THÊM THÀNH CÔNG", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivityTHEM_MONHOC.this,MainActivityMonHoc.class);
                    startActivity(intent);

                }else {
                    Toast.makeText(MainActivityTHEM_MONHOC.this, "THÊM THẤT BẠI", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}