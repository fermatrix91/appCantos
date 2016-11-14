package com.example.fernando.cantosapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import java.util.ArrayList;

import org.w3c.dom.Text;

public class IndiceHimnariosActivity extends ActionBarActivity {
    ListView listViewIndice;
    //SearchView cuadroBusqueda;
    CantosEHimnosEspiritualesAdapter adapterGlobalEspirituales;
    CantosDelCaminoAdapter adapterGlobalDelCamino;
    List<CantosEHimnosEspirituales> cantosEHimnosEspirituales = new ArrayList<CantosEHimnosEspirituales>();
    List<CantosDelCamino> cantosdelCamino = new ArrayList<CantosDelCamino>();

    //TextView nombreHimnarioAMostrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indice_himnarios);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String nombreHimnario = (String) bundle.get("NOMBREHIMNARIO");
        //nombreHimnarioAMostrar = (TextView) findViewById(R.id.nombreHimnario);
        //nombreHimnarioAMostrar.setText((String) bundle.get("NOMBREHIMNARIO"));


        listViewIndice = (ListView) findViewById(R.id.listViewIndice);

        MostrarIndice(nombreHimnario);
        registerForContextMenu(listViewIndice);

        //Text FIlter
        listViewIndice.setTextFilterEnabled(true);
        EditText editText = (EditText) findViewById(R.id.textboxBusqueda);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(adapterGlobalEspirituales != null) {
                    System.out.println("Text [" + s + "] - Start [" + start + "] - Before [" + before + "] - Count [" + count + "]");
                    if (count < before) {
                        // We're deleting char so we need to reset the adapter data
                        adapterGlobalEspirituales.resetData();
                    }
                    adapterGlobalEspirituales.getFilter().filter(s.toString());
                }
                else
                {
                    System.out.println("Text [" + s + "] - Start [" + start + "] - Before [" + before + "] - Count [" + count + "]");
                    if (count < before) {
                        // We're deleting char so we need to reset the adapter data
                        adapterGlobalDelCamino.resetData();
                    }
                    adapterGlobalDelCamino.getFilter().filter(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void MostrarIndice(String nombreHimnario)
    {
        View header = (View)getLayoutInflater().inflate(R.layout.list_header_row, null);

        if (nombreHimnario.equals("Himnos y Cánticos Espirituales"))
        {
            // 1 al 30
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("1","Iglesia de Cristo"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("2","Canta, oh Buen Cristiano"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("3","Invocación"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("4","No te de temor hablar por Cristo"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("5","Oh bondad tan infinita"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("6","Bellas Palabras de Vida"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("7","Unidos cantemos"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("8","Gloria"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("9","Lugar para Cristo"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("10","Cristo el Rey de Gloria"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("11","Hay un lugar do quiero estar"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("12","Roca de la Eternidad"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("13","Dulce Oración"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("14","¡Oh, qué amigo!"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("15","Jesús te necesita, cristiana juventud"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("16","Cerca de ti, Señor"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("17","Mi fe espera en ti"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("18","Grato es decir la historia"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("19","¿Oyes cómo el Evangelio?"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("20","¡Oh jóvenes venid!"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("21","Jesús de los cielos"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("22","Cuán grande amor"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("23","Bautícese cada uno"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("24","La Palabra hoy sembrada"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("25","Buscaré a mi Jesús"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("26","El Intercesor"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("27","Padre, tu Palabra es"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("28","Himno de invitación"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("29","Ya venimos, cual hermanos"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("30","La Santa Cena"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("31","Cristo me ama"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("32","Conmigo sé"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("33","Salvador, a Ti me rindo"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("34","Andando en la luz"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("35","Comprado con sangre"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("36","Pecador, ven al dulce Jesús"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("37","Oh, amor que no me dejará"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("38","Que mi vida entera esté"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("39","Santa Biblia"));
            cantosEHimnosEspirituales.add(new CantosEHimnosEspirituales("40","Soy peregrino aquí"));



            adapterGlobalEspirituales = new CantosEHimnosEspiritualesAdapter(this, R.layout.listview_item_row,cantosEHimnosEspirituales);

            listViewIndice.setAdapter(adapterGlobalEspirituales);

            listViewIndice.addHeaderView(header);
            listViewIndice.setAdapter(adapterGlobalEspirituales);

            TextView textoIndice = (TextView) findViewById(R.id.tituloIndice);
            textoIndice.setText(nombreHimnario);

            //Click al Himno
            listViewIndice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    try {
                        TextView nombreCantoSeleccionado = (TextView) view.findViewById(R.id.nombreCanto);
                        Toast.makeText(getApplicationContext(), nombreCantoSeleccionado.getText(), Toast.LENGTH_SHORT).show();

                        TextView numeroCantoSeleccionado = (TextView) view.findViewById(R.id.numeroCanto);

                        //Mostrar detalle del Canto
                        Intent intentDetalleCanto = new Intent(IndiceHimnariosActivity.this.getApplicationContext(), DetalleCantoActivity.class);
                        intentDetalleCanto.putExtra("NumeroCanto", numeroCantoSeleccionado.getText());
                        intentDetalleCanto.putExtra("NombreCanto", nombreCantoSeleccionado.getText());
                        intentDetalleCanto.putExtra("NombreHimnario", "CantosEHimnosEspirituales");

                        startActivity(intentDetalleCanto);
                    }
                    catch(ArrayIndexOutOfBoundsException exception)
                    {
                        System.out.println("Error en canto seleccionado");
                    }
                }
            });


        }
        else
        if (nombreHimnario.equals("Cantos del Camino")) {

            cantosdelCamino.add(new CantosDelCamino("1", "Las primicias del día"));
            cantosdelCamino.add(new CantosDelCamino("2", "Quiero alabarte"));
            cantosdelCamino.add(new CantosDelCamino("3", "Santo, Santo, Santo"));
            cantosdelCamino.add(new CantosDelCamino("4", "Su presencia"));
            cantosdelCamino.add(new CantosDelCamino("5","Te alabaré, Señor"));
            cantosdelCamino.add(new CantosDelCamino("6", "Padre amado"));
            cantosdelCamino.add(new CantosDelCamino("7", "Bendice, alma mía"));
            cantosdelCamino.add(new CantosDelCamino("8", "Eres mi Dios"));
            cantosdelCamino.add(new CantosDelCamino("9", "Te exaltaré, mi Dios, mi Rey"));
            cantosdelCamino.add(new CantosDelCamino("10","Toda la tierra"));

            cantosdelCamino.add(new CantosDelCamino("11", "El firmamento de esplendor"));
            cantosdelCamino.add(new CantosDelCamino("12", "El mundo entero es del Padre"));
            cantosdelCamino.add(new CantosDelCamino("13", "Gloria a la Trinidad"));
            cantosdelCamino.add(new CantosDelCamino("14", "En el nombre de Dios"));
            cantosdelCamino.add(new CantosDelCamino("15","Tu fidelidad es grande"));
            cantosdelCamino.add(new CantosDelCamino("16", "El nombre de Dios"));
            cantosdelCamino.add(new CantosDelCamino("17", "En momentos así"));
            cantosdelCamino.add(new CantosDelCamino("18", "Seas exaltado"));
            cantosdelCamino.add(new CantosDelCamino("19", "A dios el Padre (Doxología)"));
            cantosdelCamino.add(new CantosDelCamino("20","Enaltecido tú eres"));

            cantosdelCamino.add(new CantosDelCamino("21","Entraré por sus puertas"));
            cantosdelCamino.add(new CantosDelCamino("22","No hay Dios tan grande como tú"));
            cantosdelCamino.add(new CantosDelCamino("23","Levantaos, bendecid"));
            cantosdelCamino.add(new CantosDelCamino("24","Es exaltado"));






            adapterGlobalDelCamino = new CantosDelCaminoAdapter(this, R.layout.listview_item_row,cantosdelCamino);

            listViewIndice.setAdapter(adapterGlobalDelCamino);

            listViewIndice.addHeaderView(header);
            listViewIndice.setAdapter(adapterGlobalDelCamino);

            TextView textoIndice = (TextView) findViewById(R.id.tituloIndice);
            textoIndice.setText(nombreHimnario);

            //Click al Himno
            listViewIndice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    try {
                        TextView nombreCantoSeleccionado = (TextView) view.findViewById(R.id.nombreCanto);
                        Toast.makeText(getApplicationContext(), nombreCantoSeleccionado.getText(), Toast.LENGTH_SHORT).show();

                        TextView numeroCantoSeleccionado = (TextView) view.findViewById(R.id.numeroCanto);

                        //Mostrar detalle del Canto
                        Intent intentDetalleCanto = new Intent(IndiceHimnariosActivity.this.getApplicationContext(), DetalleCantoActivity.class);
                        intentDetalleCanto.putExtra("NumeroCanto", numeroCantoSeleccionado.getText());
                        intentDetalleCanto.putExtra("NombreCanto", nombreCantoSeleccionado.getText());
                        intentDetalleCanto.putExtra("NombreHimnario", "CantosDelCamino");

                        startActivity(intentDetalleCanto);
                    } catch (ArrayIndexOutOfBoundsException exception) {
                        System.out.println("Error en canto seleccionado");
                    }
                }
            });
        }
    }
}
