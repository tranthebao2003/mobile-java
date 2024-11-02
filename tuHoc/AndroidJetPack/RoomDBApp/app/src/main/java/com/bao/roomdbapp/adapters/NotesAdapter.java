package com.bao.roomdbapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bao.roomdbapp.R;
import com.bao.roomdbapp.notedb.Note;

import java.util.List;

//nay tuong tu nhu recyclerView
public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.BeanHolder> {

    private List<Note> list;
    private Context context;
    private LayoutInflater layoutInflater;
    private OnNoteItemClick onNoteItemClick;


//    Constructor:
    public NotesAdapter(List<Note> list, Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.list = list;
        this.context = context;
        this.onNoteItemClick = (OnNoteItemClick) context;
    }

    @NonNull
    @Override
    public BeanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        convert từ layout xml sang View để thao túng dữ liệu trong View
        View view = layoutInflater.inflate(R.layout.note_list_item, parent, false);
        return new BeanHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeanHolder holder, int position) {
//        thao túng những thành phần đã được mapping ở BeanHolder
//        list.get(position).getTitle(): lấy ra cái thuoc tinh title cua object tại vị
//        trí position sau đó dùng setText để show lên man hinh
        holder.textViewTitle.setText(list.get(position).getTitle());
//        tuong tu như trên nhung thay vi lay thuoc tinh title thi gio lay
//        thuoc tinh content
        holder.textViewContent.setText(list.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //    Bean holder class (ViewHolder)
    public class BeanHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textViewContent;
        TextView textViewTitle;

        public BeanHolder(@NonNull View itemView) {
            super(itemView);
//            set event onClick cho từng itemView
            itemView.setOnClickListener(this);
//            mapping những thành phần có trong itemView
            textViewContent= itemView.findViewById(R.id.item_text);
            textViewTitle = itemView.findViewById(R.id.tv_title);
        }

//        hàm này implement lại từ hàm onClick bên trong View.OnClickListener
//        hàm này được kích hoạt khi user click vào itemView
        @Override
        public void onClick(View view) {
//            implement 1 method từ 1 instance của interface OnNoteItemClick
//            getAdapterPosition() trả về vị trí của item trong
//            RecyclerView.Adapter tại thời điểm gọi. Vị trí này là chỉ số
//            của item trong danh sách dữ liệu mà Adapter đang quản lý.

//            trog TH item ko còn hợp lệ do dữ liệu thay đổi  có thể trả về
//            RecyclerView.NO_POSITION (-1) để cho biết vị trí không hợp lệ.
            onNoteItemClick.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteItemClick{
        void onNoteClick(int position);
    }


}
