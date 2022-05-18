package ke.co.dinerinn.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import ke.co.dinerinn.R;


public class Menufrag extends Fragment {

    //public static final String TAG = "Menufrag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState){
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_menufrag, container, false);
        Button button  = (Button) view.findViewById(R.id.buttonmenufrag);

        //set on-click listener here
       button.setOnClickListener(v -> goTofragorder());

        return view;
    }

    private void goTofragorder() {
        try {
            NavHostFragment.findNavController(this).navigate(R.id.action_menufrag_to_orderfrag);
        } catch (Exception e) {
            Log.e("Menufrag","Go to order",e);
        }
    }

}


