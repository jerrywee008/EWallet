package rds.com.mywallet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WalletActivity extends Activity {

    ListView listView;
    Button btnCal;
    Button btnAdd;
    CustomAdaptor adapter;

    List<DataItem> dataItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        dataItems = new ArrayList<DataItem>();
        //dataItems.add(new DataItem("2017/09/10", "Dell PC", 5800));
        //dataItems.add(new DataItem("2017/09/11", "LV Bag", 20000));
        //dataItems.add(new DataItem("2017/09/12", "Lottery Ticket", 2));

        setContentView(R.layout.activity_wallet);
        ListView listView = (ListView) findViewById(R.id.listView1);
        adapter = new CustomAdaptor(this, dataItems);
        listView.setAdapter(adapter);

        btnCal = (Button) findViewById(R.id.cal_button);
        btnAdd = (Button) findViewById(R.id.add_line_btn);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText shoppingDate = (EditText) findViewById(R.id.shopping_date_txt);
                EditText itemName = (EditText) findViewById(R.id.item_name_txt);
                EditText cost= (EditText) findViewById(R.id.cost_txt);

                DataItem newDateItem =
                        new DataItem(shoppingDate.getText().toString()
                                , itemName.getText().toString()
                                , Float.valueOf(cost.getText().toString()));

                dataItems.add(newDateItem);

                adapter.notifyDataSetChanged();
            }
        });

        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText totalAmt = (EditText) findViewById(R.id.total_amt_txt);

                float totalCost = 0f;

                for (DataItem dataItem: dataItems) {
                    totalCost += dataItem.cost;
                }

                TextView remainingAmt = (TextView) findViewById(R.id.remain_amt_view);
                remainingAmt.setText(String.valueOf(Float.valueOf(totalAmt.getText().toString())-totalCost));
            }
        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                final int listrowposition= position;
//                ImageView imageView = findViewById(R.id.delete_img);
//
//                imageView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        dataItems.remove(listrowposition);
//                        adapter.notifyDataSetChanged();
//                    }
//                });
//
//            }
//        });

    }

}