package com.example.robop.qqqtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {
    //現在の問題番号
    int quesnum=0;//持っていくよ！
    //選択した回答
    int ChAns=0;
    //正解値
    int AnsChe[]={2,3,1};
    //真偽
    int True=0;//持っていくよ！

    //クイズの問題文
    String Quiz[]={
            "時速200kmで飛んでくる点Pをたかしくんは受け止めました。その時のしおりさんの気持ちはどれですか",
            "弟のまさるくんが時速4kmで出発した5分後に兄のごろうくんが時速300kmで歩き始めました。その日の天気はどれでしょうか",
            "幸運になれると信じてさとみさんは500万の壺をネットで買いました。さとみさんが全てを悟るのはいつでしょうか"
    };

    String Which[]={
            "感動","歓喜","狂喜","喜びの極致",
            "晴れ","曇り","雨","嵐",
            "一週間後","一か月後","一年後","彼女は純粋だった"
    };


    //quiztextの場所
    TextView QuizText;

    //button1～4の場所
    TextView button1;
    TextView button2;
    TextView button3;
    TextView button4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Intent intent=getIntent();
        quesnum=intent.getIntExtra("num",0);
        QuizText=(TextView)findViewById(R.id.quiztext);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button4=(Button)findViewById(R.id.button4);
        QuizText.setText(Quiz[quesnum]);
        StringWhichText();
        True=0;
    }


    public void one(View v)
    {
        ChAns=0;
        AnswerCheck();
        Trans();
    }

    public void two(View v)
    {
        ChAns=1;
        AnswerCheck();
        Trans();
    }

    public void three(View v)
    {
        ChAns=2;
        AnswerCheck();
        Trans();
    }

    public void four(View v)
    {
        ChAns=3;
        AnswerCheck();
        Trans();
    }



    public void Trans()
    {
        Intent intent =new Intent(this,ResultActivity.class);

        intent.putExtra("num",quesnum);
        intent.putExtra("check",True);

        startActivity(intent);
    }

    public void AnswerCheck()
    {
        if(ChAns==AnsChe[quesnum])
        {
            True=0;
        }
        else
        {
            True=1;
        }
    }

    public void StringWhichText()
    {


        button1.setText(Which[quesnum*4]);

        button2.setText(Which[quesnum*4+1]);

        button3.setText(Which[quesnum*4+2]);

        button4.setText(Which[quesnum*4+3]);
    }

}
