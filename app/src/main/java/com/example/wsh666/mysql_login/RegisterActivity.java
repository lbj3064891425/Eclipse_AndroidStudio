package com.example.wsh666.mysql_login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created bywsh666 on 2018/9/5 14:01
 　 へ　　　　　  ／|
　　/＼7　　　 ∠＿/
　 /　│　　 ／　／
　│　Z ＿,＜　／　　 /`ヽ
　│　　　　　ヽ　　 /　　〉
　 Y　　　　　`　   /　　/
　ｲ●　､　●　　⊂⊃〈　　/
　()　 へ　　　　|　＼〈
　　>ｰ ､_　 ィ　 │ ／／
　 / へ　　 /　ﾉ＜| ＼＼
　 ヽ_ﾉ　　(_／　 │／／
　　7　　　　　　　|／
　　＞―r￣￣`ｰ―＿
 */
public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    EditText et_name;
    EditText et_password;

    Button button_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_name = (EditText)findViewById(R.id.et_name);
        et_password = (EditText)findViewById(R.id.et_password);

        button_register = (Button)findViewById(R.id.button_register);

        button_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_register:
                final String name = et_name.getText().toString().trim();
                final String password = et_password.getText().toString().trim();

                //调用Java后台登录接口
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            String path = "http://192.168.1.4:8080/ForAndroid/registerServlet?name=" + name + "&password=" + password;
                            URL url = new URL(path);
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            connection.connect();
                            int responseCode = connection.getResponseCode();
                            if(responseCode == 200){
                                InputStream is = connection.getInputStream();
                                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                                byte[] buffer= new byte[1024];
                                int len = -1;
                                while((len=is.read(buffer))!=-1){
                                    baos.write(buffer,0,len);
                                }
                                final String result = baos.toString();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        if(result.equals("1")){
                                            Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
                break;
        }
    }
}

