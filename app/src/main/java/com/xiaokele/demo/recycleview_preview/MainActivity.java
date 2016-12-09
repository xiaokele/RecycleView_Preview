package com.xiaokele.demo.recycleview_preview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PreviewRecycleView mRecyclerView;
    private RecycleViewAdapter mAdapter;
    private List<Integer> mDatas;
    private ImageView mImg ;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mImg = (ImageView) findViewById(R.id.id_content);

       initData();

        mRecyclerView = (PreviewRecycleView) findViewById(R.id.id_recyclerview_horizontal);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new RecycleViewAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setOnItemScrollChangeListener(new PreviewRecycleView.OnItemScrollChangeListener()
        {
            @Override
            public void onChange(View view, int position)
            {
                mImg.setImageResource(mDatas.get(position));
            };
        });

        mAdapter.setOnItemClickLitener(new RecycleViewAdapter.OnItemClickLitener()
        {
            @Override
            public void onItemClick(View view, int position)
            {
              Toast.makeText(getApplicationContext(), position + "", Toast.LENGTH_SHORT)
                      .show();
                mImg.setImageResource(mDatas.get(position));
            }
        });

    }

    /*

    初始化数据
     */
    private void initData() {
        mDatas=new ArrayList<Integer>(
                Arrays.asList(
                        R.mipmap.a,R.mipmap.b,R.mipmap.c,R.mipmap.d,
                        R.mipmap.e,R.mipmap.f,R.mipmap.g,R.mipmap.h,
                        R.mipmap.r,R.mipmap.g,R.mipmap.k,R.mipmap.l,
                        R.mipmap.m,R.mipmap.n,R.mipmap.o
                )
        );
    }
}
