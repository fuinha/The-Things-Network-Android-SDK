package org.ttn.android.sdk.api.converter;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.json.JSONException;
import org.json.JSONObject;
import org.ttn.android.sdk.api.converter.base.JsonConverter;
import org.ttn.android.sdk.api.converter.base.JsonErrorMessage;
import org.ttn.android.sdk.domain.gateway.GatewayStatus;
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
 * Created by fabiotiriticco on 9/10/15.
 */
public class GatewayStatusConverter extends JsonConverter {

    public static final String JSON_KEY_LATITUDE = "latitude";
    public static final String JSON_KEY_ALTITUDE = "altitude";
    public static final String JSON_KEY_LONGITUDE = "longitude";
    public static final String JSON_KEY_TIME = "time";
    public static final String JSON_KEY_EUI = "eui";

    @Override
    public Object fromJson(JSONObject jsonObj) throws JSONException {
        GatewayStatus.Builder builder = new GatewayStatus.Builder();

        if (jsonObj.has(JSON_KEY_EUI)) {
            builder.setNodeEui(jsonObj.getString(JSON_KEY_EUI));
        }

        if (jsonObj.has(JSON_KEY_LATITUDE)) {
            builder.setLatitude(jsonObj.getDouble(JSON_KEY_LATITUDE));
        }

        if (jsonObj.has(JSON_KEY_LONGITUDE)) {
            builder.setLongitude(jsonObj.getDouble(JSON_KEY_LONGITUDE));
        }

        if (jsonObj.has(JSON_KEY_ALTITUDE)) {
            builder.setAltitude(jsonObj.getDouble(JSON_KEY_ALTITUDE));
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
        if (!(object instanceof GatewayStatus)) {
            throw new JSONException(JsonErrorMessage.unexpectedObject(GatewayStatus.class, object));
        }

        GatewayStatus gatewayStatus = (GatewayStatus) object;
        final JSONObject jsonObj = new JSONObject();

        // TODO

        return jsonObj;
    }
}
