package com.example.tugasfg01;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"MM", "AI", "Computing", "HES", "Net-OS","Motion"};
    String mDescription[] = {"Multimedia Lab", "Artificial Intelligence Lab", "Computing Lab", "Hardware and Embedded Studio Lab", "Network and Opereting System Lab","Mobile Innovation Lab"};
    int images[] = {R.drawable.multimedia, R.drawable.ai, R.drawable.computing, R.drawable.hes, R.drawable.netos, R.drawable.motion};
    // so our images and other things are set in array

    // now paste some images in drawable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Toast.makeText(MainActivity.this, "Multimedia Lab", Toast.LENGTH_SHORT).show();
                }
                else if (position ==  1) {
                    Toast.makeText(MainActivity.this, "Artificial Intelligence Lab", Toast.LENGTH_SHORT).show();
                }
                else if (position ==  2) {
                    Toast.makeText(MainActivity.this, "Computing Lab", Toast.LENGTH_SHORT).show();
                }
                else if (position ==  3) {
                    Toast.makeText(MainActivity.this, "Hardware and Embedded Studio Lab", Toast.LENGTH_SHORT).show();
                }
                else if (position ==  4) {
                    Toast.makeText(MainActivity.this, "Network and Operating System Lab", Toast.LENGTH_SHORT).show();
                }
                else if (position ==  5) {
                    Toast.makeText(MainActivity.this, "Mobile Innovation Lab", Toast.LENGTH_SHORT).show();
                }

            }
        });
        // so item click is done now check list view
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);




            return row;
        }
    }
}