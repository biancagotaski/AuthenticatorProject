package com.developer.bianca.authenticatorproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class QuestionStackOverflowFragment extends Fragment {

    //Se for usar o firebase, aqui é instanciada a classe para depois utilizar e chamar a referência.

    RecyclerView questionList;

    public QuestionStackOverflowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //pega a view com o nome do arquivo xml que foi criada na pasta layout.
        //não necessariamente esse fragmento foi criado junto com esse layout que está sendo chamado,
        //pois podem apenas ser associados por código posteriormente.
        View rootView = inflater.inflate(R.layout.list_question_fragment, container, false);
        questionList = rootView.findViewById(R.id.register_list);

        List<QuestionStackOverflowCard> questionSOCardList = new LinkedList<>();
        //instancio o adapter nesse onCreate para setar a lista quesionSOCard no adapter
        final QuestionStackOverflowAdapter adapter = new QuestionStackOverflowAdapter(questionSOCardList);
        questionList.setAdapter(adapter);
        questionList.setLayoutManager(new LinearLayoutManager(getContext()));

        //TODO: aqui eu implemento a forma de como irei salvar os dados. Se é pelo firebase, sharedPreferences ou SQLite.
//        Bundle args = getArguments();
//        if (args != null) {
//             fbEndpoint = args.getString(Constants.REGISTERS_ENDPOINT_KEY);
//            dbReference = FirebaseDatabase.getInstance().getReference(fbEndpoint);
//
//            // Lê dados do firebase
//            dbReference.addChildEventListener(new ChildEventListener() {
//                @Override
//                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                    RegisterCard registerCard = dataSnapshot.getValue(RegisterCard.class);
//                    RegisterAdapter adapter = (RegisterAdapter) registerList.getAdapter();
//                    adapter.addItem(registerCard);
//                }
//
//                @Override
//                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//                }
//
//                @Override
//                public void onChildRemoved(DataSnapshot dataSnapshot) {
//                }
//
//                @Override
//                public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//                }
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//
//                }
//            });
//
//            dbReference.addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    if(!dataSnapshot.exists()){
//                        Toast.makeText(getContext(), "Lista vazia", Toast.LENGTH_LONG).show();
//                    }
//                }
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//
//                }
//            });
//        }

//        public static QuestionStackOverflowFragment newInstance(String fbEndpoint){
//            Bundle args = new Bundle();
//            QuestionStackOverflowFragment fragment = new QuestionStackOverflowFragment();
//            args.putString(Constants.REGISTERS_ENDPOINT_KEY, fbEndpoint);
//            fragment.setArguments(args);
//
//            return fragment;
//        }

        return rootView;
    }

}
