package com.alghubari.myfv.panel;
import com.alghubari.myfv.modle.Product;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.alghubari.myfv.R;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import com.alghubari.myfv.data.RecyclerAdapter;

public class ProductPanelActivity extends AppCompatActivity {
   // List<ListProduct> list,list2;

    List<Product>list4;

   RecyclerView recycler3;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseStorage storage;
    private StorageReference storageReference;
    private FirebaseUser user;
    private ChildEventListener mChildEventListener;
    private EditText editTextProdcutName, editTextProductUnit, editTextProductPrice;
    private ImageButton btnadd, btndelete, mPhotoPickerButton;
    public static final int RC_SIGN_IN = 1;
    private static final int RC_PHOTO_PICKER = 2;
    private Uri filePath;
    private String mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        initFirebase();

        recycler3=findViewById(R.id.recyclerb);

      //  list2.add(new Product("bana", "kelo", 60, R.mipmap.ic_launcher));
        reriveProduct();







      /*  view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // RecyclerAdapter recyclerAdapter=new  RecyclerAdapter(list,ProductPanelActivity.this);




            }
        });
        */


    }
    private void reriveProduct() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference productref = database.getReference().child("products");
        productref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list4 = new ArrayList<Product>();
                // StringBuffer stringbuffer = new StringBuffer();
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){
                      int i=0;

                    Product product = dataSnapshot1.getValue(Product.class);

                   Product listdata = new Product();


                    String name=product.getProductName1();
                    String unite=product.getProductUnite1();
                   int price=product.getProductPrice1();
                     list4.add(new Product(name,unite,price));
                   /*
                    listdata.setProductName1(name);
                    listdata.setProductUnite1(unite);
                    listdata.setProductPrice1(price);
                   // Log.e("DATA" ,""+ listdata);
                    list4.add(listdata);
                    Log.e("DATA" ,""+ list4.get(i));
                    Log.v("DATA" ,""+ list4.get(i));
                    i=i+1;
                    Toast.makeText(ProductPanelActivity.this,""+name,Toast.LENGTH_LONG).show();
                    System.out.println(listdata);
*/

                }


                RecyclerAdapter adapter = new RecyclerAdapter(ProductPanelActivity.this,list4);
                RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(ProductPanelActivity.this);
                recycler3.setLayoutManager(layoutmanager);
                recycler3.setItemAnimator( new DefaultItemAnimator());
                recycler3.setAdapter(adapter);

                }












            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    private void initFirebase() {
        //Khoi tao thanh phan de dang nhap, dang ky
        mAuth = FirebaseAuth.getInstance();
        //authUtils = new AuthUtils();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //  Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    // User is signed in
                    // FirebaseUser user = user.getUid();
                    // Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());


                    // Log.d(TAG, "onAuthStateChanged:signed_out");
                }

            }
        };

    }
        }



