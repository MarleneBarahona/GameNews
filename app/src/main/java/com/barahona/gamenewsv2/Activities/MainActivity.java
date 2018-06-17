package com.barahona.gamenewsv2.Activities;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.barahona.gamenewsv2.CSGO;
import com.barahona.gamenewsv2.Dota;
import com.barahona.gamenewsv2.LOL;
import com.barahona.gamenewsv2.Noticia;
import com.barahona.gamenewsv2.Noticias;
import com.barahona.gamenewsv2.R;
import com.barahona.gamenewsv2.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, Noticias.OnFragmentInteractionListener, CSGO.OnFragmentInteractionListener, LOL.OnFragmentInteractionListener, Dota.OnFragmentInteractionListener {

    List<Noticia> List;
    RecyclerView myrv;
    RecyclerView.Adapter rvadapter;
    LinearLayoutManager lm;
    boolean fragmentoSeleccionado = false;
    android.support.v4.app.Fragment miFragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //EditText username = findViewById(R.id.id_username_perfil);
        //username = findViewById(R.id.edit_user);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        List = new ArrayList<>();

        myrv = findViewById(R.id.recycler);

        List.add(new Noticia(R.drawable.icono,"Noticia CSGO",null));
        List.add(new Noticia(R.drawable.icono,"Noticia LOL",null));
        List.add(new Noticia(R.drawable.icono,"Noticia Dota",null));
        List.add(new Noticia(R.drawable.icono,"Noticia LOL",null));
        List.add(new Noticia(R.drawable.gravity_rush,"Noticia CSGO",null));
        List.add(new Noticia(R.drawable.icono,"Noticia Dota",null));

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,6);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {

                //Distribuyendo los espacios
                switch (position % 3){

                    //Primer cardview
                    case 0:
                        return 6;
                    //Segundo cardview
                    case 1:
                        return 4;
                    //Tercer cardview
                    case 2:
                        return 2;

                }

                throw new IllegalStateException("Error");

            }
        });

        //seteando recycler en adapter
        myrv.setLayoutManager(gridLayoutManager);
        rvadapter = new RecyclerAdapter(this, List);
        myrv.setAdapter(rvadapter);
        myrv.setHasFixedSize(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        fragmentoSeleccionado = true;
        if (id == R.id.nav_noticia) {
            miFragment = new Noticias();
            fragmentoSeleccionado = true;
        } else if (id == R.id.nav_favs) {

        } else if (id == R.id.nav_CSGO) {
            miFragment = new CSGO();
            fragmentoSeleccionado = true;
        } else if (id == R.id.nav_LOL) {
            miFragment = new LOL();
            fragmentoSeleccionado = true;
        } else if (id == R.id.nav_Dota) {
            miFragment = new Dota();
            fragmentoSeleccionado = true;
        } else if (id == R.id.nav_config) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_cerrarsesion) {
            Toast.makeText(getApplicationContext(), "se ha cerrado la sesion",Toast.LENGTH_SHORT).show();
        }
        if(fragmentoSeleccionado){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main_id, miFragment).commit();
        }

        //EditText username = findViewById(R.id.edit_user);
        //username = findViewById(R.id.id_username_perfil);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
