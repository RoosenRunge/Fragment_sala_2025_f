package com.example.fragment_sala_2025;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.fragment_sala_2025.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private FragmentManager fm = getSupportFragmentManager();
    private Fragmento2 f2 = new Fragmento2();
    private Fragmento3 f3 = new Fragmento3();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

 /*       NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Add_frag2) {
            FragmentTransaction t = fm.beginTransaction();
            t.add(R.id.layoutFrag, f2, "Frag2");
            t.addToBackStack(null);
            t.commit();
                }
        else if(id == R.id.action_Remove_frag2){
            FragmentTransaction t = fm.beginTransaction();
            t.remove(f2);
            t.addToBackStack(null);
            t.commit();
        }
        else if(id == R.id.action_Find_frag2_by_tag){
            Fragmento2 tag = (Fragmento2) fm.findFragmentByTag("Frag2");
            if(tag != null)
                tag.helloFrag2();

        }
        else if(id == R.id.action_Replace_Frag3_Args){
            FragmentTransaction t = fm.beginTransaction();
            Bundle args = new Bundle();
            args.putString("myTag", "Android Telecom");
            f3.setArguments(args);
            t.replace(R.id.layoutFrag, f3);
            t.addToBackStack(null);
            t.commit();

        }

        return super.onOptionsItemSelected(item);
    }

  /*  @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }*/
    public void hello(){
        Toast.makeText(this, "metodo hello da Activity", Toast.LENGTH_SHORT).show();
    }
}