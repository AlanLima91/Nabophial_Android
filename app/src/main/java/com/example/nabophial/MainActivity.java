package com.example.nabophial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * C'est cette fonction qui injecte la bar de menu dans la bar d'action
     * sans cette methode pas de bar de menu (le menu "...")
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate( R.menu.main_menu, menu );
        return true;
    }

    /**
     *
     * Il permet de dire ce qui va se passer selon l'item sur lequel on clique
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch ( item.getItemId() ) // On récupère l'id de l'item cliqué
        {
            case R.id.menu_other: // Cas ou on clique sur l'item autre
                Toast.makeText( this, "Other menu selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_settings: // Cas ou on clique sur l'item parametre
                Toast.makeText( this, "Settings menu selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
