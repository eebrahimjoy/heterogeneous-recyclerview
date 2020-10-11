package com.eebrahimjoy.heterogeneiusrecyclerview.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eebrahimjoy.heterogeneiusrecyclerview.R;
import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.Chapter;
import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.Video;
import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.Document;

import java.util.List;

public class MixAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> mData;
    private final int TYPE_DOCUMENT = 1;
    private final int TYPE_VIDEO = 2;
    private final int TYPE_CHAPTER = 3;

    public MixAdapter(List<Object> itemList) {
        this.mData = itemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case TYPE_DOCUMENT:
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_document_item_list, viewGroup, false);
                viewHolder = new DocumentViewHolder(view);
                break;
            case TYPE_CHAPTER:
                View view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_chapter_item_list, viewGroup, false);
                viewHolder = new ChapterViewHolder(view2);
                break;
            case TYPE_VIDEO:
                View view3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_video_item_list, viewGroup, false);
                viewHolder = new VideoViewHolder(view3);
                break;

            default:
                viewHolder = null;
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);
        switch (viewType) {
            case TYPE_CHAPTER:
                Chapter chapter = (Chapter) mData.get(position);
                ((ChapterViewHolder) holder).setAddValueInUI(chapter);
                break;
            case TYPE_VIDEO:
                Video video = (Video) mData.get(position);
                ((VideoViewHolder) holder).setNewsValueInUI(video);
                break;
            case TYPE_DOCUMENT:
                Document document = (Document) mData.get(position);
                ((DocumentViewHolder) holder).setTripValueInUI(document);
                break;
            default:
                break;
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class DocumentViewHolder extends RecyclerView.ViewHolder {

        private TextView id_document_text_view;
        private TextView id_document_subtitle_text_view;

        public DocumentViewHolder(@NonNull View itemView) {
            super(itemView);
            id_document_text_view = itemView.findViewById(R.id.documentNameTV);
            id_document_subtitle_text_view = itemView.findViewById(R.id.documentSubtitleTV);
        }

        private void setTripValueInUI(Document t) {
            id_document_text_view.setText(String.valueOf(t.getTitle()));
            id_document_subtitle_text_view.setText(String.valueOf(t.getSubTitle()));
        }
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder {

        private TextView videoTitleTV;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoTitleTV = itemView.findViewById(R.id.videoTitleTV);
        }

        private void setNewsValueInUI(Video video) {
            videoTitleTV.setText(String.valueOf(video.getTitle()));
        }
    }

    static class ChapterViewHolder extends RecyclerView.ViewHolder {

        private TextView chapterNameTV;
        public ChapterViewHolder(@NonNull View itemView) {
            super(itemView);
            chapterNameTV = itemView.findViewById(R.id.chapterNameTV);
        }

        private void setAddValueInUI(Chapter chapter) {
            chapterNameTV.setText(chapter.getName());
        }

    }

    public int getItemViewType(int position) {
        if (mData.get(position) instanceof Document) {
            return TYPE_DOCUMENT;
        } else if (mData.get(position) instanceof Video) {
            return TYPE_VIDEO;
        } else if (mData.get(position) instanceof Chapter) {
            return TYPE_CHAPTER;
        }
        return -1;
    }
}
