package edu.mobidev.g301.labrecyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by ngoc on 1/27/2016.
 */
public class GenreChooser extends DialogFragment {

    private OnGenreSelectListener mOnGenreSelectListener;
    final String[] mGenreList = new String[]{
            "Classic",
            "Country",
            "EDM",
            "Jazz",
            "Pop",
            "Rap",
            "Rock"
    };

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {



        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("Select Genre")
                .setItems(mGenreList, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mOnGenreSelectListener.onGenreSelect(mGenreList[which]);
                        dismiss();
                    }
                });

        return builder.create();
    }

    public interface OnGenreSelectListener{
        public void onGenreSelect(String genre);
    }

    public void setOnGenreSelectListener(OnGenreSelectListener onGenreSelectListener){
        this.mOnGenreSelectListener = onGenreSelectListener;
    }
}
