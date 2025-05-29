package com.bao.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int [] listBtnId = {R.id.write_internal_storage,
            R.id.read_internal_storage,
            R.id.write_cache_storage,
            R.id.read_cache_storage,
            R.id.write_external_storage,
            R.id.read_external_storage
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        for(int id: listBtnId){
            Button btnTemp = (Button) findViewById(id);
            btnTemp.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.read_internal_storage:
                String readDataIS = readIS("myfile.txt");
                Toast.makeText(this, "Nội dung file: " + readDataIS, Toast.LENGTH_SHORT).show();
                break;
            case R.id.write_internal_storage:
                writeIS("myfile.txt", "xin chào các bạn!");
                break;
            case R.id.read_cache_storage:
                String readDataFC = readFC("mycached.cache");
                Toast.makeText(this, "Data cache: " + readDataFC, Toast.LENGTH_SHORT).show();
                break;
            case R.id.write_cache_storage:
                writeFC("mycached.cache", "Dữ liệu lưu vào cache!");
                break;
            case R.id.read_external_storage:
                String readDataEX = readES("mysdcard.txt");
                Toast.makeText(this, "Nội dung file: " + readDataEX, Toast.LENGTH_SHORT).show();
                break;
            case R.id.write_external_storage:
                writeES("mysdcard.txt", "Dữ liệu lưu vào thẻ nhớ ngoài!");
                break;
        }
    }

    private void writeES(String filename, String data) {
        String sdcard = getExternalFilesDir("")+"/"+filename;

        try {
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(sdcard));
            writer.write(data);
            writer.close();
            Toast.makeText(this, "Lưu thành công: ",Toast.LENGTH_SHORT).show();

        } catch(Exception ex){
            Toast.makeText(this, "ERROR " + ex.getMessage(), Toast.LENGTH_SHORT).show();
            ex.printStackTrace();
        }
    }

    private String readES(String filename) {
        String sdcard = getExternalFilesDir("")+"/"+filename;
        try {
            Scanner scan = new Scanner(new File(sdcard));
            String data = "";
            while (scan.hasNext()){
                data = data + scan.nextLine() + "\n";
            }
            scan.close();
            return data;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    private void writeFC(String filename, String data){
        File cacheDir = getCacheDir();
        try(FileOutputStream fout = new FileOutputStream(new File(cacheDir,filename))) {
            fout.write(data.getBytes(StandardCharsets.UTF_8));
            Toast.makeText(this, "Dữ liệu lưu vào cache thành công", Toast.LENGTH_SHORT).show();
        } catch(Exception ex){
            Toast.makeText(this, "ERROR " + ex.getMessage(), Toast.LENGTH_SHORT).show();
            ex.printStackTrace();
        }
    }

    private String readFC(String fileName) {
        File cacheDir = getCacheDir();
        int length = 0;
        byte[] buffer = new byte[1024];
        try (FileInputStream fin = new FileInputStream(new File(cacheDir, fileName))) {
            length = fin.read(buffer);
            return new String(buffer, 0, length);
        } catch(Exception ex){
            ex.printStackTrace();
            Toast.makeText(this, "ERROR " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return null;
    }

    private void writeIS(String file, String data) {
        try (FileOutputStream fout = openFileOutput(file, MODE_PRIVATE)){
            fout.write(data.getBytes(StandardCharsets.UTF_8));
            fout.close();
            Toast.makeText(this, "Dữ liệu đã được ghi", Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Toast.makeText(this, "ERROR " + ex.getMessage(), Toast.LENGTH_SHORT).show();
            ex.printStackTrace();
        }
    }

    private String readIS(String file) {
        try (FileInputStream fin = openFileInput(file)){
            byte[] buffer = new byte[1024];
            int length = 0;
            length = fin.read(buffer);
            return new String(buffer, 0, length);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}