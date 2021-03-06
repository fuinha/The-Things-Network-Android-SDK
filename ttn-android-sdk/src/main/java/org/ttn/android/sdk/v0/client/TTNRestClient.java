package org.ttn.android.sdk.v0.client;

import org.ttn.android.sdk.v0.api.client.ApiClientV0;
import org.ttn.android.sdk.v0.api.listeners.RestApiListener;
import org.ttn.android.sdk.v0.domain.gateway.Gateway;
import org.ttn.android.sdk.v0.domain.gateway.GatewayStatus;
import org.ttn.android.sdk.v0.domain.node.Node;
import org.ttn.android.sdk.v0.domain.packet.Packet;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/*
 * Copyright 2016 Fabio Tiriticco / Fabway
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created by fabiotiriticco on 20/11/15.
 *
 */
@Deprecated
public class TTNRestClient {

    final ApiClientV0 mApiClient = new ApiClientV0();

    @Deprecated
    public void getPackets(String nodeEui,
                           String timeSpan,
                           Integer limit,
                           Integer offset,
                           final RestApiListener<Packet> packetListener) {
        mApiClient.getPacketService().get(nodeEui, timeSpan, limit, offset, getCallback(packetListener));
    }

    @Deprecated
    public void getNodes(String timeSpan,
                         final RestApiListener<Node> nodeListener) {
        mApiClient.getNodeService().get(timeSpan, getCallback(nodeListener));
    }

    @Deprecated
    public void getGateways(String timeSpan,
                            Integer limit,
                            Integer offset,
                            final RestApiListener<Gateway> gatewayListener) {
        mApiClient.getGatewaysService().get(timeSpan, limit, offset, getCallback(gatewayListener));
    }

    @Deprecated
    public void getGatewayStatuses(String gatewayEui,
                                   String timeSpan,
                                   Integer limit,
                                   Integer offset,
                                   final RestApiListener<GatewayStatus> gsListener) {
        mApiClient.getGatewayStatusService().get(gatewayEui, timeSpan, limit, offset, getCallback(gsListener));
    }

    <T> Callback<List<T>> getCallback(final RestApiListener<T> listener) {
        return new Callback<List<T>>() {
            @Override
            public void success(List<T> list, Response response) {
                listener.onResult(list);
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onError();
            }
        };
    }

}
