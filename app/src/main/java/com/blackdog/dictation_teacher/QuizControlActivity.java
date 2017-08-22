package com.blackdog.dictation_teacher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blackdog.dictation_teacher.net.FcmRequester;

public class QuizControlActivity extends AppCompatActivity {
    private TextView tvQuestion;
    private TextView tvCurrentQuestionNumber;
    private Button btnDictationEnd;
    private int currentQuestionNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_control);

        tvCurrentQuestionNumber = (TextView) findViewById(R.id.text_currentQuestionNumber);
        tvQuestion = (TextView) findViewById(R.id.text_question);
        btnDictationEnd = (Button) findViewById(R.id.button_dictationEnd);

        //현재 문제 번호 보여주기
        tvCurrentQuestionNumber.setText(String.valueOf(currentQuestionNumber));
        //강제 글자 단위 줄 바꿈
        tvQuestion.setText(tvQuestion.getText().toString().replace(" ", "\u00A0"));

//        Intent intent = getIntent();
//        String quizNumber = intent.getExtras().getString("quizNumber");
//        Toast.makeText(getApplicationContext(), quizNumber, Toast.LENGTH_LONG).show();
    }

    public void previousClick(View view) {
        //끝내기 버튼 숨김
        if(btnDictationEnd.getVisibility() == View.VISIBLE) {
            btnDictationEnd.setVisibility(View.INVISIBLE);
        }

        if(currentQuestionNumber != 1) {
            FcmRequester.getInstance().requestMoveToPrevious();
            currentQuestionNumber--;
            tvCurrentQuestionNumber.setText(String.valueOf(currentQuestionNumber));
        }
    }

    public void nextClick(View view) {
        //끝내기 버튼 표시
        if(currentQuestionNumber == 9) {
            btnDictationEnd.setVisibility(View.VISIBLE);
        }

        if (currentQuestionNumber != 10) {
            FcmRequester.getInstance().requestMoveToNext();
            currentQuestionNumber++;
            tvCurrentQuestionNumber.setText(String.valueOf(currentQuestionNumber));
        }
    }

    public void readSentenceClick(View view) {

    }

    public void dictationEndClick(View view) {
        FcmRequester.getInstance().requestDictationEnd();
    }
}
