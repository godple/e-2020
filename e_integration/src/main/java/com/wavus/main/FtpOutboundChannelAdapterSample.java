/*
 * Copyright 2002-2017 the original author or authors.
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

package com.wavus.main;

import java.io.File;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

/**
 *
 * @author Oleg Zhurakousky
 * @author Gunnar Hillert
 *
 */
public class FtpOutboundChannelAdapterSample {

	private static Log logger = LogFactory.getLog(FtpOutboundChannelAdapterSample.class);

	private static final File baseFolder = new File("target" + File.separator + "toSend");

	public static void main(String arg[]) throws Exception{
		ConfigurableApplicationContext ctx =
			new ClassPathXmlApplicationContext("FtpOutboundChannelAdapterSample-context.xml");

		MessageChannel ftpChannel = ctx.getBean("ftpChannel", MessageChannel.class);

		baseFolder.mkdirs();

		final File fileToSendA = new File(baseFolder, "a.txt");
		final File fileToSendB = new File(baseFolder, "b.txt");

		final InputStream inputStreamA = FtpOutboundChannelAdapterSample.class.getResourceAsStream("/test-files/a.txt");
		final InputStream inputStreamB = FtpOutboundChannelAdapterSample.class.getResourceAsStream("/test-files/b.txt");

		FileUtils.copyInputStreamToFile(inputStreamA, fileToSendA);
		FileUtils.copyInputStreamToFile(inputStreamB, fileToSendB);

		final Message<File> messageA = MessageBuilder.withPayload(fileToSendA).build();
		final Message<File> messageB = MessageBuilder.withPayload(fileToSendB).build();

		ftpChannel.send(messageA);
		ftpChannel.send(messageB);

		Thread.sleep(2000);

		logger.info("Successfully transferred file 'a.txt' and 'b.txt' to a remote FTP location.");
		ctx.close();
	}

//	@After
//	public void cleanup() {
//		FileUtils.deleteQuietly(baseFolder);
//	}

}
