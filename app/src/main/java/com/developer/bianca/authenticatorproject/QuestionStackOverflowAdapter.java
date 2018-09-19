package com.developer.bianca.authenticatorproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class QuestionStackOverflowAdapter extends RecyclerView.Adapter{

    List<QuestionStackOverflowCard> listCards;

    public QuestionStackOverflowAdapter(List<QuestionStackOverflowCard> listCards){ this.listCards = listCards; }

    //Pega o modelo do card e implementa o método questionViewHolder.
    //Esse método faz o set de cada elemento do card, toda vez que tiver um novo dado a ser apresentado.
    //Por exemplo: nesse card eu mostro: pergunta, link e tag. A cada item da lista que tiver uma pergunta, link e tag, terei um novo card.
    //Por isso a necessidade de se ter uma classe para criar um novo objeto para cada item da lista.
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_stack_overflow, parent, false);
        return new QuestionViewHolder(card);
    }

    //faz o set do texto de cada item da lista de perguntas do stackOverflow e mostra em cada elemento do card.
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        QuestionStackOverflowCard questionCard = listCards.get(position);
        QuestionViewHolder questionViewHolder = (QuestionViewHolder) holder;

        questionViewHolder.question.setText(questionCard.getTitle());
        questionViewHolder.linkQuestion.setText(questionCard.getLink());
        questionViewHolder.tagQuestion.setText(questionCard.getTag());
    }

    @Override
    public int getItemCount() {
        return listCards.size();
    }

    public void addItemInCard(QuestionStackOverflowCard objCard){
        listCards.add(0, objCard);
        notifyDataSetChanged();
    }

    //Esse ViewHolder pega todos os id's dos elementos que estão sendo usados no card.
    //Utilizando o itemView para ter acesso a view e usar o método findViewById ou qualquer outro método referente a view.
    //Pois o fragmento não interpreta de forma direta o que é uma view, e o adapter faz esse papel de interpretar.
    public class QuestionViewHolder extends RecyclerView.ViewHolder{

        public TextView question;
        public TextView linkQuestion;
        public TextView tagQuestion;

        public QuestionViewHolder(View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.question_field);
            linkQuestion = itemView.findViewById(R.id.link_question_field);
            tagQuestion = itemView.findViewById(R.id.tag_field);
        }
    }
}
