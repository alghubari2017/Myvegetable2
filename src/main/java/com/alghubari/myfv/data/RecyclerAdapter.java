package com.alghubari.myfv.data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alghubari.myfv.R;
import com.alghubari.myfv.modle.Product;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHoder> {

    Context context;
    List<Product> list = new ArrayList<Product>();

    public RecyclerAdapter(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);
        MyHoder myHoder = new MyHoder(view);


        return myHoder;
    }

    @Override
    public void onBindViewHolder(MyHoder holder, int position) {

        Product prodlis = list.get(position);

        // String mprice= String.valueOf(ListProduct.getProductPrice());
        // holder.customerName.setText(customerModle.getCustomerName());
        holder.prodName.setText(prodlis.getProductName1());
        holder.produnite.setText(prodlis.getProductUnite1());
        holder.prodprice.setText(String.valueOf(prodlis.getProductPrice1()));
        //holder.produnite.setText(prodlist.getProductUnite());
        //holder.prodprice.setText(mprice);
        // holder.imgprod.setImageResource(prod.getPhotoUrl1());


        //Loading image from Glide library.
        // Glide.with(context).load(Integer.parseInt(prod.getPhotoUrl())).into(holder.imgprod);
    }

    @Override
    public int getItemCount() {
        int arr = 0;
        try {
            if (list.size() == 0) {
                arr = 0;
            } else {
                arr = list.size();
            }
        } catch (Exception e) {
        }
        return arr;
    }


        class MyHoder extends RecyclerView.ViewHolder {
            TextView prodName, produnite, prodprice;
            // ImageView imgprod;


            public MyHoder(View itemView) {
                super(itemView);
                prodName = (TextView) itemView.findViewById(R.id.tx_prodcuct_name);
                produnite = (TextView) itemView.findViewById(R.id.txt_unit);
                prodprice = (TextView) itemView.findViewById(R.id.txt_price);
                // imgprod =(ImageView)itemView.findViewById(R.id.rc_prd_image);


                //  name = (TextView) itemView.findViewById(R.id.vname);
                //  email= (TextView) itemView.findViewById(R.id.vemail);
                //  address= (TextView) itemView.findViewById(R.id.vaddress);

            }
        }
    }


