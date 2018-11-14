package br.com.emazze.android.consultacep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import br.com.emazze.android.consultacep.data.CepService;
import br.com.emazze.android.consultacep.data.RetrofitImpl;
import br.com.emazze.android.consultacep.domain.Cep;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText mSearchBoxEditText;
    private TextView mCepDisplayTextView;
    private ProgressBar mLoadingIndicator;
    private Button mBtnSearch;
    private Cep cepResponse;
    private CepService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchBoxEditText = (EditText) findViewById(R.id.tv_cep_input);
        mCepDisplayTextView = (TextView) findViewById(R.id.tv_cep_display);
        mBtnSearch = (Button) findViewById(R.id.btn_search);

        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        service = RetrofitImpl.getRetrofitInstance().create(CepService.class);
    }

    public void getCep(View view) {
        showLoading();
        Call<Cep> call = service.getCep(mSearchBoxEditText.getText().toString());

        //make request
        call.enqueue(new Callback<Cep>() {
            @Override
            public void onResponse(Call<Cep> call, Response<Cep> response) {
                cepResponse = response.body();
                if(cepResponse.getCep() == null) {
                    hideAll();
                    Toast.makeText(MainActivity.this, "CEP inválido ", Toast.LENGTH_SHORT).show();
                } else {
                    mCepDisplayTextView.setText("Cep: " + cepResponse.getCep() +
                            "\nEstado: " + cepResponse.getEstado() +
                            "\nCidade: " + cepResponse.getCidade() +
                            "\nBairro: " + cepResponse.getBairro() +
                            "\nEndereco: " + cepResponse.getEndereco()
                    );
                    showResults();
                }
            }

            @Override
            public void onFailure(Call<Cep> call, Throwable t) {
                hideAll();
                Toast.makeText(MainActivity.this, "Alguma coisa deu errodo, por favor tente novamente: ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showLoading() {
        mCepDisplayTextView.setVisibility(View.INVISIBLE);
        mLoadingIndicator.setVisibility(View.VISIBLE);
    }

    private void showResults() {
        mLoadingIndicator.setVisibility(View.INVISIBLE);
        mCepDisplayTextView.setVisibility(View.VISIBLE);
    }

    private void hideAll(){
        mLoadingIndicator.setVisibility(View.INVISIBLE);
        mCepDisplayTextView.setVisibility(View.INVISIBLE);
    }
}
