package com.blackdog.dictation_teacher.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blackdog.dictation_teacher.Adapter.RecordAdapter;
import com.blackdog.dictation_teacher.R;
import com.blackdog.dictation_teacher.models.QuizHistory;
import com.blackdog.dictation_teacher.models.QuizResult;
import com.blackdog.dictation_teacher.models.RecordModel;
import com.blackdog.dictation_teacher.models.Student;
import com.blackdog.dictation_teacher.models.Teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

//탭 뷰에서 회차별
public class RecordFragment extends Fragment {

    private RecordAdapter recordAdapter;
//    private ArrayList<QuizResult> recordModels;
//    private ArrayList<Teacher> teachers;
//    private ArrayList<QuizHistory> quizHistories;

    private Student student;

    @BindView(R.id.rvRecord)
    RecyclerView rvRecord;
    @BindView(R.id.tvRecord)
    TextView tvRecord;
    LinearLayout layoutNoResult;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_record, container, false);
        ButterKnife.bind(this, view);

        layoutNoResult = (LinearLayout)view.findViewById(R.id.layout_no_result);

//        getServerData();
//        initModels();
        setupView();

        return view;
    }

    private void setupView() {
        rvRecord.setHasFixedSize(true);
        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvRecord.setLayoutManager(MyLayoutManager);

        student = ((RecordManagerActivity) getActivity()).getStudent();

        if (student == null) {
            layoutNoResult.setVisibility(View.VISIBLE);
            return;
        }

        if (student.getQuizResults().size() == 0) {
            layoutNoResult.setVisibility(View.VISIBLE);
        }
        recordAdapter = new RecordAdapter(getActivity(), student.getQuizResults());
        rvRecord.setAdapter(recordAdapter);
        recordAdapter.notifyDataSetChanged();

    }

//    private void getServerData(){
//        ApiRequester apiRequester = new ApiRequester();
//        try {
//            apiRequester.getStudentsTeachers(Student.getInstance().getId(), new ApiRequester.UserCallback<List<Teacher>>() {
//                @Override
//                public void onSuccess(List<Teacher> result) {
//                    teachers = (ArrayList<Teacher>) result;
//                }
//
//                @Override
//                public void onFail() {
//                    Log.e("RecordFragment", "Server Error");
//                }
//            });
//            if(teachers != null){
//                for(Teacher teacher : teachers){
//                    apiRequester.getTeachersQuizHistories(teacher.getLoginId(), new ApiRequester.UserCallback<List<QuizHistory>>() {
//
//                        @Override
//                        public void onSuccess(List<QuizHistory> result) {
//                            quizHistories = (ArrayList<QuizHistory>) result;
//                        }
//
//                        @Override
//                        public void onFail() {
//                            Log.e("RecordFragment", "Server Error");
//                        }
//                    });
//                }
//            }
//            else{
//                tvRecord.setText("등록된 쌘쌔가 없습니다.");
//            }
//
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//            Log.e("RecordFragment0", e.getMessage().toString());
//        }
//    }

//    private void initModels() {
//        recordModels.clear();
//        if(quizHistories != null){
//            for(QuizHistory quizHistory : quizHistories){
//                RecordModel recordModel = new RecordModel();
//                for(QuizResult quizResult :quizHistory.getQuizResults()){
//                    if(Student.getInstance().getName().equals(quizResult.getStudentName())){
//                        recordModel.setRank(quizResult.getLank());
//                        recordModel.setScore(quizResult.getScore());
//                        if(recordModel.getScore() >= 80){
//                            recordModel.setComment("참 잘했어요!");
//                        }
//                        else if(recordModel.getScore() >= 50){
//                            recordModel.setComment("조금 더 힘내세요!");
//                        }
//                        else{
//                            recordModel.setComment("많이 분발해야겠어요!");
//                        }
//                        break;
//                    }
//                }
//                recordModel.setDate(quizHistory.getDate());
//                recordModels.add(recordModel);
//            }
//        }
//        else{
//            tvRecord.setText("시험 결과가 없습니다!.");
//        }
//
//    }

}
