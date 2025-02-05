/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.architecture.blueprints.todoapp.util;

import static com.google.common.base.Preconditions.checkNotNull;

import android.support.annotation.NonNull;
import android.support.test.espresso.IdlingResource;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * An simple counter implementation of {@link IdlingResource} that determines idleness by
 * maintaining an internal counter. When the counter is 0 - it is considered to be idle, when it is
 * non-zero it is not idle. This is very similar to the way a {@link java.util.concurrent.Semaphore}
 * behaves.
 * <p>
 * This class can then be used to wrap up operations that while in progress should block tests from
 * accessing the UI.
 */
public final class SimpleCountingIdlingResource implements IdlingResource {

  // written from main thread, read from any thread.
  private volatile ResourceCallback resourceCallback;
  private final String resourceName;
  private final AtomicInteger counter = new AtomicInteger(0);

  /**
   * Creates a SimpleCountingIdlingResource
   *
   * @param resourceName the resource name this resource should report to Espresso.
   */
  public SimpleCountingIdlingResource(@NonNull String resourceName) {
    resourceName = checkNotNull(resourceName);
  }

  @Override
  public void registerIdleTransitionCallback(ResourceCallback resourceCallback) {
    this.resourceCallback = resourceCallback;
  }
  
  @Override
  public String getName() {
    return resourceName;
  }

  @Override
  public boolean getIsIdle() {
    return counter.get() == 0;
  }

  /**
   * Increments the count of in-flight transactions to the resource being monitored.
   */
  public void increment() {
    counter.getAndIncrement();
  }

  /**
   * Decrements the count of in-flight transactions to the resource being monitored.
   *
   * If this operation results in the counter falling below 0 - an exception is raised.
   *
   * @throws IllegalStateException if the counter is below 0.
   */
  public void decrement() {
    int counterVal = counter.decrementAndGet();
    if (counterVal == 0) {
      // we've gone from non-zero to zero. That means we're idle now! Tell espresso.
      if (null != resourceCallback) {
        resourceCallback.onTransitionToIdle();
      }
    }

    if (counterVal < 0) {
      throw new IllegalArgumentException("Counter has been corrupted!");
    }
  }
}
