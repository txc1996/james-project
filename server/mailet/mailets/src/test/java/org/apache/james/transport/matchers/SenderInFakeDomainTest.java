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

import org.junit.Before;
import org.junit.Test;

/*
Complete this class.

Replace the commits by code. Remove comments (accept License) when you are done.
 */
public class SenderInFakeDomainTest {

    private SenderInFakeDomain testee;

    @Before
    public void setUp() {
        testee = new SenderInFakeDomain();
    }

    @Test
    public void matchShouldReturnRecipientsWhenNoMatchingDNSRecord() {
        // Question 1
        //
        // Replace the comments by the appropriate code
        //
        // We will test the SenderInFakeDomain::match method
        // By default, when no DNS entry is associated with the domain, it generally means SPAM
        // Hence we want to match this not desired e-mail
        //
        // We first need to initialise this matcher. For this we need to call the Init method. It takes as an argument a
        // MatcherConfig. One is provided by default for the testing environment (FakeMatcherConfig.builder()....build()).
        // Initialize this matcher with a condition, and a FakeMailetContext. Please also set the matcher to reject the 192.168.0.0/16
        // network.
        //
        // Then we need an email. The testing environment provides FakeMail.builder().build(); for that. Please set a recipient
        // and a sender to this email
        //
        // We can then make the SenderInFakeDomain matcher process the mail
        // As a result it should output the recipients we set to the email, as the mail do not have records, by default.
    }

    @Test
    public void matchShouldReturnNullWhenMatchingDNSRecordAndOutOfBannedDomain() {
        // Question 2
        //
        // Initialize the matcher
        // We should give a parameter to FakeMailetContext to associate a DNS record with the sender.
        // The returned record should point to 8.8.8.8
        //
        // Create a mail
        // Process it
        //
        // As a result, we should get a null.
        // (The sender has a DNS record, and is not banned)
    }

    @Test
    public void matchShouldReturnRecipientsWhenMatchingDNSRecordAndInBannedDomain() {
        // Question 3
        //
        // Initialize the matcher
        // We should give a parameter to FakeMailetContext to associate a DNS record with the sender.
        // The returned record should point to 192.168.102.15
        //
        // Create a mail
        // Process it
        //
        // As a result, we should get the list of recipients.
        // (The sender has a DNS record, and is not banned)
    }

    @Test
    public void matchShouldReturnRecipientsWhenNoSender() {
        // Question 4
        //
        // Initialize the matcher
        // We should give a parameter to FakeMailetContext to associate a DNS record with the sender.
        // The returned record should point to 192.168.102.15
        //
        // Create a mail without sender
        // Process it
        //
        // As a result, we should get the list of recipients.
        // Modify the SenderInFakeDomain code accordingly
    }
}
