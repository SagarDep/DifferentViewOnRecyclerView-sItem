package com.androidbie.differenctviewonrecyclerviewitem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androidbie.differenctviewonrecyclerviewitem.models.ItemModel;

import java.util.List;

/**
 * Created by putuguna on 05/01/17.
 */

public class ViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<ItemModel> mListItemModel;
    private Context mContext;

    public ViewAdapter(List<ItemModel> mListItemModel, Context mContext) {
        this.mListItemModel = mListItemModel;
        this.mContext = mContext;
    }

    // override this method manually
    @Override
    public int getItemViewType(int position) {
        ItemModel item = mListItemModel.get(position);
        if(item.getIndex()==0){
            return 0;
        }else if(item.getIndex()==1){
            return 1;
        }else if(item.getIndex()==2){
            return 2;
        }
        return super.getItemViewType(position);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case 0:
                View viewInputUserPassword = inflater.inflate(R.layout.view_input_username_and_password, parent, false);
                holder = new InputUsernameAndPasswordViewHolder(viewInputUserPassword);
                break;
            case 1:
                View viewLoading = inflater.inflate(R.layout.view_please_wait, parent, false);
                holder = new LoadingPleaseWaitViewHolder(viewLoading);
                break;
            case 2:
                View viewDetail = inflater.inflate(R.layout.view_detail_usernamepassword, parent, false);
                holder = new DetailListPasswordAndUsernameViewHolder(viewDetail);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ItemModel itemModel = mListItemModel.get(position);

        if(holder instanceof InputUsernameAndPasswordViewHolder){
            ((InputUsernameAndPasswordViewHolder) holder).tvDesc.setText("Description = "+itemModel.getDescription());
            ((InputUsernameAndPasswordViewHolder) holder).tvName.setText("Name = "+itemModel.getName());
            ((InputUsernameAndPasswordViewHolder) holder).tvCity.setText("City = " + itemModel.getCity());
            // do onClick on LinearLayout to see the position of recyclerview item
            ((InputUsernameAndPasswordViewHolder) holder).llInputUsernamePassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "RecyclerView's item position = " + position, Toast.LENGTH_SHORT).show();
                }
            });
        }else if(holder instanceof LoadingPleaseWaitViewHolder){
            ((LoadingPleaseWaitViewHolder) holder).tvDesc.setText("Description = "+itemModel.getDescription());
            ((LoadingPleaseWaitViewHolder) holder).tvName.setText("Name = "+itemModel.getName());
            ((LoadingPleaseWaitViewHolder) holder).tvCity.setText(itemModel.getCity());
            // do onClick on LinearLayout to see the position of recyclerview item
            ((LoadingPleaseWaitViewHolder) holder).llLoading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "RecyclerView's item position = " + position, Toast.LENGTH_SHORT).show();
                }
            });
        }else if(holder instanceof DetailListPasswordAndUsernameViewHolder){
            ((DetailListPasswordAndUsernameViewHolder) holder).tvDesc.setText("Description = "+itemModel.getDescription());
            ((DetailListPasswordAndUsernameViewHolder) holder).tvName.setText("Name = "+itemModel.getName());
            ((DetailListPasswordAndUsernameViewHolder) holder).tvCity.setText("City = " + itemModel.getCity());
            // do onClick on LinearLayout to see the position of recyclerview item
            ((DetailListPasswordAndUsernameViewHolder) holder).llDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "RecyclerView's item position = " + position, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mListItemModel.size();
    }


    /**
     * first, create Input ViewHolder of username and password
     */
    public class InputUsernameAndPasswordViewHolder extends RecyclerView.ViewHolder{

        public EditText etUsername;
        public EditText etPassword;
        public Button btnAddToList;
        public Button btnDone;
        public TextView tvDesc;
        public TextView tvName;
        public TextView tvCity;
        public LinearLayout llInputUsernamePassword;

        public InputUsernameAndPasswordViewHolder(View itemView) {
            super(itemView);

            etPassword = (EditText) itemView.findViewById(R.id.edit_text_password);
            etUsername = (EditText) itemView.findViewById(R.id.edit_text_username);
            btnAddToList = (Button) itemView.findViewById(R.id.button_add_to_list);
            btnDone = (Button) itemView.findViewById(R.id.button_done);
            tvDesc = (TextView) itemView.findViewById(R.id.textview_description_input_usernamepassword);
            tvName = (TextView) itemView.findViewById(R.id.textview_name_input_usernamepassword);
            tvCity = (TextView) itemView.findViewById(R.id.textview_city_input_usernamepassword);
            llInputUsernamePassword = (LinearLayout) itemView.findViewById(R.id.ll_input_username_password);
        }
    }

    /**
     * Second, create loading view holder to display loading view after finish input data
     */
    public class LoadingPleaseWaitViewHolder extends RecyclerView.ViewHolder{

        public LinearLayout llLoading;
        public TextView tvDesc;
        public TextView tvName;
        public TextView tvCity;

        public LoadingPleaseWaitViewHolder(View itemView) {
            super(itemView);

            llLoading = (LinearLayout) itemView.findViewById(R.id.ll_progressbar);
            tvDesc = (TextView) itemView.findViewById(R.id.textview_description_please_wait);
            tvName = (TextView) itemView.findViewById(R.id.textview_name_please_wait);
            tvCity = (TextView) itemView.findViewById(R.id.textview_city_please_wait);
        }
    }

    /**
     * Third, create List ViewHolder to display list of username and password
     */
    public class DetailListPasswordAndUsernameViewHolder extends RecyclerView.ViewHolder{

        public TextView tvUsername;
        public TextView tvPassword;
        public TextView tvDesc;
        public TextView tvName;
        public TextView tvCity;
        public LinearLayout llDetail;

        public DetailListPasswordAndUsernameViewHolder(View itemView) {
            super(itemView);

            tvUsername = (TextView) itemView.findViewById(R.id.textview_username);
            tvPassword = (TextView) itemView.findViewById(R.id.textview_password);
            tvDesc = (TextView) itemView.findViewById(R.id.textview_description_detail);
            tvName = (TextView) itemView.findViewById(R.id.textview_name_detail);
            tvCity = (TextView) itemView.findViewById(R.id.textview_city_detail);
            llDetail = (LinearLayout) itemView.findViewById(R.id.ll_detail_view);
        }
    }
}
