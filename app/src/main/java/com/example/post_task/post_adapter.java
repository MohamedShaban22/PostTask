package com.example.post_task;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class post_adapter extends RecyclerView.Adapter<post_adapter.PostViewHolder> {
    List<postDataClass> items ;
   public post_adapter ( List<postDataClass> item )
   {
       this.items = item ;
   }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post,parent,false);
        PostViewHolder viewholder = new PostViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
       postDataClass item = items.get(position) ;
       holder.imgProfile.setImageResource(item.imgProfile);
       holder.textProfile.setText(item.textProfile);
       holder.textProfile2.setText(item.textProfile2);
       holder.imgPost.setImageResource(item.imgPost);
       holder.likeCounter.setText(item.likeCounter+"");
       holder.likeButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               onlikeOnclickListener.onclick(item,position);
           }
       });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        CircleImageView imgProfile ;
        TextView textProfile ;
        TextView textProfile2 ;
        ImageView imgPost ;
        Button likeButton;
        TextView likeCounter;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imageprofile);
            textProfile = itemView.findViewById(R.id.textprofile) ;
            textProfile2 = itemView.findViewById(R.id.text2id);
            imgPost = itemView.findViewById(R.id.imgePost) ;
            likeButton=itemView.findViewById(R.id.like_button);
            likeCounter=itemView.findViewById(R.id.likesNumber);
        }
    }
    OnLikeOnclickListener onlikeOnclickListener;
    interface OnLikeOnclickListener{
       public void onclick(postDataClass post,int position);
   }

}

