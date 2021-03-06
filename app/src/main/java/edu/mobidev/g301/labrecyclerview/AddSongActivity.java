package edu.mobidev.g301.labrecyclerview;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class AddSongActivity extends ActionBarActivity {

    EditText etTitle, etLyrics;
    Button buttonChooseGenre, buttonAdd, buttonCancel;
    TextView tvGenre;
    int genreDrawableId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_song);

        etTitle = (EditText) findViewById(R.id.et_title);
        etLyrics = (EditText) findViewById(R.id.et_lyrics);
        buttonChooseGenre = (Button) findViewById(R.id.choose_genre);
        buttonAdd = (Button) findViewById(R.id.button_add);
        buttonCancel = (Button) findViewById(R.id.button_cancel);
        tvGenre = (TextView) findViewById(R.id.tv_genre);

        buttonChooseGenre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GenreChooser gc = new GenreChooser();
                gc.setOnGenreSelectListener(new GenreChooser.OnGenreSelectListener() {
                    @Override
                    public void onGenreSelect(String genre) {
                        genreDrawableId = convertGenreToDrawableId(genre);
                        tvGenre.setText(genre);
                    }
                });
                gc.show(getFragmentManager(), "");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                Song s = new Song(etTitle.getText().toString(),
                        etLyrics.getText().toString(),
                        genreDrawableId);
                result.putExtra(MainActivity.KEY_SONG, s);
                setResult(RESULT_OK, result);
                finish();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public int convertGenreToDrawableId(String genre){
        switch(genre){
            case "Classic": return R.drawable.ic_classic;
            case "Country": return R.drawable.ic_country;
            case "EDM": return R.drawable.ic_edm;
            case "Jazz": return R.drawable.ic_jazz;
            case "Pop": return R.drawable.ic_pop;
            case "Rap": return R.drawable.ic_rap;
            case "Rock": return R.drawable.ic_rock;
            default : return -1;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_song, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
