package com.botty.animewall;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class About extends Activity {

    Context ctx = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ActionBar ab = getActionBar();
        ab.setHomeButtonEnabled(true);


        Button chiudi = (Button) findViewById(R.id.button2);
        chiudi.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ctx);
                alertDialogBuilder.setTitle("Changelog:");
                //inseriamo qui il titolo della Dialog Box
                alertDialogBuilder
                        .setMessage("v1.7\n" +
                                "- added ActivityAbout,\n" +
                                "- added new some 5 awesome wallpaper,\n" +
                                "- icon launcher on Drawer,\n" +
                                "- re-enable Android 4.+ color,\n" +
                                "- initial update translation,\n" +
                                "- ActionBar in About.\n" +
                                "v 1.5\n" +
                                "- remove some wallpaper,\n" +
                                "- remove ActionBar,\n" +
                                "- some interface improve,\n" +
                                "- added icon.")
                        .setCancelable(true)
                        .setNegativeButton("OK",new DialogInterface.OnClickListener() {
                            //scriviamo qui il testo del bottone per annullare e l'azione da eseguire
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                //con questi due metodi viene effettivamente generato l'alert e successivamente mostrato
            }
        });
    }


    public void popUp(View v){

        // Dummy list:
        ArrayList<String> dummies = new ArrayList<String>();

        dummies.add("Google+");
        dummies.add("Twitter");
        dummies.add("Facebook");


        final Dialog dialog = new Dialog(About.this);
        dialog.setContentView(R.layout.list_layout);
        dialog.setTitle("Add us on :");
        ListView listView = (ListView) dialog.findViewById(R.id.list);

        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, R.layout.single_item_layout , R.id.singleItem, dummies);
        listView.setAdapter(ad);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                //do something on click
                switch (arg2){
                    case 0:
                        Intent g = new Intent(Intent.ACTION_VIEW);
                        g.setData(Uri.parse("https://plus.google.com/u/0/b/112977683168945771364"));
                        startActivity(g);
                        break;
                    case 1:
                        Intent t = new Intent(Intent.ACTION_VIEW);
                        t.setData(Uri.parse("https://twitter.com/DroidNexus2"));
                        startActivity(t);
                        break;
                    case 2:
                        Intent f = new Intent(Intent.ACTION_VIEW);
                        f.setData(Uri.parse("https://www.facebook.com/droidnexus"));
                        startActivity(f);
                        break;
                }
                dialog.dismiss();
            }
        });

        dialog.show();
    }

}