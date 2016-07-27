package mobile.unisinos.br.jsonvimeo;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import mobile.unisinos.br.jsonvimeo.db.DBVideo;
import mobile.unisinos.br.jsonvimeo.pojo.UserVideo;

public class MainActivity extends AppCompatActivity {

    private EditText edUsuario;
    private DBVideo dbVideo;
    private TextView lbRetornoDireto;
    private TextView lbTituloDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lbRetornoDireto = (TextView) findViewById(R.id.lbRetornoDireto);
        lbTituloDados = (TextView) findViewById(R.id.lbTituloDados);

        edUsuario = (EditText) findViewById(R.id.edUsuario);
        //temporario p/ teste
        edUsuario.setText("salazarfilm");

        dbVideo = new DBVideo(this);

        Button bt = (Button) findViewById(R.id.btPesquisar);
        bt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //https://vimeo.com/api/v2/salazarfilm/videos.json
                        final String url = "https://vimeo.com/api/v2/" + edUsuario.getText() + "/videos.json";
                        new TarefaAssincrona().execute(url);
                    }
                }
        );
    }

    private void processaJson(String mensagem) throws JSONException {
        JSONArray jsonarray = new JSONArray(mensagem);
        int qtNovos = 0;
        int qtAtualizados = 0;
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jsonVideo = jsonarray.getJSONObject(i);
            UserVideo uv = new UserVideo();
            uv.set_id(jsonVideo.getLong("id"));
            uv.setDescription(jsonVideo.getString("description"));
            uv.setDuration(jsonVideo.getLong("duration"));
            uv.setHeight(jsonVideo.getLong("height"));
            uv.setWidth(jsonVideo.getLong("width"));
            uv.setStatsNumberOfComments(jsonVideo.getLong("stats_number_of_comments"));
            uv.setStatsNumberOfLikes(jsonVideo.getLong("stats_number_of_likes"));
            uv.setStatsNumberOfPlays(jsonVideo.getLong("stats_number_of_plays"));
            uv.setTags(jsonVideo.getString("tags"));
            uv.setTitle(jsonVideo.getString("title"));
            uv.setUploadDate(jsonVideo.getString("upload_date"));
            uv.setUrl(jsonVideo.getString("url"));
            uv.setUserId(jsonVideo.getLong("user_id"));
            uv.setUserName(jsonVideo.getString("user_name"));
            uv.setUserUrl(jsonVideo.getString("user_url"));

            if (dbVideo.existeVideo(uv.get_id())) {
                Log.i("VIDEO_EXISTENTE", uv.getTitle()+" será atualizado no banco.");
                dbVideo.atualizarVideo(uv);
                qtAtualizados++;
            } else {
                dbVideo.inserirVideo(uv);
                Log.i("VIDEO_NOVO", uv.getTitle());
                qtNovos++;
            }

            lbTituloDados.setText(String.format("Dados atualizados: %d novos, %d atualizados.", qtNovos, qtAtualizados));
        }

    }


    private class TarefaAssincrona extends AsyncTask<String, Void, Void> {
        private String content;
        private String error = null;
        private ProgressDialog dialog = new ProgressDialog(MainActivity.this);

        protected void onPreExecute() {
            dialog.setMessage("Buscando...");
            dialog.show();
        }

        protected Void doInBackground(String... urls) {
            BufferedReader reader = null;
            HttpURLConnection urlConnection = null;
            try {

                URL url = new URL(urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                reader = new BufferedReader(new InputStreamReader(in));

                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                content = sb.toString();
            } catch (Exception ex) {
                error = ex.getMessage();
            } finally {
                try {
                    reader.close();
                } catch (Exception ex) {
                }
                try {
                    urlConnection.disconnect();
                } catch (Exception ex) {
                }
            }
            return null;
        }

        protected void onPostExecute(Void unused) {
            dialog.dismiss();
            lbTituloDados.setText("Dados atualizados");
            if (error != null) {
                lbRetornoDireto.setText("Retorno : " + error);
            } else {
                lbRetornoDireto.setText("Retorno : " +content);
                Log.i("Tag",content);

                try {
                    processaJson(content);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
