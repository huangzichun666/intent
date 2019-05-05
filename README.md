# intent
实验五


网址输入界面：


![](https://github.com/huangzichun666/intent/blob/master/image/2.png)


intent接收界面：


![](https://github.com/huangzichun666/intent/blob/master/image/1.png)


网址打开界面：


![](https://github.com/huangzichun666/intent/blob/master/image/3.png)



Intent发送Activity:


public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        editText=(EditText)findViewById(R.id.url);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.putExtra("data",editText.getText().toString());
                startActivity(intent);
                finish();
            }
        });
    }
}


Intent接收Activity:


public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_web);
        init();
    }

    public void init(){
        webView=(WebView)findViewById(R.id.webView);
        Intent intent=getIntent();
        String url = (String)intent.getStringExtra("data");
        Log.d("huang", "url" + url);
        webView.loadUrl(url);
    }
}

Intent接收AndroidManifest.xml


<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.intent" >

    <uses-permission android:name="android.permission.INTERNET"></uses-permission>

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme" >
        <activity android:name=".MainActivity" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

        <activity android:name=".WebViewActivity">
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>

        <activity android:name=".Test">
        </activity>
    </application>

</manifest>


