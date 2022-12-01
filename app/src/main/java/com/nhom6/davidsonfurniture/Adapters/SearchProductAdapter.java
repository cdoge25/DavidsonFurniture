package com.nhom6.davidsonfurniture.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nhom6.davidsonfurniture.Models.Product;
import com.nhom6.davidsonfurniture.R;
//import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;

public class SearchProductAdapter extends RecyclerView.Adapter<SearchProductAdapter.ViewHolder> implements Filterable {

    Context context;
    ArrayList<Product> products, productList;
    SelectedProduct selectedProduct;

    public SearchProductAdapter(Context context, int item_product, ArrayList<Product> products, SelectedProduct selectedProduct) {
        this.context = context;
        this.products = products;
        this.selectedProduct = selectedProduct;
        productList = new ArrayList<>(products);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        //Picasso.get().load(products.get(position).getProductThumb()).into(holder.imvThumb);
        holder.txtName.setText(products.get(position).getProductName());
        holder.txtPrice.setText(String.format("%.0f",products.get(position).getProductPrice()) + "đ");
        holder.txtRate.setText(String.valueOf(products.get(position).getProductRate()));
        holder.txtCategory. setText(products.get(position).getProductCategory());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imvThumb;
        TextView txtName, txtPrice, txtRate,txtCategory;
        LinearLayout layoutProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imvThumb= itemView.findViewById(R.id.imvThumb);
            txtName= itemView.findViewById(R.id.txtName);
            txtPrice= itemView.findViewById(R.id.txtPrice);
            txtRate= itemView.findViewById(R.id.txtRate);
            txtCategory=itemView.findViewById(R.id.txtProductCategory);
            layoutProduct= itemView.findViewById(R.id.layoutProduct);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectedProduct.selectedProduct(products.get(getAdapterPosition()));
                }
            });
        }
    }

    @Override
    public Filter getFilter() {
        return productFilter;
    }
    private Filter productFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<Product> filteredList = new ArrayList<>();
            if(charSequence == null || charSequence.length() == 0){
                filteredList.addAll(productList);
            }else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (Product p : productList){
                    if(p.getProductName().toLowerCase().contains(filterPattern)){
                        filteredList.add(p);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            products.clear();
            products.addAll((Collection<? extends Product>) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public interface SelectedProduct{
        void selectedProduct(Product product);
    }
}
