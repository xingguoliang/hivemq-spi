/*
 * Copyright 2014 dc-square GmbH
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

package com.hivemq.spi.callback.exception;

import com.hivemq.spi.message.ReturnCode;
import com.hivemq.spi.message.CONNACK;
import com.hivemq.spi.message.CONNECT;

/**
 * An exception which can be used to refuse a {@link CONNECT}
 * MQTT message and send (+ disconnect) the client with a {@link CONNACK}
 * including a specific {@link ReturnCode}
 *
 * @author Dominik Obermaier
 * @since 1.4
 */
public class RefusedConnectionException extends Exception {

    private ReturnCode returnCode;

    public RefusedConnectionException(final ReturnCode returnCode) {
        super();
        this.returnCode = returnCode;
    }

    public RefusedConnectionException(final String message, final ReturnCode returnCode) {
        super(message);
        this.returnCode = returnCode;
    }

    public RefusedConnectionException(final String message, final ReturnCode returnCode, final Throwable cause) {
        super(message, cause);
        this.returnCode = returnCode;
    }

    public RefusedConnectionException(final ReturnCode returnCode, final Throwable cause) {
        super(cause);
        this.returnCode = returnCode;
    }

    public ReturnCode getReturnCode() {
        return returnCode;
    }

    @Override
    public String toString() {
        return "RefusedConnectionException{" +
                "returnCode=" + returnCode +
                '}';
    }
}
