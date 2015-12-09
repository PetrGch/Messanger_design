package com.example.petr.mes2;

import android.app.SearchManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Locale;

public class ContactList extends AppCompatActivity {

    private String[] drawerLinkTitles;
    private ListView drawerListView;

    private CharSequence dTitle;
    private CharSequence drawerTitle;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dTitle = drawerTitle = getTitle();
        drawerLinkTitles = getResources().getStringArray(R.array.links_for_drawer);

        drawerListView = (ListView) findViewById(R.id.drawer_list_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawerListView.setAdapter(new ArrayAdapter<>(this, R.layout.drawer_list_item,
                drawerLinkTitles));
        drawerListView.setOnItemClickListener(new DrawerItemClickListener());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /*Icon in actionBar */

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                null,
                R.string.drawer_open,
                R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(dTitle);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View view) {
                getSupportActionBar().setTitle(drawerTitle);
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem (int position) {
        DrawerFragment fragment = new DrawerFragment();
        Bundle args = new Bundle();
        args.putInt(DrawerFragment.LINK_NUMBERS, position);
        fragment.setArguments(args);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        drawerListView.setItemChecked(position, true);
        setTitle(drawerLinkTitles[position]);
        drawerLayout.closeDrawer(drawerListView);
    }

    @Override
    public void setTitle (CharSequence title) {
        dTitle = title;
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(dTitle);
        } else {
            setTitle(dTitle);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mes2, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu (Menu menu) {
        boolean drawerOpen =drawerLayout.isDrawerOpen(drawerListView);
        menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle actio n bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action buttons
        switch(item.getItemId()) {
            case R.id.action_websearch:
                // create intent to perform web search for this cat
                Intent intent = new Intent(Intent.ACTION_SEARCH);
                intent.putExtra(SearchManager.QUERY, getSupportActionBar().getTitle());
                // catch event that there's no activity to handle intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(this, R.string.app_not_available, Toast.LENGTH_LONG).show();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the DrawerActivity toggls
        drawerToggle.onConfigurationChanged(newConfig);
    }

    public static class DrawerFragment extends android.support.v4.app.Fragment{
        public static final String LINK_NUMBERS = "link_numbers";

        public DrawerFragment() {
            // Для фрагмента требуется пустой конструктор
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.new_content, container, false);
            int i = getArguments().getInt(LINK_NUMBERS);
            // нахождения имен файлов
            String linkName = getResources().getStringArray(R.array.links_for_drawer)[i];

            String catNameTitle = getResources().getStringArray(R.array.links_for_drawer)[i];

            int imageId = getResources().getIdentifier(linkName.toLowerCase(Locale.ROOT),
                    "drawable", getActivity().getPackageName());
            ((ImageView) rootView.findViewById(R.id.imageView)).setImageResource(imageId);
            getActivity().setTitle(catNameTitle);
            return rootView;
        }
    }

}
