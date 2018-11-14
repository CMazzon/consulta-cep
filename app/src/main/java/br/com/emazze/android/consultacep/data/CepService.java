package br.com.emazze.android.consultacep.data;

import br.com.emazze.android.consultacep.domain.Cep;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CepService {

    @GET("busca-cep/api/cep/{cep}.json")
    Call<Cep> getCep(@Path("cep") String cep);
}
