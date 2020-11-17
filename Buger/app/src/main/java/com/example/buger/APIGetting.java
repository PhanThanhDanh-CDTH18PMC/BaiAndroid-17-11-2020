package com.example.buger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.ExecutionException;

public class APIGetting extends AsyncTask<String, String, String> {
        private Context m_con;
        public  APIGetting(Context con)
        {
            m_con =con;
        }
        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            //Toast.makeText(m_con, s, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(m_con, Questions.class);
            intent.putExtra("message", s);
            Activity activity = (Activity) m_con;
            activity.startActivity(intent);
        }

        @Override
        protected String doInBackground(String... level) {
            return APIQuestion.getQuestions(level[0]);
        }
}
