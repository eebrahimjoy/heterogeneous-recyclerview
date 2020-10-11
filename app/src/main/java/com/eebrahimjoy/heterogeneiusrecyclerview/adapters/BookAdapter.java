package com.eebrahimjoy.heterogeneiusrecyclerview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.eebrahimjoy.heterogeneiusrecyclerview.R;
import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.Chapter;
import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.Document;
import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.SubChapter;
import com.eebrahimjoy.heterogeneiusrecyclerview.models.mixcontent.Video;

import java.util.List;

public class BookAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<Object> listGroup;

    private final int TYPE_TRIP = 1;
    private final int TYPE_NEWS = 2;
    private final int TYPE_CHAPTER = 3;

    public BookAdapter(Context context, List<Object> listGroup) {
        this.listGroup = listGroup;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {

        if (listGroup.get(groupPosition) instanceof Chapter) {
            Chapter chapter = (Chapter) listGroup.get(groupPosition);
            return chapter.getSubChapters().size();
        } else {
            return 0;

        }
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        if (listGroup.get(groupPosition) instanceof Chapter) {
            Chapter chapter = (Chapter) listGroup.get(groupPosition);
            return chapter.getSubChapters().get(childPosition);
        } else {
            return 0;
        }

    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        // Chapter = (SealAdd) getGroup(groupPosition);
        if (convertView == null) {

            if (listGroup.get(groupPosition) instanceof Document) {
                Document doc = (Document) getGroup(groupPosition);
                LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.model_document_item_list, null);

                TextView docText, docSubtileText;
                docText = convertView.findViewById(R.id.documentSubtitleTV);
                docSubtileText = convertView.findViewById(R.id.documentNameTV);

                docText.setText(doc.getTitle());
                docSubtileText.setText(doc.getSubTitle());


            } else if (listGroup.get(groupPosition) instanceof Chapter) {
                Chapter chap = (Chapter) getGroup(groupPosition);
                LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.model_chapter_item_list, null);

                TextView name;
                name = convertView.findViewById(R.id.chapterNameTV);

                name.setText(chap.getName());
            } else if (listGroup.get(groupPosition) instanceof Video) {
                Video video = (Video) getGroup(groupPosition);
                LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.model_video_item_list, null);


                TextView name;
                name = convertView.findViewById(R.id.videoTitleTV);

                name.setText(video.getTitle());
            }
        }
        return convertView;
    }


    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        SubChapter subChapter = (SubChapter) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.model_chapter_sub_item_list, null);

            TextView subChapterName;
            subChapterName = convertView.findViewById(R.id.subChapterNameTV);
            subChapterName.setText(subChapter.getName());
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
