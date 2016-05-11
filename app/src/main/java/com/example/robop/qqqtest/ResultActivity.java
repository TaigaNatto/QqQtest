package com.example.robop.qqqtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    int quesNum;

    int True;

    TextView SumText;

    TextView AnswerText;

    TextView NextButton;

    String Check[]={
            "正解",
            "不正解"
    };

    String Answer[]={
            "答えは「狂喜」",
            "答えは「嵐」",
            "答えは「一か月後」"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent=getIntent();
        quesNum =intent.getIntExtra("num",0);
        True=intent.getIntExtra("check",0);

        SumText=(TextView)findViewById(R.id.SumText);
        AnswerText=(TextView)findViewById(R.id.AnswerText);
        NextButton=(Button)findViewById(R.id.NextButton);

        SumText.setText(Check[True]);
        AnswerText.setText(Answer[quesNum]);
        if(quesNum >1) {
            NextButton.setText("終わる");
        }

    }

    public void next(View v)
    {
        if(quesNum >1) {
            quesNum = 0;
            Intent intent = new Intent(this, TitleActivity.class);
            startActivity(intent);
        }
        else
        {
            quesNum = quesNum + 1;
            Intent intent = new Intent(this, QuizActivity.class);

            intent.putExtra("num", quesNum);

            startActivity(intent);
        }
    }


}
