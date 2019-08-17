package com.example.bts_details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<BTS> list = new ArrayList<>();
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;
    String title = "Mode List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();

        if (savedInstanceState == null) {
            setActionBarTitle("Mode List");
            list.addAll(BTSData.getListData());
            showRecyclerList();
            mode = R.id.action_list;

        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<BTS> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
            setMode(stateMode);
        }
    }

    private void showSelectedMember(BTS bts) {
        Toast.makeText(this, "Kamu memilih " + bts.getName(), Toast.LENGTH_SHORT).show();

        /*Intent rm = new Intent(MainActivity.this, RMActivity.class);
        startActivity(rm);*/

        if (bts.getName() == "RM") {
            Intent rm = new Intent(MainActivity.this, RMActivity.class);
            startActivity(rm);

        } else if ( bts.getName() == "Jin") {
            Intent jin = new Intent(MainActivity.this, JinActivity.class);
            startActivity(jin);

        } else if ( bts.getName() == "Suga"){
                Intent suga = new Intent(MainActivity.this, SugaActivity.class);
                startActivity(suga);

        } else if (bts.getName() == "J-Hope") {
            Intent jhope = new Intent(MainActivity.this, JHopeActivity.class);
            startActivity(jhope);

        } else if (bts.getName() == "Jimin") {
            Intent jimin = new Intent(MainActivity.this, JiminActivity.class);
            startActivity(jimin);

        } else if (bts.getName() == "V") {
            Intent vi = new Intent(MainActivity.this, VActivity.class);
            startActivity(vi);

        } else if (bts.getName() == "Jungkook") {
                Intent jungkook = new Intent(MainActivity.this, JungkookActivity.class);
                startActivity(jungkook);

        }
    }

    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListBTSAdapter listBTSAdapter = new ListBTSAdapter(this);
        listBTSAdapter.setListBTS(list);
        rvCategory.setAdapter(listBTSAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedMember(list.get(position));
            }
        });
    }

    private void showRecyclerGrid(){
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridBTSAdapter gridBTSAdapter = new GridBTSAdapter(this);
        gridBTSAdapter.setListBTS(list);
        rvCategory.setAdapter(gridBTSAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedMember(list.get(position));
            }
        });
    }

    private void showRecyclerCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewBTSAdapter cardViewBTSAdapter = new CardViewBTSAdapter(this);
        cardViewBTSAdapter.setListBTS(list);
        rvCategory.setAdapter(cardViewBTSAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        setMode(item.getItemId());

        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }

}
