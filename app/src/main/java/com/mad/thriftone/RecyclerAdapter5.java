package com.mad.thriftone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter5 extends RecyclerView.Adapter<RecyclerAdapter5.ViewHolder5> {

    private static final String Tag="RecyclerView";
    private Context mContext;
    private ArrayList<Messages> messagesList;
    final public ListeItemclick listener;

    public RecyclerAdapter5(Context mContext, ArrayList<Messages> messagesList, ListeItemclick listener) {
        this.mContext = mContext;
        this.messagesList = messagesList;
        this.listener = listener;
    }





    @NonNull
    @Override
    public ViewHolder5 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);

        return new ViewHolder5(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter5.ViewHolder5 holder, int position) {
        //Textview
        holder.textView.setText(messagesList.get(position).getName());
//        holder.texturl.setText(messagesList.get(position).getInstaUrl());

        //ImageView:Glide Library
        Glide.with(mContext)
                .load(messagesList.get(position).getImageUrl())
                .into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }


    public class ViewHolder5 extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView textView;
        Context context;
//        Button btn1;
//        TextView texturl;


        public ViewHolder5(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.img1);
            textView=itemView.findViewById(R.id.t1);
            context = itemView.getContext();
            itemView.setOnClickListener(this);
//            btn1=itemView.findViewById(R.id.b1);
//            texturl=itemView.findViewById(R.id.instaurl);
        }

        @Override
        public void onClick(View view) {

            int position =getAbsoluteAdapterPosition();
            listener.onclicklistener(position);
        }
    }

    interface ListeItemclick
    {
        void onclicklistener(int pos);
    }

}
