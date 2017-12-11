package com.example.lenovo.weixin;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by lenovo on 2017/12/7.
 */

public class LoginActivity extends Activity implements View.OnClickListener{
    private myDBOpenHelper dbhelper;
    private EditText et_name;
    private EditText et_password;
    private Button btn_dl;
    private Button btn_register;
    private String userPhone;
    private String userPassword;
    private String userName;
    private String userCountry;
    int loginflag;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

       /* ActionBar actionBar=getSupportActionBar();
        actionBar.hide();*/
        setContentView(R.layout.login_activity);
        dbhelper = new myDBOpenHelper(this,"User.db",null,1);

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        initView();


        /*btn=(Button)findViewById(R.id.btn_dl);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn_register=(Button)findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

*/
    }
    public void initView(){
        btn_dl=(Button)findViewById(R.id.btn_dl);
        btn_register=(Button)findViewById(R.id.btn_register);
        btn_dl.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }
    public void login(){
        et_name =(EditText)findViewById(R.id.et_name);
        et_password=(EditText)findViewById(R.id.et_password);
        userName=et_name.getText().toString();
        userPassword=et_password.getText().toString();
        if (checkLogin(userName,userPassword)) {

            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean checkLogin(String newname,String newpassword){
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        String sql = "select * from registor where phone=? and password=?";
        Cursor cursor = db.rawQuery(sql, new String[] {newname, newpassword});
        if (cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        return false;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dl:
                login();
                break;
            case R.id.btn_register:
                Intent it=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(it);
                break;
            default:
                break;
        }
    }

}
   /* public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);//这里是调用menu文件夹中的main.xml，在登陆界面label右上角的三角里显示其他功能
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id ==R.id.action_settings){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    /*public void select()
    {

        dbhelper = new myDBOpenHelper(this,"User.db",null,1);
        SQLiteDatabase db=dbhelper.getWritableDatabase();

        String sql = "select * from register";

        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            //第一列为id
            userName= cursor.getString(1); //获取第2列的值,第一列的索引从0开始
            userCountry = cursor.getString(2);//获取第3列的值
            userPhone =  cursor.getString(3); //获取第2列的值,第一列的索引从0开始
            userPassword = cursor.getString(4);//获取第3列的值



            if((et_name.getText().toString().equals(userPhone))&&(et_password.getText().toString().equals(userPassword)))
            {
                Toast.makeText(this, "用户验证成功", Toast.LENGTH_SHORT).show();
                loginflag=1;

                //intent bundle传值
                /*Intent MainActivity = new Intent();
                MainActivity .setClass(this,MainActivity.class);
                Bundle bundle = new Bundle(); //该类用作携带数据
                bundle.putString("user", user.getText().toString());
                MainActivity.putExtras(bundle);   //向MainActivity传值
                this.startActivity(MainActivity);
                finish();//退出*/
/*
            }


        }

        if((et_name.getText().toString().isEmpty())||(et_password.getText().toString().isEmpty())){

            Toast.makeText(this, "不能为空，请重新输入", Toast.LENGTH_SHORT).show();
        }


        if(loginflag!=1)
        {
            Toast.makeText(this, "账号或者密码错误,请重新输入", Toast.LENGTH_SHORT).show();
        }

        cursor.close();
        db.close();
        //Toast.makeText(this, "已经关闭数据库", Toast.LENGTH_SHORT).show();
    }
*/

