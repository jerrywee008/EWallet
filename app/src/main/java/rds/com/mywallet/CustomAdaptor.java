package rds.com.mywallet;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdaptor extends ArrayAdapter<DataItem> {

        List<DataItem> dataItems = null;
        Context context;

        public CustomAdaptor(Context context, List<DataItem> objects) {
            super(context, R.layout.activity_cost_list, objects);
            this.context = context;
            this.dataItems = objects;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.activity_cost_list, parent, false);

            TextView shoppingDate = (TextView) convertView.findViewById(R.id.shopping_date_view);
            TextView itemName = (TextView) convertView.findViewById(R.id.item_name_view);
            TextView cost = (TextView) convertView.findViewById(R.id.cost_view);
            shoppingDate.setText(dataItems.get(position).getShoppingDate());
            itemName.setText(String.valueOf(dataItems.get(position).getItemName()));
            cost.setText(String.valueOf(dataItems.get(position).getCost()));

            ImageView imageView = (ImageView) convertView.findViewById(R.id.delete_img);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dataItems.remove(position);
                }
            });

            return convertView;

        }


}
