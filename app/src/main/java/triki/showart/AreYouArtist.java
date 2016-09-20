package triki.showart;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
/**
 * Created by HAJEUR on 08/09/2016.
 */
public class AreYouArtist extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.are_you_arist_layout, null))
                // Add action buttons
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i=new Intent( getActivity().getApplicationContext(), NavigationDrawer.class);
                        startActivity(i);
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //
                        Intent i=new Intent( getActivity().getApplicationContext(), NavigationDrawer.class);
                        startActivity(i);
                    }
                });


        return builder.create();
    }
}