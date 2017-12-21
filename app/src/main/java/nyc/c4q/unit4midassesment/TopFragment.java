package nyc.c4q.unit4midassesment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {
    private TextView title;
    private TextView author;
    private TextView year;

    private String getTitle;
    private String getAuthor;
    private int getYear;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_top, container, false);
        title= view.findViewById(R.id.title);
        author= view.findViewById(R.id.author);
        year= view.findViewById(R.id.year);

        Bundle bundle= getArguments();
        getTitle= bundle.getString("title");
        getAuthor= bundle.getString("author");
        getYear= bundle.getInt("year");

        title.setText(getTitle);
        author.setText(getAuthor);
        year.setText(String.valueOf(getYear));

        return view;
    }

}
