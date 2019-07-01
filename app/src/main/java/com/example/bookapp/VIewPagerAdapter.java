package com.example.bookapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class VIewPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public VIewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        PageFragment pageFragment = new PageFragment();
        position = position + 1;
        Bundle bundle = new Bundle();
        if (position == 1) {
            InputStream inputStream = context.getResources().openRawResource(R.raw.chapter1);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i;
            try {
                i = inputStream.read();
                while (i != -1) {
                    byteArrayOutputStream.write(i);
                    i = inputStream.read();
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bundle.putString("message", byteArrayOutputStream.toString());
        }
        else if (position == 2){
            InputStream inputStream = context.getResources().openRawResource(R.raw.chapter2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i;
            try {
                i = inputStream.read();
                while (i != -1) {
                    byteArrayOutputStream.write(i);
                    i = inputStream.read();
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bundle.putString("message", byteArrayOutputStream.toString());
        }
        else if (position == 3) {
            InputStream inputStream = context.getResources().openRawResource(R.raw.chapter3);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i;
            try {
                i = inputStream.read();
                while (i != -1) {
                    byteArrayOutputStream.write(i);
                    i = inputStream.read();
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bundle.putString("message", byteArrayOutputStream.toString());
        }
        pageFragment .setArguments(bundle);
        return pageFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        position = position + 1;
        return "Chapter " + position;
    }
}
