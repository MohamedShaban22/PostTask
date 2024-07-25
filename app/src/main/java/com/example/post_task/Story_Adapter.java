package com.example.post_task;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Story_Adapter extends RecyclerView.Adapter<Story_Adapter.View_Holder> {
   List<StoryDataClass> list ;

    public Story_Adapter(List<StoryDataClass> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story,parent,false);
        View_Holder VH = new View_Holder(view);
        return VH ;
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder holder, int position) {
     StoryDataClass item = list.get(position);
     holder.imgstory.setImageResource(item.imgageStory);
     holder.imgpro.setImageResource(item.imagprofile);
    holder.textprofile.setText(item.name);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class View_Holder extends RecyclerView.ViewHolder{
        ImageView imgstory ;
        ImageView imgpro ;
        TextView textprofile;

        public View_Holder(@NonNull View itemView) {
            super(itemView);
            imgstory = itemView.findViewById(R.id.image_Story);
            imgpro = itemView.findViewById(R.id.Image_Profile);
            textprofile = itemView.findViewById(R.id.Text_Profile);
        }
    }
}
