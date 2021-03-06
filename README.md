The Things Network - Android SDK
================================

Android SDK to interact with the API of [The Things Network](http://thethingsnetwork.org) servers.

Sample App
----------

The sample app serves as an example. You can try it on your device:

<a href="https://play.google.com/store/apps/details?id=org.ttn.android.sample&utm_source=global_co&utm_medium=prtnr&utm_content=Mar2515&utm_campaign=PartBadge&pcampaignid=MKT-AC-global-none-all-co-pr-py-PartBadges-Oct1515-1"><img width="200" alt="Get it on Google Play" src="https://play.google.com/intl/en_us/badges/images/apps/en-play-badge.png" /></a>

![Sample app screenshot](https://github.com/ticofab/The-Things-Network-Android-SDK/blob/master/img/sample-screenshot.png)

Note that you won't be able to receive packets if you build the app yourself, as you need the right credentials.

Download SDK
------------

Grab via gradle:

```groovy
compile 'io.ticofab:ttn-android-sdk:2.0.0'
```

Usage
-----

Please refer to the sample app. These are the main steps:

1) Get a TTNMqttClient instance:

```java
// instantiate a new client passing host, app EUI and access key, device to track ("+" for all devices)
TTNMqttClient mTTNMqttClient = new TTNMqttClient(STAGING_HOST, APP_EUI, ACCESS_KEY, "+");
```

2) Subscribe to updates using a listener implementation of the MqttApiListener interface.

```java
public interface MqttApiListener {
    void onPacket(Packet packet);

    void onError(Throwable throwable);

    void onConnected();

    void onDisconnected();
}
```

```java
mTTNMqttClient.listen(new MqttApiListener() {
  ...
});
```

That's basically it! Remember to unsubscribe when done.

```java
mTTNMqttClient.disconnect();
```

Deprecation
-----------

The SDK also offers capabilities to use the API v0, which had REST endpoint next to the MQTT one. Those API are considered deprecated and will eventually be discontinued.

Dependencies
------------

SDK:

* [Retrofit](http://square.github.io/retrofit/) [only for the deprecated API v0]
* [MQTT-Client](https://github.com/fusesource/mqtt-client)
* [Joda DateTime for Android](https://github.com/dlew/joda-time-android)

SAMPLE:

* [ButterKnife](http://jakewharton.github.io/butterknife/)
* [Material Progress Bar](https://github.com/lsjwzh/MaterialLoadingProgressBar)
* [Spark Chart Line](https://github.com/robinhood/spark)

License
--------

    Copyright 2016 Fabio Tiriticco / Fabway

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

