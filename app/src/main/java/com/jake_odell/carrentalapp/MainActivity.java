package com.jake_odell.carrentalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Integer[] CarImg = {R.drawable.sonata, R.drawable.audi, R.drawable.bolt, R.drawable.leaf,
        R.drawable.armada};
    String[] Cars = {"Sonata $30", "Audi $40", "Bolt $35", "Leaf $30", "Armada $45"};
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView grid = (GridView)findViewById(R.id.gridView);
        final ImageView pic = (ImageView)findViewById(R.id.imgLarge);
        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), Cars[position] + " per day", Toast.LENGTH_SHORT).show();
                pic.setImageResource(CarImg[position]);
            }
        });
    }
    
    
    public class ImageAdapter extends BaseAdapter {

        private Context context;
        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return CarImg.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(CarImg[position]);
            pic.setScaleType(ImageView.ScaleType.CENTER_CROP);
            pic.setLayoutParams(new GridView.LayoutParams(430, 400));
            return pic;
        }
    }
}