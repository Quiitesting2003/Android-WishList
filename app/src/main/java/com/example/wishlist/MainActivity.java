package com.example.wishlist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Country> myList = new ArrayList<>();

        Country vietnam = new Country("VietNam", "vietnam", "VietNam");
        Country argentina = new Country("Argentina", "argentina", "Argentina");
        Country australia = new Country("Australia", "australia", "Australia");
        Country belgium = new Country("Belgium", "belgium", "Belgium");
        Country canada = new Country("Canada", "canada", "Canada");
        Country china = new Country("China", "china", "China");
        Country korea = new Country("Korea", "korea", "Korea");
        Country thailand = new Country("ThaiLand", "thailand", "ThaiLand");
        Country uk = new Country("United Kingdom", "uk", "The United Kingdom");
        Country usa = new Country("United States of America", "usa", "The United States of America");
        Country france = new Country("France", "france", "France");
        Country eu = new Country("EU", "eu", "EU");
        Country germany = new Country("Germany", "germany", "Germany");
        Country india = new Country("India", "india", "India");
        Country japan = new Country("Japan", "japan", "Japan");
        Country singapore = new Country("Singapore", "singapore", "Singapore");
        Country italy = new Country("Italy", "italy", "Italy");
        Country indo = new Country("Indonesia", "indo", "Indonesia");
        Country brazil = new Country("Brazil", "brazil", "Brazil");
        Country mexico = new Country("Mexico", "mexico", "Mexico");
        Country russia = new Country("Russia", "russia", "Russia");


        myList.add(vietnam);
        myList.add(argentina);
        myList.add(belgium);
        myList.add(canada);
        myList.add(china);
        myList.add(korea);
        myList.add(thailand);
        myList.add(uk);
        myList.add(usa);
        myList.add(australia);
        myList.add(japan);
        myList.add(eu);
        myList.add(germany);
        myList.add(france);
        myList.add(mexico);
        myList.add(indo);
        myList.add(india);
        myList.add(italy);
        myList.add(brazil);
        myList.add(russia);
        myList.add(singapore);


        final ListView listView = (ListView) findViewById(R.id.listView_item);
        listView.setAdapter(new CustomListAdapter(myList, this));
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                String note = "";
                for (Country country : myList) {
                    if (country.isCheckbox()) {
                        note += country.getName() + "\n";
                    }
                }
                alertDialogBuilder.setTitle("Your Wishlist");
                String messageWithEmptyLine = note + "\n\n";
                alertDialogBuilder.setMessage(messageWithEmptyLine);

                alertDialogBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }
}

