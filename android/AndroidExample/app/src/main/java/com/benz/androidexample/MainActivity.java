package com.benz.androidexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button mStartJniThreadButton;
    private TextView mHelloWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initLayout();
        setJNIEnv();
    }

    private void initLayout() {
        mHelloWorld = (TextView) this.findViewById(R.id.hello_world);
        mStartJniThreadButton = (Button)this.findViewById(R.id.start_jni_thread);
        mStartJniThreadButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                //调用JNI中的函数来启动JNI中的线程
                mHelloWorld.setText("Hello-World-via-Click");
                mainThread();
            }
        });
    }

    //由JNI中的线程回调
    private static void fromJNI(int i)
    {
        Log.v("benzheq", "Java------> " + i);
        //mHelloWorld.setText("Hello " + String.valueOf(i));
    }

    //本地方法
    private native void mainThread();
    private native void setJNIEnv();

    static
    {
        //加载动态库
        System.loadLibrary("JNIThread");
    }
}
