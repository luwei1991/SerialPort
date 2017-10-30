package com.example.yyjcb.serialport;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android_serialport_api.SerialPortActivity;

/**
 * 陆伟 2017/10/18
 */
public class SerialPort extends SerialPortActivity {

    private EditText content;

    private TextView receContent;

    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        content = findViewById(R.id.et_content);

        receContent = findViewById(R.id.tv_rece);

        send = findViewById(R.id.bt_send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = content.getText().toString();
                try {
                    mOutputStream.write(new String(str).getBytes());
                    mOutputStream.write('\n');
                }catch (Exception e){

                }
            }
        });

        content.setText("^XA^A0N,40,30^FO50,150^FDHELLO WORLD^FS^XZ");
    }

    @Override
    protected void onDataReceived(byte[] buffer, int size) {
        //显示响应信息
        Toast.makeText(SerialPort.this,new String(buffer,0,size),Toast.LENGTH_LONG).show();

    }
}
