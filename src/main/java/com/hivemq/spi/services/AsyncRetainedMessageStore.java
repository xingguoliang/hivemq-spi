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

package com.hivemq.spi.services;

import com.google.common.util.concurrent.ListenableFuture;
import com.hivemq.spi.message.RetainedMessage;

import java.util.Set;

/**
 * The retained message store allows the management of retained messages from within plugins
 *
 * @author Lukas Brandl
 */
public interface AsyncRetainedMessageStore {

    /**
     * @return a {@link com.google.common.util.concurrent.ListenableFuture} which contains all retained messages which are currently stored on this HiveMQ instance.
     */
    ListenableFuture<Set<RetainedMessage>> getLocalRetainedMessages();

    /**
     * @return a {@link com.google.common.util.concurrent.ListenableFuture} which contains the number of all retained messages on this HiveMQ instance.
     * failing with a {@link com.hivemq.spi.services.exception.RateLimitExceededException} if the plugin service rate limit was exceeded.
     */
    ListenableFuture<Long> localSize();

    /**
     * Checks if a retained message is present in the retained message store, on this HiveMQ instance.
     *
     * @param topic the topic associated with the retained message
     * @return a {@link com.google.common.util.concurrent.ListenableFuture} which contains true if there's a message for the given topic
     * failing with a {@link com.hivemq.spi.services.exception.RateLimitExceededException} if the plugin service rate limit was exceeded.
     */
    ListenableFuture<Boolean> containsLocally(String topic);

    /**
     * @return a {@link com.google.common.util.concurrent.ListenableFuture} which contains all retained messages which are currently stored
     * failing with a {@link com.hivemq.spi.services.exception.RateLimitExceededException} if the plugin service rate limit was exceeded.
     */
    ListenableFuture<Set<RetainedMessage>> getRetainedMessages();

    /**
     * @param topic a topic
     * @return a {@link com.google.common.util.concurrent.ListenableFuture} which contains the retained message for the specific topic or <code>null</code>.
     * failing with a {@link com.hivemq.spi.services.exception.RateLimitExceededException} if the plugin service rate limit was exceeded.
     */
    ListenableFuture<RetainedMessage> getRetainedMessage(String topic);

    /**
     * Removes the retained message from given topic.
     * If there isn't any retained message on the topic yet, nothing will happen.
     *
     * @param topic from which the message should be removed
     * @return a {@link com.google.common.util.concurrent.ListenableFuture} which returns after removal
     * failing with a {@link com.hivemq.spi.services.exception.RateLimitExceededException} if the plugin service rate limit was exceeded.
     */
    ListenableFuture<Void> remove(String topic);

    /**
     * Removes all retained messages from the message store.
     *
     * @return a {@link com.google.common.util.concurrent.ListenableFuture} which returns after removal
     * failing with a {@link com.hivemq.spi.services.exception.RateLimitExceededException} if the plugin service rate limit was exceeded.
     */
    ListenableFuture<Void> clear();

    /**
     * This method adds or replaces a retained message
     *
     * @param retainedMessage which should be added or replaced
     * @return a {@link com.google.common.util.concurrent.ListenableFuture} which returns after adding or replacing
     * failing with a {@link com.hivemq.spi.services.exception.RateLimitExceededException} if the plugin service rate limit was exceeded.
     */
    ListenableFuture<Void> addOrReplace(RetainedMessage retainedMessage);

    /**
     * Checks if a retained message is present in the retained message store.
     *
     * @param topic the topic associated with the retained message
     * @return a {@link com.google.common.util.concurrent.ListenableFuture} which contains true if there's a message for the given topic
     * failing with a {@link com.hivemq.spi.services.exception.RateLimitExceededException} if the plugin service rate limit was exceeded.
     */
    ListenableFuture<Boolean> contains(String topic);

    /**
     * @return a {@link com.google.common.util.concurrent.ListenableFuture} which contains the number of all retained messages
     * failing with a {@link com.hivemq.spi.services.exception.RateLimitExceededException} if the plugin service rate limit was exceeded.
     */
    ListenableFuture<Long> size();

}
