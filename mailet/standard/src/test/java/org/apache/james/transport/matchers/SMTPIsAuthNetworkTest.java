/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/


package org.apache.james.transport.matchers;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;

import javax.mail.MessagingException;

import org.apache.mailet.MailAddress;
import org.apache.mailet.Matcher;
import org.apache.mailet.base.test.FakeMail;
import org.apache.mailet.base.test.FakeMatcherConfig;
import org.apache.mailet.base.test.MailUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SMTPIsAuthNetworkTest {

    public static final String MAIL_ATTRIBUTE_NAME = "org.apache.james.SMTPIsAuthNetwork";

    private FakeMail mail;
    private Matcher matcher;

    @Before
    public void setUp() throws MessagingException {
        matcher = new SMTPIsAuthNetwork();
        mail = MailUtil.createMockMail2Recipients();
        FakeMatcherConfig mci = FakeMatcherConfig.builder()
                .matcherName("SMTPIsAuthNetwork")
                .build();

        matcher.init(mci);
    }

    @Test
    public void testIsAuthNetwork() throws MessagingException {
        mail.setAttribute(MAIL_ATTRIBUTE_NAME, "true");
        Collection<MailAddress> matchedRecipients = matcher.match(mail);

        /*
        Question 1

        Rewrite these assertions with assertJ
         */
        Assert.assertNotNull(matchedRecipients);
        Assert.assertEquals(matchedRecipients.size(), mail.getRecipients()
                .size());
    }

    @Test
    public void testIsNotAuthNetwork() throws MessagingException {
        Collection<MailAddress> matchedRecipients = matcher.match(mail);

        /*
        Question 2

        Rewrite these assertions with assertJ
         */
        Assert.assertNull(matchedRecipients);
    }
}
