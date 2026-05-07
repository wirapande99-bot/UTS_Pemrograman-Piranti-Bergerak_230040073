package com.example.uts_pemrogramanpirantibergerak_230040073;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.SiswaViewHolder> {

    private List<Siswa> siswaList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onDeleteClick(Siswa siswa);
        void onItemClick(Siswa siswa);
    }

    public SiswaAdapter(List<Siswa> siswaList, OnItemClickListener listener) {
        this.siswaList = siswaList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_siswa, parent, false);
        return new SiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SiswaViewHolder holder, int position) {
        Siswa siswa = siswaList.get(position);
        holder.tvNama.setText(siswa.getNama());
        holder.tvNim.setText(siswa.getNim());
        holder.tvJurusan.setText(siswa.getJurusan());
        holder.tvNilai.setText(String.valueOf(siswa.getNilai()));

        holder.btnDelete.setOnClickListener(v -> listener.onDeleteClick(siswa));
        holder.itemView.setOnClickListener(v -> listener.onItemClick(siswa));
    }

    @Override
    public int getItemCount() {
        return siswaList.size();
    }

    public void updateList(List<Siswa> newList) {
        this.siswaList = newList;
        notifyDataSetChanged();
    }

    public static class SiswaViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvNim, tvJurusan, tvNilai;
        ImageButton btnDelete;

        public SiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvJurusan = itemView.findViewById(R.id.tvJurusan);
            tvNilai = itemView.findViewById(R.id.tvNilai);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}
