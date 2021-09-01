/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example.spring.events.a.fundamentals.quickstart;

import example.spring.events.a.fundamentals.quickstart.OrderManagement.OrderCompleted;
import example.spring.events.a.fundamentals.quickstart.OrderManagement.SomeOtherEvent;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author Oliver Drotbohm
 */
class OrderListeners {

	@Slf4j
	@Component
	static class ImplementingListener implements ApplicationListener<OrderCompleted> {

		/*
		 * (non-Javadoc)
		 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
		 */
		@Override
		public void onApplicationEvent(OrderCompleted event) {
			log.info("Received {}.", event);
		}
	}

	@Slf4j
	@Component
	static class AnnotatedListener {

		@EventListener
		void on(OrderCompleted event) {
			log.info("Received {}.", event);
		}

		@EventListener
		void on(SomeOtherEvent event) {
			log.info("Received {}.", event);
		}
	}
}
