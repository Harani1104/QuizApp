package com.example.quizapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.quizapp.model.questions.Quiz;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class BrowseFragment extends Fragment {

    private static final String TAG = "contentValues";

    public BrowseFragment() { }

    Button filter;
    EditText filterText;
    ListView quizList;
    ArrayList<QueryDocumentSnapshot> documentArrayList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_browse, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        filter = view.findViewById(R.id.filter);
        filterText = view.findViewById(R.id.filterText);
        quizList = view.findViewById(R.id.quizList);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        ArrayList<String> list = new ArrayList<>();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, list);

        db.collection("quizes").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        list.add(document.getId());
                    }
                    quizList.setAdapter(arrayAdapter);
                } else {
                    Log.w(TAG, "Error getting documents.", task.getException());
                }
            }
        });

        quizList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clicked = (String) parent.getItemAtPosition(position);
                BrowseFragmentDirections.ActionBrowseFragmentToQuizFragment3 action = BrowseFragmentDirections.actionBrowseFragmentToQuizFragment3(clicked);
                Navigation.findNavController(view).navigate(action);
            }
        });
    }

/*
    public void onClick(View view) {

        EditText amountTv = (EditText) getView().findViewById(R.id.editTextAmount);
        int amount = Integer.parseInt(amountTv.getText().toString());
        ConfirmationAction action = SpecifyAmountFragmentDirections.confirmationAction();
        action.setAmount(amount);
        Navigation.findNavController(view).navigate(action);
    }
*/

}


