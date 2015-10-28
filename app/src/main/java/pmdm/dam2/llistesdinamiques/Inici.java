package pmdm.dam2.llistesdinamiques;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class Inici extends Activity {

    Spinner sp_paisos,sp_ciutats;
    final String TAG="Manel";
    ArrayAdapter<String> adap_paisos, adap_ciutats;
    ArrayList<String> ac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inici);

        sp_paisos=(Spinner)findViewById(R.id.sp_paisos);

        String array_paisos[]=getResources().getStringArray(R.array.Paisos);

        ArrayList <String> ap=new ArrayList<String>(Arrays.asList(array_paisos));

        adap_paisos = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,ap);
        sp_paisos.setAdapter(adap_paisos);

        adap_ciutats = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
        ac=new ArrayList<String>();
        sp_paisos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: //Espanya
                        ac= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.ciutats_Espanya)));
                        break;
                    case 1: //França
                        ac= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.ciutats_França)));
                        break;
                    case 2: //Alemanya
                        ac= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.ciutats_Alemanya)));
                        break;
                    case 3: //Italia
                        ac= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.ciutats_Italia)));
                        break;
                }
                adap_ciutats.clear();
                adap_ciutats.addAll(ac);
                sp_ciutats.setAdapter(adap_ciutats);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /*for(String p:array_paisos){
            Log.d(TAG,p);
        }
        */
        sp_ciutats=(Spinner)findViewById(R.id.sp_ciutats);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inici, menu);
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
