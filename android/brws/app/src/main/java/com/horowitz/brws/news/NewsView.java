/**
 * Created by benz on 16-12-16.
 */
package com.horowitz.brws.news;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.os.Handler;

import com.horowitz.brws.R;
import com.horowitz.brws.util.SystemUtil;

import java.io.IOException;
import java.net.HttpURLConnection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NewsView extends LinearLayout{
    public NewsView(Context context) {
        super(context);
    }
    public NewsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public NewsView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    TextView mTextView;
    Button addBookmark;
    Button insert;
    Button query;
    Button update;
    Button delete;
    Button querys;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mTextView = (TextView) findViewById(R.id.textView);
        addBookmark = (Button) findViewById(R.id.AddBookmark);
        insert = (Button) findViewById(R.id.insert);
        query = (Button) findViewById(R.id.query);
        update = (Button) findViewById(R.id.update);
        delete = (Button) findViewById(R.id.delete);
        querys = (Button) findViewById(R.id.queryAll);

        query.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setTextInMainThread(R.string.bookmarks_fragment_title);
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setTextInMainThread(R.string.app_name);
            }
        });

        addBookmark.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startDownload();
            }
        });

        querys.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openUrl();
            }
        });
    }

    public void setTextInMainThread(int resid) {
        mTextView.setText(resid);
    }

    public void setTextInOtherThread(final String text) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mTextView.setText(text);
            }
        });
    }

    public void openUrl() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(URL_ICICI));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        SystemUtil.getAppContext().startActivity(intent);
    }

    private Handler mHandler = new Handler(Looper.getMainLooper());
    private OkHttpClient mOkClient = new OkHttpClient();
    private static final String TAG = "NewsView";
    private static final String URL_TEST = "https://www.baidu.com/duty/";
    private static final String URL_ICICI = "http://icicibank.com";

    //HttpClient
    //HttpURLConnection

    public void startDownload() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                download();
            }
        }).start();
    }

    public void download() {
        Request rq = new Request.Builder()
                .url(URL_TEST)
                .build();
        try {
            Log.d(TAG, "download <--");
            final Response rp = mOkClient.newCall(rq).execute();
            if (rp.isSuccessful()) {
                Log.d(TAG, "download -- 0");
                final String body = rp.body().string();
                if (!TextUtils.isEmpty(body)) {
                    setTextInOtherThread(body);
                }
            } else {
                Log.d(TAG, "download -- 1");
            }
            Log.d(TAG, "download --> ");
        } catch (IOException e) {
            Log.e(TAG, "download ", e);
        }
    }

}
