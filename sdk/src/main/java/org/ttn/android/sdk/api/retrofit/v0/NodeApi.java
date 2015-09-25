package org.ttn.android.sdk.api.retrofit.v0;

import org.ttn.android.sdk.domain.CollectionContainer;
import org.ttn.android.sdk.domain.packet.Packet;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface NodeApi {
    String NODES_API_BASE_URL = "/v0/nodes";

    @GET(NODES_API_BASE_URL)
    void get(@Query("time_span") String timeSpan,
             Callback<CollectionContainer<Packet>> callback);

    @GET(NODES_API_BASE_URL + "/{node_eui}")
    void get(@Path("node_eui") String nodeEui,
             @Query("time_span") String timeSpan,
             @Query("limit") int limit,
             @Query("offset") int offset,
             Callback<Packet> callback);
}