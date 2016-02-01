package edu.mobidev.g301.labrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
//    EditText etSong;
    View buttonAdd;
    SongAdapter songAdapter;

    final static int REQUEST_ADD_SONG = 0;
    final static String KEY_TITLE = "title";
    final static String KEY_LYRICS = "lyrics";
    final static String KEY_DRAWABLE_ID = "drawable_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Step 1: create recycler view
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Symphony 9", "-", R.drawable.ic_classic));
        songs.add(new Song("Boom Boom Pow", "-", R.drawable.ic_pop));

        // Step 3: Create our adapter
        songAdapter = new SongAdapter(songs);

        // Step 4: Attach adapter to UI
        recyclerView.setAdapter(songAdapter);

        // Step 5: Attach layout manager to UI
        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(
                        3, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

//        etSong = (EditText) findViewById(R.id.et_song);
        buttonAdd = findViewById(R.id.add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                songAdapter.addSong(etSong.getText().toString());
//                etSong.setText("");
                startActivityForResult(new Intent(getBaseContext(), AddSongActivity.class), REQUEST_ADD_SONG);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(REQUEST_ADD_SONG == requestCode && resultCode == RESULT_OK){
            songAdapter.addSong(new Song(data.getStringExtra(KEY_TITLE),
                                         data.getStringExtra(KEY_LYRICS),
                                         data.getIntExtra(KEY_DRAWABLE_ID, -1)));
        }
    }

}
