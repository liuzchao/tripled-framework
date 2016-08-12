/*
 * Copyright 2016 TripleD framework.
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
package eu.tripledframework.eventbus.internal.infrastructure.unitofwork;

import eu.tripledframework.eventbus.EventPublisher;
import eu.tripledframework.eventbus.internal.domain.UnitOfWork;

import java.util.ArrayList;
import java.util.List;

public class TestUnitOfWork implements UnitOfWork {

  public List<Object> delayedEvents;
  public boolean isRollbackCalled = false;
  public boolean isCommitCalled = false;

  public TestUnitOfWork() {
    delayedEvents = new ArrayList<>();
  }

  @Override
  public void commit(EventPublisher eventPublisher) {
    isCommitCalled = true;
  }

  @Override
  public void rollback() {
    isRollbackCalled = true;
  }

  @Override
  public boolean isRunning() {
    return true;
  }

  @Override
  public void addData(String key, Object value) {
    // no-op for now.
  }

  @Override
  public Object getData(String key) {
    return null;
  }

  @Override
  public void scheduleEvent(Object event) {
    delayedEvents.add(event);
  }
}
