/*
 * Copyright 2015 dc-square GmbH
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

package com.dcsquare.hivemq.spi.util;

import com.dcsquare.hivemq.spi.annotations.ReadOnly;
import com.google.common.collect.ImmutableList;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * A utility class which allows to find out information about
 * the default SSL Engine from the JVM
 *
 * @author Christoph Schäbel
 * @author Dominik Obermaier
 */
public class DefaultSslEngineUtil {

    @ReadOnly
    public List<String> getSupportedCipherSuites() throws SslException {

        try {
            final SSLEngine engine = getDefaultSslEngine();

            return ImmutableList.copyOf(engine.getSupportedCipherSuites());

        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new SslException("Not able to get list of supported cipher suites from JVM", e);
        }
    }

    @ReadOnly
    public List<String> getSupportedProtocols() throws SslException {

        try {
            final SSLEngine engine = getDefaultSslEngine();

            return ImmutableList.copyOf(engine.getSupportedProtocols());

        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new SslException("Not able to get list of supported protocols from JVM", e);
        }
    }

    @ReadOnly
    public List<String> getEnabledProtocols() throws SslException {
        try {
            final SSLEngine engine = getDefaultSslEngine();

            return ImmutableList.copyOf(engine.getEnabledProtocols());

        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new SslException("Not able to get list of enabled protocols from JVM", e);
        }
    }

    @ReadOnly
    public List<String> getEnabledCipherSuites() throws SslException {
        try {
            final SSLEngine engine = getDefaultSslEngine();

            return ImmutableList.copyOf(engine.getEnabledProtocols());

        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            throw new SslException("Not able to get list of enabled cipher suites from JVM", e);
        }
    }

    private SSLEngine getDefaultSslEngine() throws NoSuchAlgorithmException, KeyManagementException {

        final SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, null, null);

        return context.createSSLEngine();
    }
}
