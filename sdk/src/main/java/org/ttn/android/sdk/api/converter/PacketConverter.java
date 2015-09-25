package org.ttn.android.sdk.api.converter;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.json.JSONException;
import org.json.JSONObject;
import org.ttn.android.sdk.api.converter.base.JsonConverter;
import org.ttn.android.sdk.api.converter.base.JsonErrorMessage;
import org.ttn.android.sdk.domain.packet.Packet;

/*
 * Copyright 2015 The Things Network
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created by fabiotiriticco on 25/09/15.
 */
public class PacketConverter extends JsonConverter {

    public static final String JSON_KEY_DATA_RAW = "data_raw";
    public static final String JSON_KEY_DATA = "data";
    public static final String JSON_KEY_DATA_PLAIN = "data_plain";
    public static final String JSON_KEY_TIME = "time";
    public static final String JSON_KEY_GATEWAY_EUI = "gateway_eui";
    public static final String JSON_KEY_NODE_EUI = "node_eui";
    public static final String JSON_KEY_DATA_JSON = "data_json";

    @Override
    public Object fromJson(JSONObject jsonObj) throws JSONException {
        Packet.Builder builder = new Packet.Builder();

        if (jsonObj.has(JSON_KEY_DATA)) {
            builder.setData(jsonObj.getString(JSON_KEY_DATA));
        }

        if (jsonObj.has(JSON_KEY_DATA_JSON)) {
            builder.setDataJson(jsonObj.getString(JSON_KEY_DATA_JSON));
        }

        if (jsonObj.has(JSON_KEY_DATA_PLAIN)) {
            builder.setDataPlain(jsonObj.getString(JSON_KEY_DATA_PLAIN));
        }

        if (jsonObj.has(JSON_KEY_DATA_RAW)) {
            builder.setDataRaw(JSON_KEY_DATA_RAW);
        }

        if (jsonObj.has(JSON_KEY_GATEWAY_EUI)) {
            builder.setGatewayEui(jsonObj.getString(JSON_KEY_GATEWAY_EUI));
        }

        if (jsonObj.has(JSON_KEY_NODE_EUI)) {
            builder.setNodeEui(jsonObj.getString(JSON_KEY_NODE_EUI));
        }

        if (jsonObj.has(JSON_KEY_TIME)) {
            String dateStr = jsonObj.getString(JSON_KEY_TIME);
            DateTime time = ISODateTimeFormat.dateTime().parseDateTime(dateStr);
            builder.setTime(time);
        }

        return builder.build();
    }

    @Override
    public JSONObject toJson(Object object) throws JSONException {
        if (!(object instanceof Packet)) {
            throw new JSONException(JsonErrorMessage.unexpectedObject(Packet.class, object));
        }

        Packet packet = (Packet) object;
        final JSONObject jsonObj = new JSONObject();

        // TODO

        return jsonObj;
    }
}