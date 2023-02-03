package com.example.rootdetect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.rootdetect.databinding.ActivityMainBinding;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // Used to load the 'rootdetect' library on application startup.
    static {
        System.loadLibrary("rootdetect");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        // tv.setText(stringFromJNI());



        boolean deviceRoot = CheckRoot.isDeviceRooted();
        tv.setText("Device Root：" +deviceRoot);
    }

    /**
     * A native method that is implemented by the 'rootdetect' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}