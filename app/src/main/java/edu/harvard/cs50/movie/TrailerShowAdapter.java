package edu.harvard.cs50.movie;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrailerShowAdapter extends RecyclerView.Adapter<TrailerShowAdapter.TrailerShowViewHolder>{

    private String url;
    private RequestQueue requestQueue;
    private List<String> trailers = new ArrayList<>();
    private List<String> trailers_name = new ArrayList<>();
    public Context context;
    TrailerShowAdapter(Context context, String id)
    {
        url = MovieAdapter.base_url_movies_reviews + id + MovieAdapter.part_of_the_path_movies + MovieAdapter.API_KEY + "&language=en-US";
        Log.d("url_CS50", url);
        Log.d("url_CS50", id);
        requestQueue = Volley.newRequestQueue(context);
        loadTrailers(url);
        this.context = context;
    }
    private void loadTrailers(String url)
    {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray results = response.getJSONArray("results");
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject result = results.getJSONObject(i);
                        String key = result.getString("key");
                        String name = result.getString("name");
                        trailers.add(key);
                        trailers_name.add(name);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }
    @NonNull
    @Override
    public TrailerShowAdapter.TrailerShowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trailer_show, parent, false);
        return new TrailerShowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailerShowAdapter.TrailerShowViewHolder holder, int position) {
        Log.d("names", trailers_name.get(position));
        Log.d("keys", trailers.get(position));
        holder.nameOfEachMovie.setText(trailers_name.get(position));
        holder.linearLayout.setTag(trailers.get(position));
    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }

    public class TrailerShowViewHolder extends RecyclerView.ViewHolder{
        private Button button;
        private LinearLayout linearLayout;
        private TextView nameOfEachMovie;
        public TrailerShowViewHolder(@NonNull final View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.trailer_show_play_button);
            linearLayout = itemView.findViewById(R.id.linear_layout_trailer_show);
            nameOfEachMovie = itemView.findViewById(R.id.name_of_each_view);
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String key = (String) linearLayout.getTag();
                    Uri webpage = Uri.parse(MovieAdapter.youtube_base_url + key);
                    Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    if (intent.resolveActivity(itemView.getContext().getPackageManager()) != null) {
                        itemView.getContext().startActivity(intent);
                    }
                }
            });
        }
    }
}
