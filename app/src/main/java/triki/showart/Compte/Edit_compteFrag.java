package triki.showart.Compte;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;

import triki.showart.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Edit_compteFrag extends Fragment {

    FloatingActionButton importImage;

    public Edit_compteFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_edit_compte, container, false);
        ImageView imageView=(ImageView) view.findViewById(R.id.image_editCOmpte);
                importImage=(FloatingActionButton)view.findViewById(R.id.edit_image);

        importImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"select Picture"),2);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        // check if the request code is same as what is passed  here it is 2
        if(requestCode==2 && resultCode== Activity.RESULT_OK && data !=null)
        {
            Uri uri =data.getData();
        try{
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(),uri);

        }catch (IOException ee){

        }
        }
    }
}
