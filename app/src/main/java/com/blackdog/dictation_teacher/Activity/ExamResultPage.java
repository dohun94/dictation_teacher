package com.blackdog.dictation_teacher.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.blackdog.dictation_teacher.Activity.base.BaseActivity;
import com.blackdog.dictation_teacher.Activity.base.BaseDrawerActivity;
import com.blackdog.dictation_teacher.R;
import com.blackdog.dictation_teacher.singleton.Util;
import com.blackdog.dictation_teacher.models.Question;
import com.blackdog.dictation_teacher.models.QuestionResult;
import com.blackdog.dictation_teacher.models.QuizResult;
import com.blackdog.dictation_teacher.models.retify.PnuNlpSpeller;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class ExamResultPage extends BaseDrawerActivity {

    QuizResult quizResult;
    ArrayList<Question> questions;
    PnuNlpSpeller rectifies;
    @BindView(R.id.ivGradeOne) ImageView ivGradeOne;
    @BindView(R.id.ivGradeTwo) ImageView ivGradeTwo;
    @BindView(R.id.ivGradeThree) ImageView ivGradeThree;
    @BindView(R.id.ivGradeFour) ImageView ivGradeFour;
    @BindView(R.id.ivGradeFive) ImageView ivGradeFive;
    @BindView(R.id.ivGradeSix) ImageView ivGradeSix;
    @BindView(R.id.ivGradeSeven) ImageView ivGradeSeven;
    @BindView(R.id.ivGradeEight) ImageView ivGradeEight;
    @BindView(R.id.ivGradeNine) ImageView ivGradeNine;
    @BindView(R.id.ivGradeTen) ImageView ivGradeTen;
    @BindView(R.id.ivScore) ImageView ivScore;
    @BindView(R.id.konfettiView) KonfettiView konfettiView;

    @OnClick(R.id.btResultOne)
    void onClickBtResultOne(){
        Util.getInstance().moveActivity(this, ExamResultDetailedPage.class, quizResult,
                questions, 1);
    }
    @OnClick(R.id.btResultTwo)
    void onClickBtResultTwo(){
        Util.getInstance().moveActivity(this, ExamResultDetailedPage.class, quizResult,
                questions, 2);
    }
    @OnClick(R.id.btResultThree)
    void onClickBtResultThree(){
        Util.getInstance().moveActivity(this, ExamResultDetailedPage.class, quizResult,
                questions, 3);
    }
    @OnClick(R.id.btResultFour)
    void onClickBtResultFour(){
        Util.getInstance().moveActivity(this, ExamResultDetailedPage.class, quizResult,
                questions, 4);
    }
    @OnClick(R.id.btResultFive)
    void onClickBtResultFive(){
        Util.getInstance().moveActivity(this, ExamResultDetailedPage.class, quizResult,
                questions, 5);
    }
    @OnClick(R.id.btResultSix)
    void onClickBtResultSix(){
        Util.getInstance().moveActivity(this, ExamResultDetailedPage.class, quizResult,
                questions, 6);
    }
    @OnClick(R.id.btResultSeven)
    void onClickBtResultSeven(){
        Util.getInstance().moveActivity(this, ExamResultDetailedPage.class, quizResult,
                questions, 7);
    }
    @OnClick(R.id.btResultEight)
    void onClickBtResultEight(){
        Util.getInstance().moveActivity(this, ExamResultDetailedPage.class, quizResult,
                questions, 8);
    }
    @OnClick(R.id.btResultNine)
    void onClickBtResultNine(){
        Util.getInstance().moveActivity(this, ExamResultDetailedPage.class, quizResult,
                questions, 9);
    }
    @OnClick(R.id.btResultTen)
    void onClickBtResultTen(){
        Util.getInstance().moveActivity(this, ExamResultDetailedPage.class, quizResult,
                questions, 10);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_result_page);

        ButterKnife.bind(this);

        toolbarTitle.setText("시험 결과");

        Intent intent = getIntent();
        quizResult = (QuizResult) intent.getSerializableExtra("quizResult");
        questions = (ArrayList<Question>) quizResult.getQuiz().getQuestions();

        if(quizResult.getScore() == 0){
            ivScore.setImageResource(R.drawable.score_00);
        }
        else if(quizResult.getScore() == 10){
            ivScore.setImageResource(R.drawable.score_10);
        }
        else if(quizResult.getScore() == 20){
            ivScore.setImageResource(R.drawable.score_20);
        }
        else if(quizResult.getScore() == 30){
            ivScore.setImageResource(R.drawable.score_30);
        }
        else if(quizResult.getScore() == 40){
            ivScore.setImageResource(R.drawable.score_40);
        }
        else if(quizResult.getScore() == 50){
            ivScore.setImageResource(R.drawable.score_50);
        }
        else if(quizResult.getScore() == 60){
            ivScore.setImageResource(R.drawable.score_60);
        }
        else if(quizResult.getScore() == 70){
            ivScore.setImageResource(R.drawable.score_70);
        }
        else if(quizResult.getScore() == 80){
            ivScore.setImageResource(R.drawable.score_80);
            konfettiView.build()
                    .addColors(Color.rgb(241, 95, 95), Color.rgb(165, 102, 255), Color.rgb(250, 237, 125))
                    .setDirection(0.0, 359.0)
                    .setSpeed(3f, 5f)
                    .setFadeOutEnabled(true)
                    .setTimeToLive(1500L)
                    .addShapes(Shape.RECT)
                    .addSizes(new Size(12, 5f))
                    .setPosition(0f, Util.getInstance().getDisplayWidth(this), 0f, 50f)
                    .stream(300, 3000L);
        }
        else if(quizResult.getScore() == 90){
            ivScore.setImageResource(R.drawable.score_90);
            konfettiView.build()
                    .addColors(Color.rgb(241, 95, 95), Color.rgb(165, 102, 255), Color.rgb(250, 237, 125))
                    .setDirection(0.0, 359.0)
                    .setSpeed(3f, 5f)
                    .setFadeOutEnabled(true)
                    .setTimeToLive(1500L)
                    .addShapes(Shape.RECT)
                    .addSizes(new Size(12, 5f))
                    .setPosition(0f, Util.getInstance().getDisplayWidth(this), 0f, 50f)
                    .stream(300, 3000L);
        }
        else if(quizResult.getScore() == 100){
            ivScore.setImageResource(R.drawable.score_100);
            konfettiView.build()
                    .addColors(Color.rgb(241, 95, 95), Color.rgb(165, 102, 255), Color.rgb(250, 237, 125))
                    .setDirection(0.0, 359.0)
                    .setSpeed(3f, 5f)
                    .setFadeOutEnabled(true)
                    .setTimeToLive(1500L)
                    .addShapes(Shape.RECT)
                    .addSizes(new Size(12, 5f))
                    .setPosition(0f, Util.getInstance().getDisplayWidth(this), 0f, 50f)
                    .stream(300, 3000L);
        }

        for (QuestionResult questionResult : quizResult.getQuestionResult()) {
            if(questionResult.getQuestionNumber() == 1){
                if(questionResult.getCorrect()){
                    ivGradeOne.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeOne.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 2){
                if(questionResult.getCorrect()){
                    ivGradeTwo.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeTwo.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 3){
                if(questionResult.getCorrect()){
                    ivGradeThree.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeThree.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 4){
                if(questionResult.getCorrect()){
                    ivGradeFour.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeFour.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 5){
                if(questionResult.getCorrect()){
                    ivGradeFive.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeFive.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 6){
                if(questionResult.getCorrect()){
                    ivGradeSix.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeSix.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 7){
                if(questionResult.getCorrect()){
                    ivGradeSeven.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeSeven.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 8){
                if(questionResult.getCorrect()){
                    ivGradeEight.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeEight.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 9){
                if(questionResult.getCorrect()){
                    ivGradeNine.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeNine.setImageResource(R.drawable.ic_check_no);
                }
            }
            else if(questionResult.getQuestionNumber() == 10){
                if(questionResult.getCorrect()){
                    ivGradeTen.setImageResource(R.drawable.ic_check_ok);
                }
                else{
                    ivGradeTen.setImageResource(R.drawable.ic_check_no);
                }
            }
        }
    }
}
