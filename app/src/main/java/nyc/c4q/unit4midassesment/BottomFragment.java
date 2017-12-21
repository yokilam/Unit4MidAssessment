package nyc.c4q.unit4midassesment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment {
    private RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_bottom, container, false);

        rv= view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));
        createJSON();

    return view;
    }

    private void createJSON() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("books", new JSONArray()
                    .put(new JSONObject().put("title", "Northanger Abbey")
                            .put("author", "Austen, Jane")
                            .put("year", 1814))
                    .put(new JSONObject().put("title", "War and Peace")
                            .put("author", "Tolstoy, Leo")
                            .put("year", 1865))
                    .put(new JSONObject().put("title", "Anna Karenina")
                            .put("author", "Tolstoy, Leo")
                            .put("year", 1875))
                    .put(new JSONObject().put("title", "Mrs. Dalloway")
                            .put("author", "Woolf, Virginia")
                            .put("year", 1925))
                    .put(new JSONObject().put("title", "The Hours")
                            .put("author", "Cunnningham, Michael")
                            .put("year", 1999))
                    .put(new JSONObject().put("title", "Huckleberry Finn")
                            .put("author", "Twain, Mark")
                            .put("year", 1865))
                    .put(new JSONObject().put("title", "Bleak House")
                            .put("author", "Dickens, Charles")
                            .put("year", 1870))
                    .put(new JSONObject().put("title", "Tom Sawye")
                            .put("author", "Twain, Mark")
                            .put("year", 1862)));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        BookAdapter adapter= new BookAdapter(parseJSONArray(jsonObject));
        rv.setAdapter(adapter);

    }

    private List<Book> parseJSONArray(JSONObject jsonObject) {
        List<Book> bookList= new ArrayList <>();

        try {
            JSONArray jsonArray= jsonObject.getJSONArray("books");
            Log.e(TAG, jsonArray.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                Book book= new Book();
                JSONObject bookObject= (JSONObject) jsonArray.get(i);

                book.setTitle(bookObject.getString("title"));
                book.setAuthor(bookObject.getString("author"));
                book.setYear(bookObject.getInt("year"));

                Log.d(TAG, "parseJSONArray: " + book);

                bookList.add(book);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bookList;
    }
}
