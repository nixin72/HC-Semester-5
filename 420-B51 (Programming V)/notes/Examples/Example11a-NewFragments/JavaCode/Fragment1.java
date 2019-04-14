package heritage.amcdonald.example11a_newfragments;


import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {


    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Context c = getActivity().getApplicationContext();
        View vw = inflater.inflate(R.layout.fragment_fragment1, container, false);
        final String[] colours={"Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Indigo"};
        ListView colourList = (ListView) vw.findViewById(R.id.lvColours);
        ArrayAdapter<String> arrayList = new ArrayAdapter<String>(c, android.R.layout.simple_list_item_1, colours);
        colourList.setAdapter(arrayList);
        colourList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedVal = ((TextView) view).getText().toString();
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    TextView selectedColour = (TextView) getActivity().findViewById(R.id.tvSelectedColour);
                    selectedColour.setText(getString(R.string.strSelected) + selectedVal);
                } else {
                    Intent intent = new Intent(getActivity().getApplicationContext(), ShowItemActivity.class);
                    intent.putExtra("item", selectedVal);
                    startActivity(intent);
                }
            }
        });
        return vw;
    }

}
