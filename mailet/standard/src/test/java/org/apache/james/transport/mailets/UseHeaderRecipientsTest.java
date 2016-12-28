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

package org.apache.james.transport.mailets;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.mailet.base.MailAddressFixture;
import org.apache.mailet.base.test.FakeMailetConfig;
import org.apache.mailet.base.test.MimeMessageBuilder;
import org.junit.Before;
import org.junit.Test;

public class UseHeaderRecipientsTest {

    private UseHeaderRecipients testee;

    @Before
    public void setUp() throws Exception {
        testee = new UseHeaderRecipients();
        testee.init(FakeMailetConfig.builder().build());
    }

    @Test
    public void serviceShouldSetMimeMessageRecipients() throws Exception {
        /*
        Question 1:

        Using FakeMail, create a mail with :
         - Two recipients from MailAddressFixture
         - A mimeMessage instantiated with MimeMessage Builder. It has Two Other recipients as To Header field.

         Process it with the mailet

         Ensure that the mail has the recipient specified in the message
         */
    }

    @Test
    public void serviceShouldSetToCcAndBccSpecifiedInTheMimeMessage() throws Exception {
        /*
        Question 2:

        Using FakeMail, create a mail with :
         - a recipient from MailAddressFixture
         - A mimeMessage instantiated with MimeMessage Builder. It has A cc, a bcc, and a to recipient.

         Process it with the mailet

         Ensure that the mail has the recipient specified in the message (to, cc, and bcc)
         */
    }

    @Test
    public void serviceShouldSetEmptyRecipientWhenNoRecipientsInTheMimeMessage() throws Exception {
        /*
        Question 3:

        Using FakeMail, create a mail with :
         - a recipient from MailAddressFixture
         - A mimeMessage instantiated with MimeMessage Builder. It has no cc bcc nor to recipients

         Process it with the mailet

         Ensure that the mail has no recipient
         */
    }

    @Test
    public void serviceShouldThrowOnInvalidMailAddress() throws Exception {
        /*
        Question 4:

        What happen if "abcd" is used as a mail address ?
         */
    }

    @Test
    public void serviceShouldSupportAddressList() throws Exception {
        /*
        Question 5:

        What happen when I get a header like this ?

        To: a@domain.com, b@domain.com
         */
    }

    @Test
    public void serviceShouldSupportMailboxes() throws Exception {
        /*
        Question 5:

        What happen when I get a header like this ?

        To: B Name <b@domain.com>
         */
    }
}
