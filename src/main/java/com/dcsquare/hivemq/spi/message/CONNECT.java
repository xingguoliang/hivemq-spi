/*
 * Copyright 2013 dc-square GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dcsquare.hivemq.spi.message;

/**
 * @author Dominik Obermaier
 * @since 1.4
 */
public class CONNECT extends Message {

    private boolean cleanSession;

    private boolean will;

    private QoS willQos;

    private boolean willRetain;

    private boolean passwordRequired;

    private boolean usernameRequired;

    private int keepAliveTimer;

    private Byte protocolVersion;

    private String clientIdentifier;

    private String willTopic;

    private String willMessage;

    private String username;

    private String password;

    private boolean bridge;

    public boolean isCleanSession() {
        return cleanSession;
    }

    public void setCleanSession(final boolean cleanSession) {
        this.cleanSession = cleanSession;
    }

    public boolean isWill() {
        return will;
    }

    public void setWill(final boolean will) {
        this.will = will;
    }

    public QoS getWillQos() {
        return willQos;
    }

    public void setWillQos(final QoS willQos) {
        this.willQos = willQos;
    }

    public boolean isWillRetain() {
        return willRetain;
    }

    public void setWillRetain(final boolean willRetain) {
        this.willRetain = willRetain;
    }

    public boolean isPasswordRequired() {
        return passwordRequired;
    }

    public void setPasswordRequired(final boolean passwordRequired) {
        this.passwordRequired = passwordRequired;
    }

    public boolean isUsernameRequired() {
        return usernameRequired;
    }

    public void setUsernameRequired(final boolean usernameRequired) {
        this.usernameRequired = usernameRequired;
    }

    public int getKeepAliveTimer() {
        return keepAliveTimer;
    }

    public void setKeepAliveTimer(final int keepAliveTimer) {
        this.keepAliveTimer = keepAliveTimer;
    }

    public String getClientIdentifier() {
        return clientIdentifier;
    }

    public void setClientIdentifier(final String clientIdentifier) {
        this.clientIdentifier = clientIdentifier;
    }

    public String getWillTopic() {
        return willTopic;
    }

    public void setWillTopic(final String willTopic) {
        this.willTopic = willTopic;
    }

    public String getWillMessage() {
        return willMessage;
    }

    public void setWillMessage(final String willMessage) {
        this.willMessage = willMessage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Byte getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(final byte protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public boolean isBridge() {
        return bridge;
    }

    public void setBridge(boolean bridge) {
        this.bridge = bridge;
    }
}
