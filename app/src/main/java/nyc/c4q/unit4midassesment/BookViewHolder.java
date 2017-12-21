package nyc.c4q.unit4midassesment;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by yokilam on 12/20/17.
 */

public class BookViewHolder extends RecyclerView.ViewHolder {

    private TextView bookTitle;
    private Context context;

    public BookViewHolder(View itemView) {
        super(itemView);

        bookTitle= itemView.findViewById(R.id.title_in_rv);
        context= itemView.getContext();
    }

    public void bind(Book book) {
        bookTitle.setText(book.getTitle());

    }
}
