package com.example.duapokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txtDiem;
    CheckBox cb1,cb2,cb3;
    SeekBar sk1,sk2,sk3;
    ImageButton ibtnPlay;
    int soDiem = 100;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        sk1.setEnabled(false);
        sk2.setEnabled(false);
        sk3.setEnabled(false);
        txtDiem.setText(soDiem+"");
        final CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                int number = 5;
                Random random = new Random();
                int one = random.nextInt(number);
                int two = random.nextInt(number);
                int three = random.nextInt(number);

                if(sk1.getProgress()>= sk1.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "cao win", Toast.LENGTH_SHORT).show();
                    if (cb1.isChecked()){
                        soDiem+= 10;
                        Toast.makeText(MainActivity.this,"Ban cuoc chinh xac",Toast.LENGTH_LONG).show();


                    }
                    else {
                        soDiem -= 10;
                        Toast.makeText(MainActivity.this,"Ban cuoc sai roi",Toast.LENGTH_LONG).show();


                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();


                }
                if(sk2.getProgress()>= sk2.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Meo  win", Toast.LENGTH_LONG).show();
                    if (cb2.isChecked()){
                        soDiem+= 10;
                        Toast.makeText(MainActivity.this,"Ban cuoc chinh xac",Toast.LENGTH_LONG).show();


                    }
                    else {
                        soDiem -= 10;
                        Toast.makeText(MainActivity.this,"Ban cuoc sai roi",Toast.LENGTH_LONG).show();


                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }
                if (sk3.getProgress()>= sk3.getMax()){
                    this.cancel();
                    ibtnPlay.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "Pikachu win", Toast.LENGTH_LONG).show();
                    if (cb3.isChecked()){
                        soDiem+= 10;
                        Toast.makeText(MainActivity.this,"Ban cuoc chinh xac",Toast.LENGTH_LONG).show();


                    }
                    else {
                        soDiem -= 10;
                        Toast.makeText(MainActivity.this,"Ban cuoc sai roi",Toast.LENGTH_LONG).show();


                    }
                    txtDiem.setText(soDiem + "");
                    EnableCheckBox();
                }

                sk1.setProgress(sk1.getProgress() + one);
                sk2.setProgress(sk2.getProgress() + two);
                sk3.setProgress(sk3.getProgress() + three);



            }

            @Override
            public void onFinish() {

            }
        };
        ibtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked()|| cb2.isChecked()|| cb3.isChecked()){
                    Toast.makeText(MainActivity.this,"ban da dat cuoc xong ",Toast.LENGTH_SHORT).show();
                    sk1.setProgress(0);
                    sk2.setProgress(0);
                    sk3.setProgress(0);
                    ibtnPlay.setVisibility(View.INVISIBLE);

                    countDownTimer.start();
                    DisableCheckBox();

                }
                else {
                    Toast.makeText(MainActivity.this,"vui long dat cuoc truoc khi choi ",Toast.LENGTH_SHORT).show();
                }

        }
        });
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if(b){
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }

            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b){
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }

            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b) {
                if (b){
                    cb1.setChecked(false);
                    cb2.setChecked(false);
                }

            }
        });
    }
    private  void EnableCheckBox(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);


    }
    private  void DisableCheckBox(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }
    private void Anhxa(){
        txtDiem = (TextView)findViewById(R.id.textViewDiemSo);
        cb1     = (CheckBox)findViewById(R.id.checkbox1);
        cb2     = (CheckBox)findViewById(R.id.checkbox2);
        cb3     = (CheckBox)findViewById(R.id.checkbox3);
        sk1     = (SeekBar)findViewById(R.id.seekBar1);
        sk2     = (SeekBar)findViewById(R.id.seekBar2);
        sk3     = (SeekBar)findViewById(R.id.seekBar3);
        ibtnPlay=(ImageButton)findViewById(R.id.buttonPlay);

    }
}
