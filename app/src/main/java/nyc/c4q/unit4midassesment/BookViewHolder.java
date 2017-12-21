package nyc.c4q.unit4midassesment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by yokilam on 12/20/17.
 */

public class BookViewHolder extends RecyclerView.ViewHolder {

    private TextView bookTitle;
    private Context context;
    private String author;
    private int year;

    public BookViewHolder(View itemView) {
        super(itemView);

        bookTitle= itemView.findViewById(R.id.title_in_rv);
        context= itemView.getContext();
    }

    public void bind(Book book) {
        bookTitle.setText(book.getTitle());
        author= book.getAuthor();
        year= book.getYear();

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle= new Bundle();
                bundle.putString("title", bookTitle.getText().toString());
                bundle.putString("author", author);
                bundle.putInt("year", year);
                Log.e("asfjdklsajlaksfjdaskl", "onClick: " + bundle.toString());
                TopFragment TopFragment= new TopFragment();
                TopFragment.setArguments(bundle);
                FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack("BottomFragment").replace(R.id.top_fragment, TopFragment);
                fragmentTransaction.commit();
            }
        });

    }
}
