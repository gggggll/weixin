package com.example.lenovo.weixin;

import android.app.Activity;
import android.content.ContentValues;
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

public class RegisterActivity extends Activity implements View.OnClickListener {
    private Button btn_back;
    private Button btn_zhuce;
    private myDBOpenHelper helper;
    private EditText tx_name;
    private EditText tx_country;
    private EditText tx_phone;
    private EditText tx_password;
    int flag;
    private String name;
    private String country;
    private String phone;
    private String password;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        initViews();
        helper = new myDBOpenHelper(this,"User.db",null,1);


    }

    private void initViews() {
        btn_back = (Button) findViewById(R.id.btn_back);
        btn_zhuce = (Button) findViewById(R.id.btn_zhuce);
        tx_name = (EditText) findViewById(R.id.tx_name);
        tx_country = (EditText) findViewById(R.id.tx_country);
        tx_phone = (EditText) findViewById(R.id.tx_phone);
        tx_password = (EditText) findViewById(R.id.tx_password);
        btn_back.setOnClickListener(this);
        btn_zhuce.setOnClickListener(this);
    }

    /*public void insert() {
        helper = new myDBOpenHelper(this,"UserStore.db",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();    //建立打开可读可写的数据库实例


        //查询一下，是否用户名重复
        String sql1 = "select * from registor";
        Cursor cursor = db.rawQuery(sql1, null);
        while (cursor.moveToNext()) {
            //第一列为id
            name= cursor.getString(1); //获取第2列的值,第一列的索引从0开始
            country = cursor.getString(2);//获取第3列的值
            phone=cursor.getString(3);
            password=cursor.getString(4);

            if((tx_name.getText().toString().isEmpty())||(tx_country.getText().toString().isEmpty())||(tx_phone.getText().toString().isEmpty())||(tx_password.getText().toString().isEmpty())){

            Toast.makeText(this, "不能为空，请重新输入", Toast.LENGTH_SHORT).show();
            break;
        }


        flag = 1;  //不存在此用户
        if ((tx_phone.getText().toString().equals(phone))) {
            Toast.makeText(this, "已存在此用户，请重新注册", Toast.LENGTH_SHORT).show();


            flag = 0;
            break;
        }

    }

      if(flag==1)

    {
        String sql2 = "insert into registor(name,country,phone,password) values ('" + tx_name.getText().toString() + "','" + tx_country.getText().toString() + "','" + tx_phone.getText().toString() + "','" + tx_password.getText().toString() + "')";
        db.execSQL(sql2);
        Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show();
    }


}
*/

    public void register(){
        tx_name = (EditText) findViewById(R.id.tx_name);
        tx_country = (EditText) findViewById(R.id.tx_country);
        tx_phone = (EditText) findViewById(R.id.tx_phone);
        tx_password = (EditText) findViewById(R.id.tx_password);
        name=tx_name.getText().toString();
        country=tx_country.getText().toString();
        phone=tx_phone.getText().toString();
        password=tx_password.getText().toString();
        if (check(phone)) {
            Toast.makeText(this,"该用户名已被注册，注册失败",Toast.LENGTH_SHORT).show();
        }
        else {

            if (insert(name, country,phone,password)) {
                Toast.makeText(this, "插入数据表成功", Toast.LENGTH_SHORT).show();
            }
        }

    }
    public boolean insert(String userName,String userCountry,String userPhone,String userPassword){
        SQLiteDatabase db= helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",userName);
        values.put("country",userCountry);
        values.put("phone",userPhone);
        values.put("password",userPassword);
        db.insert("registor",null,values);
        db.close();
        return true;
    }
    public boolean  check(String value){
        SQLiteDatabase db=helper.getWritableDatabase();
        String Query = "Select * from registor where phone=?";
        Cursor cursor = db.rawQuery(Query,new String[] { value });

        if (cursor.getCount()>0){
            cursor.close();
            return  true;
        }
        cursor.close();
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_zhuce:
                register();
                break;
            default:
                break;
        }
    }
}
