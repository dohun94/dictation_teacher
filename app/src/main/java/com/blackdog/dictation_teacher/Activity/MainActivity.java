package com.blackdog.dictation_teacher.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.blackdog.dictation_teacher.Activity.base.BaseDrawerActivity;
import com.blackdog.dictation_teacher.singleton.MyTeacherInfo;
import com.blackdog.dictation_teacher.R;
import com.blackdog.dictation_teacher.models.Quiz;
import com.blackdog.dictation_teacher.net.ApiRequester;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseDrawerActivity {
    private static String TAG = "MainActivity.java";
    private ListView listView;
    private Button button;
    private ArrayList<Quiz> quizList;
    private Quiz selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbarTitle.setText("받아쓰기 준비");

        listView = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.bt_quiz_select);
        button.setClickable(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readyToQuiz();
            }
        });

        try {
            requestQuizList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readyToQuiz() {
        if(selectedItem == null) {
            Toast.makeText(this, "문제를 선택 후 버튼을 눌러주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(getApplicationContext(), QuizReadyActivity.class);
        intent.putExtra("selectedQuiz", selectedItem);
        startActivity(intent);
    }

    public void requestQuizList() throws IOException {
        ApiRequester.getInstance().getTeachersQuizzes(MyTeacherInfo.getInstance().getTeacher().getId(), new ApiRequester.UserCallback<List<Quiz>>() {
            @Override
            public void onSuccess(List<Quiz> result) {
                if (result == null) {
                    return;
                }

                quizList = (ArrayList) result;

                ArrayAdapter<Quiz> arrayAdapter = new ArrayAdapter<Quiz>(getApplicationContext(),
                        R.layout.quiz_list_item,
                        quizList);

                listView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        int count = listView.getCheckedItemCount();
                        if (count > 0) {
                            button.setClickable(true);
                            int pos = listView.getCheckedItemPosition();
                            selectedItem = (Quiz) listView.getItemAtPosition(pos);
                            Toast.makeText(getApplicationContext(), selectedItem.getName() + "을 선택하셨습니다.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }

            @Override
            public void onFail() {

            }
        });
    }
}
